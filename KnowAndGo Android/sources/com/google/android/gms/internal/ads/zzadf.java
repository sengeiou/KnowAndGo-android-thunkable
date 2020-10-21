package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import androidx.annotation.Nullable;

final class zzadf extends zzadc {
    zzadf() {
    }

    public final String zzg(@Nullable String str, String str2) {
        String zzci = zzci(str);
        String zzci2 = zzci(str2);
        if (TextUtils.isEmpty(zzci)) {
            return zzci2;
        }
        if (TextUtils.isEmpty(zzci2)) {
            return zzci;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(zzci).length() + 1 + String.valueOf(zzci2).length());
        sb.append(zzci);
        sb.append(",");
        sb.append(zzci2);
        return sb.toString();
    }

    @Nullable
    private static String zzci(@Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        int i = 0;
        int length = str.length();
        while (i < str.length() && str.charAt(i) == ',') {
            i++;
        }
        while (length > 0 && str.charAt(length - 1) == ',') {
            length--;
        }
        if (length < i) {
            return null;
        }
        if (i == 0 && length == str.length()) {
            return str;
        }
        return str.substring(i, length);
    }
}
