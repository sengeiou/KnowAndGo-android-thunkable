package com.uxcam.internals;

import java.io.Closeable;
import java.io.File;

/* renamed from: com.uxcam.internals.ce */
public abstract class C3019ce {
    /* renamed from: a */
    public static C3019ce m1374a(final C3007by byVar, final File file) {
        if (file != null) {
            return new C3019ce() {
                /* renamed from: a */
                public final C3007by mo38104a() {
                    return byVar;
                }

                /* renamed from: a */
                public final void mo38105a(C3131eo eoVar) {
                    C3148fc fcVar = null;
                    try {
                        C3148fc a = C3138ev.m1865a(file);
                        try {
                            eoVar.mo38351a(a);
                            C3030cl.m1428a((Closeable) a);
                        } catch (Throwable th) {
                            th = th;
                            fcVar = a;
                            C3030cl.m1428a((Closeable) fcVar);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        C3030cl.m1428a((Closeable) fcVar);
                        throw th;
                    }
                }

                /* renamed from: b */
                public final long mo38106b() {
                    return file.length();
                }
            };
        }
        throw new NullPointerException("content == null");
    }

    /* renamed from: a */
    public static C3019ce m1375a(String str) {
        byte[] bytes = str.getBytes(C3030cl.f1784e);
        return m1376a(bytes, bytes.length);
    }

    /* renamed from: a */
    public static C3019ce m1376a(final byte[] bArr, final int i) {
        if (bArr != null) {
            C3030cl.m1427a((long) bArr.length, (long) i);
            return new C3019ce() {

                /* renamed from: a */
                final /* synthetic */ C3007by f1734a = null;

                /* renamed from: d */
                final /* synthetic */ int f1737d;

                {
                    this.f1737d = 0;
                }

                /* renamed from: a */
                public final C3007by mo38104a() {
                    return this.f1734a;
                }

                /* renamed from: a */
                public final void mo38105a(C3131eo eoVar) {
                    eoVar.mo38366b(bArr, this.f1737d, i);
                }

                /* renamed from: b */
                public final long mo38106b() {
                    return (long) i;
                }
            };
        }
        throw new NullPointerException("content == null");
    }

    /* renamed from: a */
    public abstract C3007by mo38104a();

    /* renamed from: a */
    public abstract void mo38105a(C3131eo eoVar);

    /* renamed from: b */
    public long mo38106b() {
        return -1;
    }
}
