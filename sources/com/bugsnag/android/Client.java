package com.bugsnag.android;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.storage.StorageManager;
import android.text.TextUtils;
import android.view.OrientationEventListener;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bugsnag.android.Error;
import com.bugsnag.android.FileStore;
import com.bugsnag.android.NativeInterface;
import com.onesignal.OneSignalDbContract;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.RejectedExecutionException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

public class Client extends Observable implements Observer {
    private static final boolean BLOCKING = true;
    static final String INTERNAL_DIAGNOSTICS_TAB = "BugsnagDiagnostics";
    private static final String SHARED_PREF_KEY = "com.bugsnag.android";
    private static final String USER_EMAIL_KEY = "user.email";
    private static final String USER_ID_KEY = "user.id";
    private static final String USER_NAME_KEY = "user.name";
    @Nullable
    private Class<?> anrPluginClz;
    final Context appContext;
    @NonNull
    protected final AppData appData;
    @NonNull
    final Breadcrumbs breadcrumbs;
    @NonNull
    protected final Configuration config;
    private final Connectivity connectivity;
    @NonNull
    protected final DeviceData deviceData;
    @NonNull
    protected final ErrorStore errorStore;
    final EventReceiver eventReceiver;
    @Nullable
    private Class<?> ndkPluginClz;
    private final OrientationEventListener orientationListener;
    final SessionStore sessionStore;
    final SessionTracker sessionTracker;
    final SharedPreferences sharedPrefs;
    final StorageManager storageManager;
    @NonNull
    private final User user;

    public Client(@NonNull Context context) {
        this(context, (String) null, true);
    }

    public Client(@NonNull Context context, @Nullable String str) {
        this(context, str, true);
    }

    public Client(@NonNull Context context, @Nullable String str, boolean z) {
        this(context, ConfigFactory.createNewConfiguration(context, str, z));
    }

