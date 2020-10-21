package com.facebook.common.logging;

import java.util.Locale;

public class FLog {
    public static final int ASSERT = 7;
    public static final int DEBUG = 3;
    public static final int ERROR = 6;
    public static final int INFO = 4;
    public static final int VERBOSE = 2;
    public static final int WARN = 5;
    private static LoggingDelegate sHandler = FLogDefaultLoggingDelegate.getInstance();

    public static void setLoggingDelegate(LoggingDelegate loggingDelegate) {
        if (loggingDelegate != null) {
            sHandler = loggingDelegate;
            return;
        }
        throw new IllegalArgumentException();
    }

    public static boolean isLoggable(int i) {
        return sHandler.isLoggable(i);
    }

    public static void setMinimumLoggingLevel(int i) {
        sHandler.setMinimumLoggingLevel(i);
    }

    public static int getMinimumLoggingLevel() {
        return sHandler.getMinimumLoggingLevel();
    }

    /* renamed from: v */
    public static void m90v(String str, String str2) {
        if (sHandler.isLoggable(2)) {
            sHandler.mo12718v(str, str2);
        }
    }

    /* renamed from: v */
    public static void m91v(String str, String str2, Object obj) {
        if (sHandler.isLoggable(2)) {
            sHandler.mo12718v(str, formatString(str2, obj));
        }
    }

    /* renamed from: v */
    public static void m92v(String str, String str2, Object obj, Object obj2) {
        if (sHandler.isLoggable(2)) {
            sHandler.mo12718v(str, formatString(str2, obj, obj2));
        }
    }

    /* renamed from: v */
    public static void m93v(String str, String str2, Object obj, Object obj2, Object obj3) {
        if (sHandler.isLoggable(2)) {
            sHandler.mo12718v(str, formatString(str2, obj, obj2, obj3));
        }
    }

    /* renamed from: v */
    public static void m94v(String str, String str2, Object obj, Object obj2, Object obj3, Object obj4) {
        if (sHandler.isLoggable(2)) {
            sHandler.mo12718v(str, formatString(str2, obj, obj2, obj3, obj4));
        }
    }

    /* renamed from: v */
    public static void m82v(Class<?> cls, String str) {
        if (sHandler.isLoggable(2)) {
            sHandler.mo12718v(getTag(cls), str);
        }
    }

    /* renamed from: v */
    public static void m83v(Class<?> cls, String str, Object obj) {
        if (sHandler.isLoggable(2)) {
            sHandler.mo12718v(getTag(cls), formatString(str, obj));
        }
    }

    /* renamed from: v */
    public static void m84v(Class<?> cls, String str, Object obj, Object obj2) {
        if (sHandler.isLoggable(2)) {
            sHandler.mo12718v(getTag(cls), formatString(str, obj, obj2));
        }
    }

    /* renamed from: v */
    public static void m85v(Class<?> cls, String str, Object obj, Object obj2, Object obj3) {
        if (isLoggable(2)) {
            m82v(cls, formatString(str, obj, obj2, obj3));
        }
    }

    /* renamed from: v */
    public static void m86v(Class<?> cls, String str, Object obj, Object obj2, Object obj3, Object obj4) {
        if (sHandler.isLoggable(2)) {
            sHandler.mo12718v(getTag(cls), formatString(str, obj, obj2, obj3, obj4));
        }
    }

    /* renamed from: v */
    public static void m96v(String str, String str2, Object... objArr) {
        if (sHandler.isLoggable(2)) {
            sHandler.mo12718v(str, formatString(str2, objArr));
        }
    }

    /* renamed from: v */
    public static void m97v(String str, Throwable th, String str2, Object... objArr) {
        if (sHandler.isLoggable(2)) {
            sHandler.mo12719v(str, formatString(str2, objArr), th);
        }
    }

    /* renamed from: v */
    public static void m88v(Class<?> cls, String str, Object... objArr) {
        if (sHandler.isLoggable(2)) {
            sHandler.mo12718v(getTag(cls), formatString(str, objArr));
        }
    }

    /* renamed from: v */
    public static void m89v(Class<?> cls, Throwable th, String str, Object... objArr) {
        if (sHandler.isLoggable(2)) {
            sHandler.mo12719v(getTag(cls), formatString(str, objArr), th);
        }
    }

