package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.internal.ads.zzdap;
import com.google.android.gms.internal.ads.zzdau;

@ShowFirstParty
public final class zzdan {
    private final Looper zzgob;
    private final Context zzlj;

    public zzdan(@NonNull Context context, @NonNull Looper looper) {
        this.zzlj = context;
        this.zzgob = looper;
    }

    public final void zzgb(@NonNull String str) {
        new zzdao(this.zzlj, this.zzgob, (zzdau) ((zzdob) zzdau.zzank().zzge(this.zzlj.getPackageName()).zzb(zzdau.zzb.BLOCKED_IMPRESSION).zzb(zzdap.zzani().zzgd(str).zzb(zzdap.zza.BLOCKED_REASON_BACKGROUND)).zzaya())).zzanh();
    }
}
