package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

final class zzdpq<T> implements zzdqb<T> {
    private final zzdpk zzhju;
    private final boolean zzhjv;
    private final zzdqt<?, ?> zzhke;
    private final zzdnp<?> zzhkf;

    private zzdpq(zzdqt<?, ?> zzdqt, zzdnp<?> zzdnp, zzdpk zzdpk) {
        this.zzhke = zzdqt;
        this.zzhjv = zzdnp.zzm(zzdpk);
        this.zzhkf = zzdnp;
        this.zzhju = zzdpk;
    }

    static <T> zzdpq<T> zza(zzdqt<?, ?> zzdqt, zzdnp<?> zzdnp, zzdpk zzdpk) {
        return new zzdpq<>(zzdqt, zzdnp, zzdpk);
    }

    public final T newInstance() {
        return this.zzhju.zzaxu().zzaxz();
    }

    public final boolean equals(T t, T t2) {
        if (!this.zzhke.zzao(t).equals(this.zzhke.zzao(t2))) {
            return false;
        }
        if (this.zzhjv) {
            return this.zzhkf.zzy(t).equals(this.zzhkf.zzy(t2));
        }
        return true;
    }

    public final int hashCode(T t) {
        int hashCode = this.zzhke.zzao(t).hashCode();
        return this.zzhjv ? (hashCode * 53) + this.zzhkf.zzy(t).hashCode() : hashCode;
    }

    public final void zzd(T t, T t2) {
        zzdqd.zza(this.zzhke, t, t2);
        if (this.zzhjv) {
            zzdqd.zza(this.zzhkf, t, t2);
        }
    }

