package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdgr;
import java.security.GeneralSecurityException;

final class zzdcn extends zzdbt<zzdlk, zzdeb, zzded> {
    public zzdcn() {
        super(zzdlk.class, zzdeb.class, zzded.class, "type.googleapis.com/google.crypto.tink.AesCtrKey");
    }

    public final int getVersion() {
        return 0;
    }

    /* access modifiers changed from: protected */
    public final zzdgr.zzb zzans() {
        return zzdgr.zzb.SYMMETRIC;
    }

    private static void zza(zzdef zzdef) throws GeneralSecurityException {
        if (zzdef.zzaoy() < 12 || zzdef.zzaoy() > 16) {
            throw new GeneralSecurityException("invalid IV size");
        }
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ zzdpk zzt(zzdmr zzdmr) throws zzdok {
        return zzded.zzac(zzdmr);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ zzdpk zzs(zzdmr zzdmr) throws zzdok {
        return zzdeb.zzaa(zzdmr);
    }

    public final /* synthetic */ zzdpk zzg(zzdpk zzdpk) throws GeneralSecurityException {
        zzded zzded = (zzded) zzdpk;
        return (zzdeb) ((zzdob) zzdeb.zzaot().zzc(zzded.zzaos()).zzab(zzdmr.zzz(zzdlo.zzff(zzded.getKeySize()))).zzdw(0).zzaya());
    }

    public final /* synthetic */ Object zze(zzdpk zzdpk) throws GeneralSecurityException {
        zzdeb zzdeb = (zzdeb) zzdpk;
        return new zzdjj(zzdeb.zzaoi().toByteArray(), zzdeb.zzaos().zzaoy());
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void zzd(zzdpk zzdpk) throws GeneralSecurityException {
        zzded zzded = (zzded) zzdpk;
        zzdlx.zzfg(zzded.getKeySize());
        zza(zzded.zzaos());
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void zzc(zzdpk zzdpk) throws GeneralSecurityException {
        zzdeb zzdeb = (zzdeb) zzdpk;
        zzdlx.zzu(zzdeb.getVersion(), 0);
        zzdlx.zzfg(zzdeb.zzaoi().size());
        zza(zzdeb.zzaos());
    }
}
