package com.uxcam.internals;

import java.util.HashMap;
import java.util.Map;

/* renamed from: com.uxcam.internals.jz */
public final class C3319jz {

    /* renamed from: a */
    private static Map f2858a = new HashMap();

    /* renamed from: com.uxcam.internals.jz$aa */
    public static class C3320aa implements C3324kd {
        /* renamed from: a */
        public final void mo38565a(C3239hi hiVar, C3239hi hiVar2) {
            for (int i = 0; i < 3; i++) {
                System.arraycopy(hiVar.f2535d[i], 0, hiVar2.f2535d[i], 0, Math.min(hiVar.mo38528a(i) * hiVar.mo38529b(i), hiVar2.mo38528a(i) * hiVar2.mo38529b(i)));
            }
        }
    }

    static {
        HashMap hashMap = new HashMap();
        hashMap.put(C3237hg.RGB, new C3320aa());
        hashMap.put(C3237hg.YUV420, new C3322kb());
        hashMap.put(C3237hg.YUV420J, new C3321ka());
        hashMap.put(C3237hg.YUV422, new C3323kc(0));
        hashMap.put(C3237hg.YUV422_10, new C3323kc(2));
        f2858a.put(C3237hg.RGB, hashMap);
        HashMap hashMap2 = new HashMap();
        hashMap2.put(C3237hg.YUV420, new C3320aa());
        hashMap2.put(C3237hg.RGB, new C3327kg());
        hashMap2.put(C3237hg.YUV422, new C3328kh(0));
        hashMap2.put(C3237hg.YUV422_10, new C3328kh(2));
        f2858a.put(C3237hg.YUV420, hashMap2);
        HashMap hashMap3 = new HashMap();
        hashMap3.put(C3237hg.YUV422, new C3320aa());
        hashMap3.put(C3237hg.RGB, new C3331kk(0));
        hashMap3.put(C3237hg.YUV420, new C3333km(0));
        hashMap3.put(C3237hg.YUV420J, new C3332kl(0));
        f2858a.put(C3237hg.YUV422, hashMap3);
        HashMap hashMap4 = new HashMap();
        hashMap4.put(C3237hg.YUV422_10, new C3320aa());
        hashMap4.put(C3237hg.RGB, new C3331kk(2));
        hashMap4.put(C3237hg.YUV420, new C3333km(2));
        hashMap4.put(C3237hg.YUV420J, new C3332kl(2));
        f2858a.put(C3237hg.YUV422_10, hashMap4);
        HashMap hashMap5 = new HashMap();
        hashMap5.put(C3237hg.YUV444, new C3320aa());
        hashMap5.put(C3237hg.RGB, new C3336kp(0));
        hashMap5.put(C3237hg.YUV420, new C3337kq(0));
        f2858a.put(C3237hg.YUV444, hashMap5);
        HashMap hashMap6 = new HashMap();
        hashMap6.put(C3237hg.YUV444_10, new C3320aa());
        hashMap6.put(C3237hg.RGB, new C3336kp(2));
        hashMap6.put(C3237hg.YUV420, new C3337kq(2));
        f2858a.put(C3237hg.YUV444_10, hashMap6);
        HashMap hashMap7 = new HashMap();
        hashMap7.put(C3237hg.YUV420J, new C3320aa());
        hashMap7.put(C3237hg.RGB, new C3325ke());
        hashMap7.put(C3237hg.YUV420, new C3326kf());
        f2858a.put(C3237hg.YUV420J, hashMap7);
        HashMap hashMap8 = new HashMap();
        hashMap8.put(C3237hg.YUV422J, new C3320aa());
        hashMap8.put(C3237hg.RGB, new C3329ki());
        hashMap8.put(C3237hg.YUV420, new C3330kj());
        hashMap8.put(C3237hg.YUV420J, new C3333km(0));
        f2858a.put(C3237hg.YUV422J, hashMap8);
        HashMap hashMap9 = new HashMap();
        hashMap9.put(C3237hg.YUV444J, new C3320aa());
        hashMap9.put(C3237hg.RGB, new C3334kn());
        hashMap9.put(C3237hg.YUV420, new C3335ko());
        hashMap9.put(C3237hg.YUV420J, new C3337kq(0));
        f2858a.put(C3237hg.YUV444J, hashMap9);
    }

    /* renamed from: a */
    public static C3324kd m2364a(C3237hg hgVar, C3237hg hgVar2) {
        Map map = (Map) f2858a.get(hgVar);
        if (map == null) {
            return null;
        }
        return (C3324kd) map.get(hgVar2);
    }
}
