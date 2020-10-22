package com.google.android.gms.internal.ads;

import android.util.JsonReader;
import java.io.InputStream;
import java.io.InputStreamReader;

final /* synthetic */ class zzcra implements zzbal {
    private final zzarx zzfkk;

    zzcra(zzarx zzarx) {
        this.zzfkk = zzarx;
    }

    public final zzbbh zzf(Object obj) {
        return zzbar.zzm(new zzcrc(new JsonReader(new InputStreamReader((InputStream) obj))).zzn(this.zzfkk.zzdot));
    }
}