    /* renamed from: v */
    public static void m95v(String str, String str2, Throwable th) {
        if (sHandler.isLoggable(2)) {
            sHandler.mo12719v(str, str2, th);
        }
    }

    /* renamed from: v */
    public static void m87v(Class<?> cls, String str, Throwable th) {
        if (sHandler.isLoggable(2)) {
            sHandler.mo12719v(getTag(cls), str, th);
        }
    }

    /* renamed from: d */
    public static void m50d(String str, String str2) {
        if (sHandler.isLoggable(3)) {
            sHandler.mo12707d(str, str2);
        }
    }

    /* renamed from: d */
    public static void m51d(String str, String str2, Object obj) {
        if (sHandler.isLoggable(3)) {
            sHandler.mo12707d(str, formatString(str2, obj));
        }
    }

    /* renamed from: d */
    public static void m52d(String str, String str2, Object obj, Object obj2) {
        if (sHandler.isLoggable(3)) {
            sHandler.mo12707d(str, formatString(str2, obj, obj2));
        }
    }

    /* renamed from: d */
    public static void m53d(String str, String str2, Object obj, Object obj2, Object obj3) {
        if (sHandler.isLoggable(3)) {
            sHandler.mo12707d(str, formatString(str2, obj, obj2, obj3));
        }
    }

    /* renamed from: d */
    public static void m54d(String str, String str2, Object obj, Object obj2, Object obj3, Object obj4) {
        if (sHandler.isLoggable(3)) {
            sHandler.mo12707d(str, formatString(str2, obj, obj2, obj3, obj4));
        }
    }

    /* renamed from: d */
    public static void m42d(Class<?> cls, String str) {
        if (sHandler.isLoggable(3)) {
            sHandler.mo12707d(getTag(cls), str);
        }
    }

    /* renamed from: d */
    public static void m43d(Class<?> cls, String str, Object obj) {
        if (sHandler.isLoggable(3)) {
            sHandler.mo12707d(getTag(cls), formatString(str, obj));
        }
    }

    /* renamed from: d */
    public static void m44d(Class<?> cls, String str, Object obj, Object obj2) {
        if (sHandler.isLoggable(3)) {
            sHandler.mo12707d(getTag(cls), formatString(str, obj, obj2));
        }
    }

    /* renamed from: d */
    public static void m45d(Class<?> cls, String str, Object obj, Object obj2, Object obj3) {
        if (sHandler.isLoggable(3)) {
            sHandler.mo12707d(getTag(cls), formatString(str, obj, obj2, obj3));
        }
    }

    /* renamed from: d */
    public static void m46d(Class<?> cls, String str, Object obj, Object obj2, Object obj3, Object obj4) {
        if (sHandler.isLoggable(3)) {
            sHandler.mo12707d(getTag(cls), formatString(str, obj, obj2, obj3, obj4));
        }
    }

    /* renamed from: d */
    public static void m56d(String str, String str2, Object... objArr) {
        if (sHandler.isLoggable(3)) {
            m50d(str, formatString(str2, objArr));
        }
    }

    /* renamed from: d */
    public static void m57d(String str, Throwable th, String str2, Object... objArr) {
        if (sHandler.isLoggable(3)) {
            m55d(str, formatString(str2, objArr), th);
        }
    }

    /* renamed from: d */
    public static void m48d(Class<?> cls, String str, Object... objArr) {
        if (sHandler.isLoggable(3)) {
            sHandler.mo12707d(getTag(cls), formatString(str, objArr));
        }
    }

    /* renamed from: d */
    public static void m49d(Class<?> cls, Throwable th, String str, Object... objArr) {
        if (sHandler.isLoggable(3)) {
            sHandler.mo12708d(getTag(cls), formatString(str, objArr), th);
        }
    }

    /* renamed from: d */
    public static void m55d(String str, String str2, Throwable th) {
        if (sHandler.isLoggable(3)) {
            sHandler.mo12708d(str, str2, th);
        }
    }

    /* renamed from: d */
    public static void m47d(Class<?> cls, String str, Throwable th) {
        if (sHandler.isLoggable(3)) {
            sHandler.mo12708d(getTag(cls), str, th);
        }
    }

    /* renamed from: i */
    public static void m74i(String str, String str2) {
        if (sHandler.isLoggable(4)) {
            sHandler.mo12712i(str, str2);
        }
    }

