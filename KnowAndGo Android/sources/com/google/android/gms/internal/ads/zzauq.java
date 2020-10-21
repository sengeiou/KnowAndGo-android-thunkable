package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.wrappers.Wrappers;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@ParametersAreNonnullByDefault
@zzard
public final class zzauq implements zzavb {
    /* access modifiers changed from: private */
    public static List<Future<Void>> zzdqz = Collections.synchronizedList(new ArrayList());
    private static ScheduledExecutorService zzdra = Executors.newSingleThreadScheduledExecutor();
    /* access modifiers changed from: private */
    public final Object lock = new Object();
    private final zzauy zzdoc;
    /* access modifiers changed from: private */
    @GuardedBy("lock")
    public final zzdsj zzdrb;
    @GuardedBy("lock")
    private final LinkedHashMap<String, zzdsp> zzdrc;
    @GuardedBy("lock")
    private final List<String> zzdrd = new ArrayList();
    @GuardedBy("lock")
    private final List<String> zzdre = new ArrayList();
    private final zzavd zzdrf;
    @VisibleForTesting
    private boolean zzdrg;
    private final zzave zzdrh;
    private HashSet<String> zzdri = new HashSet<>();
    private boolean zzdrj = false;
    private boolean zzdrk = false;
    private boolean zzdrl = false;
    private final Context zzlj;

    public zzauq(Context context, zzbai zzbai, zzauy zzauy, String str, zzavd zzavd) {
        Preconditions.checkNotNull(zzauy, "SafeBrowsing config is not present.");
        this.zzlj = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        this.zzdrc = new LinkedHashMap<>();
        this.zzdrf = zzavd;
        this.zzdoc = zzauy;
        for (String lowerCase : this.zzdoc.zzdrv) {
            this.zzdri.add(lowerCase.toLowerCase(Locale.ENGLISH));
        }
        this.zzdri.remove("cookie".toLowerCase(Locale.ENGLISH));
        zzdsj zzdsj = new zzdsj();
        zzdsj.zzhrv = 8;
        zzdsj.url = str;
        zzdsj.zzhrx = str;
        zzdsj.zzhrz = new zzdsk();
        zzdsj.zzhrz.zzdrr = this.zzdoc.zzdrr;
        zzdsq zzdsq = new zzdsq();
        zzdsq.zzhte = zzbai.zzbsx;
        zzdsq.zzhtg = Boolean.valueOf(Wrappers.packageManager(this.zzlj).isCallerInstantApp());
        long apkVersion = (long) GoogleApiAvailabilityLight.getInstance().getApkVersion(this.zzlj);
        if (apkVersion > 0) {
            zzdsq.zzhtf = Long.valueOf(apkVersion);
        }
        zzdsj.zzhsj = zzdsq;
        this.zzdrb = zzdsj;
        this.zzdrh = new zzave(this.zzlj, this.zzdoc.zzdry, this);
    }

    static final /* synthetic */ Void zzdo(String str) {
        return null;
    }

    public final zzauy zzuc() {
        return this.zzdoc;
    }

    public final void zzdk(String str) {
        synchronized (this.lock) {
            this.zzdrb.zzhsb = str;
        }
    }

    public final boolean zzud() {
        return PlatformVersion.isAtLeastKitKat() && this.zzdoc.zzdrt && !this.zzdrk;
    }

