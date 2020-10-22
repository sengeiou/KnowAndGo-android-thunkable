package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.reward.AdMetadataListener;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbqy;
import com.google.android.gms.internal.ads.zzbtv;
import javax.annotation.concurrent.GuardedBy;

public final class zzcqj extends zzasx {
    @Nullable
    private zzbss zzfsq;
    private final zzbjm zzgbc;
    private final Context zzgdr;
    @GuardedBy("this")
    private final zzcxx zzgds = new zzcxx();
    private final zzcpy zzgeh = new zzcpy();
    /* access modifiers changed from: private */
    @GuardedBy("this")
    @Nullable
    public zzbbh<zzcdb> zzgek;
    @GuardedBy("this")
    private boolean zzgez = false;
    /* access modifiers changed from: private */
    @GuardedBy("this")
    @Nullable
    public zzcdb zzgfc;
    /* access modifiers changed from: private */
    public boolean zzgfg = false;
    private final zzcqc zzgfl = new zzcqc();
    private final zzcpx zzgfm = new zzcpx();

    public zzcqj(zzbjm zzbjm, Context context) {
        this.zzgbc = zzbjm;
        this.zzgdr = context;
    }

    public final void setAppPackageName(String str) throws RemoteException {
    }

    public final synchronized void zza(zzath zzath) throws RemoteException {
        Preconditions.checkMainThread("loadAd must be called on the main UI thread.");
        this.zzgfg = false;
        if (zzath.zzchk == null) {
            zzawz.zzen("Ad unit ID should not be null for rewarded video ad.");
            this.zzgbc.zzace().execute(new zzcqk(this));
        } else if (!zzacw.zzcg(zzath.zzchk)) {
            if (this.zzgek == null) {
                if (zzalf()) {
                    if (!((Boolean) zzyt.zzpe().zzd(zzacu.zzcvh)).booleanValue()) {
                        return;
                    }
                }
                zzcya.zze(this.zzgdr, zzath.zzdlk.zzcgq);
                this.zzgfc = null;
                zzcdf zzaeh = this.zzgbc.zzacm().zzd(new zzbqy.zza().zzbt(this.zzgdr).zza(this.zzgds.zzft(zzath.zzchk).zzd(zzyd.zzou()).zzg(zzath.zzdlk).zzamq()).zzfg((String) null).zzagh()).zzd(new zzbtv.zza().zza((zzbrl) this.zzgfl, this.zzgbc.zzace()).zza((zzbsr) new zzcqn(this, this.zzgfl), this.zzgbc.zzace()).zza((zzbro) this.zzgfl, this.zzgbc.zzace()).zza((AdMetadataListener) this.zzgfm, this.zzgbc.zzace()).zza((AppEventListener) this.zzgeh, this.zzgbc.zzace()).zzagt()).zzaeh();
                this.zzfsq = zzaeh.zzaei();
                this.zzgek = zzaeh.zzadu();
                zzbar.zza(this.zzgek, new zzcql(this, zzaeh), this.zzgbc.zzace());
            }
        }
    }

    public final void destroy() throws RemoteException {
        zzn((IObjectWrapper) null);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: android.content.Context} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzn(com.google.android.gms.dynamic.IObjectWrapper r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            java.lang.String r0 = "destroy must be called on the main UI thread."
            com.google.android.gms.common.internal.Preconditions.checkMainThread(r0)     // Catch:{ all -> 0x0028 }
            com.google.android.gms.internal.ads.zzcpx r0 = r2.zzgfm     // Catch:{ all -> 0x0028 }
            r1 = 0
            r0.zzb(r1)     // Catch:{ all -> 0x0028 }
            r0 = 0
            r2.zzgfg = r0     // Catch:{ all -> 0x0028 }
            com.google.android.gms.internal.ads.zzcdb r0 = r2.zzgfc     // Catch:{ all -> 0x0028 }
            if (r0 == 0) goto L_0x0026
            if (r3 != 0) goto L_0x0016
            goto L_0x001d
        L_0x0016:
            java.lang.Object r3 = com.google.android.gms.dynamic.ObjectWrapper.unwrap(r3)     // Catch:{ all -> 0x0028 }
            r1 = r3
            android.content.Context r1 = (android.content.Context) r1     // Catch:{ all -> 0x0028 }
        L_0x001d:
            com.google.android.gms.internal.ads.zzcdb r3 = r2.zzgfc     // Catch:{ all -> 0x0028 }
            com.google.android.gms.internal.ads.zzbry r3 = r3.zzadd()     // Catch:{ all -> 0x0028 }
            r3.zzbr(r1)     // Catch:{ all -> 0x0028 }
        L_0x0026:
            monitor-exit(r2)
            return
        L_0x0028:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcqj.zzn(com.google.android.gms.dynamic.IObjectWrapper):void");
    }

