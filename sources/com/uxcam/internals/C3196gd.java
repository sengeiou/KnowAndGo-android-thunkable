package com.uxcam.internals;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.opengl.EGL14;
import android.opengl.EGLExt;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.opengl.Matrix;
import android.os.Build;
import android.os.Handler;
import android.os.SystemClock;
import android.view.Surface;
import androidx.core.view.ViewCompat;
import com.google.android.exoplayer2.util.MimeTypes;
import com.uxcam.internals.C3338kr;
import com.uxcam.service.HttpPostService;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import javax.crypto.CipherOutputStream;
import org.json.JSONObject;
import p000ai.api.util.VoiceActivityDetector;

/* renamed from: com.uxcam.internals.gd */
public class C3196gd {

    /* renamed from: A */
    private static int f2351A = 0;

    /* renamed from: B */
    private static int f2352B = 0;

    /* renamed from: C */
    private static int f2353C = 0;

    /* renamed from: a */
    public static C3193gb f2354a = null;

    /* renamed from: b */
    public static boolean f2355b = false;

    /* renamed from: c */
    public static boolean f2356c = false;

    /* renamed from: d */
    public static C3210gg f2357d = null;

    /* renamed from: e */
    public static boolean f2358e = false;

    /* renamed from: f */
    public static boolean f2359f = false;

    /* renamed from: g */
    public static long f2360g = 0;

    /* renamed from: h */
    public static WeakReference f2361h = null;

    /* renamed from: i */
    public static ArrayList f2362i = new ArrayList();

    /* renamed from: j */
    public static ArrayList f2363j = new ArrayList();

    /* renamed from: k */
    public static ArrayList f2364k = new ArrayList();

    /* renamed from: l */
    public static int f2365l = 0;

    /* renamed from: m */
    public static float f2366m = 1.0f;

    /* renamed from: n */
    public static int f2367n = 0;

    /* renamed from: o */
    static int f2368o = 0;

    /* renamed from: p */
    public static boolean f2369p = false;

    /* renamed from: q */
    public static int f2370q = 1000;

    /* renamed from: u */
    private static boolean f2371u = false;

    /* renamed from: v */
    private static boolean f2372v = false;

    /* renamed from: w */
    private static int f2373w = -1;
    /* access modifiers changed from: private */

    /* renamed from: x */
    public static String f2374x = C3196gd.class.getSimpleName();

    /* renamed from: y */
    private static C3196gd f2375y;

    /* renamed from: z */
    private static int f2376z;
    /* access modifiers changed from: private */

    /* renamed from: D */
    public final Handler f2377D = new Handler();

    /* renamed from: E */
    private File f2378E;

    /* renamed from: r */
    public Timer f2379r;

    /* renamed from: s */
    public TimerTask f2380s;

    /* renamed from: t */
    public C3202aa f2381t;

    /* renamed from: com.uxcam.internals.gd$aa */
    public interface C3202aa {
        /* renamed from: a */
        void mo37985a();
    }

