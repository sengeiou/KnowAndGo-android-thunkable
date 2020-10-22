package com.google.android.play.core.splitinstall.testing;

import android.content.Intent;
import com.google.android.play.core.splitinstall.C2127d;
import java.util.List;

/* renamed from: com.google.android.play.core.splitinstall.testing.i */
final class C2153i implements C2127d {

    /* renamed from: a */
    final /* synthetic */ List f989a;

    /* renamed from: b */
    final /* synthetic */ List f990b;

    /* renamed from: c */
    final /* synthetic */ long f991c;

    /* renamed from: d */
    final /* synthetic */ boolean f992d;

    /* renamed from: e */
    final /* synthetic */ List f993e;

    /* renamed from: f */
    final /* synthetic */ FakeSplitInstallManager f994f;

    C2153i(FakeSplitInstallManager fakeSplitInstallManager, List list, List list2, long j, boolean z, List list3) {
        this.f994f = fakeSplitInstallManager;
        this.f989a = list;
        this.f990b = list2;
        this.f991c = j;
        this.f992d = z;
        this.f993e = list3;
    }

    /* renamed from: a */
    public final void mo33759a() {
        this.f994f.f959l.addAll(this.f989a);
        this.f994f.f960m.addAll(this.f990b);
        this.f994f.m1024a(5, 0, Long.valueOf(this.f991c), Long.valueOf(this.f991c), (List<String>) null, (Integer) null, (List<String>) null);
    }

    /* renamed from: a */
    public final void mo33760a(int i) {
        this.f994f.m1023a(i);
    }

    /* renamed from: b */
    public final void mo33761b() {
        if (!this.f992d) {
            this.f994f.m1022a((List<Intent>) this.f993e, (List<String>) this.f989a, (List<String>) this.f990b, this.f991c, true);
        }
    }
}
