package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class zzdni extends zzdmq {
    private static final Logger logger = Logger.getLogger(zzdni.class.getName());
    /* access modifiers changed from: private */
    public static final boolean zzhdn = zzdqz.zzbac();
    zzdnk zzhdo;

    static final class zzb extends zza {
        private final ByteBuffer zzhdp;
        private int zzhdq;

        zzb(ByteBuffer byteBuffer) {
            super(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining());
            this.zzhdp = byteBuffer;
            this.zzhdq = byteBuffer.position();
        }

        public final void flush() {
            this.zzhdp.position(this.zzhdq + zzawx());
        }
    }

    public static zzdni zzab(byte[] bArr) {
        return new zza(bArr, 0, bArr.length);
    }

    public static int zzbg(boolean z) {
        return 1;
    }

    public static int zzc(double d) {
        return 8;
    }

    public static int zzfn(long j) {
        int i;
        if ((-128 & j) == 0) {
            return 1;
        }
        if (j < 0) {
            return 10;
        }
        if ((-34359738368L & j) != 0) {
            i = 6;
            j >>>= 28;
        } else {
            i = 2;
        }
        if ((-2097152 & j) != 0) {
            i += 2;
            j >>>= 14;
        }
        return (j & -16384) != 0 ? i + 1 : i;
    }

    public static int zzfp(long j) {
        return 8;
    }

    public static int zzfq(long j) {
        return 8;
    }

    private static long zzfr(long j) {
        return (j >> 63) ^ (j << 1);
    }

    public static int zzgf(int i) {
        if ((i & -128) == 0) {
            return 1;
        }
        if ((i & -16384) == 0) {
            return 2;
        }
        if ((-2097152 & i) == 0) {
            return 3;
        }
        return (i & -268435456) == 0 ? 4 : 5;
    }

    public static int zzgh(int i) {
        return 4;
    }

    public static int zzgi(int i) {
        return 4;
    }

    private static int zzgk(int i) {
        return (i >> 31) ^ (i << 1);
    }

    public static int zzh(float f) {
        return 4;
    }

    public abstract void flush() throws IOException;

    public abstract void write(byte[] bArr, int i, int i2) throws IOException;

    public abstract void zza(int i, zzdmr zzdmr) throws IOException;

    public abstract void zza(int i, zzdpk zzdpk) throws IOException;

    /* access modifiers changed from: package-private */
    public abstract void zza(int i, zzdpk zzdpk, zzdqb zzdqb) throws IOException;

    /* access modifiers changed from: package-private */
    public abstract void zza(zzdpk zzdpk, zzdqb zzdqb) throws IOException;

    public abstract void zzaa(int i, int i2) throws IOException;

    public abstract int zzawu();

    public abstract void zzb(int i, zzdmr zzdmr) throws IOException;

    public abstract void zzb(int i, zzdpk zzdpk) throws IOException;

    public abstract void zzcz(zzdmr zzdmr) throws IOException;

    public abstract void zzd(byte b) throws IOException;

    public abstract void zzf(int i, String str) throws IOException;

    public abstract void zzfj(long j) throws IOException;

    public abstract void zzfl(long j) throws IOException;

    public abstract void zzfz(int i) throws IOException;

    public abstract void zzga(int i) throws IOException;

    public abstract void zzgc(int i) throws IOException;

    public abstract void zzgw(String str) throws IOException;

    public abstract void zzh(int i, long j) throws IOException;

    public abstract void zzi(int i, boolean z) throws IOException;

    public abstract void zzj(int i, long j) throws IOException;

    public abstract void zzj(zzdpk zzdpk) throws IOException;

    /* access modifiers changed from: package-private */
    public abstract void zzk(byte[] bArr, int i, int i2) throws IOException;

    public abstract void zzw(int i, int i2) throws IOException;

    public abstract void zzx(int i, int i2) throws IOException;

    public abstract void zzy(int i, int i2) throws IOException;

    public static class zzc extends IOException {
        zzc() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        zzc(java.lang.String r3) {
            /*
                r2 = this;
                java.lang.String r0 = "CodedOutputStream was writing to a flat byte array and ran out of space.: "
                java.lang.String r0 = java.lang.String.valueOf(r0)
                java.lang.String r3 = java.lang.String.valueOf(r3)
                int r1 = r3.length()
                if (r1 == 0) goto L_0x0015
                java.lang.String r3 = r0.concat(r3)
                goto L_0x001a
            L_0x0015:
                java.lang.String r3 = new java.lang.String
                r3.<init>(r0)
            L_0x001a:
                r2.<init>(r3)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdni.zzc.<init>(java.lang.String):void");
        }

        zzc(Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.", th);
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        zzc(java.lang.String r3, java.lang.Throwable r4) {
            /*
                r2 = this;
                java.lang.String r0 = "CodedOutputStream was writing to a flat byte array and ran out of space.: "
                java.lang.String r0 = java.lang.String.valueOf(r0)
                java.lang.String r3 = java.lang.String.valueOf(r3)
                int r1 = r3.length()
                if (r1 == 0) goto L_0x0015
                java.lang.String r3 = r0.concat(r3)
                goto L_0x001a
            L_0x0015:
                java.lang.String r3 = new java.lang.String
                r3.<init>(r0)
            L_0x001a:
                r2.<init>(r3, r4)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdni.zzc.<init>(java.lang.String, java.lang.Throwable):void");
        }
    }

    public static zzdni zzm(ByteBuffer byteBuffer) {
        if (byteBuffer.hasArray()) {
            return new zzb(byteBuffer);
        }
        if (!byteBuffer.isDirect() || byteBuffer.isReadOnly()) {
            throw new IllegalArgumentException("ByteBuffer is read-only");
        } else if (zzdqz.zzbad()) {
            return new zze(byteBuffer);
        } else {
            return new zzd(byteBuffer);
        }
    }

    static final class zzd extends zzdni {
        private final ByteBuffer zzaxl;
        private final int zzhdq;
        private final ByteBuffer zzhdr;

        zzd(ByteBuffer byteBuffer) {
            super();
            this.zzhdr = byteBuffer;
            this.zzaxl = byteBuffer.duplicate().order(ByteOrder.LITTLE_ENDIAN);
            this.zzhdq = byteBuffer.position();
        }

        public final void zzw(int i, int i2) throws IOException {
            zzga((i << 3) | i2);
        }

        public final void zzx(int i, int i2) throws IOException {
            zzw(i, 0);
            zzfz(i2);
        }

        public final void zzy(int i, int i2) throws IOException {
            zzw(i, 0);
            zzga(i2);
        }

        public final void zzaa(int i, int i2) throws IOException {
            zzw(i, 5);
            zzgc(i2);
        }

        public final void zzh(int i, long j) throws IOException {
            zzw(i, 0);
            zzfj(j);
        }

        public final void zzj(int i, long j) throws IOException {
            zzw(i, 1);
            zzfl(j);
        }

        public final void zzi(int i, boolean z) throws IOException {
            zzw(i, 0);
            zzd(z ? (byte) 1 : 0);
        }

        public final void zzf(int i, String str) throws IOException {
            zzw(i, 2);
            zzgw(str);
        }

        public final void zza(int i, zzdmr zzdmr) throws IOException {
            zzw(i, 2);
            zzcz(zzdmr);
        }

        public final void zza(int i, zzdpk zzdpk) throws IOException {
            zzw(i, 2);
            zzj(zzdpk);
        }

        /* access modifiers changed from: package-private */
        public final void zza(int i, zzdpk zzdpk, zzdqb zzdqb) throws IOException {
            zzw(i, 2);
            zza(zzdpk, zzdqb);
        }

        public final void zzb(int i, zzdpk zzdpk) throws IOException {
            zzw(1, 3);
            zzy(2, i);
            zza(3, zzdpk);
            zzw(1, 4);
        }

        public final void zzb(int i, zzdmr zzdmr) throws IOException {
            zzw(1, 3);
            zzy(2, i);
            zza(3, zzdmr);
            zzw(1, 4);
        }

        public final void zzj(zzdpk zzdpk) throws IOException {
            zzga(zzdpk.zzaxj());
            zzdpk.zzb(this);
        }

        /* access modifiers changed from: package-private */
        public final void zza(zzdpk zzdpk, zzdqb zzdqb) throws IOException {
            zzdmi zzdmi = (zzdmi) zzdpk;
            int zzavg = zzdmi.zzavg();
            if (zzavg == -1) {
                zzavg = zzdqb.zzak(zzdmi);
                zzdmi.zzfi(zzavg);
            }
            zzga(zzavg);
            zzdqb.zza(zzdpk, this.zzhdo);
        }

        public final void zzd(byte b) throws IOException {
            try {
                this.zzaxl.put(b);
            } catch (BufferOverflowException e) {
                throw new zzc((Throwable) e);
            }
        }

        public final void zzcz(zzdmr zzdmr) throws IOException {
            zzga(zzdmr.size());
            zzdmr.zza((zzdmq) this);
        }

        public final void zzk(byte[] bArr, int i, int i2) throws IOException {
            zzga(i2);
            write(bArr, 0, i2);
        }

        public final void zzfz(int i) throws IOException {
            if (i >= 0) {
                zzga(i);
            } else {
                zzfj((long) i);
            }
        }

        public final void zzga(int i) throws IOException {
            while ((i & -128) != 0) {
                this.zzaxl.put((byte) ((i & 127) | 128));
                i >>>= 7;
            }
            try {
                this.zzaxl.put((byte) i);
            } catch (BufferOverflowException e) {
                throw new zzc((Throwable) e);
            }
        }

        public final void zzgc(int i) throws IOException {
            try {
                this.zzaxl.putInt(i);
            } catch (BufferOverflowException e) {
                throw new zzc((Throwable) e);
            }
        }

        public final void zzfj(long j) throws IOException {
            while ((-128 & j) != 0) {
                this.zzaxl.put((byte) ((((int) j) & 127) | 128));
                j >>>= 7;
            }
            try {
                this.zzaxl.put((byte) ((int) j));
            } catch (BufferOverflowException e) {
                throw new zzc((Throwable) e);
            }
        }

        public final void zzfl(long j) throws IOException {
            try {
                this.zzaxl.putLong(j);
            } catch (BufferOverflowException e) {
                throw new zzc((Throwable) e);
            }
        }

        public final void write(byte[] bArr, int i, int i2) throws IOException {
            try {
                this.zzaxl.put(bArr, i, i2);
            } catch (IndexOutOfBoundsException e) {
                throw new zzc((Throwable) e);
            } catch (BufferOverflowException e2) {
                throw new zzc((Throwable) e2);
            }
        }

        public final void zzh(byte[] bArr, int i, int i2) throws IOException {
            write(bArr, i, i2);
        }

        public final void zzgw(String str) throws IOException {
            int position = this.zzaxl.position();
            try {
                int zzgf = zzgf(str.length() * 3);
                int zzgf2 = zzgf(str.length());
                if (zzgf2 == zzgf) {
                    int position2 = this.zzaxl.position() + zzgf2;
                    this.zzaxl.position(position2);
                    zzgy(str);
                    int position3 = this.zzaxl.position();
                    this.zzaxl.position(position);
                    zzga(position3 - position2);
                    this.zzaxl.position(position3);
                    return;
                }
                zzga(zzdrb.zza(str));
                zzgy(str);
            } catch (zzdrf e) {
                this.zzaxl.position(position);
                zza(str, e);
            } catch (IllegalArgumentException e2) {
                throw new zzc((Throwable) e2);
            }
        }

        public final void flush() {
            this.zzhdr.position(this.zzaxl.position());
        }

        public final int zzawu() {
            return this.zzaxl.remaining();
        }

        private final void zzgy(String str) throws IOException {
            try {
                zzdrb.zza(str, this.zzaxl);
            } catch (IndexOutOfBoundsException e) {
                throw new zzc((Throwable) e);
            }
        }
    }

    static final class zze extends zzdni {
        private long zzahv = this.zzhdt;
        private final ByteBuffer zzaxl;
        private final ByteBuffer zzhdr;
        private final long zzhds;
        private final long zzhdt;
        private final long zzhdu;
        private final long zzhdv = (this.zzhdu - 10);

        zze(ByteBuffer byteBuffer) {
            super();
            this.zzhdr = byteBuffer;
            this.zzaxl = byteBuffer.duplicate().order(ByteOrder.LITTLE_ENDIAN);
            this.zzhds = zzdqz.zzn(byteBuffer);
            this.zzhdt = this.zzhds + ((long) byteBuffer.position());
            this.zzhdu = this.zzhds + ((long) byteBuffer.limit());
        }

        public final void zzw(int i, int i2) throws IOException {
            zzga((i << 3) | i2);
        }

        public final void zzx(int i, int i2) throws IOException {
            zzw(i, 0);
            zzfz(i2);
        }

        public final void zzy(int i, int i2) throws IOException {
            zzw(i, 0);
            zzga(i2);
        }

        public final void zzaa(int i, int i2) throws IOException {
            zzw(i, 5);
            zzgc(i2);
        }

        public final void zzh(int i, long j) throws IOException {
            zzw(i, 0);
            zzfj(j);
        }

        public final void zzj(int i, long j) throws IOException {
            zzw(i, 1);
            zzfl(j);
        }

        public final void zzi(int i, boolean z) throws IOException {
            zzw(i, 0);
            zzd(z ? (byte) 1 : 0);
        }

        public final void zzf(int i, String str) throws IOException {
            zzw(i, 2);
            zzgw(str);
        }

        public final void zza(int i, zzdmr zzdmr) throws IOException {
            zzw(i, 2);
            zzcz(zzdmr);
        }

        public final void zza(int i, zzdpk zzdpk) throws IOException {
            zzw(i, 2);
            zzj(zzdpk);
        }

        /* access modifiers changed from: package-private */
        public final void zza(int i, zzdpk zzdpk, zzdqb zzdqb) throws IOException {
            zzw(i, 2);
            zza(zzdpk, zzdqb);
        }

        public final void zzb(int i, zzdpk zzdpk) throws IOException {
            zzw(1, 3);
            zzy(2, i);
            zza(3, zzdpk);
            zzw(1, 4);
        }

        public final void zzb(int i, zzdmr zzdmr) throws IOException {
            zzw(1, 3);
            zzy(2, i);
            zza(3, zzdmr);
            zzw(1, 4);
        }

        public final void zzj(zzdpk zzdpk) throws IOException {
            zzga(zzdpk.zzaxj());
            zzdpk.zzb(this);
        }

        /* access modifiers changed from: package-private */
        public final void zza(zzdpk zzdpk, zzdqb zzdqb) throws IOException {
            zzdmi zzdmi = (zzdmi) zzdpk;
            int zzavg = zzdmi.zzavg();
            if (zzavg == -1) {
                zzavg = zzdqb.zzak(zzdmi);
                zzdmi.zzfi(zzavg);
            }
            zzga(zzavg);
            zzdqb.zza(zzdpk, this.zzhdo);
        }

        public final void zzd(byte b) throws IOException {
            if (this.zzahv < this.zzhdu) {
                long j = this.zzahv;
                this.zzahv = 1 + j;
                zzdqz.zza(j, b);
                return;
            }
            throw new zzc(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Long.valueOf(this.zzahv), Long.valueOf(this.zzhdu), 1}));
        }

        public final void zzcz(zzdmr zzdmr) throws IOException {
            zzga(zzdmr.size());
            zzdmr.zza((zzdmq) this);
        }

        public final void zzk(byte[] bArr, int i, int i2) throws IOException {
            zzga(i2);
            write(bArr, 0, i2);
        }

        public final void zzfz(int i) throws IOException {
            if (i >= 0) {
                zzga(i);
            } else {
                zzfj((long) i);
            }
        }

        public final void zzga(int i) throws IOException {
            if (this.zzahv <= this.zzhdv) {
                while ((i & -128) != 0) {
                    long j = this.zzahv;
                    this.zzahv = j + 1;
                    zzdqz.zza(j, (byte) ((i & 127) | 128));
                    i >>>= 7;
                }
                long j2 = this.zzahv;
                this.zzahv = 1 + j2;
                zzdqz.zza(j2, (byte) i);
                return;
            }
            while (this.zzahv < this.zzhdu) {
                if ((i & -128) == 0) {
                    long j3 = this.zzahv;
                    this.zzahv = 1 + j3;
                    zzdqz.zza(j3, (byte) i);
                    return;
                }
                long j4 = this.zzahv;
                this.zzahv = j4 + 1;
                zzdqz.zza(j4, (byte) ((i & 127) | 128));
                i >>>= 7;
            }
            throw new zzc(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Long.valueOf(this.zzahv), Long.valueOf(this.zzhdu), 1}));
        }

        public final void zzgc(int i) throws IOException {
            this.zzaxl.putInt((int) (this.zzahv - this.zzhds), i);
            this.zzahv += 4;
        }

        public final void zzfj(long j) throws IOException {
            if (this.zzahv <= this.zzhdv) {
                while ((j & -128) != 0) {
                    long j2 = this.zzahv;
                    this.zzahv = j2 + 1;
                    zzdqz.zza(j2, (byte) ((((int) j) & 127) | 128));
                    j >>>= 7;
                }
                long j3 = this.zzahv;
                this.zzahv = 1 + j3;
                zzdqz.zza(j3, (byte) ((int) j));
                return;
            }
            while (this.zzahv < this.zzhdu) {
                if ((j & -128) == 0) {
                    long j4 = this.zzahv;
                    this.zzahv = 1 + j4;
                    zzdqz.zza(j4, (byte) ((int) j));
                    return;
                }
                long j5 = this.zzahv;
                this.zzahv = j5 + 1;
                zzdqz.zza(j5, (byte) ((((int) j) & 127) | 128));
                j >>>= 7;
            }
            throw new zzc(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Long.valueOf(this.zzahv), Long.valueOf(this.zzhdu), 1}));
        }

        public final void zzfl(long j) throws IOException {
            this.zzaxl.putLong((int) (this.zzahv - this.zzhds), j);
            this.zzahv += 8;
        }

        public final void write(byte[] bArr, int i, int i2) throws IOException {
            if (bArr != null && i >= 0 && i2 >= 0 && bArr.length - i2 >= i) {
                long j = (long) i2;
                if (this.zzhdu - j >= this.zzahv) {
                    zzdqz.zza(bArr, (long) i, this.zzahv, j);
                    this.zzahv += j;
                    return;
                }
            }
            if (bArr == null) {
                throw new NullPointerException("value");
            }
            throw new zzc(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Long.valueOf(this.zzahv), Long.valueOf(this.zzhdu), Integer.valueOf(i2)}));
        }

        public final void zzh(byte[] bArr, int i, int i2) throws IOException {
            write(bArr, i, i2);
        }

        public final void zzgw(String str) throws IOException {
            long j = this.zzahv;
            try {
                int zzgf = zzgf(str.length() * 3);
                int zzgf2 = zzgf(str.length());
                if (zzgf2 == zzgf) {
                    int i = ((int) (this.zzahv - this.zzhds)) + zzgf2;
                    this.zzaxl.position(i);
                    zzdrb.zza(str, this.zzaxl);
                    int position = this.zzaxl.position() - i;
                    zzga(position);
                    this.zzahv += (long) position;
                    return;
                }
                int zza = zzdrb.zza(str);
                zzga(zza);
                zzfs(this.zzahv);
                zzdrb.zza(str, this.zzaxl);
                this.zzahv += (long) zza;
            } catch (zzdrf e) {
                this.zzahv = j;
                zzfs(this.zzahv);
                zza(str, e);
            } catch (IllegalArgumentException e2) {
                throw new zzc((Throwable) e2);
            } catch (IndexOutOfBoundsException e3) {
                throw new zzc((Throwable) e3);
            }
        }

        public final void flush() {
            this.zzhdr.position((int) (this.zzahv - this.zzhds));
        }

        public final int zzawu() {
            return (int) (this.zzhdu - this.zzahv);
        }

        private final void zzfs(long j) {
            this.zzaxl.position((int) (j - this.zzhds));
        }
    }

    static class zza extends zzdni {
        private final byte[] buffer;
        private final int limit;
        private final int offset;
        private int position;

        zza(byte[] bArr, int i, int i2) {
            super();
            if (bArr != null) {
                int i3 = i + i2;
                if ((i | i2 | (bArr.length - i3)) >= 0) {
                    this.buffer = bArr;
                    this.offset = i;
                    this.position = i;
                    this.limit = i3;
                    return;
                }
                throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", new Object[]{Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2)}));
            }
            throw new NullPointerException("buffer");
        }

        public void flush() {
        }

        public final void zzw(int i, int i2) throws IOException {
            zzga((i << 3) | i2);
        }

        public final void zzx(int i, int i2) throws IOException {
            zzw(i, 0);
            zzfz(i2);
        }

        public final void zzy(int i, int i2) throws IOException {
            zzw(i, 0);
            zzga(i2);
        }

        public final void zzaa(int i, int i2) throws IOException {
            zzw(i, 5);
            zzgc(i2);
        }

        public final void zzh(int i, long j) throws IOException {
            zzw(i, 0);
            zzfj(j);
        }

        public final void zzj(int i, long j) throws IOException {
            zzw(i, 1);
            zzfl(j);
        }

        public final void zzi(int i, boolean z) throws IOException {
            zzw(i, 0);
            zzd(z ? (byte) 1 : 0);
        }

        public final void zzf(int i, String str) throws IOException {
            zzw(i, 2);
            zzgw(str);
        }

        public final void zza(int i, zzdmr zzdmr) throws IOException {
            zzw(i, 2);
            zzcz(zzdmr);
        }

        public final void zzcz(zzdmr zzdmr) throws IOException {
            zzga(zzdmr.size());
            zzdmr.zza((zzdmq) this);
        }

        public final void zzk(byte[] bArr, int i, int i2) throws IOException {
            zzga(i2);
            write(bArr, 0, i2);
        }

        public final void zza(int i, zzdpk zzdpk) throws IOException {
            zzw(i, 2);
            zzj(zzdpk);
        }

        /* access modifiers changed from: package-private */
        public final void zza(int i, zzdpk zzdpk, zzdqb zzdqb) throws IOException {
            zzw(i, 2);
            zzdmi zzdmi = (zzdmi) zzdpk;
            int zzavg = zzdmi.zzavg();
            if (zzavg == -1) {
                zzavg = zzdqb.zzak(zzdmi);
                zzdmi.zzfi(zzavg);
            }
            zzga(zzavg);
            zzdqb.zza(zzdpk, this.zzhdo);
        }

        public final void zzb(int i, zzdpk zzdpk) throws IOException {
            zzw(1, 3);
            zzy(2, i);
            zza(3, zzdpk);
            zzw(1, 4);
        }

        public final void zzb(int i, zzdmr zzdmr) throws IOException {
            zzw(1, 3);
            zzy(2, i);
            zza(3, zzdmr);
            zzw(1, 4);
        }

        public final void zzj(zzdpk zzdpk) throws IOException {
            zzga(zzdpk.zzaxj());
            zzdpk.zzb(this);
        }

        /* access modifiers changed from: package-private */
        public final void zza(zzdpk zzdpk, zzdqb zzdqb) throws IOException {
            zzdmi zzdmi = (zzdmi) zzdpk;
            int zzavg = zzdmi.zzavg();
            if (zzavg == -1) {
                zzavg = zzdqb.zzak(zzdmi);
                zzdmi.zzfi(zzavg);
            }
            zzga(zzavg);
            zzdqb.zza(zzdpk, this.zzhdo);
        }

        public final void zzd(byte b) throws IOException {
            try {
                byte[] bArr = this.buffer;
                int i = this.position;
                this.position = i + 1;
                bArr[i] = b;
            } catch (IndexOutOfBoundsException e) {
                throw new zzc(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), 1}), e);
            }
        }

        public final void zzfz(int i) throws IOException {
            if (i >= 0) {
                zzga(i);
            } else {
                zzfj((long) i);
            }
        }

        public final void zzga(int i) throws IOException {
            if (!zzdni.zzhdn || zzawu() < 10) {
                while ((i & -128) != 0) {
                    byte[] bArr = this.buffer;
                    int i2 = this.position;
                    this.position = i2 + 1;
                    bArr[i2] = (byte) ((i & 127) | 128);
                    i >>>= 7;
                }
                try {
                    byte[] bArr2 = this.buffer;
                    int i3 = this.position;
                    this.position = i3 + 1;
                    bArr2[i3] = (byte) i;
                } catch (IndexOutOfBoundsException e) {
                    throw new zzc(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), 1}), e);
                }
            } else {
                while ((i & -128) != 0) {
                    byte[] bArr3 = this.buffer;
                    int i4 = this.position;
                    this.position = i4 + 1;
                    zzdqz.zza(bArr3, (long) i4, (byte) ((i & 127) | 128));
                    i >>>= 7;
                }
                byte[] bArr4 = this.buffer;
                int i5 = this.position;
                this.position = i5 + 1;
                zzdqz.zza(bArr4, (long) i5, (byte) i);
            }
        }

        public final void zzgc(int i) throws IOException {
            try {
                byte[] bArr = this.buffer;
                int i2 = this.position;
                this.position = i2 + 1;
                bArr[i2] = (byte) i;
                byte[] bArr2 = this.buffer;
                int i3 = this.position;
                this.position = i3 + 1;
                bArr2[i3] = (byte) (i >> 8);
                byte[] bArr3 = this.buffer;
                int i4 = this.position;
                this.position = i4 + 1;
                bArr3[i4] = (byte) (i >> 16);
                byte[] bArr4 = this.buffer;
                int i5 = this.position;
                this.position = i5 + 1;
                bArr4[i5] = (byte) (i >>> 24);
            } catch (IndexOutOfBoundsException e) {
                throw new zzc(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), 1}), e);
            }
        }

        public final void zzfj(long j) throws IOException {
            if (!zzdni.zzhdn || zzawu() < 10) {
                while ((j & -128) != 0) {
                    byte[] bArr = this.buffer;
                    int i = this.position;
                    this.position = i + 1;
                    bArr[i] = (byte) ((((int) j) & 127) | 128);
                    j >>>= 7;
                }
                try {
                    byte[] bArr2 = this.buffer;
                    int i2 = this.position;
                    this.position = i2 + 1;
                    bArr2[i2] = (byte) ((int) j);
                } catch (IndexOutOfBoundsException e) {
                    throw new zzc(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), 1}), e);
                }
            } else {
                while ((j & -128) != 0) {
                    byte[] bArr3 = this.buffer;
                    int i3 = this.position;
                    this.position = i3 + 1;
                    zzdqz.zza(bArr3, (long) i3, (byte) ((((int) j) & 127) | 128));
                    j >>>= 7;
                }
                byte[] bArr4 = this.buffer;
                int i4 = this.position;
                this.position = i4 + 1;
                zzdqz.zza(bArr4, (long) i4, (byte) ((int) j));
            }
        }

        public final void zzfl(long j) throws IOException {
            try {
                byte[] bArr = this.buffer;
                int i = this.position;
                this.position = i + 1;
                bArr[i] = (byte) ((int) j);
                byte[] bArr2 = this.buffer;
                int i2 = this.position;
                this.position = i2 + 1;
                bArr2[i2] = (byte) ((int) (j >> 8));
                byte[] bArr3 = this.buffer;
                int i3 = this.position;
                this.position = i3 + 1;
                bArr3[i3] = (byte) ((int) (j >> 16));
                byte[] bArr4 = this.buffer;
                int i4 = this.position;
                this.position = i4 + 1;
                bArr4[i4] = (byte) ((int) (j >> 24));
                byte[] bArr5 = this.buffer;
                int i5 = this.position;
                this.position = i5 + 1;
                bArr5[i5] = (byte) ((int) (j >> 32));
                byte[] bArr6 = this.buffer;
                int i6 = this.position;
                this.position = i6 + 1;
                bArr6[i6] = (byte) ((int) (j >> 40));
                byte[] bArr7 = this.buffer;
                int i7 = this.position;
                this.position = i7 + 1;
                bArr7[i7] = (byte) ((int) (j >> 48));
                byte[] bArr8 = this.buffer;
                int i8 = this.position;
                this.position = i8 + 1;
                bArr8[i8] = (byte) ((int) (j >> 56));
            } catch (IndexOutOfBoundsException e) {
                throw new zzc(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), 1}), e);
            }
        }

        public final void write(byte[] bArr, int i, int i2) throws IOException {
            try {
                System.arraycopy(bArr, i, this.buffer, this.position, i2);
                this.position += i2;
            } catch (IndexOutOfBoundsException e) {
                throw new zzc(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(i2)}), e);
            }
        }

        public final void zzh(byte[] bArr, int i, int i2) throws IOException {
            write(bArr, i, i2);
        }

        public final void zzgw(String str) throws IOException {
            int i = this.position;
            try {
                int zzgf = zzgf(str.length() * 3);
                int zzgf2 = zzgf(str.length());
                if (zzgf2 == zzgf) {
                    this.position = i + zzgf2;
                    int zza = zzdrb.zza(str, this.buffer, this.position, zzawu());
                    this.position = i;
                    zzga((zza - i) - zzgf2);
                    this.position = zza;
                    return;
                }
                zzga(zzdrb.zza(str));
                this.position = zzdrb.zza(str, this.buffer, this.position, zzawu());
            } catch (zzdrf e) {
                this.position = i;
                zza(str, e);
            } catch (IndexOutOfBoundsException e2) {
                throw new zzc((Throwable) e2);
            }
        }

        public final int zzawu() {
            return this.limit - this.position;
        }

        public final int zzawx() {
            return this.position - this.offset;
        }
    }

    private zzdni() {
    }

    public final void zzz(int i, int i2) throws IOException {
        zzy(i, zzgk(i2));
    }

    public final void zzi(int i, long j) throws IOException {
        zzh(i, zzfr(j));
    }

    public final void zza(int i, float f) throws IOException {
        zzaa(i, Float.floatToRawIntBits(f));
    }

    public final void zzb(int i, double d) throws IOException {
        zzj(i, Double.doubleToRawLongBits(d));
    }

    public final void zzgb(int i) throws IOException {
        zzga(zzgk(i));
    }

    public final void zzfk(long j) throws IOException {
        zzfj(zzfr(j));
    }

    public final void zzg(float f) throws IOException {
        zzgc(Float.floatToRawIntBits(f));
    }

    public final void zzb(double d) throws IOException {
        zzfl(Double.doubleToRawLongBits(d));
    }

    public final void zzbf(boolean z) throws IOException {
        zzd(z ? (byte) 1 : 0);
    }

    public static int zzab(int i, int i2) {
        return zzgd(i) + zzge(i2);
    }

    public static int zzac(int i, int i2) {
        return zzgd(i) + zzgf(i2);
    }

    public static int zzad(int i, int i2) {
        return zzgd(i) + zzgf(zzgk(i2));
    }

    public static int zzae(int i, int i2) {
        return zzgd(i) + 4;
    }

    public static int zzaf(int i, int i2) {
        return zzgd(i) + 4;
    }

    public static int zzk(int i, long j) {
        return zzgd(i) + zzfn(j);
    }

    public static int zzl(int i, long j) {
        return zzgd(i) + zzfn(j);
    }

    public static int zzm(int i, long j) {
        return zzgd(i) + zzfn(zzfr(j));
    }

    public static int zzn(int i, long j) {
        return zzgd(i) + 8;
    }

    public static int zzo(int i, long j) {
        return zzgd(i) + 8;
    }

    public static int zzb(int i, float f) {
        return zzgd(i) + 4;
    }

    public static int zzc(int i, double d) {
        return zzgd(i) + 8;
    }

    public static int zzj(int i, boolean z) {
        return zzgd(i) + 1;
    }

    public static int zzag(int i, int i2) {
        return zzgd(i) + zzge(i2);
    }

    public static int zzg(int i, String str) {
        return zzgd(i) + zzgx(str);
    }

    public static int zzc(int i, zzdmr zzdmr) {
        int zzgd = zzgd(i);
        int size = zzdmr.size();
        return zzgd + zzgf(size) + size;
    }

    public static int zza(int i, zzdor zzdor) {
        int zzgd = zzgd(i);
        int zzaxj = zzdor.zzaxj();
        return zzgd + zzgf(zzaxj) + zzaxj;
    }

    public static int zzc(int i, zzdpk zzdpk) {
        return zzgd(i) + zzk(zzdpk);
    }

    static int zzb(int i, zzdpk zzdpk, zzdqb zzdqb) {
        return zzgd(i) + zzb(zzdpk, zzdqb);
    }

    public static int zzd(int i, zzdpk zzdpk) {
        return (zzgd(1) << 1) + zzac(2, i) + zzc(3, zzdpk);
    }

    public static int zzd(int i, zzdmr zzdmr) {
        return (zzgd(1) << 1) + zzac(2, i) + zzc(3, zzdmr);
    }

    public static int zzb(int i, zzdor zzdor) {
        return (zzgd(1) << 1) + zzac(2, i) + zza(3, zzdor);
    }

    public static int zzgd(int i) {
        return zzgf(i << 3);
    }

    public static int zzge(int i) {
        if (i >= 0) {
            return zzgf(i);
        }
        return 10;
    }

    public static int zzgg(int i) {
        return zzgf(zzgk(i));
    }

    public static int zzfm(long j) {
        return zzfn(j);
    }

    public static int zzfo(long j) {
        return zzfn(zzfr(j));
    }

    public static int zzgj(int i) {
        return zzge(i);
    }

    public static int zzgx(String str) {
        int i;
        try {
            i = zzdrb.zza(str);
        } catch (zzdrf unused) {
            i = str.getBytes(zzdod.UTF_8).length;
        }
        return zzgf(i) + i;
    }

    public static int zza(zzdor zzdor) {
        int zzaxj = zzdor.zzaxj();
        return zzgf(zzaxj) + zzaxj;
    }

    public static int zzda(zzdmr zzdmr) {
        int size = zzdmr.size();
        return zzgf(size) + size;
    }

    public static int zzac(byte[] bArr) {
        int length = bArr.length;
        return zzgf(length) + length;
    }

    public static int zzk(zzdpk zzdpk) {
        int zzaxj = zzdpk.zzaxj();
        return zzgf(zzaxj) + zzaxj;
    }

    static int zzb(zzdpk zzdpk, zzdqb zzdqb) {
        zzdmi zzdmi = (zzdmi) zzdpk;
        int zzavg = zzdmi.zzavg();
        if (zzavg == -1) {
            zzavg = zzdqb.zzak(zzdmi);
            zzdmi.zzfi(zzavg);
        }
        return zzgf(zzavg) + zzavg;
    }

    public final void zzawv() {
        if (zzawu() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(String str, zzdrf zzdrf) throws IOException {
        logger.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", zzdrf);
        byte[] bytes = str.getBytes(zzdod.UTF_8);
        try {
            zzga(bytes.length);
            zzh(bytes, 0, bytes.length);
        } catch (IndexOutOfBoundsException e) {
            throw new zzc((Throwable) e);
        } catch (zzc e2) {
            throw e2;
        }
    }

    @Deprecated
    static int zzc(int i, zzdpk zzdpk, zzdqb zzdqb) {
        int zzgd = zzgd(i) << 1;
        zzdmi zzdmi = (zzdmi) zzdpk;
        int zzavg = zzdmi.zzavg();
        if (zzavg == -1) {
            zzavg = zzdqb.zzak(zzdmi);
            zzdmi.zzfi(zzavg);
        }
        return zzgd + zzavg;
    }

    @Deprecated
    public static int zzl(zzdpk zzdpk) {
        return zzdpk.zzaxj();
    }

    @Deprecated
    public static int zzgl(int i) {
        return zzgf(i);
    }
}
