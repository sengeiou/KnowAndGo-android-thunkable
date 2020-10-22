package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Map;

@SafeParcelable.Class(creator = "HttpRequestParcelCreator")
@zzard
public final class zzaia extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaia> CREATOR = new zzaib();
    @SafeParcelable.Field(mo22648id = 1)
    private final String url;
    @SafeParcelable.Field(mo22648id = 2)
    private final String[] zzdat;
    @SafeParcelable.Field(mo22648id = 3)
    private final String[] zzdau;

    @SafeParcelable.Constructor
    zzaia(@SafeParcelable.Param(mo22651id = 1) String str, @SafeParcelable.Param(mo22651id = 2) String[] strArr, @SafeParcelable.Param(mo22651id = 3) String[] strArr2) {
        this.url = str;
        this.zzdat = strArr;
        this.zzdau = strArr2;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.url, false);
        SafeParcelWriter.writeStringArray(parcel, 2, this.zzdat, false);
        SafeParcelWriter.writeStringArray(parcel, 3, this.zzdau, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public static zzaia zzh(zzr zzr) throws zza {
        Map<String, String> headers = zzr.getHeaders();
        int size = headers.size();
        String[] strArr = new String[size];
        String[] strArr2 = new String[size];
        int i = 0;
        for (Map.Entry next : headers.entrySet()) {
            strArr[i] = (String) next.getKey();
            strArr2[i] = (String) next.getValue();
            i++;
        }
        return new zzaia(zzr.getUrl(), strArr, strArr2);
    }
}
