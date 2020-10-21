package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.Arrays;
import kotlin.UByte;
import kotlin.jvm.internal.ByteCompanionObject;

final class zzts extends zztq {
    private final byte[] buffer;
    private int limit;
    private int pos;
    private final boolean zzbuf;
    private int zzbug;
    private int zzbuh;
    private int zzbui;
    private int zzbuj;

    private zzts(byte[] bArr, int i, int i2, boolean z) {
        super();
        this.zzbuj = Integer.MAX_VALUE;
        this.buffer = bArr;
        this.limit = i2 + i;
        this.pos = i;
        this.zzbuh = this.pos;
        this.zzbuf = z;
    }

    public final int zzuj() throws IOException {
        if (zzuz()) {
            this.zzbui = 0;
            return 0;
        }
        this.zzbui = zzvb();
        if ((this.zzbui >>> 3) != 0) {
            return this.zzbui;
        }
        throw new zzuv("Protocol message contained an invalid tag (zero).");
    }

    public final void zzap(int i) throws zzuv {
        if (this.zzbui != i) {
            throw zzuv.zzwt();
        }
    }

    public final boolean zzaq(int i) throws IOException {
        int zzuj;
        int i2 = 0;
        switch (i & 7) {
            case 0:
                if (this.limit - this.pos >= 10) {
                    while (i2 < 10) {
                        byte[] bArr = this.buffer;
                        int i3 = this.pos;
                        this.pos = i3 + 1;
                        if (bArr[i3] < 0) {
                            i2++;
                        }
                    }
                    throw zzuv.zzws();
                }
                while (i2 < 10) {
                    if (zzvg() < 0) {
                        i2++;
                    }
                }
                throw zzuv.zzws();
                return true;
            case 1:
                zzau(8);
                return true;
            case 2:
                zzau(zzvb());
                return true;
            case 3:
                break;
            case 4:
                return false;
            case 5:
                zzau(4);
                return true;
            default:
                throw zzuv.zzwu();
        }
        do {
            zzuj = zzuj();
            if (zzuj == 0 || !zzaq(zzuj)) {
                zzap(((i >>> 3) << 3) | 4);
                return true;
            }
            zzuj = zzuj();
            zzap(((i >>> 3) << 3) | 4);
            return true;
        } while (!zzaq(zzuj));
        zzap(((i >>> 3) << 3) | 4);
        return true;
    }

    public final double readDouble() throws IOException {
        return Double.longBitsToDouble(zzve());
    }

    public final float readFloat() throws IOException {
        return Float.intBitsToFloat(zzvd());
    }

    public final long zzuk() throws IOException {
        return zzvc();
    }

    public final long zzul() throws IOException {
        return zzvc();
    }

    public final int zzum() throws IOException {
        return zzvb();
    }

    public final long zzun() throws IOException {
        return zzve();
    }

    public final int zzuo() throws IOException {
        return zzvd();
    }

    public final boolean zzup() throws IOException {
        return zzvc() != 0;
    }

    public final String readString() throws IOException {
        int zzvb = zzvb();
        if (zzvb > 0 && zzvb <= this.limit - this.pos) {
            String str = new String(this.buffer, this.pos, zzvb, zzuq.UTF_8);
            this.pos += zzvb;
            return str;
        } else if (zzvb == 0) {
            return "";
        } else {
            if (zzvb < 0) {
                throw zzuv.zzwr();
            }
            throw zzuv.zzwq();
        }
    }

    public final String zzuq() throws IOException {
        int zzvb = zzvb();
        if (zzvb > 0 && zzvb <= this.limit - this.pos) {
            String zzh = zzxl.zzh(this.buffer, this.pos, zzvb);
            this.pos += zzvb;
            return zzh;
        } else if (zzvb == 0) {
            return "";
        } else {
            if (zzvb <= 0) {
                throw zzuv.zzwr();
            }
            throw zzuv.zzwq();
        }
    }

    public final <T extends zzvv> T zza(zzwf<T> zzwf, zzub zzub) throws IOException {
        int zzvb = zzvb();
        if (this.zzbua < this.zzbub) {
            int zzas = zzas(zzvb);
            this.zzbua++;
            T t = (zzvv) zzwf.zza(this, zzub);
            zzap(0);
            this.zzbua--;
            zzat(zzas);
            return t;
        }
        throw zzuv.zzwv();
    }

    public final zzte zzur() throws IOException {
        byte[] bArr;
        int zzvb = zzvb();
        if (zzvb > 0 && zzvb <= this.limit - this.pos) {
            zzte zzb = zzte.zzb(this.buffer, this.pos, zzvb);
            this.pos += zzvb;
            return zzb;
        } else if (zzvb == 0) {
            return zzte.zzbts;
        } else {
            if (zzvb > 0 && zzvb <= this.limit - this.pos) {
                int i = this.pos;
                this.pos += zzvb;
                bArr = Arrays.copyOfRange(this.buffer, i, this.pos);
            } else if (zzvb > 0) {
                throw zzuv.zzwq();
            } else if (zzvb == 0) {
                bArr = zzuq.zzbzc;
            } else {
                throw zzuv.zzwr();
            }
            return zzte.zzi(bArr);
        }
    }

    public final int zzus() throws IOException {
        return zzvb();
    }

    public final int zzut() throws IOException {
        return zzvb();
    }

    public final int zzuu() throws IOException {
        return zzvd();
    }

    public final long zzuv() throws IOException {
        return zzve();
    }

