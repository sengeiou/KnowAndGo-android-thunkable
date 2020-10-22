package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.common.util.IOUtils;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;

@zzard
public final class zzbeh implements zzjp {
    private boolean isOpen;
    private InputStream zzegc;
    private final zzjp zzegd;
    private final WeakReference<zzbei> zzege;
    private final Context zzlj;

    public zzbeh(Context context, zzjp zzjp, zzbei zzbei) {
        this.zzlj = context;
        this.zzegd = zzjp;
        this.zzege = new WeakReference<>(zzbei);
    }

    public final void close() throws IOException {
        if (this.isOpen) {
            this.isOpen = false;
            if (this.zzegc != null) {
                IOUtils.closeQuietly((Closeable) this.zzegc);
                this.zzegc = null;
                return;
            }
            this.zzegd.close();
            return;
        }
        throw new IOException("Attempt to close an already closed CacheDataSource.");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x009a, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        r4.cancel(true);
        java.lang.Thread.currentThread().interrupt();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        r4.cancel(true);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00da, code lost:
        r4 = com.google.android.gms.ads.internal.zzk.zzln().elapsedRealtime() - r9;
        r2 = (com.google.android.gms.internal.ads.zzbei) r1.zzege.get();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00eb, code lost:
        if (r2 != null) goto L_0x00ed;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00ed, code lost:
        r2.zzd(false, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00f0, code lost:
        r2 = new java.lang.StringBuilder(44);
        r2.append("Cache connection took ");
        r2.append(r4);
        r2.append("ms");
        com.google.android.gms.internal.ads.zzawz.zzds(r2.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x010a, code lost:
        r2 = com.google.android.gms.ads.internal.zzk.zzln().elapsedRealtime() - r9;
        r4 = (com.google.android.gms.internal.ads.zzbei) r1.zzege.get();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x011b, code lost:
        if (r4 != null) goto L_0x011d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x011d, code lost:
        r4.zzd(false, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0120, code lost:
        r4 = new java.lang.StringBuilder(44);
        r5 = "Cache connection took ";
        r4.append(r5);
        r4.append(r2);
        r2 = "ms";
        r4.append(r2);
        com.google.android.gms.internal.ads.zzawz.zzds(r4.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0139, code lost:
        throw r0;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:18:0x009c, B:24:0x00d7] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x009c */
    /* JADX WARNING: Missing exception handler attribute for start block: B:24:0x00d7 */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:24:0x00d7=Splitter:B:24:0x00d7, B:18:0x009c=Splitter:B:18:0x009c} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long zza(com.google.android.gms.internal.ads.zzjq r18) throws java.io.IOException {
        /*
            r17 = this;
            r1 = r17
            r0 = r18
            boolean r2 = r1.isOpen
            if (r2 != 0) goto L_0x017a
            r2 = 1
            r1.isOpen = r2
            android.net.Uri r3 = r0.uri
            com.google.android.gms.internal.ads.zzvv r3 = com.google.android.gms.internal.ads.zzvv.zze(r3)
            com.google.android.gms.internal.ads.zzacj<java.lang.Boolean> r4 = com.google.android.gms.internal.ads.zzacu.zzcts
            com.google.android.gms.internal.ads.zzacr r5 = com.google.android.gms.internal.ads.zzyt.zzpe()
            java.lang.Object r4 = r5.zzd(r4)
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            boolean r4 = r4.booleanValue()
            r5 = -1
            if (r4 == 0) goto L_0x013a
            if (r3 == 0) goto L_0x0158
            long r7 = r0.zzahv
            r3.zzbwy = r7
            boolean r4 = r3.zzbwx
            if (r4 == 0) goto L_0x003c
            com.google.android.gms.internal.ads.zzacj<java.lang.Long> r4 = com.google.android.gms.internal.ads.zzacu.zzctu
            com.google.android.gms.internal.ads.zzacr r7 = com.google.android.gms.internal.ads.zzyt.zzpe()
            java.lang.Object r4 = r7.zzd(r4)
            java.lang.Long r4 = (java.lang.Long) r4
            goto L_0x0048
        L_0x003c:
            com.google.android.gms.internal.ads.zzacj<java.lang.Long> r4 = com.google.android.gms.internal.ads.zzacu.zzctt
            com.google.android.gms.internal.ads.zzacr r7 = com.google.android.gms.internal.ads.zzyt.zzpe()
            java.lang.Object r4 = r7.zzd(r4)
            java.lang.Long r4 = (java.lang.Long) r4
        L_0x0048:
            long r7 = r4.longValue()
            com.google.android.gms.common.util.Clock r4 = com.google.android.gms.ads.internal.zzk.zzln()
            long r9 = r4.elapsedRealtime()
            com.google.android.gms.ads.internal.zzk.zzma()
            android.content.Context r4 = r1.zzlj
            java.util.concurrent.Future r4 = com.google.android.gms.internal.ads.zzwi.zza(r4, r3)
            r11 = 0
            r12 = 44
            java.util.concurrent.TimeUnit r13 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ ExecutionException | TimeoutException -> 0x00d7, InterruptedException -> 0x009c }
            java.lang.Object r7 = r4.get(r7, r13)     // Catch:{ ExecutionException | TimeoutException -> 0x00d7, InterruptedException -> 0x009c }
            java.io.InputStream r7 = (java.io.InputStream) r7     // Catch:{ ExecutionException | TimeoutException -> 0x00d7, InterruptedException -> 0x009c }
            r1.zzegc = r7     // Catch:{ ExecutionException | TimeoutException -> 0x00d7, InterruptedException -> 0x009c }
            com.google.android.gms.common.util.Clock r0 = com.google.android.gms.ads.internal.zzk.zzln()
            long r3 = r0.elapsedRealtime()
            long r3 = r3 - r9
            java.lang.ref.WeakReference<com.google.android.gms.internal.ads.zzbei> r0 = r1.zzege
            java.lang.Object r0 = r0.get()
            com.google.android.gms.internal.ads.zzbei r0 = (com.google.android.gms.internal.ads.zzbei) r0
            if (r0 == 0) goto L_0x0080
            r0.zzd(r2, r3)
        L_0x0080:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r12)
            java.lang.String r2 = "Cache connection took "
            r0.append(r2)
            r0.append(r3)
            java.lang.String r2 = "ms"
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            com.google.android.gms.internal.ads.zzawz.zzds(r0)
            return r5
        L_0x009a:
            r0 = move-exception
            goto L_0x010a
        L_0x009c:
            r4.cancel(r2)     // Catch:{ all -> 0x009a }
            java.lang.Thread r2 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x009a }
            r2.interrupt()     // Catch:{ all -> 0x009a }
            com.google.android.gms.common.util.Clock r2 = com.google.android.gms.ads.internal.zzk.zzln()
            long r4 = r2.elapsedRealtime()
            long r4 = r4 - r9
            java.lang.ref.WeakReference<com.google.android.gms.internal.ads.zzbei> r2 = r1.zzege
            java.lang.Object r2 = r2.get()
            com.google.android.gms.internal.ads.zzbei r2 = (com.google.android.gms.internal.ads.zzbei) r2
            if (r2 == 0) goto L_0x00bc
            r2.zzd(r11, r4)
        L_0x00bc:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r12)
            java.lang.String r6 = "Cache connection took "
            r2.append(r6)
            r2.append(r4)
            java.lang.String r4 = "ms"
            r2.append(r4)
            java.lang.String r2 = r2.toString()
            com.google.android.gms.internal.ads.zzawz.zzds(r2)
            goto L_0x0158
        L_0x00d7:
            r4.cancel(r2)     // Catch:{ all -> 0x009a }
            com.google.android.gms.common.util.Clock r2 = com.google.android.gms.ads.internal.zzk.zzln()
            long r4 = r2.elapsedRealtime()
            long r4 = r4 - r9
            java.lang.ref.WeakReference<com.google.android.gms.internal.ads.zzbei> r2 = r1.zzege
            java.lang.Object r2 = r2.get()
            com.google.android.gms.internal.ads.zzbei r2 = (com.google.android.gms.internal.ads.zzbei) r2
            if (r2 == 0) goto L_0x00f0
            r2.zzd(r11, r4)
        L_0x00f0:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r12)
            java.lang.String r6 = "Cache connection took "
            r2.append(r6)
            r2.append(r4)
            java.lang.String r4 = "ms"
            r2.append(r4)
            java.lang.String r2 = r2.toString()
            com.google.android.gms.internal.ads.zzawz.zzds(r2)
            goto L_0x0158
        L_0x010a:
            com.google.android.gms.common.util.Clock r2 = com.google.android.gms.ads.internal.zzk.zzln()
            long r2 = r2.elapsedRealtime()
            long r2 = r2 - r9
            java.lang.ref.WeakReference<com.google.android.gms.internal.ads.zzbei> r4 = r1.zzege
            java.lang.Object r4 = r4.get()
            com.google.android.gms.internal.ads.zzbei r4 = (com.google.android.gms.internal.ads.zzbei) r4
            if (r4 == 0) goto L_0x0120
            r4.zzd(r11, r2)
        L_0x0120:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r12)
            java.lang.String r5 = "Cache connection took "
            r4.append(r5)
            r4.append(r2)
            java.lang.String r2 = "ms"
            r4.append(r2)
            java.lang.String r2 = r4.toString()
            com.google.android.gms.internal.ads.zzawz.zzds(r2)
            throw r0
        L_0x013a:
            r2 = 0
            if (r3 == 0) goto L_0x0149
            long r7 = r0.zzahv
            r3.zzbwy = r7
            com.google.android.gms.internal.ads.zzvn r2 = com.google.android.gms.ads.internal.zzk.zzlm()
            com.google.android.gms.internal.ads.zzvs r2 = r2.zza((com.google.android.gms.internal.ads.zzvv) r3)
        L_0x0149:
            if (r2 == 0) goto L_0x0158
            boolean r4 = r2.zznh()
            if (r4 == 0) goto L_0x0158
            java.io.InputStream r0 = r2.zzni()
            r1.zzegc = r0
            return r5
        L_0x0158:
            if (r3 == 0) goto L_0x0173
            com.google.android.gms.internal.ads.zzjq r2 = new com.google.android.gms.internal.ads.zzjq
            java.lang.String r3 = r3.url
            android.net.Uri r8 = android.net.Uri.parse(r3)
            long r9 = r0.zzapg
            long r11 = r0.zzahv
            long r13 = r0.zzcd
            java.lang.String r15 = r0.zzcc
            int r0 = r0.flags
            r7 = r2
            r16 = r0
            r7.<init>(r8, r9, r11, r13, r15, r16)
            r0 = r2
        L_0x0173:
            com.google.android.gms.internal.ads.zzjp r2 = r1.zzegd
            long r2 = r2.zza(r0)
            return r2
        L_0x017a:
            java.io.IOException r0 = new java.io.IOException
            java.lang.String r2 = "Attempt to open an already open CacheDataSource."
            r0.<init>(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbeh.zza(com.google.android.gms.internal.ads.zzjq):long");
    }

    public final int read(byte[] bArr, int i, int i2) throws IOException {
        if (!this.isOpen) {
            throw new IOException("Attempt to read closed CacheDataSource.");
        } else if (this.zzegc != null) {
            return this.zzegc.read(bArr, i, i2);
        } else {
            return this.zzegd.read(bArr, i, i2);
        }
    }
}
