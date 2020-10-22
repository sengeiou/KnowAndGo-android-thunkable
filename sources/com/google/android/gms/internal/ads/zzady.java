package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "NativeAdOptionsParcelCreator")
@zzard
public final class zzady extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzady> CREATOR = new zzadz();
    @SafeParcelable.Field(mo22648id = 1)
    public final int versionCode;
    @SafeParcelable.Field(mo22648id = 3)
    public final int zzbqc;
    @SafeParcelable.Field(mo22648id = 8)
    public final int zzbqd;
    @SafeParcelable.Field(mo22648id = 4)
    public final boolean zzbqe;
    @SafeParcelable.Field(mo22648id = 5)
    public final int zzbqf;
    @SafeParcelable.Field(mo22648id = 7)
    public final boolean zzbqh;
    @SafeParcelable.Field(mo22648id = 2)
    public final boolean zzcym;
    @SafeParcelable.Field(mo22648id = 6)
    @Nullable
    public final zzacd zzcyn;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public zzady(NativeAdOptions nativeAdOptions) {
        this(4, nativeAdOptions.shouldReturnUrlsForImageAssets(), nativeAdOptions.getImageOrientation(), nativeAdOptions.shouldRequestMultipleImages(), nativeAdOptions.getAdChoicesPlacement(), nativeAdOptions.getVideoOptions() != null ? new zzacd(nativeAdOptions.getVideoOptions()) : null, nativeAdOptions.zzkr(), 0);
    }

    @SafeParcelable.Constructor
    public zzady(@SafeParcelable.Param(mo22651id = 1) int i, @SafeParcelable.Param(mo22651id = 2) boolean z, @SafeParcelable.Param(mo22651id = 3) int i2, @SafeParcelable.Param(mo22651id = 4) boolean z2, @SafeParcelable.Param(mo22651id = 5) int i3, @SafeParcelable.Param(mo22651id = 6) zzacd zzacd, @SafeParcelable.Param(mo22651id = 7) boolean z3, @SafeParcelable.Param(mo22651id = 8) int i4) {
        this.versionCode = i;
        this.zzcym = z;
        this.zzbqc = i2;
        this.zzbqe = z2;
        this.zzbqf = i3;
        this.zzcyn = zzacd;
        this.zzbqh = z3;
        this.zzbqd = i4;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.versionCode);
        SafeParcelWriter.writeBoolean(parcel, 2, this.zzcym);
        SafeParcelWriter.writeInt(parcel, 3, this.zzbqc);
        SafeParcelWriter.writeBoolean(parcel, 4, this.zzbqe);
        SafeParcelWriter.writeInt(parcel, 5, this.zzbqf);
        SafeParcelWriter.writeParcelable(parcel, 6, this.zzcyn, i, false);
        SafeParcelWriter.writeBoolean(parcel, 7, this.zzbqh);
        SafeParcelWriter.writeInt(parcel, 8, this.zzbqd);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
