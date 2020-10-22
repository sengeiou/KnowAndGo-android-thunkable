package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

public final class zztb implements Parcelable {
    public static final Parcelable.Creator<zztb> CREATOR = new zztc();
    private int zzafx;
    public final int zzbbo;
    public final int zzbbp;
    public final int zzbbq;
    public final byte[] zzbnt;

    public zztb(int i, int i2, int i3, byte[] bArr) {
        this.zzbbo = i;
        this.zzbbq = i2;
        this.zzbbp = i3;
        this.zzbnt = bArr;
    }

    public final int describeContents() {
        return 0;
    }

    zztb(Parcel parcel) {
        this.zzbbo = parcel.readInt();
        this.zzbbq = parcel.readInt();
        this.zzbbp = parcel.readInt();
        this.zzbnt = parcel.readInt() != 0 ? parcel.createByteArray() : null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        zztb zztb = (zztb) obj;
        return this.zzbbo == zztb.zzbbo && this.zzbbq == zztb.zzbbq && this.zzbbp == zztb.zzbbp && Arrays.equals(this.zzbnt, zztb.zzbnt);
    }

    public final String toString() {
        int i = this.zzbbo;
        int i2 = this.zzbbq;
        int i3 = this.zzbbp;
        boolean z = this.zzbnt != null;
        StringBuilder sb = new StringBuilder(55);
        sb.append("ColorInfo(");
        sb.append(i);
        sb.append(", ");
        sb.append(i2);
        sb.append(", ");
        sb.append(i3);
        sb.append(", ");
        sb.append(z);
        sb.append(")");
        return sb.toString();
    }

    public final int hashCode() {
        if (this.zzafx == 0) {
            this.zzafx = ((((((this.zzbbo + 527) * 31) + this.zzbbq) * 31) + this.zzbbp) * 31) + Arrays.hashCode(this.zzbnt);
        }
        return this.zzafx;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.zzbbo);
        parcel.writeInt(this.zzbbq);
        parcel.writeInt(this.zzbbp);
        parcel.writeInt(this.zzbnt != null ? 1 : 0);
        if (this.zzbnt != null) {
            parcel.writeByteArray(this.zzbnt);
        }
    }
}
