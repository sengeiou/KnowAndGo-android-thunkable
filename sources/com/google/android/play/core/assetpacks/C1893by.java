package com.google.android.play.core.assetpacks;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* renamed from: com.google.android.play.core.assetpacks.by */
final class C1893by extends OutputStream {

    /* renamed from: a */
    private final C1926dd f496a = new C1926dd();

    /* renamed from: b */
    private final File f497b;

    /* renamed from: c */
    private final C1940dr f498c;

    /* renamed from: d */
    private long f499d;

    /* renamed from: e */
    private long f500e;

    /* renamed from: f */
    private FileOutputStream f501f;

    /* renamed from: g */
    private C1946dx f502g;

    C1893by(File file, C1940dr drVar) {
        this.f497b = file;
        this.f498c = drVar;
    }

    public final void write(int i) throws IOException {
        write(new byte[]{(byte) i});
    }

    public final void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    public final void write(byte[] bArr, int i, int i2) throws IOException {
        int i3;
        while (i2 > 0) {
            if (this.f499d == 0 && this.f500e == 0) {
                int a = this.f496a.mo33471a(bArr, i, i2);
                if (a != -1) {
                    i += a;
                    i2 -= a;
                    this.f502g = this.f496a.mo33472a();
                    if (this.f502g.mo33510g()) {
                        this.f499d = 0;
                        this.f498c.mo33498b(this.f502g.mo33511h(), this.f502g.mo33511h().length);
                        this.f500e = (long) this.f502g.mo33511h().length;
                    } else if (!this.f502g.mo33504b() || this.f502g.mo33503a()) {
                        byte[] h = this.f502g.mo33511h();
                        this.f498c.mo33498b(h, h.length);
                        this.f499d = this.f502g.mo33506d();
                    } else {
                        this.f498c.mo33493a(this.f502g.mo33511h());
                        File file = new File(this.f497b, this.f502g.mo33505c());
                        file.getParentFile().mkdirs();
                        this.f499d = this.f502g.mo33506d();
                        this.f501f = new FileOutputStream(file);
                    }
                } else {
                    return;
                }
            }
            if (!this.f502g.mo33503a()) {
                if (this.f502g.mo33510g()) {
                    this.f498c.mo33490a(this.f500e, bArr, i, i2);
                    this.f500e += (long) i2;
                    i3 = i2;
                } else if (this.f502g.mo33504b()) {
                    i3 = (int) Math.min((long) i2, this.f499d);
                    this.f501f.write(bArr, i, i3);
                    long j = this.f499d - ((long) i3);
                    this.f499d = j;
                    if (j == 0) {
                        this.f501f.close();
                    }
                } else {
                    i3 = (int) Math.min((long) i2, this.f499d);
                    int length = this.f502g.mo33511h().length;
                    this.f498c.mo33490a((((long) length) + this.f502g.mo33506d()) - this.f499d, bArr, i, i3);
                    this.f499d -= (long) i3;
                }
                i += i3;
                i2 -= i3;
            }
        }
    }
}
