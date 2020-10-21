package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdgy;
import java.security.GeneralSecurityException;

public final class zzdbl {
    public static zzdgy zza(String str, String str2, String str3, int i, boolean z) {
        zzdgy.zza zzgn = zzdgy.zzasf().zzgn(str2);
        String valueOf = String.valueOf(str3);
        return (zzdgy) ((zzdob) zzgn.zzgo(valueOf.length() != 0 ? "type.googleapis.com/google.crypto.tink.".concat(valueOf) : new String("type.googleapis.com/google.crypto.tink.")).zzeq(0).zzbe(true).zzgp(str).zzaya());
    }

    public static void zza(zzdho zzdho) throws GeneralSecurityException {
        for (zzdgy next : zzdho.zzatj()) {
            if (next.zzart().isEmpty()) {
                throw new GeneralSecurityException("Missing type_url.");
            } else if (next.zzasb().isEmpty()) {
                throw new GeneralSecurityException("Missing primitive_name.");
            } else if (!next.zzase().isEmpty()) {
                zzdbk<?> zzgi = zzdcf.zzgi(next.zzase());
                zzdcf.zza(zzgi.zzanp());
                zzdcf.zza(zzgi.zzb(next.zzart(), next.zzasb(), next.zzasc()), next.zzasd());
            } else {
                throw new GeneralSecurityException("Missing catalogue_name.");
            }
        }
    }
}
