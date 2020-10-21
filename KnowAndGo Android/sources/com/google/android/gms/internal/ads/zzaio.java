package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "AdapterStatusParcelCreator")
@zzard
public final class zzaio extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaio> CREATOR = new zzaip();
    @SafeParcelable.Field(mo22648id = 4)
    public final String description;
    @SafeParcelable.Field(mo22648id = 1)
    private final String zzdba;
    @SafeParcelable.Field(mo22648id = 2)
    public final boolean zzdbb;
    @SafeParcelable.Field(mo22648id = 3)
    public final int zzdbc;

    @SafeParcelable.Constructor
    public zzaio(@SafeParcelable.Param(mo22651id = 1) String str, @SafeParcelable.Param(mo22651id = 2) boolean z, @SafeParcelable.Param(mo22651id = 3) int i, @SafeParcelable.Param(mo22651id = 4) String str2) {
        this.zzdba = str;
        this.zzdbb = z;
        this.zzdbc = i;
        this.description = str2;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zzdba, false);
        SafeParcelWriter.writeBoolean(parcel, 2, this.zzdbb);
        SafeParcelWriter.writeInt(parcel, 3, this.zzdbc);
        SafeParcelWriter.writeString(parcel, 4, this.description, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
