package com.google.android.gms.internal.ads;

import android.database.sqlite.SQLiteDatabase;

final class zzcje implements zzban<SQLiteDatabase> {
    private final /* synthetic */ zzczc zzfyf;

    zzcje(zzcjc zzcjc, zzczc zzczc) {
        this.zzfyf = zzczc;
    }

    public final void zzb(Throwable th) {
        String valueOf = String.valueOf(th.getMessage());
        zzawz.zzen(valueOf.length() != 0 ? "Failed to get offline signal database: ".concat(valueOf) : new String("Failed to get offline signal database: "));
    }

    public final /* synthetic */ void zzk(Object obj) {
        try {
            this.zzfyf.apply((SQLiteDatabase) obj);
        } catch (Exception e) {
            String valueOf = String.valueOf(e.getMessage());
            zzawz.zzen(valueOf.length() != 0 ? "Error executing function on offline signal database: ".concat(valueOf) : new String("Error executing function on offline signal database: "));
        }
    }
}