    private C3196gd() {
        String str;
        File file = new File(C2958as.m1196a());
        if (!file.exists()) {
            file.mkdir();
        }
        this.f2378E = new File(file, C2958as.m1202c());
        f2369p = m2090f();
        f2373w = -1;
        if (!f2369p) {
            m2100p();
            str = "JCodec";
        } else if (Build.MODEL.contains("SM-G93")) {
            m2096l();
            C2970bc.m1233a(f2374x);
            f2358e = true;
            final C3338kr krVar = new C3338kr();
            File file2 = new File(C2958as.m1196a());
            if (!file2.exists()) {
                file2.mkdir();
            }
            krVar.f2890c = this.f2378E.getAbsolutePath();
            krVar.f2889b.add(new C3342ku() {
                /* renamed from: a */
                public final void mo38491a() {
                    C2970bc.m1233a(C3196gd.f2374x);
                    C3196gd.this.m2097m();
                    C3196gd.m2084b(C3196gd.this);
                }

                /* renamed from: b */
                public final void mo38492b() {
                    C2970bc.m1233a(C3196gd.f2374x);
                    C3196gd.m2100p();
                }
            });
            f2370q = C2952an.f1324h;
            new Thread(new Runnable() {
                public final void run() {
                    boolean z;
                    C3338kr krVar = krVar;
                    krVar.f2891d = C3338kr.m2402a();
                    krVar.f2892e = C3338kr.m2403b();
                    krVar.f2893f = 150000;
                    boolean z2 = true;
                    try {
                        krVar.f2899l = new MediaCodec.BufferInfo();
                        MediaFormat createVideoFormat = MediaFormat.createVideoFormat(MimeTypes.VIDEO_H264, krVar.f2891d, krVar.f2892e);
                        createVideoFormat.setInteger("color-format", 2130708361);
                        createVideoFormat.setInteger("bitrate", krVar.f2893f);
                        createVideoFormat.setInteger("frame-rate", C3338kr.f2888a);
                        createVideoFormat.setInteger("i-frame-interval", 10);
                        try {
                            krVar.f2894g = MediaCodec.createEncoderByType(MimeTypes.VIDEO_H264);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        Paint paint = null;
                        krVar.f2894g.configure(createVideoFormat, (Surface) null, (MediaCrypto) null, 1);
                        krVar.f2895h = new C3338kr.C3339aa(krVar.f2894g.createInputSurface());
                        krVar.f2894g.start();
                        new StringBuilder("output file is ").append(krVar.f2890c);
                        krVar.f2896i = new MediaMuxer(krVar.f2890c, 0);
                        krVar.f2897j = -1;
                        krVar.f2898k = false;
                        C3338kr.C3339aa aaVar = krVar.f2895h;
                        EGL14.eglMakeCurrent(aaVar.f2900a, aaVar.f2902c, aaVar.f2902c, aaVar.f2901b);
                        C3338kr.C3339aa.m2406a("eglMakeCurrent");
                        long b = C2923aa.m1098b();
                        while (true) {
                            if (C3196gd.f2355b) {
                                break;
                            }
                            krVar.mo38566a(false);
                            C3340ks ksVar = new C3340ks(krVar.f2891d, krVar.f2892e);
                            GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
                            ksVar.f2907d = new C3341kt();
                            GLES20.glViewport(0, 0, ksVar.f2905b, ksVar.f2906c);
                            float f = ((float) ksVar.f2905b) / ((float) ksVar.f2906c);
                            Matrix.frustumM(ksVar.f2904a, 0, -f, f, -1.0f, 1.0f, 3.0f, 7.0f);
                            GLES20.glClear(16640);
                            C3341kt ktVar = ksVar.f2907d;
                            GLES20.glUseProgram(ktVar.f2910c);
                            GLES20.glGenTextures(z2 ? 1 : 0, ktVar.f2911d, 0);
                            if (ktVar.f2911d[0] != 0) {
                                GLES20.glBindTexture(3553, ktVar.f2911d[0]);
                                GLES20.glTexParameteri(3553, 10241, 9728);
                                GLES20.glTexParameteri(3553, 10240, 9728);
                                C3195gc.m2078a(z2);
                                if (C3195gc.f2344b == null) {
                                    Bitmap createBitmap = Bitmap.createBitmap(VoiceActivityDetector.FRAME_SIZE_IN_BYTES, 480, Bitmap.Config.RGB_565);
                                    Canvas canvas = new Canvas(createBitmap);
                                    Paint paint2 = new Paint();
                                    paint2.setColor(ViewCompat.MEASURED_STATE_MASK);
                                    canvas.drawRect(0.0f, 0.0f, (float) canvas.getWidth(), (float) canvas.getHeight(), paint2);
                                    GLUtils.texImage2D(3553, 0, createBitmap, 0);
                                } else {
                                    Bitmap createBitmap2 = Bitmap.createBitmap(C3195gc.f2344b.getWidth(), C3183fy.m2029a(C3195gc.f2344b.getHeight()), Bitmap.Config.RGB_565);
                                    new Canvas(createBitmap2).drawBitmap(C3195gc.f2344b, 0.0f, 0.0f, paint);
                                    GLUtils.texImage2D(3553, 0, createBitmap2, 0);
                                }
                                C3341kt ktVar2 = ksVar.f2907d;
                                int glGetUniformLocation = GLES20.glGetUniformLocation(ktVar2.f2910c, "uScreen");
                                int glGetUniformLocation2 = GLES20.glGetUniformLocation(ktVar2.f2910c, "uTexture");
                                FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect(64).order(ByteOrder.nativeOrder()).asFloatBuffer();
                                asFloatBuffer.put(new float[]{0.00625f, 0.0f, 0.0f, 0.0f, 0.0f, -0.004166667f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, 1.0f, 0.0f, 1.0f}).position(0);
                                GLES20.glUniformMatrix4fv(glGetUniformLocation, asFloatBuffer.limit() / 16, false, asFloatBuffer);
                                GLES20.glActiveTexture(33984);
                                GLES20.glBindTexture(3553, ktVar2.f2911d[0]);
                                GLES20.glUniform1i(glGetUniformLocation2, 0);
                                C3341kt ktVar3 = ksVar.f2907d;
                                int glGetAttribLocation = GLES20.glGetAttribLocation(ktVar3.f2910c, "aPosition");
                                int glGetAttribLocation2 = GLES20.glGetAttribLocation(ktVar3.f2910c, "aTexPos");
                                FloatBuffer asFloatBuffer2 = ByteBuffer.allocateDirect(64).order(ByteOrder.nativeOrder()).asFloatBuffer();
                                asFloatBuffer2.put(new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 480.0f, 0.0f, 1.0f, 320.0f, 0.0f, 1.0f, 0.0f, 320.0f, 480.0f, 1.0f, 1.0f});
                                asFloatBuffer2.position(0);
                                GLES20.glVertexAttribPointer(glGetAttribLocation, 2, 5126, false, 16, asFloatBuffer2);
                                GLES20.glEnableVertexAttribArray(glGetAttribLocation);
                                asFloatBuffer2.position(2);
                                GLES20.glVertexAttribPointer(glGetAttribLocation2, 2, 5126, false, 16, asFloatBuffer2);
                                GLES20.glEnableVertexAttribArray(glGetAttribLocation2);
                                GLES20.glDrawArrays(5, 0, 4);
                                C3338kr.C3339aa aaVar2 = krVar.f2895h;
                                EGLExt.eglPresentationTimeANDROID(aaVar2.f2900a, aaVar2.f2902c, (SystemClock.elapsedRealtime() - b) * 1000000);
                                C3338kr.C3339aa.m2406a("eglPresentationTimeANDROID");
                                C3338kr.C3339aa aaVar3 = krVar.f2895h;
                                EGL14.eglSwapBuffers(aaVar3.f2900a, aaVar3.f2902c);
                                C3338kr.C3339aa.m2406a("eglSwapBuffers");
                                if (C3165fk.f2260f <= 0.0f) {
                                    C3165fk.f2260f = C3183fy.m2041c();
                                }
                                int i = 0;
                                while (true) {
                                    if (i >= 100) {
                                        z = false;
                                        break;
                                    }
                                    Thread.sleep((long) (10 / C3338kr.f2888a));
                                    if (C3196gd.f2355b) {
                                        z = true;
                                        break;
                                    }
                                    i++;
                                }
                                if (z) {
                                    z2 = true;
                                    break;
                                } else {
                                    z2 = true;
                                    paint = null;
                                }
                            } else {
                                throw new RuntimeException("Error loading texture");
                            }
                        }
                        krVar.mo38566a(z2);
                        krVar.mo38567c();
                    } catch (IOException e2) {
                        throw new RuntimeException("MediaMuxer creation failed", e2);
                    } catch (Exception unused) {
                        krVar.mo38567c();
                        z2 = false;
                    } catch (Throwable th) {
                        krVar.mo38567c();
                        throw th;
                    }
                    if (z2) {
                        Iterator it = krVar.f2889b.iterator();
                        while (it.hasNext()) {
                            ((C3342ku) it.next()).mo38491a();
                        }
                        return;
                    }
                    Iterator it2 = krVar.f2889b.iterator();
                    while (it2.hasNext()) {
                        ((C3342ku) it2.next()).mo38492b();
                    }
                }
            }).start();
            str = "GLMediaCodec";
        } else {
            m2096l();
            C2970bc.m1233a(f2374x);
            f2358e = true;
            C3344kw kwVar = new C3344kw();
            File file3 = new File(C2958as.m1196a());
            if (!file3.exists()) {
                file3.mkdir();
            }
            kwVar.f2914b = this.f2378E.getAbsolutePath();
            kwVar.f2916d = new C3343kv();
            kwVar.f2918f.add(new C3342ku() {
                /* renamed from: a */
                public final void mo38491a() {
                    C2970bc.m1233a(C3196gd.f2374x);
                    C3196gd.this.m2097m();
                    C3196gd.m2084b(C3196gd.this);
                }

                /* renamed from: b */
                public final void mo38492b() {
                    C2970bc.m1233a(C3196gd.f2374x);
                    String unused = C3196gd.f2374x;
                    new Object[1][0] = "ENCODING FAILED WITH MEDIA CODEC";
                    C3196gd.m2100p();
                }
            });
            f2370q = C2952an.f1324h;
            kwVar.f2917e.start();
            str = "MediaCodec";
        }
        HashMap hashMap = new HashMap();
        hashMap.put("encoder", str);
        hashMap.put("frameTime", Integer.valueOf(C2952an.f1324h));
        C3171fo.m1998a(C3183fy.m2030a(), "initMediaCodec", hashMap);
    }

