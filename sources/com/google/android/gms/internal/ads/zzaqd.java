package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import android.webkit.WebView;
import androidx.annotation.Nullable;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import javax.annotation.concurrent.GuardedBy;

@zzard
public final class zzaqd {
    private static final Object lock = new Object();
    @GuardedBy("lock")
    @VisibleForTesting
    private static boolean zzdje = false;
    @GuardedBy("lock")
    @VisibleForTesting
    private static boolean zzxs = false;
    @VisibleForTesting
    private zzdah zzdjf;

    public final boolean zzl(Context context) {
        synchronized (lock) {
            if (!((Boolean) zzyt.zzpe().zzd(zzacu.zzcuu)).booleanValue()) {
                return false;
            }
            if (zzxs) {
                return true;
            }
            try {
                zzm(context);
                boolean zzap = this.zzdjf.zzap(ObjectWrapper.wrap(context));
                zzxs = zzap;
                return zzap;
            } catch (RemoteException | NullPointerException e) {
                zzbad.zze("#007 Could not call remote method.", e);
                return false;
            }
        }
    }

    @VisibleForTesting
    private final void zzm(Context context) {
        synchronized (lock) {
            if (((Boolean) zzyt.zzpe().zzd(zzacu.zzcuu)).booleanValue() && !zzdje) {
                try {
                    zzdje = true;
                    this.zzdjf = (zzdah) zzbae.zza(context, "com.google.android.gms.ads.omid.DynamiteOmid", zzaqe.zzbzd);
                } catch (zzbag e) {
                    zzbad.zze("#007 Could not call remote method.", e);
                }
            }
        }
    }

    @Nullable
    public final String getVersion(Context context) {
        if (!((Boolean) zzyt.zzpe().zzd(zzacu.zzcuu)).booleanValue()) {
            return null;
        }
        try {
            zzm(context);
            String valueOf = String.valueOf(this.zzdjf.getVersion());
            return valueOf.length() != 0 ? "a.".concat(valueOf) : new String("a.");
        } catch (RemoteException | NullPointerException e) {
            zzbad.zze("#007 Could not call remote method.", e);
            return null;
        }
    }

    @Nullable
    public final IObjectWrapper zza(String str, WebView webView, String str2, String str3, String str4) {
        return zza(str, webView, str2, str3, str4, "Google");
    }

    @Nullable
    public final IObjectWrapper zza(String str, WebView webView, String str2, String str3, String str4, String str5) {
        synchronized (lock) {
            try {
                if (((Boolean) zzyt.zzpe().zzd(zzacu.zzcuu)).booleanValue()) {
                    if (zzxs) {
                        try {
                            return this.zzdjf.zza(str, ObjectWrapper.wrap(webView), str2, str3, str4, str5);
                        } catch (RemoteException | NullPointerException e) {
                            zzbad.zze("#007 Could not call remote method.", e);
                            return null;
                        }
                    }
                }
                return null;
            } catch (Throwable th) {
                th = th;
                throw th;
            }
        }
    }

    public final void zzaa(IObjectWrapper iObjectWrapper) {
        synchronized (lock) {
            if (((Boolean) zzyt.zzpe().zzd(zzacu.zzcuu)).booleanValue()) {
                if (zzxs) {
                    try {
                        this.zzdjf.zzaa(iObjectWrapper);
                    } catch (RemoteException | NullPointerException e) {
                        zzbad.zze("#007 Could not call remote method.", e);
                    }
                }
            }
        }
    }

    public final void zzab(IObjectWrapper iObjectWrapper) {
        synchronized (lock) {
            if (((Boolean) zzyt.zzpe().zzd(zzacu.zzcuu)).booleanValue()) {
                if (zzxs) {
                    try {
                        this.zzdjf.zzab(iObjectWrapper);
                    } catch (RemoteException | NullPointerException e) {
                        zzbad.zze("#007 Could not call remote method.", e);
                    }
                }
            }
        }
    }

    public final void zza(IObjectWrapper iObjectWrapper, View view) {
        synchronized (lock) {
            if (((Boolean) zzyt.zzpe().zzd(zzacu.zzcuu)).booleanValue()) {
                if (zzxs) {
                    try {
                        this.zzdjf.zzd(iObjectWrapper, ObjectWrapper.wrap(view));
                    } catch (RemoteException | NullPointerException e) {
                        zzbad.zze("#007 Could not call remote method.", e);
                    }
                }
            }
        }
    }
}
