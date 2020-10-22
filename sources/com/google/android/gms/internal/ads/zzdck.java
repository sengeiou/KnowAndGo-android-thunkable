package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.logging.Logger;

public class zzdck implements zzdcc<zzdbj> {
    private static final Logger logger = Logger.getLogger(zzdck.class.getName());

    public final Class<zzdbj> zzanr() {
        return zzdbj.class;
    }

    static class zza implements zzdbj {
        private final zzdca<zzdbj> zzgpw;

        private zza(zzdca<zzdbj> zzdca) {
            this.zzgpw = zzdca;
        }

        public final byte[] zzc(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
            return zzdjs.zza(this.zzgpw.zzanu().zzanx(), this.zzgpw.zzanu().zzanv().zzc(bArr, bArr2));
        }
    }

    public final /* synthetic */ Object zza(zzdca zzdca) throws GeneralSecurityException {
        return new zza(zzdca);
    }
}
