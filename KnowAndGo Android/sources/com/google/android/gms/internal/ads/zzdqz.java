package com.google.android.gms.internal.ads;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import libcore.io.Memory;
import sun.misc.Unsafe;

final class zzdqz {
    private static final Logger logger = Logger.getLogger(zzdqz.class.getName());
    private static final Class<?> zzhcj = zzdmm.zzavm();
    private static final boolean zzhdn = zzbaf();
    private static final Unsafe zzhjp = zzbae();
    private static final boolean zzhlm = zzl(Long.TYPE);
    private static final boolean zzhln = zzl(Integer.TYPE);
    private static final zzd zzhlo;
    private static final boolean zzhlp = zzbag();
    /* access modifiers changed from: private */
    public static final long zzhlq = ((long) zzj(byte[].class));
    private static final long zzhlr = ((long) zzj(boolean[].class));
    private static final long zzhls = ((long) zzk(boolean[].class));
    private static final long zzhlt = ((long) zzj(int[].class));
    private static final long zzhlu = ((long) zzk(int[].class));
    private static final long zzhlv = ((long) zzj(long[].class));
    private static final long zzhlw = ((long) zzk(long[].class));
    private static final long zzhlx = ((long) zzj(float[].class));
    private static final long zzhly = ((long) zzk(float[].class));
    private static final long zzhlz = ((long) zzj(double[].class));
    private static final long zzhma = ((long) zzk(double[].class));
    private static final long zzhmb = ((long) zzj(Object[].class));
    private static final long zzhmc = ((long) zzk(Object[].class));
    private static final long zzhmd;
    /* access modifiers changed from: private */
    public static final boolean zzhme = (ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN);

    private zzdqz() {
    }

    static final class zzb extends zzd {
        zzb(Unsafe unsafe) {
            super(unsafe);
        }

        public final void zza(long j, byte b) {
            Memory.pokeByte(j, b);
        }

        public final byte zzy(Object obj, long j) {
            if (zzdqz.zzhme) {
                return zzdqz.zzq(obj, j);
            }
            return zzdqz.zzr(obj, j);
        }

        public final void zze(Object obj, long j, byte b) {
            if (zzdqz.zzhme) {
                zzdqz.zza(obj, j, b);
            } else {
                zzdqz.zzb(obj, j, b);
            }
        }

        public final boolean zzm(Object obj, long j) {
            if (zzdqz.zzhme) {
                return zzdqz.zzs(obj, j);
            }
            return zzdqz.zzt(obj, j);
        }

        public final void zza(Object obj, long j, boolean z) {
            if (zzdqz.zzhme) {
                zzdqz.zzb(obj, j, z);
            } else {
                zzdqz.zzc(obj, j, z);
            }
        }

        public final float zzn(Object obj, long j) {
            return Float.intBitsToFloat(zzk(obj, j));
        }

        public final void zza(Object obj, long j, float f) {
            zzb(obj, j, Float.floatToIntBits(f));
        }

        public final double zzo(Object obj, long j) {
            return Double.longBitsToDouble(zzl(obj, j));
        }

        public final void zza(Object obj, long j, double d) {
            zza(obj, j, Double.doubleToLongBits(d));
        }

        public final void zza(byte[] bArr, long j, long j2, long j3) {
            Memory.pokeByteArray(j2, bArr, (int) j, (int) j3);
        }
    }

    static final class zzc extends zzd {
        zzc(Unsafe unsafe) {
            super(unsafe);
        }

        public final void zza(long j, byte b) {
            this.zzhmf.putByte(j, b);
        }

        public final byte zzy(Object obj, long j) {
            return this.zzhmf.getByte(obj, j);
        }

        public final void zze(Object obj, long j, byte b) {
            this.zzhmf.putByte(obj, j, b);
        }

        public final boolean zzm(Object obj, long j) {
            return this.zzhmf.getBoolean(obj, j);
        }

        public final void zza(Object obj, long j, boolean z) {
            this.zzhmf.putBoolean(obj, j, z);
        }

        public final float zzn(Object obj, long j) {
            return this.zzhmf.getFloat(obj, j);
        }

        public final void zza(Object obj, long j, float f) {
            this.zzhmf.putFloat(obj, j, f);
        }

