package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdho;
import java.security.GeneralSecurityException;

public final class zzddo {
    @Deprecated
    public static final zzdho zzgpt = ((zzdho) ((zzdob) zzdho.zzatk().zzgs("TINK_MAC_1_0_0").zzb(zzdbl.zza("TinkMac", "Mac", "HmacKey", 0, true)).zzaya()));
    @Deprecated
    private static final zzdho zzgpu = ((zzdho) ((zzdob) ((zzdho.zza) zzdho.zzatk().zza(zzgpt)).zzgs("TINK_MAC_1_1_0").zzaya()));
    public static final zzdho zzgpv = ((zzdho) ((zzdob) ((zzdho.zza) zzdho.zzatk().zza(zzgpt)).zzgs("TINK_MAC").zzaya()));

    public static void zzany() throws GeneralSecurityException {
        zzdcf.zza("TinkMac", (zzdbk<?>) new zzddn());
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
