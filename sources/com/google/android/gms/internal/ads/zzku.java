package com.google.android.gms.internal.ads;

import java.io.IOException;

public final class zzku extends Exception {
    private final int type;
    private final int zzark;

    public static zzku zza(Exception exc, int i) {
        return new zzku(1, (String) null, exc, i);
    }

    public static zzku zza(IOException iOException) {
        return new zzku(0, (String) null, iOException, -1);
    }

    static zzku zza(RuntimeException runtimeException) {
        return new zzku(2, (String) null, runtimeException, -1);
    }

    private zzku(int i, String str, Throwable th, int i2) {
        super((String) null, th);
        this.type = i;
        this.zzark = i2;
    }
}
