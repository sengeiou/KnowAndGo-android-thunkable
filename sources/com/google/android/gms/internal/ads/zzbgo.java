package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

@zzard
public final class zzbgo extends zzbft implements zzsj<zzrv> {
    private String url;
    private ByteBuffer zzaxl;
    private final zzbde zzefp;
    private boolean zzeih;
    private final zzbfl zzeii = new zzbfl();
    private boolean zzeij;
    private final Object zzeik = new Object();
    private boolean zzeil;
    private final zzbgn zzeit = new zzbgn();

    public zzbgo(zzbdf zzbdf, zzbde zzbde) {
        super(zzbdf);
        this.zzefp = zzbde;
    }

    public final /* bridge */ /* synthetic */ void zzc(Object obj, int i) {
    }

    public final /* bridge */ /* synthetic */ void zze(Object obj) {
    }

    public final String getUrl() {
        return this.url;
    }

    public final boolean zzzv() {
        return this.zzeil;
    }

    /* access modifiers changed from: protected */
    public final String zzey(String str) {
        String valueOf = String.valueOf("cache:");
        String valueOf2 = String.valueOf(super.zzey(str));
        return valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
    }

    private final void zzxt() {
        int zzzz = (int) this.zzeit.zzzz();
        int zzl = (int) this.zzeii.zzl(this.zzaxl);
        int position = this.zzaxl.position();
        int round = Math.round(((float) zzl) * (((float) position) / ((float) zzzz)));
        zza(this.url, zzey(this.url), position, zzzz, (long) round, (long) zzl, round > 0, zzbfa.zzyp(), zzbfa.zzyq());
    }

