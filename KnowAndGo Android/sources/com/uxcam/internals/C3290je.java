package com.uxcam.internals;

import com.google.android.exoplayer2.source.hls.DefaultHlsExtractorFactory;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.uxcam.internals.je */
public class C3290je extends C3286ja {

    /* renamed from: a */
    public static final C3291aa f2689a = new C3291aa();

    /* renamed from: com.uxcam.internals.je$aa */
    public static class C3291aa extends C3256hy {

        /* renamed from: a */
        private Map f2690a = new HashMap();

        public C3291aa() {
            this.f2690a.put("ap4h", C3307jr.class);
            this.f2690a.put("apch", C3307jr.class);
            this.f2690a.put("apcn", C3307jr.class);
            this.f2690a.put("apcs", C3307jr.class);
            this.f2690a.put("apco", C3307jr.class);
            this.f2690a.put("avc1", C3307jr.class);
            this.f2690a.put("cvid", C3307jr.class);
            this.f2690a.put("jpeg", C3307jr.class);
            this.f2690a.put("smc ", C3307jr.class);
            this.f2690a.put("rle ", C3307jr.class);
            this.f2690a.put("rpza", C3307jr.class);
            this.f2690a.put("kpcd", C3307jr.class);
            this.f2690a.put("png ", C3307jr.class);
            this.f2690a.put("mjpa", C3307jr.class);
            this.f2690a.put("mjpb", C3307jr.class);
            this.f2690a.put("SVQ1", C3307jr.class);
            this.f2690a.put("SVQ3", C3307jr.class);
            this.f2690a.put("mp4v", C3307jr.class);
            this.f2690a.put("dvc ", C3307jr.class);
            this.f2690a.put("dvcp", C3307jr.class);
            this.f2690a.put("gif ", C3307jr.class);
            this.f2690a.put("h263", C3307jr.class);
            this.f2690a.put("tiff", C3307jr.class);
            this.f2690a.put("raw ", C3307jr.class);
            this.f2690a.put("2vuY", C3307jr.class);
            this.f2690a.put("yuv2", C3307jr.class);
            this.f2690a.put("v308", C3307jr.class);
            this.f2690a.put("v408", C3307jr.class);
            this.f2690a.put("v216", C3307jr.class);
            this.f2690a.put("v410", C3307jr.class);
            this.f2690a.put("v210", C3307jr.class);
            this.f2690a.put("m2v1", C3307jr.class);
            this.f2690a.put("m1v1", C3307jr.class);
            this.f2690a.put("xd5b", C3307jr.class);
            this.f2690a.put("dv5n", C3307jr.class);
            this.f2690a.put("jp2h", C3307jr.class);
            this.f2690a.put("mjp2", C3307jr.class);
            this.f2690a.put("ac-3", C3254hw.class);
            this.f2690a.put("cac3", C3254hw.class);
            this.f2690a.put("ima4", C3254hw.class);
            this.f2690a.put("aac ", C3254hw.class);
            this.f2690a.put("celp", C3254hw.class);
            this.f2690a.put("hvxc", C3254hw.class);
            this.f2690a.put("twvq", C3254hw.class);
            this.f2690a.put(".mp1", C3254hw.class);
            this.f2690a.put(".mp2", C3254hw.class);
            this.f2690a.put("midi", C3254hw.class);
            this.f2690a.put("apvs", C3254hw.class);
            this.f2690a.put("alac", C3254hw.class);
            this.f2690a.put("aach", C3254hw.class);
            this.f2690a.put("aacl", C3254hw.class);
            this.f2690a.put("aace", C3254hw.class);
            this.f2690a.put("aacf", C3254hw.class);
            this.f2690a.put("aacp", C3254hw.class);
            this.f2690a.put("aacs", C3254hw.class);
            this.f2690a.put("samr", C3254hw.class);
            this.f2690a.put("AUDB", C3254hw.class);
            this.f2690a.put("ilbc", C3254hw.class);
            this.f2690a.put("ms\u0000\u0011", C3254hw.class);
            this.f2690a.put("ms\u00001", C3254hw.class);
            this.f2690a.put("aes3", C3254hw.class);
            this.f2690a.put("NONE", C3254hw.class);
            this.f2690a.put("raw ", C3254hw.class);
            this.f2690a.put("twos", C3254hw.class);
            this.f2690a.put("sowt", C3254hw.class);
            this.f2690a.put("MAC3 ", C3254hw.class);
            this.f2690a.put("MAC6 ", C3254hw.class);
            this.f2690a.put("ima4", C3254hw.class);
            this.f2690a.put("fl32", C3254hw.class);
            this.f2690a.put("fl64", C3254hw.class);
            this.f2690a.put("in24", C3254hw.class);
            this.f2690a.put("in32", C3254hw.class);
            this.f2690a.put("ulaw", C3254hw.class);
            this.f2690a.put("alaw", C3254hw.class);
            this.f2690a.put("dvca", C3254hw.class);
            this.f2690a.put("QDMC", C3254hw.class);
            this.f2690a.put("QDM2", C3254hw.class);
            this.f2690a.put("Qclp", C3254hw.class);
            this.f2690a.put(DefaultHlsExtractorFactory.MP3_FILE_EXTENSION, C3254hw.class);
            this.f2690a.put("mp4a", C3254hw.class);
            this.f2690a.put("lpcm", C3254hw.class);
            this.f2690a.put("tmcd", C3301jm.class);
            this.f2690a.put("time", C3301jm.class);
            this.f2690a.put("c608", C3292jf.class);
            this.f2690a.put("c708", C3292jf.class);
            this.f2690a.put("text", C3292jf.class);
        }
    }

    public C3290je() {
        this(new C3277ir("stsd"));
    }

    private C3290je(C3277ir irVar) {
        super(irVar);
        this.f2686f = f2689a;
    }

    public C3290je(C3292jf... jfVarArr) {
        this();
        for (C3292jf add : jfVarArr) {
            this.f2685e.add(add);
        }
    }

    /* renamed from: a */
    public static String m2308a() {
        return "stsd";
    }

    /* renamed from: a */
    public final void mo38506a(ByteBuffer byteBuffer) {
        byteBuffer.putInt(0);
        byteBuffer.putInt(this.f2685e.size());
        super.mo38506a(byteBuffer);
    }
}
