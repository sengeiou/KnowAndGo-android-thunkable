package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import javax.annotation.ParametersAreNonnullByDefault;

@TargetApi(16)
@ParametersAreNonnullByDefault
@zzard
public final class zzbdk {
    @VisibleForTesting
    private static int zzefc;
    @VisibleForTesting
    private static int zzefd;
    @Nullable
    private zzge zzefe;
    private zzhd zzeff;
    private zzgn zzefg;
    @Nullable
    private zzbdo zzefh;
    private final zzbdn zzefi = new zzbdn(this);
    private final zzbdp zzefj = new zzbdp(this);
    private final zzbdm zzefk = new zzbdm(this);

    public zzbdk() {
        Preconditions.checkMainThread("ExoPlayer must be created on the main UI thread.");
        if (zzawz.zzvj()) {
            String valueOf = String.valueOf(this);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 29);
            sb.append("AdExoPlayerHelper initialize ");
            sb.append(valueOf);
            zzawz.zzds(sb.toString());
        }
        zzefc++;
        this.zzefe = zzgg.zzn(2);
        this.zzefe.zza((zzgh) this.zzefi);
    }

    public static int zzyp() {
        return zzefc;
    }

    public static int zzyq() {
        return zzefd;
    }

    public final boolean zza(zzhn zzhn) {
        if (this.zzefe == null) {
            return false;
        }
        this.zzeff = new zzhd(zzhn, 1, 0, zzaxi.zzdvv, this.zzefj, -1);
        this.zzefg = new zzgn(zzhn, zzaxi.zzdvv, this.zzefk);
        this.zzefe.zza(this.zzeff, this.zzefg);
        zzefd++;
        return true;
    }

    public final void zzyr() {
        if (this.zzefe != null) {
            this.zzefe.release();
            this.zzefe = null;
            zzefd--;
        }
    }

    public final synchronized void zza(zzbdo zzbdo) {
        this.zzefh = zzbdo;
    }

    public final synchronized void removeListener() {
        this.zzefh = null;
    }

    /* access modifiers changed from: private */
    public final synchronized void zzm(String str, @Nullable String str2) {
        if (this.zzefh != null) {
            this.zzefh.zzl(str, str2);
        }
    }

    @Nullable
    public final zzge zzys() {
        return this.zzefe;
    }

    public final zzhd zzyt() {
        return this.zzeff;
    }

    public final zzgn zzyu() {
        return this.zzefg;
    }

    public final void zza(zzgh zzgh, zzhh zzhh, zzgq zzgq) {
        this.zzefi.zzb(zzgh);
        this.zzefj.zza(zzhh);
        this.zzefk.zza(zzgq);
    }

    public final void finalize() throws Throwable {
        zzefc--;
        if (zzawz.zzvj()) {
            String valueOf = String.valueOf(this);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 27);
            sb.append("AdExoPlayerHelper finalize ");
            sb.append(valueOf);
            zzawz.zzds(sb.toString());
        }
    }
}
