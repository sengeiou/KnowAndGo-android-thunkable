package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Collections;

public final class zzcpm extends zzzl {
    private final ViewGroup zzfgu;
    private final zzcxv zzfjp;
    private final zzyz zzfme;
    private final zzbnf zzgdo;
    private final Context zzlj;

    public zzcpm(Context context, @Nullable zzyz zzyz, zzcxv zzcxv, zzbnf zzbnf) {
        this.zzlj = context;
        this.zzfme = zzyz;
        this.zzfjp = zzcxv;
        this.zzgdo = zzbnf;
        FrameLayout frameLayout = new FrameLayout(this.zzlj);
        frameLayout.removeAllViews();
        frameLayout.addView(this.zzgdo.zzafi(), zzk.zzli().zzwg());
        frameLayout.setMinimumHeight(zzpn().heightPixels);
        frameLayout.setMinimumWidth(zzpn().widthPixels);
        this.zzfgu = frameLayout;
    }

    public final boolean isLoading() throws RemoteException {
        return false;
    }

    public final boolean isReady() throws RemoteException {
        return false;
    }

    public final void setImmersiveMode(boolean z) throws RemoteException {
    }

    public final void setUserId(String str) throws RemoteException {
    }

    public final void showInterstitial() throws RemoteException {
    }

    public final void stopLoading() throws RemoteException {
    }

    public final void zza(zzaax zzaax) throws RemoteException {
    }

    public final void zza(zzaqn zzaqn) throws RemoteException {
    }

    public final void zza(zzaqt zzaqt, String str) throws RemoteException {
    }

    public final void zza(zzatb zzatb) throws RemoteException {
    }

    public final void zzbt(String str) throws RemoteException {
    }

    public final IObjectWrapper zzpl() throws RemoteException {
        return ObjectWrapper.wrap(this.zzfgu);
    }

    public final void destroy() throws RemoteException {
        Preconditions.checkMainThread("destroy must be called on the main UI thread.");
        this.zzgdo.destroy();
    }

    public final boolean zzb(zzxz zzxz) throws RemoteException {
        zzawz.zzeo("loadAd is not supported for a Publisher AdView returned from AdLoader.");
        return false;
    }

    public final void pause() throws RemoteException {
        Preconditions.checkMainThread("destroy must be called on the main UI thread.");
        this.zzgdo.zzafy().zzbp((Context) null);
    }

    public final void resume() throws RemoteException {
        Preconditions.checkMainThread("destroy must be called on the main UI thread.");
        this.zzgdo.zzafy().zzbq((Context) null);
    }

    public final void zzpm() throws RemoteException {
        this.zzgdo.zzpm();
    }

    public final zzyd zzpn() {
        return zzcxy.zza(this.zzlj, Collections.singletonList(this.zzgdo.zzafj()));
    }

    public final String getMediationAdapterClassName() throws RemoteException {
        return this.zzgdo.getMediationAdapterClassName();
    }

    public final zzaar getVideoController() throws RemoteException {
        return this.zzgdo.getVideoController();
    }

    public final String getAdUnitId() throws RemoteException {
        return this.zzfjp.zzglb;
    }

    public final zzzs zzpo() throws RemoteException {
        return this.zzfjp.zzgli;
    }

    public final zzyz zzpp() throws RemoteException {
        return this.zzfme;
    }

    public final String zzpj() throws RemoteException {
        return this.zzgdo.zzpj();
    }

    public final void zza(zzacd zzacd) throws RemoteException {
        zzawz.zzeo("setVideoOptions is not supported in Publisher AdView returned by AdLoader.");
    }

    public final void zza(zzyd zzyd) throws RemoteException {
        if (this.zzgdo != null) {
            this.zzgdo.zza(this.zzfgu, zzyd);
        }
    }

    public final void zza(zzado zzado) throws RemoteException {
        zzawz.zzeo("setOnCustomRenderedAdLoadedListener is not supported in Publisher AdView returned by AdLoader.");
    }

    public final void zza(zzyw zzyw) throws RemoteException {
        zzawz.zzeo("setAdClickListener is not supported in Publisher AdView returned by AdLoader.");
    }

    public final void zzb(zzzy zzzy) throws RemoteException {
        zzawz.zzeo("setCorrelationIdProvider is not supported in Publisher AdView returned by AdLoader.");
    }

    public final void setManualImpressionsEnabled(boolean z) throws RemoteException {
        zzawz.zzeo("setManualImpressionsEnabled is not supported in Publisher AdView returned by AdLoader.");
    }

    public final void zzb(zzyz zzyz) throws RemoteException {
        zzawz.zzeo("setAdListener is not supported in Publisher AdView returned by AdLoader.");
    }

    public final void zza(zzzs zzzs) throws RemoteException {
        zzawz.zzeo("setAppEventListener is not supported in Publisher AdView returned by AdLoader.");
    }

    public final void zza(zzzp zzzp) throws RemoteException {
        zzawz.zzeo("setAdMetadataListener is not supported in Publisher AdView returned by AdLoader.");
    }

    public final Bundle getAdMetadata() throws RemoteException {
        zzawz.zzeo("getAdMetadata is not supported in Publisher AdView returned by AdLoader.");
        return new Bundle();
    }
}
