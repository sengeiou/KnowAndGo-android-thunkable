package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.ads.formats.NativeAd;
import java.util.ArrayList;
import java.util.List;

@zzard
public final class zzaed extends NativeAd.AdChoicesInfo {
    private String zzbhy;
    private final List<NativeAd.Image> zzcyd = new ArrayList();
    private final zzaea zzcyo;

    public zzaed(zzaea zzaea) {
        zzaei zzaei;
        IBinder iBinder;
        this.zzcyo = zzaea;
        try {
            this.zzbhy = this.zzcyo.getText();
        } catch (RemoteException e) {
            zzbad.zzc("", e);
            this.zzbhy = "";
        }
        try {
            for (zzaei next : zzaea.zzra()) {
                if (!(next instanceof IBinder) || (iBinder = (IBinder) next) == null) {
                    zzaei = null;
                } else {
                    IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
                    zzaei = queryLocalInterface instanceof zzaei ? (zzaei) queryLocalInterface : new zzaek(iBinder);
                }
                if (zzaei != null) {
                    this.zzcyd.add(new zzael(zzaei));
                }
            }
        } catch (RemoteException e2) {
            zzbad.zzc("", e2);
        }
    }

    public final CharSequence getText() {
        return this.zzbhy;
    }

    public final List<NativeAd.Image> getImages() {
        return this.zzcyd;
    }
}
