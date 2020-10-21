package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.browser.customtabs.CustomTabsIntent;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzc;
import com.google.android.gms.ads.internal.overlay.zzu;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.common.util.PlatformVersion;

@zzard
public final class zzapl implements MediationInterstitialAdapter {
    private Uri uri;
    /* access modifiers changed from: private */
    public Activity zzdhn;
    /* access modifiers changed from: private */
    public MediationInterstitialListener zzdho;

    public final void requestInterstitialAd(Context context, MediationInterstitialListener mediationInterstitialListener, Bundle bundle, MediationAdRequest mediationAdRequest, Bundle bundle2) {
        this.zzdho = mediationInterstitialListener;
        if (this.zzdho == null) {
            zzbad.zzep("Listener not set for mediation. Returning.");
        } else if (!(context instanceof Activity)) {
            zzbad.zzep("AdMobCustomTabs can only work with Activity context. Bailing out.");
            this.zzdho.onAdFailedToLoad(this, 0);
        } else {
            if (!(PlatformVersion.isAtLeastIceCreamSandwichMR1() && zzads.zzj(context))) {
                zzbad.zzep("Default browser does not support custom tabs. Bailing out.");
                this.zzdho.onAdFailedToLoad(this, 0);
                return;
            }
            String string = bundle.getString("tab_url");
            if (TextUtils.isEmpty(string)) {
                zzbad.zzep("The tab_url retrieved from mediation metadata is empty. Bailing out.");
                this.zzdho.onAdFailedToLoad(this, 0);
                return;
            }
            this.zzdhn = (Activity) context;
            this.uri = Uri.parse(string);
            this.zzdho.onAdLoaded(this);
        }
    }

    public final void showInterstitial() {
        CustomTabsIntent build = new CustomTabsIntent.Builder().build();
        build.intent.setData(this.uri);
        zzaxi.zzdvv.post(new zzapn(this, new AdOverlayInfoParcel(new zzc(build.intent), (zzxr) null, new zzapm(this), (zzu) null, new zzbai(0, 0, false))));
        zzk.zzlk().zzuy();
    }

    public final void onDestroy() {
        zzbad.zzdp("Destroying AdMobCustomTabsAdapter adapter.");
    }

    public final void onPause() {
        zzbad.zzdp("Pausing AdMobCustomTabsAdapter adapter.");
    }

    public final void onResume() {
        zzbad.zzdp("Resuming AdMobCustomTabsAdapter adapter.");
    }
}
