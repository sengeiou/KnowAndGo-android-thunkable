package com.google.android.gms.internal.ads;

import android.content.pm.PackageInfo;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

public final class zzcvu implements zzcva<zzcvt> {
    @Nullable
    private final PackageInfo zzdlm;
    private final Executor zzffi;
    private final zzawi zzgir;
    private final String zzgiv;

    public zzcvu(zzawi zzawi, Executor executor, String str, @Nullable PackageInfo packageInfo) {
        this.zzgir = zzawi;
        this.zzffi = executor;
        this.zzgiv = str;
        this.zzdlm = packageInfo;
    }

    public final zzbbh<zzcvt> zzalm() {
        return zzbar.zza(zzbar.zza(this.zzgir.zza(this.zzgiv, this.zzdlm), zzcvv.zzdrn, this.zzffi), Throwable.class, new zzcvw(this), this.zzffi);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzbbh zzf(Throwable th) throws Exception {
        return zzbar.zzm(new zzcvt(this.zzgiv));
    }
}
