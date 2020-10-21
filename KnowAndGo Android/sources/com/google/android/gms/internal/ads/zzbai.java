package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "VersionInfoParcelCreator")
@SafeParcelable.Reserved({1})
@zzard
public final class zzbai extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbai> CREATOR = new zzbaj();
    @SafeParcelable.Field(mo22648id = 2)
    public String zzbsx;
    @SafeParcelable.Field(mo22648id = 3)
    public int zzdzc;
    @SafeParcelable.Field(mo22648id = 4)
    public int zzdzd;
    @SafeParcelable.Field(mo22648id = 5)
    public boolean zzdze;
    @SafeParcelable.Field(mo22648id = 6)
    private boolean zzdzf;

    public zzbai(int i, int i2, boolean z) {
        this(i, i2, z, false, false);
    }

    public zzbai(int i, int i2, boolean z, boolean z2) {
        this(i, i2, true, false, false);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private zzbai(int r8, int r9, boolean r10, boolean r11, boolean r12) {
        /*
            r7 = this;
            if (r10 == 0) goto L_0x0005
            java.lang.String r11 = "0"
            goto L_0x0007
        L_0x0005:
            java.lang.String r11 = "1"
        L_0x0007:
            java.lang.String r12 = java.lang.String.valueOf(r11)
            int r12 = r12.length()
            int r12 = r12 + 36
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r12)
            java.lang.String r12 = "afma-sdk-a-v"
            r0.append(r12)
            r0.append(r8)
            java.lang.String r12 = "."
            r0.append(r12)
            r0.append(r9)
            java.lang.String r12 = "."
            r0.append(r12)
            r0.append(r11)
            java.lang.String r2 = r0.toString()
            r6 = 0
            r1 = r7
            r3 = r8
            r4 = r9
            r5 = r10
            r1.<init>((java.lang.String) r2, (int) r3, (int) r4, (boolean) r5, (boolean) r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbai.<init>(int, int, boolean, boolean, boolean):void");
    }

    @SafeParcelable.Constructor
    zzbai(@SafeParcelable.Param(mo22651id = 2) String str, @SafeParcelable.Param(mo22651id = 3) int i, @SafeParcelable.Param(mo22651id = 4) int i2, @SafeParcelable.Param(mo22651id = 5) boolean z, @SafeParcelable.Param(mo22651id = 6) boolean z2) {
        this.zzbsx = str;
        this.zzdzc = i;
        this.zzdzd = i2;
        this.zzdze = z;
        this.zzdzf = z2;
    }

    public static zzbai zzxc() {
        return new zzbai(12451009, 12451009, true);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zzbsx, false);
        SafeParcelWriter.writeInt(parcel, 3, this.zzdzc);
        SafeParcelWriter.writeInt(parcel, 4, this.zzdzd);
        SafeParcelWriter.writeBoolean(parcel, 5, this.zzdze);
        SafeParcelWriter.writeBoolean(parcel, 6, this.zzdzf);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
