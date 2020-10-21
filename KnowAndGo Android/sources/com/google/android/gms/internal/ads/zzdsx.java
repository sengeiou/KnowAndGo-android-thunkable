package com.google.android.gms.internal.ads;

import android.util.Log;
import org.apache.logging.log4j.message.ParameterizedMessage;

public final class zzdsx extends zzdtc {
    private String name;

    public zzdsx(String str) {
        this.name = str;
    }

    public final void zzhc(String str) {
        String str2 = this.name;
        StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 1 + String.valueOf(str).length());
        sb.append(str2);
        sb.append(ParameterizedMessage.ERROR_MSG_SEPARATOR);
        sb.append(str);
        Log.d("isoparser", sb.toString());
    }
}
