package com.google.android.gms.internal.ads;

import android.os.Trace;

public final class zzkp {
    public static void beginSection(String str) {
        if (zzkq.SDK_INT >= 18) {
            Trace.beginSection(str);
        }
    }

    public static void endSection() {
        if (zzkq.SDK_INT >= 18) {
            Trace.endSection();
        }
    }
}
