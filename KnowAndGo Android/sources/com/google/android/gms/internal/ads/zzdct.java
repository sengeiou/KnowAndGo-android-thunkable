package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdgr;
import java.security.GeneralSecurityException;

final class zzdct extends zzdbt<zzdbj, zzdhi, zzdhk> {
    public zzdct() {
        super(zzdbj.class, zzdhi.class, zzdhk.class, "type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey");
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
        return zzdhk.zzbs(zzdmr);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ zzdpk zzs(zzdmr zzdmr) throws zzdok {
        return zzdhi.zzbr(zzdmr);
    }

    public final /* synthetic */ zzdpk zzg(zzdpk zzdpk) throws GeneralSecurityException {
        return (zzdhi) ((zzdob) zzdhi.zzatd().zzb((zzdhk) zzdpk).zzey(0).zzaya());
    }

    public final /* synthetic */ Object zze(zzdpk zzdpk) throws GeneralSecurityException {
        zzdhi zzdhi = (zzdhi) zzdpk;
        String zzatf = zzdhi.zzatc().zzatf();
        return new zzdcs(zzdhi.zzatc().zzatg(), zzdbx.zzgh(zzatf).zzgg(zzatf));
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void zzc(zzdpk zzdpk) throws GeneralSecurityException {
        zzdlx.zzu(((zzdhi) zzdpk).getVersion(), 0);
    }
}
