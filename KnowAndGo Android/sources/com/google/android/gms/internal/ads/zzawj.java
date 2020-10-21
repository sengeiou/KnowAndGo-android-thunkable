package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.common.util.Clock;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import javax.annotation.concurrent.GuardedBy;

@zzard
public final class zzawj {
    private final Object lock = new Object();
    /* access modifiers changed from: private */
    public final Clock zzbsa;
    private final String zzdlz;
    @GuardedBy("lock")
    private boolean zzdnj = false;
    @GuardedBy("lock")
    private long zzdnn = -1;
    private final zzawu zzdsw;
    @GuardedBy("lock")
    private final LinkedList<zzawk> zzdsx;
    private final String zzdsy;
    @GuardedBy("lock")
    private long zzdsz = -1;
    @GuardedBy("lock")
    private long zzdta = -1;
    @GuardedBy("lock")
    private long zzdtb = 0;
    @GuardedBy("lock")
    private long zzdtc = -1;
    @GuardedBy("lock")
    private long zzdtd = -1;

    zzawj(Clock clock, zzawu zzawu, String str, String str2) {
        this.zzbsa = clock;
        this.zzdsw = zzawu;
        this.zzdsy = str;
        this.zzdlz = str2;
        this.zzdsx = new LinkedList<>();
    }

    public final void zze(zzxz zzxz) {
        synchronized (this.lock) {
            this.zzdtc = this.zzbsa.elapsedRealtime();
            this.zzdsw.zza(zzxz, this.zzdtc);
        }
    }

    public final void zzfb(long j) {
        synchronized (this.lock) {
            this.zzdtd = j;
            if (this.zzdtd != -1) {
                this.zzdsw.zzb(this);
            }
        }
    }

    public final void zzuj() {
        synchronized (this.lock) {
            if (this.zzdtd != -1 && this.zzdsz == -1) {
                this.zzdsz = this.zzbsa.elapsedRealtime();
                this.zzdsw.zzb(this);
            }
            this.zzdsw.zzuj();
        }
    }

    public final void zzuk() {
        synchronized (this.lock) {
            if (this.zzdtd != -1) {
                zzawk zzawk = new zzawk(this);
                zzawk.zzup();
                this.zzdsx.add(zzawk);
                this.zzdtb++;
                this.zzdsw.zzuk();
                this.zzdsw.zzb(this);
            }
        }
    }

    public final void zzul() {
        synchronized (this.lock) {
            if (this.zzdtd != -1 && !this.zzdsx.isEmpty()) {
                zzawk last = this.zzdsx.getLast();
                if (last.zzun() == -1) {
                    last.zzuo();
                    this.zzdsw.zzb(this);
                }
            }
        }
    }

    public final void zzah(boolean z) {
        synchronized (this.lock) {
            if (this.zzdtd != -1) {
                this.zzdta = this.zzbsa.elapsedRealtime();
            }
        }
    }

    public final Bundle toBundle() {
        Bundle bundle;
        synchronized (this.lock) {
            bundle = new Bundle();
            bundle.putString("seq_num", this.zzdsy);
            bundle.putString("slotid", this.zzdlz);
            bundle.putBoolean("ismediation", false);
            bundle.putLong("treq", this.zzdtc);
            bundle.putLong("tresponse", this.zzdtd);
            bundle.putLong("timp", this.zzdsz);
            bundle.putLong("tload", this.zzdta);
            bundle.putLong("pcc", this.zzdtb);
            bundle.putLong("tfetch", this.zzdnn);
            ArrayList arrayList = new ArrayList();
            Iterator it = this.zzdsx.iterator();
            while (it.hasNext()) {
                arrayList.add(((zzawk) it.next()).toBundle());
            }
            bundle.putParcelableArrayList("tclick", arrayList);
        }
        return bundle;
    }

    public final String zzum() {
        return this.zzdsy;
    }
}
