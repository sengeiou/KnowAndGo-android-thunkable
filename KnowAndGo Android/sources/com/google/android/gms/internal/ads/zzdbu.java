package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

public final class zzdbu {
    private zzdha zzgph;

    private zzdbu(zzdha zzdha) {
        this.zzgph = zzdha;
    }

    static final zzdbu zza(zzdha zzdha) throws GeneralSecurityException {
        if (zzdha != null && zzdha.zzasj() > 0) {
            return new zzdbu(zzdha);
        }
        throw new GeneralSecurityException("empty keyset");
    }

    /* access modifiers changed from: package-private */
    public final zzdha zzant() {
        return this.zzgph;
    }

    public final String toString() {
        return zzdch.zzc(this.zzgph).toString();
    }
}
