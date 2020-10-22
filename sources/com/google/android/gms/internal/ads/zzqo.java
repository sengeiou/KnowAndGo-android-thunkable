package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public final class zzqo implements zzql {
    private final zzlu zzars = new zzlu();
    private final zzql[] zzbji;
    private final ArrayList<zzql> zzbjj;
    private zzqm zzbjk;
    private zzlr zzbjl;
    private Object zzbjm;
    private int zzbjn = -1;
    private zzqq zzbjo;

    public zzqo(zzql... zzqlArr) {
        this.zzbji = zzqlArr;
        this.zzbjj = new ArrayList<>(Arrays.asList(zzqlArr));
    }

    public final void zza(zzkv zzkv, boolean z, zzqm zzqm) {
        this.zzbjk = zzqm;
        for (int i = 0; i < this.zzbji.length; i++) {
            this.zzbji[i].zza(zzkv, false, new zzqp(this, i));
        }
    }

    public final void zzjf() throws IOException {
        if (this.zzbjo == null) {
            for (zzql zzjf : this.zzbji) {
                zzjf.zzjf();
            }
            return;
        }
        throw this.zzbjo;
    }

    public final zzqj zza(int i, zzrt zzrt) {
        zzqj[] zzqjArr = new zzqj[this.zzbji.length];
        for (int i2 = 0; i2 < zzqjArr.length; i2++) {
            zzqjArr[i2] = this.zzbji[i2].zza(i, zzrt);
        }
        return new zzqn(zzqjArr);
    }

    public final void zzb(zzqj zzqj) {
        zzqn zzqn = (zzqn) zzqj;
        for (int i = 0; i < this.zzbji.length; i++) {
            this.zzbji[i].zzb(zzqn.zzbjd[i]);
        }
    }

    public final void zzjg() {
        for (zzql zzjg : this.zzbji) {
            zzjg.zzjg();
        }
    }

    /* access modifiers changed from: private */
    public final void zza(int i, zzlr zzlr, Object obj) {
        zzqq zzqq;
        if (this.zzbjo == null) {
            int zzhf = zzlr.zzhf();
            int i2 = 0;
            while (true) {
                if (i2 >= zzhf) {
                    if (this.zzbjn == -1) {
                        this.zzbjn = zzlr.zzhg();
                    } else if (zzlr.zzhg() != this.zzbjn) {
                        zzqq = new zzqq(1);
                    }
                    zzqq = null;
                } else if (zzlr.zza(i2, this.zzars, false).zzaut) {
                    zzqq = new zzqq(0);
                    break;
                } else {
                    i2++;
                }
            }
            this.zzbjo = zzqq;
        }
        if (this.zzbjo == null) {
            this.zzbjj.remove(this.zzbji[i]);
            if (i == 0) {
                this.zzbjl = zzlr;
                this.zzbjm = obj;
            }
            if (this.zzbjj.isEmpty()) {
                this.zzbjk.zzb(this.zzbjl, this.zzbjm);
            }
        }
    }
}