    /* renamed from: i */
    public static void m75i(String str, String str2, Object obj) {
        if (sHandler.isLoggable(4)) {
            sHandler.mo12712i(str, formatString(str2, obj));
        }
    }

    /* renamed from: i */
    public static void m76i(String str, String str2, Object obj, Object obj2) {
        if (sHandler.isLoggable(4)) {
            sHandler.mo12712i(str, formatString(str2, obj, obj2));
        }
    }

    /* renamed from: i */
    public static void m77i(String str, String str2, Object obj, Object obj2, Object obj3) {
        if (sHandler.isLoggable(4)) {
            sHandler.mo12712i(str, formatString(str2, obj, obj2, obj3));
        }
    }

    /* renamed from: i */
    public static void m78i(String str, String str2, Object obj, Object obj2, Object obj3, Object obj4) {
        if (sHandler.isLoggable(4)) {
            sHandler.mo12712i(str, formatString(str2, obj, obj2, obj3, obj4));
        }
    }

    /* renamed from: i */
    public static void m66i(Class<?> cls, String str) {
        if (sHandler.isLoggable(4)) {
            sHandler.mo12712i(getTag(cls), str);
        }
    }

    /* renamed from: i */
    public static void m67i(Class<?> cls, String str, Object obj) {
        if (sHandler.isLoggable(4)) {
            sHandler.mo12712i(getTag(cls), formatString(str, obj));
        }
    }

    /* renamed from: i */
    public static void m68i(Class<?> cls, String str, Object obj, Object obj2) {
        if (sHandler.isLoggable(4)) {
            sHandler.mo12712i(getTag(cls), formatString(str, obj, obj2));
        }
    }

    /* renamed from: i */
    public static void m69i(Class<?> cls, String str, Object obj, Object obj2, Object obj3) {
        if (sHandler.isLoggable(4)) {
            sHandler.mo12712i(getTag(cls), formatString(str, obj, obj2, obj3));
        }
    }

    /* renamed from: i */
    public static void m70i(Class<?> cls, String str, Object obj, Object obj2, Object obj3, Object obj4) {
        if (sHandler.isLoggable(4)) {
            sHandler.mo12712i(getTag(cls), formatString(str, obj, obj2, obj3, obj4));
        }
    }

    /* renamed from: i */
    public static void m80i(String str, String str2, Object... objArr) {
        if (sHandler.isLoggable(4)) {
            sHandler.mo12712i(str, formatString(str2, objArr));
        }
    }

    /* renamed from: i */
    public static void m81i(String str, Throwable th, String str2, Object... objArr) {
        if (sHandler.isLoggable(4)) {
            sHandler.mo12713i(str, formatString(str2, objArr), th);
        }
    }

    /* renamed from: i */
    public static void m72i(Class<?> cls, String str, Object... objArr) {
        if (sHandler.isLoggable(4)) {
            sHandler.mo12712i(getTag(cls), formatString(str, objArr));
        }
    }

    /* renamed from: i */
    public static void m73i(Class<?> cls, Throwable th, String str, Object... objArr) {
        if (isLoggable(4)) {
            sHandler.mo12713i(getTag(cls), formatString(str, objArr), th);
        }
    }

    /* renamed from: i */
    public static void m79i(String str, String str2, Throwable th) {
        if (sHandler.isLoggable(4)) {
            sHandler.mo12713i(str, str2, th);
        }
    }

    /* renamed from: i */
    public static void m71i(Class<?> cls, String str, Throwable th) {
        if (sHandler.isLoggable(4)) {
            sHandler.mo12713i(getTag(cls), str, th);
        }
    }

    /* renamed from: w */
    public static void m102w(String str, String str2) {
        if (sHandler.isLoggable(5)) {
            sHandler.mo12720w(str, str2);
        }
    }

    /* renamed from: w */
    public static void m98w(Class<?> cls, String str) {
        if (sHandler.isLoggable(5)) {
            sHandler.mo12720w(getTag(cls), str);
        }
    }

    /* renamed from: w */
    public static void m104w(String str, String str2, Object... objArr) {
        if (sHandler.isLoggable(5)) {
            sHandler.mo12720w(str, formatString(str2, objArr));
        }
    }

    /* renamed from: w */
    public static void m105w(String str, Throwable th, String str2, Object... objArr) {
        if (sHandler.isLoggable(5)) {
            sHandler.mo12721w(str, formatString(str2, objArr), th);
        }
    }

