package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdgr;
import java.security.GeneralSecurityException;
import javax.crypto.spec.SecretKeySpec;

final class zzddl extends zzdbt<zzdby, zzdgl, zzdgn> {
    public zzddl() {
        super(zzdby.class, zzdgl.class, zzdgn.class, "type.googleapis.com/google.crypto.tink.HmacKey");
    }

    public final int getVersion() {
        return 0;
    }

    /* access modifiers changed from: protected */
    public final zzdgr.zzb zzans() {
        return zzdgr.zzb.SYMMETRIC;
    }

    private static void zza(zzdgp zzdgp) throws GeneralSecurityException {
        if (zzdgp.zzarq() >= 10) {
            switch (zzddm.zzgqb[zzdgp.zzarp().ordinal()]) {
                case 1:
                    if (zzdgp.zzarq() > 20) {
                        throw new GeneralSecurityException("tag size too big");
                    }
                    return;
                case 2:
                    if (zzdgp.zzarq() > 32) {
                        throw new GeneralSecurityException("tag size too big");
                    }
                    return;
                case 3:
                    if (zzdgp.zzarq() > 64) {
                        throw new GeneralSecurityException("tag size too big");
                    }
                    return;
                default:
                    throw new GeneralSecurityException("unknown hash type");
            }
        } else {
            throw new GeneralSecurityException("tag size too small");
        }
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ zzdpk zzt(zzdmr zzdmr) throws zzdok {
        return zzdgn.zzbm(zzdmr);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ zzdpk zzs(zzdmr zzdmr) throws zzdok {
        return zzdgl.zzbk(zzdmr);
    }

    public final /* synthetic */ zzdpk zzg(zzdpk zzdpk) throws GeneralSecurityException {
        zzdgn zzdgn = (zzdgn) zzdpk;
        return (zzdgl) ((zzdob) zzdgl.zzark().zzem(0).zzc(zzdgn.zzarj()).zzbl(zzdmr.zzz(zzdlo.zzff(zzdgn.getKeySize()))).zzaya());
    }

    public final /* synthetic */ Object zze(zzdpk zzdpk) throws GeneralSecurityException {
        zzdgl zzdgl = (zzdgl) zzdpk;
        zzdgj zzarp = zzdgl.zzarj().zzarp();
        SecretKeySpec secretKeySpec = new SecretKeySpec(zzdgl.zzaoi().toByteArray(), "HMAC");
        int zzarq = zzdgl.zzarj().zzarq();
        switch (zzddm.zzgqb[zzarp.ordinal()]) {
            case 1:
                return new zzdll("HMACSHA1", secretKeySpec, zzarq);
            case 2:
                return new zzdll("HMACSHA256", secretKeySpec, zzarq);
            case 3:
                return new zzdll("HMACSHA512", secretKeySpec, zzarq);
            default:
                throw new GeneralSecurityException("unknown hash");
        }
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void zzd(zzdpk zzdpk) throws GeneralSecurityException {
        zzdgn zzdgn = (zzdgn) zzdpk;
        if (zzdgn.getKeySize() >= 16) {
            zza(zzdgn.zzarj());
            return;
        }
        throw new GeneralSecurityException("key too short");
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void zzc(zzdpk zzdpk) throws GeneralSecurityException {
        zzdgl zzdgl = (zzdgl) zzdpk;
        zzdlx.zzu(zzdgl.getVersion(), 0);
        if (zzdgl.zzaoi().size() >= 16) {
            zza(zzdgl.zzarj());
            return;
        }
        throw new GeneralSecurityException("key too short");
    }
}
