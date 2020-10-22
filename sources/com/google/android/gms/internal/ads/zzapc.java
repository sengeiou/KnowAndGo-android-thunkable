package com.google.android.gms.internal.ads;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.mediation.MediationBannerAdConfiguration;
import com.google.android.gms.ads.mediation.MediationConfiguration;
import com.google.android.gms.ads.mediation.MediationInterstitialAd;
import com.google.android.gms.ads.mediation.MediationInterstitialAdConfiguration;
import com.google.android.gms.ads.mediation.MediationNativeAdConfiguration;
import com.google.android.gms.ads.mediation.MediationRewardedAd;
import com.google.android.gms.ads.mediation.MediationRewardedAdConfiguration;
import com.google.android.gms.ads.mediation.rtb.RtbAdapter;
import com.google.android.gms.ads.mediation.rtb.RtbSignalData;
import com.google.android.gms.ads.mediation.zza;
import com.google.android.gms.ads.zzb;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Iterator;
import javax.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzapc extends zzaow {
    /* access modifiers changed from: private */
    public MediationRewardedAd zzdgg;
    private final RtbAdapter zzdhc;
    /* access modifiers changed from: private */
    public MediationInterstitialAd zzdhd;

    public zzapc(RtbAdapter rtbAdapter) {
        this.zzdhc = rtbAdapter;
    }

    public final void zza(String[] strArr, Bundle[] bundleArr) {
    }

    public final void zzx(IObjectWrapper iObjectWrapper) {
    }

    public final void zza(String str, String str2, zzxz zzxz, IObjectWrapper iObjectWrapper, zzaoj zzaoj, zzamv zzamv, zzyd zzyd) throws RemoteException {
        zzxz zzxz2 = zzxz;
        zzyd zzyd2 = zzyd;
        try {
            zzapd zzapd = new zzapd(this, zzaoj, zzamv);
            RtbAdapter rtbAdapter = this.zzdhc;
            Bundle zzde = zzde(str2);
            Bundle zzd = zzd(zzxz2);
            boolean zzc = zzc(zzxz);
            Location location = zzxz2.zzmw;
            int i = zzxz2.zzcgr;
            int i2 = zzxz2.zzchc;
            String zza = zza(str2, zzxz);
            AdSize zza2 = zzb.zza(zzyd2.width, zzyd2.height, zzyd2.zzaap);
            MediationBannerAdConfiguration mediationBannerAdConfiguration = r5;
            MediationBannerAdConfiguration mediationBannerAdConfiguration2 = new MediationBannerAdConfiguration((Context) ObjectWrapper.unwrap(iObjectWrapper), str, zzde, zzd, zzc, location, i, i2, zza, zza2);
            rtbAdapter.loadBannerAd(mediationBannerAdConfiguration, zzapd);
        } catch (Throwable th) {
            zzbad.zzc("Adapter failed to render banner ad.", th);
            throw new RemoteException();
        }
    }

    public final void zza(String str, String str2, zzxz zzxz, IObjectWrapper iObjectWrapper, zzaom zzaom, zzamv zzamv) throws RemoteException {
        zzxz zzxz2 = zzxz;
        try {
            this.zzdhc.loadInterstitialAd(new MediationInterstitialAdConfiguration((Context) ObjectWrapper.unwrap(iObjectWrapper), str, zzde(str2), zzd(zzxz2), zzc(zzxz), zzxz2.zzmw, zzxz2.zzcgr, zzxz2.zzchc, zza(str2, zzxz)), new zzape(this, zzaom, zzamv));
        } catch (Throwable th) {
            zzbad.zzc("Adapter failed to render interstitial ad.", th);
            throw new RemoteException();
        }
    }

    public final void zza(String str, String str2, zzxz zzxz, IObjectWrapper iObjectWrapper, zzaos zzaos, zzamv zzamv) throws RemoteException {
        zzxz zzxz2 = zzxz;
        try {
            this.zzdhc.loadRewardedAd(new MediationRewardedAdConfiguration((Context) ObjectWrapper.unwrap(iObjectWrapper), str, zzde(str2), zzd(zzxz2), zzc(zzxz), zzxz2.zzmw, zzxz2.zzcgr, zzxz2.zzchc, zza(str2, zzxz)), new zzapf(this, zzaos, zzamv));
        } catch (Throwable th) {
            zzbad.zzc("Adapter failed to render rewarded ad.", th);
            throw new RemoteException();
        }
    }

    public final void zza(String str, String str2, zzxz zzxz, IObjectWrapper iObjectWrapper, zzaop zzaop, zzamv zzamv) throws RemoteException {
        zzxz zzxz2 = zzxz;
        try {
            this.zzdhc.loadNativeAd(new MediationNativeAdConfiguration((Context) ObjectWrapper.unwrap(iObjectWrapper), str, zzde(str2), zzd(zzxz2), zzc(zzxz), zzxz2.zzmw, zzxz2.zzcgr, zzxz2.zzchc, zza(str2, zzxz)), new zzapg(this, zzaop, zzamv));
        } catch (Throwable th) {
            zzbad.zzc("Adapter failed to render rewarded ad.", th);
            throw new RemoteException();
        }
    }

    public final boolean zzy(IObjectWrapper iObjectWrapper) throws RemoteException {
        if (this.zzdhd == null) {
            return false;
        }
        try {
            this.zzdhd.showAd((Context) ObjectWrapper.unwrap(iObjectWrapper));
            return true;
        } catch (Throwable th) {
            zzbad.zzc("", th);
            return true;
        }
    }

    public final boolean zzz(IObjectWrapper iObjectWrapper) throws RemoteException {
        if (this.zzdgg == null) {
            return false;
        }
        try {
            this.zzdgg.showAd((Context) ObjectWrapper.unwrap(iObjectWrapper));
            return true;
        } catch (Throwable th) {
            zzbad.zzc("", th);
            return true;
        }
    }

    public final zzaar getVideoController() {
        if (!(this.zzdhc instanceof zza)) {
            return null;
        }
        try {
            return ((zza) this.zzdhc).getVideoController();
        } catch (Throwable th) {
            zzbad.zzc("", th);
            return null;
        }
    }

    public final void zza(IObjectWrapper iObjectWrapper, String str, Bundle bundle, Bundle bundle2, zzyd zzyd, zzaoy zzaoy) throws RemoteException {
        AdFormat adFormat;
        try {
            zzaph zzaph = new zzaph(this, zzaoy);
            RtbAdapter rtbAdapter = this.zzdhc;
            char c = 65535;
            int hashCode = str.hashCode();
            if (hashCode != -1396342996) {
                if (hashCode != -1052618729) {
                    if (hashCode != -239580146) {
                        if (hashCode == 604727084) {
                            if (str.equals("interstitial")) {
                                c = 1;
                            }
                        }
                    } else if (str.equals("rewarded")) {
                        c = 2;
                    }
                } else if (str.equals("native")) {
                    c = 3;
                }
            } else if (str.equals("banner")) {
                c = 0;
            }
            switch (c) {
                case 0:
                    adFormat = AdFormat.BANNER;
                    break;
                case 1:
                    adFormat = AdFormat.INTERSTITIAL;
                    break;
                case 2:
                    adFormat = AdFormat.REWARDED;
                    break;
                case 3:
                    adFormat = AdFormat.NATIVE;
                    break;
                default:
                    throw new IllegalArgumentException("Internal Error");
            }
            rtbAdapter.collectSignals(new RtbSignalData((Context) ObjectWrapper.unwrap(iObjectWrapper), new MediationConfiguration(adFormat, bundle2), bundle, zzb.zza(zzyd.width, zzyd.height, zzyd.zzaap)), zzaph);
        } catch (Throwable th) {
            zzbad.zzc("Error generating signals for RTB", th);
            throw new RemoteException();
        }
    }

    public final zzapj zzsx() throws RemoteException {
        return zzapj.zza(this.zzdhc.getVersionInfo());
    }

    public final zzapj zzsy() throws RemoteException {
        return zzapj.zza(this.zzdhc.getSDKVersionInfo());
    }

    private static Bundle zzde(String str) throws RemoteException {
        String valueOf = String.valueOf(str);
        zzbad.zzep(valueOf.length() != 0 ? "Server parameters: ".concat(valueOf) : new String("Server parameters: "));
        try {
            Bundle bundle = new Bundle();
            if (str == null) {
                return bundle;
            }
            JSONObject jSONObject = new JSONObject(str);
            Bundle bundle2 = new Bundle();
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                bundle2.putString(next, jSONObject.getString(next));
            }
            return bundle2;
        } catch (JSONException e) {
            zzbad.zzc("", e);
            throw new RemoteException();
        }
    }

    private static boolean zzc(zzxz zzxz) {
        if (zzxz.zzcgq) {
            return true;
        }
        zzyt.zzpa();
        return zzazt.zzwx();
    }

    @Nullable
    private static String zza(String str, zzxz zzxz) {
        try {
            return new JSONObject(str).getString("max_ad_content_rating");
        } catch (JSONException unused) {
            return zzxz.zzchd;
        }
    }

    private final Bundle zzd(zzxz zzxz) {
        Bundle bundle;
        if (zzxz.zzcgv == null || (bundle = zzxz.zzcgv.getBundle(this.zzdhc.getClass().getName())) == null) {
            return new Bundle();
        }
        return bundle;
    }
}
