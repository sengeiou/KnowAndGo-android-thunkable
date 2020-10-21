package com.facebook.react.views.text;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import androidx.annotation.Nullable;

public class ReactTypefaceUtils {
    public static final int UNSET = -1;

    public static int parseFontWeight(@Nullable String str) {
        int parseNumericFontWeight = str != null ? parseNumericFontWeight(str) : -1;
        if (parseNumericFontWeight == -1) {
            parseNumericFontWeight = 0;
        }
        if (parseNumericFontWeight == 700 || TtmlNode.BOLD.equals(str)) {
            return 1;
        }
        if (parseNumericFontWeight == 400 || "normal".equals(str)) {
            return 0;
        }
        return parseNumericFontWeight;
    }

    public static int parseFontStyle(@Nullable String str) {
        if (TtmlNode.ITALIC.equals(str)) {
            return 2;
        }
        return "normal".equals(str) ? 0 : -1;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String parseFontVariant(@androidx.annotation.Nullable com.facebook.react.bridge.ReadableArray r6) {
        /*
            if (r6 == 0) goto L_0x0084
            int r0 = r6.size()
            if (r0 != 0) goto L_0x000a
            goto L_0x0084
        L_0x000a:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 0
            r2 = 0
        L_0x0011:
            int r3 = r6.size()
            if (r2 >= r3) goto L_0x007d
            java.lang.String r3 = r6.getString(r2)
            if (r3 == 0) goto L_0x007a
            r4 = -1
            int r5 = r3.hashCode()
            switch(r5) {
                case -1195362251: goto L_0x004e;
                case -1061392823: goto L_0x0044;
                case -771984547: goto L_0x003a;
                case -659678800: goto L_0x0030;
                case 1183323111: goto L_0x0026;
                default: goto L_0x0025;
            }
        L_0x0025:
            goto L_0x0058
        L_0x0026:
            java.lang.String r5 = "small-caps"
            boolean r3 = r3.equals(r5)
            if (r3 == 0) goto L_0x0058
            r3 = 0
            goto L_0x0059
        L_0x0030:
            java.lang.String r5 = "oldstyle-nums"
            boolean r3 = r3.equals(r5)
            if (r3 == 0) goto L_0x0058
            r3 = 1
            goto L_0x0059
        L_0x003a:
            java.lang.String r5 = "tabular-nums"
            boolean r3 = r3.equals(r5)
            if (r3 == 0) goto L_0x0058
            r3 = 3
            goto L_0x0059
        L_0x0044:
            java.lang.String r5 = "lining-nums"
            boolean r3 = r3.equals(r5)
            if (r3 == 0) goto L_0x0058
            r3 = 2
            goto L_0x0059
        L_0x004e:
            java.lang.String r5 = "proportional-nums"
            boolean r3 = r3.equals(r5)
            if (r3 == 0) goto L_0x0058
            r3 = 4
            goto L_0x0059
        L_0x0058:
            r3 = -1
        L_0x0059:
            switch(r3) {
                case 0: goto L_0x0075;
                case 1: goto L_0x006f;
                case 2: goto L_0x0069;
                case 3: goto L_0x0063;
                case 4: goto L_0x005d;
                default: goto L_0x005c;
            }
        L_0x005c:
            goto L_0x007a
        L_0x005d:
            java.lang.String r3 = "'pnum'"
            r0.add(r3)
            goto L_0x007a
        L_0x0063:
            java.lang.String r3 = "'tnum'"
            r0.add(r3)
            goto L_0x007a
        L_0x0069:
            java.lang.String r3 = "'lnum'"
            r0.add(r3)
            goto L_0x007a
        L_0x006f:
            java.lang.String r3 = "'onum'"
            r0.add(r3)
            goto L_0x007a
        L_0x0075:
            java.lang.String r3 = "'smcp'"
            r0.add(r3)
        L_0x007a:
            int r2 = r2 + 1
            goto L_0x0011
        L_0x007d:
            java.lang.String r6 = ", "
            java.lang.String r6 = android.text.TextUtils.join(r6, r0)
            return r6
        L_0x0084:
            r6 = 0
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.views.text.ReactTypefaceUtils.parseFontVariant(com.facebook.react.bridge.ReadableArray):java.lang.String");
    }

    public static Typeface applyStyles(@Nullable Typeface typeface, int i, int i2, @Nullable String str, AssetManager assetManager) {
        int i3 = 0;
        int style = typeface == null ? 0 : typeface.getStyle();
        if (i2 == 1 || ((style & 1) != 0 && i2 == -1)) {
            i3 = 1;
        }
        if (i == 2 || ((style & 2) != 0 && i == -1)) {
            i3 |= 2;
        }
        if (str != null) {
            typeface = ReactFontManager.getInstance().getTypeface(str, i3, i2, assetManager);
        } else if (typeface != null) {
            typeface = Typeface.create(typeface, i3);
        }
        if (typeface != null) {
            return typeface;
        }
        return Typeface.defaultFromStyle(i3);
    }

    private static int parseNumericFontWeight(String str) {
        if (str.length() != 3 || !str.endsWith("00") || str.charAt(0) > '9' || str.charAt(0) < '1') {
            return -1;
        }
        return (str.charAt(0) - '0') * 100;
    }
}
