package com.google.android.gms.internal.ads;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.mediation.MediationExtrasReceiver;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.ads.search.SearchAdRequest;
import java.util.Collections;
import java.util.Date;
import java.util.Map;
import java.util.Set;

@zzard
public final class zzaaz {
    private final boolean zzbqn;
    private final int zzcgo;
    private final int zzcgr;
    private final String zzcgs;
    private final String zzcgu;
    private final Bundle zzcgw;
    private final String zzcgy;
    private final boolean zzcha;
    private final int zzchc;
    private final String zzchd;
    private final Bundle zzcis;
    private final Map<Class<? extends NetworkExtras>, NetworkExtras> zzcit;
    private final SearchAdRequest zzciu;
    private final Set<String> zzciv;
    private final Set<String> zzciw;
    private final zzdak zzcix;
    private final Date zzms;
    private final Set<String> zzmu;
    private final Location zzmw;

    public zzaaz(zzaba zzaba) {
        this(zzaba, (SearchAdRequest) null);
    }

    public zzaaz(zzaba zzaba, SearchAdRequest searchAdRequest) {
        this.zzms = zzaba.zzms;
        this.zzcgu = zzaba.zzcgu;
        this.zzcgo = zzaba.zzcgo;
        this.zzmu = Collections.unmodifiableSet(zzaba.zzciy);
        this.zzmw = zzaba.zzmw;
        this.zzbqn = zzaba.zzbqn;
        this.zzcis = zzaba.zzcis;
        this.zzcit = Collections.unmodifiableMap(zzaba.zzciz);
        this.zzcgs = zzaba.zzcgs;
        this.zzcgy = zzaba.zzcgy;
        this.zzciu = searchAdRequest;
        this.zzcgr = zzaba.zzcgr;
        this.zzciv = Collections.unmodifiableSet(zzaba.zzcja);
        this.zzcgw = zzaba.zzcgw;
        this.zzciw = Collections.unmodifiableSet(zzaba.zzcjb);
        this.zzcha = zzaba.zzcha;
        this.zzcix = null;
        this.zzchc = zzaba.zzchc;
        this.zzchd = zzaba.zzchd;
    }

    @Deprecated
    public final Date getBirthday() {
        return this.zzms;
    }

    public final String getContentUrl() {
        return this.zzcgu;
    }

    @Deprecated
    public final int getGender() {
        return this.zzcgo;
    }

    public final Set<String> getKeywords() {
        return this.zzmu;
    }

    public final Location getLocation() {
        return this.zzmw;
    }

    public final boolean getManualImpressionsEnabled() {
        return this.zzbqn;
    }

    @Deprecated
    public final <T extends NetworkExtras> T getNetworkExtras(Class<T> cls) {
        return (NetworkExtras) this.zzcit.get(cls);
    }

    public final Bundle getNetworkExtrasBundle(Class<? extends MediationExtrasReceiver> cls) {
        return this.zzcis.getBundle(cls.getName());
    }

    public final Bundle getCustomEventExtrasBundle(Class<? extends CustomEvent> cls) {
        Bundle bundle = this.zzcis.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter");
        if (bundle != null) {
            return bundle.getBundle(cls.getName());
        }
        return null;
    }

    public final String getPublisherProvidedId() {
        return this.zzcgs;
    }

    public final String zzpy() {
        return this.zzcgy;
    }

    public final SearchAdRequest zzpz() {
        return this.zzciu;
    }

    public final boolean isTestDevice(Context context) {
        Set<String> set = this.zzciv;
        zzyt.zzpa();
        return set.contains(zzazt.zzbe(context));
    }

    public final Map<Class<? extends NetworkExtras>, NetworkExtras> zzqa() {
        return this.zzcit;
    }

    public final Bundle zzqb() {
        return this.zzcis;
    }

    public final int zzqc() {
        return this.zzcgr;
    }

    public final Bundle getCustomTargeting() {
        return this.zzcgw;
    }

    public final Set<String> zzqd() {
        return this.zzciw;
    }

    @Deprecated
    public final boolean isDesignedForFamilies() {
        return this.zzcha;
    }

    public final int zzqe() {
        return this.zzchc;
    }

    @Nullable
    public final String getMaxAdContentRating() {
        return this.zzchd;
    }
}
