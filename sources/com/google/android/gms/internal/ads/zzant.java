package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.ads.AdSize;
import com.google.ads.mediation.MediationAdapter;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.zzb;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

@zzard
public final class zzant<NETWORK_EXTRAS extends NetworkExtras, SERVER_PARAMETERS extends MediationServerParameters> extends zzamt {
    private final MediationAdapter<NETWORK_EXTRAS, SERVER_PARAMETERS> zzdgv;
    private final NETWORK_EXTRAS zzdgw;

    public zzant(MediationAdapter<NETWORK_EXTRAS, SERVER_PARAMETERS> mediationAdapter, NETWORK_EXTRAS network_extras) {
        this.zzdgv = mediationAdapter;
        this.zzdgw = network_extras;
    }

    public final zzaar getVideoController() {
        return null;
    }

    public final boolean isInitialized() {
        return true;
    }

    public final void setImmersiveMode(boolean z) {
    }

    public final void showVideo() {
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzaiq zzaiq, List<zzaiw> list) throws RemoteException {
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzatk zzatk, List<String> list) {
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzxz zzxz, String str, zzatk zzatk, String str2) throws RemoteException {
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzxz zzxz, String str, String str2, zzamv zzamv, zzady zzady, List<String> list) {
    }

    public final void zza(zzxz zzxz, String str) {
    }

    public final void zza(zzxz zzxz, String str, String str2) {
    }

    public final void zzb(IObjectWrapper iObjectWrapper, zzxz zzxz, String str, zzamv zzamv) throws RemoteException {
    }

    public final void zzr(IObjectWrapper iObjectWrapper) throws RemoteException {
    }

    public final void zzs(IObjectWrapper iObjectWrapper) throws RemoteException {
    }

    public final zzana zzsf() {
        return null;
    }

    public final zzand zzsg() {
        return null;
    }

    public final boolean zzsj() {
        return false;
    }

    public final zzafe zzsk() {
        return null;
    }

    public final zzang zzsl() {
        return null;
    }

    public final IObjectWrapper zzse() throws RemoteException {
        if (!(this.zzdgv instanceof MediationBannerAdapter)) {
            String valueOf = String.valueOf(this.zzdgv.getClass().getCanonicalName());
            zzbad.zzep(valueOf.length() != 0 ? "Not a MediationBannerAdapter: ".concat(valueOf) : new String("Not a MediationBannerAdapter: "));
            throw new RemoteException();
        }
        try {
            return ObjectWrapper.wrap(((MediationBannerAdapter) this.zzdgv).getBannerView());
        } catch (Throwable th) {
            zzbad.zzc("", th);
            throw new RemoteException();
        }
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzyd zzyd, zzxz zzxz, String str, zzamv zzamv) throws RemoteException {
        zza(iObjectWrapper, zzyd, zzxz, str, (String) null, zzamv);
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzyd zzyd, zzxz zzxz, String str, String str2, zzamv zzamv) throws RemoteException {
        AdSize adSize;
        if (!(this.zzdgv instanceof MediationBannerAdapter)) {
            String valueOf = String.valueOf(this.zzdgv.getClass().getCanonicalName());
            zzbad.zzep(valueOf.length() != 0 ? "Not a MediationBannerAdapter: ".concat(valueOf) : new String("Not a MediationBannerAdapter: "));
            throw new RemoteException();
        }
        zzbad.zzdp("Requesting banner ad from adapter.");
        try {
            MediationBannerAdapter mediationBannerAdapter = (MediationBannerAdapter) this.zzdgv;
            zzanu zzanu = new zzanu(zzamv);
            Activity activity = (Activity) ObjectWrapper.unwrap(iObjectWrapper);
            MediationServerParameters zzda = zzda(str);
            int i = 0;
            AdSize[] adSizeArr = {AdSize.SMART_BANNER, AdSize.BANNER, AdSize.IAB_MRECT, AdSize.IAB_BANNER, AdSize.IAB_LEADERBOARD, AdSize.IAB_WIDE_SKYSCRAPER};
            while (true) {
                if (i < 6) {
                    if (adSizeArr[i].getWidth() == zzyd.width && adSizeArr[i].getHeight() == zzyd.height) {
                        adSize = adSizeArr[i];
                        break;
                    }
                    i++;
                } else {
                    adSize = new AdSize(zzb.zza(zzyd.width, zzyd.height, zzyd.zzaap));
                    break;
                }
            }
            mediationBannerAdapter.requestBannerAd(zzanu, activity, zzda, adSize, zzaog.zza(zzxz, zzc(zzxz)), this.zzdgw);
        } catch (Throwable th) {
            zzbad.zzc("", th);
            throw new RemoteException();
        }
    }

