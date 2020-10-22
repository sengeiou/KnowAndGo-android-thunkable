package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzk;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

public final class zzcvb<T> {
    private final Executor zzffi;
    private final Set<zzcva<? extends zzcuz<T>>> zzgih;

    public zzcvb(Executor executor, Set<zzcva<? extends zzcuz<T>>> set) {
        this.zzffi = executor;
        this.zzgih = set;
    }

    public final zzbbh<T> zzu(T t) {
        ArrayList arrayList = new ArrayList(this.zzgih.size());
        for (zzcva next : this.zzgih) {
            zzbbh zzalm = next.zzalm();
            if (((Boolean) zzyt.zzpe().zzd(zzacu.zzcqg)).booleanValue()) {
                zzalm.zza(new zzcvc(next, zzk.zzln().elapsedRealtime()), zzbbm.zzeaf);
            }
            arrayList.add(zzalm);
        }
        return zzbar.zzf(arrayList).zza(new zzcvd(arrayList, t), this.zzffi);
    }

    static final /* synthetic */ Object zza(List list, Object obj) throws Exception {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            try {
                zzcuz zzcuz = (zzcuz) ((zzbbh) it.next()).get();
                if (zzcuz != null) {
                    zzcuz.zzt(obj);
                }
            } catch (InterruptedException | ExecutionException e) {
                zzawz.zzc("Derive quality signals error.", e);
                throw new Exception(e);
            }
        }
        return obj;
    }
}
