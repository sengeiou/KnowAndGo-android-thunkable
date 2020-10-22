package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdob;
import com.google.android.gms.internal.ads.zzdob.zza;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class zzdob<MessageType extends zzdob<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> extends zzdmi<MessageType, BuilderType> {
    private static Map<Object, zzdob<?, ?>> zzhhf = new ConcurrentHashMap();
    protected zzdqu zzhhd = zzdqu.zzazz();
    private int zzhhe = -1;

    public static class zzb<T extends zzdob<T, ?>> extends zzdmk<T> {
        private final T zzhhg;

        public zzb(T t) {
            this.zzhhg = t;
        }
    }

    public static abstract class zzc<MessageType extends zzc<MessageType, BuilderType>, BuilderType> extends zzdob<MessageType, BuilderType> implements zzdpm {
        protected zzdns<Object> zzhhj = zzdns.zzaxi();
    }

    public static class zzd<ContainingType extends zzdpk, Type> extends zzdnm<ContainingType, Type> {
    }

    /* 'enum' modifier removed */
    public static final class zze {
        public static final int zzhhk = 1;
        public static final int zzhhl = 2;
        public static final int zzhhm = 3;
        public static final int zzhhn = 4;
        public static final int zzhho = 5;
        public static final int zzhhp = 6;
        public static final int zzhhq = 7;
        private static final /* synthetic */ int[] zzhhr = {zzhhk, zzhhl, zzhhm, zzhhn, zzhho, zzhhp, zzhhq};
        public static final int zzhhs = 1;
        public static final int zzhht = 2;
        private static final /* synthetic */ int[] zzhhu = {zzhhs, zzhht};
        public static final int zzhhv = 1;
        public static final int zzhhw = 2;
        private static final /* synthetic */ int[] zzhhx = {zzhhv, zzhhw};

        public static int[] zzayb() {
            return (int[]) zzhhr.clone();
        }
    }

    /* access modifiers changed from: protected */
    public abstract Object zza(int i, Object obj, Object obj2);

    public String toString() {
        return zzdpn.zza(this, super.toString());
    }

    public int hashCode() {
        if (this.zzhcf != 0) {
            return this.zzhcf;
        }
        this.zzhcf = zzdpx.zzazg().zzan(this).hashCode(this);
        return this.zzhcf;
    }

    public static abstract class zza<MessageType extends zzdob<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> extends zzdmj<MessageType, BuilderType> {
        private final MessageType zzhhg;
        protected MessageType zzhhh;
        private boolean zzhhi = false;

        protected zza(MessageType messagetype) {
            this.zzhhg = messagetype;
            this.zzhhh = (zzdob) messagetype.zza(zze.zzhhn, (Object) null, (Object) null);
        }

        /* access modifiers changed from: protected */
        public final void zzaxw() {
            if (this.zzhhi) {
                MessageType messagetype = (zzdob) this.zzhhh.zza(zze.zzhhn, (Object) null, (Object) null);
                zza(messagetype, this.zzhhh);
                this.zzhhh = messagetype;
                this.zzhhi = false;
            }
        }

        public final boolean isInitialized() {
            return zzdob.zza(this.zzhhh, false);
        }

        /* renamed from: zzaxx */
        public MessageType zzaxz() {
            if (this.zzhhi) {
                return this.zzhhh;
            }
            MessageType messagetype = this.zzhhh;
            zzdpx.zzazg().zzan(messagetype).zzaa(messagetype);
            this.zzhhi = true;
            return this.zzhhh;
        }

        /* renamed from: zzaxy */
        public final MessageType zzaya() {
            MessageType messagetype = (zzdob) zzaxz();
            boolean booleanValue = Boolean.TRUE.booleanValue();
            byte byteValue = ((Byte) messagetype.zza(zze.zzhhk, (Object) null, (Object) null)).byteValue();
            boolean z = true;
            if (byteValue != 1) {
                if (byteValue == 0) {
                    z = false;
                } else {
                    z = zzdpx.zzazg().zzan(messagetype).zzam(messagetype);
                    if (booleanValue) {
                        messagetype.zza(zze.zzhhl, (Object) z ? messagetype : null, (Object) null);
                    }
                }
            }
            if (z) {
                return messagetype;
            }
            throw new zzdqs(messagetype);
        }

        public final BuilderType zza(MessageType messagetype) {
            zzaxw();
            zza(this.zzhhh, messagetype);
            return this;
        }

        private static void zza(MessageType messagetype, MessageType messagetype2) {
            zzdpx.zzazg().zzan(messagetype).zzd(messagetype, messagetype2);
        }

        private final BuilderType zzb(byte[] bArr, int i, int i2, zzdno zzdno) throws zzdok {
            zzaxw();
            try {
                zzdpx.zzazg().zzan(this.zzhhh).zza(this.zzhhh, bArr, 0, i2 + 0, new zzdmo(zzdno));
                return this;
            } catch (zzdok e) {
                throw e;
            } catch (IndexOutOfBoundsException unused) {
                throw zzdok.zzayd();
            } catch (IOException e2) {
                throw new RuntimeException("Reading from byte array should not throw IOException.", e2);
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: zzb */
        public final BuilderType zza(zzdnd zzdnd, zzdno zzdno) throws IOException {
            zzaxw();
            try {
                zzdpx.zzazg().zzan(this.zzhhh).zza(this.zzhhh, zzdng.zza(zzdnd), zzdno);
                return this;
            } catch (RuntimeException e) {
                if (e.getCause() instanceof IOException) {
                    throw ((IOException) e.getCause());
                }
                throw e;
            }
        }

        public final /* synthetic */ zzdmj zza(byte[] bArr, int i, int i2, zzdno zzdno) throws zzdok {
            return zzb(bArr, 0, i2, zzdno);
        }

        public final /* synthetic */ zzdmj zzavh() {
            return (zza) clone();
        }

        public final /* synthetic */ zzdpk zzaxv() {
            return this.zzhhg;
        }

        public /* synthetic */ Object clone() throws CloneNotSupportedException {
            zza zza = (zza) ((zzdob) this.zzhhg).zza(zze.zzhho, (Object) null, (Object) null);
            zza.zza((zzdob) zzaxz());
            return zza;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!((zzdob) zza(zze.zzhhp, (Object) null, (Object) null)).getClass().isInstance(obj)) {
            return false;
        }
        return zzdpx.zzazg().zzan(this).equals(this, (zzdob) obj);
    }

    public final boolean isInitialized() {
        boolean booleanValue = Boolean.TRUE.booleanValue();
        byte byteValue = ((Byte) zza(zze.zzhhk, (Object) null, (Object) null)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean zzam = zzdpx.zzazg().zzan(this).zzam(this);
        if (booleanValue) {
            zza(zze.zzhhl, (Object) zzam ? this : null, (Object) null);
        }
        return zzam;
    }

    /* access modifiers changed from: package-private */
    public final int zzavg() {
        return this.zzhhe;
    }

    /* access modifiers changed from: package-private */
    public final void zzfi(int i) {
        this.zzhhe = i;
    }

    public final void zzb(zzdni zzdni) throws IOException {
        zzdpx.zzazg().zzg(getClass()).zza(this, zzdnk.zza(zzdni));
    }

    public final int zzaxj() {
        if (this.zzhhe == -1) {
            this.zzhhe = zzdpx.zzazg().zzan(this).zzak(this);
        }
        return this.zzhhe;
    }

    static <T extends zzdob<?, ?>> T zze(Class<T> cls) {
        T t = (zzdob) zzhhf.get(cls);
        if (t == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                t = (zzdob) zzhhf.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (t == null) {
            t = (zzdob) ((zzdob) zzdqz.zzi(cls)).zza(zze.zzhhp, (Object) null, (Object) null);
            if (t != null) {
                zzhhf.put(cls, t);
            } else {
                throw new IllegalStateException();
            }
        }
        return t;
    }

    protected static <T extends zzdob<?, ?>> void zza(Class<T> cls, T t) {
        zzhhf.put(cls, t);
    }

    protected static Object zza(zzdpk zzdpk, String str, Object[] objArr) {
        return new zzdpz(zzdpk, str, objArr);
    }

    static Object zza(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            } else if (cause instanceof Error) {
                throw ((Error) cause);
            } else {
                throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
            }
        }
    }

    protected static final <T extends zzdob<T, ?>> boolean zza(T t, boolean z) {
        byte byteValue = ((Byte) t.zza(zze.zzhhk, (Object) null, (Object) null)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        return zzdpx.zzazg().zzan(t).zzam(t);
    }

    protected static zzdoh zzaxr() {
        return zzdoc.zzayc();
    }

    protected static <E> zzdoj<E> zzaxs() {
        return zzdpy.zzazh();
    }

    private static <T extends zzdob<T, ?>> T zza(T t, zzdnd zzdnd, zzdno zzdno) throws zzdok {
        T t2 = (zzdob) t.zza(zze.zzhhn, (Object) null, (Object) null);
        try {
            zzdpx.zzazg().zzan(t2).zza(t2, zzdng.zza(zzdnd), zzdno);
            zzdpx.zzazg().zzan(t2).zzaa(t2);
            return t2;
        } catch (IOException e) {
            if (e.getCause() instanceof zzdok) {
                throw ((zzdok) e.getCause());
            }
            throw new zzdok(e.getMessage()).zzo(t2);
        } catch (RuntimeException e2) {
            if (e2.getCause() instanceof zzdok) {
                throw ((zzdok) e2.getCause());
            }
            throw e2;
        }
    }

    private static <T extends zzdob<T, ?>> T zza(T t, byte[] bArr, int i, int i2, zzdno zzdno) throws zzdok {
        T t2 = (zzdob) t.zza(zze.zzhhn, (Object) null, (Object) null);
        try {
            zzdpx.zzazg().zzan(t2).zza(t2, bArr, 0, i2, new zzdmo(zzdno));
            zzdpx.zzazg().zzan(t2).zzaa(t2);
            if (t2.zzhcf == 0) {
                return t2;
            }
            throw new RuntimeException();
        } catch (IOException e) {
            if (e.getCause() instanceof zzdok) {
                throw ((zzdok) e.getCause());
            }
            throw new zzdok(e.getMessage()).zzo(t2);
        } catch (IndexOutOfBoundsException unused) {
            throw zzdok.zzayd().zzo(t2);
        }
    }

    protected static <T extends zzdob<T, ?>> T zza(T t, zzdmr zzdmr) throws zzdok {
        boolean z;
        T zza2 = zza(t, zzdmr, zzdno.zzaxd());
        boolean z2 = false;
        if (zza2 != null) {
            boolean booleanValue = Boolean.TRUE.booleanValue();
            byte byteValue = ((Byte) zza2.zza(zze.zzhhk, (Object) null, (Object) null)).byteValue();
            if (byteValue == 1) {
                z = true;
            } else if (byteValue == 0) {
                z = false;
            } else {
                z = zzdpx.zzazg().zzan(zza2).zzam(zza2);
                if (booleanValue) {
                    zza2.zza(zze.zzhhl, (Object) z ? zza2 : null, (Object) null);
                }
            }
            if (!z) {
                throw new zzdqs(zza2).zzazx().zzo(zza2);
            }
        }
        if (zza2 != null) {
            boolean booleanValue2 = Boolean.TRUE.booleanValue();
            byte byteValue2 = ((Byte) zza2.zza(zze.zzhhk, (Object) null, (Object) null)).byteValue();
            if (byteValue2 == 1) {
                z2 = true;
            } else if (byteValue2 != 0) {
                z2 = zzdpx.zzazg().zzan(zza2).zzam(zza2);
                if (booleanValue2) {
                    zza2.zza(zze.zzhhl, (Object) z2 ? zza2 : null, (Object) null);
                }
            }
            if (!z2) {
                throw new zzdqs(zza2).zzazx().zzo(zza2);
            }
        }
        return zza2;
    }

    private static <T extends zzdob<T, ?>> T zza(T t, zzdmr zzdmr, zzdno zzdno) throws zzdok {
        T zza2;
        try {
            zzdnd zzavp = zzdmr.zzavp();
            zza2 = zza(t, zzavp, zzdno);
            zzavp.zzfp(0);
            return zza2;
        } catch (zzdok e) {
            throw e.zzo(zza2);
        } catch (zzdok e2) {
            throw e2;
        }
    }

    protected static <T extends zzdob<T, ?>> T zza(T t, byte[] bArr) throws zzdok {
        boolean z = false;
        T zza2 = zza(t, bArr, 0, bArr.length, zzdno.zzaxd());
        if (zza2 != null) {
            boolean booleanValue = Boolean.TRUE.booleanValue();
            byte byteValue = ((Byte) zza2.zza(zze.zzhhk, (Object) null, (Object) null)).byteValue();
            if (byteValue == 1) {
                z = true;
            } else if (byteValue != 0) {
                z = zzdpx.zzazg().zzan(zza2).zzam(zza2);
                if (booleanValue) {
                    zza2.zza(zze.zzhhl, (Object) z ? zza2 : null, (Object) null);
                }
            }
            if (!z) {
                throw new zzdqs(zza2).zzazx().zzo(zza2);
            }
        }
        return zza2;
    }

    protected static <T extends zzdob<T, ?>> T zza(T t, byte[] bArr, zzdno zzdno) throws zzdok {
        boolean z = false;
        T zza2 = zza(t, bArr, 0, bArr.length, zzdno);
        if (zza2 != null) {
            boolean booleanValue = Boolean.TRUE.booleanValue();
            byte byteValue = ((Byte) zza2.zza(zze.zzhhk, (Object) null, (Object) null)).byteValue();
            if (byteValue == 1) {
                z = true;
            } else if (byteValue != 0) {
                z = zzdpx.zzazg().zzan(zza2).zzam(zza2);
                if (booleanValue) {
                    zza2.zza(zze.zzhhl, (Object) z ? zza2 : null, (Object) null);
                }
            }
            if (!z) {
                throw new zzdqs(zza2).zzazx().zzo(zza2);
            }
        }
        return zza2;
    }

    public final /* synthetic */ zzdpl zzaxt() {
        zza zza2 = (zza) zza(zze.zzhho, (Object) null, (Object) null);
        zza2.zza(this);
        return zza2;
    }

    public final /* synthetic */ zzdpl zzaxu() {
        return (zza) zza(zze.zzhho, (Object) null, (Object) null);
    }

    public final /* synthetic */ zzdpk zzaxv() {
        return (zzdob) zza(zze.zzhhp, (Object) null, (Object) null);
    }
}
