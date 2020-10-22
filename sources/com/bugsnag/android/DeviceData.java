package com.bugsnag.android;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Build;
import android.os.Environment;
import android.provider.Settings;
import android.util.DisplayMetrics;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.p005os.EnvironmentCompat;
import com.amplitude.api.DeviceInfo;
import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;

class DeviceData {
    private static final String INSTALL_ID_KEY = "install.iud";
    private static final String[] ROOT_INDICATORS = {"/system/xbin/su", "/system/bin/su", "/system/app/Superuser.apk", "/system/app/SuperSU.apk", "/system/app/Superuser", "/system/app/SuperSU", "/system/xbin/daemonsu", "/su/bin"};
    private final Context appContext;
    private final Connectivity connectivity;
    @NonNull
    final String[] cpuAbi;
    private final DisplayMetrics displayMetrics;
    @Nullable
    final Integer dpi;
    private final boolean emulator;

    /* renamed from: id */
    private final String f64id;
    @NonNull
    final String locale;
    private final Resources resources;
    private final boolean rooted;
    @Nullable
    final Float screenDensity;
    @Nullable
    final String screenResolution;
    private final SharedPreferences sharedPrefs;

    DeviceData(Connectivity connectivity2, Context context, Resources resources2, SharedPreferences sharedPreferences) {
        this.connectivity = connectivity2;
        this.appContext = context;
        this.resources = resources2;
        this.sharedPrefs = sharedPreferences;
        if (resources2 != null) {
            this.displayMetrics = resources2.getDisplayMetrics();
        } else {
            this.displayMetrics = null;
        }
        this.screenDensity = getScreenDensity();
        this.dpi = getScreenDensityDpi();
        this.screenResolution = getScreenResolution();
        this.locale = getLocale();
        this.cpuAbi = getCpuAbi();
        this.emulator = isEmulator();
        this.f64id = retrieveUniqueInstallId();
        this.rooted = isRooted();
    }

    /* access modifiers changed from: package-private */
    public Map<String, Object> getDeviceDataSummary() {
        HashMap hashMap = new HashMap();
        hashMap.put("manufacturer", Build.MANUFACTURER);
        hashMap.put("model", Build.MODEL);
        hashMap.put("jailbroken", Boolean.valueOf(this.rooted));
        hashMap.put("osName", DeviceInfo.OS_NAME);
        hashMap.put("osVersion", Build.VERSION.RELEASE);
        hashMap.put("cpuAbi", this.cpuAbi);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("androidApiLevel", Integer.valueOf(Build.VERSION.SDK_INT));
        hashMap2.put("osBuild", Build.DISPLAY);
        hashMap.put("runtimeVersions", hashMap2);
        return hashMap;
    }

    /* access modifiers changed from: package-private */
    public Map<String, Object> getDeviceData() {
        Map<String, Object> deviceDataSummary = getDeviceDataSummary();
        deviceDataSummary.put("id", this.f64id);
        deviceDataSummary.put("freeMemory", Long.valueOf(calculateFreeMemory()));
        deviceDataSummary.put("totalMemory", Long.valueOf(calculateTotalMemory()));
        deviceDataSummary.put("freeDisk", Long.valueOf(calculateFreeDisk()));
        deviceDataSummary.put("orientation", calculateOrientation());
        return deviceDataSummary;
    }

    /* access modifiers changed from: package-private */
    public Map<String, Object> getDeviceMetaData() {
        HashMap hashMap = new HashMap();
        hashMap.put("batteryLevel", getBatteryLevel());
        hashMap.put("charging", isCharging());
        hashMap.put("locationStatus", getLocationStatus());
        hashMap.put("networkAccess", getNetworkAccess());
        hashMap.put("time", getTime());
        hashMap.put("brand", Build.BRAND);
        hashMap.put("locale", this.locale);
        hashMap.put("screenDensity", this.screenDensity);
        hashMap.put("dpi", this.dpi);
        hashMap.put("emulator", Boolean.valueOf(this.emulator));
        hashMap.put("screenResolution", this.screenResolution);
        return hashMap;
    }

    /* access modifiers changed from: package-private */
    public String getId() {
        return this.f64id;
    }

