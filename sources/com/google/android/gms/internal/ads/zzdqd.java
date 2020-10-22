package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

final class zzdqd {
    private static final Class<?> zzhkn = zzazn();
    private static final zzdqt<?, ?> zzhko = zzbi(false);
    private static final zzdqt<?, ?> zzhkp = zzbi(true);
    private static final zzdqt<?, ?> zzhkq = new zzdqv();

    public static void zzh(Class<?> cls) {
        if (!zzdob.class.isAssignableFrom(cls) && zzhkn != null && !zzhkn.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static void zza(int i, List<Double> list, zzdro zzdro, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzdro.zzg(i, list, z);
        }
    }

    public static void zzb(int i, List<Float> list, zzdro zzdro, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzdro.zzf(i, list, z);
        }
    }

    public static void zzc(int i, List<Long> list, zzdro zzdro, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzdro.zzc(i, list, z);
        }
    }

    public static void zzd(int i, List<Long> list, zzdro zzdro, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzdro.zzd(i, list, z);
        }
    }

    public static void zze(int i, List<Long> list, zzdro zzdro, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzdro.zzn(i, list, z);
        }
    }

    public static void zzf(int i, List<Long> list, zzdro zzdro, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzdro.zze(i, list, z);
        }
    }

    public static void zzg(int i, List<Long> list, zzdro zzdro, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzdro.zzl(i, list, z);
        }
    }

    public static void zzh(int i, List<Integer> list, zzdro zzdro, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzdro.zza(i, list, z);
        }
    }

    public static void zzi(int i, List<Integer> list, zzdro zzdro, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzdro.zzj(i, list, z);
        }
    }

    public static void zzj(int i, List<Integer> list, zzdro zzdro, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzdro.zzm(i, list, z);
        }
    }

    public static void zzk(int i, List<Integer> list, zzdro zzdro, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzdro.zzb(i, list, z);
        }
    }

    public static void zzl(int i, List<Integer> list, zzdro zzdro, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzdro.zzk(i, list, z);
        }
    }

    public static void zzm(int i, List<Integer> list, zzdro zzdro, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzdro.zzh(i, list, z);
        }
    }

    public static void zzn(int i, List<Boolean> list, zzdro zzdro, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzdro.zzi(i, list, z);
        }
    }

    public static void zza(int i, List<String> list, zzdro zzdro) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzdro.zza(i, list);
        }
    }

    public static void zzb(int i, List<zzdmr> list, zzdro zzdro) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzdro.zzb(i, list);
        }
    }

    public static void zza(int i, List<?> list, zzdro zzdro, zzdqb zzdqb) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzdro.zza(i, list, zzdqb);
        }
    }

    public static void zzb(int i, List<?> list, zzdro zzdro, zzdqb zzdqb) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzdro.zzb(i, list, zzdqb);
        }
    }

    static int zzy(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzdoy) {
            zzdoy zzdoy = (zzdoy) list;
            i = 0;
            while (i2 < size) {
                i += zzdni.zzfm(zzdoy.getLong(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzdni.zzfm(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    static int zzo(int i, List<Long> list, boolean z) {
        if (list.size() == 0) {
            return 0;
        }
        return zzy(list) + (list.size() * zzdni.zzgd(i));
    }

    static int zzz(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzdoy) {
            zzdoy zzdoy = (zzdoy) list;
            i = 0;
            while (i2 < size) {
                i += zzdni.zzfn(zzdoy.getLong(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzdni.zzfn(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    static int zzp(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzz(list) + (size * zzdni.zzgd(i));
    }

    static int zzaa(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzdoy) {
            zzdoy zzdoy = (zzdoy) list;
            i = 0;
            while (i2 < size) {
                i += zzdni.zzfo(zzdoy.getLong(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzdni.zzfo(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    static int zzq(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzaa(list) + (size * zzdni.zzgd(i));
    }

    static int zzab(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzdoc) {
            zzdoc zzdoc = (zzdoc) list;
            i = 0;
            while (i2 < size) {
                i += zzdni.zzgj(zzdoc.getInt(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzdni.zzgj(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    static int zzr(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzab(list) + (size * zzdni.zzgd(i));
    }

    static int zzac(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzdoc) {
            zzdoc zzdoc = (zzdoc) list;
            i = 0;
            while (i2 < size) {
                i += zzdni.zzge(zzdoc.getInt(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzdni.zzge(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    static int zzs(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzac(list) + (size * zzdni.zzgd(i));
    }

    static int zzad(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzdoc) {
            zzdoc zzdoc = (zzdoc) list;
            i = 0;
            while (i2 < size) {
                i += zzdni.zzgf(zzdoc.getInt(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzdni.zzgf(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    static int zzt(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzad(list) + (size * zzdni.zzgd(i));
    }

    static int zzae(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzdoc) {
            zzdoc zzdoc = (zzdoc) list;
            i = 0;
            while (i2 < size) {
                i += zzdni.zzgg(zzdoc.getInt(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzdni.zzgg(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    static int zzu(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzae(list) + (size * zzdni.zzgd(i));
    }

    static int zzaf(List<?> list) {
        return list.size() << 2;
    }

    static int zzv(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzdni.zzae(i, 0);
    }

    static int zzag(List<?> list) {
        return list.size() << 3;
    }

    static int zzw(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzdni.zzn(i, 0);
    }

    static int zzah(List<?> list) {
        return list.size();
    }

    static int zzx(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzdni.zzj(i, true);
    }

    static int zzc(int i, List<?> list) {
        int i2;
        int i3;
        int size = list.size();
        int i4 = 0;
        if (size == 0) {
            return 0;
        }
        int zzgd = zzdni.zzgd(i) * size;
        if (list instanceof zzdot) {
            zzdot zzdot = (zzdot) list;
            while (i4 < size) {
                Object zzgq = zzdot.zzgq(i4);
                if (zzgq instanceof zzdmr) {
                    i3 = zzdni.zzda((zzdmr) zzgq);
                } else {
                    i3 = zzdni.zzgx((String) zzgq);
                }
                zzgd += i3;
                i4++;
            }
        } else {
            while (i4 < size) {
                Object obj = list.get(i4);
                if (obj instanceof zzdmr) {
                    i2 = zzdni.zzda((zzdmr) obj);
                } else {
                    i2 = zzdni.zzgx((String) obj);
                }
                zzgd += i2;
                i4++;
            }
        }
        return zzgd;
    }

    static int zzc(int i, Object obj, zzdqb zzdqb) {
        if (obj instanceof zzdor) {
            return zzdni.zza(i, (zzdor) obj);
        }
        return zzdni.zzb(i, (zzdpk) obj, zzdqb);
    }

    static int zzc(int i, List<?> list, zzdqb zzdqb) {
        int i2;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzgd = zzdni.zzgd(i) * size;
        for (int i3 = 0; i3 < size; i3++) {
            Object obj = list.get(i3);
            if (obj instanceof zzdor) {
                i2 = zzdni.zza((zzdor) obj);
            } else {
                i2 = zzdni.zzb((zzdpk) obj, zzdqb);
            }
            zzgd += i2;
        }
        return zzgd;
    }

    static int zzd(int i, List<zzdmr> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzgd = size * zzdni.zzgd(i);
        for (int i2 = 0; i2 < list.size(); i2++) {
            zzgd += zzdni.zzda(list.get(i2));
        }
        return zzgd;
    }

    static int zzd(int i, List<zzdpk> list, zzdqb zzdqb) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i2 += zzdni.zzc(i, list.get(i3), zzdqb);
        }
        return i2;
    }

    public static zzdqt<?, ?> zzazk() {
        return zzhko;
    }

    public static zzdqt<?, ?> zzazl() {
        return zzhkp;
    }

    public static zzdqt<?, ?> zzazm() {
        return zzhkq;
    }

    private static zzdqt<?, ?> zzbi(boolean z) {
        try {
            Class<?> zzazo = zzazo();
            if (zzazo == null) {
                return null;
            }
            return (zzdqt) zzazo.getConstructor(new Class[]{Boolean.TYPE}).newInstance(new Object[]{Boolean.valueOf(z)});
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Class<?> zzazn() {
        try {
            return Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Class<?> zzazo() {
        try {
            return Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            return null;
        }
    }

    static boolean zze(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    static <T> void zza(zzdpf zzdpf, T t, T t2, long j) {
        zzdqz.zza((Object) t, j, zzdpf.zzc(zzdqz.zzp(t, j), zzdqz.zzp(t2, j)));
    }

    static <T, FT extends zzdnu<FT>> void zza(zzdnp<FT> zzdnp, T t, T t2) {
        zzdns<FT> zzy = zzdnp.zzy(t2);
        if (!zzy.isEmpty()) {
            zzdnp.zzz(t).zza(zzy);
        }
    }

    static <T, UT, UB> void zza(zzdqt<UT, UB> zzdqt, T t, T t2) {
        zzdqt.zzf(t, zzdqt.zzh(zzdqt.zzao(t), zzdqt.zzao(t2)));
    }

    static <UT, UB> UB zza(int i, List<Integer> list, zzdog zzdog, UB ub, zzdqt<UT, UB> zzdqt) {
        UB ub2;
        if (zzdog == null) {
            return ub;
        }
        if (!(list instanceof RandomAccess)) {
            Iterator<Integer> it = list.iterator();
            loop1:
            while (true) {
                ub2 = ub;
                while (it.hasNext()) {
                    int intValue = it.next().intValue();
                    if (!zzdog.zzf(intValue)) {
                        ub = zza(i, intValue, ub2, zzdqt);
                        it.remove();
                    }
                }
                break loop1;
            }
        } else {
            int size = list.size();
            ub2 = ub;
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                int intValue2 = list.get(i3).intValue();
                if (zzdog.zzf(intValue2)) {
                    if (i3 != i2) {
                        list.set(i2, Integer.valueOf(intValue2));
                    }
                    i2++;
                } else {
                    ub2 = zza(i, intValue2, ub2, zzdqt);
                }
            }
            if (i2 != size) {
                list.subList(i2, size).clear();
            }
        }
        return ub2;
    }

    static <UT, UB> UB zza(int i, int i2, UB ub, zzdqt<UT, UB> zzdqt) {
        if (ub == null) {
            ub = zzdqt.zzazy();
        }
        zzdqt.zza(ub, i, (long) i2);
        return ub;
    }
}
