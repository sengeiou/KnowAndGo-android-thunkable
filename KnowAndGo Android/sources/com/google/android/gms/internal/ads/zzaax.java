package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "IconAdOptionsParcelCreator")
@SafeParcelable.Reserved({1})
@zzard
public final class zzaax extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaax> CREATOR = new zzaay();
    @SafeParcelable.Field(mo22648id = 2)
    private final int zzcir;

    @SafeParcelable.Constructor
    public zzaax(@SafeParcelable.Param(mo22651id = 2) int i) {
        this.zzcir = i;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 2, this.zzcir);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
