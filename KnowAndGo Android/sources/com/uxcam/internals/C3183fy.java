package com.uxcam.internals;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.os.SystemClock;
import android.telephony.TelephonyManager;
import android.util.Pair;
import android.util.TypedValue;
import android.view.View;
import android.view.WindowManager;
import androidx.annotation.RequiresApi;
import androidx.core.p005os.EnvironmentCompat;
import com.google.android.exoplayer2.util.MimeTypes;
import com.polidea.multiplatformbleadapter.utils.Constants;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.uxcam.internals.fy */
public class C3183fy {

    /* renamed from: a */
    public static String[] f2315a = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"};

    /* renamed from: b */
    public static String[] f2316b = {"android.permission.WRITE_EXTERNAL_STORAGE"};

    /* renamed from: c */
    public static Context f2317c;

    /* renamed from: d */
    static final /* synthetic */ boolean f2318d = (!C3183fy.class.desiredAssertionStatus());

    /* renamed from: e */
    private static final String f2319e = C3183fy.class.getSimpleName();

    /* renamed from: f */
    private static WeakReference f2320f = new WeakReference((Object) null);

    /* renamed from: a */
    public static float m2028a(float f, Context context) {
        return TypedValue.applyDimension(5, f, context.getResources().getDisplayMetrics());
    }

    /* renamed from: a */
    public static int m2029a(int i) {
        int i2 = i % 16;
        return i + (i2 > 0 ? 16 - i2 : 0);
    }

    /* renamed from: a */
    public static Context m2030a() {
        return f2317c;
    }

    /* renamed from: a */
    public static String m2031a(Context context) {
        try {
            Object obj = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.get("uxcam_app_key");
            if (obj instanceof Integer) {
                return obj.toString();
            }
            if (obj instanceof String) {
                return (String) obj;
            }
            return null;
        } catch (Exception e) {
            new StringBuilder("api key from manifest is Failed to load meta-data, nullpointer exception NameNotFound: ").append(e.getMessage());
            C2970bc.m1237b();
            return "";
        }
    }

    /* renamed from: a */
    public static String m2032a(View view) {
        try {
            return view.getResources().getResourceName(view.getId());
        } catch (Exception unused) {
            return "";
        }
    }

