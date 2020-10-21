package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdnu;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

final class zzdns<FieldDescriptorType extends zzdnu<FieldDescriptorType>> {
    private static final zzdns zzhej = new zzdns(true);
    private final zzdqe<FieldDescriptorType, Object> zzheg = zzdqe.zzgy(16);
    private boolean zzheh;
    private boolean zzhei = false;

    private zzdns() {
    }

    private zzdns(boolean z) {
        zzavj();
    }

    public static <T extends zzdnu<T>> zzdns<T> zzaxi() {
        return zzhej;
    }

    /* access modifiers changed from: package-private */
    public final boolean isEmpty() {
        return this.zzheg.isEmpty();
    }

    public final void zzavj() {
        if (!this.zzheh) {
            this.zzheg.zzavj();
            this.zzheh = true;
        }
    }

    public final boolean isImmutable() {
        return this.zzheh;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzdns)) {
            return false;
        }
        return this.zzheg.equals(((zzdns) obj).zzheg);
    }

    public final int hashCode() {
        return this.zzheg.hashCode();
    }

    public final Iterator<Map.Entry<FieldDescriptorType, Object>> iterator() {
        if (this.zzhei) {
            return new zzdoq(this.zzheg.entrySet().iterator());
        }
        return this.zzheg.entrySet().iterator();
    }

    /* access modifiers changed from: package-private */
    public final Iterator<Map.Entry<FieldDescriptorType, Object>> descendingIterator() {
        if (this.zzhei) {
            return new zzdoq(this.zzheg.zzazr().iterator());
        }
        return this.zzheg.zzazr().iterator();
    }

    private final Object zza(FieldDescriptorType fielddescriptortype) {
        Object obj = this.zzheg.get(fielddescriptortype);
        return obj instanceof zzdon ? zzdon.zzaym() : obj;
    }

    private final void zza(FieldDescriptorType fielddescriptortype, Object obj) {
        if (!fielddescriptortype.zzaxn()) {
            zza(fielddescriptortype.zzaxl(), obj);
        } else if (obj instanceof List) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            ArrayList arrayList2 = arrayList;
            int size = arrayList2.size();
            int i = 0;
            while (i < size) {
                Object obj2 = arrayList2.get(i);
                i++;
                zza(fielddescriptortype.zzaxl(), obj2);
            }
            obj = arrayList;
        } else {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
        if (obj instanceof zzdon) {
            this.zzhei = true;
        }
        this.zzheg.put(fielddescriptortype, obj);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0026, code lost:
        r1 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002e, code lost:
        if ((r3 instanceof byte[]) == false) goto L_0x0043;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x001b, code lost:
        if ((r3 instanceof com.google.android.gms.internal.ads.zzdon) == false) goto L_0x0043;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0024, code lost:
        if ((r3 instanceof com.google.android.gms.internal.ads.zzdoe) == false) goto L_0x0043;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void zza(com.google.android.gms.internal.ads.zzdri r2, java.lang.Object r3) {
        /*
            com.google.android.gms.internal.ads.zzdod.checkNotNull(r3)
            int[] r0 = com.google.android.gms.internal.ads.zzdnt.zzhek
            com.google.android.gms.internal.ads.zzdrn r2 = r2.zzbaj()
            int r2 = r2.ordinal()
            r2 = r0[r2]
            r0 = 1
            r1 = 0
            switch(r2) {
                case 1: goto L_0x0040;
                case 2: goto L_0x003d;
                case 3: goto L_0x003a;
                case 4: goto L_0x0037;
                case 5: goto L_0x0034;
                case 6: goto L_0x0031;
                case 7: goto L_0x0028;
                case 8: goto L_0x001e;
                case 9: goto L_0x0015;
                default: goto L_0x0014;
            }
        L_0x0014:
            goto L_0x0043
        L_0x0015:
            boolean r2 = r3 instanceof com.google.android.gms.internal.ads.zzdpk
            if (r2 != 0) goto L_0x0026
            boolean r2 = r3 instanceof com.google.android.gms.internal.ads.zzdon
            if (r2 == 0) goto L_0x0043
            goto L_0x0026
        L_0x001e:
            boolean r2 = r3 instanceof java.lang.Integer
            if (r2 != 0) goto L_0x0026
            boolean r2 = r3 instanceof com.google.android.gms.internal.ads.zzdoe
            if (r2 == 0) goto L_0x0043
        L_0x0026:
            r1 = 1
            goto L_0x0043
        L_0x0028:
            boolean r2 = r3 instanceof com.google.android.gms.internal.ads.zzdmr
            if (r2 != 0) goto L_0x0026
            boolean r2 = r3 instanceof byte[]
            if (r2 == 0) goto L_0x0043
            goto L_0x0026
        L_0x0031:
            boolean r0 = r3 instanceof java.lang.String
            goto L_0x0042
        L_0x0034:
            boolean r0 = r3 instanceof java.lang.Boolean
            goto L_0x0042
        L_0x0037:
            boolean r0 = r3 instanceof java.lang.Double
            goto L_0x0042
        L_0x003a:
            boolean r0 = r3 instanceof java.lang.Float
            goto L_0x0042
        L_0x003d:
            boolean r0 = r3 instanceof java.lang.Long
            goto L_0x0042
        L_0x0040:
            boolean r0 = r3 instanceof java.lang.Integer
        L_0x0042:
            r1 = r0
        L_0x0043:
            if (r1 == 0) goto L_0x0046
            return
        L_0x0046:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r3 = "Wrong object type used with protocol message reflection."
            r2.<init>(r3)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdns.zza(com.google.android.gms.internal.ads.zzdri, java.lang.Object):void");
    }

    public final boolean isInitialized() {
        for (int i = 0; i < this.zzheg.zzazp(); i++) {
            if (!zzb(this.zzheg.zzgz(i))) {
                return false;
            }
        }
        for (Map.Entry<FieldDescriptorType, Object> zzb : this.zzheg.zzazq()) {
            if (!zzb(zzb)) {
                return false;
            }
        }
        return true;
    }

    private static boolean zzb(Map.Entry<FieldDescriptorType, Object> entry) {
        zzdnu zzdnu = (zzdnu) entry.getKey();
        if (zzdnu.zzaxm() == zzdrn.MESSAGE) {
            if (zzdnu.zzaxn()) {
                for (zzdpk isInitialized : (List) entry.getValue()) {
                    if (!isInitialized.isInitialized()) {
                        return false;
                    }
                }
            } else {
                Object value = entry.getValue();
                if (value instanceof zzdpk) {
                    if (!((zzdpk) value).isInitialized()) {
                        return false;
                    }
                } else if (value instanceof zzdon) {
                    return true;
                } else {
                    throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
                }
            }
        }
        return true;
    }

    public final void zza(zzdns<FieldDescriptorType> zzdns) {
        for (int i = 0; i < zzdns.zzheg.zzazp(); i++) {
            zzc(zzdns.zzheg.zzgz(i));
        }
        for (Map.Entry<FieldDescriptorType, Object> zzc : zzdns.zzheg.zzazq()) {
            zzc(zzc);
        }
    }

    private static Object zzab(Object obj) {
        if (obj instanceof zzdpr) {
            return ((zzdpr) obj).zzazc();
        }
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    private final void zzc(Map.Entry<FieldDescriptorType, Object> entry) {
        Object obj;
        zzdnu zzdnu = (zzdnu) entry.getKey();
        Object value = entry.getValue();
        if (value instanceof zzdon) {
            value = zzdon.zzaym();
        }
        if (zzdnu.zzaxn()) {
            Object zza = zza(zzdnu);
            if (zza == null) {
                zza = new ArrayList();
            }
            for (Object zzab : (List) value) {
                ((List) zza).add(zzab(zzab));
            }
            this.zzheg.put(zzdnu, zza);
        } else if (zzdnu.zzaxm() == zzdrn.MESSAGE) {
            Object zza2 = zza(zzdnu);
            if (zza2 == null) {
                this.zzheg.put(zzdnu, zzab(value));
                return;
            }
            if (zza2 instanceof zzdpr) {
                obj = zzdnu.zza((zzdpr) zza2, (zzdpr) value);
            } else {
                obj = zzdnu.zza(((zzdpk) zza2).zzaxt(), (zzdpk) value).zzaya();
            }
            this.zzheg.put(zzdnu, obj);
        } else {
            this.zzheg.put(zzdnu, zzab(value));
        }
    }

    static void zza(zzdni zzdni, zzdri zzdri, int i, Object obj) throws IOException {
        if (zzdri == zzdri.GROUP) {
            zzdpk zzdpk = (zzdpk) obj;
            zzdod.zzn(zzdpk);
            zzdni.zzw(i, 3);
            zzdpk.zzb(zzdni);
            zzdni.zzw(i, 4);
            return;
        }
        zzdni.zzw(i, zzdri.zzbak());
        switch (zzdnt.zzhdm[zzdri.ordinal()]) {
            case 1:
                zzdni.zzb(((Double) obj).doubleValue());
                return;
            case 2:
                zzdni.zzg(((Float) obj).floatValue());
                return;
            case 3:
                zzdni.zzfj(((Long) obj).longValue());
                return;
            case 4:
                zzdni.zzfj(((Long) obj).longValue());
                return;
            case 5:
                zzdni.zzfz(((Integer) obj).intValue());
                return;
            case 6:
                zzdni.zzfl(((Long) obj).longValue());
                return;
            case 7:
                zzdni.zzgc(((Integer) obj).intValue());
                return;
            case 8:
                zzdni.zzbf(((Boolean) obj).booleanValue());
                return;
            case 9:
                ((zzdpk) obj).zzb(zzdni);
                return;
            case 10:
                zzdni.zzj((zzdpk) obj);
                return;
            case 11:
                if (obj instanceof zzdmr) {
                    zzdni.zzcz((zzdmr) obj);
                    return;
                } else {
                    zzdni.zzgw((String) obj);
                    return;
                }
            case 12:
                if (obj instanceof zzdmr) {
                    zzdni.zzcz((zzdmr) obj);
                    return;
                }
                byte[] bArr = (byte[]) obj;
                zzdni.zzk(bArr, 0, bArr.length);
                return;
            case 13:
                zzdni.zzga(((Integer) obj).intValue());
                return;
            case 14:
                zzdni.zzgc(((Integer) obj).intValue());
                return;
            case 15:
                zzdni.zzfl(((Long) obj).longValue());
                return;
            case 16:
                zzdni.zzgb(((Integer) obj).intValue());
                return;
            case 17:
                zzdni.zzfk(((Long) obj).longValue());
                return;
            case 18:
                if (obj instanceof zzdoe) {
                    zzdni.zzfz(((zzdoe) obj).zzac());
                    return;
                } else {
                    zzdni.zzfz(((Integer) obj).intValue());
                    return;
                }
            default:
                return;
        }
    }

    public final int zzaxj() {
        int i = 0;
        for (int i2 = 0; i2 < this.zzheg.zzazp(); i2++) {
            Map.Entry<FieldDescriptorType, Object> zzgz = this.zzheg.zzgz(i2);
            i += zzb((zzdnu<?>) (zzdnu) zzgz.getKey(), zzgz.getValue());
        }
        for (Map.Entry next : this.zzheg.zzazq()) {
            i += zzb((zzdnu<?>) (zzdnu) next.getKey(), next.getValue());
        }
        return i;
    }

    public final int zzaxk() {
        int i = 0;
        for (int i2 = 0; i2 < this.zzheg.zzazp(); i2++) {
            i += zzd(this.zzheg.zzgz(i2));
        }
        for (Map.Entry<FieldDescriptorType, Object> zzd : this.zzheg.zzazq()) {
            i += zzd(zzd);
        }
        return i;
    }

    private static int zzd(Map.Entry<FieldDescriptorType, Object> entry) {
        zzdnu zzdnu = (zzdnu) entry.getKey();
        Object value = entry.getValue();
        if (zzdnu.zzaxm() != zzdrn.MESSAGE || zzdnu.zzaxn() || zzdnu.zzaxo()) {
            return zzb((zzdnu<?>) zzdnu, value);
        }
        if (value instanceof zzdon) {
            return zzdni.zzb(((zzdnu) entry.getKey()).zzac(), (zzdor) (zzdon) value);
        }
        return zzdni.zzd(((zzdnu) entry.getKey()).zzac(), (zzdpk) value);
    }

    static int zza(zzdri zzdri, int i, Object obj) {
        int zzgd = zzdni.zzgd(i);
        if (zzdri == zzdri.GROUP) {
            zzdod.zzn((zzdpk) obj);
            zzgd <<= 1;
        }
        return zzgd + zzb(zzdri, obj);
    }

    private static int zzb(zzdri zzdri, Object obj) {
        switch (zzdnt.zzhdm[zzdri.ordinal()]) {
            case 1:
                return zzdni.zzc(((Double) obj).doubleValue());
            case 2:
                return zzdni.zzh(((Float) obj).floatValue());
            case 3:
                return zzdni.zzfm(((Long) obj).longValue());
            case 4:
                return zzdni.zzfn(((Long) obj).longValue());
            case 5:
                return zzdni.zzge(((Integer) obj).intValue());
            case 6:
                return zzdni.zzfp(((Long) obj).longValue());
            case 7:
                return zzdni.zzgh(((Integer) obj).intValue());
            case 8:
                return zzdni.zzbg(((Boolean) obj).booleanValue());
            case 9:
                return zzdni.zzl((zzdpk) obj);
            case 10:
                if (obj instanceof zzdon) {
                    return zzdni.zza((zzdon) obj);
                }
                return zzdni.zzk((zzdpk) obj);
            case 11:
                if (obj instanceof zzdmr) {
                    return zzdni.zzda((zzdmr) obj);
                }
                return zzdni.zzgx((String) obj);
            case 12:
                if (obj instanceof zzdmr) {
                    return zzdni.zzda((zzdmr) obj);
                }
                return zzdni.zzac((byte[]) obj);
            case 13:
                return zzdni.zzgf(((Integer) obj).intValue());
            case 14:
                return zzdni.zzgi(((Integer) obj).intValue());
            case 15:
                return zzdni.zzfq(((Long) obj).longValue());
            case 16:
                return zzdni.zzgg(((Integer) obj).intValue());
            case 17:
                return zzdni.zzfo(((Long) obj).longValue());
            case 18:
                if (obj instanceof zzdoe) {
                    return zzdni.zzgj(((zzdoe) obj).zzac());
                }
                return zzdni.zzgj(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    private static int zzb(zzdnu<?> zzdnu, Object obj) {
        zzdri zzaxl = zzdnu.zzaxl();
        int zzac = zzdnu.zzac();
        if (!zzdnu.zzaxn()) {
            return zza(zzaxl, zzac, obj);
        }
        int i = 0;
        if (zzdnu.zzaxo()) {
            for (Object zzb : (List) obj) {
                i += zzb(zzaxl, zzb);
            }
            return zzdni.zzgd(zzac) + i + zzdni.zzgl(i);
        }
        for (Object zza : (List) obj) {
            i += zza(zzaxl, zzac, zza);
        }
        return i;
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzdns zzdns = new zzdns();
        for (int i = 0; i < this.zzheg.zzazp(); i++) {
            Map.Entry<FieldDescriptorType, Object> zzgz = this.zzheg.zzgz(i);
            zzdns.zza((zzdnu) zzgz.getKey(), zzgz.getValue());
        }
        for (Map.Entry next : this.zzheg.zzazq()) {
            zzdns.zza((zzdnu) next.getKey(), next.getValue());
        }
        zzdns.zzhei = this.zzhei;
        return zzdns;
    }
}