        public final double zzo(Object obj, long j) {
            return this.zzhmf.getDouble(obj, j);
        }

        public final void zza(Object obj, long j, double d) {
            this.zzhmf.putDouble(obj, j, d);
        }

        public final void zza(byte[] bArr, long j, long j2, long j3) {
            this.zzhmf.copyMemory(bArr, zzdqz.zzhlq + j, (Object) null, j2, j3);
        }
    }

    static boolean zzbac() {
        return zzhdn;
    }

    static abstract class zzd {
        Unsafe zzhmf;

        zzd(Unsafe unsafe) {
            this.zzhmf = unsafe;
        }

        public abstract void zza(long j, byte b);

        public abstract void zza(Object obj, long j, double d);

        public abstract void zza(Object obj, long j, float f);

        public abstract void zza(Object obj, long j, boolean z);

        public abstract void zza(byte[] bArr, long j, long j2, long j3);

        public abstract void zze(Object obj, long j, byte b);

        public abstract boolean zzm(Object obj, long j);

        public abstract float zzn(Object obj, long j);

        public abstract double zzo(Object obj, long j);

        public abstract byte zzy(Object obj, long j);

        public final int zzk(Object obj, long j) {
            return this.zzhmf.getInt(obj, j);
        }

        public final void zzb(Object obj, long j, int i) {
            this.zzhmf.putInt(obj, j, i);
        }

        public final long zzl(Object obj, long j) {
            return this.zzhmf.getLong(obj, j);
        }

        public final void zza(Object obj, long j, long j2) {
            this.zzhmf.putLong(obj, j, j2);
        }
    }

    static boolean zzbad() {
        return zzhlp;
    }

    static final class zza extends zzd {
        zza(Unsafe unsafe) {
            super(unsafe);
        }

        public final void zza(long j, byte b) {
            Memory.pokeByte((int) (j & -1), b);
        }

        public final byte zzy(Object obj, long j) {
            if (zzdqz.zzhme) {
                return zzdqz.zzq(obj, j);
            }
            return zzdqz.zzr(obj, j);
        }

        public final void zze(Object obj, long j, byte b) {
            if (zzdqz.zzhme) {
                zzdqz.zza(obj, j, b);
            } else {
                zzdqz.zzb(obj, j, b);
            }
        }

        public final boolean zzm(Object obj, long j) {
            if (zzdqz.zzhme) {
                return zzdqz.zzs(obj, j);
            }
            return zzdqz.zzt(obj, j);
        }

        public final void zza(Object obj, long j, boolean z) {
            if (zzdqz.zzhme) {
                zzdqz.zzb(obj, j, z);
            } else {
                zzdqz.zzc(obj, j, z);
            }
        }

        public final float zzn(Object obj, long j) {
            return Float.intBitsToFloat(zzk(obj, j));
        }

        public final void zza(Object obj, long j, float f) {
            zzb(obj, j, Float.floatToIntBits(f));
        }

        public final double zzo(Object obj, long j) {
            return Double.longBitsToDouble(zzl(obj, j));
        }

        public final void zza(Object obj, long j, double d) {
            zza(obj, j, Double.doubleToLongBits(d));
        }

        public final void zza(byte[] bArr, long j, long j2, long j3) {
            Memory.pokeByteArray((int) (j2 & -1), bArr, (int) j, (int) j3);
        }
    }

    static <T> T zzi(Class<T> cls) {
        try {
            return zzhjp.allocateInstance(cls);
        } catch (InstantiationException e) {
            throw new IllegalStateException(e);
        }
    }

    private static int zzj(Class<?> cls) {
        if (zzhdn) {
            return zzhlo.zzhmf.arrayBaseOffset(cls);
        }
        return -1;
    }

    private static int zzk(Class<?> cls) {
        if (zzhdn) {
            return zzhlo.zzhmf.arrayIndexScale(cls);
        }
        return -1;
    }

    static int zzk(Object obj, long j) {
        return zzhlo.zzk(obj, j);
    }

    static void zzb(Object obj, long j, int i) {
        zzhlo.zzb(obj, j, i);
    }

    static long zzl(Object obj, long j) {
        return zzhlo.zzl(obj, j);
    }

    static void zza(Object obj, long j, long j2) {
        zzhlo.zza(obj, j, j2);
    }

