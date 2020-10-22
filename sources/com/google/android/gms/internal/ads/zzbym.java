package com.google.android.gms.internal.ads;

import android.graphics.drawable.Drawable;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

@zzard
public final class zzbym extends zzaef {
    private final zzbyt zzfmq;

    public zzbym(zzbyt zzbyt) {
        this.zzfmq = zzbyt;
    }

    public final float getAspectRatio() {
        if (!((Boolean) zzyt.zzpe().zzd(zzacu.zzcwx)).booleanValue()) {
            return 0.0f;
        }
        if (this.zzfmq.zzsq() != 0.0f) {
            return this.zzfmq.zzsq();
        }
        if (this.zzfmq.getVideoController() != null) {
            return zzahq();
        }
        return zzahr();
    }

    private final float zzahq() {
        try {
            return this.zzfmq.getVideoController().getAspectRatio();
        } catch (RemoteException e) {
            zzawz.zzc("Remote exception getting video controller aspect ratio.", e);
            return 0.0f;
        }
    }

    private final float zzahr() {
        zzadw zzadw = this.zzfmq.getImages().get(0);
        if (zzadw.getWidth() != -1 && zzadw.getHeight() != -1) {
            return ((float) zzadw.getWidth()) / ((float) zzadw.getHeight());
        }
        try {
            Drawable drawable = (Drawable) ObjectWrapper.unwrap(zzadw.zzrf());
            if (drawable == null || drawable.getIntrinsicWidth() == -1 || drawable.getIntrinsicHeight() == -1) {
                return 0.0f;
            }
            return ((float) drawable.getIntrinsicWidth()) / ((float) drawable.getIntrinsicHeight());
        } catch (RemoteException e) {
            zzawz.zzc("RemoteException getting Drawable for aspect ratio calculation.", e);
            return 0.0f;
        }
    }
}
