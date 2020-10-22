package com.google.android.gms.internal.ads;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.RemoteException;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

@zzard
public final class zzael extends NativeAd.Image {
    private final int height;
    private final Uri uri;
    private final int width;
    private final double zzcyl;
    private final zzaei zzcyq;
    private final Drawable zzcyr;

    public zzael(zzaei zzaei) {
        Drawable drawable;
        int i;
        this.zzcyq = zzaei;
        Uri uri2 = null;
        try {
            IObjectWrapper zzrf = this.zzcyq.zzrf();
            if (zzrf != null) {
                drawable = (Drawable) ObjectWrapper.unwrap(zzrf);
                this.zzcyr = drawable;
                uri2 = this.zzcyq.getUri();
                this.uri = uri2;
                double d = 1.0d;
                d = this.zzcyq.getScale();
                this.zzcyl = d;
                int i2 = -1;
                i = this.zzcyq.getWidth();
                this.width = i;
                i2 = this.zzcyq.getHeight();
                this.height = i2;
            }
        } catch (RemoteException e) {
            zzbad.zzc("", e);
        }
        drawable = null;
        this.zzcyr = drawable;
        try {
            uri2 = this.zzcyq.getUri();
        } catch (RemoteException e2) {
            zzbad.zzc("", e2);
        }
        this.uri = uri2;
        double d2 = 1.0d;
        try {
            d2 = this.zzcyq.getScale();
        } catch (RemoteException e3) {
            zzbad.zzc("", e3);
        }
        this.zzcyl = d2;
        int i22 = -1;
        try {
            i = this.zzcyq.getWidth();
        } catch (RemoteException e4) {
            zzbad.zzc("", e4);
            i = -1;
        }
        this.width = i;
        try {
            i22 = this.zzcyq.getHeight();
        } catch (RemoteException e5) {
            zzbad.zzc("", e5);
        }
        this.height = i22;
    }

    public final Drawable getDrawable() {
        return this.zzcyr;
    }

    public final Uri getUri() {
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
