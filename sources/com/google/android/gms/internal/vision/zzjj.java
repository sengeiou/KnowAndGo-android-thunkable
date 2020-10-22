package com.google.android.gms.internal.vision;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.0.0 */
abstract class zzjj<T, B> {
    zzjj() {
    }

    /* access modifiers changed from: package-private */
    public abstract void zza(B b, int i, long j);

    /* access modifiers changed from: package-private */
    public abstract void zza(B b, int i, zzfh zzfh);

    /* access modifiers changed from: package-private */
    public abstract void zza(B b, int i, T t);

    /* access modifiers changed from: package-private */
    public abstract void zza(T t, zzkg zzkg) throws IOException;

    /* access modifiers changed from: package-private */
    public abstract boolean zza(zzis zzis);

    /* access modifiers changed from: package-private */
    public abstract void zzb(B b, int i, long j);

    /* access modifiers changed from: package-private */
    public abstract void zzc(B b, int i, int i2);

    /* access modifiers changed from: package-private */
    public abstract void zzc(T t, zzkg zzkg) throws IOException;

    /* access modifiers changed from: package-private */
    public abstract void zzf(Object obj, T t);

    /* access modifiers changed from: package-private */
    public abstract void zzg(Object obj);

    /* access modifiers changed from: package-private */
    public abstract void zzg(Object obj, B b);

    /* access modifiers changed from: package-private */
    public abstract T zzh(T t, T t2);

    /* access modifiers changed from: package-private */
    public abstract B zzif();

    /* access modifiers changed from: package-private */
    public abstract T zzn(B b);

    /* access modifiers changed from: package-private */
    public abstract int zzr(T t);

    /* access modifiers changed from: package-private */
    public abstract T zzv(Object obj);

    /* access modifiers changed from: package-private */
    public abstract B zzw(Object obj);

    /* access modifiers changed from: package-private */
    public abstract int zzx(T t);

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023 A[LOOP:0: B:8:0x0023->B:11:0x0030, LOOP_START] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zza(B r7, com.google.android.gms.internal.vision.zzis r8) throws java.io.IOException {
        /*
            r6 = this;
            int r0 = r8.getTag()
            int r1 = r0 >>> 3
            r0 = r0 & 7
            r2 = 1
            switch(r0) {
                case 0: goto L_0x0055;
                case 1: goto L_0x004d;
                case 2: goto L_0x0045;
                case 3: goto L_0x001b;
                case 4: goto L_0x0019;
                case 5: goto L_0x0011;
                default: goto L_0x000c;
            }
        L_0x000c:
            com.google.android.gms.internal.vision.zzhb r7 = com.google.android.gms.internal.vision.zzhc.zzgr()
            throw r7
        L_0x0011:
            int r8 = r8.zzea()
            r6.zzc(r7, r1, r8)
            return r2
        L_0x0019:
            r7 = 0
            return r7
        L_0x001b:
            java.lang.Object r0 = r6.zzif()
            int r3 = r1 << 3
            r3 = r3 | 4
        L_0x0023:
            int r4 = r8.zzdu()
            r5 = 2147483647(0x7fffffff, float:NaN)
            if (r4 == r5) goto L_0x0032
            boolean r4 = r6.zza(r0, (com.google.android.gms.internal.vision.zzis) r8)
            if (r4 != 0) goto L_0x0023
        L_0x0032:
            int r8 = r8.getTag()
            if (r3 != r8) goto L_0x0040
            java.lang.Object r8 = r6.zzn(r0)
            r6.zza(r7, (int) r1, r8)
            return r2
        L_0x0040:
            com.google.android.gms.internal.vision.zzhc r7 = com.google.android.gms.internal.vision.zzhc.zzgq()
            throw r7
        L_0x0045:
            com.google.android.gms.internal.vision.zzfh r8 = r8.zzed()
            r6.zza(r7, (int) r1, (com.google.android.gms.internal.vision.zzfh) r8)
            return r2
        L_0x004d:
            long r3 = r8.zzdz()
            r6.zzb(r7, r1, r3)
            return r2
        L_0x0055:
            long r3 = r8.zzdx()
            r6.zza(r7, (int) r1, (long) r3)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzjj.zza(java.lang.Object, com.google.android.gms.internal.vision.zzis):boolean");
    }
}
