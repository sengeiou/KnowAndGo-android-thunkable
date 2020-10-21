package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.formats.MediaView;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.List;
import java.util.WeakHashMap;

@zzard
public final class zzafh implements NativeCustomTemplateAd {
    private static WeakHashMap<IBinder, zzafh> zzcyy = new WeakHashMap<>();
    private final VideoController zzcje = new VideoController();
    private final zzafe zzcyz;
    private final MediaView zzcza;

    @VisibleForTesting
    private zzafh(zzafe zzafe) {
        Context context;
        this.zzcyz = zzafe;
        MediaView mediaView = null;
        try {
            context = (Context) ObjectWrapper.unwrap(zzafe.zzrm());
        } catch (RemoteException | NullPointerException e) {
            zzbad.zzc("", e);
            context = null;
        }
        if (context != null) {
            MediaView mediaView2 = new MediaView(context);
            try {
                if (this.zzcyz.zzp(ObjectWrapper.wrap(mediaView2))) {
                    mediaView = mediaView2;
                }
            } catch (RemoteException e2) {
                zzbad.zzc("", e2);
            }
        }
        this.zzcza = mediaView;
    }

    public static zzafh zza(zzafe zzafe) {
        synchronized (zzcyy) {
            zzafh zzafh = zzcyy.get(zzafe.asBinder());
            if (zzafh != null) {
                return zzafh;
            }
            zzafh zzafh2 = new zzafh(zzafe);
            zzcyy.put(zzafe.asBinder(), zzafh2);
            return zzafh2;
        }
    }

    public final zzafe zzrn() {
        return this.zzcyz;
    }

    public final CharSequence getText(String str) {
        try {
            return this.zzcyz.zzcj(str);
        } catch (RemoteException e) {
            zzbad.zzc("", e);
            return null;
        }
    }

    public final NativeAd.Image getImage(String str) {
        try {
            zzaei zzck = this.zzcyz.zzck(str);
            if (zzck != null) {
                return new zzael(zzck);
            }
            return null;
        } catch (RemoteException e) {
            zzbad.zzc("", e);
            return null;
        }
    }

    public final VideoController getVideoController() {
        try {
            zzaar videoController = this.zzcyz.getVideoController();
            if (videoController != null) {
                this.zzcje.zza(videoController);
            }
        } catch (RemoteException e) {
            zzbad.zzc("Exception occurred while getting video controller", e);
        }
        return this.zzcje;
    }

    public final MediaView getVideoMediaView() {
        return this.zzcza;
    }

    public final List<String> getAvailableAssetNames() {
        try {
            return this.zzcyz.getAvailableAssetNames();
        } catch (RemoteException e) {
            zzbad.zzc("", e);
            return null;
        }
    }

    public final String getCustomTemplateId() {
        try {
            return this.zzcyz.getCustomTemplateId();
        } catch (RemoteException e) {
            zzbad.zzc("", e);
            return null;
        }
    }

    public final void performClick(String str) {
        try {
            this.zzcyz.performClick(str);
        } catch (RemoteException e) {
            zzbad.zzc("", e);
        }
    }

    public final void recordImpression() {
        try {
            this.zzcyz.recordImpression();
        } catch (RemoteException e) {
            zzbad.zzc("", e);
        }
    }

    public final void destroy() {
        try {
            this.zzcyz.destroy();
        } catch (RemoteException e) {
            zzbad.zzc("", e);
        }
    }
}
