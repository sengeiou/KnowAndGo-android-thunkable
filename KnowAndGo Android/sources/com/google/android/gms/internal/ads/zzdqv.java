package com.google.android.gms.internal.ads;

import java.io.IOException;

final class zzdqv extends zzdqt<zzdqu, zzdqu> {
    zzdqv() {
    }

    /* access modifiers changed from: package-private */
    public final boolean zza(zzdqa zzdqa) {
        return false;
    }

    private static void zza(Object obj, zzdqu zzdqu) {
        ((zzdob) obj).zzhhd = zzdqu;
    }

    /* access modifiers changed from: package-private */
    public final void zzaa(Object obj) {
        ((zzdob) obj).zzhhd.zzavj();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ int zzak(Object obj) {
        return ((zzdqu) obj).zzaxj();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ int zzaq(Object obj) {
        return ((zzdqu) obj).zzbab();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object zzh(Object obj, Object obj2) {
        zzdqu zzdqu = (zzdqu) obj;
        zzdqu zzdqu2 = (zzdqu) obj2;
        if (zzdqu2.equals(zzdqu.zzazz())) {
            return zzdqu;
        }
        return zzdqu.zza(zzdqu, zzdqu2);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzc(Object obj, zzdro zzdro) throws IOException {
        ((zzdqu) obj).zza(zzdro);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(Object obj, zzdro zzdro) throws IOException {
        ((zzdqu) obj).zzb(zzdro);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzg(Object obj, Object obj2) {
        zza(obj, (zzdqu) obj2);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object zzap(Object obj) {
        zzdqu zzdqu = ((zzdob) obj).zzhhd;
        if (zzdqu != zzdqu.zzazz()) {
            return zzdqu;
        }
        zzdqu zzbaa = zzdqu.zzbaa();
        zza(obj, zzbaa);
        return zzbaa;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object zzao(Object obj) {
        return ((zzdob) obj).zzhhd;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzf(Object obj, Object obj2) {
        zza(obj, (zzdqu) obj2);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object zzah(Object obj) {
        zzdqu zzdqu = (zzdqu) obj;
        zzdqu.zzavj();
        return zzdqu;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object zzazy() {
        return zzdqu.zzbaa();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(Object obj, int i, Object obj2) {
        ((zzdqu) obj).zzc((i << 3) | 3, (zzdqu) obj2);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(Object obj, int i, zzdmr zzdmr) {
        ((zzdqu) obj).zzc((i << 3) | 2, zzdmr);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzb(Object obj, int i, long j) {
        ((zzdqu) obj).zzc((i << 3) | 1, Long.valueOf(j));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzc(Object obj, int i, int i2) {
        ((zzdqu) obj).zzc((i << 3) | 5, Integer.valueOf(i2));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(Object obj, int i, long j) {
        ((zzdqu) obj).zzc(i << 3, Long.valueOf(j));
    }
}
