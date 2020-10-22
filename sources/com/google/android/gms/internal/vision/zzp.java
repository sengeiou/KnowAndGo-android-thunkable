package com.google.android.gms.internal.vision;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.vision.Frame;

@SafeParcelable.Class(creator = "FrameMetadataParcelCreator")
@SafeParcelable.Reserved({1})
/* compiled from: com.google.android.gms:play-services-vision-common@@19.0.0 */
public final class zzp extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzp> CREATOR = new zzo();
    @SafeParcelable.Field(mo22648id = 3)
    public int height;
    @SafeParcelable.Field(mo22648id = 4)

    /* renamed from: id */
    public int f189id;
    @SafeParcelable.Field(mo22648id = 6)
    public int rotation;
    @SafeParcelable.Field(mo22648id = 2)
    public int width;
    @SafeParcelable.Field(mo22648id = 5)
    public long zzar;

    public zzp() {
    }

    @SafeParcelable.Constructor
    public zzp(@SafeParcelable.Param(mo22651id = 2) int i, @SafeParcelable.Param(mo22651id = 3) int i2, @SafeParcelable.Param(mo22651id = 4) int i3, @SafeParcelable.Param(mo22651id = 5) long j, @SafeParcelable.Param(mo22651id = 6) int i4) {
        this.width = i;
        this.height = i2;
        this.f189id = i3;
        this.zzar = j;
        this.rotation = i4;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 2, this.width);
        SafeParcelWriter.writeInt(parcel, 3, this.height);
        SafeParcelWriter.writeInt(parcel, 4, this.f189id);
        SafeParcelWriter.writeLong(parcel, 5, this.zzar);
        SafeParcelWriter.writeInt(parcel, 6, this.rotation);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public static zzp zzc(Frame frame) {
        zzp zzp = new zzp();
        zzp.width = frame.getMetadata().getWidth();
        zzp.height = frame.getMetadata().getHeight();
        zzp.rotation = frame.getMetadata().getRotation();
        zzp.f189id = frame.getMetadata().getId();
        zzp.zzar = frame.getMetadata().getTimestampMillis();
        return zzp;
    }
}
