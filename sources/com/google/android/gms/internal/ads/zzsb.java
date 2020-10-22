package com.google.android.gms.internal.ads;

import java.io.IOException;

public class zzsb extends IOException {
    private final int type;
    private final zzry zzbmo;

    public zzsb(String str, zzry zzry, int i) {
        super(str);
        this.zzbmo = zzry;
        this.type = 1;
    }

    public zzsb(IOException iOException, zzry zzry, int i) {
        super(iOException);
        this.zzbmo = zzry;
        this.type = i;
    }

    public zzsb(String str, IOException iOException, zzry zzry, int i) {
        super(str, iOException);
        this.zzbmo = zzry;
        this.type = 1;
    }
}
