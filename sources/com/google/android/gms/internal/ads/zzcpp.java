package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.internal.ads.zzbqy;
import com.google.android.gms.internal.ads.zzbtv;
import javax.annotation.concurrent.GuardedBy;

public final class zzcpp extends zzzd {
    private final zzbjm zzgbc;
    private final Context zzgdr;
    private final zzcxx zzgds;
    private final zzbzc zzgdu;
    private final zzcpw zzgdv = new zzcpw();
    private final zzbro zzgdw;
    @GuardedBy("this")
    @Nullable
    private zzbpk zzgdx;
    /* access modifiers changed from: private */
    @GuardedBy("this")
    @Nullable
    public String zzgdy;
    /* access modifiers changed from: private */
    @GuardedBy("this")
    @Nullable
    public String zzgdz;

    public zzcpp(Context context, zzbjm zzbjm, zzcxx zzcxx, zzbzc zzbzc, zzyz zzyz) {
        this.zzgdr = context;
        this.zzgbc = zzbjm;
        this.zzgds = zzcxx;
        this.zzgdu = zzbzc;
        this.zzgdv.zzc(zzyz);
        this.zzgdw = new zzcpr(this.zzgdv, zzbzc.zzaim());
    }

    public final synchronized boolean isLoading() throws RemoteException {
        return this.zzgdx != null && this.zzgdx.isLoading();
    }

    public final void zza(zzxz zzxz) {
        zza(zzxz, 1);
    }

    public final synchronized void zza(zzxz zzxz, int i) {
        if (this.zzgds.zzamp() == null) {
            zzawz.zzen("Ad unit ID should not be null for AdLoader.");
            this.zzgbc.zzace().execute(new zzcpq(this));
            return;
        }
        zzcya.zze(this.zzgdr, zzxz.zzcgq);
        this.zzgdy = null;
        this.zzgdz = null;
        zzcxv zzamq = this.zzgds.zzg(zzxz).zzdp(i).zzamq();
        zzbxo zzacy = this.zzgbc.zzacl().zza(new zzbqy.zza().zzbt(this.zzgdr).zza(zzamq).zzagh()).zza(new zzbtv.zza().zza((zzbsr) this.zzgdv, this.zzgbc.zzace()).zza(this.zzgdw, this.zzgbc.zzace()).zza((zzbrw) this.zzgdv, this.zzgbc.zzace()).zza((zzxr) this.zzgdv, this.zzgbc.zzace()).zza((zzbrl) this.zzgdv, this.zzgbc.zzace()).zza(zzamq.zzgli, this.zzgbc.zzace()).zzagt()).zza(new zzbxk(this.zzgdu, this.zzgdv.zzald())).zzacy();
        zzacy.zzadc().zzdq(1);
        this.zzgdx = zzacy.zzacz();
        this.zzgdx.zza((zzban<zzbpc>) new zzcps(this, zzacy));
    }

    public final synchronized String getMediationAdapterClassName() {
        return this.zzgdy;
    }

    public final synchronized String zzpj() {
        return this.zzgdz;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzalc() {
        this.zzgdw.onAdFailedToLoad(1);
    }
}
