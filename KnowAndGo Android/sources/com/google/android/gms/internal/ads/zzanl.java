package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import com.google.android.gms.ads.mediation.Adapter;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationConfiguration;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.MediationRewardedAd;
import com.google.android.gms.ads.mediation.MediationRewardedAdConfiguration;
import com.google.android.gms.ads.mediation.NativeAdMapper;
import com.google.android.gms.ads.mediation.NativeAppInstallAdMapper;
import com.google.android.gms.ads.mediation.NativeContentAdMapper;
import com.google.android.gms.ads.mediation.OnContextChangedListener;
import com.google.android.gms.ads.mediation.OnImmersiveModeUpdatedListener;
import com.google.android.gms.ads.mediation.UnifiedNativeAdMapper;
import com.google.android.gms.ads.mediation.zza;
import com.google.android.gms.ads.reward.mediation.InitializableMediationRewardedVideoAdAdapter;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter;
import com.google.android.gms.ads.zzb;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

@zzard
public final class zzanl extends zzamt {
    private final Object zzdgc;
    private zzano zzdgd;
    private zzatk zzdge;
    private IObjectWrapper zzdgf;
    /* access modifiers changed from: private */
    public MediationRewardedAd zzdgg;

    public zzanl(@NonNull MediationAdapter mediationAdapter) {
        this.zzdgc = mediationAdapter;
    }

    public zzanl(@NonNull Adapter adapter) {
        this.zzdgc = adapter;
    }

