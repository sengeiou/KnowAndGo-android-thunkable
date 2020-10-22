package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import androidx.annotation.Nullable;

@TargetApi(16)
@zzard
public abstract class zzbgl extends zzbft {
    private final zzbdk zzefq = new zzbdk();
    private boolean zzeih;
    /* access modifiers changed from: private */
    @Nullable
    public String zzeio = null;
    private boolean zzeip;

    public zzbgl(zzbdf zzbdf) {
        super(zzbdf);
        this.zzefq.zza((zzbdo) new zzbgm(this));
    }

    /* access modifiers changed from: protected */
    public abstract zzhn zzfa(String str);

    /* access modifiers changed from: protected */
    public abstract int zzzw();

    public void release() {
        this.zzefq.zzyr();
        super.release();
    }

    /* access modifiers changed from: protected */
    public final String zzey(String str) {
        String valueOf = String.valueOf("cache:");
        String valueOf2 = String.valueOf(super.zzey(str));
        return valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0082, code lost:
        if (android.text.TextUtils.isEmpty(r9.zzeio) != false) goto L_0x008a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0084, code lost:
        r1 = "badUrl";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0088, code lost:
        r14 = r9.zzeio;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x008a, code lost:
        r1 = "externalAbort";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0093, code lost:
        throw new java.io.IOException("Abort requested before buffering finished. ");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:?, code lost:
        java.lang.Thread.sleep(r18);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00f3, code lost:
        r1 = "error";
        r2 = "Sleep interrupted.";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x00fe, code lost:
        throw new java.io.IOException("Interrupted sleep.");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x0131, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x0132, code lost:
        r12 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x0155, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x0156, code lost:
        r12 = r1;
        r14 = r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzex(java.lang.String r34) {
        /*
            r33 = this;
            r9 = r33
            r10 = r34
            com.google.android.gms.internal.ads.zzhn r0 = r33.zzfa(r34)
            java.lang.String r11 = r33.zzey(r34)
            java.lang.String r12 = "error"
            r13 = 0
            r14 = 0
            com.google.android.gms.internal.ads.zzbdk r1 = r9.zzefq     // Catch:{ IOException -> 0x015c }
            boolean r0 = r1.zza((com.google.android.gms.internal.ads.zzhn) r0)     // Catch:{ IOException -> 0x015c }
            if (r0 == 0) goto L_0x0146
            com.google.android.gms.internal.ads.zzbdk r0 = r9.zzefq     // Catch:{ IOException -> 0x015c }
            com.google.android.gms.internal.ads.zzge r0 = r0.zzys()     // Catch:{ IOException -> 0x015c }
            if (r0 == 0) goto L_0x0137
            java.lang.ref.WeakReference r1 = r9.zzeht     // Catch:{ IOException -> 0x015c }
            java.lang.Object r1 = r1.get()     // Catch:{ IOException -> 0x015c }
            com.google.android.gms.internal.ads.zzbdf r1 = (com.google.android.gms.internal.ads.zzbdf) r1     // Catch:{ IOException -> 0x015c }
            if (r1 == 0) goto L_0x002d
            r1.zza((java.lang.String) r11, (com.google.android.gms.internal.ads.zzbft) r9)     // Catch:{ IOException -> 0x015c }
        L_0x002d:
            com.google.android.gms.common.util.Clock r15 = com.google.android.gms.ads.internal.zzk.zzln()     // Catch:{ IOException -> 0x015c }
            long r16 = r15.currentTimeMillis()     // Catch:{ IOException -> 0x015c }
            com.google.android.gms.internal.ads.zzacj<java.lang.Long> r1 = com.google.android.gms.internal.ads.zzacu.zzcly     // Catch:{ IOException -> 0x015c }
            com.google.android.gms.internal.ads.zzacr r2 = com.google.android.gms.internal.ads.zzyt.zzpe()     // Catch:{ IOException -> 0x015c }
            java.lang.Object r1 = r2.zzd(r1)     // Catch:{ IOException -> 0x015c }
            java.lang.Long r1 = (java.lang.Long) r1     // Catch:{ IOException -> 0x015c }
            long r18 = r1.longValue()     // Catch:{ IOException -> 0x015c }
            com.google.android.gms.internal.ads.zzacj<java.lang.Long> r1 = com.google.android.gms.internal.ads.zzacu.zzclx     // Catch:{ IOException -> 0x015c }
            com.google.android.gms.internal.ads.zzacr r2 = com.google.android.gms.internal.ads.zzyt.zzpe()     // Catch:{ IOException -> 0x015c }
            java.lang.Object r1 = r2.zzd(r1)     // Catch:{ IOException -> 0x015c }
            java.lang.Long r1 = (java.lang.Long) r1     // Catch:{ IOException -> 0x015c }
            long r1 = r1.longValue()     // Catch:{ IOException -> 0x015c }
            r3 = 1000(0x3e8, double:4.94E-321)
            long r20 = r1 * r3
            com.google.android.gms.internal.ads.zzacj<java.lang.Integer> r1 = com.google.android.gms.internal.ads.zzacu.zzclw     // Catch:{ IOException -> 0x015c }
            com.google.android.gms.internal.ads.zzacr r2 = com.google.android.gms.internal.ads.zzyt.zzpe()     // Catch:{ IOException -> 0x015c }
            java.lang.Object r1 = r2.zzd(r1)     // Catch:{ IOException -> 0x015c }
            java.lang.Integer r1 = (java.lang.Integer) r1     // Catch:{ IOException -> 0x015c }
            int r1 = r1.intValue()     // Catch:{ IOException -> 0x015c }
            long r6 = (long) r1     // Catch:{ IOException -> 0x015c }
            r1 = -1
        L_0x006c:
            monitor-enter(r33)     // Catch:{ IOException -> 0x015c }
            long r3 = r15.currentTimeMillis()     // Catch:{ all -> 0x0134 }
            r5 = 0
            long r3 = r3 - r16
            int r3 = (r3 > r20 ? 1 : (r3 == r20 ? 0 : -1))
            if (r3 > 0) goto L_0x00ff
            boolean r3 = r9.zzeih     // Catch:{ all -> 0x0134 }
            if (r3 == 0) goto L_0x0094
            java.lang.String r0 = r9.zzeio     // Catch:{ all -> 0x0134 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x0134 }
            if (r0 != 0) goto L_0x008a
            java.lang.String r1 = "badUrl"
            java.lang.String r0 = r9.zzeio     // Catch:{ all -> 0x0131 }
            r14 = r0
            goto L_0x008c
        L_0x008a:
            java.lang.String r1 = "externalAbort"
        L_0x008c:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x0131 }
            java.lang.String r2 = "Abort requested before buffering finished. "
            r0.<init>(r2)     // Catch:{ all -> 0x0131 }
            throw r0     // Catch:{ all -> 0x0131 }
        L_0x0094:
            boolean r3 = r9.zzeip     // Catch:{ all -> 0x0134 }
            r22 = 1
            if (r3 == 0) goto L_0x009c
            monitor-exit(r33)     // Catch:{ all -> 0x0134 }
            goto L_0x00e6
        L_0x009c:
            long r4 = r0.getDuration()     // Catch:{ all -> 0x0134 }
            r23 = 0
            int r3 = (r4 > r23 ? 1 : (r4 == r23 ? 0 : -1))
            if (r3 <= 0) goto L_0x00e9
            long r25 = r0.getBufferedPosition()     // Catch:{ all -> 0x0134 }
            int r3 = (r25 > r1 ? 1 : (r25 == r1 ? 0 : -1))
            if (r3 == 0) goto L_0x00ca
            int r1 = (r25 > r23 ? 1 : (r25 == r23 ? 0 : -1))
            if (r1 <= 0) goto L_0x00b4
            r8 = 1
            goto L_0x00b5
        L_0x00b4:
            r8 = 0
        L_0x00b5:
            r1 = r33
            r2 = r34
            r3 = r11
            r27 = r4
            r4 = r25
            r29 = r6
            r6 = r27
            r1.zza(r2, r3, r4, r6, r8)     // Catch:{ all -> 0x0134 }
            r3 = r25
            r1 = r27
            goto L_0x00d1
        L_0x00ca:
            r29 = r6
            r31 = r1
            r1 = r4
            r3 = r31
        L_0x00d1:
            int r5 = (r25 > r1 ? 1 : (r25 == r1 ? 0 : -1))
            if (r5 < 0) goto L_0x00da
            r9.zzb(r10, r11, r1)     // Catch:{ all -> 0x0134 }
            monitor-exit(r33)     // Catch:{ all -> 0x0134 }
            goto L_0x00e6
        L_0x00da:
            r33.zzzw()     // Catch:{ all -> 0x0134 }
            int r1 = (r23 > r29 ? 1 : (r23 == r29 ? 0 : -1))
            if (r1 < 0) goto L_0x00e7
            int r1 = (r25 > r23 ? 1 : (r25 == r23 ? 0 : -1))
            if (r1 <= 0) goto L_0x00e7
            monitor-exit(r33)     // Catch:{ all -> 0x0134 }
        L_0x00e6:
            return r22
        L_0x00e7:
            r1 = r3
            goto L_0x00eb
        L_0x00e9:
            r29 = r6
        L_0x00eb:
            monitor-exit(r33)     // Catch:{ all -> 0x0134 }
            java.lang.Thread.sleep(r18)     // Catch:{ InterruptedException -> 0x00f3 }
            r6 = r29
            goto L_0x006c
        L_0x00f3:
            java.lang.String r1 = "error"
            java.lang.String r2 = "Sleep interrupted."
            java.io.IOException r0 = new java.io.IOException     // Catch:{ IOException -> 0x0155 }
            java.lang.String r3 = "Interrupted sleep."
            r0.<init>(r3)     // Catch:{ IOException -> 0x0155 }
            throw r0     // Catch:{ IOException -> 0x0155 }
        L_0x00ff:
            java.lang.String r1 = "downloadTimeout"
            java.lang.String r0 = java.lang.Long.toString(r20)     // Catch:{ all -> 0x0131 }
            java.lang.String r2 = java.lang.String.valueOf(r0)     // Catch:{ all -> 0x0131 }
            int r2 = r2.length()     // Catch:{ all -> 0x0131 }
            int r2 = r2 + 27
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0131 }
            r3.<init>(r2)     // Catch:{ all -> 0x0131 }
            java.lang.String r2 = "Timeout reached. Limit: "
            r3.append(r2)     // Catch:{ all -> 0x0131 }
            r3.append(r0)     // Catch:{ all -> 0x0131 }
            java.lang.String r0 = " ms"
            r3.append(r0)     // Catch:{ all -> 0x0131 }
            java.lang.String r2 = r3.toString()     // Catch:{ all -> 0x0131 }
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x012d }
            java.lang.String r3 = "Timed out while buffering."
            r0.<init>(r3)     // Catch:{ all -> 0x012d }
            throw r0     // Catch:{ all -> 0x012d }
        L_0x012d:
            r0 = move-exception
            r12 = r1
            r14 = r2
            goto L_0x0135
        L_0x0131:
            r0 = move-exception
            r12 = r1
            goto L_0x0135
        L_0x0134:
            r0 = move-exception
        L_0x0135:
            monitor-exit(r33)     // Catch:{ all -> 0x0134 }
            throw r0     // Catch:{ IOException -> 0x015c }
        L_0x0137:
            java.lang.String r1 = "playerFailed"
            java.lang.String r2 = "ExoPlayer not created"
            r33.release()     // Catch:{ IOException -> 0x0155 }
            java.io.IOException r0 = new java.io.IOException     // Catch:{ IOException -> 0x0155 }
            java.lang.String r3 = "Failed to get ExoPlayer"
            r0.<init>(r3)     // Catch:{ IOException -> 0x0155 }
            throw r0     // Catch:{ IOException -> 0x0155 }
        L_0x0146:
            java.lang.String r1 = "playerFailed"
            java.lang.String r2 = "ExoPlayer prepare failed"
            r33.release()     // Catch:{ IOException -> 0x0155 }
            java.io.IOException r0 = new java.io.IOException     // Catch:{ IOException -> 0x0155 }
            java.lang.String r3 = "Failed to prepare AdExoPlayerHelper"
            r0.<init>(r3)     // Catch:{ IOException -> 0x0155 }
            throw r0     // Catch:{ IOException -> 0x0155 }
        L_0x0155:
            r0 = move-exception
            r12 = r1
            r14 = r2
            goto L_0x015d
        L_0x0159:
            r0 = move-exception
            r12 = r1
            goto L_0x015d
        L_0x015c:
            r0 = move-exception
        L_0x015d:
            java.lang.String r0 = r0.getMessage()
            java.lang.String r1 = java.lang.String.valueOf(r34)
            int r1 = r1.length()
            int r1 = r1 + 34
            java.lang.String r2 = java.lang.String.valueOf(r0)
            int r2 = r2.length()
            int r1 = r1 + r2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r1)
            java.lang.String r1 = "Failed to preload url "
            r2.append(r1)
            r2.append(r10)
            java.lang.String r1 = " Exception: "
            r2.append(r1)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            com.google.android.gms.internal.ads.zzawz.zzep(r0)
            r9.zza(r10, r11, r12, r14)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbgl.zzex(java.lang.String):boolean");
    }

    public final void abort() {
        synchronized (this) {
            this.zzeih = true;
        }
    }

    public final void zzzx() {
        synchronized (this) {
            this.zzeip = true;
            this.zzefq.removeListener();
        }
    }

    public final zzbdk zzzy() {
        return this.zzefq;
    }
}
