package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

final /* synthetic */ class zzbav implements Runnable {
    private final Iterable zzdzm;
    private final zzbbr zzdzn;

    zzbav(Iterable iterable, zzbbr zzbbr) {
        this.zzdzm = iterable;
        this.zzdzn = zzbbr;
    }

    public final void run() {
        Iterable<zzbbh> iterable = this.zzdzm;
        zzbbr zzbbr = this.zzdzn;
        ArrayList arrayList = new ArrayList();
        for (zzbbh zzbbh : iterable) {
            try {
                arrayList.add(zzbbh.get());
            } catch (ExecutionException e) {
                zzbbr.setException(e.getCause());
            } catch (Exception | InterruptedException e2) {
                zzbbr.setException(e2);
            }
        }
        zzbbr.set(arrayList);
    }
}
