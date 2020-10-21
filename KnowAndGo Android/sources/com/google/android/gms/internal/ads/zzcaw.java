package com.google.android.gms.internal.ads;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;

final /* synthetic */ class zzcaw implements zzbam {
    private final String zzddy;
    private final int zzdwk;
    private final int zzdwl;
    private final double zzfro;

    zzcaw(String str, double d, int i, int i2) {
        this.zzddy = str;
        this.zzfro = d;
        this.zzdwk = i;
        this.zzdwl = i2;
    }

    public final Object apply(Object obj) {
        String str = this.zzddy;
        return new zzadw(new BitmapDrawable(Resources.getSystem(), (Bitmap) obj), Uri.parse(str), this.zzfro, this.zzdwk, this.zzdwl);
    }
}
