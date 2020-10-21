package com.google.android.gms.internal.vision;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "BoundingBoxParcelCreator")
@SafeParcelable.Reserved({1})
/* compiled from: com.google.android.gms:play-services-vision@@19.0.0 */
public final class zzw extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzw> CREATOR = new zzv();
    @SafeParcelable.Field(mo22648id = 5)
    public final int height;
    @SafeParcelable.Field(mo22648id = 2)
    public final int left;
    @SafeParcelable.Field(mo22648id = 3)
    public final int top;
    @SafeParcelable.Field(mo22648id = 4)
    public final int width;
    @SafeParcelable.Field(mo22648id = 6)
    public final float zzeg;

    @SafeParcelable.Constructor
    public zzw(@SafeParcelable.Param(mo22651id = 2) int i, @SafeParcelable.Param(mo22651id = 3) int i2, @SafeParcelable.Param(mo22651id = 4) int i3, @SafeParcelable.Param(mo22651id = 5) int i4, @SafeParcelable.Param(mo22651id = 6) float f) {
        this.left = i;
        this.top = i2;
        this.width = i3;
        this.height = i4;
        this.zzeg = f;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 2, this.left);
        SafeParcelWriter.writeInt(parcel, 3, this.top);
        SafeParcelWriter.writeInt(parcel, 4, this.width);
        SafeParcelWriter.writeInt(parcel, 5, this.height);
        SafeParcelWriter.writeFloat(parcel, 6, this.zzeg);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
