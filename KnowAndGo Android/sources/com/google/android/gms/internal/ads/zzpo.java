package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.List;

public final class zzpo implements Parcelable {
    public static final Parcelable.Creator<zzpo> CREATOR = new zzpp();
    private final zza[] zzbhv;

    public interface zza extends Parcelable {
    }

    public zzpo(List<? extends zza> list) {
        this.zzbhv = new zza[list.size()];
        list.toArray(this.zzbhv);
    }

    public final int describeContents() {
        return 0;
    }

    zzpo(Parcel parcel) {
        this.zzbhv = new zza[parcel.readInt()];
        for (int i = 0; i < this.zzbhv.length; i++) {
            this.zzbhv[i] = (zza) parcel.readParcelable(zza.class.getClassLoader());
        }
    }

    public final int length() {
        return this.zzbhv.length;
    }

    public final zza zzbc(int i) {
        return this.zzbhv[i];
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.zzbhv, ((zzpo) obj).zzbhv);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.zzbhv);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.zzbhv.length);
        for (zza writeParcelable : this.zzbhv) {
            parcel.writeParcelable(writeParcelable, 0);
        }
    }
}
