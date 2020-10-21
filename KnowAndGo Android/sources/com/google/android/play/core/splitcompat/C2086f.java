package com.google.android.play.core.splitcompat;

import java.io.IOException;
import java.util.Set;
import java.util.zip.ZipFile;

/* renamed from: com.google.android.play.core.splitcompat.f */
final class C2086f implements C2088h {

    /* renamed from: a */
    final /* synthetic */ Set f834a;

    /* renamed from: b */
    final /* synthetic */ C2097q f835b;

    /* renamed from: c */
    final /* synthetic */ C2091k f836c;

    C2086f(C2091k kVar, Set set, C2097q qVar) {
        this.f836c = kVar;
        this.f834a = set;
        this.f835b = qVar;
    }

    /* renamed from: a */
    public final void mo33697a(ZipFile zipFile, Set<C2090j> set) throws IOException {
        this.f834a.addAll(C2091k.m900a(this.f836c, (Set) set, this.f835b, zipFile));
    }
}
