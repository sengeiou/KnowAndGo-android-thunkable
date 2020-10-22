package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.logging.Logger;

public final class zzdde implements zzdcc<zzdbp> {
    private static final Logger logger = Logger.getLogger(zzdde.class.getName());

    static class zza implements zzdbp {
        private final zzdca<zzdbp> zzgqa;

        public zza(zzdca<zzdbp> zzdca) {
            this.zzgqa = zzdca;
        }
    }

    public final Class<zzdbp> zzanr() {
        return zzdbp.class;
    }

    public final /* synthetic */ Object zza(zzdca zzdca) throws GeneralSecurityException {
        return new zza(zzdca);
    }
}
