package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.ObjectWrapper;

@zzard
public final class zzwo {
    @VisibleForTesting
    zzfx zzbzb;
    @VisibleForTesting
    boolean zzbzc;

    public final zzws zzg(byte[] bArr) {
        return new zzws(this, bArr);
    }

    public zzwo(Context context, String str, String str2) {
        zzacu.initialize(context);
        try {
            this.zzbzb = (zzfx) zzbae.zza(context, "com.google.android.gms.ads.clearcut.DynamiteClearcutLogger", zzwp.zzbzd);
            ObjectWrapper.wrap(context);
            this.zzbzb.zza(ObjectWrapper.wrap(context), str, (String) null);
            this.zzbzc = true;
        } catch (RemoteException | zzbag | NullPointerException unused) {
            zzbad.zzdp("Cannot dynamite load clearcut");
        }
    }

    public zzwo(Context context) {
        zzacu.initialize(context);
        if (((Boolean) zzyt.zzpe().zzd(zzacu.zzcul)).booleanValue()) {
            try {
                this.zzbzb = (zzfx) zzbae.zza(context, "com.google.android.gms.ads.clearcut.DynamiteClearcutLogger", zzwq.zzbzd);
                ObjectWrapper.wrap(context);
                this.zzbzb.zzb(ObjectWrapper.wrap(context), "GMA_SDK");
                this.zzbzc = true;
            } catch (RemoteException | zzbag | NullPointerException unused) {
                zzbad.zzdp("Cannot dynamite load clearcut");
            }
        }
    }

    public zzwo() {
    }
}
