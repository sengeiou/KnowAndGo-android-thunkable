package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.HashMap;

final class zzyp extends zzys<zzaer> {
    private final /* synthetic */ zzyh zzchw;
    private final /* synthetic */ View zzchz;
    private final /* synthetic */ HashMap zzcia;
    private final /* synthetic */ HashMap zzcib;

    zzyp(zzyh zzyh, View view, HashMap hashMap, HashMap hashMap2) {
        this.zzchw = zzyh;
        this.zzchz = view;
        this.zzcia = hashMap;
        this.zzcib = hashMap2;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object zzov() {
        zzyh.zza(this.zzchz.getContext(), "native_ad_view_holder_delegate");
        return new zzabu();
    }

    public final /* synthetic */ Object zzow() throws RemoteException {
        return this.zzchw.zzchs.zzb(this.zzchz, this.zzcia, this.zzcib);
    }

    public final /* synthetic */ Object zza(zzzv zzzv) throws RemoteException {
        return zzzv.zza(ObjectWrapper.wrap(this.zzchz), ObjectWrapper.wrap(this.zzcia), ObjectWrapper.wrap(this.zzcib));
    }
}
