package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;

public final class zzcuw implements zzcva<zzcuv> {
    private final zzbai zzbtc;
    private final zzbbl zzfqw;
    private final Context zzlj;

    public zzcuw(zzbbl zzbbl, Context context, zzbai zzbai) {
        this.zzfqw = zzbbl;
        this.zzlj = context;
        this.zzbtc = zzbai;
    }

    public final zzbbh<zzcuv> zzalm() {
        return this.zzfqw.zza(new zzcux(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzcuv zzaly() throws Exception {
        boolean isCallerInstantApp = Wrappers.packageManager(this.zzlj).isCallerInstantApp();
        zzk.zzlg();
        boolean zzau = zzaxi.zzau(this.zzlj);
        String str = this.zzbtc.zzbsx;
        zzk.zzli();
        boolean zzwh = zzaxo.zzwh();
        zzk.zzlg();
        return new zzcuv(isCallerInstantApp, zzau, str, zzwh, zzaxi.zzar(this.zzlj), DynamiteModule.getRemoteVersion(this.zzlj, ModuleDescriptor.MODULE_ID));
    }
}
