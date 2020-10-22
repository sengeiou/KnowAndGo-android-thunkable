package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.overlay.zzo;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.HashMap;
import java.util.Map;

public final class zzbxa implements zzo, zzbsr {
    private final zzbai zzbtc;
    @Nullable
    private final zzbgz zzdbs;
    private final zzcxm zzfig;
    @Nullable
    @VisibleForTesting
    private IObjectWrapper zzfih;
    private final int zzflt;
    private final Context zzlj;

    public zzbxa(Context context, @Nullable zzbgz zzbgz, zzcxm zzcxm, zzbai zzbai, int i) {
        this.zzlj = context;
        this.zzdbs = zzbgz;
        this.zzfig = zzcxm;
        this.zzbtc = zzbai;
        this.zzflt = i;
    }

    public final void onPause() {
    }

    public final void onResume() {
    }

    public final void onAdLoaded() {
        if ((this.zzflt == 7 || this.zzflt == 3) && this.zzfig.zzdoh && this.zzdbs != null && zzk.zzlv().zzl(this.zzlj)) {
            int i = this.zzbtc.zzdzc;
            int i2 = this.zzbtc.zzdzd;
            StringBuilder sb = new StringBuilder(23);
            sb.append(i);
            sb.append(".");
            sb.append(i2);
            this.zzfih = zzk.zzlv().zza(sb.toString(), this.zzdbs.getWebView(), "", "javascript", this.zzfig.zzgko.optInt("media_type", -1) == 0 ? null : "javascript");
            if (this.zzfih != null && this.zzdbs.getView() != null) {
                zzk.zzlv().zza(this.zzfih, this.zzdbs.getView());
                this.zzdbs.zzam(this.zzfih);
                zzk.zzlv().zzaa(this.zzfih);
            }
        }
    }

    public final void zzsz() {
        this.zzfih = null;
    }

    public final void zzta() {
        if (this.zzfih != null && this.zzdbs != null) {
            this.zzdbs.zza("onSdkImpression", (Map<String, ?>) new HashMap());
        }
    }
}
