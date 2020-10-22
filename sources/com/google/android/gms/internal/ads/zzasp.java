package com.google.android.gms.internal.ads;

import com.google.android.gms.common.internal.Objects;

@zzard
public final class zzasp extends zzass {
    private final String type;
    private final int zzdqm;

    public zzasp(String str, int i) {
        this.type = str;
        this.zzdqm = i;
    }

    public final String getType() {
        return this.type;
    }

    public final int getAmount() {
        return this.zzdqm;
    }

    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof zzasp)) {
            return false;
        }
        zzasp zzasp = (zzasp) obj;
        if (!Objects.equal(this.type, zzasp.type) || !Objects.equal(Integer.valueOf(this.zzdqm), Integer.valueOf(zzasp.zzdqm))) {
            return false;
        }
        return true;
    }
}
