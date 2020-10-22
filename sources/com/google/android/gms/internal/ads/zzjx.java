package com.google.android.gms.internal.ads;

import java.io.IOException;

public class zzjx extends IOException {
    private final zzjq zzapt;

    public zzjx(String str, zzjq zzjq) {
        super(str);
        this.zzapt = zzjq;
    }

    public zzjx(IOException iOException, zzjq zzjq) {
        super(iOException);
        this.zzapt = zzjq;
    }

    public zzjx(String str, IOException iOException, zzjq zzjq) {
        super(str, iOException);
        this.zzapt = zzjq;
    }
}
