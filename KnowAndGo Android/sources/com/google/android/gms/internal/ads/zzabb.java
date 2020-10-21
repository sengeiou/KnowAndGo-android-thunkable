package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.Correlator;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.doubleclick.OnCustomRenderedAdLoadedListener;
import com.google.android.gms.ads.zzb;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.concurrent.atomic.AtomicBoolean;

@zzard
public final class zzabb {
    private final zzyc zzaaj;
    private VideoOptions zzbqg;
    private boolean zzbqn;
    private AppEventListener zzbqp;
    private zzxr zzcgi;
    private AdListener zzcgl;
    private AdSize[] zzchj;
    private String zzchk;
    private final zzamo zzcjc;
    private final AtomicBoolean zzcjd;
    /* access modifiers changed from: private */
    public final VideoController zzcje;
    @VisibleForTesting
    private final zzyv zzcjf;
    private Correlator zzcjg;
    private zzzk zzcjh;
    private OnCustomRenderedAdLoadedListener zzcji;
    private ViewGroup zzcjj;
    private int zzcjk;

    private static boolean zzcp(int i) {
        return i == 1;
    }

    public zzabb(ViewGroup viewGroup) {
        this(viewGroup, (AttributeSet) null, false, zzyc.zzche, 0);
    }

    public zzabb(ViewGroup viewGroup, int i) {
        this(viewGroup, (AttributeSet) null, false, zzyc.zzche, i);
    }

    public zzabb(ViewGroup viewGroup, AttributeSet attributeSet, boolean z) {
        this(viewGroup, attributeSet, z, zzyc.zzche, 0);
    }

    public zzabb(ViewGroup viewGroup, AttributeSet attributeSet, boolean z, int i) {
        this(viewGroup, attributeSet, false, zzyc.zzche, i);
    }

    @VisibleForTesting
    private zzabb(ViewGroup viewGroup, AttributeSet attributeSet, boolean z, zzyc zzyc, zzzk zzzk, int i) {
        this.zzcjc = new zzamo();
        this.zzcje = new VideoController();
        this.zzcjf = new zzabc(this);
        this.zzcjj = viewGroup;
        this.zzaaj = zzyc;
        this.zzcjh = null;
        this.zzcjd = new AtomicBoolean(false);
        this.zzcjk = i;
        if (attributeSet != null) {
            Context context = viewGroup.getContext();
            try {
                zzyg zzyg = new zzyg(context, attributeSet);
                this.zzchj = zzyg.zzs(z);
                this.zzchk = zzyg.getAdUnitId();
                if (viewGroup.isInEditMode()) {
                    zzazt zzpa = zzyt.zzpa();
                    AdSize adSize = this.zzchj[0];
                    int i2 = this.zzcjk;
                    zzyd zzyd = new zzyd(context, adSize);
                    zzyd.zzchi = zzcp(i2);
                    zzpa.zza(viewGroup, zzyd, "Ads by Google");
                }
            } catch (IllegalArgumentException e) {
                zzyt.zzpa().zza(viewGroup, new zzyd(context, AdSize.BANNER), e.getMessage(), e.getMessage());
            }
        }
    }

    @VisibleForTesting
    private zzabb(ViewGroup viewGroup, AttributeSet attributeSet, boolean z, zzyc zzyc, int i) {
        this(viewGroup, attributeSet, z, zzyc, (zzzk) null, i);
    }

    public final void destroy() {
        try {
            if (this.zzcjh != null) {
                this.zzcjh.destroy();
            }
        } catch (RemoteException e) {
            zzbad.zze("#007 Could not call remote method.", e);
        }
    }

    public final AdListener getAdListener() {
        return this.zzcgl;
    }

    public final AdSize getAdSize() {
        zzyd zzpn;
        try {
            if (!(this.zzcjh == null || (zzpn = this.zzcjh.zzpn()) == null)) {
                return zzb.zza(zzpn.width, zzpn.height, zzpn.zzaap);
            }
        } catch (RemoteException e) {
            zzbad.zze("#007 Could not call remote method.", e);
        }
        if (this.zzchj != null) {
            return this.zzchj[0];
        }
        return null;
    }

    public final AdSize[] getAdSizes() {
        return this.zzchj;
    }

