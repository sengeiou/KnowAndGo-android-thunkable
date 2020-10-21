package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import org.json.JSONObject;

final /* synthetic */ class zzcil implements Callable {
    private final zzbbh zzdzi;
    private final zzbbh zzdzo;

    zzcil(zzbbh zzbbh, zzbbh zzbbh2) {
        this.zzdzo = zzbbh;
        this.zzdzi = zzbbh2;
    }

    public final Object call() {
        return new zzciv((JSONObject) this.zzdzo.get(), (zzasd) this.zzdzi.get());
    }
}
