package com.uxcam.internals;

import android.annotation.TargetApi;
import android.graphics.Canvas;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.os.Handler;
import android.os.Message;
import android.view.Surface;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;

@TargetApi(18)
/* renamed from: com.uxcam.internals.kw */
public final class C3344kw {

    /* renamed from: a */
    public static int f2913a = 1;

    /* renamed from: b */
    public String f2914b;

    /* renamed from: c */
    int f2915c = 150000;

    /* renamed from: d */
    public C3346ab f2916d;

    /* renamed from: e */
    public C3347ac f2917e = new C3347ac(this, (byte) 0);

    /* renamed from: f */
    public ArrayList f2918f = new ArrayList();

    /* renamed from: g */
    C3345aa f2919g = new C3345aa(this);
    /* access modifiers changed from: private */

    /* renamed from: h */
    public MediaCodec f2920h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public Surface f2921i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public MediaMuxer f2922j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public int f2923k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public boolean f2924l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public MediaCodec.BufferInfo f2925m;

    /* renamed from: com.uxcam.internals.kw$aa */
    static class C3345aa extends Handler {

        /* renamed from: a */
        C3344kw f2926a;

        public C3345aa(C3344kw kwVar) {
            this.f2926a = kwVar;
        }

        public final void handleMessage(Message message) {
            if (message.what != 100) {
                return;
            }
            if (message.arg1 == 101) {
                Iterator it = this.f2926a.f2918f.iterator();
                while (it.hasNext()) {
                    ((C3342ku) it.next()).mo38491a();
                }
            } else if (message.arg1 == 102) {
                Iterator it2 = this.f2926a.f2918f.iterator();
                while (it2.hasNext()) {
                    ((C3342ku) it2.next()).mo38492b();
                }
            }
        }
    }

    /* renamed from: com.uxcam.internals.kw$ab */
    public interface C3346ab {
        /* renamed from: a */
        int mo38569a();

        /* renamed from: a */
        boolean mo38570a(Canvas canvas);

        /* renamed from: b */
        int mo38571b();
    }

    /* renamed from: com.uxcam.internals.kw$ac */
    public class C3347ac extends Thread {
        private C3347ac() {
        }

        /* synthetic */ C3347ac(C3344kw kwVar, byte b) {
            this();
        }

        /* renamed from: a */
        private void m2429a() {
            if (C3344kw.this.f2920h != null) {
                try {
                    C3344kw.this.f2920h.stop();
                    C3344kw.this.f2920h.release();
                    MediaCodec unused = C3344kw.this.f2920h = null;
                } catch (Exception unused2) {
                    C2970bc.m1233a("SurfaceEncoder");
                }
            }
            if (C3344kw.this.f2921i != null) {
                try {
                    C3344kw.this.f2921i.release();
                    Surface unused3 = C3344kw.this.f2921i = null;
                } catch (Exception unused4) {
                    C2970bc.m1233a("SurfaceEncoder");
                }
            }
            if (C3344kw.this.f2922j != null) {
                try {
                    C3344kw.this.f2922j.stop();
                    C3344kw.this.f2922j.release();
                    MediaMuxer unused5 = C3344kw.this.f2922j = null;
                } catch (Exception unused6) {
                    C2970bc.m1233a("SurfaceEncoder");
                }
            }
        }

