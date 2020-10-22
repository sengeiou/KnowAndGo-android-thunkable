package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "InitializationParamsCreator")
public final class zzdy extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzdy> CREATOR = new zzdz();
    @SafeParcelable.Field(mo22648id = 5)
    public final String origin;
    @SafeParcelable.Field(mo22648id = 1)
    public final long zzade;
    @SafeParcelable.Field(mo22648id = 2)
    public final long zzadf;
    @SafeParcelable.Field(mo22648id = 3)
    public final boolean zzadg;
    @SafeParcelable.Field(mo22648id = 4)
    public final String zzadh;
    @SafeParcelable.Field(mo22648id = 6)
    public final String zzadi;
    @SafeParcelable.Field(mo22648id = 7)
    public final Bundle zzadj;

    @SafeParcelable.Constructor
    zzdy(@SafeParcelable.Param(mo22651id = 1) long j, @SafeParcelable.Param(mo22651id = 2) long j2, @SafeParcelable.Param(mo22651id = 3) boolean z, @SafeParcelable.Param(mo22651id = 4) String str, @SafeParcelable.Param(mo22651id = 5) String str2, @SafeParcelable.Param(mo22651id = 6) String str3, @SafeParcelable.Param(mo22651id = 7) Bundle bundle) {
        this.zzade = j;
        this.zzadf = j2;
        this.zzadg = z;
        this.zzadh = str;
        this.origin = str2;
        this.zzadi = str3;
        this.zzadj = bundle;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeLong(parcel, 1, this.zzade);
        SafeParcelWriter.writeLong(parcel, 2, this.zzadf);
        SafeParcelWriter.writeBoolean(parcel, 3, this.zzadg);
        SafeParcelWriter.writeString(parcel, 4, this.zzadh, false);
        SafeParcelWriter.writeString(parcel, 5, this.origin, false);
        SafeParcelWriter.writeString(parcel, 6, this.zzadi, false);
        SafeParcelWriter.writeBundle(parcel, 7, this.zzadj, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