    static boolean zzm(Object obj, long j) {
        return zzhlo.zzm(obj, j);
    }

    static void zza(Object obj, long j, boolean z) {
        zzhlo.zza(obj, j, z);
    }

    static float zzn(Object obj, long j) {
        return zzhlo.zzn(obj, j);
    }

    static void zza(Object obj, long j, float f) {
        zzhlo.zza(obj, j, f);
    }

    static double zzo(Object obj, long j) {
        return zzhlo.zzo(obj, j);
    }

    static void zza(Object obj, long j, double d) {
        zzhlo.zza(obj, j, d);
    }

    static Object zzp(Object obj, long j) {
        return zzhlo.zzhmf.getObject(obj, j);
    }

    static void zza(Object obj, long j, Object obj2) {
        zzhlo.zzhmf.putObject(obj, j, obj2);
    }

    static byte zza(byte[] bArr, long j) {
        return zzhlo.zzy(bArr, zzhlq + j);
    }

    static void zza(byte[] bArr, long j, byte b) {
        zzhlo.zze(bArr, zzhlq + j, b);
    }

    static void zza(byte[] bArr, long j, long j2, long j3) {
        zzhlo.zza(bArr, j, j2, j3);
    }

    static void zza(long j, byte b) {
        zzhlo.zza(j, b);
    }

    static long zzn(ByteBuffer byteBuffer) {
        return zzhlo.zzl(byteBuffer, zzhmd);
    }

    static Unsafe zzbae() {
        try {
            return (Unsafe) AccessController.doPrivileged(new zzdra());
        } catch (Throwable unused) {
            return null;
        }
    }

