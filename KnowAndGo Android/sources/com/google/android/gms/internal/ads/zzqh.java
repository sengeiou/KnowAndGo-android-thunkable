package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.Handler;
import com.google.android.exoplayer2.C1470C;
import java.io.IOException;

public final class zzqh implements zzql, zzqm {
    private final Uri uri;
    private final Handler zzabq;
    private final int zzaig = -1;
    private final zzlt zzart;
    private zzlr zzary;
    private final zzqi zzbia;
    private zzqm zzbib;
    private final String zzbid;
    private final zzrw zzbiz;
    private final zznq zzbja;
    private final int zzbjb;
    private boolean zzbjc;

    public zzqh(Uri uri2, zzrw zzrw, zznq zznq, int i, Handler handler, zzqi zzqi, String str, int i2) {
        this.uri = uri2;
        this.zzbiz = zzrw;
        this.zzbja = zznq;
        this.zzabq = handler;
        this.zzbia = zzqi;
        this.zzbid = null;
        this.zzbjb = i2;
        this.zzart = new zzlt();
    }

    public final void zzjf() throws IOException {
    }

    public final void zza(zzkv zzkv, boolean z, zzqm zzqm) {
        this.zzbib = zzqm;
        this.zzary = new zzqz(C1470C.TIME_UNSET, false);
        zzqm.zzb(this.zzary, (Object) null);
    }

    public final zzqj zza(int i, zzrt zzrt) {
        zzsk.checkArgument(i == 0);
        return new zzpz(this.uri, this.zzbiz.zzju(), this.zzbja.zzih(), this.zzaig, this.zzabq, this.zzbia, this, zzrt, (String) null, this.zzbjb);
    }

    public final void zzb(zzqj zzqj) {
        ((zzpz) zzqj).release();
    }

    public final void zzjg() {
        this.zzbib = null;
    }

    public final void zzb(zzlr zzlr, Object obj) {
        boolean z = false;
        if (zzlr.zza(0, this.zzart, false).zzack != C1470C.TIME_UNSET) {
            z = true;
        }
        if (!this.zzbjc || z) {
            this.zzary = zzlr;
            this.zzbjc = z;
            this.zzbib.zzb(this.zzary, (Object) null);
        }
    }
}
