package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdgr;
import java.security.GeneralSecurityException;

final class zzdcp extends zzdbt<zzdbj, zzdet, zzdev> {
    public zzdcp() {
        super(zzdbj.class, zzdet.class, zzdev.class, "type.googleapis.com/google.crypto.tink.AesGcmKey");
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
        return zzdev.zzal(zzdmr);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ zzdpk zzs(zzdmr zzdmr) throws zzdok {
        return zzdet.zzaj(zzdmr);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ zzdpk zzg(zzdpk zzdpk) throws GeneralSecurityException {
        return (zzdet) ((zzdob) zzdet.zzapn().zzak(zzdmr.zzz(zzdlo.zzff(((zzdev) zzdpk).getKeySize()))).zzdz(0).zzaya());
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object zze(zzdpk zzdpk) throws GeneralSecurityException {
        return new zzdjm(((zzdet) zzdpk).zzaoi().toByteArray());
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void zzd(zzdpk zzdpk) throws GeneralSecurityException {
        zzdlx.zzfg(((zzdev) zzdpk).getKeySize());
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void zzc(zzdpk zzdpk) throws GeneralSecurityException {
        zzdet zzdet = (zzdet) zzdpk;
        zzdlx.zzu(zzdet.getVersion(), 0);
        zzdlx.zzfg(zzdet.zzaoi().size());
    }
}
