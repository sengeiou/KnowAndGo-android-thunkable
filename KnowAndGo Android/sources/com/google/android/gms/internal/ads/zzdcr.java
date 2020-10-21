package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdgr;
import java.security.GeneralSecurityException;

final class zzdcr extends zzdbt<zzdbj, zzdhe, zzdhg> {
    public zzdcr() {
        super(zzdbj.class, zzdhe.class, zzdhg.class, "type.googleapis.com/google.crypto.tink.KmsAeadKey");
    }

    public final int getVersion() {
        return 0;
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ void zzd(zzdpk zzdpk) throws GeneralSecurityException {
    }

    /* access modifiers changed from: protected */
    public final zzdgr.zzb zzans() {
        return zzdgr.zzb.REMOTE;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ zzdpk zzt(zzdmr zzdmr) throws zzdok {
        return zzdhg.zzbq(zzdmr);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ zzdpk zzs(zzdmr zzdmr) throws zzdok {
        return zzdhe.zzbp(zzdmr);
    }

    public final /* synthetic */ zzdpk zzg(zzdpk zzdpk) throws GeneralSecurityException {
        return (zzdhe) ((zzdob) zzdhe.zzasx().zzb((zzdhg) zzdpk).zzex(0).zzaya());
    }

    public final /* synthetic */ Object zze(zzdpk zzdpk) throws GeneralSecurityException {
        String zzasz = ((zzdhe) zzdpk).zzasw().zzasz();
        return zzdbx.zzgh(zzasz).zzgg(zzasz);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void zzc(zzdpk zzdpk) throws GeneralSecurityException {
        zzdlx.zzu(((zzdhe) zzdpk).getVersion(), 0);
    }
}
