package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.Map;
import javax.annotation.concurrent.GuardedBy;

public final class zzbot implements zzbrw, zzbsr {
    private final zzbai zzbtc;
    @Nullable
    private final zzbgz zzdbs;
    private final zzcxm zzfig;
    @GuardedBy("this")
    @Nullable
    private IObjectWrapper zzfih;
    @GuardedBy("this")
    private boolean zzfii;
    private final Context zzlj;

    public zzbot(Context context, @Nullable zzbgz zzbgz, zzcxm zzcxm, zzbai zzbai) {
        this.zzlj = context;
        this.zzdbs = zzbgz;
        this.zzfig = zzcxm;
        this.zzbtc = zzbai;
    }

    public final synchronized void onAdLoaded() {
        if (!this.zzfii) {
            zzafv();
        }
    }

    public final synchronized void onAdImpression() {
        if (!this.zzfii) {
            zzafv();
        }
        if (!(!this.zzfig.zzdoh || this.zzfih == null || this.zzdbs == null)) {
            this.zzdbs.zza("onSdkImpression", (Map<String, ?>) new ArrayMap());
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x008b, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final synchronized void zzafv() {
        /*
            r10 = this;
            monitor-enter(r10)
            com.google.android.gms.internal.ads.zzcxm r0 = r10.zzfig     // Catch:{ all -> 0x008c }
            boolean r0 = r0.zzdoh     // Catch:{ all -> 0x008c }
            if (r0 != 0) goto L_0x0009
            monitor-exit(r10)
            return
        L_0x0009:
            com.google.android.gms.internal.ads.zzbgz r0 = r10.zzdbs     // Catch:{ all -> 0x008c }
            if (r0 != 0) goto L_0x000f
            monitor-exit(r10)
            return
        L_0x000f:
            com.google.android.gms.internal.ads.zzaqd r0 = com.google.android.gms.ads.internal.zzk.zzlv()     // Catch:{ all -> 0x008c }
            android.content.Context r1 = r10.zzlj     // Catch:{ all -> 0x008c }
            boolean r0 = r0.zzl(r1)     // Catch:{ all -> 0x008c }
            if (r0 != 0) goto L_0x001d
            monitor-exit(r10)
            return
        L_0x001d:
            com.google.android.gms.internal.ads.zzbai r0 = r10.zzbtc     // Catch:{ all -> 0x008c }
            int r0 = r0.zzdzc     // Catch:{ all -> 0x008c }
            com.google.android.gms.internal.ads.zzbai r1 = r10.zzbtc     // Catch:{ all -> 0x008c }
            int r1 = r1.zzdzd     // Catch:{ all -> 0x008c }
            r2 = 23
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x008c }
            r3.<init>(r2)     // Catch:{ all -> 0x008c }
            r3.append(r0)     // Catch:{ all -> 0x008c }
            java.lang.String r0 = "."
            r3.append(r0)     // Catch:{ all -> 0x008c }
            r3.append(r1)     // Catch:{ all -> 0x008c }
            java.lang.String r5 = r3.toString()     // Catch:{ all -> 0x008c }
            com.google.android.gms.internal.ads.zzcxm r0 = r10.zzfig     // Catch:{ all -> 0x008c }
            org.json.JSONObject r0 = r0.zzgko     // Catch:{ all -> 0x008c }
            java.lang.String r1 = "media_type"
            r2 = -1
            int r0 = r0.optInt(r1, r2)     // Catch:{ all -> 0x008c }
            if (r0 != 0) goto L_0x004b
            r0 = 0
        L_0x0049:
            r9 = r0
            goto L_0x004e
        L_0x004b:
            java.lang.String r0 = "javascript"
            goto L_0x0049
        L_0x004e:
            com.google.android.gms.internal.ads.zzaqd r4 = com.google.android.gms.ads.internal.zzk.zzlv()     // Catch:{ all -> 0x008c }
            com.google.android.gms.internal.ads.zzbgz r0 = r10.zzdbs     // Catch:{ all -> 0x008c }
            android.webkit.WebView r6 = r0.getWebView()     // Catch:{ all -> 0x008c }
            java.lang.String r7 = ""
            java.lang.String r8 = "javascript"
            com.google.android.gms.dynamic.IObjectWrapper r0 = r4.zza(r5, r6, r7, r8, r9)     // Catch:{ all -> 0x008c }
            r10.zzfih = r0     // Catch:{ all -> 0x008c }
            com.google.android.gms.internal.ads.zzbgz r0 = r10.zzdbs     // Catch:{ all -> 0x008c }
            android.view.View r0 = r0.getView()     // Catch:{ all -> 0x008c }
            com.google.android.gms.dynamic.IObjectWrapper r1 = r10.zzfih     // Catch:{ all -> 0x008c }
            if (r1 == 0) goto L_0x008a
            if (r0 == 0) goto L_0x008a
            com.google.android.gms.internal.ads.zzaqd r1 = com.google.android.gms.ads.internal.zzk.zzlv()     // Catch:{ all -> 0x008c }
            com.google.android.gms.dynamic.IObjectWrapper r2 = r10.zzfih     // Catch:{ all -> 0x008c }
            r1.zza(r2, r0)     // Catch:{ all -> 0x008c }
            com.google.android.gms.internal.ads.zzbgz r0 = r10.zzdbs     // Catch:{ all -> 0x008c }
            com.google.android.gms.dynamic.IObjectWrapper r1 = r10.zzfih     // Catch:{ all -> 0x008c }
            r0.zzam(r1)     // Catch:{ all -> 0x008c }
            com.google.android.gms.internal.ads.zzaqd r0 = com.google.android.gms.ads.internal.zzk.zzlv()     // Catch:{ all -> 0x008c }
            com.google.android.gms.dynamic.IObjectWrapper r1 = r10.zzfih     // Catch:{ all -> 0x008c }
            r0.zzaa(r1)     // Catch:{ all -> 0x008c }
            r0 = 1
            r10.zzfii = r0     // Catch:{ all -> 0x008c }
        L_0x008a:
            monitor-exit(r10)
            return
        L_0x008c:
            r0 = move-exception
            monitor-exit(r10)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbot.zzafv():void");
    }
}
