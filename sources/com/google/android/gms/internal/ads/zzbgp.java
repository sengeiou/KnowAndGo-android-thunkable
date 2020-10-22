package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import org.apache.logging.log4j.message.ParameterizedMessage;

@TargetApi(16)
@zzard
public final class zzbgp extends zzbft implements zzbfi {
    private String zzecf;
    private boolean zzeih;
    private zzbfa zzeiu;
    private Exception zzeiv;
    private boolean zzeiw;

    public zzbgp(zzbdf zzbdf, zzbde zzbde) {
        super(zzbdf);
        this.zzeiu = new zzbfa(zzbdf.getContext(), zzbde);
        this.zzeiu.zza((zzbfi) this);
    }

    public final void zzde(int i) {
    }

    public final void zzo(int i, int i2) {
    }

    public final void zzd(boolean z, long j) {
        zzbdf zzbdf = (zzbdf) this.zzeht.get();
        if (zzbdf != null) {
            zzbbm.zzeae.execute(new zzbgq(zzbdf, z, j));
        }
    }

    public final void zza(String str, Exception exc) {
        this.zzeiv = exc;
        zzawz.zzd("Precache error", exc);
        zzfb(str);
    }

    public final void zzcz(int i) {
        this.zzeiu.zzzu().zzdh(i);
    }

    public final void zzcy(int i) {
        this.zzeiu.zzzu().zzdg(i);
    }

    public final void zzda(int i) {
        this.zzeiu.zzzu().zzda(i);
    }

    public final void zzdb(int i) {
        this.zzeiu.zzzu().zzdb(i);
    }

    public final void release() {
        if (this.zzeiu != null) {
            this.zzeiu.zza((zzbfi) null);
            this.zzeiu.release();
        }
        super.release();
    }

    /* access modifiers changed from: protected */
    public final String zzey(String str) {
        String valueOf = String.valueOf("cache:");
        String valueOf2 = String.valueOf(super.zzey(str));
        return valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
    }

