package com.google.android.gms.internal.vision;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.0.0 */
final class zzjp {
    private static final Logger logger = Logger.getLogger(zzjp.class.getName());
    private static final boolean zzaap = zzk(Long.TYPE);
    private static final boolean zzaaq = zzk(Integer.TYPE);
    private static final zzd zzaar;
    private static final boolean zzaas = zzin();
    private static final long zzaat = ((long) zzi(byte[].class));
    private static final long zzaau = ((long) zzi(boolean[].class));
    private static final long zzaav = ((long) zzj(boolean[].class));
    private static final long zzaaw = ((long) zzi(int[].class));
    private static final long zzaax = ((long) zzj(int[].class));
    private static final long zzaay = ((long) zzi(long[].class));
    private static final long zzaaz = ((long) zzj(long[].class));
    private static final long zzaba = ((long) zzi(float[].class));
    private static final long zzabb = ((long) zzj(float[].class));
    private static final long zzabc = ((long) zzi(double[].class));
    private static final long zzabd = ((long) zzj(double[].class));
    private static final long zzabe = ((long) zzi(Object[].class));
    private static final long zzabf = ((long) zzj(Object[].class));
    private static final long zzabg;
    private static final int zzabh = ((int) (zzaat & 7));
    static final boolean zzabi = (ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN);
    private static final Class<?> zzrm = zzfa.zzds();
    private static final boolean zzsr = zzim();
    private static final Unsafe zzyt = zzil();

    private zzjp() {
    }

    /* compiled from: com.google.android.gms:play-services-vision-common@@19.0.0 */
    static final class zza extends zzd {
        zza(Unsafe unsafe) {
            super(unsafe);
        }

        public final byte zzy(Object obj, long j) {
            if (zzjp.zzabi) {
                return zzjp.zzq(obj, j);
            }
            return zzjp.zzr(obj, j);
        }

        public final void zze(Object obj, long j, byte b) {
            if (zzjp.zzabi) {
                zzjp.zza(obj, j, b);
            } else {
                zzjp.zzb(obj, j, b);
            }
        }

        public final boolean zzm(Object obj, long j) {
            if (zzjp.zzabi) {
                return zzjp.zzs(obj, j);
            }
            return zzjp.zzt(obj, j);
        }

