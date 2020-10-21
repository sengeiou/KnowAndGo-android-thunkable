package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import androidx.annotation.VisibleForTesting;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public final class zzan implements zzb {
    private final Map<String, zzao> zzbx;
    private long zzby;
    private final File zzbz;
    private final int zzca;

    public zzan(File file, int i) {
        this.zzbx = new LinkedHashMap(16, 0.75f, true);
        this.zzby = 0;
        this.zzbz = file;
        this.zzca = i;
    }

    public zzan(File file) {
        this(file, 5242880);
    }

    public final synchronized zzc zza(String str) {
        zzap zzap;
        zzao zzao = this.zzbx.get(str);
        if (zzao == null) {
            return null;
        }
        File zze = zze(str);
        try {
            zzap = new zzap(new BufferedInputStream(zza(zze)), zze.length());
            zzao zzc = zzao.zzc(zzap);
            if (!TextUtils.equals(str, zzc.zzcc)) {
                zzag.m183d("%s: key=%s, found=%s", zze.getAbsolutePath(), str, zzc.zzcc);
                removeEntry(str);
                zzap.close();
                return null;
            }
            byte[] zza = zza(zzap, zzap.zzo());
            zzc zzc2 = new zzc();
            zzc2.data = zza;
            zzc2.zza = zzao.zza;
            zzc2.zzb = zzao.zzb;
            zzc2.zzc = zzao.zzc;
            zzc2.zzd = zzao.zzd;
            zzc2.zze = zzao.zze;
            List<zzl> list = zzao.zzg;
            TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
            for (zzl next : list) {
                treeMap.put(next.getName(), next.getValue());
            }
            zzc2.zzf = treeMap;
            zzc2.zzg = Collections.unmodifiableList(zzao.zzg);
            zzap.close();
            return zzc2;
        } catch (IOException e) {
            zzag.m183d("%s: %s", zze.getAbsolutePath(), e.toString());
            remove(str);
            return null;
        } catch (Throwable th) {
            zzap.close();
            throw th;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0023, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0059 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zza() {
        /*
            r9 = this;
            monitor-enter(r9)
            java.io.File r0 = r9.zzbz     // Catch:{ all -> 0x0061 }
            boolean r0 = r0.exists()     // Catch:{ all -> 0x0061 }
            r1 = 0
            if (r0 != 0) goto L_0x0024
            java.io.File r0 = r9.zzbz     // Catch:{ all -> 0x0061 }
            boolean r0 = r0.mkdirs()     // Catch:{ all -> 0x0061 }
            if (r0 != 0) goto L_0x0022
            java.lang.String r0 = "Unable to create cache dir %s"
            r2 = 1
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ all -> 0x0061 }
            java.io.File r3 = r9.zzbz     // Catch:{ all -> 0x0061 }
            java.lang.String r3 = r3.getAbsolutePath()     // Catch:{ all -> 0x0061 }
            r2[r1] = r3     // Catch:{ all -> 0x0061 }
            com.google.android.gms.internal.ads.zzag.m184e(r0, r2)     // Catch:{ all -> 0x0061 }
        L_0x0022:
            monitor-exit(r9)
            return
        L_0x0024:
            java.io.File r0 = r9.zzbz     // Catch:{ all -> 0x0061 }
            java.io.File[] r0 = r0.listFiles()     // Catch:{ all -> 0x0061 }
            if (r0 != 0) goto L_0x002e
            monitor-exit(r9)
            return
        L_0x002e:
            int r2 = r0.length     // Catch:{ all -> 0x0061 }
        L_0x002f:
            if (r1 >= r2) goto L_0x005f
            r3 = r0[r1]     // Catch:{ all -> 0x0061 }
            long r4 = r3.length()     // Catch:{ IOException -> 0x0059 }
            com.google.android.gms.internal.ads.zzap r6 = new com.google.android.gms.internal.ads.zzap     // Catch:{ IOException -> 0x0059 }
            java.io.BufferedInputStream r7 = new java.io.BufferedInputStream     // Catch:{ IOException -> 0x0059 }
            java.io.InputStream r8 = zza((java.io.File) r3)     // Catch:{ IOException -> 0x0059 }
            r7.<init>(r8)     // Catch:{ IOException -> 0x0059 }
            r6.<init>(r7, r4)     // Catch:{ IOException -> 0x0059 }
            com.google.android.gms.internal.ads.zzao r7 = com.google.android.gms.internal.ads.zzao.zzc(r6)     // Catch:{ all -> 0x0054 }
            r7.zzcb = r4     // Catch:{ all -> 0x0054 }
            java.lang.String r4 = r7.zzcc     // Catch:{ all -> 0x0054 }
            r9.zza((java.lang.String) r4, (com.google.android.gms.internal.ads.zzao) r7)     // Catch:{ all -> 0x0054 }
            r6.close()     // Catch:{ IOException -> 0x0059 }
            goto L_0x005c
        L_0x0054:
            r4 = move-exception
            r6.close()     // Catch:{ IOException -> 0x0059 }
            throw r4     // Catch:{ IOException -> 0x0059 }
        L_0x0059:
            r3.delete()     // Catch:{ all -> 0x0061 }
        L_0x005c:
            int r1 = r1 + 1
            goto L_0x002f
        L_0x005f:
            monitor-exit(r9)
            return
        L_0x0061:
            r0 = move-exception
            monitor-exit(r9)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzan.zza():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00f9, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0114, code lost:
        if (r3.delete() == false) goto L_0x0116;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0116, code lost:
        com.google.android.gms.internal.ads.zzag.m183d("Could not clean up file %s", r3.getAbsolutePath());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0124, code lost:
        return;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x0110 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zza(java.lang.String r18, com.google.android.gms.internal.ads.zzc r19) {
        /*
            r17 = this;
            r1 = r17
            r0 = r18
            r2 = r19
            monitor-enter(r17)
            long r3 = r1.zzby     // Catch:{ all -> 0x0125 }
            byte[] r5 = r2.data     // Catch:{ all -> 0x0125 }
            int r5 = r5.length     // Catch:{ all -> 0x0125 }
            long r5 = (long) r5     // Catch:{ all -> 0x0125 }
            long r3 = r3 + r5
            int r5 = r1.zzca     // Catch:{ all -> 0x0125 }
            long r5 = (long) r5     // Catch:{ all -> 0x0125 }
            r7 = 1063675494(0x3f666666, float:0.9)
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 <= 0) goto L_0x0027
            byte[] r3 = r2.data     // Catch:{ all -> 0x0125 }
            int r3 = r3.length     // Catch:{ all -> 0x0125 }
            float r3 = (float) r3     // Catch:{ all -> 0x0125 }
            int r4 = r1.zzca     // Catch:{ all -> 0x0125 }
            float r4 = (float) r4
            float r4 = r4 * r7
            int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r3 <= 0) goto L_0x0027
            monitor-exit(r17)
            return
        L_0x0027:
            java.io.File r3 = r17.zze(r18)     // Catch:{ all -> 0x0125 }
            r4 = 1
            r5 = 0
            java.io.BufferedOutputStream r6 = new java.io.BufferedOutputStream     // Catch:{ IOException -> 0x0110 }
            java.io.FileOutputStream r8 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0110 }
            r8.<init>(r3)     // Catch:{ IOException -> 0x0110 }
            r6.<init>(r8)     // Catch:{ IOException -> 0x0110 }
            com.google.android.gms.internal.ads.zzao r8 = new com.google.android.gms.internal.ads.zzao     // Catch:{ IOException -> 0x0110 }
            r8.<init>(r0, r2)     // Catch:{ IOException -> 0x0110 }
            boolean r9 = r8.zza(r6)     // Catch:{ IOException -> 0x0110 }
            if (r9 == 0) goto L_0x00fa
            byte[] r2 = r2.data     // Catch:{ IOException -> 0x0110 }
            r6.write(r2)     // Catch:{ IOException -> 0x0110 }
            r6.close()     // Catch:{ IOException -> 0x0110 }
            long r9 = r3.length()     // Catch:{ IOException -> 0x0110 }
            r8.zzcb = r9     // Catch:{ IOException -> 0x0110 }
            r1.zza((java.lang.String) r0, (com.google.android.gms.internal.ads.zzao) r8)     // Catch:{ IOException -> 0x0110 }
            long r8 = r1.zzby     // Catch:{ IOException -> 0x0110 }
            int r0 = r1.zzca     // Catch:{ IOException -> 0x0110 }
            long r10 = (long) r0     // Catch:{ IOException -> 0x0110 }
            int r0 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r0 < 0) goto L_0x00f8
            boolean r0 = com.google.android.gms.internal.ads.zzag.DEBUG     // Catch:{ IOException -> 0x0110 }
            if (r0 == 0) goto L_0x0067
            java.lang.String r0 = "Pruning old cache entries."
            java.lang.Object[] r2 = new java.lang.Object[r5]     // Catch:{ IOException -> 0x0110 }
            com.google.android.gms.internal.ads.zzag.m185v(r0, r2)     // Catch:{ IOException -> 0x0110 }
        L_0x0067:
            long r8 = r1.zzby     // Catch:{ IOException -> 0x0110 }
            long r10 = android.os.SystemClock.elapsedRealtime()     // Catch:{ IOException -> 0x0110 }
            java.util.Map<java.lang.String, com.google.android.gms.internal.ads.zzao> r0 = r1.zzbx     // Catch:{ IOException -> 0x0110 }
            java.util.Set r0 = r0.entrySet()     // Catch:{ IOException -> 0x0110 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ IOException -> 0x0110 }
            r2 = 0
        L_0x0078:
            boolean r6 = r0.hasNext()     // Catch:{ IOException -> 0x0110 }
            r12 = 2
            if (r6 == 0) goto L_0x00cf
            java.lang.Object r6 = r0.next()     // Catch:{ IOException -> 0x0110 }
            java.util.Map$Entry r6 = (java.util.Map.Entry) r6     // Catch:{ IOException -> 0x0110 }
            java.lang.Object r6 = r6.getValue()     // Catch:{ IOException -> 0x0110 }
            com.google.android.gms.internal.ads.zzao r6 = (com.google.android.gms.internal.ads.zzao) r6     // Catch:{ IOException -> 0x0110 }
            java.lang.String r13 = r6.zzcc     // Catch:{ IOException -> 0x0110 }
            java.io.File r13 = r1.zze(r13)     // Catch:{ IOException -> 0x0110 }
            boolean r13 = r13.delete()     // Catch:{ IOException -> 0x0110 }
            if (r13 == 0) goto L_0x00a1
            long r13 = r1.zzby     // Catch:{ IOException -> 0x0110 }
            r15 = r8
            long r7 = r6.zzcb     // Catch:{ IOException -> 0x0110 }
            r6 = 0
            long r13 = r13 - r7
            r1.zzby = r13     // Catch:{ IOException -> 0x0110 }
            goto L_0x00b5
        L_0x00a1:
            r15 = r8
            java.lang.String r7 = "Could not delete cache entry for key=%s, filename=%s"
            java.lang.Object[] r8 = new java.lang.Object[r12]     // Catch:{ IOException -> 0x0110 }
            java.lang.String r9 = r6.zzcc     // Catch:{ IOException -> 0x0110 }
            r8[r5] = r9     // Catch:{ IOException -> 0x0110 }
            java.lang.String r6 = r6.zzcc     // Catch:{ IOException -> 0x0110 }
            java.lang.String r6 = zzd(r6)     // Catch:{ IOException -> 0x0110 }
            r8[r4] = r6     // Catch:{ IOException -> 0x0110 }
            com.google.android.gms.internal.ads.zzag.m183d(r7, r8)     // Catch:{ IOException -> 0x0110 }
        L_0x00b5:
            r0.remove()     // Catch:{ IOException -> 0x0110 }
            int r2 = r2 + 1
            long r6 = r1.zzby     // Catch:{ IOException -> 0x0110 }
            float r6 = (float) r6     // Catch:{ IOException -> 0x0110 }
            int r7 = r1.zzca     // Catch:{ IOException -> 0x0110 }
            float r7 = (float) r7     // Catch:{ IOException -> 0x0110 }
            r8 = 1063675494(0x3f666666, float:0.9)
            float r7 = r7 * r8
            int r6 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1))
            if (r6 >= 0) goto L_0x00ca
            goto L_0x00d0
        L_0x00ca:
            r8 = r15
            r7 = 1063675494(0x3f666666, float:0.9)
            goto L_0x0078
        L_0x00cf:
            r15 = r8
        L_0x00d0:
            boolean r0 = com.google.android.gms.internal.ads.zzag.DEBUG     // Catch:{ IOException -> 0x0110 }
            if (r0 == 0) goto L_0x00f8
            java.lang.String r0 = "pruned %d files, %d bytes, %d ms"
            r6 = 3
            java.lang.Object[] r6 = new java.lang.Object[r6]     // Catch:{ IOException -> 0x0110 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ IOException -> 0x0110 }
            r6[r5] = r2     // Catch:{ IOException -> 0x0110 }
            long r7 = r1.zzby     // Catch:{ IOException -> 0x0110 }
            r2 = 0
            long r7 = r7 - r15
            java.lang.Long r2 = java.lang.Long.valueOf(r7)     // Catch:{ IOException -> 0x0110 }
            r6[r4] = r2     // Catch:{ IOException -> 0x0110 }
            long r7 = android.os.SystemClock.elapsedRealtime()     // Catch:{ IOException -> 0x0110 }
            r2 = 0
            long r7 = r7 - r10
            java.lang.Long r2 = java.lang.Long.valueOf(r7)     // Catch:{ IOException -> 0x0110 }
            r6[r12] = r2     // Catch:{ IOException -> 0x0110 }
            com.google.android.gms.internal.ads.zzag.m185v(r0, r6)     // Catch:{ IOException -> 0x0110 }
        L_0x00f8:
            monitor-exit(r17)
            return
        L_0x00fa:
            r6.close()     // Catch:{ IOException -> 0x0110 }
            java.lang.String r0 = "Failed to write header for %s"
            java.lang.Object[] r2 = new java.lang.Object[r4]     // Catch:{ IOException -> 0x0110 }
            java.lang.String r6 = r3.getAbsolutePath()     // Catch:{ IOException -> 0x0110 }
            r2[r5] = r6     // Catch:{ IOException -> 0x0110 }
            com.google.android.gms.internal.ads.zzag.m183d(r0, r2)     // Catch:{ IOException -> 0x0110 }
            java.io.IOException r0 = new java.io.IOException     // Catch:{ IOException -> 0x0110 }
            r0.<init>()     // Catch:{ IOException -> 0x0110 }
            throw r0     // Catch:{ IOException -> 0x0110 }
        L_0x0110:
            boolean r0 = r3.delete()     // Catch:{ all -> 0x0125 }
            if (r0 != 0) goto L_0x0123
            java.lang.String r0 = "Could not clean up file %s"
            java.lang.Object[] r2 = new java.lang.Object[r4]     // Catch:{ all -> 0x0125 }
            java.lang.String r3 = r3.getAbsolutePath()     // Catch:{ all -> 0x0125 }
            r2[r5] = r3     // Catch:{ all -> 0x0125 }
            com.google.android.gms.internal.ads.zzag.m183d(r0, r2)     // Catch:{ all -> 0x0125 }
        L_0x0123:
            monitor-exit(r17)
            return
        L_0x0125:
            r0 = move-exception
            monitor-exit(r17)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzan.zza(java.lang.String, com.google.android.gms.internal.ads.zzc):void");
    }

    private final synchronized void remove(String str) {
        boolean delete = zze(str).delete();
        removeEntry(str);
        if (!delete) {
            zzag.m183d("Could not delete cache entry for key=%s, filename=%s", str, zzd(str));
        }
    }

    private static String zzd(String str) {
        int length = str.length() / 2;
        String valueOf = String.valueOf(String.valueOf(str.substring(0, length).hashCode()));
        String valueOf2 = String.valueOf(String.valueOf(str.substring(length).hashCode()));
        return valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
    }

    private final File zze(String str) {
        return new File(this.zzbz, zzd(str));
    }

    private final void zza(String str, zzao zzao) {
        if (!this.zzbx.containsKey(str)) {
            this.zzby += zzao.zzcb;
        } else {
            this.zzby += zzao.zzcb - this.zzbx.get(str).zzcb;
        }
        this.zzbx.put(str, zzao);
    }

    private final void removeEntry(String str) {
        zzao remove = this.zzbx.remove(str);
        if (remove != null) {
            this.zzby -= remove.zzcb;
        }
    }

    @VisibleForTesting
    private static byte[] zza(zzap zzap, long j) throws IOException {
        long zzo = zzap.zzo();
        if (j >= 0 && j <= zzo) {
            int i = (int) j;
            if (((long) i) == j) {
                byte[] bArr = new byte[i];
                new DataInputStream(zzap).readFully(bArr);
                return bArr;
            }
        }
        StringBuilder sb = new StringBuilder(73);
        sb.append("streamToBytes length=");
        sb.append(j);
        sb.append(", maxLength=");
        sb.append(zzo);
        throw new IOException(sb.toString());
    }

    @VisibleForTesting
    private static InputStream zza(File file) throws FileNotFoundException {
        return new FileInputStream(file);
    }

    private static int zza(InputStream inputStream) throws IOException {
        int read = inputStream.read();
        if (read != -1) {
            return read;
        }
        throw new EOFException();
    }

    static void zza(OutputStream outputStream, int i) throws IOException {
        outputStream.write(i & 255);
        outputStream.write((i >> 8) & 255);
        outputStream.write((i >> 16) & 255);
        outputStream.write(i >>> 24);
    }

    static int zzb(InputStream inputStream) throws IOException {
        return (zza(inputStream) << 24) | zza(inputStream) | 0 | (zza(inputStream) << 8) | (zza(inputStream) << 16);
    }

    static void zza(OutputStream outputStream, long j) throws IOException {
        outputStream.write((byte) ((int) j));
        outputStream.write((byte) ((int) (j >>> 8)));
        outputStream.write((byte) ((int) (j >>> 16)));
        outputStream.write((byte) ((int) (j >>> 24)));
        outputStream.write((byte) ((int) (j >>> 32)));
        outputStream.write((byte) ((int) (j >>> 40)));
        outputStream.write((byte) ((int) (j >>> 48)));
        outputStream.write((byte) ((int) (j >>> 56)));
    }

    static long zzc(InputStream inputStream) throws IOException {
        return (((long) zza(inputStream)) & 255) | 0 | ((((long) zza(inputStream)) & 255) << 8) | ((((long) zza(inputStream)) & 255) << 16) | ((((long) zza(inputStream)) & 255) << 24) | ((((long) zza(inputStream)) & 255) << 32) | ((((long) zza(inputStream)) & 255) << 40) | ((((long) zza(inputStream)) & 255) << 48) | ((255 & ((long) zza(inputStream))) << 56);
    }

    static void zza(OutputStream outputStream, String str) throws IOException {
        byte[] bytes = str.getBytes("UTF-8");
        zza(outputStream, (long) bytes.length);
        outputStream.write(bytes, 0, bytes.length);
    }

    static String zza(zzap zzap) throws IOException {
        return new String(zza(zzap, zzc(zzap)), "UTF-8");
    }

    static List<zzl> zzb(zzap zzap) throws IOException {
        int zzb = zzb((InputStream) zzap);
        if (zzb >= 0) {
            List<zzl> emptyList = zzb == 0 ? Collections.emptyList() : new ArrayList<>();
            for (int i = 0; i < zzb; i++) {
                emptyList.add(new zzl(zza(zzap).intern(), zza(zzap).intern()));
            }
            return emptyList;
        }
        StringBuilder sb = new StringBuilder(31);
        sb.append("readHeaderList size=");
        sb.append(zzb);
        throw new IOException(sb.toString());
    }
}
