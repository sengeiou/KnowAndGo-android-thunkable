package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.ViewGroup;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;

@zzard
public final class zzbcw {
    private final Context zzcko;
    private final zzbdf zzebt;
    private final ViewGroup zzecp;
    private zzbcq zzecq;

    public zzbcw(Context context, ViewGroup viewGroup, zzbgz zzbgz) {
        this(context, viewGroup, zzbgz, (zzbcq) null);
    }

    @VisibleForTesting
    private zzbcw(Context context, ViewGroup viewGroup, zzbdf zzbdf, zzbcq zzbcq) {
        this.zzcko = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        this.zzecp = viewGroup;
        this.zzebt = zzbdf;
        this.zzecq = null;
    }

    public final void zze(int i, int i2, int i3, int i4) {
        Preconditions.checkMainThread("The underlay may only be modified from the UI thread.");
        if (this.zzecq != null) {
            this.zzecq.zzd(i, i2, i3, i4);
        }
    }

    public final void zza(int i, int i2, int i3, int i4, int i5, boolean z, zzbde zzbde) {
        if (this.zzecq == null) {
            zzadb.zza(this.zzebt.zzyg().zzqw(), this.zzebt.zzyc(), "vpr2");
            this.zzecq = new zzbcq(this.zzcko, this.zzebt, i5, z, this.zzebt.zzyg().zzqw(), zzbde);
            this.zzecp.addView(this.zzecq, 0, new ViewGroup.LayoutParams(-1, -1));
            int i6 = i;
            int i7 = i2;
            int i8 = i3;
            int i9 = i4;
            this.zzecq.zzd(i, i2, i3, i4);
            this.zzebt.zzao(false);
        }
    }

    public final zzbcq zzxw() {
        Preconditions.checkMainThread("getAdVideoUnderlay must be called from the UI thread.");
        return this.zzecq;
    }

    public final void onPause() {
        Preconditions.checkMainThread("onPause must be called from the UI thread.");
        if (this.zzecq != null) {
            this.zzecq.pause();
        }
    }

    public final void onDestroy() {
        Preconditions.checkMainThread("onDestroy must be called from the UI thread.");
        if (this.zzecq != null) {
            this.zzecq.destroy();
            this.zzecp.removeView(this.zzecq);
            this.zzecq = null;
        }
    }
}
