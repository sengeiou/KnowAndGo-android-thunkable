package com.google.android.play.core.assetpacks;

import com.google.android.play.core.assetpacks.model.AssetPackStatus;
import java.io.InputStream;

/* renamed from: com.google.android.play.core.assetpacks.bs */
final class C1887bs extends C1913cr {

    /* renamed from: a */
    final int f458a;

    /* renamed from: b */
    final long f459b;

    /* renamed from: c */
    final String f460c;

    /* renamed from: d */
    final int f461d;

    /* renamed from: e */
    final int f462e;

    /* renamed from: f */
    final int f463f;

    /* renamed from: g */
    final long f464g;
    @AssetPackStatus

    /* renamed from: h */
    final int f465h;

    /* renamed from: i */
    final InputStream f466i;

    C1887bs(int i, String str, int i2, long j, String str2, int i3, int i4, int i5, long j2, @AssetPackStatus int i6, InputStream inputStream) {
        super(i, str);
        this.f458a = i2;
        this.f459b = j;
        this.f460c = str2;
        this.f461d = i3;
        this.f462e = i4;
        this.f463f = i5;
        this.f464g = j2;
        this.f465h = i6;
        this.f466i = inputStream;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final boolean mo33429a() {
        return this.f462e + 1 == this.f463f;
    }
}
