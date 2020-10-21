package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.MuteThisAdReason;

@zzard
public final class zzaan implements MuteThisAdReason {
    private final String description;
    private zzaak zzciq;

    public zzaan(zzaak zzaak) {
        String str;
        this.zzciq = zzaak;
        try {
            str = zzaak.getDescription();
        } catch (RemoteException e) {
            zzbad.zzc("", e);
            str = null;
        }
        this.description = str;
    }

    public final String getDescription() {
        return this.description;
    }

    public final zzaak zzpu() {
        return this.zzciq;
    }
}