    public final void zza(T t, zzdro zzdro) throws IOException {
        Iterator<Map.Entry<?, Object>> it = this.zzhkf.zzy(t).iterator();
        while (it.hasNext()) {
            Map.Entry next = it.next();
            zzdnu zzdnu = (zzdnu) next.getKey();
            if (zzdnu.zzaxm() != zzdrn.MESSAGE || zzdnu.zzaxn() || zzdnu.zzaxo()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            } else if (next instanceof zzdop) {
                zzdro.zzb(zzdnu.zzac(), (Object) ((zzdop) next).zzayn().zzavf());
            } else {
                zzdro.zzb(zzdnu.zzac(), next.getValue());
            }
        }
        zzdqt<?, ?> zzdqt = this.zzhke;
        zzdqt.zzc(zzdqt.zzao(t), zzdro);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v14, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v13, resolved type: com.google.android.gms.internal.ads.zzdob$zzd} */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(T r9, byte[] r10, int r11, int r12, com.google.android.gms.internal.ads.zzdmo r13) throws java.io.IOException {
        /*
            r8 = this;
            r0 = r9
            com.google.android.gms.internal.ads.zzdob r0 = (com.google.android.gms.internal.ads.zzdob) r0
            com.google.android.gms.internal.ads.zzdqu r1 = r0.zzhhd
            com.google.android.gms.internal.ads.zzdqu r2 = com.google.android.gms.internal.ads.zzdqu.zzazz()
            if (r1 != r2) goto L_0x0011
            com.google.android.gms.internal.ads.zzdqu r1 = com.google.android.gms.internal.ads.zzdqu.zzbaa()
            r0.zzhhd = r1
        L_0x0011:
            com.google.android.gms.internal.ads.zzdob$zzc r9 = (com.google.android.gms.internal.ads.zzdob.zzc) r9
            com.google.android.gms.internal.ads.zzdns<java.lang.Object> r0 = r9.zzhhj
            boolean r0 = r0.isImmutable()
            if (r0 == 0) goto L_0x0025
            com.google.android.gms.internal.ads.zzdns<java.lang.Object> r0 = r9.zzhhj
            java.lang.Object r0 = r0.clone()
            com.google.android.gms.internal.ads.zzdns r0 = (com.google.android.gms.internal.ads.zzdns) r0
            r9.zzhhj = r0
        L_0x0025:
            com.google.android.gms.internal.ads.zzdns<java.lang.Object> r9 = r9.zzhhj
            r9 = 0
            r0 = r9
        L_0x0029:
            if (r11 >= r12) goto L_0x00b4
            int r4 = com.google.android.gms.internal.ads.zzdmn.zza(r10, r11, r13)
            int r2 = r13.zzhcl
            r11 = 11
            r3 = 2
            if (r2 == r11) goto L_0x0062
            r11 = r2 & 7
            if (r11 != r3) goto L_0x005d
            com.google.android.gms.internal.ads.zzdnp<?> r11 = r8.zzhkf
            com.google.android.gms.internal.ads.zzdno r0 = r13.zzhco
            com.google.android.gms.internal.ads.zzdpk r3 = r8.zzhju
            int r5 = r2 >>> 3
            java.lang.Object r11 = r11.zza(r0, r3, r5)
            r0 = r11
            com.google.android.gms.internal.ads.zzdob$zzd r0 = (com.google.android.gms.internal.ads.zzdob.zzd) r0
            if (r0 != 0) goto L_0x0054
            r3 = r10
            r5 = r12
            r6 = r1
            r7 = r13
            int r11 = com.google.android.gms.internal.ads.zzdmn.zza((int) r2, (byte[]) r3, (int) r4, (int) r5, (com.google.android.gms.internal.ads.zzdqu) r6, (com.google.android.gms.internal.ads.zzdmo) r7)
            goto L_0x0029
        L_0x0054:
            com.google.android.gms.internal.ads.zzdpx.zzazg()
            java.lang.NoSuchMethodError r9 = new java.lang.NoSuchMethodError
            r9.<init>()
            throw r9
        L_0x005d:
            int r11 = com.google.android.gms.internal.ads.zzdmn.zza((int) r2, (byte[]) r10, (int) r4, (int) r12, (com.google.android.gms.internal.ads.zzdmo) r13)
            goto L_0x0029
        L_0x0062:
            r11 = 0
            r11 = r9
            r2 = 0
        L_0x0065:
            if (r4 >= r12) goto L_0x00a9
            int r4 = com.google.android.gms.internal.ads.zzdmn.zza(r10, r4, r13)
            int r5 = r13.zzhcl
            int r6 = r5 >>> 3
            r7 = r5 & 7
            switch(r6) {
                case 2: goto L_0x008b;
                case 3: goto L_0x0075;
                default: goto L_0x0074;
            }
        L_0x0074:
            goto L_0x00a0
        L_0x0075:
            if (r0 != 0) goto L_0x0082
            if (r7 != r3) goto L_0x00a0
            int r4 = com.google.android.gms.internal.ads.zzdmn.zze(r10, r4, r13)
            java.lang.Object r11 = r13.zzhcn
            com.google.android.gms.internal.ads.zzdmr r11 = (com.google.android.gms.internal.ads.zzdmr) r11
            goto L_0x0065
        L_0x0082:
            com.google.android.gms.internal.ads.zzdpx.zzazg()
            java.lang.NoSuchMethodError r9 = new java.lang.NoSuchMethodError
            r9.<init>()
            throw r9
        L_0x008b:
            if (r7 != 0) goto L_0x00a0
            int r4 = com.google.android.gms.internal.ads.zzdmn.zza(r10, r4, r13)
            int r2 = r13.zzhcl
            com.google.android.gms.internal.ads.zzdnp<?> r0 = r8.zzhkf
            com.google.android.gms.internal.ads.zzdno r5 = r13.zzhco
            com.google.android.gms.internal.ads.zzdpk r6 = r8.zzhju
            java.lang.Object r0 = r0.zza(r5, r6, r2)
            com.google.android.gms.internal.ads.zzdob$zzd r0 = (com.google.android.gms.internal.ads.zzdob.zzd) r0
            goto L_0x0065
        L_0x00a0:
            r6 = 12
            if (r5 == r6) goto L_0x00a9
            int r4 = com.google.android.gms.internal.ads.zzdmn.zza((int) r5, (byte[]) r10, (int) r4, (int) r12, (com.google.android.gms.internal.ads.zzdmo) r13)
            goto L_0x0065
        L_0x00a9:
            if (r11 == 0) goto L_0x00b1
            int r2 = r2 << 3
            r2 = r2 | r3
            r1.zzc(r2, r11)
        L_0x00b1:
            r11 = r4
            goto L_0x0029
        L_0x00b4:
            if (r11 != r12) goto L_0x00b7
            return
        L_0x00b7:
            com.google.android.gms.internal.ads.zzdok r9 = com.google.android.gms.internal.ads.zzdok.zzayj()
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdpq.zza(java.lang.Object, byte[], int, int, com.google.android.gms.internal.ads.zzdmo):void");
    }

    public final void zza(T t, zzdqa zzdqa, zzdno zzdno) throws IOException {
        boolean z;
        zzdqt<?, ?> zzdqt = this.zzhke;
        zzdnp<?> zzdnp = this.zzhkf;
        Object zzap = zzdqt.zzap(t);
        zzdns<?> zzz = zzdnp.zzz(t);
        do {
            try {
                if (zzdqa.zzaws() == Integer.MAX_VALUE) {
                    zzdqt.zzg(t, zzap);
                    return;
                }
                int tag = zzdqa.getTag();
                if (tag == 11) {
                    Object obj = null;
                    zzdmr zzdmr = null;
                    int i = 0;
                    while (zzdqa.zzaws() != Integer.MAX_VALUE) {
                        int tag2 = zzdqa.getTag();
                        if (tag2 == 16) {
                            i = zzdqa.zzawd();
                            obj = zzdnp.zza(zzdno, this.zzhju, i);
                        } else if (tag2 == 26) {
                            if (obj != null) {
                                zzdnp.zza(zzdqa, obj, zzdno, zzz);
                            } else {
                                zzdmr = zzdqa.zzawc();
                            }
                        } else if (!zzdqa.zzawt()) {
                            break;
                        }
                    }
                    if (zzdqa.getTag() != 12) {
                        throw zzdok.zzayh();
                    } else if (zzdmr != null) {
                        if (obj != null) {
                            zzdnp.zza(zzdmr, obj, zzdno, zzz);
                        } else {
                            zzdqt.zza(zzap, i, zzdmr);
                        }
                    }
                } else if ((tag & 7) == 2) {
                    Object zza = zzdnp.zza(zzdno, this.zzhju, tag >>> 3);
                    if (zza != null) {
                        zzdnp.zza(zzdqa, zza, zzdno, zzz);
                    } else {
                        z = zzdqt.zza(zzap, zzdqa);
                        continue;
                    }
                } else {
                    z = zzdqa.zzawt();
                    continue;
                }
                z = true;
                continue;
            } finally {
                zzdqt.zzg(t, zzap);
            }
        } while (z);
    }

    public final void zzaa(T t) {
        this.zzhke.zzaa(t);
        this.zzhkf.zzaa(t);
    }

    public final boolean zzam(T t) {
        return this.zzhkf.zzy(t).isInitialized();
    }

    public final int zzak(T t) {
        zzdqt<?, ?> zzdqt = this.zzhke;
        int zzaq = zzdqt.zzaq(zzdqt.zzao(t)) + 0;
        return this.zzhjv ? zzaq + this.zzhkf.zzy(t).zzaxk() : zzaq;
    }
}
