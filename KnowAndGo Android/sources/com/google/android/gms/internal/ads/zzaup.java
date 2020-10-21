package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.rewarded.RewardItem;
import javax.annotation.Nullable;

public final class zzaup extends zzatr {
    private final String type;
    private final int zzdqm;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public zzaup(@Nullable zzato zzato) {
        this(zzato != null ? zzato.type : "", zzato != null ? zzato.zzdqm : 1);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public zzaup(@Nullable RewardItem rewardItem) {
        this(rewardItem != null ? rewardItem.getType() : "", rewardItem != null ? rewardItem.getAmount() : 1);
    }

    public zzaup(String str, int i) {
        this.type = str;
        this.zzdqm = i;
    }

    public final String getType() throws RemoteException {
        return this.type;
    }

    public final int getAmount() throws RemoteException {
        return this.zzdqm;
    }
}
