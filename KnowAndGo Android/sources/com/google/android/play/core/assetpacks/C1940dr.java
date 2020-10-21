package com.google.android.play.core.assetpacks;

import androidx.exifinterface.media.ExifInterface;
import com.google.android.play.core.internal.C1982af;
import com.google.android.play.core.internal.C2039ci;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.Properties;

/* renamed from: com.google.android.play.core.assetpacks.dr */
final class C1940dr {

    /* renamed from: a */
    private static final C1982af f646a = new C1982af("SliceMetadataManager");

    /* renamed from: b */
    private final byte[] f647b = new byte[8192];

    /* renamed from: c */
    private final C1870bb f648c;

    /* renamed from: d */
    private final String f649d;

    /* renamed from: e */
    private final int f650e;

    /* renamed from: f */
    private final long f651f;

    /* renamed from: g */
    private final String f652g;

    /* renamed from: h */
    private int f653h;

    C1940dr(C1870bb bbVar, String str, int i, long j, String str2) {
        this.f648c = bbVar;
        this.f649d = str;
        this.f650e = i;
        this.f651f = j;
        this.f652g = str2;
        this.f653h = -1;
    }

    /* renamed from: e */
    private final File m498e() {
        File f = this.f648c.mo33397f(this.f649d, this.f650e, this.f651f, this.f652g);
        if (!f.exists()) {
            f.mkdirs();
        }
        return f;
    }

