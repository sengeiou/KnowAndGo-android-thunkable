package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbqy;
import com.google.android.gms.internal.ads.zzbtv;
import java.util.Collections;
import javax.annotation.concurrent.GuardedBy;

@zzard
public final class zzcpt extends zzzl implements zzbtf {
    /* access modifiers changed from: private */
    public final ViewGroup zzfgu;
    private final zzbjm zzgbc;
    /* access modifiers changed from: private */
    @GuardedBy("this")
    @Nullable
    public zzbnf zzgdo;
    private final Context zzgdr;
    @GuardedBy("this")
    private final zzcxx zzgds = new zzcxx();
    private final zzcpw zzgef = new zzcpw();
    private final zzcpv zzgeg = new zzcpv();
    private final zzcpy zzgeh = new zzcpy();
    /* access modifiers changed from: private */
    public final zzbtb zzgei;
    @GuardedBy("this")
    @Nullable
    private zzado zzgej;
    /* access modifiers changed from: private */
    @GuardedBy("this")
    @Nullable
    public zzbbh<zzbnf> zzgek;

    public zzcpt(zzbjm zzbjm, Context context, zzyd zzyd, String str) {
        this.zzfgu = new FrameLayout(context);
        this.zzgbc = zzbjm;
        this.zzgdr = context;
        this.zzgds.zzd(zzyd).zzft(str);
        this.zzgei = zzbjm.zzacg();
        this.zzgei.zza(this, this.zzgbc.zzace());
    }

    public final boolean isReady() {
        return false;
    }

    public final void setImmersiveMode(boolean z) {
    }

    public final void setUserId(String str) {
    }

    public final void showInterstitial() {
    }

    public final void stopLoading() {
    }

    public final void zza(zzaax zzaax) {
    }

    public final void zza(zzaqn zzaqn) {
    }

    public final void zza(zzaqt zzaqt, String str) {
    }

    public final void zza(zzatb zzatb) {
    }

    public final void zzbt(String str) {
    }

    public final IObjectWrapper zzpl() {
        Preconditions.checkMainThread("destroy must be called on the main UI thread.");
        return ObjectWrapper.wrap(this.zzfgu);
    }

    public final synchronized boolean zzb(zzxz zzxz) {
        Preconditions.checkMainThread("loadAd must be called on the main UI thread.");
        if (this.zzgek != null) {
            return false;
        }
        zzcya.zze(this.zzgdr, zzxz.zzcgq);
        zzboc zzb = zzb(this.zzgds.zzg(zzxz).zzamq());
        this.zzgek = zzb.zzadu();
        zzbar.zza(this.zzgek, new zzcpu(this, zzb), this.zzgbc.zzace());
        return true;
    }

    private final synchronized zzboc zzb(zzcxv zzcxv) {
        return this.zzgbc.zzacj().zzb(new zzbqy.zza().zzbt(this.zzgdr).zza(zzcxv).zzagh()).zzb(new zzbtv.zza().zza((zzxr) this.zzgef, this.zzgbc.zzace()).zza((zzxr) this.zzgeg, this.zzgbc.zzace()).zza((zzbrl) this.zzgef, this.zzgbc.zzace()).zza((zzbsr) this.zzgef, this.zzgbc.zzace()).zza((zzbro) this.zzgef, this.zzgbc.zzace()).zza((AppEventListener) this.zzgeh, this.zzgbc.zzace()).zzagt()).zza(new zzcow(this.zzgej)).zzb(new zzbxk(zzbzc.zzfpd, (zzyz) null)).zza(new zzbox(this.zzgei)).zza(new zzbnc(this.zzfgu)).zzads();
    }

    public final synchronized void destroy() {
        Preconditions.checkMainThread("destroy must be called on the main UI thread.");
        if (this.zzgdo != null) {
            this.zzgdo.destroy();
        }
    }

    public final synchronized void pause() {
        Preconditions.checkMainThread("pause must be called on the main UI thread.");
        if (this.zzgdo != null) {
            this.zzgdo.zzafy().zzbp((Context) null);
        }
    }

