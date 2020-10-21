package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.charset.Charset;

class zzdnb extends zzdna {
    protected final byte[] zzhcy;

    zzdnb(byte[] bArr) {
        if (bArr != null) {
            this.zzhcy = bArr;
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: protected */
    public int zzavr() {
        return 0;
    }

    public byte zzfm(int i) {
        return this.zzhcy[i];
    }

    /* access modifiers changed from: package-private */
    public byte zzfn(int i) {
        return this.zzhcy[i];
    }

    public int size() {
        return this.zzhcy.length;
    }

    public final zzdmr zzv(int i, int i2) {
        int zzg = zzg(0, i2, size());
        if (zzg == 0) {
            return zzdmr.zzhcr;
        }
        return new zzdmw(this.zzhcy, zzavr(), zzg);
    }

    /* access modifiers changed from: protected */
    public void zza(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.zzhcy, 0, bArr, 0, i3);
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzdmq zzdmq) throws IOException {
        zzdmq.zzh(this.zzhcy, zzavr(), size());
    }

    /* access modifiers changed from: protected */
    public final String zza(Charset charset) {
        return new String(this.zzhcy, zzavr(), size(), charset);
    }

    public final boolean zzavo() {
        int zzavr = zzavr();
        return zzdrb.zzl(this.zzhcy, zzavr, size() + zzavr);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzdmr) || size() != ((zzdmr) obj).size()) {
            return false;
        }
        if (size() == 0) {
            return true;
        }
        if (!(obj instanceof zzdnb)) {
            return obj.equals(this);
        }
        zzdnb zzdnb = (zzdnb) obj;
        int zzavq = zzavq();
        int zzavq2 = zzdnb.zzavq();
        if (zzavq == 0 || zzavq2 == 0 || zzavq == zzavq2) {
            return zza(zzdnb, 0, size());
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public final boolean zza(zzdmr zzdmr, int i, int i2) {
        if (i2 > zzdmr.size()) {
            int size = size();
            StringBuilder sb = new StringBuilder(40);
            sb.append("Length too large: ");
            sb.append(i2);
            sb.append(size);
            throw new IllegalArgumentException(sb.toString());
        } else if (i2 > zzdmr.size()) {
            int size2 = zzdmr.size();
            StringBuilder sb2 = new StringBuilder(59);
            sb2.append("Ran off end of other: 0, ");
            sb2.append(i2);
            sb2.append(", ");
            sb2.append(size2);
            throw new IllegalArgumentException(sb2.toString());
        } else if (!(zzdmr instanceof zzdnb)) {
            return zzdmr.zzv(0, i2).equals(zzv(0, i2));
        } else {
            zzdnb zzdnb = (zzdnb) zzdmr;
            byte[] bArr = this.zzhcy;
            byte[] bArr2 = zzdnb.zzhcy;
            int zzavr = zzavr() + i2;
            int zzavr2 = zzavr();
            int zzavr3 = zzdnb.zzavr();
            while (zzavr2 < zzavr) {
                if (bArr[zzavr2] != bArr2[zzavr3]) {
                    return false;
                }
                zzavr2++;
                zzavr3++;
            }
            return true;
        }
    }

    /* access modifiers changed from: protected */
    public final int zzf(int i, int i2, int i3) {
        return zzdod.zza(i, this.zzhcy, zzavr(), i3);
    }

    public final zzdnd zzavp() {
        return zzdnd.zzc(this.zzhcy, zzavr(), size(), true);
    }
}
