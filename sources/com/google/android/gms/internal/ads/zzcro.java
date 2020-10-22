package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;

public final class zzcro implements zzcuz<Bundle> {
    private final String zzaap;
    private final float zzbtx;
    private final boolean zzchh;
    private final zzyd zzdll;
    private final int zzdlt;
    private final int zzdlu;
    private final String zzggf;
    private final String zzggg;

    public zzcro(zzyd zzyd, String str, boolean z, String str2, float f, int i, int i2, String str3) {
        Preconditions.checkNotNull(zzyd, "the adSize must not be null");
        this.zzdll = zzyd;
        this.zzaap = str;
        this.zzchh = z;
        this.zzggf = str2;
        this.zzbtx = f;
        this.zzdlt = i;
        this.zzdlu = i2;
        this.zzggg = str3;
    }

    public final /* synthetic */ void zzt(Object obj) {
        Bundle bundle = (Bundle) obj;
        zzcxz.zza(bundle, "smart_w", "full", this.zzdll.width == -1);
        zzcxz.zza(bundle, "smart_h", "auto", this.zzdll.height == -2);
        zzcxz.zza(bundle, "ene", (Boolean) true, this.zzdll.zzchi);
        zzcxz.zza(bundle, "format", this.zzaap);
        zzcxz.zza(bundle, "fluid", "height", this.zzchh);
        zzcxz.zza(bundle, "sz", this.zzggf, !TextUtils.isEmpty(this.zzggf));
        bundle.putFloat("u_sd", this.zzbtx);
        bundle.putInt("sw", this.zzdlt);
        bundle.putInt("sh", this.zzdlu);
        zzcxz.zza(bundle, "sc", this.zzggg, !TextUtils.isEmpty(this.zzggg));
        ArrayList arrayList = new ArrayList();
        if (this.zzdll.zzchg == null) {
            Bundle bundle2 = new Bundle();
            bundle2.putInt("height", this.zzdll.height);
            bundle2.putInt("width", this.zzdll.width);
            bundle2.putBoolean("is_fluid_height", this.zzdll.zzchh);
            arrayList.add(bundle2);
        } else {
            for (zzyd zzyd : this.zzdll.zzchg) {
                Bundle bundle3 = new Bundle();
                bundle3.putBoolean("is_fluid_height", zzyd.zzchh);
                bundle3.putInt("height", zzyd.height);
                bundle3.putInt("width", zzyd.width);
                arrayList.add(bundle3);
            }
        }
        bundle.putParcelableArrayList("valid_ad_sizes", arrayList);
    }
}
