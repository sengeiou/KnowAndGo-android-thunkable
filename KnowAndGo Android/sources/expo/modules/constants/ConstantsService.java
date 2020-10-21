package expo.modules.constants;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.util.Log;
import androidx.annotation.Nullable;
import com.amplitude.api.Constants;
import com.amplitude.api.DeviceInfo;
import com.facebook.device.yearclass.YearClass;
import com.google.android.exoplayer2.C1470C;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.unimodules.core.ModuleRegistry;
import org.unimodules.core.interfaces.InternalModule;
import org.unimodules.core.interfaces.RegistryLifecycleListener;
import org.unimodules.interfaces.constants.ConstantsInterface;

public class ConstantsService implements InternalModule, ConstantsInterface {
    private static final String PREFERENCES_FILE_NAME = "host.exp.exponent.SharedPreferences";
    private static final String TAG = "ConstantsService";
    private static final String UUID_KEY = "uuid";
    protected Context mContext;
    private String mSessionId = UUID.randomUUID().toString();
    protected int mStatusBarHeight = 0;
    private SharedPreferences sharedPref;

    public String getAppOwnership() {
        return "guest";
    }

    public /* synthetic */ void onCreate(ModuleRegistry moduleRegistry) {
        RegistryLifecycleListener.CC.$default$onCreate(this, moduleRegistry);
    }

    public /* synthetic */ void onDestroy() {
        RegistryLifecycleListener.CC.$default$onDestroy(this);
    }

    private static int convertPixelsToDp(float f, Context context) {
        return (int) (f / (((float) context.getResources().getDisplayMetrics().densityDpi) / 160.0f));
    }

    public ConstantsService(Context context) {
        this.mContext = context;
        this.sharedPref = this.mContext.getSharedPreferences(PREFERENCES_FILE_NAME, 0);
        int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", DeviceInfo.OS_NAME);
        if (identifier > 0) {
            this.mStatusBarHeight = convertPixelsToDp((float) context.getResources().getDimensionPixelSize(identifier), context);
        }
    }

    public List<Class> getExportedInterfaces() {
        return Collections.singletonList(ConstantsInterface.class);
    }

    @Nullable
    public Map<String, Object> getConstants() {
        HashMap hashMap = new HashMap();
        hashMap.put("sessionId", this.mSessionId);
        hashMap.put("statusBarHeight", Integer.valueOf(getStatusBarHeight()));
        hashMap.put("deviceYearClass", Integer.valueOf(getDeviceYearClass()));
        hashMap.put("deviceName", getDeviceName());
        hashMap.put("isDevice", Boolean.valueOf(getIsDevice()));
        hashMap.put("systemFonts", getSystemFonts());
        hashMap.put("systemVersion", getSystemVersion());
        hashMap.put("installationId", getOrCreateInstallationId());
        try {
            PackageInfo packageInfo = this.mContext.getPackageManager().getPackageInfo(this.mContext.getPackageName(), 0);
            hashMap.put("nativeAppVersion", packageInfo.versionName);
            hashMap.put("nativeBuildVersion", Integer.toString((int) getLongVersionCode(packageInfo)));
        } catch (PackageManager.NameNotFoundException e) {
            Log.e(TAG, "Exception: ", e);
        }
        HashMap hashMap2 = new HashMap();
        hashMap2.put(DeviceInfo.OS_NAME, new HashMap());
        hashMap.put(Constants.AMP_TRACKING_OPTION_PLATFORM, hashMap2);
        return hashMap;
    }

    public String getAppId() {
        return this.mContext.getPackageName();
    }

    public String getDeviceName() {
        return Build.MODEL;
    }

    public int getDeviceYearClass() {
        return YearClass.get(this.mContext);
    }

    public boolean getIsDevice() {
        return !isRunningOnGenymotion() && !isRunningOnStockEmulator();
    }

    public int getStatusBarHeight() {
        return this.mStatusBarHeight;
    }

    public String getSystemVersion() {
        return Build.VERSION.RELEASE;
    }

    public String getOrCreateInstallationId() {
        String string = this.sharedPref.getString("uuid", (String) null);
        if (string != null) {
            return string;
        }
        String uuid = UUID.randomUUID().toString();
        this.sharedPref.edit().putString("uuid", uuid).apply();
        return uuid;
    }

    public List<String> getSystemFonts() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("normal");
        arrayList.add("notoserif");
        arrayList.add(C1470C.SANS_SERIF_NAME);
        arrayList.add("sans-serif-light");
        arrayList.add("sans-serif-thin");
        arrayList.add("sans-serif-condensed");
        arrayList.add("sans-serif-medium");
        arrayList.add(C1470C.SERIF_NAME);
        arrayList.add("Roboto");
        arrayList.add("monospace");
        return arrayList;
    }

    private static boolean isRunningOnGenymotion() {
        return Build.FINGERPRINT.contains("vbox");
    }

    private static boolean isRunningOnStockEmulator() {
        return Build.FINGERPRINT.contains("generic");
    }

    private static long getLongVersionCode(PackageInfo packageInfo) {
        if (Build.VERSION.SDK_INT >= 28) {
            return packageInfo.getLongVersionCode();
        }
        return (long) packageInfo.versionCode;
    }
}
