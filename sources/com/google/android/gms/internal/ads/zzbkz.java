package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONObject;

public final class zzbkz extends zzaac {
    private final zzbai zzbtc;
    private final zzclc zzfee;
    private final zzcjz<zzams, zzclb> zzfef;
    private final zzcpf zzfeg;
    private final zzcgb zzfeh;
    private final Context zzlj;
    @GuardedBy("this")
    private boolean zzxs = false;

    zzbkz(Context context, zzbai zzbai, zzclc zzclc, zzcjz<zzams, zzclb> zzcjz, zzcpf zzcpf, zzcgb zzcgb) {
        this.zzlj = context;
        this.zzbtc = zzbai;
        this.zzfee = zzclc;
        this.zzfef = zzcjz;
        this.zzfeg = zzcpf;
        this.zzfeh = zzcgb;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0045, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zza() {
        /*
            r3 = this;
            monitor-enter(r3)
            boolean r0 = r3.zzxs     // Catch:{ all -> 0x0046 }
            if (r0 == 0) goto L_0x000c
            java.lang.String r0 = "Mobile ads is initialized already."
            com.google.android.gms.internal.ads.zzawz.zzep(r0)     // Catch:{ all -> 0x0046 }
            monitor-exit(r3)
            return
        L_0x000c:
            android.content.Context r0 = r3.zzlj     // Catch:{ all -> 0x0046 }
            com.google.android.gms.internal.ads.zzacu.initialize(r0)     // Catch:{ all -> 0x0046 }
            com.google.android.gms.internal.ads.zzawm r0 = com.google.android.gms.ads.internal.zzk.zzlk()     // Catch:{ all -> 0x0046 }
            android.content.Context r1 = r3.zzlj     // Catch:{ all -> 0x0046 }
            com.google.android.gms.internal.ads.zzbai r2 = r3.zzbtc     // Catch:{ all -> 0x0046 }
            r0.zzd(r1, r2)     // Catch:{ all -> 0x0046 }
            com.google.android.gms.internal.ads.zzvn r0 = com.google.android.gms.ads.internal.zzk.zzlm()     // Catch:{ all -> 0x0046 }
            android.content.Context r1 = r3.zzlj     // Catch:{ all -> 0x0046 }
            r0.initialize(r1)     // Catch:{ all -> 0x0046 }
            r0 = 1
            r3.zzxs = r0     // Catch:{ all -> 0x0046 }
            com.google.android.gms.internal.ads.zzcgb r0 = r3.zzfeh     // Catch:{ all -> 0x0046 }
            r0.zzakd()     // Catch:{ all -> 0x0046 }
            com.google.android.gms.internal.ads.zzacj<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzacu.zzcqu     // Catch:{ all -> 0x0046 }
            com.google.android.gms.internal.ads.zzacr r1 = com.google.android.gms.internal.ads.zzyt.zzpe()     // Catch:{ all -> 0x0046 }
            java.lang.Object r0 = r1.zzd(r0)     // Catch:{ all -> 0x0046 }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x0046 }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x0046 }
            if (r0 == 0) goto L_0x0044
            com.google.android.gms.internal.ads.zzcpf r0 = r3.zzfeg     // Catch:{ all -> 0x0046 }
            r0.zzakw()     // Catch:{ all -> 0x0046 }
        L_0x0044:
            monitor-exit(r3)
            return
        L_0x0046:
            r0 = move-exception
            monitor-exit(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbkz.zza():void");
    }

    public final synchronized void setAppVolume(float f) {
        zzk.zzll().setAppVolume(f);
    }

    public final synchronized float zzpq() {
        return zzk.zzll().zzpq();
    }

    public final synchronized void setAppMuted(boolean z) {
        zzk.zzll().setAppMuted(z);
    }

    public final synchronized boolean zzpr() {
        return zzk.zzll().zzpr();
    }

    public final synchronized void zzbu(String str) {
        zzacu.initialize(this.zzlj);
        if (!TextUtils.isEmpty(str)) {
            if (((Boolean) zzyt.zzpe().zzd(zzacu.zzcsv)).booleanValue()) {
                zzk.zzlo().zza(this.zzlj, this.zzbtc, str, (Runnable) null);
            }
        }
    }

    public final void zzc(IObjectWrapper iObjectWrapper, String str) {
        if (iObjectWrapper == null) {
            zzawz.zzen("Wrapped context is null. Failed to open debug menu.");
            return;
        }
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        if (context == null) {
            zzawz.zzen("Context is null. Failed to open debug menu.");
            return;
        }
        zzayb zzayb = new zzayb(context);
        zzayb.setAdUnitId(str);
        zzayb.zzp(this.zzbtc.zzbsx);
        zzayb.showDialog();
    }

    public final void zzb(@Nullable String str, IObjectWrapper iObjectWrapper) {
        String str2 = "";
        if (((Boolean) zzyt.zzpe().zzd(zzacu.zzcsx)).booleanValue()) {
            str2 = zzaep();
        }
        if (!TextUtils.isEmpty(str2)) {
            str = str2;
        }
        if (!TextUtils.isEmpty(str)) {
            zzacu.initialize(this.zzlj);
            boolean booleanValue = ((Boolean) zzyt.zzpe().zzd(zzacu.zzcsv)).booleanValue() | ((Boolean) zzyt.zzpe().zzd(zzacu.zzcot)).booleanValue();
            zzbla zzbla = null;
            if (((Boolean) zzyt.zzpe().zzd(zzacu.zzcot)).booleanValue()) {
                booleanValue = true;
                zzbla = new zzbla(this, (Runnable) ObjectWrapper.unwrap(iObjectWrapper));
            }
            if (booleanValue) {
                zzk.zzlo().zza(this.zzlj, this.zzbtc, str, (Runnable) zzbla);
            }
        }
    }

    public final String getVersionString() {
        return this.zzbtc.zzbsx;
    }

    public final void zzbv(String str) {
        this.zzfeg.zzfr(str);
    }

    public final void zza(zzamp zzamp) throws RemoteException {
        this.zzfee.zzb(zzamp);
    }

    public final void zza(zzait zzait) throws RemoteException {
        this.zzfeh.zzb(zzait);
    }

    public final List<zzaio> zzps() throws RemoteException {
        return this.zzfeh.zzajy();
    }

    private final String zzaep() {
        Context applicationContext = this.zzlj.getApplicationContext() == null ? this.zzlj : this.zzlj.getApplicationContext();
        try {
            return Wrappers.packageManager(applicationContext).getApplicationInfo(applicationContext.getPackageName(), 128).metaData.getString("com.google.android.gms.ads.APPLICATION_ID");
        } catch (PackageManager.NameNotFoundException | NullPointerException e) {
            zzawz.zza("Error getting metadata", e);
            return "";
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzf(Runnable runnable) {
        Preconditions.checkMainThread("Adapters must be initialized on the main thread.");
        Map<String, zzamm> zzuu = zzk.zzlk().zzvc().zzvr().zzuu();
        if (zzuu != null && !zzuu.isEmpty()) {
            if (runnable != null) {
                try {
                    runnable.run();
                } catch (Throwable th) {
                    zzawz.zzd("Could not initialize rewarded ads.", th);
                    return;
                }
            }
            if (this.zzfee.zzakr()) {
                HashMap hashMap = new HashMap();
                IObjectWrapper wrap = ObjectWrapper.wrap(this.zzlj);
                for (zzamm zzamm : zzuu.values()) {
                    for (zzaml next : zzamm.zzdfd) {
                        String str = next.zzdeq;
                        for (String next2 : next.zzdei) {
                            if (!hashMap.containsKey(next2)) {
                                hashMap.put(next2, new ArrayList());
                            }
                            if (str != null) {
                                ((Collection) hashMap.get(next2)).add(str);
                            }
                        }
                    }
                }
                JSONObject jSONObject = new JSONObject();
                for (Map.Entry entry : hashMap.entrySet()) {
                    String str2 = (String) entry.getKey();
                    try {
                        zzcjy<zzams, zzclb> zzd = this.zzfef.zzd(str2, jSONObject);
                        if (zzd != null) {
                            zzams zzams = (zzams) zzd.zzdgc;
                            if (!zzams.isInitialized()) {
                                if (zzams.zzsj()) {
                                    zzams.zza(wrap, (zzatk) (zzclb) zzd.zzfzn, (List<String>) (List) entry.getValue());
                                    String valueOf = String.valueOf(str2);
                                    zzawz.zzdp(valueOf.length() != 0 ? "Initialized rewarded video mediation adapter ".concat(valueOf) : new String("Initialized rewarded video mediation adapter "));
                                }
                            }
                        }
                    } catch (Throwable th2) {
                        StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 56);
                        sb.append("Failed to initialize rewarded video mediation adapter \"");
                        sb.append(str2);
                        sb.append("\"");
                        zzawz.zzd(sb.toString(), th2);
                    }
                }
            }
        }
    }
}
