package com.uxcam.internals;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.view.Surface;
import java.nio.ByteBuffer;
import java.util.ArrayList;

@TargetApi(19)
/* renamed from: com.uxcam.internals.kr */
public final class C3338kr {

    /* renamed from: a */
    public static int f2888a = 1;

    /* renamed from: b */
    public ArrayList f2889b = new ArrayList();

    /* renamed from: c */
    public String f2890c;

    /* renamed from: d */
    public int f2891d = -1;

    /* renamed from: e */
    public int f2892e = -1;

    /* renamed from: f */
    public int f2893f = -1;

    /* renamed from: g */
    public MediaCodec f2894g;

    /* renamed from: h */
    public C3339aa f2895h;

    /* renamed from: i */
    public MediaMuxer f2896i;

    /* renamed from: j */
    public int f2897j;

    /* renamed from: k */
    public boolean f2898k;

    /* renamed from: l */
    public MediaCodec.BufferInfo f2899l;

    /* renamed from: com.uxcam.internals.kr$aa */
    public static class C3339aa {

        /* renamed from: a */
        public EGLDisplay f2900a = EGL14.EGL_NO_DISPLAY;

        /* renamed from: b */
        public EGLContext f2901b = EGL14.EGL_NO_CONTEXT;

        /* renamed from: c */
        public EGLSurface f2902c = EGL14.EGL_NO_SURFACE;

        /* renamed from: d */
        private Surface f2903d;

        public C3339aa(Surface surface) {
            if (surface != null) {
                this.f2903d = surface;
                this.f2900a = EGL14.eglGetDisplay(0);
                if (this.f2900a != EGL14.EGL_NO_DISPLAY) {
                    int[] iArr = new int[2];
                    if (EGL14.eglInitialize(this.f2900a, iArr, 0, iArr, 1)) {
                        EGLConfig[] eGLConfigArr = new EGLConfig[1];
                        EGL14.eglChooseConfig(this.f2900a, new int[]{12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, 4, 12610, 1, 12344}, 0, eGLConfigArr, 0, 1, new int[1], 0);
                        m2406a("eglCreateContext RGB888+recordable ES2");
                        this.f2901b = EGL14.eglCreateContext(this.f2900a, eGLConfigArr[0], EGL14.EGL_NO_CONTEXT, new int[]{12440, 2, 12344}, 0);
                        m2406a("eglCreateContext");
                        this.f2902c = EGL14.eglCreateWindowSurface(this.f2900a, eGLConfigArr[0], this.f2903d, new int[]{12344}, 0);
                        m2406a("eglCreateWindowSurface");
                        return;
                    }
                    throw new RuntimeException("unable to initialize EGL14");
                }
                throw new RuntimeException("unable to get EGL14 display");
            }
            throw new NullPointerException();
        }

        /* renamed from: a */
        public static void m2406a(String str) {
            int eglGetError = EGL14.eglGetError();
            if (eglGetError != 12288) {
                throw new RuntimeException(str + ": EGL error: 0x" + Integer.toHexString(eglGetError));
            }
        }

        /* renamed from: a */
        public final void mo38568a() {
            if (this.f2900a != EGL14.EGL_NO_DISPLAY) {
                EGLDisplay eGLDisplay = this.f2900a;
                EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
                EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL14.EGL_NO_CONTEXT);
                EGL14.eglDestroySurface(this.f2900a, this.f2902c);
                EGL14.eglDestroyContext(this.f2900a, this.f2901b);
                EGL14.eglReleaseThread();
                EGL14.eglTerminate(this.f2900a);
            }
            this.f2903d.release();
            this.f2900a = EGL14.EGL_NO_DISPLAY;
            this.f2901b = EGL14.EGL_NO_CONTEXT;
            this.f2902c = EGL14.EGL_NO_SURFACE;
            this.f2903d = null;
        }
    }

    /* renamed from: a */
    public static int m2402a() {
        return C3183fy.m2029a(C3196gd.m2083b());
    }

    /* renamed from: b */
    public static int m2403b() {
        return C3183fy.m2029a(C3196gd.m2086c());
    }

    /* renamed from: a */
    public final void mo38566a(boolean z) {
        if (z) {
            this.f2894g.signalEndOfInputStream();
        }
        while (true) {
            ByteBuffer[] outputBuffers = this.f2894g.getOutputBuffers();
            while (true) {
                int dequeueOutputBuffer = this.f2894g.dequeueOutputBuffer(this.f2899l, 10000);
                if (dequeueOutputBuffer == -1) {
                    if (!z) {
                        return;
                    }
                } else if (dequeueOutputBuffer != -3) {
                    if (dequeueOutputBuffer == -2) {
                        if (!this.f2898k) {
                            MediaFormat outputFormat = this.f2894g.getOutputFormat();
                            new StringBuilder("encoder output format changed: ").append(outputFormat);
                            this.f2897j = this.f2896i.addTrack(outputFormat);
                            this.f2896i.start();
                            this.f2898k = true;
                        } else {
                            throw new RuntimeException("format changed twice");
                        }
                    } else if (dequeueOutputBuffer < 0) {
                        continue;
                    } else {
                        ByteBuffer byteBuffer = outputBuffers[dequeueOutputBuffer];
                        if (byteBuffer != null) {
                            if ((this.f2899l.flags & 2) != 0) {
                                this.f2899l.size = 0;
                            }
                            if (this.f2899l.size != 0) {
                                if (this.f2898k) {
                                    byteBuffer.position(this.f2899l.offset);
                                    byteBuffer.limit(this.f2899l.offset + this.f2899l.size);
                                    this.f2896i.writeSampleData(this.f2897j, byteBuffer, this.f2899l);
                                } else {
                                    throw new RuntimeException("muxer hasn't started");
                                }
                            }
                            this.f2894g.releaseOutputBuffer(dequeueOutputBuffer, false);
                            if ((this.f2899l.flags & 4) != 0) {
                                if (!z) {
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

    /* renamed from: c */
    public final void mo38567c() {
        if (this.f2894g != null) {
            try {
                this.f2894g.stop();
                this.f2894g.release();
                this.f2894g = null;
            } catch (Exception unused) {
            }
        }
        if (this.f2895h != null) {
            try {
                this.f2895h.mo38568a();
                this.f2895h = null;
            } catch (Exception unused2) {
            }
        }
        if (this.f2896i != null) {
            try {
                this.f2896i.stop();
                this.f2896i.release();
                this.f2896i = null;
            } catch (Exception unused3) {
            }
        }
    }
}
