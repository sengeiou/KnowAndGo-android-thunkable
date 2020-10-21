package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;

final class zzpt implements Parcelable.Creator<zzps> {
    zzpt() {
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzps[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new zzps(parcel);
    }
}
