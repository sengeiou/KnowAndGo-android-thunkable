package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.MediaCrypto;

@TargetApi(16)
public interface zzhz {
    void close();

    int getState();

    boolean requiresSecureDecoderComponent(String str);

    void zza(zzhw zzhw);

    MediaCrypto zzfa();

    Exception zzfb();
}
