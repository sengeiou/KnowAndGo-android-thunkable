package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "GassEventParcelCreator")
public final class zzday extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzday> CREATOR = new zzdaz();
    @SafeParcelable.VersionField(mo22654id = 1)
    private final int versionCode;
    @SafeParcelable.Field(mo22648id = 2)
    private final byte[] zzgou;

    @SafeParcelable.Constructor
    zzday(@SafeParcelable.Param(mo22651id = 1) int i, @SafeParcelable.Param(mo22651id = 2) byte[] bArr) {
        this.versionCode = i;
        this.zzgou = bArr;
    }

    public zzday(byte[] bArr) {
        this(1, bArr);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.versionCode);
        SafeParcelWriter.writeByteArray(parcel, 2, this.zzgou, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
