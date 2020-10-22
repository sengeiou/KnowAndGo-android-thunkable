package com.google.android.play.core.assetpacks.model;

import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.play.core.assetpacks.model.a */
public final class C1956a {

    /* renamed from: a */
    private static final Map<Integer, String> f696a = new HashMap();

    /* renamed from: b */
    private static final Map<Integer, String> f697b = new HashMap();

    static {
        f696a.put(-1, "The requesting app is unavailable (e.g. unpublished, nonexistent version code).");
        f696a.put(-2, "The requested pack is not available.");
        f696a.put(-3, "The request is invalid.");
        f696a.put(-4, "The requested download is not found.");
        f696a.put(-5, "The Asset Delivery API is not available.");
        f696a.put(-6, "Network error. Unable to obtain the asset pack details.");
        f696a.put(-7, "Download not permitted under current device circumstances (e.g. in background).");
        f696a.put(-10, "Asset pack download failed due to insufficient storage.");
        f696a.put(-11, "The Play Store app is either not installed or not the official version.");
        f696a.put(-12, "Tried to show the cellular data confirmation but no asset packs are waiting for Wi-Fi.");
        f696a.put(-13, "The app is not owned by any user on this device. An app is \"owned\" if it has been acquired from Play.");
        f696a.put(-100, "Unknown error downloading an asset pack.");
        f697b.put(-1, "APP_UNAVAILABLE");
        f697b.put(-2, "PACK_UNAVAILABLE");
        f697b.put(-3, "INVALID_REQUEST");
        f697b.put(-4, "DOWNLOAD_NOT_FOUND");
        f697b.put(-5, "API_NOT_AVAILABLE");
        f697b.put(-6, "NETWORK_ERROR");
        f697b.put(-7, "ACCESS_DENIED");
        f697b.put(-10, "INSUFFICIENT_STORAGE");
        f697b.put(-11, "PLAY_STORE_NOT_FOUND");
        f697b.put(-12, "NETWORK_UNRESTRICTED");
        f697b.put(-13, "APP_NOT_OWNED");
        f697b.put(-100, "INTERNAL_ERROR");
    }

    /* renamed from: a */
    public static String m538a(@AssetPackErrorCode int i) {
        Map<Integer, String> map = f696a;
        Integer valueOf = Integer.valueOf(i);
        if (!map.containsKey(valueOf)) {
            return "";
        }
        String str = f696a.get(valueOf);
        String str2 = f697b.get(valueOf);
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 113 + String.valueOf(str2).length());
        sb.append(str);
        sb.append(" (https://developer.android.com/reference/com/google/android/play/core/assetpacks/model/AssetPackErrorCode.html#");
        sb.append(str2);
        sb.append(")");
        return sb.toString();
    }
}
