package com.google.android.gms.internal.ads;

import com.google.android.gms.common.internal.Objects;
import com.onesignal.shortcutbadger.impl.NewHtcHomeBadger;

public final class zzays {
    public final int count;
    public final String name;
    private final double zzdxb;
    private final double zzdxc;
    public final double zzdxd;

    public zzays(String str, double d, double d2, double d3, int i) {
        this.name = str;
        this.zzdxc = d;
        this.zzdxb = d2;
        this.zzdxd = d3;
        this.count = i;
    }

    public final String toString() {
        return Objects.toStringHelper(this).add("name", this.name).add("minBound", Double.valueOf(this.zzdxc)).add("maxBound", Double.valueOf(this.zzdxb)).add("percent", Double.valueOf(this.zzdxd)).add(NewHtcHomeBadger.COUNT, Integer.valueOf(this.count)).toString();
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzays)) {
            return false;
        }
        zzays zzays = (zzays) obj;
        if (Objects.equal(this.name, zzays.name) && this.zzdxb == zzays.zzdxb && this.zzdxc == zzays.zzdxc && this.count == zzays.count && Double.compare(this.zzdxd, zzays.zzdxd) == 0) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.name, Double.valueOf(this.zzdxb), Double.valueOf(this.zzdxc), Double.valueOf(this.zzdxd), Integer.valueOf(this.count));
    }
}
