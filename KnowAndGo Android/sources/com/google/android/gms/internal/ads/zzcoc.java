package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import org.json.JSONObject;

public final class zzcoc implements zzcjz<zzaov, zzcla> {
    private final zzclc zzfvd;

    public zzcoc(zzclc zzclc) {
        this.zzfvd = zzclc;
    }

    public final zzcjy<zzaov, zzcla> zzd(String str, JSONObject jSONObject) throws RemoteException {
        zzaov zzcy = this.zzfvd.zzcy(str);
        if (zzcy == null) {
            return null;
        }
        return new zzcjy<>(zzcy, new zzcla(), str);
    }
}