    public Client(@NonNull Context context, @NonNull Configuration configuration) {
        String str;
        this.user = new User();
        warnIfNotAppContext(context);
        this.appContext = context.getApplicationContext();
        this.config = configuration;
        this.sessionStore = new SessionStore(this.config, this.appContext, (FileStore.Delegate) null);
        this.storageManager = (StorageManager) this.appContext.getSystemService("storage");
        this.connectivity = new ConnectivityCompat(this.appContext, new Function1<Boolean, Unit>() {
            public Unit invoke(Boolean bool) {
                if (!bool.booleanValue()) {
                    return null;
                }
                Client.this.errorStore.flushAsync();
                return null;
            }
        });
        if (configuration.getDelivery() == null) {
            configuration.setDelivery(new DefaultDelivery(this.connectivity));
        }
        this.sessionTracker = new SessionTracker(configuration, this, this.sessionStore);
        this.eventReceiver = new EventReceiver(this);
        this.sharedPrefs = this.appContext.getSharedPreferences("com.bugsnag.android", 0);
        this.appData = new AppData(this.appContext, this.appContext.getPackageManager(), this.config, this.sessionTracker);
        this.deviceData = new DeviceData(this.connectivity, this.appContext, this.appContext.getResources(), this.sharedPrefs);
        this.breadcrumbs = new Breadcrumbs(configuration);
        if (this.config.getProjectPackages() == null) {
            setProjectPackages(this.appContext.getPackageName());
        }
        String id = this.deviceData.getId();
        if (this.config.getPersistUserBetweenSessions()) {
            this.user.setId(this.sharedPrefs.getString(USER_ID_KEY, id));
            this.user.setName(this.sharedPrefs.getString(USER_NAME_KEY, (String) null));
            this.user.setEmail(this.sharedPrefs.getString(USER_EMAIL_KEY, (String) null));
        } else {
            this.user.setId(id);
        }
        if (this.appContext instanceof Application) {
            ((Application) this.appContext).registerActivityLifecycleCallbacks(this.sessionTracker);
        } else {
            Logger.warn("Bugsnag is unable to setup automatic activity lifecycle breadcrumbs on API Levels below 14.");
        }
        if (this.config.getBuildUUID() == null) {
            try {
                str = this.appContext.getPackageManager().getApplicationInfo(this.appContext.getPackageName(), 128).metaData.getString("com.bugsnag.android.BUILD_UUID");
            } catch (Exception unused) {
                Logger.warn("Bugsnag is unable to read build UUID from manifest.");
                str = null;
            }
            if (str != null) {
                this.config.setBuildUUID(str);
            }
        }
        this.errorStore = new ErrorStore(this.config, this.appContext, new FileStore.Delegate() {
            public void onErrorIOFailure(Exception exc, File file, String str) {
                Error build = new Error.Builder(Client.this.config, exc, (SessionTracker) null, Thread.currentThread(), true).build();
                build.setContext(str);
                MetaData metaData = build.getMetaData();
                metaData.addToTab(Client.INTERNAL_DIAGNOSTICS_TAB, "canRead", Boolean.valueOf(file.canRead()));
                metaData.addToTab(Client.INTERNAL_DIAGNOSTICS_TAB, "canWrite", Boolean.valueOf(file.canWrite()));
                metaData.addToTab(Client.INTERNAL_DIAGNOSTICS_TAB, "exists", Boolean.valueOf(file.exists()));
                metaData.addToTab(Client.INTERNAL_DIAGNOSTICS_TAB, "usableSpace", Long.valueOf(Client.this.appContext.getCacheDir().getUsableSpace()));
                metaData.addToTab(Client.INTERNAL_DIAGNOSTICS_TAB, "filename", file.getName());
                metaData.addToTab(Client.INTERNAL_DIAGNOSTICS_TAB, "fileLength", Long.valueOf(file.length()));
                Client.this.recordStorageCacheBehavior(metaData);
                Client.this.reportInternalBugsnagError(build);
            }
        });
        if (this.config.getEnableExceptionHandler()) {
            enableExceptionHandler();
        }
        try {
            this.ndkPluginClz = Class.forName("com.bugsnag.android.NdkPlugin");
        } catch (ClassNotFoundException unused2) {
            Logger.warn("bugsnag-plugin-android-ndk artefact not found on classpath, NDK errors will not be captured.");
        }
        try {
            this.anrPluginClz = Class.forName("com.bugsnag.android.AnrPlugin");
        } catch (ClassNotFoundException unused3) {
            Logger.warn("bugsnag-plugin-android-anr artefact not found on classpath, ANR errors will not be captured.");
        }
        try {
            Async.run(new Runnable() {
                public void run() {
                    Client.this.appContext.registerReceiver(Client.this.eventReceiver, EventReceiver.getIntentFilter());
                }
            });
        } catch (RejectedExecutionException e) {
            Logger.warn("Failed to register for automatic breadcrumb broadcasts", e);
        }
        this.connectivity.registerForNetworkChanges();
        Logger.setEnabled(!"production".equals(this.appData.guessReleaseStage()));
        this.config.addObserver(this);
        this.breadcrumbs.addObserver(this);
        this.sessionTracker.addObserver(this);
        this.user.addObserver(this);
        this.orientationListener = new OrientationEventListener(this.appContext) {
            public void onOrientationChanged(int i) {
                this.setChanged();
                this.notifyObservers(new NativeInterface.Message(NativeInterface.MessageType.UPDATE_ORIENTATION, Integer.valueOf(i)));
            }
        };
        try {
            this.orientationListener.enable();
        } catch (IllegalStateException e2) {
            Logger.warn("Failed to set up orientation tracking: " + e2);
        }
        this.errorStore.flushOnLaunch();
        loadPlugins();
        ClientConfigObserver clientConfigObserver = new ClientConfigObserver(this, this.config);
        this.config.addObserver(clientConfigObserver);
        addObserver(clientConfigObserver);
    }

