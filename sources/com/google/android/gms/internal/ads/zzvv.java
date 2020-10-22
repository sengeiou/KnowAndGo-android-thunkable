package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

@SafeParcelable.Class(creator = "CacheOfferingCreator")
@SafeParcelable.Reserved({1})
@zzard
public final class zzvv extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzvv> CREATOR = new zzvw();
    @SafeParcelable.Field(mo22648id = 2)
    @Nullable
    public final String url;
    @SafeParcelable.Field(mo22648id = 3)
    private final long zzbws;
    @SafeParcelable.Field(mo22648id = 4)
    private final String zzbwt;
    @SafeParcelable.Field(mo22648id = 5)
    private final String zzbwu;
    @SafeParcelable.Field(mo22648id = 6)
    private final String zzbwv;
    @SafeParcelable.Field(mo22648id = 7)
    private final Bundle zzbww;
    @SafeParcelable.Field(mo22648id = 8)
    public final boolean zzbwx;
    @SafeParcelable.Field(mo22648id = 9)
    public long zzbwy;

    @Nullable
    public static zzvv zzbo(String str) {
        return zze(Uri.parse(str));
    }

    @Nullable
    public static zzvv zze(Uri uri) {
        long parseLong;
        try {
            if (!"gcache".equals(uri.getScheme())) {
                return null;
            }
            List<String> pathSegments = uri.getPathSegments();
            if (pathSegments.size() != 2) {
                int size = pathSegments.size();
                StringBuilder sb = new StringBuilder(62);
                sb.append("Expected 2 path parts for namespace and id, found :");
                sb.append(size);
                zzawz.zzep(sb.toString());
                return null;
            }
            String str = pathSegments.get(0);
            String str2 = pathSegments.get(1);
            String host = uri.getHost();
            String queryParameter = uri.getQueryParameter(ImagesContract.URL);
            boolean equals = "1".equals(uri.getQueryParameter("read_only"));
            String queryParameter2 = uri.getQueryParameter("expiration");
            if (queryParameter2 == null) {
                parseLong = 0;
            } else {
                parseLong = Long.parseLong(queryParameter2);
            }
            long j = parseLong;
            Bundle bundle = new Bundle();
            zzk.zzli();
            for (String next : uri.getQueryParameterNames()) {
                if (next.startsWith("tag.")) {
                    bundle.putString(next.substring(4), uri.getQueryParameter(next));
                }
            }
            return new zzvv(queryParameter, j, host, str, str2, bundle, equals, 0);
        } catch (NullPointerException | NumberFormatException e) {
            zzawz.zzd("Unable to parse Uri into cache offering.", e);
            return null;
        }
    }

    @SafeParcelable.Constructor
    zzvv(@SafeParcelable.Param(mo22651id = 2) @Nullable String str, @SafeParcelable.Param(mo22651id = 3) long j, @SafeParcelable.Param(mo22651id = 4) String str2, @SafeParcelable.Param(mo22651id = 5) String str3, @SafeParcelable.Param(mo22651id = 6) String str4, @SafeParcelable.Param(mo22651id = 7) Bundle bundle, @SafeParcelable.Param(mo22651id = 8) boolean z, @SafeParcelable.Param(mo22651id = 9) long j2) {
        this.url = str;
        this.zzbws = j;
        this.zzbwt = str2 == null ? "" : str2;
        this.zzbwu = str3 == null ? "" : str3;
        this.zzbwv = str4 == null ? "" : str4;
        this.zzbww = bundle == null ? new Bundle() : bundle;
        this.zzbwx = z;
        this.zzbwy = j2;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.url, false);
        SafeParcelWriter.writeLong(parcel, 3, this.zzbws);
        SafeParcelWriter.writeString(parcel, 4, this.zzbwt, false);
        SafeParcelWriter.writeString(parcel, 5, this.zzbwu, false);
        SafeParcelWriter.writeString(parcel, 6, this.zzbwv, false);
        SafeParcelWriter.writeBundle(parcel, 7, this.zzbww, false);
        SafeParcelWriter.writeBoolean(parcel, 8, this.zzbwx);
        SafeParcelWriter.writeLong(parcel, 9, this.zzbwy);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
