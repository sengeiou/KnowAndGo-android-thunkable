package com.google.android.gms.internal.ads;

import java.util.concurrent.ExecutionException;

final /* synthetic */ class zzbas implements Runnable {
    private final zzban zzdzh;
    private final zzbbh zzdzi;

    zzbas(zzban zzban, zzbbh zzbbh) {
        this.zzdzh = zzban;
        this.zzdzi = zzbbh;
    }

    public final void run() {
        Throwable e;
        zzban zzban = this.zzdzh;
        try {
            zzban.zzk(this.zzdzi.get());
        } catch (ExecutionException e2) {
            e = e2.getCause();
            zzban.zzb(e);
        } catch (InterruptedException e3) {
            e = e3;
            Thread.currentThread().interrupt();
            zzban.zzb(e);
        } catch (Exception e4) {
            e = e4;
            zzban.zzb(e);
        }
    }
}
