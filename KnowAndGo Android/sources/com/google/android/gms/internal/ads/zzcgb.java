package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.polidea.rxandroidble.ClientComponent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzcgb {
    private final Executor zzffi;
    private final Executor zzffv;
    private final ScheduledExecutorService zzfkf;
    private boolean zzfuz = false;
    private boolean zzfva = false;
    private final long zzfvb;
    private final zzbbr<Boolean> zzfvc = new zzbbr<>();
    private final zzclc zzfvd;
    private Map<String, zzaio> zzfve = new ConcurrentHashMap();
    private final Context zzlj;

    public zzcgb(Executor executor, Context context, Executor executor2, zzclc zzclc, ScheduledExecutorService scheduledExecutorService) {
        this.zzfvd = zzclc;
        this.zzlj = context;
        this.zzffi = executor2;
        this.zzfkf = scheduledExecutorService;
        this.zzffv = executor;
        this.zzfvb = zzk.zzln().elapsedRealtime();
        zza("com.google.android.gms.ads.MobileAds", false, "", 0);
    }

    public final void zzb(zzait zzait) {
        this.zzfvc.zza(new zzcgc(this, zzait), this.zzffv);
    }

    /* renamed from: zzajx */
    public final void zzakd() {
        if (((Boolean) zzyt.zzpe().zzd(zzacu.zzcqy)).booleanValue() && !this.zzfuz) {
            synchronized (this) {
                if (!this.zzfuz) {
                    String zzus = zzk.zzlk().zzvc().zzvr().zzus();
                    if (TextUtils.isEmpty(zzus)) {
                        zzajz();
                        return;
                    }
                    this.zzfuz = true;
                    zza("com.google.android.gms.ads.MobileAds", true, "", (int) (zzk.zzln().elapsedRealtime() - this.zzfvb));
                    this.zzffi.execute(new zzcgd(this, zzus));
                }
            }
        }
    }

    public final List<zzaio> zzajy() {
        ArrayList arrayList = new ArrayList();
        for (String next : this.zzfve.keySet()) {
            zzaio zzaio = this.zzfve.get(next);
            arrayList.add(new zzaio(next, zzaio.zzdbb, zzaio.zzdbc, zzaio.description));
        }
        return arrayList;
    }

    private final synchronized void zzajz() {
        if (!this.zzfva) {
            zzk.zzlk().zzvc().zzb(new zzcge(this));
            this.zzfva = true;
            this.zzfkf.schedule(new zzcgf(this), ((Long) zzyt.zzpe().zzd(zzacu.zzcra)).longValue(), TimeUnit.SECONDS);
        }
    }

    /* access modifiers changed from: private */
    public final void zza(String str, boolean z, String str2, int i) {
        this.zzfve.put(str, new zzaio(str, z, i, str2));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(zzams zzams, zzaiq zzaiq, List list) {
        try {
            zzams.zza(ObjectWrapper.wrap(this.zzlj), zzaiq, (List<zzaiw>) list);
        } catch (RemoteException unused) {
            try {
                zzaiq.onInitializationFailed("Failed to create Adapter.");
            } catch (RemoteException e) {
                zzbad.zzc("", e);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object zzaka() throws Exception {
        this.zzfvc.set(true);
        return null;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(Object obj, zzbbr zzbbr, String str, long j) {
        synchronized (obj) {
            if (!zzbbr.isDone()) {
                zza(str, false, ClientComponent.NamedSchedulers.TIMEOUT, (int) (zzk.zzln().elapsedRealtime() - j));
                zzbbr.set(false);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzakb() {
        synchronized (this) {
            if (!this.zzfuz) {
                zza("com.google.android.gms.ads.MobileAds", false, ClientComponent.NamedSchedulers.TIMEOUT, (int) (zzk.zzln().elapsedRealtime() - this.zzfvb));
                this.zzfvc.set(true);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzakc() {
        this.zzffi.execute(new zzcgj(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzfq(String str) {
        try {
            ArrayList arrayList = new ArrayList();
            JSONObject jSONObject = new JSONObject(str).getJSONObject("initializer_settings").getJSONObject("config");
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                Object obj = new Object();
                zzbbr zzbbr = new zzbbr();
                zzbbh zza = zzbar.zza(zzbbr, ((Long) zzyt.zzpe().zzd(zzacu.zzcqz)).longValue(), TimeUnit.SECONDS, this.zzfkf);
                long elapsedRealtime = zzk.zzln().elapsedRealtime();
                Iterator<String> it = keys;
                zzcgg zzcgg = r1;
                zzcgg zzcgg2 = new zzcgg(this, obj, zzbbr, next, elapsedRealtime);
                zza.zza(zzcgg, this.zzffi);
                arrayList.add(zza);
                zzcgk zzcgk = new zzcgk(this, obj, next, elapsedRealtime, zzbbr);
                JSONObject optJSONObject = jSONObject.optJSONObject(next);
                ArrayList arrayList2 = new ArrayList();
                if (optJSONObject != null) {
                    try {
                        JSONArray jSONArray = optJSONObject.getJSONArray("data");
                        for (int i = 0; i < jSONArray.length(); i++) {
                            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                            String optString = jSONObject2.optString("format", "");
                            JSONObject optJSONObject2 = jSONObject2.optJSONObject("data");
                            Bundle bundle = new Bundle();
                            if (optJSONObject2 != null) {
                                Iterator<String> keys2 = optJSONObject2.keys();
                                while (keys2.hasNext()) {
                                    String next2 = keys2.next();
                                    bundle.putString(next2, optJSONObject2.optString(next2, ""));
                                }
                            }
                            arrayList2.add(new zzaiw(optString, bundle));
                        }
                    } catch (JSONException unused) {
                    }
                }
                zza(next, false, "", 0);
                try {
                    this.zzffv.execute(new zzcgi(this, this.zzfvd.zze(next, new JSONObject()), zzcgk, arrayList2));
                } catch (RemoteException unused2) {
                    try {
                        zzcgk.onInitializationFailed("Failed to create Adapter.");
                    } catch (RemoteException e) {
                        zzbad.zzc("", e);
                    }
                }
                keys = it;
            }
            zzbar.zzf(arrayList).zza(new zzcgh(this), this.zzffi);
        } catch (JSONException e2) {
            zzawz.zza("Malformed CLD response", e2);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzc(zzait zzait) {
        try {
            zzait.zzc(zzajy());
        } catch (RemoteException e) {
            zzbad.zzc("", e);
        }
    }
}
