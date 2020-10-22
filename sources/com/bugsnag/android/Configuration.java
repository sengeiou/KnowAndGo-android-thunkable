package com.bugsnag.android;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bugsnag.android.NativeInterface;
import com.google.android.exoplayer2.DefaultRenderersFactory;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Configuration extends Observable implements Observer {
    static final String DEFAULT_EXCEPTION_TYPE = "android";
    private static final int DEFAULT_MAX_SIZE = 32;
    static final String HEADER_API_KEY = "Bugsnag-Api-Key";
    private static final String HEADER_API_PAYLOAD_VERSION = "Bugsnag-Payload-Version";
    private static final String HEADER_BUGSNAG_SENT_AT = "Bugsnag-Sent-At";
    private long anrThresholdMs = DefaultRenderersFactory.DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS;
    @NonNull
    private final String apiKey;
    private String appVersion;
    private boolean autoCaptureSessions = true;
    private boolean automaticallyCollectBreadcrumbs = true;
    private final Collection<BeforeNotify> beforeNotifyTasks = new ConcurrentLinkedQueue();
    private final Collection<BeforeRecordBreadcrumb> beforeRecordBreadcrumbTasks = new ConcurrentLinkedQueue();
    private final Collection<BeforeSend> beforeSendTasks = new ConcurrentLinkedQueue();
    private String buildUuid;
    private boolean callPreviousSigquitHandler = true;
    private String codeBundleId;
    private String context;
    private Delivery delivery;
    private boolean detectAnrs = false;
    private boolean detectNdkCrashes;
    private boolean enableExceptionHandler = true;
    private volatile String endpoint = "https://notify.bugsnag.com";
    private String[] ignoreClasses;
    private long launchCrashThresholdMs = DefaultRenderersFactory.DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS;
    private int maxBreadcrumbs = 32;
    @NonNull
    private MetaData metaData;
    private String notifierType;
    @Nullable
    private String[] notifyReleaseStages = null;
    private boolean persistUserBetweenSessions = false;
    private String[] projectPackages;
    private String releaseStage;
    private boolean sendThreads = true;
    private final Collection<BeforeSendSession> sessionCallbacks = new ConcurrentLinkedQueue();
    private volatile String sessionEndpoint = "https://sessions.bugsnag.com";
    private Integer versionCode;

    @Deprecated
    public void setAnrThresholdMs(long j) {
    }

    public Configuration(@NonNull String str) {
        this.apiKey = str;
        this.metaData = new MetaData();
        this.metaData.addObserver(this);
        try {
            this.detectNdkCrashes = Class.forName("com.bugsnag.android.BuildConfig").getDeclaredField("DETECT_NDK_CRASHES").getBoolean((Object) null);
        } catch (Throwable unused) {
            this.detectNdkCrashes = false;
        }
    }

    public void update(@NonNull Observable observable, @NonNull Object obj) {
        if (obj instanceof NativeInterface.Message) {
            setChanged();
            notifyObservers(obj);
        }
    }

    @NonNull
    public String getApiKey() {
        return this.apiKey;
    }

    @NonNull
    public String getAppVersion() {
        return this.appVersion;
    }

    public void setAppVersion(@NonNull String str) {
        this.appVersion = str;
        setChanged();
        notifyObservers(new NativeInterface.Message(NativeInterface.MessageType.UPDATE_APP_VERSION, str));
    }

    @Nullable
    public Integer getVersionCode() {
        return this.versionCode;
    }

    public void setVersionCode(@Nullable Integer num) {
        this.versionCode = num;
    }

    @Nullable
    public String getContext() {
        return this.context;
    }

    public void setContext(@Nullable String str) {
        this.context = str;
        setChanged();
        notifyObservers(new NativeInterface.Message(NativeInterface.MessageType.UPDATE_CONTEXT, str));
    }

    @NonNull
    public String getEndpoint() {
        return this.endpoint;
    }

    @Deprecated
    public void setEndpoint(@NonNull String str) {
        this.endpoint = str;
    }

    public void setEndpoints(@NonNull String str, @NonNull String str2) throws IllegalArgumentException {
        if (!Intrinsics.isEmpty(str)) {
            this.endpoint = str;
            if (Intrinsics.isEmpty(str2)) {
                Logger.warn("The session tracking endpoint has not been set. Session tracking is disabled");
                this.sessionEndpoint = null;
                this.autoCaptureSessions = false;
                return;
            }
            this.sessionEndpoint = str2;
            return;
        }
        throw new IllegalArgumentException("Notify endpoint cannot be empty or null.");
    }

    @NonNull
    public String getSessionEndpoint() {
        return this.sessionEndpoint;
    }

    @Deprecated
    public void setSessionEndpoint(@NonNull String str) {
        this.sessionEndpoint = str;
    }

    @Nullable
    public String getBuildUUID() {
        return this.buildUuid;
    }

    public void setBuildUUID(@Nullable String str) {
        this.buildUuid = str;
        setChanged();
        notifyObservers(new NativeInterface.Message(NativeInterface.MessageType.UPDATE_BUILD_UUID, str));
    }

    @Nullable
    public String[] getFilters() {
        return this.metaData.getFilters();
    }

    public void setFilters(@Nullable String[] strArr) {
        this.metaData.setFilters(strArr);
    }

    @Nullable
    public String[] getIgnoreClasses() {
        return this.ignoreClasses;
    }

    public void setIgnoreClasses(@Nullable String[] strArr) {
        this.ignoreClasses = strArr;
    }

    @Nullable
    public String[] getNotifyReleaseStages() {
        return this.notifyReleaseStages;
    }

    public void setNotifyReleaseStages(@Nullable String[] strArr) {
        this.notifyReleaseStages = strArr;
        setChanged();
        notifyObservers(new NativeInterface.Message(NativeInterface.MessageType.UPDATE_NOTIFY_RELEASE_STAGES, this));
    }

    @Nullable
    public String[] getProjectPackages() {
        return this.projectPackages;
    }

    public void setProjectPackages(@Nullable String[] strArr) {
        this.projectPackages = strArr;
    }

    @Nullable
    public String getReleaseStage() {
        return this.releaseStage;
    }

    public void setReleaseStage(@Nullable String str) {
        this.releaseStage = str;
        setChanged();
        notifyObservers(new NativeInterface.Message(NativeInterface.MessageType.UPDATE_RELEASE_STAGE, this));
    }

    public boolean getSendThreads() {
        return this.sendThreads;
    }

    public void setSendThreads(boolean z) {
        this.sendThreads = z;
    }

    public boolean getEnableExceptionHandler() {
        return this.enableExceptionHandler;
    }

    public void setEnableExceptionHandler(boolean z) {
        this.enableExceptionHandler = z;
    }

    @Deprecated
    public boolean shouldAutoCaptureSessions() {
        return getAutoCaptureSessions();
    }

    public boolean getAutoCaptureSessions() {
        return this.autoCaptureSessions;
    }

    public void setAutoCaptureSessions(boolean z) {
        this.autoCaptureSessions = z;
    }

    @NonNull
    public MetaData getMetaData() {
        return this.metaData;
    }

    public void setMetaData(@NonNull MetaData metaData2) {
        this.metaData.deleteObserver(this);
        if (metaData2 == null) {
            this.metaData = new MetaData();
        } else {
            this.metaData = metaData2;
        }
        setChanged();
        notifyObservers(new NativeInterface.Message(NativeInterface.MessageType.UPDATE_METADATA, this.metaData.store));
        this.metaData.addObserver(this);
    }

    /* access modifiers changed from: protected */
    @NonNull
    public Collection<BeforeNotify> getBeforeNotifyTasks() {
        return this.beforeNotifyTasks;
    }

    /* access modifiers changed from: protected */
    @NonNull
    public Collection<BeforeSend> getBeforeSendTasks() {
        return this.beforeSendTasks;
    }

    public boolean getPersistUserBetweenSessions() {
        return this.persistUserBetweenSessions;
    }

    public void setPersistUserBetweenSessions(boolean z) {
        this.persistUserBetweenSessions = z;
    }

    public long getLaunchCrashThresholdMs() {
        return this.launchCrashThresholdMs;
    }

    public void setLaunchCrashThresholdMs(long j) {
        if (j <= 0) {
            this.launchCrashThresholdMs = 0;
        } else {
            this.launchCrashThresholdMs = j;
        }
    }

    public boolean isAutomaticallyCollectingBreadcrumbs() {
        return this.automaticallyCollectBreadcrumbs;
    }

    public void setAutomaticallyCollectBreadcrumbs(boolean z) {
        this.automaticallyCollectBreadcrumbs = z;
    }

    public void setNotifierType(@NonNull String str) {
        this.notifierType = str;
    }

    public void setCodeBundleId(@Nullable String str) {
        this.codeBundleId = str;
    }

    @Nullable
    public String getCodeBundleId() {
        return this.codeBundleId;
    }

    @NonNull
    public String getNotifierType() {
        return this.notifierType;
    }

    public void setMaxBreadcrumbs(int i) {
        if (i < 0) {
            Logger.warn("Ignoring invalid breadcrumb capacity. Must be >= 0.");
        } else {
            this.maxBreadcrumbs = i;
        }
    }

    public int getMaxBreadcrumbs() {
        return this.maxBreadcrumbs;
    }

    @NonNull
    public Delivery getDelivery() {
        return this.delivery;
    }

    public void setDelivery(@NonNull Delivery delivery2) {
        if (delivery2 != null) {
            this.delivery = delivery2;
            return;
        }
        throw new IllegalArgumentException("Delivery cannot be null");
    }

    public boolean getDetectAnrs() {
        return this.detectAnrs;
    }

    public void setDetectAnrs(boolean z) {
        this.detectAnrs = z;
    }

    /* access modifiers changed from: package-private */
    public boolean getCallPreviousSigquitHandler() {
        return this.callPreviousSigquitHandler;
    }

    /* access modifiers changed from: package-private */
    public void setCallPreviousSigquitHandler(boolean z) {
        this.callPreviousSigquitHandler = z;
    }

    public boolean getDetectNdkCrashes() {
        return this.detectNdkCrashes;
    }

    public void setDetectNdkCrashes(boolean z) {
        this.detectNdkCrashes = z;
    }

    @Deprecated
    public long getAnrThresholdMs() {
        return this.anrThresholdMs;
    }

    @NonNull
    public Map<String, String> getErrorApiHeaders() {
        HashMap hashMap = new HashMap();
        hashMap.put(HEADER_API_PAYLOAD_VERSION, "4.0");
        hashMap.put(HEADER_API_KEY, this.apiKey);
        hashMap.put(HEADER_BUGSNAG_SENT_AT, DateUtils.toIso8601(new Date()));
        return hashMap;
    }

    @NonNull
    public Map<String, String> getSessionApiHeaders() {
        HashMap hashMap = new HashMap();
        hashMap.put(HEADER_API_PAYLOAD_VERSION, "1.0");
        hashMap.put(HEADER_API_KEY, this.apiKey);
        hashMap.put(HEADER_BUGSNAG_SENT_AT, DateUtils.toIso8601(new Date()));
        return hashMap;
    }

    public void beforeSend(@NonNull BeforeSend beforeSend) {
        if (!this.beforeSendTasks.contains(beforeSend)) {
            this.beforeSendTasks.add(beforeSend);
        }
    }

    public boolean shouldNotifyForReleaseStage(@Nullable String str) {
        if (this.notifyReleaseStages == null) {
            return true;
        }
        return Arrays.asList(this.notifyReleaseStages).contains(str);
    }

    /* access modifiers changed from: protected */
    public boolean shouldIgnoreClass(@Nullable String str) {
        if (this.ignoreClasses == null) {
            return false;
        }
        return Arrays.asList(this.ignoreClasses).contains(str);
    }

    /* access modifiers changed from: protected */
    public void beforeNotify(@NonNull BeforeNotify beforeNotify) {
        if (!this.beforeNotifyTasks.contains(beforeNotify)) {
            this.beforeNotifyTasks.add(beforeNotify);
        }
    }

    /* access modifiers changed from: protected */
    public void beforeRecordBreadcrumb(@NonNull BeforeRecordBreadcrumb beforeRecordBreadcrumb) {
        if (!this.beforeRecordBreadcrumbTasks.contains(beforeRecordBreadcrumb)) {
            this.beforeRecordBreadcrumbTasks.add(beforeRecordBreadcrumb);
        }
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public boolean inProject(@NonNull String str) {
        return Stacktrace.inProject(str, this.projectPackages);
    }

    /* access modifiers changed from: protected */
    @NonNull
    public Collection<BeforeRecordBreadcrumb> getBeforeRecordBreadcrumbTasks() {
        return this.beforeRecordBreadcrumbTasks;
    }

    /* access modifiers changed from: package-private */
    public void addBeforeSendSession(BeforeSendSession beforeSendSession) {
        this.sessionCallbacks.add(beforeSendSession);
    }

    /* access modifiers changed from: package-private */
    public Collection<BeforeSendSession> getSessionCallbacks() {
        return this.sessionCallbacks;
    }
}