    public final IObjectWrapper zzse() throws RemoteException {
        if (this.zzdgc instanceof MediationBannerAdapter) {
            try {
                return ObjectWrapper.wrap(((MediationBannerAdapter) this.zzdgc).getBannerView());
            } catch (Throwable th) {
                zzbad.zzc("", th);
                throw new RemoteException();
            }
        } else {
            String canonicalName = MediationBannerAdapter.class.getCanonicalName();
            String canonicalName2 = this.zzdgc.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
            sb.append(canonicalName);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName2);
            zzbad.zzep(sb.toString());
            throw new RemoteException();
        }
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzyd zzyd, zzxz zzxz, String str, zzamv zzamv) throws RemoteException {
        zza(iObjectWrapper, zzyd, zzxz, str, (String) null, zzamv);
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzyd zzyd, zzxz zzxz, String str, String str2, zzamv zzamv) throws RemoteException {
        Date date;
        zzyd zzyd2 = zzyd;
        zzxz zzxz2 = zzxz;
        String str3 = str;
        if (this.zzdgc instanceof MediationBannerAdapter) {
            zzbad.zzdp("Requesting banner ad from adapter.");
            try {
                MediationBannerAdapter mediationBannerAdapter = (MediationBannerAdapter) this.zzdgc;
                Bundle bundle = null;
                HashSet hashSet = zzxz2.zzcgp != null ? new HashSet(zzxz2.zzcgp) : null;
                if (zzxz2.zzcgn == -1) {
                    date = null;
                } else {
                    date = new Date(zzxz2.zzcgn);
                }
                zzank zzank = new zzank(date, zzxz2.zzcgo, hashSet, zzxz2.zzmw, zzc(zzxz), zzxz2.zzcgr, zzxz2.zzcha, zzxz2.zzchc, zza(str3, zzxz2));
                if (zzxz2.zzcgv != null) {
                    bundle = zzxz2.zzcgv.getBundle(mediationBannerAdapter.getClass().getName());
                }
                mediationBannerAdapter.requestBannerAd((Context) ObjectWrapper.unwrap(iObjectWrapper), new zzano(zzamv), zza(str3, zzxz2, str2), zzb.zza(zzyd2.width, zzyd2.height, zzyd2.zzaap), zzank, bundle);
            } catch (Throwable th) {
                zzbad.zzc("", th);
                throw new RemoteException();
            }
        } else {
            String canonicalName = MediationBannerAdapter.class.getCanonicalName();
            String canonicalName2 = this.zzdgc.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
            sb.append(canonicalName);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName2);
            zzbad.zzep(sb.toString());
            throw new RemoteException();
        }
    }

    public final Bundle zzsh() {
        if (this.zzdgc instanceof zzbjk) {
            return ((zzbjk) this.zzdgc).zzsh();
        }
        String canonicalName = zzbjk.class.getCanonicalName();
        String canonicalName2 = this.zzdgc.getClass().getCanonicalName();
        StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
        sb.append(canonicalName);
        sb.append(" #009 Class mismatch: ");
        sb.append(canonicalName2);
        zzbad.zzep(sb.toString());
        return new Bundle();
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzxz zzxz, String str, zzamv zzamv) throws RemoteException {
        zza(iObjectWrapper, zzxz, str, (String) null, zzamv);
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzxz zzxz, String str, String str2, zzamv zzamv) throws RemoteException {
        Date date;
        zzxz zzxz2 = zzxz;
        String str3 = str;
        if (this.zzdgc instanceof MediationInterstitialAdapter) {
            zzbad.zzdp("Requesting interstitial ad from adapter.");
            try {
                MediationInterstitialAdapter mediationInterstitialAdapter = (MediationInterstitialAdapter) this.zzdgc;
                Bundle bundle = null;
                HashSet hashSet = zzxz2.zzcgp != null ? new HashSet(zzxz2.zzcgp) : null;
                if (zzxz2.zzcgn == -1) {
                    date = null;
                } else {
                    date = new Date(zzxz2.zzcgn);
                }
                zzank zzank = new zzank(date, zzxz2.zzcgo, hashSet, zzxz2.zzmw, zzc(zzxz), zzxz2.zzcgr, zzxz2.zzcha, zzxz2.zzchc, zza(str3, zzxz2));
                if (zzxz2.zzcgv != null) {
                    bundle = zzxz2.zzcgv.getBundle(mediationInterstitialAdapter.getClass().getName());
                }
                mediationInterstitialAdapter.requestInterstitialAd((Context) ObjectWrapper.unwrap(iObjectWrapper), new zzano(zzamv), zza(str3, zzxz2, str2), zzank, bundle);
            } catch (Throwable th) {
                zzbad.zzc("", th);
                throw new RemoteException();
            }
        } else {
            String canonicalName = MediationInterstitialAdapter.class.getCanonicalName();
            String canonicalName2 = this.zzdgc.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
            sb.append(canonicalName);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName2);
            zzbad.zzep(sb.toString());
            throw new RemoteException();
        }
    }

    public final Bundle getInterstitialAdapterInfo() {
        if (this.zzdgc instanceof zzbjl) {
            return ((zzbjl) this.zzdgc).getInterstitialAdapterInfo();
        }
        String canonicalName = zzbjl.class.getCanonicalName();
        String canonicalName2 = this.zzdgc.getClass().getCanonicalName();
        StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
        sb.append(canonicalName);
        sb.append(" #009 Class mismatch: ");
        sb.append(canonicalName2);
        zzbad.zzep(sb.toString());
        return new Bundle();
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzxz zzxz, String str, String str2, zzamv zzamv, zzady zzady, List<String> list) throws RemoteException {
        Date date;
        zzxz zzxz2 = zzxz;
        String str3 = str;
        if (this.zzdgc instanceof MediationNativeAdapter) {
            try {
                MediationNativeAdapter mediationNativeAdapter = (MediationNativeAdapter) this.zzdgc;
                Bundle bundle = null;
                HashSet hashSet = zzxz2.zzcgp != null ? new HashSet(zzxz2.zzcgp) : null;
                if (zzxz2.zzcgn == -1) {
                    date = null;
                } else {
                    date = new Date(zzxz2.zzcgn);
                }
                zzans zzans = new zzans(date, zzxz2.zzcgo, hashSet, zzxz2.zzmw, zzc(zzxz), zzxz2.zzcgr, zzady, list, zzxz2.zzcha, zzxz2.zzchc, zza(str3, zzxz2));
                if (zzxz2.zzcgv != null) {
                    bundle = zzxz2.zzcgv.getBundle(mediationNativeAdapter.getClass().getName());
                }
                this.zzdgd = new zzano(zzamv);
                mediationNativeAdapter.requestNativeAd((Context) ObjectWrapper.unwrap(iObjectWrapper), this.zzdgd, zza(str3, zzxz2, str2), zzans, bundle);
            } catch (Throwable th) {
                zzbad.zzc("", th);
                throw new RemoteException();
            }
        } else {
            String canonicalName = MediationNativeAdapter.class.getCanonicalName();
            String canonicalName2 = this.zzdgc.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
            sb.append(canonicalName);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName2);
            zzbad.zzep(sb.toString());
            throw new RemoteException();
        }
    }

    public final Bundle zzsi() {
        return new Bundle();
    }

    public final zzana zzsf() {
        NativeAdMapper zzsr = this.zzdgd.zzsr();
        if (zzsr instanceof NativeAppInstallAdMapper) {
            return new zzanq((NativeAppInstallAdMapper) zzsr);
        }
        return null;
    }

    public final zzang zzsl() {
        UnifiedNativeAdMapper zzss = this.zzdgd.zzss();
        if (zzss != null) {
            return new zzaoi(zzss);
        }
        return null;
    }

    public final zzand zzsg() {
        NativeAdMapper zzsr = this.zzdgd.zzsr();
        if (zzsr instanceof NativeContentAdMapper) {
            return new zzanr((NativeContentAdMapper) zzsr);
        }
        return null;
    }

    public final zzafe zzsk() {
        NativeCustomTemplateAd zzst = this.zzdgd.zzst();
        if (zzst instanceof zzafh) {
            return ((zzafh) zzst).zzrn();
        }
        return null;
    }

    public final boolean zzsj() {
        return this.zzdgc instanceof InitializableMediationRewardedVideoAdAdapter;
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzxz zzxz, String str, zzatk zzatk, String str2) throws RemoteException {
        Bundle bundle;
        zzank zzank;
        Date date;
        zzxz zzxz2 = zzxz;
        zzatk zzatk2 = zzatk;
        String str3 = str2;
        if (this.zzdgc instanceof MediationRewardedVideoAdAdapter) {
            zzbad.zzdp("Initialize rewarded video adapter.");
            try {
                MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter = (MediationRewardedVideoAdAdapter) this.zzdgc;
                Bundle zza = zza(str3, zzxz2, (String) null);
                if (zzxz2 != null) {
                    HashSet hashSet = zzxz2.zzcgp != null ? new HashSet(zzxz2.zzcgp) : null;
                    if (zzxz2.zzcgn == -1) {
                        date = null;
                    } else {
                        date = new Date(zzxz2.zzcgn);
                    }
                    zzank zzank2 = new zzank(date, zzxz2.zzcgo, hashSet, zzxz2.zzmw, zzc(zzxz), zzxz2.zzcgr, zzxz2.zzcha, zzxz2.zzchc, zza(str3, zzxz2));
                    bundle = zzxz2.zzcgv != null ? zzxz2.zzcgv.getBundle(mediationRewardedVideoAdAdapter.getClass().getName()) : null;
                    zzank = zzank2;
                } else {
                    zzank = null;
                    bundle = null;
                }
                mediationRewardedVideoAdAdapter.initialize((Context) ObjectWrapper.unwrap(iObjectWrapper), zzank, str, new zzatn(zzatk2), zza, bundle);
            } catch (Throwable th) {
                zzbad.zzc("", th);
                throw new RemoteException();
            }
        } else if (this.zzdgc instanceof Adapter) {
            this.zzdgf = iObjectWrapper;
            this.zzdge = zzatk2;
            zzatk2.zzae(ObjectWrapper.wrap(this.zzdgc));
        } else {
            String canonicalName = MediationRewardedVideoAdAdapter.class.getCanonicalName();
            String canonicalName2 = Adapter.class.getCanonicalName();
            String canonicalName3 = this.zzdgc.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 26 + String.valueOf(canonicalName2).length() + String.valueOf(canonicalName3).length());
            sb.append(canonicalName);
            sb.append(" or ");
            sb.append(canonicalName2);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName3);
            zzbad.zzep(sb.toString());
            throw new RemoteException();
        }
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzatk zzatk, List<String> list) throws RemoteException {
        if (this.zzdgc instanceof InitializableMediationRewardedVideoAdAdapter) {
            zzbad.zzdp("Initialize rewarded video adapter.");
            try {
                InitializableMediationRewardedVideoAdAdapter initializableMediationRewardedVideoAdAdapter = (InitializableMediationRewardedVideoAdAdapter) this.zzdgc;
                ArrayList arrayList = new ArrayList();
                for (String zza : list) {
                    arrayList.add(zza(zza, (zzxz) null, (String) null));
                }
                initializableMediationRewardedVideoAdAdapter.initialize((Context) ObjectWrapper.unwrap(iObjectWrapper), new zzatn(zzatk), arrayList);
            } catch (Throwable th) {
                zzbad.zzd("Could not initialize rewarded video adapter.", th);
                throw new RemoteException();
            }
        } else {
            String canonicalName = InitializableMediationRewardedVideoAdAdapter.class.getCanonicalName();
            String canonicalName2 = this.zzdgc.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
            sb.append(canonicalName);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName2);
            zzbad.zzep(sb.toString());
            throw new RemoteException();
        }
    }

    public final void zza(zzxz zzxz, String str) throws RemoteException {
        zza(zzxz, str, (String) null);
    }

    public final void zza(zzxz zzxz, String str, String str2) throws RemoteException {
        Date date;
        zzxz zzxz2 = zzxz;
        String str3 = str;
        if (this.zzdgc instanceof MediationRewardedVideoAdAdapter) {
            zzbad.zzdp("Requesting rewarded video ad from adapter.");
            try {
                MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter = (MediationRewardedVideoAdAdapter) this.zzdgc;
                Bundle bundle = null;
                HashSet hashSet = zzxz2.zzcgp != null ? new HashSet(zzxz2.zzcgp) : null;
                if (zzxz2.zzcgn == -1) {
                    date = null;
                } else {
                    date = new Date(zzxz2.zzcgn);
                }
                zzank zzank = new zzank(date, zzxz2.zzcgo, hashSet, zzxz2.zzmw, zzc(zzxz), zzxz2.zzcgr, zzxz2.zzcha, zzxz2.zzchc, zza(str3, zzxz2));
                if (zzxz2.zzcgv != null) {
                    bundle = zzxz2.zzcgv.getBundle(mediationRewardedVideoAdAdapter.getClass().getName());
                }
                mediationRewardedVideoAdAdapter.loadAd(zzank, zza(str3, zzxz2, str2), bundle);
            } catch (Throwable th) {
                zzbad.zzc("", th);
                throw new RemoteException();
            }
        } else if (this.zzdgc instanceof Adapter) {
            zzb(this.zzdgf, zzxz2, str3, new zzanp((Adapter) this.zzdgc, this.zzdge));
        } else {
            String canonicalName = MediationRewardedVideoAdAdapter.class.getCanonicalName();
            String canonicalName2 = Adapter.class.getCanonicalName();
            String canonicalName3 = this.zzdgc.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 26 + String.valueOf(canonicalName2).length() + String.valueOf(canonicalName3).length());
            sb.append(canonicalName);
            sb.append(" or ");
            sb.append(canonicalName2);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName3);
            zzbad.zzep(sb.toString());
            throw new RemoteException();
        }
    }

    public final void showVideo() throws RemoteException {
        if (this.zzdgc instanceof MediationRewardedVideoAdAdapter) {
            zzbad.zzdp("Show rewarded video ad from adapter.");
            try {
                ((MediationRewardedVideoAdAdapter) this.zzdgc).showVideo();
            } catch (Throwable th) {
                zzbad.zzc("", th);
                throw new RemoteException();
            }
        } else if (!(this.zzdgc instanceof Adapter)) {
            String canonicalName = MediationRewardedVideoAdAdapter.class.getCanonicalName();
            String canonicalName2 = Adapter.class.getCanonicalName();
            String canonicalName3 = this.zzdgc.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 26 + String.valueOf(canonicalName2).length() + String.valueOf(canonicalName3).length());
            sb.append(canonicalName);
            sb.append(" or ");
            sb.append(canonicalName2);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName3);
            zzbad.zzep(sb.toString());
            throw new RemoteException();
        } else if (this.zzdgg != null) {
            this.zzdgg.showAd((Context) ObjectWrapper.unwrap(this.zzdgf));
        } else {
            zzbad.zzen("Can not show null mediated rewarded ad.");
            throw new RemoteException();
        }
    }

    public final boolean isInitialized() throws RemoteException {
        if (this.zzdgc instanceof MediationRewardedVideoAdAdapter) {
            zzbad.zzdp("Check if adapter is initialized.");
            try {
                return ((MediationRewardedVideoAdAdapter) this.zzdgc).isInitialized();
            } catch (Throwable th) {
                zzbad.zzc("", th);
                throw new RemoteException();
            }
        } else if (this.zzdgc instanceof Adapter) {
            return this.zzdge != null;
        } else {
            String canonicalName = MediationRewardedVideoAdAdapter.class.getCanonicalName();
            String canonicalName2 = Adapter.class.getCanonicalName();
            String canonicalName3 = this.zzdgc.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 26 + String.valueOf(canonicalName2).length() + String.valueOf(canonicalName3).length());
            sb.append(canonicalName);
            sb.append(" or ");
            sb.append(canonicalName2);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName3);
            zzbad.zzep(sb.toString());
            throw new RemoteException();
        }
    }

    public final void zzb(IObjectWrapper iObjectWrapper, zzxz zzxz, String str, zzamv zzamv) throws RemoteException {
        Bundle bundle;
        zzxz zzxz2 = zzxz;
        String str2 = str;
        if (this.zzdgc instanceof Adapter) {
            zzbad.zzdp("Requesting rewarded ad from adapter.");
            try {
                Adapter adapter = (Adapter) this.zzdgc;
                zzanm zzanm = new zzanm(this, zzamv, adapter);
                Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
                Bundle zza = zza(str2, zzxz2, (String) null);
                if (zzxz2.zzcgv == null || (bundle = zzxz2.zzcgv.getBundle(this.zzdgc.getClass().getName())) == null) {
                    bundle = new Bundle();
                }
                adapter.loadRewardedAd(new MediationRewardedAdConfiguration(context, "", zza, bundle, zzc(zzxz), zzxz2.zzmw, zzxz2.zzcgr, zzxz2.zzchc, zza(str2, zzxz2)), zzanm);
            } catch (Exception e) {
                zzbad.zzc("", e);
                throw new RemoteException();
            }
        } else {
            String canonicalName = Adapter.class.getCanonicalName();
            String canonicalName2 = this.zzdgc.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
            sb.append(canonicalName);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName2);
            zzbad.zzep(sb.toString());
            throw new RemoteException();
        }
    }

    public final void zzs(IObjectWrapper iObjectWrapper) throws RemoteException {
        if (this.zzdgc instanceof Adapter) {
            zzbad.zzdp("Show rewarded ad from adapter.");
            if (this.zzdgg != null) {
                this.zzdgg.showAd((Context) ObjectWrapper.unwrap(iObjectWrapper));
            } else {
                zzbad.zzen("Can not show null mediation rewarded ad.");
                throw new RemoteException();
            }
        } else {
            String canonicalName = Adapter.class.getCanonicalName();
            String canonicalName2 = this.zzdgc.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
            sb.append(canonicalName);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName2);
            zzbad.zzep(sb.toString());
            throw new RemoteException();
        }
    }

    public final void setImmersiveMode(boolean z) throws RemoteException {
        if (!(this.zzdgc instanceof OnImmersiveModeUpdatedListener)) {
            String canonicalName = OnImmersiveModeUpdatedListener.class.getCanonicalName();
            String canonicalName2 = this.zzdgc.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
            sb.append(canonicalName);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName2);
            zzbad.zzep(sb.toString());
            return;
        }
        try {
            ((OnImmersiveModeUpdatedListener) this.zzdgc).onImmersiveModeUpdated(z);
        } catch (Throwable th) {
            zzbad.zzc("", th);
        }
    }

    public final zzaar getVideoController() {
        if (!(this.zzdgc instanceof zza)) {
            return null;
        }
        try {
            return ((zza) this.zzdgc).getVideoController();
        } catch (Throwable th) {
            zzbad.zzc("", th);
            return null;
        }
    }

    public final void showInterstitial() throws RemoteException {
        if (this.zzdgc instanceof MediationInterstitialAdapter) {
            zzbad.zzdp("Showing interstitial from adapter.");
            try {
                ((MediationInterstitialAdapter) this.zzdgc).showInterstitial();
            } catch (Throwable th) {
                zzbad.zzc("", th);
                throw new RemoteException();
            }
        } else {
            String canonicalName = MediationInterstitialAdapter.class.getCanonicalName();
            String canonicalName2 = this.zzdgc.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
            sb.append(canonicalName);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName2);
            zzbad.zzep(sb.toString());
            throw new RemoteException();
        }
    }

    public final void destroy() throws RemoteException {
        if (this.zzdgc instanceof MediationAdapter) {
            try {
                ((MediationAdapter) this.zzdgc).onDestroy();
            } catch (Throwable th) {
                zzbad.zzc("", th);
                throw new RemoteException();
            }
        }
    }

    public final void pause() throws RemoteException {
        if (this.zzdgc instanceof MediationAdapter) {
            try {
                ((MediationAdapter) this.zzdgc).onPause();
            } catch (Throwable th) {
                zzbad.zzc("", th);
                throw new RemoteException();
            }
        }
    }

    public final void resume() throws RemoteException {
        if (this.zzdgc instanceof MediationAdapter) {
            try {
                ((MediationAdapter) this.zzdgc).onResume();
            } catch (Throwable th) {
                zzbad.zzc("", th);
                throw new RemoteException();
            }
        }
    }

    public final void zzr(IObjectWrapper iObjectWrapper) throws RemoteException {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        if (this.zzdgc instanceof OnContextChangedListener) {
            ((OnContextChangedListener) this.zzdgc).onContextChanged(context);
        }
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzaiq zzaiq, List<zzaiw> list) throws RemoteException {
        AdFormat adFormat;
        if (this.zzdgc instanceof Adapter) {
            zzann zzann = new zzann(this, zzaiq);
            ArrayList arrayList = new ArrayList();
            for (zzaiw next : list) {
                String str = next.zzdbd;
                char c = 65535;
                int hashCode = str.hashCode();
                if (hashCode != -1396342996) {
                    if (hashCode != -1052618729) {
                        if (hashCode != -239580146) {
                            if (hashCode == 604727084 && str.equals("interstitial")) {
                                c = 1;
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
                        throw new RemoteException();
                }
                arrayList.add(new MediationConfiguration(adFormat, next.extras));
            }
            ((Adapter) this.zzdgc).initialize((Context) ObjectWrapper.unwrap(iObjectWrapper), zzann, arrayList);
            return;
        }
        throw new RemoteException();
    }

    private final Bundle zza(String str, zzxz zzxz, String str2) throws RemoteException {
        Bundle bundle;
        String valueOf = String.valueOf(str);
        zzbad.zzdp(valueOf.length() != 0 ? "Server parameters: ".concat(valueOf) : new String("Server parameters: "));
        try {
            Bundle bundle2 = new Bundle();
            if (str != null) {
                JSONObject jSONObject = new JSONObject(str);
                bundle = new Bundle();
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    bundle.putString(next, jSONObject.getString(next));
                }
            } else {
                bundle = bundle2;
            }
            if (this.zzdgc instanceof AdMobAdapter) {
                bundle.putString("adJson", str2);
                if (zzxz != null) {
                    bundle.putInt("tagForChildDirectedTreatment", zzxz.zzcgr);
                }
            }
            bundle.remove("max_ad_content_rating");
            return bundle;
        } catch (Throwable th) {
            zzbad.zzc("", th);
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
}
