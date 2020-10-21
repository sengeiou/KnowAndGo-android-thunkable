package com.uxcam.internals;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import com.facebook.react.uimanager.ViewProps;
import com.uxcam.internals.C3152ff;
import com.uxcam.internals.C3163fj;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;

/* renamed from: com.uxcam.internals.fl */
public class C3166fl extends ScaleGestureDetector.SimpleOnScaleGestureListener implements GestureDetector.OnDoubleTapListener, GestureDetector.OnGestureListener {

    /* renamed from: a */
    public static boolean f2274a = false;

    /* renamed from: e */
    private static final String f2275e = "fl";

    /* renamed from: b */
    public C3163fj f2276b;

    /* renamed from: c */
    public C2953ao f2277c;

    /* renamed from: d */
    String f2278d;

    /* renamed from: f */
    private boolean f2279f = true;

    /* renamed from: g */
    private boolean f2280g = false;

    /* renamed from: h */
    private float f2281h;

    /* renamed from: i */
    private float f2282i;

    /* renamed from: j */
    private ArrayList f2283j = new ArrayList();

    /* renamed from: com.uxcam.internals.fl$aa */
    enum C3168aa {
        ;
        

        /* renamed from: a */
        public static final int f2285a = 1;

        /* renamed from: b */
        public static final int f2286b = 2;

        /* renamed from: c */
        public static final int f2287c = 3;

        /* renamed from: d */
        public static final int f2288d = 4;

        static {
            f2289e = new int[]{f2285a, f2286b, f2287c, f2288d};
        }

        /* renamed from: a */
        public static int m1991a(double d) {
            return m1992a(d, 45.0f, 135.0f) ? f2285a : (m1992a(d, 0.0f, 45.0f) || m1992a(d, 315.0f, 360.0f)) ? f2288d : m1992a(d, 225.0f, 315.0f) ? f2286b : f2287c;
        }

        /* renamed from: a */
        private static boolean m1992a(double d, float f, float f2) {
            return d >= ((double) f) && d < ((double) f2);
        }
    }

