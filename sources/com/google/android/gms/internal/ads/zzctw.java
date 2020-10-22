package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzk;
import java.util.Set;

public final class zzctw implements zzcva<zzctv> {
    private final zzbbl zzfqw;
    private final Set<String> zzggk;
    private final Context zzlj;

    public zzctw(zzbbl zzbbl, Context context, Set<String> set) {
        this.zzfqw = zzbbl;
        this.zzlj = context;
        this.zzggk = set;
    }

    public final zzbbh<zzctv> zzalm() {
        return this.zzfqw.zza(new zzctx(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzctv zzalu() throws Exception {
        if (!((Boolean) zzyt.zzpe().zzd(zzacu.zzcuu)).booleanValue() || !zzctv.zzd(this.zzggk)) {
            return new zzctv((String) null);
        }
        return new zzctv(zzk.zzlv().getVersion(this.zzlj));
    }
}
