package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "VideoOptionsParcelCreator")
@SafeParcelable.Reserved({1})
@zzard
public final class zzacd extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzacd> CREATOR = new zzace();
    @SafeParcelable.Field(mo22648id = 2)
    public final boolean zzaax;
    @SafeParcelable.Field(mo22648id = 3)
    public final boolean zzaay;
    @SafeParcelable.Field(mo22648id = 4)
    public final boolean zzaaz;

    public zzacd(VideoOptions videoOptions) {
        this(videoOptions.getStartMuted(), videoOptions.getCustomControlsRequested(), videoOptions.getClickToExpandRequested());
    }

    @SafeParcelable.Constructor
    public zzacd(@SafeParcelable.Param(mo22651id = 2) boolean z, @SafeParcelable.Param(mo22651id = 3) boolean z2, @SafeParcelable.Param(mo22651id = 4) boolean z3) {
        this.zzaax = z;
        this.zzaay = z2;
        this.zzaaz = z3;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBoolean(parcel, 2, this.zzaax);
        SafeParcelWriter.writeBoolean(parcel, 3, this.zzaay);
        SafeParcelWriter.writeBoolean(parcel, 4, this.zzaaz);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
