package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.reward.RewardItem;

@zzard
public final class zzate implements RewardItem {
    private final zzasr zzdqp;

    public zzate(zzasr zzasr) {
        this.zzdqp = zzasr;
    }

    public final String getType() {
        if (this.zzdqp == null) {
            return null;
        }
        try {
            return this.zzdqp.getType();
        } catch (RemoteException e) {
            zzbad.zzd("Could not forward getType to RewardItem", e);
            return null;
        }
    }

    public final int getAmount() {
        if (this.zzdqp == null) {
            return 0;
        }
        try {
            return this.zzdqp.getAmount();
        } catch (RemoteException e) {
            zzbad.zzd("Could not forward getAmount to RewardItem", e);
            return 0;
        }
    }
}
