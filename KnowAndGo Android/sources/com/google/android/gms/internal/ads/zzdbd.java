package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.ads.zzbp;

@SafeParcelable.Class(creator = "GassResponseParcelCreator")
public final class zzdbd extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzdbd> CREATOR = new zzdbe();
    @SafeParcelable.VersionField(mo22654id = 1)
    private final int versionCode;
    @SafeParcelable.Field(getter = "getAfmaSignalsAsBytes", mo22648id = 2, type = "byte[]")
    private zzbp.zza zzgow = null;
    private byte[] zzgox;

    @SafeParcelable.Constructor
    zzdbd(@SafeParcelable.Param(mo22651id = 1) int i, @SafeParcelable.Param(mo22651id = 2) byte[] bArr) {
        this.versionCode = i;
        this.zzgox = bArr;
        zzano();
    }

    public final zzbp.zza zzann() {
        if (!(this.zzgow != null)) {
            try {
                this.zzgow = zzbp.zza.zzb(this.zzgox, zzdno.zzaxe());
                this.zzgox = null;
            } catch (zzdok e) {
                throw new IllegalStateException(e);
            }
        }
        zzano();
        return this.zzgow;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        byte[] bArr;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.versionCode);
        if (this.zzgox != null) {
            bArr = this.zzgox;
        } else {
            bArr = this.zzgow.toByteArray();
        }
        SafeParcelWriter.writeByteArray(parcel, 2, bArr, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    private final void zzano() {
        if (this.zzgow == null && this.zzgox != null) {
            return;
        }
        if (this.zzgow != null && this.zzgox == null) {
            return;
        }
        if (this.zzgow != null && this.zzgox != null) {
            throw new IllegalStateException("Invalid internal representation - full");
        } else if (this.zzgow == null && this.zzgox == null) {
            throw new IllegalStateException("Invalid internal representation - empty");
        } else {
            throw new IllegalStateException("Impossible");
        }
    }
}