    /* access modifiers changed from: package-private */
    public void recordStorageCacheBehavior(MetaData metaData) {
        if (Build.VERSION.SDK_INT >= 26) {
            File file = new File(this.appContext.getCacheDir(), "bugsnag-errors");
            try {
                boolean isCacheBehaviorTombstone = this.storageManager.isCacheBehaviorTombstone(file);
                boolean isCacheBehaviorGroup = this.storageManager.isCacheBehaviorGroup(file);
                metaData.addToTab(INTERNAL_DIAGNOSTICS_TAB, "cacheTombstone", Boolean.valueOf(isCacheBehaviorTombstone));
                metaData.addToTab(INTERNAL_DIAGNOSTICS_TAB, "cacheGroup", Boolean.valueOf(isCacheBehaviorGroup));
            } catch (IOException e) {
                Logger.warn("Failed to record cache behaviour, skipping diagnostics", e);
            }
        }
    }

    private void loadPlugins() {
        NativeInterface.setClient(this);
        enableOrDisableNdkReporting();
        enableOrDisableAnrReporting();
        BugsnagPluginInterface.INSTANCE.loadRegisteredPlugins(this);
    }

    /* access modifiers changed from: package-private */
    public void enableOrDisableNdkReporting() {
        if (this.ndkPluginClz != null) {
            if (this.config.getDetectNdkCrashes()) {
                BugsnagPluginInterface.INSTANCE.loadPlugin(this, this.ndkPluginClz);
            } else {
                BugsnagPluginInterface.INSTANCE.unloadPlugin(this.ndkPluginClz);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void enableOrDisableAnrReporting() {
        if (this.anrPluginClz != null) {
            if (this.config.getDetectAnrs()) {
                BugsnagPluginInterface.INSTANCE.loadPlugin(this, this.anrPluginClz);
            } else {
                BugsnagPluginInterface.INSTANCE.unloadPlugin(this.anrPluginClz);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void sendNativeSetupNotification() {
        setChanged();
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.config);
        super.notifyObservers(new NativeInterface.Message(NativeInterface.MessageType.INSTALL, arrayList));
        try {
            Async.run(new Runnable() {
                public void run() {
                    Client.this.enqueuePendingNativeReports();
                }
            });
        } catch (RejectedExecutionException e) {
            Logger.warn("Failed to enqueue native reports, will retry next launch: ", e);
        }
    }

    /* access modifiers changed from: package-private */
    public void enqueuePendingNativeReports() {
        setChanged();
        notifyObservers(new NativeInterface.Message(NativeInterface.MessageType.DELIVER_PENDING, (Object) null));
    }

    public void update(@NonNull Observable observable, @NonNull Object obj) {
        if (obj instanceof NativeInterface.Message) {
            setChanged();
            super.notifyObservers(obj);
        }
    }

    public void startSession() {
        this.sessionTracker.startSession(false);
    }

    public final void stopSession() {
        this.sessionTracker.stopSession();
    }

    public final boolean resumeSession() {
        return this.sessionTracker.resumeSession();
    }

    public void startFirstSession(@NonNull Activity activity) {
        this.sessionTracker.startFirstSession(activity);
    }

    public void setAppVersion(@NonNull String str) {
        this.config.setAppVersion(str);
    }

    @Nullable
    public String getContext() {
        return this.config.getContext();
    }

    public void setContext(@Nullable String str) {
        this.config.setContext(str);
    }

    @Deprecated
    public void setEndpoint(@NonNull String str) {
        this.config.setEndpoint(str);
    }

    public void setBuildUUID(@Nullable String str) {
        this.config.setBuildUUID(str);
    }

    public void setFilters(@Nullable String... strArr) {
        this.config.setFilters(strArr);
    }

    public void setIgnoreClasses(@Nullable String... strArr) {
        this.config.setIgnoreClasses(strArr);
    }

    public void setNotifyReleaseStages(@Nullable String... strArr) {
        this.config.setNotifyReleaseStages(strArr);
    }

    @Deprecated
    public void setProjectPackages(@Nullable String... strArr) {
        this.config.setProjectPackages(strArr);
    }

    public void setReleaseStage(@Nullable String str) {
        this.config.setReleaseStage(str);
        Logger.setEnabled(!"production".equals(str));
    }

    public void setSendThreads(boolean z) {
        this.config.setSendThreads(z);
    }

    public void setAutoCaptureSessions(boolean z) {
        this.config.setAutoCaptureSessions(z);
        if (z) {
            this.sessionTracker.onAutoCaptureEnabled();
        }
    }

    public void setUser(@Nullable String str, @Nullable String str2, @Nullable String str3) {
        setUserId(str);
        setUserEmail(str2);
        setUserName(str3);
    }

    @NonNull
    public User getUser() {
        return this.user;
    }

    @NonNull
    public Collection<Breadcrumb> getBreadcrumbs() {
        return new ArrayList(this.breadcrumbs.store);
    }

    @NonNull
    public AppData getAppData() {
        return this.appData;
    }

    @NonNull
    public DeviceData getDeviceData() {
        return this.deviceData;
    }

    public void clearUser() {
        this.user.setId(MapUtils.getStringFromMap("id", this.deviceData.getDeviceData()));
        this.user.setEmail((String) null);
        this.user.setName((String) null);
        this.appContext.getSharedPreferences("com.bugsnag.android", 0).edit().remove(USER_ID_KEY).remove(USER_EMAIL_KEY).remove(USER_NAME_KEY).apply();
    }

    public void setUserId(@Nullable String str) {
        this.user.setId(str);
        if (this.config.getPersistUserBetweenSessions()) {
            storeInSharedPrefs(USER_ID_KEY, str);
        }
    }

    public void setUserEmail(@Nullable String str) {
        this.user.setEmail(str);
        if (this.config.getPersistUserBetweenSessions()) {
            storeInSharedPrefs(USER_EMAIL_KEY, str);
        }
    }

    public void setUserName(@Nullable String str) {
        this.user.setName(str);
        if (this.config.getPersistUserBetweenSessions()) {
            storeInSharedPrefs(USER_NAME_KEY, str);
        }
    }

    /* access modifiers changed from: package-private */
    public DeliveryCompat getAndSetDeliveryCompat() {
        Delivery delivery = this.config.getDelivery();
        if (delivery instanceof DeliveryCompat) {
            return (DeliveryCompat) delivery;
        }
        DeliveryCompat deliveryCompat = new DeliveryCompat();
        this.config.setDelivery(deliveryCompat);
        return deliveryCompat;
    }

    /* access modifiers changed from: package-private */
    @Deprecated
    public void setErrorReportApiClient(@NonNull ErrorReportApiClient errorReportApiClient) {
        if (errorReportApiClient != null) {
            getAndSetDeliveryCompat().errorReportApiClient = errorReportApiClient;
            return;
        }
        throw new IllegalArgumentException("ErrorReportApiClient cannot be null.");
    }

    /* access modifiers changed from: package-private */
    @Deprecated
    public void setSessionTrackingApiClient(@NonNull SessionTrackingApiClient sessionTrackingApiClient) {
        if (sessionTrackingApiClient != null) {
            getAndSetDeliveryCompat().sessionTrackingApiClient = sessionTrackingApiClient;
            return;
        }
        throw new IllegalArgumentException("SessionTrackingApiClient cannot be null.");
    }

    public void beforeNotify(@NonNull BeforeNotify beforeNotify) {
        this.config.beforeNotify(beforeNotify);
    }

    public void beforeRecordBreadcrumb(@NonNull BeforeRecordBreadcrumb beforeRecordBreadcrumb) {
        this.config.beforeRecordBreadcrumb(beforeRecordBreadcrumb);
    }

    public void notify(@NonNull Throwable th) {
        notify(new Error.Builder(this.config, th, this.sessionTracker, Thread.currentThread(), false).severityReasonType("handledException").build(), false);
    }

    public void notify(@NonNull Throwable th, @Nullable Callback callback) {
        notify(new Error.Builder(this.config, th, this.sessionTracker, Thread.currentThread(), false).severityReasonType("handledException").build(), DeliveryStyle.ASYNC, callback);
    }

    public void notify(@NonNull String str, @NonNull String str2, @NonNull StackTraceElement[] stackTraceElementArr, @Nullable Callback callback) {
        notify(new Error.Builder(this.config, str, str2, stackTraceElementArr, this.sessionTracker, Thread.currentThread()).severityReasonType("handledException").build(), DeliveryStyle.ASYNC, callback);
    }

    public void notify(@NonNull Throwable th, @NonNull Severity severity) {
        notify(new Error.Builder(this.config, th, this.sessionTracker, Thread.currentThread(), false).severity(severity).build(), false);
    }

    @Deprecated
    public void notify(@NonNull Throwable th, @NonNull MetaData metaData) {
        notify(new Error.Builder(this.config, th, this.sessionTracker, Thread.currentThread(), false).metaData(metaData).severityReasonType("handledException").build(), false);
    }

    @Deprecated
    public void notify(@NonNull Throwable th, @NonNull Severity severity, @NonNull MetaData metaData) {
        notify(new Error.Builder(this.config, th, this.sessionTracker, Thread.currentThread(), false).metaData(metaData).severity(severity).build(), false);
    }

    @Deprecated
    public void notify(@NonNull String str, @NonNull String str2, @NonNull StackTraceElement[] stackTraceElementArr, @NonNull Severity severity, @NonNull MetaData metaData) {
        notify(new Error.Builder(this.config, str, str2, stackTraceElementArr, this.sessionTracker, Thread.currentThread()).severity(severity).metaData(metaData).build(), false);
    }

    @Deprecated
    public void notify(@NonNull String str, @NonNull String str2, @Nullable String str3, @NonNull StackTraceElement[] stackTraceElementArr, @NonNull Severity severity, @NonNull MetaData metaData) {
        Error build = new Error.Builder(this.config, str, str2, stackTraceElementArr, this.sessionTracker, Thread.currentThread()).severity(severity).metaData(metaData).build();
        build.setContext(str3);
        notify(build, false);
    }

    private void notify(@NonNull Error error, boolean z) {
        notify(error, z ? DeliveryStyle.SAME_THREAD : DeliveryStyle.ASYNC, (Callback) null);
    }

    /* access modifiers changed from: package-private */
    public void notify(@NonNull Error error, @NonNull DeliveryStyle deliveryStyle, @Nullable Callback callback) {
        if (!error.shouldIgnoreClass()) {
            Map<String, Object> appData2 = this.appData.getAppData();
            if (this.config.shouldNotifyForReleaseStage(MapUtils.getStringFromMap("releaseStage", appData2))) {
                error.setDeviceData(this.deviceData.getDeviceData());
                error.getMetaData().store.put("device", this.deviceData.getDeviceMetaData());
                error.setAppData(appData2);
                error.getMetaData().store.put("app", this.appData.getAppDataMetaData());
                error.setBreadcrumbs(this.breadcrumbs);
                error.setUser(this.user);
                if (TextUtils.isEmpty(error.getContext())) {
                    String context = this.config.getContext();
                    if (context == null) {
                        context = this.appData.getActiveScreenClass();
                    }
                    error.setContext(context);
                }
                if (!runBeforeNotifyTasks(error)) {
                    Logger.info("Skipping notification - beforeNotify task returned false");
                    return;
                }
                Report report = new Report(this.config.getApiKey(), error);
                if (callback != null) {
                    callback.beforeNotify(report);
                }
                if (error.getSession() != null) {
                    setChanged();
                    if (error.getHandledState().isUnhandled()) {
                        notifyObservers(new NativeInterface.Message(NativeInterface.MessageType.NOTIFY_UNHANDLED, (Object) null));
                    } else {
                        notifyObservers(new NativeInterface.Message(NativeInterface.MessageType.NOTIFY_HANDLED, error.getExceptionName()));
                    }
                }
                switch (deliveryStyle) {
                    case SAME_THREAD:
                        deliver(report, error);
                        return;
                    case NO_CACHE:
                        report.setCachingDisabled(true);
                        deliverReportAsync(error, report);
                        return;
                    case ASYNC:
                        deliverReportAsync(error, report);
                        return;
                    case ASYNC_WITH_CACHE:
                        this.errorStore.write(error);
                        this.errorStore.flushAsync();
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void reportInternalBugsnagError(@NonNull Error error) {
        Map<String, Object> appDataSummary = this.appData.getAppDataSummary();
        appDataSummary.put("duration", Long.valueOf(AppData.getDurationMs()));
        appDataSummary.put("durationInForeground", this.appData.calculateDurationInForeground());
        appDataSummary.put("inForeground", this.sessionTracker.isInForeground());
        error.setAppData(appDataSummary);
        Map<String, Object> deviceDataSummary = this.deviceData.getDeviceDataSummary();
        deviceDataSummary.put("freeDisk", Long.valueOf(this.deviceData.calculateFreeDisk()));
        error.setDeviceData(deviceDataSummary);
        MetaData metaData = error.getMetaData();
        Notifier instance = Notifier.getInstance();
        metaData.addToTab(INTERNAL_DIAGNOSTICS_TAB, "notifierName", instance.getName());
        metaData.addToTab(INTERNAL_DIAGNOSTICS_TAB, "notifierVersion", instance.getVersion());
        metaData.addToTab(INTERNAL_DIAGNOSTICS_TAB, "apiKey", this.config.getApiKey());
        metaData.addToTab(INTERNAL_DIAGNOSTICS_TAB, "packageName", this.appData.getAppData().get("packageName"));
        final Report report = new Report((String) null, error);
        try {
            Async.run(new Runnable() {
                public void run() {
                    try {
                        Delivery delivery = Client.this.config.getDelivery();
                        if (delivery instanceof DefaultDelivery) {
                            Map<String, String> errorApiHeaders = Client.this.config.getErrorApiHeaders();
                            errorApiHeaders.put("Bugsnag-Internal-Error", "true");
                            errorApiHeaders.remove("Bugsnag-Api-Key");
                            ((DefaultDelivery) delivery).deliver(Client.this.config.getEndpoint(), report, errorApiHeaders);
                        }
                    } catch (Exception e) {
                        Logger.warn("Failed to report internal error to Bugsnag", e);
                    }
                }
            });
        } catch (RejectedExecutionException unused) {
        }
    }

    private void deliverReportAsync(@NonNull final Error error, final Report report) {
        try {
            Async.run(new Runnable() {
                public void run() {
                    Client.this.deliver(report, error);
                }
            });
        } catch (RejectedExecutionException unused) {
            this.errorStore.write(error);
            Logger.warn("Exceeded max queue count, saving to disk to send later");
        }
    }

    private void leaveErrorBreadcrumb(@NonNull Error error) {
        this.breadcrumbs.add(new Breadcrumb(error.getExceptionName(), BreadcrumbType.ERROR, Collections.singletonMap(OneSignalDbContract.NotificationTable.COLUMN_NAME_MESSAGE, error.getExceptionMessage())));
    }

    public void notifyBlocking(@NonNull Throwable th) {
        notify(new Error.Builder(this.config, th, this.sessionTracker, Thread.currentThread(), false).severityReasonType("handledException").build(), true);
    }

    public void notifyBlocking(@NonNull Throwable th, @Nullable Callback callback) {
        notify(new Error.Builder(this.config, th, this.sessionTracker, Thread.currentThread(), false).severityReasonType("handledException").build(), DeliveryStyle.SAME_THREAD, callback);
    }

    public void notifyBlocking(@NonNull String str, @NonNull String str2, @NonNull StackTraceElement[] stackTraceElementArr, @Nullable Callback callback) {
        notify(new Error.Builder(this.config, str, str2, stackTraceElementArr, this.sessionTracker, Thread.currentThread()).severityReasonType("handledException").build(), DeliveryStyle.SAME_THREAD, callback);
    }

    @Deprecated
    public void notifyBlocking(@NonNull Throwable th, @NonNull MetaData metaData) {
        notify(new Error.Builder(this.config, th, this.sessionTracker, Thread.currentThread(), false).severityReasonType("handledException").metaData(metaData).build(), true);
    }

    @Deprecated
    public void notifyBlocking(@NonNull Throwable th, @NonNull Severity severity, @NonNull MetaData metaData) {
        notify(new Error.Builder(this.config, th, this.sessionTracker, Thread.currentThread(), false).metaData(metaData).severity(severity).build(), true);
    }

    @Deprecated
    public void notifyBlocking(@NonNull String str, @NonNull String str2, @NonNull StackTraceElement[] stackTraceElementArr, @NonNull Severity severity, @NonNull MetaData metaData) {
        notify(new Error.Builder(this.config, str, str2, stackTraceElementArr, this.sessionTracker, Thread.currentThread()).severity(severity).metaData(metaData).build(), true);
    }

    @Deprecated
    public void notifyBlocking(@NonNull String str, @NonNull String str2, @Nullable String str3, @NonNull StackTraceElement[] stackTraceElementArr, @NonNull Severity severity, @NonNull MetaData metaData) {
        Error build = new Error.Builder(this.config, str, str2, stackTraceElementArr, this.sessionTracker, Thread.currentThread()).severity(severity).metaData(metaData).build();
        build.setContext(str3);
        notify(build, true);
    }

    public void notifyBlocking(@NonNull Throwable th, @NonNull Severity severity) {
        notify(new Error.Builder(this.config, th, this.sessionTracker, Thread.currentThread(), false).severity(severity).build(), true);
    }

    public void internalClientNotify(@NonNull Throwable th, @NonNull Map<String, Object> map, boolean z, @Nullable Callback callback) {
        String keyFromClientData = getKeyFromClientData(map, "severity", true);
        String keyFromClientData2 = getKeyFromClientData(map, "severityReason", true);
        String keyFromClientData3 = getKeyFromClientData(map, "logLevel", false);
        Logger.info(String.format("Internal client notify, severity = '%s', severityReason = '%s'", new Object[]{keyFromClientData, keyFromClientData2}));
        notify(new Error.Builder(this.config, th, this.sessionTracker, Thread.currentThread(), false).severity(Severity.fromString(keyFromClientData)).severityReasonType(keyFromClientData2).attributeValue(keyFromClientData3).build(), z ? DeliveryStyle.SAME_THREAD : DeliveryStyle.ASYNC, callback);
    }

    @NonNull
    private String getKeyFromClientData(Map<String, Object> map, String str, boolean z) {
        Object obj = map.get(str);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (!z) {
            return null;
        }
        throw new IllegalStateException("Failed to set " + str + " in client data!");
    }

    public void addToTab(@NonNull String str, @NonNull String str2, @Nullable Object obj) {
        this.config.getMetaData().addToTab(str, str2, obj);
    }

    public void clearTab(@NonNull String str) {
        this.config.getMetaData().clearTab(str);
    }

    @NonNull
    public MetaData getMetaData() {
        return this.config.getMetaData();
    }

    public void setMetaData(@NonNull MetaData metaData) {
        this.config.setMetaData(metaData);
    }

    public void leaveBreadcrumb(@NonNull String str) {
        Breadcrumb breadcrumb = new Breadcrumb(str);
        if (runBeforeBreadcrumbTasks(breadcrumb)) {
            this.breadcrumbs.add(breadcrumb);
        }
    }

    public void leaveBreadcrumb(@NonNull String str, @NonNull BreadcrumbType breadcrumbType, @NonNull Map<String, String> map) {
        Breadcrumb breadcrumb = new Breadcrumb(str, breadcrumbType, map);
        if (runBeforeBreadcrumbTasks(breadcrumb)) {
            this.breadcrumbs.add(breadcrumb);
        }
    }

    @Deprecated
    public void setMaxBreadcrumbs(int i) {
        this.config.setMaxBreadcrumbs(i);
    }

    public void clearBreadcrumbs() {
        this.breadcrumbs.clear();
    }

    /* access modifiers changed from: package-private */
    public void enableAnrReporting() {
        getConfig().setDetectAnrs(true);
        enableOrDisableAnrReporting();
    }

    /* access modifiers changed from: package-private */
    public void disableAnrReporting() {
        getConfig().setDetectAnrs(false);
        enableOrDisableAnrReporting();
    }

    /* access modifiers changed from: package-private */
    public void enableNdkCrashReporting() {
        getConfig().setDetectNdkCrashes(true);
        enableOrDisableNdkReporting();
    }

    /* access modifiers changed from: package-private */
    public void disableNdkCrashReporting() {
        getConfig().setDetectNdkCrashes(false);
        enableOrDisableNdkReporting();
    }

    public void enableExceptionHandler() {
        ExceptionHandler.enable(this);
    }

    public void disableExceptionHandler() {
        ExceptionHandler.disable(this);
    }

    /* access modifiers changed from: package-private */
    public void deliver(@NonNull Report report, @NonNull Error error) {
        if (!runBeforeSendTasks(report)) {
            Logger.info("Skipping notification - beforeSend task returned false");
            return;
        }
        try {
            this.config.getDelivery().deliver(report, this.config);
            Logger.info("Sent 1 new error to Bugsnag");
            leaveErrorBreadcrumb(error);
        } catch (DeliveryFailureException e) {
            if (!report.isCachingDisabled()) {
                Logger.warn("Could not send error(s) to Bugsnag, saving to disk to send later", e);
                this.errorStore.write(error);
                leaveErrorBreadcrumb(error);
            }
        } catch (Exception e2) {
            Logger.warn("Problem sending error to Bugsnag", e2);
        }
    }

    /* access modifiers changed from: package-private */
    public void cacheAndNotify(@NonNull Throwable th, Severity severity, MetaData metaData, String str, @Nullable String str2, Thread thread) {
        notify(new Error.Builder(this.config, th, this.sessionTracker, thread, true).severity(severity).metaData(metaData).severityReasonType(str).attributeValue(str2).build(), DeliveryStyle.ASYNC_WITH_CACHE, (Callback) null);
    }

    private boolean runBeforeSendTasks(Report report) {
        for (BeforeSend run : this.config.getBeforeSendTasks()) {
            try {
                if (!run.run(report)) {
                    return false;
                }
            } catch (Throwable th) {
                Logger.warn("BeforeSend threw an Exception", th);
            }
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public OrientationEventListener getOrientationListener() {
        return this.orientationListener;
    }

    /* access modifiers changed from: package-private */
    public SessionTracker getSessionTracker() {
        return this.sessionTracker;
    }

    private boolean runBeforeNotifyTasks(Error error) {
        for (BeforeNotify run : this.config.getBeforeNotifyTasks()) {
            try {
                if (!run.run(error)) {
                    return false;
                }
            } catch (Throwable th) {
                Logger.warn("BeforeNotify threw an Exception", th);
            }
        }
        return true;
    }

    private boolean runBeforeBreadcrumbTasks(@NonNull Breadcrumb breadcrumb) {
        for (BeforeRecordBreadcrumb shouldRecord : this.config.getBeforeRecordBreadcrumbTasks()) {
            try {
                if (!shouldRecord.shouldRecord(breadcrumb)) {
                    return false;
                }
            } catch (Throwable th) {
                Logger.warn("BeforeRecordBreadcrumb threw an Exception", th);
            }
        }
        return true;
    }

    private void storeInSharedPrefs(String str, String str2) {
        this.appContext.getSharedPreferences("com.bugsnag.android", 0).edit().putString(str, str2).apply();
    }

    /* access modifiers changed from: package-private */
    public ErrorStore getErrorStore() {
        return this.errorStore;
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        if (this.eventReceiver != null) {
            try {
                this.appContext.unregisterReceiver(this.eventReceiver);
            } catch (IllegalArgumentException unused) {
                Logger.warn("Receiver not registered");
            }
        }
        super.finalize();
    }

    private static void warnIfNotAppContext(Context context) {
        if (!(context instanceof Application)) {
            Logger.warn("Warning - Non-Application context detected! Please ensure that you are initializing Bugsnag from a custom Application class.");
        }
    }

    public void setLoggingEnabled(boolean z) {
        Logger.setEnabled(z);
    }

    @NonNull
    public Configuration getConfig() {
        return this.config;
    }

    public long getLaunchTimeMs() {
        return AppData.getDurationMs();
    }

    /* access modifiers changed from: package-private */
    public void setBinaryArch(String str) {
        getAppData().setBinaryArch(str);
    }

    /* access modifiers changed from: package-private */
    public void close() {
        this.orientationListener.disable();
        this.connectivity.unregisterForNetworkChanges();
    }
}
