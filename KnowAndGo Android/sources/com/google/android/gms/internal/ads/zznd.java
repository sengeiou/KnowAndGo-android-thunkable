package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

public final class zznd extends zzmy {
    public long zzaga;
    private final int zzagb = 0;
    public final zzmz zzaze = new zzmz();
    public ByteBuffer zzde;

    public zznd(int i) {
    }

    public final void zzan(int i) throws IllegalStateException {
        if (this.zzde == null) {
            this.zzde = zzao(i);
            return;
        }
        int capacity = this.zzde.capacity();
        int position = this.zzde.position();
        int i2 = i + position;
        if (capacity < i2) {
            ByteBuffer zzao = zzao(i2);
            if (position > 0) {
                this.zzde.position(0);
                this.zzde.limit(position);
                zzao.put(this.zzde);
            }
            this.zzde = zzao;
        }
    }

    public final boolean zzeo() {
        return zzam(1073741824);
    }

    public final void clear() {
        super.clear();
        if (this.zzde != null) {
            this.zzde.clear();
        }
    }

    private final ByteBuffer zzao(int i) {
        int capacity = this.zzde == null ? 0 : this.zzde.capacity();
        StringBuilder sb = new StringBuilder(44);
        sb.append("Buffer too small (");
        sb.append(capacity);
        sb.append(" < ");
        sb.append(i);
        sb.append(")");
        throw new IllegalStateException(sb.toString());
    }
}
