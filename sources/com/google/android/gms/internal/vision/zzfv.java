package com.google.android.gms.internal.vision;

import java.io.IOException;
import java.util.Arrays;
import kotlin.UByte;
import kotlin.jvm.internal.ByteCompanionObject;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.0.0 */
final class zzfv extends zzft {
    private final byte[] buffer;
    private int limit;
    private int pos;
    private final boolean zzsk;
    private int zzsl;
    private int zzsm;
    private int zzsn;
    private int zzso;

    private zzfv(byte[] bArr, int i, int i2, boolean z) {
        super();
        this.zzso = Integer.MAX_VALUE;
        this.buffer = bArr;
        this.limit = i2 + i;
        this.pos = i;
        this.zzsm = this.pos;
        this.zzsk = z;
    }

    public final int zzex() throws IOException {
        if (zzdt()) {
            this.zzsn = 0;
            return 0;
        }
        this.zzsn = zzfa();
        if ((this.zzsn >>> 3) != 0) {
            return this.zzsn;
        }
        throw zzhc.zzgp();
    }

    public final void zzaq(int i) throws zzhc {
        if (this.zzsn != i) {
            throw zzhc.zzgq();
        }
    }

    public final boolean zzar(int i) throws IOException {
        int zzex;
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
                    throw zzhc.zzgo();
                }
                while (i2 < 10) {
                    if (zzff() < 0) {
                        i2++;
                    }
                }
                throw zzhc.zzgo();
                return true;
            case 1:
                zzav(8);
                return true;
            case 2:
                zzav(zzfa());
                return true;
            case 3:
                break;
            case 4:
                return false;
            case 5:
                zzav(4);
                return true;
            default:
                throw zzhc.zzgr();
        }
        do {
            zzex = zzex();
            if (zzex == 0 || !zzar(zzex)) {
                zzaq(((i >>> 3) << 3) | 4);
                return true;
            }
            zzex = zzex();
            zzaq(((i >>> 3) << 3) | 4);
            return true;
        } while (!zzar(zzex));
        zzaq(((i >>> 3) << 3) | 4);
        return true;
    }

    public final double readDouble() throws IOException {
        return Double.longBitsToDouble(zzfd());
    }

    public final float readFloat() throws IOException {
        return Float.intBitsToFloat(zzfc());
    }

    public final long zzdw() throws IOException {
        return zzfb();
    }

    public final long zzdx() throws IOException {
        return zzfb();
    }

    public final int zzdy() throws IOException {
        return zzfa();
    }

    public final long zzdz() throws IOException {
        return zzfd();
    }

    public final int zzea() throws IOException {
        return zzfc();
    }

    public final boolean zzeb() throws IOException {
        return zzfb() != 0;
    }

    public final String readString() throws IOException {
        int zzfa = zzfa();
        if (zzfa > 0 && zzfa <= this.limit - this.pos) {
            String str = new String(this.buffer, this.pos, zzfa, zzgt.UTF_8);
            this.pos += zzfa;
            return str;
        } else if (zzfa == 0) {
            return "";
        } else {
            if (zzfa < 0) {
                throw zzhc.zzgn();
            }
            throw zzhc.zzgm();
        }
    }

    public final String zzec() throws IOException {
        int zzfa = zzfa();
        if (zzfa > 0 && zzfa <= this.limit - this.pos) {
            String zzh = zzjs.zzh(this.buffer, this.pos, zzfa);
            this.pos += zzfa;
            return zzh;
        } else if (zzfa == 0) {
            return "";
        } else {
            if (zzfa <= 0) {
                throw zzhc.zzgn();
            }
            throw zzhc.zzgm();
        }
    }

    public final zzfh zzed() throws IOException {
        byte[] bArr;
        int zzfa = zzfa();
        if (zzfa > 0 && zzfa <= this.limit - this.pos) {
            zzfh zza = zzfh.zza(this.buffer, this.pos, zzfa);
            this.pos += zzfa;
            return zza;
        } else if (zzfa == 0) {
            return zzfh.zzrx;
        } else {
            if (zzfa > 0 && zzfa <= this.limit - this.pos) {
                int i = this.pos;
                this.pos += zzfa;
                bArr = Arrays.copyOfRange(this.buffer, i, this.pos);
            } else if (zzfa > 0) {
                throw zzhc.zzgm();
            } else if (zzfa == 0) {
                bArr = zzgt.zzxc;
            } else {
                throw zzhc.zzgn();
            }
            return zzfh.zzd(bArr);
        }
    }

    public final int zzee() throws IOException {
        return zzfa();
    }

    public final int zzef() throws IOException {
        return zzfa();
    }

    public final int zzeg() throws IOException {
        return zzfc();
    }

    public final long zzeh() throws IOException {
        return zzfd();
    }

    public final int zzei() throws IOException {
        return zzau(zzfa());
    }

    public final long zzej() throws IOException {
        return zzr(zzfb());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0068, code lost:
        if (r1[r2] >= 0) goto L_0x006a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int zzfa() throws java.io.IOException {
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
            long r0 = r5.zzey()
            int r0 = (int) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzfv.zzfa():int");
    }

    private final long zzfb() throws IOException {
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
        return zzey();
    }

    /* access modifiers changed from: package-private */
    public final long zzey() throws IOException {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte zzff = zzff();
            j |= ((long) (zzff & ByteCompanionObject.MAX_VALUE)) << i;
            if ((zzff & ByteCompanionObject.MIN_VALUE) == 0) {
                return j;
            }
        }
        throw zzhc.zzgo();
    }

    private final int zzfc() throws IOException {
        int i = this.pos;
        if (this.limit - i >= 4) {
            byte[] bArr = this.buffer;
            this.pos = i + 4;
            return ((bArr[i + 3] & UByte.MAX_VALUE) << 24) | (bArr[i] & UByte.MAX_VALUE) | ((bArr[i + 1] & UByte.MAX_VALUE) << 8) | ((bArr[i + 2] & UByte.MAX_VALUE) << 16);
        }
        throw zzhc.zzgm();
    }

    private final long zzfd() throws IOException {
        int i = this.pos;
        if (this.limit - i >= 8) {
            byte[] bArr = this.buffer;
            this.pos = i + 8;
            return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
        }
        throw zzhc.zzgm();
    }

    public final int zzas(int i) throws zzhc {
        if (i >= 0) {
            int zzez = i + zzez();
            int i2 = this.zzso;
            if (zzez <= i2) {
                this.zzso = zzez;
                zzfe();
                return i2;
            }
            throw zzhc.zzgm();
        }
        throw zzhc.zzgn();
    }

    private final void zzfe() {
        this.limit += this.zzsl;
        int i = this.limit - this.zzsm;
        if (i > this.zzso) {
            this.zzsl = i - this.zzso;
            this.limit -= this.zzsl;
            return;
        }
        this.zzsl = 0;
    }

    public final void zzat(int i) {
        this.zzso = i;
        zzfe();
    }

    public final boolean zzdt() throws IOException {
        return this.pos == this.limit;
    }

    public final int zzez() {
        return this.pos - this.zzsm;
    }

    private final byte zzff() throws IOException {
        if (this.pos != this.limit) {
            byte[] bArr = this.buffer;
            int i = this.pos;
            this.pos = i + 1;
            return bArr[i];
        }
        throw zzhc.zzgm();
    }

    private final void zzav(int i) throws IOException {
        if (i >= 0 && i <= this.limit - this.pos) {
            this.pos += i;
        } else if (i < 0) {
            throw zzhc.zzgn();
        } else {
            throw zzhc.zzgm();
        }
    }
}
