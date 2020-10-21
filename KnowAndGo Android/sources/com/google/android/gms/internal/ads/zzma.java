package com.google.android.gms.internal.ads;

import android.os.Handler;

public final class zzma {
    private final Handler handler;
    /* access modifiers changed from: private */
    public final zzlz zzavi;

    public zzma(Handler handler2, zzlz zzlz) {
        this.handler = zzlz != null ? (Handler) zzsk.checkNotNull(handler2) : null;
        this.zzavi = zzlz;
    }

    public final void zzc(zznc zznc) {
        if (this.zzavi != null) {
            this.handler.post(new zzmb(this, zznc));
        }
    }

    public final void zzc(String str, long j, long j2) {
        if (this.zzavi != null) {
            this.handler.post(new zzmc(this, str, j, j2));
        }
    }

    public final void zzc(zzlh zzlh) {
        if (this.zzavi != null) {
            this.handler.post(new zzmd(this, zzlh));
        }
    }

    public final void zzd(int i, long j, long j2) {
        if (this.zzavi != null) {
            this.handler.post(new zzme(this, i, j, j2));
        }
    }

    public final void zzd(zznc zznc) {
        if (this.zzavi != null) {
            this.handler.post(new zzmf(this, zznc));
        }
    }

    public final void zzah(int i) {
        if (this.zzavi != null) {
            this.handler.post(new zzmg(this, i));
        }
    }
}
