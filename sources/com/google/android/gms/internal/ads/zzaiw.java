package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "MediationConfigurationParcelCreator")
@zzard
public final class zzaiw extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaiw> CREATOR = new zzaix();
    @SafeParcelable.Field(mo22648id = 2)
    public final Bundle extras;
    @SafeParcelable.Field(mo22648id = 1)
    public final String zzdbd;

    @SafeParcelable.Constructor
    public zzaiw(@SafeParcelable.Param(mo22651id = 1) String str, @SafeParcelable.Param(mo22651id = 2) Bundle bundle) {
        this.zzdbd = str;
        this.extras = bundle;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zzdbd, false);
        SafeParcelWriter.writeBundle(parcel, 2, this.extras, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
