package com.uxcam.internals;

import java.nio.ByteBuffer;

/* renamed from: com.uxcam.internals.hh */
public class C3238hh {

    /* renamed from: a */
    public ByteBuffer f2524a;

    /* renamed from: b */
    public long f2525b;

    /* renamed from: c */
    public long f2526c;

    /* renamed from: d */
    public boolean f2527d;

    /* renamed from: e */
    public C3243hm f2528e;

    /* renamed from: f */
    public int f2529f;

    /* renamed from: g */
    private long f2530g;

    /* renamed from: h */
    private long f2531h;

    public C3238hh(C3238hh hhVar) {
        this((ByteBuffer) null, hhVar.f2525b, hhVar.f2530g, hhVar.f2526c, hhVar.f2531h, hhVar.f2527d, hhVar.f2528e);
        this.f2529f = hhVar.f2529f;
    }

    public C3238hh(ByteBuffer byteBuffer, long j, long j2, long j3, long j4, boolean z, C3243hm hmVar) {
        this(byteBuffer, j, j2, j3, j4, z, hmVar, (byte) 0);
    }

    private C3238hh(ByteBuffer byteBuffer, long j, long j2, long j3, long j4, boolean z, C3243hm hmVar, byte b) {
        this.f2524a = byteBuffer;
        this.f2525b = j;
        this.f2530g = j2;
        this.f2526c = j3;
        this.f2531h = j4;
        this.f2527d = z;
        this.f2528e = hmVar;
        this.f2529f = 0;
    }
}
