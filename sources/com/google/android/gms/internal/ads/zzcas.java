package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.concurrent.Callable;
import org.json.JSONObject;

final /* synthetic */ class zzcas implements Callable {
    private final zzbbh zzdzi;
    private final zzbbh zzdzk;
    private final zzcaq zzfqz;
    private final zzbbh zzfrc;
    private final zzbbh zzfrd;
    private final zzbbh zzfre;
    private final JSONObject zzfrf;
    private final zzbbh zzfrg;
    private final zzbbh zzfrh;
    private final zzbbh zzfri;

    zzcas(zzcaq zzcaq, zzbbh zzbbh, zzbbh zzbbh2, zzbbh zzbbh3, zzbbh zzbbh4, zzbbh zzbbh5, JSONObject jSONObject, zzbbh zzbbh6, zzbbh zzbbh7, zzbbh zzbbh8) {
        this.zzfqz = zzcaq;
        this.zzdzi = zzbbh;
        this.zzdzk = zzbbh2;
        this.zzfrc = zzbbh3;
        this.zzfrd = zzbbh4;
        this.zzfre = zzbbh5;
        this.zzfrf = jSONObject;
        this.zzfrg = zzbbh6;
        this.zzfrh = zzbbh7;
        this.zzfri = zzbbh8;
    }

    public final Object call() {
        zzcaq zzcaq = this.zzfqz;
        zzbbh zzbbh = this.zzdzi;
        zzbbh zzbbh2 = this.zzdzk;
        zzbbh zzbbh3 = this.zzfrc;
        zzbbh zzbbh4 = this.zzfrd;
        zzbbh zzbbh5 = this.zzfre;
        JSONObject jSONObject = this.zzfrf;
        zzbbh zzbbh6 = this.zzfrg;
        zzbbh zzbbh7 = this.zzfrh;
        zzbbh zzbbh8 = this.zzfri;
        zzbyt zzbyt = (zzbyt) zzbbh.get();
        zzbyt.setImages((List) zzbbh2.get());
        zzbyt.zza((zzaei) zzbbh3.get());
        zzbyt.zzb((zzaei) zzbbh4.get());
        zzbyt.zza((zzaea) zzbbh5.get());
        zzbyt.zze(zzcau.zzi(jSONObject));
        zzbyt.zza(zzcau.zzj(jSONObject));
        zzbgz zzbgz = (zzbgz) zzbbh6.get();
        if (zzbgz != null) {
            zzbyt.zzh(zzbgz);
            zzbyt.zzz(zzbgz.getView());
            zzbyt.zzb((zzaar) zzbgz.zzyb());
        }
        zzbgz zzbgz2 = (zzbgz) zzbbh7.get();
        if (zzbgz2 != null) {
            zzbyt.zzi(zzbgz2);
        }
        for (zzcbg zzcbg : (List) zzbbh8.get()) {
            switch (zzcbg.type) {
                case 1:
                    zzbyt.zzp(zzcbg.zzcc, zzcbg.zzfrt);
                    break;
                case 2:
                    zzbyt.zza(zzcbg.zzcc, zzcbg.zzfru);
                    break;
            }
        }
        return zzbyt;
    }
}
