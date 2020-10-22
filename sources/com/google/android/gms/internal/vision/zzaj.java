package com.google.android.gms.internal.vision;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "WordBoxParcelCreator")
@SafeParcelable.Reserved({1})
/* compiled from: com.google.android.gms:play-services-vision@@19.0.0 */
public final class zzaj extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaj> CREATOR = new zzam();
    @SafeParcelable.Field(mo22648id = 6)
    private final float zzdo;
    @SafeParcelable.Field(mo22648id = 7)
    public final String zzec;
    @SafeParcelable.Field(mo22648id = 3)
    public final zzw zzei;
    @SafeParcelable.Field(mo22648id = 4)
    private final zzw zzej;
    @SafeParcelable.Field(mo22648id = 5)
    public final String zzel;
    @SafeParcelable.Field(mo22648id = 2)
    private final zzag[] zzer;
    @SafeParcelable.Field(mo22648id = 8)
    private final boolean zzes;

    @SafeParcelable.Constructor
    public zzaj(@SafeParcelable.Param(mo22651id = 2) zzag[] zzagArr, @SafeParcelable.Param(mo22651id = 3) zzw zzw, @SafeParcelable.Param(mo22651id = 4) zzw zzw2, @SafeParcelable.Param(mo22651id = 5) String str, @SafeParcelable.Param(mo22651id = 6) float f, @SafeParcelable.Param(mo22651id = 7) String str2, @SafeParcelable.Param(mo22651id = 8) boolean z) {
        this.zzer = zzagArr;
        this.zzei = zzw;
        this.zzej = zzw2;
        this.zzel = str;
        this.zzdo = f;
        this.zzec = str2;
        this.zzes = z;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeTypedArray(parcel, 2, this.zzer, i, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzei, i, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzej, i, false);
        SafeParcelWriter.writeString(parcel, 5, this.zzel, false);
        SafeParcelWriter.writeFloat(parcel, 6, this.zzdo);
        SafeParcelWriter.writeString(parcel, 7, this.zzec, false);
        SafeParcelWriter.writeBoolean(parcel, 8, this.zzes);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
