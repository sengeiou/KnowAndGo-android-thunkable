package com.google.android.gms.internal.ads;

public final class zzbok implements zzdti<Boolean> {
    private final zzdtu<zzcxv> zzfhr;

    public zzbok(zzdtu<zzcxv> zzdtu) {
        this.zzfhr = zzdtu;
    }

    public final /* synthetic */ Object get() {
        boolean z;
        if (this.zzfhr.get().zzamn() != null) {
            z = ((Boolean) zzyt.zzpe().zzd(zzacu.zzcpm)).booleanValue();
        } else {
            z = ((Boolean) zzyt.zzpe().zzd(zzacu.zzcvq)).booleanValue();
        }
        return Boolean.valueOf(z);
    }
}
