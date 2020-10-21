package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "RewardedVideoAdRequestParcelCreator")
@SafeParcelable.Reserved({1})
@zzard
public final class zzath extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzath> CREATOR = new zzati();
    @SafeParcelable.Field(mo22648id = 3)
    public final String zzchk;
    @SafeParcelable.Field(mo22648id = 2)
    public final zzxz zzdlk;

    @SafeParcelable.Constructor
    public zzath(@SafeParcelable.Param(mo22651id = 2) zzxz zzxz, @SafeParcelable.Param(mo22651id = 3) String str) {
        this.zzdlk = zzxz;
        this.zzchk = str;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzdlk, i, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzchk, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
