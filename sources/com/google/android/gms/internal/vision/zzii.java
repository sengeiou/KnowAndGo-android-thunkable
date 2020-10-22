package com.google.android.gms.internal.vision;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.0.0 */
final class zzii<T> implements zzir<T> {
    private final zzic zzyy;
    private final boolean zzyz;
    private final zzjj<?, ?> zzzi;
    private final zzgf<?> zzzj;

    private zzii(zzjj<?, ?> zzjj, zzgf<?> zzgf, zzic zzic) {
        this.zzzi = zzjj;
        this.zzyz = zzgf.zze(zzic);
        this.zzzj = zzgf;
        this.zzyy = zzic;
    }

    static <T> zzii<T> zza(zzjj<?, ?> zzjj, zzgf<?> zzgf, zzic zzic) {
        return new zzii<>(zzjj, zzgf, zzic);
    }

    public final T newInstance() {
        return this.zzyy.zzgj().zzgb();
    }

    public final boolean equals(T t, T t2) {
        if (!this.zzzi.zzv(t).equals(this.zzzi.zzv(t2))) {
            return false;
        }
        if (this.zzyz) {
            return this.zzzj.zze((Object) t).equals(this.zzzj.zze((Object) t2));
        }
        return true;
    }

    public final int hashCode(T t) {
        int hashCode = this.zzzi.zzv(t).hashCode();
        return this.zzyz ? (hashCode * 53) + this.zzzj.zze((Object) t).hashCode() : hashCode;
    }

    public final void zzd(T t, T t2) {
        zzit.zza(this.zzzi, t, t2);
        if (this.zzyz) {
            zzit.zza(this.zzzj, t, t2);
        }
    }

