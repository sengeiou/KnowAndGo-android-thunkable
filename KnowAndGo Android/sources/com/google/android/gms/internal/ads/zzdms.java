package com.google.android.gms.internal.ads;

import java.util.NoSuchElementException;

final class zzdms extends zzdmu {
    private final int limit = this.zzhcu.size();
    private int position = 0;
    private final /* synthetic */ zzdmr zzhcu;

    zzdms(zzdmr zzdmr) {
        this.zzhcu = zzdmr;
    }

    public final boolean hasNext() {
        return this.position < this.limit;
    }

    public final byte nextByte() {
        int i = this.position;
        if (i < this.limit) {
            this.position = i + 1;
            return this.zzhcu.zzfn(i);
        }
        throw new NoSuchElementException();
    }
}
