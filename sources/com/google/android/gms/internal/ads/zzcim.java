package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import org.json.JSONObject;

final /* synthetic */ class zzcim implements Callable {
    private final zzbbh zzdzi;
    private final zzbbh zzdzk;
    private final zzbbh zzdzo;

    zzcim(zzbbh zzbbh, zzbbh zzbbh2, zzbbh zzbbh3) {
        this.zzdzo = zzbbh;
        this.zzdzi = zzbbh2;
        this.zzdzk = zzbbh3;
    }

    public final Object call() {
        return new zzcir((zzciw) this.zzdzo.get(), (JSONObject) this.zzdzi.get(), (zzasd) this.zzdzk.get());
    }
}
