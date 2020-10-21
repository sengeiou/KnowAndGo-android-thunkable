package com.google.android.gms.internal.ads;

import com.facebook.common.statfs.StatFsHelper;
import java.nio.ShortBuffer;
import java.util.Arrays;

final class zzmw {
    private final int zzafv;
    private float zzauh;
    private float zzaui;
    private final int zzaxx;
    private final int zzaxy;
    private final int zzaxz;
    private final int zzaya = (this.zzaxz * 2);
    private final short[] zzayb = new short[this.zzaya];
    private int zzayc = this.zzaya;
    private short[] zzayd;
    private int zzaye;
    private short[] zzayf;
    private int zzayg;
    private short[] zzayh;
    private int zzayi;
    private int zzayj;
    private int zzayk;
    private int zzayl;
    private int zzaym;
    private int zzayn;
    private int zzayo;
    private int zzayp;
    private int zzayq;
    private int zzayr;

    public zzmw(int i, int i2) {
        this.zzafv = i;
        this.zzaxx = i2;
        this.zzaxy = i / StatFsHelper.DEFAULT_DISK_YELLOW_LEVEL_IN_MB;
        this.zzaxz = i / 65;
        this.zzayd = new short[(this.zzaya * i2)];
        this.zzaye = this.zzaya;
        this.zzayf = new short[(this.zzaya * i2)];
        this.zzayg = this.zzaya;
        this.zzayh = new short[(this.zzaya * i2)];
        this.zzayi = 0;
        this.zzayj = 0;
        this.zzayo = 0;
        this.zzauh = 1.0f;
        this.zzaui = 1.0f;
    }

    public final void setSpeed(float f) {
        this.zzauh = f;
    }

    public final void zza(float f) {
        this.zzaui = f;
    }

    public final void zza(ShortBuffer shortBuffer) {
        int remaining = shortBuffer.remaining() / this.zzaxx;
        zzak(remaining);
        shortBuffer.get(this.zzayd, this.zzayk * this.zzaxx, ((this.zzaxx * remaining) << 1) / 2);
        this.zzayk += remaining;
        zzhy();
    }

    public final void zzb(ShortBuffer shortBuffer) {
        int min = Math.min(shortBuffer.remaining() / this.zzaxx, this.zzayl);
        shortBuffer.put(this.zzayf, 0, this.zzaxx * min);
        this.zzayl -= min;
        System.arraycopy(this.zzayf, min * this.zzaxx, this.zzayf, 0, this.zzayl * this.zzaxx);
    }

    public final void zzhl() {
        int i = this.zzayk;
        int i2 = this.zzayl + ((int) ((((((float) i) / (this.zzauh / this.zzaui)) + ((float) this.zzaym)) / this.zzaui) + 0.5f));
        zzak((this.zzaya * 2) + i);
        for (int i3 = 0; i3 < this.zzaya * 2 * this.zzaxx; i3++) {
            this.zzayd[(this.zzaxx * i) + i3] = 0;
        }
        this.zzayk += this.zzaya * 2;
        zzhy();
        if (this.zzayl > i2) {
            this.zzayl = i2;
        }
        this.zzayk = 0;
        this.zzayn = 0;
        this.zzaym = 0;
    }

    public final int zzhx() {
        return this.zzayl;
    }

    private final void zzaj(int i) {
        if (this.zzayl + i > this.zzaye) {
            this.zzaye += (this.zzaye / 2) + i;
            this.zzayf = Arrays.copyOf(this.zzayf, this.zzaye * this.zzaxx);
        }
    }

    private final void zzak(int i) {
        if (this.zzayk + i > this.zzayc) {
            this.zzayc += (this.zzayc / 2) + i;
            this.zzayd = Arrays.copyOf(this.zzayd, this.zzayc * this.zzaxx);
        }
    }

    private final void zza(short[] sArr, int i, int i2) {
        zzaj(i2);
        System.arraycopy(sArr, i * this.zzaxx, this.zzayf, this.zzayl * this.zzaxx, this.zzaxx * i2);
        this.zzayl += i2;
    }