    public final synchronized void resume() {
        Preconditions.checkMainThread("resume must be called on the main UI thread.");
        if (this.zzgdo != null) {
            this.zzgdo.zzafy().zzbq((Context) null);
        }
    }

    public final void zzb(zzyz zzyz) {
        Preconditions.checkMainThread("setAdListener must be called on the main UI thread.");
        this.zzgef.zzc(zzyz);
    }

    public final zzyz zzpp() {
        return this.zzgef.zzald();
    }

    public final void zza(zzzs zzzs) {
        Preconditions.checkMainThread("setAppEventListener must be called on the main UI thread.");
        this.zzgeh.zzb(zzzs);
    }

    public final zzzs zzpo() {
        return this.zzgeh.zzale();
    }

    public final synchronized void zzpm() {
        Preconditions.checkMainThread("recordManualImpression must be called on the main UI thread.");
        if (this.zzgdo != null) {
            this.zzgdo.zzpm();
        }
    }

    public final synchronized zzyd zzpn() {
        Preconditions.checkMainThread("getAdSize must be called on the main UI thread.");
        if (this.zzgdo != null) {
            return zzcxy.zza(this.zzgdr, Collections.singletonList(this.zzgdo.zzafj()));
        }
        return this.zzgds.zzpn();
    }

    public final synchronized void zza(zzyd zzyd) {
        Preconditions.checkMainThread("setAdSize must be called on the main UI thread.");
        this.zzgds.zzd(zzyd);
        if (this.zzgdo != null) {
            this.zzgdo.zza(this.zzfgu, zzyd);
        }
    }

    public final synchronized String getMediationAdapterClassName() {
        if (this.zzgdo == null) {
            return null;
        }
        return this.zzgdo.getMediationAdapterClassName();
    }

    public final synchronized String zzpj() {
        if (this.zzgdo == null) {
            return null;
        }
        return this.zzgdo.zzpj();
    }

    public final synchronized void zzb(zzzy zzzy) {
        Preconditions.checkMainThread("setCorrelationIdProvider must be called on the main UI thread");
        this.zzgds.zzd(zzzy);
    }

    public final synchronized void setManualImpressionsEnabled(boolean z) {
        Preconditions.checkMainThread("setManualImpressionsEnabled must be called from the main thread.");
        this.zzgds.zzbc(z);
    }

    public final synchronized boolean isLoading() {
        return this.zzgek != null && !this.zzgek.isDone();
    }

    public final synchronized zzaar getVideoController() {
        Preconditions.checkMainThread("getVideoController must be called from the main thread.");
        if (this.zzgdo == null) {
            return null;
        }
        return this.zzgdo.getVideoController();
    }

    public final synchronized String getAdUnitId() {
        return this.zzgds.zzamp();
    }

    public final synchronized void zza(zzacd zzacd) {
        Preconditions.checkMainThread("setVideoOptions must be called on the main UI thread.");
        this.zzgds.zzc(zzacd);
    }

    public final void zza(zzyw zzyw) {
        Preconditions.checkMainThread("setAdListener must be called on the main UI thread.");
        this.zzgeg.zzb(zzyw);
    }

    public final synchronized void zza(zzado zzado) {
        Preconditions.checkMainThread("setOnCustomRenderedAdLoadedListener must be called on the main UI thread.");
        this.zzgej = zzado;
    }

    public final synchronized void zzagk() {
        boolean z;
        ViewParent parent = this.zzfgu.getParent();
        if (!(parent instanceof View)) {
            z = false;
        } else {
            View view = (View) parent;
            z = zzk.zzlg().zza(view, view.getContext());
        }
        if (z) {
            zzb(this.zzgds.zzamo());
        } else {
            this.zzgei.zzdk(60);
        }
    }

    public final void zza(zzzp zzzp) {
        Preconditions.checkMainThread("setAdMetadataListener must be called on the main UI thread.");
    }

    public final Bundle getAdMetadata() {
        Preconditions.checkMainThread("getAdMetadata must be called on the main UI thread.");
        return new Bundle();
    }
}
