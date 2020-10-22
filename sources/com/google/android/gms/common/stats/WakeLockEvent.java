package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

@SafeParcelable.Class(creator = "WakeLockEventCreator")
public final class WakeLockEvent extends StatsEvent {
    public static final Parcelable.Creator<WakeLockEvent> CREATOR = new zza();
    private long durationMillis;
    @SafeParcelable.VersionField(mo22654id = 1)
    private final int versionCode;
    @SafeParcelable.Field(getter = "getTimeMillis", mo22648id = 2)
    private final long zzfo;
    @SafeParcelable.Field(getter = "getEventType", mo22648id = 11)
    private int zzfp;
    @SafeParcelable.Field(getter = "getWakeLockName", mo22648id = 4)
    private final String zzfq;
    @SafeParcelable.Field(getter = "getSecondaryWakeLockName", mo22648id = 10)
    private final String zzfr;
    @SafeParcelable.Field(getter = "getCodePackage", mo22648id = 17)
    private final String zzfs;
    @SafeParcelable.Field(getter = "getWakeLockType", mo22648id = 5)
    private final int zzft;
    @SafeParcelable.Field(getter = "getCallingPackages", mo22648id = 6)
    private final List<String> zzfu;
    @SafeParcelable.Field(getter = "getEventKey", mo22648id = 12)
    private final String zzfv;
    @SafeParcelable.Field(getter = "getElapsedRealtime", mo22648id = 8)
    private final long zzfw;
    @SafeParcelable.Field(getter = "getDeviceState", mo22648id = 14)
    private int zzfx;
    @SafeParcelable.Field(getter = "getHostPackage", mo22648id = 13)
    private final String zzfy;
    @SafeParcelable.Field(getter = "getBeginPowerPercentage", mo22648id = 15)
    private final float zzfz;
    @SafeParcelable.Field(getter = "getTimeout", mo22648id = 16)
    private final long zzga;
    @SafeParcelable.Field(getter = "getAcquiredWithTimeout", mo22648id = 18)
    private final boolean zzgb;

    @SafeParcelable.Constructor
    WakeLockEvent(@SafeParcelable.Param(mo22651id = 1) int i, @SafeParcelable.Param(mo22651id = 2) long j, @SafeParcelable.Param(mo22651id = 11) int i2, @SafeParcelable.Param(mo22651id = 4) String str, @SafeParcelable.Param(mo22651id = 5) int i3, @SafeParcelable.Param(mo22651id = 6) List<String> list, @SafeParcelable.Param(mo22651id = 12) String str2, @SafeParcelable.Param(mo22651id = 8) long j2, @SafeParcelable.Param(mo22651id = 14) int i4, @SafeParcelable.Param(mo22651id = 10) String str3, @SafeParcelable.Param(mo22651id = 13) String str4, @SafeParcelable.Param(mo22651id = 15) float f, @SafeParcelable.Param(mo22651id = 16) long j3, @SafeParcelable.Param(mo22651id = 17) String str5, @SafeParcelable.Param(mo22651id = 18) boolean z) {
        this.versionCode = i;
        this.zzfo = j;
        this.zzfp = i2;
        this.zzfq = str;
        this.zzfr = str3;
        this.zzfs = str5;
        this.zzft = i3;
        this.durationMillis = -1;
        this.zzfu = list;
        this.zzfv = str2;
        this.zzfw = j2;
        this.zzfx = i4;
        this.zzfy = str4;
        this.zzfz = f;
        this.zzga = j3;
        this.zzgb = z;
    }

    public WakeLockEvent(long j, int i, String str, int i2, List<String> list, String str2, long j2, int i3, String str3, String str4, float f, long j3, String str5, boolean z) {
        this(2, j, i, str, i2, list, str2, j2, i3, str3, str4, f, j3, str5, z);
    }

    public final long getTimeMillis() {
        return this.zzfo;
    }

    public final int getEventType() {
        return this.zzfp;
    }

    public final long zzu() {
        return this.durationMillis;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.versionCode);
        SafeParcelWriter.writeLong(parcel, 2, getTimeMillis());
        SafeParcelWriter.writeString(parcel, 4, this.zzfq, false);
        SafeParcelWriter.writeInt(parcel, 5, this.zzft);
        SafeParcelWriter.writeStringList(parcel, 6, this.zzfu, false);
        SafeParcelWriter.writeLong(parcel, 8, this.zzfw);
        SafeParcelWriter.writeString(parcel, 10, this.zzfr, false);
        SafeParcelWriter.writeInt(parcel, 11, getEventType());
        SafeParcelWriter.writeString(parcel, 12, this.zzfv, false);
        SafeParcelWriter.writeString(parcel, 13, this.zzfy, false);
        SafeParcelWriter.writeInt(parcel, 14, this.zzfx);
        SafeParcelWriter.writeFloat(parcel, 15, this.zzfz);
        SafeParcelWriter.writeLong(parcel, 16, this.zzga);
        SafeParcelWriter.writeString(parcel, 17, this.zzfs, false);
        SafeParcelWriter.writeBoolean(parcel, 18, this.zzgb);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final String zzv() {
        String str;
        String str2;
        String str3;
        String str4;
        String str5 = this.zzfq;
        int i = this.zzft;
        if (this.zzfu == null) {
            str = "";
        } else {
            str = TextUtils.join(",", this.zzfu);
        }
        int i2 = this.zzfx;
        if (this.zzfr == null) {
            str2 = "";
        } else {
            str2 = this.zzfr;
        }
        if (this.zzfy == null) {
            str3 = "";
        } else {
            str3 = this.zzfy;
        }
        float f = this.zzfz;
        if (this.zzfs == null) {
            str4 = "";
        } else {
            str4 = this.zzfs;
        }
        boolean z = this.zzgb;
        StringBuilder sb = new StringBuilder(String.valueOf(str5).length() + 51 + String.valueOf(str).length() + String.valueOf(str2).length() + String.valueOf(str3).length() + String.valueOf(str4).length());
        sb.append("\t");
        sb.append(str5);
        sb.append("\t");
        sb.append(i);
        sb.append("\t");
        sb.append(str);
        sb.append("\t");
        sb.append(i2);
        sb.append("\t");
        sb.append(str2);
        sb.append("\t");
        sb.append(str3);
        sb.append("\t");
        sb.append(f);
        sb.append("\t");
        sb.append(str4);
        sb.append("\t");
        sb.append(z);
        return sb.toString();
    }
}
