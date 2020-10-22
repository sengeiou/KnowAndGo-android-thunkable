package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;

final class zzpr implements Parcelable.Creator<zzpq> {
    zzpr() {
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzpq[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new zzpq(parcel);
    }
}
