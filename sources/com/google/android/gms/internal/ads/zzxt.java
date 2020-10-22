package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "AdDataParcelCreator")
@zzard
public final class zzxt extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzxt> CREATOR = new zzxu();
    @SafeParcelable.Field(mo22648id = 1)
    public final String zzcgj;
    @SafeParcelable.Field(mo22648id = 2)
    public final String zzcgk;

    @SafeParcelable.Constructor
    public zzxt(@SafeParcelable.Param(mo22651id = 1) String str, @SafeParcelable.Param(mo22651id = 2) String str2) {
        this.zzcgj = str;
        this.zzcgk = str2;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zzcgj, false);
        SafeParcelWriter.writeString(parcel, 2, this.zzcgk, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
