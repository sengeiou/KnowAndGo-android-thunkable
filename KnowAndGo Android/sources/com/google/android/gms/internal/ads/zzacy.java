package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Environment;
import androidx.annotation.Nullable;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.File;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@zzard
public final class zzacy {
    private File file;
    @VisibleForTesting
    private Context mContext;
    @VisibleForTesting
    private BlockingQueue<zzadi> zzcxb = new ArrayBlockingQueue(100);
    @VisibleForTesting
    private ExecutorService zzcxc;
    @VisibleForTesting
    private LinkedHashMap<String, String> zzcxd = new LinkedHashMap<>();
    @VisibleForTesting
    private Map<String, zzadc> zzcxe = new HashMap();
    @VisibleForTesting
    private String zzcxf;
    @VisibleForTesting
    private String zzcxg;
    private AtomicBoolean zzcxh;

    public final void zza(Context context, String str, String str2, Map<String, String> map) {
        File externalStorageDirectory;
        this.mContext = context;
        this.zzcxg = str;
        this.zzcxf = str2;
        this.zzcxh = new AtomicBoolean(false);
        this.zzcxh.set(((Boolean) zzyt.zzpe().zzd(zzacu.zzcmz)).booleanValue());
        if (this.zzcxh.get() && (externalStorageDirectory = Environment.getExternalStorageDirectory()) != null) {
            this.file = new File(externalStorageDirectory, "sdk_csi_data.txt");
        }
        for (Map.Entry next : map.entrySet()) {
            this.zzcxd.put((String) next.getKey(), (String) next.getValue());
        }
        this.zzcxc = Executors.newSingleThreadExecutor();
        this.zzcxc.execute(new zzacz(this));
        this.zzcxe.put("action", zzadc.zzcxk);
        this.zzcxe.put("ad_format", zzadc.zzcxk);
        this.zzcxe.put("e", zzadc.zzcxl);
    }

