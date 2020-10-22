package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

@SafeParcelable.Class(creator = "SafeBrowsingConfigParcelCreator")
@SafeParcelable.Reserved({1})
@zzard
public final class zzauy extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzauy> CREATOR = new zzauz();
    @SafeParcelable.Field(mo22648id = 2)
    public final String zzdrr;
    @SafeParcelable.Field(mo22648id = 3)
    public final String zzdrs;
    @SafeParcelable.Field(mo22648id = 4)
    public final boolean zzdrt;
    @SafeParcelable.Field(mo22648id = 5)
    public final boolean zzdru;
    @SafeParcelable.Field(mo22648id = 6)
    public final List<String> zzdrv;
    @SafeParcelable.Field(mo22648id = 7)
    public final boolean zzdrw;
    @SafeParcelable.Field(mo22648id = 8)
    public final boolean zzdrx;
    @SafeParcelable.Field(mo22648id = 9)
    public final List<String> zzdry;

    @SafeParcelable.Constructor
    public zzauy(@SafeParcelable.Param(mo22651id = 2) String str, @SafeParcelable.Param(mo22651id = 3) String str2, @SafeParcelable.Param(mo22651id = 4) boolean z, @SafeParcelable.Param(mo22651id = 5) boolean z2, @SafeParcelable.Param(mo22651id = 6) List<String> list, @SafeParcelable.Param(mo22651id = 7) boolean z3, @SafeParcelable.Param(mo22651id = 8) boolean z4, @SafeParcelable.Param(mo22651id = 9) List<String> list2) {
        this.zzdrr = str;
        this.zzdrs = str2;
        this.zzdrt = z;
        this.zzdru = z2;
        this.zzdrv = list;
        this.zzdrw = z3;
        this.zzdrx = z4;
        this.zzdry = list2 == null ? new ArrayList<>() : list2;
    }

    @Nullable
    public static zzauy zzg(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return null;
        }
        return new zzauy(jSONObject.optString("click_string", ""), jSONObject.optString("report_url", ""), jSONObject.optBoolean("rendered_ad_enabled", false), jSONObject.optBoolean("non_malicious_reporting_enabled", false), zzazc.zza(jSONObject.optJSONArray("allowed_headers"), (List<String>) null), jSONObject.optBoolean("protection_enabled", false), jSONObject.optBoolean("malicious_reporting_enabled", false), zzazc.zza(jSONObject.optJSONArray("webview_permissions"), (List<String>) null));
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zzdrr, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzdrs, false);
        SafeParcelWriter.writeBoolean(parcel, 4, this.zzdrt);
        SafeParcelWriter.writeBoolean(parcel, 5, this.zzdru);
        SafeParcelWriter.writeStringList(parcel, 6, this.zzdrv, false);
        SafeParcelWriter.writeBoolean(parcel, 7, this.zzdrw);
        SafeParcelWriter.writeBoolean(parcel, 8, this.zzdrx);
        SafeParcelWriter.writeStringList(parcel, 9, this.zzdry, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
