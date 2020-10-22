package com.google.android.gms.internal.ads;

final class zzdpb implements zzdpj {
    private zzdpj[] zzhjh;

    zzdpb(zzdpj... zzdpjArr) {
        this.zzhjh = zzdpjArr;
    }

    public final boolean zzc(Class<?> cls) {
        for (zzdpj zzc : this.zzhjh) {
            if (zzc.zzc(cls)) {
                return true;
            }
        }
        return false;
    }

    public final zzdpi zzd(Class<?> cls) {
        for (zzdpj zzdpj : this.zzhjh) {
            if (zzdpj.zzc(cls)) {
                return zzdpj.zzd(cls);
            }
        }
        String valueOf = String.valueOf(cls.getName());
        throw new UnsupportedOperationException(valueOf.length() != 0 ? "No factory is available for message type: ".concat(valueOf) : new String("No factory is available for message type: "));
    }
}