        /* renamed from: a */
        private void m2430a(boolean z) {
            if (z) {
                C3344kw.this.f2920h.signalEndOfInputStream();
            }
            while (true) {
                ByteBuffer[] outputBuffers = C3344kw.this.f2920h.getOutputBuffers();
                while (true) {
                    int dequeueOutputBuffer = C3344kw.this.f2920h.dequeueOutputBuffer(C3344kw.this.f2925m, 10000);
                    if (dequeueOutputBuffer == -1) {
                        if (!z) {
                            return;
                        }
                    } else if (dequeueOutputBuffer != -3) {
                        if (dequeueOutputBuffer == -2) {
                            if (!C3344kw.this.f2924l) {
                                MediaFormat outputFormat = C3344kw.this.f2920h.getOutputFormat();
                                new StringBuilder("encoder output format changed: ").append(outputFormat);
                                int unused = C3344kw.this.f2923k = C3344kw.this.f2922j.addTrack(outputFormat);
                                C3344kw.this.f2922j.start();
                                boolean unused2 = C3344kw.this.f2924l = true;
                            } else {
                                throw new RuntimeException("format changed twice");
                            }
                        } else if (dequeueOutputBuffer < 0) {
                            continue;
                        } else {
                            ByteBuffer byteBuffer = outputBuffers[dequeueOutputBuffer];
                            if (byteBuffer != null) {
                                if ((C3344kw.this.f2925m.flags & 2) != 0) {
                                    C3344kw.this.f2925m.size = 0;
                                }
                                if (C3344kw.this.f2925m.size != 0) {
                                    if (C3344kw.this.f2924l) {
                                        byteBuffer.position(C3344kw.this.f2925m.offset);
                                        byteBuffer.limit(C3344kw.this.f2925m.offset + C3344kw.this.f2925m.size);
                                        C3344kw.this.f2922j.writeSampleData(C3344kw.this.f2923k, byteBuffer, C3344kw.this.f2925m);
                                    } else {
                                        throw new RuntimeException("muxer hasn't started");
                                    }
                                }
                                C3344kw.this.f2920h.releaseOutputBuffer(dequeueOutputBuffer, false);
                                if ((C3344kw.this.f2925m.flags & 4) != 0) {
                                    if (z) {
                                    }
                                    return;
                                }
                            } else {
                                throw new RuntimeException("encoderOutputBuffer " + dequeueOutputBuffer + " was null");
                            }
                        }
                    }
                }
            }
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(17:2|3|4|5|6|7|8|9|10|11|12|(2:13|(10:15|16|17|18|19|22|(1:24)|25|(1:(2:27|(3:72|29|71)(1:30))(3:73|31|70))|(2:68|33))(1:69))|37|38|49|(1:51)(1:52)|(4:54|(2:57|55)|74|58)(4:59|(2:62|60)|75|63)) */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x006c */
        /* JADX WARNING: Removed duplicated region for block: B:15:0x00ac A[Catch:{ IOException -> 0x011b, IllegalArgumentException -> 0x010b, OutOfResourcesException -> 0x00ce, Exception -> 0x0126 }] */
        /* JADX WARNING: Removed duplicated region for block: B:69:0x0113 A[EDGE_INSN: B:69:0x0113->B:37:0x0113 ?: BREAK  , SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            /*
                r8 = this;
                com.uxcam.internals.kw r0 = com.uxcam.internals.C3344kw.this
                com.uxcam.internals.kw$ab r0 = r0.f2916d
                if (r0 == 0) goto L_0x016f
                r0 = 0
                r1 = 1
                com.uxcam.internals.kw r2 = com.uxcam.internals.C3344kw.this     // Catch:{ Exception -> 0x0126 }
                android.media.MediaCodec$BufferInfo r3 = new android.media.MediaCodec$BufferInfo     // Catch:{ Exception -> 0x0126 }
                r3.<init>()     // Catch:{ Exception -> 0x0126 }
                android.media.MediaCodec.BufferInfo unused = r2.f2925m = r3     // Catch:{ Exception -> 0x0126 }
                java.lang.String r2 = "video/avc"
                com.uxcam.internals.kw r3 = com.uxcam.internals.C3344kw.this     // Catch:{ Exception -> 0x0126 }
                com.uxcam.internals.kw$ab r3 = r3.f2916d     // Catch:{ Exception -> 0x0126 }
                int r3 = r3.mo38569a()     // Catch:{ Exception -> 0x0126 }
                com.uxcam.internals.kw r4 = com.uxcam.internals.C3344kw.this     // Catch:{ Exception -> 0x0126 }
                com.uxcam.internals.kw$ab r4 = r4.f2916d     // Catch:{ Exception -> 0x0126 }
                int r4 = r4.mo38571b()     // Catch:{ Exception -> 0x0126 }
                android.media.MediaFormat r2 = android.media.MediaFormat.createVideoFormat(r2, r3, r4)     // Catch:{ Exception -> 0x0126 }
                java.lang.String r3 = "color-format"
                r4 = 2130708361(0x7f000789, float:1.701803E38)
                r2.setInteger(r3, r4)     // Catch:{ Exception -> 0x0126 }
                java.lang.String r3 = "bitrate"
                com.uxcam.internals.kw r4 = com.uxcam.internals.C3344kw.this     // Catch:{ Exception -> 0x0126 }
                int r4 = r4.f2915c     // Catch:{ Exception -> 0x0126 }
                r2.setInteger(r3, r4)     // Catch:{ Exception -> 0x0126 }
                java.lang.String r3 = "frame-rate"
                int r4 = com.uxcam.internals.C3344kw.f2913a     // Catch:{ Exception -> 0x0126 }
                r2.setInteger(r3, r4)     // Catch:{ Exception -> 0x0126 }
                java.lang.String r3 = "i-frame-interval"
                r4 = 100
                r2.setInteger(r3, r4)     // Catch:{ Exception -> 0x0126 }
                java.lang.String r3 = "stride"
                com.uxcam.internals.kw r5 = com.uxcam.internals.C3344kw.this     // Catch:{ Exception -> 0x0126 }
                com.uxcam.internals.kw$ab r5 = r5.f2916d     // Catch:{ Exception -> 0x0126 }
                int r5 = r5.mo38569a()     // Catch:{ Exception -> 0x0126 }
                r2.setInteger(r3, r5)     // Catch:{ Exception -> 0x0126 }
                java.lang.String r3 = "slice-height"
                com.uxcam.internals.kw r5 = com.uxcam.internals.C3344kw.this     // Catch:{ Exception -> 0x0126 }
                com.uxcam.internals.kw$ab r5 = r5.f2916d     // Catch:{ Exception -> 0x0126 }
                int r5 = r5.mo38571b()     // Catch:{ Exception -> 0x0126 }
                r2.setInteger(r3, r5)     // Catch:{ Exception -> 0x0126 }
                com.uxcam.internals.kw r3 = com.uxcam.internals.C3344kw.this     // Catch:{ IOException -> 0x006c }
                java.lang.String r5 = "video/avc"
                android.media.MediaCodec r5 = android.media.MediaCodec.createEncoderByType(r5)     // Catch:{ IOException -> 0x006c }
                android.media.MediaCodec unused = r3.f2920h = r5     // Catch:{ IOException -> 0x006c }
            L_0x006c:
                com.uxcam.internals.kw r3 = com.uxcam.internals.C3344kw.this     // Catch:{ Exception -> 0x0126 }
                android.media.MediaCodec r3 = r3.f2920h     // Catch:{ Exception -> 0x0126 }
                r5 = 0
                r3.configure(r2, r5, r5, r1)     // Catch:{ Exception -> 0x0126 }
                com.uxcam.internals.kw r2 = com.uxcam.internals.C3344kw.this     // Catch:{ Exception -> 0x0126 }
                com.uxcam.internals.kw r3 = com.uxcam.internals.C3344kw.this     // Catch:{ Exception -> 0x0126 }
                android.media.MediaCodec r3 = r3.f2920h     // Catch:{ Exception -> 0x0126 }
                android.view.Surface r3 = r3.createInputSurface()     // Catch:{ Exception -> 0x0126 }
                android.view.Surface unused = r2.f2921i = r3     // Catch:{ Exception -> 0x0126 }
                com.uxcam.internals.kw r2 = com.uxcam.internals.C3344kw.this     // Catch:{ Exception -> 0x0126 }
                android.media.MediaCodec r2 = r2.f2920h     // Catch:{ Exception -> 0x0126 }
                r2.start()     // Catch:{ Exception -> 0x0126 }
                com.uxcam.internals.kw r2 = com.uxcam.internals.C3344kw.this     // Catch:{ IOException -> 0x011b }
                android.media.MediaMuxer r3 = new android.media.MediaMuxer     // Catch:{ IOException -> 0x011b }
                com.uxcam.internals.kw r6 = com.uxcam.internals.C3344kw.this     // Catch:{ IOException -> 0x011b }
                java.lang.String r6 = r6.f2914b     // Catch:{ IOException -> 0x011b }
                r3.<init>(r6, r0)     // Catch:{ IOException -> 0x011b }
                android.media.MediaMuxer unused = r2.f2922j = r3     // Catch:{ IOException -> 0x011b }
                com.uxcam.internals.kw r2 = com.uxcam.internals.C3344kw.this     // Catch:{ Exception -> 0x0126 }
                r3 = -1
                int unused = r2.f2923k = r3     // Catch:{ Exception -> 0x0126 }
                com.uxcam.internals.kw r2 = com.uxcam.internals.C3344kw.this     // Catch:{ Exception -> 0x0126 }
                boolean unused = r2.f2924l = r0     // Catch:{ Exception -> 0x0126 }
                r2 = 0
            L_0x00a8:
                boolean r3 = com.uxcam.internals.C3196gd.f2355b     // Catch:{ Exception -> 0x0126 }
                if (r3 != 0) goto L_0x0113
                r8.m2430a(r0)     // Catch:{ Exception -> 0x0126 }
                int r3 = com.uxcam.internals.C3344kw.f2913a     // Catch:{ Exception -> 0x0126 }
                com.uxcam.internals.kw r3 = com.uxcam.internals.C3344kw.this     // Catch:{ IllegalArgumentException -> 0x010b, OutOfResourcesException -> 0x00ce }
                android.view.Surface r3 = r3.f2921i     // Catch:{ IllegalArgumentException -> 0x010b, OutOfResourcesException -> 0x00ce }
                android.graphics.Canvas r3 = r3.lockCanvas(r5)     // Catch:{ IllegalArgumentException -> 0x010b, OutOfResourcesException -> 0x00ce }
                com.uxcam.internals.kw r6 = com.uxcam.internals.C3344kw.this     // Catch:{ Exception -> 0x0126 }
                com.uxcam.internals.kw$ab r6 = r6.f2916d     // Catch:{ Exception -> 0x0126 }
                int r7 = com.uxcam.internals.C3344kw.f2913a     // Catch:{ Exception -> 0x0126 }
                r6.mo38570a(r3)     // Catch:{ Exception -> 0x0126 }
                com.uxcam.internals.kw r6 = com.uxcam.internals.C3344kw.this     // Catch:{ Exception -> 0x0126 }
                android.view.Surface r6 = r6.f2921i     // Catch:{ Exception -> 0x0126 }
                r6.unlockCanvasAndPost(r3)     // Catch:{ Exception -> 0x0126 }
                goto L_0x00d3
            L_0x00ce:
                java.lang.String r3 = "SurfaceEncoder"
                com.uxcam.internals.C2970bc.m1233a((java.lang.String) r3)     // Catch:{ Exception -> 0x0126 }
            L_0x00d3:
                int r2 = r2 + r1
                if (r2 != r1) goto L_0x00f2
                float r3 = com.uxcam.internals.C3183fy.m2041c()     // Catch:{ Exception -> 0x0126 }
                com.uxcam.internals.C3165fk.f2260f = r3     // Catch:{ Exception -> 0x0126 }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0126 }
                java.lang.String r6 = "MC encoding offset is :"
                r3.<init>(r6)     // Catch:{ Exception -> 0x0126 }
                float r6 = com.uxcam.internals.C3183fy.m2041c()     // Catch:{ Exception -> 0x0126 }
                r3.append(r6)     // Catch:{ Exception -> 0x0126 }
                java.lang.String r6 = ", "
                r3.append(r6)     // Catch:{ Exception -> 0x0126 }
                r3.append(r2)     // Catch:{ Exception -> 0x0126 }
            L_0x00f2:
                r3 = 0
            L_0x00f3:
                if (r3 >= r4) goto L_0x0107
                r6 = 10
                int r7 = com.uxcam.internals.C3344kw.f2913a     // Catch:{ Exception -> 0x0126 }
                int r6 = r6 / r7
                long r6 = (long) r6     // Catch:{ Exception -> 0x0126 }
                java.lang.Thread.sleep(r6)     // Catch:{ Exception -> 0x0126 }
                boolean r6 = com.uxcam.internals.C3196gd.f2355b     // Catch:{ Exception -> 0x0126 }
                if (r6 == 0) goto L_0x0104
                r3 = 1
                goto L_0x0108
            L_0x0104:
                int r3 = r3 + 1
                goto L_0x00f3
            L_0x0107:
                r3 = 0
            L_0x0108:
                if (r3 == 0) goto L_0x00a8
                goto L_0x0113
            L_0x010b:
                java.lang.RuntimeException r1 = new java.lang.RuntimeException     // Catch:{ Exception -> 0x0126 }
                java.lang.String r2 = "UXCam : IllegalArgumentException while lockCamvas "
                r1.<init>(r2)     // Catch:{ Exception -> 0x0126 }
                throw r1     // Catch:{ Exception -> 0x0126 }
            L_0x0113:
                r8.m2430a(r1)     // Catch:{ Exception -> 0x0126 }
                r8.m2429a()
                r0 = 1
                goto L_0x012e
            L_0x011b:
                r1 = move-exception
                java.lang.RuntimeException r2 = new java.lang.RuntimeException     // Catch:{ Exception -> 0x0126 }
                java.lang.String r3 = "MediaMuxer creation failed"
                r2.<init>(r3, r1)     // Catch:{ Exception -> 0x0126 }
                throw r2     // Catch:{ Exception -> 0x0126 }
            L_0x0124:
                r0 = move-exception
                goto L_0x016b
            L_0x0126:
                java.lang.String r1 = "SurfaceEncoder"
                com.uxcam.internals.C2970bc.m1233a((java.lang.String) r1)     // Catch:{ all -> 0x0124 }
                r8.m2429a()
            L_0x012e:
                r1 = 101(0x65, float:1.42E-43)
                if (r0 == 0) goto L_0x0135
                r0 = 101(0x65, float:1.42E-43)
                goto L_0x0137
            L_0x0135:
                r0 = 102(0x66, float:1.43E-43)
            L_0x0137:
                if (r0 != r1) goto L_0x0152
                com.uxcam.internals.kw r0 = com.uxcam.internals.C3344kw.this
                java.util.ArrayList r0 = r0.f2918f
                java.util.Iterator r0 = r0.iterator()
            L_0x0141:
                boolean r1 = r0.hasNext()
                if (r1 == 0) goto L_0x0151
                java.lang.Object r1 = r0.next()
                com.uxcam.internals.ku r1 = (com.uxcam.internals.C3342ku) r1
                r1.mo38491a()
                goto L_0x0141
            L_0x0151:
                return
            L_0x0152:
                com.uxcam.internals.kw r0 = com.uxcam.internals.C3344kw.this
                java.util.ArrayList r0 = r0.f2918f
                java.util.Iterator r0 = r0.iterator()
            L_0x015a:
                boolean r1 = r0.hasNext()
                if (r1 == 0) goto L_0x016a
                java.lang.Object r1 = r0.next()
                com.uxcam.internals.ku r1 = (com.uxcam.internals.C3342ku) r1
                r1.mo38492b()
                goto L_0x015a
            L_0x016a:
                return
            L_0x016b:
                r8.m2429a()
                throw r0
            L_0x016f:
                java.lang.NullPointerException r0 = new java.lang.NullPointerException
                java.lang.String r1 = "Need to set an encoder source on the surfaceEncoder"
                r0.<init>(r1)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uxcam.internals.C3344kw.C3347ac.run():void");
        }
    }

    public C3344kw() {
        this.f2917e.setName("uxSurfaceEncode");
    }
}
