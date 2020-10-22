package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzuo;
import java.io.IOException;
import java.util.List;
import java.util.Map;

final class zztx implements zzxy {
    private final zztv zzbty;

    public static zztx zza(zztv zztv) {
        if (zztv.zzbup != null) {
            return zztv.zzbup;
        }
        return new zztx(zztv);
    }

    private zztx(zztv zztv) {
        this.zzbty = (zztv) zzuq.zza(zztv, "output");
        this.zzbty.zzbup = this;
    }

    public final int zzvm() {
        return zzuo.zze.zzbyx;
    }

    public final void zzn(int i, int i2) throws IOException {
        this.zzbty.zzg(i, i2);
    }

    public final void zzi(int i, long j) throws IOException {
        this.zzbty.zza(i, j);
    }

    public final void zzj(int i, long j) throws IOException {
        this.zzbty.zzc(i, j);
    }

    public final void zza(int i, float f) throws IOException {
        this.zzbty.zza(i, f);
    }

    public final void zza(int i, double d) throws IOException {
        this.zzbty.zza(i, d);
    }

    public final void zzo(int i, int i2) throws IOException {
        this.zzbty.zzd(i, i2);
    }

    public final void zza(int i, long j) throws IOException {
        this.zzbty.zza(i, j);
    }

    public final void zzd(int i, int i2) throws IOException {
        this.zzbty.zzd(i, i2);
    }

    public final void zzc(int i, long j) throws IOException {
        this.zzbty.zzc(i, j);
    }

    public final void zzg(int i, int i2) throws IOException {
        this.zzbty.zzg(i, i2);
    }

    public final void zzb(int i, boolean z) throws IOException {
        this.zzbty.zzb(i, z);
    }

    public final void zzb(int i, String str) throws IOException {
        this.zzbty.zzb(i, str);
    }

    public final void zza(int i, zzte zzte) throws IOException {
        this.zzbty.zza(i, zzte);
    }

    public final void zze(int i, int i2) throws IOException {
        this.zzbty.zze(i, i2);
    }

    public final void zzf(int i, int i2) throws IOException {
        this.zzbty.zzf(i, i2);
    }

    public final void zzb(int i, long j) throws IOException {
        this.zzbty.zzb(i, j);
    }

    public final void zza(int i, Object obj, zzwl zzwl) throws IOException {
        this.zzbty.zza(i, (zzvv) obj, zzwl);
    }

    public final void zzb(int i, Object obj, zzwl zzwl) throws IOException {
        zztv zztv = this.zzbty;
        zztv.zzc(i, 3);
        zzwl.zza((zzvv) obj, zztv.zzbup);
        zztv.zzc(i, 4);
    }

    public final void zzbm(int i) throws IOException {
        this.zzbty.zzc(i, 3);
    }

    public final void zzbn(int i) throws IOException {
        this.zzbty.zzc(i, 4);
    }

    public final void zza(int i, Object obj) throws IOException {
        if (obj instanceof zzte) {
            this.zzbty.zzb(i, (zzte) obj);
        } else {
            this.zzbty.zzb(i, (zzvv) obj);
        }
    }

