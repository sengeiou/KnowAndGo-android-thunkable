package com.uxcam.internals;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/* renamed from: com.uxcam.internals.fm */
public final class C3169fm {
    /* renamed from: a */
    public static boolean m1993a(Context context) {
        if (!C2952an.f1332p) {
            return true;
        }
        NetworkInfo d = m1996d(context);
        return d != null && d.isConnected();
    }

    /* renamed from: b */
    public static boolean m1994b(Context context) {
        NetworkInfo d = m1996d(context);
        return (d == null || !d.isConnected() || d.getType() == 0) ? false : true;
    }

    /* renamed from: c */
    public static boolean m1995c(Context context) {
        NetworkInfo d = m1996d(context);
        return d != null && d.isConnected() && d.getType() == 0;
    }

    /* renamed from: d */
    private static NetworkInfo m1996d(Context context) {
        return ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
    }
}
