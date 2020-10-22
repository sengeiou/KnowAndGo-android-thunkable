package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Arrays;
import kotlin.UByte;
import kotlin.jvm.internal.ByteCompanionObject;

final class zzdnf extends zzdnd {
    private final byte[] buffer;
    private int limit;
    private int pos;
    private final boolean zzhde;
    private int zzhdf;
    private int zzhdg;
    private int zzhdh;
    private int zzhdi;

    private zzdnf(byte[] bArr, int i, int i2, boolean z) {
        super();
        this.zzhdi = Integer.MAX_VALUE;
        this.buffer = bArr;
        this.limit = i2 + i;
        this.pos = i;
        this.zzhdg = this.pos;
        this.zzhde = z;
    }

    public final int zzavu() throws IOException {
        if (zzawk()) {
            this.zzhdh = 0;
            return 0;
        }
        this.zzhdh = zzawm();
        if ((this.zzhdh >>> 3) != 0) {
            return this.zzhdh;
        }
        throw zzdok.zzayg();
    }

    public final void zzfp(int i) throws zzdok {
        if (this.zzhdh != i) {
            throw zzdok.zzayh();
        }
    }

    public final boolean zzfq(int i) throws IOException {
        int zzavu;
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
                    throw zzdok.zzayf();
                }
                while (i2 < 10) {
                    if (zzawr() < 0) {
                        i2++;
                    }
                }
                throw zzdok.zzayf();
                return true;
            case 1:
                zzfu(8);
                return true;
            case 2:
                zzfu(zzawm());
                return true;
            case 3:
                break;
            case 4:
                return false;
            case 5:
                zzfu(4);
                return true;
            default:
                throw zzdok.zzayi();
        }
        do {
            zzavu = zzavu();
            if (zzavu == 0 || !zzfq(zzavu)) {
                zzfp(((i >>> 3) << 3) | 4);
                return true;
            }
            zzavu = zzavu();
            zzfp(((i >>> 3) << 3) | 4);
            return true;
        } while (!zzfq(zzavu));
        zzfp(((i >>> 3) << 3) | 4);
        return true;
    }

    public final double readDouble() throws IOException {
        return Double.longBitsToDouble(zzawp());
    }

    public final float readFloat() throws IOException {
        return Float.intBitsToFloat(zzawo());
    }

    public final long zzavv() throws IOException {
        return zzawn();
    }

    public final long zzavw() throws IOException {
        return zzawn();
    }

    public final int zzavx() throws IOException {
        return zzawm();
    }

    public final long zzavy() throws IOException {
        return zzawp();
    }

    public final int zzavz() throws IOException {
        return zzawo();
    }

    public final boolean zzawa() throws IOException {
        return zzawn() != 0;
    }

    public final String readString() throws IOException {
        int zzawm = zzawm();
        if (zzawm > 0 && zzawm <= this.limit - this.pos) {
            String str = new String(this.buffer, this.pos, zzawm, zzdod.UTF_8);
            this.pos += zzawm;
            return str;
        } else if (zzawm == 0) {
            return "";
        } else {
            if (zzawm < 0) {
                throw zzdok.zzaye();
            }
            throw zzdok.zzayd();
        }
    }

    public final String zzawb() throws IOException {
        int zzawm = zzawm();
        if (zzawm > 0 && zzawm <= this.limit - this.pos) {
            String zzn = zzdrb.zzn(this.buffer, this.pos, zzawm);
            this.pos += zzawm;
            return zzn;
        } else if (zzawm == 0) {
            return "";
        } else {
            if (zzawm <= 0) {
                throw zzdok.zzaye();
            }
            throw zzdok.zzayd();
        }
    }

    public final zzdmr zzawc() throws IOException {
        byte[] bArr;
        int zzawm = zzawm();
        if (zzawm > 0 && zzawm <= this.limit - this.pos) {
            zzdmr zzi = zzdmr.zzi(this.buffer, this.pos, zzawm);
            this.pos += zzawm;
            return zzi;
        } else if (zzawm == 0) {
            return zzdmr.zzhcr;
        } else {
            if (zzawm > 0 && zzawm <= this.limit - this.pos) {
                int i = this.pos;
                this.pos += zzawm;
                bArr = Arrays.copyOfRange(this.buffer, i, this.pos);
            } else if (zzawm > 0) {
                throw zzdok.zzayd();
            } else if (zzawm == 0) {
                bArr = zzdod.zzhia;
            } else {
                throw zzdok.zzaye();
            }
            return zzdmr.zzaa(bArr);
        }
    }

    public final int zzawd() throws IOException {
        return zzawm();
    }

    public final int zzawe() throws IOException {
        return zzawm();
    }

    public final int zzawf() throws IOException {
        return zzawo();
    }

    public final long zzawg() throws IOException {
        return zzawp();
    }

    public final int zzawh() throws IOException {
        return zzft(zzawm());
    }

    public final long zzawi() throws IOException {
        return zzfi(zzawn());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0068, code lost:
        if (r1[r2] >= 0) goto L_0x006a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int zzawm() throws java.io.IOException {
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
            long r0 = r5.zzawj()
            int r0 = (int) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdnf.zzawm():int");
    }

    private final long zzawn() throws IOException {
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
        return zzawj();
    }

    /* access modifiers changed from: package-private */
    public final long zzawj() throws IOException {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte zzawr = zzawr();
            j |= ((long) (zzawr & ByteCompanionObject.MAX_VALUE)) << i;
            if ((zzawr & ByteCompanionObject.MIN_VALUE) == 0) {
                return j;
            }
        }
        throw zzdok.zzayf();
    }

    private final int zzawo() throws IOException {
        int i = this.pos;
        if (this.limit - i >= 4) {
            byte[] bArr = this.buffer;
            this.pos = i + 4;
            return ((bArr[i + 3] & UByte.MAX_VALUE) << 24) | (bArr[i] & UByte.MAX_VALUE) | ((bArr[i + 1] & UByte.MAX_VALUE) << 8) | ((bArr[i + 2] & UByte.MAX_VALUE) << 16);
        }
        throw zzdok.zzayd();
    }

    private final long zzawp() throws IOException {
        int i = this.pos;
        if (this.limit - i >= 8) {
            byte[] bArr = this.buffer;
            this.pos = i + 8;
            return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
        }
        throw zzdok.zzayd();
    }

    public final int zzfr(int i) throws zzdok {
        if (i >= 0) {
            int zzawl = i + zzawl();
            int i2 = this.zzhdi;
            if (zzawl <= i2) {
                this.zzhdi = zzawl;
                zzawq();
                return i2;
            }
            throw zzdok.zzayd();
        }
        throw zzdok.zzaye();
    }

    private final void zzawq() {
        this.limit += this.zzhdf;
        int i = this.limit - this.zzhdg;
        if (i > this.zzhdi) {
            this.zzhdf = i - this.zzhdi;
            this.limit -= this.zzhdf;
            return;
        }
        this.zzhdf = 0;
    }

    public final void zzfs(int i) {
        this.zzhdi = i;
        zzawq();
    }

    public final boolean zzawk() throws IOException {
        return this.pos == this.limit;
    }

    public final int zzawl() {
        return this.pos - this.zzhdg;
    }

    private final byte zzawr() throws IOException {
        if (this.pos != this.limit) {
            byte[] bArr = this.buffer;
            int i = this.pos;
            this.pos = i + 1;
            return bArr[i];
        }
        throw zzdok.zzayd();
    }

    private final void zzfu(int i) throws IOException {
        if (i >= 0 && i <= this.limit - this.pos) {
            this.pos += i;
        } else if (i < 0) {
            throw zzdok.zzaye();
        } else {
            throw zzdok.zzayd();
        }
    }
}
