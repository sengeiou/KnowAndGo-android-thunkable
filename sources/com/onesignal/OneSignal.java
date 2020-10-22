package com.onesignal;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.amplitude.api.Constants;
import com.onesignal.LocationController;
import com.onesignal.OSNotification;
import com.onesignal.OSNotificationAction;
import com.onesignal.OSSessionManager;
import com.onesignal.OneSignalDbContract;
import com.onesignal.OneSignalRemoteParams;
import com.onesignal.OneSignalRestClient;
import com.onesignal.PushRegistrator;
import com.onesignal.UserStateSynchronizer;
import com.onesignal.influence.OSTrackerFactory;
import com.onesignal.influence.model.OSInfluence;
import com.onesignal.outcomes.OSOutcomeEventsFactory;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class OneSignal {
    static final long MIN_ON_SESSION_TIME_MILLIS = 30000;
    public static final String VERSION = "031501";
    @Nullable
    private static AdvertisingIdentifierProvider adIdProvider;
    private static OneSignalAPIClient apiClient = new OneSignalRestClientWrapper();
    static Context appContext;
    @NonNull
    private static AppEntryAction appEntryState = AppEntryAction.APP_CLOSE;
    @Nullable
    static String appId;
    private static OSEmailSubscriptionState currentEmailSubscriptionState;
    private static OSPermissionState currentPermissionState;
    private static OSSubscriptionState currentSubscriptionState;
    static DelayedConsentInitializationParameters delayedInitParams;
    private static String emailId = null;
    private static EmailUpdateHandler emailLogoutHandler;
    private static OSObservable<OSEmailSubscriptionObserver, OSEmailSubscriptionStateChanges> emailSubscriptionStateChangesObserver;
    private static EmailUpdateHandler emailUpdateHandler;
    private static boolean foreground;
    /* access modifiers changed from: private */
    public static boolean getTagsCall;
    private static IAPUpdateJob iapUpdateJob;
    private static IdsAvailableHandler idsAvailableHandler;
    private static boolean initDone;
    static OSEmailSubscriptionState lastEmailSubscriptionState;
    /* access modifiers changed from: private */
    public static LocationController.LocationPoint lastLocationPoint;
    static OSPermissionState lastPermissionState;
    /* access modifiers changed from: private */
    public static String lastRegistrationId;
    static OSSubscriptionState lastSubscriptionState;
    static AtomicLong lastTaskId = new AtomicLong();
    /* access modifiers changed from: private */
    public static boolean locationFired;
    private static LOG_LEVEL logCatLevel = LOG_LEVEL.WARN;
    /* access modifiers changed from: private */
    public static OSLogger logger = new OSLogWrapper();
    /* access modifiers changed from: private */
    public static String mGoogleProjectNumber;
    @NonNull
    static Builder mInitBuilder = new Builder();
    private static PushRegistrator mPushRegistrator;
    @NonNull
    private static OSUtils osUtils = new OSUtils();
    /* access modifiers changed from: private */
    @Nullable
    public static OSOutcomeEventsController outcomeEventsController;
    @Nullable
    private static OSOutcomeEventsFactory outcomeEventsFactory;
    /* access modifiers changed from: private */
    public static ArrayList<GetTagsHandler> pendingGetTagsHandlers = new ArrayList<>();
    static ExecutorService pendingTaskExecutor;
    private static OSObservable<OSPermissionObserver, OSPermissionStateChanges> permissionStateChangesObserver;
    private static HashSet<String> postedOpenedNotifIds = new HashSet<>();
    /* access modifiers changed from: private */
    public static OSSharedPreferences preferences = new OSSharedPreferencesWrapper();
    /* access modifiers changed from: private */
    public static boolean promptedLocation;
    /* access modifiers changed from: private */
    public static boolean registerForPushFired;
    static OneSignalRemoteParams.Params remoteParams;
    static boolean requiresUserPrivacyConsent = false;
    public static String sdkType = "native";
    private static OSSessionManager.SessionListener sessionListener = new OSSessionManager.SessionListener() {
        public void onSessionEnding(@NonNull List<OSInfluence> list) {
            if (OneSignal.outcomeEventsController == null) {
                OneSignal.Log(LOG_LEVEL.WARN, "OneSignal onSessionEnding called before initZ");
            }
            if (OneSignal.outcomeEventsController != null) {
                OneSignal.outcomeEventsController.cleanOutcomes();
            }
            FocusTimeController.getInstance().onSessionEnded(list);
        }
    };
    private static OSSessionManager sessionManager = new OSSessionManager(sessionListener, trackerFactory, logger);
    static boolean shareLocation = true;
    /* access modifiers changed from: private */
    public static int subscribableStatus;
    private static OSObservable<OSSubscriptionObserver, OSSubscriptionStateChanges> subscriptionStateChangesObserver;
    public static ConcurrentLinkedQueue<Runnable> taskQueueWaitingForInit = new ConcurrentLinkedQueue<>();
    private static TrackAmazonPurchase trackAmazonPurchase;
    private static TrackFirebaseAnalytics trackFirebaseAnalytics;
    private static TrackGooglePurchase trackGooglePurchase;
    /* access modifiers changed from: private */
    public static OSTrackerFactory trackerFactory = new OSTrackerFactory(preferences, logger);
    private static Collection<JSONArray> unprocessedOpenedNotifis = new ArrayList();
    private static OSDevice userDevice;
    /* access modifiers changed from: private */
    public static String userId = null;
    private static LOG_LEVEL visualLogLevel = LOG_LEVEL.NONE;
    private static boolean waitingToPostStateSync;

    public interface ChangeTagsUpdateHandler {
        void onFailure(SendTagsError sendTagsError);

        void onSuccess(JSONObject jSONObject);
    }

    public enum EmailErrorType {
        VALIDATION,
        REQUIRES_EMAIL_AUTH,
        INVALID_OPERATION,
        NETWORK
    }

    public interface EmailUpdateHandler {
        void onFailure(EmailUpdateError emailUpdateError);

        void onSuccess();
    }

    public interface GetTagsHandler {
        void tagsAvailable(JSONObject jSONObject);
    }

    public interface IdsAvailableHandler {
        void idsAvailable(String str, String str2);
    }

    public interface InAppMessageClickHandler {
        void inAppMessageClicked(OSInAppMessageAction oSInAppMessageAction);
    }

    public enum LOG_LEVEL {
        NONE,
        FATAL,
        ERROR,
        WARN,
        INFO,
        DEBUG,
        VERBOSE
    }

    public interface NotificationOpenedHandler {
        void notificationOpened(OSNotificationOpenResult oSNotificationOpenResult);
    }

    public interface NotificationReceivedHandler {
        void notificationReceived(OSNotification oSNotification);
    }

    public interface OSExternalUserIdUpdateCompletionHandler {
        void onComplete(JSONObject jSONObject);
    }

    public enum OSInFocusDisplayOption {
        None,
        InAppAlert,
        Notification
    }

    interface OSInternalExternalUserIdUpdateCompletionHandler {
        void onComplete(String str, boolean z);
    }

    interface OSPromptActionCompletionCallback {
        void onCompleted(PromptActionResult promptActionResult);
    }

    public interface OutcomeCallback {
        void onSuccess(@Nullable OutcomeEvent outcomeEvent);
    }

    public interface PostNotificationResponseHandler {
        void onFailure(JSONObject jSONObject);

        void onSuccess(JSONObject jSONObject);
    }

    enum PromptActionResult {
        PERMISSION_GRANTED,
        PERMISSION_DENIED,
        LOCATION_PERMISSIONS_MISSING_MANIFEST,
        ERROR
    }

    /* access modifiers changed from: private */
    public static boolean pushStatusRuntimeError(int i) {
        return i < -6;
    }

    public enum AppEntryAction {
        NOTIFICATION_CLICK,
        APP_OPEN,
        APP_CLOSE;

        public boolean isNotificationClick() {
            return equals(NOTIFICATION_CLICK);
        }

        public boolean isAppOpen() {
            return equals(APP_OPEN);
        }

        public boolean isAppClose() {
            return equals(APP_CLOSE);
        }
    }

    public static class SendTagsError {
        private int code;
        private String message;

        SendTagsError(int i, String str) {
            this.message = str;
            this.code = i;
        }

        public int getCode() {
            return this.code;
        }

        public String getMessage() {
            return this.message;
        }
    }

    public static class EmailUpdateError {
        private String message;
        private EmailErrorType type;

        EmailUpdateError(EmailErrorType emailErrorType, String str) {
            this.type = emailErrorType;
            this.message = str;
        }

        public EmailErrorType getType() {
            return this.type;
        }

        public String getMessage() {
            return this.message;
        }
    }

    public static class Builder {
        Context mContext;
        boolean mDisableGmsMissingPrompt;
        OSInFocusDisplayOption mDisplayOption;
        boolean mDisplayOptionCarryOver;
        boolean mFilterOtherGCMReceivers;
        InAppMessageClickHandler mInAppMessageClickHandler;
        NotificationOpenedHandler mNotificationOpenedHandler;
        NotificationReceivedHandler mNotificationReceivedHandler;
        boolean mPromptLocation;
        boolean mUnsubscribeWhenNotificationsAreDisabled;

        private Builder() {
            this.mDisplayOption = OSInFocusDisplayOption.InAppAlert;
        }

        private Builder(Context context) {
            this.mDisplayOption = OSInFocusDisplayOption.InAppAlert;
            this.mContext = context;
        }

        private void setDisplayOptionCarryOver(boolean z) {
            this.mDisplayOptionCarryOver = z;
        }

        public Builder setNotificationOpenedHandler(NotificationOpenedHandler notificationOpenedHandler) {
            this.mNotificationOpenedHandler = notificationOpenedHandler;
            return this;
        }

        public Builder setNotificationReceivedHandler(NotificationReceivedHandler notificationReceivedHandler) {
            this.mNotificationReceivedHandler = notificationReceivedHandler;
            return this;
        }

        public Builder setInAppMessageClickHandler(InAppMessageClickHandler inAppMessageClickHandler) {
            this.mInAppMessageClickHandler = inAppMessageClickHandler;
            return this;
        }

        public Builder autoPromptLocation(boolean z) {
            this.mPromptLocation = z;
            return this;
        }

        public Builder disableGmsMissingPrompt(boolean z) {
            this.mDisableGmsMissingPrompt = z;
            return this;
        }

        public Builder inFocusDisplaying(OSInFocusDisplayOption oSInFocusDisplayOption) {
            this.mDisplayOptionCarryOver = false;
            this.mDisplayOption = oSInFocusDisplayOption;
            return this;
        }

        public Builder unsubscribeWhenNotificationsAreDisabled(boolean z) {
            this.mUnsubscribeWhenNotificationsAreDisabled = z;
            return this;
        }

        public Builder filterOtherGCMReceivers(boolean z) {
            this.mFilterOtherGCMReceivers = z;
            return this;
        }

        public void init() {
            OneSignal.init(this);
        }
    }

    static boolean isInitDone() {
        return initDone;
    }

    static boolean isForeground() {
        return foreground;
    }

    @NonNull
    static AppEntryAction getAppEntryState() {
        return appEntryState;
    }

    @Nullable
    private static synchronized AdvertisingIdentifierProvider getAdIdProvider() {
        AdvertisingIdentifierProvider advertisingIdentifierProvider;
        synchronized (OneSignal.class) {
            if (adIdProvider == null && OSUtils.isAndroidDeviceType()) {
                adIdProvider = new AdvertisingIdProviderGPS();
            }
            advertisingIdentifierProvider = adIdProvider;
        }
        return advertisingIdentifierProvider;
    }

    private static OSPermissionState getCurrentPermissionState(Context context) {
        if (context == null) {
            return null;
        }
        if (currentPermissionState == null) {
            currentPermissionState = new OSPermissionState(false);
            currentPermissionState.observable.addObserverStrong(new OSPermissionChangedInternalObserver());
        }
        return currentPermissionState;
    }

    private static OSPermissionState getLastPermissionState(Context context) {
        if (context == null) {
            return null;
        }
        if (lastPermissionState == null) {
            lastPermissionState = new OSPermissionState(true);
        }
        return lastPermissionState;
    }

    static OSObservable<OSPermissionObserver, OSPermissionStateChanges> getPermissionStateChangesObserver() {
        if (permissionStateChangesObserver == null) {
            permissionStateChangesObserver = new OSObservable<>("onOSPermissionChanged", true);
        }
        return permissionStateChangesObserver;
    }

    /* access modifiers changed from: private */
    public static OSSubscriptionState getCurrentSubscriptionState(Context context) {
        if (context == null) {
            return null;
        }
        if (currentSubscriptionState == null) {
            currentSubscriptionState = new OSSubscriptionState(false, getCurrentPermissionState(context).getEnabled());
            getCurrentPermissionState(context).observable.addObserver(currentSubscriptionState);
            currentSubscriptionState.observable.addObserverStrong(new OSSubscriptionChangedInternalObserver());
        }
        return currentSubscriptionState;
    }

    private static OSSubscriptionState getLastSubscriptionState(Context context) {
        if (context == null) {
            return null;
        }
        if (lastSubscriptionState == null) {
            lastSubscriptionState = new OSSubscriptionState(true, false);
        }
        return lastSubscriptionState;
    }

    static OSObservable<OSSubscriptionObserver, OSSubscriptionStateChanges> getSubscriptionStateChangesObserver() {
        if (subscriptionStateChangesObserver == null) {
            subscriptionStateChangesObserver = new OSObservable<>("onOSSubscriptionChanged", true);
        }
        return subscriptionStateChangesObserver;
    }

    /* access modifiers changed from: private */
    public static OSEmailSubscriptionState getCurrentEmailSubscriptionState(Context context) {
        if (context == null) {
            return null;
        }
        if (currentEmailSubscriptionState == null) {
            currentEmailSubscriptionState = new OSEmailSubscriptionState(false);
            currentEmailSubscriptionState.observable.addObserverStrong(new OSEmailSubscriptionChangedInternalObserver());
        }
        return currentEmailSubscriptionState;
    }

    private static OSEmailSubscriptionState getLastEmailSubscriptionState(Context context) {
        if (context == null) {
            return null;
        }
        if (lastEmailSubscriptionState == null) {
            lastEmailSubscriptionState = new OSEmailSubscriptionState(true);
        }
        return lastEmailSubscriptionState;
    }

    static OSObservable<OSEmailSubscriptionObserver, OSEmailSubscriptionStateChanges> getEmailSubscriptionStateChangesObserver() {
        if (emailSubscriptionStateChangesObserver == null) {
            emailSubscriptionStateChangesObserver = new OSObservable<>("onOSEmailSubscriptionChanged", true);
        }
        return emailSubscriptionStateChangesObserver;
    }

    public static OSDevice getUserDevice() {
        if (userDevice == null) {
            userDevice = new OSDevice();
        }
        return userDevice;
    }

    private static class IAPUpdateJob {
        boolean newAsExisting;
        OneSignalRestClient.ResponseHandler restResponseHandler;
        JSONArray toReport;

        IAPUpdateJob(JSONArray jSONArray) {
            this.toReport = jSONArray;
        }
    }

    public static Builder getCurrentOrNewInitBuilder() {
        return mInitBuilder;
    }

    public static void setAppContext(@NonNull Context context) {
        if (context == null) {
            Log(LOG_LEVEL.WARN, "setAppContext(null) is not valid, ignoring!");
            return;
        }
        boolean z = appContext == null;
        appContext = context.getApplicationContext();
        ActivityLifecycleListener.registerActivityLifecycleCallbacks((Application) appContext);
        if (z) {
            if (outcomeEventsFactory == null) {
                outcomeEventsFactory = new OSOutcomeEventsFactory(logger, apiClient, getDBHelperInstance(), preferences);
            }
            sessionManager.initSessionFromCache();
            outcomeEventsController = new OSOutcomeEventsController(sessionManager, outcomeEventsFactory);
            OneSignalPrefs.startDelayedWrite();
            OneSignalCacheCleaner.cleanOldCachedData(context);
        }
    }

    static OneSignalDbHelper getDBHelperInstance() {
        return OneSignalDbHelper.getInstance(appContext);
    }

    public static Builder startInit(Context context) {
        return new Builder(context);
    }

    /* access modifiers changed from: private */
    public static void init(Builder builder) {
        if (mInitBuilder.mDisplayOptionCarryOver) {
            builder.mDisplayOption = mInitBuilder.mDisplayOption;
        }
        mInitBuilder = builder;
        Context context = mInitBuilder.mContext;
        mInitBuilder.mContext = null;
        try {
            Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
            String string = bundle.getString("onesignal_google_project_number");
            if (string != null && string.length() > 4) {
                string = string.substring(4);
            }
            init(context, string, bundle.getString("onesignal_app_id"), mInitBuilder.mNotificationOpenedHandler, mInitBuilder.mNotificationReceivedHandler);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void init(Context context, String str, String str2) {
        init(context, str, str2, (NotificationOpenedHandler) null, (NotificationReceivedHandler) null);
    }

    public static void init(Context context, String str, String str2, NotificationOpenedHandler notificationOpenedHandler) {
        init(context, str, str2, notificationOpenedHandler, (NotificationReceivedHandler) null);
    }

    public static void init(Context context, String str, String str2, NotificationOpenedHandler notificationOpenedHandler, NotificationReceivedHandler notificationReceivedHandler) {
        mInitBuilder = createInitBuilder(notificationOpenedHandler, notificationReceivedHandler);
        setAppContext(context);
        setupPrivacyConsent(context);
        if (requiresUserPrivacyConsent()) {
            Log(LOG_LEVEL.VERBOSE, "OneSignal SDK initialization delayed, user privacy consent is set to required for this application.");
            delayedInitParams = new DelayedConsentInitializationParameters(context, str, str2, notificationOpenedHandler, notificationReceivedHandler);
            return;
        }
        mInitBuilder = createInitBuilder(notificationOpenedHandler, notificationReceivedHandler);
        if (!isGoogleProjectNumberRemote()) {
            mGoogleProjectNumber = str;
        }
        subscribableStatus = osUtils.initializationChecker(context, str2);
        if (!isSubscriptionStatusUninitializable()) {
            if (appId != null && !appId.equals(str2)) {
                initDone = false;
            }
            if (!initDone) {
                appId = str2;
                saveFilterOtherGCMReceivers(mInitBuilder.mFilterOtherGCMReceivers);
                handleActivityLifecycleHandler(context);
                OneSignalStateSynchronizer.initUserState();
                handleAmazonPurchase();
                handleAppIdChange();
                OSPermissionChangedInternalObserver.handleInternalChanges(getCurrentPermissionState(appContext));
                doSessionInit();
                if (mInitBuilder.mNotificationOpenedHandler != null) {
                    fireCallbackForOpenedNotifications();
                }
                if (TrackGooglePurchase.CanTrack(appContext)) {
                    trackGooglePurchase = new TrackGooglePurchase(appContext);
                }
                if (TrackFirebaseAnalytics.CanTrack()) {
                    trackFirebaseAnalytics = new TrackFirebaseAnalytics(appContext);
                }
                PushRegistratorFCM.disableFirebaseInstanceIdService(appContext);
                initDone = true;
                outcomeEventsController.sendSavedOutcomes();
                startPendingTasks();
            } else if (mInitBuilder.mNotificationOpenedHandler != null) {
                fireCallbackForOpenedNotifications();
            }
        }
    }

    private static void setupPrivacyConsent(Context context) {
        try {
            setRequiresUserPrivacyConsent("ENABLE".equalsIgnoreCase(context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.getString("com.onesignal.PrivacyConsent")));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private static Builder createInitBuilder(NotificationOpenedHandler notificationOpenedHandler, NotificationReceivedHandler notificationReceivedHandler) {
        mInitBuilder.mDisplayOptionCarryOver = false;
        mInitBuilder.mNotificationOpenedHandler = notificationOpenedHandler;
        mInitBuilder.mNotificationReceivedHandler = notificationReceivedHandler;
        return mInitBuilder;
    }

    private static void handleAppIdChange() {
        String savedAppId = getSavedAppId();
        if (savedAppId == null) {
            BadgeCountUpdater.updateCount(0, appContext);
            saveAppId(appId);
        } else if (!savedAppId.equals(appId)) {
            Log(LOG_LEVEL.DEBUG, "APP ID changed, clearing user id as it is no longer valid.");
            saveAppId(appId);
            OneSignalStateSynchronizer.resetCurrentState();
            remoteParams = null;
        }
    }

    public static boolean userProvidedPrivacyConsent() {
        return getSavedUserConsentStatus();
    }

    private static boolean isGoogleProjectNumberRemote() {
        return (remoteParams == null || remoteParams.googleProjectNumber == null) ? false : true;
    }

    private static boolean isSubscriptionStatusUninitializable() {
        return subscribableStatus == -999;
    }

    private static void handleActivityLifecycleHandler(Context context) {
        foreground = isContextActivity(context);
        if (foreground) {
            ActivityLifecycleHandler.curActivity = (Activity) context;
            NotificationRestorer.asyncRestore(appContext);
            FocusTimeController.getInstance().appForegrounded();
            return;
        }
        ActivityLifecycleHandler.nextResumeIsFirstActivity = true;
    }

    private static void handleAmazonPurchase() {
        try {
            Class.forName("com.amazon.device.iap.PurchasingListener");
            trackAmazonPurchase = new TrackAmazonPurchase(appContext);
        } catch (ClassNotFoundException unused) {
        }
    }

    private static void doSessionInit() {
        if (isPastOnSessionTime()) {
            OneSignalStateSynchronizer.setNewSession();
            if (foreground) {
                outcomeEventsController.cleanOutcomes();
                sessionManager.restartSessionIfNeeded(getAppEntryState());
            }
        } else if (foreground) {
            OSInAppMessageController.getController().initWithCachedInAppMessages();
            sessionManager.attemptSessionUpgrade(getAppEntryState());
        }
        if (foreground || !hasUserId()) {
            setLastSessionTime(System.currentTimeMillis());
            startRegistrationOrOnSession();
        }
    }

    private static boolean isContextActivity(Context context) {
        return context instanceof Activity;
    }

    /* access modifiers changed from: private */
    public static void onTaskRan(long j) {
        if (lastTaskId.get() == j) {
            Log(LOG_LEVEL.INFO, "Last Pending Task has ran, shutting down");
            pendingTaskExecutor.shutdown();
        }
    }

    private static class PendingTaskRunnable implements Runnable {
        private Runnable innerTask;
        /* access modifiers changed from: private */
        public long taskId;

        PendingTaskRunnable(Runnable runnable) {
            this.innerTask = runnable;
        }

        public void run() {
            this.innerTask.run();
            OneSignal.onTaskRan(this.taskId);
        }
    }

    private static void startPendingTasks() {
        if (!taskQueueWaitingForInit.isEmpty()) {
            pendingTaskExecutor = Executors.newSingleThreadExecutor(new ThreadFactory() {
                public Thread newThread(@NonNull Runnable runnable) {
                    Thread thread = new Thread(runnable);
                    thread.setName("OS_PENDING_EXECUTOR_" + thread.getId());
                    return thread;
                }
            });
            while (!taskQueueWaitingForInit.isEmpty()) {
                pendingTaskExecutor.submit(taskQueueWaitingForInit.poll());
            }
        }
    }

    private static void addTaskToQueue(PendingTaskRunnable pendingTaskRunnable) {
        long unused = pendingTaskRunnable.taskId = lastTaskId.incrementAndGet();
        if (pendingTaskExecutor == null) {
            LOG_LEVEL log_level = LOG_LEVEL.INFO;
            Log(log_level, "Adding a task to the pending queue with ID: " + pendingTaskRunnable.taskId);
            taskQueueWaitingForInit.add(pendingTaskRunnable);
        } else if (!pendingTaskExecutor.isShutdown()) {
            LOG_LEVEL log_level2 = LOG_LEVEL.INFO;
            Log(log_level2, "Executor is still running, add to the executor with ID: " + pendingTaskRunnable.taskId);
            try {
                pendingTaskExecutor.submit(pendingTaskRunnable);
            } catch (RejectedExecutionException e) {
                LOG_LEVEL log_level3 = LOG_LEVEL.INFO;
                Log(log_level3, "Executor is shutdown, running task manually with ID: " + pendingTaskRunnable.taskId);
                pendingTaskRunnable.run();
                e.printStackTrace();
            }
        }
    }

    private static boolean shouldRunTaskThroughQueue() {
        if (initDone && pendingTaskExecutor == null) {
            return false;
        }
        if (!initDone && pendingTaskExecutor == null) {
            return true;
        }
        if (pendingTaskExecutor == null || pendingTaskExecutor.isShutdown()) {
            return false;
        }
        return true;
    }

    private static void startRegistrationOrOnSession() {
        if (!waitingToPostStateSync) {
            waitingToPostStateSync = true;
            if (OneSignalStateSynchronizer.getSyncAsNewSession()) {
                locationFired = false;
            }
            startLocationUpdate();
            registerForPushFired = false;
            makeAndroidParamsRequest();
        }
    }

    private static void startLocationUpdate() {
        C24263 r0 = new LocationController.LocationHandler() {
            public LocationController.PermissionType getType() {
                return LocationController.PermissionType.STARTUP;
            }

            public void onComplete(LocationController.LocationPoint locationPoint) {
                LocationController.LocationPoint unused = OneSignal.lastLocationPoint = locationPoint;
                boolean unused2 = OneSignal.locationFired = true;
                OneSignal.registerUser();
            }
        };
        boolean z = true;
        boolean z2 = mInitBuilder.mPromptLocation && !promptedLocation;
        if (!promptedLocation && !mInitBuilder.mPromptLocation) {
            z = false;
        }
        promptedLocation = z;
        LocationController.getLocation(appContext, z2, false, r0);
    }

    private static PushRegistrator getPushRegistrator() {
        if (mPushRegistrator != null) {
            return mPushRegistrator;
        }
        if (OSUtils.isFireOSDeviceType()) {
            mPushRegistrator = new PushRegistratorADM();
        } else if (!OSUtils.isAndroidDeviceType()) {
            mPushRegistrator = new PushRegistratorHMS();
        } else if (OSUtils.hasFCMLibrary()) {
            mPushRegistrator = new PushRegistratorFCM();
        } else {
            mPushRegistrator = new PushRegistratorGCM();
        }
        return mPushRegistrator;
    }

    /* access modifiers changed from: private */
    public static void registerForPushToken() {
        getPushRegistrator().registerForPush(appContext, mGoogleProjectNumber, new PushRegistrator.RegisteredHandler() {
            public void complete(String str, int i) {
                if (i < 1) {
                    if (OneSignalStateSynchronizer.getRegistrationId() == null && (OneSignal.subscribableStatus == 1 || OneSignal.pushStatusRuntimeError(OneSignal.subscribableStatus))) {
                        int unused = OneSignal.subscribableStatus = i;
                    }
                } else if (OneSignal.pushStatusRuntimeError(OneSignal.subscribableStatus)) {
                    int unused2 = OneSignal.subscribableStatus = i;
                }
                String unused3 = OneSignal.lastRegistrationId = str;
                boolean unused4 = OneSignal.registerForPushFired = true;
                OneSignal.getCurrentSubscriptionState(OneSignal.appContext).setPushToken(str);
                OneSignal.registerUser();
            }
        });
    }

    private static void makeAndroidParamsRequest() {
        if (remoteParams != null) {
            registerForPushToken();
        } else {
            OneSignalRemoteParams.makeAndroidParamsRequest(new OneSignalRemoteParams.CallBack() {
                public void complete(OneSignalRemoteParams.Params params) {
                    OneSignal.remoteParams = params;
                    if (OneSignal.remoteParams.googleProjectNumber != null) {
                        String unused = OneSignal.mGoogleProjectNumber = OneSignal.remoteParams.googleProjectNumber;
                    }
                    OneSignalPrefs.saveBool(OneSignalPrefs.PREFS_ONESIGNAL, OneSignalPrefs.PREFS_GT_FIREBASE_TRACKING_ENABLED, OneSignal.remoteParams.firebaseAnalytics);
                    OneSignalPrefs.saveBool(OneSignalPrefs.PREFS_ONESIGNAL, OneSignalPrefs.PREFS_OS_RESTORE_TTL_FILTER, OneSignal.remoteParams.restoreTTLFilter);
                    OneSignalPrefs.saveBool(OneSignalPrefs.PREFS_ONESIGNAL, OneSignalPrefs.PREFS_OS_CLEAR_GROUP_SUMMARY_CLICK, OneSignal.remoteParams.clearGroupOnSummaryClick);
                    OneSignalPrefs.saveBool(OneSignalPrefs.PREFS_ONESIGNAL, OneSignalPrefs.PREFS_OS_RECEIVE_RECEIPTS_ENABLED, OneSignal.remoteParams.receiveReceiptEnabled);
                    OneSignalPrefs.saveBool(OneSignalPrefs.PREFS_ONESIGNAL, OneSignal.preferences.getOutcomesV2KeyName(), params.influenceParams.outcomesV2ServiceEnabled);
                    OSLogger access$1600 = OneSignal.logger;
                    access$1600.debug("OneSignal saveInfluenceParams: " + params.influenceParams.toString());
                    OneSignal.trackerFactory.saveInfluenceParams(params.influenceParams);
                    NotificationChannelManager.processChannelList(OneSignal.appContext, params.notificationChannels);
                    OneSignal.registerForPushToken();
                }
            });
        }
    }

    private static void fireCallbackForOpenedNotifications() {
        for (JSONArray runNotificationOpenedCallback : unprocessedOpenedNotifis) {
            runNotificationOpenedCallback(runNotificationOpenedCallback, true, false);
        }
        unprocessedOpenedNotifis.clear();
    }

    public static void onesignalLog(LOG_LEVEL log_level, String str) {
        Log(log_level, str);
    }

    public static void provideUserConsent(boolean z) {
        boolean userProvidedPrivacyConsent = userProvidedPrivacyConsent();
        saveUserConsentStatus(z);
        if (!userProvidedPrivacyConsent && z && delayedInitParams != null) {
            init(delayedInitParams.context, delayedInitParams.googleProjectNumber, delayedInitParams.appId, delayedInitParams.openedHandler, delayedInitParams.receivedHandler);
            delayedInitParams = null;
        }
    }

    public static void setRequiresUserPrivacyConsent(boolean z) {
        if (!requiresUserPrivacyConsent || z) {
            requiresUserPrivacyConsent = z;
        } else {
            Log(LOG_LEVEL.ERROR, "Cannot change requiresUserPrivacyConsent() from TRUE to FALSE");
        }
    }

    public static boolean requiresUserPrivacyConsent() {
        return requiresUserPrivacyConsent && !userProvidedPrivacyConsent();
    }

    static boolean shouldLogUserPrivacyConsentErrorMessageForMethodName(String str) {
        if (!requiresUserPrivacyConsent()) {
            return false;
        }
        if (str == null) {
            return true;
        }
        LOG_LEVEL log_level = LOG_LEVEL.WARN;
        Log(log_level, "Method " + str + " was called before the user provided privacy consent. Your application is set to require the user's privacy consent before the OneSignal SDK can be initialized. Please ensure the user has provided consent before calling this method. You can check the latest OneSignal consent status by calling OneSignal.userProvidedPrivacyConsent()");
        return true;
    }

    public static void setLogLevel(LOG_LEVEL log_level, LOG_LEVEL log_level2) {
        logCatLevel = log_level;
        visualLogLevel = log_level2;
    }

    public static void setLogLevel(int i, int i2) {
        setLogLevel(getLogLevel(i), getLogLevel(i2));
    }

    private static LOG_LEVEL getLogLevel(int i) {
        switch (i) {
            case 0:
                return LOG_LEVEL.NONE;
            case 1:
                return LOG_LEVEL.FATAL;
            case 2:
                return LOG_LEVEL.ERROR;
            case 3:
                return LOG_LEVEL.WARN;
            case 4:
                return LOG_LEVEL.INFO;
            case 5:
                return LOG_LEVEL.DEBUG;
            case 6:
                return LOG_LEVEL.VERBOSE;
            default:
                if (i < 0) {
                    return LOG_LEVEL.NONE;
                }
                return LOG_LEVEL.VERBOSE;
        }
    }

    static boolean atLogLevel(LOG_LEVEL log_level) {
        return log_level.compareTo(visualLogLevel) < 1 || log_level.compareTo(logCatLevel) < 1;
    }

    static void Log(@NonNull LOG_LEVEL log_level, @NonNull String str) {
        Log(log_level, str, (Throwable) null);
    }

    static void Log(@NonNull final LOG_LEVEL log_level, @NonNull String str, @Nullable Throwable th) {
        if (log_level.compareTo(logCatLevel) < 1) {
            if (log_level == LOG_LEVEL.VERBOSE) {
                Log.v("OneSignal", str, th);
            } else if (log_level == LOG_LEVEL.DEBUG) {
                Log.d("OneSignal", str, th);
            } else if (log_level == LOG_LEVEL.INFO) {
                Log.i("OneSignal", str, th);
            } else if (log_level == LOG_LEVEL.WARN) {
                Log.w("OneSignal", str, th);
            } else if (log_level == LOG_LEVEL.ERROR || log_level == LOG_LEVEL.FATAL) {
                Log.e("OneSignal", str, th);
            }
        }
        if (log_level.compareTo(visualLogLevel) < 1 && ActivityLifecycleHandler.curActivity != null) {
            try {
                final String str2 = str + "\n";
                if (th != null) {
                    StringWriter stringWriter = new StringWriter();
                    th.printStackTrace(new PrintWriter(stringWriter));
                    str2 = (str2 + th.getMessage()) + stringWriter.toString();
                }
                OSUtils.runOnMainUIThread(new Runnable() {
                    public void run() {
                        if (ActivityLifecycleHandler.curActivity != null) {
                            new AlertDialog.Builder(ActivityLifecycleHandler.curActivity).setTitle(log_level.toString()).setMessage(str2).show();
                        }
                    }
                });
            } catch (Throwable th2) {
                Log.e("OneSignal", "Error showing logging message.", th2);
            }
        }
    }

    static void logHttpError(String str, int i, Throwable th, String str2) {
        String str3 = "";
        if (str2 != null && atLogLevel(LOG_LEVEL.INFO)) {
            str3 = "\n" + str2 + "\n";
        }
        Log(LOG_LEVEL.WARN, "HTTP code: " + i + StringUtils.SPACE + str + str3, th);
    }

    @WorkerThread
    static void onAppLostFocus() {
        foreground = false;
        appEntryState = AppEntryAction.APP_CLOSE;
        setLastSessionTime(System.currentTimeMillis());
        LocationController.onFocusChange();
        if (initDone) {
            if (trackAmazonPurchase != null) {
                trackAmazonPurchase.checkListener();
            }
            if (appContext == null) {
                Log(LOG_LEVEL.ERROR, "Android Context not found, please call OneSignal.init when your app starts.");
                return;
            }
            FocusTimeController.getInstance().appBackgrounded();
            scheduleSyncService();
        }
    }

    private static boolean scheduleSyncService() {
        boolean persist = OneSignalStateSynchronizer.persist();
        if (persist) {
            OneSignalSyncServiceUtils.scheduleSyncTask(appContext);
        }
        return LocationController.scheduleUpdate(appContext) || persist;
    }

    static void onAppFocus() {
        foreground = true;
        if (!appEntryState.equals(AppEntryAction.NOTIFICATION_CLICK)) {
            appEntryState = AppEntryAction.APP_OPEN;
        }
        LocationController.onFocusChange();
        if (!shouldLogUserPrivacyConsentErrorMessageForMethodName("onAppFocus") && !OSUtils.shouldLogMissingAppIdError(appId)) {
            FocusTimeController.getInstance().appForegrounded();
            doSessionInit();
            if (trackGooglePurchase != null) {
                trackGooglePurchase.trackIAP();
            }
            NotificationRestorer.asyncRestore(appContext);
            getCurrentPermissionState(appContext).refreshAsTo();
            if (trackFirebaseAnalytics != null && getFirebaseAnalyticsEnabled()) {
                trackFirebaseAnalytics.trackInfluenceOpenEvent();
            }
            OneSignalSyncServiceUtils.cancelSyncTask(appContext);
        }
    }

    static void addNetType(JSONObject jSONObject) {
        try {
            jSONObject.put("net_type", osUtils.getNetType());
        } catch (Throwable unused) {
        }
    }

    private static int getTimeZoneOffset() {
        TimeZone timeZone = Calendar.getInstance().getTimeZone();
        int rawOffset = timeZone.getRawOffset();
        if (timeZone.inDaylightTime(new Date())) {
            rawOffset += timeZone.getDSTSavings();
        }
        return rawOffset / 1000;
    }

    /* access modifiers changed from: private */
    public static void registerUser() {
        LOG_LEVEL log_level = LOG_LEVEL.DEBUG;
        Log(log_level, "registerUser:registerForPushFired:" + registerForPushFired + ", locationFired: " + locationFired + ", remoteParams: " + remoteParams + ", appId: " + appId);
        if (registerForPushFired && locationFired && remoteParams != null && appId != null) {
            new Thread(new Runnable() {
                public void run() {
                    try {
                        OneSignal.registerUserTask();
                        OneSignalChromeTabAndroidFrame.setup(OneSignal.appId, OneSignal.userId, AdvertisingIdProviderGPS.getLastValue());
                    } catch (JSONException e) {
                        OneSignal.Log(LOG_LEVEL.FATAL, "FATAL Error registering device!", e);
                    }
                }
            }, "OS_REG_USER").start();
        }
    }

    /* access modifiers changed from: private */
    public static void registerUserTask() throws JSONException {
        String identifier;
        String packageName = appContext.getPackageName();
        PackageManager packageManager = appContext.getPackageManager();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("app_id", getSavedAppId());
        if (!(getAdIdProvider() == null || (identifier = getAdIdProvider().getIdentifier(appContext)) == null)) {
            jSONObject.put("ad_id", identifier);
        }
        jSONObject.put("device_os", Build.VERSION.RELEASE);
        jSONObject.put("timezone", getTimeZoneOffset());
        jSONObject.put(Constants.AMP_TRACKING_OPTION_LANGUAGE, OSUtils.getCorrectedLanguage());
        jSONObject.put("sdk", VERSION);
        jSONObject.put("sdk_type", sdkType);
        jSONObject.put("android_package", packageName);
        jSONObject.put(Constants.AMP_TRACKING_OPTION_DEVICE_MODEL, Build.MODEL);
        try {
            jSONObject.put("game_version", packageManager.getPackageInfo(packageName, 0).versionCode);
        } catch (PackageManager.NameNotFoundException unused) {
        }
        jSONObject.put("net_type", osUtils.getNetType());
        jSONObject.put(Constants.AMP_TRACKING_OPTION_CARRIER, osUtils.getCarrierName());
        jSONObject.put("rooted", RootToolsInternalMethods.isRooted());
        OneSignalStateSynchronizer.updateDeviceInfo(jSONObject);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("identifier", lastRegistrationId);
        jSONObject2.put("subscribableStatus", subscribableStatus);
        jSONObject2.put("androidPermission", areNotificationsEnabledForSubscribedState());
        jSONObject2.put("device_type", osUtils.getDeviceType());
        OneSignalStateSynchronizer.updatePushState(jSONObject2);
        if (shareLocation && lastLocationPoint != null) {
            OneSignalStateSynchronizer.updateLocation(lastLocationPoint);
        }
        OneSignalStateSynchronizer.readyToUpdate(true);
        waitingToPostStateSync = false;
    }

    @Deprecated
    public static void syncHashedEmail(final String str) {
        if (!shouldLogUserPrivacyConsentErrorMessageForMethodName("SyncHashedEmail()") && OSUtils.isValidEmail(str)) {
            C24318 r0 = new Runnable() {
                public void run() {
                    OneSignalStateSynchronizer.syncHashedEmail(str.trim().toLowerCase());
                }
            };
            if (appContext == null || shouldRunTaskThroughQueue()) {
                Log(LOG_LEVEL.ERROR, "You should initialize OneSignal before calling syncHashedEmail! Moving this operation to a pending task queue.");
                addTaskToQueue(new PendingTaskRunnable(r0));
                return;
            }
            r0.run();
        }
    }

    public static void setEmail(@NonNull String str, EmailUpdateHandler emailUpdateHandler2) {
        setEmail(str, (String) null, emailUpdateHandler2);
    }

    public static void setEmail(@NonNull String str) {
        setEmail(str, (String) null, (EmailUpdateHandler) null);
    }

    public static void setEmail(@NonNull String str, @Nullable String str2) {
        setEmail(str, str2, (EmailUpdateHandler) null);
    }

    public static void setEmail(@NonNull final String str, @Nullable final String str2, @Nullable EmailUpdateHandler emailUpdateHandler2) {
        if (!shouldLogUserPrivacyConsentErrorMessageForMethodName("setEmail()")) {
            if (!OSUtils.isValidEmail(str)) {
                if (emailUpdateHandler2 != null) {
                    emailUpdateHandler2.onFailure(new EmailUpdateError(EmailErrorType.VALIDATION, "Email is invalid"));
                }
                Log(LOG_LEVEL.ERROR, "Email is invalid");
            } else if (remoteParams == null || !remoteParams.useEmailAuth || str2 != null) {
                emailUpdateHandler = emailUpdateHandler2;
                C24329 r3 = new Runnable() {
                    public void run() {
                        String trim = str.trim();
                        String str = str2;
                        if (str != null) {
                            str.toLowerCase();
                        }
                        OneSignal.getCurrentEmailSubscriptionState(OneSignal.appContext).setEmailAddress(trim);
                        OneSignalStateSynchronizer.setEmail(trim.toLowerCase(), str);
                    }
                };
                if (appContext == null || shouldRunTaskThroughQueue()) {
                    Log(LOG_LEVEL.ERROR, "You should initialize OneSignal before calling setEmail! Moving this operation to a pending task queue.");
                    addTaskToQueue(new PendingTaskRunnable(r3));
                    return;
                }
                r3.run();
            } else {
                if (emailUpdateHandler2 != null) {
                    emailUpdateHandler2.onFailure(new EmailUpdateError(EmailErrorType.REQUIRES_EMAIL_AUTH, "Email authentication (auth token) is set to REQUIRED for this application. Please provide an auth token from your backend server or change the setting in the OneSignal dashboard."));
                }
                Log(LOG_LEVEL.ERROR, "Email authentication (auth token) is set to REQUIRED for this application. Please provide an auth token from your backend server or change the setting in the OneSignal dashboard.");
            }
        }
    }

    public static void logoutEmail() {
        logoutEmail((EmailUpdateHandler) null);
    }

    public static void logoutEmail(@Nullable EmailUpdateHandler emailUpdateHandler2) {
        if (!shouldLogUserPrivacyConsentErrorMessageForMethodName("logoutEmail()")) {
            if (getEmailId() == null) {
                if (emailUpdateHandler2 != null) {
                    emailUpdateHandler2.onFailure(new EmailUpdateError(EmailErrorType.INVALID_OPERATION, "logoutEmail not valid as email was not set or already logged out!"));
                }
                Log(LOG_LEVEL.ERROR, "logoutEmail not valid as email was not set or already logged out!");
                return;
            }
            emailLogoutHandler = emailUpdateHandler2;
            C240710 r3 = new Runnable() {
                public void run() {
                    OneSignalStateSynchronizer.logoutEmail();
                }
            };
            if (appContext == null || shouldRunTaskThroughQueue()) {
                Log(LOG_LEVEL.ERROR, "You should initialize OneSignal before calling logoutEmail! Moving this operation to a pending task queue.");
                addTaskToQueue(new PendingTaskRunnable(r3));
                return;
            }
            r3.run();
        }
    }

    public static void setExternalUserId(@NonNull String str) {
        setExternalUserId(str, (OSExternalUserIdUpdateCompletionHandler) null);
    }

    public static void setExternalUserId(@NonNull final String str, @Nullable final OSExternalUserIdUpdateCompletionHandler oSExternalUserIdUpdateCompletionHandler) {
        if (!shouldLogUserPrivacyConsentErrorMessageForMethodName("setExternalUserId()")) {
            C240811 r0 = new Runnable() {
                public void run() {
                    if (str == null) {
                        OneSignal.Log(LOG_LEVEL.WARN, "External id can't be null, set an empty string to remove an external id");
                        return;
                    }
                    try {
                        OneSignalStateSynchronizer.setExternalUserId(str, oSExternalUserIdUpdateCompletionHandler);
                    } catch (JSONException e) {
                        String str = str.equals("") ? "remove" : "set";
                        LOG_LEVEL log_level = LOG_LEVEL.ERROR;
                        OneSignal.onesignalLog(log_level, "Attempted to " + str + " external ID but encountered a JSON exception");
                        e.printStackTrace();
                    }
                }
            };
            if (appContext == null || shouldRunTaskThroughQueue()) {
                addTaskToQueue(new PendingTaskRunnable(r0));
            } else {
                r0.run();
            }
        }
    }

    public static void removeExternalUserId() {
        if (!shouldLogUserPrivacyConsentErrorMessageForMethodName("removeExternalUserId()")) {
            removeExternalUserId((OSExternalUserIdUpdateCompletionHandler) null);
        }
    }

    public static void removeExternalUserId(OSExternalUserIdUpdateCompletionHandler oSExternalUserIdUpdateCompletionHandler) {
        if (!shouldLogUserPrivacyConsentErrorMessageForMethodName("removeExternalUserId()")) {
            setExternalUserId("", oSExternalUserIdUpdateCompletionHandler);
        }
    }

    public static void sendTag(String str, String str2) {
        if (!shouldLogUserPrivacyConsentErrorMessageForMethodName("sendTag()")) {
            try {
                sendTags(new JSONObject().put(str, str2));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public static void sendTags(String str) {
        try {
            sendTags(new JSONObject(str));
        } catch (JSONException e) {
            Log(LOG_LEVEL.ERROR, "Generating JSONObject for sendTags failed!", e);
        }
    }

    public static void sendTags(JSONObject jSONObject) {
        sendTags(jSONObject, (ChangeTagsUpdateHandler) null);
    }

    public static void sendTags(final JSONObject jSONObject, final ChangeTagsUpdateHandler changeTagsUpdateHandler) {
        if (!shouldLogUserPrivacyConsentErrorMessageForMethodName("sendTags()")) {
            C240912 r0 = new Runnable() {
                public void run() {
                    if (jSONObject != null) {
                        JSONObject jSONObject = OneSignalStateSynchronizer.getTags(false).result;
                        JSONObject jSONObject2 = new JSONObject();
                        Iterator<String> keys = jSONObject.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            try {
                                Object opt = jSONObject.opt(next);
                                if (!(opt instanceof JSONArray)) {
                                    if (!(opt instanceof JSONObject)) {
                                        if (!jSONObject.isNull(next)) {
                                            if (!"".equals(opt)) {
                                                jSONObject2.put(next, opt.toString());
                                            }
                                        }
                                        if (jSONObject != null && jSONObject.has(next)) {
                                            jSONObject2.put(next, "");
                                        }
                                    }
                                }
                                LOG_LEVEL log_level = LOG_LEVEL.ERROR;
                                OneSignal.Log(log_level, "Omitting key '" + next + "'! sendTags DO NOT supported nested values!");
                            } catch (Throwable unused) {
                            }
                        }
                        if (!jSONObject2.toString().equals("{}")) {
                            OneSignalStateSynchronizer.sendTags(jSONObject2, changeTagsUpdateHandler);
                        } else if (changeTagsUpdateHandler != null) {
                            changeTagsUpdateHandler.onSuccess(jSONObject);
                        }
                    } else if (changeTagsUpdateHandler != null) {
                        changeTagsUpdateHandler.onFailure(new SendTagsError(-1, "Attempted to send null tags"));
                    }
                }
            };
            if (appContext == null || shouldRunTaskThroughQueue()) {
                Log(LOG_LEVEL.ERROR, "You must initialize OneSignal before modifying tags!Moving this operation to a pending task queue.");
                if (changeTagsUpdateHandler != null) {
                    changeTagsUpdateHandler.onFailure(new SendTagsError(-1, "You must initialize OneSignal before modifying tags!Moving this operation to a pending task queue."));
                }
                addTaskToQueue(new PendingTaskRunnable(r0));
                return;
            }
            r0.run();
        }
    }

    public static void postNotification(String str, PostNotificationResponseHandler postNotificationResponseHandler) {
        try {
            postNotification(new JSONObject(str), postNotificationResponseHandler);
        } catch (JSONException unused) {
            LOG_LEVEL log_level = LOG_LEVEL.ERROR;
            Log(log_level, "Invalid postNotification JSON format: " + str);
        }
    }

    public static void postNotification(JSONObject jSONObject, final PostNotificationResponseHandler postNotificationResponseHandler) {
        if (!shouldLogUserPrivacyConsentErrorMessageForMethodName("postNotification()")) {
            try {
                if (!jSONObject.has("app_id")) {
                    jSONObject.put("app_id", getSavedAppId());
                }
                if (jSONObject.has("app_id")) {
                    OneSignalRestClient.post("notifications/", jSONObject, new OneSignalRestClient.ResponseHandler() {
                        public void onSuccess(String str) {
                            LOG_LEVEL log_level = LOG_LEVEL.DEBUG;
                            StringBuilder sb = new StringBuilder();
                            sb.append("HTTP create notification success: ");
                            sb.append(str != null ? str : "null");
                            OneSignal.Log(log_level, sb.toString());
                            if (postNotificationResponseHandler != null) {
                                try {
                                    JSONObject jSONObject = new JSONObject(str);
                                    if (jSONObject.has("errors")) {
                                        postNotificationResponseHandler.onFailure(jSONObject);
                                    } else {
                                        postNotificationResponseHandler.onSuccess(new JSONObject(str));
                                    }
                                } catch (Throwable th) {
                                    th.printStackTrace();
                                }
                            }
                        }

                        /* access modifiers changed from: package-private */
                        /* JADX WARNING: Can't wrap try/catch for region: R(6:(1:3)|4|5|6|7|13) */
                        /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
                            return;
                         */
                        /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
                            return;
                         */
                        /* JADX WARNING: Code restructure failed: missing block: B:8:0x0025, code lost:
                            r2 = move-exception;
                         */
                        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0026, code lost:
                            r2.printStackTrace();
                         */
                        /* JADX WARNING: Failed to process nested try/catch */
                        /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0018 */
                        /* Code decompiled incorrectly, please refer to instructions dump. */
                        public void onFailure(int r2, java.lang.String r3, java.lang.Throwable r4) {
                            /*
                                r1 = this;
                                java.lang.String r0 = "create notification failed"
                                com.onesignal.OneSignal.logHttpError(r0, r2, r4, r3)
                                com.onesignal.OneSignal$PostNotificationResponseHandler r4 = r3
                                if (r4 == 0) goto L_0x0029
                                if (r2 != 0) goto L_0x000d
                                java.lang.String r3 = "{\"error\": \"HTTP no response error\"}"
                            L_0x000d:
                                com.onesignal.OneSignal$PostNotificationResponseHandler r2 = r3     // Catch:{ Throwable -> 0x0018 }
                                org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ Throwable -> 0x0018 }
                                r4.<init>(r3)     // Catch:{ Throwable -> 0x0018 }
                                r2.onFailure(r4)     // Catch:{ Throwable -> 0x0018 }
                                goto L_0x0029
                            L_0x0018:
                                com.onesignal.OneSignal$PostNotificationResponseHandler r2 = r3     // Catch:{ JSONException -> 0x0025 }
                                org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0025 }
                                java.lang.String r4 = "{\"error\": \"Unknown response!\"}"
                                r3.<init>(r4)     // Catch:{ JSONException -> 0x0025 }
                                r2.onFailure(r3)     // Catch:{ JSONException -> 0x0025 }
                                goto L_0x0029
                            L_0x0025:
                                r2 = move-exception
                                r2.printStackTrace()
                            L_0x0029:
                                return
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.onesignal.OneSignal.C241013.onFailure(int, java.lang.String, java.lang.Throwable):void");
                        }
                    });
                } else if (postNotificationResponseHandler != null) {
                    postNotificationResponseHandler.onFailure(new JSONObject().put("error", "Missing app_id"));
                }
            } catch (JSONException e) {
                Log(LOG_LEVEL.ERROR, "HTTP create notification json exception!", e);
                if (postNotificationResponseHandler != null) {
                    try {
                        postNotificationResponseHandler.onFailure(new JSONObject("{'error': 'HTTP create notification json exception!'}"));
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
            }
        }
    }

    public static void getTags(final GetTagsHandler getTagsHandler) {
        if (!shouldLogUserPrivacyConsentErrorMessageForMethodName("getTags()")) {
            if (getTagsHandler == null) {
                Log(LOG_LEVEL.ERROR, "getTagsHandler is null!");
            } else {
                new Thread(new Runnable() {
                    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0020, code lost:
                        com.onesignal.OneSignal.Log(com.onesignal.OneSignal.LOG_LEVEL.ERROR, "You must initialize OneSignal before getting tags! Moving this tag operation to a pending queue.");
                        com.onesignal.OneSignal.taskQueueWaitingForInit.add(new com.onesignal.OneSignal.C241114.C24121(r3));
                     */
                    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0031, code lost:
                        return;
                     */
                    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0032, code lost:
                        com.onesignal.OneSignal.access$2300();
                     */
                    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0035, code lost:
                        return;
                     */
                    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001e, code lost:
                        if (com.onesignal.OneSignal.appContext != null) goto L_0x0032;
                     */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public void run() {
                        /*
                            r3 = this;
                            java.util.ArrayList r0 = com.onesignal.OneSignal.pendingGetTagsHandlers
                            monitor-enter(r0)
                            java.util.ArrayList r1 = com.onesignal.OneSignal.pendingGetTagsHandlers     // Catch:{ all -> 0x0036 }
                            com.onesignal.OneSignal$GetTagsHandler r2 = r2     // Catch:{ all -> 0x0036 }
                            r1.add(r2)     // Catch:{ all -> 0x0036 }
                            java.util.ArrayList r1 = com.onesignal.OneSignal.pendingGetTagsHandlers     // Catch:{ all -> 0x0036 }
                            int r1 = r1.size()     // Catch:{ all -> 0x0036 }
                            r2 = 1
                            if (r1 <= r2) goto L_0x001b
                            monitor-exit(r0)     // Catch:{ all -> 0x0036 }
                            return
                        L_0x001b:
                            monitor-exit(r0)     // Catch:{ all -> 0x0036 }
                            android.content.Context r0 = com.onesignal.OneSignal.appContext
                            if (r0 != 0) goto L_0x0032
                            com.onesignal.OneSignal$LOG_LEVEL r0 = com.onesignal.OneSignal.LOG_LEVEL.ERROR
                            java.lang.String r1 = "You must initialize OneSignal before getting tags! Moving this tag operation to a pending queue."
                            com.onesignal.OneSignal.Log(r0, r1)
                            java.util.concurrent.ConcurrentLinkedQueue<java.lang.Runnable> r0 = com.onesignal.OneSignal.taskQueueWaitingForInit
                            com.onesignal.OneSignal$14$1 r1 = new com.onesignal.OneSignal$14$1
                            r1.<init>()
                            r0.add(r1)
                            return
                        L_0x0032:
                            com.onesignal.OneSignal.runGetTags()
                            return
                        L_0x0036:
                            r1 = move-exception
                            monitor-exit(r0)     // Catch:{ all -> 0x0036 }
                            throw r1
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.OneSignal.C241114.run():void");
                    }
                }, "OS_GETTAGS").start();
            }
        }
    }

    /* access modifiers changed from: private */
    public static void runGetTags() {
        if (getUserId() != null) {
            internalFireGetTagsCallbacks();
        }
    }

    private static void internalFireGetTagsCallbacks() {
        synchronized (pendingGetTagsHandlers) {
            if (pendingGetTagsHandlers.size() != 0) {
                new Thread(new Runnable() {
                    public void run() {
                        JSONObject jSONObject;
                        UserStateSynchronizer.GetTagsResult tags = OneSignalStateSynchronizer.getTags(!OneSignal.getTagsCall);
                        if (tags.serverSuccess) {
                            boolean unused = OneSignal.getTagsCall = true;
                        }
                        synchronized (OneSignal.pendingGetTagsHandlers) {
                            Iterator it = OneSignal.pendingGetTagsHandlers.iterator();
                            while (it.hasNext()) {
                                GetTagsHandler getTagsHandler = (GetTagsHandler) it.next();
                                if (tags.result != null) {
                                    if (!tags.toString().equals("{}")) {
                                        jSONObject = tags.result;
                                        getTagsHandler.tagsAvailable(jSONObject);
                                    }
                                }
                                jSONObject = null;
                                getTagsHandler.tagsAvailable(jSONObject);
                            }
                            OneSignal.pendingGetTagsHandlers.clear();
                        }
                    }
                }, "OS_GETTAGS_CALLBACK").start();
            }
        }
    }

    public static void deleteTag(String str) {
        deleteTag(str, (ChangeTagsUpdateHandler) null);
    }

    public static void deleteTag(String str, ChangeTagsUpdateHandler changeTagsUpdateHandler) {
        if (!shouldLogUserPrivacyConsentErrorMessageForMethodName("deleteTag()")) {
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(str);
            deleteTags((Collection<String>) arrayList, changeTagsUpdateHandler);
        }
    }

    public static void deleteTags(Collection<String> collection) {
        deleteTags(collection, (ChangeTagsUpdateHandler) null);
    }

    public static void deleteTags(Collection<String> collection, ChangeTagsUpdateHandler changeTagsUpdateHandler) {
        if (!shouldLogUserPrivacyConsentErrorMessageForMethodName("deleteTags()")) {
            try {
                JSONObject jSONObject = new JSONObject();
                for (String put : collection) {
                    jSONObject.put(put, "");
                }
                sendTags(jSONObject, changeTagsUpdateHandler);
            } catch (Throwable th) {
                Log(LOG_LEVEL.ERROR, "Failed to generate JSON for deleteTags.", th);
            }
        }
    }

    public static void deleteTags(String str) {
        deleteTags(str, (ChangeTagsUpdateHandler) null);
    }

    public static void deleteTags(String str, ChangeTagsUpdateHandler changeTagsUpdateHandler) {
        try {
            deleteTags(new JSONArray(str), changeTagsUpdateHandler);
        } catch (Throwable th) {
            Log(LOG_LEVEL.ERROR, "Failed to generate JSON for deleteTags.", th);
        }
    }

    public static void deleteTags(JSONArray jSONArray, ChangeTagsUpdateHandler changeTagsUpdateHandler) {
        if (!shouldLogUserPrivacyConsentErrorMessageForMethodName("deleteTags()")) {
            try {
                JSONObject jSONObject = new JSONObject();
                for (int i = 0; i < jSONArray.length(); i++) {
                    jSONObject.put(jSONArray.getString(i), "");
                }
                sendTags(jSONObject, changeTagsUpdateHandler);
            } catch (Throwable th) {
                Log(LOG_LEVEL.ERROR, "Failed to generate JSON for deleteTags.", th);
            }
        }
    }

    public static void idsAvailable(IdsAvailableHandler idsAvailableHandler2) {
        if (!shouldLogUserPrivacyConsentErrorMessageForMethodName("idsAvailable()")) {
            idsAvailableHandler = idsAvailableHandler2;
            C241416 r2 = new Runnable() {
                public void run() {
                    if (OneSignal.getUserId() != null) {
                        OSUtils.runOnMainUIThread(new Runnable() {
                            public void run() {
                                OneSignal.internalFireIdsAvailableCallback();
                            }
                        });
                    }
                }
            };
            if (appContext == null || shouldRunTaskThroughQueue()) {
                Log(LOG_LEVEL.ERROR, "You must initialize OneSignal before getting tags! Moving this tag operation to a pending queue.");
                addTaskToQueue(new PendingTaskRunnable(r2));
                return;
            }
            r2.run();
        }
    }

    static void fireIdsAvailableCallback() {
        if (idsAvailableHandler != null) {
            OSUtils.runOnMainUIThread(new Runnable() {
                public void run() {
                    OneSignal.internalFireIdsAvailableCallback();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0027, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void internalFireIdsAvailableCallback() {
        /*
            java.lang.Class<com.onesignal.OneSignal> r0 = com.onesignal.OneSignal.class
            monitor-enter(r0)
            com.onesignal.OneSignal$IdsAvailableHandler r1 = idsAvailableHandler     // Catch:{ all -> 0x0028 }
            if (r1 != 0) goto L_0x0009
            monitor-exit(r0)
            return
        L_0x0009:
            java.lang.String r1 = com.onesignal.OneSignalStateSynchronizer.getRegistrationId()     // Catch:{ all -> 0x0028 }
            boolean r2 = com.onesignal.OneSignalStateSynchronizer.getSubscribed()     // Catch:{ all -> 0x0028 }
            r3 = 0
            if (r2 != 0) goto L_0x0015
            r1 = r3
        L_0x0015:
            java.lang.String r2 = getUserId()     // Catch:{ all -> 0x0028 }
            if (r2 != 0) goto L_0x001d
            monitor-exit(r0)
            return
        L_0x001d:
            com.onesignal.OneSignal$IdsAvailableHandler r4 = idsAvailableHandler     // Catch:{ all -> 0x0028 }
            r4.idsAvailable(r2, r1)     // Catch:{ all -> 0x0028 }
            if (r1 == 0) goto L_0x0026
            idsAvailableHandler = r3     // Catch:{ all -> 0x0028 }
        L_0x0026:
            monitor-exit(r0)
            return
        L_0x0028:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.OneSignal.internalFireIdsAvailableCallback():void");
    }

    static void sendPurchases(JSONArray jSONArray, boolean z, OneSignalRestClient.ResponseHandler responseHandler) {
        if (!shouldLogUserPrivacyConsentErrorMessageForMethodName("sendPurchases()")) {
            if (getUserId() == null) {
                iapUpdateJob = new IAPUpdateJob(jSONArray);
                iapUpdateJob.newAsExisting = z;
                iapUpdateJob.restResponseHandler = responseHandler;
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("app_id", getSavedAppId());
                if (z) {
                    jSONObject.put("existing", true);
                }
                jSONObject.put("purchases", jSONArray);
                OneSignalRestClient.post("players/" + getUserId() + "/on_purchase", jSONObject, responseHandler);
                if (getEmailId() != null) {
                    OneSignalRestClient.post("players/" + getEmailId() + "/on_purchase", jSONObject, (OneSignalRestClient.ResponseHandler) null);
                }
            } catch (Throwable th) {
                Log(LOG_LEVEL.ERROR, "Failed to generate JSON for sendPurchases.", th);
            }
        }
    }

    private static boolean openURLFromNotification(Context context, JSONArray jSONArray) {
        String optString;
        if (shouldLogUserPrivacyConsentErrorMessageForMethodName((String) null)) {
            return false;
        }
        int length = jSONArray.length();
        boolean z = false;
        for (int i = 0; i < length; i++) {
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                if (jSONObject.has(OSNotificationFormatHelper.PAYLOAD_OS_ROOT_CUSTOM)) {
                    JSONObject jSONObject2 = new JSONObject(jSONObject.optString(OSNotificationFormatHelper.PAYLOAD_OS_ROOT_CUSTOM));
                    if (jSONObject2.has("u") && (optString = jSONObject2.optString("u", (String) null)) != null) {
                        OSUtils.openURLInBrowser(optString);
                        z = true;
                    }
                }
            } catch (Throwable th) {
                LOG_LEVEL log_level = LOG_LEVEL.ERROR;
                Log(log_level, "Error parsing JSON item " + i + "/" + length + " for launching a web URL.", th);
            }
        }
        return z;
    }

    private static void runNotificationOpenedCallback(JSONArray jSONArray, boolean z, boolean z2) {
        if (mInitBuilder == null || mInitBuilder.mNotificationOpenedHandler == null) {
            unprocessedOpenedNotifis.add(jSONArray);
        } else {
            fireNotificationOpenedHandler(generateOsNotificationOpenResult(jSONArray, z, z2));
        }
    }

    @NonNull
    private static OSNotificationOpenResult generateOsNotificationOpenResult(JSONArray jSONArray, boolean z, boolean z2) {
        int length = jSONArray.length();
        OSNotificationOpenResult oSNotificationOpenResult = new OSNotificationOpenResult();
        OSNotification oSNotification = new OSNotification();
        oSNotification.isAppInFocus = isAppActive();
        oSNotification.shown = z;
        oSNotification.androidNotificationId = jSONArray.optJSONObject(0).optInt(GenerateNotification.BUNDLE_KEY_ANDROID_NOTIFICATION_ID);
        String str = null;
        boolean z3 = true;
        for (int i = 0; i < length; i++) {
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                oSNotification.payload = NotificationBundleProcessor.OSNotificationPayloadFrom(jSONObject);
                if (str == null && jSONObject.has(GenerateNotification.BUNDLE_KEY_ACTION_ID)) {
                    str = jSONObject.optString(GenerateNotification.BUNDLE_KEY_ACTION_ID, (String) null);
                }
                if (z3) {
                    z3 = false;
                } else {
                    if (oSNotification.groupedNotifications == null) {
                        oSNotification.groupedNotifications = new ArrayList();
                    }
                    oSNotification.groupedNotifications.add(oSNotification.payload);
                }
            } catch (Throwable th) {
                Log(LOG_LEVEL.ERROR, "Error parsing JSON item " + i + "/" + length + " for callback.", th);
            }
        }
        oSNotificationOpenResult.notification = oSNotification;
        oSNotificationOpenResult.action = new OSNotificationAction();
        oSNotificationOpenResult.action.actionID = str;
        oSNotificationOpenResult.action.type = str != null ? OSNotificationAction.ActionType.ActionTaken : OSNotificationAction.ActionType.Opened;
        if (z2) {
            oSNotificationOpenResult.notification.displayType = OSNotification.DisplayType.InAppAlert;
        } else {
            oSNotificationOpenResult.notification.displayType = OSNotification.DisplayType.Notification;
        }
        return oSNotificationOpenResult;
    }

    private static void fireNotificationOpenedHandler(final OSNotificationOpenResult oSNotificationOpenResult) {
        OSUtils.runOnMainUIThread(new Runnable() {
            public void run() {
                OneSignal.mInitBuilder.mNotificationOpenedHandler.notificationOpened(oSNotificationOpenResult);
            }
        });
    }

    static void handleNotificationReceived(JSONArray jSONArray, boolean z, boolean z2) {
        OSNotificationOpenResult generateOsNotificationOpenResult = generateOsNotificationOpenResult(jSONArray, z, z2);
        if (trackFirebaseAnalytics != null && getFirebaseAnalyticsEnabled()) {
            trackFirebaseAnalytics.trackReceivedEvent(generateOsNotificationOpenResult);
        }
        if (mInitBuilder != null && mInitBuilder.mNotificationReceivedHandler != null) {
            mInitBuilder.mNotificationReceivedHandler.notificationReceived(generateOsNotificationOpenResult.notification);
        }
    }

    public static void handleNotificationOpen(Context context, JSONArray jSONArray, boolean z, @Nullable String str) {
        if (!shouldLogUserPrivacyConsentErrorMessageForMethodName((String) null)) {
            notificationOpenedRESTCall(context, jSONArray);
            if (trackFirebaseAnalytics != null && getFirebaseAnalyticsEnabled()) {
                trackFirebaseAnalytics.trackOpenedEvent(generateOsNotificationOpenResult(jSONArray, true, z));
            }
            boolean z2 = false;
            boolean equals = "DISABLE".equals(OSUtils.getManifestMeta(context, "com.onesignal.NotificationOpened.DEFAULT"));
            if (!equals) {
                z2 = openURLFromNotification(context, jSONArray);
            }
            if (shouldInitDirectSessionFromNotificationOpen(context, z, z2, equals)) {
                appEntryState = AppEntryAction.NOTIFICATION_CLICK;
                sessionManager.onDirectInfluenceFromNotificationOpen(appEntryState, str);
            }
            runNotificationOpenedCallback(jSONArray, true, z);
        }
    }

    static boolean startOrResumeApp(Context context) {
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
        if (launchIntentForPackage == null) {
            return false;
        }
        launchIntentForPackage.setFlags(268566528);
        context.startActivity(launchIntentForPackage);
        return true;
    }

    private static boolean shouldInitDirectSessionFromNotificationOpen(Context context, boolean z, boolean z2, boolean z3) {
        return !z && !z2 && !z3 && !foreground && startOrResumeApp(context);
    }

    private static void notificationOpenedRESTCall(Context context, JSONArray jSONArray) {
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                String optString = new JSONObject(jSONArray.getJSONObject(i).optString(OSNotificationFormatHelper.PAYLOAD_OS_ROOT_CUSTOM, (String) null)).optString("i", (String) null);
                if (!postedOpenedNotifIds.contains(optString)) {
                    postedOpenedNotifIds.add(optString);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("app_id", getSavedAppId(context));
                    jSONObject.put("player_id", getSavedUserId(context));
                    jSONObject.put(OneSignalDbContract.NotificationTable.COLUMN_NAME_OPENED, true);
                    jSONObject.put("device_type", osUtils.getDeviceType());
                    OneSignalRestClient.put("notifications/" + optString, jSONObject, new OneSignalRestClient.ResponseHandler() {
                        /* access modifiers changed from: package-private */
                        public void onFailure(int i, String str, Throwable th) {
                            OneSignal.logHttpError("sending Notification Opened Failed", i, th, str);
                        }
                    });
                }
            } catch (Throwable th) {
                Log(LOG_LEVEL.ERROR, "Failed to generate JSON to send notification opened.", th);
            }
        }
    }

    private static void saveAppId(String str) {
        if (appContext != null) {
            OneSignalPrefs.saveString(OneSignalPrefs.PREFS_ONESIGNAL, OneSignalPrefs.PREFS_GT_APP_ID, str);
        }
    }

    static String getSavedAppId() {
        return getSavedAppId(appContext);
    }

    private static String getSavedAppId(Context context) {
        if (context == null) {
            return null;
        }
        return OneSignalPrefs.getString(OneSignalPrefs.PREFS_ONESIGNAL, OneSignalPrefs.PREFS_GT_APP_ID, (String) null);
    }

    static boolean getSavedUserConsentStatus() {
        return OneSignalPrefs.getBool(OneSignalPrefs.PREFS_ONESIGNAL, OneSignalPrefs.PREFS_ONESIGNAL_USER_PROVIDED_CONSENT, false);
    }

    static void saveUserConsentStatus(boolean z) {
        OneSignalPrefs.saveBool(OneSignalPrefs.PREFS_ONESIGNAL, OneSignalPrefs.PREFS_ONESIGNAL_USER_PROVIDED_CONSENT, z);
    }

    private static String getSavedUserId(Context context) {
        if (context == null) {
            return null;
        }
        return OneSignalPrefs.getString(OneSignalPrefs.PREFS_ONESIGNAL, OneSignalPrefs.PREFS_GT_PLAYER_ID, (String) null);
    }

    static boolean hasUserId() {
        return getUserId() != null;
    }

    static String getUserId() {
        if (userId == null && appContext != null) {
            userId = getSavedUserId(appContext);
        }
        return userId;
    }

    static void saveUserId(String str) {
        userId = str;
        if (appContext != null) {
            OneSignalPrefs.saveString(OneSignalPrefs.PREFS_ONESIGNAL, OneSignalPrefs.PREFS_GT_PLAYER_ID, userId);
        }
    }

    static boolean hasEmailId() {
        return !TextUtils.isEmpty(emailId);
    }

    static String getEmailId() {
        if (TextUtils.isEmpty(emailId) && appContext != null) {
            emailId = OneSignalPrefs.getString(OneSignalPrefs.PREFS_ONESIGNAL, OneSignalPrefs.PREFS_OS_EMAIL_ID, (String) null);
        }
        return emailId;
    }

    static void saveEmailId(String str) {
        emailId = str;
        if (appContext != null) {
            OneSignalPrefs.saveString(OneSignalPrefs.PREFS_ONESIGNAL, OneSignalPrefs.PREFS_OS_EMAIL_ID, "".equals(emailId) ? null : emailId);
        }
    }

    static boolean getFilterOtherGCMReceivers(Context context) {
        return OneSignalPrefs.getBool(OneSignalPrefs.PREFS_ONESIGNAL, OneSignalPrefs.PREFS_OS_FILTER_OTHER_GCM_RECEIVERS, false);
    }

    static void saveFilterOtherGCMReceivers(boolean z) {
        if (appContext != null) {
            OneSignalPrefs.saveBool(OneSignalPrefs.PREFS_ONESIGNAL, OneSignalPrefs.PREFS_OS_FILTER_OTHER_GCM_RECEIVERS, z);
        }
    }

    static void updateUserIdDependents(String str) {
        saveUserId(str);
        fireIdsAvailableCallback();
        internalFireGetTagsCallbacks();
        getCurrentSubscriptionState(appContext).setUserId(str);
        if (iapUpdateJob != null) {
            sendPurchases(iapUpdateJob.toReport, iapUpdateJob.newAsExisting, iapUpdateJob.restResponseHandler);
            iapUpdateJob = null;
        }
        OneSignalStateSynchronizer.refreshEmailState();
        OneSignalChromeTabAndroidFrame.setup(appId, str, AdvertisingIdProviderGPS.getLastValue());
    }

    static void updateEmailIdDependents(String str) {
        saveEmailId(str);
        getCurrentEmailSubscriptionState(appContext).setEmailUserId(str);
        try {
            OneSignalStateSynchronizer.updatePushState(new JSONObject().put("parent_player_id", str));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    static boolean getFirebaseAnalyticsEnabled() {
        return OneSignalPrefs.getBool(OneSignalPrefs.PREFS_ONESIGNAL, OneSignalPrefs.PREFS_GT_FIREBASE_TRACKING_ENABLED, false);
    }

    static boolean getClearGroupSummaryClick() {
        return OneSignalPrefs.getBool(OneSignalPrefs.PREFS_ONESIGNAL, OneSignalPrefs.PREFS_OS_CLEAR_GROUP_SUMMARY_CLICK, true);
    }

    public static void enableVibrate(boolean z) {
        if (appContext != null) {
            OneSignalPrefs.saveBool(OneSignalPrefs.PREFS_ONESIGNAL, OneSignalPrefs.PREFS_GT_VIBRATE_ENABLED, z);
        }
    }

    static boolean getVibrate() {
        return OneSignalPrefs.getBool(OneSignalPrefs.PREFS_ONESIGNAL, OneSignalPrefs.PREFS_GT_VIBRATE_ENABLED, true);
    }

    public static void enableSound(boolean z) {
        if (appContext != null) {
            OneSignalPrefs.saveBool(OneSignalPrefs.PREFS_ONESIGNAL, OneSignalPrefs.PREFS_GT_SOUND_ENABLED, z);
        }
    }

    static boolean getSoundEnabled() {
        return OneSignalPrefs.getBool(OneSignalPrefs.PREFS_ONESIGNAL, OneSignalPrefs.PREFS_GT_SOUND_ENABLED, true);
    }

    static void setLastSessionTime(long j) {
        OneSignalPrefs.saveLong(OneSignalPrefs.PREFS_ONESIGNAL, OneSignalPrefs.PREFS_OS_LAST_SESSION_TIME, j);
    }

    private static long getLastSessionTime() {
        return OneSignalPrefs.getLong(OneSignalPrefs.PREFS_ONESIGNAL, OneSignalPrefs.PREFS_OS_LAST_SESSION_TIME, -31000);
    }

    public static void setInFocusDisplaying(OSInFocusDisplayOption oSInFocusDisplayOption) {
        mInitBuilder.mDisplayOptionCarryOver = true;
        mInitBuilder.mDisplayOption = oSInFocusDisplayOption;
    }

    public static void setInFocusDisplaying(int i) {
        setInFocusDisplaying(getInFocusDisplaying(i));
    }

    public static OSInFocusDisplayOption currentInFocusDisplayOption() {
        return mInitBuilder.mDisplayOption;
    }

    private static OSInFocusDisplayOption getInFocusDisplaying(int i) {
        switch (i) {
            case 0:
                return OSInFocusDisplayOption.None;
            case 1:
                return OSInFocusDisplayOption.InAppAlert;
            case 2:
                return OSInFocusDisplayOption.Notification;
            default:
                if (i < 0) {
                    return OSInFocusDisplayOption.None;
                }
                return OSInFocusDisplayOption.Notification;
        }
    }

    static boolean getNotificationsWhenActiveEnabled() {
        if (mInitBuilder == null || mInitBuilder.mDisplayOption == OSInFocusDisplayOption.Notification) {
            return true;
        }
        return false;
    }

    static boolean getInAppAlertNotificationEnabled() {
        if (mInitBuilder != null && mInitBuilder.mDisplayOption == OSInFocusDisplayOption.InAppAlert) {
            return true;
        }
        return false;
    }

    public static void setSubscription(final boolean z) {
        if (!shouldLogUserPrivacyConsentErrorMessageForMethodName("setSubscription()")) {
            C242020 r0 = new Runnable() {
                public void run() {
                    OneSignal.getCurrentSubscriptionState(OneSignal.appContext).setUserSubscriptionSetting(z);
                    OneSignalStateSynchronizer.setSubscription(z);
                }
            };
            if (appContext == null || shouldRunTaskThroughQueue()) {
                Log(LOG_LEVEL.ERROR, "OneSignal.init has not been called. Moving subscription action to a waiting task queue.");
                addTaskToQueue(new PendingTaskRunnable(r0));
                return;
            }
            r0.run();
        }
    }

    public static void setLocationShared(boolean z) {
        if (!shouldLogUserPrivacyConsentErrorMessageForMethodName("setLocationShared()")) {
            shareLocation = z;
            if (!z) {
                OneSignalStateSynchronizer.clearLocation();
            }
            LOG_LEVEL log_level = LOG_LEVEL.DEBUG;
            Log(log_level, "shareLocation:" + shareLocation);
        }
    }

    public static void promptLocation() {
        promptLocation((OSPromptActionCompletionCallback) null, false);
    }

    static void promptLocation(@Nullable final OSPromptActionCompletionCallback oSPromptActionCompletionCallback, final boolean z) {
        if (!shouldLogUserPrivacyConsentErrorMessageForMethodName("promptLocation()")) {
            C242121 r0 = new Runnable() {
                public void run() {
                    LocationController.getLocation(OneSignal.appContext, true, z, new LocationController.LocationPromptCompletionHandler() {
                        public LocationController.PermissionType getType() {
                            return LocationController.PermissionType.PROMPT_LOCATION;
                        }

                        public void onComplete(LocationController.LocationPoint locationPoint) {
                            if (!OneSignal.shouldLogUserPrivacyConsentErrorMessageForMethodName("promptLocation()") && locationPoint != null) {
                                OneSignalStateSynchronizer.updateLocation(locationPoint);
                            }
                        }

                        /* access modifiers changed from: package-private */
                        public void onAnswered(PromptActionResult promptActionResult) {
                            super.onAnswered(promptActionResult);
                            if (oSPromptActionCompletionCallback != null) {
                                oSPromptActionCompletionCallback.onCompleted(promptActionResult);
                            }
                        }
                    });
                    boolean unused = OneSignal.promptedLocation = true;
                }
            };
            if (appContext == null || shouldRunTaskThroughQueue()) {
                Log(LOG_LEVEL.ERROR, "OneSignal.init has not been called. Could not prompt for location at this time - moving this operation to awaiting queue.");
                addTaskToQueue(new PendingTaskRunnable(r0));
                return;
            }
            r0.run();
        }
    }

    public static void clearOneSignalNotifications() {
        C242322 r0 = new Runnable() {
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v4, resolved type: android.database.sqlite.SQLiteDatabase} */
            /* JADX WARNING: type inference failed for: r2v0 */
            /* JADX WARNING: type inference failed for: r2v1, types: [android.database.Cursor] */
            /* JADX WARNING: type inference failed for: r2v2 */
            /* JADX WARNING: type inference failed for: r2v7 */
            /* JADX WARNING: Code restructure failed: missing block: B:15:0x0062, code lost:
                r0 = th;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
                r1 = com.onesignal.OneSignal.LOG_LEVEL.ERROR;
                r2 = "Error closing transaction! ";
             */
            /* JADX WARNING: Code restructure failed: missing block: B:30:0x0081, code lost:
                r0 = th;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:32:?, code lost:
                r1 = com.onesignal.OneSignal.LOG_LEVEL.ERROR;
                r2 = "Error closing transaction! ";
             */
            /* JADX WARNING: Code restructure failed: missing block: B:43:0x00a2, code lost:
                r0 = th;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:44:0x00a4, code lost:
                r0 = th;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:45:0x00a5, code lost:
                r2 = r3;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:52:0x00b4, code lost:
                r2.close();
             */
            /* JADX WARNING: Code restructure failed: missing block: B:54:0x00ba, code lost:
                r3.close();
             */
            /* JADX WARNING: Code restructure failed: missing block: B:56:?, code lost:
                return;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:59:?, code lost:
                return;
             */
            /* JADX WARNING: Failed to process nested try/catch */
            /* JADX WARNING: Multi-variable type inference failed */
            /* JADX WARNING: Removed duplicated region for block: B:28:0x007d A[SYNTHETIC, Splitter:B:28:0x007d] */
            /* JADX WARNING: Removed duplicated region for block: B:35:0x008f  */
            /* JADX WARNING: Removed duplicated region for block: B:37:0x0095 A[SYNTHETIC, Splitter:B:37:0x0095] */
            /* JADX WARNING: Removed duplicated region for block: B:43:0x00a2 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:3:0x0023] */
            /* JADX WARNING: Removed duplicated region for block: B:52:0x00b4  */
            /* JADX WARNING: Removed duplicated region for block: B:54:0x00ba  */
            /* JADX WARNING: Removed duplicated region for block: B:57:? A[RETURN, SYNTHETIC] */
            /* JADX WARNING: Removed duplicated region for block: B:59:? A[RETURN, SYNTHETIC] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void run() {
                /*
                    r11 = this;
                    android.content.Context r0 = com.onesignal.OneSignal.appContext
                    android.app.NotificationManager r0 = com.onesignal.OneSignalNotificationManager.getNotificationManager(r0)
                    android.content.Context r1 = com.onesignal.OneSignal.appContext
                    com.onesignal.OneSignalDbHelper r1 = com.onesignal.OneSignalDbHelper.getInstance(r1)
                    r2 = 0
                    android.database.sqlite.SQLiteDatabase r3 = r1.getSQLiteDatabaseWithRetries()     // Catch:{ Throwable -> 0x00aa }
                    java.lang.String r4 = "android_notification_id"
                    java.lang.String[] r5 = new java.lang.String[]{r4}     // Catch:{ Throwable -> 0x00aa }
                    java.lang.String r4 = "notification"
                    java.lang.String r6 = "dismissed = 0 AND opened = 0"
                    r7 = 0
                    r8 = 0
                    r9 = 0
                    r10 = 0
                    android.database.Cursor r3 = r3.query(r4, r5, r6, r7, r8, r9, r10)     // Catch:{ Throwable -> 0x00aa }
                    boolean r4 = r3.moveToFirst()     // Catch:{ Throwable -> 0x00a4, all -> 0x00a2 }
                    if (r4 == 0) goto L_0x003c
                L_0x0029:
                    java.lang.String r4 = "android_notification_id"
                    int r4 = r3.getColumnIndex(r4)     // Catch:{ Throwable -> 0x00a4, all -> 0x00a2 }
                    int r4 = r3.getInt(r4)     // Catch:{ Throwable -> 0x00a4, all -> 0x00a2 }
                    r0.cancel(r4)     // Catch:{ Throwable -> 0x00a4, all -> 0x00a2 }
                    boolean r4 = r3.moveToNext()     // Catch:{ Throwable -> 0x00a4, all -> 0x00a2 }
                    if (r4 != 0) goto L_0x0029
                L_0x003c:
                    android.database.sqlite.SQLiteDatabase r0 = r1.getSQLiteDatabaseWithRetries()     // Catch:{ Throwable -> 0x0073 }
                    r0.beginTransaction()     // Catch:{ Throwable -> 0x006d, all -> 0x006b }
                    java.lang.String r1 = "opened = 0"
                    android.content.ContentValues r4 = new android.content.ContentValues     // Catch:{ Throwable -> 0x006d, all -> 0x006b }
                    r4.<init>()     // Catch:{ Throwable -> 0x006d, all -> 0x006b }
                    java.lang.String r5 = "dismissed"
                    r6 = 1
                    java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ Throwable -> 0x006d, all -> 0x006b }
                    r4.put(r5, r6)     // Catch:{ Throwable -> 0x006d, all -> 0x006b }
                    java.lang.String r5 = "notification"
                    r0.update(r5, r4, r1, r2)     // Catch:{ Throwable -> 0x006d, all -> 0x006b }
                    r0.setTransactionSuccessful()     // Catch:{ Throwable -> 0x006d, all -> 0x006b }
                    if (r0 == 0) goto L_0x0087
                    r0.endTransaction()     // Catch:{ Throwable -> 0x0062, all -> 0x00a2 }
                    goto L_0x0087
                L_0x0062:
                    r0 = move-exception
                    com.onesignal.OneSignal$LOG_LEVEL r1 = com.onesignal.OneSignal.LOG_LEVEL.ERROR     // Catch:{ Throwable -> 0x00a4, all -> 0x00a2 }
                    java.lang.String r2 = "Error closing transaction! "
                L_0x0067:
                    com.onesignal.OneSignal.Log(r1, r2, r0)     // Catch:{ Throwable -> 0x00a4, all -> 0x00a2 }
                    goto L_0x0087
                L_0x006b:
                    r1 = move-exception
                    goto L_0x0093
                L_0x006d:
                    r1 = move-exception
                    r2 = r0
                    goto L_0x0074
                L_0x0070:
                    r1 = move-exception
                    r0 = r2
                    goto L_0x0093
                L_0x0073:
                    r1 = move-exception
                L_0x0074:
                    com.onesignal.OneSignal$LOG_LEVEL r0 = com.onesignal.OneSignal.LOG_LEVEL.ERROR     // Catch:{ all -> 0x0070 }
                    java.lang.String r4 = "Error marking all notifications as dismissed! "
                    com.onesignal.OneSignal.Log(r0, r4, r1)     // Catch:{ all -> 0x0070 }
                    if (r2 == 0) goto L_0x0087
                    r2.endTransaction()     // Catch:{ Throwable -> 0x0081, all -> 0x00a2 }
                    goto L_0x0087
                L_0x0081:
                    r0 = move-exception
                    com.onesignal.OneSignal$LOG_LEVEL r1 = com.onesignal.OneSignal.LOG_LEVEL.ERROR     // Catch:{ Throwable -> 0x00a4, all -> 0x00a2 }
                    java.lang.String r2 = "Error closing transaction! "
                    goto L_0x0067
                L_0x0087:
                    r0 = 0
                    android.content.Context r1 = com.onesignal.OneSignal.appContext     // Catch:{ Throwable -> 0x00a4, all -> 0x00a2 }
                    com.onesignal.BadgeCountUpdater.updateCount(r0, r1)     // Catch:{ Throwable -> 0x00a4, all -> 0x00a2 }
                    if (r3 == 0) goto L_0x00b7
                    r3.close()
                    goto L_0x00b7
                L_0x0093:
                    if (r0 == 0) goto L_0x00a1
                    r0.endTransaction()     // Catch:{ Throwable -> 0x0099, all -> 0x00a2 }
                    goto L_0x00a1
                L_0x0099:
                    r0 = move-exception
                    com.onesignal.OneSignal$LOG_LEVEL r2 = com.onesignal.OneSignal.LOG_LEVEL.ERROR     // Catch:{ Throwable -> 0x00a4, all -> 0x00a2 }
                    java.lang.String r4 = "Error closing transaction! "
                    com.onesignal.OneSignal.Log(r2, r4, r0)     // Catch:{ Throwable -> 0x00a4, all -> 0x00a2 }
                L_0x00a1:
                    throw r1     // Catch:{ Throwable -> 0x00a4, all -> 0x00a2 }
                L_0x00a2:
                    r0 = move-exception
                    goto L_0x00b8
                L_0x00a4:
                    r0 = move-exception
                    r2 = r3
                    goto L_0x00ab
                L_0x00a7:
                    r0 = move-exception
                    r3 = r2
                    goto L_0x00b8
                L_0x00aa:
                    r0 = move-exception
                L_0x00ab:
                    com.onesignal.OneSignal$LOG_LEVEL r1 = com.onesignal.OneSignal.LOG_LEVEL.ERROR     // Catch:{ all -> 0x00a7 }
                    java.lang.String r3 = "Error canceling all notifications! "
                    com.onesignal.OneSignal.Log(r1, r3, r0)     // Catch:{ all -> 0x00a7 }
                    if (r2 == 0) goto L_0x00b7
                    r2.close()
                L_0x00b7:
                    return
                L_0x00b8:
                    if (r3 == 0) goto L_0x00bd
                    r3.close()
                L_0x00bd:
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.onesignal.OneSignal.C242322.run():void");
            }
        };
        if (appContext == null || shouldRunTaskThroughQueue()) {
            Log(LOG_LEVEL.ERROR, "OneSignal.init has not been called. Could not clear notifications at this time - moving this operation toa waiting task queue.");
            addTaskToQueue(new PendingTaskRunnable(r0));
            return;
        }
        r0.run();
    }

    public static void cancelNotification(final int i) {
        C242423 r0 = new Runnable() {
            /* JADX WARNING: Removed duplicated region for block: B:20:0x0092 A[SYNTHETIC, Splitter:B:20:0x0092] */
            /* JADX WARNING: Removed duplicated region for block: B:27:0x00ac A[SYNTHETIC, Splitter:B:27:0x00ac] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void run() {
                /*
                    r7 = this;
                    android.content.Context r0 = com.onesignal.OneSignal.appContext
                    com.onesignal.OneSignalDbHelper r0 = com.onesignal.OneSignalDbHelper.getInstance(r0)
                    r1 = 0
                    android.database.sqlite.SQLiteDatabase r0 = r0.getSQLiteDatabaseWithRetries()     // Catch:{ Throwable -> 0x006f, all -> 0x006a }
                    r0.beginTransaction()     // Catch:{ Throwable -> 0x0068 }
                    java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x0068 }
                    r2.<init>()     // Catch:{ Throwable -> 0x0068 }
                    java.lang.String r3 = "android_notification_id = "
                    r2.append(r3)     // Catch:{ Throwable -> 0x0068 }
                    int r3 = r4     // Catch:{ Throwable -> 0x0068 }
                    r2.append(r3)     // Catch:{ Throwable -> 0x0068 }
                    java.lang.String r3 = " AND "
                    r2.append(r3)     // Catch:{ Throwable -> 0x0068 }
                    java.lang.String r3 = "opened"
                    r2.append(r3)     // Catch:{ Throwable -> 0x0068 }
                    java.lang.String r3 = " = 0 AND "
                    r2.append(r3)     // Catch:{ Throwable -> 0x0068 }
                    java.lang.String r3 = "dismissed"
                    r2.append(r3)     // Catch:{ Throwable -> 0x0068 }
                    java.lang.String r3 = " = 0"
                    r2.append(r3)     // Catch:{ Throwable -> 0x0068 }
                    java.lang.String r2 = r2.toString()     // Catch:{ Throwable -> 0x0068 }
                    android.content.ContentValues r3 = new android.content.ContentValues     // Catch:{ Throwable -> 0x0068 }
                    r3.<init>()     // Catch:{ Throwable -> 0x0068 }
                    java.lang.String r4 = "dismissed"
                    r5 = 1
                    java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ Throwable -> 0x0068 }
                    r3.put(r4, r5)     // Catch:{ Throwable -> 0x0068 }
                    java.lang.String r4 = "notification"
                    int r1 = r0.update(r4, r3, r2, r1)     // Catch:{ Throwable -> 0x0068 }
                    if (r1 <= 0) goto L_0x0058
                    android.content.Context r1 = com.onesignal.OneSignal.appContext     // Catch:{ Throwable -> 0x0068 }
                    int r2 = r4     // Catch:{ Throwable -> 0x0068 }
                    com.onesignal.NotificationSummaryManager.updatePossibleDependentSummaryOnDismiss(r1, r0, r2)     // Catch:{ Throwable -> 0x0068 }
                L_0x0058:
                    android.content.Context r1 = com.onesignal.OneSignal.appContext     // Catch:{ Throwable -> 0x0068 }
                    com.onesignal.BadgeCountUpdater.update(r0, r1)     // Catch:{ Throwable -> 0x0068 }
                    r0.setTransactionSuccessful()     // Catch:{ Throwable -> 0x0068 }
                    if (r0 == 0) goto L_0x009e
                    r0.endTransaction()     // Catch:{ Throwable -> 0x0096 }
                    goto L_0x009e
                L_0x0066:
                    r1 = move-exception
                    goto L_0x00aa
                L_0x0068:
                    r1 = move-exception
                    goto L_0x0073
                L_0x006a:
                    r0 = move-exception
                    r6 = r1
                    r1 = r0
                    r0 = r6
                    goto L_0x00aa
                L_0x006f:
                    r0 = move-exception
                    r6 = r1
                    r1 = r0
                    r0 = r6
                L_0x0073:
                    com.onesignal.OneSignal$LOG_LEVEL r2 = com.onesignal.OneSignal.LOG_LEVEL.ERROR     // Catch:{ all -> 0x0066 }
                    java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0066 }
                    r3.<init>()     // Catch:{ all -> 0x0066 }
                    java.lang.String r4 = "Error marking a notification id "
                    r3.append(r4)     // Catch:{ all -> 0x0066 }
                    int r4 = r4     // Catch:{ all -> 0x0066 }
                    r3.append(r4)     // Catch:{ all -> 0x0066 }
                    java.lang.String r4 = " as dismissed! "
                    r3.append(r4)     // Catch:{ all -> 0x0066 }
                    java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0066 }
                    com.onesignal.OneSignal.Log(r2, r3, r1)     // Catch:{ all -> 0x0066 }
                    if (r0 == 0) goto L_0x009e
                    r0.endTransaction()     // Catch:{ Throwable -> 0x0096 }
                    goto L_0x009e
                L_0x0096:
                    r0 = move-exception
                    com.onesignal.OneSignal$LOG_LEVEL r1 = com.onesignal.OneSignal.LOG_LEVEL.ERROR
                    java.lang.String r2 = "Error closing transaction! "
                    com.onesignal.OneSignal.Log(r1, r2, r0)
                L_0x009e:
                    android.content.Context r0 = com.onesignal.OneSignal.appContext
                    android.app.NotificationManager r0 = com.onesignal.OneSignalNotificationManager.getNotificationManager(r0)
                    int r1 = r4
                    r0.cancel(r1)
                    return
                L_0x00aa:
                    if (r0 == 0) goto L_0x00b8
                    r0.endTransaction()     // Catch:{ Throwable -> 0x00b0 }
                    goto L_0x00b8
                L_0x00b0:
                    r0 = move-exception
                    com.onesignal.OneSignal$LOG_LEVEL r2 = com.onesignal.OneSignal.LOG_LEVEL.ERROR
                    java.lang.String r3 = "Error closing transaction! "
                    com.onesignal.OneSignal.Log(r2, r3, r0)
                L_0x00b8:
                    throw r1
                */
                throw new UnsupportedOperationException("Method not decompiled: com.onesignal.OneSignal.C242423.run():void");
            }
        };
        if (appContext == null || shouldRunTaskThroughQueue()) {
            LOG_LEVEL log_level = LOG_LEVEL.ERROR;
            Log(log_level, "OneSignal.init has not been called. Could not clear notification id: " + i + " at this time - movingthis operation to a waiting task queue. The notification will still be canceledfrom NotificationManager at this time.");
            taskQueueWaitingForInit.add(r0);
            return;
        }
        r0.run();
    }

    public static void cancelGroupedNotifications(final String str) {
        if (!shouldLogUserPrivacyConsentErrorMessageForMethodName("cancelGroupedNotifications()")) {
            C242524 r0 = new Runnable() {
                /* JADX WARNING: Code restructure failed: missing block: B:11:0x0047, code lost:
                    if (r5.isClosed() == false) goto L_0x0072;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:21:0x0070, code lost:
                    if (r5.isClosed() == false) goto L_0x0072;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:22:0x0072, code lost:
                    r5.close();
                 */
                /* JADX WARNING: Removed duplicated region for block: B:20:0x006c  */
                /* JADX WARNING: Removed duplicated region for block: B:28:0x00a1 A[SYNTHETIC, Splitter:B:28:0x00a1] */
                /* JADX WARNING: Removed duplicated region for block: B:39:0x00cd A[SYNTHETIC, Splitter:B:39:0x00cd] */
                /* JADX WARNING: Removed duplicated region for block: B:44:0x00dc A[SYNTHETIC, Splitter:B:44:0x00dc] */
                /* JADX WARNING: Removed duplicated region for block: B:60:? A[RETURN, SYNTHETIC] */
                /* JADX WARNING: Removed duplicated region for block: B:61:? A[RETURN, SYNTHETIC] */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public void run() {
                    /*
                        r13 = this;
                        android.content.Context r0 = com.onesignal.OneSignal.appContext
                        android.app.NotificationManager r0 = com.onesignal.OneSignalNotificationManager.getNotificationManager(r0)
                        android.content.Context r1 = com.onesignal.OneSignal.appContext
                        com.onesignal.OneSignalDbHelper r1 = com.onesignal.OneSignalDbHelper.getInstance(r1)
                        r2 = 0
                        r3 = 0
                        r4 = 1
                        android.database.sqlite.SQLiteDatabase r5 = r1.getSQLiteDatabaseWithRetries()     // Catch:{ Throwable -> 0x0050, all -> 0x004c }
                        java.lang.String r6 = "android_notification_id"
                        java.lang.String[] r7 = new java.lang.String[]{r6}     // Catch:{ Throwable -> 0x0050, all -> 0x004c }
                        java.lang.String r8 = "group_id = ? AND dismissed = 0 AND opened = 0"
                        java.lang.String[] r9 = new java.lang.String[r4]     // Catch:{ Throwable -> 0x0050, all -> 0x004c }
                        java.lang.String r6 = r4     // Catch:{ Throwable -> 0x0050, all -> 0x004c }
                        r9[r2] = r6     // Catch:{ Throwable -> 0x0050, all -> 0x004c }
                        java.lang.String r6 = "notification"
                        r10 = 0
                        r11 = 0
                        r12 = 0
                        android.database.Cursor r5 = r5.query(r6, r7, r8, r9, r10, r11, r12)     // Catch:{ Throwable -> 0x0050, all -> 0x004c }
                    L_0x002a:
                        boolean r6 = r5.moveToNext()     // Catch:{ Throwable -> 0x004a }
                        if (r6 == 0) goto L_0x0041
                        java.lang.String r6 = "android_notification_id"
                        int r6 = r5.getColumnIndex(r6)     // Catch:{ Throwable -> 0x004a }
                        int r6 = r5.getInt(r6)     // Catch:{ Throwable -> 0x004a }
                        r7 = -1
                        if (r6 == r7) goto L_0x002a
                        r0.cancel(r6)     // Catch:{ Throwable -> 0x004a }
                        goto L_0x002a
                    L_0x0041:
                        if (r5 == 0) goto L_0x0075
                        boolean r0 = r5.isClosed()
                        if (r0 != 0) goto L_0x0075
                        goto L_0x0072
                    L_0x004a:
                        r0 = move-exception
                        goto L_0x0052
                    L_0x004c:
                        r0 = move-exception
                        r5 = r3
                        goto L_0x00ea
                    L_0x0050:
                        r0 = move-exception
                        r5 = r3
                    L_0x0052:
                        com.onesignal.OneSignal$LOG_LEVEL r6 = com.onesignal.OneSignal.LOG_LEVEL.ERROR     // Catch:{ all -> 0x00e9 }
                        java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x00e9 }
                        r7.<init>()     // Catch:{ all -> 0x00e9 }
                        java.lang.String r8 = "Error getting android notifications part of group: "
                        r7.append(r8)     // Catch:{ all -> 0x00e9 }
                        java.lang.String r8 = r4     // Catch:{ all -> 0x00e9 }
                        r7.append(r8)     // Catch:{ all -> 0x00e9 }
                        java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x00e9 }
                        com.onesignal.OneSignal.Log(r6, r7, r0)     // Catch:{ all -> 0x00e9 }
                        if (r5 == 0) goto L_0x0075
                        boolean r0 = r5.isClosed()
                        if (r0 != 0) goto L_0x0075
                    L_0x0072:
                        r5.close()
                    L_0x0075:
                        android.database.sqlite.SQLiteDatabase r0 = r1.getSQLiteDatabaseWithRetries()     // Catch:{ Throwable -> 0x00ad }
                        r0.beginTransaction()     // Catch:{ Throwable -> 0x00a7, all -> 0x00a5 }
                        java.lang.String r1 = "group_id = ? AND opened = 0 AND dismissed = 0"
                        java.lang.String[] r3 = new java.lang.String[r4]     // Catch:{ Throwable -> 0x00a7, all -> 0x00a5 }
                        java.lang.String r5 = r4     // Catch:{ Throwable -> 0x00a7, all -> 0x00a5 }
                        r3[r2] = r5     // Catch:{ Throwable -> 0x00a7, all -> 0x00a5 }
                        android.content.ContentValues r2 = new android.content.ContentValues     // Catch:{ Throwable -> 0x00a7, all -> 0x00a5 }
                        r2.<init>()     // Catch:{ Throwable -> 0x00a7, all -> 0x00a5 }
                        java.lang.String r5 = "dismissed"
                        java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ Throwable -> 0x00a7, all -> 0x00a5 }
                        r2.put(r5, r4)     // Catch:{ Throwable -> 0x00a7, all -> 0x00a5 }
                        java.lang.String r4 = "notification"
                        r0.update(r4, r2, r1, r3)     // Catch:{ Throwable -> 0x00a7, all -> 0x00a5 }
                        android.content.Context r1 = com.onesignal.OneSignal.appContext     // Catch:{ Throwable -> 0x00a7, all -> 0x00a5 }
                        com.onesignal.BadgeCountUpdater.update(r0, r1)     // Catch:{ Throwable -> 0x00a7, all -> 0x00a5 }
                        r0.setTransactionSuccessful()     // Catch:{ Throwable -> 0x00a7, all -> 0x00a5 }
                        if (r0 == 0) goto L_0x00d9
                        r0.endTransaction()     // Catch:{ Throwable -> 0x00d1 }
                        goto L_0x00d9
                    L_0x00a5:
                        r1 = move-exception
                        goto L_0x00da
                    L_0x00a7:
                        r1 = move-exception
                        r3 = r0
                        goto L_0x00ae
                    L_0x00aa:
                        r1 = move-exception
                        r0 = r3
                        goto L_0x00da
                    L_0x00ad:
                        r1 = move-exception
                    L_0x00ae:
                        com.onesignal.OneSignal$LOG_LEVEL r0 = com.onesignal.OneSignal.LOG_LEVEL.ERROR     // Catch:{ all -> 0x00aa }
                        java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x00aa }
                        r2.<init>()     // Catch:{ all -> 0x00aa }
                        java.lang.String r4 = "Error marking a notifications with group "
                        r2.append(r4)     // Catch:{ all -> 0x00aa }
                        java.lang.String r4 = r4     // Catch:{ all -> 0x00aa }
                        r2.append(r4)     // Catch:{ all -> 0x00aa }
                        java.lang.String r4 = " as dismissed! "
                        r2.append(r4)     // Catch:{ all -> 0x00aa }
                        java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x00aa }
                        com.onesignal.OneSignal.Log(r0, r2, r1)     // Catch:{ all -> 0x00aa }
                        if (r3 == 0) goto L_0x00d9
                        r3.endTransaction()     // Catch:{ Throwable -> 0x00d1 }
                        goto L_0x00d9
                    L_0x00d1:
                        r0 = move-exception
                        com.onesignal.OneSignal$LOG_LEVEL r1 = com.onesignal.OneSignal.LOG_LEVEL.ERROR
                        java.lang.String r2 = "Error closing transaction! "
                        com.onesignal.OneSignal.Log(r1, r2, r0)
                    L_0x00d9:
                        return
                    L_0x00da:
                        if (r0 == 0) goto L_0x00e8
                        r0.endTransaction()     // Catch:{ Throwable -> 0x00e0 }
                        goto L_0x00e8
                    L_0x00e0:
                        r0 = move-exception
                        com.onesignal.OneSignal$LOG_LEVEL r2 = com.onesignal.OneSignal.LOG_LEVEL.ERROR
                        java.lang.String r3 = "Error closing transaction! "
                        com.onesignal.OneSignal.Log(r2, r3, r0)
                    L_0x00e8:
                        throw r1
                    L_0x00e9:
                        r0 = move-exception
                    L_0x00ea:
                        if (r5 == 0) goto L_0x00f5
                        boolean r1 = r5.isClosed()
                        if (r1 != 0) goto L_0x00f5
                        r5.close()
                    L_0x00f5:
                        throw r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.onesignal.OneSignal.C242524.run():void");
                }
            };
            if (appContext == null || shouldRunTaskThroughQueue()) {
                LOG_LEVEL log_level = LOG_LEVEL.ERROR;
                Log(log_level, "OneSignal.init has not been called. Could not clear notifications part of group " + str + " - movingthis operation to a waiting task queue.");
                addTaskToQueue(new PendingTaskRunnable(r0));
                return;
            }
            r0.run();
        }
    }

    public static void removeNotificationOpenedHandler() {
        mInitBuilder.mNotificationOpenedHandler = null;
    }

    public static void removeInAppMessageClickHandler() {
        mInitBuilder.mInAppMessageClickHandler = null;
    }

    public static void removeNotificationReceivedHandler() {
        mInitBuilder.mNotificationReceivedHandler = null;
    }

    public static void addPermissionObserver(OSPermissionObserver oSPermissionObserver) {
        if (appContext == null) {
            Log(LOG_LEVEL.ERROR, "OneSignal.init has not been called. Could not add permission observer");
            return;
        }
        getPermissionStateChangesObserver().addObserver(oSPermissionObserver);
        if (getCurrentPermissionState(appContext).compare(getLastPermissionState(appContext))) {
            OSPermissionChangedInternalObserver.fireChangesToPublicObserver(getCurrentPermissionState(appContext));
        }
    }

    public static void removePermissionObserver(OSPermissionObserver oSPermissionObserver) {
        if (appContext == null) {
            Log(LOG_LEVEL.ERROR, "OneSignal.init has not been called. Could not modify permission observer");
        } else {
            getPermissionStateChangesObserver().removeObserver(oSPermissionObserver);
        }
    }

    public static void addSubscriptionObserver(OSSubscriptionObserver oSSubscriptionObserver) {
        if (appContext == null) {
            Log(LOG_LEVEL.ERROR, "OneSignal.init has not been called. Could not add subscription observer");
            return;
        }
        getSubscriptionStateChangesObserver().addObserver(oSSubscriptionObserver);
        if (getCurrentSubscriptionState(appContext).compare(getLastSubscriptionState(appContext))) {
            OSSubscriptionChangedInternalObserver.fireChangesToPublicObserver(getCurrentSubscriptionState(appContext));
        }
    }

    public static void removeSubscriptionObserver(OSSubscriptionObserver oSSubscriptionObserver) {
        if (appContext == null) {
            Log(LOG_LEVEL.ERROR, "OneSignal.init has not been called. Could not modify subscription observer");
        } else {
            getSubscriptionStateChangesObserver().removeObserver(oSSubscriptionObserver);
        }
    }

    public static void addEmailSubscriptionObserver(@NonNull OSEmailSubscriptionObserver oSEmailSubscriptionObserver) {
        if (appContext == null) {
            Log(LOG_LEVEL.ERROR, "OneSignal.init has not been called. Could not add email subscription observer");
            return;
        }
        getEmailSubscriptionStateChangesObserver().addObserver(oSEmailSubscriptionObserver);
        if (getCurrentEmailSubscriptionState(appContext).compare(getLastEmailSubscriptionState(appContext))) {
            OSEmailSubscriptionChangedInternalObserver.fireChangesToPublicObserver(getCurrentEmailSubscriptionState(appContext));
        }
    }

    public static void removeEmailSubscriptionObserver(@NonNull OSEmailSubscriptionObserver oSEmailSubscriptionObserver) {
        if (appContext == null) {
            Log(LOG_LEVEL.ERROR, "OneSignal.init has not been called. Could not modify email subscription observer");
        } else {
            getEmailSubscriptionStateChangesObserver().removeObserver(oSEmailSubscriptionObserver);
        }
    }

    public static OSPermissionSubscriptionState getPermissionSubscriptionState() {
        if (shouldLogUserPrivacyConsentErrorMessageForMethodName("getPermissionSubscriptionState()")) {
            return null;
        }
        if (appContext == null) {
            Log(LOG_LEVEL.ERROR, "OneSignal.init has not been called. Could not get OSPermissionSubscriptionState");
            return null;
        }
        OSPermissionSubscriptionState oSPermissionSubscriptionState = new OSPermissionSubscriptionState();
        oSPermissionSubscriptionState.subscriptionStatus = getCurrentSubscriptionState(appContext);
        oSPermissionSubscriptionState.permissionStatus = getCurrentPermissionState(appContext);
        oSPermissionSubscriptionState.emailSubscriptionStatus = getCurrentEmailSubscriptionState(appContext);
        return oSPermissionSubscriptionState;
    }

    public static void addTriggers(Map<String, Object> map) {
        OSInAppMessageController.getController().addTriggers(map);
    }

    public static void addTriggersFromJsonString(String str) {
        try {
            addTriggers(JSONUtils.jsonObjectToMap(new JSONObject(str)));
        } catch (JSONException e) {
            Log(LOG_LEVEL.ERROR, "addTriggersFromJsonString, invalid json", e);
        }
    }

    public static void addTrigger(String str, Object obj) {
        HashMap hashMap = new HashMap();
        hashMap.put(str, obj);
        OSInAppMessageController.getController().addTriggers(hashMap);
    }

    public static void removeTriggersForKeys(Collection<String> collection) {
        OSInAppMessageController.getController().removeTriggersForKeys(collection);
    }

    public static void removeTriggersForKeysFromJsonArrayString(@NonNull String str) {
        try {
            JSONArray jSONArray = new JSONArray(str);
            Collection<String> extractStringsFromCollection = OSUtils.extractStringsFromCollection(JSONUtils.jsonArrayToList(jSONArray));
            if (jSONArray.length() != extractStringsFromCollection.size()) {
                Log(LOG_LEVEL.WARN, "removeTriggersForKeysFromJsonArrayString: Skipped removing non-String type keys ");
            }
            OSInAppMessageController.getController().removeTriggersForKeys(extractStringsFromCollection);
        } catch (JSONException e) {
            Log(LOG_LEVEL.ERROR, "removeTriggersForKeysFromJsonArrayString, invalid json", e);
        }
    }

    public static void removeTriggerForKey(String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        OSInAppMessageController.getController().removeTriggersForKeys(arrayList);
    }

    @Nullable
    public static Object getTriggerValueForKey(String str) {
        return OSInAppMessageController.getController().getTriggerValue(str);
    }

    public static void pauseInAppMessages(boolean z) {
        OSInAppMessageController.getController().setInAppMessagingEnabled(!z);
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0066 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0069  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean isDuplicateNotification(java.lang.String r12, android.content.Context r13) {
        /*
            r0 = 0
            if (r12 == 0) goto L_0x006d
            java.lang.String r1 = ""
            boolean r1 = r1.equals(r12)
            if (r1 == 0) goto L_0x000c
            goto L_0x006d
        L_0x000c:
            com.onesignal.OneSignalDbHelper r13 = com.onesignal.OneSignalDbHelper.getInstance(r13)
            r1 = 0
            r2 = 1
            android.database.sqlite.SQLiteDatabase r3 = r13.getSQLiteDatabaseWithRetries()     // Catch:{ Throwable -> 0x003f }
            java.lang.String r13 = "notification_id"
            java.lang.String[] r5 = new java.lang.String[]{r13}     // Catch:{ Throwable -> 0x003f }
            java.lang.String[] r7 = new java.lang.String[r2]     // Catch:{ Throwable -> 0x003f }
            r7[r0] = r12     // Catch:{ Throwable -> 0x003f }
            java.lang.String r4 = "notification"
            java.lang.String r6 = "notification_id = ?"
            r8 = 0
            r9 = 0
            r10 = 0
            android.database.Cursor r13 = r3.query(r4, r5, r6, r7, r8, r9, r10)     // Catch:{ Throwable -> 0x003f }
            boolean r1 = r13.moveToFirst()     // Catch:{ Throwable -> 0x0038, all -> 0x0035 }
            if (r13 == 0) goto L_0x004d
            r13.close()
            goto L_0x004d
        L_0x0035:
            r12 = move-exception
            r1 = r13
            goto L_0x0067
        L_0x0038:
            r1 = move-exception
            r11 = r1
            r1 = r13
            r13 = r11
            goto L_0x0040
        L_0x003d:
            r12 = move-exception
            goto L_0x0067
        L_0x003f:
            r13 = move-exception
        L_0x0040:
            com.onesignal.OneSignal$LOG_LEVEL r3 = com.onesignal.OneSignal.LOG_LEVEL.ERROR     // Catch:{ all -> 0x003d }
            java.lang.String r4 = "Could not check for duplicate, assuming unique."
            Log(r3, r4, r13)     // Catch:{ all -> 0x003d }
            if (r1 == 0) goto L_0x004c
            r1.close()
        L_0x004c:
            r1 = 0
        L_0x004d:
            if (r1 == 0) goto L_0x0066
            com.onesignal.OneSignal$LOG_LEVEL r13 = com.onesignal.OneSignal.LOG_LEVEL.DEBUG
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Duplicate GCM message received, skip processing of "
            r0.append(r1)
            r0.append(r12)
            java.lang.String r12 = r0.toString()
            Log(r13, r12)
            return r2
        L_0x0066:
            return r0
        L_0x0067:
            if (r1 == 0) goto L_0x006c
            r1.close()
        L_0x006c:
            throw r12
        L_0x006d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.OneSignal.isDuplicateNotification(java.lang.String, android.content.Context):boolean");
    }

    static boolean notValidOrDuplicated(Context context, JSONObject jSONObject) {
        String oSNotificationIdFromJson = OSNotificationFormatHelper.getOSNotificationIdFromJson(jSONObject);
        return oSNotificationIdFromJson == null || isDuplicateNotification(oSNotificationIdFromJson, context);
    }

    private static String getNotificationIdFromGCMJsonPayload(JSONObject jSONObject) {
        try {
            return new JSONObject(jSONObject.optString(OSNotificationFormatHelper.PAYLOAD_OS_ROOT_CUSTOM)).optString("i", (String) null);
        } catch (Throwable unused) {
            return null;
        }
    }

    static boolean isAppActive() {
        return initDone && isForeground();
    }

    private static boolean isPastOnSessionTime() {
        return System.currentTimeMillis() - getLastSessionTime() >= 30000;
    }

    static boolean areNotificationsEnabledForSubscribedState() {
        if (mInitBuilder.mUnsubscribeWhenNotificationsAreDisabled) {
            return OSUtils.areNotificationsEnabled(appContext);
        }
        return true;
    }

    static void handleSuccessfulEmailLogout() {
        if (emailLogoutHandler != null) {
            emailLogoutHandler.onSuccess();
            emailLogoutHandler = null;
        }
    }

    static void handleFailedEmailLogout() {
        if (emailLogoutHandler != null) {
            emailLogoutHandler.onFailure(new EmailUpdateError(EmailErrorType.NETWORK, "Failed due to network failure. Will retry on next sync."));
            emailLogoutHandler = null;
        }
    }

    static void fireEmailUpdateSuccess() {
        if (emailUpdateHandler != null) {
            emailUpdateHandler.onSuccess();
            emailUpdateHandler = null;
        }
    }

    static void fireEmailUpdateFailure() {
        if (emailUpdateHandler != null) {
            emailUpdateHandler.onFailure(new EmailUpdateError(EmailErrorType.NETWORK, "Failed due to network failure. Will retry on next sync."));
            emailUpdateHandler = null;
        }
    }

    static void setTrackerFactory(OSTrackerFactory oSTrackerFactory) {
        trackerFactory = oSTrackerFactory;
    }

    static void setSessionManager(OSSessionManager oSSessionManager) {
        sessionManager = oSSessionManager;
    }

    static void setSharedPreferences(OSSharedPreferences oSSharedPreferences) {
        preferences = oSSharedPreferences;
    }

    static OSSessionManager.SessionListener getSessionListener() {
        return sessionListener;
    }

    static OSSessionManager getSessionManager() {
        return sessionManager;
    }

    static void sendClickActionOutcomes(@NonNull List<OSInAppMessageOutcome> list) {
        if (outcomeEventsController == null) {
            Log(LOG_LEVEL.ERROR, "Make sure OneSignal.init is called first");
        } else {
            outcomeEventsController.sendClickActionOutcomes(list);
        }
    }

    public static void sendOutcome(@NonNull String str) {
        sendOutcome(str, (OutcomeCallback) null);
    }

    public static void sendOutcome(@NonNull String str, OutcomeCallback outcomeCallback) {
        if (isValidOutcomeEntry(str)) {
            if (outcomeEventsController == null) {
                Log(LOG_LEVEL.ERROR, "Make sure OneSignal.init is called first");
            } else {
                outcomeEventsController.sendOutcomeEvent(str, outcomeCallback);
            }
        }
    }

    public static void sendUniqueOutcome(@NonNull String str) {
        sendUniqueOutcome(str, (OutcomeCallback) null);
    }

    public static void sendUniqueOutcome(@NonNull String str, OutcomeCallback outcomeCallback) {
        if (isValidOutcomeEntry(str)) {
            if (outcomeEventsController == null) {
                Log(LOG_LEVEL.ERROR, "Make sure OneSignal.init is called first");
            } else {
                outcomeEventsController.sendUniqueOutcomeEvent(str, outcomeCallback);
            }
        }
    }

    public static void sendOutcomeWithValue(@NonNull String str, float f) {
        sendOutcomeWithValue(str, f, (OutcomeCallback) null);
    }

    public static void sendOutcomeWithValue(@NonNull String str, float f, OutcomeCallback outcomeCallback) {
        if (isValidOutcomeEntry(str) && isValidOutcomeValue(f)) {
            if (outcomeEventsController == null) {
                Log(LOG_LEVEL.ERROR, "Make sure OneSignal.init is called first");
            } else {
                outcomeEventsController.sendOutcomeEventWithValue(str, f, outcomeCallback);
            }
        }
    }

    private static boolean isValidOutcomeValue(float f) {
        if (f > 0.0f) {
            return true;
        }
        Log(LOG_LEVEL.ERROR, "Outcome value must be greater than 0");
        return false;
    }

    private static boolean isValidOutcomeEntry(String str) {
        if (str != null && !str.isEmpty()) {
            return true;
        }
        Log(LOG_LEVEL.ERROR, "Outcome name must not be empty");
        return false;
    }
}
