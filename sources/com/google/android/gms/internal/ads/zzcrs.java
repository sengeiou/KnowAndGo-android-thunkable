package com.google.android.gms.internal.ads;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.Set;

final class zzcrs implements zzcva<zzcuz<Bundle>> {
    private final Set<String> zzggk;

    zzcrs(Set<String> set) {
        this.zzggk = set;
    }

    public final zzbbh<zzcuz<Bundle>> zzalm() {
        ArrayList arrayList = new ArrayList();
        for (String add : this.zzggk) {
            arrayList.add(add);
        }
        return zzbar.zzm(new zzcrt(arrayList));
    }
}
