package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

public class InstrumentedDrawable extends ForwardingDrawable {
    private boolean mIsChecked = false;
    private final Listener mListener;

    public interface Listener {
        void track(int i, int i2, int i3, int i4, int i5, int i6);
    }

    public InstrumentedDrawable(Drawable drawable, Listener listener) {
        super(drawable);
        this.mListener = listener;
    }

    public void draw(Canvas canvas) {
        if (!this.mIsChecked) {
            this.mIsChecked = true;
            RectF rectF = new RectF();
            getRootBounds(rectF);
            int width = (int) rectF.width();
            int height = (int) rectF.height();
            getTransformedBounds(rectF);
            int width2 = (int) rectF.width();
            int height2 = (int) rectF.height();
            int intrinsicWidth = getIntrinsicWidth();
            int intrinsicHeight = getIntrinsicHeight();
            if (this.mListener != null) {
                this.mListener.track(width, height, intrinsicWidth, intrinsicHeight, width2, height2);
            }
        }
        super.draw(canvas);
    }
}