    public final Bundle zzsh() {
        return new Bundle();
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzxz zzxz, String str, zzamv zzamv) throws RemoteException {
        zza(iObjectWrapper, zzxz, str, (String) null, zzamv);
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzxz zzxz, String str, String str2, zzamv zzamv) throws RemoteException {
        if (!(this.zzdgv instanceof MediationInterstitialAdapter)) {
            String valueOf = String.valueOf(this.zzdgv.getClass().getCanonicalName());
            zzbad.zzep(valueOf.length() != 0 ? "Not a MediationInterstitialAdapter: ".concat(valueOf) : new String("Not a MediationInterstitialAdapter: "));
            throw new RemoteException();
        }
        zzbad.zzdp("Requesting interstitial ad from adapter.");
        try {
            ((MediationInterstitialAdapter) this.zzdgv).requestInterstitialAd(new zzanu(zzamv), (Activity) ObjectWrapper.unwrap(iObjectWrapper), zzda(str), zzaog.zza(zzxz, zzc(zzxz)), this.zzdgw);
        } catch (Throwable th) {
            zzbad.zzc("", th);
            throw new RemoteException();
        }
    }

    public final Bundle getInterstitialAdapterInfo() {
        return new Bundle();
    }

    public final void showInterstitial() throws RemoteException {
        if (!(this.zzdgv instanceof MediationInterstitialAdapter)) {
            String valueOf = String.valueOf(this.zzdgv.getClass().getCanonicalName());
            zzbad.zzep(valueOf.length() != 0 ? "Not a MediationInterstitialAdapter: ".concat(valueOf) : new String("Not a MediationInterstitialAdapter: "));
            throw new RemoteException();
        }
        zzbad.zzdp("Showing interstitial from adapter.");
        try {
            ((MediationInterstitialAdapter) this.zzdgv).showInterstitial();
        } catch (Throwable th) {
            zzbad.zzc("", th);
            throw new RemoteException();
        }
    }

    public final Bundle zzsi() {
        return new Bundle();
    }

    public final void destroy() throws RemoteException {
        try {
            this.zzdgv.destroy();
        } catch (Throwable th) {
            zzbad.zzc("", th);
            throw new RemoteException();
        }
    }

    public final void pause() throws RemoteException {
        throw new RemoteException();
    }

    public final void resume() throws RemoteException {
        throw new RemoteException();
    }

    private final SERVER_PARAMETERS zzda(String str) throws RemoteException {
        HashMap hashMap;
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                hashMap = new HashMap(jSONObject.length());
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    hashMap.put(next, jSONObject.getString(next));
                }
            } catch (Throwable th) {
                zzbad.zzc("", th);
                throw new RemoteException();
            }
        } else {
            hashMap = new HashMap(0);
        }
        Class<SERVER_PARAMETERS> serverParametersType = this.zzdgv.getServerParametersType();
        if (serverParametersType == null) {
            return null;
        }
        SERVER_PARAMETERS server_parameters = (MediationServerParameters) serverParametersType.newInstance();
        server_parameters.load(hashMap);
        return server_parameters;
    }

    private static boolean zzc(zzxz zzxz) {
        if (zzxz.zzcgq) {
            return true;
        }
        zzyt.zzpa();
        return zzazt.zzwx();
    }
}
