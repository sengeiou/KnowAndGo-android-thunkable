package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdob;
import java.io.IOException;
import java.util.Arrays;

public final class zzdqu {
    private static final zzdqu zzhlf = new zzdqu(0, new int[0], new Object[0], false);
    private int count;
    private boolean zzhci;
    private int zzhhe;
    private Object[] zzhjr;
    private int[] zzhlg;

    public static zzdqu zzazz() {
        return zzhlf;
    }

    static zzdqu zzbaa() {
        return new zzdqu();
    }

    static zzdqu zza(zzdqu zzdqu, zzdqu zzdqu2) {
        int i = zzdqu.count + zzdqu2.count;
        int[] copyOf = Arrays.copyOf(zzdqu.zzhlg, i);
        System.arraycopy(zzdqu2.zzhlg, 0, copyOf, zzdqu.count, zzdqu2.count);
        Object[] copyOf2 = Arrays.copyOf(zzdqu.zzhjr, i);
        System.arraycopy(zzdqu2.zzhjr, 0, copyOf2, zzdqu.count, zzdqu2.count);
        return new zzdqu(i, copyOf, copyOf2, true);
    }

    private zzdqu() {
        this(0, new int[8], new Object[8], true);
    }

    private zzdqu(int i, int[] iArr, Object[] objArr, boolean z) {
        this.zzhhe = -1;
        this.count = i;
        this.zzhlg = iArr;
        this.zzhjr = objArr;
        this.zzhci = z;
    }

    public final void zzavj() {
        this.zzhci = false;
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzdro zzdro) throws IOException {
        if (zzdro.zzawy() == zzdob.zze.zzhhw) {
            for (int i = this.count - 1; i >= 0; i--) {
                zzdro.zzb(this.zzhlg[i] >>> 3, this.zzhjr[i]);
            }
            return;
        }
        for (int i2 = 0; i2 < this.count; i2++) {
            zzdro.zzb(this.zzhlg[i2] >>> 3, this.zzhjr[i2]);
        }
    }

    public final void zzb(zzdro zzdro) throws IOException {
        if (this.count != 0) {
            if (zzdro.zzawy() == zzdob.zze.zzhhv) {
                for (int i = 0; i < this.count; i++) {
                    zzb(this.zzhlg[i], this.zzhjr[i], zzdro);
                }
                return;
            }
            for (int i2 = this.count - 1; i2 >= 0; i2--) {
                zzb(this.zzhlg[i2], this.zzhjr[i2], zzdro);
            }
        }
    }

    private static void zzb(int i, Object obj, zzdro zzdro) throws IOException {
        int i2 = i >>> 3;
        int i3 = i & 7;
        if (i3 != 5) {
            switch (i3) {
                case 0:
                    zzdro.zzp(i2, ((Long) obj).longValue());
                    return;
                case 1:
                    zzdro.zzj(i2, ((Long) obj).longValue());
                    return;
                case 2:
                    zzdro.zza(i2, (zzdmr) obj);
                    return;
                case 3:
                    if (zzdro.zzawy() == zzdob.zze.zzhhv) {
                        zzdro.zzgm(i2);
                        ((zzdqu) obj).zzb(zzdro);
                        zzdro.zzgn(i2);
                        return;
                    }
                    zzdro.zzgn(i2);
                    ((zzdqu) obj).zzb(zzdro);
                    zzdro.zzgm(i2);
                    return;
                default:
                    throw new RuntimeException(zzdok.zzayi());
            }
        } else {
            zzdro.zzaa(i2, ((Integer) obj).intValue());
        }
    }

    public final int zzbab() {
        int i = this.zzhhe;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.count; i3++) {
            i2 += zzdni.zzd(this.zzhlg[i3] >>> 3, (zzdmr) this.zzhjr[i3]);
        }
        this.zzhhe = i2;
        return i2;
    }

    public final int zzaxj() {
        int i;
        int i2 = this.zzhhe;
        if (i2 != -1) {
            return i2;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < this.count; i4++) {
            int i5 = this.zzhlg[i4];
            int i6 = i5 >>> 3;
            int i7 = i5 & 7;
            if (i7 != 5) {
                switch (i7) {
                    case 0:
                        i = zzdni.zzl(i6, ((Long) this.zzhjr[i4]).longValue());
                        break;
                    case 1:
                        i = zzdni.zzn(i6, ((Long) this.zzhjr[i4]).longValue());
                        break;
                    case 2:
                        i = zzdni.zzc(i6, (zzdmr) this.zzhjr[i4]);
                        break;
                    case 3:
                        i = (zzdni.zzgd(i6) << 1) + ((zzdqu) this.zzhjr[i4]).zzaxj();
                        break;
                    default:
                        throw new IllegalStateException(zzdok.zzayi());
                }
            } else {
                i = zzdni.zzae(i6, ((Integer) this.zzhjr[i4]).intValue());
            }
            i3 += i;
        }
        this.zzhhe = i3;
        return i3;
    }

    public final boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzdqu)) {
            return false;
        }
        zzdqu zzdqu = (zzdqu) obj;
        if (this.count == zzdqu.count) {
            int[] iArr = this.zzhlg;
            int[] iArr2 = zzdqu.zzhlg;
            int i = this.count;
            int i2 = 0;
            while (true) {
                if (i2 >= i) {
                    z = true;
                    break;
                } else if (iArr[i2] != iArr2[i2]) {
                    z = false;
                    break;
                } else {
                    i2++;
                }
            }
            if (z) {
                Object[] objArr = this.zzhjr;
                Object[] objArr2 = zzdqu.zzhjr;
                int i3 = this.count;
                int i4 = 0;
                while (true) {
                    if (i4 >= i3) {
                        z2 = true;
                        break;
                    } else if (!objArr[i4].equals(objArr2[i4])) {
                        z2 = false;
                        break;
                    } else {
                        i4++;
                    }
                }
                return z2;
            }
        }
    }

    public final int hashCode() {
        int i = (this.count + 527) * 31;
        int[] iArr = this.zzhlg;
        int i2 = this.count;
        int i3 = 17;
        int i4 = 17;
        for (int i5 = 0; i5 < i2; i5++) {
            i4 = (i4 * 31) + iArr[i5];
        }
        int i6 = (i + i4) * 31;
        Object[] objArr = this.zzhjr;
        int i7 = this.count;
        for (int i8 = 0; i8 < i7; i8++) {
            i3 = (i3 * 31) + objArr[i8].hashCode();
        }
        return i6 + i3;
    }

    /* access modifiers changed from: package-private */
    public final void zza(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < this.count; i2++) {
            zzdpn.zza(sb, i, String.valueOf(this.zzhlg[i2] >>> 3), this.zzhjr[i2]);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzc(int i, Object obj) {
        if (this.zzhci) {
            if (this.count == this.zzhlg.length) {
                int i2 = this.count + (this.count < 4 ? 8 : this.count >> 1);
                this.zzhlg = Arrays.copyOf(this.zzhlg, i2);
                this.zzhjr = Arrays.copyOf(this.zzhjr, i2);
            }
            this.zzhlg[this.count] = i;
            this.zzhjr[this.count] = obj;
            this.count++;
            return;
        }
        throw new UnsupportedOperationException();
    }
}
