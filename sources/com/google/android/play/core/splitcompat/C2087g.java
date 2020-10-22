package com.google.android.play.core.splitcompat;

import android.util.Log;
import com.google.android.play.core.internal.C2039ci;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* renamed from: com.google.android.play.core.splitcompat.g */
final class C2087g implements C2089i {

    /* renamed from: a */
    final /* synthetic */ Set f837a;

    /* renamed from: b */
    final /* synthetic */ C2097q f838b;

    /* renamed from: c */
    final /* synthetic */ ZipFile f839c;

    C2087g(Set set, C2097q qVar, ZipFile zipFile) {
        this.f837a = set;
        this.f838b = qVar;
        this.f839c = zipFile;
    }

    /* renamed from: a */
    public final void mo33696a(C2090j jVar, File file, boolean z) throws IOException {
        FileOutputStream fileOutputStream;
        this.f837a.add(file);
        if (!z) {
            Log.i("SplitCompat", String.format("NativeLibraryExtractor: split '%s' has native library '%s' that does not exist; extracting from '%s!%s' to '%s'", new Object[]{this.f838b.mo33705b(), jVar.f840a, this.f838b.mo33704a().getAbsolutePath(), jVar.f841b.getName(), file.getAbsolutePath()}));
            ZipFile zipFile = this.f839c;
            ZipEntry zipEntry = jVar.f841b;
            int i = C2091k.f842a;
            byte[] bArr = new byte[4096];
            InputStream inputStream = zipFile.getInputStream(zipEntry);
            try {
                fileOutputStream = new FileOutputStream(file);
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, read);
                }
                fileOutputStream.close();
                if (inputStream != null) {
                    inputStream.close();
                    return;
                }
                return;
            } catch (Throwable th) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Throwable th2) {
                        C2039ci.m739a(th, th2);
                    }
                }
                throw th;
            }
        } else {
            return;
        }
        throw th;
    }
}
