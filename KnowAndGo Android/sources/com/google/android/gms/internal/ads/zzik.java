package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.LinkedBlockingDeque;
import kotlin.jvm.internal.ByteCompanionObject;

final class zzik {
    private final zzjl zzajg;
    private final int zzajh;
    private final zzim zzaji = new zzim();
    private final LinkedBlockingDeque<zzjk> zzajj = new LinkedBlockingDeque<>();
    private final zzin zzajk = new zzin();
    private final zzkm zzajl = new zzkm(32);
    private long zzajm;
    private long zzajn;
    private zzjk zzajo;
    private int zzajp = this.zzajh;

    public zzik(zzjl zzjl) {
        this.zzajg = zzjl;
        this.zzajh = zzjl.zzfz();
    }

    public final void clear() {
        this.zzaji.clear();
        while (!this.zzajj.isEmpty()) {
            this.zzajg.zza(this.zzajj.remove());
        }
        this.zzajm = 0;
        this.zzajn = 0;
        this.zzajo = null;
        this.zzajp = this.zzajh;
    }

    public final boolean zzb(zzhm zzhm) {
        return this.zzaji.zza(zzhm, this.zzajk);
    }

    public final void zzfs() {
        zzdu(this.zzaji.zzfv());
    }

    public final boolean zzds(long j) {
        long zzdv = this.zzaji.zzdv(j);
        if (zzdv == -1) {
            return false;
        }
        zzdu(zzdv);
        return true;
    }

    public final boolean zzc(zzhm zzhm) {
        int i;
        if (!this.zzaji.zza(zzhm, this.zzajk)) {
            return false;
        }
        if (zzhm.zzeo()) {
            zzin zzin = this.zzajk;
            long j = zzin.zzajx;
            zza(j, this.zzajl.data, 1);
            long j2 = j + 1;
            byte b = this.zzajl.data[0];
            boolean z = (b & ByteCompanionObject.MIN_VALUE) != 0;
            byte b2 = b & ByteCompanionObject.MAX_VALUE;
            if (zzhm.zzafz.f181iv == null) {
                zzhm.zzafz.f181iv = new byte[16];
            }
            zza(j2, zzhm.zzafz.f181iv, b2);
            long j3 = j2 + ((long) b2);
            if (z) {
                zza(j3, this.zzajl.data, 2);
                j3 += 2;
                this.zzajl.setPosition(0);
                i = this.zzajl.readUnsignedShort();
            } else {
                i = 1;
            }
            int[] iArr = zzhm.zzafz.numBytesOfClearData;
            if (iArr == null || iArr.length < i) {
                iArr = new int[i];
            }
            int[] iArr2 = iArr;
            int[] iArr3 = zzhm.zzafz.numBytesOfEncryptedData;
            if (iArr3 == null || iArr3.length < i) {
                iArr3 = new int[i];
            }
            int[] iArr4 = iArr3;
            if (z) {
                int i2 = i * 6;
                zzkm zzkm = this.zzajl;
                if (zzkm.limit() < i2) {
                    zzkm.zzb(new byte[i2], i2);
                }
                zza(j3, this.zzajl.data, i2);
                j3 += (long) i2;
                this.zzajl.setPosition(0);
                for (int i3 = 0; i3 < i; i3++) {
                    iArr2[i3] = this.zzajl.readUnsignedShort();
                    iArr4[i3] = this.zzajl.zzgg();
                }
            } else {
                iArr2[0] = 0;
                iArr4[0] = zzhm.size - ((int) (j3 - zzin.zzajx));
            }
            zzhm.zzafz.set(i, iArr2, iArr4, zzin.zzajy, zzhm.zzafz.f181iv, 1);
            int i4 = (int) (j3 - zzin.zzajx);
            zzin.zzajx += (long) i4;
            zzhm.size -= i4;
        }
        if (zzhm.zzde == null || zzhm.zzde.capacity() < zzhm.size) {
            int i5 = zzhm.size;
        }
        if (zzhm.zzde != null) {
            long j4 = this.zzajk.zzajx;
            ByteBuffer byteBuffer = zzhm.zzde;
            int i6 = zzhm.size;
            while (i6 > 0) {
                zzdu(j4);
                int i7 = (int) (j4 - this.zzajm);
                int min = Math.min(i6, this.zzajh - i7);
                byteBuffer.put(this.zzajj.peek().data, i7 + 0, min);
                j4 += (long) min;
                i6 -= min;
            }
        }
        zzdu(this.zzaji.zzfv());
        return true;
    }

    private final void zza(long j, byte[] bArr, int i) {
        long j2 = j;
        int i2 = 0;
        while (i2 < i) {
            zzdu(j2);
            int i3 = (int) (j2 - this.zzajm);
            int min = Math.min(i - i2, this.zzajh - i3);
            System.arraycopy(this.zzajj.peek().data, i3 + 0, bArr, i2, min);
            j2 += (long) min;
            i2 += min;
        }
    }

    private final void zzdu(long j) {
        int i = ((int) (j - this.zzajm)) / this.zzajh;
        for (int i2 = 0; i2 < i; i2++) {
            this.zzajg.zza(this.zzajj.remove());
            this.zzajm += (long) this.zzajh;
        }
    }

    public final long zzft() {
        return this.zzajn;
    }

    public final int zzb(zzie zzie, int i) throws IOException, InterruptedException {
        zzfu();
        int min = Math.min(i, this.zzajh - this.zzajp);
        byte[] bArr = this.zzajo.data;
        zzjk zzjk = this.zzajo;
        zzie.readFully(bArr, this.zzajp + 0, min);
        this.zzajp += min;
        this.zzajn += (long) min;
        return min;
    }

    public final void zzb(zzkm zzkm, int i) {
        int i2 = i;
        while (i2 > 0) {
            zzfu();
            int min = Math.min(i2, this.zzajh - this.zzajp);
            byte[] bArr = this.zzajo.data;
            zzjk zzjk = this.zzajo;
            zzkm.zzb(bArr, this.zzajp + 0, min);
            this.zzajp += min;
            i2 -= min;
        }
        this.zzajn += (long) i;
    }

    public final void zza(long j, int i, long j2, int i2, byte[] bArr) {
        this.zzaji.zza(j, i, j2, i2, bArr);
    }

    private final void zzfu() {
        if (this.zzajp == this.zzajh) {
            this.zzajp = 0;
            this.zzajo = this.zzajg.zzfy();
            this.zzajj.add(this.zzajo);
        }
    }
}
