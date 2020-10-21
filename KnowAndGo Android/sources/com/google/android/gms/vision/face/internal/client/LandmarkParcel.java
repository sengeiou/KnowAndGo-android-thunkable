package com.google.android.gms.vision.face.internal.client;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.apps.common.proguard.UsedByNative;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@UsedByNative("wrapper.cc")
@SafeParcelable.Class(creator = "LandmarkParcelCreator")
/* compiled from: com.google.android.gms:play-services-vision@@19.0.0 */
public final class LandmarkParcel extends AbstractSafeParcelable {
    public static final Parcelable.Creator<LandmarkParcel> CREATOR = new zzm();
    @SafeParcelable.Field(mo22648id = 4)
    public final int type;
    @SafeParcelable.VersionField(mo22654id = 1)
    private final int versionCode;
    @SafeParcelable.Field(mo22648id = 2)

    /* renamed from: x */
    public final float f193x;
    @SafeParcelable.Field(mo22648id = 3)

    /* renamed from: y */
    public final float f194y;

    @UsedByNative("wrapper.cc")
    @SafeParcelable.Constructor
    public LandmarkParcel(@SafeParcelable.Param(mo22651id = 1) int i, @SafeParcelable.Param(mo22651id = 2) float f, @SafeParcelable.Param(mo22651id = 3) float f2, @SafeParcelable.Param(mo22651id = 4) int i2) {
        this.versionCode = i;
        this.f193x = f;
        this.f194y = f2;
        this.type = i2;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.versionCode);
        SafeParcelWriter.writeFloat(parcel, 2, this.f193x);
        SafeParcelWriter.writeFloat(parcel, 3, this.f194y);
        SafeParcelWriter.writeInt(parcel, 4, this.type);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
