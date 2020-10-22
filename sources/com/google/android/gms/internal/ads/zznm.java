package com.google.android.gms.internal.ads;

import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;

public final class zznm implements zzno {
    private static final byte[] zzaht = new byte[4096];
    private long zzahv;
    private final zzrv zzazi;
    private final long zzazj;
    private byte[] zzazk = new byte[65536];
    private int zzazl;
    private int zzazm;

    public zznm(zzrv zzrv, long j, long j2) {
        this.zzazi = zzrv;
        this.zzahv = j;
        this.zzazj = j2;
    }

    public final int read(byte[] bArr, int i, int i2) throws IOException, InterruptedException {
        int zzd = zzd(bArr, i, i2);
        if (zzd == 0) {
            zzd = zza(bArr, i, i2, 0, true);
        }
        zzau(zzd);
        return zzd;
    }

    public final boolean zza(byte[] bArr, int i, int i2, boolean z) throws IOException, InterruptedException {
        int zzd = zzd(bArr, i, i2);
        while (zzd < i2 && zzd != -1) {
            zzd = zza(bArr, i, i2, zzd, z);
        }
        zzau(zzd);
        return zzd != -1;
    }

    public final void readFully(byte[] bArr, int i, int i2) throws IOException, InterruptedException {
        zza(bArr, i, i2, false);
    }

    public final int zzaq(int i) throws IOException, InterruptedException {
        int zzas = zzas(i);
        if (zzas == 0) {
            zzas = zza(zzaht, 0, Math.min(i, zzaht.length), 0, true);
        }
        zzau(zzas);
        return zzas;
    }

    public final void zzr(int i) throws IOException, InterruptedException {
        int zzas = zzas(i);
        while (zzas < i && zzas != -1) {
            zzas = zza(zzaht, -zzas, Math.min(i, zzaht.length + zzas), zzas, false);
        }
        zzau(zzas);
    }

    public final void zzc(byte[] bArr, int i, int i2) throws IOException, InterruptedException {
        if (zze(i2, false)) {
            System.arraycopy(this.zzazk, this.zzazl - i2, bArr, i, i2);
        }
    }

    private final boolean zze(int i, boolean z) throws IOException, InterruptedException {
        int i2 = this.zzazl + i;
        if (i2 > this.zzazk.length) {
            this.zzazk = Arrays.copyOf(this.zzazk, zzsy.zzd(this.zzazk.length << 1, 65536 + i2, i2 + 524288));
        }
        int min = Math.min(this.zzazm - this.zzazl, i);
        while (min < i) {
            min = zza(this.zzazk, this.zzazl, i, min, false);
            if (min == -1) {
                return false;
            }
        }
        this.zzazl += i;
        this.zzazm = Math.max(this.zzazm, this.zzazl);
        return true;
    }

    public final void zzar(int i) throws IOException, InterruptedException {
        zze(i, false);
    }

    public final void zzig() {
        this.zzazl = 0;
    }

    public final long getPosition() {
        return this.zzahv;
    }

    public final long getLength() {
        return this.zzazj;
    }

    private final int zzas(int i) {
        int min = Math.min(this.zzazm, i);
        zzat(min);
        return min;
    }

    private final int zzd(byte[] bArr, int i, int i2) {
        if (this.zzazm == 0) {
            return 0;
        }
        int min = Math.min(this.zzazm, i2);
        System.arraycopy(this.zzazk, 0, bArr, i, min);
        zzat(min);
        return min;
    }

    private final void zzat(int i) {
        this.zzazm -= i;
        this.zzazl = 0;
        byte[] bArr = this.zzazk;
        if (this.zzazm < this.zzazk.length - 524288) {
            bArr = new byte[(this.zzazm + 65536)];
        }
        System.arraycopy(this.zzazk, i, bArr, 0, this.zzazm);
        this.zzazk = bArr;
    }

    private final int zza(byte[] bArr, int i, int i2, int i3, boolean z) throws InterruptedException, IOException {
        if (!Thread.interrupted()) {
            int read = this.zzazi.read(bArr, i + i3, i2 - i3);
            if (read != -1) {
                return i3 + read;
            }
            if (i3 == 0 && z) {
                return -1;
            }
            throw new EOFException();
        }
        throw new InterruptedException();
    }

    private final void zzau(int i) {
        if (i != -1) {
            this.zzahv += (long) i;
        }
    }
}
