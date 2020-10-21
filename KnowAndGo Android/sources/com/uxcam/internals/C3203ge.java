package com.uxcam.internals;

import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.TextView;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.ViewCompat;
import com.google.android.gms.maps.GoogleMap;
import io.flutter.embedding.android.FlutterSurfaceView;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.embedding.engine.renderer.FlutterRenderer;
import io.flutter.view.FlutterNativeView;
import io.flutter.view.FlutterView;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* renamed from: com.uxcam.internals.ge */
public final class C3203ge {

    /* renamed from: a */
    public static boolean f2388a = false;

    /* renamed from: b */
    public static CountDownLatch f2389b = new CountDownLatch(1);

    /* renamed from: c */
    static int f2390c;

    /* renamed from: d */
    public static WeakReference f2391d;

    /* renamed from: e */
    public static GoogleMap f2392e;

    /* renamed from: f */
    private static WeakReference f2393f;

    /* renamed from: g */
    private static WeakReference f2394g;

    /* renamed from: com.uxcam.internals.ge$aa */
    static class C3208aa {

        /* renamed from: a */
        final View f2401a;

        /* renamed from: b */
        final Rect f2402b;

        /* renamed from: c */
        final WindowManager.LayoutParams f2403c;

        C3208aa(View view, Rect rect, WindowManager.LayoutParams layoutParams) {
            this.f2401a = view;
            this.f2402b = rect;
            this.f2403c = layoutParams;
        }
    }

    /* renamed from: a */
    static void m2109a(Activity activity) {
        int i;
        Rect rect = new Rect();
        ((ViewGroup) activity.findViewById(16908290).getRootView()).getWindowVisibleDisplayFrame(rect);
        int height = rect.height();
        if (f2390c != 0) {
            if (f2390c > height + 150) {
                i = rect.bottom;
            } else if (f2390c + 150 < height) {
                i = 0;
            }
            C3196gd.f2365l = i;
        }
        f2390c = height;
    }

    /* renamed from: a */
    private static void m2110a(Bitmap bitmap) {
        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint();
        int i = C3196gd.m2083b() > 400 ? 2 : 1;
        float c = C3183fy.m2041c();
        Iterator it = C3165fk.m1970a().f2267a.iterator();
        while (it.hasNext()) {
            Iterator it2 = ((C2953ao) it.next()).f1345c.iterator();
            while (it2.hasNext()) {
                C2949ak akVar = (C2949ak) it2.next();
                if (akVar.f1283c > c - ((float) C2952an.f1300C)) {
                    paint.setAntiAlias(true);
                    paint.setColor(-16711936);
                    paint.setStyle(Paint.Style.FILL);
                    paint.setAlpha(i * 126);
                    float f = ((float) akVar.f1284d) * C3196gd.f2366m;
                    float f2 = ((float) akVar.f1285e) * C3196gd.f2366m;
                    float f3 = (float) (i * 8);
                    canvas.drawCircle(f, f2, f3, paint);
                    akVar.f1290j = true;
                    paint.setColor(SupportMenu.CATEGORY_MASK);
                    paint.setTextSize((float) (i * 16));
                    canvas.drawText("(" + akVar.f1284d + ", " + akVar.f1285e + ")" + akVar.f1283c, f + 16.0f, f2 + 16.0f, paint);
                    if (akVar.f1282b == 11) {
                        Iterator it3 = akVar.f1293m.iterator();
                        while (it3.hasNext()) {
                            C2949ak akVar2 = (C2949ak) it3.next();
                            paint.setAntiAlias(true);
                            paint.setColor(-12303292);
                            paint.setStyle(Paint.Style.FILL);
                            paint.setAlpha(48);
                            canvas.drawCircle(((float) akVar2.f1284d) * C3196gd.f2366m, ((float) akVar2.f1285e) * C3196gd.f2366m, f3, paint);
                        }
                    }
                }
            }
        }
        paint.setColor(-16711936);
        paint.setTextSize((float) (i * 16));
        canvas.drawText(String.valueOf(c), 64.0f, 64.0f, paint);
    }

