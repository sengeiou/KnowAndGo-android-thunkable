package com.google.android.gms.internal.ads;

import android.os.Bundle;
import java.util.ArrayList;

final /* synthetic */ class zzcrx implements zzcuz {
    private final ArrayList zzggl;

    zzcrx(ArrayList arrayList) {
        this.zzggl = arrayList;
    }

    public final void zzt(Object obj) {
        ((Bundle) obj).putStringArrayList("android_permissions", this.zzggl);
    }
}
