package com.uxcam.internals;

import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import java.lang.reflect.Field;
import java.math.BigInteger;
import java.security.SecureRandom;
import org.apache.commons.lang3.StringUtils;

/* renamed from: com.uxcam.internals.fp */
public final class C3172fp {

    /* renamed from: a */
    private static String f2293a;

    /* renamed from: a */
    public static Point m2001a(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        Point point = new Point();
        if (windowManager == null || Build.VERSION.SDK_INT <= 17) {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            return new Point(displayMetrics.widthPixels, displayMetrics.heightPixels);
        }
        windowManager.getDefaultDisplay().getRealSize(point);
        return point;
    }

    /* renamed from: a */
    public static String m2002a() {
        int i;
        StringBuilder sb = new StringBuilder();
        for (Field field : Build.VERSION_CODES.class.getFields()) {
            String name = field.getName();
            try {
                i = field.getInt(new Object());
            } catch (IllegalAccessException | IllegalArgumentException | NullPointerException unused) {
                C2970bc.m1238c();
                i = -1;
            }
            if (i == Build.VERSION.SDK_INT) {
                sb.append(StringUtils.SPACE);
                sb.append(name);
            }
        }
        return sb.toString();
    }

    /* renamed from: b */
    public static String m2003b(Context context) {
        String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
        f2293a = string;
        if (string.equals("") || f2293a == null || f2293a.isEmpty()) {
            f2293a = new BigInteger(64, new SecureRandom()).toString(16);
        }
        return f2293a;
    }

    /* renamed from: c */
    public static boolean m2004c(Context context) {
        return ((context.getResources().getConfiguration().screenLayout & 15) == 4) || ((context.getResources().getConfiguration().screenLayout & 15) == 3);
    }

    /* renamed from: d */
    public static String m2005d(Context context) {
        return m2004c(context) ? "Tablet" : "Phone";
    }
}