    public final boolean zza(zzadi zzadi) {
        return this.zzcxb.offer(zzadi);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x009f A[SYNTHETIC, Splitter:B:31:0x009f] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00ae A[SYNTHETIC, Splitter:B:36:0x00ae] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0000 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzqt() {
        /*
            r5 = this;
        L_0x0000:
            java.util.concurrent.BlockingQueue<com.google.android.gms.internal.ads.zzadi> r0 = r5.zzcxb     // Catch:{ InterruptedException -> 0x00cc }
            java.lang.Object r0 = r0.take()     // Catch:{ InterruptedException -> 0x00cc }
            com.google.android.gms.internal.ads.zzadi r0 = (com.google.android.gms.internal.ads.zzadi) r0     // Catch:{ InterruptedException -> 0x00cc }
            java.lang.String r1 = r0.zzqx()     // Catch:{ InterruptedException -> 0x00cc }
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 != 0) goto L_0x0000
            java.util.LinkedHashMap<java.lang.String, java.lang.String> r2 = r5.zzcxd
            java.util.Map r0 = r0.zzqy()
            java.util.Map r0 = r5.zza(r2, r0)
            java.lang.String r2 = r5.zzcxf
            android.net.Uri r2 = android.net.Uri.parse(r2)
            android.net.Uri$Builder r2 = r2.buildUpon()
            java.util.Set r0 = r0.entrySet()
            java.util.Iterator r0 = r0.iterator()
        L_0x002e:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L_0x004a
            java.lang.Object r3 = r0.next()
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3
            java.lang.Object r4 = r3.getKey()
            java.lang.String r4 = (java.lang.String) r4
            java.lang.Object r3 = r3.getValue()
            java.lang.String r3 = (java.lang.String) r3
            r2.appendQueryParameter(r4, r3)
            goto L_0x002e
        L_0x004a:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            android.net.Uri r2 = r2.build()
            java.lang.String r2 = r2.toString()
            r0.<init>(r2)
            java.lang.String r2 = "&it="
            r0.append(r2)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.util.concurrent.atomic.AtomicBoolean r1 = r5.zzcxh
            boolean r1 = r1.get()
            if (r1 == 0) goto L_0x00c0
            java.io.File r1 = r5.file
            if (r1 == 0) goto L_0x00b9
            r2 = 0
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0097 }
            r4 = 1
            r3.<init>(r1, r4)     // Catch:{ IOException -> 0x0097 }
            byte[] r0 = r0.getBytes()     // Catch:{ IOException -> 0x0092, all -> 0x008f }
            r3.write(r0)     // Catch:{ IOException -> 0x0092, all -> 0x008f }
            r0 = 10
            r3.write(r0)     // Catch:{ IOException -> 0x0092, all -> 0x008f }
            r3.close()     // Catch:{ IOException -> 0x0087 }
            goto L_0x0000
        L_0x0087:
            r0 = move-exception
            java.lang.String r1 = "CsiReporter: Cannot close file: sdk_csi_data.txt."
            com.google.android.gms.internal.ads.zzawz.zzd(r1, r0)
            goto L_0x0000
        L_0x008f:
            r0 = move-exception
            r2 = r3
            goto L_0x00ac
        L_0x0092:
            r0 = move-exception
            r2 = r3
            goto L_0x0098
        L_0x0095:
            r0 = move-exception
            goto L_0x00ac
        L_0x0097:
            r0 = move-exception
        L_0x0098:
            java.lang.String r1 = "CsiReporter: Cannot write to file: sdk_csi_data.txt."
            com.google.android.gms.internal.ads.zzawz.zzd(r1, r0)     // Catch:{ all -> 0x0095 }
            if (r2 == 0) goto L_0x0000
            r2.close()     // Catch:{ IOException -> 0x00a4 }
            goto L_0x0000
        L_0x00a4:
            r0 = move-exception
            java.lang.String r1 = "CsiReporter: Cannot close file: sdk_csi_data.txt."
            com.google.android.gms.internal.ads.zzawz.zzd(r1, r0)
            goto L_0x0000
        L_0x00ac:
            if (r2 == 0) goto L_0x00b8
            r2.close()     // Catch:{ IOException -> 0x00b2 }
            goto L_0x00b8
        L_0x00b2:
            r1 = move-exception
            java.lang.String r2 = "CsiReporter: Cannot close file: sdk_csi_data.txt."
            com.google.android.gms.internal.ads.zzawz.zzd(r2, r1)
        L_0x00b8:
            throw r0
        L_0x00b9:
            java.lang.String r0 = "CsiReporter: File doesn't exists. Cannot write CSI data to file."
            com.google.android.gms.internal.ads.zzawz.zzep(r0)
            goto L_0x0000
        L_0x00c0:
            com.google.android.gms.ads.internal.zzk.zzlg()
            android.content.Context r1 = r5.mContext
            java.lang.String r2 = r5.zzcxg
            com.google.android.gms.internal.ads.zzaxi.zzb(r1, r2, r0)
            goto L_0x0000
        L_0x00cc:
            r0 = move-exception
            java.lang.String r1 = "CsiReporter:reporter interrupted"
            com.google.android.gms.internal.ads.zzawz.zzd(r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzacy.zzqt():void");
    }

    /* access modifiers changed from: package-private */
    public final Map<String, String> zza(Map<String, String> map, @Nullable Map<String, String> map2) {
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        if (map2 == null) {
            return linkedHashMap;
        }
        for (Map.Entry next : map2.entrySet()) {
            String str = (String) next.getKey();
            String str2 = (String) linkedHashMap.get(str);
            linkedHashMap.put(str, zzch(str).zzg(str2, (String) next.getValue()));
        }
        return linkedHashMap;
    }

    public final zzadc zzch(String str) {
        zzadc zzadc = this.zzcxe.get(str);
        if (zzadc != null) {
            return zzadc;
        }
        return zzadc.zzcxj;
    }
}
