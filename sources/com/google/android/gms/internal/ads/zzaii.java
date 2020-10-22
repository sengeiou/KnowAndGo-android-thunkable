package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import android.os.ParcelFileDescriptor;
import com.google.android.gms.ads.internal.zzk;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

@zzard
public final class zzaii implements zzm {
    /* access modifiers changed from: private */
    public volatile zzahz zzdax;
    private final Context zzlj;

    public zzaii(Context context) {
        this.zzlj = context;
    }

    public final zzp zzc(zzr<?> zzr) throws zzaf {
        zzaia zzh = zzaia.zzh(zzr);
        long elapsedRealtime = zzk.zzln().elapsedRealtime();
        try {
            zzbbr zzbbr = new zzbbr();
            this.zzdax = new zzahz(this.zzlj, zzk.zzlu().zzwr(), new zzaim(this, zzbbr), new zzain(this, zzbbr));
            this.zzdax.checkAvailabilityAndConnect();
            zzbbh zza = zzbar.zza(zzbar.zza(zzbbr, new zzaij(this, zzh), (Executor) zzaxg.zzdvp), (long) ((Integer) zzyt.zzpe().zzd(zzacu.zzctx)).intValue(), TimeUnit.MILLISECONDS, zzaxg.zzdvr);
            zza.zza(new zzail(this), zzaxg.zzdvp);
            ParcelFileDescriptor parcelFileDescriptor = (ParcelFileDescriptor) zza.get();
            long elapsedRealtime2 = zzk.zzln().elapsedRealtime() - elapsedRealtime;
            StringBuilder sb = new StringBuilder(52);
            sb.append("Http assets remote cache took ");
            sb.append(elapsedRealtime2);
            sb.append("ms");
            zzawz.zzds(sb.toString());
            zzaic zzaic = (zzaic) new zzaru(parcelFileDescriptor).zza(zzaic.CREATOR);
            if (zzaic == null) {
                return null;
            }
            if (zzaic.zzdav) {
                throw new zzaf(zzaic.zzdaw);
            } else if (zzaic.zzdat.length != zzaic.zzdau.length) {
                return null;
            } else {
                HashMap hashMap = new HashMap();
                for (int i = 0; i < zzaic.zzdat.length; i++) {
                    hashMap.put(zzaic.zzdat[i], zzaic.zzdau[i]);
                }
                return new zzp(zzaic.statusCode, zzaic.data, (Map<String, String>) hashMap, zzaic.zzac, zzaic.zzad);
            }
        } catch (InterruptedException | ExecutionException unused) {
            StringBuilder sb2 = new StringBuilder(52);
            sb2.append("Http assets remote cache took ");
            sb2.append(zzk.zzln().elapsedRealtime() - elapsedRealtime);
            sb2.append("ms");
            zzawz.zzds(sb2.toString());
            return null;
        } catch (Throwable th) {
            long elapsedRealtime3 = zzk.zzln().elapsedRealtime() - elapsedRealtime;
            StringBuilder sb3 = new StringBuilder(52);
            sb3.append("Http assets remote cache took ");
            sb3.append(elapsedRealtime3);
            sb3.append("ms");
            zzawz.zzds(sb3.toString());
            throw th;
        }
    }

    /* access modifiers changed from: private */
    public final void disconnect() {
        if (this.zzdax != null) {
            this.zzdax.disconnect();
            Binder.flushPendingCommands();
        }
    }
}
