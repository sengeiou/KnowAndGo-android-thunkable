package com.uxcam.internals;

import com.facebook.imagepipeline.producers.DecodeProducer;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* renamed from: com.uxcam.internals.hw */
public class C3254hw extends C3292jf {

    /* renamed from: a */
    public static int f2592a = 1;

    /* renamed from: b */
    public static int f2593b = 2;

    /* renamed from: c */
    public static Set f2594c;

    /* renamed from: g */
    private static Map f2595g = new HashMap();

    /* renamed from: h */
    private static Map f2596h = new HashMap();

    /* renamed from: i */
    private short f2597i;

    /* renamed from: j */
    private short f2598j;

    /* renamed from: k */
    private float f2599k;

    /* renamed from: l */
    private short f2600l;

    /* renamed from: m */
    private int f2601m;

    /* renamed from: n */
    private int f2602n;

    /* renamed from: o */
    private int f2603o;

    /* renamed from: p */
    private int f2604p;

    /* renamed from: q */
    private int f2605q;

    /* renamed from: r */
    private int f2606r;

    /* renamed from: s */
    private int f2607s;

    /* renamed from: t */
    private short f2608t;

    /* renamed from: u */
    private int f2609u;

    static {
        HashSet hashSet = new HashSet();
        f2594c = hashSet;
        hashSet.add("raw ");
        f2594c.add("twos");
        f2594c.add("sowt");
        f2594c.add("fl32");
        f2594c.add("fl64");
        f2594c.add("in24");
        f2594c.add("in32");
        f2594c.add("lpcm");
        f2595g.put(C3309js.Left, C3236hf.STEREO_LEFT);
        f2595g.put(C3309js.Right, C3236hf.STEREO_RIGHT);
        f2595g.put(C3309js.HeadphonesLeft, C3236hf.STEREO_LEFT);
        f2595g.put(C3309js.HeadphonesRight, C3236hf.STEREO_RIGHT);
        f2595g.put(C3309js.LeftTotal, C3236hf.STEREO_LEFT);
        f2595g.put(C3309js.RightTotal, C3236hf.STEREO_RIGHT);
        f2595g.put(C3309js.LeftWide, C3236hf.STEREO_LEFT);
        f2595g.put(C3309js.RightWide, C3236hf.STEREO_RIGHT);
        f2596h.put(C3309js.Left, C3236hf.FRONT_LEFT);
        f2596h.put(C3309js.Right, C3236hf.FRONT_RIGHT);
        f2596h.put(C3309js.LeftCenter, C3236hf.FRONT_CENTER_LEFT);
        f2596h.put(C3309js.RightCenter, C3236hf.FRONT_CENTER_RIGHT);
        f2596h.put(C3309js.Center, C3236hf.CENTER);
        f2596h.put(C3309js.CenterSurround, C3236hf.REAR_CENTER);
        f2596h.put(C3309js.CenterSurroundDirect, C3236hf.REAR_CENTER);
        f2596h.put(C3309js.LeftSurround, C3236hf.REAR_LEFT);
        f2596h.put(C3309js.LeftSurroundDirect, C3236hf.REAR_LEFT);
        f2596h.put(C3309js.RightSurround, C3236hf.REAR_RIGHT);
        f2596h.put(C3309js.RightSurroundDirect, C3236hf.REAR_RIGHT);
        f2596h.put(C3309js.RearSurroundLeft, C3236hf.SIDE_LEFT);
        f2596h.put(C3309js.RearSurroundRight, C3236hf.SIDE_RIGHT);
        f2596h.put(C3309js.LFE2, C3236hf.LFE);
        f2596h.put(C3309js.LFEScreen, C3236hf.LFE);
        f2596h.put(C3309js.LeftTotal, C3236hf.STEREO_LEFT);
        f2596h.put(C3309js.RightTotal, C3236hf.STEREO_RIGHT);
        f2596h.put(C3309js.LeftWide, C3236hf.STEREO_LEFT);
        f2596h.put(C3309js.RightWide, C3236hf.STEREO_RIGHT);
    }

    /* renamed from: a */
    public final void mo38539a(StringBuilder sb) {
        sb.append(this.f2610d.f2662a + ": {\n");
        sb.append("entry: ");
        C3246hp.m2232a(this, sb, "channelCount", DecodeProducer.SAMPLE_SIZE, "sampleRat", "revision", "vendor", "compressionId", "pktSize", "samplesPerPkt", "bytesPerPkt", "bytesPerFrame", "bytesPerSample", "version", "lpcmFlags");
        sb.append(",\nexts: [\n");
        mo38549b(sb);
        sb.append("\n]\n");
        sb.append("}\n");
    }

    /* renamed from: a */
    public final void mo38506a(ByteBuffer byteBuffer) {
        int i;
        super.mo38506a(byteBuffer);
        byteBuffer.putShort(this.f2608t);
        byteBuffer.putShort(this.f2600l);
        byteBuffer.putInt(this.f2601m);
        if (this.f2608t < 2) {
            byteBuffer.putShort(this.f2597i);
            if (this.f2608t == 0) {
                byteBuffer.putShort(this.f2598j);
            } else {
                byteBuffer.putShort(16);
            }
            byteBuffer.putShort((short) this.f2602n);
            byteBuffer.putShort((short) this.f2603o);
            byteBuffer.putInt((int) Math.round(((double) this.f2599k) * 65536.0d));
            if (this.f2608t == 1) {
                byteBuffer.putInt(this.f2604p);
                byteBuffer.putInt(this.f2605q);
                byteBuffer.putInt(this.f2606r);
                i = this.f2607s;
            }
            mo38550c(byteBuffer);
        }
        if (this.f2608t == 2) {
            byteBuffer.putShort(3);
            byteBuffer.putShort(16);
            byteBuffer.putShort(-2);
            byteBuffer.putShort(0);
            byteBuffer.putInt(65536);
            byteBuffer.putInt(72);
            byteBuffer.putLong(Double.doubleToLongBits((double) this.f2599k));
            byteBuffer.putInt(this.f2597i);
            byteBuffer.putInt(2130706432);
            byteBuffer.putInt(this.f2598j);
            byteBuffer.putInt(this.f2609u);
            byteBuffer.putInt(this.f2606r);
            i = this.f2604p;
        }
        mo38550c(byteBuffer);
        byteBuffer.putInt(i);
        mo38550c(byteBuffer);
    }
}
