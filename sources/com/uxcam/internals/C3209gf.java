package com.uxcam.internals;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.uxcam.internals.gf */
public class C3209gf {

    /* renamed from: a */
    public static float f2404a = 1.0f;

    /* renamed from: i */
    public static int f2405i = 1;

    /* renamed from: b */
    public C3239hi f2406b;

    /* renamed from: c */
    public C3324kd f2407c;

    /* renamed from: d */
    public C3212gi f2408d;

    /* renamed from: e */
    public ArrayList f2409e;

    /* renamed from: f */
    public ArrayList f2410f;

    /* renamed from: g */
    public C3312ju f2411g;

    /* renamed from: h */
    public ByteBuffer f2412h;

    /* renamed from: j */
    long f2413j;

    /* renamed from: k */
    private C3230ha f2414k;

    /* renamed from: l */
    private C3313jv f2415l;

    /* renamed from: m */
    private final int f2416m = 1;

    public C3209gf(File file) {
        this.f2414k = new C3224gu(new FileOutputStream(file).getChannel());
        this.f2413j = C2923aa.m1098b();
        this.f2415l = new C3313jv(this.f2414k, C3247hq.MP4);
        this.f2411g = this.f2415l.mo38561a(C3251hu.VIDEO);
        this.f2412h = ByteBuffer.allocate(4194304);
        this.f2408d = new C3212gi();
        this.f2407c = C3319jz.m2364a(C3237hg.RGB, C3212gi.m2134a()[0]);
        this.f2409e = new ArrayList();
        this.f2410f = new ArrayList();
    }

    /* renamed from: a */
    public final void mo38501a() {
        this.f2411g.mo38554a(C3213gj.m2142a((List) this.f2409e, (List) this.f2410f));
        this.f2415l.mo38562a();
        C3229gz.m2202a((ReadableByteChannel) this.f2414k);
    }
}
