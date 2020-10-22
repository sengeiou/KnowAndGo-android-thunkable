package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdgr;
import java.security.GeneralSecurityException;

final class zzdco extends zzdbt<zzdbj, zzdeh, zzdej> {
    public zzdco() {
        super(zzdbj.class, zzdeh.class, zzdej.class, "type.googleapis.com/google.crypto.tink.AesEaxKey");
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
        return zzdej.zzaf(zzdmr);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ zzdpk zzs(zzdmr zzdmr) throws zzdok {
        return zzdeh.zzad(zzdmr);
    }

    public final /* synthetic */ zzdpk zzg(zzdpk zzdpk) throws GeneralSecurityException {
        zzdej zzdej = (zzdej) zzdpk;
        return (zzdeh) ((zzdob) zzdeh.zzapc().zzae(zzdmr.zzz(zzdlo.zzff(zzdej.getKeySize()))).zzb(zzdej.zzapb()).zzdx(0).zzaya());
    }

    public final /* synthetic */ Object zze(zzdpk zzdpk) throws GeneralSecurityException {
        zzdeh zzdeh = (zzdeh) zzdpk;
        return new zzdjk(zzdeh.zzaoi().toByteArray(), zzdeh.zzapb().zzaoy());
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void zzd(zzdpk zzdpk) throws GeneralSecurityException {
        zzdej zzdej = (zzdej) zzdpk;
        zzdlx.zzfg(zzdej.getKeySize());
        if (zzdej.zzapb().zzaoy() != 12 && zzdej.zzapb().zzaoy() != 16) {
            throw new GeneralSecurityException("invalid IV size; acceptable values have 12 or 16 bytes");
        }
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void zzc(zzdpk zzdpk) throws GeneralSecurityException {
        zzdeh zzdeh = (zzdeh) zzdpk;
        zzdlx.zzu(zzdeh.getVersion(), 0);
        zzdlx.zzfg(zzdeh.zzaoi().size());
        if (zzdeh.zzapb().zzaoy() != 12 && zzdeh.zzapb().zzaoy() != 16) {
            throw new GeneralSecurityException("invalid IV size; acceptable values have 12 or 16 bytes");
        }
    }
}
