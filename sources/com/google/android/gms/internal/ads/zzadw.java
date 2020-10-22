package com.google.android.gms.internal.ads;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

@zzard
public final class zzadw extends zzaej {
    private final int height;
    private final Uri uri;
    private final int width;
    private final Drawable zzcyk;
    private final double zzcyl;

    public zzadw(Drawable drawable, Uri uri2, double d, int i, int i2) {
        this.zzcyk = drawable;
        this.uri = uri2;
        this.zzcyl = d;
        this.width = i;
        this.height = i2;
    }

    public final IObjectWrapper zzrf() throws RemoteException {
        return ObjectWrapper.wrap(this.zzcyk);
    }

    public final Uri getUri() throws RemoteException {
        return this.uri;
    }

    public final double getScale() {
        return this.zzcyl;
    }

    public final int getWidth() {
        return this.width;
    }

    public final int getHeight() {
        return this.height;
    }
}
