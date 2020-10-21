package com.google.android.gms.internal.ads;

import androidx.exifinterface.media.ExifInterface;
import java.util.HashMap;

public final class zzch extends zzcf<Integer, Object> {
    public String zzne;
    public long zznf;
    public String zzng;
    public String zznh;
    public String zzni;

    public zzch(String str) {
        this();
        zzak(str);
    }

    public zzch() {
        this.zzne = ExifInterface.LONGITUDE_EAST;
        this.zznf = -1;
        this.zzng = ExifInterface.LONGITUDE_EAST;
        this.zznh = ExifInterface.LONGITUDE_EAST;
        this.zzni = ExifInterface.LONGITUDE_EAST;
    }

    /* access modifiers changed from: protected */
    public final void zzak(String str) {
        String str2;
        long j;
        String str3;
        String str4;
        String str5;
        HashMap zzal = zzal(str);
        if (zzal != null) {
            if (zzal.get(0) == null) {
                str2 = ExifInterface.LONGITUDE_EAST;
            } else {
                str2 = (String) zzal.get(0);
            }
            this.zzne = str2;
            if (zzal.get(1) == null) {
                j = -1;
            } else {
                j = ((Long) zzal.get(1)).longValue();
            }
            this.zznf = j;
            if (zzal.get(2) == null) {
                str3 = ExifInterface.LONGITUDE_EAST;
            } else {
                str3 = (String) zzal.get(2);
            }
            this.zzng = str3;
            if (zzal.get(3) == null) {
                str4 = ExifInterface.LONGITUDE_EAST;
            } else {
                str4 = (String) zzal.get(3);
            }
            this.zznh = str4;
            if (zzal.get(4) == null) {
                str5 = ExifInterface.LONGITUDE_EAST;
            } else {
                str5 = (String) zzal.get(4);
            }
            this.zzni = str5;
        }
    }

    /* access modifiers changed from: protected */
    public final HashMap<Integer, Object> zzca() {
        HashMap<Integer, Object> hashMap = new HashMap<>();
        hashMap.put(0, this.zzne);
        hashMap.put(4, this.zzni);
        hashMap.put(3, this.zznh);
        hashMap.put(2, this.zzng);
        hashMap.put(1, Long.valueOf(this.zznf));
        return hashMap;
    }
}
