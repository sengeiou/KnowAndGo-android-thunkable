package com.google.android.gms.vision.face.internal.client;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "FaceSettingsParcelCreator")
@SafeParcelable.Reserved({1})
/* compiled from: com.google.android.gms:play-services-vision@@19.0.0 */
public final class zzf extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzf> CREATOR = new zze();
    @SafeParcelable.Field(mo22648id = 3)
    public int landmarkType;
    @SafeParcelable.Field(mo22648id = 2)
    public int mode;
    @SafeParcelable.Field(defaultValue = "-1", mo22648id = 7)
    public float proportionalMinFaceSize;
    @SafeParcelable.Field(mo22648id = 6)
    public boolean trackingEnabled;
    @SafeParcelable.Field(mo22648id = 5)
    public boolean zzcn;
    @SafeParcelable.Field(mo22648id = 4)
    public int zzco;

    public zzf() {
    }

    @SafeParcelable.Constructor
    public zzf(@SafeParcelable.Param(mo22651id = 2) int i, @SafeParcelable.Param(mo22651id = 3) int i2, @SafeParcelable.Param(mo22651id = 4) int i3, @SafeParcelable.Param(mo22651id = 5) boolean z, @SafeParcelable.Param(mo22651id = 6) boolean z2, @SafeParcelable.Param(mo22651id = 7) float f) {
        this.mode = i;
        this.landmarkType = i2;
        this.zzco = i3;
        this.zzcn = z;
        this.trackingEnabled = z2;
        this.proportionalMinFaceSize = f;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 2, this.mode);
        SafeParcelWriter.writeInt(parcel, 3, this.landmarkType);
        SafeParcelWriter.writeInt(parcel, 4, this.zzco);
        SafeParcelWriter.writeBoolean(parcel, 5, this.zzcn);
        SafeParcelWriter.writeBoolean(parcel, 6, this.trackingEnabled);
        SafeParcelWriter.writeFloat(parcel, 7, this.proportionalMinFaceSize);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
