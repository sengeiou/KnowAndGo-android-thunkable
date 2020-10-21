package com.google.android.play.core.internal;

import android.content.ComponentName;
import android.content.pm.ComponentInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

/* renamed from: com.google.android.play.core.internal.bq */
public final class C2020bq {
    /* renamed from: a */
    public static <T> C2019bp<T> m677a(Object obj, String str, Class<T> cls) {
        return new C2019bp<>(obj, m682a(obj, str), cls);
    }

    /* renamed from: a */
    public static <R, P0> R m678a(Class cls, Class<R> cls2, Class<P0> cls3, P0 p0) {
        try {
            return cls2.cast(m683a((Class<?>) cls, "isDexOptNeeded", (Class<?>[]) new Class[]{cls3}).invoke((Object) null, new Object[]{p0}));
        } catch (Exception e) {
            throw new C2021br(String.format("Failed to invoke static method %s on type %s", new Object[]{"isDexOptNeeded", cls}), e);
        }
    }

    /* renamed from: a */
    public static <R, P0, P1> R m679a(Class cls, Class<R> cls2, Class<P0> cls3, P0 p0, Class<P1> cls4, P1 p1) {
        try {
            return cls2.cast(m683a((Class<?>) cls, "optimizedPathFor", (Class<?>[]) new Class[]{cls3, cls4}).invoke((Object) null, new Object[]{p0, p1}));
        } catch (Exception e) {
            throw new C2021br(String.format("Failed to invoke static method %s on type %s", new Object[]{"optimizedPathFor", cls}), e);
        }
    }

    /* renamed from: a */
    public static <R, P0> R m680a(Object obj, String str, Class<R> cls, Class<P0> cls2, P0 p0) {
        try {
            return cls.cast(m684a(obj, str, (Class<?>[]) new Class[]{cls2}).invoke(obj, new Object[]{p0}));
        } catch (Exception e) {
            throw new C2021br(String.format("Failed to invoke method %s on an object of type %s", new Object[]{str, obj.getClass()}), e);
        }
    }

    /* renamed from: a */
    public static <R, P0, P1, P2> R m681a(Object obj, String str, Class<R> cls, Class<P0> cls2, P0 p0, Class<P1> cls3, P1 p1, Class<P2> cls4, P2 p2) {
        try {
            return cls.cast(m684a(obj, str, (Class<?>[]) new Class[]{cls2, cls3, cls4}).invoke(obj, new Object[]{p0, p1, p2}));
        } catch (Exception e) {
            throw new C2021br(String.format("Failed to invoke method %s on an object of type %s", new Object[]{str, obj.getClass()}), e);
        }
    }

    /* renamed from: a */
    private static Field m682a(Object obj, String str) {
        Class cls = obj.getClass();
        while (cls != null) {
            try {
                Field declaredField = cls.getDeclaredField(str);
                if (!declaredField.isAccessible()) {
                    declaredField.setAccessible(true);
                }
                return declaredField;
            } catch (NoSuchFieldException unused) {
                cls = cls.getSuperclass();
            }
        }
        throw new C2021br(String.format("Failed to find a field named %s on an object of instance %s", new Object[]{str, obj.getClass().getName()}));
    }

    /* renamed from: a */
    private static Method m683a(Class<?> cls, String str, Class<?>... clsArr) {
        Class<?> cls2 = cls;
        while (cls2 != null) {
            try {
                Method declaredMethod = cls2.getDeclaredMethod(str, clsArr);
                if (!declaredMethod.isAccessible()) {
                    declaredMethod.setAccessible(true);
                }
                return declaredMethod;
            } catch (NoSuchMethodException unused) {
                cls2 = cls2.getSuperclass();
            }
        }
        throw new C2021br(String.format("Could not find a method named %s with parameters %s in type %s", new Object[]{str, Arrays.asList(clsArr), cls}));
    }

    /* renamed from: a */
    private static Method m684a(Object obj, String str, Class<?>... clsArr) {
        return m683a(obj.getClass(), str, clsArr);
    }

