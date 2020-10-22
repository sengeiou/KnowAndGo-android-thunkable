package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public final class zzcae implements zzbzb {
    private final zzbai zzbtc;
    private final zzcxm zzfig;
    private final zzcxv zzfjp;
    private final zzbrt zzfmr;
    private final zzbri zzfms;
    private boolean zzfmw = false;
    private boolean zzfmz = false;
    @Nullable
    private final zzana zzfqm;
    @Nullable
    private final zzand zzfqn;
    @Nullable
    private final zzang zzfqo;
    private final Context zzlj;

    public zzcae(@Nullable zzana zzana, @Nullable zzand zzand, @Nullable zzang zzang, zzbrt zzbrt, zzbri zzbri, Context context, zzcxm zzcxm, zzbai zzbai, zzcxv zzcxv) {
        this.zzfqm = zzana;
        this.zzfqn = zzand;
        this.zzfqo = zzang;
        this.zzfmr = zzbrt;
        this.zzfms = zzbri;
        this.zzlj = context;
        this.zzfig = zzcxm;
        this.zzbtc = zzbai;
        this.zzfjp = zzcxv;
    }

    public final void cancelUnconfirmedClick() {
    }

    public final void destroy() {
    }

    public final void setClickConfirmingView(View view) {
    }

    public final void zza(View view, MotionEvent motionEvent, @Nullable View view2) {
    }

    public final void zza(zzagd zzagd) {
    }

    public final void zzahk() {
    }

    public final void zzahm() {
    }

    public final void zzf(Bundle bundle) {
    }

    public final void zzfi(String str) {
    }

    public final void zzg(Bundle bundle) {
    }

    public final boolean zzh(Bundle bundle) {
        return false;
    }

    public final void zza(View view, @Nullable Map<String, WeakReference<View>> map, @Nullable Map<String, WeakReference<View>> map2, View.OnTouchListener onTouchListener, View.OnClickListener onClickListener) {
        try {
            IObjectWrapper wrap = ObjectWrapper.wrap(view);
            HashMap<String, View> zzb = zzb(map);
            HashMap<String, View> zzb2 = zzb(map2);
            if (this.zzfqo != null) {
                this.zzfqo.zzc(wrap, ObjectWrapper.wrap(zzb), ObjectWrapper.wrap(zzb2));
            } else if (this.zzfqm != null) {
                this.zzfqm.zzc(wrap, ObjectWrapper.wrap(zzb), ObjectWrapper.wrap(zzb2));
                this.zzfqm.zzu(wrap);
            } else if (this.zzfqn != null) {
                this.zzfqn.zzc(wrap, ObjectWrapper.wrap(zzb), ObjectWrapper.wrap(zzb2));
                this.zzfqn.zzu(wrap);
            }
        } catch (RemoteException e) {
            zzawz.zzd("Failed to call trackView", e);
        }
    }

    private static HashMap<String, View> zzb(Map<String, WeakReference<View>> map) {
        HashMap<String, View> hashMap = new HashMap<>();
        if (map == null) {
            return hashMap;
        }
        synchronized (map) {
            for (Map.Entry next : map.entrySet()) {
                View view = (View) ((WeakReference) next.getValue()).get();
                if (view != null) {
                    hashMap.put((String) next.getKey(), view);
                }
            }
        }
        return hashMap;
    }

    public final void zza(View view, @Nullable Map<String, WeakReference<View>> map) {
        try {
            IObjectWrapper wrap = ObjectWrapper.wrap(view);
            if (this.zzfqo != null) {
                this.zzfqo.zzv(wrap);
            } else if (this.zzfqm != null) {
                this.zzfqm.zzv(wrap);
            } else if (this.zzfqn != null) {
                this.zzfqn.zzv(wrap);
            }
        } catch (RemoteException e) {
            zzawz.zzd("Failed to call untrackView", e);
        }
    }

    public final void zza(View view, @Nullable View view2, @Nullable Map<String, WeakReference<View>> map, @Nullable Map<String, WeakReference<View>> map2, boolean z) {
        if (!this.zzfmz || !this.zzfig.zzdft) {
            zzaa(view);
        }
    }

    private final void zzaa(View view) {
        try {
            if (this.zzfqo != null && !this.zzfqo.getOverrideClickHandling()) {
                this.zzfqo.zzt(ObjectWrapper.wrap(view));
                this.zzfms.onAdClicked();
            } else if (this.zzfqm != null && !this.zzfqm.getOverrideClickHandling()) {
                this.zzfqm.zzt(ObjectWrapper.wrap(view));
                this.zzfms.onAdClicked();
            } else if (this.zzfqn != null && !this.zzfqn.getOverrideClickHandling()) {
                this.zzfqn.zzt(ObjectWrapper.wrap(view));
                this.zzfms.onAdClicked();
            }
        } catch (RemoteException e) {
            zzawz.zzd("Failed to call handleClick", e);
        }
    }

    public final void zza(View view, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2, boolean z) {
        if (!this.zzfmz) {
            zzawz.zzep("Custom click reporting for 3p ads failed. enableCustomClickGesture is not set.");
        } else if (!this.zzfig.zzdft) {
            zzawz.zzep("Custom click reporting for 3p ads failed. Ad unit id not whitelisted.");
        } else {
            zzaa(view);
        }
    }

    public final void zzro() {
        this.zzfmz = true;
    }

    public final void zza(@Nullable View view, @Nullable Map<String, WeakReference<View>> map, @Nullable Map<String, WeakReference<View>> map2) {
        try {
            if (!this.zzfmw && this.zzfig.zzgkj != null) {
                this.zzfmw |= zzk.zzlq().zzb(this.zzlj, this.zzbtc.zzbsx, this.zzfig.zzgkj.toString(), this.zzfjp.zzglb);
            }
            if (this.zzfqo != null && !this.zzfqo.getOverrideImpressionRecording()) {
                this.zzfqo.recordImpression();
                this.zzfmr.onAdImpression();
            } else if (this.zzfqm != null && !this.zzfqm.getOverrideImpressionRecording()) {
                this.zzfqm.recordImpression();
                this.zzfmr.onAdImpression();
            } else if (this.zzfqn != null && !this.zzfqn.getOverrideImpressionRecording()) {
                this.zzfqn.recordImpression();
                this.zzfmr.onAdImpression();
            }
        } catch (RemoteException e) {
            zzawz.zzd("Failed to call recordImpression", e);
        }
    }

    public final void zza(@Nullable zzaak zzaak) {
        zzawz.zzep("Mute This Ad is not supported for 3rd party ads");
    }

    public final void zza(zzaag zzaag) {
        zzawz.zzep("Mute This Ad is not supported for 3rd party ads");
    }

    public final void zzahl() {
        zzawz.zzep("Mute This Ad is not supported for 3rd party ads");
    }
}
