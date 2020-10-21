package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Map;

final class zzdqh extends zzdqn {
    private final /* synthetic */ zzdqe zzhky;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private zzdqh(zzdqe zzdqe) {
        super(zzdqe, (zzdqf) null);
        this.zzhky = zzdqe;
    }

    public final Iterator<Map.Entry<K, V>> iterator() {
        return new zzdqg(this.zzhky, (zzdqf) null);
    }

    /* synthetic */ zzdqh(zzdqe zzdqe, zzdqf zzdqf) {
        this(zzdqe);
    }
}
