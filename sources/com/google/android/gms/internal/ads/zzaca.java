package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.search.SearchAdRequest;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "SearchAdRequestParcelCreator")
@SafeParcelable.Reserved({1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14})
@zzard
public final class zzaca extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaca> CREATOR = new zzacb();
    @SafeParcelable.Field(mo22648id = 15)
    private final String zzckf;

    public zzaca(SearchAdRequest searchAdRequest) {
        this.zzckf = searchAdRequest.getQuery();
    }

    @SafeParcelable.Constructor
    zzaca(@SafeParcelable.Param(mo22651id = 15) String str) {
        this.zzckf = str;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 15, this.zzckf, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
