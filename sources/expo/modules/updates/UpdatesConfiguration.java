package expo.modules.updates;

import android.net.Uri;
import androidx.annotation.Nullable;
import java.util.Map;

public class UpdatesConfiguration {
    private static final String TAG = "UpdatesConfiguration";
    public static final String UPDATES_CONFIGURATION_CHECK_ON_LAUNCH_KEY = "checkOnLaunch";
    public static final String UPDATES_CONFIGURATION_ENABLED_KEY = "enabled";
    private static final int UPDATES_CONFIGURATION_LAUNCH_WAIT_MS_DEFAULT_VALUE = 0;
    public static final String UPDATES_CONFIGURATION_LAUNCH_WAIT_MS_KEY = "launchWaitMs";
    private static final String UPDATES_CONFIGURATION_RELEASE_CHANNEL_DEFAULT_VALUE = "default";
    public static final String UPDATES_CONFIGURATION_RELEASE_CHANNEL_KEY = "releaseChannel";
    public static final String UPDATES_CONFIGURATION_RUNTIME_VERSION_KEY = "runtimeVersion";
    public static final String UPDATES_CONFIGURATION_SDK_VERSION_KEY = "sdkVersion";
    public static final String UPDATES_CONFIGURATION_UPDATE_URL_KEY = "updateUrl";
    private CheckAutomaticallyConfiguration mCheckOnLaunch = CheckAutomaticallyConfiguration.ALWAYS;
    private boolean mIsEnabled;
    private int mLaunchWaitMs = 0;
    private String mReleaseChannel = UPDATES_CONFIGURATION_RELEASE_CHANNEL_DEFAULT_VALUE;
    private String mRuntimeVersion;
    private String mSdkVersion;
    private Uri mUpdateUrl;

    public enum CheckAutomaticallyConfiguration {
        NEVER,
        WIFI_ONLY,
        ALWAYS
    }

    public boolean isEnabled() {
        return this.mIsEnabled;
    }

    public Uri getUpdateUrl() {
        return this.mUpdateUrl;
    }

    public String getReleaseChannel() {
        return this.mReleaseChannel;
    }

    public String getSdkVersion() {
        return this.mSdkVersion;
    }

    public String getRuntimeVersion() {
        return this.mRuntimeVersion;
    }

    public CheckAutomaticallyConfiguration getCheckOnLaunch() {
        return this.mCheckOnLaunch;
    }

