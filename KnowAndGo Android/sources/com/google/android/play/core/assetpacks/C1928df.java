package com.google.android.play.core.assetpacks;

import com.google.android.play.core.internal.C1982af;
import java.io.File;
import java.io.IOException;

/* renamed from: com.google.android.play.core.assetpacks.df */
final class C1928df {

    /* renamed from: a */
    private static final C1982af f606a = new C1982af("MergeSliceTaskHandler");

    /* renamed from: b */
    private final C1870bb f607b;

    C1928df(C1870bb bbVar) {
        this.f607b = bbVar;
    }

    /* renamed from: a */
    private static void m483a(File file, File file2) {
        if (file.isDirectory()) {
            file2.mkdirs();
            for (File file3 : file.listFiles()) {
                m483a(file3, new File(file2, file3.getName()));
            }
            if (!file.delete()) {
                String valueOf = String.valueOf(file);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 28);
                sb.append("Unable to delete directory: ");
                sb.append(valueOf);
                throw new C1890bv(sb.toString());
            }
        } else if (file2.exists()) {
            String valueOf2 = String.valueOf(file2);
            StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf2).length() + 51);
            sb2.append("File clashing with existing file from other slice: ");
            sb2.append(valueOf2);
            throw new C1890bv(sb2.toString());
        } else if (!file.renameTo(file2)) {
            String valueOf3 = String.valueOf(file);
            StringBuilder sb3 = new StringBuilder(String.valueOf(valueOf3).length() + 21);
            sb3.append("Unable to move file: ");
            sb3.append(valueOf3);
            throw new C1890bv(sb3.toString());
        }
    }

    /* renamed from: a */
    public final void mo33475a(C1927de deVar) {
        File b = this.f607b.mo33382b(deVar.f551k, deVar.f603a, deVar.f604b, deVar.f605c);
        if (b.exists()) {
            File c = this.f607b.mo33384c(deVar.f551k, deVar.f603a, deVar.f604b);
            if (!c.exists()) {
                c.mkdirs();
            }
            m483a(b, c);
            try {
                this.f607b.mo33377a(deVar.f551k, deVar.f603a, deVar.f604b, this.f607b.mo33388d(deVar.f551k, deVar.f603a, deVar.f604b) + 1);
            } catch (IOException e) {
                f606a.mo33552b("Writing merge checkpoint failed with %s.", e.getMessage());
                throw new C1890bv("Writing merge checkpoint failed.", e, deVar.f550j);
            }
        } else {
            throw new C1890bv(String.format("Cannot find verified files for slice %s.", new Object[]{deVar.f605c}), deVar.f550j);
        }
    }
}
