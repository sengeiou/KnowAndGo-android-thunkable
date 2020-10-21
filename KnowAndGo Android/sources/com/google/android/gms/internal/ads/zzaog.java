package com.google.android.gms.internal.ads;

import com.google.ads.AdRequest;
import com.google.ads.mediation.MediationAdRequest;
import java.util.Date;
import java.util.HashSet;

@zzard
public final class zzaog {
    public static int zza(AdRequest.ErrorCode errorCode) {
        switch (zzaoh.zzdha[errorCode.ordinal()]) {
            case 2:
                return 1;
            case 3:
                return 2;
            case 4:
                return 3;
            default:
                return 0;
        }
    }

    public static MediationAdRequest zza(zzxz zzxz, boolean z) {
        AdRequest.Gender gender;
        HashSet hashSet = zzxz.zzcgp != null ? new HashSet(zzxz.zzcgp) : null;
        Date date = new Date(zzxz.zzcgn);
        switch (zzxz.zzcgo) {
            case 1:
                gender = AdRequest.Gender.MALE;
                break;
            case 2:
                gender = AdRequest.Gender.FEMALE;
                break;
            default:
                gender = AdRequest.Gender.UNKNOWN;
                break;
        }
        return new MediationAdRequest(date, gender, hashSet, z, zzxz.zzmw);
    }
}