    private final void zzb(short[] sArr, int i, int i2) {
        int i3 = this.zzaya / i2;
        int i4 = this.zzaxx * i2;
        int i5 = i * this.zzaxx;
        for (int i6 = 0; i6 < i3; i6++) {
            int i7 = 0;
            for (int i8 = 0; i8 < i4; i8++) {
                i7 += sArr[(i6 * i4) + i5 + i8];
            }
            this.zzayb[i6] = (short) (i7 / i4);
        }
    }

    private final int zza(short[] sArr, int i, int i2, int i3) {
        int i4 = i * this.zzaxx;
        int i5 = 1;
        int i6 = 0;
        int i7 = 0;
        int i8 = 255;
        while (i2 <= i3) {
            int i9 = 0;
            for (int i10 = 0; i10 < i2; i10++) {
                short s = sArr[i4 + i10];
                short s2 = sArr[i4 + i2 + i10];
                i9 += s >= s2 ? s - s2 : s2 - s;
            }
            if (i9 * i6 < i5 * i2) {
                i6 = i2;
                i5 = i9;
            }
            if (i9 * i8 > i7 * i2) {
                i8 = i2;
                i7 = i9;
            }
            i2++;
        }
        this.zzayq = i5 / i6;
        this.zzayr = i7 / i8;
        return i6;
    }

