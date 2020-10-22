package com.google.android.play.core.splitinstall.model;

import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.play.core.splitinstall.model.a */
public final class C2137a {

    /* renamed from: a */
    private static final Map<Integer, String> f930a = new HashMap();

    /* renamed from: b */
    private static final Map<Integer, String> f931b = new HashMap();

    static {
        f930a.put(-1, "Too many sessions are running for current app, existing sessions must be resolved first.");
        f930a.put(-2, "A requested module is not available (to this user/device, for the installed apk).");
        f930a.put(-3, "Request is otherwise invalid.");
        f930a.put(-4, "Requested session is not found.");
        f930a.put(-5, "Split Install API is not available.");
        f930a.put(-6, "Network error: unable to obtain split details.");
        f930a.put(-7, "Download not permitted under current device circumstances (e.g. in background).");
        f930a.put(-8, "Requested session contains modules from an existing active session and also new modules.");
        f930a.put(-9, "Service handling split install has died.");
        f930a.put(-10, "Install failed due to insufficient storage.");
        f930a.put(-11, "Signature verification error when invoking SplitCompat.");
        f930a.put(-12, "Error in SplitCompat emulation.");
        f930a.put(-13, "Error in copying files for SplitCompat.");
        f930a.put(-14, "The Play Store app is either not installed or not the official version.");
        f930a.put(-15, "The app is not owned by any user on this device. An app is \"owned\" if it has been acquired from Play.");
        f930a.put(-100, "Unknown error processing split install.");
        f931b.put(-1, "ACTIVE_SESSIONS_LIMIT_EXCEEDED");
        f931b.put(-2, "MODULE_UNAVAILABLE");
        f931b.put(-3, "INVALID_REQUEST");
        f931b.put(-4, "DOWNLOAD_NOT_FOUND");
        f931b.put(-5, "API_NOT_AVAILABLE");
        f931b.put(-6, "NETWORK_ERROR");
        f931b.put(-7, "ACCESS_DENIED");
        f931b.put(-8, "INCOMPATIBLE_WITH_EXISTING_SESSION");
        f931b.put(-9, "SERVICE_DIED");
        f931b.put(-10, "INSUFFICIENT_STORAGE");
        f931b.put(-11, "SPLITCOMPAT_VERIFICATION_ERROR");
        f931b.put(-12, "SPLITCOMPAT_EMULATION_ERROR");
        f931b.put(-13, "SPLITCOMPAT_COPY_ERROR");
        f931b.put(-14, "PLAY_STORE_NOT_FOUND");
        f931b.put(-15, "APP_NOT_OWNED");
    }

    /* renamed from: a */
    public static String m994a(@SplitInstallErrorCode int i) {
        Map<Integer, String> map = f930a;
        Integer valueOf = Integer.valueOf(i);
        if (!map.containsKey(valueOf) || !f931b.containsKey(valueOf)) {
            return "";
        }
        String str = f930a.get(valueOf);
        String str2 = f931b.get(valueOf);
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 118 + String.valueOf(str2).length());
        sb.append(str);
        sb.append(" (https://developer.android.com/reference/com/google/android/play/core/splitinstall/model/SplitInstallErrorCode.html#");
        sb.append(str2);
        sb.append(")");
        return sb.toString();
    }
}
