package com.bugsnag.android;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bugsnag.android.NativeInterface;
import java.io.File;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Observable;
import java.util.UUID;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

class SessionTracker extends Observable implements Application.ActivityLifecycleCallbacks {
    private static final int DEFAULT_TIMEOUT_MS = 30000;
    private static final String KEY_LIFECYCLE_CALLBACK = "ActivityLifecycle";
    final Client client;
    final Configuration configuration;
    private final AtomicReference<Session> currentSession;
    private final Semaphore flushingRequest;
    private final Collection<String> foregroundActivities;
    private final ForegroundDetector foregroundDetector;
    private final AtomicLong lastEnteredForegroundMs;
    private final AtomicLong lastExitedForegroundMs;
    final SessionStore sessionStore;
    private final long timeoutMs;

    SessionTracker(Configuration configuration2, Client client2, SessionStore sessionStore2) {
        this(configuration2, client2, 30000, sessionStore2);
    }

    SessionTracker(Configuration configuration2, Client client2, long j, SessionStore sessionStore2) {
        this.foregroundActivities = new ConcurrentLinkedQueue();
        this.lastExitedForegroundMs = new AtomicLong(0);
        this.lastEnteredForegroundMs = new AtomicLong(0);
        this.currentSession = new AtomicReference<>();
        this.flushingRequest = new Semaphore(1);
        this.configuration = configuration2;
        this.client = client2;
        this.timeoutMs = j;
        this.sessionStore = sessionStore2;
        this.foregroundDetector = new ForegroundDetector(client2.appContext);
        notifyNdkInForeground();
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    @Nullable
    public Session startNewSession(@NonNull Date date, @Nullable User user, boolean z) {
        if (this.configuration.getSessionEndpoint() == null) {
            Logger.warn("The session tracking endpoint has not been set. Session tracking is disabled");
            return null;
        }
        Session session = new Session(UUID.randomUUID().toString(), date, user, z);
        this.currentSession.set(session);
        trackSessionIfNeeded(session);
        return session;
    }

    /* access modifiers changed from: package-private */
    public Session startSession(boolean z) {
        return startNewSession(new Date(), this.client.getUser(), z);
    }

    /* access modifiers changed from: package-private */
    public void stopSession() {
        Session session = this.currentSession.get();
        if (session != null) {
            session.isStopped.set(true);
            setChanged();
            notifyObservers(new NativeInterface.Message(NativeInterface.MessageType.STOP_SESSION, (Object) null));
        }
    }

    /* access modifiers changed from: package-private */
    public boolean resumeSession() {
        Session session = this.currentSession.get();
        boolean z = false;
        if (session == null) {
            session = startSession(false);
        } else {
            z = session.isStopped.compareAndSet(true, false);
        }
        if (session != null) {
            notifySessionStartObserver(session);
        }
        return z;
    }

    private void notifySessionStartObserver(Session session) {
        setChanged();
        String iso8601 = DateUtils.toIso8601(session.getStartedAt());
        notifyObservers(new NativeInterface.Message(NativeInterface.MessageType.START_SESSION, Arrays.asList(new Serializable[]{session.getId(), iso8601, Integer.valueOf(session.getHandledCount()), Integer.valueOf(session.getUnhandledCount())})));
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public Session registerExistingSession(@Nullable Date date, @Nullable String str, @Nullable User user, int i, int i2) {
        Session session = null;
        if (date == null || str == null) {
            setChanged();
            notifyObservers(new NativeInterface.Message(NativeInterface.MessageType.STOP_SESSION, (Object) null));
        } else {
            session = new Session(str, date, user, i, i2);
            notifySessionStartObserver(session);
        }
        this.currentSession.set(session);
        return session;
    }

    private void trackSessionIfNeeded(final Session session) {
        if (!this.configuration.shouldNotifyForReleaseStage(getReleaseStage())) {
            return;
        }
        if ((this.configuration.getAutoCaptureSessions() || !session.isAutoCaptured()) && session.isTracked().compareAndSet(false, true)) {
            notifySessionStartObserver(session);
            try {
                this.configuration.getSessionEndpoint();
                Async.run(new Runnable() {
                    public void run() {
                        SessionTracker.this.flushStoredSessions();
                        SessionTrackingPayload sessionTrackingPayload = new SessionTrackingPayload(session, (List<File>) null, SessionTracker.this.client.appData, SessionTracker.this.client.deviceData);
                        try {
                            for (BeforeSendSession beforeSendSession : SessionTracker.this.configuration.getSessionCallbacks()) {
                                beforeSendSession.beforeSendSession(sessionTrackingPayload);
                            }
                            SessionTracker.this.configuration.getDelivery().deliver(sessionTrackingPayload, SessionTracker.this.configuration);
                        } catch (DeliveryFailureException e) {
                            Logger.warn("Storing session payload for future delivery", e);
                            SessionTracker.this.sessionStore.write(session);
                        } catch (Exception e2) {
                            Logger.warn("Dropping invalid session tracking payload", e2);
                        }
                    }
                });
            } catch (RejectedExecutionException unused) {
                this.sessionStore.write(session);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void onAutoCaptureEnabled() {
        Session session = this.currentSession.get();
        if (session != null && !this.foregroundActivities.isEmpty()) {
            trackSessionIfNeeded(session);
        }
    }

    private String getReleaseStage() {
        return MapUtils.getStringFromMap("releaseStage", this.client.appData.getAppDataSummary());
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public Session getCurrentSession() {
        Session session = this.currentSession.get();
        if (session == null || session.isStopped.get()) {
            return null;
        }
        return session;
    }

    /* access modifiers changed from: package-private */
    public Session incrementUnhandledAndCopy() {
        Session currentSession2 = getCurrentSession();
        if (currentSession2 != null) {
            return currentSession2.incrementUnhandledAndCopy();
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public Session incrementHandledAndCopy() {
        Session currentSession2 = getCurrentSession();
        if (currentSession2 != null) {
            return currentSession2.incrementHandledAndCopy();
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public void flushStoredSessions() {
        List<File> findStoredFiles;
        if (this.flushingRequest.tryAcquire(1)) {
            try {
                findStoredFiles = this.sessionStore.findStoredFiles();
                if (!findStoredFiles.isEmpty()) {
                    this.configuration.getDelivery().deliver(new SessionTrackingPayload((Session) null, findStoredFiles, this.client.appData, this.client.deviceData), this.configuration);
                    this.sessionStore.deleteStoredFiles(findStoredFiles);
                }
            } catch (DeliveryFailureException e) {
                this.sessionStore.cancelQueuedFiles(findStoredFiles);
                Logger.warn("Leaving session payload for future delivery", e);
            } catch (Exception e2) {
                Logger.warn("Deleting invalid session tracking payload", e2);
                this.sessionStore.deleteStoredFiles(findStoredFiles);
            } catch (Throwable th) {
                this.flushingRequest.release(1);
                throw th;
            }
            this.flushingRequest.release(1);
        }
    }

    public void onActivityCreated(@NonNull Activity activity, Bundle bundle) {
        leaveLifecycleBreadcrumb(getActivityName(activity), "onCreate()");
    }

    public void onActivityStarted(@NonNull Activity activity) {
        String activityName = getActivityName(activity);
        leaveLifecycleBreadcrumb(activityName, "onStart()");
        updateForegroundTracker(activityName, true, System.currentTimeMillis());
    }

    public void onActivityResumed(@NonNull Activity activity) {
        leaveLifecycleBreadcrumb(getActivityName(activity), "onResume()");
    }

    public void onActivityPaused(@NonNull Activity activity) {
        leaveLifecycleBreadcrumb(getActivityName(activity), "onPause()");
    }

    public void onActivityStopped(@NonNull Activity activity) {
        String activityName = getActivityName(activity);
        leaveLifecycleBreadcrumb(activityName, "onStop()");
        updateForegroundTracker(activityName, false, System.currentTimeMillis());
    }

    public void onActivitySaveInstanceState(@NonNull Activity activity, Bundle bundle) {
        leaveLifecycleBreadcrumb(getActivityName(activity), "onSaveInstanceState()");
    }

    public void onActivityDestroyed(@NonNull Activity activity) {
        leaveLifecycleBreadcrumb(getActivityName(activity), "onDestroy()");
    }

    private String getActivityName(@NonNull Activity activity) {
        return activity.getClass().getSimpleName();
    }

    /* access modifiers changed from: package-private */
    public void leaveLifecycleBreadcrumb(String str, String str2) {
        leaveBreadcrumb(str, str2);
    }

    private void leaveBreadcrumb(String str, String str2) {
        if (this.configuration.isAutomaticallyCollectingBreadcrumbs()) {
            HashMap hashMap = new HashMap();
            hashMap.put(KEY_LIFECYCLE_CALLBACK, str2);
            try {
                this.client.leaveBreadcrumb(str, BreadcrumbType.NAVIGATION, hashMap);
            } catch (Exception e) {
                Logger.warn("Failed to leave breadcrumb in SessionTracker: " + e.getMessage());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void startFirstSession(Activity activity) {
        if (this.currentSession.get() == null) {
            long currentTimeMillis = System.currentTimeMillis();
            this.lastEnteredForegroundMs.set(currentTimeMillis);
            startNewSession(new Date(currentTimeMillis), this.client.getUser(), true);
            this.foregroundActivities.add(getActivityName(activity));
        }
    }

    /* access modifiers changed from: package-private */
    public void updateForegroundTracker(String str, boolean z, long j) {
        if (z) {
            long j2 = j - this.lastExitedForegroundMs.get();
            if (this.foregroundActivities.isEmpty()) {
                this.lastEnteredForegroundMs.set(j);
                if (j2 >= this.timeoutMs && this.configuration.getAutoCaptureSessions()) {
                    startNewSession(new Date(j), this.client.getUser(), true);
                }
            }
            this.foregroundActivities.add(str);
        } else {
            this.foregroundActivities.remove(str);
            if (this.foregroundActivities.isEmpty()) {
                this.lastExitedForegroundMs.set(j);
            }
        }
        setChanged();
        notifyNdkInForeground();
    }

    private void notifyNdkInForeground() {
        Boolean isInForeground = isInForeground();
        if (isInForeground != null) {
            notifyObservers(new NativeInterface.Message(NativeInterface.MessageType.UPDATE_IN_FOREGROUND, Arrays.asList(new Serializable[]{isInForeground, getContextActivity()})));
        }
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public Boolean isInForeground() {
        return this.foregroundDetector.isInForeground();
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public Long getDurationInForegroundMs(long j) {
        long j2 = this.lastEnteredForegroundMs.get();
        Boolean isInForeground = isInForeground();
        if (isInForeground == null) {
            return null;
        }
        long j3 = (!isInForeground.booleanValue() || j2 == 0) ? 0 : j - j2;
        if (j3 <= 0) {
            j3 = 0;
        }
        return Long.valueOf(j3);
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public String getContextActivity() {
        if (this.foregroundActivities.isEmpty()) {
            return null;
        }
        int size = this.foregroundActivities.size();
        return ((String[]) this.foregroundActivities.toArray(new String[size]))[size - 1];
    }
}