    public final void zza(T t, zzkg zzkg) throws IOException {
        Iterator<Map.Entry<?, Object>> it = this.zzzj.zze((Object) t).iterator();
        while (it.hasNext()) {
            Map.Entry next = it.next();
            zzgk zzgk = (zzgk) next.getKey();
            if (zzgk.zzft() != zzkd.MESSAGE || zzgk.zzfu() || zzgk.zzfv()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            } else if (next instanceof zzhf) {
                zzkg.zza(zzgk.zzag(), (Object) ((zzhf) next).zzgw().zzdk());
            } else {
                zzkg.zza(zzgk.zzag(), next.getValue());
            }
        }
        zzjj<?, ?> zzjj = this.zzzi;
        zzjj.zzc(zzjj.zzv(t), zzkg);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v10, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: com.google.android.gms.internal.vision.zzgs$zzg} */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(T r10, byte[] r11, int r12, int r13, com.google.android.gms.internal.vision.zzfb r14) throws java.io.IOException {
        /*
            r9 = this;
            r0 = r10
            com.google.android.gms.internal.vision.zzgs r0 = (com.google.android.gms.internal.vision.zzgs) r0
            com.google.android.gms.internal.vision.zzjm r1 = r0.zzwd
            com.google.android.gms.internal.vision.zzjm r2 = com.google.android.gms.internal.vision.zzjm.zzig()
            if (r1 != r2) goto L_0x0011
            com.google.android.gms.internal.vision.zzjm r1 = com.google.android.gms.internal.vision.zzjm.zzih()
            r0.zzwd = r1
        L_0x0011:
            com.google.android.gms.internal.vision.zzgs$zze r10 = (com.google.android.gms.internal.vision.zzgs.zze) r10
            com.google.android.gms.internal.vision.zzgi r10 = r10.zzgk()
            r0 = 0
            r2 = r0
        L_0x0019:
            if (r12 >= r13) goto L_0x00c8
            int r4 = com.google.android.gms.internal.vision.zzez.zza(r11, r12, r14)
            int r12 = r14.zzro
            r3 = 11
            r5 = 2
            if (r12 == r3) goto L_0x0065
            r3 = r12 & 7
            if (r3 != r5) goto L_0x0060
            com.google.android.gms.internal.vision.zzgf<?> r2 = r9.zzzj
            com.google.android.gms.internal.vision.zzgd r3 = r14.zzcm
            com.google.android.gms.internal.vision.zzic r5 = r9.zzyy
            int r6 = r12 >>> 3
            java.lang.Object r2 = r2.zza(r3, r5, r6)
            r8 = r2
            com.google.android.gms.internal.vision.zzgs$zzg r8 = (com.google.android.gms.internal.vision.zzgs.zzg) r8
            if (r8 == 0) goto L_0x0056
            com.google.android.gms.internal.vision.zzin r12 = com.google.android.gms.internal.vision.zzin.zzho()
            com.google.android.gms.internal.vision.zzic r2 = r8.zzxa
            java.lang.Class r2 = r2.getClass()
            com.google.android.gms.internal.vision.zzir r12 = r12.zzf(r2)
            int r12 = com.google.android.gms.internal.vision.zzez.zza((com.google.android.gms.internal.vision.zzir) r12, (byte[]) r11, (int) r4, (int) r13, (com.google.android.gms.internal.vision.zzfb) r14)
            com.google.android.gms.internal.vision.zzgs$zzd r2 = r8.zzxb
            java.lang.Object r3 = r14.zzrq
            r10.zza(r2, (java.lang.Object) r3)
        L_0x0054:
            r2 = r8
            goto L_0x0019
        L_0x0056:
            r2 = r12
            r3 = r11
            r5 = r13
            r6 = r1
            r7 = r14
            int r12 = com.google.android.gms.internal.vision.zzez.zza((int) r2, (byte[]) r3, (int) r4, (int) r5, (com.google.android.gms.internal.vision.zzjm) r6, (com.google.android.gms.internal.vision.zzfb) r7)
            goto L_0x0054
        L_0x0060:
            int r12 = com.google.android.gms.internal.vision.zzez.zza((int) r12, (byte[]) r11, (int) r4, (int) r13, (com.google.android.gms.internal.vision.zzfb) r14)
            goto L_0x0019
        L_0x0065:
            r12 = 0
            r12 = r0
            r3 = 0
        L_0x0068:
            if (r4 >= r13) goto L_0x00bd
            int r4 = com.google.android.gms.internal.vision.zzez.zza(r11, r4, r14)
            int r6 = r14.zzro
            int r7 = r6 >>> 3
            r8 = r6 & 7
            switch(r7) {
                case 2: goto L_0x009f;
                case 3: goto L_0x0078;
                default: goto L_0x0077;
            }
        L_0x0077:
            goto L_0x00b4
        L_0x0078:
            if (r2 == 0) goto L_0x0094
            com.google.android.gms.internal.vision.zzin r6 = com.google.android.gms.internal.vision.zzin.zzho()
            com.google.android.gms.internal.vision.zzic r7 = r2.zzxa
            java.lang.Class r7 = r7.getClass()
            com.google.android.gms.internal.vision.zzir r6 = r6.zzf(r7)
            int r4 = com.google.android.gms.internal.vision.zzez.zza((com.google.android.gms.internal.vision.zzir) r6, (byte[]) r11, (int) r4, (int) r13, (com.google.android.gms.internal.vision.zzfb) r14)
            com.google.android.gms.internal.vision.zzgs$zzd r6 = r2.zzxb
            java.lang.Object r7 = r14.zzrq
            r10.zza(r6, (java.lang.Object) r7)
            goto L_0x0068
        L_0x0094:
            if (r8 != r5) goto L_0x00b4
            int r4 = com.google.android.gms.internal.vision.zzez.zze(r11, r4, r14)
            java.lang.Object r12 = r14.zzrq
            com.google.android.gms.internal.vision.zzfh r12 = (com.google.android.gms.internal.vision.zzfh) r12
            goto L_0x0068
        L_0x009f:
            if (r8 != 0) goto L_0x00b4
            int r4 = com.google.android.gms.internal.vision.zzez.zza(r11, r4, r14)
            int r3 = r14.zzro
            com.google.android.gms.internal.vision.zzgf<?> r2 = r9.zzzj
            com.google.android.gms.internal.vision.zzgd r6 = r14.zzcm
            com.google.android.gms.internal.vision.zzic r7 = r9.zzyy
            java.lang.Object r2 = r2.zza(r6, r7, r3)
            com.google.android.gms.internal.vision.zzgs$zzg r2 = (com.google.android.gms.internal.vision.zzgs.zzg) r2
            goto L_0x0068
        L_0x00b4:
            r7 = 12
            if (r6 == r7) goto L_0x00bd
            int r4 = com.google.android.gms.internal.vision.zzez.zza((int) r6, (byte[]) r11, (int) r4, (int) r13, (com.google.android.gms.internal.vision.zzfb) r14)
            goto L_0x0068
        L_0x00bd:
            if (r12 == 0) goto L_0x00c5
            int r3 = r3 << 3
            r3 = r3 | r5
            r1.zzb(r3, r12)
        L_0x00c5:
            r12 = r4
            goto L_0x0019
        L_0x00c8:
            if (r12 != r13) goto L_0x00cb
            return
        L_0x00cb:
            com.google.android.gms.internal.vision.zzhc r10 = com.google.android.gms.internal.vision.zzhc.zzgs()
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzii.zza(java.lang.Object, byte[], int, int, com.google.android.gms.internal.vision.zzfb):void");
    }

    public final void zza(T t, zzis zzis, zzgd zzgd) throws IOException {
        boolean z;
        zzjj<?, ?> zzjj = this.zzzi;
        zzgf<?> zzgf = this.zzzj;
        Object zzw = zzjj.zzw(t);
        zzgi<?> zzf = zzgf.zzf(t);
        do {
            try {
                if (zzis.zzdu() == Integer.MAX_VALUE) {
                    zzjj.zzg(t, zzw);
                    return;
                }
                int tag = zzis.getTag();
                if (tag == 11) {
                    Object obj = null;
                    zzfh zzfh = null;
                    int i = 0;
                    while (zzis.zzdu() != Integer.MAX_VALUE) {
                        int tag2 = zzis.getTag();
                        if (tag2 == 16) {
                            i = zzis.zzee();
                            obj = zzgf.zza(zzgd, this.zzyy, i);
                        } else if (tag2 == 26) {
                            if (obj != null) {
                                zzgf.zza(zzis, obj, zzgd, zzf);
                            } else {
                                zzfh = zzis.zzed();
                            }
                        } else if (!zzis.zzdv()) {
                            break;
                        }
                    }
                    if (zzis.getTag() != 12) {
                        throw zzhc.zzgq();
                    } else if (zzfh != null) {
                        if (obj != null) {
                            zzgf.zza(zzfh, obj, zzgd, zzf);
                        } else {
                            zzjj.zza(zzw, i, zzfh);
                        }
                    }
                } else if ((tag & 7) == 2) {
                    Object zza = zzgf.zza(zzgd, this.zzyy, tag >>> 3);
                    if (zza != null) {
                        zzgf.zza(zzis, zza, zzgd, zzf);
                    } else {
                        z = zzjj.zza(zzw, zzis);
                        continue;
                    }
                } else {
                    z = zzis.zzdv();
                    continue;
                }
                z = true;
                continue;
            } finally {
                zzjj.zzg(t, zzw);
            }
        } while (z);
    }

    public final void zzg(T t) {
        this.zzzi.zzg(t);
        this.zzzj.zzg(t);
    }

    public final boolean zzt(T t) {
        return this.zzzj.zze((Object) t).isInitialized();
    }

    public final int zzr(T t) {
        zzjj<?, ?> zzjj = this.zzzi;
        int zzx = zzjj.zzx(zzjj.zzv(t)) + 0;
        return this.zzyz ? zzx + this.zzzj.zze((Object) t).zzfo() : zzx;
    }
}
