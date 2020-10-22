package com.google.android.gms.internal.ads;

import android.location.Location;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import java.util.Date;
import java.util.Set;

@zzard
public final class zzank implements MediationAdRequest {
    private final int zzcgo;
    private final boolean zzcha;
    private final String zzchd;
    private final int zzdga;
    private final int zzdgb;
    private final Date zzms;
    private final Set<String> zzmu;
    private final boolean zzmv;
    private final Location zzmw;

    public zzank(@Nullable Date date, int i, @Nullable Set<String> set, @Nullable Location location, boolean z, int i2, boolean z2, int i3, String str) {
        this.zzms = date;
        this.zzcgo = i;
        this.zzmu = set;
        this.zzmw = location;
        this.zzmv = z;
        this.zzdga = i2;
        this.zzcha = z2;
        this.zzdgb = i3;
        this.zzchd = str;
    }

    @Deprecated
    public final Date getBirthday() {
        return this.zzms;
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

    public final boolean isTesting() {
        return this.zzmv;
    }

    public final int taggedForChildDirectedTreatment() {
        return this.zzdga;
    }

    @Deprecated
    public final boolean isDesignedForFamilies() {
        return this.zzcha;
    }
}
