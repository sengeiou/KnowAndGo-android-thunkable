package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.browser.customtabs.CustomTabsIntent;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzc;
import com.google.android.gms.ads.internal.overlay.zzu;
import com.google.android.gms.common.util.PlatformVersion;
import java.util.concurrent.Executor;

public final class zzckr implements zzcjv<zzbvx> {
    private final zzcxk zzfex;
    private final Executor zzffv;
    private final zzbws zzfzy;
    private final Context zzlj;

    public zzckr(Context context, Executor executor, zzbws zzbws, zzcxk zzcxk) {
        this.zzlj = context;
        this.zzfzy = zzbws;
        this.zzffv = executor;
        this.zzfex = zzcxk;
    }

    public final boolean zza(zzcxu zzcxu, zzcxm zzcxm) {
        return (this.zzlj instanceof Activity) && PlatformVersion.isAtLeastIceCreamSandwichMR1() && zzads.zzj(this.zzlj) && !TextUtils.isEmpty(zzc(zzcxm));
    }

    public final zzbbh<zzbvx> zzb(zzcxu zzcxu, zzcxm zzcxm) {
        String zzc = zzc(zzcxm);
        return zzbar.zza(zzbar.zzm(null), new zzcks(this, zzc != null ? Uri.parse(zzc) : null, zzcxu, zzcxm), this.zzffv);
    }

    private static String zzc(zzcxm zzcxm) {
        try {
            return zzcxm.zzgkh.getString("tab_url");
        } catch (Exception unused) {
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzbbh zza(Uri uri, zzcxu zzcxu, zzcxm zzcxm, Object obj) throws Exception {
        try {
            CustomTabsIntent build = new CustomTabsIntent.Builder().build();
            build.intent.setData(uri);
            zzc zzc = new zzc(build.intent);
            zzbbr zzbbr = new zzbbr();
            zzbvy zza = this.zzfzy.zza(new zzbpr(zzcxu, zzcxm, (String) null), new zzbvz(new zzckt(zzbbr)));
            zzbbr.set(new AdOverlayInfoParcel(zzc, (zzxr) null, zza.zzaef(), (zzu) null, new zzbai(0, 0, false)));
            this.zzfex.zzuy();
            return zzbar.zzm(zza.zzaee());
        } catch (Throwable th) {
            zzawz.zzc("Error in CustomTabsAdRenderer", th);
            throw th;
        }
    }
}
