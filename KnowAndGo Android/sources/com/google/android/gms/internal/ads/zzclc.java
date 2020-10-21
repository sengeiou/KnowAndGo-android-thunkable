package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.ads.mediation.AdUrlAdapter;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.mediation.MediationAdapter;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzclc {
    private final AtomicReference<zzamp> zzgal = new AtomicReference<>();

    zzclc() {
    }

    public final void zzb(zzamp zzamp) {
        this.zzgal.compareAndSet((Object) null, zzamp);
    }

    public final zzams zze(String str, JSONObject jSONObject) throws RemoteException {
        if ("com.google.ads.mediation.admob.AdMobAdapter".equals(str)) {
            return new zzanl((MediationAdapter) new AdMobAdapter());
        }
        if ("com.google.ads.mediation.AdUrlAdapter".equals(str)) {
            return new zzanl((MediationAdapter) new AdUrlAdapter());
        }
        if ("com.google.ads.mediation.admob.AdMobCustomTabsAdapter".equals(str)) {
            return new zzanl((MediationAdapter) new zzapl());
        }
        return zzf(str, jSONObject);
    }

    public final zzaov zzcy(String str) throws RemoteException {
        return zzaks().zzcy(str);
    }

    public final boolean zzakr() {
        return this.zzgal.get() != null;
    }

    private final zzams zzf(String str, JSONObject jSONObject) throws RemoteException {
        zzamp zzaks = zzaks();
        if ("com.google.ads.mediation.customevent.CustomEventAdapter".equals(str) || "com.google.android.gms.ads.mediation.customevent.CustomEventAdapter".equals(str)) {
            try {
                if (zzaks.zzcv(jSONObject.getString("class_name"))) {
                    return zzaks.zzcu("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter");
                }
                return zzaks.zzcu("com.google.ads.mediation.customevent.CustomEventAdapter");
            } catch (JSONException e) {
                zzawz.zzc("Invalid custom event.", e);
            }
        }
        return zzaks.zzcu(str);
    }

    private final zzamp zzaks() throws RemoteException {
        zzamp zzamp = this.zzgal.get();
        if (zzamp != null) {
            return zzamp;
        }
        zzawz.zzep("Unexpected call to adapter creator.");
        throw new RemoteException();
    }
}
