package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdho;
import java.security.GeneralSecurityException;

public final class zzdcj {
    @Deprecated
    public static final zzdho zzgpt = ((zzdho) ((zzdob) ((zzdho.zza) zzdho.zzatk().zza(zzddo.zzgpt)).zzb(zzdbl.zza("TinkAead", "Aead", "AesCtrHmacAeadKey", 0, true)).zzb(zzdbl.zza("TinkAead", "Aead", "AesEaxKey", 0, true)).zzb(zzdbl.zza("TinkAead", "Aead", "AesGcmKey", 0, true)).zzb(zzdbl.zza("TinkAead", "Aead", "ChaCha20Poly1305Key", 0, true)).zzb(zzdbl.zza("TinkAead", "Aead", "KmsAeadKey", 0, true)).zzb(zzdbl.zza("TinkAead", "Aead", "KmsEnvelopeAeadKey", 0, true)).zzgs("TINK_AEAD_1_0_0").zzaya()));
    @Deprecated
    private static final zzdho zzgpu = ((zzdho) ((zzdob) ((zzdho.zza) zzdho.zzatk().zza(zzgpt)).zzgs("TINK_AEAD_1_1_0").zzaya()));
    public static final zzdho zzgpv = ((zzdho) ((zzdob) ((zzdho.zza) zzdho.zzatk().zza(zzddo.zzgpv)).zzb(zzdbl.zza("TinkAead", "Aead", "AesCtrHmacAeadKey", 0, true)).zzb(zzdbl.zza("TinkAead", "Aead", "AesEaxKey", 0, true)).zzb(zzdbl.zza("TinkAead", "Aead", "AesGcmKey", 0, true)).zzb(zzdbl.zza("TinkAead", "Aead", "ChaCha20Poly1305Key", 0, true)).zzb(zzdbl.zza("TinkAead", "Aead", "KmsAeadKey", 0, true)).zzb(zzdbl.zza("TinkAead", "Aead", "KmsEnvelopeAeadKey", 0, true)).zzb(zzdbl.zza("TinkAead", "Aead", "XChaCha20Poly1305Key", 0, true)).zzgs("TINK_AEAD").zzaya()));

    public static void zzany() throws GeneralSecurityException {
        zzddo.zzany();
        zzdcf.zza("TinkAead", (zzdbk<?>) new zzdci());
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
