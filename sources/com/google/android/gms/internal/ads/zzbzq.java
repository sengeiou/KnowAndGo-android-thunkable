package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.util.Clock;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public final class zzbzq implements View.OnClickListener {
    private final Clock zzbsa;
    private final zzccj zzfpz;
    @Nullable
    private zzagd zzfqa;
    @Nullable
    private zzaho zzfqb;
    @VisibleForTesting
    @Nullable
    String zzfqc;
    @VisibleForTesting
    @Nullable
    Long zzfqd;
    @VisibleForTesting
    @Nullable
    WeakReference<View> zzfqe;

    public zzbzq(zzccj zzccj, Clock clock) {
        this.zzfpz = zzccj;
        this.zzbsa = clock;
    }

    public final void zza(zzagd zzagd) {
        this.zzfqa = zzagd;
        if (this.zzfqb != null) {
            this.zzfpz.zzb("/unconfirmedClick", this.zzfqb);
        }
        this.zzfqb = new zzbzr(this, zzagd);
        this.zzfpz.zza("/unconfirmedClick", (zzaho<Object>) this.zzfqb);
    }

    @Nullable
    public final zzagd zzaiz() {
        return this.zzfqa;
    }

    public final void cancelUnconfirmedClick() {
        if (this.zzfqa != null && this.zzfqd != null) {
            zzaja();
            try {
                this.zzfqa.onUnconfirmedClickCancelled();
            } catch (RemoteException e) {
                zzbad.zze("#007 Could not call remote method.", e);
            }
        }
    }

    public final void onClick(View view) {
        if (this.zzfqe != null && this.zzfqe.get() == view) {
            if (!(this.zzfqc == null || this.zzfqd == null)) {
                HashMap hashMap = new HashMap();
                hashMap.put("id", this.zzfqc);
                hashMap.put("time_interval", String.valueOf(this.zzbsa.currentTimeMillis() - this.zzfqd.longValue()));
                hashMap.put("messageType", "onePointFiveClick");
                this.zzfpz.zza("sendMessageToNativeJs", (Map<String, ?>) hashMap);
            }
            zzaja();
        }
    }

    private final void zzaja() {
        View view;
        this.zzfqc = null;
        this.zzfqd = null;
        if (this.zzfqe != null && (view = (View) this.zzfqe.get()) != null) {
            view.setClickable(false);
            view.setOnClickListener((View.OnClickListener) null);
            this.zzfqe = null;
        }
    }
}
