package com.uxcam.internals;

import android.view.MotionEvent;
import android.view.View;
import java.util.ArrayList;

/* renamed from: com.uxcam.internals.fh */
final class C3157fh implements View.OnTouchListener {

    /* renamed from: a */
    int f2243a;

    /* renamed from: b */
    private View.OnTouchListener f2244b;

    C3157fh(View.OnTouchListener onTouchListener, int i) {
        this.f2244b = onTouchListener;
        this.f2243a = i;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        try {
            if (motionEvent.getAction() == 0) {
                C3154fg.f2231a = new ArrayList();
            }
            C3181fw fwVar = new C3181fw(view);
            fwVar.f2303e = this.f2243a;
            C3154fg.f2231a.add(fwVar);
            if (this.f2244b == null || !Thread.currentThread().getStackTrace()[3].getClassName().equals(View.class.getName())) {
                return false;
            }
            return this.f2244b.onTouch(view, motionEvent);
        } catch (Exception unused) {
            return false;
        }
    }
}
