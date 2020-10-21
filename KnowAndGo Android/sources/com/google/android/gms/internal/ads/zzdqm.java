package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Map;

final class zzdqm implements Iterator<Map.Entry<K, V>> {
    private int pos;
    private Iterator<Map.Entry<K, V>> zzhkx;
    private final /* synthetic */ zzdqe zzhky;
    private boolean zzhlc;

    private zzdqm(zzdqe zzdqe) {
        this.zzhky = zzdqe;
        this.pos = -1;
    }

    public final boolean hasNext() {
        if (this.pos + 1 < this.zzhky.zzhks.size() || (!this.zzhky.zzhkt.isEmpty() && zzazu().hasNext())) {
            return true;
        }
        return false;
    }

    public final void remove() {
        if (this.zzhlc) {
            this.zzhlc = false;
            this.zzhky.zzazs();
            if (this.pos < this.zzhky.zzhks.size()) {
                zzdqe zzdqe = this.zzhky;
                int i = this.pos;
                this.pos = i - 1;
                Object unused = zzdqe.zzha(i);
                return;
            }
            zzazu().remove();
            return;
        }
        throw new IllegalStateException("remove() was called before next()");
    }

    private final Iterator<Map.Entry<K, V>> zzazu() {
        if (this.zzhkx == null) {
            this.zzhkx = this.zzhky.zzhkt.entrySet().iterator();
        }
        return this.zzhkx;
    }

    public final /* synthetic */ Object next() {
        this.zzhlc = true;
        int i = this.pos + 1;
        this.pos = i;
        if (i < this.zzhky.zzhks.size()) {
            return (Map.Entry) this.zzhky.zzhks.get(this.pos);
        }
        return (Map.Entry) zzazu().next();
    }

    /* synthetic */ zzdqm(zzdqe zzdqe, zzdqf zzdqf) {
        this(zzdqe);
    }
}
