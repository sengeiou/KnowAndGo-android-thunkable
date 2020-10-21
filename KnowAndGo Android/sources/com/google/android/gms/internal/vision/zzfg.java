package com.google.android.gms.internal.vision;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;
import kotlin.UByte;
import kotlin.jvm.internal.ByteCompanionObject;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.0.0 */
final class zzfg extends zzfe {
    private final byte[] buffer;
    private int limit;
    private int pos;
    private int tag;
    private final boolean zzru = true;
    private final int zzrv;
    private int zzrw;

    public zzfg(ByteBuffer byteBuffer, boolean z) {
        super((zzfd) null);
        this.buffer = byteBuffer.array();
        int arrayOffset = byteBuffer.arrayOffset() + byteBuffer.position();
        this.pos = arrayOffset;
        this.zzrv = arrayOffset;
        this.limit = byteBuffer.arrayOffset() + byteBuffer.limit();
    }

    private final boolean zzdt() {
        return this.pos == this.limit;
    }

    public final int zzdu() throws IOException {
        if (zzdt()) {
            return Integer.MAX_VALUE;
        }
        this.tag = zzek();
        if (this.tag == this.zzrw) {
            return Integer.MAX_VALUE;
        }
        return this.tag >>> 3;
    }

    public final int getTag() {
        return this.tag;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x002b A[LOOP:0: B:10:0x002b->B:13:0x0038, LOOP_START] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzdv() throws java.io.IOException {
        /*
            r7 = this;
            boolean r0 = r7.zzdt()
            r1 = 0
            if (r0 != 0) goto L_0x0089
            int r0 = r7.tag
            int r2 = r7.zzrw
            if (r0 != r2) goto L_0x000f
            goto L_0x0089
        L_0x000f:
            int r0 = r7.tag
            r0 = r0 & 7
            r2 = 5
            r3 = 4
            r4 = 1
            if (r0 == r2) goto L_0x0085
            switch(r0) {
                case 0: goto L_0x0056;
                case 1: goto L_0x0050;
                case 2: goto L_0x0048;
                case 3: goto L_0x0020;
                default: goto L_0x001b;
            }
        L_0x001b:
            com.google.android.gms.internal.vision.zzhb r0 = com.google.android.gms.internal.vision.zzhc.zzgr()
            throw r0
        L_0x0020:
            int r0 = r7.zzrw
            int r1 = r7.tag
            int r1 = r1 >>> 3
            int r1 = r1 << 3
            r1 = r1 | r3
            r7.zzrw = r1
        L_0x002b:
            int r1 = r7.zzdu()
            r2 = 2147483647(0x7fffffff, float:NaN)
            if (r1 == r2) goto L_0x003a
            boolean r1 = r7.zzdv()
            if (r1 != 0) goto L_0x002b
        L_0x003a:
            int r1 = r7.tag
            int r2 = r7.zzrw
            if (r1 != r2) goto L_0x0043
            r7.zzrw = r0
            return r4
        L_0x0043:
            com.google.android.gms.internal.vision.zzhc r0 = com.google.android.gms.internal.vision.zzhc.zzgs()
            throw r0
        L_0x0048:
            int r0 = r7.zzek()
            r7.zzah(r0)
            return r4
        L_0x0050:
            r0 = 8
            r7.zzah(r0)
            return r4
        L_0x0056:
            int r0 = r7.limit
            int r2 = r7.pos
            int r0 = r0 - r2
            r2 = 10
            if (r0 < r2) goto L_0x0074
            byte[] r0 = r7.buffer
            int r3 = r7.pos
            r5 = r3
            r3 = 0
        L_0x0065:
            if (r3 >= r2) goto L_0x0074
            int r6 = r5 + 1
            byte r5 = r0[r5]
            if (r5 < 0) goto L_0x0070
            r7.pos = r6
            goto L_0x007f
        L_0x0070:
            int r3 = r3 + 1
            r5 = r6
            goto L_0x0065
        L_0x0074:
            if (r1 >= r2) goto L_0x0080
            byte r0 = r7.readByte()
            if (r0 >= 0) goto L_0x007f
            int r1 = r1 + 1
            goto L_0x0074
        L_0x007f:
            return r4
        L_0x0080:
            com.google.android.gms.internal.vision.zzhc r0 = com.google.android.gms.internal.vision.zzhc.zzgo()
            throw r0
        L_0x0085:
            r7.zzah(r3)
            return r4
        L_0x0089:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzfg.zzdv():boolean");
    }

    public final double readDouble() throws IOException {
        zzaj(1);
        return Double.longBitsToDouble(zzeo());
    }

    public final float readFloat() throws IOException {
        zzaj(5);
        return Float.intBitsToFloat(zzen());
    }

    public final long zzdw() throws IOException {
        zzaj(0);
        return zzel();
    }

    public final long zzdx() throws IOException {
        zzaj(0);
        return zzel();
    }

    public final int zzdy() throws IOException {
        zzaj(0);
        return zzek();
    }

    public final long zzdz() throws IOException {
        zzaj(1);
        return zzeo();
    }

    public final int zzea() throws IOException {
        zzaj(5);
        return zzen();
    }

    public final boolean zzeb() throws IOException {
        zzaj(0);
        if (zzek() != 0) {
            return true;
        }
        return false;
    }

    public final String readString() throws IOException {
        return zzj(false);
    }

    public final String zzec() throws IOException {
        return zzj(true);
    }

    private final String zzj(boolean z) throws IOException {
        zzaj(2);
        int zzek = zzek();
        if (zzek == 0) {
            return "";
        }
        zzai(zzek);
        if (!z || zzjs.zzf(this.buffer, this.pos, this.pos + zzek)) {
            String str = new String(this.buffer, this.pos, zzek, zzgt.UTF_8);
            this.pos += zzek;
            return str;
        }
        throw zzhc.zzgt();
    }

    public final <T> T zza(Class<T> cls, zzgd zzgd) throws IOException {
        zzaj(2);
        return zzb(zzin.zzho().zzf(cls), zzgd);
    }

    public final <T> T zza(zzir<T> zzir, zzgd zzgd) throws IOException {
        zzaj(2);
        return zzb(zzir, zzgd);
    }

    private final <T> T zzb(zzir<T> zzir, zzgd zzgd) throws IOException {
        int zzek = zzek();
        zzai(zzek);
        int i = this.limit;
        int i2 = this.pos + zzek;
        this.limit = i2;
        try {
            T newInstance = zzir.newInstance();
            zzir.zza(newInstance, this, zzgd);
            zzir.zzg(newInstance);
            if (this.pos == i2) {
                return newInstance;
            }
            throw zzhc.zzgs();
        } finally {
            this.limit = i;
        }
    }

    public final <T> T zzb(Class<T> cls, zzgd zzgd) throws IOException {
        zzaj(3);
        return zzd(zzin.zzho().zzf(cls), zzgd);
    }

    public final <T> T zzc(zzir<T> zzir, zzgd zzgd) throws IOException {
        zzaj(3);
        return zzd(zzir, zzgd);
    }

    private final <T> T zzd(zzir<T> zzir, zzgd zzgd) throws IOException {
        int i = this.zzrw;
        this.zzrw = ((this.tag >>> 3) << 3) | 4;
        try {
            T newInstance = zzir.newInstance();
            zzir.zza(newInstance, this, zzgd);
            zzir.zzg(newInstance);
            if (this.tag == this.zzrw) {
                return newInstance;
            }
            throw zzhc.zzgs();
        } finally {
            this.zzrw = i;
        }
    }

    public final zzfh zzed() throws IOException {
        zzfh zzfh;
        zzaj(2);
        int zzek = zzek();
        if (zzek == 0) {
            return zzfh.zzrx;
        }
        zzai(zzek);
        if (this.zzru) {
            zzfh = zzfh.zzb(this.buffer, this.pos, zzek);
        } else {
            zzfh = zzfh.zza(this.buffer, this.pos, zzek);
        }
        this.pos += zzek;
        return zzfh;
    }

    public final int zzee() throws IOException {
        zzaj(0);
        return zzek();
    }

    public final int zzef() throws IOException {
        zzaj(0);
        return zzek();
    }

    public final int zzeg() throws IOException {
        zzaj(5);
        return zzen();
    }

    public final long zzeh() throws IOException {
        zzaj(1);
        return zzeo();
    }

    public final int zzei() throws IOException {
        zzaj(0);
        return zzft.zzau(zzek());
    }

    public final long zzej() throws IOException {
        zzaj(0);
        return zzft.zzr(zzel());
    }

    public final void zza(List<Double> list) throws IOException {
        int i;
        int i2;
        if (list instanceof zzgb) {
            zzgb zzgb = (zzgb) list;
            switch (this.tag & 7) {
                case 1:
                    break;
                case 2:
                    int zzek = zzek();
                    zzak(zzek);
                    int i3 = this.pos + zzek;
                    while (this.pos < i3) {
                        zzgb.zzc(Double.longBitsToDouble(zzeq()));
                    }
                    return;
                default:
                    throw zzhc.zzgr();
            }
            do {
                zzgb.zzc(readDouble());
                if (!zzdt()) {
                    i2 = this.pos;
                } else {
                    return;
                }
            } while (zzek() == this.tag);
            this.pos = i2;
            return;
        }
        switch (this.tag & 7) {
            case 1:
                break;
            case 2:
                int zzek2 = zzek();
                zzak(zzek2);
                int i4 = this.pos + zzek2;
                while (this.pos < i4) {
                    list.add(Double.valueOf(Double.longBitsToDouble(zzeq())));
                }
                return;
            default:
                throw zzhc.zzgr();
        }
        do {
            list.add(Double.valueOf(readDouble()));
            if (!zzdt()) {
                i = this.pos;
            } else {
                return;
            }
        } while (zzek() == this.tag);
        this.pos = i;
    }

    public final void zzb(List<Float> list) throws IOException {
        int i;
        int i2;
        if (list instanceof zzgo) {
            zzgo zzgo = (zzgo) list;
            int i3 = this.tag & 7;
            if (i3 == 2) {
                int zzek = zzek();
                zzal(zzek);
                int i4 = this.pos + zzek;
                while (this.pos < i4) {
                    zzgo.zzu(Float.intBitsToFloat(zzep()));
                }
            } else if (i3 == 5) {
                do {
                    zzgo.zzu(readFloat());
                    if (!zzdt()) {
                        i2 = this.pos;
                    } else {
                        return;
                    }
                } while (zzek() == this.tag);
                this.pos = i2;
            } else {
                throw zzhc.zzgr();
            }
        } else {
            int i5 = this.tag & 7;
            if (i5 == 2) {
                int zzek2 = zzek();
                zzal(zzek2);
                int i6 = this.pos + zzek2;
                while (this.pos < i6) {
                    list.add(Float.valueOf(Float.intBitsToFloat(zzep())));
                }
            } else if (i5 == 5) {
                do {
                    list.add(Float.valueOf(readFloat()));
                    if (!zzdt()) {
                        i = this.pos;
                    } else {
                        return;
                    }
                } while (zzek() == this.tag);
                this.pos = i;
            } else {
                throw zzhc.zzgr();
            }
        }
    }

    public final void zzc(List<Long> list) throws IOException {
        int i;
        int i2;
        if (list instanceof zzhq) {
            zzhq zzhq = (zzhq) list;
            int i3 = this.tag & 7;
            if (i3 == 0) {
                do {
                    zzhq.zzac(zzdw());
                    if (!zzdt()) {
                        i2 = this.pos;
                    } else {
                        return;
                    }
                } while (zzek() == this.tag);
                this.pos = i2;
            } else if (i3 == 2) {
                int zzek = this.pos + zzek();
                while (this.pos < zzek) {
                    zzhq.zzac(zzel());
                }
                zzam(zzek);
            } else {
                throw zzhc.zzgr();
            }
        } else {
            int i4 = this.tag & 7;
            if (i4 == 0) {
                do {
                    list.add(Long.valueOf(zzdw()));
                    if (!zzdt()) {
                        i = this.pos;
                    } else {
                        return;
                    }
                } while (zzek() == this.tag);
                this.pos = i;
            } else if (i4 == 2) {
                int zzek2 = this.pos + zzek();
                while (this.pos < zzek2) {
                    list.add(Long.valueOf(zzel()));
                }
                zzam(zzek2);
            } else {
                throw zzhc.zzgr();
            }
        }
    }

    public final void zzd(List<Long> list) throws IOException {
        int i;
        int i2;
        if (list instanceof zzhq) {
            zzhq zzhq = (zzhq) list;
            int i3 = this.tag & 7;
            if (i3 == 0) {
                do {
                    zzhq.zzac(zzdx());
                    if (!zzdt()) {
                        i2 = this.pos;
                    } else {
                        return;
                    }
                } while (zzek() == this.tag);
                this.pos = i2;
            } else if (i3 == 2) {
                int zzek = this.pos + zzek();
                while (this.pos < zzek) {
                    zzhq.zzac(zzel());
                }
                zzam(zzek);
            } else {
                throw zzhc.zzgr();
            }
        } else {
            int i4 = this.tag & 7;
            if (i4 == 0) {
                do {
                    list.add(Long.valueOf(zzdx()));
                    if (!zzdt()) {
                        i = this.pos;
                    } else {
                        return;
                    }
                } while (zzek() == this.tag);
                this.pos = i;
            } else if (i4 == 2) {
                int zzek2 = this.pos + zzek();
                while (this.pos < zzek2) {
                    list.add(Long.valueOf(zzel()));
                }
                zzam(zzek2);
            } else {
                throw zzhc.zzgr();
            }
        }
    }

    public final void zze(List<Integer> list) throws IOException {
        int i;
        int i2;
        if (list instanceof zzgu) {
            zzgu zzgu = (zzgu) list;
            int i3 = this.tag & 7;
            if (i3 == 0) {
                do {
                    zzgu.zzbl(zzdy());
                    if (!zzdt()) {
                        i2 = this.pos;
                    } else {
                        return;
                    }
                } while (zzek() == this.tag);
                this.pos = i2;
            } else if (i3 == 2) {
                int zzek = this.pos + zzek();
                while (this.pos < zzek) {
                    zzgu.zzbl(zzek());
                }
                zzam(zzek);
            } else {
                throw zzhc.zzgr();
            }
        } else {
            int i4 = this.tag & 7;
            if (i4 == 0) {
                do {
                    list.add(Integer.valueOf(zzdy()));
                    if (!zzdt()) {
                        i = this.pos;
                    } else {
                        return;
                    }
                } while (zzek() == this.tag);
                this.pos = i;
            } else if (i4 == 2) {
                int zzek2 = this.pos + zzek();
                while (this.pos < zzek2) {
                    list.add(Integer.valueOf(zzek()));
                }
                zzam(zzek2);
            } else {
                throw zzhc.zzgr();
            }
        }
    }

    public final void zzf(List<Long> list) throws IOException {
        int i;
        int i2;
        if (list instanceof zzhq) {
            zzhq zzhq = (zzhq) list;
            switch (this.tag & 7) {
                case 1:
                    break;
                case 2:
                    int zzek = zzek();
                    zzak(zzek);
                    int i3 = this.pos + zzek;
                    while (this.pos < i3) {
                        zzhq.zzac(zzeq());
                    }
                    return;
                default:
                    throw zzhc.zzgr();
            }
            do {
                zzhq.zzac(zzdz());
                if (!zzdt()) {
                    i2 = this.pos;
                } else {
                    return;
                }
            } while (zzek() == this.tag);
            this.pos = i2;
            return;
        }
        switch (this.tag & 7) {
            case 1:
                break;
            case 2:
                int zzek2 = zzek();
                zzak(zzek2);
                int i4 = this.pos + zzek2;
                while (this.pos < i4) {
                    list.add(Long.valueOf(zzeq()));
                }
                return;
            default:
                throw zzhc.zzgr();
        }
        do {
            list.add(Long.valueOf(zzdz()));
            if (!zzdt()) {
                i = this.pos;
            } else {
                return;
            }
        } while (zzek() == this.tag);
        this.pos = i;
    }

    public final void zzg(List<Integer> list) throws IOException {
        int i;
        int i2;
        if (list instanceof zzgu) {
            zzgu zzgu = (zzgu) list;
            int i3 = this.tag & 7;
            if (i3 == 2) {
                int zzek = zzek();
                zzal(zzek);
                int i4 = this.pos + zzek;
                while (this.pos < i4) {
                    zzgu.zzbl(zzep());
                }
            } else if (i3 == 5) {
                do {
                    zzgu.zzbl(zzea());
                    if (!zzdt()) {
                        i2 = this.pos;
                    } else {
                        return;
                    }
                } while (zzek() == this.tag);
                this.pos = i2;
            } else {
                throw zzhc.zzgr();
            }
        } else {
            int i5 = this.tag & 7;
            if (i5 == 2) {
                int zzek2 = zzek();
                zzal(zzek2);
                int i6 = this.pos + zzek2;
                while (this.pos < i6) {
                    list.add(Integer.valueOf(zzep()));
                }
            } else if (i5 == 5) {
                do {
                    list.add(Integer.valueOf(zzea()));
                    if (!zzdt()) {
                        i = this.pos;
                    } else {
                        return;
                    }
                } while (zzek() == this.tag);
                this.pos = i;
            } else {
                throw zzhc.zzgr();
            }
        }
    }

    public final void zzh(List<Boolean> list) throws IOException {
        int i;
        int i2;
        if (list instanceof zzff) {
            zzff zzff = (zzff) list;
            int i3 = this.tag & 7;
            if (i3 == 0) {
                do {
                    zzff.addBoolean(zzeb());
                    if (!zzdt()) {
                        i2 = this.pos;
                    } else {
                        return;
                    }
                } while (zzek() == this.tag);
                this.pos = i2;
            } else if (i3 == 2) {
                int zzek = this.pos + zzek();
                while (this.pos < zzek) {
                    zzff.addBoolean(zzek() != 0);
                }
                zzam(zzek);
            } else {
                throw zzhc.zzgr();
            }
        } else {
            int i4 = this.tag & 7;
            if (i4 == 0) {
                do {
                    list.add(Boolean.valueOf(zzeb()));
                    if (!zzdt()) {
                        i = this.pos;
                    } else {
                        return;
                    }
                } while (zzek() == this.tag);
                this.pos = i;
            } else if (i4 == 2) {
                int zzek2 = this.pos + zzek();
                while (this.pos < zzek2) {
                    list.add(Boolean.valueOf(zzek() != 0));
                }
                zzam(zzek2);
            } else {
                throw zzhc.zzgr();
            }
        }
    }

    public final void readStringList(List<String> list) throws IOException {
        zza(list, false);
    }

    public final void zzi(List<String> list) throws IOException {
        zza(list, true);
    }

    private final void zza(List<String> list, boolean z) throws IOException {
        int i;
        int i2;
        if ((this.tag & 7) != 2) {
            throw zzhc.zzgr();
        } else if (!(list instanceof zzhj) || z) {
            do {
                list.add(zzj(z));
                if (!zzdt()) {
                    i = this.pos;
                } else {
                    return;
                }
            } while (zzek() == this.tag);
            this.pos = i;
        } else {
            zzhj zzhj = (zzhj) list;
            do {
                zzhj.zzc(zzed());
                if (!zzdt()) {
                    i2 = this.pos;
                } else {
                    return;
                }
            } while (zzek() == this.tag);
            this.pos = i2;
        }
    }

    public final <T> void zza(List<T> list, zzir<T> zzir, zzgd zzgd) throws IOException {
        int i;
        if ((this.tag & 7) == 2) {
            int i2 = this.tag;
            do {
                list.add(zzb(zzir, zzgd));
                if (!zzdt()) {
                    i = this.pos;
                } else {
                    return;
                }
            } while (zzek() == i2);
            this.pos = i;
            return;
        }
        throw zzhc.zzgr();
    }

    public final <T> void zzb(List<T> list, zzir<T> zzir, zzgd zzgd) throws IOException {
        int i;
        if ((this.tag & 7) == 3) {
            int i2 = this.tag;
            do {
                list.add(zzd(zzir, zzgd));
                if (!zzdt()) {
                    i = this.pos;
                } else {
                    return;
                }
            } while (zzek() == i2);
            this.pos = i;
            return;
        }
        throw zzhc.zzgr();
    }

    public final void zzj(List<zzfh> list) throws IOException {
        int i;
        if ((this.tag & 7) == 2) {
            do {
                list.add(zzed());
                if (!zzdt()) {
                    i = this.pos;
                } else {
                    return;
                }
            } while (zzek() == this.tag);
            this.pos = i;
            return;
        }
        throw zzhc.zzgr();
    }

    public final void zzk(List<Integer> list) throws IOException {
        int i;
        int i2;
        if (list instanceof zzgu) {
            zzgu zzgu = (zzgu) list;
            int i3 = this.tag & 7;
            if (i3 == 0) {
                do {
                    zzgu.zzbl(zzee());
                    if (!zzdt()) {
                        i2 = this.pos;
                    } else {
                        return;
                    }
                } while (zzek() == this.tag);
                this.pos = i2;
            } else if (i3 == 2) {
                int zzek = this.pos + zzek();
                while (this.pos < zzek) {
                    zzgu.zzbl(zzek());
                }
            } else {
                throw zzhc.zzgr();
            }
        } else {
            int i4 = this.tag & 7;
            if (i4 == 0) {
                do {
                    list.add(Integer.valueOf(zzee()));
                    if (!zzdt()) {
                        i = this.pos;
                    } else {
                        return;
                    }
                } while (zzek() == this.tag);
                this.pos = i;
            } else if (i4 == 2) {
                int zzek2 = this.pos + zzek();
                while (this.pos < zzek2) {
                    list.add(Integer.valueOf(zzek()));
                }
            } else {
                throw zzhc.zzgr();
            }
        }
    }

    public final void zzl(List<Integer> list) throws IOException {
        int i;
        int i2;
        if (list instanceof zzgu) {
            zzgu zzgu = (zzgu) list;
            int i3 = this.tag & 7;
            if (i3 == 0) {
                do {
                    zzgu.zzbl(zzef());
                    if (!zzdt()) {
                        i2 = this.pos;
                    } else {
                        return;
                    }
                } while (zzek() == this.tag);
                this.pos = i2;
            } else if (i3 == 2) {
                int zzek = this.pos + zzek();
                while (this.pos < zzek) {
                    zzgu.zzbl(zzek());
                }
            } else {
                throw zzhc.zzgr();
            }
        } else {
            int i4 = this.tag & 7;
            if (i4 == 0) {
                do {
                    list.add(Integer.valueOf(zzef()));
                    if (!zzdt()) {
                        i = this.pos;
                    } else {
                        return;
                    }
                } while (zzek() == this.tag);
                this.pos = i;
            } else if (i4 == 2) {
                int zzek2 = this.pos + zzek();
                while (this.pos < zzek2) {
                    list.add(Integer.valueOf(zzek()));
                }
            } else {
                throw zzhc.zzgr();
            }
        }
    }

    public final void zzm(List<Integer> list) throws IOException {
        int i;
        int i2;
        if (list instanceof zzgu) {
            zzgu zzgu = (zzgu) list;
            int i3 = this.tag & 7;
            if (i3 == 2) {
                int zzek = zzek();
                zzal(zzek);
                int i4 = this.pos + zzek;
                while (this.pos < i4) {
                    zzgu.zzbl(zzep());
                }
            } else if (i3 == 5) {
                do {
                    zzgu.zzbl(zzeg());
                    if (!zzdt()) {
                        i2 = this.pos;
                    } else {
                        return;
                    }
                } while (zzek() == this.tag);
                this.pos = i2;
            } else {
                throw zzhc.zzgr();
            }
        } else {
            int i5 = this.tag & 7;
            if (i5 == 2) {
                int zzek2 = zzek();
                zzal(zzek2);
                int i6 = this.pos + zzek2;
                while (this.pos < i6) {
                    list.add(Integer.valueOf(zzep()));
                }
            } else if (i5 == 5) {
                do {
                    list.add(Integer.valueOf(zzeg()));
                    if (!zzdt()) {
                        i = this.pos;
                    } else {
                        return;
                    }
                } while (zzek() == this.tag);
                this.pos = i;
            } else {
                throw zzhc.zzgr();
            }
        }
    }

    public final void zzn(List<Long> list) throws IOException {
        int i;
        int i2;
        if (list instanceof zzhq) {
            zzhq zzhq = (zzhq) list;
            switch (this.tag & 7) {
                case 1:
                    break;
                case 2:
                    int zzek = zzek();
                    zzak(zzek);
                    int i3 = this.pos + zzek;
                    while (this.pos < i3) {
                        zzhq.zzac(zzeq());
                    }
                    return;
                default:
                    throw zzhc.zzgr();
            }
            do {
                zzhq.zzac(zzeh());
                if (!zzdt()) {
                    i2 = this.pos;
                } else {
                    return;
                }
            } while (zzek() == this.tag);
            this.pos = i2;
            return;
        }
        switch (this.tag & 7) {
            case 1:
                break;
            case 2:
                int zzek2 = zzek();
                zzak(zzek2);
                int i4 = this.pos + zzek2;
                while (this.pos < i4) {
                    list.add(Long.valueOf(zzeq()));
                }
                return;
            default:
                throw zzhc.zzgr();
        }
        do {
            list.add(Long.valueOf(zzeh()));
            if (!zzdt()) {
                i = this.pos;
            } else {
                return;
            }
        } while (zzek() == this.tag);
        this.pos = i;
    }

    public final void zzo(List<Integer> list) throws IOException {
        int i;
        int i2;
        if (list instanceof zzgu) {
            zzgu zzgu = (zzgu) list;
            int i3 = this.tag & 7;
            if (i3 == 0) {
                do {
                    zzgu.zzbl(zzei());
                    if (!zzdt()) {
                        i2 = this.pos;
                    } else {
                        return;
                    }
                } while (zzek() == this.tag);
                this.pos = i2;
            } else if (i3 == 2) {
                int zzek = this.pos + zzek();
                while (this.pos < zzek) {
                    zzgu.zzbl(zzft.zzau(zzek()));
                }
            } else {
                throw zzhc.zzgr();
            }
        } else {
            int i4 = this.tag & 7;
            if (i4 == 0) {
                do {
                    list.add(Integer.valueOf(zzei()));
                    if (!zzdt()) {
                        i = this.pos;
                    } else {
                        return;
                    }
                } while (zzek() == this.tag);
                this.pos = i;
            } else if (i4 == 2) {
                int zzek2 = this.pos + zzek();
                while (this.pos < zzek2) {
                    list.add(Integer.valueOf(zzft.zzau(zzek())));
                }
            } else {
                throw zzhc.zzgr();
            }
        }
    }

    public final void zzp(List<Long> list) throws IOException {
        int i;
        int i2;
        if (list instanceof zzhq) {
            zzhq zzhq = (zzhq) list;
            int i3 = this.tag & 7;
            if (i3 == 0) {
                do {
                    zzhq.zzac(zzej());
                    if (!zzdt()) {
                        i2 = this.pos;
                    } else {
                        return;
                    }
                } while (zzek() == this.tag);
                this.pos = i2;
            } else if (i3 == 2) {
                int zzek = this.pos + zzek();
                while (this.pos < zzek) {
                    zzhq.zzac(zzft.zzr(zzel()));
                }
            } else {
                throw zzhc.zzgr();
            }
        } else {
            int i4 = this.tag & 7;
            if (i4 == 0) {
                do {
                    list.add(Long.valueOf(zzej()));
                    if (!zzdt()) {
                        i = this.pos;
                    } else {
                        return;
                    }
                } while (zzek() == this.tag);
                this.pos = i;
            } else if (i4 == 2) {
                int zzek2 = this.pos + zzek();
                while (this.pos < zzek2) {
                    list.add(Long.valueOf(zzft.zzr(zzel())));
                }
            } else {
                throw zzhc.zzgr();
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:15|16|(2:18|34)(3:28|19|20)) */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x004d, code lost:
        if (zzdv() != false) goto L_0x004f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0057, code lost:
        throw new com.google.android.gms.internal.vision.zzhc("Unable to parse map entry.");
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0049 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <K, V> void zza(java.util.Map<K, V> r6, com.google.android.gms.internal.vision.zzht<K, V> r7, com.google.android.gms.internal.vision.zzgd r8) throws java.io.IOException {
        /*
            r5 = this;
            r0 = 2
            r5.zzaj(r0)
            int r0 = r5.zzek()
            r5.zzai(r0)
            int r1 = r5.limit
            int r2 = r5.pos
            int r2 = r2 + r0
            r5.limit = r2
            K r0 = r7.zzyn     // Catch:{ all -> 0x005e }
            V r2 = r7.zzgc     // Catch:{ all -> 0x005e }
        L_0x0016:
            int r3 = r5.zzdu()     // Catch:{ all -> 0x005e }
            r4 = 2147483647(0x7fffffff, float:NaN)
            if (r3 == r4) goto L_0x0058
            switch(r3) {
                case 1: goto L_0x0035;
                case 2: goto L_0x0027;
                default: goto L_0x0022;
            }
        L_0x0022:
            boolean r3 = r5.zzdv()     // Catch:{ zzhb -> 0x0049 }
            goto L_0x003e
        L_0x0027:
            com.google.android.gms.internal.vision.zzka r3 = r7.zzyo     // Catch:{ zzhb -> 0x0049 }
            V r4 = r7.zzgc     // Catch:{ zzhb -> 0x0049 }
            java.lang.Class r4 = r4.getClass()     // Catch:{ zzhb -> 0x0049 }
            java.lang.Object r3 = r5.zza((com.google.android.gms.internal.vision.zzka) r3, (java.lang.Class<?>) r4, (com.google.android.gms.internal.vision.zzgd) r8)     // Catch:{ zzhb -> 0x0049 }
            r2 = r3
            goto L_0x0016
        L_0x0035:
            com.google.android.gms.internal.vision.zzka r3 = r7.zzym     // Catch:{ zzhb -> 0x0049 }
            r4 = 0
            java.lang.Object r3 = r5.zza((com.google.android.gms.internal.vision.zzka) r3, (java.lang.Class<?>) r4, (com.google.android.gms.internal.vision.zzgd) r4)     // Catch:{ zzhb -> 0x0049 }
            r0 = r3
            goto L_0x0016
        L_0x003e:
            if (r3 == 0) goto L_0x0041
            goto L_0x0016
        L_0x0041:
            com.google.android.gms.internal.vision.zzhc r3 = new com.google.android.gms.internal.vision.zzhc     // Catch:{ zzhb -> 0x0049 }
            java.lang.String r4 = "Unable to parse map entry."
            r3.<init>(r4)     // Catch:{ zzhb -> 0x0049 }
            throw r3     // Catch:{ zzhb -> 0x0049 }
        L_0x0049:
            boolean r3 = r5.zzdv()     // Catch:{ all -> 0x005e }
            if (r3 == 0) goto L_0x0050
            goto L_0x0016
        L_0x0050:
            com.google.android.gms.internal.vision.zzhc r6 = new com.google.android.gms.internal.vision.zzhc     // Catch:{ all -> 0x005e }
            java.lang.String r7 = "Unable to parse map entry."
            r6.<init>(r7)     // Catch:{ all -> 0x005e }
            throw r6     // Catch:{ all -> 0x005e }
        L_0x0058:
            r6.put(r0, r2)     // Catch:{ all -> 0x005e }
            r5.limit = r1
            return
        L_0x005e:
            r6 = move-exception
            r5.limit = r1
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzfg.zza(java.util.Map, com.google.android.gms.internal.vision.zzht, com.google.android.gms.internal.vision.zzgd):void");
    }

    private final Object zza(zzka zzka, Class<?> cls, zzgd zzgd) throws IOException {
        switch (zzfd.zzrr[zzka.ordinal()]) {
            case 1:
                return Boolean.valueOf(zzeb());
            case 2:
                return zzed();
            case 3:
                return Double.valueOf(readDouble());
            case 4:
                return Integer.valueOf(zzef());
            case 5:
                return Integer.valueOf(zzea());
            case 6:
                return Long.valueOf(zzdz());
            case 7:
                return Float.valueOf(readFloat());
            case 8:
                return Integer.valueOf(zzdy());
            case 9:
                return Long.valueOf(zzdx());
            case 10:
                return zza(cls, zzgd);
            case 11:
                return Integer.valueOf(zzeg());
            case 12:
                return Long.valueOf(zzeh());
            case 13:
                return Integer.valueOf(zzei());
            case 14:
                return Long.valueOf(zzej());
            case 15:
                return zzj(true);
            case 16:
                return Integer.valueOf(zzee());
            case 17:
                return Long.valueOf(zzdw());
            default:
                throw new RuntimeException("unsupported field type.");
        }
    }

    private final int zzek() throws IOException {
        byte b;
        int i = this.pos;
        if (this.limit != this.pos) {
            int i2 = i + 1;
            byte b2 = this.buffer[i];
            if (b2 >= 0) {
                this.pos = i2;
                return b2;
            } else if (this.limit - i2 < 9) {
                return (int) zzem();
            } else {
                int i3 = i2 + 1;
                byte b3 = b2 ^ (this.buffer[i2] << 7);
                if (b3 < 0) {
                    b = b3 ^ ByteCompanionObject.MIN_VALUE;
                } else {
                    int i4 = i3 + 1;
                    byte b4 = b3 ^ (this.buffer[i3] << 14);
                    if (b4 >= 0) {
                        b = b4 ^ ByteCompanionObject.MIN_VALUE;
                    } else {
                        i3 = i4 + 1;
                        byte b5 = b4 ^ (this.buffer[i4] << 21);
                        if (b5 < 0) {
                            b = b5 ^ ByteCompanionObject.MIN_VALUE;
                        } else {
                            i4 = i3 + 1;
                            byte b6 = this.buffer[i3];
                            b = (b5 ^ (b6 << 28)) ^ ByteCompanionObject.MIN_VALUE;
                            if (b6 < 0) {
                                i3 = i4 + 1;
                                if (this.buffer[i4] < 0) {
                                    i4 = i3 + 1;
                                    if (this.buffer[i3] < 0) {
                                        i3 = i4 + 1;
                                        if (this.buffer[i4] < 0) {
                                            i4 = i3 + 1;
                                            if (this.buffer[i3] < 0) {
                                                i3 = i4 + 1;
                                                if (this.buffer[i4] < 0) {
                                                    throw zzhc.zzgo();
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    i3 = i4;
                }
                this.pos = i3;
                return b;
            }
        } else {
            throw zzhc.zzgm();
        }
    }

    private final long zzel() throws IOException {
        long j;
        int i;
        long j2;
        long j3;
        int i2 = this.pos;
        if (this.limit != i2) {
            byte[] bArr = this.buffer;
            int i3 = i2 + 1;
            byte b = bArr[i2];
            if (b >= 0) {
                this.pos = i3;
                return (long) b;
            } else if (this.limit - i3 < 9) {
                return zzem();
            } else {
                int i4 = i3 + 1;
                byte b2 = b ^ (bArr[i3] << 7);
                if (b2 < 0) {
                    j3 = (long) (b2 ^ ByteCompanionObject.MIN_VALUE);
                } else {
                    int i5 = i4 + 1;
                    byte b3 = b2 ^ (bArr[i4] << 14);
                    if (b3 >= 0) {
                        long j4 = (long) (b3 ^ ByteCompanionObject.MIN_VALUE);
                        i = i5;
                        j = j4;
                    } else {
                        i4 = i5 + 1;
                        byte b4 = b3 ^ (bArr[i5] << 21);
                        if (b4 < 0) {
                            j3 = (long) (b4 ^ ByteCompanionObject.MIN_VALUE);
                        } else {
                            long j5 = (long) b4;
                            i = i4 + 1;
                            long j6 = (((long) bArr[i4]) << 28) ^ j5;
                            if (j6 >= 0) {
                                j = j6 ^ 266354560;
                            } else {
                                int i6 = i + 1;
                                long j7 = j6 ^ (((long) bArr[i]) << 35);
                                if (j7 < 0) {
                                    j2 = -34093383808L ^ j7;
                                } else {
                                    i = i6 + 1;
                                    long j8 = j7 ^ (((long) bArr[i6]) << 42);
                                    if (j8 >= 0) {
                                        j = j8 ^ 4363953127296L;
                                    } else {
                                        i6 = i + 1;
                                        long j9 = j8 ^ (((long) bArr[i]) << 49);
                                        if (j9 < 0) {
                                            j2 = -558586000294016L ^ j9;
                                        } else {
                                            i = i6 + 1;
                                            long j10 = (j9 ^ (((long) bArr[i6]) << 56)) ^ 71499008037633920L;
                                            if (j10 < 0) {
                                                i6 = i + 1;
                                                if (((long) bArr[i]) >= 0) {
                                                    j = j10;
                                                    i = i6;
                                                } else {
                                                    throw zzhc.zzgo();
                                                }
                                            } else {
                                                j = j10;
                                            }
                                        }
                                    }
                                }
                                j = j2;
                                i = i6;
                            }
                        }
                    }
                    this.pos = i;
                    return j;
                }
                j = j3;
                i = i4;
                this.pos = i;
                return j;
            }
        } else {
            throw zzhc.zzgm();
        }
    }

    private final long zzem() throws IOException {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte readByte = readByte();
            j |= ((long) (readByte & ByteCompanionObject.MAX_VALUE)) << i;
            if ((readByte & ByteCompanionObject.MIN_VALUE) == 0) {
                return j;
            }
        }
        throw zzhc.zzgo();
    }

    private final byte readByte() throws IOException {
        if (this.pos != this.limit) {
            byte[] bArr = this.buffer;
            int i = this.pos;
            this.pos = i + 1;
            return bArr[i];
        }
        throw zzhc.zzgm();
    }

    private final int zzen() throws IOException {
        zzai(4);
        return zzep();
    }

    private final long zzeo() throws IOException {
        zzai(8);
        return zzeq();
    }

    private final int zzep() {
        int i = this.pos;
        byte[] bArr = this.buffer;
        this.pos = i + 4;
        return ((bArr[i + 3] & UByte.MAX_VALUE) << 24) | (bArr[i] & UByte.MAX_VALUE) | ((bArr[i + 1] & UByte.MAX_VALUE) << 8) | ((bArr[i + 2] & UByte.MAX_VALUE) << 16);
    }

    private final long zzeq() {
        int i = this.pos;
        byte[] bArr = this.buffer;
        this.pos = i + 8;
        return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
    }

    private final void zzah(int i) throws IOException {
        zzai(i);
        this.pos += i;
    }

    private final void zzai(int i) throws IOException {
        if (i < 0 || i > this.limit - this.pos) {
            throw zzhc.zzgm();
        }
    }

    private final void zzaj(int i) throws IOException {
        if ((this.tag & 7) != i) {
            throw zzhc.zzgr();
        }
    }

    private final void zzak(int i) throws IOException {
        zzai(i);
        if ((i & 7) != 0) {
            throw zzhc.zzgs();
        }
    }

    private final void zzal(int i) throws IOException {
        zzai(i);
        if ((i & 3) != 0) {
            throw zzhc.zzgs();
        }
    }

    private final void zzam(int i) throws IOException {
        if (this.pos != i) {
            throw zzhc.zzgm();
        }
    }
}