    public final void pause() throws RemoteException {
        zzl((IObjectWrapper) null);
    }

    public final synchronized void zzl(IObjectWrapper iObjectWrapper) {
        Context context;
        Preconditions.checkMainThread("pause must be called on the main UI thread.");
        if (this.zzgfc != null) {
            if (iObjectWrapper == null) {
                context = null;
            } else {
                context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
            }
            this.zzgfc.zzadd().zzbp(context);
        }
    }

    public final void resume() throws RemoteException {
        zzm((IObjectWrapper) null);
    }

    public final synchronized void zzm(IObjectWrapper iObjectWrapper) {
        Context context;
        Preconditions.checkMainThread("resume must be called on the main UI thread.");
        if (this.zzgfc != null) {
            if (iObjectWrapper == null) {
                context = null;
            } else {
                context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
            }
            this.zzgfc.zzadd().zzbq(context);
        }
    }

    public final synchronized void show() throws RemoteException {
        zzk((IObjectWrapper) null);
    }

    public final synchronized void zzk(@Nullable IObjectWrapper iObjectWrapper) throws RemoteException {
        Activity activity;
        Preconditions.checkMainThread("showAd must be called on the main UI thread.");
        if (this.zzgfc != null) {
            if (iObjectWrapper != null) {
                Object unwrap = ObjectWrapper.unwrap(iObjectWrapper);
                if (unwrap instanceof Activity) {
                    activity = (Activity) unwrap;
                    this.zzgfc.zzb(this.zzgez, activity);
                }
            }
            activity = null;
            this.zzgfc.zzb(this.zzgez, activity);
        }
    }

    public final synchronized String getMediationAdapterClassName() throws RemoteException {
        if (this.zzgfc == null) {
            return null;
        }
        return this.zzgfc.getMediationAdapterClassName();
    }

    public final boolean isLoaded() throws RemoteException {
        Preconditions.checkMainThread("isLoaded must be called on the main UI thread.");
        return zzalf();
    }

    public final void zza(zzatb zzatb) throws RemoteException {
        Preconditions.checkMainThread("setRewardedVideoAdListener can only be called from the UI thread.");
        this.zzgfl.zzb(zzatb);
    }

    public final void zza(zzasu zzasu) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.: setRewardedAdSkuListener");
        this.zzgfl.zzb(zzasu);
    }

    public final void zza(zzzp zzzp) {
        Preconditions.checkMainThread("setAdMetadataListener can only be called from the UI thread.");
        this.zzgfm.zzb(new zzcqm(this, zzzp));
    }

    public final Bundle getAdMetadata() {
        Preconditions.checkMainThread("getAdMetadata can only be called from the UI thread.");
        if (!this.zzgfg || this.zzfsq == null) {
            return new Bundle();
        }
        return this.zzfsq.getAdMetadata();
    }

    /* access modifiers changed from: package-private */
    public final void zzalg() {
        this.zzgfg = true;
    }

    /* access modifiers changed from: package-private */
    public final void zzalh() {
        this.zzgfm.onAdMetadataChanged();
    }

    public final synchronized void setUserId(String str) throws RemoteException {
        Preconditions.checkMainThread("setUserId must be called on the main UI thread.");
        this.zzgds.zzfu(str);
    }

    public final synchronized void setCustomData(String str) throws RemoteException {
        if (((Boolean) zzyt.zzpe().zzd(zzacu.zzcow)).booleanValue()) {
            Preconditions.checkMainThread("#008 Must be called on the main UI thread.: setCustomData");
            this.zzgds.zzfv(str);
        }
    }

    public final synchronized void setImmersiveMode(boolean z) {
        Preconditions.checkMainThread("setImmersiveMode must be called on the main UI thread.");
        this.zzgez = z;
    }

    private final synchronized boolean zzalf() {
        return this.zzgfc != null && !this.zzgfc.isClosed();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzali() {
        this.zzgfl.onAdFailedToLoad(1);
    }
}