    /* JADX WARNING: type inference failed for: r1v30, types: [com.google.android.gms.internal.ads.zzbex] */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00c2, code lost:
        if (r9.zzaxl.remaining() > 0) goto L_0x00c9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00c4, code lost:
        zzxt();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00cb, code lost:
        if (r9.zzeih != false) goto L_0x010d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00cd, code lost:
        r12 = r1.currentTimeMillis();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00d6, code lost:
        if ((r12 - r16) < r4) goto L_0x00dd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00d8, code lost:
        zzxt();
        r16 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00e5, code lost:
        if ((r12 - r2) > (1000 * r6)) goto L_0x00ed;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:?, code lost:
        r1 = new java.lang.StringBuilder(49);
        r1.append("Timeout exceeded. Limit: ");
        r1.append(r6);
        r1.append(" sec");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x010c, code lost:
        throw new java.io.IOException(r1.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x010d, code lost:
        r12 = "externalAbort";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:?, code lost:
        r1 = r9.zzaxl.limit();
        r3 = new java.lang.StringBuilder(35);
        r3.append("Precache abort at ");
        r3.append(r1);
        r3.append(" bytes");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0132, code lost:
        throw new java.io.IOException(r3.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0138, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0139, code lost:
        r12 = r18;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:?, code lost:
        return true;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzex(java.lang.String r22) {
        /*
            r21 = this;
            r9 = r21
            r10 = r22
            r9.url = r10
            java.lang.String r11 = r21.zzey(r22)
            java.lang.String r12 = "error"
            r13 = 0
            com.google.android.gms.internal.ads.zzsa r0 = new com.google.android.gms.internal.ads.zzsa     // Catch:{ Exception -> 0x013e }
            java.lang.String r2 = r9.zzdyb     // Catch:{ Exception -> 0x013e }
            r3 = 0
            com.google.android.gms.internal.ads.zzbde r1 = r9.zzefp     // Catch:{ Exception -> 0x013e }
            int r5 = r1.zzeef     // Catch:{ Exception -> 0x013e }
            com.google.android.gms.internal.ads.zzbde r1 = r9.zzefp     // Catch:{ Exception -> 0x013e }
            int r6 = r1.zzeeh     // Catch:{ Exception -> 0x013e }
            r7 = 1
            r8 = 0
            r1 = r0
            r4 = r21
            r1.<init>(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x013e }
            com.google.android.gms.internal.ads.zzbde r1 = r9.zzefp     // Catch:{ Exception -> 0x013e }
            boolean r1 = r1.zzeel     // Catch:{ Exception -> 0x013e }
            if (r1 == 0) goto L_0x0035
            com.google.android.gms.internal.ads.zzbex r1 = new com.google.android.gms.internal.ads.zzbex     // Catch:{ Exception -> 0x0032 }
            android.content.Context r2 = r9.mContext     // Catch:{ Exception -> 0x0032 }
            r3 = 0
            r1.<init>(r2, r0, r3, r3)     // Catch:{ Exception -> 0x0032 }
            r0 = r1
            goto L_0x0035
        L_0x0032:
            r0 = move-exception
            goto L_0x0141
        L_0x0035:
            android.net.Uri r1 = android.net.Uri.parse(r22)     // Catch:{ Exception -> 0x013e }
            com.google.android.gms.internal.ads.zzry r2 = new com.google.android.gms.internal.ads.zzry     // Catch:{ Exception -> 0x013e }
            r2.<init>(r1)     // Catch:{ Exception -> 0x013e }
            r0.zza(r2)     // Catch:{ Exception -> 0x013e }
            java.lang.ref.WeakReference r1 = r9.zzeht     // Catch:{ Exception -> 0x013e }
            java.lang.Object r1 = r1.get()     // Catch:{ Exception -> 0x013e }
            com.google.android.gms.internal.ads.zzbdf r1 = (com.google.android.gms.internal.ads.zzbdf) r1     // Catch:{ Exception -> 0x013e }
            if (r1 == 0) goto L_0x004e
            r1.zza((java.lang.String) r11, (com.google.android.gms.internal.ads.zzbft) r9)     // Catch:{ Exception -> 0x0032 }
        L_0x004e:
            com.google.android.gms.common.util.Clock r1 = com.google.android.gms.ads.internal.zzk.zzln()     // Catch:{ Exception -> 0x013e }
            long r2 = r1.currentTimeMillis()     // Catch:{ Exception -> 0x013e }
            com.google.android.gms.internal.ads.zzacj<java.lang.Long> r4 = com.google.android.gms.internal.ads.zzacu.zzcly     // Catch:{ Exception -> 0x013e }
            com.google.android.gms.internal.ads.zzacr r5 = com.google.android.gms.internal.ads.zzyt.zzpe()     // Catch:{ Exception -> 0x013e }
            java.lang.Object r4 = r5.zzd(r4)     // Catch:{ Exception -> 0x013e }
            java.lang.Long r4 = (java.lang.Long) r4     // Catch:{ Exception -> 0x013e }
            long r4 = r4.longValue()     // Catch:{ Exception -> 0x013e }
            com.google.android.gms.internal.ads.zzacj<java.lang.Long> r6 = com.google.android.gms.internal.ads.zzacu.zzclx     // Catch:{ Exception -> 0x013e }
            com.google.android.gms.internal.ads.zzacr r7 = com.google.android.gms.internal.ads.zzyt.zzpe()     // Catch:{ Exception -> 0x013e }
            java.lang.Object r6 = r7.zzd(r6)     // Catch:{ Exception -> 0x013e }
            java.lang.Long r6 = (java.lang.Long) r6     // Catch:{ Exception -> 0x013e }
            long r6 = r6.longValue()     // Catch:{ Exception -> 0x013e }
            com.google.android.gms.internal.ads.zzbde r8 = r9.zzefp     // Catch:{ Exception -> 0x013e }
            int r8 = r8.zzeee     // Catch:{ Exception -> 0x013e }
            java.nio.ByteBuffer r8 = java.nio.ByteBuffer.allocate(r8)     // Catch:{ Exception -> 0x013e }
            r9.zzaxl = r8     // Catch:{ Exception -> 0x013e }
            r8 = 8192(0x2000, float:1.14794E-41)
            byte[] r15 = new byte[r8]     // Catch:{ Exception -> 0x013e }
            r16 = r2
        L_0x0086:
            java.nio.ByteBuffer r14 = r9.zzaxl     // Catch:{ Exception -> 0x013e }
            int r14 = r14.remaining()     // Catch:{ Exception -> 0x013e }
            int r14 = java.lang.Math.min(r14, r8)     // Catch:{ Exception -> 0x013e }
            int r14 = r0.read(r15, r13, r14)     // Catch:{ Exception -> 0x013e }
            r8 = -1
            if (r14 != r8) goto L_0x00a9
            r8 = 1
            r9.zzeil = r8     // Catch:{ Exception -> 0x0032 }
            com.google.android.gms.internal.ads.zzbfl r0 = r9.zzeii     // Catch:{ Exception -> 0x0032 }
            java.nio.ByteBuffer r1 = r9.zzaxl     // Catch:{ Exception -> 0x0032 }
            long r0 = r0.zzl(r1)     // Catch:{ Exception -> 0x0032 }
            int r0 = (int) r0     // Catch:{ Exception -> 0x0032 }
            long r0 = (long) r0     // Catch:{ Exception -> 0x0032 }
            r9.zzb(r10, r11, r0)     // Catch:{ Exception -> 0x0032 }
        L_0x00a7:
            r1 = 1
            goto L_0x00c8
        L_0x00a9:
            java.lang.Object r8 = r9.zzeik     // Catch:{ Exception -> 0x013e }
            monitor-enter(r8)     // Catch:{ Exception -> 0x013e }
            boolean r13 = r9.zzeih     // Catch:{ all -> 0x0133 }
            if (r13 != 0) goto L_0x00b9
            java.nio.ByteBuffer r13 = r9.zzaxl     // Catch:{ all -> 0x0133 }
            r18 = r12
            r12 = 0
            r13.put(r15, r12, r14)     // Catch:{ all -> 0x013c }
            goto L_0x00bb
        L_0x00b9:
            r18 = r12
        L_0x00bb:
            monitor-exit(r8)     // Catch:{ all -> 0x013c }
            java.nio.ByteBuffer r8 = r9.zzaxl     // Catch:{ Exception -> 0x0138 }
            int r8 = r8.remaining()     // Catch:{ Exception -> 0x0138 }
            if (r8 > 0) goto L_0x00c9
            r21.zzxt()     // Catch:{ Exception -> 0x0138 }
            goto L_0x00a7
        L_0x00c8:
            return r1
        L_0x00c9:
            boolean r8 = r9.zzeih     // Catch:{ Exception -> 0x0138 }
            if (r8 != 0) goto L_0x010d
            long r12 = r1.currentTimeMillis()     // Catch:{ Exception -> 0x0138 }
            r8 = 0
            long r19 = r12 - r16
            int r8 = (r19 > r4 ? 1 : (r19 == r4 ? 0 : -1))
            if (r8 < 0) goto L_0x00dd
            r21.zzxt()     // Catch:{ Exception -> 0x0138 }
            r16 = r12
        L_0x00dd:
            r8 = 0
            long r12 = r12 - r2
            r19 = 1000(0x3e8, double:4.94E-321)
            long r19 = r19 * r6
            int r8 = (r12 > r19 ? 1 : (r12 == r19 ? 0 : -1))
            if (r8 > 0) goto L_0x00ed
            r12 = r18
            r8 = 8192(0x2000, float:1.14794E-41)
            r13 = 0
            goto L_0x0086
        L_0x00ed:
            java.lang.String r12 = "downloadTimeout"
            r0 = 49
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0032 }
            r1.<init>(r0)     // Catch:{ Exception -> 0x0032 }
            java.lang.String r0 = "Timeout exceeded. Limit: "
            r1.append(r0)     // Catch:{ Exception -> 0x0032 }
            r1.append(r6)     // Catch:{ Exception -> 0x0032 }
            java.lang.String r0 = " sec"
            r1.append(r0)     // Catch:{ Exception -> 0x0032 }
            java.lang.String r0 = r1.toString()     // Catch:{ Exception -> 0x0032 }
            java.io.IOException r1 = new java.io.IOException     // Catch:{ Exception -> 0x0032 }
            r1.<init>(r0)     // Catch:{ Exception -> 0x0032 }
            throw r1     // Catch:{ Exception -> 0x0032 }
        L_0x010d:
            java.lang.String r12 = "externalAbort"
            java.io.IOException r0 = new java.io.IOException     // Catch:{ Exception -> 0x0032 }
            java.nio.ByteBuffer r1 = r9.zzaxl     // Catch:{ Exception -> 0x0032 }
            int r1 = r1.limit()     // Catch:{ Exception -> 0x0032 }
            r2 = 35
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0032 }
            r3.<init>(r2)     // Catch:{ Exception -> 0x0032 }
            java.lang.String r2 = "Precache abort at "
            r3.append(r2)     // Catch:{ Exception -> 0x0032 }
            r3.append(r1)     // Catch:{ Exception -> 0x0032 }
            java.lang.String r1 = " bytes"
            r3.append(r1)     // Catch:{ Exception -> 0x0032 }
            java.lang.String r1 = r3.toString()     // Catch:{ Exception -> 0x0032 }
            r0.<init>(r1)     // Catch:{ Exception -> 0x0032 }
            throw r0     // Catch:{ Exception -> 0x0032 }
        L_0x0133:
            r0 = move-exception
            r18 = r12
        L_0x0136:
            monitor-exit(r8)     // Catch:{ all -> 0x013c }
            throw r0     // Catch:{ Exception -> 0x0138 }
        L_0x0138:
            r0 = move-exception
            r12 = r18
            goto L_0x0141
        L_0x013c:
            r0 = move-exception
            goto L_0x0136
        L_0x013e:
            r0 = move-exception
            r18 = r12
        L_0x0141:
            java.lang.Class r1 = r0.getClass()
            java.lang.String r1 = r1.getCanonicalName()
            java.lang.String r0 = r0.getMessage()
            java.lang.String r2 = java.lang.String.valueOf(r1)
            int r2 = r2.length()
            r3 = 1
            int r2 = r2 + r3
            java.lang.String r3 = java.lang.String.valueOf(r0)
            int r3 = r3.length()
            int r2 = r2 + r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r2)
            r3.append(r1)
            java.lang.String r1 = ":"
            r3.append(r1)
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            java.lang.String r1 = java.lang.String.valueOf(r22)
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
            java.lang.String r1 = r2.toString()
            com.google.android.gms.internal.ads.zzawz.zzep(r1)
            r9.zza(r10, r11, r12, r0)
            r1 = 0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbgo.zzex(java.lang.String):boolean");
    }

    public final void abort() {
        this.zzeih = true;
    }

    public final ByteBuffer getByteBuffer() {
        synchronized (this.zzeik) {
            if (this.zzaxl != null && !this.zzeij) {
                this.zzaxl.flip();
                this.zzeij = true;
            }
            this.zzeih = true;
        }
        return this.zzaxl;
    }

    public final /* synthetic */ void zza(Object obj, zzry zzry) {
        zzrv zzrv = (zzrv) obj;
        if (zzrv instanceof zzsa) {
            this.zzeit.zza((zzsa) zzrv);
        }
    }
}
