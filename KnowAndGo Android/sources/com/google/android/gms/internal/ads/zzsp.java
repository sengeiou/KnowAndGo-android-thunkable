package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.util.MimeTypes;

public final class zzsp {
    public static boolean zzav(String str) {
        return MimeTypes.BASE_TYPE_AUDIO.equals(zzau(str));
    }

    public static boolean zzbf(String str) {
        return MimeTypes.BASE_TYPE_VIDEO.equals(zzau(str));
    }

    private static String zzau(String str) {
        if (str == null) {
            return null;
        }
        int indexOf = str.indexOf(47);
        if (indexOf != -1) {
            return str.substring(0, indexOf);
        }
        String valueOf = String.valueOf(str);
        throw new IllegalArgumentException(valueOf.length() != 0 ? "Invalid mime type: ".concat(valueOf) : new String("Invalid mime type: "));
    }
}
