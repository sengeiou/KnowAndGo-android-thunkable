package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdob;

final class zzdoz implements zzdqc {
    private static final zzdpj zzhjg = new zzdpa();
    private final zzdpj zzhjf;

    public zzdoz() {
        this(new zzdpb(zzdoa.zzaxq(), zzays()));
    }

    private zzdoz(zzdpj zzdpj) {
        this.zzhjf = (zzdpj) zzdod.zza(zzdpj, "messageInfoFactory");
    }

    public final <T> zzdqb<T> zzf(Class<T> cls) {
        zzdqd.zzh(cls);
        zzdpi zzd = this.zzhjf.zzd(cls);
        if (zzd.zzaza()) {
            if (zzdob.class.isAssignableFrom(cls)) {
                return zzdpq.zza(zzdqd.zzazm(), zzdnr.zzaxg(), zzd.zzazb());
            }
            return zzdpq.zza(zzdqd.zzazk(), zzdnr.zzaxh(), zzd.zzazb());
        } else if (zzdob.class.isAssignableFrom(cls)) {
            if (zza(zzd)) {
                return zzdpo.zza(cls, zzd, zzdpu.zzaze(), zzdou.zzayr(), zzdqd.zzazm(), zzdnr.zzaxg(), zzdph.zzayx());
            }
            return zzdpo.zza(cls, zzd, zzdpu.zzaze(), zzdou.zzayr(), zzdqd.zzazm(), (zzdnp<?>) null, zzdph.zzayx());
        } else if (zza(zzd)) {
            return zzdpo.zza(cls, zzd, zzdpu.zzazd(), zzdou.zzayq(), zzdqd.zzazk(), zzdnr.zzaxh(), zzdph.zzayw());
        } else {
            return zzdpo.zza(cls, zzd, zzdpu.zzazd(), zzdou.zzayq(), zzdqd.zzazl(), (zzdnp<?>) null, zzdph.zzayw());
        }
    }

    private static boolean zza(zzdpi zzdpi) {
        return zzdpi.zzayz() == zzdob.zze.zzhhs;
    }

    private static zzdpj zzays() {
        try {
            return (zzdpj) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke((Object) null, new Object[0]);
        } catch (Exception unused) {
            return zzhjg;
        }
    }
}
