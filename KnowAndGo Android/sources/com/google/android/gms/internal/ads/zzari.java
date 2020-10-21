package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Collections;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;

@SafeParcelable.Class(creator = "AdResponseParcelCreator")
@ParametersAreNonnullByDefault
@zzard
public final class zzari extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzari> CREATOR = new zzarj();
    @SafeParcelable.Field(mo22648id = 5)
    private final int errorCode;
    @SafeParcelable.Field(mo22648id = 12)
    private final int orientation;
    @SafeParcelable.Field(mo22648id = 1)
    private final int versionCode;
    @SafeParcelable.Field(mo22648id = 37)
    @Nullable
    private final zzark zzbqx;
    @SafeParcelable.Field(mo22648id = 49)
    private final boolean zzbrl;
    @SafeParcelable.Field(mo22648id = 53)
    private final boolean zzbrm;
    @SafeParcelable.Field(mo22648id = 23)
    private final boolean zzbsz;
    @SafeParcelable.Field(mo22648id = 30)
    private final String zzcep;
    @SafeParcelable.Field(mo22648id = 31)
    private final boolean zzchh;
    @SafeParcelable.Field(mo22648id = 32)
    private final boolean zzchi;
    @SafeParcelable.Field(mo22648id = 4)
    private final List<String> zzdfe;
    @SafeParcelable.Field(mo22648id = 6)
    private final List<String> zzdff;
    @SafeParcelable.Field(mo22648id = 52)
    private final List<String> zzdfg;
    @SafeParcelable.Field(mo22648id = 40)
    private final List<String> zzdfi;
    @SafeParcelable.Field(mo22648id = 42)
    private final boolean zzdfj;
    @SafeParcelable.Field(mo22648id = 11)
    private final long zzdfl;
    @SafeParcelable.Field(mo22648id = 2)
    private final String zzdkn;
    @SafeParcelable.Field(mo22648id = 24)
    private final boolean zzdls;
    @SafeParcelable.Field(mo22648id = 38)
    private final boolean zzdmh;
    @SafeParcelable.Field(mo22648id = 39)
    @Nullable
    private String zzdmi;
    @SafeParcelable.Field(mo22648id = 47)
    private final boolean zzdmu;
    @SafeParcelable.Field(mo22648id = 3)
    private String zzdnh;
    @SafeParcelable.Field(mo22648id = 7)
    private final long zzdni;
    @SafeParcelable.Field(mo22648id = 8)
    private final boolean zzdnj;
    @SafeParcelable.Field(mo22648id = 9)
    private final long zzdnk;
    @SafeParcelable.Field(mo22648id = 10)
    private final List<String> zzdnl;
    @SafeParcelable.Field(mo22648id = 13)
    private final String zzdnm;
    @SafeParcelable.Field(mo22648id = 14)
    private final long zzdnn;
    @SafeParcelable.Field(mo22648id = 15)
    private final String zzdno;
    @SafeParcelable.Field(mo22648id = 18)
    private final boolean zzdnp;
    @SafeParcelable.Field(mo22648id = 19)
    private final String zzdnq;
    @SafeParcelable.Field(mo22648id = 21)
    private final String zzdnr;
    @SafeParcelable.Field(mo22648id = 22)
    private final boolean zzdns;
    @SafeParcelable.Field(mo22648id = 25)
    private final boolean zzdnt;
    @SafeParcelable.Field(mo22648id = 26)
    private final boolean zzdnu;
    @SafeParcelable.Field(mo22648id = 28)
    private zzaru zzdnv;
    @SafeParcelable.Field(mo22648id = 29)
    private String zzdnw;
    @SafeParcelable.Field(mo22648id = 33)
    @Nullable
    private final zzato zzdnx;
    @SafeParcelable.Field(mo22648id = 34)
    @Nullable
    private final List<String> zzdny;
    @SafeParcelable.Field(mo22648id = 35)
    @Nullable
    private final List<String> zzdnz;
    @SafeParcelable.Field(mo22648id = 36)
    private final boolean zzdoa;
    @SafeParcelable.Field(mo22648id = 43)
    @Nullable
    private final String zzdob;
    @SafeParcelable.Field(mo22648id = 44)
    @Nullable
    private final zzauy zzdoc;
    @SafeParcelable.Field(mo22648id = 45)
    @Nullable
    private final String zzdod;
    @SafeParcelable.Field(mo22648id = 46)
    private final boolean zzdoe;
    @SafeParcelable.Field(mo22648id = 48)
    private Bundle zzdof;
    @SafeParcelable.Field(mo22648id = 50)
    private final int zzdog;
    @SafeParcelable.Field(mo22648id = 51)
    private final boolean zzdoh;
    @SafeParcelable.Field(mo22648id = 54)
    @Nullable
    private final String zzdoi;
    @SafeParcelable.Field(mo22648id = 55)
    @Nullable
    private String zzdoj;
    @SafeParcelable.Field(mo22648id = 56)
    private boolean zzdok;
    @SafeParcelable.Field(mo22648id = 57)
    private boolean zzdol;

    @SafeParcelable.Constructor
    zzari(@SafeParcelable.Param(mo22651id = 1) int i, @SafeParcelable.Param(mo22651id = 2) String str, @SafeParcelable.Param(mo22651id = 3) String str2, @SafeParcelable.Param(mo22651id = 4) List<String> list, @SafeParcelable.Param(mo22651id = 5) int i2, @SafeParcelable.Param(mo22651id = 6) List<String> list2, @SafeParcelable.Param(mo22651id = 7) long j, @SafeParcelable.Param(mo22651id = 8) boolean z, @SafeParcelable.Param(mo22651id = 9) long j2, @SafeParcelable.Param(mo22651id = 10) List<String> list3, @SafeParcelable.Param(mo22651id = 11) long j3, @SafeParcelable.Param(mo22651id = 12) int i3, @SafeParcelable.Param(mo22651id = 13) String str3, @SafeParcelable.Param(mo22651id = 14) long j4, @SafeParcelable.Param(mo22651id = 15) String str4, @SafeParcelable.Param(mo22651id = 18) boolean z2, @SafeParcelable.Param(mo22651id = 19) String str5, @SafeParcelable.Param(mo22651id = 21) String str6, @SafeParcelable.Param(mo22651id = 22) boolean z3, @SafeParcelable.Param(mo22651id = 23) boolean z4, @SafeParcelable.Param(mo22651id = 24) boolean z5, @SafeParcelable.Param(mo22651id = 25) boolean z6, @SafeParcelable.Param(mo22651id = 26) boolean z7, @SafeParcelable.Param(mo22651id = 28) zzaru zzaru, @SafeParcelable.Param(mo22651id = 29) String str7, @SafeParcelable.Param(mo22651id = 30) String str8, @SafeParcelable.Param(mo22651id = 31) boolean z8, @SafeParcelable.Param(mo22651id = 32) boolean z9, @SafeParcelable.Param(mo22651id = 33) zzato zzato, @SafeParcelable.Param(mo22651id = 34) List<String> list4, @SafeParcelable.Param(mo22651id = 35) List<String> list5, @SafeParcelable.Param(mo22651id = 36) boolean z10, @SafeParcelable.Param(mo22651id = 37) zzark zzark, @SafeParcelable.Param(mo22651id = 38) boolean z11, @SafeParcelable.Param(mo22651id = 39) String str9, @SafeParcelable.Param(mo22651id = 40) List<String> list6, @SafeParcelable.Param(mo22651id = 42) boolean z12, @SafeParcelable.Param(mo22651id = 43) String str10, @SafeParcelable.Param(mo22651id = 44) zzauy zzauy, @SafeParcelable.Param(mo22651id = 45) String str11, @SafeParcelable.Param(mo22651id = 46) boolean z13, @SafeParcelable.Param(mo22651id = 47) boolean z14, @SafeParcelable.Param(mo22651id = 48) Bundle bundle, @SafeParcelable.Param(mo22651id = 49) boolean z15, @SafeParcelable.Param(mo22651id = 50) int i4, @SafeParcelable.Param(mo22651id = 51) boolean z16, @SafeParcelable.Param(mo22651id = 52) List<String> list7, @SafeParcelable.Param(mo22651id = 53) boolean z17, @SafeParcelable.Param(mo22651id = 54) String str12, @SafeParcelable.Param(mo22651id = 55) @Nullable String str13, @SafeParcelable.Param(mo22651id = 56) boolean z18, @SafeParcelable.Param(mo22651id = 57) boolean z19) {
        zzarz zzarz;
        this.versionCode = i;
        this.zzdkn = str;
        this.zzdnh = str2;
        List<String> list8 = null;
        this.zzdfe = list != null ? Collections.unmodifiableList(list) : null;
        this.errorCode = i2;
        this.zzdff = list2 != null ? Collections.unmodifiableList(list2) : null;
        this.zzdni = j;
        this.zzdnj = z;
        this.zzdnk = j2;
        this.zzdnl = list3 != null ? Collections.unmodifiableList(list3) : null;
        this.zzdfl = j3;
        this.orientation = i3;
        this.zzdnm = str3;
        this.zzdnn = j4;
        this.zzdno = str4;
        this.zzdnp = z2;
        this.zzdnq = str5;
        this.zzdnr = str6;
        this.zzdns = z3;
        this.zzbsz = z4;
        this.zzdls = z5;
        this.zzdnt = z6;
        this.zzdoe = z13;
        this.zzdnu = z7;
        this.zzdnv = zzaru;
        this.zzdnw = str7;
        this.zzcep = str8;
        if (this.zzdnh == null && this.zzdnv != null && (zzarz = (zzarz) this.zzdnv.zza(zzarz.CREATOR)) != null && !TextUtils.isEmpty(zzarz.zzdow)) {
            this.zzdnh = zzarz.zzdow;
        }
        this.zzchh = z8;
        this.zzchi = z9;
        this.zzdnx = zzato;
        this.zzdny = list4;
        this.zzdnz = list5;
        this.zzdoa = z10;
        this.zzbqx = zzark;
        this.zzdmh = z11;
        this.zzdmi = str9;
        this.zzdfi = list6;
        this.zzdfj = z12;
        this.zzdob = str10;
        this.zzdoc = zzauy;
        this.zzdod = str11;
        this.zzdmu = z14;
        this.zzdof = bundle;
        this.zzbrl = z15;
        this.zzdog = i4;
        this.zzdoh = z16;
        this.zzdfg = list7 != null ? Collections.unmodifiableList(list7) : list8;
        this.zzbrm = z17;
        this.zzdoi = str12;
        this.zzdoj = str13;
        this.zzdok = z18;
        this.zzdol = z19;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.versionCode);
        SafeParcelWriter.writeString(parcel, 2, this.zzdkn, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzdnh, false);
        SafeParcelWriter.writeStringList(parcel, 4, this.zzdfe, false);
        SafeParcelWriter.writeInt(parcel, 5, this.errorCode);
        SafeParcelWriter.writeStringList(parcel, 6, this.zzdff, false);
        SafeParcelWriter.writeLong(parcel, 7, this.zzdni);
        SafeParcelWriter.writeBoolean(parcel, 8, this.zzdnj);
        SafeParcelWriter.writeLong(parcel, 9, this.zzdnk);
        SafeParcelWriter.writeStringList(parcel, 10, this.zzdnl, false);
        SafeParcelWriter.writeLong(parcel, 11, this.zzdfl);
        SafeParcelWriter.writeInt(parcel, 12, this.orientation);
        SafeParcelWriter.writeString(parcel, 13, this.zzdnm, false);
        SafeParcelWriter.writeLong(parcel, 14, this.zzdnn);
        SafeParcelWriter.writeString(parcel, 15, this.zzdno, false);
        SafeParcelWriter.writeBoolean(parcel, 18, this.zzdnp);
        SafeParcelWriter.writeString(parcel, 19, this.zzdnq, false);
        SafeParcelWriter.writeString(parcel, 21, this.zzdnr, false);
        SafeParcelWriter.writeBoolean(parcel, 22, this.zzdns);
        SafeParcelWriter.writeBoolean(parcel, 23, this.zzbsz);
        SafeParcelWriter.writeBoolean(parcel, 24, this.zzdls);
        SafeParcelWriter.writeBoolean(parcel, 25, this.zzdnt);
        SafeParcelWriter.writeBoolean(parcel, 26, this.zzdnu);
        SafeParcelWriter.writeParcelable(parcel, 28, this.zzdnv, i, false);
        SafeParcelWriter.writeString(parcel, 29, this.zzdnw, false);
        SafeParcelWriter.writeString(parcel, 30, this.zzcep, false);
        SafeParcelWriter.writeBoolean(parcel, 31, this.zzchh);
        SafeParcelWriter.writeBoolean(parcel, 32, this.zzchi);
        SafeParcelWriter.writeParcelable(parcel, 33, this.zzdnx, i, false);
        SafeParcelWriter.writeStringList(parcel, 34, this.zzdny, false);
        SafeParcelWriter.writeStringList(parcel, 35, this.zzdnz, false);
        SafeParcelWriter.writeBoolean(parcel, 36, this.zzdoa);
        SafeParcelWriter.writeParcelable(parcel, 37, this.zzbqx, i, false);
        SafeParcelWriter.writeBoolean(parcel, 38, this.zzdmh);
        SafeParcelWriter.writeString(parcel, 39, this.zzdmi, false);
        SafeParcelWriter.writeStringList(parcel, 40, this.zzdfi, false);
        SafeParcelWriter.writeBoolean(parcel, 42, this.zzdfj);
        SafeParcelWriter.writeString(parcel, 43, this.zzdob, false);
        SafeParcelWriter.writeParcelable(parcel, 44, this.zzdoc, i, false);
        SafeParcelWriter.writeString(parcel, 45, this.zzdod, false);
        SafeParcelWriter.writeBoolean(parcel, 46, this.zzdoe);
        SafeParcelWriter.writeBoolean(parcel, 47, this.zzdmu);
        SafeParcelWriter.writeBundle(parcel, 48, this.zzdof, false);
        SafeParcelWriter.writeBoolean(parcel, 49, this.zzbrl);
        SafeParcelWriter.writeInt(parcel, 50, this.zzdog);
        SafeParcelWriter.writeBoolean(parcel, 51, this.zzdoh);
        SafeParcelWriter.writeStringList(parcel, 52, this.zzdfg, false);
        SafeParcelWriter.writeBoolean(parcel, 53, this.zzbrm);
        SafeParcelWriter.writeString(parcel, 54, this.zzdoi, false);
        SafeParcelWriter.writeString(parcel, 55, this.zzdoj, false);
        SafeParcelWriter.writeBoolean(parcel, 56, this.zzdok);
        SafeParcelWriter.writeBoolean(parcel, 57, this.zzdol);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