    public final boolean zzex(String str) {
        return zze(str, new String[]{str});
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0088, code lost:
        if (r11.zzeiv == null) goto L_0x008f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x008e, code lost:
        throw r11.zzeiv;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x008f, code lost:
        r1 = "externalAbort";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0098, code lost:
        throw new java.io.IOException("Abort requested before buffering finished. ");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zze(java.lang.String r33, java.lang.String[] r34) {
        /*
            r32 = this;
            r11 = r32
            r12 = r33
            r0 = r34
            r11.zzecf = r12
            java.lang.String r13 = r32.zzey(r33)
            java.lang.String r14 = "error"
            int r1 = r0.length     // Catch:{ Exception -> 0x0166 }
            android.net.Uri[] r1 = new android.net.Uri[r1]     // Catch:{ Exception -> 0x0166 }
            r2 = 0
        L_0x0012:
            int r3 = r0.length     // Catch:{ Exception -> 0x0166 }
            if (r2 >= r3) goto L_0x0023
            r3 = r0[r2]     // Catch:{ Exception -> 0x0020 }
            android.net.Uri r3 = android.net.Uri.parse(r3)     // Catch:{ Exception -> 0x0020 }
            r1[r2] = r3     // Catch:{ Exception -> 0x0020 }
            int r2 = r2 + 1
            goto L_0x0012
        L_0x0020:
            r0 = move-exception
            goto L_0x0169
        L_0x0023:
            com.google.android.gms.internal.ads.zzbfa r0 = r11.zzeiu     // Catch:{ Exception -> 0x0166 }
            java.lang.String r2 = r11.zzdyb     // Catch:{ Exception -> 0x0166 }
            r0.zza((android.net.Uri[]) r1, (java.lang.String) r2)     // Catch:{ Exception -> 0x0166 }
            java.lang.ref.WeakReference r0 = r11.zzeht     // Catch:{ Exception -> 0x0166 }
            java.lang.Object r0 = r0.get()     // Catch:{ Exception -> 0x0166 }
            com.google.android.gms.internal.ads.zzbdf r0 = (com.google.android.gms.internal.ads.zzbdf) r0     // Catch:{ Exception -> 0x0166 }
            if (r0 == 0) goto L_0x0037
            r0.zza((java.lang.String) r13, (com.google.android.gms.internal.ads.zzbft) r11)     // Catch:{ Exception -> 0x0020 }
        L_0x0037:
            com.google.android.gms.common.util.Clock r0 = com.google.android.gms.ads.internal.zzk.zzln()     // Catch:{ Exception -> 0x0166 }
            long r16 = r0.currentTimeMillis()     // Catch:{ Exception -> 0x0166 }
            com.google.android.gms.internal.ads.zzacj<java.lang.Long> r1 = com.google.android.gms.internal.ads.zzacu.zzcly     // Catch:{ Exception -> 0x0166 }
            com.google.android.gms.internal.ads.zzacr r2 = com.google.android.gms.internal.ads.zzyt.zzpe()     // Catch:{ Exception -> 0x0166 }
            java.lang.Object r1 = r2.zzd(r1)     // Catch:{ Exception -> 0x0166 }
            java.lang.Long r1 = (java.lang.Long) r1     // Catch:{ Exception -> 0x0166 }
            long r9 = r1.longValue()     // Catch:{ Exception -> 0x0166 }
            com.google.android.gms.internal.ads.zzacj<java.lang.Long> r1 = com.google.android.gms.internal.ads.zzacu.zzclx     // Catch:{ Exception -> 0x0166 }
            com.google.android.gms.internal.ads.zzacr r2 = com.google.android.gms.internal.ads.zzyt.zzpe()     // Catch:{ Exception -> 0x0166 }
            java.lang.Object r1 = r2.zzd(r1)     // Catch:{ Exception -> 0x0166 }
            java.lang.Long r1 = (java.lang.Long) r1     // Catch:{ Exception -> 0x0166 }
            long r1 = r1.longValue()     // Catch:{ Exception -> 0x0166 }
            r3 = 1000(0x3e8, double:4.94E-321)
            long r6 = r1 * r3
            com.google.android.gms.internal.ads.zzacj<java.lang.Integer> r1 = com.google.android.gms.internal.ads.zzacu.zzclw     // Catch:{ Exception -> 0x0166 }
            com.google.android.gms.internal.ads.zzacr r2 = com.google.android.gms.internal.ads.zzyt.zzpe()     // Catch:{ Exception -> 0x0166 }
            java.lang.Object r1 = r2.zzd(r1)     // Catch:{ Exception -> 0x0166 }
            java.lang.Integer r1 = (java.lang.Integer) r1     // Catch:{ Exception -> 0x0166 }
            int r1 = r1.intValue()     // Catch:{ Exception -> 0x0166 }
            long r4 = (long) r1     // Catch:{ Exception -> 0x0166 }
            r1 = -1
        L_0x0076:
            monitor-enter(r32)     // Catch:{ Exception -> 0x0166 }
            long r18 = r0.currentTimeMillis()     // Catch:{ all -> 0x015f }
            r3 = 0
            long r18 = r18 - r16
            int r3 = (r18 > r6 ? 1 : (r18 == r6 ? 0 : -1))
            if (r3 > 0) goto L_0x0132
            boolean r3 = r11.zzeih     // Catch:{ all -> 0x015f }
            if (r3 == 0) goto L_0x0099
            java.lang.Exception r0 = r11.zzeiv     // Catch:{ all -> 0x0164 }
            if (r0 == 0) goto L_0x008f
            java.lang.String r1 = "badUrl"
            java.lang.Exception r0 = r11.zzeiv     // Catch:{ all -> 0x0158 }
            throw r0     // Catch:{ all -> 0x0158 }
        L_0x008f:
            java.lang.String r1 = "externalAbort"
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x0158 }
            java.lang.String r2 = "Abort requested before buffering finished. "
            r0.<init>(r2)     // Catch:{ all -> 0x0158 }
            throw r0     // Catch:{ all -> 0x0158 }
        L_0x0099:
            boolean r3 = r11.zzeiw     // Catch:{ all -> 0x015f }
            r18 = 1
            if (r3 == 0) goto L_0x00a2
            monitor-exit(r32)     // Catch:{ all -> 0x0164 }
            goto L_0x0103
        L_0x00a2:
            com.google.android.gms.internal.ads.zzbfa r3 = r11.zzeiu     // Catch:{ all -> 0x015f }
            com.google.android.gms.internal.ads.zzkv r3 = r3.zzzt()     // Catch:{ all -> 0x015f }
            if (r3 == 0) goto L_0x0126
            r20 = r14
            long r14 = r3.getDuration()     // Catch:{ all -> 0x015b }
            r21 = 0
            int r8 = (r14 > r21 ? 1 : (r14 == r21 ? 0 : -1))
            if (r8 <= 0) goto L_0x0108
            long r23 = r3.getBufferedPosition()     // Catch:{ all -> 0x015b }
            int r3 = (r23 > r1 ? 1 : (r23 == r1 ? 0 : -1))
            if (r3 == 0) goto L_0x00e5
            int r1 = (r23 > r21 ? 1 : (r23 == r21 ? 0 : -1))
            if (r1 <= 0) goto L_0x00c4
            r8 = 1
            goto L_0x00c5
        L_0x00c4:
            r8 = 0
        L_0x00c5:
            int r19 = com.google.android.gms.internal.ads.zzbfa.zzyp()     // Catch:{ all -> 0x015b }
            int r25 = com.google.android.gms.internal.ads.zzbfa.zzyq()     // Catch:{ all -> 0x015b }
            r1 = r32
            r2 = r33
            r3 = r13
            r26 = r4
            r4 = r23
            r28 = r6
            r6 = r14
            r30 = r9
            r9 = r19
            r10 = r25
            r1.zza((java.lang.String) r2, (java.lang.String) r3, (long) r4, (long) r6, (boolean) r8, (int) r9, (int) r10)     // Catch:{ all -> 0x015b }
            r1 = r23
            goto L_0x00eb
        L_0x00e5:
            r26 = r4
            r28 = r6
            r30 = r9
        L_0x00eb:
            int r3 = (r23 > r14 ? 1 : (r23 == r14 ? 0 : -1))
            if (r3 < 0) goto L_0x00f4
            r11.zzb(r12, r13, r14)     // Catch:{ all -> 0x015b }
            monitor-exit(r32)     // Catch:{ all -> 0x015b }
            goto L_0x0103
        L_0x00f4:
            com.google.android.gms.internal.ads.zzbfa r3 = r11.zzeiu     // Catch:{ all -> 0x015b }
            long r3 = r3.getBytesTransferred()     // Catch:{ all -> 0x015b }
            int r3 = (r3 > r26 ? 1 : (r3 == r26 ? 0 : -1))
            if (r3 < 0) goto L_0x0104
            int r3 = (r23 > r21 ? 1 : (r23 == r21 ? 0 : -1))
            if (r3 <= 0) goto L_0x0104
            monitor-exit(r32)     // Catch:{ all -> 0x015b }
        L_0x0103:
            return r18
        L_0x0104:
            r3 = r1
            r1 = r30
            goto L_0x010e
        L_0x0108:
            r26 = r4
            r28 = r6
            r3 = r1
            r1 = r9
        L_0x010e:
            r11.wait(r1)     // Catch:{ InterruptedException -> 0x011c }
            monitor-exit(r32)     // Catch:{ all -> 0x015b }
            r9 = r1
            r1 = r3
            r14 = r20
            r4 = r26
            r6 = r28
            goto L_0x0076
        L_0x011c:
            java.lang.String r1 = "interrupted"
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x0158 }
            java.lang.String r2 = "Wait interrupted."
            r0.<init>(r2)     // Catch:{ all -> 0x0158 }
            throw r0     // Catch:{ all -> 0x0158 }
        L_0x0126:
            r20 = r14
            java.lang.String r1 = "exoPlayerReleased"
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x0158 }
            java.lang.String r2 = "ExoPlayer was released during preloading."
            r0.<init>(r2)     // Catch:{ all -> 0x0158 }
            throw r0     // Catch:{ all -> 0x0158 }
        L_0x0132:
            r28 = r6
            r20 = r14
            java.lang.String r1 = "downloadTimeout"
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x0158 }
            r2 = 47
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0158 }
            r3.<init>(r2)     // Catch:{ all -> 0x0158 }
            java.lang.String r2 = "Timeout reached. Limit: "
            r3.append(r2)     // Catch:{ all -> 0x0158 }
            r4 = r28
            r3.append(r4)     // Catch:{ all -> 0x0158 }
            java.lang.String r2 = " ms"
            r3.append(r2)     // Catch:{ all -> 0x0158 }
            java.lang.String r2 = r3.toString()     // Catch:{ all -> 0x0158 }
            r0.<init>(r2)     // Catch:{ all -> 0x0158 }
            throw r0     // Catch:{ all -> 0x0158 }
        L_0x0158:
            r0 = move-exception
            r14 = r1
            goto L_0x0162
        L_0x015b:
            r0 = move-exception
            r14 = r20
            goto L_0x0162
        L_0x015f:
            r0 = move-exception
            r20 = r14
        L_0x0162:
            monitor-exit(r32)     // Catch:{ all -> 0x0164 }
            throw r0     // Catch:{ Exception -> 0x0020 }
        L_0x0164:
            r0 = move-exception
            goto L_0x0162
        L_0x0166:
            r0 = move-exception
            r20 = r14
        L_0x0169:
            java.lang.String r1 = r0.getMessage()
            java.lang.String r2 = java.lang.String.valueOf(r33)
            int r2 = r2.length()
            int r2 = r2 + 34
            java.lang.String r3 = java.lang.String.valueOf(r1)
            int r3 = r3.length()
            int r2 = r2 + r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r2)
            java.lang.String r2 = "Failed to preload url "
            r3.append(r2)
            r3.append(r12)
            java.lang.String r2 = " Exception: "
            r3.append(r2)
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            com.google.android.gms.internal.ads.zzawz.zzep(r1)
            r32.release()
            java.lang.String r0 = zzb(r14, r0)
            r11.zza(r12, r13, r14, r0)
            r1 = 0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbgp.zze(java.lang.String, java.lang.String[]):boolean");
    }

    public final void abort() {
        zzfb((String) null);
    }

    private final void zzfb(String str) {
        synchronized (this) {
            this.zzeih = true;
            notify();
            release();
        }
        if (this.zzecf != null) {
            String zzey = zzey(this.zzecf);
            if (this.zzeiv != null) {
                zza(this.zzecf, zzey, "badUrl", zzb(str, this.zzeiv));
            } else {
                zza(this.zzecf, zzey, "externalAbort", "Programmatic precache abort.");
            }
        }
    }

    public final zzbfa zzaaa() {
        synchronized (this) {
            this.zzeiw = true;
            notify();
        }
        this.zzeiu.zza((zzbfi) null);
        zzbfa zzbfa = this.zzeiu;
        this.zzeiu = null;
        return zzbfa;
    }

    private static String zzb(String str, Exception exc) {
        String canonicalName = exc.getClass().getCanonicalName();
        String message = exc.getMessage();
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 2 + String.valueOf(canonicalName).length() + String.valueOf(message).length());
        sb.append(str);
        sb.append("/");
        sb.append(canonicalName);
        sb.append(ParameterizedMessage.ERROR_MSG_SEPARATOR);
        sb.append(message);
        return sb.toString();
    }
}
