package com.google.android.gms.internal.ads;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.amplitude.api.DeviceInfo;
import com.google.android.gms.ads.AdActivity;
import com.google.android.gms.common.util.VisibleForTesting;
import javax.annotation.concurrent.GuardedBy;

@zzard
public final class zzawr {
    private final Object lock = new Object();
    @VisibleForTesting
    private long zzdue = -1;
    @VisibleForTesting
    private long zzduf = -1;
    @GuardedBy("lock")
    @VisibleForTesting
    private int zzdug = -1;
    @VisibleForTesting
    int zzduh = -1;
    @VisibleForTesting
    private long zzdui = 0;
    @VisibleForTesting
    private final String zzduj;
    private final zzaxb zzduk;
    @GuardedBy("lock")
    @VisibleForTesting
    private int zzdul = 0;
    @GuardedBy("lock")
    @VisibleForTesting
    private int zzdum = 0;

    public zzawr(String str, zzaxb zzaxb) {
        this.zzduj = str;
        this.zzduk = zzaxb;
    }

    public final void zzuk() {
        synchronized (this.lock) {
            this.zzdul++;
        }
    }

    public final void zzuj() {
        synchronized (this.lock) {
            this.zzdum++;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x007b, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(com.google.android.gms.internal.ads.zzxz r10, long r11) {
        /*
            r9 = this;
            java.lang.Object r0 = r9.lock
            monitor-enter(r0)
            com.google.android.gms.internal.ads.zzaxb r1 = r9.zzduk     // Catch:{ all -> 0x007c }
            long r1 = r1.zzvs()     // Catch:{ all -> 0x007c }
            com.google.android.gms.common.util.Clock r3 = com.google.android.gms.ads.internal.zzk.zzln()     // Catch:{ all -> 0x007c }
            long r3 = r3.currentTimeMillis()     // Catch:{ all -> 0x007c }
            long r5 = r9.zzduf     // Catch:{ all -> 0x007c }
            r7 = -1
            int r5 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r5 != 0) goto L_0x0042
            long r1 = r3 - r1
            com.google.android.gms.internal.ads.zzacj<java.lang.Long> r5 = com.google.android.gms.internal.ads.zzacu.zzcoy     // Catch:{ all -> 0x007c }
            com.google.android.gms.internal.ads.zzacr r6 = com.google.android.gms.internal.ads.zzyt.zzpe()     // Catch:{ all -> 0x007c }
            java.lang.Object r5 = r6.zzd(r5)     // Catch:{ all -> 0x007c }
            java.lang.Long r5 = (java.lang.Long) r5     // Catch:{ all -> 0x007c }
            long r5 = r5.longValue()     // Catch:{ all -> 0x007c }
            int r1 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r1 <= 0) goto L_0x0033
            r1 = -1
            r9.zzduh = r1     // Catch:{ all -> 0x007c }
            goto L_0x003b
        L_0x0033:
            com.google.android.gms.internal.ads.zzaxb r1 = r9.zzduk     // Catch:{ all -> 0x007c }
            int r1 = r1.zzvt()     // Catch:{ all -> 0x007c }
            r9.zzduh = r1     // Catch:{ all -> 0x007c }
        L_0x003b:
            r9.zzduf = r11     // Catch:{ all -> 0x007c }
            long r11 = r9.zzduf     // Catch:{ all -> 0x007c }
            r9.zzdue = r11     // Catch:{ all -> 0x007c }
            goto L_0x0044
        L_0x0042:
            r9.zzdue = r11     // Catch:{ all -> 0x007c }
        L_0x0044:
            r11 = 1
            if (r10 == 0) goto L_0x0058
            android.os.Bundle r12 = r10.extras     // Catch:{ all -> 0x007c }
            if (r12 == 0) goto L_0x0058
            android.os.Bundle r10 = r10.extras     // Catch:{ all -> 0x007c }
            java.lang.String r12 = "gw"
            r1 = 2
            int r10 = r10.getInt(r12, r1)     // Catch:{ all -> 0x007c }
            if (r10 != r11) goto L_0x0058
            monitor-exit(r0)     // Catch:{ all -> 0x007c }
            return
        L_0x0058:
            int r10 = r9.zzdug     // Catch:{ all -> 0x007c }
            int r10 = r10 + r11
            r9.zzdug = r10     // Catch:{ all -> 0x007c }
            int r10 = r9.zzduh     // Catch:{ all -> 0x007c }
            int r10 = r10 + r11
            r9.zzduh = r10     // Catch:{ all -> 0x007c }
            int r10 = r9.zzduh     // Catch:{ all -> 0x007c }
            if (r10 != 0) goto L_0x0070
            r10 = 0
            r9.zzdui = r10     // Catch:{ all -> 0x007c }
            com.google.android.gms.internal.ads.zzaxb r10 = r9.zzduk     // Catch:{ all -> 0x007c }
            r10.zzfd(r3)     // Catch:{ all -> 0x007c }
            goto L_0x007a
        L_0x0070:
            com.google.android.gms.internal.ads.zzaxb r10 = r9.zzduk     // Catch:{ all -> 0x007c }
            long r10 = r10.zzvu()     // Catch:{ all -> 0x007c }
            r12 = 0
            long r3 = r3 - r10
            r9.zzdui = r3     // Catch:{ all -> 0x007c }
        L_0x007a:
            monitor-exit(r0)     // Catch:{ all -> 0x007c }
            return
        L_0x007c:
            r10 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x007c }
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzawr.zza(com.google.android.gms.internal.ads.zzxz, long):void");
    }

    public final Bundle zzn(Context context, String str) {
        Bundle bundle;
        synchronized (this.lock) {
            bundle = new Bundle();
            bundle.putString("session_id", this.zzduj);
            bundle.putLong("basets", this.zzduf);
            bundle.putLong("currts", this.zzdue);
            bundle.putString("seq_num", str);
            bundle.putInt("preqs", this.zzdug);
            bundle.putInt("preqs_in_session", this.zzduh);
            bundle.putLong("time_in_session", this.zzdui);
            bundle.putInt("pclick", this.zzdul);
            bundle.putInt("pimp", this.zzdum);
            bundle.putBoolean("support_transparent_background", zzai(context));
        }
        return bundle;
    }

    private static boolean zzai(Context context) {
        Context zzw = zzasq.zzw(context);
        int identifier = zzw.getResources().getIdentifier("Theme.Translucent", TtmlNode.TAG_STYLE, DeviceInfo.OS_NAME);
        if (identifier == 0) {
            zzawz.zzeo("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
            return false;
        }
        try {
            if (identifier == zzw.getPackageManager().getActivityInfo(new ComponentName(zzw.getPackageName(), AdActivity.CLASS_NAME), 0).theme) {
                return true;
            }
            zzawz.zzeo("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
            return false;
        } catch (PackageManager.NameNotFoundException unused) {
            zzawz.zzep("Fail to fetch AdActivity theme");
            zzawz.zzeo("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
            return false;
        }
    }
}
