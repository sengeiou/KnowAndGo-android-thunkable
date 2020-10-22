package com.google.android.gms.ads.formats;

import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzaer;
import com.google.android.gms.internal.ads.zzbad;
import com.google.android.gms.internal.ads.zzyt;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

public final class NativeAdViewHolder {
    public static WeakHashMap<View, NativeAdViewHolder> zzbql = new WeakHashMap<>();
    private zzaer zzbqk;
    private WeakReference<View> zzbqm;

    public NativeAdViewHolder(View view, Map<String, View> map, Map<String, View> map2) {
        Preconditions.checkNotNull(view, "ContainerView must not be null");
        if ((view instanceof NativeAdView) || (view instanceof UnifiedNativeAdView)) {
            zzbad.zzen("The provided containerView is of type of NativeAdView, which cannot be usedwith NativeAdViewHolder.");
        } else if (zzbql.get(view) != null) {
            zzbad.zzen("The provided containerView is already in use with another NativeAdViewHolder.");
        } else {
            zzbql.put(view, this);
            this.zzbqm = new WeakReference<>(view);
            this.zzbqk = zzyt.zzpb().zza(view, zzb(map), zzb(map2));
        }
    }

    private static HashMap<String, View> zzb(Map<String, View> map) {
        if (map == null) {
            return new HashMap<>();
        }
        return new HashMap<>(map);
    }

    public final void setNativeAd(NativeAd nativeAd) {
        zze((IObjectWrapper) nativeAd.zzkq());
    }

    public final void setNativeAd(UnifiedNativeAd unifiedNativeAd) {
        zze((IObjectWrapper) unifiedNativeAd.zzkq());
    }

    private final void zze(IObjectWrapper iObjectWrapper) {
        View view = this.zzbqm != null ? (View) this.zzbqm.get() : null;
        if (view == null) {
            zzbad.zzep("NativeAdViewHolder.setNativeAd containerView doesn't exist, returning");
            return;
        }
        if (!zzbql.containsKey(view)) {
            zzbql.put(view, this);
        }
        if (this.zzbqk != null) {
            try {
                this.zzbqk.zze(iObjectWrapper);
            } catch (RemoteException e) {
                zzbad.zzc("Unable to call setNativeAd on delegate", e);
            }
        }
    }

    public final void unregisterNativeAd() {
        if (this.zzbqk != null) {
            try {
                this.zzbqk.unregisterNativeAd();
            } catch (RemoteException e) {
                zzbad.zzc("Unable to call unregisterNativeAd on delegate", e);
            }
        }
        View view = this.zzbqm != null ? (View) this.zzbqm.get() : null;
        if (view != null) {
            zzbql.remove(view);
        }
    }

    public final void setClickConfirmingView(View view) {
        try {
            this.zzbqk.zzi(ObjectWrapper.wrap(view));
        } catch (RemoteException e) {
            zzbad.zzc("Unable to call setClickConfirmingView on delegate", e);
        }
    }
}
