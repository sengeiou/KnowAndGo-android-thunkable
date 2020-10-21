package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;

final /* synthetic */ class zzauk implements zzbaf {
    static final zzbaf zzbzd = new zzauk();

    private zzauk() {
    }

    public final Object apply(Object obj) {
        IBinder iBinder = (IBinder) obj;
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardedAdCreator");
        if (queryLocalInterface instanceof zzatz) {
            return (zzatz) queryLocalInterface;
        }
        return new zzaua(iBinder);
    }
}
