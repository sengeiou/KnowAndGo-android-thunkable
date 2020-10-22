package com.bugsnag.android;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Map;

public final class Bugsnag {
    @SuppressLint({"StaticFieldLeak"})
    static Client client;
    private static final Object lock = new Object();

    private Bugsnag() {
    }

    @NonNull
    public static Client init(@NonNull Context context) {
        return init(context, (String) null, true);
    }

    @NonNull
    public static Client init(@NonNull Context context, @Nullable String str) {
        return init(context, str, true);
    }

    @NonNull
    public static Client init(@NonNull Context context, @Nullable String str, boolean z) {
        return init(context, ConfigFactory.createNewConfiguration(context, str, z));
    }

    @NonNull
    public static Client init(@NonNull Context context, @NonNull Configuration configuration) {
        synchronized (lock) {
            if (client == null) {
                client = new Client(context, configuration);
            } else {
                logClientInitWarning();
            }
        }
        return client;
    }

    private static void logClientInitWarning() {
        Logger.warn("It appears that Bugsnag.init() was called more than once. Subsequent calls have no effect, but may indicate that Bugsnag is not integrated in an Application subclass, which can lead to undesired behaviour.");
    }

    public static void setAppVersion(@NonNull String str) {
        getClient().setAppVersion(str);
    }

    @Nullable
    public static String getContext() {
        return getClient().getContext();
    }

    public static void setContext(@Nullable String str) {
        getClient().setContext(str);
    }

    @Deprecated
    public static void setEndpoint(@NonNull String str) {
        getClient().setEndpoint(str);
    }

    public static void setBuildUUID(@Nullable String str) {
        getClient().setBuildUUID(str);
    }

    public static void setFilters(@Nullable String... strArr) {
        getClient().setFilters(strArr);
    }

    public static void setIgnoreClasses(@Nullable String... strArr) {
        getClient().setIgnoreClasses(strArr);
    }

    public static void setNotifyReleaseStages(@Nullable String... strArr) {
        getClient().setNotifyReleaseStages(strArr);
    }

    @Deprecated
    public static void setProjectPackages(@Nullable String... strArr) {
        getClient().setProjectPackages(strArr);
    }

    public static void setReleaseStage(@Nullable String str) {
        getClient().setReleaseStage(str);
    }

    public static void setSendThreads(boolean z) {
        getClient().setSendThreads(z);
    }

    public static void setAutoCaptureSessions(boolean z) {
        getClient().setAutoCaptureSessions(z);
    }

    public static void setUser(@Nullable String str, @Nullable String str2, @Nullable String str3) {
        getClient().setUser(str, str2, str3);
    }

    public static void clearUser() {
        getClient().clearUser();
    }

    public static void setUserId(@Nullable String str) {
        getClient().setUserId(str);
    }

    public static void setUserEmail(@Nullable String str) {
        getClient().setUserEmail(str);
    }

    public static void setUserName(@Nullable String str) {
        getClient().setUserName(str);
    }

    @Deprecated
    public static void setErrorReportApiClient(@NonNull ErrorReportApiClient errorReportApiClient) {
        getClient().setErrorReportApiClient(errorReportApiClient);
    }

    @Deprecated
    public static void setSessionTrackingApiClient(@NonNull SessionTrackingApiClient sessionTrackingApiClient) {
        getClient().setSessionTrackingApiClient(sessionTrackingApiClient);
    }

    public static void beforeNotify(@NonNull BeforeNotify beforeNotify) {
        getClient().beforeNotify(beforeNotify);
    }

    public static void beforeRecordBreadcrumb(@NonNull BeforeRecordBreadcrumb beforeRecordBreadcrumb) {
        getClient().beforeRecordBreadcrumb(beforeRecordBreadcrumb);
    }

    public static void notify(@NonNull Throwable th) {
        getClient().notify(th);
    }

