package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class zzdtq<T> implements zzdti<Set<T>> {
    private static final zzdti<Set<Object>> zzhuo = zzdtj.zzar(Collections.emptySet());
    private final List<zzdtu<T>> zzhup;
    private final List<zzdtu<Collection<T>>> zzhuq;

    public static <T> zzdts<T> zzao(int i, int i2) {
        return new zzdts<>(i, i2);
    }

    private zzdtq(List<zzdtu<T>> list, List<zzdtu<Collection<T>>> list2) {
        this.zzhup = list;
        this.zzhuq = list2;
    }

    public final /* synthetic */ Object get() {
        int size = this.zzhup.size();
        ArrayList arrayList = new ArrayList(this.zzhuq.size());
        int size2 = this.zzhuq.size();
        int i = size;
        for (int i2 = 0; i2 < size2; i2++) {
            Collection collection = (Collection) this.zzhuq.get(i2).get();
            i += collection.size();
            arrayList.add(collection);
        }
        HashSet zzhl = zzdtf.zzhl(i);
        int size3 = this.zzhup.size();
        for (int i3 = 0; i3 < size3; i3++) {
            zzhl.add(zzdto.checkNotNull(this.zzhup.get(i3).get()));
        }
        int size4 = arrayList.size();
        for (int i4 = 0; i4 < size4; i4++) {
            for (Object checkNotNull : (Collection) arrayList.get(i4)) {
                zzhl.add(zzdto.checkNotNull(checkNotNull));
            }
        }
        return Collections.unmodifiableSet(zzhl);
    }
}
