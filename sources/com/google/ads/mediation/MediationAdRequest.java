package com.google.ads.mediation;

import android.location.Location;
import com.google.ads.AdRequest;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;

@Deprecated
public class MediationAdRequest {
    private final Date zzms;
    private final AdRequest.Gender zzmt;
    private final Set<String> zzmu;
    private final boolean zzmv;
    private final Location zzmw;

    public MediationAdRequest(Date date, AdRequest.Gender gender, Set<String> set, boolean z, Location location) {
        this.zzms = date;
        this.zzmt = gender;
        this.zzmu = set;
        this.zzmv = z;
        this.zzmw = location;
    }

    public Integer getAgeInYears() {
        if (this.zzms == null) {
            return null;
        }
        Calendar instance = Calendar.getInstance();
        Calendar instance2 = Calendar.getInstance();
        instance.setTime(this.zzms);
        Integer valueOf = Integer.valueOf(instance2.get(1) - instance.get(1));
        return (instance2.get(2) < instance.get(2) || (instance2.get(2) == instance.get(2) && instance2.get(5) < instance.get(5))) ? Integer.valueOf(valueOf.intValue() - 1) : valueOf;
    }

    public Date getBirthday() {
        return this.zzms;
    }

    public AdRequest.Gender getGender() {
        return this.zzmt;
    }

    public Set<String> getKeywords() {
        return this.zzmu;
    }

    public Location getLocation() {
        return this.zzmw;
    }

    public boolean isTesting() {
        return this.zzmv;
    }
}
