package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdob;
import java.io.IOException;
import java.util.List;
import java.util.Map;

final class zzdnk implements zzdro {
    private final zzdni zzhcx;

    public static zzdnk zza(zzdni zzdni) {
        if (zzdni.zzhdo != null) {
            return zzdni.zzhdo;
        }
        return new zzdnk(zzdni);
    }

    private zzdnk(zzdni zzdni) {
        this.zzhcx = (zzdni) zzdod.zza(zzdni, "output");
        this.zzhcx.zzhdo = this;
    }

    public final int zzawy() {
        return zzdob.zze.zzhhv;
    }

    public final void zzah(int i, int i2) throws IOException {
        this.zzhcx.zzaa(i, i2);
    }

    public final void zzp(int i, long j) throws IOException {
        this.zzhcx.zzh(i, j);
    }

    public final void zzq(int i, long j) throws IOException {
        this.zzhcx.zzj(i, j);
    }

    public final void zza(int i, float f) throws IOException {
        this.zzhcx.zza(i, f);
    }

    public final void zzb(int i, double d) throws IOException {
        this.zzhcx.zzb(i, d);
    }

    public final void zzai(int i, int i2) throws IOException {
        this.zzhcx.zzx(i, i2);
    }

    public final void zzh(int i, long j) throws IOException {
        this.zzhcx.zzh(i, j);
    }

    public final void zzx(int i, int i2) throws IOException {
        this.zzhcx.zzx(i, i2);
    }

    public final void zzj(int i, long j) throws IOException {
        this.zzhcx.zzj(i, j);
    }

    public final void zzaa(int i, int i2) throws IOException {
        this.zzhcx.zzaa(i, i2);
    }

    public final void zzi(int i, boolean z) throws IOException {
        this.zzhcx.zzi(i, z);
    }

    public final void zzf(int i, String str) throws IOException {
        this.zzhcx.zzf(i, str);
    }

    public final void zza(int i, zzdmr zzdmr) throws IOException {
        this.zzhcx.zza(i, zzdmr);
    }

    public final void zzy(int i, int i2) throws IOException {
        this.zzhcx.zzy(i, i2);
    }

    public final void zzz(int i, int i2) throws IOException {
        this.zzhcx.zzz(i, i2);
    }

    public final void zzi(int i, long j) throws IOException {
        this.zzhcx.zzi(i, j);
    }

    public final void zza(int i, Object obj, zzdqb zzdqb) throws IOException {
        this.zzhcx.zza(i, (zzdpk) obj, zzdqb);
    }

    public final void zzb(int i, Object obj, zzdqb zzdqb) throws IOException {
        zzdni zzdni = this.zzhcx;
        zzdni.zzw(i, 3);
        zzdqb.zza((zzdpk) obj, zzdni.zzhdo);
        zzdni.zzw(i, 4);
    }

    public final void zzgm(int i) throws IOException {
        this.zzhcx.zzw(i, 3);
    }

    public final void zzgn(int i) throws IOException {
        this.zzhcx.zzw(i, 4);
    }

    public final void zzb(int i, Object obj) throws IOException {
        if (obj instanceof zzdmr) {
            this.zzhcx.zzb(i, (zzdmr) obj);
        } else {
            this.zzhcx.zzb(i, (zzdpk) obj);
        }
    }

