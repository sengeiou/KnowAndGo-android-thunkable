package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import com.google.android.gms.internal.ads.zzbhx;
import com.google.android.gms.internal.ads.zzbif;
import com.google.android.gms.internal.ads.zzbih;

@TargetApi(17)
@zzard
public final class zzbht<WebViewT extends zzbhx & zzbif & zzbih> {
    private final zzbhw zzemd;
    private final WebViewT zzeme;

    public static zzbht<zzbgz> zzc(zzbgz zzbgz) {
        return new zzbht<>(zzbgz, new zzbhu(zzbgz));
    }

    private zzbht(WebViewT webviewt, zzbhw zzbhw) {
        this.zzemd = zzbhw;
        this.zzeme = webviewt;
    }

    @JavascriptInterface
    public final void notify(String str) {
        if (TextUtils.isEmpty(str)) {
            zzawz.zzep("URL is empty, ignoring message");
        } else {
            zzaxi.zzdvv.post(new zzbhv(this, str));
        }
    }

    @JavascriptInterface
    public final String getClickSignals(String str) {
        if (TextUtils.isEmpty(str)) {
            zzawz.zzds("Click string is empty, not proceeding.");
            return "";
        }
        zzdh zzaal = ((zzbif) this.zzeme).zzaal();
        if (zzaal == null) {
            zzawz.zzds("Signal utils is empty, ignoring.");
            return "";
        }
        zzdc zzcg = zzaal.zzcg();
        if (zzcg == null) {
            zzawz.zzds("Signals object is empty, ignoring.");
            return "";
        } else if (this.zzeme.getContext() != null) {
            return zzcg.zza(this.zzeme.getContext(), str, ((zzbih) this.zzeme).getView(), this.zzeme.zzyd());
        } else {
            zzawz.zzds("Context is null, ignoring.");
            return "";
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzff(String str) {
        this.zzemd.zzh(Uri.parse(str));
    }
}
