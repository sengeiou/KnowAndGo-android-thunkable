package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.metadata.id3.ApicFrame;
import java.util.Arrays;

public final class zzpq extends zzpv {
    public static final Parcelable.Creator<zzpq> CREATOR = new zzpr();
    private final String description;
    private final String mimeType;
    private final int zzbhw;
    private final byte[] zzbhx;

    public zzpq(String str, String str2, int i, byte[] bArr) {
        super(ApicFrame.f141ID);
        this.mimeType = str;
        this.description = null;
        this.zzbhw = 3;
        this.zzbhx = bArr;
    }

    zzpq(Parcel parcel) {
        super(ApicFrame.f141ID);
        this.mimeType = parcel.readString();
        this.description = parcel.readString();
        this.zzbhw = parcel.readInt();
        this.zzbhx = parcel.createByteArray();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        zzpq zzpq = (zzpq) obj;
        return this.zzbhw == zzpq.zzbhw && zzsy.zza(this.mimeType, zzpq.mimeType) && zzsy.zza(this.description, zzpq.description) && Arrays.equals(this.zzbhx, zzpq.zzbhx);
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = (((this.zzbhw + 527) * 31) + (this.mimeType != null ? this.mimeType.hashCode() : 0)) * 31;
        if (this.description != null) {
            i = this.description.hashCode();
        }
        return ((hashCode + i) * 31) + Arrays.hashCode(this.zzbhx);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mimeType);
        parcel.writeString(this.description);
        parcel.writeInt(this.zzbhw);
        parcel.writeByteArray(this.zzbhx);
    }
}
