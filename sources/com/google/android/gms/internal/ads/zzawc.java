package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import javax.annotation.ParametersAreNonnullByDefault;

@SafeParcelable.Class(creator = "SignalConfigurationParcelCreator")
@ParametersAreNonnullByDefault
@zzard
public final class zzawc extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzawc> CREATOR = new zzawd();
    @SafeParcelable.Field(mo22648id = 2)
    public final String zzbsu;
    @SafeParcelable.Field(mo22648id = 1)
    public final String zzchk;
    @SafeParcelable.Field(mo22648id = 3)
    public final zzyd zzdsu;

    @SafeParcelable.Constructor
    public zzawc(@SafeParcelable.Param(mo22651id = 1) String str, @SafeParcelable.Param(mo22651id = 2) String str2, @SafeParcelable.Param(mo22651id = 3) zzyd zzyd) {
        this.zzchk = str;
        this.zzbsu = str2;
        this.zzdsu = zzyd;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zzchk, false);
        SafeParcelWriter.writeString(parcel, 2, this.zzbsu, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzdsu, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
