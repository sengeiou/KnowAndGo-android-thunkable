package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import java.io.IOException;

final /* synthetic */ class zzwe implements Runnable {
    private final zzwd zzbxd;
    private final zzvu zzbxe;
    private final zzvv zzbxf;
    private final zzbbr zzbxg;

    zzwe(zzwd zzwd, zzvu zzvu, zzvv zzvv, zzbbr zzbbr) {
        this.zzbxd = zzwd;
        this.zzbxe = zzvu;
        this.zzbxf = zzvv;
        this.zzbxg = zzbbr;
    }

    public final void run() {
        zzwd zzwd = this.zzbxd;
        zzvu zzvu = this.zzbxe;
        zzvv zzvv = this.zzbxf;
        zzbbr zzbbr = this.zzbxg;
        try {
            zzvs zza = zzvu.zznk().zza(zzvv);
            if (!zza.zznh()) {
                zzbbr.setException(new RuntimeException("No entry contents."));
                zzwd.zzbxa.disconnect();
                return;
            }
            zzwg zzwg = new zzwg(zzwd, zza.zzni(), 1);
            int read = zzwg.read();
            if (read != -1) {
                zzwg.unread(read);
                zzbbr.set(zzwg);
                return;
            }
            throw new IOException("Unable to read from cache.");
        } catch (RemoteException | IOException e) {
            zzawz.zzc("Unable to obtain a cache service instance.", e);
            zzbbr.setException(e);
            zzwd.zzbxa.disconnect();
        }
    }
}
