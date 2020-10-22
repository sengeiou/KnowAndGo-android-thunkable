package com.uxcam.internals;

import android.content.pm.PackageManager;
import com.amplitude.api.DeviceInfo;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.uxcam.internals.fx */
public final class C3182fx {

    /* renamed from: a */
    public static Map f2313a = new HashMap();

    /* renamed from: b */
    public static String f2314b = DeviceInfo.OS_NAME;

    /* renamed from: a */
    public static String m2027a() {
        try {
            f2313a.put("oldDash", "https://api.uxcam.com/webservices/v4/verifyapp");
            f2313a.put("UAT", "https://verifyuat.uxcam.com/v4/verify");
            f2313a.put("development", "https://devverify.uxcam.co.uk/v4/verify");
            f2313a.put("production", "https://verify.uxcam.com/v4/verify");
            String str = (String) f2313a.get(C3183fy.m2038b().getPackageManager().getApplicationInfo(C3183fy.m2038b().getPackageName(), 128).metaData.getString("UXCamServerRegion"));
            return str != null ? str : (String) f2313a.get("production");
        } catch (PackageManager.NameNotFoundException | NullPointerException unused) {
            return (String) f2313a.get("production");
        }
    }
}