    /* renamed from: a */
    public static C3196gd m2079a() {
        if (f2375y == null) {
            f2375y = new C3196gd();
        }
        return f2375y;
    }

    /* renamed from: a */
    private static void m2081a(File file, ZipOutputStream zipOutputStream) {
        byte[] bArr = new byte[16384];
        FileInputStream fileInputStream = new FileInputStream(file);
        while (true) {
            int read = fileInputStream.read(bArr, 0, 16384);
            if (read != -1) {
                zipOutputStream.write(bArr, 0, read);
            } else {
                fileInputStream.close();
                return;
            }
        }
    }

    /* renamed from: a */
    public static void m2082a(boolean z) {
        f2371u = z;
    }

    /* renamed from: b */
    public static int m2083b() {
        return f2373w == 1 ? f2376z : f2351A;
    }

    /* renamed from: b */
    static /* synthetic */ void m2084b(C3196gd gdVar) {
        C3195gc.f2343a = 0;
        f2355b = false;
        m2088d();
        gdVar.m2098n();
    }

    /* renamed from: b */
    public static void m2085b(boolean z) {
        f2372v = z;
    }

    /* renamed from: c */
    public static int m2086c() {
        return f2373w == 1 ? f2351A : f2376z;
    }

    /* renamed from: d */
    public static void m2088d() {
        f2375y = null;
        f2357d = null;
        if (f2354a != null) {
            f2354a.clear();
            f2354a = null;
        }
        C3195gc.f2343a = 0;
    }