    public int getLaunchWaitMs() {
        return this.mLaunchWaitMs;
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x006f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public expo.modules.updates.UpdatesConfiguration loadValuesFromMetadata(android.content.Context r5) {
        /*
            r4 = this;
            android.content.pm.PackageManager r0 = r5.getPackageManager()     // Catch:{ Exception -> 0x008f }
            java.lang.String r5 = r5.getPackageName()     // Catch:{ Exception -> 0x008f }
            r1 = 128(0x80, float:1.794E-43)
            android.content.pm.ApplicationInfo r5 = r0.getApplicationInfo(r5, r1)     // Catch:{ Exception -> 0x008f }
            android.os.Bundle r0 = r5.metaData     // Catch:{ Exception -> 0x008f }
            java.lang.String r1 = "expo.modules.updates.EXPO_UPDATE_URL"
            java.lang.String r0 = r0.getString(r1)     // Catch:{ Exception -> 0x008f }
            r1 = 0
            if (r0 != 0) goto L_0x001b
            r0 = r1
            goto L_0x001f
        L_0x001b:
            android.net.Uri r0 = android.net.Uri.parse(r0)     // Catch:{ Exception -> 0x008f }
        L_0x001f:
            r4.mUpdateUrl = r0     // Catch:{ Exception -> 0x008f }
            android.os.Bundle r0 = r5.metaData     // Catch:{ Exception -> 0x008f }
            java.lang.String r2 = "expo.modules.updates.ENABLED"
            r3 = 1
            boolean r0 = r0.getBoolean(r2, r3)     // Catch:{ Exception -> 0x008f }
            r4.mIsEnabled = r0     // Catch:{ Exception -> 0x008f }
            android.os.Bundle r0 = r5.metaData     // Catch:{ Exception -> 0x008f }
            java.lang.String r2 = "expo.modules.updates.EXPO_SDK_VERSION"
            java.lang.String r0 = r0.getString(r2)     // Catch:{ Exception -> 0x008f }
            r4.mSdkVersion = r0     // Catch:{ Exception -> 0x008f }
            android.os.Bundle r0 = r5.metaData     // Catch:{ Exception -> 0x008f }
            java.lang.String r2 = "expo.modules.updates.EXPO_RELEASE_CHANNEL"
            java.lang.String r3 = "default"
            java.lang.String r0 = r0.getString(r2, r3)     // Catch:{ Exception -> 0x008f }
            r4.mReleaseChannel = r0     // Catch:{ Exception -> 0x008f }
            android.os.Bundle r0 = r5.metaData     // Catch:{ Exception -> 0x008f }
            java.lang.String r2 = "expo.modules.updates.EXPO_UPDATES_LAUNCH_WAIT_MS"
            r3 = 0
            int r0 = r0.getInt(r2, r3)     // Catch:{ Exception -> 0x008f }
            r4.mLaunchWaitMs = r0     // Catch:{ Exception -> 0x008f }
            android.os.Bundle r0 = r5.metaData     // Catch:{ Exception -> 0x008f }
            java.lang.String r2 = "expo.modules.updates.EXPO_RUNTIME_VERSION"
            java.lang.Object r0 = r0.get(r2)     // Catch:{ Exception -> 0x008f }
            if (r0 != 0) goto L_0x0058
            goto L_0x005c
        L_0x0058:
            java.lang.String r1 = java.lang.String.valueOf(r0)     // Catch:{ Exception -> 0x008f }
        L_0x005c:
            r4.mRuntimeVersion = r1     // Catch:{ Exception -> 0x008f }
            android.os.Bundle r5 = r5.metaData     // Catch:{ Exception -> 0x008f }
            java.lang.String r0 = "expo.modules.updates.EXPO_UPDATES_CHECK_ON_LAUNCH"
            java.lang.String r1 = "ALWAYS"
            java.lang.String r5 = r5.getString(r0, r1)     // Catch:{ Exception -> 0x008f }
            expo.modules.updates.UpdatesConfiguration$CheckAutomaticallyConfiguration r0 = expo.modules.updates.UpdatesConfiguration.CheckAutomaticallyConfiguration.valueOf(r5)     // Catch:{ IllegalArgumentException -> 0x006f }
            r4.mCheckOnLaunch = r0     // Catch:{ IllegalArgumentException -> 0x006f }
            goto L_0x0097
        L_0x006f:
            java.lang.String r0 = TAG     // Catch:{ Exception -> 0x008f }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x008f }
            r1.<init>()     // Catch:{ Exception -> 0x008f }
            java.lang.String r2 = "Invalid value "
            r1.append(r2)     // Catch:{ Exception -> 0x008f }
            r1.append(r5)     // Catch:{ Exception -> 0x008f }
            java.lang.String r5 = " for expo.modules.updates.EXPO_UPDATES_CHECK_ON_LAUNCH in AndroidManifest; defaulting to ALWAYS"
            r1.append(r5)     // Catch:{ Exception -> 0x008f }
            java.lang.String r5 = r1.toString()     // Catch:{ Exception -> 0x008f }
            android.util.Log.e(r0, r5)     // Catch:{ Exception -> 0x008f }
            expo.modules.updates.UpdatesConfiguration$CheckAutomaticallyConfiguration r5 = expo.modules.updates.UpdatesConfiguration.CheckAutomaticallyConfiguration.ALWAYS     // Catch:{ Exception -> 0x008f }
            r4.mCheckOnLaunch = r5     // Catch:{ Exception -> 0x008f }
            goto L_0x0097
        L_0x008f:
            r5 = move-exception
            java.lang.String r0 = TAG
            java.lang.String r1 = "Could not read expo-updates configuration data in AndroidManifest"
            android.util.Log.e(r0, r1, r5)
        L_0x0097:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.updates.UpdatesConfiguration.loadValuesFromMetadata(android.content.Context):expo.modules.updates.UpdatesConfiguration");
    }

    public UpdatesConfiguration loadValuesFromMap(Map<String, Object> map) {
        Boolean bool = (Boolean) readValueCheckingType(map, "enabled", Boolean.class);
        if (bool != null) {
            this.mIsEnabled = bool.booleanValue();
        }
        Uri uri = (Uri) readValueCheckingType(map, UPDATES_CONFIGURATION_UPDATE_URL_KEY, Uri.class);
        if (uri != null) {
            this.mUpdateUrl = uri;
        }
        String str = (String) readValueCheckingType(map, UPDATES_CONFIGURATION_RELEASE_CHANNEL_KEY, String.class);
        if (str != null) {
            this.mReleaseChannel = str;
        }
        String str2 = (String) readValueCheckingType(map, UPDATES_CONFIGURATION_SDK_VERSION_KEY, String.class);
        if (str2 != null) {
            this.mSdkVersion = str2;
        }
        String str3 = (String) readValueCheckingType(map, UPDATES_CONFIGURATION_RUNTIME_VERSION_KEY, String.class);
        if (str3 != null) {
            this.mRuntimeVersion = str3;
        }
        String str4 = (String) readValueCheckingType(map, UPDATES_CONFIGURATION_CHECK_ON_LAUNCH_KEY, String.class);
        if (str4 != null) {
            try {
                this.mCheckOnLaunch = CheckAutomaticallyConfiguration.valueOf(str4);
            } catch (IllegalArgumentException unused) {
                throw new AssertionError("UpdatesConfiguration failed to initialize: invalid value " + str4 + " provided for checkOnLaunch");
            }
        }
        Integer num = (Integer) readValueCheckingType(map, UPDATES_CONFIGURATION_LAUNCH_WAIT_MS_KEY, Integer.class);
        if (num != null) {
            this.mLaunchWaitMs = num.intValue();
        }
        return this;
    }

    @Nullable
    private <T> T readValueCheckingType(Map<String, Object> map, String str, Class<T> cls) {
        if (!map.containsKey(str)) {
            return null;
        }
        Object obj = map.get(str);
        if (cls.isInstance(obj)) {
            return cls.cast(obj);
        }
        throw new AssertionError("UpdatesConfiguration failed to initialize: bad value of type " + obj.getClass().getSimpleName() + " provided for key " + str);
    }
}