    public final String getAdUnitId() {
        if (this.zzchk == null && this.zzcjh != null) {
            try {
                this.zzchk = this.zzcjh.getAdUnitId();
            } catch (RemoteException e) {
                zzbad.zze("#007 Could not call remote method.", e);
            }
        }
        return this.zzchk;
    }

    public final AppEventListener getAppEventListener() {
        return this.zzbqp;
    }

    public final OnCustomRenderedAdLoadedListener getOnCustomRenderedAdLoadedListener() {
        return this.zzcji;
    }

    public final void zza(zzaaz zzaaz) {
        zzzk zzzk;
        try {
            if (this.zzcjh == null) {
                if ((this.zzchj == null || this.zzchk == null) && this.zzcjh == null) {
                    throw new IllegalStateException("The ad size and ad unit ID must be set before loadAd is called.");
                }
                Context context = this.zzcjj.getContext();
                zzyd zza = zza(context, this.zzchj, this.zzcjk);
                if ("search_v2".equals(zza.zzaap)) {
                    zzzk = (zzzk) new zzyk(zzyt.zzpb(), context, zza, this.zzchk).zzd(context, false);
                } else {
                    zzzk = (zzzk) new zzyi(zzyt.zzpb(), context, zza, this.zzchk, this.zzcjc).zzd(context, false);
                }
                this.zzcjh = zzzk;
                this.zzcjh.zzb((zzyz) new zzxv(this.zzcjf));
                if (this.zzcgi != null) {
                    this.zzcjh.zza((zzyw) new zzxs(this.zzcgi));
                }
                if (this.zzbqp != null) {
                    this.zzcjh.zza((zzzs) new zzyf(this.zzbqp));
                }
                if (this.zzcji != null) {
                    this.zzcjh.zza((zzado) new zzadr(this.zzcji));
                }
                if (this.zzcjg != null) {
                    this.zzcjh.zzb((zzzy) this.zzcjg.zzdf());
                }
                if (this.zzbqg != null) {
                    this.zzcjh.zza(new zzacd(this.zzbqg));
                }
                this.zzcjh.setManualImpressionsEnabled(this.zzbqn);
                try {
                    IObjectWrapper zzpl = this.zzcjh.zzpl();
                    if (zzpl != null) {
                        this.zzcjj.addView((View) ObjectWrapper.unwrap(zzpl));
                    }
                } catch (RemoteException e) {
                    zzbad.zze("#007 Could not call remote method.", e);
                }
            }
            if (this.zzcjh.zzb(zzyc.zza(this.zzcjj.getContext(), zzaaz))) {
                this.zzcjc.zzf(zzaaz.zzqa());
            }
        } catch (RemoteException e2) {
            zzbad.zze("#007 Could not call remote method.", e2);
        }
    }

    public final void pause() {
        try {
            if (this.zzcjh != null) {
                this.zzcjh.pause();
            }
        } catch (RemoteException e) {
            zzbad.zze("#007 Could not call remote method.", e);
        }
    }

    public final void recordManualImpression() {
        if (!this.zzcjd.getAndSet(true)) {
            try {
                if (this.zzcjh != null) {
                    this.zzcjh.zzpm();
                }
            } catch (RemoteException e) {
                zzbad.zze("#007 Could not call remote method.", e);
            }
        }
    }

    public final void resume() {
        try {
            if (this.zzcjh != null) {
                this.zzcjh.resume();
            }
        } catch (RemoteException e) {
            zzbad.zze("#007 Could not call remote method.", e);
        }
    }

    public final void setAdListener(AdListener adListener) {
        this.zzcgl = adListener;
        this.zzcjf.zza(adListener);
    }

    public final void zza(zzxr zzxr) {
        try {
            this.zzcgi = zzxr;
            if (this.zzcjh != null) {
                this.zzcjh.zza((zzyw) zzxr != null ? new zzxs(zzxr) : null);
            }
        } catch (RemoteException e) {
            zzbad.zze("#007 Could not call remote method.", e);
        }
    }

    public final void setAdSizes(AdSize... adSizeArr) {
        if (this.zzchj == null) {
            zza(adSizeArr);
            return;
        }
        throw new IllegalStateException("The ad size can only be set once on AdView.");
    }

