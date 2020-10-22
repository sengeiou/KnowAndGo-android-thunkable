package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.util.MimeTypes;

public final class zzkl {
    public static String zzau(String str) {
        int indexOf = str.indexOf(47);
        if (indexOf != -1) {
            return str.substring(0, indexOf);
        }
        String valueOf = String.valueOf(str);
        throw new IllegalArgumentException(valueOf.length() != 0 ? "Invalid mime type: ".concat(valueOf) : new String("Invalid mime type: "));
    }

    public static boolean zzav(String str) {
        return zzau(str).equals(MimeTypes.BASE_TYPE_AUDIO);
    }

    public static boolean zzaw(String str) {
        return MimeTypes.AUDIO_AC3.equals(str) || MimeTypes.AUDIO_E_AC3.equals(str);
    }
}