    /* renamed from: e */
    static int m2089e() {
        return f2370q == 2000 ? 2 : 1;
    }

    /* renamed from: f */
    public static boolean m2090f() {
        return Build.VERSION.SDK_INT >= 19 && C3183fy.m2058j() && !Build.MODEL.equalsIgnoreCase("Nexus 10");
    }

    /* renamed from: g */
    public static boolean m2091g() {
        return f2371u || f2372v;
    }

    /* renamed from: h */
    static C3210gg m2092h() {
        return f2357d;
    }

    /* renamed from: l */
    private static void m2096l() {
        float f;
        int i;
        Point a = C3172fp.m2001a(C3183fy.m2030a());
        f2353C = a.y;
        int i2 = a.x;
        f2352B = i2;
        int i3 = 1;
        boolean z = i2 > f2353C;
        f2376z = f2352B;
        if (f2352B > C2952an.f1335s) {
            f2376z = C2952an.f1335s;
            f2366m = 1.0f;
            if (z) {
                f = (float) f2376z;
                i = f2353C;
            } else {
                f = (float) f2376z;
                i = f2352B;
            }
            f2366m = f / ((float) i);
        }
        f2376z = (int) (((float) f2352B) * f2366m);
        int i4 = (int) (((float) f2353C) * f2366m);
        f2351A = i4;
        f2367n = C3183fy.m2029a(i4) - f2351A;
        C2970bc.m1233a(f2374x);
        StringBuilder sb = new StringBuilder("sctest width is ");
        sb.append(f2376z);
        sb.append(" Height is ");
        sb.append(f2351A);
        sb.append(" Offset ");
        sb.append(f2367n);
        if (f2373w == -1) {
            if (f2376z > f2351A) {
                i3 = 0;
            }
            f2373w = i3;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: m */
    public void m2097m() {
        if (this.f2381t != null) {
            this.f2381t.mo37985a();
            this.f2381t = null;
        }
    }

    /* renamed from: n */
    private void m2098n() {
        C3171fo.m1998a(C3183fy.m2030a(), "encodingComplete", new HashMap());
        try {
            if (C2952an.f1307J && this.f2378E.exists()) {
                m2099o();
            }
            Intent intent = new Intent(C3183fy.m2030a(), HttpPostService.class);
            intent.putExtra("arg_which_service", "screen_upload");
            C3183fy.m2030a().startService(intent);
        } catch (IllegalStateException unused) {
        }
    }

    /* renamed from: o */
    private void m2099o() {
        try {
            C2959at atVar = new C2959at();
            FileOutputStream fileOutputStream = new FileOutputStream(new File(this.f2378E.getParentFile(), "video.zip"));
            ZipOutputStream zipOutputStream = new ZipOutputStream(fileOutputStream);
            byte[] bArr = new byte[16384];
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            File file = new File(this.f2378E.getParentFile(), "video.aes");
            FileOutputStream fileOutputStream2 = new FileOutputStream(file);
            CipherOutputStream a = atVar.mo38056a(fileOutputStream2);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(this.f2378E), 16384);
            while (true) {
                int read = bufferedInputStream.read(bArr, 0, 16384);
                if (read != -1) {
                    a.write(bArr, 0, read);
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    a.close();
                    bufferedInputStream.close();
                    fileOutputStream2.close();
                    zipOutputStream.putNextEntry(new ZipEntry("video.mp4.aes"));
                    m2081a(file, zipOutputStream);
                    zipOutputStream.closeEntry();
                    zipOutputStream.putNextEntry(new ZipEntry("metadata.json"));
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("decryptKey", atVar.mo38055a());
                    jSONObject.put("decryptiv", atVar.mo38057b());
                    zipOutputStream.write(jSONObject.toString().getBytes());
                    zipOutputStream.closeEntry();
                    zipOutputStream.close();
                    fileOutputStream.close();
                    C3183fy.m2035a(this.f2378E);
                    C3183fy.m2035a(file);
                    return;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: p */
    public static void m2100p() {
        f2369p = false;
        try {
            if (f2357d == null) {
                File file = new File(C2958as.m1196a());
                if (!file.exists()) {
                    file.mkdir();
                }
                f2357d = new C3210gg(new File(file, C2958as.m1202c()));
            }
            C2970bc.m1233a(f2374x);
        } catch (IOException unused) {
            C2970bc.m1238c();
        }
        m2101q();
    }

    /* renamed from: q */
    private static void m2101q() {
        f2354a = new C3193gb();
        m2096l();
        f2367n = 0;
        f2370q = C2952an.f1324h;
    }

    /* renamed from: a */
    public final void mo38490a(C3210gg ggVar) {
        if (f2354a.size() == 0 && f2355b && C2952an.f1323g) {
            C3195gc.f2343a = 0;
            f2355b = false;
            C2970bc.m1233a(f2374x);
            new StringBuilder("position value stoping encoding.....").append(f2354a.size());
            try {
                ggVar.mo38501a();
                C2970bc.m1233a(f2374x);
                m2097m();
            } catch (Exception unused) {
                m2097m();
                C2970bc.m1233a(f2374x);
            }
            f2375y = null;
            f2357d = null;
            f2354a.clear();
            f2354a = null;
            C3195gc.f2343a = 0;
            m2098n();
        }
    }
}
