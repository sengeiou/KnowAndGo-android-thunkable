package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.util.VisibleForTesting;
import javax.annotation.concurrent.GuardedBy;

@zzard
public final class zzvn {
    /* access modifiers changed from: private */
    public final Object lock = new Object();
    private final Runnable zzbwn = new zzvo(this);
    /* access modifiers changed from: private */
    @GuardedBy("lock")
    @Nullable
    public zzvu zzbwo;
    /* access modifiers changed from: private */
    @GuardedBy("lock")
    @Nullable
    public zzvy zzbwp;
    @GuardedBy("lock")
    @Nullable
    private Context zzlj;

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0047, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void initialize(android.content.Context r3) {
        /*
            r2 = this;
            if (r3 != 0) goto L_0x0003
            return
        L_0x0003:
            java.lang.Object r0 = r2.lock
            monitor-enter(r0)
            android.content.Context r1 = r2.zzlj     // Catch:{ all -> 0x0048 }
            if (r1 == 0) goto L_0x000c
            monitor-exit(r0)     // Catch:{ all -> 0x0048 }
            return
        L_0x000c:
            android.content.Context r3 = r3.getApplicationContext()     // Catch:{ all -> 0x0048 }
            r2.zzlj = r3     // Catch:{ all -> 0x0048 }
            com.google.android.gms.internal.ads.zzacj<java.lang.Boolean> r3 = com.google.android.gms.internal.ads.zzacu.zzcto     // Catch:{ all -> 0x0048 }
            com.google.android.gms.internal.ads.zzacr r1 = com.google.android.gms.internal.ads.zzyt.zzpe()     // Catch:{ all -> 0x0048 }
            java.lang.Object r3 = r1.zzd(r3)     // Catch:{ all -> 0x0048 }
            java.lang.Boolean r3 = (java.lang.Boolean) r3     // Catch:{ all -> 0x0048 }
            boolean r3 = r3.booleanValue()     // Catch:{ all -> 0x0048 }
            if (r3 == 0) goto L_0x0028
            r2.connect()     // Catch:{ all -> 0x0048 }
            goto L_0x0046
        L_0x0028:
            com.google.android.gms.internal.ads.zzacj<java.lang.Boolean> r3 = com.google.android.gms.internal.ads.zzacu.zzctn     // Catch:{ all -> 0x0048 }
            com.google.android.gms.internal.ads.zzacr r1 = com.google.android.gms.internal.ads.zzyt.zzpe()     // Catch:{ all -> 0x0048 }
            java.lang.Object r3 = r1.zzd(r3)     // Catch:{ all -> 0x0048 }
            java.lang.Boolean r3 = (java.lang.Boolean) r3     // Catch:{ all -> 0x0048 }
            boolean r3 = r3.booleanValue()     // Catch:{ all -> 0x0048 }
            if (r3 == 0) goto L_0x0046
            com.google.android.gms.internal.ads.zzvp r3 = new com.google.android.gms.internal.ads.zzvp     // Catch:{ all -> 0x0048 }
            r3.<init>(r2)     // Catch:{ all -> 0x0048 }
            com.google.android.gms.internal.ads.zzuq r1 = com.google.android.gms.ads.internal.zzk.zzlj()     // Catch:{ all -> 0x0048 }
            r1.zza(r3)     // Catch:{ all -> 0x0048 }
        L_0x0046:
            monitor-exit(r0)     // Catch:{ all -> 0x0048 }
            return
        L_0x0048:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0048 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzvn.initialize(android.content.Context):void");
    }

    public final void zzng() {
        if (((Boolean) zzyt.zzpe().zzd(zzacu.zzctp)).booleanValue()) {
            synchronized (this.lock) {
                connect();
                zzk.zzlg();
                zzaxi.zzdvv.removeCallbacks(this.zzbwn);
                zzk.zzlg();
                zzaxi.zzdvv.postDelayed(this.zzbwn, ((Long) zzyt.zzpe().zzd(zzacu.zzctq)).longValue());
            }
        }
    }

    public final zzvs zza(zzvv zzvv) {
        synchronized (this.lock) {
            if (this.zzbwp == null) {
                zzvs zzvs = new zzvs();
                return zzvs;
            }
            try {
                zzvs zza = this.zzbwp.zza(zzvv);
                return zza;
            } catch (RemoteException e) {
                zzawz.zzc("Unable to call into cache service.", e);
                return new zzvs();
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0024, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void connect() {
        /*
            r3 = this;
            java.lang.Object r0 = r3.lock
            monitor-enter(r0)
            android.content.Context r1 = r3.zzlj     // Catch:{ all -> 0x0025 }
            if (r1 == 0) goto L_0x0023
            com.google.android.gms.internal.ads.zzvu r1 = r3.zzbwo     // Catch:{ all -> 0x0025 }
            if (r1 == 0) goto L_0x000c
            goto L_0x0023
        L_0x000c:
            com.google.android.gms.internal.ads.zzvq r1 = new com.google.android.gms.internal.ads.zzvq     // Catch:{ all -> 0x0025 }
            r1.<init>(r3)     // Catch:{ all -> 0x0025 }
            com.google.android.gms.internal.ads.zzvr r2 = new com.google.android.gms.internal.ads.zzvr     // Catch:{ all -> 0x0025 }
            r2.<init>(r3)     // Catch:{ all -> 0x0025 }
            com.google.android.gms.internal.ads.zzvu r1 = r3.zza((com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks) r1, (com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener) r2)     // Catch:{ all -> 0x0025 }
            r3.zzbwo = r1     // Catch:{ all -> 0x0025 }
            com.google.android.gms.internal.ads.zzvu r1 = r3.zzbwo     // Catch:{ all -> 0x0025 }
            r1.checkAvailabilityAndConnect()     // Catch:{ all -> 0x0025 }
            monitor-exit(r0)     // Catch:{ all -> 0x0025 }
            return
        L_0x0023:
            monitor-exit(r0)     // Catch:{ all -> 0x0025 }
            return
        L_0x0025:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0025 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzvn.connect():void");
    }

    @VisibleForTesting
    private final synchronized zzvu zza(BaseGmsClient.BaseConnectionCallbacks baseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener baseOnConnectionFailedListener) {
        return new zzvu(this.zzlj, zzk.zzlu().zzwr(), baseConnectionCallbacks, baseOnConnectionFailedListener);
    }

    /* access modifiers changed from: private */
    public final void disconnect() {
        synchronized (this.lock) {
            if (this.zzbwo != null) {
                if (this.zzbwo.isConnected() || this.zzbwo.isConnecting()) {
                    this.zzbwo.disconnect();
                }
                this.zzbwo = null;
                this.zzbwp = null;
                Binder.flushPendingCommands();
            }
        }
    }
}
