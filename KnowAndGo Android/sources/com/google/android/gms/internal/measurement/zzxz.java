package com.google.android.gms.internal.measurement;

import java.io.IOException;
import kotlin.UByte;
import kotlin.jvm.internal.ByteCompanionObject;

public final class zzxz {
    private final byte[] buffer;
    private int zzbua;
    private int zzbub = 64;
    private int zzbuc = 67108864;
    private int zzbug;
    private int zzbui;
    private int zzbuj = Integer.MAX_VALUE;
    private final int zzceo;
    private final int zzcep;
    private int zzceq;
    private int zzcer;
    private zztq zzces;

    public static zzxz zzn(byte[] bArr) {
        return zzj(bArr, 0, bArr.length);
    }

    public static zzxz zzj(byte[] bArr, int i, int i2) {
        return new zzxz(bArr, 0, i2);
    }

    public final int zzuj() throws IOException {
        if (this.zzcer == this.zzceq) {
            this.zzbui = 0;
            return 0;
        }
        this.zzbui = zzvb();
        if (this.zzbui != 0) {
            return this.zzbui;
        }
        throw new zzyh("Protocol message contained an invalid tag (zero).");
    }

    public final void zzap(int i) throws zzyh {
        if (this.zzbui != i) {
            throw new zzyh("Protocol message end-group tag did not match expected tag.");
        }
    }

