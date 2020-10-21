package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzk;
import java.util.concurrent.Callable;

final class zzash implements Callable<zzase> {
    private final /* synthetic */ Context val$context;
    private final /* synthetic */ zzasg zzdqf;

    zzash(zzasg zzasg, Context context) {
        this.zzdqf = zzasg;
        this.val$context = context;
    }

    public final /* synthetic */ Object call() throws Exception {
        zzase zzase;
        zzasi zzasi = (zzasi) this.zzdqf.zzdqe.get(this.val$context);
        if (zzasi != null) {
            if (!(zzasi.zzdqg + ((Long) zzyt.zzpe().zzd(zzacu.zzcqm)).longValue() < zzk.zzln().currentTimeMillis())) {
                zzase = new zzasf(this.val$context, zzasi.zzdqh).zzty();
                this.zzdqf.zzdqe.put(this.val$context, new zzasi(this.zzdqf, zzase));
                return zzase;
            }
        }
        zzase = new zzasf(this.val$context).zzty();
        this.zzdqf.zzdqe.put(this.val$context, new zzasi(this.zzdqf, zzase));
        return zzase;
    }
}