    public final void zza(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzhcx.zzw(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzdni.zzge(list.get(i4).intValue());
            }
            this.zzhcx.zzga(i3);
            while (i2 < list.size()) {
                this.zzhcx.zzfz(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzhcx.zzx(i, list.get(i2).intValue());
            i2++;
        }
    }

    public final void zzb(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzhcx.zzw(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzdni.zzgh(list.get(i4).intValue());
            }
            this.zzhcx.zzga(i3);
            while (i2 < list.size()) {
                this.zzhcx.zzgc(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzhcx.zzaa(i, list.get(i2).intValue());
            i2++;
        }
    }

    public final void zzc(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzhcx.zzw(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzdni.zzfm(list.get(i4).longValue());
            }
            this.zzhcx.zzga(i3);
            while (i2 < list.size()) {
                this.zzhcx.zzfj(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzhcx.zzh(i, list.get(i2).longValue());
            i2++;
        }
    }

    public final void zzd(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzhcx.zzw(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzdni.zzfn(list.get(i4).longValue());
            }
            this.zzhcx.zzga(i3);
            while (i2 < list.size()) {
                this.zzhcx.zzfj(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzhcx.zzh(i, list.get(i2).longValue());
            i2++;
        }
    }

    public final void zze(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzhcx.zzw(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzdni.zzfp(list.get(i4).longValue());
            }
            this.zzhcx.zzga(i3);
            while (i2 < list.size()) {
                this.zzhcx.zzfl(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzhcx.zzj(i, list.get(i2).longValue());
            i2++;
        }
    }

    public final void zzf(int i, List<Float> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzhcx.zzw(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzdni.zzh(list.get(i4).floatValue());
            }
            this.zzhcx.zzga(i3);
            while (i2 < list.size()) {
                this.zzhcx.zzg(list.get(i2).floatValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzhcx.zza(i, list.get(i2).floatValue());
            i2++;
        }
    }

    public final void zzg(int i, List<Double> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzhcx.zzw(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzdni.zzc(list.get(i4).doubleValue());
            }
            this.zzhcx.zzga(i3);
            while (i2 < list.size()) {
                this.zzhcx.zzb(list.get(i2).doubleValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzhcx.zzb(i, list.get(i2).doubleValue());
            i2++;
        }
    }

    public final void zzh(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzhcx.zzw(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzdni.zzgj(list.get(i4).intValue());
            }
            this.zzhcx.zzga(i3);
            while (i2 < list.size()) {
                this.zzhcx.zzfz(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzhcx.zzx(i, list.get(i2).intValue());
            i2++;
        }
    }

    public final void zzi(int i, List<Boolean> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzhcx.zzw(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzdni.zzbg(list.get(i4).booleanValue());
            }
            this.zzhcx.zzga(i3);
            while (i2 < list.size()) {
                this.zzhcx.zzbf(list.get(i2).booleanValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzhcx.zzi(i, list.get(i2).booleanValue());
            i2++;
        }
    }

    public final void zza(int i, List<String> list) throws IOException {
        int i2 = 0;
        if (list instanceof zzdot) {
            zzdot zzdot = (zzdot) list;
            while (i2 < list.size()) {
                Object zzgq = zzdot.zzgq(i2);
                if (zzgq instanceof String) {
                    this.zzhcx.zzf(i, (String) zzgq);
                } else {
                    this.zzhcx.zza(i, (zzdmr) zzgq);
                }
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzhcx.zzf(i, list.get(i2));
            i2++;
        }
    }

    public final void zzb(int i, List<zzdmr> list) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.zzhcx.zza(i, list.get(i2));
        }
    }

    public final void zzj(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzhcx.zzw(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzdni.zzgf(list.get(i4).intValue());
            }
            this.zzhcx.zzga(i3);
            while (i2 < list.size()) {
                this.zzhcx.zzga(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzhcx.zzy(i, list.get(i2).intValue());
            i2++;
        }
    }

    public final void zzk(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzhcx.zzw(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzdni.zzgi(list.get(i4).intValue());
            }
            this.zzhcx.zzga(i3);
            while (i2 < list.size()) {
                this.zzhcx.zzgc(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzhcx.zzaa(i, list.get(i2).intValue());
            i2++;
        }
    }

    public final void zzl(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzhcx.zzw(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzdni.zzfq(list.get(i4).longValue());
            }
            this.zzhcx.zzga(i3);
            while (i2 < list.size()) {
                this.zzhcx.zzfl(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzhcx.zzj(i, list.get(i2).longValue());
            i2++;
        }
    }

    public final void zzm(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzhcx.zzw(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzdni.zzgg(list.get(i4).intValue());
            }
            this.zzhcx.zzga(i3);
            while (i2 < list.size()) {
                this.zzhcx.zzgb(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzhcx.zzz(i, list.get(i2).intValue());
            i2++;
        }
    }

    public final void zzn(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzhcx.zzw(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzdni.zzfo(list.get(i4).longValue());
            }
            this.zzhcx.zzga(i3);
            while (i2 < list.size()) {
                this.zzhcx.zzfk(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzhcx.zzi(i, list.get(i2).longValue());
            i2++;
        }
    }

    public final void zza(int i, List<?> list, zzdqb zzdqb) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            zza(i, (Object) list.get(i2), zzdqb);
        }
    }

    public final void zzb(int i, List<?> list, zzdqb zzdqb) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            zzb(i, (Object) list.get(i2), zzdqb);
        }
    }

    public final <K, V> void zza(int i, zzdpd<K, V> zzdpd, Map<K, V> map) throws IOException {
        for (Map.Entry next : map.entrySet()) {
            this.zzhcx.zzw(i, 2);
            this.zzhcx.zzga(zzdpc.zza(zzdpd, next.getKey(), next.getValue()));
            zzdpc.zza(this.zzhcx, zzdpd, next.getKey(), next.getValue());
        }
    }
}
