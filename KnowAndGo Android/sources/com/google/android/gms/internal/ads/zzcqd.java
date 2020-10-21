package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzbqy;
import com.google.android.gms.internal.ads.zzbtv;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;

public final class zzcqd extends zzzl {
    private final Executor zzffv;
    private final zzbjm zzgbc;
    private final Context zzgdr;
    @GuardedBy("this")
    private final zzcxx zzgds = new zzcxx();
    private final zzcpw zzgef = new zzcpw();
    private final zzcpy zzgeh = new zzcpy();
    @GuardedBy("this")
    @Nullable
    private zzado zzgej;
    /* access modifiers changed from: private */
    @GuardedBy("this")
    @Nullable
    public zzbbh<zzbvx> zzgek;
    private final zzcqc zzgex = new zzcqc();
    /* access modifiers changed from: private */
    @GuardedBy("this")
    @Nullable
    public zzbvx zzgey;
    @GuardedBy("this")
    private boolean zzgez = false;

    public zzcqd(zzbjm zzbjm, Context context, zzyd zzyd, String str) {
        this.zzgbc = zzbjm;
        this.zzgds.zzd(zzyd).zzft(str);
        this.zzffv = zzbjm.zzace();
        this.zzgdr = context;
    }

    public final zzaar getVideoController() {
        return null;
    }

    public final void setUserId(String str) {
    }

    public final void stopLoading() {
    }

    public final void zza(zzaax zzaax) {
    }

    public final void zza(zzaqn zzaqn) {
    }

    public final void zza(zzaqt zzaqt, String str) {
    }

    public final void zza(zzyd zzyd) {
    }

    public final void zza(zzyw zzyw) {
    }

    public final void zzbt(String str) {
    }

    public final IObjectWrapper zzpl() {
        return null;
    }

    public final void zzpm() {
    }

    public final zzyd zzpn() {
        return null;
    }

    public final synchronized boolean zzb(zzxz zzxz) {
        Preconditions.checkMainThread("loadAd must be called on the main UI thread.");
        if (this.zzgek == null) {
            if (!zzalf()) {
                zzcya.zze(this.zzgdr, zzxz.zzcgq);
                this.zzgey = null;
                zzcxv zzamq = this.zzgds.zzg(zzxz).zzamq();
                zzbtv.zza zza = new zzbtv.zza();
                if (this.zzgex != null) {
                    zza.zza((zzbrl) this.zzgex, this.zzgbc.zzace()).zza((zzbsr) this.zzgex, this.zzgbc.zzace()).zza((zzbro) this.zzgex, this.zzgbc.zzace());
                }
                zzbws zzaed = this.zzgbc.zzack().zzc(new zzbqy.zza().zzbt(this.zzgdr).zza(zzamq).zzagh()).zzc(zza.zza((zzbrl) this.zzgef, this.zzgbc.zzace()).zza((zzbsr) this.zzgef, this.zzgbc.zzace()).zza((zzbro) this.zzgef, this.zzgbc.zzace()).zza((zzxr) this.zzgef, this.zzgbc.zzace()).zza((AppEventListener) this.zzgeh, this.zzgbc.zzace()).zzagt()).zzb(new zzcow(this.zzgej)).zzaed();
                this.zzgek = zzaed.zzadu();
                zzbar.zza(this.zzgek, new zzcqe(this, zzaed), this.zzffv);
                return true;
            }
        }
        return false;
    }

    public final synchronized void destroy() {
        Preconditions.checkMainThread("destroy must be called on the main UI thread.");
        if (this.zzgey != null) {
            this.zzgey.zzadd().zzbr((Context) null);
        }
    }

    public final synchronized void pause() {
        Preconditions.checkMainThread("pause must be called on the main UI thread.");
        if (this.zzgey != null) {
            this.zzgey.zzadd().zzbp((Context) null);
        }
    }

    public final synchronized void resume() {
        Preconditions.checkMainThread("resume must be called on the main UI thread.");
        if (this.zzgey != null) {
            this.zzgey.zzadd().zzbq((Context) null);
        }
    }

    public final void zzb(zzyz zzyz) {
        Preconditions.checkMainThread("setAdListener must be called on the main UI thread.");
        this.zzgef.zzc(zzyz);
    }

    public final void zza(zzzs zzzs) {
        Preconditions.checkMainThread("setAppEventListener must be called on the main UI thread.");
        this.zzgeh.zzb(zzzs);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001c, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void showInterstitial() {
        /*
            r2 = this;
            monitor-enter(r2)
            java.lang.String r0 = "showInterstitial must be called on the main UI thread."
            com.google.android.gms.common.internal.Preconditions.checkMainThread(r0)     // Catch:{ all -> 0x001d }
            com.google.android.gms.internal.ads.zzbvx r0 = r2.zzgey     // Catch:{ all -> 0x001d }
            if (r0 != 0) goto L_0x000c
            monitor-exit(r2)
            return
        L_0x000c:
            com.google.android.gms.internal.ads.zzbvx r0 = r2.zzgey     // Catch:{ all -> 0x001d }
            boolean r0 = r0.zzagz()     // Catch:{ all -> 0x001d }
            if (r0 == 0) goto L_0x001b
            com.google.android.gms.internal.ads.zzbvx r0 = r2.zzgey     // Catch:{ all -> 0x001d }
            boolean r1 = r2.zzgez     // Catch:{ all -> 0x001d }
            r0.show(r1)     // Catch:{ all -> 0x001d }
        L_0x001b:
            monitor-exit(r2)
            return
        L_0x001d:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcqd.showInterstitial():void");
    }

    public final synchronized String getMediationAdapterClassName() {
        if (this.zzgey == null) {
            return null;
        }
        return this.zzgey.getMediationAdapterClassName();
    }

    public final synchronized String zzpj() {
        if (this.zzgey == null) {
            return null;
        }
        return this.zzgey.zzpj();
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

    public final synchronized boolean isReady() {
        Preconditions.checkMainThread("isLoaded must be called on the main UI thread.");
        return zzalf();
    }

    public final synchronized String getAdUnitId() {
        return this.zzgds.zzamp();
    }

    public final zzzs zzpo() {
        return this.zzgeh.zzale();
    }

    public final zzyz zzpp() {
        return this.zzgef.zzald();
    }

    public final synchronized void setImmersiveMode(boolean z) {
        Preconditions.checkMainThread("setImmersiveMode must be called on the main UI thread.");
        this.zzgez = z;
    }

    public final synchronized void zza(zzacd zzacd) {
        this.zzgds.zzc(zzacd);
    }

    public final synchronized void zza(zzado zzado) {
        Preconditions.checkMainThread("setOnCustomRenderedAdLoadedListener must be called on the main UI thread.");
        this.zzgej = zzado;
    }

    private final synchronized boolean zzalf() {
        return this.zzgey != null && !this.zzgey.isClosed();
    }

    public final void zza(zzzp zzzp) {
        Preconditions.checkMainThread("setAdMetadataListener must be called on the main UI thread.");
    }

    public final Bundle getAdMetadata() {
        Preconditions.checkMainThread("getAdMetadata must be called on the main UI thread.");
        return new Bundle();
    }

    public final void zza(zzatb zzatb) {
        this.zzgex.zzb(zzatb);
    }
}
