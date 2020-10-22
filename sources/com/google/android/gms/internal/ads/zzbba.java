package com.google.android.gms.internal.ads;

import java.util.concurrent.ExecutionException;

final /* synthetic */ class zzbba implements Runnable {
    private final zzbbr zzbxh;
    private final zzbbh zzdzi;

    zzbba(zzbbr zzbbr, zzbbh zzbbh) {
        this.zzbxh = zzbbr;
        this.zzdzi = zzbbh;
    }

    public final void run() {
        zzbbr zzbbr = this.zzbxh;
        try {
            zzbbr.set(this.zzdzi.get());
        } catch (ExecutionException e) {
            zzbbr.setException(e.getCause());
        } catch (InterruptedException e2) {
            Thread.currentThread().interrupt();
            zzbbr.setException(e2);
        } catch (Exception e3) {
            zzbbr.setException(e3);
        }
    }
}
