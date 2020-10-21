package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "ExceptionParcelCreator")
@zzard
public final class zzaym extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaym> CREATOR = new zzayo();
    @SafeParcelable.Field(mo22648id = 2)
    public final int errorCode;
    @SafeParcelable.Field(mo22648id = 1)
    public final String zzdwv;

    @Nullable
    public static zzaym zza(Throwable th, int i) {
        return new zzaym(th.getMessage(), i);
    }

    @SafeParcelable.Constructor
    zzaym(@SafeParcelable.Param(mo22651id = 1) @Nullable String str, @SafeParcelable.Param(mo22651id = 2) int i) {
        this.zzdwv = str == null ? "" : str;
        this.errorCode = i;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zzdwv, false);
        SafeParcelWriter.writeInt(parcel, 2, this.errorCode);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
