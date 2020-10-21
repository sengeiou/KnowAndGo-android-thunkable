package com.facebook.react.views.text;

import android.graphics.Paint;
import android.text.style.LineHeightSpan;

public class CustomLineHeightSpan implements LineHeightSpan, ReactSpan {
    private final int mHeight;

    CustomLineHeightSpan(float f) {
        this.mHeight = (int) Math.ceil((double) f);
    }

    public void chooseHeight(CharSequence charSequence, int i, int i2, int i3, int i4, Paint.FontMetricsInt fontMetricsInt) {
        if (fontMetricsInt.descent > this.mHeight) {
            int min = Math.min(this.mHeight, fontMetricsInt.descent);
            fontMetricsInt.descent = min;
            fontMetricsInt.bottom = min;
            fontMetricsInt.ascent = 0;
            fontMetricsInt.top = 0;
        } else if ((-fontMetricsInt.ascent) + fontMetricsInt.descent > this.mHeight) {
            fontMetricsInt.bottom = fontMetricsInt.descent;
            int i5 = (-this.mHeight) + fontMetricsInt.descent;
            fontMetricsInt.ascent = i5;
            fontMetricsInt.top = i5;
        } else if ((-fontMetricsInt.ascent) + fontMetricsInt.bottom > this.mHeight) {
            fontMetricsInt.top = fontMetricsInt.ascent;
            fontMetricsInt.bottom = fontMetricsInt.ascent + this.mHeight;
        } else if ((-fontMetricsInt.top) + fontMetricsInt.bottom > this.mHeight) {
            fontMetricsInt.top = fontMetricsInt.bottom - this.mHeight;
        } else {
            double d = (double) (((float) (this.mHeight - ((-fontMetricsInt.top) + fontMetricsInt.bottom))) / 2.0f);
            fontMetricsInt.top = (int) (((double) fontMetricsInt.top) - Math.ceil(d));
            fontMetricsInt.bottom = (int) (((double) fontMetricsInt.bottom) + Math.floor(d));
            fontMetricsInt.ascent = fontMetricsInt.top;
            fontMetricsInt.descent = fontMetricsInt.bottom;
        }
    }
}
