package com.google.android.gms.internal.ads;

import java.util.HashSet;
import java.util.concurrent.Executor;
import org.json.JSONObject;

public final class zzcxf implements zzdti<zzcvb<JSONObject>> {
    public static zzcvb<JSONObject> zza(Object obj, zzcvu zzcvu, zzcwn zzcwn, zzdte<zzcvo> zzdte, zzdte<zzcvy> zzdte2, zzdte<zzcwc> zzdte3, zzdte<zzcwj> zzdte4, zzdte<zzcwq> zzdte5, zzdte<zzcwu> zzdte6, zzdte<zzcxh> zzdte7, Executor executor) {
        HashSet hashSet = new HashSet();
        hashSet.add((zzcwf) obj);
        hashSet.add(zzcvu);
        hashSet.add(zzcwn);
        if (((Boolean) zzyt.zzpe().zzd(zzacu.zzcvt)).booleanValue()) {
            hashSet.add(zzdte.get());
        }
        if (((Boolean) zzyt.zzpe().zzd(zzacu.zzcvu)).booleanValue()) {
            hashSet.add(zzdte2.get());
        }
        if (((Boolean) zzyt.zzpe().zzd(zzacu.zzcvv)).booleanValue()) {
            hashSet.add(zzdte3.get());
        }
        if (((Boolean) zzyt.zzpe().zzd(zzacu.zzcvw)).booleanValue()) {
            hashSet.add(zzdte4.get());
        }
        if (((Boolean) zzyt.zzpe().zzd(zzacu.zzcvz)).booleanValue()) {
            hashSet.add(zzdte5.get());
        }
        if (((Boolean) zzyt.zzpe().zzd(zzacu.zzcwb)).booleanValue()) {
            hashSet.add(zzdte6.get());
        }
        if (((Boolean) zzyt.zzpe().zzd(zzacu.zzcwc)).booleanValue()) {
            hashSet.add(zzdte7.get());
        }
        return (zzcvb) zzdto.zza(new zzcvb(executor, hashSet), "Cannot return null from a non-@Nullable @Provides method");
    }

    public final /* synthetic */ Object get() {
        throw new NoSuchMethodError();
    }
}
