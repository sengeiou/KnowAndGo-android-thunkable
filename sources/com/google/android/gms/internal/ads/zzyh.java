package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import java.util.HashMap;

@zzard
public class zzyh {
    /* access modifiers changed from: private */
    public final zzxx zzchl;
    /* access modifiers changed from: private */
    public final zzxw zzchm;
    /* access modifiers changed from: private */
    public final zzabk zzchn;
    /* access modifiers changed from: private */
    public final zzagk zzcho;
    /* access modifiers changed from: private */
    public final zzatf zzchp;
    private final zzauj zzchq;
    /* access modifiers changed from: private */
    public final zzaqf zzchr;
    /* access modifiers changed from: private */
    public final zzagl zzchs;

    public zzyh(zzxx zzxx, zzxw zzxw, zzabk zzabk, zzagk zzagk, zzatf zzatf, zzauj zzauj, zzaqf zzaqf, zzagl zzagl) {
        this.zzchl = zzxx;
        this.zzchm = zzxw;
        this.zzchn = zzabk;
        this.zzcho = zzagk;
        this.zzchp = zzatf;
        this.zzchq = zzauj;
        this.zzchr = zzaqf;
        this.zzchs = zzagl;
    }

    /* access modifiers changed from: private */
    public static void zza(Context context, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("action", "no_ads_fallback");
        bundle.putString("flow", str);
        zzyt.zzpa().zza(context, zzyt.zzpg().zzbsx, "gmob-apps", bundle, true);
    }

    public final zzzf zzb(Context context, String str, zzamp zzamp) {
        return (zzzf) new zzym(this, context, str, zzamp).zzd(context, false);
    }

    public final zzaem zza(Context context, FrameLayout frameLayout, FrameLayout frameLayout2) {
        return (zzaem) new zzyo(this, frameLayout, frameLayout2, context).zzd(context, false);
    }

    public final zzaer zza(View view, HashMap<String, View> hashMap, HashMap<String, View> hashMap2) {
        return (zzaer) new zzyp(this, view, hashMap, hashMap2).zzd(view.getContext(), false);
    }

    public final zzatt zzc(Context context, String str, zzamp zzamp) {
        return (zzatt) new zzyr(this, context, str, zzamp).zzd(context, false);
    }

    @Nullable
    public final zzaqg zzb(Activity activity) {
        zzyj zzyj = new zzyj(this, activity);
        Intent intent = activity.getIntent();
        boolean z = false;
        if (!intent.hasExtra("com.google.android.gms.ads.internal.overlay.useClientJar")) {
            zzbad.zzen("useClientJar flag not found in activity intent extras.");
        } else {
            z = intent.getBooleanExtra("com.google.android.gms.ads.internal.overlay.useClientJar", false);
        }
        return (zzaqg) zzyj.zzd(activity, z);
    }
}
