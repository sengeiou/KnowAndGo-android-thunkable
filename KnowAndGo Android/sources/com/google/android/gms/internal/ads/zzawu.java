package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

@zzard
public final class zzawu implements zzut {
    private final Object lock = new Object();
    private final zzaxb zzduk;
    private final zzawt zzduo;
    @VisibleForTesting
    private final zzawr zzdup;
    @VisibleForTesting
    private final HashSet<zzawj> zzduq = new HashSet<>();
    @VisibleForTesting
    private final HashSet<Object> zzdur = new HashSet<>();

    public zzawu(String str, zzaxb zzaxb) {
        this.zzdup = new zzawr(str, zzaxb);
        this.zzduk = zzaxb;
        this.zzduo = new zzawt();
    }

    public final void zzb(zzawj zzawj) {
        synchronized (this.lock) {
            this.zzduq.add(zzawj);
        }
    }

    public final void zzb(HashSet<zzawj> hashSet) {
        synchronized (this.lock) {
            this.zzduq.addAll(hashSet);
        }
    }

    public final Bundle zza(Context context, zzaws zzaws) {
        HashSet hashSet = new HashSet();
        synchronized (this.lock) {
            hashSet.addAll(this.zzduq);
            this.zzduq.clear();
        }
        Bundle bundle = new Bundle();
        bundle.putBundle("app", this.zzdup.zzn(context, this.zzduo.zzvh()));
        Bundle bundle2 = new Bundle();
        Iterator<Object> it = this.zzdur.iterator();
        if (!it.hasNext()) {
            bundle.putBundle("slots", bundle2);
            ArrayList arrayList = new ArrayList();
            Iterator it2 = hashSet.iterator();
            while (it2.hasNext()) {
                arrayList.add(((zzawj) it2.next()).toBundle());
            }
            bundle.putParcelableArrayList("ads", arrayList);
            zzaws.zza(hashSet);
            return bundle;
        }
        it.next();
        throw new NoSuchMethodError();
    }

    public final void zzp(boolean z) {
        long currentTimeMillis = zzk.zzln().currentTimeMillis();
        if (z) {
            if (currentTimeMillis - this.zzduk.zzvs() > ((Long) zzyt.zzpe().zzd(zzacu.zzcoy)).longValue()) {
                this.zzdup.zzduh = -1;
                return;
            }
            this.zzdup.zzduh = this.zzduk.zzvt();
            return;
        }
        this.zzduk.zzfc(currentTimeMillis);
        this.zzduk.zzcu(this.zzdup.zzduh);
    }

    public final void zzuk() {
        synchronized (this.lock) {
            this.zzdup.zzuk();
        }
    }

    public final void zzuj() {
        synchronized (this.lock) {
            this.zzdup.zzuj();
        }
    }

    public final void zza(zzxz zzxz, long j) {
        synchronized (this.lock) {
            this.zzdup.zza(zzxz, j);
        }
    }

    public final zzawj zza(Clock clock, String str) {
        return new zzawj(clock, this, this.zzduo.zzvg(), str);
    }
}
