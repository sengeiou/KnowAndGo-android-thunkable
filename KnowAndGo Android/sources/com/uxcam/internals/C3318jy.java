package com.uxcam.internals;

import android.graphics.Bitmap;

/* renamed from: com.uxcam.internals.jy */
public final class C3318jy {
    /* renamed from: a */
    public static void m2363a(Bitmap bitmap, C3239hi hiVar) {
        int[] iArr = hiVar.f2535d[0];
        int[] iArr2 = new int[(bitmap.getWidth() * bitmap.getHeight())];
        bitmap.getPixels(iArr2, 0, bitmap.getWidth(), 0, 0, bitmap.getWidth(), bitmap.getHeight());
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i < bitmap.getHeight()) {
            int i4 = i3;
            int i5 = i2;
            int i6 = 0;
            while (i6 < bitmap.getWidth()) {
                int i7 = iArr2[i5];
                iArr[i4] = (i7 >> 16) & 255;
                iArr[i4 + 1] = (i7 >> 8) & 255;
                iArr[i4 + 2] = i7 & 255;
                i6++;
                i5++;
                i4 += 3;
            }
            i++;
            i2 = i5;
            i3 = i4;
        }
    }
}
