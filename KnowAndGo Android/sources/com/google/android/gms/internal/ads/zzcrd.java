package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import com.google.android.gms.ads.internal.zzk;
import java.util.List;

public final class zzcrd implements zzcuz<Bundle> {
    private final zzyd zzdll;
    private final List<Parcelable> zzgfy;
    private final Context zzlj;

    public zzcrd(Context context, zzyd zzyd, List<Parcelable> list) {
        this.zzlj = context;
        this.zzdll = zzyd;
        this.zzgfy = list;
    }

    public final /* synthetic */ void zzt(Object obj) {
        Bundle bundle = (Bundle) obj;
        zzk.zzlg();
        bundle.putString("activity", zzaxi.zzap(this.zzlj));
        Bundle bundle2 = new Bundle();
        bundle2.putInt("width", this.zzdll.width);
        bundle2.putInt("height", this.zzdll.height);
        bundle.putBundle("size", bundle2);
        if (this.zzgfy.size() > 0) {
            bundle.putParcelableArray("parents", (Parcelable[]) this.zzgfy.toArray(new Parcelable[this.zzgfy.size()]));
        }
    }
}