    private boolean isRooted() {
        if (Build.TAGS != null && Build.TAGS.contains("test-keys")) {
            return true;
        }
        try {
            for (String file : ROOT_INDICATORS) {
                if (new File(file).exists()) {
                    return true;
                }
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    private boolean isEmulator() {
        String str = Build.FINGERPRINT;
        return str.startsWith(EnvironmentCompat.MEDIA_UNKNOWN) || str.contains("generic") || str.contains("vbox");
    }

    @Nullable
    private Float getScreenDensity() {
        if (this.displayMetrics != null) {
            return Float.valueOf(this.displayMetrics.density);
        }
        return null;
    }

    @Nullable
    private Integer getScreenDensityDpi() {
        if (this.displayMetrics != null) {
            return Integer.valueOf(this.displayMetrics.densityDpi);
        }
        return null;
    }

    @Nullable
    private String getScreenResolution() {
        if (this.displayMetrics == null) {
            return null;
        }
        int max = Math.max(this.displayMetrics.widthPixels, this.displayMetrics.heightPixels);
        int min = Math.min(this.displayMetrics.widthPixels, this.displayMetrics.heightPixels);
        return String.format(Locale.US, "%dx%d", new Object[]{Integer.valueOf(max), Integer.valueOf(min)});
    }

    static long calculateTotalMemory() {
        Runtime runtime = Runtime.getRuntime();
        if (runtime.maxMemory() != Long.MAX_VALUE) {
            return runtime.maxMemory();
        }
        return runtime.totalMemory();
    }

    @NonNull
    private String getLocale() {
        return Locale.getDefault().toString();
    }

    @Nullable
    private String retrieveUniqueInstallId() {
        String string = this.sharedPrefs.getString(INSTALL_ID_KEY, (String) null);
        if (string != null) {
            return string;
        }
        String uuid = UUID.randomUUID().toString();
        this.sharedPrefs.edit().putString(INSTALL_ID_KEY, uuid).apply();
        return uuid;
    }

    @NonNull
    private String[] getCpuAbi() {
        if (Build.VERSION.SDK_INT >= 21) {
            return SupportedAbiWrapper.getSupportedAbis();
        }
        return Abi2Wrapper.getAbi1andAbi2();
    }

    /* access modifiers changed from: package-private */
    @SuppressLint({"UsableSpace"})
    public long calculateFreeDisk() {
        return Environment.getDataDirectory().getUsableSpace();
    }

    private long calculateFreeMemory() {
        Runtime runtime = Runtime.getRuntime();
        if (runtime.maxMemory() != Long.MAX_VALUE) {
            return (runtime.maxMemory() - runtime.totalMemory()) + runtime.freeMemory();
        }
        return runtime.freeMemory();
    }

    @Nullable
    private String calculateOrientation() {
        if (this.resources != null) {
            switch (this.resources.getConfiguration().orientation) {
                case 1:
                    return "portrait";
                case 2:
                    return "landscape";
            }
        }
        return null;
    }

    @Nullable
    private Float getBatteryLevel() {
        try {
            Intent registerReceiver = this.appContext.registerReceiver((BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            return Float.valueOf(((float) registerReceiver.getIntExtra("level", -1)) / ((float) registerReceiver.getIntExtra("scale", -1)));
        } catch (Exception unused) {
            Logger.warn("Could not get batteryLevel");
            return null;
        }
    }

    @Nullable
    private Boolean isCharging() {
        boolean z;
        try {
            int intExtra = this.appContext.registerReceiver((BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED")).getIntExtra("status", -1);
            if (intExtra != 2) {
                if (intExtra != 5) {
                    z = false;
                    return Boolean.valueOf(z);
                }
            }
            z = true;
            return Boolean.valueOf(z);
        } catch (Exception unused) {
            Logger.warn("Could not get charging status");
            return null;
        }
    }

    @Nullable
    private String getLocationStatus() {
        try {
            String string = Settings.Secure.getString(this.appContext.getContentResolver(), "location_providers_allowed");
            return (string == null || string.length() <= 0) ? "disallowed" : "allowed";
        } catch (Exception unused) {
            Logger.warn("Could not get locationStatus");
            return null;
        }
    }

    @Nullable
    private String getNetworkAccess() {
        return this.connectivity.retrieveNetworkAccessState();
    }

    @NonNull
    private String getTime() {
        return DateUtils.toIso8601(new Date());
    }

    static class SupportedAbiWrapper {
        SupportedAbiWrapper() {
        }

        @RequiresApi(21)
        static String[] getSupportedAbis() {
            return Build.SUPPORTED_ABIS;
        }
    }

    static class Abi2Wrapper {
        Abi2Wrapper() {
        }

        @NonNull
        static String[] getAbi1andAbi2() {
            return new String[]{Build.CPU_ABI, Build.CPU_ABI2};
        }
    }
}
