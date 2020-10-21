package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdgr;
import java.security.GeneralSecurityException;

final class zzdcm extends zzdbt<zzdbj, zzddr, zzddt> {
    public zzdcm() throws GeneralSecurityException {
        super(zzdbj.class, zzddr.class, zzddt.class, "type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey");
        zzdcf.zza(new zzdcn());
    }

    public final int getVersion() {
        return 0;
    }

    /* access modifiers changed from: protected */
    public final zzdgr.zzb zzans() {
        return zzdgr.zzb.SYMMETRIC;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ zzdpk zzt(zzdmr zzdmr) throws zzdok {
        return zzddt.zzv(zzdmr);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ zzdpk zzs(zzdmr zzdmr) throws zzdok {
        return zzddr.zzu(zzdmr);
    }

    public final /* synthetic */ zzdpk zzg(zzdpk zzdpk) throws GeneralSecurityException {
        zzddt zzddt = (zzddt) zzdpk;
        return (zzddr) ((zzdob) zzddr.zzaoc().zzb((zzdeb) zzdcf.zza("type.googleapis.com/google.crypto.tink.AesCtrKey", (zzdpk) zzddt.zzaoe())).zzb((zzdgl) zzdcf.zza("type.googleapis.com/google.crypto.tink.HmacKey", (zzdpk) zzddt.zzaof())).zzdu(0).zzaya());
    }

    public final /* synthetic */ Object zze(zzdpk zzdpk) throws GeneralSecurityException {
        zzddr zzddr = (zzddr) zzdpk;
        return new zzdkw((zzdlk) zzdcf.zza("type.googleapis.com/google.crypto.tink.AesCtrKey", (zzdpk) zzddr.zzaoa(), zzdlk.class), (zzdby) zzdcf.zza("type.googleapis.com/google.crypto.tink.HmacKey", (zzdpk) zzddr.zzaob(), zzdby.class), zzddr.zzaob().zzarj().zzarq());
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void zzd(zzdpk zzdpk) throws GeneralSecurityException {
        zzdlx.zzfg(((zzddt) zzdpk).zzaoe().getKeySize());
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void zzc(zzdpk zzdpk) throws GeneralSecurityException {
        zzdlx.zzu(((zzddr) zzdpk).getVersion(), 0);
    }
}
