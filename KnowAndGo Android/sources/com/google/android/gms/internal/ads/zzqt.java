package com.google.android.gms.internal.ads;

import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.ByteCompanionObject;

public final class zzqt implements zznw {
    private final int zzajh;
    private long zzajn;
    private int zzajp = this.zzajh;
    private final zzst zzbac = new zzst(32);
    private final zzrt zzbic;
    private final zzqr zzbke = new zzqr();
    private final zzqs zzbkf = new zzqs();
    private final AtomicInteger zzbkg = new AtomicInteger();
    private zzqu zzbkh = new zzqu(0, this.zzajh);
    private zzqu zzbki = this.zzbkh;
    private zzlh zzbkj;
    private boolean zzbkk;
    private zzlh zzbkl;
    private zzqv zzbkm;

    public zzqt(zzrt zzrt) {
        this.zzbic = zzrt;
        this.zzajh = zzrt.zzfz();
    }

    public final void zzk(boolean z) {
        int andSet = this.zzbkg.getAndSet(z ? 0 : 2);
        zzjh();
        this.zzbke.zzji();
        if (andSet == 2) {
            this.zzbkj = null;
        }
    }

    public final int zzjj() {
        return this.zzbke.zzjj();
    }

    public final void disable() {
        if (this.zzbkg.getAndSet(2) == 0) {
            zzjh();
        }
    }

    public final boolean zzjk() {
        return this.zzbke.zzjk();
    }

    public final zzlh zzjl() {
        return this.zzbke.zzjl();
    }

    public final long zzje() {
        return this.zzbke.zzje();
    }

    public final void zzjn() {
        long zzjm = this.zzbke.zzjm();
        if (zzjm != -1) {
            zzdu(zzjm);
        }
    }

    public final boolean zzh(long j, boolean z) {
        long zzg = this.zzbke.zzg(j, z);
        if (zzg == -1) {
            return false;
        }
        zzdu(zzg);
        return true;
    }

    public final int zza(zzlj zzlj, zznd zznd, boolean z, boolean z2, long j) {
        int i;
        switch (this.zzbke.zza(zzlj, zznd, z, z2, this.zzbkj, this.zzbkf)) {
            case -5:
                this.zzbkj = zzlj.zzaue;
                return -5;
            case -4:
                if (zznd.zzic()) {
                    return -4;
                }
                if (zznd.zzaga < j) {
                    zznd.zzal(Integer.MIN_VALUE);
                }
                if (zznd.zzeo()) {
                    zzqs zzqs = this.zzbkf;
                    long j2 = zzqs.zzajx;
                    this.zzbac.reset(1);
                    zza(j2, this.zzbac.data, 1);
                    long j3 = j2 + 1;
                    byte b = this.zzbac.data[0];
                    boolean z3 = (b & ByteCompanionObject.MIN_VALUE) != 0;
                    byte b2 = b & ByteCompanionObject.MAX_VALUE;
                    if (zznd.zzaze.f183iv == null) {
                        zznd.zzaze.f183iv = new byte[16];
                    }
                    zza(j3, zznd.zzaze.f183iv, (int) b2);
                    long j4 = j3 + ((long) b2);
                    if (z3) {
                        this.zzbac.reset(2);
                        zza(j4, this.zzbac.data, 2);
                        j4 += 2;
                        i = this.zzbac.readUnsignedShort();
                    } else {
                        i = 1;
                    }
                    int[] iArr = zznd.zzaze.numBytesOfClearData;
                    if (iArr == null || iArr.length < i) {
                        iArr = new int[i];
                    }
                    int[] iArr2 = iArr;
                    int[] iArr3 = zznd.zzaze.numBytesOfEncryptedData;
                    if (iArr3 == null || iArr3.length < i) {
                        iArr3 = new int[i];
                    }
                    int[] iArr4 = iArr3;
                    if (z3) {
                        int i2 = i * 6;
                        this.zzbac.reset(i2);
                        zza(j4, this.zzbac.data, i2);
                        j4 += (long) i2;
                        this.zzbac.setPosition(0);
                        for (int i3 = 0; i3 < i; i3++) {
                            iArr2[i3] = this.zzbac.readUnsignedShort();
                            iArr4[i3] = this.zzbac.zzgg();
                        }
                    } else {
                        iArr2[0] = 0;
                        iArr4[0] = zzqs.size - ((int) (j4 - zzqs.zzajx));
                    }
                    zznx zznx = zzqs.zzbbj;
                    zznd.zzaze.set(i, iArr2, iArr4, zznx.zzazq, zznd.zzaze.f183iv, zznx.zzazp);
                    int i4 = (int) (j4 - zzqs.zzajx);
                    zzqs.zzajx += (long) i4;
                    zzqs.size -= i4;
                }
                zznd.zzan(this.zzbkf.size);
                long j5 = this.zzbkf.zzajx;
                ByteBuffer byteBuffer = zznd.zzde;
                int i5 = this.zzbkf.size;
                zzdu(j5);
                while (i5 > 0) {
                    int i6 = (int) (j5 - this.zzbkh.zzbkn);
                    int min = Math.min(i5, this.zzajh - i6);
                    zzrs zzrs = this.zzbkh.zzbkp;
                    byteBuffer.put(zzrs.data, zzrs.zzbj(i6), min);
                    j5 += (long) min;
                    i5 -= min;
                    if (j5 == this.zzbkh.zzbdz) {
                        this.zzbic.zza(zzrs);
                        this.zzbkh = this.zzbkh.zzjq();
                    }
                }
                zzdu(this.zzbkf.zzbkd);
                return -4;
            case -3:
                return -3;
            default:
                throw new IllegalStateException();
        }
    }

