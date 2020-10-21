package com.google.android.gms.internal.ads;

public final class zzln {
    public static final zzln zzaug = new zzln(1.0f, 1.0f);
    public final float zzauh;
    public final float zzaui;
    private final int zzauj;

    public zzln(float f, float f2) {
        this.zzauh = f;
        this.zzaui = f2;
        this.zzauj = Math.round(f * 1000.0f);
    }

    public final long zzef(long j) {
        return j * ((long) this.zzauj);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        zzln zzln = (zzln) obj;
        return this.zzauh == zzln.zzauh && this.zzaui == zzln.zzaui;
    }

    public final int hashCode() {
        return ((Float.floatToRawIntBits(this.zzauh) + 527) * 31) + Float.floatToRawIntBits(this.zzaui);
    }
}
