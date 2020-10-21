package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzddr;
import com.google.android.gms.internal.ads.zzdeb;
import com.google.android.gms.internal.ads.zzdet;
import com.google.android.gms.internal.ads.zzdgl;
import java.security.GeneralSecurityException;
import java.util.Arrays;

final class zzddk implements zzdka {
    private final String zzgqe;
    private final int zzgqf;
    private zzdet zzgqg;
    private zzddr zzgqh;
    private int zzgqi;

    zzddk(zzdgw zzdgw) throws GeneralSecurityException {
        this.zzgqe = zzdgw.zzart();
        if (this.zzgqe.equals("type.googleapis.com/google.crypto.tink.AesGcmKey")) {
            try {
                zzdev zzal = zzdev.zzal(zzdgw.zzaru());
                this.zzgqg = (zzdet) zzdcf.zzb(zzdgw);
                this.zzgqf = zzal.getKeySize();
            } catch (zzdok e) {
                throw new GeneralSecurityException("invalid KeyFormat protobuf, expected AesGcmKeyFormat", e);
            }
        } else if (this.zzgqe.equals("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey")) {
            try {
                zzddt zzv = zzddt.zzv(zzdgw.zzaru());
                this.zzgqh = (zzddr) zzdcf.zzb(zzdgw);
                this.zzgqi = zzv.zzaoe().getKeySize();
                this.zzgqf = this.zzgqi + zzv.zzaof().getKeySize();
            } catch (zzdok e2) {
                throw new GeneralSecurityException("invalid KeyFormat protobuf, expected AesCtrHmacAeadKeyFormat", e2);
            }
        } else {
            String valueOf = String.valueOf(this.zzgqe);
            throw new GeneralSecurityException(valueOf.length() != 0 ? "unsupported AEAD DEM key type: ".concat(valueOf) : new String("unsupported AEAD DEM key type: "));
        }
    }

    public final int zzanz() {
        return this.zzgqf;
    }

    public final zzdbj zzm(byte[] bArr) throws GeneralSecurityException {
        if (bArr.length != this.zzgqf) {
            throw new GeneralSecurityException("Symmetric key has incorrect length");
        } else if (this.zzgqe.equals("type.googleapis.com/google.crypto.tink.AesGcmKey")) {
            return (zzdbj) zzdcf.zza(this.zzgqe, (zzdpk) (zzdet) ((zzdob) ((zzdet.zza) zzdet.zzapn().zza(this.zzgqg)).zzak(zzdmr.zzi(bArr, 0, this.zzgqf)).zzaya()), zzdbj.class);
        } else if (this.zzgqe.equals("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey")) {
            byte[] copyOfRange = Arrays.copyOfRange(bArr, 0, this.zzgqi);
            byte[] copyOfRange2 = Arrays.copyOfRange(bArr, this.zzgqi, this.zzgqf);
            zzddr.zza zzb = zzddr.zzaoc().zzdu(this.zzgqh.getVersion()).zzb((zzdeb) ((zzdob) ((zzdeb.zza) zzdeb.zzaot().zza(this.zzgqh.zzaoa())).zzab(zzdmr.zzz(copyOfRange)).zzaya()));
            return (zzdbj) zzdcf.zza(this.zzgqe, (zzdpk) (zzddr) ((zzdob) zzb.zzb((zzdgl) ((zzdob) ((zzdgl.zza) zzdgl.zzark().zza(this.zzgqh.zzaob())).zzbl(zzdmr.zzz(copyOfRange2)).zzaya())).zzaya()), zzdbj.class);
        } else {
            throw new GeneralSecurityException("unknown DEM key type");
        }
    }
}
