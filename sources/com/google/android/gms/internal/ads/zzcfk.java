package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public final class zzcfk implements zzczz {
    private final Clock zzbsa;
    private final Map<zzczs, Long> zzfuq = new HashMap();
    private final zzcfi zzfur;
    private final Map<zzczs, zzcfl> zzfus = new HashMap();

    public zzcfk(zzcfi zzcfi, Set<zzcfl> set, Clock clock) {
        this.zzfur = zzcfi;
        for (zzcfl next : set) {
            this.zzfus.put(next.zzfuu, next);
        }
        this.zzbsa = clock;
    }

    public final void zza(zzczs zzczs, String str) {
    }

    public final void zzb(zzczs zzczs, String str) {
        this.zzfuq.put(zzczs, Long.valueOf(this.zzbsa.elapsedRealtime()));
    }

    public final void zza(zzczs zzczs, String str, Throwable th) {
        if (this.zzfuq.containsKey(zzczs)) {
            long elapsedRealtime = this.zzbsa.elapsedRealtime() - this.zzfuq.get(zzczs).longValue();
            Map<String, String> zzqy = this.zzfur.zzqy();
            String valueOf = String.valueOf(str);
            String concat = valueOf.length() != 0 ? "task.".concat(valueOf) : new String("task.");
            String valueOf2 = String.valueOf(Long.toString(elapsedRealtime));
            zzqy.put(concat, valueOf2.length() != 0 ? "f.".concat(valueOf2) : new String("f."));
        }
        if (this.zzfus.containsKey(zzczs)) {
            zza(zzczs, false);
        }
    }

    public final void zzc(zzczs zzczs, String str) {
        if (this.zzfuq.containsKey(zzczs)) {
            long elapsedRealtime = this.zzbsa.elapsedRealtime() - this.zzfuq.get(zzczs).longValue();
            Map<String, String> zzqy = this.zzfur.zzqy();
            String valueOf = String.valueOf(str);
            String concat = valueOf.length() != 0 ? "task.".concat(valueOf) : new String("task.");
            String valueOf2 = String.valueOf(Long.toString(elapsedRealtime));
            zzqy.put(concat, valueOf2.length() != 0 ? "s.".concat(valueOf2) : new String("s."));
        }
        if (this.zzfus.containsKey(zzczs)) {
            zza(zzczs, true);
        }
    }

    private final void zza(zzczs zzczs, boolean z) {
        zzczs zzb = this.zzfus.get(zzczs).zzfut;
        String str = z ? "s." : "f.";
        if (this.zzfuq.containsKey(zzb)) {
            long elapsedRealtime = this.zzbsa.elapsedRealtime() - this.zzfuq.get(zzb).longValue();
            Map<String, String> zzqy = this.zzfur.zzqy();
            String valueOf = String.valueOf(this.zzfus.get(zzczs).label);
            String concat = valueOf.length() != 0 ? "label.".concat(valueOf) : new String("label.");
            String valueOf2 = String.valueOf(str);
            String valueOf3 = String.valueOf(Long.toString(elapsedRealtime));
            zzqy.put(concat, valueOf3.length() != 0 ? valueOf2.concat(valueOf3) : new String(valueOf2));
        }
    }
}