    public final void zza(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzbty.zzc(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zztv.zzbe(list.get(i4).intValue());
            }
            this.zzbty.zzba(i3);
            while (i2 < list.size()) {
                this.zzbty.zzaz(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzbty.zzd(i, list.get(i2).intValue());
            i2++;
        }
    }

    public final void zzb(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzbty.zzc(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zztv.zzbh(list.get(i4).intValue());
            }
            this.zzbty.zzba(i3);
            while (i2 < list.size()) {
                this.zzbty.zzbc(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzbty.zzg(i, list.get(i2).intValue());
            i2++;
        }
    }

    public final void zzc(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzbty.zzc(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zztv.zzaw(list.get(i4).longValue());
            }
            this.zzbty.zzba(i3);
            while (i2 < list.size()) {
                this.zzbty.zzat(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzbty.zza(i, list.get(i2).longValue());
            i2++;
        }
    }

    public final void zzd(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzbty.zzc(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zztv.zzax(list.get(i4).longValue());
            }
            this.zzbty.zzba(i3);
            while (i2 < list.size()) {
                this.zzbty.zzat(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzbty.zza(i, list.get(i2).longValue());
            i2++;
        }
    }

    public final void zze(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzbty.zzc(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zztv.zzaz(list.get(i4).longValue());
            }
            this.zzbty.zzba(i3);
            while (i2 < list.size()) {
                this.zzbty.zzav(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzbty.zzc(i, list.get(i2).longValue());
            i2++;
        }
    }

    public final void zzf(int i, List<Float> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzbty.zzc(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zztv.zzb(list.get(i4).floatValue());
            }
            this.zzbty.zzba(i3);
            while (i2 < list.size()) {
                this.zzbty.zza(list.get(i2).floatValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzbty.zza(i, list.get(i2).floatValue());
            i2++;
        }
    }

    public final void zzg(int i, List<Double> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzbty.zzc(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zztv.zzc(list.get(i4).doubleValue());
            }
            this.zzbty.zzba(i3);
            while (i2 < list.size()) {
                this.zzbty.zzb(list.get(i2).doubleValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzbty.zza(i, list.get(i2).doubleValue());
            i2++;
        }
    }

    public final void zzh(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzbty.zzc(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zztv.zzbj(list.get(i4).intValue());
            }
            this.zzbty.zzba(i3);
            while (i2 < list.size()) {
                this.zzbty.zzaz(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzbty.zzd(i, list.get(i2).intValue());
            i2++;
        }
    }

    public final void zzi(int i, List<Boolean> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzbty.zzc(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zztv.zzt(list.get(i4).booleanValue());
            }
            this.zzbty.zzba(i3);
            while (i2 < list.size()) {
                this.zzbty.zzs(list.get(i2).booleanValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzbty.zzb(i, list.get(i2).booleanValue());
            i2++;
        }
    }

    public final void zza(int i, List<String> list) throws IOException {
        int i2 = 0;
        if (list instanceof zzve) {
            zzve zzve = (zzve) list;
            while (i2 < list.size()) {
                Object zzbp = zzve.zzbp(i2);
                if (zzbp instanceof String) {
                    this.zzbty.zzb(i, (String) zzbp);
                } else {
                    this.zzbty.zza(i, (zzte) zzbp);
                }
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzbty.zzb(i, list.get(i2));
            i2++;
        }
    }

    public final void zzb(int i, List<zzte> list) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.zzbty.zza(i, list.get(i2));
        }
    }

    public final void zzj(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzbty.zzc(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zztv.zzbf(list.get(i4).intValue());
            }
            this.zzbty.zzba(i3);
            while (i2 < list.size()) {
                this.zzbty.zzba(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzbty.zze(i, list.get(i2).intValue());
            i2++;
        }
    }

    public final void zzk(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzbty.zzc(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zztv.zzbi(list.get(i4).intValue());
            }
            this.zzbty.zzba(i3);
            while (i2 < list.size()) {
                this.zzbty.zzbc(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzbty.zzg(i, list.get(i2).intValue());
            i2++;
        }
    }

    public final void zzl(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzbty.zzc(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zztv.zzba(list.get(i4).longValue());
            }
            this.zzbty.zzba(i3);
            while (i2 < list.size()) {
                this.zzbty.zzav(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzbty.zzc(i, list.get(i2).longValue());
            i2++;
        }
    }

    public final void zzm(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzbty.zzc(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zztv.zzbg(list.get(i4).intValue());
            }
            this.zzbty.zzba(i3);
            while (i2 < list.size()) {
                this.zzbty.zzbb(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzbty.zzf(i, list.get(i2).intValue());
            i2++;
        }
    }

    public final void zzn(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzbty.zzc(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zztv.zzay(list.get(i4).longValue());
            }
            this.zzbty.zzba(i3);
            while (i2 < list.size()) {
                this.zzbty.zzau(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzbty.zzb(i, list.get(i2).longValue());
            i2++;
        }
    }

    public final void zza(int i, List<?> list, zzwl zzwl) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            zza(i, (Object) list.get(i2), zzwl);
        }
    }

    public final void zzb(int i, List<?> list, zzwl zzwl) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            zzb(i, (Object) list.get(i2), zzwl);
        }
    }

    public final <K, V> void zza(int i, zzvo<K, V> zzvo, Map<K, V> map) throws IOException {
        for (Map.Entry next : map.entrySet()) {
            this.zzbty.zzc(i, 2);
            this.zzbty.zzba(zzvn.zza(zzvo, next.getKey(), next.getValue()));
            zzvn.zza(this.zzbty, zzvo, next.getKey(), next.getValue());
        }
    }
}
