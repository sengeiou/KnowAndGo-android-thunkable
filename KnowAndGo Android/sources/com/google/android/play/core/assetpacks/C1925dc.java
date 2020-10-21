package com.google.android.play.core.assetpacks;

import androidx.annotation.Nullable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;

/* renamed from: com.google.android.play.core.assetpacks.dc */
public final class C1925dc extends InputStream {

    /* renamed from: a */
    private final Enumeration<File> f592a;
    @Nullable

    /* renamed from: b */
    private InputStream f593b;

    public C1925dc(Enumeration<File> enumeration) throws IOException {
        this.f592a = enumeration;
        mo33467a();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo33467a() throws IOException {
        InputStream inputStream = this.f593b;
        if (inputStream != null) {
            inputStream.close();
        }
        this.f593b = this.f592a.hasMoreElements() ? new FileInputStream(this.f592a.nextElement()) : null;
    }

    public final void close() throws IOException {
        super.close();
        InputStream inputStream = this.f593b;
        if (inputStream != null) {
            inputStream.close();
            this.f593b = null;
        }
    }

    public final int read() throws IOException {
        while (true) {
            InputStream inputStream = this.f593b;
            if (inputStream == null) {
                return -1;
            }
            int read = inputStream.read();
            if (read != -1) {
                return read;
            }
            mo33467a();
        }
    }

    public final int read(byte[] bArr, int i, int i2) throws IOException {
        if (this.f593b == null) {
            return -1;
        }
        if (bArr == null) {
            throw null;
        } else if (i < 0 || i2 < 0 || i2 > bArr.length - i) {
            throw new IndexOutOfBoundsException();
        } else if (i2 == 0) {
            return 0;
        } else {
            do {
                int read = this.f593b.read(bArr, i, i2);
                if (read > 0) {
                    return read;
                }
                mo33467a();
            } while (this.f593b != null);
            return -1;
        }
    }
}