    @TargetApi(11)
    /* renamed from: a */
    private static void m2111a(View view, Canvas canvas) {
        if (!C3196gd.f2362i.isEmpty()) {
            Iterator it = C3196gd.f2362i.iterator();
            while (it.hasNext()) {
                C3181fw fwVar = (C3181fw) it.next();
                if (fwVar.f2300b.get() != null && ((View) fwVar.f2300b.get()).isShown() && ((View) fwVar.f2300b.get()).getVisibility() == 0) {
                    View view2 = (View) fwVar.f2300b.get();
                    try {
                        int[] iArr = new int[2];
                        view2.getLocationOnScreen(iArr);
                        Paint paint = new Paint();
                        paint.setColor(SupportMenu.CATEGORY_MASK);
                        paint.setStrokeWidth(3.0f);
                        if (view.getWindowToken() == null || view.getWindowToken().equals(view2.getWindowToken())) {
                            int[] iArr2 = new int[2];
                            view.getLocationOnScreen(iArr2);
                            float f = (float) (iArr[0] - iArr2[0]);
                            float f2 = (float) (iArr[1] - iArr2[1]);
                            canvas.drawRect(f, f2, f + ((float) view2.getWidth()), f2 + ((float) view2.getHeight()), paint);
                        }
                    } catch (Exception e) {
                        canvas.drawColor(-7829368);
                        e.printStackTrace();
                    }
                }
            }
        }
        if (!C3196gd.f2363j.isEmpty()) {
            Iterator it2 = C3196gd.f2363j.iterator();
            while (it2.hasNext()) {
                Paint paint2 = new Paint();
                paint2.setColor(SupportMenu.CATEGORY_MASK);
                paint2.setStrokeWidth(3.0f);
                canvas.drawRect((Rect) it2.next(), paint2);
            }
        }
        C3196gd.f2363j = new ArrayList();
    }

