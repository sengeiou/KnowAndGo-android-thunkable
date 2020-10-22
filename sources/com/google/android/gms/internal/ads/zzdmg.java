package com.google.android.gms.internal.ads;

import java.io.PrintWriter;

final class zzdmg extends zzdmc {
    zzdmg() {
    }

    public final void zza(Throwable th, Throwable th2) {
        th.addSuppressed(th2);
    }

    public final void zzg(Throwable th) {
        th.printStackTrace();
    }

    public final void zza(Throwable th, PrintWriter printWriter) {
        th.printStackTrace(printWriter);
    }
}