    public final void zza(AdSize... adSizeArr) {
        this.zzchj = adSizeArr;
        try {
            if (this.zzcjh != null) {
                this.zzcjh.zza(zza(this.zzcjj.getContext(), this.zzchj, this.zzcjk));
            }
        } catch (RemoteException e) {
            zzbad.zze("#007 Could not call remote method.", e);
        }
        this.zzcjj.requestLayout();
    }

    public final void setAdUnitId(String str) {
        if (this.zzchk == null) {
            this.zzchk = str;
            return;
        }
        throw new IllegalStateException("The ad unit ID can only be set once on AdView.");
    }

    public final void setAppEventListener(AppEventListener appEventListener) {
        try {
            this.zzbqp = appEventListener;
            if (this.zzcjh != null) {
                this.zzcjh.zza((zzzs) appEventListener != null ? new zzyf(appEventListener) : null);
            }
        } catch (RemoteException e) {
            zzbad.zze("#007 Could not call remote method.", e);
        }
    }

    public final void setOnCustomRenderedAdLoadedListener(OnCustomRenderedAdLoadedListener onCustomRenderedAdLoadedListener) {
        this.zzcji = onCustomRenderedAdLoadedListener;
        try {
            if (this.zzcjh != null) {
                this.zzcjh.zza((zzado) onCustomRenderedAdLoadedListener != null ? new zzadr(onCustomRenderedAdLoadedListener) : null);
            }
        } catch (RemoteException e) {
            zzbad.zze("#007 Could not call remote method.", e);
        }
    }

    public final void setManualImpressionsEnabled(boolean z) {
        this.zzbqn = z;
        try {
            if (this.zzcjh != null) {
                this.zzcjh.setManualImpressionsEnabled(this.zzbqn);
            }
        } catch (RemoteException e) {
            zzbad.zze("#007 Could not call remote method.", e);
        }
    }

    public final void setCorrelator(Correlator correlator) {
        this.zzcjg = correlator;
        try {
            if (this.zzcjh != null) {
                this.zzcjh.zzb((zzzy) this.zzcjg == null ? null : this.zzcjg.zzdf());
            }
        } catch (RemoteException e) {
            zzbad.zze("#007 Could not call remote method.", e);
        }
    }

    public final String getMediationAdapterClassName() {
        try {
            if (this.zzcjh != null) {
                return this.zzcjh.zzpj();
            }
            return null;
        } catch (RemoteException e) {
            zzbad.zze("#007 Could not call remote method.", e);
            return null;
        }
    }

    public final boolean isLoading() {
        try {
            if (this.zzcjh != null) {
                return this.zzcjh.isLoading();
            }
            return false;
        } catch (RemoteException e) {
            zzbad.zze("#007 Could not call remote method.", e);
            return false;
        }
    }

    public final VideoController getVideoController() {
        return this.zzcje;
    }

    public final zzaar zzdh() {
        if (this.zzcjh == null) {
            return null;
        }
        try {
            return this.zzcjh.getVideoController();
        } catch (RemoteException e) {
            zzbad.zze("#007 Could not call remote method.", e);
            return null;
        }
    }

    public final void setVideoOptions(VideoOptions videoOptions) {
        zzacd zzacd;
        this.zzbqg = videoOptions;
        try {
            if (this.zzcjh != null) {
                zzzk zzzk = this.zzcjh;
                if (videoOptions == null) {
                    zzacd = null;
                } else {
                    zzacd = new zzacd(videoOptions);
                }
                zzzk.zza(zzacd);
            }
        } catch (RemoteException e) {
            zzbad.zze("#007 Could not call remote method.", e);
        }
    }

    public final VideoOptions getVideoOptions() {
        return this.zzbqg;
    }

    public final boolean zza(zzzk zzzk) {
        if (zzzk == null) {
            return false;
        }
        try {
            IObjectWrapper zzpl = zzzk.zzpl();
            if (zzpl == null || ((View) ObjectWrapper.unwrap(zzpl)).getParent() != null) {
                return false;
            }
            this.zzcjj.addView((View) ObjectWrapper.unwrap(zzpl));
            this.zzcjh = zzzk;
            return true;
        } catch (RemoteException e) {
            zzbad.zze("#007 Could not call remote method.", e);
            return false;
        }
    }

    private static zzyd zza(Context context, AdSize[] adSizeArr, int i) {
        zzyd zzyd = new zzyd(context, adSizeArr);
        zzyd.zzchi = zzcp(i);
        return zzyd;
    }
}
