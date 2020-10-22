package com.google.android.play.core.splitinstall.testing;

import com.google.android.play.core.splitinstall.SplitInstallSessionState;
import java.util.List;

/* renamed from: com.google.android.play.core.splitinstall.testing.b */
final /* synthetic */ class C2146b implements C2154j {

    /* renamed from: a */
    private final Integer f965a;

    /* renamed from: b */
    private final int f966b;

    /* renamed from: c */
    private final int f967c;

    /* renamed from: d */
    private final Long f968d;

    /* renamed from: e */
    private final Long f969e;

    /* renamed from: f */
    private final List f970f;

    /* renamed from: g */
    private final List f971g;

    C2146b(Integer num, int i, int i2, Long l, Long l2, List list, List list2) {
        this.f965a = num;
        this.f966b = i;
        this.f967c = i2;
        this.f968d = l;
        this.f969e = l2;
        this.f970f = list;
        this.f971g = list2;
    }

    /* renamed from: a */
    public final SplitInstallSessionState mo33777a(SplitInstallSessionState splitInstallSessionState) {
        return FakeSplitInstallManager.m1016a(this.f965a, this.f966b, this.f967c, this.f968d, this.f969e, this.f970f, this.f971g, splitInstallSessionState);
    }
}
