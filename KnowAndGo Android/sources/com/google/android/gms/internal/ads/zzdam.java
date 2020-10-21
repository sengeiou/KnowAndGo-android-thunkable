package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.DeadObjectException;
import android.os.HandlerThread;
import android.support.p002v4.media.session.PlaybackStateCompat;
import com.google.android.exoplayer2.DefaultRenderersFactory;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zzbp;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

@VisibleForTesting
final class zzdam implements BaseGmsClient.BaseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener {
    private final String packageName;
    private final HandlerThread zzdxs = new HandlerThread("GassClient");
    @VisibleForTesting
    private zzdba zzgny;
    private final String zzgnz;
    private final LinkedBlockingQueue<zzbp.zza> zzgoa;

    public zzdam(Context context, String str, String str2) {
        this.packageName = str;
        this.zzgnz = str2;
        this.zzdxs.start();
        this.zzgny = new zzdba(context, this.zzdxs.getLooper(), this, this);
        this.zzgoa = new LinkedBlockingQueue<>();
        this.zzgny.checkAvailabilityAndConnect();
    }

    public final zzbp.zza zzdr(int i) {
        zzbp.zza zza;
        try {
            zza = this.zzgoa.poll(DefaultRenderersFactory.DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS, TimeUnit.MILLISECONDS);
        } catch (InterruptedException unused) {
            zza = null;
        }
        return zza == null ? zzang() : zza;
    }

    private final zzdbf zzanf() {
        try {
            return this.zzgny.zzanm();
        } catch (DeadObjectException | IllegalStateException unused) {
            return null;
        }
    }

    public final void onConnectionSuspended(int i) {
        try {
            this.zzgoa.put(zzang());
        } catch (InterruptedException unused) {
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0039, code lost:
        throw r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x003a, code lost:
        zzakh();
        r3.zzdxs.quit();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0042, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0025, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:?, code lost:
        r3.zzgoa.put(zzang());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0031, code lost:
        zzakh();
        r3.zzdxs.quit();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0027 */
    /* JADX WARNING: Removed duplicated region for block: B:6:0x0025 A[ExcHandler: all (r4v4 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:2:0x0006] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onConnected(android.os.Bundle r4) {
        /*
            r3 = this;
            com.google.android.gms.internal.ads.zzdbf r4 = r3.zzanf()
            if (r4 == 0) goto L_0x0043
            com.google.android.gms.internal.ads.zzdbb r0 = new com.google.android.gms.internal.ads.zzdbb     // Catch:{ Throwable -> 0x0027, all -> 0x0025 }
            java.lang.String r1 = r3.packageName     // Catch:{ Throwable -> 0x0027, all -> 0x0025 }
            java.lang.String r2 = r3.zzgnz     // Catch:{ Throwable -> 0x0027, all -> 0x0025 }
            r0.<init>(r1, r2)     // Catch:{ Throwable -> 0x0027, all -> 0x0025 }
            com.google.android.gms.internal.ads.zzdbd r4 = r4.zza((com.google.android.gms.internal.ads.zzdbb) r0)     // Catch:{ Throwable -> 0x0027, all -> 0x0025 }
            com.google.android.gms.internal.ads.zzbp$zza r4 = r4.zzann()     // Catch:{ Throwable -> 0x0027, all -> 0x0025 }
            java.util.concurrent.LinkedBlockingQueue<com.google.android.gms.internal.ads.zzbp$zza> r0 = r3.zzgoa     // Catch:{ Throwable -> 0x0027, all -> 0x0025 }
            r0.put(r4)     // Catch:{ Throwable -> 0x0027, all -> 0x0025 }
            r3.zzakh()
            android.os.HandlerThread r4 = r3.zzdxs
            r4.quit()
            return
        L_0x0025:
            r4 = move-exception
            goto L_0x0031
        L_0x0027:
            java.util.concurrent.LinkedBlockingQueue<com.google.android.gms.internal.ads.zzbp$zza> r4 = r3.zzgoa     // Catch:{ InterruptedException -> 0x003a, all -> 0x0025 }
            com.google.android.gms.internal.ads.zzbp$zza r0 = zzang()     // Catch:{ InterruptedException -> 0x003a, all -> 0x0025 }
            r4.put(r0)     // Catch:{ InterruptedException -> 0x003a, all -> 0x0025 }
            goto L_0x003a
        L_0x0031:
            r3.zzakh()
            android.os.HandlerThread r0 = r3.zzdxs
            r0.quit()
            throw r4
        L_0x003a:
            r3.zzakh()
            android.os.HandlerThread r4 = r3.zzdxs
            r4.quit()
            return
        L_0x0043:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdam.onConnected(android.os.Bundle):void");
    }

    public final void onConnectionFailed(ConnectionResult connectionResult) {
        try {
            this.zzgoa.put(zzang());
        } catch (InterruptedException unused) {
        }
    }

    private final void zzakh() {
        if (this.zzgny == null) {
            return;
        }
        if (this.zzgny.isConnected() || this.zzgny.isConnecting()) {
            this.zzgny.disconnect();
        }
    }

    @VisibleForTesting
    private static zzbp.zza zzang() {
        return (zzbp.zza) ((zzdob) zzbp.zza.zzam().zzau(PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID).zzaya());
    }
}