    private final void zza(long j, byte[] bArr, int i) {
        zzdu(j);
        int i2 = 0;
        while (i2 < i) {
            int i3 = (int) (j - this.zzbkh.zzbkn);
            int min = Math.min(i - i2, this.zzajh - i3);
            zzrs zzrs = this.zzbkh.zzbkp;
            System.arraycopy(zzrs.data, zzrs.zzbj(i3), bArr, i2, min);
            j += (long) min;
            i2 += min;
            if (j == this.zzbkh.zzbdz) {
                this.zzbic.zza(zzrs);
                this.zzbkh = this.zzbkh.zzjq();
            }
        }
    }

    private final void zzdu(long j) {
        while (j >= this.zzbkh.zzbdz) {
            this.zzbic.zza(this.zzbkh.zzbkp);
            this.zzbkh = this.zzbkh.zzjq();
        }
    }

    public final void zza(zzqv zzqv) {
        this.zzbkm = zzqv;
    }

    public final void zze(zzlh zzlh) {
        zzlh zzlh2 = zzlh == null ? null : zzlh;
        boolean zzg = this.zzbke.zzg(zzlh2);
        this.zzbkl = zzlh;
        this.zzbkk = false;
        if (this.zzbkm != null && zzg) {
            this.zzbkm.zzf(zzlh2);
        }
    }

    public final int zza(zzno zzno, int i, boolean z) throws IOException, InterruptedException {
        if (!zzjo()) {
            int zzaq = zzno.zzaq(i);
            if (zzaq != -1) {
                return zzaq;
            }
            throw new EOFException();
        }
        try {
            int zzbe = zzbe(i);
            zzrs zzrs = this.zzbki.zzbkp;
            int read = zzno.read(zzrs.data, zzrs.zzbj(this.zzajp), zzbe);
            if (read != -1) {
                this.zzajp += read;
                this.zzajn += (long) read;
                return read;
            }
            throw new EOFException();
        } finally {
            zzjp();
        }
    }

    public final void zza(zzst zzst, int i) {
        if (!zzjo()) {
            zzst.zzac(i);
            return;
        }
        while (i > 0) {
            int zzbe = zzbe(i);
            zzrs zzrs = this.zzbki.zzbkp;
            zzst.zzb(zzrs.data, zzrs.zzbj(this.zzajp), zzbe);
            this.zzajp += zzbe;
            this.zzajn += (long) zzbe;
            i -= zzbe;
        }
        zzjp();
    }

    public final void zza(long j, int i, int i2, int i3, zznx zznx) {
        if (!zzjo()) {
            long j2 = j;
            this.zzbke.zzep(j);
            return;
        }
        long j3 = j;
        try {
            this.zzbke.zza(j, i, this.zzajn - ((long) i2), i2, zznx);
        } finally {
            zzjp();
        }
    }

    private final boolean zzjo() {
        return this.zzbkg.compareAndSet(0, 1);
    }

    private final void zzjp() {
        if (!this.zzbkg.compareAndSet(1, 0)) {
            zzjh();
        }
    }

    private final void zzjh() {
        this.zzbke.zzjh();
        zzqu zzqu = this.zzbkh;
        if (zzqu.zzbko) {
            zzrs[] zzrsArr = new zzrs[((this.zzbki.zzbko ? 1 : 0) + (((int) (this.zzbki.zzbkn - zzqu.zzbkn)) / this.zzajh))];
            for (int i = 0; i < zzrsArr.length; i++) {
                zzrsArr[i] = zzqu.zzbkp;
                zzqu = zzqu.zzjq();
            }
            this.zzbic.zza(zzrsArr);
        }
        this.zzbkh = new zzqu(0, this.zzajh);
        this.zzbki = this.zzbkh;
        this.zzajn = 0;
        this.zzajp = this.zzajh;
        this.zzbic.zzn();
    }

    private final int zzbe(int i) {
        if (this.zzajp == this.zzajh) {
            this.zzajp = 0;
            if (this.zzbki.zzbko) {
                this.zzbki = this.zzbki.zzbkq;
            }
            zzqu zzqu = this.zzbki;
            zzrs zzjt = this.zzbic.zzjt();
            zzqu zzqu2 = new zzqu(this.zzbki.zzbdz, this.zzajh);
            zzqu.zzbkp = zzjt;
            zzqu.zzbkq = zzqu2;
            zzqu.zzbko = true;
        }
        return Math.min(i, this.zzajh - this.zzajp);
    }
}
