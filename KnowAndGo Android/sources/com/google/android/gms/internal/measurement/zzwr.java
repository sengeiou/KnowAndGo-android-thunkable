package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Map;

final class zzwr extends zzwx {
    private final /* synthetic */ zzwo zzcca;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private zzwr(zzwo zzwo) {
        super(zzwo, (zzwp) null);
        this.zzcca = zzwo;
    }

    public final Iterator<Map.Entry<K, V>> iterator() {
        return new zzwq(this.zzcca, (zzwp) null);
    }

    /* synthetic */ zzwr(zzwo zzwo, zzwp zzwp) {
        this(zzwo);
    }
}