    public static void notify(@NonNull Throwable th, @Nullable Callback callback) {
        getClient().notify(th, callback);
    }

    public static void notify(@NonNull String str, @NonNull String str2, @NonNull StackTraceElement[] stackTraceElementArr, @Nullable Callback callback) {
        getClient().notify(str, str2, stackTraceElementArr, callback);
    }

    public static void notify(@NonNull Throwable th, @NonNull Severity severity) {
        getClient().notify(th, severity);
    }

    @Deprecated
    public static void notify(@NonNull Throwable th, @NonNull final MetaData metaData) {
        getClient().notify(th, (Callback) new Callback() {
            public void beforeNotify(@NonNull Report report) {
                report.getError().setMetaData(metaData);
            }
        });
    }

    @Deprecated
    public static void notify(@NonNull Throwable th, @NonNull final Severity severity, @NonNull final MetaData metaData) {
        getClient().notify(th, (Callback) new Callback() {
            public void beforeNotify(@NonNull Report report) {
                report.getError().setSeverity(severity);
                report.getError().setMetaData(metaData);
            }
        });
    }

    @Deprecated
    public static void notify(@NonNull String str, @NonNull String str2, @NonNull StackTraceElement[] stackTraceElementArr, @NonNull final Severity severity, @NonNull final MetaData metaData) {
        getClient().notify(str, str2, stackTraceElementArr, new Callback() {
            public void beforeNotify(@NonNull Report report) {
                report.getError().setSeverity(severity);
                report.getError().setMetaData(metaData);
            }
        });
    }

    @Deprecated
    public static void notify(@NonNull String str, @NonNull String str2, @Nullable final String str3, @NonNull StackTraceElement[] stackTraceElementArr, @NonNull final Severity severity, @NonNull final MetaData metaData) {
        getClient().notify(str, str2, stackTraceElementArr, new Callback() {
            public void beforeNotify(@NonNull Report report) {
                report.getError().setSeverity(severity);
                report.getError().setMetaData(metaData);
                report.getError().setContext(str3);
            }
        });
    }

    public static void internalClientNotify(@NonNull Throwable th, @NonNull Map<String, Object> map, boolean z, @Nullable Callback callback) {
        getClient().internalClientNotify(th, map, z, callback);
    }

    public static void addToTab(@NonNull String str, @NonNull String str2, @Nullable Object obj) {
        getClient().addToTab(str, str2, obj);
    }

    public static void clearTab(@NonNull String str) {
        getClient().clearTab(str);
    }

    @NonNull
    public static MetaData getMetaData() {
        return getClient().getMetaData();
    }

    public static void setMetaData(@NonNull MetaData metaData) {
        getClient().setMetaData(metaData);
    }

    public static void leaveBreadcrumb(@NonNull String str) {
        getClient().leaveBreadcrumb(str);
    }

    public static void leaveBreadcrumb(@NonNull String str, @NonNull BreadcrumbType breadcrumbType, @NonNull Map<String, String> map) {
        getClient().leaveBreadcrumb(str, breadcrumbType, map);
    }

    @Deprecated
    public static void setMaxBreadcrumbs(int i) {
        getClient().config.setMaxBreadcrumbs(i);
    }

    public static void clearBreadcrumbs() {
        getClient().clearBreadcrumbs();
    }

    public static void enableExceptionHandler() {
        getClient().enableExceptionHandler();
    }

    public static void disableExceptionHandler() {
        getClient().disableExceptionHandler();
    }

    public static void setLoggingEnabled(boolean z) {
        getClient().setLoggingEnabled(z);
    }

    public static void startSession() {
        getClient().startSession();
    }

    public static boolean resumeSession() {
        return getClient().resumeSession();
    }

    public static void stopSession() {
        getClient().stopSession();
    }

    @NonNull
    public static Client getClient() {
        if (client != null) {
            return client;
        }
        throw new IllegalStateException("You must call Bugsnag.init before any other Bugsnag methods");
    }
}
