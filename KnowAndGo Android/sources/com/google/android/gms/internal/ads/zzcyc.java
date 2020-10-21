package com.google.android.gms.internal.ads;

import android.os.ParcelFileDescriptor;
import java.io.IOException;
import java.io.InputStream;

public final class zzcyc {
    public static ParcelFileDescriptor zze(InputStream inputStream) throws IOException {
        ParcelFileDescriptor[] createPipe = ParcelFileDescriptor.createPipe();
        ParcelFileDescriptor parcelFileDescriptor = createPipe[0];
        zzaxg.zzdvp.execute(new zzcyd(inputStream, createPipe[1]));
        return parcelFileDescriptor;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0013, code lost:
        r5 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0014, code lost:
        r2 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0018, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0019, code lost:
        r3 = r2;
        r2 = r5;
        r5 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x002b, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0030, code lost:
        if (r4 != null) goto L_0x0032;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:?, code lost:
        zza(r0, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0035, code lost:
        throw r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0036, code lost:
        return;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:8:0x000e, B:30:0x002f] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static final /* synthetic */ void zza(java.io.InputStream r4, android.os.ParcelFileDescriptor r5) {
        /*
            r0 = 0
            android.os.ParcelFileDescriptor$AutoCloseOutputStream r1 = new android.os.ParcelFileDescriptor$AutoCloseOutputStream     // Catch:{ Throwable -> 0x002d }
            r1.<init>(r5)     // Catch:{ Throwable -> 0x002d }
            com.google.android.gms.common.util.IOUtils.copyStream(r4, r1)     // Catch:{ Throwable -> 0x0016, all -> 0x0013 }
            r1.close()     // Catch:{ Throwable -> 0x002d }
            if (r4 == 0) goto L_0x0012
            zza((java.lang.Throwable) r0, (java.io.InputStream) r4)     // Catch:{ IOException -> 0x0036 }
            return
        L_0x0012:
            return
        L_0x0013:
            r5 = move-exception
            r2 = r0
            goto L_0x001c
        L_0x0016:
            r5 = move-exception
            throw r5     // Catch:{ all -> 0x0018 }
        L_0x0018:
            r2 = move-exception
            r3 = r2
            r2 = r5
            r5 = r3
        L_0x001c:
            if (r2 == 0) goto L_0x0027
            r1.close()     // Catch:{ Throwable -> 0x0022 }
            goto L_0x002a
        L_0x0022:
            r1 = move-exception
            com.google.android.gms.internal.ads.zzdmb.zza((java.lang.Throwable) r2, (java.lang.Throwable) r1)     // Catch:{ Throwable -> 0x002d }
            goto L_0x002a
        L_0x0027:
            r1.close()     // Catch:{ Throwable -> 0x002d }
        L_0x002a:
            throw r5     // Catch:{ Throwable -> 0x002d }
        L_0x002b:
            r5 = move-exception
            goto L_0x0030
        L_0x002d:
            r5 = move-exception
            r0 = r5
            throw r0     // Catch:{ all -> 0x002b }
        L_0x0030:
            if (r4 == 0) goto L_0x0035
            zza((java.lang.Throwable) r0, (java.io.InputStream) r4)     // Catch:{ IOException -> 0x0036 }
        L_0x0035:
            throw r5     // Catch:{ IOException -> 0x0036 }
        L_0x0036:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcyc.zza(java.io.InputStream, android.os.ParcelFileDescriptor):void");
    }

    private static /* synthetic */ void zza(Throwable th, InputStream inputStream) {
        if (th != null) {
            try {
                inputStream.close();
            } catch (Throwable th2) {
                zzdmb.zza(th, th2);
            }
        } else {
            inputStream.close();
        }
    }
}
