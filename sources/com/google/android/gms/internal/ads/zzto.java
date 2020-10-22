package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.view.Surface;

public final class zzto {
    private final Handler handler;
    /* access modifiers changed from: private */
    public final zztn zzbpt;

    public zzto(Handler handler2, zztn zztn) {
        this.handler = zztn != null ? (Handler) zzsk.checkNotNull(handler2) : null;
        this.zzbpt = zztn;
    }

    public final void zzc(zznc zznc) {
        if (this.zzbpt != null) {
            this.handler.post(new zztp(this, zznc));
        }
    }

    public final void zzc(String str, long j, long j2) {
        if (this.zzbpt != null) {
            this.handler.post(new zztq(this, str, j, j2));
        }
    }

    public final void zzc(zzlh zzlh) {
        if (this.zzbpt != null) {
            this.handler.post(new zztr(this, zzlh));
        }
    }

    public final void zzg(int i, long j) {
        if (this.zzbpt != null) {
            this.handler.post(new zzts(this, i, j));
        }
    }

    public final void zzb(int i, int i2, int i3, float f) {
        if (this.zzbpt != null) {
            this.handler.post(new zztt(this, i, i2, i3, f));
        }
    }

    public final void zzc(Surface surface) {
        if (this.zzbpt != null) {
            this.handler.post(new zztu(this, surface));
        }
    }

    public final void zzd(zznc zznc) {
        if (this.zzbpt != null) {
            this.handler.post(new zztv(this, zznc));
        }
    }
}
