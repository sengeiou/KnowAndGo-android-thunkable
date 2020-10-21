package com.google.android.gms.internal.vision;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "LineBoxParcelCreator")
@SafeParcelable.Reserved({1})
/* compiled from: com.google.android.gms:play-services-vision@@19.0.0 */
public final class zzac extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzac> CREATOR = new zzab();
    @SafeParcelable.Field(mo22648id = 7)
    private final float zzdo;
    @SafeParcelable.Field(mo22648id = 8)
    public final String zzec;
    @SafeParcelable.Field(mo22648id = 2)
    public final zzaj[] zzeh;
    @SafeParcelable.Field(mo22648id = 3)
    public final zzw zzei;
    @SafeParcelable.Field(mo22648id = 4)
    private final zzw zzej;
    @SafeParcelable.Field(mo22648id = 5)
    private final zzw zzek;
    @SafeParcelable.Field(mo22648id = 6)
    public final String zzel;
    @SafeParcelable.Field(mo22648id = 9)
    private final int zzem;
    @SafeParcelable.Field(mo22648id = 10)
    public final boolean zzen;
    @SafeParcelable.Field(mo22648id = 11)
    public final int zzeo;
    @SafeParcelable.Field(mo22648id = 12)
    public final int zzep;

    @SafeParcelable.Constructor
    public zzac(@SafeParcelable.Param(mo22651id = 2) zzaj[] zzajArr, @SafeParcelable.Param(mo22651id = 3) zzw zzw, @SafeParcelable.Param(mo22651id = 4) zzw zzw2, @SafeParcelable.Param(mo22651id = 5) zzw zzw3, @SafeParcelable.Param(mo22651id = 6) String str, @SafeParcelable.Param(mo22651id = 7) float f, @SafeParcelable.Param(mo22651id = 8) String str2, @SafeParcelable.Param(mo22651id = 9) int i, @SafeParcelable.Param(mo22651id = 10) boolean z, @SafeParcelable.Param(mo22651id = 11) int i2, @SafeParcelable.Param(mo22651id = 12) int i3) {
        this.zzeh = zzajArr;
        this.zzei = zzw;
        this.zzej = zzw2;
        this.zzek = zzw3;
        this.zzel = str;
        this.zzdo = f;
        this.zzec = str2;
        this.zzem = i;
        this.zzen = z;
        this.zzeo = i2;
        this.zzep = i3;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeTypedArray(parcel, 2, this.zzeh, i, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzei, i, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzej, i, false);
        SafeParcelWriter.writeParcelable(parcel, 5, this.zzek, i, false);
        SafeParcelWriter.writeString(parcel, 6, this.zzel, false);
        SafeParcelWriter.writeFloat(parcel, 7, this.zzdo);
        SafeParcelWriter.writeString(parcel, 8, this.zzec, false);
        SafeParcelWriter.writeInt(parcel, 9, this.zzem);
        SafeParcelWriter.writeBoolean(parcel, 10, this.zzen);
        SafeParcelWriter.writeInt(parcel, 11, this.zzeo);
        SafeParcelWriter.writeInt(parcel, 12, this.zzep);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
