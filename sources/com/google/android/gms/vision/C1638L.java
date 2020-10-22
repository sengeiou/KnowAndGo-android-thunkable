package com.google.android.gms.vision;

import android.annotation.SuppressLint;
import android.util.Log;
import androidx.annotation.Keep;

@Keep
/* renamed from: com.google.android.gms.vision.L */
/* compiled from: com.google.android.gms:play-services-vision-common@@19.0.0 */
public class C1638L {
    public static final String TAG = "Vision";

    /* renamed from: v */
    public static int m201v(String str, Object... objArr) {
        if (Log.isLoggable(TAG, 2)) {
            return Log.v(TAG, String.format(str, objArr));
        }
        return 0;
    }

    /* renamed from: d */
    public static int m196d(String str, Object... objArr) {
        if (Log.isLoggable(TAG, 3)) {
            return Log.d(TAG, String.format(str, objArr));
        }
        return 0;
    }

    /* renamed from: d */
    public static int m197d(Throwable th, String str, Object... objArr) {
        if (Log.isLoggable(TAG, 3)) {
            return Log.d(TAG, String.format(str, objArr), th);
        }
        return 0;
    }

    /* renamed from: i */
    public static int m200i(String str, Object... objArr) {
        if (Log.isLoggable(TAG, 4)) {
            return Log.i(TAG, String.format(str, objArr));
        }
        return 0;
    }

    /* renamed from: e */
    public static int m198e(String str, Object... objArr) {
        if (Log.isLoggable(TAG, 6)) {
            return Log.e(TAG, String.format(str, objArr));
        }
        return 0;
    }

    @SuppressLint({"LogTagMismatch"})
    /* renamed from: e */
    public static int m199e(Throwable th, String str, Object... objArr) {
        if (!Log.isLoggable(TAG, 6)) {
            return 0;
        }
        if (Log.isLoggable(TAG, 3)) {
            return Log.e(TAG, String.format(str, objArr), th);
        }
        String format = String.format(str, objArr);
        String valueOf = String.valueOf(th);
        StringBuilder sb = new StringBuilder(String.valueOf(format).length() + 2 + String.valueOf(valueOf).length());
        sb.append(format);
        sb.append(": ");
        sb.append(valueOf);
        return Log.e(TAG, sb.toString());
    }

    /* renamed from: w */
    public static int m202w(String str, Object... objArr) {
        if (Log.isLoggable(TAG, 5)) {
            return Log.w(TAG, String.format(str, objArr));
        }
        return 0;
    }

    @SuppressLint({"LogTagMismatch"})
    /* renamed from: w */
    public static int m203w(Throwable th, String str, Object... objArr) {
        if (!Log.isLoggable(TAG, 5)) {
            return 0;
        }
        if (Log.isLoggable(TAG, 3)) {
            return Log.w(TAG, String.format(str, objArr), th);
        }
        String format = String.format(str, objArr);
        String valueOf = String.valueOf(th);
        StringBuilder sb = new StringBuilder(String.valueOf(format).length() + 2 + String.valueOf(valueOf).length());
        sb.append(format);
        sb.append(": ");
        sb.append(valueOf);
        return Log.w(TAG, sb.toString());
    }
}
