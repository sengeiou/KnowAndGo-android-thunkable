package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.rewarded.RewardItem;

@zzard
public final class zzauh implements RewardItem {
    private final zzatq zzdqw;

    public zzauh(zzatq zzatq) {
        this.zzdqw = zzatq;
    }

    public final String getType() {
        if (this.zzdqw == null) {
            return null;
        }
        try {
            return this.zzdqw.getType();
        } catch (RemoteException e) {
            zzbad.zzd("Could not forward getType to RewardItem", e);
            return null;
        }
    }

    public final int getAmount() {
        if (this.zzdqw == null) {
            return 0;
        }
        try {
            return this.zzdqw.getAmount();
        } catch (RemoteException e) {
            zzbad.zzd("Could not forward getAmount to RewardItem", e);
            return 0;
        }
    }
}
