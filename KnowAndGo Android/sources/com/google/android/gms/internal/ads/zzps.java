package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.metadata.id3.CommentFrame;

public final class zzps extends zzpv {
    public static final Parcelable.Creator<zzps> CREATOR = new zzpt();
    public final String description;
    private final String zzauc;
    public final String zzbhy;

    public zzps(String str, String str2, String str3) {
        super(CommentFrame.f144ID);
        this.zzauc = str;
        this.description = str2;
        this.zzbhy = str3;
    }

    zzps(Parcel parcel) {
        super(CommentFrame.f144ID);
        this.zzauc = parcel.readString();
        this.description = parcel.readString();
        this.zzbhy = parcel.readString();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        zzps zzps = (zzps) obj;
        return zzsy.zza(this.description, zzps.description) && zzsy.zza(this.zzauc, zzps.zzauc) && zzsy.zza(this.zzbhy, zzps.zzbhy);
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = ((((this.zzauc != null ? this.zzauc.hashCode() : 0) + 527) * 31) + (this.description != null ? this.description.hashCode() : 0)) * 31;
        if (this.zzbhy != null) {
            i = this.zzbhy.hashCode();
        }
        return hashCode + i;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.zzatl);
        parcel.writeString(this.zzauc);
        parcel.writeString(this.zzbhy);
    }
}
