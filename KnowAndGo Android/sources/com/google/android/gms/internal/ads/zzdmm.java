package com.google.android.gms.internal.ads;

final class zzdmm {
    private static final Class<?> zzhcj = zzgu("libcore.io.Memory");
    private static final boolean zzhck = (zzgu("org.robolectric.Robolectric") != null);

    static boolean zzavl() {
        return zzhcj != null && !zzhck;
    }

    static Class<?> zzavm() {
        return zzhcj;
    }

    private static <T> Class<T> zzgu(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable unused) {
            return null;
        }
    }
}
