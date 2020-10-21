package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.widget.FrameLayout;
import com.google.android.gms.dynamic.ObjectWrapper;

final class zzyo extends zzys<zzaem> {
    private final /* synthetic */ Context val$context;
    private final /* synthetic */ zzyh zzchw;
    private final /* synthetic */ FrameLayout zzchx;
    private final /* synthetic */ FrameLayout zzchy;

    zzyo(zzyh zzyh, FrameLayout frameLayout, FrameLayout frameLayout2, Context context) {
        this.zzchw = zzyh;
        this.zzchx = frameLayout;
        this.zzchy = frameLayout2;
        this.val$context = context;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object zzov() {
        zzyh.zza(this.val$context, "native_ad_view_delegate");
        return new zzabt();
    }

    public final /* synthetic */ Object zzow() throws RemoteException {
        return this.zzchw.zzcho.zzb(this.val$context, this.zzchx, this.zzchy);
    }

    public final /* synthetic */ Object zza(zzzv zzzv) throws RemoteException {
        return zzzv.zzc(ObjectWrapper.wrap(this.zzchx), ObjectWrapper.wrap(this.zzchy));
    }
}
