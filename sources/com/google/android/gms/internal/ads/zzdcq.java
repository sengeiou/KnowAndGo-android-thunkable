package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdgr;
import java.security.GeneralSecurityException;

final class zzdcq extends zzdbt<zzdbj, zzdfb, zzdgh> {
    public zzdcq() {
        super(zzdbj.class, zzdfb.class, zzdgh.class, "type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key");
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
        return zzdfb.zzap(zzdmr);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ zzdpk zzg(zzdpk zzdpk) throws GeneralSecurityException {
        return (zzdfb) ((zzdob) zzdfb.zzapt().zzeb(0).zzaq(zzdmr.zzz(zzdlo.zzff(32))).zzaya());
    }

    public final /* synthetic */ Object zze(zzdpk zzdpk) throws GeneralSecurityException {
        return new zzdjv(((zzdfb) zzdpk).zzaoi().toByteArray());
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void zzc(zzdpk zzdpk) throws GeneralSecurityException {
        zzdfb zzdfb = (zzdfb) zzdpk;
        zzdlx.zzu(zzdfb.getVersion(), 0);
        if (zzdfb.zzaoi().size() != 32) {
            throw new GeneralSecurityException("invalid ChaCha20Poly1305Key: incorrect key length");
        }
    }
}
