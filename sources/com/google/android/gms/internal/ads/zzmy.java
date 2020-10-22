package com.google.android.gms.internal.ads;

public class zzmy {
    private int flags;

    public void clear() {
        this.flags = 0;
    }

    public final boolean zzib() {
        return zzam(Integer.MIN_VALUE);
    }

    public final boolean zzic() {
        return zzam(4);
    }

    public final boolean zzid() {
        return zzam(1);
    }

    public final void setFlags(int i) {
        this.flags = i;
    }

    public final void zzal(int i) {
        this.flags |= Integer.MIN_VALUE;
    }

    /* access modifiers changed from: protected */
    public final boolean zzam(int i) {
        return (this.flags & i) == i;
    }
}