    /* renamed from: a */
    public static Map m2033a(JSONObject jSONObject) {
        HashMap hashMap = new HashMap();
        if (jSONObject != null) {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                hashMap.put(next, jSONObject.getString(next));
            }
        }
        return hashMap;
    }

    /* renamed from: a */
    public static void m2034a(Activity activity) {
        f2320f = new WeakReference(activity);
        if (activity != null) {
            f2317c = activity.getApplicationContext();
        }
    }

    /* renamed from: a */
    public static void m2035a(File file) {
        if (file.isDirectory()) {
            for (File a : file.listFiles()) {
                m2035a(a);
            }
        }
        file.delete();
    }

    /* renamed from: a */
    public static boolean m2036a(String str) {
        try {
            Class.forName(str);
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    /* renamed from: a */
    public static boolean m2037a(String[] strArr) {
        PackageInfo packageInfo;
        PackageManager packageManager = f2317c.getPackageManager();
        StringBuilder sb = new StringBuilder();
        try {
            packageInfo = packageManager.getPackageInfo(f2317c.getPackageName(), 4096);
        } catch (PackageManager.NameNotFoundException unused) {
            C2970bc.m1238c();
            packageInfo = null;
        }
        if (f2318d || packageInfo != null) {
            String[] strArr2 = packageInfo.requestedPermissions;
            if (strArr2 != null) {
                for (String str : strArr) {
                    boolean z = false;
                    for (String compareTo : strArr2) {
                        if (str.compareTo(compareTo) == 0) {
                            z = true;
                        }
                    }
                    if (!z) {
                        sb.append(",");
                        sb.append(str);
                        C2970bc.m1233a("UXCam 3.3.0[501]").mo38070a("Missed permission : " + str + ". Add this permission to project’s manifest.", new Object[0]);
                    }
                }
                if (sb.length() != 0) {
                    C2970bc.m1233a(f2319e);
                    new StringBuilder("Missed permission : ").append(sb);
                    return false;
                }
            }
            return true;
        }
        throw new AssertionError();
    }

    /* renamed from: b */
    public static Context m2038b() {
        return (Context) f2320f.get();
    }

    /* renamed from: b */
    public static String m2039b(Context context) {
        ApplicationInfo applicationInfo;
        PackageManager packageManager = context.getPackageManager();
        try {
            applicationInfo = packageManager.getApplicationInfo(context.getApplicationInfo().packageName, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            C2970bc.m1238c();
            applicationInfo = null;
        }
        return (String) (applicationInfo != null ? packageManager.getApplicationLabel(applicationInfo) : Constants.BluetoothState.UNKNOWN);
    }

    /* renamed from: b */
    static boolean m2040b(File file) {
        if (file.isDirectory()) {
            for (File name : file.listFiles()) {
                if (name.getName().contains("data")) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: c */
    public static float m2041c() {
        long b = C2923aa.m1098b();
        if (b <= 0) {
            return 0.0f;
        }
        return ((float) (SystemClock.elapsedRealtime() - b)) / 1000.0f;
    }

    /* renamed from: c */
    public static String m2042c(Context context) {
        return (C2952an.f1320d == null || C2952an.f1320d.isEmpty()) ? context.getApplicationInfo().packageName : C2952an.f1320d;
    }

    /* renamed from: c */
    static void m2043c(File file) {
        if (file.isDirectory()) {
            for (File file2 : file.listFiles()) {
                if (file2.getName().contains("data") || file2.getName().contains(MimeTypes.BASE_TYPE_VIDEO)) {
                    file2.delete();
                }
            }
        }
    }

    /* renamed from: d */
    public static long m2044d(File file) {
        long j = 0;
        for (File file2 : file.listFiles()) {
            j += file2.isFile() ? file2.length() : m2044d(file2);
        }
        return j;
    }

    /* renamed from: d */
    public static Pair m2045d(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            C2970bc.m1233a(f2319e);
            new StringBuilder("Version name is ").append(packageInfo.versionName);
            C2970bc.m1233a(f2319e);
            new StringBuilder("Version code is ").append(packageInfo.versionCode);
            return new Pair(packageInfo.versionName, Integer.valueOf(packageInfo.versionCode));
        } catch (PackageManager.NameNotFoundException unused) {
            C2970bc.m1238c();
            return null;
        }
    }

    /* renamed from: d */
    public static boolean m2046d() {
        String[] strArr = {"/sbin/", "/system/bin/", "/system/xbin/", "/data/local/xbin/", "/data/local/bin/", "/system/sd/xbin/", "/system/bin/failsafe/", "/data/local/"};
        for (int i = 0; i < 8; i++) {
            String str = strArr[i];
            if (new File(str + "su").exists()) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: e */
    public static long m2047e() {
        return Runtime.getRuntime().maxMemory() - Runtime.getRuntime().totalMemory();
    }

    /* renamed from: e */
    public static String m2048e(Context context) {
        return ((TelephonyManager) context.getSystemService("phone")).getNetworkOperatorName();
    }

    /* renamed from: e */
    public static boolean m2049e(File file) {
        if (!file.isDirectory()) {
            return C2958as.m1198a(file.getName());
        }
        File[] listFiles = file.listFiles();
        for (File name : listFiles) {
            if (C2958as.m1198a(name.getName())) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: f */
    public static float m2050f() {
        long blockSize;
        long blockCount;
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        if (Build.VERSION.SDK_INT >= 18) {
            blockSize = statFs.getBlockSizeLong();
            blockCount = statFs.getBlockCountLong();
        } else {
            blockSize = (long) statFs.getBlockSize();
            blockCount = (long) statFs.getBlockCount();
        }
        return ((float) (blockSize * blockCount)) / 1048576.0f;
    }

    /* renamed from: f */
    public static String m2051f(Context context) {
        return ((TelephonyManager) context.getSystemService("phone")).getNetworkOperator();
    }

    /* renamed from: g */
    public static float m2052g() {
        long blockSize;
        long availableBlocks;
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        if (Build.VERSION.SDK_INT >= 18) {
            blockSize = statFs.getBlockSizeLong();
            availableBlocks = statFs.getAvailableBlocksLong();
        } else {
            blockSize = (long) statFs.getBlockSize();
            availableBlocks = (long) statFs.getAvailableBlocks();
        }
        return ((float) (blockSize * availableBlocks)) / 1048576.0f;
    }

    @RequiresApi(api = 16)
    /* renamed from: g */
    public static int m2053g(Context context) {
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
        return (int) (memoryInfo.availMem / 1048576);
    }

    /* renamed from: h */
    public static String m2054h(Context context) {
        return C3169fm.m1994b(context) ? "wifi" : C3169fm.m1995c(context) ? "mobile data" : C3169fm.m1993a(context) ? EnvironmentCompat.MEDIA_UNKNOWN : "no network";
    }

    /* renamed from: h */
    public static void m2055h() {
        File file = new File(C2958as.m1196a());
        if (!file.exists()) {
            file.mkdirs();
        }
    }

    /* renamed from: i */
    public static int m2056i() {
        try {
            C2928ab.m1122b();
            return new File(C2958as.m1199b()).list().length;
        } catch (Exception unused) {
            return 0;
        }
    }

    /* renamed from: i */
    public static int m2057i(Context context) {
        Configuration configuration = context.getResources().getConfiguration();
        int rotation = ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRotation();
        return (((rotation == 0 || rotation == 2) && configuration.orientation == 2) || ((rotation == 1 || rotation == 3) && configuration.orientation == 1)) ? 2 : 1;
    }

    /* renamed from: j */
    public static boolean m2058j() {
        if (Build.FINGERPRINT.startsWith("generic") || Build.FINGERPRINT.startsWith(EnvironmentCompat.MEDIA_UNKNOWN) || Build.MODEL.contains("google_sdk") || Build.MODEL.contains("Emulator") || Build.MODEL.contains("Android SDK built for x86") || Build.MANUFACTURER.contains("Genymotion")) {
            return false;
        }
        return (!Build.BRAND.startsWith("generic") || !Build.DEVICE.startsWith("generic")) && !"google_sdk".equals(Build.PRODUCT);
    }
}
