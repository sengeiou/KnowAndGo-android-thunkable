package com.uxcam.internals;

import android.annotation.TargetApi;
import android.graphics.Canvas;
import android.graphics.Paint;
import androidx.core.view.ViewCompat;
import com.uxcam.internals.C3344kw;

@TargetApi(18)
/* renamed from: com.uxcam.internals.kv */
public final class C3343kv implements C3344kw.C3346ab {

    /* renamed from: a */
    private Paint f2912a = new Paint();

    public C3343kv() {
        this.f2912a.setAntiAlias(true);
        this.f2912a.setDither(true);
        this.f2912a.setTextSize(22.0f);
    }

    /* renamed from: a */
    public final int mo38569a() {
        return C3183fy.m2029a(C3196gd.m2083b());
    }

    /* renamed from: a */
    public final boolean mo38570a(Canvas canvas) {
        boolean z = true;
        if (C3196gd.f2358e) {
            C3195gc.m2078a(true);
        }
        this.f2912a.setColor(ViewCompat.MEASURED_STATE_MASK);
        canvas.drawRect(0.0f, 0.0f, (float) canvas.getWidth(), (float) canvas.getHeight(), this.f2912a);
        if (C3195gc.f2344b != null && !C3195gc.f2344b.isRecycled()) {
            z = false;
        }
        if (!z) {
            canvas.drawBitmap(C3195gc.f2344b, 0.0f, 0.0f, (Paint) null);
        }
        return C3196gd.f2358e;
    }

    /* renamed from: b */
    public final int mo38571b() {
        return C3183fy.m2029a(C3196gd.m2086c());
    }
}
