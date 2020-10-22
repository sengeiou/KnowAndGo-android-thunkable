package com.google.android.gms.internal.ads;

import android.location.Location;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.mediation.MediationExtrasReceiver;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.admob.AdMobExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;

public final class zzaba {
    /* access modifiers changed from: private */
    public boolean zzbqn = false;
    /* access modifiers changed from: private */
    public int zzcgo = -1;
    /* access modifiers changed from: private */
    public int zzcgr = -1;
    /* access modifiers changed from: private */
    public String zzcgs;
    /* access modifiers changed from: private */
    public String zzcgu;
    /* access modifiers changed from: private */
    public final Bundle zzcgw = new Bundle();
    /* access modifiers changed from: private */
    public String zzcgy;
    /* access modifiers changed from: private */
    public boolean zzcha;
    /* access modifiers changed from: private */
    public int zzchc = -1;
    /* access modifiers changed from: private */
    public String zzchd;
    /* access modifiers changed from: private */
    public final Bundle zzcis = new Bundle();
    /* access modifiers changed from: private */
    public final HashSet<String> zzciy = new HashSet<>();
    /* access modifiers changed from: private */
    public final HashMap<Class<? extends NetworkExtras>, NetworkExtras> zzciz = new HashMap<>();
    /* access modifiers changed from: private */
    public final HashSet<String> zzcja = new HashSet<>();
    /* access modifiers changed from: private */
    public final HashSet<String> zzcjb = new HashSet<>();
    /* access modifiers changed from: private */
    public Date zzms;
    /* access modifiers changed from: private */
    public Location zzmw;

    public final void zzbw(String str) {
        this.zzciy.add(str);
    }

    @Deprecated
    public final void zza(NetworkExtras networkExtras) {
        if (networkExtras instanceof AdMobExtras) {
            zza(AdMobAdapter.class, ((AdMobExtras) networkExtras).getExtras());
        } else {
            this.zzciz.put(networkExtras.getClass(), networkExtras);
        }
    }

    public final void zza(Class<? extends MediationExtrasReceiver> cls, Bundle bundle) {
        this.zzcis.putBundle(cls.getName(), bundle);
    }

    public final void zzb(Class<? extends CustomEvent> cls, Bundle bundle) {
        if (this.zzcis.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter") == null) {
            this.zzcis.putBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter", new Bundle());
        }
        this.zzcis.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter").putBundle(cls.getName(), bundle);
    }

    public final void zzbx(String str) {
        this.zzcja.add(str);
    }

    public final void zzby(String str) {
        this.zzcja.remove(str);
    }

    @Deprecated
    public final void zza(Date date) {
        this.zzms = date;
    }

    public final void zzbz(String str) {
        this.zzcgu = str;
    }

    @Deprecated
    public final void zzcn(int i) {
        this.zzcgo = i;
    }

    public final void zza(Location location) {
        this.zzmw = location;
    }

    public final void setManualImpressionsEnabled(boolean z) {
        this.zzbqn = z;
    }

    public final void zzca(String str) {
        this.zzcgs = str;
    }

    public final void zzcb(String str) {
        this.zzcgy = str;
    }

    public final void zzt(boolean z) {
        this.zzcgr = z ? 1 : 0;
    }

    public final void zze(String str, String str2) {
        this.zzcgw.putString(str, str2);
    }

    public final void zzcc(String str) {
        this.zzcjb.add(str);
    }

    @Deprecated
    public final void zzu(boolean z) {
        this.zzcha = z;
    }

    public final void zzco(int i) {
        if (i == -1 || i == 0 || i == 1) {
            this.zzchc = i;
        }
    }

    public final void zzcd(String str) {
        if ("G".equals(str) || "PG".equals(str) || "T".equals(str) || "MA".equals(str)) {
            this.zzchd = str;
        }
    }
}
