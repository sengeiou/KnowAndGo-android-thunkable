package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzk;
import java.io.StringReader;
import java.util.concurrent.Executor;
import org.json.JSONObject;

public final class zzchq {
    private final Executor zzffi;
    private final zzcxv zzfjp;
    private final zzbai zzfxa;
    private final Context zzlj;

    public zzchq(Context context, zzbai zzbai, zzcxv zzcxv, Executor executor) {
        this.zzlj = context;
        this.zzfxa = zzbai;
        this.zzfjp = zzcxv;
        this.zzffi = executor;
    }

    /* access modifiers changed from: protected */
    public final zzbbh<zzcxu> zzakg() {
        zzalj<I, O> zza = zzk.zzlt().zzb(this.zzlj, this.zzfxa).zza("google.afma.response.normalize", zzalo.zzddi, zzalo.zzddi);
        return zzbar.zza(zzbar.zza(zzbar.zza(zzbar.zzm(""), new zzchr(this, this.zzfjp.zzghg.zzchb), this.zzffi), new zzchs(zza), this.zzffi), new zzcht(this), this.zzffi);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzbbh zzn(JSONObject jSONObject) throws Exception {
        return zzbar.zzm(new zzcxu(new zzcxr(this.zzfjp), zzcxs.zza(new StringReader(jSONObject.toString()))));
    }
}
