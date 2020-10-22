package com.uxcam.internals;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.SeekBar;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;

@TargetApi(11)
/* renamed from: com.uxcam.internals.fg */
public final class C3154fg {

    /* renamed from: a */
    public static ArrayList f2231a = new ArrayList();

    /* renamed from: b */
    public static ArrayList f2232b = new ArrayList();

    /* renamed from: c */
    public static boolean f2233c = false;

    /* renamed from: d */
    public static HandlerThread f2234d = new HandlerThread("screenActionLooper");

    /* renamed from: e */
    public static Handler f2235e = null;

    /* renamed from: f */
    private int f2236f = 0;

    /* renamed from: g */
    private int f2237g = 0;

    /* renamed from: h */
    private int f2238h = 0;

    /* renamed from: i */
    private int f2239i = 0;

    /* renamed from: j */
    private int f2240j = 0;

    /* renamed from: k */
    private int f2241k = 0;

    /* renamed from: a */
    private static View.OnTouchListener m1952a(View view) {
        Class cls = view.getClass();
        while (cls != View.class) {
            cls = cls.getSuperclass();
        }
        for (Field field : cls.getDeclaredFields()) {
            if ("mListenerInfo".equals(field.getName())) {
                field.setAccessible(true);
                return (View.OnTouchListener) C3176ft.m2021a("mOnTouchListener", field.get(view));
            }
        }
        return null;
    }

    /* renamed from: a */
    public static void m1953a() {
        if (!f2233c) {
            if (!f2234d.isAlive()) {
                f2234d.start();
                f2235e = new Handler(f2234d.getLooper()) {
                };
            }
            if (C2952an.f1306I) {
                final ViewGroup viewGroup = (ViewGroup) ((Activity) C3183fy.m2038b()).findViewById(16908290).getRootView();
                f2235e.post(new Runnable() {
                    public final void run() {
                        C3154fg.f2233c = true;
                        try {
                            Thread.sleep(800);
                            for (int i = 0; i < C3154fg.f2232b.size(); i++) {
                                if (((WeakReference) C3154fg.f2232b.get(i)).get() == null) {
                                    C3154fg.f2232b.remove(i);
                                }
                            }
                            new C3154fg().m1955a(viewGroup);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        C3154fg.f2233c = false;
                    }
                });
            }
        }
    }

    /* renamed from: a */
    private static void m1954a(View view, int i) {
        try {
            if (view.isShown() && view.getVisibility() == 0) {
                int i2 = 0;
                while (i2 < f2232b.size()) {
                    if (((WeakReference) f2232b.get(i2)).get() != view) {
                        i2++;
                    } else {
                        return;
                    }
                }
                View.OnTouchListener a = m1952a(view);
                if (!(a instanceof C3157fh)) {
                    view.setOnTouchListener(new C3157fh(a, i));
                    f2232b.add(new WeakReference(view));
                    return;
                }
                ((C3157fh) a).f2243a = i;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m1955a(ViewGroup viewGroup) {
        int i;
        for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
            View childAt = viewGroup.getChildAt(i2);
            if (childAt != null) {
                if (childAt instanceof ViewGroup) {
                    this.f2240j++;
                    m1954a(childAt, this.f2240j);
                    m1955a((ViewGroup) childAt);
                } else {
                    if (childAt instanceof CompoundButton) {
                        this.f2238h++;
                        i = this.f2238h;
                    } else if ((childAt instanceof Button) || (childAt instanceof ImageButton) || childAt.getClass().getName().contains("ActionMenuItemView")) {
                        this.f2236f++;
                        i = this.f2236f;
                    } else if (childAt instanceof EditText) {
                        this.f2237g++;
                        i = this.f2237g;
                    } else if (childAt instanceof SeekBar) {
                        this.f2239i++;
                        i = this.f2239i;
                    } else {
                        this.f2241k++;
                        i = this.f2241k;
                    }
                    m1954a(childAt, i);
                }
            }
        }
    }
}