    /* renamed from: a */
    public static void m685a(PackageManager packageManager, ComponentName componentName, int i) {
        ComponentInfo componentInfo;
        switch (packageManager.getComponentEnabledSetting(componentName)) {
            case 1:
                return;
            case 2:
                break;
            default:
                String packageName = componentName.getPackageName();
                String className = componentName.getClassName();
                try {
                    PackageInfo packageInfo = packageManager.getPackageInfo(packageName, i | 512);
                    ComponentInfo[][] componentInfoArr = {packageInfo.activities, packageInfo.services, packageInfo.providers};
                    int i2 = 0;
                    while (true) {
                        if (i2 >= 3) {
                            componentInfo = null;
                        } else {
                            ComponentInfo[] componentInfoArr2 = componentInfoArr[i2];
                            if (componentInfoArr2 != null) {
                                int length = componentInfoArr2.length;
                                int i3 = 0;
                                while (i3 < length) {
                                    componentInfo = componentInfoArr2[i3];
                                    if (!componentInfo.name.equals(className)) {
                                        i3++;
                                    }
                                }
                                continue;
                            }
                            i2++;
                        }
                    }
                    if (componentInfo == null) {
                        break;
                    } else if (componentInfo.isEnabled()) {
                        return;
                    }
                } catch (PackageManager.NameNotFoundException unused) {
                    break;
                }
                break;
        }
        packageManager.setComponentEnabledSetting(componentName, 1, 1);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x005e, code lost:
        m690a(r0, r9, r15, r12, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0070, code lost:
        m689a(r0, r13, r15, r4, r12, r7);
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void m686a(com.google.android.play.core.internal.C2031ca r13, java.io.InputStream r14, java.io.OutputStream r15, long r16) throws java.io.IOException {
        /*
            r0 = 16384(0x4000, float:2.2959E-41)
            byte[] r0 = new byte[r0]
            java.io.BufferedInputStream r1 = new java.io.BufferedInputStream
            r2 = 4096(0x1000, float:5.74E-42)
            r3 = r14
            r1.<init>(r14, r2)
            java.io.DataInputStream r9 = new java.io.DataInputStream
            r9.<init>(r1)
            int r1 = r9.readInt()
            r2 = -771763713(0xffffffffd1ffd1ff, float:-1.37342476E11)
            if (r1 == r2) goto L_0x0046
            com.google.android.play.core.internal.bz r0 = new com.google.android.play.core.internal.bz
            r2 = 1
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r3 = 0
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r2[r3] = r1
            java.lang.String r1 = "%x"
            java.lang.String r1 = java.lang.String.format(r1, r2)
            java.lang.String r1 = java.lang.String.valueOf(r1)
            java.lang.String r2 = "Unexpected magic="
            int r3 = r1.length()
            if (r3 == 0) goto L_0x003d
            java.lang.String r1 = r2.concat(r1)
            goto L_0x0042
        L_0x003d:
            java.lang.String r1 = new java.lang.String
            r1.<init>(r2)
        L_0x0042:
            r0.<init>(r1)
            throw r0
        L_0x0046:
            int r1 = r9.read()
            r2 = 4
            if (r1 != r2) goto L_0x00e7
            r1 = 0
            r10 = r1
        L_0x0050:
            r1 = 0
            long r7 = r16 - r10
            int r12 = r9.read()     // Catch:{ all -> 0x00e2 }
            switch(r12) {
                case -1: goto L_0x00da;
                case 0: goto L_0x00d6;
                default: goto L_0x005a;
            }     // Catch:{ all -> 0x00e2 }
        L_0x005a:
            r1 = -1
            switch(r12) {
                case 247: goto L_0x00cd;
                case 248: goto L_0x00c8;
                case 249: goto L_0x00b4;
                case 250: goto L_0x00aa;
                case 251: goto L_0x00a0;
                case 252: goto L_0x008c;
                case 253: goto L_0x0082;
                case 254: goto L_0x0078;
                case 255: goto L_0x0068;
                default: goto L_0x005e;
            }     // Catch:{ all -> 0x00e2 }
        L_0x005e:
            r1 = r0
            r2 = r9
            r3 = r15
            r4 = r12
            r5 = r7
            m690a((byte[]) r1, (java.io.DataInputStream) r2, (java.io.OutputStream) r3, (int) r4, (long) r5)     // Catch:{ all -> 0x00e2 }
            goto L_0x00d2
        L_0x0068:
            long r4 = r9.readLong()     // Catch:{ all -> 0x00e2 }
            int r12 = r9.readInt()     // Catch:{ all -> 0x00e2 }
        L_0x0070:
            r1 = r0
            r2 = r13
            r3 = r15
            r6 = r12
            m689a((byte[]) r1, (com.google.android.play.core.internal.C2031ca) r2, (java.io.OutputStream) r3, (long) r4, (int) r6, (long) r7)     // Catch:{ all -> 0x00e2 }
            goto L_0x00d2
        L_0x0078:
            int r1 = r9.readInt()     // Catch:{ all -> 0x00e2 }
            long r4 = (long) r1     // Catch:{ all -> 0x00e2 }
            int r12 = r9.readInt()     // Catch:{ all -> 0x00e2 }
            goto L_0x0070
        L_0x0082:
            int r1 = r9.readInt()     // Catch:{ all -> 0x00e2 }
            long r4 = (long) r1     // Catch:{ all -> 0x00e2 }
            int r12 = r9.readUnsignedShort()     // Catch:{ all -> 0x00e2 }
            goto L_0x0070
        L_0x008c:
            int r2 = r9.readInt()     // Catch:{ all -> 0x00e2 }
            long r4 = (long) r2     // Catch:{ all -> 0x00e2 }
            int r12 = r9.read()     // Catch:{ all -> 0x00e2 }
            if (r12 == r1) goto L_0x0098
            goto L_0x0070
        L_0x0098:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x00e2 }
            java.lang.String r1 = "Unexpected end of patch"
            r0.<init>(r1)     // Catch:{ all -> 0x00e2 }
            throw r0     // Catch:{ all -> 0x00e2 }
        L_0x00a0:
            int r1 = r9.readUnsignedShort()     // Catch:{ all -> 0x00e2 }
            long r4 = (long) r1     // Catch:{ all -> 0x00e2 }
            int r12 = r9.readInt()     // Catch:{ all -> 0x00e2 }
            goto L_0x0070
        L_0x00aa:
            int r1 = r9.readUnsignedShort()     // Catch:{ all -> 0x00e2 }
            long r4 = (long) r1     // Catch:{ all -> 0x00e2 }
            int r12 = r9.readUnsignedShort()     // Catch:{ all -> 0x00e2 }
            goto L_0x0070
        L_0x00b4:
            int r2 = r9.readUnsignedShort()     // Catch:{ all -> 0x00e2 }
            long r4 = (long) r2     // Catch:{ all -> 0x00e2 }
            int r12 = r9.read()     // Catch:{ all -> 0x00e2 }
            if (r12 == r1) goto L_0x00c0
            goto L_0x0070
        L_0x00c0:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x00e2 }
            java.lang.String r1 = "Unexpected end of patch"
            r0.<init>(r1)     // Catch:{ all -> 0x00e2 }
            throw r0     // Catch:{ all -> 0x00e2 }
        L_0x00c8:
            int r12 = r9.readInt()     // Catch:{ all -> 0x00e2 }
            goto L_0x005e
        L_0x00cd:
            int r12 = r9.readUnsignedShort()     // Catch:{ all -> 0x00e2 }
            goto L_0x005e
        L_0x00d2:
            long r1 = (long) r12
            long r10 = r10 + r1
            goto L_0x0050
        L_0x00d6:
            r15.flush()
            return
        L_0x00da:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x00e2 }
            java.lang.String r1 = "Patch file overrun"
            r0.<init>(r1)     // Catch:{ all -> 0x00e2 }
            throw r0     // Catch:{ all -> 0x00e2 }
        L_0x00e2:
            r0 = move-exception
            r15.flush()
            throw r0
        L_0x00e7:
            com.google.android.play.core.internal.bz r0 = new com.google.android.play.core.internal.bz
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r3 = 30
            r2.<init>(r3)
            java.lang.String r3 = "Unexpected version="
            r2.append(r3)
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.play.core.internal.C2020bq.m686a(com.google.android.play.core.internal.ca, java.io.InputStream, java.io.OutputStream, long):void");
    }

    /* renamed from: a */
    public static <T> void m687a(T t) {
        if (t == null) {
            throw null;
        }
    }

    /* renamed from: a */
    public static <T> void m688a(T t, Class<T> cls) {
        if (t == null) {
            throw new IllegalStateException(String.valueOf(cls.getCanonicalName()).concat(" must be set"));
        }
    }

    /* renamed from: a */
    private static void m689a(byte[] bArr, C2031ca caVar, OutputStream outputStream, long j, int i, long j2) throws IOException {
        InputStream b;
        if (i < 0) {
            throw new IOException("copyLength negative");
        } else if (j >= 0) {
            long j3 = (long) i;
            if (j3 <= j2) {
                try {
                    b = new C2032cb(caVar, j, j3).mo33600b();
                    while (i > 0) {
                        int min = Math.min(i, 16384);
                        int i2 = 0;
                        while (i2 < min) {
                            int read = b.read(bArr, i2, min - i2);
                            if (read != -1) {
                                i2 += read;
                            } else {
                                throw new IOException("truncated input stream");
                            }
                        }
                        outputStream.write(bArr, 0, min);
                        i -= min;
                    }
                    if (b != null) {
                        b.close();
                        return;
                    }
                    return;
                } catch (EOFException e) {
                    throw new IOException("patch underrun", e);
                } catch (Throwable th) {
                    C2039ci.m739a(th, th);
                }
            } else {
                throw new IOException("Output length overrun");
            }
        } else {
            throw new IOException("inputOffset negative");
        }
        throw th;
    }

    /* renamed from: a */
    private static void m690a(byte[] bArr, DataInputStream dataInputStream, OutputStream outputStream, int i, long j) throws IOException {
        if (i < 0) {
            throw new IOException("copyLength negative");
        } else if (((long) i) <= j) {
            while (i > 0) {
                try {
                    int min = Math.min(i, 16384);
                    dataInputStream.readFully(bArr, 0, min);
                    outputStream.write(bArr, 0, min);
                    i -= min;
                } catch (EOFException unused) {
                    throw new IOException("patch underrun");
                }
            }
        } else {
            throw new IOException("Output length overrun");
        }
    }

    /* renamed from: b */
    public static <T> C2019bp m691b(Object obj, String str, Class<T> cls) {
        return new C2019bp(obj, m682a(obj, str), cls, (byte[]) null);
    }

    /* renamed from: b */
    public static <T> void m692b(T t) {
        if (t == null) {
            throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
        }
    }
}
