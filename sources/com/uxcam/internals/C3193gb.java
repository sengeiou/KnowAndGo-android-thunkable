package com.uxcam.internals;

import android.os.Looper;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* renamed from: com.uxcam.internals.gb */
public final class C3193gb extends ArrayList {

    /* renamed from: a */
    private static final ExecutorService f2339a = Executors.newSingleThreadExecutor();

    /* renamed from: b */
    private static String f2340b = "MyArrayList";

    /* renamed from: a */
    public final boolean add(final C2950al alVar) {
        C31941 r0 = new Runnable() {
            /* JADX WARNING: Can't wrap try/catch for region: R(2:35|36) */
            /* JADX WARNING: Code restructure failed: missing block: B:36:?, code lost:
                com.uxcam.internals.C2970bc.m1233a(com.uxcam.internals.C3192ga.f2335b);
             */
            /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x01c4 */
            /* JADX WARNING: Removed duplicated region for block: B:34:0x01bd A[Catch:{ IOException -> 0x01c4 }] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void run() {
                /*
                    r25 = this;
                    r0 = r25
                    com.uxcam.internals.ga r1 = new com.uxcam.internals.ga
                    com.uxcam.internals.C3196gd.m2079a()
                    com.uxcam.internals.gg r2 = com.uxcam.internals.C3196gd.m2092h()
                    r1.<init>(r2)
                    com.uxcam.internals.al r2 = r4
                    com.uxcam.internals.al r3 = r4
                    int r3 = r3.f1296c
                    boolean r4 = com.uxcam.internals.C3192ga.f2334a
                    if (r4 == 0) goto L_0x01dd
                    r4 = 1
                    java.lang.Object[] r5 = new java.lang.Object[r4]
                    java.lang.String r6 = "adding screenshot bitmap into videoooo 111111111111111"
                    r7 = 0
                    r5[r7] = r6
                    com.uxcam.internals.C2970bc.m1234a()
                    android.graphics.Bitmap r5 = r2.f1294a     // Catch:{ Exception -> 0x01d8 }
                    r1.f2337d = r5     // Catch:{ Exception -> 0x01d8 }
                    int r5 = r2.f1295b     // Catch:{ Exception -> 0x01d8 }
                    r1.f2338e = r5     // Catch:{ Exception -> 0x01d8 }
                    java.lang.Object[] r5 = new java.lang.Object[r4]     // Catch:{ Exception -> 0x01d8 }
                    java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01d8 }
                    java.lang.String r8 = "position value: "
                    r6.<init>(r8)     // Catch:{ Exception -> 0x01d8 }
                    int r8 = r1.f2338e     // Catch:{ Exception -> 0x01d8 }
                    r6.append(r8)     // Catch:{ Exception -> 0x01d8 }
                    java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x01d8 }
                    r5[r7] = r6     // Catch:{ Exception -> 0x01d8 }
                    com.uxcam.internals.C2970bc.m1234a()     // Catch:{ Exception -> 0x01d8 }
                    android.graphics.Bitmap r5 = r1.f2337d     // Catch:{ IOException -> 0x01c4 }
                    if (r5 == 0) goto L_0x01c9
                    com.uxcam.internals.gg r5 = r1.f2336c     // Catch:{ IOException -> 0x01c4 }
                    android.graphics.Bitmap r6 = r1.f2337d     // Catch:{ IOException -> 0x01c4 }
                    int r8 = r6.getWidth()     // Catch:{ IOException -> 0x01c4 }
                    java.lang.String r8 = java.lang.String.valueOf(r8)     // Catch:{ IOException -> 0x01c4 }
                    int r8 = java.lang.Integer.parseInt(r8)     // Catch:{ IOException -> 0x01c4 }
                    int r9 = r6.getHeight()     // Catch:{ IOException -> 0x01c4 }
                    java.lang.String r9 = java.lang.String.valueOf(r9)     // Catch:{ IOException -> 0x01c4 }
                    int r9 = java.lang.Integer.parseInt(r9)     // Catch:{ IOException -> 0x01c4 }
                    com.uxcam.internals.hg r10 = com.uxcam.internals.C3237hg.RGB     // Catch:{ IOException -> 0x01c4 }
                    com.uxcam.internals.hi r8 = com.uxcam.internals.C3239hi.m2224a(r8, r9, r10)     // Catch:{ IOException -> 0x01c4 }
                    com.uxcam.internals.C3318jy.m2363a(r6, r8)     // Catch:{ IOException -> 0x01c4 }
                    com.uxcam.internals.hi r6 = r5.f2406b     // Catch:{ IOException -> 0x01c4 }
                    if (r6 != 0) goto L_0x007f
                    int r6 = r8.f2533b     // Catch:{ IOException -> 0x01c4 }
                    int r9 = r8.f2534c     // Catch:{ IOException -> 0x01c4 }
                    com.uxcam.internals.hg[] r10 = com.uxcam.internals.C3212gi.m2134a()     // Catch:{ IOException -> 0x01c4 }
                    r10 = r10[r7]     // Catch:{ IOException -> 0x01c4 }
                    com.uxcam.internals.hi r6 = com.uxcam.internals.C3239hi.m2224a(r6, r9, r10)     // Catch:{ IOException -> 0x01c4 }
                    r5.f2406b = r6     // Catch:{ IOException -> 0x01c4 }
                L_0x007f:
                    float r6 = com.uxcam.internals.C3209gf.f2404a     // Catch:{ IOException -> 0x01c4 }
                    r9 = 0
                    int r6 = (r6 > r9 ? 1 : (r6 == r9 ? 0 : -1))
                    if (r6 > 0) goto L_0x0088
                    com.uxcam.internals.C3209gf.f2405i = r4     // Catch:{ IOException -> 0x01c4 }
                L_0x0088:
                    int r6 = com.uxcam.internals.C3209gf.f2405i     // Catch:{ IOException -> 0x01c4 }
                    int r10 = com.uxcam.internals.C2952an.f1324h     // Catch:{ IOException -> 0x01c4 }
                    r11 = 1000(0x3e8, float:1.401E-42)
                    if (r10 <= r11) goto L_0x0093
                    int r6 = com.uxcam.internals.C2952an.f1324h     // Catch:{ IOException -> 0x01c4 }
                    int r6 = r6 / r11
                L_0x0093:
                    com.uxcam.internals.kd r10 = r5.f2407c     // Catch:{ IOException -> 0x01c4 }
                    com.uxcam.internals.hi r11 = r5.f2406b     // Catch:{ IOException -> 0x01c4 }
                    r10.mo38565a(r8, r11)     // Catch:{ IOException -> 0x01c4 }
                    java.nio.ByteBuffer r8 = r5.f2412h     // Catch:{ IOException -> 0x01c4 }
                    r8.clear()     // Catch:{ IOException -> 0x01c4 }
                    com.uxcam.internals.gi r8 = r5.f2408d     // Catch:{ IOException -> 0x01c4 }
                    com.uxcam.internals.hi r10 = r5.f2406b     // Catch:{ IOException -> 0x01c4 }
                    java.nio.ByteBuffer r11 = r5.f2412h     // Catch:{ IOException -> 0x01c4 }
                    java.nio.ByteBuffer r13 = r11.duplicate()     // Catch:{ IOException -> 0x01c4 }
                    com.uxcam.internals.hl r11 = new com.uxcam.internals.hl     // Catch:{ IOException -> 0x01c4 }
                    com.uxcam.internals.hk r12 = r10.f2536e     // Catch:{ IOException -> 0x01c4 }
                    if (r12 != 0) goto L_0x00b2
                    int r12 = r10.f2533b     // Catch:{ IOException -> 0x01c4 }
                    goto L_0x00b6
                L_0x00b2:
                    com.uxcam.internals.hk r12 = r10.f2536e     // Catch:{ IOException -> 0x01c4 }
                    int r12 = r12.f2539a     // Catch:{ IOException -> 0x01c4 }
                L_0x00b6:
                    com.uxcam.internals.hk r14 = r10.f2536e     // Catch:{ IOException -> 0x01c4 }
                    if (r14 != 0) goto L_0x00bd
                    int r14 = r10.f2534c     // Catch:{ IOException -> 0x01c4 }
                    goto L_0x00c1
                L_0x00bd:
                    com.uxcam.internals.hk r14 = r10.f2536e     // Catch:{ IOException -> 0x01c4 }
                    int r14 = r14.f2540b     // Catch:{ IOException -> 0x01c4 }
                L_0x00c1:
                    r11.<init>(r12, r14)     // Catch:{ IOException -> 0x01c4 }
                    com.uxcam.video.screen.codec.codecs.h264.io.model.SeqParameterSet r12 = new com.uxcam.video.screen.codec.codecs.h264.io.model.SeqParameterSet     // Catch:{ IOException -> 0x01c4 }
                    r12.<init>()     // Catch:{ IOException -> 0x01c4 }
                    int r14 = r11.f2543a     // Catch:{ IOException -> 0x01c4 }
                    int r14 = r14 + 15
                    int r14 = r14 >> 4
                    int r14 = r14 - r4
                    r12.pic_width_in_mbs_minus1 = r14     // Catch:{ IOException -> 0x01c4 }
                    int r14 = r11.f2544b     // Catch:{ IOException -> 0x01c4 }
                    int r14 = r14 + 15
                    int r14 = r14 >> 4
                    int r14 = r14 - r4
                    r12.pic_height_in_map_units_minus1 = r14     // Catch:{ IOException -> 0x01c4 }
                    com.uxcam.internals.hg r14 = com.uxcam.internals.C3237hg.YUV420     // Catch:{ IOException -> 0x01c4 }
                    r12.chroma_format_idc = r14     // Catch:{ IOException -> 0x01c4 }
                    r14 = 66
                    r12.profile_idc = r14     // Catch:{ IOException -> 0x01c4 }
                    r14 = 40
                    r12.level_idc = r14     // Catch:{ IOException -> 0x01c4 }
                    r12.frame_mbs_only_flag = r4     // Catch:{ IOException -> 0x01c4 }
                    int r14 = r12.pic_width_in_mbs_minus1     // Catch:{ IOException -> 0x01c4 }
                    int r14 = r14 + r4
                    int r14 = r14 << 4
                    int r15 = r12.pic_height_in_map_units_minus1     // Catch:{ IOException -> 0x01c4 }
                    int r15 = r15 + r4
                    int r15 = r15 << 4
                    int r9 = r11.f2543a     // Catch:{ IOException -> 0x01c4 }
                    if (r14 != r9) goto L_0x00fe
                    int r9 = r11.f2544b     // Catch:{ IOException -> 0x01c4 }
                    if (r15 == r9) goto L_0x00fc
                    goto L_0x00fe
                L_0x00fc:
                    r9 = 0
                    goto L_0x00ff
                L_0x00fe:
                    r9 = 1
                L_0x00ff:
                    r12.frame_cropping_flag = r9     // Catch:{ IOException -> 0x01c4 }
                    int r9 = r11.f2543a     // Catch:{ IOException -> 0x01c4 }
                    int r14 = r14 - r9
                    int r14 = r14 + r4
                    int r9 = r14 >> 1
                    r12.frame_crop_right_offset = r9     // Catch:{ IOException -> 0x01c4 }
                    int r9 = r11.f2544b     // Catch:{ IOException -> 0x01c4 }
                    int r15 = r15 - r9
                    int r15 = r15 + r4
                    int r9 = r15 >> 1
                    r12.frame_crop_bottom_offset = r9     // Catch:{ IOException -> 0x01c4 }
                    com.uxcam.video.screen.codec.codecs.h264.io.model.PictureParameterSet r9 = new com.uxcam.video.screen.codec.codecs.h264.io.model.PictureParameterSet     // Catch:{ IOException -> 0x01c4 }
                    r9.<init>()     // Catch:{ IOException -> 0x01c4 }
                    r11 = -6
                    r9.pic_init_qp_minus26 = r11     // Catch:{ IOException -> 0x01c4 }
                    r13.putInt(r4)     // Catch:{ IOException -> 0x01c4 }
                    com.uxcam.video.screen.codec.codecs.h264.io.model.NALUnit r11 = new com.uxcam.video.screen.codec.codecs.h264.io.model.NALUnit     // Catch:{ IOException -> 0x01c4 }
                    com.uxcam.video.screen.codec.codecs.h264.io.model.NALUnitType r14 = com.uxcam.video.screen.codec.codecs.h264.p018io.model.NALUnitType.SPS     // Catch:{ IOException -> 0x01c4 }
                    r15 = 3
                    r11.<init>(r14, r15)     // Catch:{ IOException -> 0x01c4 }
                    r11.write(r13)     // Catch:{ IOException -> 0x01c4 }
                    r11 = 1024(0x400, float:1.435E-42)
                    java.nio.ByteBuffer r14 = java.nio.ByteBuffer.allocate(r11)     // Catch:{ IOException -> 0x01c4 }
                    r12.write(r14)     // Catch:{ IOException -> 0x01c4 }
                    r14.flip()     // Catch:{ IOException -> 0x01c4 }
                    com.uxcam.internals.C3213gj.m2144a((java.nio.ByteBuffer) r14, (java.nio.ByteBuffer) r13)     // Catch:{ IOException -> 0x01c4 }
                    r13.putInt(r4)     // Catch:{ IOException -> 0x01c4 }
                    com.uxcam.video.screen.codec.codecs.h264.io.model.NALUnit r14 = new com.uxcam.video.screen.codec.codecs.h264.io.model.NALUnit     // Catch:{ IOException -> 0x01c4 }
                    com.uxcam.video.screen.codec.codecs.h264.io.model.NALUnitType r7 = com.uxcam.video.screen.codec.codecs.h264.p018io.model.NALUnitType.PPS     // Catch:{ IOException -> 0x01c4 }
                    r14.<init>(r7, r15)     // Catch:{ IOException -> 0x01c4 }
                    r14.write(r13)     // Catch:{ IOException -> 0x01c4 }
                    java.nio.ByteBuffer r7 = java.nio.ByteBuffer.allocate(r11)     // Catch:{ IOException -> 0x01c4 }
                    r9.write(r7)     // Catch:{ IOException -> 0x01c4 }
                    r7.flip()     // Catch:{ IOException -> 0x01c4 }
                    com.uxcam.internals.C3213gj.m2144a((java.nio.ByteBuffer) r7, (java.nio.ByteBuffer) r13)     // Catch:{ IOException -> 0x01c4 }
                    int r7 = r12.pic_width_in_mbs_minus1     // Catch:{ IOException -> 0x01c4 }
                    int r7 = r7 + r4
                    int[][] r11 = new int[r15][]     // Catch:{ IOException -> 0x01c4 }
                    r14 = 16
                    int[] r14 = new int[r14]     // Catch:{ IOException -> 0x01c4 }
                    r16 = 0
                    r11[r16] = r14     // Catch:{ IOException -> 0x01c4 }
                    r14 = 8
                    int[] r15 = new int[r14]     // Catch:{ IOException -> 0x01c4 }
                    r11[r4] = r15     // Catch:{ IOException -> 0x01c4 }
                    int[] r14 = new int[r14]     // Catch:{ IOException -> 0x01c4 }
                    r15 = 2
                    r11[r15] = r14     // Catch:{ IOException -> 0x01c4 }
                    r8.f2428a = r11     // Catch:{ IOException -> 0x01c4 }
                    r11 = 3
                    int[][] r14 = new int[r11][]     // Catch:{ IOException -> 0x01c4 }
                    int r15 = r7 << 4
                    int[] r15 = new int[r15]     // Catch:{ IOException -> 0x01c4 }
                    r16 = 0
                    r14[r16] = r15     // Catch:{ IOException -> 0x01c4 }
                    int r7 = r7 << r11
                    int[] r11 = new int[r7]     // Catch:{ IOException -> 0x01c4 }
                    r14[r4] = r11     // Catch:{ IOException -> 0x01c4 }
                    int[] r4 = new int[r7]     // Catch:{ IOException -> 0x01c4 }
                    r7 = 2
                    r14[r7] = r4     // Catch:{ IOException -> 0x01c4 }
                    r8.f2429b = r14     // Catch:{ IOException -> 0x01c4 }
                    r8.mo38502a((com.uxcam.video.screen.codec.codecs.h264.p018io.model.SeqParameterSet) r12, (com.uxcam.video.screen.codec.codecs.h264.p018io.model.PictureParameterSet) r9, (com.uxcam.internals.C3239hi) r10, (java.nio.ByteBuffer) r13)     // Catch:{ IOException -> 0x01c4 }
                    r13.flip()     // Catch:{ IOException -> 0x01c4 }
                    java.util.ArrayList r4 = r5.f2409e     // Catch:{ IOException -> 0x01c4 }
                    r4.clear()     // Catch:{ IOException -> 0x01c4 }
                    java.util.ArrayList r4 = r5.f2410f     // Catch:{ IOException -> 0x01c4 }
                    r4.clear()     // Catch:{ IOException -> 0x01c4 }
                    java.util.ArrayList r4 = r5.f2409e     // Catch:{ IOException -> 0x01c4 }
                    java.util.ArrayList r7 = r5.f2410f     // Catch:{ IOException -> 0x01c4 }
                    com.uxcam.internals.C3213gj.m2145a(r13, r4, r7)     // Catch:{ IOException -> 0x01c4 }
                    com.uxcam.internals.C3213gj.m2143a((java.nio.ByteBuffer) r13)     // Catch:{ IOException -> 0x01c4 }
                    com.uxcam.internals.ju r4 = r5.f2411g     // Catch:{ IOException -> 0x01c4 }
                    com.uxcam.internals.hr r5 = new com.uxcam.internals.hr     // Catch:{ IOException -> 0x01c4 }
                    int r7 = r3 * r6
                    long r7 = (long) r7     // Catch:{ IOException -> 0x01c4 }
                    r16 = 1
                    long r9 = (long) r6     // Catch:{ IOException -> 0x01c4 }
                    long r14 = (long) r3     // Catch:{ IOException -> 0x01c4 }
                    r24 = 0
                    r12 = r5
                    r20 = r14
                    r14 = r7
                    r18 = r9
                    r22 = r7
                    r12.<init>(r13, r14, r16, r18, r20, r22, r24)     // Catch:{ IOException -> 0x01c4 }
                    r4.mo38560a((com.uxcam.internals.C3248hr) r5)     // Catch:{ IOException -> 0x01c4 }
                    float r3 = com.uxcam.internals.C3165fk.f2260f     // Catch:{ IOException -> 0x01c4 }
                    r4 = 0
                    int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
                    if (r3 > 0) goto L_0x01c9
                    float r3 = com.uxcam.internals.C3183fy.m2041c()     // Catch:{ IOException -> 0x01c4 }
                    com.uxcam.internals.C3165fk.f2260f = r3     // Catch:{ IOException -> 0x01c4 }
                    goto L_0x01c9
                L_0x01c4:
                    java.lang.String r3 = com.uxcam.internals.C3192ga.f2335b     // Catch:{ Exception -> 0x01d8 }
                    com.uxcam.internals.C2970bc.m1233a((java.lang.String) r3)     // Catch:{ Exception -> 0x01d8 }
                L_0x01c9:
                    com.uxcam.internals.gb r3 = com.uxcam.internals.C3196gd.f2354a     // Catch:{ Exception -> 0x01d8 }
                    r3.remove(r2)     // Catch:{ Exception -> 0x01d8 }
                    com.uxcam.internals.gd r2 = com.uxcam.internals.C3196gd.m2079a()     // Catch:{ Exception -> 0x01d8 }
                    com.uxcam.internals.gg r1 = r1.f2336c     // Catch:{ Exception -> 0x01d8 }
                    r2.mo38490a((com.uxcam.internals.C3210gg) r1)     // Catch:{ Exception -> 0x01d8 }
                    return
                L_0x01d8:
                    java.lang.String r1 = com.uxcam.internals.C3192ga.f2335b
                    com.uxcam.internals.C2970bc.m1233a((java.lang.String) r1)
                L_0x01dd:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.uxcam.internals.C3193gb.C31941.run():void");
            }
        };
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            f2339a.submit(r0);
        } else {
            r0.run();
        }
        return super.add(alVar);
    }
}
