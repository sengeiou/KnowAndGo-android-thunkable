package com.uxcam.internals;

import com.amplitude.api.Constants;
import java.nio.ByteBuffer;

/* renamed from: com.uxcam.internals.iv */
public class C3281iv extends C3273in {

    /* renamed from: c */
    private long f2670c;

    /* renamed from: e */
    private long f2671e;

    /* renamed from: f */
    private int f2672f;

    /* renamed from: g */
    private long f2673g;

    /* renamed from: h */
    private int f2674h;

    /* renamed from: i */
    private int f2675i;

    public C3281iv() {
        super(new C3277ir("mdhd"));
    }

    public C3281iv(int i, long j, long j2, long j3) {
        super(new C3277ir("mdhd"));
        this.f2672f = i;
        this.f2673g = j;
        this.f2674h = 0;
        this.f2670c = j2;
        this.f2671e = j3;
        this.f2675i = 0;
    }

    /* renamed from: a */
    public static String m2287a() {
        return "mdhd";
    }

    /* renamed from: a */
    public final void mo38539a(StringBuilder sb) {
        super.mo38539a(sb);
        sb.append(": ");
        C3246hp.m2232a(this, sb, "created", "modified", "timescale", "duration", Constants.AMP_TRACKING_OPTION_LANGUAGE, "quality");
    }

    /* renamed from: a */
    public final void mo38506a(ByteBuffer byteBuffer) {
        super.mo38506a(byteBuffer);
        byteBuffer.putInt(C3250ht.m2235a(this.f2670c));
        byteBuffer.putInt(C3250ht.m2235a(this.f2671e));
        byteBuffer.putInt(this.f2672f);
        byteBuffer.putInt((int) this.f2673g);
        byteBuffer.putShort((short) this.f2674h);
        byteBuffer.putShort((short) this.f2675i);
    }
}
