package com.facebook.imagepipeline.filter;

import android.os.Build;

public abstract class RenderScriptBlurFilter {
    public static final int BLUR_MAX_RADIUS = 25;

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0043  */
    @androidx.annotation.RequiresApi(17)
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void blurBitmap(android.graphics.Bitmap r2, android.graphics.Bitmap r3, android.content.Context r4, int r5) {
        /*
            com.facebook.common.internal.Preconditions.checkNotNull(r2)
            com.facebook.common.internal.Preconditions.checkNotNull(r3)
            com.facebook.common.internal.Preconditions.checkNotNull(r4)
            if (r5 <= 0) goto L_0x0011
            r0 = 25
            if (r5 > r0) goto L_0x0011
            r0 = 1
            goto L_0x0012
        L_0x0011:
            r0 = 0
        L_0x0012:
            com.facebook.common.internal.Preconditions.checkArgument(r0)
            r0 = 0
            android.renderscript.RenderScript r4 = android.renderscript.RenderScript.create(r4)     // Catch:{ all -> 0x003f }
            android.renderscript.Element r0 = android.renderscript.Element.U8_4(r4)     // Catch:{ all -> 0x003d }
            android.renderscript.ScriptIntrinsicBlur r0 = android.renderscript.ScriptIntrinsicBlur.create(r4, r0)     // Catch:{ all -> 0x003d }
            android.renderscript.Allocation r3 = android.renderscript.Allocation.createFromBitmap(r4, r3)     // Catch:{ all -> 0x003d }
            android.renderscript.Allocation r1 = android.renderscript.Allocation.createFromBitmap(r4, r2)     // Catch:{ all -> 0x003d }
            float r5 = (float) r5     // Catch:{ all -> 0x003d }
            r0.setRadius(r5)     // Catch:{ all -> 0x003d }
            r0.setInput(r3)     // Catch:{ all -> 0x003d }
            r0.forEach(r1)     // Catch:{ all -> 0x003d }
            r1.copyTo(r2)     // Catch:{ all -> 0x003d }
            if (r4 == 0) goto L_0x003c
            r4.destroy()
        L_0x003c:
            return
        L_0x003d:
            r2 = move-exception
            goto L_0x0041
        L_0x003f:
            r2 = move-exception
            r4 = r0
        L_0x0041:
            if (r4 == 0) goto L_0x0046
            r4.destroy()
        L_0x0046:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.filter.RenderScriptBlurFilter.blurBitmap(android.graphics.Bitmap, android.graphics.Bitmap, android.content.Context, int):void");
    }

    public static boolean canUseRenderScript() {
        return Build.VERSION.SDK_INT >= 17;
    }
}
