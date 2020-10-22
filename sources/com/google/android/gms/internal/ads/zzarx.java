package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

@SafeParcelable.Class(creator = "NonagonRequestParcelCreator")
@ParametersAreNonnullByDefault
@zzard
public final class zzarx extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzarx> CREATOR = new zzary();
    @SafeParcelable.Field(mo22648id = 3)
    public final ApplicationInfo applicationInfo;
    @SafeParcelable.Field(mo22648id = 4)
    public final String packageName;
    @SafeParcelable.Field(mo22648id = 2)
    public final zzbai zzdld;
    @SafeParcelable.Field(mo22648id = 6)
    @Nullable
    public final PackageInfo zzdlm;
    @SafeParcelable.Field(mo22648id = 5)
    public final List<String> zzdly;
    @SafeParcelable.Field(mo22648id = 7)
    public final String zzdmi;
    @SafeParcelable.Field(mo22648id = 1)
    public final Bundle zzdot;
    @SafeParcelable.Field(mo22648id = 8)
    public final boolean zzdou;
    @SafeParcelable.Field(mo22648id = 9)
    public final String zzdov;

    @SafeParcelable.Constructor
    public zzarx(@SafeParcelable.Param(mo22651id = 1) Bundle bundle, @SafeParcelable.Param(mo22651id = 2) zzbai zzbai, @SafeParcelable.Param(mo22651id = 3) ApplicationInfo applicationInfo2, @SafeParcelable.Param(mo22651id = 4) String str, @SafeParcelable.Param(mo22651id = 5) List<String> list, @SafeParcelable.Param(mo22651id = 6) @Nullable PackageInfo packageInfo, @SafeParcelable.Param(mo22651id = 7) String str2, @SafeParcelable.Param(mo22651id = 8) boolean z, @SafeParcelable.Param(mo22651id = 9) String str3) {
        this.zzdot = bundle;
        this.zzdld = zzbai;
        this.packageName = str;
        this.applicationInfo = applicationInfo2;
        this.zzdly = list;
        this.zzdlm = packageInfo;
        this.zzdmi = str2;
        this.zzdou = z;
        this.zzdov = str3;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBundle(parcel, 1, this.zzdot, false);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzdld, i, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.applicationInfo, i, false);
        SafeParcelWriter.writeString(parcel, 4, this.packageName, false);
        SafeParcelWriter.writeStringList(parcel, 5, this.zzdly, false);
        SafeParcelWriter.writeParcelable(parcel, 6, this.zzdlm, i, false);
        SafeParcelWriter.writeString(parcel, 7, this.zzdmi, false);
        SafeParcelWriter.writeBoolean(parcel, 8, this.zzdou);
        SafeParcelWriter.writeString(parcel, 9, this.zzdov, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
