package com.google.android.gms.ads.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.ads.zzard;

@SafeParcelable.Class(creator = "InterstitialAdParameterParcelCreator")
@SafeParcelable.Reserved({1})
@zzard
public final class zzh extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzh> CREATOR = new zzi();
    @SafeParcelable.Field(mo22648id = 2)
    public final boolean zzbre;
    @SafeParcelable.Field(mo22648id = 3)
    public final boolean zzbrf;
    @SafeParcelable.Field(mo22648id = 4)
    private final String zzbrg;
    @SafeParcelable.Field(mo22648id = 5)
    public final boolean zzbrh;
    @SafeParcelable.Field(mo22648id = 6)
    public final float zzbri;
    @SafeParcelable.Field(mo22648id = 7)
    public final int zzbrj;
    @SafeParcelable.Field(mo22648id = 8)
    public final boolean zzbrk;
    @SafeParcelable.Field(mo22648id = 9)
    public final boolean zzbrl;
    @SafeParcelable.Field(mo22648id = 10)
    public final boolean zzbrm;

    public zzh(boolean z, boolean z2, boolean z3, float f, int i, boolean z4, boolean z5, boolean z6) {
        this(false, z2, (String) null, false, 0.0f, -1, z4, z5, z6);
    }

    @SafeParcelable.Constructor
    zzh(@SafeParcelable.Param(mo22651id = 2) boolean z, @SafeParcelable.Param(mo22651id = 3) boolean z2, @SafeParcelable.Param(mo22651id = 4) String str, @SafeParcelable.Param(mo22651id = 5) boolean z3, @SafeParcelable.Param(mo22651id = 6) float f, @SafeParcelable.Param(mo22651id = 7) int i, @SafeParcelable.Param(mo22651id = 8) boolean z4, @SafeParcelable.Param(mo22651id = 9) boolean z5, @SafeParcelable.Param(mo22651id = 10) boolean z6) {
        this.zzbre = z;
        this.zzbrf = z2;
        this.zzbrg = str;
        this.zzbrh = z3;
        this.zzbri = f;
        this.zzbrj = i;
        this.zzbrk = z4;
        this.zzbrl = z5;
        this.zzbrm = z6;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBoolean(parcel, 2, this.zzbre);
        SafeParcelWriter.writeBoolean(parcel, 3, this.zzbrf);
        SafeParcelWriter.writeString(parcel, 4, this.zzbrg, false);
        SafeParcelWriter.writeBoolean(parcel, 5, this.zzbrh);
        SafeParcelWriter.writeFloat(parcel, 6, this.zzbri);
        SafeParcelWriter.writeInt(parcel, 7, this.zzbrj);
        SafeParcelWriter.writeBoolean(parcel, 8, this.zzbrk);
        SafeParcelWriter.writeBoolean(parcel, 9, this.zzbrl);
        SafeParcelWriter.writeBoolean(parcel, 10, this.zzbrm);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
