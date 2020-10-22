package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;

public final class zzpw extends zzpv {
    public static final Parcelable.Creator<zzpw> CREATOR = new zzpx();
    private final String description;
    private final String value;

    public zzpw(String str, String str2, String str3) {
        super(str);
        this.description = null;
        this.value = str3;
    }

    zzpw(Parcel parcel) {
        super(parcel.readString());
        this.description = parcel.readString();
        this.value = parcel.readString();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        zzpw zzpw = (zzpw) obj;
        return this.zzatl.equals(zzpw.zzatl) && zzsy.zza(this.description, zzpw.description) && zzsy.zza(this.value, zzpw.value);
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = (((this.zzatl.hashCode() + 527) * 31) + (this.description != null ? this.description.hashCode() : 0)) * 31;
        if (this.value != null) {
            i = this.value.hashCode();
        }
        return hashCode + i;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.zzatl);
        parcel.writeString(this.description);
        parcel.writeString(this.value);
    }
}
