package com.google.android.gms.internal.ads;

import android.os.Bundle;
import java.util.ArrayList;

final /* synthetic */ class zzcrt implements zzcuz {
    private final ArrayList zzggl;

    zzcrt(ArrayList arrayList) {
        this.zzggl = arrayList;
    }

    public final void zzt(Object obj) {
        ((Bundle) obj).putStringArrayList("ad_types", this.zzggl);
    }
}
