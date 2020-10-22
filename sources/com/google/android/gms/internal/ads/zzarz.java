package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "StringParcelCreator")
@SafeParcelable.Reserved({1})
@zzard
public final class zzarz extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzarz> CREATOR = new zzasa();
    @SafeParcelable.Field(mo22648id = 2)
    String zzdow;

    @SafeParcelable.Constructor
    public zzarz(@SafeParcelable.Param(mo22651id = 2) String str) {
        this.zzdow = str;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zzdow, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
