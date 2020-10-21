package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.internal.zzk;
import java.util.Collections;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;

public final class zzcfz implements AppEventListener, zzbrl, zzbro, zzbrw, zzbrx, zzbsr, zzbtk, zzczz, zzxr {
    private long startTime;
    private final List<Object> zzdyx;
    private final zzcfn zzfuy;

    public zzcfz(zzcfn zzcfn, zzbjm zzbjm) {
        this.zzfuy = zzcfn;
        this.zzdyx = Collections.singletonList(zzbjm);
    }

    public final void zza(zzcxu zzcxu) {
    }

    public final void zzbp(Context context) {
        zza(zzbrx.class, "onPause", context);
    }

    public final void zzbq(Context context) {
        zza(zzbrx.class, "onResume", context);
    }

    public final void zzbr(Context context) {
        zza(zzbrx.class, "onDestroy", context);
    }

    public final void onAppEvent(String str, String str2) {
        zza(AppEventListener.class, "onAppEvent", str, str2);
    }

    public final void onAdLoaded() {
        long elapsedRealtime = zzk.zzln().elapsedRealtime() - this.startTime;
        StringBuilder sb = new StringBuilder(41);
        sb.append("Ad Request Latency : ");
        sb.append(elapsedRealtime);
        zzawz.zzds(sb.toString());
        zza(zzbsr.class, "onAdLoaded", new Object[0]);
    }

    public final void onAdFailedToLoad(int i) {
        zza(zzbro.class, "onAdFailedToLoad", Integer.valueOf(i));
    }

    public final void onAdOpened() {
        zza(zzbrl.class, "onAdOpened", new Object[0]);
    }

    public final void onAdClosed() {
        zza(zzbrl.class, "onAdClosed", new Object[0]);
    }

    public final void onAdLeftApplication() {
        zza(zzbrl.class, "onAdLeftApplication", new Object[0]);
    }

    public final void onAdClicked() {
        zza(zzxr.class, "onAdClicked", new Object[0]);
    }

    public final void onAdImpression() {
        zza(zzbrw.class, "onAdImpression", new Object[0]);
    }

    public final void onRewardedVideoStarted() {
        zza(zzbrl.class, "onRewardedVideoStarted", new Object[0]);
    }

    @ParametersAreNonnullByDefault
    public final void zzb(zzasr zzasr, String str, String str2) {
        zza(zzbrl.class, "onRewarded", zzasr, str, str2);
    }

    public final void onRewardedVideoCompleted() {
        zza(zzbrl.class, "onRewardedVideoCompleted", new Object[0]);
    }

    public final void zza(zzczs zzczs, String str) {
        zza(zzczr.class, "onTaskCreated", str);
    }

    public final void zzb(zzczs zzczs, String str) {
        zza(zzczr.class, "onTaskStarted", str);
    }

    public final void zza(zzczs zzczs, String str, Throwable th) {
        zza(zzczr.class, "onTaskFailed", str, th.getClass().getSimpleName());
    }

    public final void zzc(zzczs zzczs, String str) {
        zza(zzczr.class, "onTaskSucceeded", str);
    }

    private final void zza(Class cls, String str, Object... objArr) {
        zzcfn zzcfn = this.zzfuy;
        List<Object> list = this.zzdyx;
        String valueOf = String.valueOf(cls.getSimpleName());
        zzcfn.zza(list, valueOf.length() != 0 ? "Event-".concat(valueOf) : new String("Event-"), str, objArr);
    }

    public final void zzb(zzarx zzarx) {
        this.startTime = zzk.zzln().elapsedRealtime();
        zza(zzbtk.class, "onAdRequest", new Object[0]);
    }
}