    private static boolean zzbaf() {
        if (zzhjp == null) {
            return false;
        }
        try {
            Class<?> cls = zzhjp.getClass();
            cls.getMethod("objectFieldOffset", new Class[]{Field.class});
            cls.getMethod("arrayBaseOffset", new Class[]{Class.class});
            cls.getMethod("arrayIndexScale", new Class[]{Class.class});
            cls.getMethod("getInt", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putInt", new Class[]{Object.class, Long.TYPE, Integer.TYPE});
            cls.getMethod("getLong", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putLong", new Class[]{Object.class, Long.TYPE, Long.TYPE});
            cls.getMethod("getObject", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putObject", new Class[]{Object.class, Long.TYPE, Object.class});
            if (zzdmm.zzavl()) {
                return true;
            }
            cls.getMethod("getByte", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putByte", new Class[]{Object.class, Long.TYPE, Byte.TYPE});
            cls.getMethod("getBoolean", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putBoolean", new Class[]{Object.class, Long.TYPE, Boolean.TYPE});
            cls.getMethod("getFloat", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putFloat", new Class[]{Object.class, Long.TYPE, Float.TYPE});
            cls.getMethod("getDouble", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putDouble", new Class[]{Object.class, Long.TYPE, Double.TYPE});
            return true;
        } catch (Throwable th) {
            Logger logger2 = logger;
            Level level = Level.WARNING;
            String valueOf = String.valueOf(th);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 71);
            sb.append("platform method missing - proto runtime falling back to safer methods: ");
            sb.append(valueOf);
            logger2.logp(level, "com.google.protobuf.UnsafeUtil", "supportsUnsafeArrayOperations", sb.toString());
            return false;
        }
    }

    private static boolean zzbag() {
        if (zzhjp == null) {
            return false;
        }
        try {
            Class<?> cls = zzhjp.getClass();
            cls.getMethod("objectFieldOffset", new Class[]{Field.class});
            cls.getMethod("getLong", new Class[]{Object.class, Long.TYPE});
            if (zzbah() == null) {
                return false;
            }
            if (zzdmm.zzavl()) {
                return true;
            }
            cls.getMethod("getByte", new Class[]{Long.TYPE});
            cls.getMethod("putByte", new Class[]{Long.TYPE, Byte.TYPE});
            cls.getMethod("getInt", new Class[]{Long.TYPE});
            cls.getMethod("putInt", new Class[]{Long.TYPE, Integer.TYPE});
            cls.getMethod("getLong", new Class[]{Long.TYPE});
            cls.getMethod("putLong", new Class[]{Long.TYPE, Long.TYPE});
            cls.getMethod("copyMemory", new Class[]{Long.TYPE, Long.TYPE, Long.TYPE});
            cls.getMethod("copyMemory", new Class[]{Object.class, Long.TYPE, Object.class, Long.TYPE, Long.TYPE});
            return true;
        } catch (Throwable th) {
            Logger logger2 = logger;
            Level level = Level.WARNING;
            String valueOf = String.valueOf(th);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 71);
            sb.append("platform method missing - proto runtime falling back to safer methods: ");
            sb.append(valueOf);
            logger2.logp(level, "com.google.protobuf.UnsafeUtil", "supportsUnsafeByteBufferOperations", sb.toString());
            return false;
        }
    }

    private static boolean zzl(Class<?> cls) {
        if (!zzdmm.zzavl()) {
            return false;
        }
        try {
            Class<?> cls2 = zzhcj;
            cls2.getMethod("peekLong", new Class[]{cls, Boolean.TYPE});
            cls2.getMethod("pokeLong", new Class[]{cls, Long.TYPE, Boolean.TYPE});
            cls2.getMethod("pokeInt", new Class[]{cls, Integer.TYPE, Boolean.TYPE});
            cls2.getMethod("peekInt", new Class[]{cls, Boolean.TYPE});
            cls2.getMethod("pokeByte", new Class[]{cls, Byte.TYPE});
            cls2.getMethod("peekByte", new Class[]{cls});
            cls2.getMethod("pokeByteArray", new Class[]{cls, byte[].class, Integer.TYPE, Integer.TYPE});
            cls2.getMethod("peekByteArray", new Class[]{cls, byte[].class, Integer.TYPE, Integer.TYPE});
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    private static Field zzbah() {
        Field zzb2;
        if (zzdmm.zzavl() && (zzb2 = zzb(Buffer.class, "effectiveDirectAddress")) != null) {
            return zzb2;
        }
        Field zzb3 = zzb(Buffer.class, "address");
        if (zzb3 == null || zzb3.getType() != Long.TYPE) {
            return null;
        }
        return zzb3;
    }

    private static Field zzb(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* access modifiers changed from: private */
    public static byte zzq(Object obj, long j) {
        return (byte) (zzk(obj, -4 & j) >>> ((int) (((~j) & 3) << 3)));
    }

    /* access modifiers changed from: private */
    public static byte zzr(Object obj, long j) {
        return (byte) (zzk(obj, -4 & j) >>> ((int) ((j & 3) << 3)));
    }

    /* access modifiers changed from: private */
    public static void zza(Object obj, long j, byte b) {
        long j2 = -4 & j;
        int zzk = zzk(obj, j2);
        int i = ((~((int) j)) & 3) << 3;
        zzb(obj, j2, ((255 & b) << i) | (zzk & (~(255 << i))));
    }

    /* access modifiers changed from: private */
    public static void zzb(Object obj, long j, byte b) {
        long j2 = -4 & j;
        int i = (((int) j) & 3) << 3;
        zzb(obj, j2, ((255 & b) << i) | (zzk(obj, j2) & (~(255 << i))));
    }

    /* access modifiers changed from: private */
    public static boolean zzs(Object obj, long j) {
        return zzq(obj, j) != 0;
    }

    /* access modifiers changed from: private */
    public static boolean zzt(Object obj, long j) {
        return zzr(obj, j) != 0;
    }

    /* access modifiers changed from: private */
    public static void zzb(Object obj, long j, boolean z) {
        zza(obj, j, z ? (byte) 1 : 0);
    }

    /* access modifiers changed from: private */
    public static void zzc(Object obj, long j, boolean z) {
        zzb(obj, j, z ? (byte) 1 : 0);
    }

    static {
        zzd zzd2 = null;
        if (zzhjp != null) {
            if (!zzdmm.zzavl()) {
                zzd2 = new zzc(zzhjp);
            } else if (zzhlm) {
                zzd2 = new zzb(zzhjp);
            } else if (zzhln) {
                zzd2 = new zza(zzhjp);
            }
        }
        zzhlo = zzd2;
        Field zzbah = zzbah();
        zzhmd = (zzbah == null || zzhlo == null) ? -1 : zzhlo.zzhmf.objectFieldOffset(zzbah);
    }
}
