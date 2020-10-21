package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Collections;

public final class zzcbw extends zzajb implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener, zzadv {
    private boolean zzeky = false;
    private zzaar zzfoh;
    private View zzfom;
    private zzbyn zzfpj;
    private boolean zzfsb = false;

    public zzcbw(zzbyn zzbyn, zzbyt zzbyt) {
        this.zzfom = zzbyt.zzahy();
        this.zzfoh = zzbyt.getVideoController();
        this.zzfpj = zzbyn;
        if (zzbyt.zzahz() != null) {
            zzbyt.zzahz().zza((zzadv) this);
        }
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzajc zzajc) throws RemoteException {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        if (this.zzeky) {
            zzawz.zzen("Instream ad is destroyed already.");
            zza(zzajc, 2);
        } else if (this.zzfom == null || this.zzfoh == null) {
            String valueOf = String.valueOf(this.zzfom == null ? "can not get video view." : "can not get video controller.");
            zzawz.zzen(valueOf.length() != 0 ? "Instream internal error: ".concat(valueOf) : new String("Instream internal error: "));
            zza(zzajc, 0);
        } else if (this.zzfsb) {
            zzawz.zzen("Instream ad should not be used again.");
            zza(zzajc, 1);
        } else {
            this.zzfsb = true;
            zzajf();
            ((ViewGroup) ObjectWrapper.unwrap(iObjectWrapper)).addView(this.zzfom, new ViewGroup.LayoutParams(-1, -1));
            zzk.zzmd();
            zzbbz.zza(this.zzfom, (ViewTreeObserver.OnGlobalLayoutListener) this);
            zzk.zzmd();
            zzbbz.zza(this.zzfom, (ViewTreeObserver.OnScrollChangedListener) this);
            zzajg();
            try {
                zzajc.zzrt();
            } catch (RemoteException e) {
                zzawz.zze("#007 Could not call remote method.", e);
            }
        }
    }

    public final zzaar getVideoController() throws RemoteException {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        if (!this.zzeky) {
            return this.zzfoh;
        }
        zzawz.zzen("getVideoController: Instream ad should not be used after destroyed");
        return null;
    }

    public final void destroy() throws RemoteException {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzajf();
        if (this.zzfpj != null) {
            this.zzfpj.destroy();
        }
        this.zzfpj = null;
        this.zzfom = null;
        this.zzfoh = null;
        this.zzeky = true;
    }

    private final void zzajf() {
        if (this.zzfom != null) {
            ViewParent parent = this.zzfom.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.zzfom);
            }
        }
    }

    public final void onGlobalLayout() {
        zzajg();
    }

    public final void onScrollChanged() {
        zzajg();
    }

    public final void zzre() {
        zzaxi.zzdvv.post(new zzcbx(this));
    }

    private final void zzajg() {
        if (this.zzfpj != null && this.zzfom != null) {
            this.zzfpj.zzb(this.zzfom, Collections.emptyMap(), Collections.emptyMap(), zzbyn.zzx(this.zzfom));
        }
    }

    private static void zza(zzajc zzajc, int i) {
        try {
            zzajc.zzcq(i);
        } catch (RemoteException e) {
            zzawz.zze("#007 Could not call remote method.", e);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzajh() {
        try {
            destroy();
        } catch (RemoteException e) {
            zzawz.zze("#007 Could not call remote method.", e);
        }
    }
}
