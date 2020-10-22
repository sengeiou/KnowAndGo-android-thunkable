package com.google.android.gms.vision.face.internal.client;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.apps.common.proguard.UsedByNative;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@UsedByNative("wrapper.cc")
@SafeParcelable.Class(creator = "FaceParcelCreator")
/* compiled from: com.google.android.gms:play-services-vision@@19.0.0 */
public class FaceParcel extends AbstractSafeParcelable {
    public static final Parcelable.Creator<FaceParcel> CREATOR = new zzd();
    @SafeParcelable.Field(mo22648id = 3)
    public final float centerX;
    @SafeParcelable.Field(mo22648id = 4)
    public final float centerY;
    @SafeParcelable.Field(mo22648id = 6)
    public final float height;
    @SafeParcelable.Field(mo22648id = 2)

    /* renamed from: id */
    public final int f192id;
    @SafeParcelable.VersionField(mo22654id = 1)
    private final int versionCode;
    @SafeParcelable.Field(mo22648id = 5)
    public final float width;
    @SafeParcelable.Field(mo22648id = 10)
    public final float zzce;
    @SafeParcelable.Field(mo22648id = 11)
    public final float zzcf;
    @SafeParcelable.Field(mo22648id = 12)
    public final float zzcg;
    @SafeParcelable.Field(defaultValue = "-1.0f", mo22648id = 15)
    public final float zzch;
    @SafeParcelable.Field(defaultValue = "3.4028235E38f", mo22648id = 7)
    public final float zzcz;
    @SafeParcelable.Field(defaultValue = "3.4028235E38f", mo22648id = 8)
    public final float zzda;
    @SafeParcelable.Field(defaultValue = "3.4028235E38f", mo22648id = 14)
    public final float zzdb;
    @SafeParcelable.Field(mo22648id = 9)
    public final LandmarkParcel[] zzdc;
    @SafeParcelable.Field(mo22648id = 13)
    public final zza[] zzdd;

    @SafeParcelable.Constructor
    public FaceParcel(@SafeParcelable.Param(mo22651id = 1) int i, @SafeParcelable.Param(mo22651id = 2) int i2, @SafeParcelable.Param(mo22651id = 3) float f, @SafeParcelable.Param(mo22651id = 4) float f2, @SafeParcelable.Param(mo22651id = 5) float f3, @SafeParcelable.Param(mo22651id = 6) float f4, @SafeParcelable.Param(mo22651id = 7) float f5, @SafeParcelable.Param(mo22651id = 8) float f6, @SafeParcelable.Param(mo22651id = 14) float f7, @SafeParcelable.Param(mo22651id = 9) LandmarkParcel[] landmarkParcelArr, @SafeParcelable.Param(mo22651id = 10) float f8, @SafeParcelable.Param(mo22651id = 11) float f9, @SafeParcelable.Param(mo22651id = 12) float f10, @SafeParcelable.Param(mo22651id = 13) zza[] zzaArr, @SafeParcelable.Param(mo22651id = 15) float f11) {
        this.versionCode = i;
        this.f192id = i2;
        this.centerX = f;
        this.centerY = f2;
        this.width = f3;
        this.height = f4;
        this.zzcz = f5;
        this.zzda = f6;
        this.zzdb = f7;
        this.zzdc = landmarkParcelArr;
        this.zzce = f8;
        this.zzcf = f9;
        this.zzcg = f10;
        this.zzdd = zzaArr;
        this.zzch = f11;
    }

    @UsedByNative("wrapper.cc")
    public FaceParcel(@SafeParcelable.Param(mo22651id = 1) int i, @SafeParcelable.Param(mo22651id = 2) int i2, @SafeParcelable.Param(mo22651id = 3) float f, @SafeParcelable.Param(mo22651id = 4) float f2, @SafeParcelable.Param(mo22651id = 5) float f3, @SafeParcelable.Param(mo22651id = 6) float f4, @SafeParcelable.Param(mo22651id = 7) float f5, @SafeParcelable.Param(mo22651id = 8) float f6, @SafeParcelable.Param(mo22651id = 9) LandmarkParcel[] landmarkParcelArr, @SafeParcelable.Param(mo22651id = 10) float f7, @SafeParcelable.Param(mo22651id = 11) float f8, @SafeParcelable.Param(mo22651id = 12) float f9) {
        this(i, i2, f, f2, f3, f4, f5, f6, 0.0f, landmarkParcelArr, f7, f8, f9, new zza[0], -1.0f);
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.versionCode);
        SafeParcelWriter.writeInt(parcel, 2, this.f192id);
        SafeParcelWriter.writeFloat(parcel, 3, this.centerX);
        SafeParcelWriter.writeFloat(parcel, 4, this.centerY);
        SafeParcelWriter.writeFloat(parcel, 5, this.width);
        SafeParcelWriter.writeFloat(parcel, 6, this.height);
        SafeParcelWriter.writeFloat(parcel, 7, this.zzcz);
        SafeParcelWriter.writeFloat(parcel, 8, this.zzda);
        SafeParcelWriter.writeTypedArray(parcel, 9, this.zzdc, i, false);
        SafeParcelWriter.writeFloat(parcel, 10, this.zzce);
        SafeParcelWriter.writeFloat(parcel, 11, this.zzcf);
        SafeParcelWriter.writeFloat(parcel, 12, this.zzcg);
        SafeParcelWriter.writeTypedArray(parcel, 13, this.zzdd, i, false);
        SafeParcelWriter.writeFloat(parcel, 14, this.zzdb);
        SafeParcelWriter.writeFloat(parcel, 15, this.zzch);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