    public final void zzj(View view) {
        if (this.zzdoc.zzdrt && !this.zzdrk) {
            zzk.zzlg();
            Bitmap zzl = zzaxi.zzl(view);
            if (zzl == null) {
                zzava.zzdp("Failed to capture the webview bitmap.");
                return;
            }
            this.zzdrk = true;
            zzaxi.zzd((Runnable) new zzaut(this, zzl));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0026, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(java.lang.String r7, java.util.Map<java.lang.String, java.lang.String> r8, int r9) {
        /*
            r6 = this;
            java.lang.Object r0 = r6.lock
            monitor-enter(r0)
            r1 = 3
            if (r9 != r1) goto L_0x000d
            r2 = 1
            r6.zzdrl = r2     // Catch:{ all -> 0x000a }
            goto L_0x000d
        L_0x000a:
            r7 = move-exception
            goto L_0x00ca
        L_0x000d:
            java.util.LinkedHashMap<java.lang.String, com.google.android.gms.internal.ads.zzdsp> r2 = r6.zzdrc     // Catch:{ all -> 0x000a }
            boolean r2 = r2.containsKey(r7)     // Catch:{ all -> 0x000a }
            if (r2 == 0) goto L_0x0027
            if (r9 != r1) goto L_0x0025
            java.util.LinkedHashMap<java.lang.String, com.google.android.gms.internal.ads.zzdsp> r8 = r6.zzdrc     // Catch:{ all -> 0x000a }
            java.lang.Object r7 = r8.get(r7)     // Catch:{ all -> 0x000a }
            com.google.android.gms.internal.ads.zzdsp r7 = (com.google.android.gms.internal.ads.zzdsp) r7     // Catch:{ all -> 0x000a }
            java.lang.Integer r8 = java.lang.Integer.valueOf(r9)     // Catch:{ all -> 0x000a }
            r7.zzhtc = r8     // Catch:{ all -> 0x000a }
        L_0x0025:
            monitor-exit(r0)     // Catch:{ all -> 0x000a }
            return
        L_0x0027:
            com.google.android.gms.internal.ads.zzdsp r1 = new com.google.android.gms.internal.ads.zzdsp     // Catch:{ all -> 0x000a }
            r1.<init>()     // Catch:{ all -> 0x000a }
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)     // Catch:{ all -> 0x000a }
            r1.zzhtc = r9     // Catch:{ all -> 0x000a }
            java.util.LinkedHashMap<java.lang.String, com.google.android.gms.internal.ads.zzdsp> r9 = r6.zzdrc     // Catch:{ all -> 0x000a }
            int r9 = r9.size()     // Catch:{ all -> 0x000a }
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)     // Catch:{ all -> 0x000a }
            r1.zzhsw = r9     // Catch:{ all -> 0x000a }
            r1.url = r7     // Catch:{ all -> 0x000a }
            com.google.android.gms.internal.ads.zzdsm r9 = new com.google.android.gms.internal.ads.zzdsm     // Catch:{ all -> 0x000a }
            r9.<init>()     // Catch:{ all -> 0x000a }
            r1.zzhsx = r9     // Catch:{ all -> 0x000a }
            java.util.HashSet<java.lang.String> r9 = r6.zzdri     // Catch:{ all -> 0x000a }
            int r9 = r9.size()     // Catch:{ all -> 0x000a }
            if (r9 <= 0) goto L_0x00c3
            if (r8 == 0) goto L_0x00c3
            java.util.ArrayList r9 = new java.util.ArrayList     // Catch:{ all -> 0x000a }
            r9.<init>()     // Catch:{ all -> 0x000a }
            java.util.Set r8 = r8.entrySet()     // Catch:{ all -> 0x000a }
            java.util.Iterator r8 = r8.iterator()     // Catch:{ all -> 0x000a }
        L_0x005e:
            boolean r2 = r8.hasNext()     // Catch:{ all -> 0x000a }
            if (r2 == 0) goto L_0x00b6
            java.lang.Object r2 = r8.next()     // Catch:{ all -> 0x000a }
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2     // Catch:{ all -> 0x000a }
            java.lang.Object r3 = r2.getKey()     // Catch:{ UnsupportedEncodingException -> 0x00b0 }
            if (r3 == 0) goto L_0x0077
            java.lang.Object r3 = r2.getKey()     // Catch:{ UnsupportedEncodingException -> 0x00b0 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ UnsupportedEncodingException -> 0x00b0 }
            goto L_0x0079
        L_0x0077:
            java.lang.String r3 = ""
        L_0x0079:
            java.lang.Object r4 = r2.getValue()     // Catch:{ UnsupportedEncodingException -> 0x00b0 }
            if (r4 == 0) goto L_0x0086
            java.lang.Object r2 = r2.getValue()     // Catch:{ UnsupportedEncodingException -> 0x00b0 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ UnsupportedEncodingException -> 0x00b0 }
            goto L_0x0088
        L_0x0086:
            java.lang.String r2 = ""
        L_0x0088:
            java.util.Locale r4 = java.util.Locale.ENGLISH     // Catch:{ UnsupportedEncodingException -> 0x00b0 }
            java.lang.String r4 = r3.toLowerCase(r4)     // Catch:{ UnsupportedEncodingException -> 0x00b0 }
            java.util.HashSet<java.lang.String> r5 = r6.zzdri     // Catch:{ UnsupportedEncodingException -> 0x00b0 }
            boolean r4 = r5.contains(r4)     // Catch:{ UnsupportedEncodingException -> 0x00b0 }
            if (r4 != 0) goto L_0x0097
            goto L_0x005e
        L_0x0097:
            com.google.android.gms.internal.ads.zzdsl r4 = new com.google.android.gms.internal.ads.zzdsl     // Catch:{ UnsupportedEncodingException -> 0x00b0 }
            r4.<init>()     // Catch:{ UnsupportedEncodingException -> 0x00b0 }
            java.lang.String r5 = "UTF-8"
            byte[] r3 = r3.getBytes(r5)     // Catch:{ UnsupportedEncodingException -> 0x00b0 }
            r4.zzhsn = r3     // Catch:{ UnsupportedEncodingException -> 0x00b0 }
            java.lang.String r3 = "UTF-8"
            byte[] r2 = r2.getBytes(r3)     // Catch:{ UnsupportedEncodingException -> 0x00b0 }
            r4.zzhso = r2     // Catch:{ UnsupportedEncodingException -> 0x00b0 }
            r9.add(r4)     // Catch:{ UnsupportedEncodingException -> 0x00b0 }
            goto L_0x005e
        L_0x00b0:
            java.lang.String r2 = "Cannot convert string to bytes, skip header."
            com.google.android.gms.internal.ads.zzava.zzdp(r2)     // Catch:{ all -> 0x000a }
            goto L_0x005e
        L_0x00b6:
            int r8 = r9.size()     // Catch:{ all -> 0x000a }
            com.google.android.gms.internal.ads.zzdsl[] r8 = new com.google.android.gms.internal.ads.zzdsl[r8]     // Catch:{ all -> 0x000a }
            r9.toArray(r8)     // Catch:{ all -> 0x000a }
            com.google.android.gms.internal.ads.zzdsm r9 = r1.zzhsx     // Catch:{ all -> 0x000a }
            r9.zzhsq = r8     // Catch:{ all -> 0x000a }
        L_0x00c3:
            java.util.LinkedHashMap<java.lang.String, com.google.android.gms.internal.ads.zzdsp> r8 = r6.zzdrc     // Catch:{ all -> 0x000a }
            r8.put(r7, r1)     // Catch:{ all -> 0x000a }
            monitor-exit(r0)     // Catch:{ all -> 0x000a }
            return
        L_0x00ca:
            monitor-exit(r0)     // Catch:{ all -> 0x000a }
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzauq.zza(java.lang.String, java.util.Map, int):void");
    }

    /* access modifiers changed from: package-private */
    public final void zzdl(String str) {
        synchronized (this.lock) {
            this.zzdrd.add(str);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzdm(String str) {
        synchronized (this.lock) {
            this.zzdre.add(str);
        }
    }

    public final String[] zza(String[] strArr) {
        return (String[]) this.zzdrh.zzb(strArr).toArray(new String[0]);
    }

    public final void zzue() {
        this.zzdrj = true;
    }

    @Nullable
    private final zzdsp zzdn(String str) {
        zzdsp zzdsp;
        synchronized (this.lock) {
            zzdsp = this.zzdrc.get(str);
        }
        return zzdsp;
    }

    public final void zzuf() {
        synchronized (this.lock) {
            zzbbh<B> zza = zzbar.zza(this.zzdrf.zza(this.zzlj, this.zzdrc.keySet()), new zzaur(this), zzbbm.zzeaf);
            zzbbh<V> zza2 = zzbar.zza(zza, 10, TimeUnit.SECONDS, zzdra);
            zzbar.zza(zza, new zzauu(this, zza2), zzbbm.zzeaf);
            zzdqz.add(zza2);
        }
    }

    @VisibleForTesting
    private final zzbbh<Void> zzug() {
        zzbbh<Void> zza;
        if (!((this.zzdrg && this.zzdoc.zzdrx) || (this.zzdrl && this.zzdoc.zzdrw) || (!this.zzdrg && this.zzdoc.zzdru))) {
            return zzbar.zzm(null);
        }
        synchronized (this.lock) {
            this.zzdrb.zzhsa = new zzdsp[this.zzdrc.size()];
            this.zzdrc.values().toArray(this.zzdrb.zzhsa);
            this.zzdrb.zzhsk = (String[]) this.zzdrd.toArray(new String[0]);
            this.zzdrb.zzhsl = (String[]) this.zzdre.toArray(new String[0]);
            if (zzava.isEnabled()) {
                String str = this.zzdrb.url;
                String str2 = this.zzdrb.zzhsb;
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 53 + String.valueOf(str2).length());
                sb.append("Sending SB report\n  url: ");
                sb.append(str);
                sb.append("\n  clickUrl: ");
                sb.append(str2);
                sb.append("\n  resources: \n");
                StringBuilder sb2 = new StringBuilder(sb.toString());
                for (zzdsp zzdsp : this.zzdrb.zzhsa) {
                    sb2.append("    [");
                    sb2.append(zzdsp.zzhtd.length);
                    sb2.append("] ");
                    sb2.append(zzdsp.url);
                }
                zzava.zzdp(sb2.toString());
            }
            zzbbh<String> zza2 = new zzayu(this.zzlj).zza(1, this.zzdoc.zzdrs, (Map<String, String>) null, zzdrw.zza((zzdrw) this.zzdrb));
            if (zzava.isEnabled()) {
                zza2.zza(new zzauv(this), zzaxg.zzdvp);
            }
            zza = zzbar.zza(zza2, zzaus.zzdrn, zzbbm.zzeaf);
        }
        return zza;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzbbh zzh(Map map) throws Exception {
        if (map != null) {
            try {
                for (String str : map.keySet()) {
                    JSONArray optJSONArray = new JSONObject((String) map.get(str)).optJSONArray("matches");
                    if (optJSONArray != null) {
                        synchronized (this.lock) {
                            int length = optJSONArray.length();
                            zzdsp zzdn = zzdn(str);
                            if (zzdn == null) {
                                String valueOf = String.valueOf(str);
                                zzava.zzdp(valueOf.length() != 0 ? "Cannot find the corresponding resource object for ".concat(valueOf) : new String("Cannot find the corresponding resource object for "));
                            } else {
                                zzdn.zzhtd = new String[length];
                                boolean z = false;
                                for (int i = 0; i < length; i++) {
                                    zzdn.zzhtd[i] = optJSONArray.getJSONObject(i).getString("threat_type");
                                }
                                boolean z2 = this.zzdrg;
                                if (length > 0) {
                                    z = true;
                                }
                                this.zzdrg = z | z2;
                            }
                        }
                    }
                }
            } catch (JSONException e) {
                if (((Boolean) zzyt.zzpe().zzd(zzacu.zzctj)).booleanValue()) {
                    zzawz.zzb("Failed to get SafeBrowsing metadata", e);
                }
                return zzbar.zzd(new Exception("Safebrowsing report transmission failed."));
            }
        }
        if (this.zzdrg) {
            synchronized (this.lock) {
                this.zzdrb.zzhrv = 9;
            }
        }
        return zzug();
    }
}