    private final void zzhy() {
        int i;
        int i2;
        int i3;
        int i4 = this.zzayl;
        float f = this.zzauh / this.zzaui;
        double d = (double) f;
        int i5 = 1;
        if (d <= 1.00001d && d >= 0.99999d) {
            zza(this.zzayd, 0, this.zzayk);
            this.zzayk = 0;
        } else if (this.zzayk >= this.zzaya) {
            int i6 = this.zzayk;
            int i7 = 0;
            while (true) {
                if (this.zzayn > 0) {
                    int min = Math.min(this.zzaya, this.zzayn);
                    zza(this.zzayd, i7, min);
                    this.zzayn -= min;
                    i7 += min;
                } else {
                    short[] sArr = this.zzayd;
                    int i8 = this.zzafv > 4000 ? this.zzafv / 4000 : 1;
                    if (this.zzaxx == i5 && i8 == i5) {
                        i = zza(sArr, i7, this.zzaxy, this.zzaxz);
                    } else {
                        zzb(sArr, i7, i8);
                        int zza = zza(this.zzayb, 0, this.zzaxy / i8, this.zzaxz / i8);
                        if (i8 != i5) {
                            int i9 = zza * i8;
                            int i10 = i8 << 2;
                            int i11 = i9 - i10;
                            int i12 = i9 + i10;
                            if (i11 < this.zzaxy) {
                                i11 = this.zzaxy;
                            }
                            if (i12 > this.zzaxz) {
                                i12 = this.zzaxz;
                            }
                            if (this.zzaxx == i5) {
                                i = zza(sArr, i7, i11, i12);
                            } else {
                                zzb(sArr, i7, i5);
                                i = zza(this.zzayb, 0, i11, i12);
                            }
                        } else {
                            i = zza;
                        }
                    }
                    int i13 = this.zzayq;
                    int i14 = i13 != 0 && this.zzayo != 0 && this.zzayr <= i13 * 3 && (i13 << 1) > this.zzayp * 3 ? this.zzayo : i;
                    this.zzayp = this.zzayq;
                    this.zzayo = i;
                    if (d > 1.0d) {
                        short[] sArr2 = this.zzayd;
                        if (f >= 2.0f) {
                            i3 = (int) (((float) i14) / (f - 1.0f));
                        } else {
                            this.zzayn = (int) ((((float) i14) * (2.0f - f)) / (f - 1.0f));
                            i3 = i14;
                        }
                        zzaj(i3);
                        int i15 = i3;
                        zza(i3, this.zzaxx, this.zzayf, this.zzayl, sArr2, i7, sArr2, i7 + i14);
                        this.zzayl += i15;
                        i7 += i14 + i15;
                    } else {
                        int i16 = i14;
                        int i17 = i7;
                        short[] sArr3 = this.zzayd;
                        if (f < 0.5f) {
                            i2 = (int) ((((float) i16) * f) / (1.0f - f));
                        } else {
                            this.zzayn = (int) ((((float) i16) * ((2.0f * f) - 1.0f)) / (1.0f - f));
                            i2 = i16;
                        }
                        int i18 = i16 + i2;
                        zzaj(i18);
                        System.arraycopy(sArr3, this.zzaxx * i17, this.zzayf, this.zzayl * this.zzaxx, this.zzaxx * i16);
                        zza(i2, this.zzaxx, this.zzayf, this.zzayl + i16, sArr3, i17 + i16, sArr3, i17);
                        this.zzayl += i18;
                        i7 = i17 + i2;
                    }
                }
                if (this.zzaya + i7 > i6) {
                    break;
                }
                i5 = 1;
            }
            int i19 = this.zzayk - i7;
            System.arraycopy(this.zzayd, i7 * this.zzaxx, this.zzayd, 0, this.zzaxx * i19);
            this.zzayk = i19;
        }
        if (this.zzaui != 1.0f) {
            float f2 = this.zzaui;
            if (this.zzayl != i4) {
                int i20 = (int) (((float) this.zzafv) / f2);
                int i21 = this.zzafv;
                while (true) {
                    if (i20 <= 16384 && i21 <= 16384) {
                        break;
                    }
                    i20 /= 2;
                    i21 /= 2;
                }
                int i22 = this.zzayl - i4;
                if (this.zzaym + i22 > this.zzayg) {
                    this.zzayg += (this.zzayg / 2) + i22;
                    this.zzayh = Arrays.copyOf(this.zzayh, this.zzayg * this.zzaxx);
                }
                System.arraycopy(this.zzayf, this.zzaxx * i4, this.zzayh, this.zzaym * this.zzaxx, this.zzaxx * i22);
                this.zzayl = i4;
                this.zzaym += i22;
                int i23 = 0;
                while (true) {
                    int i24 = 1;
                    if (i23 >= this.zzaym - 1) {
                        break;
                    }
                    while ((this.zzayi + i24) * i20 > this.zzayj * i21) {
                        zzaj(i24);
                        for (int i25 = 0; i25 < this.zzaxx; i25++) {
                            short[] sArr4 = this.zzayh;
                            int i26 = (this.zzaxx * i23) + i25;
                            short s = sArr4[i26];
                            short s2 = sArr4[i26 + this.zzaxx];
                            int i27 = (this.zzayi + 1) * i20;
                            int i28 = i27 - (this.zzayj * i21);
                            int i29 = i27 - (this.zzayi * i20);
                            this.zzayf[(this.zzayl * this.zzaxx) + i25] = (short) (((s * i28) + ((i29 - i28) * s2)) / i29);
                        }
                        i24 = 1;
                        this.zzayj++;
                        this.zzayl++;
                    }
                    this.zzayi += i24;
                    if (this.zzayi == i21) {
                        this.zzayi = 0;
                        zzsk.checkState(this.zzayj == i20);
                        this.zzayj = 0;
                    }
                    i23++;
                }
                int i30 = this.zzaym - 1;
                if (i30 != 0) {
                    System.arraycopy(this.zzayh, this.zzaxx * i30, this.zzayh, 0, (this.zzaym - i30) * this.zzaxx);
                    this.zzaym -= i30;
                }
            }
        }
    }

    private static void zza(int i, int i2, short[] sArr, int i3, short[] sArr2, int i4, short[] sArr3, int i5) {
        for (int i6 = 0; i6 < i2; i6++) {
            int i7 = (i4 * i2) + i6;
            int i8 = (i5 * i2) + i6;
            int i9 = (i3 * i2) + i6;
            for (int i10 = 0; i10 < i; i10++) {
                sArr[i9] = (short) (((sArr2[i7] * (i - i10)) + (sArr3[i8] * i10)) / i);
                i9 += i2;
                i7 += i2;
                i8 += i2;
            }
        }
    }
}
