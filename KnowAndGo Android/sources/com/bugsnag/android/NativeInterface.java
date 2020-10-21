package com.bugsnag.android;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class NativeInterface {
    private static Charset UTF8Charset = Charset.defaultCharset();
    @SuppressLint({"StaticFieldLeak"})
    private static Client client;

    public enum MessageType {
        ADD_BREADCRUMB,
        ADD_METADATA,
        CLEAR_BREADCRUMBS,
        CLEAR_METADATA_TAB,
        DELIVER_PENDING,
        INSTALL,
        ENABLE_NATIVE_CRASH_REPORTING,
        DISABLE_NATIVE_CRASH_REPORTING,
        NOTIFY_HANDLED,
        NOTIFY_UNHANDLED,
        REMOVE_METADATA,
        START_SESSION,
        STOP_SESSION,
        UPDATE_APP_VERSION,
        UPDATE_BUILD_UUID,
        UPDATE_CONTEXT,
        UPDATE_IN_FOREGROUND,
        UPDATE_LOW_MEMORY,
        UPDATE_METADATA,
        UPDATE_ORIENTATION,
        UPDATE_NOTIFY_RELEASE_STAGES,
        UPDATE_RELEASE_STAGE,
        UPDATE_USER_EMAIL,
        UPDATE_USER_NAME,
        UPDATE_USER_ID
    }

    public static class Message {
        @NonNull
        public final MessageType type;
        @Nullable
        public final Object value;

        public Message(@NonNull MessageType messageType, @Nullable Object obj) {
            this.type = messageType;
            this.value = obj;
        }
    }

    @NonNull
    private static Client getClient() {
        if (client != null) {
            return client;
        }
        return Bugsnag.getClient();
    }

    public static void setClient(@NonNull Client client2) {
        client = client2;
    }

    @Deprecated
    public static void configureClientObservers(@NonNull Client client2) {
        setClient(client2);
    }

    @Nullable
    public static String getContext() {
        return getClient().getContext();
    }

    public static boolean getLoggingEnabled() {
        return Logger.getEnabled();
    }

    @NonNull
    public static String getNativeReportPath() {
        return getClient().appContext.getCacheDir().getAbsolutePath() + "/bugsnag-native/";
    }

    @NonNull
    public static Map<String, String> getUserData() {
        HashMap hashMap = new HashMap();
        User user = getClient().getUser();
        hashMap.put("id", user.getId());
        hashMap.put("name", user.getName());
        hashMap.put("email", user.getEmail());
        return hashMap;
    }

    @NonNull
    public static Map<String, Object> getAppData() {
        HashMap hashMap = new HashMap();
        AppData appData = getClient().getAppData();
        hashMap.putAll(appData.getAppData());
        hashMap.putAll(appData.getAppDataMetaData());
        return hashMap;
    }

    @NonNull
    public static Map<String, Object> getDeviceData() {
        HashMap hashMap = new HashMap();
        DeviceData deviceData = getClient().getDeviceData();
        hashMap.putAll(deviceData.getDeviceMetaData());
        hashMap.putAll(deviceData.getDeviceData());
        return hashMap;
    }

    @NonNull
    public static String[] getCpuAbi() {
        return getClient().deviceData.cpuAbi;
    }

    @NonNull
    public static Map<String, Object> getMetaData() {
        return new HashMap(getClient().getMetaData().store);
    }

    @NonNull
    public static List<Breadcrumb> getBreadcrumbs() {
        return new ArrayList(getClient().breadcrumbs.store);
    }

    public static void setUser(@Nullable String str, @Nullable String str2, @Nullable String str3) {
        Client client2 = getClient();
        client2.setUserId(str);
        client2.setUserEmail(str2);
        client2.setUserName(str3);
    }

    public static void setUser(@Nullable byte[] bArr, @Nullable byte[] bArr2, @Nullable byte[] bArr3) {
        String str;
        String str2 = null;
        String str3 = bArr == null ? null : new String(bArr, UTF8Charset);
        if (bArr2 == null) {
            str = null;
        } else {
            str = new String(bArr2, UTF8Charset);
        }
        if (bArr3 != null) {
            str2 = new String(bArr3, UTF8Charset);
        }
        setUser(str3, str, str2);
    }

    public static void leaveBreadcrumb(@NonNull String str, @NonNull BreadcrumbType breadcrumbType) {
        if (str != null) {
            getClient().leaveBreadcrumb(str, breadcrumbType, Collections.emptyMap());
        }
    }

    public static void leaveBreadcrumb(@NonNull byte[] bArr, @NonNull BreadcrumbType breadcrumbType) {
        if (bArr != null) {
            getClient().leaveBreadcrumb(new String(bArr, UTF8Charset), breadcrumbType, Collections.emptyMap());
        }
    }

    public static void leaveBreadcrumb(@NonNull String str, @NonNull String str2, @NonNull Map<String, String> map) {
        String upperCase = str2.toUpperCase(Locale.US);
        if (map == null) {
            map = new HashMap<>();
        }
        getClient().leaveBreadcrumb(str, BreadcrumbType.valueOf(upperCase), map);
    }

    public static void clearTab(@NonNull String str) {
        getClient().clearTab(str);
    }

    public static void addToTab(@NonNull String str, @NonNull String str2, @Nullable Object obj) {
        getClient().addToTab(str, str2, obj);
    }

    public static void setReleaseStage(@Nullable String str) {
        getClient().setReleaseStage(str);
    }

    @Nullable
    public static String getReleaseStage() {
        return getClient().getConfig().getReleaseStage();
    }

    @NonNull
    public static String getSessionEndpoint() {
        return getClient().getConfig().getSessionEndpoint();
    }

    @NonNull
    public static String getEndpoint() {
        return getClient().getConfig().getEndpoint();
    }

    public static void setSessionEndpoint(@NonNull String str) {
        getClient().getConfig().setSessionEndpoint(str);
    }

    public static void setEndpoint(@NonNull String str) {
        getClient().getConfig().setEndpoint(str);
    }

    public static void setContext(@Nullable String str) {
        getClient().setContext(str);
    }

    public static void setAppVersion(@NonNull String str) {
        getClient().setAppVersion(str);
    }

    public static void setBinaryArch(@NonNull String str) {
        getClient().setBinaryArch(str);
    }

    public static void enableAnrReporting() {
        getClient().enableAnrReporting();
    }

    public static void disableAnrReporting() {
        getClient().disableAnrReporting();
    }

    public static void enableNdkCrashReporting() {
        getClient().enableNdkCrashReporting();
    }

    public static void disableNdkCrashReporting() {
        getClient().disableNdkCrashReporting();
    }

    public static void enableUncaughtJavaExceptionReporting() {
        getClient().enableExceptionHandler();
    }

    public static void disableUncaughtJavaExceptionReporting() {
        getClient().disableExceptionHandler();
    }

    @NonNull
    public static String getAppVersion() {
        return getClient().getConfig().getAppVersion();
    }

    @Nullable
    public static String[] getNotifyReleaseStages() {
        return getClient().getConfig().getNotifyReleaseStages();
    }

    public static void setNotifyReleaseStages(@Nullable String[] strArr) {
        getClient().getConfig().setNotifyReleaseStages(strArr);
    }

    public static void registerSession(long j, @Nullable String str, int i, int i2) {
        Client client2 = getClient();
        client2.getSessionTracker().registerExistingSession(j > 0 ? new Date(j) : null, str, client2.getUser(), i, i2);
    }

    public static void deliverReport(@Nullable byte[] bArr, @NonNull byte[] bArr2) {
        String str;
        if (bArr2 != null) {
            String str2 = new String(bArr2, UTF8Charset);
            if (bArr == null) {
                str = null;
            } else {
                str = new String(bArr, UTF8Charset);
            }
            Client client2 = getClient();
            if (str == null || str.length() == 0 || client2.getConfig().shouldNotifyForReleaseStage(str)) {
                client2.getErrorStore().enqueueContentForDelivery(str2);
                client2.getErrorStore().flushAsync();
            }
        }
    }

    public static void notify(@NonNull byte[] bArr, @NonNull byte[] bArr2, @NonNull Severity severity, @NonNull StackTraceElement[] stackTraceElementArr) {
        if (bArr != null && bArr2 != null && stackTraceElementArr != null) {
            notify(new String(bArr, UTF8Charset), new String(bArr2, UTF8Charset), severity, stackTraceElementArr);
        }
    }

    public static void notify(@NonNull String str, @NonNull String str2, @NonNull final Severity severity, @NonNull StackTraceElement[] stackTraceElementArr) {
        if (str != null && str2 != null && stackTraceElementArr != null) {
            getClient().notify(str, str2, stackTraceElementArr, new Callback() {
                public void beforeNotify(@NonNull Report report) {
                    Error error = report.getError();
                    if (error != null) {
                        if (severity != null) {
                            error.setSeverity(severity);
                        }
                        error.getExceptions().setExceptionType("c");
                    }
                }
            });
        }
    }
}