    /* renamed from: a */
    static void m2112a(ViewGroup viewGroup) {
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            FlutterView childAt = viewGroup.getChildAt(i);
            if (childAt instanceof ViewGroup) {
                m2112a((ViewGroup) childAt);
            } else if (childAt != null) {
                new StringBuilder("view is ").append(childAt.getClass().getName());
                if (childAt instanceof FlutterView) {
                    f2393f = new WeakReference(childAt);
                }
                if (childAt instanceof FlutterSurfaceView) {
                    f2394g = new WeakReference((FlutterSurfaceView) childAt);
                }
            }
        }
    }

    /* renamed from: a */
    static void m2114a(boolean z) {
        try {
            if (C3196gd.f2361h != null && C3196gd.f2361h.get() != null) {
                f2389b = new CountDownLatch(1);
                if (z) {
                    m2116b();
                } else {
                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                        public final void run() {
                            C3203ge.m2116b();
                        }
                    });
                }
                f2389b.await(75, TimeUnit.MILLISECONDS);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    static boolean m2115a(String str) {
        return !C2952an.f1311N.isEmpty() ? C2952an.f1311N.contains(str) : C2952an.f1312O.isEmpty() || !C2952an.f1312O.contains(str);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m2116b() {
        if (C3196gd.f2361h != null && C3196gd.f2361h.get() != null) {
            int[] iArr = new int[2];
            ((WebView) C3196gd.f2361h.get()).getLocationOnScreen(iArr);
            ((WebView) C3196gd.f2361h.get()).loadUrl("javascript:".concat(String.valueOf("!function(){var e=$$webviewX,t=$$webviewY,n=$$occludeAllTextFields;var i=[];function o(n,o){var a=n.left*o*window.devicePixelRatio+window.screenX+e,c=n.top*o*window.devicePixelRatio+window.screenY+t,r=n.right*o*window.devicePixelRatio+window.screenX+e,w=n.bottom*o*window.devicePixelRatio+window.screenY+t;i.push([parseInt(a),parseInt(c),parseInt(r),parseInt(w)])}!function(){var e,t=document.getElementsByClassName(\"uxcam-occlude\");for(e=0;e<t.length;e++){var n=t[e].getBoundingClientRect(),i=t[e].style.zoom;i||(i=1),o(n,i)}}(),function(){var e,t=document.getElementsByTagName(\"input\");for(e=0;e<t.length;e++){var i=t[e].getBoundingClientRect();if(\"password\"===t[e].type.toLowerCase()||n){var a=t[e].style.zoom;a||(a=1),o(i,a)}}}();try{UXCam.occludeRectsOnNextFrame(JSON.stringify(i))}catch(e){}}();".replace("$$webviewX", String.valueOf(iArr[0])).replace("$$webviewY", String.valueOf(iArr[1])).replace("$$occludeAllTextFields", String.valueOf(C2952an.f1340x)))));
        }
    }

    /* renamed from: b */
    public static void m2117b(ViewGroup viewGroup) {
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof ViewGroup) {
                if ((childAt instanceof WebView) && C2952an.f1308K) {
                    C3196gd.f2361h = new WeakReference((WebView) childAt);
                }
                m2117b((ViewGroup) childAt);
            } else if (childAt != null && (childAt instanceof TextView)) {
                int inputType = ((TextView) childAt).getInputType();
                if (inputType == 128 || inputType == 129) {
                    C3180fv fvVar = new C3180fv(false);
                    fvVar.f2300b = new WeakReference(childAt);
                    fvVar.f2301c = true;
                    C3196gd.f2362i.add(fvVar);
                }
                if ((childAt instanceof EditText) && C2952an.f1340x) {
                    C3180fv fvVar2 = new C3180fv(false);
                    fvVar2.f2300b = new WeakReference(childAt);
                    fvVar2.f2301c = true;
                    C3196gd.f2362i.add(fvVar2);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo38496a(List list, Bitmap bitmap) {
        if (C3196gd.f2359f) {
            new Canvas(bitmap).drawColor(Color.rgb(200, 0, 0));
            C2970bc.m1233a("pauseForAnotherApp");
            StringBuilder sb = new StringBuilder("painted RED, pauseForAnotherApp : ");
            sb.append(C3196gd.f2359f);
            sb.append(", viewRootSize : ");
            sb.append(list.size());
        } else if (list.size() != 0) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                C3208aa aaVar = (C3208aa) it.next();
                if (aaVar.f2401a instanceof ViewGroup) {
                    m2117b((ViewGroup) aaVar.f2401a);
                }
                if ((aaVar.f2403c.flags & 2) == 2) {
                    new Canvas(bitmap).drawARGB((int) (aaVar.f2403c.dimAmount * 255.0f), 0, 0, 0);
                }
                Point a = C3172fp.m2001a(C3183fy.m2030a());
                int i = a.y;
                float width = ((float) bitmap.getWidth()) / ((float) a.x);
                Canvas canvas = new Canvas(bitmap);
                canvas.translate(((float) aaVar.f2402b.left) * width, ((float) aaVar.f2402b.top) * width);
                canvas.scale(width, width);
                if (Build.VERSION.SDK_INT < 23) {
                    aaVar.f2401a.draw(canvas);
                } else if (aaVar.f2401a.isAttachedToWindow()) {
                    View view = aaVar.f2401a;
                    if (!C2952an.f1315R || C3196gd.f2361h == null || C3196gd.f2361h.get() == null) {
                        view.draw(canvas);
                    } else {
                        view.setDrawingCacheEnabled(true);
                        canvas.drawBitmap(view.getDrawingCache(), 0.0f, 0.0f, (Paint) null);
                        view.setDrawingCacheEnabled(false);
                    }
                    if (!(!C2952an.f1316S || f2393f == null || f2393f.get() == null)) {
                        FlutterView flutterView = (FlutterView) f2393f.get();
                        int[] iArr = new int[2];
                        flutterView.getLocationOnScreen(iArr);
                        try {
                            FlutterNativeView flutterNativeView = flutterView.getFlutterNativeView();
                            Method declaredMethod = flutterNativeView.getClass().getDeclaredMethod("getFlutterJNI", (Class[]) null);
                            declaredMethod.setAccessible(true);
                            canvas.drawBitmap(((FlutterJNI) declaredMethod.invoke(flutterNativeView, new Object[0])).getBitmap(), (float) iArr[0], (float) iArr[1], (Paint) null);
                        } catch (NoSuchMethodException e) {
                            e.printStackTrace();
                        } catch (IllegalAccessException e2) {
                            e2.printStackTrace();
                        } catch (InvocationTargetException e3) {
                            e3.printStackTrace();
                        }
                    }
                    if (!(!C2952an.f1316S || f2394g == null || f2394g.get() == null)) {
                        try {
                            int[] iArr2 = new int[2];
                            ((FlutterSurfaceView) f2394g.get()).getLocationOnScreen(iArr2);
                            canvas.drawBitmap(((FlutterRenderer) C3176ft.m2021a("flutterRenderer", f2394g.get())).getBitmap(), (float) iArr2[0], (float) iArr2[1], (Paint) null);
                        } catch (Exception e4) {
                            e4.printStackTrace();
                        }
                    }
                    boolean z = f2391d != null && f2391d.get() != null && ((View) f2391d.get()).isShown() && ((View) f2391d.get()).getMeasuredWidth() > 0 && ((View) f2391d.get()).getMeasuredHeight() > 0;
                    if (C3195gc.f2345c != null && z) {
                        int[] iArr3 = {0, 0};
                        ((View) f2391d.get()).getLocationOnScreen(iArr3);
                        canvas.drawBitmap(C3195gc.f2345c, (float) iArr3[0], (float) iArr3[1], (Paint) null);
                    }
                    if (f2392e != null && z) {
                        f2392e.snapshot(new GoogleMap.SnapshotReadyCallback() {
                            public final void onSnapshotReady(Bitmap bitmap) {
                                C3195gc.f2345c = bitmap;
                            }
                        });
                    }
                }
                Rect rect = new Rect(0, i, (int) (((float) bitmap.getWidth()) / width), (int) (((float) bitmap.getHeight()) / width));
                Paint paint = new Paint();
                paint.setAntiAlias(true);
                paint.setColor(ViewCompat.MEASURED_STATE_MASK);
                paint.setStyle(Paint.Style.FILL);
                canvas.drawRect(rect, paint);
                C3165fk.f2261g = 0;
                C3165fk.f2262h = (int) (((float) rect.height()) * width);
                if (C3196gd.m2091g() || C2934ad.f1242b) {
                    canvas.drawColor(SupportMenu.CATEGORY_MASK);
                } else {
                    m2111a(aaVar.f2401a, canvas);
                }
                m2114a(true);
                if (C3196gd.m2091g() || C2934ad.f1242b) {
                    canvas.drawColor(SupportMenu.CATEGORY_MASK);
                } else {
                    m2111a(aaVar.f2401a, canvas);
                }
            }
            if (C2952an.f1300C > 0) {
                m2110a(bitmap);
            }
            if (C3196gd.f2365l > 0) {
                int i2 = (int) (((float) C3196gd.f2365l) * C3196gd.f2366m);
                Canvas canvas2 = new Canvas(bitmap);
                try {
                    Paint paint2 = new Paint();
                    paint2.setColor(-3355444);
                    paint2.setStrokeWidth(3.0f);
                    canvas2.drawRect(0.0f, (float) i2, (float) canvas2.getWidth(), (float) canvas2.getHeight(), paint2);
                    Paint paint3 = new Paint();
                    paint3.setColor(ViewCompat.MEASURED_STATE_MASK);
                    paint3.setAntiAlias(true);
                    paint3.setTextSize(16.0f);
                    canvas2.drawText("Keyboard", (float) ((canvas2.getWidth() / 2) - (((int) paint3.measureText("Keyboard")) / 2)), (float) (i2 + ((canvas2.getHeight() - i2) / 2)), paint3);
                } catch (Exception e5) {
                    canvas2.drawColor(-65281);
                    e5.printStackTrace();
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00bf, code lost:
        if (android.os.Build.VERSION.SDK_INT >= 24) goto L_0x00c1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00c1, code lost:
        r5 = "mWindow";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00c3, code lost:
        r4 = (android.widget.PopupWindow) com.uxcam.internals.C3176ft.m2021a(r5, (java.lang.Object) r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00ca, code lost:
        r5 = "this$0";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00cd, code lost:
        if (r4 != null) goto L_0x00cf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00cf, code lost:
        r4.setTouchInterceptor(new com.uxcam.internals.C3203ge.C32074(r12));
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x00bd */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List mo38497b(android.app.Activity r13) {
        /*
            r12 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.lang.String r1 = "mWindowManager"
            android.view.WindowManager r2 = r13.getWindowManager()     // Catch:{ NoSuchFieldException -> 0x001d }
            java.lang.Class r2 = r2.getClass()     // Catch:{ NoSuchFieldException -> 0x001d }
            com.uxcam.internals.C3176ft.m2022a((java.lang.String) r1, (java.lang.Class) r2)     // Catch:{ NoSuchFieldException -> 0x001d }
            java.lang.String r1 = "mWindowManager"
            android.view.WindowManager r2 = r13.getWindowManager()     // Catch:{ NoSuchFieldException -> 0x001d }
            java.lang.Object r1 = com.uxcam.internals.C3176ft.m2021a((java.lang.String) r1, (java.lang.Object) r2)     // Catch:{ NoSuchFieldException -> 0x001d }
            goto L_0x0027
        L_0x001d:
            java.lang.String r1 = "mGlobal"
            android.view.WindowManager r13 = r13.getWindowManager()
            java.lang.Object r1 = com.uxcam.internals.C3176ft.m2021a((java.lang.String) r1, (java.lang.Object) r13)
        L_0x0027:
            java.lang.String r13 = "mRoots"
            java.lang.Object r13 = com.uxcam.internals.C3176ft.m2021a((java.lang.String) r13, (java.lang.Object) r1)
            java.lang.String r2 = "mParams"
            java.lang.Object r1 = com.uxcam.internals.C3176ft.m2021a((java.lang.String) r2, (java.lang.Object) r1)
            int r2 = android.os.Build.VERSION.SDK_INT
            r3 = 19
            if (r2 < r3) goto L_0x004e
            java.util.List r13 = (java.util.List) r13
            java.lang.Object[] r13 = r13.toArray()
            java.util.List r1 = (java.util.List) r1
            int r2 = r1.size()
            android.view.WindowManager$LayoutParams[] r2 = new android.view.WindowManager.LayoutParams[r2]
            java.lang.Object[] r1 = r1.toArray(r2)
        L_0x004b:
            android.view.WindowManager$LayoutParams[] r1 = (android.view.WindowManager.LayoutParams[]) r1
            goto L_0x0051
        L_0x004e:
            java.lang.Object[] r13 = (java.lang.Object[]) r13
            goto L_0x004b
        L_0x0051:
            r2 = 0
            r3 = 0
        L_0x0053:
            int r4 = r13.length
            if (r3 >= r4) goto L_0x00db
            r4 = r13[r3]
            java.lang.String r5 = "mView"
            java.lang.Object r4 = com.uxcam.internals.C3176ft.m2021a((java.lang.String) r5, (java.lang.Object) r4)
            android.view.View r4 = (android.view.View) r4
            r5 = 2
            int[] r5 = new int[r5]
            if (r4 == 0) goto L_0x00d7
            r4.getLocationOnScreen(r5)
            android.graphics.Rect r6 = new android.graphics.Rect
            r7 = r5[r2]
            r8 = 1
            r9 = r5[r8]
            r10 = r5[r2]
            int r11 = r4.getWidth()
            int r10 = r10 + r11
            r5 = r5[r8]
            int r8 = r4.getHeight()
            int r5 = r5 + r8
            r6.<init>(r7, r9, r10, r5)
            boolean r5 = r4.isShown()
            if (r5 == 0) goto L_0x0090
            com.uxcam.internals.ge$aa r5 = new com.uxcam.internals.ge$aa
            r7 = r1[r3]
            r5.<init>(r4, r6, r7)
            r0.add(r5)
        L_0x0090:
            android.content.Context r5 = r4.getContext()
            boolean r5 = r5 instanceof android.app.Activity
            if (r5 != 0) goto L_0x00d7
            r5 = 24
            int r6 = android.os.Build.VERSION.SDK_INT     // Catch:{ ClassCastException -> 0x00bd }
            if (r6 < r5) goto L_0x00a7
            java.lang.String r6 = "mWindow"
        L_0x00a0:
            java.lang.Object r6 = com.uxcam.internals.C3176ft.m2021a((java.lang.String) r6, (java.lang.Object) r4)     // Catch:{ ClassCastException -> 0x00bd }
            android.view.Window r6 = (android.view.Window) r6     // Catch:{ ClassCastException -> 0x00bd }
            goto L_0x00aa
        L_0x00a7:
            java.lang.String r6 = "this$0"
            goto L_0x00a0
        L_0x00aa:
            if (r6 == 0) goto L_0x00d7
            android.view.Window$Callback r7 = r6.getCallback()     // Catch:{ ClassCastException -> 0x00bd }
            boolean r8 = r7 instanceof com.uxcam.internals.C2942ag     // Catch:{ ClassCastException -> 0x00bd }
            if (r8 != 0) goto L_0x00d7
            com.uxcam.internals.ag r8 = new com.uxcam.internals.ag     // Catch:{ ClassCastException -> 0x00bd }
            r8.<init>(r7)     // Catch:{ ClassCastException -> 0x00bd }
            r6.setCallback(r8)     // Catch:{ ClassCastException -> 0x00bd }
            goto L_0x00d7
        L_0x00bd:
            int r6 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x00d7 }
            if (r6 < r5) goto L_0x00ca
            java.lang.String r5 = "mWindow"
        L_0x00c3:
            java.lang.Object r4 = com.uxcam.internals.C3176ft.m2021a((java.lang.String) r5, (java.lang.Object) r4)     // Catch:{ Exception -> 0x00d7 }
            android.widget.PopupWindow r4 = (android.widget.PopupWindow) r4     // Catch:{ Exception -> 0x00d7 }
            goto L_0x00cd
        L_0x00ca:
            java.lang.String r5 = "this$0"
            goto L_0x00c3
        L_0x00cd:
            if (r4 == 0) goto L_0x00d7
            com.uxcam.internals.ge$4 r5 = new com.uxcam.internals.ge$4     // Catch:{ Exception -> 0x00d7 }
            r5.<init>()     // Catch:{ Exception -> 0x00d7 }
            r4.setTouchInterceptor(r5)     // Catch:{ Exception -> 0x00d7 }
        L_0x00d7:
            int r3 = r3 + 1
            goto L_0x0053
        L_0x00db:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uxcam.internals.C3203ge.mo38497b(android.app.Activity):java.util.List");
    }
}
