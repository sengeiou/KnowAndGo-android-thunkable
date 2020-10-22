package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import java.util.HashSet;
import javax.annotation.concurrent.GuardedBy;

public final class zzcyi implements zzaws, zzbro {
    private final zzawu zzdsw;
    @GuardedBy("this")
    private final HashSet<zzawj> zzglq = new HashSet<>();
    private final Context zzlj;

    public zzcyi(Context context, zzawu zzawu) {
        this.zzlj = context;
        this.zzdsw = zzawu;
    }

    public final synchronized void onAdFailedToLoad(int i) {
        if (i != 3) {
            this.zzdsw.zzb(this.zzglq);
        }
    }

    public final synchronized void zza(HashSet<zzawj> hashSet) {
        this.zzglq.clear();
        this.zzglq.addAll(hashSet);
    }

    public final Bundle zzams() {
        return this.zzdsw.zza(this.zzlj, (zzaws) this);
    }
}
