package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.logging.Logger;

public final class zzddp implements zzdcc<zzdby> {
    private static final Logger logger = Logger.getLogger(zzddp.class.getName());

    public final Class<zzdby> zzanr() {
        return zzdby.class;
    }

    static class zza implements zzdby {
        private final zzdca<zzdby> zzgqa;
        private final byte[] zzgqj;

        private zza(zzdca<zzdby> zzdca) {
            this.zzgqj = new byte[]{0};
            this.zzgqa = zzdca;
        }

        public final byte[] zzk(byte[] bArr) throws GeneralSecurityException {
            if (this.zzgqa.zzanu().zzanw().equals(zzdhm.LEGACY)) {
                return zzdjs.zza(this.zzgqa.zzanu().zzanx(), this.zzgqa.zzanu().zzanv().zzk(zzdjs.zza(bArr, this.zzgqj)));
            }
            return zzdjs.zza(this.zzgqa.zzanu().zzanx(), this.zzgqa.zzanu().zzanv().zzk(bArr));
        }
    }

    public final /* synthetic */ Object zza(zzdca zzdca) throws GeneralSecurityException {
        return new zza(zzdca);
    }
}
