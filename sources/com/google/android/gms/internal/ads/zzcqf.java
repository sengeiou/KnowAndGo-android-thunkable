package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.reward.AdMetadataListener;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbqy;
import com.google.android.gms.internal.ads.zzbtv;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

public final class zzcqf extends zzatu {
    private final String zzchk;
    @Nullable
    private zzbss zzfsq;
    private final zzbjm zzgbc;
    @GuardedBy("this")
    private final zzcxx zzgds;
    /* access modifiers changed from: private */
    @GuardedBy("this")
    @Nullable
    public zzbbh<zzcdb> zzgek;
    /* access modifiers changed from: private */
    @GuardedBy("this")
    @Nullable
    public zzcdb zzgfc;
    private final zzcqa zzgfd = new zzcqa();
    private final zzcqb zzgfe = new zzcqb();
    private final zzcpz zzgff = new zzcpz();
    /* access modifiers changed from: private */
    public boolean zzgfg = false;
    private final Context zzlj;

    public zzcqf(zzbjm zzbjm, Context context, String str) {
        zzcxx zzcxx = new zzcxx();
        zzcxx.zzglj.add("new_rewarded");
        this.zzgds = zzcxx;
        this.zzgbc = zzbjm;
        this.zzlj = context;
        this.zzchk = str;
    }

    public final synchronized void zza(zzxz zzxz, zzaub zzaub) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        this.zzgfe.zza(zzaub);
        this.zzgfg = false;
        if (this.zzgek == null) {
            if (this.zzgfc == null) {
                zzcya.zze(this.zzlj, zzxz.zzcgq);
                zzcdf zzaeh = this.zzgbc.zzacm().zzd(new zzbqy.zza().zzbt(this.zzlj).zza(this.zzgds.zzft(this.zzchk).zzd(zzyd.zzou()).zzg(zzxz).zzamq()).zzagh()).zzd(new zzbtv.zza().zza((zzbrl) this.zzgfd, this.zzgbc.zzace()).zza((zzbsr) new zzcqi(this, this.zzgfe), this.zzgbc.zzace()).zza((zzbro) this.zzgfe, this.zzgbc.zzace()).zza((zzbrs) this.zzgfd, this.zzgbc.zzace()).zza((AdMetadataListener) this.zzgff, this.zzgbc.zzace()).zza((AppEventListener) new zzcpy(), this.zzgbc.zzace()).zzagt()).zzaeh();
                this.zzfsq = zzaeh.zzaei();
                this.zzgek = zzaeh.zzadu();
                zzbar.zza(this.zzgek, new zzcqg(this, zzaeh), this.zzgbc.zzace());
            }
        }
    }

    public final synchronized void zzj(IObjectWrapper iObjectWrapper) throws RemoteException {
        zza(iObjectWrapper, false);
    }

    public final synchronized void zza(IObjectWrapper iObjectWrapper, boolean z) throws RemoteException {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        if (this.zzgfc == null) {
            zzawz.zzep("Rewarded can not be shown before loaded");
            this.zzgfd.zzcs(2);
            return;
        }
        this.zzgfc.zzb(z, (Activity) ObjectWrapper.unwrap(iObjectWrapper));
    }

    public final synchronized String getMediationAdapterClassName() throws RemoteException {
        if (this.zzgfc == null) {
            return null;
        }
        return this.zzgfc.getMediationAdapterClassName();
    }

    public final boolean isLoaded() throws RemoteException {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        return this.zzgfg;
    }

    public final void zza(zzatw zzatw) throws RemoteException {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        this.zzgfd.zzb(zzatw);
    }

    public final void zza(zzaue zzaue) throws RemoteException {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        this.zzgfd.zzb(zzaue);
    }

    public final void zza(zzaao zzaao) throws RemoteException {
        this.zzgff.zzb(new zzcqh(this, zzaao));
    }

    public final Bundle getAdMetadata() throws RemoteException {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        if (!this.zzgfg || this.zzfsq == null) {
            return new Bundle();
        }
        return this.zzfsq.getAdMetadata();
    }

    @Nullable
    public final zzatq zzqh() {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        if (!this.zzgfg || this.zzgfc == null) {
            return null;
        }
        return this.zzgfc.zzqh();
    }

    /* access modifiers changed from: package-private */
    public final void zzalg() {
        this.zzgfg = true;
    }

    /* access modifiers changed from: package-private */
    public final void zzalh() {
        this.zzgff.onAdMetadataChanged();
    }

    public final synchronized void zza(zzaum zzaum) throws RemoteException {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        this.zzgds.zzfu(zzaum.zzdqs);
        if (((Boolean) zzyt.zzpe().zzd(zzacu.zzcow)).booleanValue()) {
            this.zzgds.zzfv(zzaum.zzdqt);
        }
    }
}
