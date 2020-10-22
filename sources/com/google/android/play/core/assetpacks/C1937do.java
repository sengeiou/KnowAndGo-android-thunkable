package com.google.android.play.core.assetpacks;

import com.google.android.play.core.common.C1971a;
import com.google.android.play.core.internal.C1982af;
import com.google.android.play.core.internal.C2020bq;
import com.google.android.play.core.internal.C2031ca;
import com.google.android.play.core.internal.C2039ci;
import com.google.android.play.core.internal.C2040cj;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;

/* renamed from: com.google.android.play.core.assetpacks.do */
final class C1937do {

    /* renamed from: a */
    private static final C1982af f634a = new C1982af("PatchSliceTaskHandler");

    /* renamed from: b */
    private final C1870bb f635b;

    /* renamed from: c */
    private final C2040cj<C1966w> f636c;

    /* renamed from: d */
    private final C1971a f637d;

    C1937do(C1870bb bbVar, C2040cj<C1966w> cjVar, C1971a aVar) {
        this.f635b = bbVar;
        this.f636c = cjVar;
        this.f637d = aVar;
    }

    /* renamed from: a */
    public final void mo33479a(C1936dn dnVar) {
        InputStream inputStream;
        Throwable th;
        C1982af afVar;
        Object[] objArr;
        String str;
        C1936dn dnVar2 = dnVar;
        File a = this.f635b.mo33374a(dnVar2.f551k, dnVar2.f626a, dnVar2.f627b);
        C1870bb bbVar = this.f635b;
        String str2 = dnVar2.f551k;
        int i = dnVar2.f626a;
        long j = dnVar2.f627b;
        File file = new File(bbVar.mo33381b(str2, i, j), dnVar2.f631f);
        try {
            inputStream = dnVar2.f633h;
            if (dnVar2.f630e == 2) {
                inputStream = new GZIPInputStream(inputStream, 8192);
            }
            C1873be beVar = new C1873be(a, file);
            if (this.f637d.mo33532a()) {
                File a2 = this.f635b.mo33375a(dnVar2.f551k, dnVar2.f628c, dnVar2.f629d, dnVar2.f631f);
                if (!a2.exists()) {
                    a2.mkdirs();
                }
                C1940dr drVar = new C1940dr(this.f635b, dnVar2.f551k, dnVar2.f628c, dnVar2.f629d, dnVar2.f631f);
                C2020bq.m686a((C2031ca) beVar, inputStream, (OutputStream) new C1893by(a2, drVar), dnVar2.f632g);
                drVar.mo33497b(0);
            } else {
                File file2 = new File(this.f635b.mo33397f(dnVar2.f551k, dnVar2.f628c, dnVar2.f629d, dnVar2.f631f), "slice.zip.tmp");
                if (file2.getParentFile() != null && !file2.getParentFile().exists()) {
                    file2.getParentFile().mkdirs();
                }
                C2020bq.m686a((C2031ca) beVar, inputStream, (OutputStream) new FileOutputStream(file2), dnVar2.f632g);
                if (!file2.renameTo(this.f635b.mo33394e(dnVar2.f551k, dnVar2.f628c, dnVar2.f629d, dnVar2.f631f))) {
                    throw new C1890bv(String.format("Error moving patch for slice %s of pack %s.", new Object[]{dnVar2.f631f, dnVar2.f551k}), dnVar2.f550j);
                }
            }
            inputStream.close();
            if (this.f637d.mo33532a()) {
                afVar = f634a;
                objArr = new Object[]{dnVar2.f631f, dnVar2.f551k};
                str = "Patching and extraction finished for slice %s of pack %s.";
            } else {
                afVar = f634a;
                objArr = new Object[]{dnVar2.f631f, dnVar2.f551k};
                str = "Patching finished for slice %s of pack %s.";
            }
            afVar.mo33553c(str, objArr);
            this.f636c.mo33606a().mo33359a(dnVar2.f550j, dnVar2.f551k, dnVar2.f631f, 0);
            try {
                dnVar2.f633h.close();
                return;
            } catch (IOException unused) {
                f634a.mo33554d("Could not close file for slice %s of pack %s.", dnVar2.f631f, dnVar2.f551k);
                return;
            }
        } catch (IOException e) {
            f634a.mo33552b("IOException during patching %s.", e.getMessage());
            throw new C1890bv(String.format("Error patching slice %s of pack %s.", new Object[]{dnVar2.f631f, dnVar2.f551k}), e, dnVar2.f550j);
        } catch (Throwable th2) {
            C2039ci.m739a(th, th2);
        }
        throw th;
    }
}