    public final int zzuw() throws IOException {
        int zzvb = zzvb();
        return (-(zzvb & 1)) ^ (zzvb >>> 1);
    }

    public final long zzux() throws IOException {
        long zzvc = zzvc();
        return (-(zzvc & 1)) ^ (zzvc >>> 1);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0068, code lost:
        if (r1[r2] >= 0) goto L_0x006a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int zzvb() throws java.io.IOException {
        /*
            r5 = this;
            int r0 = r5.pos
            int r1 = r5.limit
            if (r1 == r0) goto L_0x006d
            byte[] r1 = r5.buffer
            int r2 = r0 + 1
            byte r0 = r1[r0]
            if (r0 < 0) goto L_0x0011
            r5.pos = r2
            return r0
        L_0x0011:
            int r3 = r5.limit
            int r3 = r3 - r2
            r4 = 9
            if (r3 < r4) goto L_0x006d
            int r3 = r2 + 1
            byte r2 = r1[r2]
            int r2 = r2 << 7
            r0 = r0 ^ r2
            if (r0 >= 0) goto L_0x0024
            r0 = r0 ^ -128(0xffffffffffffff80, float:NaN)
            goto L_0x006a
        L_0x0024:
            int r2 = r3 + 1
            byte r3 = r1[r3]
            int r3 = r3 << 14
            r0 = r0 ^ r3
            if (r0 < 0) goto L_0x0031
            r0 = r0 ^ 16256(0x3f80, float:2.278E-41)
        L_0x002f:
            r3 = r2
            goto L_0x006a
        L_0x0031:
            int r3 = r2 + 1
            byte r2 = r1[r2]
            int r2 = r2 << 21
            r0 = r0 ^ r2
            if (r0 >= 0) goto L_0x003f
            r1 = -2080896(0xffffffffffe03f80, float:NaN)
            r0 = r0 ^ r1
            goto L_0x006a
        L_0x003f:
            int r2 = r3 + 1
            byte r3 = r1[r3]
            int r4 = r3 << 28
            r0 = r0 ^ r4
            r4 = 266354560(0xfe03f80, float:2.2112565E-29)
            r0 = r0 ^ r4
            if (r3 >= 0) goto L_0x002f
            int r3 = r2 + 1
            byte r2 = r1[r2]
            if (r2 >= 0) goto L_0x006a
            int r2 = r3 + 1
            byte r3 = r1[r3]
            if (r3 >= 0) goto L_0x002f
            int r3 = r2 + 1
            byte r2 = r1[r2]
            if (r2 >= 0) goto L_0x006a
            int r2 = r3 + 1
            byte r3 = r1[r3]
            if (r3 >= 0) goto L_0x002f
            int r3 = r2 + 1
            byte r1 = r1[r2]
            if (r1 < 0) goto L_0x006d
        L_0x006a:
            r5.pos = r3
            return r0
        L_0x006d:
            long r0 = r5.zzuy()
            int r0 = (int) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzts.zzvb():int");
    }

    private final long zzvc() throws IOException {
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
            } else if (this.limit - i3 >= 9) {
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
        }
        return zzuy();
    }

    /* access modifiers changed from: package-private */
    public final long zzuy() throws IOException {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte zzvg = zzvg();
            j |= ((long) (zzvg & ByteCompanionObject.MAX_VALUE)) << i;
            if ((zzvg & ByteCompanionObject.MIN_VALUE) == 0) {
                return j;
            }
        }
        throw zzuv.zzws();
    }

    private final int zzvd() throws IOException {
        int i = this.pos;
        if (this.limit - i >= 4) {
            byte[] bArr = this.buffer;
            this.pos = i + 4;
            return ((bArr[i + 3] & UByte.MAX_VALUE) << 24) | (bArr[i] & UByte.MAX_VALUE) | ((bArr[i + 1] & UByte.MAX_VALUE) << 8) | ((bArr[i + 2] & UByte.MAX_VALUE) << 16);
        }
        throw zzuv.zzwq();
    }

    private final long zzve() throws IOException {
        int i = this.pos;
        if (this.limit - i >= 8) {
            byte[] bArr = this.buffer;
            this.pos = i + 8;
            return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
        }
        throw zzuv.zzwq();
    }

    public final int zzas(int i) throws zzuv {
        if (i >= 0) {
            int zzva = i + zzva();
            int i2 = this.zzbuj;
            if (zzva <= i2) {
                this.zzbuj = zzva;
                zzvf();
                return i2;
            }
            throw zzuv.zzwq();
        }
        throw zzuv.zzwr();
    }

    private final void zzvf() {
        this.limit += this.zzbug;
        int i = this.limit - this.zzbuh;
        if (i > this.zzbuj) {
            this.zzbug = i - this.zzbuj;
            this.limit -= this.zzbug;
            return;
        }
        this.zzbug = 0;
    }

    public final void zzat(int i) {
        this.zzbuj = i;
        zzvf();
    }

    public final boolean zzuz() throws IOException {
        return this.pos == this.limit;
    }

    public final int zzva() {
        return this.pos - this.zzbuh;
    }

    private final byte zzvg() throws IOException {
        if (this.pos != this.limit) {
            byte[] bArr = this.buffer;
            int i = this.pos;
            this.pos = i + 1;
            return bArr[i];
        }
        throw zzuv.zzwq();
    }

    public final void zzau(int i) throws IOException {
        if (i >= 0 && i <= this.limit - this.pos) {
            this.pos += i;
        } else if (i < 0) {
            throw zzuv.zzwr();
        } else {
            throw zzuv.zzwq();
        }
    }
}