        public final void zza(Object obj, long j, boolean z) {
            if (zzjp.zzabi) {
                zzjp.zzb(obj, j, z);
            } else {
                zzjp.zzc(obj, j, z);
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
    }

    /* compiled from: com.google.android.gms:play-services-vision-common@@19.0.0 */
    static final class zzb extends zzd {
        zzb(Unsafe unsafe) {
            super(unsafe);
        }

        public final byte zzy(Object obj, long j) {
            return this.zzabl.getByte(obj, j);
        }

        public final void zze(Object obj, long j, byte b) {
            this.zzabl.putByte(obj, j, b);
        }

        public final boolean zzm(Object obj, long j) {
            return this.zzabl.getBoolean(obj, j);
        }

        public final void zza(Object obj, long j, boolean z) {
            this.zzabl.putBoolean(obj, j, z);
        }

        public final float zzn(Object obj, long j) {
            return this.zzabl.getFloat(obj, j);
        }

        public final void zza(Object obj, long j, float f) {
            this.zzabl.putFloat(obj, j, f);
        }

        public final double zzo(Object obj, long j) {
            return this.zzabl.getDouble(obj, j);
        }

        public final void zza(Object obj, long j, double d) {
            this.zzabl.putDouble(obj, j, d);
        }
    }

    /* compiled from: com.google.android.gms:play-services-vision-common@@19.0.0 */
    static final class zzc extends zzd {
        zzc(Unsafe unsafe) {
            super(unsafe);
        }

        public final byte zzy(Object obj, long j) {
            if (zzjp.zzabi) {
                return zzjp.zzq(obj, j);
            }
            return zzjp.zzr(obj, j);
        }

        public final void zze(Object obj, long j, byte b) {
            if (zzjp.zzabi) {
                zzjp.zza(obj, j, b);
            } else {
                zzjp.zzb(obj, j, b);
            }
        }

        public final boolean zzm(Object obj, long j) {
            if (zzjp.zzabi) {
                return zzjp.zzs(obj, j);
            }
            return zzjp.zzt(obj, j);
        }

        public final void zza(Object obj, long j, boolean z) {
            if (zzjp.zzabi) {
                zzjp.zzb(obj, j, z);
            } else {
                zzjp.zzc(obj, j, z);
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
    }

    static boolean zzij() {
        return zzsr;
    }

    /* compiled from: com.google.android.gms:play-services-vision-common@@19.0.0 */
    static abstract class zzd {
        Unsafe zzabl;

        zzd(Unsafe unsafe) {
            this.zzabl = unsafe;
        }

        public abstract void zza(Object obj, long j, double d);

        public abstract void zza(Object obj, long j, float f);

        public abstract void zza(Object obj, long j, boolean z);

        public abstract void zze(Object obj, long j, byte b);

        public abstract boolean zzm(Object obj, long j);

        public abstract float zzn(Object obj, long j);

        public abstract double zzo(Object obj, long j);

        public abstract byte zzy(Object obj, long j);

        public final int zzk(Object obj, long j) {
            return this.zzabl.getInt(obj, j);
        }

        public final void zzb(Object obj, long j, int i) {
            this.zzabl.putInt(obj, j, i);
        }

        public final long zzl(Object obj, long j) {
            return this.zzabl.getLong(obj, j);
        }

        public final void zza(Object obj, long j, long j2) {
            this.zzabl.putLong(obj, j, j2);
        }
    }

    static boolean zzik() {
        return zzaas;
    }

    static <T> T zzh(Class<T> cls) {
        try {
            return zzyt.allocateInstance(cls);
        } catch (InstantiationException e) {
            throw new IllegalStateException(e);
        }
    }

    private static int zzi(Class<?> cls) {
        if (zzsr) {
            return zzaar.zzabl.arrayBaseOffset(cls);
        }
        return -1;
    }

    private static int zzj(Class<?> cls) {
        if (zzsr) {
            return zzaar.zzabl.arrayIndexScale(cls);
        }
        return -1;
    }

    static int zzk(Object obj, long j) {
        return zzaar.zzk(obj, j);
    }

    static void zzb(Object obj, long j, int i) {
        zzaar.zzb(obj, j, i);
    }

    static long zzl(Object obj, long j) {
        return zzaar.zzl(obj, j);
    }

    static void zza(Object obj, long j, long j2) {
        zzaar.zza(obj, j, j2);
    }

    static boolean zzm(Object obj, long j) {
        return zzaar.zzm(obj, j);
    }

    static void zza(Object obj, long j, boolean z) {
        zzaar.zza(obj, j, z);
    }

    static float zzn(Object obj, long j) {
        return zzaar.zzn(obj, j);
    }

    static void zza(Object obj, long j, float f) {
        zzaar.zza(obj, j, f);
    }

    static double zzo(Object obj, long j) {
        return zzaar.zzo(obj, j);
    }

    static void zza(Object obj, long j, double d) {
        zzaar.zza(obj, j, d);
    }

    static Object zzp(Object obj, long j) {
        return zzaar.zzabl.getObject(obj, j);
    }

    static void zza(Object obj, long j, Object obj2) {
        zzaar.zzabl.putObject(obj, j, obj2);
    }

    static byte zza(byte[] bArr, long j) {
        return zzaar.zzy(bArr, zzaat + j);
    }

    static void zza(byte[] bArr, long j, byte b) {
        zzaar.zze(bArr, zzaat + j, b);
    }

    static Unsafe zzil() {
        try {
            return (Unsafe) AccessController.doPrivileged(new zzjr());
        } catch (Throwable unused) {
            return null;
        }
    }

    private static boolean zzim() {
        if (zzyt == null) {
            return false;
        }
        try {
            Class<?> cls = zzyt.getClass();
            cls.getMethod("objectFieldOffset", new Class[]{Field.class});
            cls.getMethod("arrayBaseOffset", new Class[]{Class.class});
            cls.getMethod("arrayIndexScale", new Class[]{Class.class});
            cls.getMethod("getInt", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putInt", new Class[]{Object.class, Long.TYPE, Integer.TYPE});
            cls.getMethod("getLong", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putLong", new Class[]{Object.class, Long.TYPE, Long.TYPE});
            cls.getMethod("getObject", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putObject", new Class[]{Object.class, Long.TYPE, Object.class});
            if (zzfa.zzdr()) {
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

    private static boolean zzin() {
        if (zzyt == null) {
            return false;
        }
        try {
            Class<?> cls = zzyt.getClass();
            cls.getMethod("objectFieldOffset", new Class[]{Field.class});
            cls.getMethod("getLong", new Class[]{Object.class, Long.TYPE});
            if (zzio() == null) {
                return false;
            }
            if (zzfa.zzdr()) {
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

    private static boolean zzk(Class<?> cls) {
        if (!zzfa.zzdr()) {
            return false;
        }
        try {
            Class<?> cls2 = zzrm;
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

    private static Field zzio() {
        Field zzb2;
        if (zzfa.zzdr() && (zzb2 = zzb(Buffer.class, "effectiveDirectAddress")) != null) {
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
        if (zzyt != null) {
            if (!zzfa.zzdr()) {
                zzd2 = new zzb(zzyt);
            } else if (zzaap) {
                zzd2 = new zzc(zzyt);
            } else if (zzaaq) {
                zzd2 = new zza(zzyt);
            }
        }
        zzaar = zzd2;
        Field zzio = zzio();
        zzabg = (zzio == null || zzaar == null) ? -1 : zzaar.zzabl.objectFieldOffset(zzio);
    }
}
