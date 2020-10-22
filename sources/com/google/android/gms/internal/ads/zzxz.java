package com.google.android.gms.internal.ads;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;
import javax.annotation.Nullable;

@SafeParcelable.Class(creator = "AdRequestParcelCreator")
@zzard
public final class zzxz extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzxz> CREATOR = new zzyb();
    @SafeParcelable.Field(mo22648id = 3)
    public final Bundle extras;
    @SafeParcelable.Field(mo22648id = 1)
    public final int versionCode;
    @SafeParcelable.Field(mo22648id = 8)
    public final boolean zzbqn;
    @SafeParcelable.Field(mo22648id = 2)
    @Deprecated
    public final long zzcgn;
    @SafeParcelable.Field(mo22648id = 4)
    @Deprecated
    public final int zzcgo;
    @SafeParcelable.Field(mo22648id = 5)
    public final List<String> zzcgp;
    @SafeParcelable.Field(mo22648id = 6)
    public final boolean zzcgq;
    @SafeParcelable.Field(mo22648id = 7)
    public final int zzcgr;
    @SafeParcelable.Field(mo22648id = 9)
    public final String zzcgs;
    @SafeParcelable.Field(mo22648id = 10)
    public final zzaca zzcgt;
    @SafeParcelable.Field(mo22648id = 12)
    public final String zzcgu;
    @SafeParcelable.Field(mo22648id = 13)
    public final Bundle zzcgv;
    @SafeParcelable.Field(mo22648id = 14)
    public final Bundle zzcgw;
    @SafeParcelable.Field(mo22648id = 15)
    public final List<String> zzcgx;
    @SafeParcelable.Field(mo22648id = 16)
    public final String zzcgy;
    @SafeParcelable.Field(mo22648id = 17)
    public final String zzcgz;
    @SafeParcelable.Field(mo22648id = 18)
    @Deprecated
    public final boolean zzcha;
    @SafeParcelable.Field(mo22648id = 19)
    @Nullable
    public final zzxt zzchb;
    @SafeParcelable.Field(mo22648id = 20)
    public final int zzchc;
    @SafeParcelable.Field(mo22648id = 21)
    @Nullable
    public final String zzchd;
    @SafeParcelable.Field(mo22648id = 11)
    public final Location zzmw;

    @SafeParcelable.Constructor
    public zzxz(@SafeParcelable.Param(mo22651id = 1) int i, @SafeParcelable.Param(mo22651id = 2) long j, @SafeParcelable.Param(mo22651id = 3) Bundle bundle, @SafeParcelable.Param(mo22651id = 4) int i2, @SafeParcelable.Param(mo22651id = 5) List<String> list, @SafeParcelable.Param(mo22651id = 6) boolean z, @SafeParcelable.Param(mo22651id = 7) int i3, @SafeParcelable.Param(mo22651id = 8) boolean z2, @SafeParcelable.Param(mo22651id = 9) String str, @SafeParcelable.Param(mo22651id = 10) zzaca zzaca, @SafeParcelable.Param(mo22651id = 11) Location location, @SafeParcelable.Param(mo22651id = 12) String str2, @SafeParcelable.Param(mo22651id = 13) Bundle bundle2, @SafeParcelable.Param(mo22651id = 14) Bundle bundle3, @SafeParcelable.Param(mo22651id = 15) List<String> list2, @SafeParcelable.Param(mo22651id = 16) String str3, @SafeParcelable.Param(mo22651id = 17) String str4, @SafeParcelable.Param(mo22651id = 18) boolean z3, @SafeParcelable.Param(mo22651id = 19) zzxt zzxt, @SafeParcelable.Param(mo22651id = 20) int i4, @SafeParcelable.Param(mo22651id = 21) @Nullable String str5) {
        this.versionCode = i;
        this.zzcgn = j;
        this.extras = bundle == null ? new Bundle() : bundle;
        this.zzcgo = i2;
        this.zzcgp = list;
        this.zzcgq = z;
        this.zzcgr = i3;
        this.zzbqn = z2;
        this.zzcgs = str;
        this.zzcgt = zzaca;
        this.zzmw = location;
        this.zzcgu = str2;
        this.zzcgv = bundle2 == null ? new Bundle() : bundle2;
        this.zzcgw = bundle3;
        this.zzcgx = list2;
        this.zzcgy = str3;
        this.zzcgz = str4;
        this.zzcha = z3;
        this.zzchb = zzxt;
        this.zzchc = i4;
        this.zzchd = str5;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.versionCode);
        SafeParcelWriter.writeLong(parcel, 2, this.zzcgn);
        SafeParcelWriter.writeBundle(parcel, 3, this.extras, false);
        SafeParcelWriter.writeInt(parcel, 4, this.zzcgo);
        SafeParcelWriter.writeStringList(parcel, 5, this.zzcgp, false);
        SafeParcelWriter.writeBoolean(parcel, 6, this.zzcgq);
        SafeParcelWriter.writeInt(parcel, 7, this.zzcgr);
        SafeParcelWriter.writeBoolean(parcel, 8, this.zzbqn);
        SafeParcelWriter.writeString(parcel, 9, this.zzcgs, false);
        SafeParcelWriter.writeParcelable(parcel, 10, this.zzcgt, i, false);
        SafeParcelWriter.writeParcelable(parcel, 11, this.zzmw, i, false);
        SafeParcelWriter.writeString(parcel, 12, this.zzcgu, false);
        SafeParcelWriter.writeBundle(parcel, 13, this.zzcgv, false);
        SafeParcelWriter.writeBundle(parcel, 14, this.zzcgw, false);
        SafeParcelWriter.writeStringList(parcel, 15, this.zzcgx, false);
        SafeParcelWriter.writeString(parcel, 16, this.zzcgy, false);
        SafeParcelWriter.writeString(parcel, 17, this.zzcgz, false);
        SafeParcelWriter.writeBoolean(parcel, 18, this.zzcha);
        SafeParcelWriter.writeParcelable(parcel, 19, this.zzchb, i, false);
        SafeParcelWriter.writeInt(parcel, 20, this.zzchc);
        SafeParcelWriter.writeString(parcel, 21, this.zzchd, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzxz)) {
            return false;
        }
        zzxz zzxz = (zzxz) obj;
        if (this.versionCode != zzxz.versionCode || this.zzcgn != zzxz.zzcgn || !Objects.equal(this.extras, zzxz.extras) || this.zzcgo != zzxz.zzcgo || !Objects.equal(this.zzcgp, zzxz.zzcgp) || this.zzcgq != zzxz.zzcgq || this.zzcgr != zzxz.zzcgr || this.zzbqn != zzxz.zzbqn || !Objects.equal(this.zzcgs, zzxz.zzcgs) || !Objects.equal(this.zzcgt, zzxz.zzcgt) || !Objects.equal(this.zzmw, zzxz.zzmw) || !Objects.equal(this.zzcgu, zzxz.zzcgu) || !Objects.equal(this.zzcgv, zzxz.zzcgv) || !Objects.equal(this.zzcgw, zzxz.zzcgw) || !Objects.equal(this.zzcgx, zzxz.zzcgx) || !Objects.equal(this.zzcgy, zzxz.zzcgy) || !Objects.equal(this.zzcgz, zzxz.zzcgz) || this.zzcha != zzxz.zzcha || this.zzchc != zzxz.zzchc || !Objects.equal(this.zzchd, zzxz.zzchd)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.versionCode), Long.valueOf(this.zzcgn), this.extras, Integer.valueOf(this.zzcgo), this.zzcgp, Boolean.valueOf(this.zzcgq), Integer.valueOf(this.zzcgr), Boolean.valueOf(this.zzbqn), this.zzcgs, this.zzcgt, this.zzmw, this.zzcgu, this.zzcgv, this.zzcgw, this.zzcgx, this.zzcgy, this.zzcgz, Boolean.valueOf(this.zzcha), Integer.valueOf(this.zzchc), this.zzchd);
    }
}