    C3166fl() {
        int i = C2952an.f1302E[0];
        float f = ((float) C2952an.f1302E[1]) / 1000.0f;
        int a = (int) C3183fy.m2028a((float) C2952an.f1302E[2], C3183fy.m2030a());
        StringBuilder sb = new StringBuilder(" minGesture ");
        sb.append(i);
        sb.append(" time ");
        sb.append(f);
        sb.append(" distance ");
        sb.append(a);
        this.f2276b = new C3163fj(i, f, a, new C3163fj.C3164aa() {
            /* renamed from: a */
            public final void mo38444a(List list) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    C2949ak akVar = (C2949ak) it.next();
                    akVar.f1291k = true;
                    StringBuilder sb = new StringBuilder("(");
                    sb.append(akVar.f1282b);
                    sb.append(", ");
                    sb.append(akVar.f1283c - C3165fk.f2260f);
                    sb.append(", ");
                    sb.append(akVar.f1284d);
                    sb.append(", ");
                    sb.append(akVar.f1285e);
                    sb.append(")");
                    sb.append(akVar.f1291k ? "\t<isRage>" : "");
                }
                HashMap hashMap = new HashMap();
                Float valueOf = Float.valueOf(String.format(Locale.ENGLISH, "%.3f", new Object[]{Float.valueOf(((C2949ak) list.get(0)).f1283c - C3165fk.f2260f)}));
                hashMap.put("activity", ((C2949ak) list.get(0)).f1281a);
                C3165fk.m1970a().mo38446a("rageTap", valueOf.floatValue(), (Map) hashMap);
            }
        });
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0029, code lost:
        return 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0031, code lost:
        return 2;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int m1981a() {
        /*
            android.content.Context r0 = com.uxcam.internals.C3183fy.m2030a()
            java.lang.String r1 = "window"
            java.lang.Object r0 = r0.getSystemService(r1)
            android.view.WindowManager r0 = (android.view.WindowManager) r0
            android.view.Display r0 = r0.getDefaultDisplay()
            int r0 = r0.getRotation()
            android.content.Context r1 = com.uxcam.internals.C3183fy.m2030a()
            int r1 = com.uxcam.internals.C3183fy.m2057i(r1)
            r2 = 3
            r3 = 0
            r4 = 2
            r5 = 1
            r6 = -1
            if (r1 != r5) goto L_0x002b
            switch(r0) {
                case 0: goto L_0x0029;
                case 1: goto L_0x0027;
                case 2: goto L_0x0034;
                case 3: goto L_0x0031;
                default: goto L_0x0026;
            }
        L_0x0026:
            goto L_0x0033
        L_0x0027:
            r2 = 0
            goto L_0x0034
        L_0x0029:
            r2 = 1
            goto L_0x0034
        L_0x002b:
            if (r1 != r4) goto L_0x0033
            switch(r0) {
                case 0: goto L_0x0027;
                case 1: goto L_0x0034;
                case 2: goto L_0x0031;
                case 3: goto L_0x0029;
                default: goto L_0x0030;
            }
        L_0x0030:
            goto L_0x0033
        L_0x0031:
            r2 = 2
            goto L_0x0034
        L_0x0033:
            r2 = -1
        L_0x0034:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uxcam.internals.C3166fl.m1981a():int");
    }

    /* renamed from: a */
    private static int m1982a(float f, float f2, float f3, float f4) {
        return C3168aa.m1991a(m1987b(f, f2, f3, f4));
    }

    /* renamed from: a */
    private static C3152ff m1983a(ArrayList arrayList) {
        C3152ff.C3153aa a;
        C3181fw fwVar;
        C3181fw fwVar2;
        C3152ff.C3153aa aaVar = null;
        if (!arrayList.isEmpty()) {
            C3181fw fwVar3 = (C3181fw) arrayList.get(arrayList.size() - 1);
            if (fwVar3.f2300b.get() != null) {
                View view = (View) fwVar3.f2300b.get();
                try {
                    C3152ff.C3153aa aaVar2 = new C3152ff.C3153aa();
                    aaVar2.f2218b = view.getId();
                    aaVar2.f2219c = C3183fy.m2032a(view);
                    aaVar2.f2220d = fwVar3.f2302d;
                    aaVar2.f2223g = C3183fy.m2041c();
                    aaVar2.f2224h = fwVar3.f2303e;
                    Class cls = view.getClass();
                    aaVar2.f2225i = cls.getName();
                    ArrayList arrayList2 = new ArrayList();
                    while (cls.getSuperclass() != null) {
                        cls = cls.getSuperclass();
                        arrayList2.add(cls);
                    }
                    arrayList2.remove(0);
                    if (arrayList2.size() > 0) {
                        arrayList2.remove(arrayList2.size() - 1);
                    }
                    JSONArray jSONArray = new JSONArray();
                    Iterator it = arrayList2.iterator();
                    int i = 0;
                    while (it.hasNext()) {
                        Class cls2 = (Class) it.next();
                        if (i >= 4) {
                            break;
                        }
                        jSONArray.put(cls2.getName());
                        i++;
                    }
                    aaVar2.f2230n = jSONArray;
                    aaVar2.f2226j = fwVar3;
                    aaVar = aaVar2;
                } catch (Exception e) {
                    e.printStackTrace();
                }
                boolean z = view instanceof Button;
                if ((z || (view instanceof ImageButton) || view.getClass().getName().contains("ActionMenuItemView")) && !(view instanceof CompoundButton)) {
                    String charSequence = z ? ((Button) view).getText().toString() : "";
                    aaVar.f2217a = 1;
                    a = aaVar.mo38436a(charSequence);
                    fwVar = new C3181fw(view);
                } else {
                    if (view instanceof EditText) {
                        aaVar.f2217a = 2;
                        fwVar2 = new C3181fw(view);
                    } else if (view instanceof CompoundButton) {
                        aaVar.f2217a = 3;
                        aaVar.f2222f = ((CompoundButton) view).isChecked() ? ViewProps.f120ON : "off";
                        fwVar2 = new C3181fw(view);
                    } else if (view instanceof SeekBar) {
                        aaVar.f2217a = 4;
                        aaVar.f2222f = String.valueOf(((SeekBar) view).getProgress());
                        fwVar2 = new C3181fw(view);
                    } else {
                        if (view instanceof ViewGroup) {
                            ArrayList arrayList3 = new ArrayList();
                            m1984a((ViewGroup) view, arrayList3);
                            aaVar.f2217a = new C3181fw(view).mo38479a() ? 6 : 5;
                            aaVar.f2227k = arrayList3;
                        } else if (view instanceof TextView) {
                            String charSequence2 = ((TextView) view).getText().toString();
                            aaVar.f2217a = 7;
                            a = aaVar.mo38436a(charSequence2);
                            fwVar = new C3181fw(view);
                        } else {
                            aaVar.f2217a = -1;
                            aaVar.mo38436a("UnknownView");
                        }
                        aaVar.f2229m = "onTouchEvent";
                        return new C3152ff(aaVar, (byte) 0);
                    }
                    aaVar.f2226j = fwVar2;
                    aaVar.f2229m = "onTouchEvent";
                    return new C3152ff(aaVar, (byte) 0);
                }
                a.f2226j = fwVar;
                aaVar.f2229m = "onTouchEvent";
                return new C3152ff(aaVar, (byte) 0);
            }
        }
        return null;
    }

    /* renamed from: a */
    private static void m1984a(ViewGroup viewGroup, ArrayList arrayList) {
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof ViewGroup) {
                m1984a((ViewGroup) childAt, arrayList);
            } else {
                arrayList.add(new C3181fw(childAt));
            }
        }
    }

    /* renamed from: a */
    private void m1985a(C2949ak akVar) {
        if (this.f2277c == null) {
            return;
        }
        if (C3165fk.f2260f > 0.0f || !C2952an.f1323g || akVar.f1282b == 10) {
            akVar.f1281a = this.f2278d;
            if (!m1988b(akVar)) {
                float f = akVar.f1283c - this.f2277c.f1344b;
                if (f >= 1.0f || akVar.f1282b == 10) {
                    m1986a(akVar, this.f2277c);
                    return;
                }
                int indexOf = C3165fk.m1970a().f2267a.indexOf(this.f2277c) - 1;
                if (indexOf >= 0) {
                    akVar.mo38043a(akVar.f1283c - f);
                    akVar.f1284d += C3165fk.f2261g;
                    akVar.f1285e += C3165fk.f2262h;
                    m1986a(akVar, (C2953ao) C3165fk.m1970a().f2267a.get(indexOf));
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x007e, code lost:
        if (r7.f2306h != false) goto L_0x00b6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0088, code lost:
        if (r7.f2307i != false) goto L_0x00b6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0092, code lost:
        if (r7.f2309k != false) goto L_0x00b6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x009c, code lost:
        if (r7.f2308j != false) goto L_0x00b6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00a1, code lost:
        if (r6.f1282b == 11) goto L_0x00b6;
     */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00eb  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m1986a(com.uxcam.internals.C2949ak r6, com.uxcam.internals.C2953ao r7) {
        /*
            r5 = this;
            boolean r0 = r7.f1348f
            if (r0 != 0) goto L_0x0009
            java.util.ArrayList r7 = r7.f1345c
            r7.add(r6)
        L_0x0009:
            int r7 = r6.f1282b
            r0 = 1
            if (r7 == 0) goto L_0x0012
            int r7 = r6.f1282b
            if (r7 != r0) goto L_0x0017
        L_0x0012:
            com.uxcam.internals.fj r7 = r5.f2276b
            r7.mo38443a(r6)
        L_0x0017:
            java.util.ArrayList r7 = com.uxcam.internals.C3154fg.f2231a
            com.uxcam.internals.ff r7 = m1983a((java.util.ArrayList) r7)
            boolean r1 = com.uxcam.internals.C2952an.f1306I
            int r2 = r6.f1282b
            r3 = 10
            if (r2 == r3) goto L_0x0148
            boolean r2 = com.uxcam.internals.C2952an.f1306I
            if (r2 != 0) goto L_0x002b
            goto L_0x0148
        L_0x002b:
            if (r7 == 0) goto L_0x0147
            if (r1 == 0) goto L_0x0147
            r6.f1292l = r7
            int r1 = r6.f1282b
            r2 = 2
            r3 = 11
            if (r1 == 0) goto L_0x00a4
            int r1 = r6.f1282b
            if (r1 == r0) goto L_0x00a4
            int r1 = r6.f1282b
            r4 = 6
            if (r1 != r4) goto L_0x0042
            goto L_0x00a4
        L_0x0042:
            boolean r1 = r6.mo38047c()
            if (r1 != 0) goto L_0x004c
            int r1 = r6.f1282b
            if (r1 != r3) goto L_0x00be
        L_0x004c:
            r6.f1292l = r7
            com.uxcam.internals.fw r7 = r7.f2203a
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            boolean r4 = r7.f2306h
            r1.append(r4)
            java.lang.String r4 = " "
            r1.append(r4)
            boolean r4 = r7.f2307i
            r1.append(r4)
            java.lang.String r4 = " "
            r1.append(r4)
            boolean r4 = r7.f2308j
            r1.append(r4)
            java.lang.String r4 = " "
            r1.append(r4)
            boolean r4 = r7.f2309k
            r1.append(r4)
            int r1 = r6.f1282b
            if (r1 != r2) goto L_0x0081
            boolean r1 = r7.f2306h
            if (r1 == 0) goto L_0x0081
            goto L_0x00b6
        L_0x0081:
            int r1 = r6.f1282b
            r4 = 3
            if (r1 != r4) goto L_0x008b
            boolean r1 = r7.f2307i
            if (r1 == 0) goto L_0x008b
            goto L_0x00b6
        L_0x008b:
            int r1 = r6.f1282b
            r4 = 4
            if (r1 != r4) goto L_0x0095
            boolean r1 = r7.f2309k
            if (r1 == 0) goto L_0x0095
            goto L_0x00b6
        L_0x0095:
            int r1 = r6.f1282b
            r4 = 5
            if (r1 != r4) goto L_0x009f
            boolean r7 = r7.f2308j
            if (r7 == 0) goto L_0x009f
            goto L_0x00b6
        L_0x009f:
            int r7 = r6.f1282b
            if (r7 != r3) goto L_0x00be
            goto L_0x00b6
        L_0x00a4:
            com.uxcam.internals.fw r1 = r7.f2203a
            boolean r1 = r1.f2304f
            if (r1 != 0) goto L_0x00b0
            com.uxcam.internals.fw r1 = r7.f2203a
            boolean r1 = r1.f2312n
            if (r1 == 0) goto L_0x00be
        L_0x00b0:
            com.uxcam.internals.fw r7 = r7.f2203a
            boolean r7 = r7.f2305g
            if (r7 == 0) goto L_0x00bb
        L_0x00b6:
            java.lang.Boolean r7 = java.lang.Boolean.TRUE
        L_0x00b8:
            r6.f1289i = r7
            goto L_0x00be
        L_0x00bb:
            java.lang.Boolean r7 = java.lang.Boolean.FALSE
            goto L_0x00b8
        L_0x00be:
            boolean r7 = r6.mo38047c()
            if (r7 == 0) goto L_0x00f2
            com.uxcam.internals.ao r7 = r5.f2277c
            java.util.ArrayList r7 = r7.f1345c
            if (r7 == 0) goto L_0x00f2
            com.uxcam.internals.ao r7 = r5.f2277c
            java.util.ArrayList r7 = r7.f1345c
            int r7 = r7.size()
            if (r7 <= r0) goto L_0x00f2
            com.uxcam.internals.ao r7 = r5.f2277c
            java.util.ArrayList r7 = r7.f1345c
            com.uxcam.internals.ao r0 = r5.f2277c
            java.util.ArrayList r0 = r0.f1345c
            int r0 = r0.size()
            int r0 = r0 - r2
            java.lang.Object r7 = r7.get(r0)
            com.uxcam.internals.ak r7 = (com.uxcam.internals.C2949ak) r7
            int r0 = r7.f1282b
            if (r0 != r3) goto L_0x00f2
            r0 = 0
            r7.f1292l = r0
            java.lang.Boolean r0 = r6.f1289i
            r7.f1289i = r0
        L_0x00f2:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r0 = "3 FINAL SCREEN ACTION is :: "
            r7.<init>(r0)
            java.lang.String r0 = r6.toString()
            r7.append(r0)
            java.lang.String r7 = "screenaction77"
            com.uxcam.internals.C2970bc.m1233a((java.lang.String) r7)
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r0 = "UXCam event "
            r7.<init>(r0)
            int r0 = r6.f1282b
            java.lang.String r0 = com.uxcam.internals.C3173fq.m2006a(r0)
            r7.append(r0)
            java.lang.String r0 = " added  RESPONSIVE "
            r7.append(r0)
            java.lang.Boolean r0 = r6.f1289i
            r7.append(r0)
            java.lang.String r0 = " x : "
            r7.append(r0)
            int r0 = r6.f1286f
            r7.append(r0)
            java.lang.String r0 = " y :"
            r7.append(r0)
            int r0 = r6.f1287g
            r7.append(r0)
            java.lang.String r0 = " time :"
            r7.append(r0)
            float r0 = r6.f1283c
            r7.append(r0)
            java.lang.String r0 = " orientation:"
            r7.append(r0)
            int r6 = r6.f1288h
            r7.append(r6)
        L_0x0147:
            return
        L_0x0148:
            java.lang.Boolean r7 = java.lang.Boolean.TRUE
            r6.f1289i = r7
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uxcam.internals.C3166fl.m1986a(com.uxcam.internals.ak, com.uxcam.internals.ao):void");
    }

    /* renamed from: b */
    private static double m1987b(float f, float f2, float f3, float f4) {
        return ((((Math.atan2((double) (f2 - f4), (double) (f3 - f)) + 3.141592653589793d) * 180.0d) / 3.141592653589793d) + 180.0d) % 360.0d;
    }

    /* renamed from: b */
    private static boolean m1988b(C2949ak akVar) {
        int i = akVar.f1286f;
        int i2 = akVar.f1287g;
        Iterator it = C3196gd.f2362i.iterator();
        while (it.hasNext()) {
            C3181fw fwVar = (C3181fw) it.next();
            if (fwVar.f2300b.get() != null && fwVar.f2301c) {
                View view = (View) fwVar.f2300b.get();
                int[] iArr = new int[2];
                view.getLocationOnScreen(iArr);
                int i3 = iArr[0];
                int i4 = iArr[1];
                int width = view.getWidth() + i3;
                int height = view.getHeight() + i4;
                if (i >= i3 && i <= width && i2 >= i4 && i2 <= height) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:42:0x010d */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo38452a(int r10, float r11, float r12) {
        /*
            r9 = this;
            boolean r0 = com.uxcam.internals.C3196gd.m2091g()     // Catch:{ Exception -> 0x0142 }
            if (r0 == 0) goto L_0x000b
            boolean r0 = com.uxcam.internals.C2952an.f1309L     // Catch:{ Exception -> 0x0142 }
            if (r0 != 0) goto L_0x000b
            return
        L_0x000b:
            float r3 = com.uxcam.internals.C3183fy.m2041c()     // Catch:{ Exception -> 0x0142 }
            com.uxcam.internals.ak r0 = new com.uxcam.internals.ak     // Catch:{ Exception -> 0x0142 }
            int r6 = (int) r11     // Catch:{ Exception -> 0x0142 }
            int r7 = (int) r12     // Catch:{ Exception -> 0x0142 }
            r1 = r0
            r2 = r10
            r4 = r6
            r5 = r7
            r1.<init>(r2, r3, r4, r5, r6, r7)     // Catch:{ Exception -> 0x0142 }
            int r10 = com.uxcam.internals.C3165fk.f2261g     // Catch:{ Exception -> 0x0142 }
            int r11 = com.uxcam.internals.C3165fk.f2262h     // Catch:{ Exception -> 0x0142 }
            r0.mo38044a(r10, r11)     // Catch:{ Exception -> 0x0142 }
            android.content.Context r10 = com.uxcam.internals.C3183fy.m2038b()     // Catch:{ Exception -> 0x0142 }
            android.app.Activity r10 = (android.app.Activity) r10     // Catch:{ Exception -> 0x0142 }
            android.view.Window r11 = r10.getWindow()     // Catch:{ Exception -> 0x0142 }
            r12 = 2
            if (r11 == 0) goto L_0x0043
            android.view.Window r10 = r10.getWindow()     // Catch:{ Exception -> 0x0142 }
            android.view.View r10 = r10.getDecorView()     // Catch:{ Exception -> 0x0142 }
            int[] r11 = new int[r12]     // Catch:{ Exception -> 0x0142 }
            r10.getLocationOnScreen(r11)     // Catch:{ Exception -> 0x0142 }
            int r10 = r0.f1285e     // Catch:{ Exception -> 0x0142 }
            r0.f1285e = r10     // Catch:{ Exception -> 0x0142 }
            int r10 = r0.f1284d     // Catch:{ Exception -> 0x0142 }
            r0.f1284d = r10     // Catch:{ Exception -> 0x0142 }
        L_0x0043:
            int r10 = m1981a()     // Catch:{ Exception -> 0x0142 }
            r0.f1288h = r10     // Catch:{ Exception -> 0x0142 }
            com.uxcam.internals.ao r10 = r9.f2277c     // Catch:{ Exception -> 0x0142 }
            if (r10 == 0) goto L_0x0141
            int r10 = r0.f1282b     // Catch:{ Exception -> 0x0142 }
            r11 = 12
            if (r10 != r11) goto L_0x0059
            java.util.ArrayList r10 = r9.f2283j     // Catch:{ Exception -> 0x0142 }
            r10.add(r0)     // Catch:{ Exception -> 0x0142 }
            return
        L_0x0059:
            java.util.ArrayList r10 = r9.f2283j     // Catch:{ Exception -> 0x0142 }
            boolean r10 = r10.isEmpty()     // Catch:{ Exception -> 0x0142 }
            r11 = 11
            r1 = 5
            r2 = 4
            r3 = 3
            r4 = 1
            r5 = 0
            if (r10 != 0) goto L_0x00bb
            int r10 = r0.f1282b     // Catch:{ Exception -> 0x0142 }
            if (r10 == r12) goto L_0x0078
            int r10 = r0.f1282b     // Catch:{ Exception -> 0x0142 }
            if (r10 == r3) goto L_0x0078
            int r10 = r0.f1282b     // Catch:{ Exception -> 0x0142 }
            if (r10 == r2) goto L_0x0078
            int r10 = r0.f1282b     // Catch:{ Exception -> 0x0142 }
            if (r10 != r1) goto L_0x00bb
        L_0x0078:
            java.util.ArrayList r10 = r9.f2283j     // Catch:{ Exception -> 0x0142 }
            java.lang.Object r10 = r10.get(r5)     // Catch:{ Exception -> 0x0142 }
            com.uxcam.internals.ak r10 = (com.uxcam.internals.C2949ak) r10     // Catch:{ Exception -> 0x0142 }
            com.uxcam.internals.ak r10 = r10.mo38042a()     // Catch:{ Exception -> 0x0142 }
            java.util.ArrayList r12 = r9.f2283j     // Catch:{ Exception -> 0x0142 }
            java.util.ArrayList r1 = r9.f2283j     // Catch:{ Exception -> 0x0142 }
            int r1 = r1.size()     // Catch:{ Exception -> 0x0142 }
            int r1 = r1 - r4
            java.lang.Object r12 = r12.get(r1)     // Catch:{ Exception -> 0x0142 }
            com.uxcam.internals.ak r12 = (com.uxcam.internals.C2949ak) r12     // Catch:{ Exception -> 0x0142 }
            com.uxcam.internals.ak r12 = r12.mo38042a()     // Catch:{ Exception -> 0x0142 }
            java.util.ArrayList r1 = r9.f2283j     // Catch:{ Exception -> 0x0142 }
            r10.f1293m = r1     // Catch:{ Exception -> 0x0142 }
            r10.mo38045b()     // Catch:{ Exception -> 0x0142 }
            r10.f1282b = r11     // Catch:{ Exception -> 0x0142 }
            r9.m1985a((com.uxcam.internals.C2949ak) r10)     // Catch:{ Exception -> 0x0142 }
            int r11 = r0.f1282b     // Catch:{ Exception -> 0x0142 }
            r12.f1282b = r11     // Catch:{ Exception -> 0x0142 }
            int r11 = r10.f1284d     // Catch:{ Exception -> 0x0142 }
            r12.f1286f = r11     // Catch:{ Exception -> 0x0142 }
            int r10 = r10.f1285e     // Catch:{ Exception -> 0x0142 }
            r12.f1287g = r10     // Catch:{ Exception -> 0x0142 }
            r9.m1985a((com.uxcam.internals.C2949ak) r12)     // Catch:{ Exception -> 0x0142 }
            java.util.ArrayList r10 = new java.util.ArrayList     // Catch:{ Exception -> 0x0142 }
            r10.<init>()     // Catch:{ Exception -> 0x0142 }
            r9.f2283j = r10     // Catch:{ Exception -> 0x0142 }
            goto L_0x012d
        L_0x00bb:
            java.util.ArrayList r10 = r9.f2283j     // Catch:{ Exception -> 0x0142 }
            boolean r10 = r10.isEmpty()     // Catch:{ Exception -> 0x0142 }
            if (r10 != 0) goto L_0x012c
            java.util.ArrayList r10 = r9.f2283j     // Catch:{ Exception -> 0x0142 }
            java.lang.Object r10 = r10.get(r5)     // Catch:{ Exception -> 0x0142 }
            com.uxcam.internals.ak r10 = (com.uxcam.internals.C2949ak) r10     // Catch:{ Exception -> 0x0142 }
            com.uxcam.internals.ak r10 = r10.mo38042a()     // Catch:{ Exception -> 0x0142 }
            java.util.ArrayList r6 = r9.f2283j     // Catch:{ Exception -> 0x0142 }
            java.util.ArrayList r7 = r9.f2283j     // Catch:{ Exception -> 0x0142 }
            int r7 = r7.size()     // Catch:{ Exception -> 0x0142 }
            int r7 = r7 - r4
            java.lang.Object r4 = r6.get(r7)     // Catch:{ Exception -> 0x0142 }
            com.uxcam.internals.ak r4 = (com.uxcam.internals.C2949ak) r4     // Catch:{ Exception -> 0x0142 }
            com.uxcam.internals.ak r4 = r4.mo38042a()     // Catch:{ Exception -> 0x0142 }
            int r6 = r10.f1284d     // Catch:{ Exception -> 0x010d }
            float r6 = (float) r6     // Catch:{ Exception -> 0x010d }
            int r7 = r10.f1285e     // Catch:{ Exception -> 0x010d }
            float r7 = (float) r7     // Catch:{ Exception -> 0x010d }
            int r8 = r4.f1284d     // Catch:{ Exception -> 0x010d }
            float r8 = (float) r8     // Catch:{ Exception -> 0x010d }
            int r4 = r4.f1285e     // Catch:{ Exception -> 0x010d }
            float r4 = (float) r4     // Catch:{ Exception -> 0x010d }
            int r4 = m1982a(r6, r7, r8, r4)     // Catch:{ Exception -> 0x010d }
            int r6 = com.uxcam.internals.C3166fl.C3168aa.f2286b     // Catch:{ Exception -> 0x010d }
            if (r4 != r6) goto L_0x00f9
            r10.f1282b = r3     // Catch:{ Exception -> 0x010d }
            goto L_0x010d
        L_0x00f9:
            int r3 = com.uxcam.internals.C3166fl.C3168aa.f2285a     // Catch:{ Exception -> 0x010d }
            if (r4 != r3) goto L_0x0100
            r10.f1282b = r12     // Catch:{ Exception -> 0x010d }
            goto L_0x010d
        L_0x0100:
            int r12 = com.uxcam.internals.C3166fl.C3168aa.f2288d     // Catch:{ Exception -> 0x010d }
            if (r4 != r12) goto L_0x0107
            r10.f1282b = r1     // Catch:{ Exception -> 0x010d }
            goto L_0x010d
        L_0x0107:
            int r12 = com.uxcam.internals.C3166fl.C3168aa.f2287c     // Catch:{ Exception -> 0x010d }
            if (r4 != r12) goto L_0x010d
            r10.f1282b = r2     // Catch:{ Exception -> 0x010d }
        L_0x010d:
            java.util.ArrayList r10 = r9.f2283j     // Catch:{ Exception -> 0x0142 }
            java.lang.Object r10 = r10.get(r5)     // Catch:{ Exception -> 0x0142 }
            com.uxcam.internals.ak r10 = (com.uxcam.internals.C2949ak) r10     // Catch:{ Exception -> 0x0142 }
            com.uxcam.internals.ak r10 = r10.mo38042a()     // Catch:{ Exception -> 0x0142 }
            r10.f1282b = r11     // Catch:{ Exception -> 0x0142 }
            java.util.ArrayList r11 = r9.f2283j     // Catch:{ Exception -> 0x0142 }
            r10.f1293m = r11     // Catch:{ Exception -> 0x0142 }
            r10.mo38045b()     // Catch:{ Exception -> 0x0142 }
            r9.m1985a((com.uxcam.internals.C2949ak) r10)     // Catch:{ Exception -> 0x0142 }
            java.util.ArrayList r10 = new java.util.ArrayList     // Catch:{ Exception -> 0x0142 }
            r10.<init>()     // Catch:{ Exception -> 0x0142 }
            r9.f2283j = r10     // Catch:{ Exception -> 0x0142 }
        L_0x012c:
            r4 = 0
        L_0x012d:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0142 }
            java.lang.String r11 = "scrtest normal gesture registered "
            r10.<init>(r11)     // Catch:{ Exception -> 0x0142 }
            int r11 = r0.f1282b     // Catch:{ Exception -> 0x0142 }
            r10.append(r11)     // Catch:{ Exception -> 0x0142 }
            com.uxcam.internals.C2970bc.m1234a()     // Catch:{ Exception -> 0x0142 }
            if (r4 != 0) goto L_0x0141
            r9.m1985a((com.uxcam.internals.C2949ak) r0)     // Catch:{ Exception -> 0x0142 }
        L_0x0141:
            return
        L_0x0142:
            java.lang.String r10 = f2275e
            com.uxcam.internals.C2970bc.m1233a((java.lang.String) r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uxcam.internals.C3166fl.mo38452a(int, float, float):void");
    }

    public boolean onDoubleTap(MotionEvent motionEvent) {
        mo38452a(1, motionEvent.getRawX(), motionEvent.getRawY());
        return false;
    }

    public boolean onDoubleTapEvent(MotionEvent motionEvent) {
        return false;
    }

    public boolean onDown(MotionEvent motionEvent) {
        if (motionEvent != null) {
            this.f2281h = motionEvent.getRawX();
            this.f2282i = motionEvent.getRawY();
            this.f2279f = this.f2280g;
            if (this.f2277c != null && !this.f2283j.isEmpty()) {
                C2949ak a = ((C2949ak) this.f2283j.get(0)).mo38042a();
                a.f1282b = 11;
                a.f1293m = this.f2283j;
                a.mo38045b();
                m1985a(a);
                this.f2283j = new ArrayList();
            }
        }
        C3154fg.m1953a();
        return false;
    }

    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        int i;
        if (motionEvent == null || motionEvent2 == null) {
            return false;
        }
        int a = m1982a(motionEvent.getRawX(), motionEvent.getRawY(), motionEvent2.getRawX(), motionEvent2.getRawY());
        if (a == C3168aa.f2286b && Math.abs(f2) > 1.0f) {
            i = 3;
        } else if (a == C3168aa.f2285a && Math.abs(f2) > 1.0f) {
            i = 2;
        } else if (a == C3168aa.f2288d && Math.abs(f) > 1.0f) {
            i = 5;
        } else if (a != C3168aa.f2287c || Math.abs(f) <= 1.0f) {
            return false;
        } else {
            i = 4;
        }
        mo38452a(i, motionEvent2.getRawX(), motionEvent2.getRawY());
        return false;
    }

    public void onLongPress(MotionEvent motionEvent) {
        if (motionEvent != null) {
            mo38452a(6, motionEvent.getRawX(), motionEvent.getRawY());
        }
    }

    public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
        this.f2280g = true;
        return false;
    }

    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (motionEvent == null || motionEvent2 == null) {
            return false;
        }
        if (this.f2283j.isEmpty()) {
            mo38452a(12, motionEvent.getRawX(), motionEvent.getRawY());
        }
        mo38452a(12, motionEvent2.getRawX(), motionEvent2.getRawY());
        return false;
    }

    public void onShowPress(MotionEvent motionEvent) {
    }

    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        this.f2280g = true;
        if (motionEvent != null) {
            mo38452a(0, motionEvent.getRawX(), motionEvent.getRawY());
        }
        return false;
    }

    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }
}
