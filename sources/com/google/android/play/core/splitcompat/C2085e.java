package com.google.android.play.core.splitcompat;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.zip.ZipFile;

/* renamed from: com.google.android.play.core.splitcompat.e */
final class C2085e implements C2088h {

    /* renamed from: a */
    final /* synthetic */ C2097q f830a;

    /* renamed from: b */
    final /* synthetic */ Set f831b;

    /* renamed from: c */
    final /* synthetic */ AtomicBoolean f832c;

    /* renamed from: d */
    final /* synthetic */ C2091k f833d;

    C2085e(C2091k kVar, C2097q qVar, Set set, AtomicBoolean atomicBoolean) {
        this.f833d = kVar;
        this.f830a = qVar;
        this.f831b = set;
        this.f832c = atomicBoolean;
    }

    /* renamed from: a */
    public final void mo33697a(ZipFile zipFile, Set<C2090j> set) throws IOException {
        this.f833d.m903a(this.f830a, set, new C2084d(this));
    }
}
