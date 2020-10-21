package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.VisibleForTesting;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.internal.ads.zzbp;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class zzdy {
    private static final String TAG = "zzdy";
    protected Context zzlj;
    private volatile boolean zzwf = false;
    private ExecutorService zzxf;
    private DexClassLoader zzxg;
    private zzdj zzxh;
    private byte[] zzxi;
    private volatile AdvertisingIdClient zzxj = null;
    private Future zzxk = null;
    private boolean zzxl;
    /* access modifiers changed from: private */
    public volatile zzbp.zza zzxm = null;
    private Future zzxn = null;
    private zzda zzxo;
    protected boolean zzxp = false;
    private boolean zzxq = false;
    private Map<Pair<String, String>, zzfi> zzxr;
    private boolean zzxs = false;
    /* access modifiers changed from: private */
    public boolean zzxt;
    private boolean zzxu;

    final class zza extends BroadcastReceiver {
        private zza() {
        }

        public final void onReceive(Context context, Intent intent) {
            if ("android.intent.action.USER_PRESENT".equals(intent.getAction())) {
                boolean unused = zzdy.this.zzxt = true;
            } else if ("android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
                boolean unused2 = zzdy.this.zzxt = false;
            }
        }

        /* synthetic */ zza(zzdy zzdy, zzdz zzdz) {
            this();
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(18:1|2|(1:4)|5|6|7|8|(1:10)(1:11)|12|(1:14)(1:15)|16|17|18|(2:20|(1:22)(2:23|24))|25|26|27|(14:28|29|(2:31|(1:33)(2:34|35))|36|(1:38)|39|40|41|42|43|44|45|(1:47)|48)) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x004b */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0054 A[Catch:{ zzdk -> 0x0152, zzdv -> 0x0159 }] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0087 A[Catch:{ all -> 0x011f, FileNotFoundException -> 0x014b, IOException -> 0x0144, zzdk -> 0x013d, NullPointerException -> 0x0136 }] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00b2 A[Catch:{ all -> 0x011f, FileNotFoundException -> 0x014b, IOException -> 0x0144, zzdk -> 0x013d, NullPointerException -> 0x0136 }] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00fa A[Catch:{ zzdk -> 0x0152, zzdv -> 0x0159 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.ads.zzdy zza(android.content.Context r8, java.lang.String r9, java.lang.String r10, boolean r11) {
        /*
            com.google.android.gms.internal.ads.zzdy r0 = new com.google.android.gms.internal.ads.zzdy
            r0.<init>(r8)
            com.google.android.gms.internal.ads.zzdz r8 = new com.google.android.gms.internal.ads.zzdz     // Catch:{ zzdv -> 0x0159 }
            r8.<init>()     // Catch:{ zzdv -> 0x0159 }
            java.util.concurrent.ExecutorService r8 = java.util.concurrent.Executors.newCachedThreadPool(r8)     // Catch:{ zzdv -> 0x0159 }
            r0.zzxf = r8     // Catch:{ zzdv -> 0x0159 }
            r0.zzwf = r11     // Catch:{ zzdv -> 0x0159 }
            if (r11 == 0) goto L_0x0021
            java.util.concurrent.ExecutorService r8 = r0.zzxf     // Catch:{ zzdv -> 0x0159 }
            com.google.android.gms.internal.ads.zzea r11 = new com.google.android.gms.internal.ads.zzea     // Catch:{ zzdv -> 0x0159 }
            r11.<init>(r0)     // Catch:{ zzdv -> 0x0159 }
            java.util.concurrent.Future r8 = r8.submit(r11)     // Catch:{ zzdv -> 0x0159 }
            r0.zzxk = r8     // Catch:{ zzdv -> 0x0159 }
        L_0x0021:
            java.util.concurrent.ExecutorService r8 = r0.zzxf     // Catch:{ zzdv -> 0x0159 }
            com.google.android.gms.internal.ads.zzec r11 = new com.google.android.gms.internal.ads.zzec     // Catch:{ zzdv -> 0x0159 }
            r11.<init>(r0)     // Catch:{ zzdv -> 0x0159 }
            r8.execute(r11)     // Catch:{ zzdv -> 0x0159 }
            r8 = 1
            r11 = 0
            com.google.android.gms.common.GoogleApiAvailabilityLight r1 = com.google.android.gms.common.GoogleApiAvailabilityLight.getInstance()     // Catch:{ Throwable -> 0x004b }
            android.content.Context r2 = r0.zzlj     // Catch:{ Throwable -> 0x004b }
            int r2 = r1.getApkVersion(r2)     // Catch:{ Throwable -> 0x004b }
            if (r2 <= 0) goto L_0x003b
            r2 = 1
            goto L_0x003c
        L_0x003b:
            r2 = 0
        L_0x003c:
            r0.zzxp = r2     // Catch:{ Throwable -> 0x004b }
            android.content.Context r2 = r0.zzlj     // Catch:{ Throwable -> 0x004b }
            int r1 = r1.isGooglePlayServicesAvailable(r2)     // Catch:{ Throwable -> 0x004b }
            if (r1 != 0) goto L_0x0048
            r1 = 1
            goto L_0x0049
        L_0x0048:
            r1 = 0
        L_0x0049:
            r0.zzxq = r1     // Catch:{ Throwable -> 0x004b }
        L_0x004b:
            r0.zza((int) r11, (boolean) r8)     // Catch:{ zzdv -> 0x0159 }
            boolean r1 = com.google.android.gms.internal.ads.zzef.isMainThread()     // Catch:{ zzdv -> 0x0159 }
            if (r1 == 0) goto L_0x006f
            com.google.android.gms.internal.ads.zzacj<java.lang.Boolean> r1 = com.google.android.gms.internal.ads.zzacu.zzcrn     // Catch:{ zzdv -> 0x0159 }
            com.google.android.gms.internal.ads.zzacr r2 = com.google.android.gms.internal.ads.zzyt.zzpe()     // Catch:{ zzdv -> 0x0159 }
            java.lang.Object r1 = r2.zzd(r1)     // Catch:{ zzdv -> 0x0159 }
            java.lang.Boolean r1 = (java.lang.Boolean) r1     // Catch:{ zzdv -> 0x0159 }
            boolean r1 = r1.booleanValue()     // Catch:{ zzdv -> 0x0159 }
            if (r1 != 0) goto L_0x0067
            goto L_0x006f
        L_0x0067:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException     // Catch:{ zzdv -> 0x0159 }
            java.lang.String r9 = "Task Context initialization must not be called from the UI thread."
            r8.<init>(r9)     // Catch:{ zzdv -> 0x0159 }
            throw r8     // Catch:{ zzdv -> 0x0159 }
        L_0x006f:
            com.google.android.gms.internal.ads.zzdj r1 = new com.google.android.gms.internal.ads.zzdj     // Catch:{ zzdv -> 0x0159 }
            r2 = 0
            r1.<init>(r2)     // Catch:{ zzdv -> 0x0159 }
            r0.zzxh = r1     // Catch:{ zzdv -> 0x0159 }
            com.google.android.gms.internal.ads.zzdj r1 = r0.zzxh     // Catch:{ zzdk -> 0x0152 }
            byte[] r9 = r1.zzan(r9)     // Catch:{ zzdk -> 0x0152 }
            r0.zzxi = r9     // Catch:{ zzdk -> 0x0152 }
            android.content.Context r9 = r0.zzlj     // Catch:{ FileNotFoundException -> 0x014b, IOException -> 0x0144, zzdk -> 0x013d, NullPointerException -> 0x0136 }
            java.io.File r9 = r9.getCacheDir()     // Catch:{ FileNotFoundException -> 0x014b, IOException -> 0x0144, zzdk -> 0x013d, NullPointerException -> 0x0136 }
            if (r9 != 0) goto L_0x0098
            android.content.Context r9 = r0.zzlj     // Catch:{ FileNotFoundException -> 0x014b, IOException -> 0x0144, zzdk -> 0x013d, NullPointerException -> 0x0136 }
            java.lang.String r1 = "dex"
            java.io.File r9 = r9.getDir(r1, r11)     // Catch:{ FileNotFoundException -> 0x014b, IOException -> 0x0144, zzdk -> 0x013d, NullPointerException -> 0x0136 }
            if (r9 == 0) goto L_0x0092
            goto L_0x0098
        L_0x0092:
            com.google.android.gms.internal.ads.zzdv r8 = new com.google.android.gms.internal.ads.zzdv     // Catch:{ FileNotFoundException -> 0x014b, IOException -> 0x0144, zzdk -> 0x013d, NullPointerException -> 0x0136 }
            r8.<init>()     // Catch:{ FileNotFoundException -> 0x014b, IOException -> 0x0144, zzdk -> 0x013d, NullPointerException -> 0x0136 }
            throw r8     // Catch:{ FileNotFoundException -> 0x014b, IOException -> 0x0144, zzdk -> 0x013d, NullPointerException -> 0x0136 }
        L_0x0098:
            java.lang.String r1 = "1542658731108"
            java.io.File r3 = new java.io.File     // Catch:{ FileNotFoundException -> 0x014b, IOException -> 0x0144, zzdk -> 0x013d, NullPointerException -> 0x0136 }
            java.lang.String r4 = "%s/%s.jar"
            r5 = 2
            java.lang.Object[] r6 = new java.lang.Object[r5]     // Catch:{ FileNotFoundException -> 0x014b, IOException -> 0x0144, zzdk -> 0x013d, NullPointerException -> 0x0136 }
            r6[r11] = r9     // Catch:{ FileNotFoundException -> 0x014b, IOException -> 0x0144, zzdk -> 0x013d, NullPointerException -> 0x0136 }
            r6[r8] = r1     // Catch:{ FileNotFoundException -> 0x014b, IOException -> 0x0144, zzdk -> 0x013d, NullPointerException -> 0x0136 }
            java.lang.String r4 = java.lang.String.format(r4, r6)     // Catch:{ FileNotFoundException -> 0x014b, IOException -> 0x0144, zzdk -> 0x013d, NullPointerException -> 0x0136 }
            r3.<init>(r4)     // Catch:{ FileNotFoundException -> 0x014b, IOException -> 0x0144, zzdk -> 0x013d, NullPointerException -> 0x0136 }
            boolean r4 = r3.exists()     // Catch:{ FileNotFoundException -> 0x014b, IOException -> 0x0144, zzdk -> 0x013d, NullPointerException -> 0x0136 }
            if (r4 != 0) goto L_0x00c9
            com.google.android.gms.internal.ads.zzdj r4 = r0.zzxh     // Catch:{ FileNotFoundException -> 0x014b, IOException -> 0x0144, zzdk -> 0x013d, NullPointerException -> 0x0136 }
            byte[] r6 = r0.zzxi     // Catch:{ FileNotFoundException -> 0x014b, IOException -> 0x0144, zzdk -> 0x013d, NullPointerException -> 0x0136 }
            byte[] r10 = r4.zza(r6, r10)     // Catch:{ FileNotFoundException -> 0x014b, IOException -> 0x0144, zzdk -> 0x013d, NullPointerException -> 0x0136 }
            r3.createNewFile()     // Catch:{ FileNotFoundException -> 0x014b, IOException -> 0x0144, zzdk -> 0x013d, NullPointerException -> 0x0136 }
            java.io.FileOutputStream r4 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x014b, IOException -> 0x0144, zzdk -> 0x013d, NullPointerException -> 0x0136 }
            r4.<init>(r3)     // Catch:{ FileNotFoundException -> 0x014b, IOException -> 0x0144, zzdk -> 0x013d, NullPointerException -> 0x0136 }
            int r6 = r10.length     // Catch:{ FileNotFoundException -> 0x014b, IOException -> 0x0144, zzdk -> 0x013d, NullPointerException -> 0x0136 }
            r4.write(r10, r11, r6)     // Catch:{ FileNotFoundException -> 0x014b, IOException -> 0x0144, zzdk -> 0x013d, NullPointerException -> 0x0136 }
            r4.close()     // Catch:{ FileNotFoundException -> 0x014b, IOException -> 0x0144, zzdk -> 0x013d, NullPointerException -> 0x0136 }
        L_0x00c9:
            r0.zzb((java.io.File) r9, (java.lang.String) r1)     // Catch:{ FileNotFoundException -> 0x014b, IOException -> 0x0144, zzdk -> 0x013d, NullPointerException -> 0x0136 }
            dalvik.system.DexClassLoader r10 = new dalvik.system.DexClassLoader     // Catch:{ all -> 0x011f }
            java.lang.String r4 = r3.getAbsolutePath()     // Catch:{ all -> 0x011f }
            java.lang.String r6 = r9.getAbsolutePath()     // Catch:{ all -> 0x011f }
            android.content.Context r7 = r0.zzlj     // Catch:{ all -> 0x011f }
            java.lang.ClassLoader r7 = r7.getClassLoader()     // Catch:{ all -> 0x011f }
            r10.<init>(r4, r6, r2, r7)     // Catch:{ all -> 0x011f }
            r0.zzxg = r10     // Catch:{ all -> 0x011f }
            zzb(r3)     // Catch:{ FileNotFoundException -> 0x014b, IOException -> 0x0144, zzdk -> 0x013d, NullPointerException -> 0x0136 }
            r0.zza((java.io.File) r9, (java.lang.String) r1)     // Catch:{ FileNotFoundException -> 0x014b, IOException -> 0x0144, zzdk -> 0x013d, NullPointerException -> 0x0136 }
            java.lang.String r10 = "%s/%s.dex"
            java.lang.Object[] r3 = new java.lang.Object[r5]     // Catch:{ FileNotFoundException -> 0x014b, IOException -> 0x0144, zzdk -> 0x013d, NullPointerException -> 0x0136 }
            r3[r11] = r9     // Catch:{ FileNotFoundException -> 0x014b, IOException -> 0x0144, zzdk -> 0x013d, NullPointerException -> 0x0136 }
            r3[r8] = r1     // Catch:{ FileNotFoundException -> 0x014b, IOException -> 0x0144, zzdk -> 0x013d, NullPointerException -> 0x0136 }
            java.lang.String r9 = java.lang.String.format(r10, r3)     // Catch:{ FileNotFoundException -> 0x014b, IOException -> 0x0144, zzdk -> 0x013d, NullPointerException -> 0x0136 }
            zzao(r9)     // Catch:{ FileNotFoundException -> 0x014b, IOException -> 0x0144, zzdk -> 0x013d, NullPointerException -> 0x0136 }
            boolean r9 = r0.zzxu     // Catch:{ zzdv -> 0x0159 }
            if (r9 != 0) goto L_0x0115
            android.content.IntentFilter r9 = new android.content.IntentFilter     // Catch:{ zzdv -> 0x0159 }
            r9.<init>()     // Catch:{ zzdv -> 0x0159 }
            java.lang.String r10 = "android.intent.action.USER_PRESENT"
            r9.addAction(r10)     // Catch:{ zzdv -> 0x0159 }
            java.lang.String r10 = "android.intent.action.SCREEN_OFF"
            r9.addAction(r10)     // Catch:{ zzdv -> 0x0159 }
            android.content.Context r10 = r0.zzlj     // Catch:{ zzdv -> 0x0159 }
            com.google.android.gms.internal.ads.zzdy$zza r11 = new com.google.android.gms.internal.ads.zzdy$zza     // Catch:{ zzdv -> 0x0159 }
            r11.<init>(r0, r2)     // Catch:{ zzdv -> 0x0159 }
            r10.registerReceiver(r11, r9)     // Catch:{ zzdv -> 0x0159 }
            r0.zzxu = r8     // Catch:{ zzdv -> 0x0159 }
        L_0x0115:
            com.google.android.gms.internal.ads.zzda r9 = new com.google.android.gms.internal.ads.zzda     // Catch:{ zzdv -> 0x0159 }
            r9.<init>(r0)     // Catch:{ zzdv -> 0x0159 }
            r0.zzxo = r9     // Catch:{ zzdv -> 0x0159 }
            r0.zzxs = r8     // Catch:{ zzdv -> 0x0159 }
            goto L_0x0159
        L_0x011f:
            r10 = move-exception
            zzb(r3)     // Catch:{ FileNotFoundException -> 0x014b, IOException -> 0x0144, zzdk -> 0x013d, NullPointerException -> 0x0136 }
            r0.zza((java.io.File) r9, (java.lang.String) r1)     // Catch:{ FileNotFoundException -> 0x014b, IOException -> 0x0144, zzdk -> 0x013d, NullPointerException -> 0x0136 }
            java.lang.String r2 = "%s/%s.dex"
            java.lang.Object[] r3 = new java.lang.Object[r5]     // Catch:{ FileNotFoundException -> 0x014b, IOException -> 0x0144, zzdk -> 0x013d, NullPointerException -> 0x0136 }
            r3[r11] = r9     // Catch:{ FileNotFoundException -> 0x014b, IOException -> 0x0144, zzdk -> 0x013d, NullPointerException -> 0x0136 }
            r3[r8] = r1     // Catch:{ FileNotFoundException -> 0x014b, IOException -> 0x0144, zzdk -> 0x013d, NullPointerException -> 0x0136 }
            java.lang.String r8 = java.lang.String.format(r2, r3)     // Catch:{ FileNotFoundException -> 0x014b, IOException -> 0x0144, zzdk -> 0x013d, NullPointerException -> 0x0136 }
            zzao(r8)     // Catch:{ FileNotFoundException -> 0x014b, IOException -> 0x0144, zzdk -> 0x013d, NullPointerException -> 0x0136 }
            throw r10     // Catch:{ FileNotFoundException -> 0x014b, IOException -> 0x0144, zzdk -> 0x013d, NullPointerException -> 0x0136 }
        L_0x0136:
            r8 = move-exception
            com.google.android.gms.internal.ads.zzdv r9 = new com.google.android.gms.internal.ads.zzdv     // Catch:{ zzdv -> 0x0159 }
            r9.<init>(r8)     // Catch:{ zzdv -> 0x0159 }
            throw r9     // Catch:{ zzdv -> 0x0159 }
        L_0x013d:
            r8 = move-exception
            com.google.android.gms.internal.ads.zzdv r9 = new com.google.android.gms.internal.ads.zzdv     // Catch:{ zzdv -> 0x0159 }
            r9.<init>(r8)     // Catch:{ zzdv -> 0x0159 }
            throw r9     // Catch:{ zzdv -> 0x0159 }
        L_0x0144:
            r8 = move-exception
            com.google.android.gms.internal.ads.zzdv r9 = new com.google.android.gms.internal.ads.zzdv     // Catch:{ zzdv -> 0x0159 }
            r9.<init>(r8)     // Catch:{ zzdv -> 0x0159 }
            throw r9     // Catch:{ zzdv -> 0x0159 }
        L_0x014b:
            r8 = move-exception
            com.google.android.gms.internal.ads.zzdv r9 = new com.google.android.gms.internal.ads.zzdv     // Catch:{ zzdv -> 0x0159 }
            r9.<init>(r8)     // Catch:{ zzdv -> 0x0159 }
            throw r9     // Catch:{ zzdv -> 0x0159 }
        L_0x0152:
            r8 = move-exception
            com.google.android.gms.internal.ads.zzdv r9 = new com.google.android.gms.internal.ads.zzdv     // Catch:{ zzdv -> 0x0159 }
            r9.<init>(r8)     // Catch:{ zzdv -> 0x0159 }
            throw r9     // Catch:{ zzdv -> 0x0159 }
        L_0x0159:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdy.zza(android.content.Context, java.lang.String, java.lang.String, boolean):com.google.android.gms.internal.ads.zzdy");
    }

    public final Context getContext() {
        return this.zzlj;
    }

    public final boolean isInitialized() {
        return this.zzxs;
    }

    public final ExecutorService zzch() {
        return this.zzxf;
    }

    public final DexClassLoader zzci() {
        return this.zzxg;
    }

    public final zzdj zzcj() {
        return this.zzxh;
    }

    public final byte[] zzck() {
        return this.zzxi;
    }

    public final boolean zzcl() {
        return this.zzxp;
    }

    public final zzda zzcm() {
        return this.zzxo;
    }

    public final boolean zzcn() {
        return this.zzxq;
    }

    public final boolean zzco() {
        return this.zzxt;
    }

    public final zzbp.zza zzcp() {
        return this.zzxm;
    }

    public final Future zzcq() {
        return this.zzxn;
    }

    private zzdy(Context context) {
        boolean z = true;
        this.zzxt = true;
        this.zzxu = false;
        Context applicationContext = context.getApplicationContext();
        this.zzxl = applicationContext == null ? false : z;
        this.zzlj = this.zzxl ? applicationContext : context;
        this.zzxr = new HashMap();
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(10:20|21|22|23|24|25|26|27|28|30) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:26:0x00c4 */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00d6 A[SYNTHETIC, Splitter:B:39:0x00d6] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00db A[SYNTHETIC, Splitter:B:43:0x00db] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00e5 A[SYNTHETIC, Splitter:B:52:0x00e5] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00ea A[SYNTHETIC, Splitter:B:56:0x00ea] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zza(java.io.File r8, java.lang.String r9) {
        /*
            r7 = this;
            java.io.File r0 = new java.io.File
            java.lang.String r1 = "%s/%s.tmp"
            r2 = 2
            java.lang.Object[] r3 = new java.lang.Object[r2]
            r4 = 0
            r3[r4] = r8
            r5 = 1
            r3[r5] = r9
            java.lang.String r1 = java.lang.String.format(r1, r3)
            r0.<init>(r1)
            boolean r1 = r0.exists()
            if (r1 == 0) goto L_0x001b
            return
        L_0x001b:
            java.io.File r1 = new java.io.File
            java.lang.String r3 = "%s/%s.dex"
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r2[r4] = r8
            r2[r5] = r9
            java.lang.String r8 = java.lang.String.format(r3, r2)
            r1.<init>(r8)
            boolean r8 = r1.exists()
            if (r8 != 0) goto L_0x0033
            return
        L_0x0033:
            long r2 = r1.length()
            r5 = 0
            int r8 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r8 > 0) goto L_0x003e
            return
        L_0x003e:
            int r8 = (int) r2
            byte[] r8 = new byte[r8]
            r2 = 0
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ zzdk | IOException | NoSuchAlgorithmException -> 0x00e2, all -> 0x00d2 }
            r3.<init>(r1)     // Catch:{ zzdk | IOException | NoSuchAlgorithmException -> 0x00e2, all -> 0x00d2 }
            int r5 = r3.read(r8)     // Catch:{ zzdk | IOException | NoSuchAlgorithmException -> 0x00e3, all -> 0x00d0 }
            if (r5 > 0) goto L_0x0054
            r3.close()     // Catch:{ IOException -> 0x0050 }
        L_0x0050:
            zzb(r1)
            return
        L_0x0054:
            java.io.PrintStream r5 = java.lang.System.out     // Catch:{ zzdk | IOException | NoSuchAlgorithmException -> 0x00e3, all -> 0x00d0 }
            java.lang.String r6 = "test"
            r5.print(r6)     // Catch:{ zzdk | IOException | NoSuchAlgorithmException -> 0x00e3, all -> 0x00d0 }
            java.io.PrintStream r5 = java.lang.System.out     // Catch:{ zzdk | IOException | NoSuchAlgorithmException -> 0x00e3, all -> 0x00d0 }
            java.lang.String r6 = "test"
            r5.print(r6)     // Catch:{ zzdk | IOException | NoSuchAlgorithmException -> 0x00e3, all -> 0x00d0 }
            java.io.PrintStream r5 = java.lang.System.out     // Catch:{ zzdk | IOException | NoSuchAlgorithmException -> 0x00e3, all -> 0x00d0 }
            java.lang.String r6 = "test"
            r5.print(r6)     // Catch:{ zzdk | IOException | NoSuchAlgorithmException -> 0x00e3, all -> 0x00d0 }
            com.google.android.gms.internal.ads.zzbp$zzd$zza r5 = com.google.android.gms.internal.ads.zzbp.zzd.zzbc()     // Catch:{ zzdk | IOException | NoSuchAlgorithmException -> 0x00e3, all -> 0x00d0 }
            java.lang.String r6 = android.os.Build.VERSION.SDK     // Catch:{ zzdk | IOException | NoSuchAlgorithmException -> 0x00e3, all -> 0x00d0 }
            byte[] r6 = r6.getBytes()     // Catch:{ zzdk | IOException | NoSuchAlgorithmException -> 0x00e3, all -> 0x00d0 }
            com.google.android.gms.internal.ads.zzdmr r6 = com.google.android.gms.internal.ads.zzdmr.zzz(r6)     // Catch:{ zzdk | IOException | NoSuchAlgorithmException -> 0x00e3, all -> 0x00d0 }
            com.google.android.gms.internal.ads.zzbp$zzd$zza r5 = r5.zzl(r6)     // Catch:{ zzdk | IOException | NoSuchAlgorithmException -> 0x00e3, all -> 0x00d0 }
            byte[] r9 = r9.getBytes()     // Catch:{ zzdk | IOException | NoSuchAlgorithmException -> 0x00e3, all -> 0x00d0 }
            com.google.android.gms.internal.ads.zzdmr r9 = com.google.android.gms.internal.ads.zzdmr.zzz(r9)     // Catch:{ zzdk | IOException | NoSuchAlgorithmException -> 0x00e3, all -> 0x00d0 }
            com.google.android.gms.internal.ads.zzbp$zzd$zza r9 = r5.zzk(r9)     // Catch:{ zzdk | IOException | NoSuchAlgorithmException -> 0x00e3, all -> 0x00d0 }
            com.google.android.gms.internal.ads.zzdj r5 = r7.zzxh     // Catch:{ zzdk | IOException | NoSuchAlgorithmException -> 0x00e3, all -> 0x00d0 }
            byte[] r6 = r7.zzxi     // Catch:{ zzdk | IOException | NoSuchAlgorithmException -> 0x00e3, all -> 0x00d0 }
            java.lang.String r8 = r5.zzb(r6, r8)     // Catch:{ zzdk | IOException | NoSuchAlgorithmException -> 0x00e3, all -> 0x00d0 }
            byte[] r8 = r8.getBytes()     // Catch:{ zzdk | IOException | NoSuchAlgorithmException -> 0x00e3, all -> 0x00d0 }
            com.google.android.gms.internal.ads.zzdmr r5 = com.google.android.gms.internal.ads.zzdmr.zzz(r8)     // Catch:{ zzdk | IOException | NoSuchAlgorithmException -> 0x00e3, all -> 0x00d0 }
            com.google.android.gms.internal.ads.zzbp$zzd$zza r5 = r9.zzi(r5)     // Catch:{ zzdk | IOException | NoSuchAlgorithmException -> 0x00e3, all -> 0x00d0 }
            byte[] r8 = com.google.android.gms.internal.ads.zzci.zzb(r8)     // Catch:{ zzdk | IOException | NoSuchAlgorithmException -> 0x00e3, all -> 0x00d0 }
            com.google.android.gms.internal.ads.zzdmr r8 = com.google.android.gms.internal.ads.zzdmr.zzz(r8)     // Catch:{ zzdk | IOException | NoSuchAlgorithmException -> 0x00e3, all -> 0x00d0 }
            r5.zzj(r8)     // Catch:{ zzdk | IOException | NoSuchAlgorithmException -> 0x00e3, all -> 0x00d0 }
            r0.createNewFile()     // Catch:{ zzdk | IOException | NoSuchAlgorithmException -> 0x00e3, all -> 0x00d0 }
            java.io.FileOutputStream r8 = new java.io.FileOutputStream     // Catch:{ zzdk | IOException | NoSuchAlgorithmException -> 0x00e3, all -> 0x00d0 }
            r8.<init>(r0)     // Catch:{ zzdk | IOException | NoSuchAlgorithmException -> 0x00e3, all -> 0x00d0 }
            com.google.android.gms.internal.ads.zzdpk r9 = r9.zzaya()     // Catch:{ zzdk | IOException | NoSuchAlgorithmException -> 0x00ce, all -> 0x00cb }
            com.google.android.gms.internal.ads.zzdob r9 = (com.google.android.gms.internal.ads.zzdob) r9     // Catch:{ zzdk | IOException | NoSuchAlgorithmException -> 0x00ce, all -> 0x00cb }
            com.google.android.gms.internal.ads.zzbp$zzd r9 = (com.google.android.gms.internal.ads.zzbp.zzd) r9     // Catch:{ zzdk | IOException | NoSuchAlgorithmException -> 0x00ce, all -> 0x00cb }
            byte[] r9 = r9.toByteArray()     // Catch:{ zzdk | IOException | NoSuchAlgorithmException -> 0x00ce, all -> 0x00cb }
            int r0 = r9.length     // Catch:{ zzdk | IOException | NoSuchAlgorithmException -> 0x00ce, all -> 0x00cb }
            r8.write(r9, r4, r0)     // Catch:{ zzdk | IOException | NoSuchAlgorithmException -> 0x00ce, all -> 0x00cb }
            r8.close()     // Catch:{ zzdk | IOException | NoSuchAlgorithmException -> 0x00ce, all -> 0x00cb }
            r3.close()     // Catch:{ IOException -> 0x00c4 }
        L_0x00c4:
            r8.close()     // Catch:{ IOException -> 0x00c7 }
        L_0x00c7:
            zzb(r1)
            return
        L_0x00cb:
            r9 = move-exception
            r2 = r8
            goto L_0x00d4
        L_0x00ce:
            r2 = r8
            goto L_0x00e3
        L_0x00d0:
            r9 = move-exception
            goto L_0x00d4
        L_0x00d2:
            r9 = move-exception
            r3 = r2
        L_0x00d4:
            if (r3 == 0) goto L_0x00d9
            r3.close()     // Catch:{ IOException -> 0x00d9 }
        L_0x00d9:
            if (r2 == 0) goto L_0x00de
            r2.close()     // Catch:{ IOException -> 0x00de }
        L_0x00de:
            zzb(r1)
            throw r9
        L_0x00e2:
            r3 = r2
        L_0x00e3:
            if (r3 == 0) goto L_0x00e8
            r3.close()     // Catch:{ IOException -> 0x00e8 }
        L_0x00e8:
            if (r2 == 0) goto L_0x00ed
            r2.close()     // Catch:{ IOException -> 0x00ed }
        L_0x00ed:
            zzb(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdy.zza(java.io.File, java.lang.String):void");
    }

    private static void zzao(String str) {
        zzb(new File(str));
    }

    private static void zzb(File file) {
        if (!file.exists()) {
            Log.d(TAG, String.format("File %s not found. No need for deletion", new Object[]{file.getAbsolutePath()}));
            return;
        }
        file.delete();
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:34:0x00cc */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00e2 A[SYNTHETIC, Splitter:B:52:0x00e2] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00e7 A[SYNTHETIC, Splitter:B:56:0x00e7] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00ee A[SYNTHETIC, Splitter:B:64:0x00ee] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00f3 A[SYNTHETIC, Splitter:B:68:0x00f3] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean zzb(java.io.File r9, java.lang.String r10) {
        /*
            r8 = this;
            java.io.File r0 = new java.io.File
            java.lang.String r1 = "%s/%s.tmp"
            r2 = 2
            java.lang.Object[] r3 = new java.lang.Object[r2]
            r4 = 0
            r3[r4] = r9
            r5 = 1
            r3[r5] = r10
            java.lang.String r1 = java.lang.String.format(r1, r3)
            r0.<init>(r1)
            boolean r1 = r0.exists()
            if (r1 != 0) goto L_0x001b
            return r4
        L_0x001b:
            java.io.File r1 = new java.io.File
            java.lang.String r3 = "%s/%s.dex"
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r2[r4] = r9
            r2[r5] = r10
            java.lang.String r9 = java.lang.String.format(r3, r2)
            r1.<init>(r9)
            boolean r9 = r1.exists()
            if (r9 == 0) goto L_0x0033
            return r4
        L_0x0033:
            r9 = 0
            long r2 = r0.length()     // Catch:{ zzdk | IOException | NoSuchAlgorithmException -> 0x00eb, all -> 0x00de }
            r6 = 0
            int r6 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r6 > 0) goto L_0x0042
            zzb(r0)     // Catch:{ zzdk | IOException | NoSuchAlgorithmException -> 0x00eb, all -> 0x00de }
            return r4
        L_0x0042:
            int r2 = (int) r2     // Catch:{ zzdk | IOException | NoSuchAlgorithmException -> 0x00eb, all -> 0x00de }
            byte[] r2 = new byte[r2]     // Catch:{ zzdk | IOException | NoSuchAlgorithmException -> 0x00eb, all -> 0x00de }
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ zzdk | IOException | NoSuchAlgorithmException -> 0x00eb, all -> 0x00de }
            r3.<init>(r0)     // Catch:{ zzdk | IOException | NoSuchAlgorithmException -> 0x00eb, all -> 0x00de }
            int r6 = r3.read(r2)     // Catch:{ zzdk | IOException | NoSuchAlgorithmException -> 0x00ec, all -> 0x00dc }
            if (r6 > 0) goto L_0x005e
            java.lang.String r10 = TAG     // Catch:{ zzdk | IOException | NoSuchAlgorithmException -> 0x00ec, all -> 0x00dc }
            java.lang.String r1 = "Cannot read the cache data."
            android.util.Log.d(r10, r1)     // Catch:{ zzdk | IOException | NoSuchAlgorithmException -> 0x00ec, all -> 0x00dc }
            zzb(r0)     // Catch:{ zzdk | IOException | NoSuchAlgorithmException -> 0x00ec, all -> 0x00dc }
            r3.close()     // Catch:{ IOException -> 0x005d }
        L_0x005d:
            return r4
        L_0x005e:
            com.google.android.gms.internal.ads.zzdno r6 = com.google.android.gms.internal.ads.zzdno.zzaxe()     // Catch:{ zzdk | IOException | NoSuchAlgorithmException -> 0x00ec, all -> 0x00dc }
            com.google.android.gms.internal.ads.zzbp$zzd r2 = com.google.android.gms.internal.ads.zzbp.zzd.zzc((byte[]) r2, (com.google.android.gms.internal.ads.zzdno) r6)     // Catch:{ zzdk | IOException | NoSuchAlgorithmException -> 0x00ec, all -> 0x00dc }
            java.lang.String r6 = new java.lang.String     // Catch:{ zzdk | IOException | NoSuchAlgorithmException -> 0x00ec, all -> 0x00dc }
            com.google.android.gms.internal.ads.zzdmr r7 = r2.zzba()     // Catch:{ zzdk | IOException | NoSuchAlgorithmException -> 0x00ec, all -> 0x00dc }
            byte[] r7 = r7.toByteArray()     // Catch:{ zzdk | IOException | NoSuchAlgorithmException -> 0x00ec, all -> 0x00dc }
            r6.<init>(r7)     // Catch:{ zzdk | IOException | NoSuchAlgorithmException -> 0x00ec, all -> 0x00dc }
            boolean r10 = r10.equals(r6)     // Catch:{ zzdk | IOException | NoSuchAlgorithmException -> 0x00ec, all -> 0x00dc }
            if (r10 == 0) goto L_0x00d5
            com.google.android.gms.internal.ads.zzdmr r10 = r2.zzaz()     // Catch:{ zzdk | IOException | NoSuchAlgorithmException -> 0x00ec, all -> 0x00dc }
            byte[] r10 = r10.toByteArray()     // Catch:{ zzdk | IOException | NoSuchAlgorithmException -> 0x00ec, all -> 0x00dc }
            com.google.android.gms.internal.ads.zzdmr r6 = r2.zzay()     // Catch:{ zzdk | IOException | NoSuchAlgorithmException -> 0x00ec, all -> 0x00dc }
            byte[] r6 = r6.toByteArray()     // Catch:{ zzdk | IOException | NoSuchAlgorithmException -> 0x00ec, all -> 0x00dc }
            byte[] r6 = com.google.android.gms.internal.ads.zzci.zzb(r6)     // Catch:{ zzdk | IOException | NoSuchAlgorithmException -> 0x00ec, all -> 0x00dc }
            boolean r10 = java.util.Arrays.equals(r10, r6)     // Catch:{ zzdk | IOException | NoSuchAlgorithmException -> 0x00ec, all -> 0x00dc }
            if (r10 == 0) goto L_0x00d5
            com.google.android.gms.internal.ads.zzdmr r10 = r2.zzbb()     // Catch:{ zzdk | IOException | NoSuchAlgorithmException -> 0x00ec, all -> 0x00dc }
            byte[] r10 = r10.toByteArray()     // Catch:{ zzdk | IOException | NoSuchAlgorithmException -> 0x00ec, all -> 0x00dc }
            java.lang.String r6 = android.os.Build.VERSION.SDK     // Catch:{ zzdk | IOException | NoSuchAlgorithmException -> 0x00ec, all -> 0x00dc }
            byte[] r6 = r6.getBytes()     // Catch:{ zzdk | IOException | NoSuchAlgorithmException -> 0x00ec, all -> 0x00dc }
            boolean r10 = java.util.Arrays.equals(r10, r6)     // Catch:{ zzdk | IOException | NoSuchAlgorithmException -> 0x00ec, all -> 0x00dc }
            if (r10 != 0) goto L_0x00a8
            goto L_0x00d5
        L_0x00a8:
            com.google.android.gms.internal.ads.zzdj r10 = r8.zzxh     // Catch:{ zzdk | IOException | NoSuchAlgorithmException -> 0x00ec, all -> 0x00dc }
            byte[] r0 = r8.zzxi     // Catch:{ zzdk | IOException | NoSuchAlgorithmException -> 0x00ec, all -> 0x00dc }
            java.lang.String r6 = new java.lang.String     // Catch:{ zzdk | IOException | NoSuchAlgorithmException -> 0x00ec, all -> 0x00dc }
            com.google.android.gms.internal.ads.zzdmr r2 = r2.zzay()     // Catch:{ zzdk | IOException | NoSuchAlgorithmException -> 0x00ec, all -> 0x00dc }
            byte[] r2 = r2.toByteArray()     // Catch:{ zzdk | IOException | NoSuchAlgorithmException -> 0x00ec, all -> 0x00dc }
            r6.<init>(r2)     // Catch:{ zzdk | IOException | NoSuchAlgorithmException -> 0x00ec, all -> 0x00dc }
            byte[] r10 = r10.zza(r0, r6)     // Catch:{ zzdk | IOException | NoSuchAlgorithmException -> 0x00ec, all -> 0x00dc }
            r1.createNewFile()     // Catch:{ zzdk | IOException | NoSuchAlgorithmException -> 0x00ec, all -> 0x00dc }
            java.io.FileOutputStream r0 = new java.io.FileOutputStream     // Catch:{ zzdk | IOException | NoSuchAlgorithmException -> 0x00ec, all -> 0x00dc }
            r0.<init>(r1)     // Catch:{ zzdk | IOException | NoSuchAlgorithmException -> 0x00ec, all -> 0x00dc }
            int r9 = r10.length     // Catch:{ zzdk | IOException | NoSuchAlgorithmException -> 0x00d3, all -> 0x00d0 }
            r0.write(r10, r4, r9)     // Catch:{ zzdk | IOException | NoSuchAlgorithmException -> 0x00d3, all -> 0x00d0 }
            r3.close()     // Catch:{ IOException -> 0x00cc }
        L_0x00cc:
            r0.close()     // Catch:{ IOException -> 0x00cf }
        L_0x00cf:
            return r5
        L_0x00d0:
            r10 = move-exception
            r9 = r0
            goto L_0x00e0
        L_0x00d3:
            r9 = r0
            goto L_0x00ec
        L_0x00d5:
            zzb(r0)     // Catch:{ zzdk | IOException | NoSuchAlgorithmException -> 0x00ec, all -> 0x00dc }
            r3.close()     // Catch:{ IOException -> 0x00db }
        L_0x00db:
            return r4
        L_0x00dc:
            r10 = move-exception
            goto L_0x00e0
        L_0x00de:
            r10 = move-exception
            r3 = r9
        L_0x00e0:
            if (r3 == 0) goto L_0x00e5
            r3.close()     // Catch:{ IOException -> 0x00e5 }
        L_0x00e5:
            if (r9 == 0) goto L_0x00ea
            r9.close()     // Catch:{ IOException -> 0x00ea }
        L_0x00ea:
            throw r10
        L_0x00eb:
            r3 = r9
        L_0x00ec:
            if (r3 == 0) goto L_0x00f1
            r3.close()     // Catch:{ IOException -> 0x00f1 }
        L_0x00f1:
            if (r9 == 0) goto L_0x00f6
            r9.close()     // Catch:{ IOException -> 0x00f6 }
        L_0x00f6:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdy.zzb(java.io.File, java.lang.String):boolean");
    }

    public final boolean zza(String str, String str2, Class<?>... clsArr) {
        if (this.zzxr.containsKey(new Pair(str, str2))) {
            return false;
        }
        this.zzxr.put(new Pair(str, str2), new zzfi(this, str, str2, clsArr));
        return true;
    }

    public final Method zzc(String str, String str2) {
        zzfi zzfi = this.zzxr.get(new Pair(str, str2));
        if (zzfi == null) {
            return null;
        }
        return zzfi.zzdc();
    }

    /* access modifiers changed from: private */
    public final void zzcr() {
        try {
            if (this.zzxj == null && this.zzxl) {
                AdvertisingIdClient advertisingIdClient = new AdvertisingIdClient(this.zzlj);
                advertisingIdClient.start();
                this.zzxj = advertisingIdClient;
            }
        } catch (GooglePlayServicesNotAvailableException | GooglePlayServicesRepairableException | IOException unused) {
            this.zzxj = null;
        }
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public final void zza(int i, boolean z) {
        if (this.zzxq) {
            Future<?> submit = this.zzxf.submit(new zzeb(this, i, z));
            if (i == 0) {
                this.zzxn = submit;
            }
        }
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public final zzbp.zza zzb(int i, boolean z) {
        if (i > 0 && z) {
            try {
                Thread.sleep((long) (i * 1000));
            } catch (InterruptedException unused) {
            }
        }
        return zzcs();
    }

    /* access modifiers changed from: private */
    public static boolean zza(int i, zzbp.zza zza2) {
        if (i >= 4) {
            return false;
        }
        if (zza2 != null && zza2.zzai() && !zza2.zzae().equals("0000000000000000000000000000000000000000000000000000000000000000") && zza2.zzak() && zza2.zzal().zzbe() && zza2.zzal().zzbf() != -2) {
            return false;
        }
        return true;
    }

    @VisibleForTesting
    private final zzbp.zza zzcs() {
        try {
            return zzdal.zzj(this.zzlj, this.zzlj.getPackageName(), Integer.toString(this.zzlj.getPackageManager().getPackageInfo(this.zzlj.getPackageName(), 0).versionCode));
        } catch (Throwable unused) {
            return null;
        }
    }

    public final AdvertisingIdClient zzct() {
        if (!this.zzwf) {
            return null;
        }
        if (this.zzxj != null) {
            return this.zzxj;
        }
        if (this.zzxk != null) {
            try {
                this.zzxk.get(AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS, TimeUnit.MILLISECONDS);
                this.zzxk = null;
            } catch (InterruptedException | ExecutionException unused) {
            } catch (TimeoutException unused2) {
                this.zzxk.cancel(true);
            }
        }
        return this.zzxj;
    }

    public final int zzcd() {
        if (this.zzxo != null) {
            return zzda.zzcd();
        }
        return Integer.MIN_VALUE;
    }
}
