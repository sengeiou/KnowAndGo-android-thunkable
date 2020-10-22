package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdho;
import java.security.GeneralSecurityException;

public final class zzddc {
    @Deprecated
    public static final zzdho zzgpt = ((zzdho) ((zzdob) ((zzdho.zza) zzdho.zzatk().zza(zzdcj.zzgpt)).zzb(zzdbl.zza("TinkHybridDecrypt", "HybridDecrypt", "EciesAeadHkdfPrivateKey", 0, true)).zzb(zzdbl.zza("TinkHybridEncrypt", "HybridEncrypt", "EciesAeadHkdfPublicKey", 0, true)).zzgs("TINK_HYBRID_1_0_0").zzaya()));
    @Deprecated
    public static final zzdho zzgpu = ((zzdho) ((zzdob) ((zzdho.zza) zzdho.zzatk().zza(zzgpt)).zzgs("TINK_HYBRID_1_1_0").zzaya()));
    public static final zzdho zzgpv = ((zzdho) ((zzdob) ((zzdho.zza) zzdho.zzatk().zza(zzdcj.zzgpv)).zzb(zzdbl.zza("TinkHybridDecrypt", "HybridDecrypt", "EciesAeadHkdfPrivateKey", 0, true)).zzb(zzdbl.zza("TinkHybridEncrypt", "HybridEncrypt", "EciesAeadHkdfPublicKey", 0, true)).zzgs("TINK_HYBRID").zzaya()));

    public static void zzany() throws GeneralSecurityException {
        zzdcj.zzany();
        zzdcf.zza("TinkHybridEncrypt", (zzdbk<?>) new zzddf());
        zzdcf.zza("TinkHybridDecrypt", (zzdbk<?>) new zzddd());
        zzdbl.zza(zzgpv);
    }

    static {
        try {
            zzany();
        } catch (GeneralSecurityException e) {
            throw new ExceptionInInitializerError(e);
        }
    }
}