    /* renamed from: f */
    private final File m499f() throws IOException {
        File c = this.f648c.mo33385c(this.f649d, this.f650e, this.f651f, this.f652g);
        c.getParentFile().mkdirs();
        c.createNewFile();
        return c;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final C1939dq mo33488a() throws IOException {
        File c = this.f648c.mo33385c(this.f649d, this.f650e, this.f651f, this.f652g);
        if (c.exists()) {
            Properties properties = new Properties();
            FileInputStream fileInputStream = new FileInputStream(c);
            try {
                properties.load(fileInputStream);
                fileInputStream.close();
                if (properties.getProperty("fileStatus") == null || properties.getProperty("previousChunk") == null) {
                    throw new C1890bv("Slice checkpoint file corrupt.");
                }
                try {
                    int parseInt = Integer.parseInt(properties.getProperty("fileStatus"));
                    String property = properties.getProperty("fileName");
                    long parseLong = Long.parseLong(properties.getProperty("fileOffset", "-1"));
                    long parseLong2 = Long.parseLong(properties.getProperty("remainingBytes", "-1"));
                    int parseInt2 = Integer.parseInt(properties.getProperty("previousChunk"));
                    this.f653h = Integer.parseInt(properties.getProperty("metadataFileCounter", "0"));
                    return new C1939dq(parseInt, property, parseLong, parseLong2, parseInt2);
                } catch (NumberFormatException e) {
                    throw new C1890bv("Slice checkpoint file corrupt.", (Exception) e);
                }
            } catch (Throwable th) {
                C2039ci.m739a(th, th);
            }
        } else {
            throw new C1890bv("Slice checkpoint file does not exist.");
        }
        throw th;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo33489a(int i) throws IOException {
        Properties properties = new Properties();
        properties.put("fileStatus", ExifInterface.GPS_MEASUREMENT_3D);
        properties.put("fileOffset", String.valueOf(mo33496b().length()));
        properties.put("previousChunk", String.valueOf(i));
        properties.put("metadataFileCounter", String.valueOf(this.f653h));
        FileOutputStream fileOutputStream = new FileOutputStream(m499f());
        try {
            properties.store(fileOutputStream, (String) null);
            fileOutputStream.close();
            return;
        } catch (Throwable th) {
            C2039ci.m739a(th, th);
        }
        throw th;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo33490a(long j, byte[] bArr, int i, int i2) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(mo33496b(), "rw");
        try {
            randomAccessFile.seek(j);
            randomAccessFile.write(bArr, i, i2);
            randomAccessFile.close();
            return;
        } catch (Throwable th) {
            C2039ci.m739a(th, th);
        }
        throw th;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo33491a(InputStream inputStream, long j) throws IOException {
        int read;
        RandomAccessFile randomAccessFile = new RandomAccessFile(mo33496b(), "rw");
        try {
            randomAccessFile.seek(j);
            do {
                read = inputStream.read(this.f647b);
                if (read > 0) {
                    randomAccessFile.write(this.f647b, 0, read);
                }
            } while (read == this.f647b.length);
            randomAccessFile.close();
            return;
        } catch (Throwable th) {
            C2039ci.m739a(th, th);
        }
        throw th;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo33492a(String str, long j, long j2, int i) throws IOException {
        Properties properties = new Properties();
        properties.put("fileStatus", "1");
        properties.put("fileName", str);
        properties.put("fileOffset", String.valueOf(j));
        properties.put("remainingBytes", String.valueOf(j2));
        properties.put("previousChunk", String.valueOf(i));
        properties.put("metadataFileCounter", String.valueOf(this.f653h));
        FileOutputStream fileOutputStream = new FileOutputStream(m499f());
        try {
            properties.store(fileOutputStream, (String) null);
            fileOutputStream.close();
            return;
        } catch (Throwable th) {
            C2039ci.m739a(th, th);
        }
        throw th;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo33493a(byte[] bArr) throws IOException {
        FileOutputStream fileOutputStream;
        this.f653h++;
        try {
            fileOutputStream = new FileOutputStream(new File(m498e(), String.format("%s-LFH.dat", new Object[]{Integer.valueOf(this.f653h)})));
            fileOutputStream.write(bArr);
            fileOutputStream.close();
            return;
        } catch (IOException e) {
            throw new C1890bv("Could not write metadata file.", (Exception) e);
        } catch (Throwable th) {
            C2039ci.m739a(th, th);
        }
        throw th;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo33494a(byte[] bArr, int i) throws IOException {
        Properties properties = new Properties();
        properties.put("fileStatus", ExifInterface.GPS_MEASUREMENT_2D);
        properties.put("previousChunk", String.valueOf(i));
        properties.put("metadataFileCounter", String.valueOf(this.f653h));
        FileOutputStream fileOutputStream = new FileOutputStream(m499f());
        try {
            properties.store(fileOutputStream, (String) null);
            fileOutputStream.close();
            File d = this.f648c.mo33389d(this.f649d, this.f650e, this.f651f, this.f652g);
            if (d.exists()) {
                d.delete();
            }
            FileOutputStream fileOutputStream2 = new FileOutputStream(d);
            try {
                fileOutputStream2.write(bArr);
                fileOutputStream2.close();
                return;
            } catch (Throwable th) {
                C2039ci.m739a(th, th);
            }
            throw th;
            throw th;
        } catch (Throwable th2) {
            C2039ci.m739a(th, th2);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo33495a(byte[] bArr, InputStream inputStream) throws IOException {
        this.f653h++;
        FileOutputStream fileOutputStream = new FileOutputStream(mo33496b());
        try {
            fileOutputStream.write(bArr);
            byte[] bArr2 = this.f647b;
            while (true) {
                int read = inputStream.read(bArr2);
                if (read > 0) {
                    fileOutputStream.write(this.f647b, 0, read);
                    bArr2 = this.f647b;
                } else {
                    fileOutputStream.close();
                    return;
                }
            }
        } catch (Throwable th) {
            C2039ci.m739a(th, th);
        }
        throw th;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final File mo33496b() {
        return new File(m498e(), String.format("%s-NAM.dat", new Object[]{Integer.valueOf(this.f653h)}));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final void mo33497b(int i) throws IOException {
        Properties properties = new Properties();
        properties.put("fileStatus", "4");
        properties.put("previousChunk", String.valueOf(i));
        properties.put("metadataFileCounter", String.valueOf(this.f653h));
        FileOutputStream fileOutputStream = new FileOutputStream(m499f());
        try {
            properties.store(fileOutputStream, (String) null);
            fileOutputStream.close();
            return;
        } catch (Throwable th) {
            C2039ci.m739a(th, th);
        }
        throw th;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final void mo33498b(byte[] bArr, int i) throws IOException {
        this.f653h++;
        FileOutputStream fileOutputStream = new FileOutputStream(mo33496b());
        try {
            fileOutputStream.write(bArr, 0, i);
            fileOutputStream.close();
            return;
        } catch (Throwable th) {
            C2039ci.m739a(th, th);
        }
        throw th;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final int mo33499c() throws IOException {
        File c = this.f648c.mo33385c(this.f649d, this.f650e, this.f651f, this.f652g);
        if (!c.exists()) {
            return 0;
        }
        FileInputStream fileInputStream = new FileInputStream(c);
        try {
            Properties properties = new Properties();
            properties.load(fileInputStream);
            fileInputStream.close();
            if (Integer.parseInt(properties.getProperty("fileStatus", "-1")) == 4) {
                return -1;
            }
            if (properties.getProperty("previousChunk") != null) {
                return Integer.parseInt(properties.getProperty("previousChunk")) + 1;
            }
            throw new C1890bv("Slice checkpoint file corrupt.");
        } catch (Throwable th) {
            C2039ci.m739a(th, th);
        }
        throw th;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public final boolean mo33500d() {
        FileInputStream fileInputStream;
        File c = this.f648c.mo33385c(this.f649d, this.f650e, this.f651f, this.f652g);
        if (!c.exists()) {
            return false;
        }
        try {
            fileInputStream = new FileInputStream(c);
            Properties properties = new Properties();
            properties.load(fileInputStream);
            fileInputStream.close();
            if (properties.getProperty("fileStatus") != null) {
                return Integer.parseInt(properties.getProperty("fileStatus")) == 4;
            }
            f646a.mo33552b("Slice checkpoint file corrupt while checking if extraction finished.", new Object[0]);
            return false;
        } catch (IOException e) {
            f646a.mo33552b("Could not read checkpoint while checking if extraction finished. %s", e);
            return false;
        } catch (Throwable th) {
            C2039ci.m739a(th, th);
        }
        throw th;
    }
}
