package com.google.android.gms.internal.ads;

import android.os.RemoteException;

@zzard
public final class zzabj extends zzaal {
    private final String description;
    private final String zzcju;

    public zzabj(String str, String str2) {
        this.description = str;
        this.zzcju = str2;
    }

    public final String getDescription() throws RemoteException {
        return this.description;
    }

    public final String zzpt() throws RemoteException {
        return this.zzcju;
    }
}