    /* renamed from: w */
    public static void m100w(Class<?> cls, String str, Object... objArr) {
        if (sHandler.isLoggable(5)) {
            sHandler.mo12720w(getTag(cls), formatString(str, objArr));
        }
    }

    /* renamed from: w */
    public static void m101w(Class<?> cls, Throwable th, String str, Object... objArr) {
        if (isLoggable(5)) {
            m99w(cls, formatString(str, objArr), th);
        }
    }

    /* renamed from: w */
    public static void m103w(String str, String str2, Throwable th) {
        if (sHandler.isLoggable(5)) {
            sHandler.mo12721w(str, str2, th);
        }
    }

    /* renamed from: w */
    public static void m99w(Class<?> cls, String str, Throwable th) {
        if (sHandler.isLoggable(5)) {
            sHandler.mo12721w(getTag(cls), str, th);
        }
    }

    /* renamed from: e */
    public static void m62e(String str, String str2) {
        if (sHandler.isLoggable(6)) {
            sHandler.mo12709e(str, str2);
        }
    }

    /* renamed from: e */
    public static void m58e(Class<?> cls, String str) {
        if (sHandler.isLoggable(6)) {
            sHandler.mo12709e(getTag(cls), str);
        }
    }

    /* renamed from: e */
    public static void m64e(String str, String str2, Object... objArr) {
        if (sHandler.isLoggable(6)) {
            sHandler.mo12709e(str, formatString(str2, objArr));
        }
    }

    /* renamed from: e */
    public static void m65e(String str, Throwable th, String str2, Object... objArr) {
        if (sHandler.isLoggable(6)) {
            sHandler.mo12710e(str, formatString(str2, objArr), th);
        }
    }

    /* renamed from: e */
    public static void m60e(Class<?> cls, String str, Object... objArr) {
        if (sHandler.isLoggable(6)) {
            sHandler.mo12709e(getTag(cls), formatString(str, objArr));
        }
    }

    /* renamed from: e */
    public static void m61e(Class<?> cls, Throwable th, String str, Object... objArr) {
        if (sHandler.isLoggable(6)) {
            sHandler.mo12710e(getTag(cls), formatString(str, objArr), th);
        }
    }

    /* renamed from: e */
    public static void m63e(String str, String str2, Throwable th) {
        if (sHandler.isLoggable(6)) {
            sHandler.mo12710e(str, str2, th);
        }
    }

    /* renamed from: e */
    public static void m59e(Class<?> cls, String str, Throwable th) {
        if (sHandler.isLoggable(6)) {
            sHandler.mo12710e(getTag(cls), str, th);
        }
    }

    public static void wtf(String str, String str2) {
        if (sHandler.isLoggable(6)) {
            sHandler.wtf(str, str2);
        }
    }

    public static void wtf(Class<?> cls, String str) {
        if (sHandler.isLoggable(6)) {
            sHandler.wtf(getTag(cls), str);
        }
    }

    public static void wtf(String str, String str2, Object... objArr) {
        if (sHandler.isLoggable(6)) {
            sHandler.wtf(str, formatString(str2, objArr));
        }
    }

    public static void wtf(String str, Throwable th, String str2, Object... objArr) {
        if (sHandler.isLoggable(6)) {
            sHandler.wtf(str, formatString(str2, objArr), th);
        }
    }

    public static void wtf(Class<?> cls, String str, Object... objArr) {
        if (sHandler.isLoggable(6)) {
            sHandler.wtf(getTag(cls), formatString(str, objArr));
        }
    }

    public static void wtf(Class<?> cls, Throwable th, String str, Object... objArr) {
        if (sHandler.isLoggable(6)) {
            sHandler.wtf(getTag(cls), formatString(str, objArr), th);
        }
    }

    public static void wtf(String str, String str2, Throwable th) {
        if (sHandler.isLoggable(6)) {
            sHandler.wtf(str, str2, th);
        }
    }

    public static void wtf(Class<?> cls, String str, Throwable th) {
        if (sHandler.isLoggable(6)) {
            sHandler.wtf(getTag(cls), str, th);
        }
    }

    private static String formatString(String str, Object... objArr) {
        return String.format((Locale) null, str, objArr);
    }

    private static String getTag(Class<?> cls) {
        return cls.getSimpleName();
    }
}
