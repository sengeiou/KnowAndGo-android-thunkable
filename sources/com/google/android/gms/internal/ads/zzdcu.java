package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdgr;
import java.security.GeneralSecurityException;

final class zzdcu extends zzdbt<zzdbj, zzdig, zzdgh> {
    public zzdcu() {
        super(zzdbj.class, zzdig.class, zzdgh.class, "type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key");
    }

    public final int getVersion() {
        return 0;
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ void zzd(zzdpk zzdpk) throws GeneralSecurityException {
    }

    /* access modifiers changed from: protected */
    public final zzdgr.zzb zzans() {
        return zzdgr.zzb.SYMMETRIC;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ zzdpk zzt(zzdmr zzdmr) throws zzdok {
        return zzdgh.zzbj(zzdmr);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ zzdpk zzs(zzdmr zzdmr) throws zzdok {
        return zzdig.zzcx(zzdmr);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ zzdpk zzg(zzdpk zzdpk) throws GeneralSecurityException {
        return (zzdig) ((zzdob) zzdig.zzaus().zzfe(0).zzcy(zzdmr.zzz(zzdlo.zzff(32))).zzaya());
    }

    public final /* synthetic */ Object zze(zzdpk zzdpk) throws GeneralSecurityException {
        return new zzdma(((zzdig) zzdpk).zzaoi().toByteArray());
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void zzc(zzdpk zzdpk) throws GeneralSecurityException {
        zzdig zzdig = (zzdig) zzdpk;
        zzdlx.zzu(zzdig.getVersion(), 0);
        if (zzdig.zzaoi().size() != 32) {
            throw new GeneralSecurityException("invalid XChaCha20Poly1305Key: incorrect key length");
        }
    }
}