    public final boolean zzaq(int i) throws IOException {
        int zzuj;
        switch (i & 7) {
            case 0:
                zzvb();
                return true;
            case 1:
                zzve();
                return true;
            case 2:
                zzau(zzvb());
                return true;
            case 3:
                break;
            case 4:
                return false;
            case 5:
                zzvd();
                return true;
            default:
                throw new zzyh("Protocol message tag had invalid wire type.");
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

    public final boolean zzup() throws IOException {
        return zzvb() != 0;
    }

    public final String readString() throws IOException {
        int zzvb = zzvb();
        if (zzvb < 0) {
            throw zzyh.zzze();
        } else if (zzvb <= this.zzceq - this.zzcer) {
            String str = new String(this.buffer, this.zzcer, zzvb, zzyg.UTF_8);
            this.zzcer += zzvb;
            return str;
        } else {
            throw zzyh.zzzd();
        }
    }

    public final void zza(zzyi zzyi, int i) throws IOException {
        if (this.zzbua < this.zzbub) {
            this.zzbua++;
            zzyi.zza(this);
            zzap((i << 3) | 4);
            this.zzbua--;
            return;
        }
        throw zzyh.zzzg();
    }

    public final void zza(zzyi zzyi) throws IOException {
        int zzvb = zzvb();
        if (this.zzbua < this.zzbub) {
            int zzas = zzas(zzvb);
            this.zzbua++;
            zzyi.zza(this);
            zzap(0);
            this.zzbua--;
            zzat(zzas);
            return;
        }
        throw zzyh.zzzg();
    }

    public final int zzvb() throws IOException {
        byte zzvg = zzvg();
        if (zzvg >= 0) {
            return zzvg;
        }
        byte b = zzvg & ByteCompanionObject.MAX_VALUE;
        byte zzvg2 = zzvg();
        if (zzvg2 >= 0) {
            return b | (zzvg2 << 7);
        }
        byte b2 = b | ((zzvg2 & ByteCompanionObject.MAX_VALUE) << 7);
        byte zzvg3 = zzvg();
        if (zzvg3 >= 0) {
            return b2 | (zzvg3 << 14);
        }
        byte b3 = b2 | ((zzvg3 & ByteCompanionObject.MAX_VALUE) << 14);
        byte zzvg4 = zzvg();
        if (zzvg4 >= 0) {
            return b3 | (zzvg4 << 21);
        }
        byte b4 = b3 | ((zzvg4 & ByteCompanionObject.MAX_VALUE) << 21);
        byte zzvg5 = zzvg();
        byte b5 = b4 | (zzvg5 << 28);
        if (zzvg5 >= 0) {
            return b5;
        }
        for (int i = 0; i < 5; i++) {
            if (zzvg() >= 0) {
                return b5;
            }
        }
        throw zzyh.zzzf();
    }

    public final long zzvc() throws IOException {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte zzvg = zzvg();
            j |= ((long) (zzvg & ByteCompanionObject.MAX_VALUE)) << i;
            if ((zzvg & ByteCompanionObject.MIN_VALUE) == 0) {
                return j;
            }
        }
        throw zzyh.zzzf();
    }

    public final int zzvd() throws IOException {
        return (zzvg() & UByte.MAX_VALUE) | ((zzvg() & UByte.MAX_VALUE) << 8) | ((zzvg() & UByte.MAX_VALUE) << 16) | ((zzvg() & UByte.MAX_VALUE) << 24);
    }

    public final long zzve() throws IOException {
        byte zzvg = zzvg();
        byte zzvg2 = zzvg();
        return ((((long) zzvg2) & 255) << 8) | (((long) zzvg) & 255) | ((((long) zzvg()) & 255) << 16) | ((((long) zzvg()) & 255) << 24) | ((((long) zzvg()) & 255) << 32) | ((((long) zzvg()) & 255) << 40) | ((((long) zzvg()) & 255) << 48) | ((((long) zzvg()) & 255) << 56);
    }

    private zzxz(byte[] bArr, int i, int i2) {
        this.buffer = bArr;
        this.zzceo = i;
        int i3 = i2 + i;
        this.zzceq = i3;
        this.zzcep = i3;
        this.zzcer = i;
    }

    private final zztq zzyx() throws IOException {
        if (this.zzces == null) {
            this.zzces = zztq.zzd(this.buffer, this.zzceo, this.zzcep);
        }
        int zzva = this.zzces.zzva();
        int i = this.zzcer - this.zzceo;
        if (zzva <= i) {
            this.zzces.zzau(i - zzva);
            this.zzces.zzar(this.zzbub - this.zzbua);
            return this.zzces;
        }
        throw new IOException(String.format("CodedInputStream read ahead of CodedInputByteBufferNano: %s > %s", new Object[]{Integer.valueOf(zzva), Integer.valueOf(i)}));
    }

    public final <T extends zzuo<T, ?>> T zza(zzwf<T> zzwf) throws IOException {
        try {
            T t = (zzuo) zzyx().zza(zzwf, zzub.zzvs());
            zzaq(this.zzbui);
            return t;
        } catch (zzuv e) {
            throw new zzyh("", e);
        }
    }

    public final int zzas(int i) throws zzyh {
        if (i >= 0) {
            int i2 = i + this.zzcer;
            int i3 = this.zzbuj;
            if (i2 <= i3) {
                this.zzbuj = i2;
                zzvf();
                return i3;
            }
            throw zzyh.zzzd();
        }
        throw zzyh.zzze();
    }

    private final void zzvf() {
        this.zzceq += this.zzbug;
        int i = this.zzceq;
        if (i > this.zzbuj) {
            this.zzbug = i - this.zzbuj;
            this.zzceq -= this.zzbug;
            return;
        }
        this.zzbug = 0;
    }

    public final void zzat(int i) {
        this.zzbuj = i;
        zzvf();
    }

    public final int zzyy() {
        if (this.zzbuj == Integer.MAX_VALUE) {
            return -1;
        }
        return this.zzbuj - this.zzcer;
    }

    public final int getPosition() {
        return this.zzcer - this.zzceo;
    }

    public final byte[] zzs(int i, int i2) {
        if (i2 == 0) {
            return zzyl.zzcfq;
        }
        byte[] bArr = new byte[i2];
        System.arraycopy(this.buffer, this.zzceo + i, bArr, 0, i2);
        return bArr;
    }

    public final void zzcb(int i) {
        zzt(i, this.zzbui);
    }

    /* access modifiers changed from: package-private */
    public final void zzt(int i, int i2) {
        if (i > this.zzcer - this.zzceo) {
            StringBuilder sb = new StringBuilder(50);
            sb.append("Position ");
            sb.append(i);
            sb.append(" is beyond current ");
            sb.append(this.zzcer - this.zzceo);
            throw new IllegalArgumentException(sb.toString());
        } else if (i >= 0) {
            this.zzcer = this.zzceo + i;
            this.zzbui = i2;
        } else {
            StringBuilder sb2 = new StringBuilder(24);
            sb2.append("Bad position ");
            sb2.append(i);
            throw new IllegalArgumentException(sb2.toString());
        }
    }

    private final byte zzvg() throws IOException {
        if (this.zzcer != this.zzceq) {
            byte[] bArr = this.buffer;
            int i = this.zzcer;
            this.zzcer = i + 1;
            return bArr[i];
        }
        throw zzyh.zzzd();
    }

    private final void zzau(int i) throws IOException {
        if (i < 0) {
            throw zzyh.zzze();
        } else if (this.zzcer + i > this.zzbuj) {
            zzau(this.zzbuj - this.zzcer);
            throw zzyh.zzzd();
        } else if (i <= this.zzceq - this.zzcer) {
            this.zzcer += i;
        } else {
            throw zzyh.zzzd();
        }
    }
}
