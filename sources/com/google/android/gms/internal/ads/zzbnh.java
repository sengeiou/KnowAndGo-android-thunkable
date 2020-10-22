package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.concurrent.Executor;

final class zzbnh extends zzbnf {
    private final View view;
    @Nullable
    private final zzbgz zzdbs;
    private final Executor zzffv;
    private final zzcxn zzfgx;
    private final zzbpb zzfgy;
    private final zzbzc zzfgz;
    private final zzbvd zzfha;
    private final zzdte<zzcpm> zzfhb;
    private final Context zzlj;

    zzbnh(Context context, zzcxn zzcxn, View view2, @Nullable zzbgz zzbgz, zzbpb zzbpb, zzbzc zzbzc, zzbvd zzbvd, zzdte<zzcpm> zzdte, Executor executor) {
        this.zzlj = context;
        this.view = view2;
        this.zzdbs = zzbgz;
        this.zzfgx = zzcxn;
        this.zzfgy = zzbpb;
        this.zzfgz = zzbzc;
        this.zzfha = zzbvd;
        this.zzfhb = zzdte;
        this.zzffv = executor;
    }

    public final View zzafi() {
        return this.view;
    }

    public final void zza(ViewGroup viewGroup, zzyd zzyd) {
        if (viewGroup != null && this.zzdbs != null) {
            this.zzdbs.zza(zzbin.zzb(zzyd));
            viewGroup.setMinimumHeight(zzyd.heightPixels);
            viewGroup.setMinimumWidth(zzyd.widthPixels);
        }
    }

    public final zzaar getVideoController() {
        try {
            return this.zzfgy.getVideoController();
        } catch (RemoteException unused) {
            return null;
        }
    }

    public final zzcxn zzafj() {
        return this.zzfig.zzgkd.get(0);
    }

    public final int zzafk() {
        return this.zzffa.zzgky.zzgku.zzgkr;
    }

    public final void zzpm() {
        this.zzfha.zzagx();
    }

    public final void zzafl() {
        this.zzffv.execute(new zzbni(this));
        super.zzafl();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzafm() {
        if (this.zzfgz.zzail() != null) {
            try {
                this.zzfgz.zzail().zza(this.zzfhb.get(), ObjectWrapper.wrap(this.zzlj));
            } catch (RemoteException e) {
                zzawz.zzc("RemoteException when notifyAdLoad is called", e);
            }
        }
    }
}
