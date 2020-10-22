package com.bugsnag.android;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.amplitude.api.DeviceInfo;
import java.util.HashMap;
import java.util.Map;

class AppData {
    static final String RELEASE_STAGE_DEVELOPMENT = "development";
    static final String RELEASE_STAGE_PRODUCTION = "production";
    private static final long startTimeMs = SystemClock.elapsedRealtime();
    private final Context appContext;
    @Nullable
    final String appName;
    @Nullable
    private ApplicationInfo applicationInfo;
    private String binaryArch = null;
    private final Configuration config;
    @Nullable
    private PackageInfo packageInfo;
    private PackageManager packageManager;
    private final String packageName;
    private final SessionTracker sessionTracker;

    AppData(Context context, PackageManager packageManager2, Configuration configuration, SessionTracker sessionTracker2) {
        this.appContext = context;
        this.packageManager = packageManager2;
        this.config = configuration;
        this.sessionTracker = sessionTracker2;
        this.packageName = context.getPackageName();
        try {
            this.packageManager = packageManager2;
            this.packageInfo = this.packageManager.getPackageInfo(this.packageName, 0);
            this.applicationInfo = this.packageManager.getApplicationInfo(this.packageName, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            Logger.warn("Could not retrieve package/application information for " + this.packageName);
        }
        this.appName = getAppName();
    }

    /* access modifiers changed from: package-private */
    public Map<String, Object> getAppDataSummary() {
        HashMap hashMap = new HashMap();
        hashMap.put("type", calculateNotifierType());
        hashMap.put("releaseStage", guessReleaseStage());
        hashMap.put("version", calculateVersionName());
        hashMap.put("versionCode", calculateVersionCode());
        hashMap.put("codeBundleId", this.config.getCodeBundleId());
        return hashMap;
    }

    /* access modifiers changed from: package-private */
    public Map<String, Object> getAppData() {
        Map<String, Object> appDataSummary = getAppDataSummary();
        appDataSummary.put("id", this.packageName);
        appDataSummary.put("buildUUID", this.config.getBuildUUID());
        appDataSummary.put("duration", Long.valueOf(getDurationMs()));
        appDataSummary.put("durationInForeground", calculateDurationInForeground());
        appDataSummary.put("inForeground", this.sessionTracker.isInForeground());
        appDataSummary.put("packageName", this.packageName);
        appDataSummary.put("binaryArch", this.binaryArch);
        return appDataSummary;
    }

    /* access modifiers changed from: package-private */
    public Map<String, Object> getAppDataMetaData() {
        HashMap hashMap = new HashMap();
        hashMap.put("name", this.appName);
        hashMap.put("packageName", this.packageName);
        hashMap.put("versionName", calculateVersionName());
        hashMap.put("activeScreen", getActiveScreenClass());
        hashMap.put("memoryUsage", Long.valueOf(getMemoryUsage()));
        hashMap.put("lowMemory", isLowMemory());
        return hashMap;
    }

    /* access modifiers changed from: package-private */
    public void setBinaryArch(String str) {
        this.binaryArch = str;
    }

    static long getDurationMs() {
        return SystemClock.elapsedRealtime() - startTimeMs;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public Long calculateDurationInForeground() {
        return this.sessionTracker.getDurationInForegroundMs(System.currentTimeMillis());
    }

    /* access modifiers changed from: package-private */
    public String getActiveScreenClass() {
        return this.sessionTracker.getContextActivity();
    }

    @NonNull
    private String calculateNotifierType() {
        String notifierType = this.config.getNotifierType();
        return notifierType != null ? notifierType : DeviceInfo.OS_NAME;
    }

    @Nullable
    private Integer calculateVersionCode() {
        Integer versionCode = this.config.getVersionCode();
        if (versionCode != null) {
            return versionCode;
        }
        if (this.packageInfo != null) {
            return Integer.valueOf(this.packageInfo.versionCode);
        }
        return null;
    }

    @Nullable
    private String calculateVersionName() {
        String appVersion = this.config.getAppVersion();
        if (appVersion != null) {
            return appVersion;
        }
        if (this.packageInfo != null) {
            return this.packageInfo.versionName;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public String guessReleaseStage() {
        String releaseStage = this.config.getReleaseStage();
        if (releaseStage != null) {
            return releaseStage;
        }
        return (this.applicationInfo == null || (this.applicationInfo.flags & 2) == 0) ? RELEASE_STAGE_PRODUCTION : RELEASE_STAGE_DEVELOPMENT;
    }

    @Nullable
    private String getAppName() {
        if (this.packageManager == null || this.applicationInfo == null) {
            return null;
        }
        return this.packageManager.getApplicationLabel(this.applicationInfo).toString();
    }

    private long getMemoryUsage() {
        Runtime runtime = Runtime.getRuntime();
        return runtime.totalMemory() - runtime.freeMemory();
    }

    @Nullable
    private Boolean isLowMemory() {
        try {
            ActivityManager activityManager = (ActivityManager) this.appContext.getSystemService("activity");
            if (activityManager == null) {
                return null;
            }
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            activityManager.getMemoryInfo(memoryInfo);
            return Boolean.valueOf(memoryInfo.lowMemory);
        } catch (Exception unused) {
            Logger.warn("Could not check lowMemory status");
            return null;
        }
    }
}
