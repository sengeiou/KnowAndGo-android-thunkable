package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

final /* synthetic */ class zzbbe implements zzbal {
    private final Callable zzdzx;

    zzbbe(Callable callable) {
        this.zzdzx = callable;
    }

    public final zzbbh zzf(Object obj) {
        return zzbar.zzm(this.zzdzx.call());
    }
}
