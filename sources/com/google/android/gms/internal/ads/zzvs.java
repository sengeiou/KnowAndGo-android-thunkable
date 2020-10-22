package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.io.InputStream;
import javax.annotation.concurrent.GuardedBy;

@SafeParcelable.Class(creator = "CacheEntryParcelCreator")
@SafeParcelable.Reserved({1})
@zzard
public final class zzvs extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzvs> CREATOR = new zzvt();
    @GuardedBy("this")
    @SafeParcelable.Field(getter = "getContentFileDescriptor", mo22648id = 2)
    @Nullable
    private ParcelFileDescriptor zzbwr;

    public zzvs() {
        this((ParcelFileDescriptor) null);
    }

    @SafeParcelable.Constructor
    public zzvs(@SafeParcelable.Param(mo22651id = 2) @Nullable ParcelFileDescriptor parcelFileDescriptor) {
        this.zzbwr = parcelFileDescriptor;
    }

    public final synchronized boolean zznh() {
        return this.zzbwr != null;
    }

    @Nullable
    public final synchronized InputStream zzni() {
        if (this.zzbwr == null) {
            return null;
        }
        ParcelFileDescriptor.AutoCloseInputStream autoCloseInputStream = new ParcelFileDescriptor.AutoCloseInputStream(this.zzbwr);
        this.zzbwr = null;
        return autoCloseInputStream;
    }

    private final synchronized ParcelFileDescriptor zznj() {
        return this.zzbwr;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, zznj(), i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
