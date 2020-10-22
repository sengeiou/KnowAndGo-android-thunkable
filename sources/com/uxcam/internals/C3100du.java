package com.uxcam.internals;

import com.uxcam.internals.C3072do;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.UByte;

/* renamed from: com.uxcam.internals.du */
final class C3100du implements Closeable {

    /* renamed from: c */
    private static final Logger f2084c = Logger.getLogger(C3075dp.class.getName());

    /* renamed from: a */
    int f2085a = 16384;

    /* renamed from: b */
    final C3072do.C3074ab f2086b = new C3072do.C3074ab(this.f2089f);

    /* renamed from: d */
    private final C3131eo f2087d;

    /* renamed from: e */
    private final boolean f2088e;

    /* renamed from: f */
    private final C3130en f2089f = new C3130en();

    /* renamed from: g */
    private boolean f2090g;

    public C3100du(C3131eo eoVar, boolean z) {
        this.f2087d = eoVar;
        this.f2088e = z;
    }

    /* renamed from: a */
    private void m1647a(int i, int i2, byte b, byte b2) {
        if (f2084c.isLoggable(Level.FINE)) {
            f2084c.fine(C3075dp.m1563a(false, i, i2, b, b2));
        }
        if (i2 > this.f2085a) {
            throw C3075dp.m1562a("FRAME_SIZE_ERROR length > %d: %d", Integer.valueOf(this.f2085a), Integer.valueOf(i2));
        } else if ((Integer.MIN_VALUE & i) == 0) {
            m1648a(this.f2087d, i2);
            this.f2087d.mo38387h(b & UByte.MAX_VALUE);
            this.f2087d.mo38387h(b2 & UByte.MAX_VALUE);
            this.f2087d.mo38380f(i & Integer.MAX_VALUE);
        } else {
            throw C3075dp.m1562a("reserved bit set: %s", Integer.valueOf(i));
        }
    }

    /* renamed from: a */
    private static void m1648a(C3131eo eoVar, int i) {
        eoVar.mo38387h((i >>> 16) & 255);
        eoVar.mo38387h((i >>> 8) & 255);
        eoVar.mo38387h(i & 255);
    }

    /* renamed from: b */
    private void m1649b(int i, long j) {
        while (j > 0) {
            int min = (int) Math.min((long) this.f2085a, j);
            long j2 = (long) min;
            j -= j2;
            m1647a(i, min, (byte) 9, j == 0 ? (byte) 4 : 0);
            this.f2087d.mo38242a_(this.f2089f, j2);
        }
    }

    /* renamed from: a */
    public final synchronized void mo38294a() {
        if (this.f2090g) {
            throw new IOException("closed");
        } else if (this.f2088e) {
            if (f2084c.isLoggable(Level.FINE)) {
                f2084c.fine(C3030cl.m1422a(">> CONNECTION %s", C3075dp.f1966a.mo38412e()));
            }
            this.f2087d.mo38365b(C3075dp.f1966a.mo38416h());
            this.f2087d.flush();
        }
    }

    /* renamed from: a */
    public final synchronized void mo38295a(int i, long j) {
        if (this.f2090g) {
            throw new IOException("closed");
        } else if (j == 0 || j > 2147483647L) {
            throw C3075dp.m1562a("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", Long.valueOf(j));
        } else {
            m1647a(i, 4, (byte) 8, (byte) 0);
            this.f2087d.mo38380f((int) j);
            this.f2087d.flush();
        }
    }

    /* renamed from: a */
    public final synchronized void mo38296a(int i, C3070dm dmVar) {
        if (this.f2090g) {
            throw new IOException("closed");
        } else if (dmVar.f1936g != -1) {
            m1647a(i, 4, (byte) 3, (byte) 0);
            this.f2087d.mo38380f(dmVar.f1936g);
            this.f2087d.flush();
        } else {
            throw new IllegalArgumentException();
        }
    }

    /* renamed from: a */
    public final synchronized void mo38297a(int i, C3070dm dmVar, byte[] bArr) {
        if (this.f2090g) {
            throw new IOException("closed");
        } else if (dmVar.f1936g != -1) {
            m1647a(0, bArr.length + 8, (byte) 7, (byte) 0);
            this.f2087d.mo38380f(i);
            this.f2087d.mo38380f(dmVar.f1936g);
            if (bArr.length > 0) {
                this.f2087d.mo38365b(bArr);
            }
            this.f2087d.flush();
        } else {
            throw C3075dp.m1562a("errorCode.httpCode == -1", new Object[0]);
        }
    }

    /* renamed from: a */
    public final synchronized void mo38298a(C3106dy dyVar) {
        if (!this.f2090g) {
            int i = this.f2085a;
            if ((dyVar.f2102a & 32) != 0) {
                i = dyVar.f2103b[5];
            }
            this.f2085a = i;
            if (dyVar.mo38308a() != -1) {
                this.f2086b.mo38250a(dyVar.mo38308a());
            }
            m1647a(0, 0, (byte) 4, (byte) 1);
            this.f2087d.flush();
        } else {
            throw new IOException("closed");
        }
    }

    /* renamed from: a */
    public final synchronized void mo38299a(boolean z, int i, int i2) {
        if (!this.f2090g) {
            m1647a(0, 8, (byte) 6, z ? (byte) 1 : 0);
            this.f2087d.mo38380f(i);
            this.f2087d.mo38380f(i2);
            this.f2087d.flush();
        } else {
            throw new IOException("closed");
        }
    }

    /* renamed from: a */
    public final synchronized void mo38300a(boolean z, int i, C3130en enVar, int i2) {
        if (!this.f2090g) {
            m1647a(i, i2, (byte) 0, z ? (byte) 1 : 0);
            if (i2 > 0) {
                this.f2087d.mo38242a_(enVar, (long) i2);
            }
        } else {
            throw new IOException("closed");
        }
    }

    /* renamed from: a */
    public final synchronized void mo38301a(boolean z, int i, List list) {
        if (this.f2090g) {
            throw new IOException("closed");
        } else if (!this.f2090g) {
            this.f2086b.mo38251a(list);
            long j = this.f2089f.f2158b;
            int min = (int) Math.min((long) this.f2085a, j);
            long j2 = (long) min;
            int i2 = (j > j2 ? 1 : (j == j2 ? 0 : -1));
            byte b = i2 == 0 ? (byte) 4 : 0;
            if (z) {
                b = (byte) (b | 1);
            }
            m1647a(i, min, (byte) 1, b);
            this.f2087d.mo38242a_(this.f2089f, j2);
            if (i2 > 0) {
                m1649b(i, j - j2);
            }
        } else {
            throw new IOException("closed");
        }
    }

    /* renamed from: b */
    public final synchronized void mo38302b() {
        if (!this.f2090g) {
            this.f2087d.flush();
        } else {
            throw new IOException("closed");
        }
    }

    /* renamed from: b */
    public final synchronized void mo38303b(C3106dy dyVar) {
        if (!this.f2090g) {
            int i = 0;
            m1647a(0, Integer.bitCount(dyVar.f2102a) * 6, (byte) 4, (byte) 0);
            while (i < 10) {
                if (dyVar.mo38310a(i)) {
                    this.f2087d.mo38385g(i == 4 ? 3 : i == 7 ? 4 : i);
                    this.f2087d.mo38380f(dyVar.f2103b[i]);
                }
                i++;
            }
            this.f2087d.flush();
        } else {
            throw new IOException("closed");
        }
    }

    public final synchronized void close() {
        this.f2090g = true;
        this.f2087d.close();
    }
}
