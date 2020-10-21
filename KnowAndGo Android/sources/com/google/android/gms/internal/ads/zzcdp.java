package com.google.android.gms.internal.ads;

import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.ads.internal.zzb;
import java.util.Map;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

public final class zzcdp {
    private final zzavb zzbqw;
    private final zzdh zzeko;
    private final Executor zzffv;
    /* access modifiers changed from: private */
    public final zzbse zzfjg;
    private final zzbsv zzflp;
    private final zzbri zzfms;
    private final zzbmn zzfmt;
    private final zzbva zzfmv;
    private final zzbss zzfsq;
    private final zzbtp zzfsr;
    private final zzb zzfti;
    private final zzbry zzftj;
    /* access modifiers changed from: private */
    public final zzbtl zzftk;

    public zzcdp(zzbri zzbri, zzbse zzbse, zzbss zzbss, zzbsv zzbsv, zzbtp zzbtp, Executor executor, zzbva zzbva, zzbmn zzbmn, zzb zzb, zzbry zzbry, @Nullable zzavb zzavb, zzdh zzdh, zzbtl zzbtl) {
        this.zzfms = zzbri;
        this.zzfjg = zzbse;
        this.zzfsq = zzbss;
        this.zzflp = zzbsv;
        this.zzfsr = zzbtp;
        this.zzffv = executor;
        this.zzfmv = zzbva;
        this.zzfmt = zzbmn;
        this.zzfti = zzb;
        this.zzftj = zzbry;
        this.zzbqw = zzavb;
        this.zzeko = zzdh;
        this.zzftk = zzbtl;
    }

    public final void zzb(zzbgz zzbgz, boolean z) {
        zzdc zzcg;
        zzbgz.zzaai().zza(new zzcdq(this), this.zzfsq, this.zzflp, new zzcdr(this), new zzcds(this), z, (zzahp) null, this.zzfti, new zzcdz(this), this.zzbqw);
        zzbgz.setOnTouchListener(new zzcdt(this));
        zzbgz.setOnClickListener(new zzcdu(this));
        if (((Boolean) zzyt.zzpe().zzd(zzacu.zzcrg)).booleanValue() && (zzcg = this.zzeko.zzcg()) != null) {
            zzcg.zzb(zzbgz.getView());
        }
        this.zzfmv.zza(zzbgz, this.zzffv);
        this.zzfmv.zza(new zzcdv(zzbgz), this.zzffv);
        this.zzfmv.zzq(zzbgz.getView());
        zzbgz.zza("/trackActiveViewUnit", (zzaho<? super zzbgz>) new zzcdw(this, zzbgz));
        this.zzfmt.zzq(zzbgz);
        this.zzftj.zza(new zzcdx(zzbgz), this.zzffv);
    }

    public static zzbbh<?> zza(zzbgz zzbgz, String str, String str2) {
        zzbbr zzbbr = new zzbbr();
        zzbgz.zzaai().zza((zzbij) new zzcdy(zzbbr));
        zzbgz.zzb(str, str2, (String) null);
        return zzbbr;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(zzbgz zzbgz, zzbgz zzbgz2, Map map) {
        this.zzfmt.zzf(zzbgz);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzab(View view) {
        this.zzfti.recordClick();
        if (this.zzbqw != null) {
            this.zzbqw.zzue();
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ boolean zza(View view, MotionEvent motionEvent) {
        this.zzfti.recordClick();
        if (this.zzbqw == null) {
            return false;
        }
        this.zzbqw.zzue();
        return false;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzajm() {
        this.zzfjg.onAdLeftApplication();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzr(String str, String str2) {
        this.zzfsr.onAppEvent(str, str2);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzajn() {
        this.zzfms.onAdClicked();
    }
}
