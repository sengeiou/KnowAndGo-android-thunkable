package com.google.android.play.core.internal;

import android.os.Build;
import java.io.File;

/* renamed from: com.google.android.play.core.internal.av */
public final class C1998av {
    /* renamed from: a */
    public static C1997au m628a() {
        if (Build.VERSION.SDK_INT >= 21) {
            switch (Build.VERSION.SDK_INT) {
                case 21:
                    return new C2004ba();
                case 22:
                    return new C2005bb();
                case 23:
                    return new C2009bf();
                case 24:
                    return new C2010bg();
                case 25:
                    return new C2011bh();
                case 26:
                    return new C2014bk();
                case 27:
                    if (Build.VERSION.PREVIEW_SDK_INT == 0) {
                        return new C2015bl();
                    }
                    break;
            }
            return new C2017bn();
        }
        throw new AssertionError("Unsupported Android Version");
    }

    /* renamed from: a */
    public static String m629a(File file) {
        if (file.getName().endsWith(".apk")) {
            return file.getName().replaceFirst("(_\\d+)?\\.apk", "").replace("base-", "config.").replace("-", ".config.").replace(".config.master", "").replace("config.master", "");
        }
        throw new IllegalArgumentException("Non-apk found in splits directory.");
    }

    /* renamed from: a */
    public static <T> void m630a(T t, Object obj) {
        if (t == null) {
            throw new NullPointerException((String) obj);
        }
    }

    /* renamed from: a */
    public static void m631a(boolean z, Object obj) {
        if (!z) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }
}
