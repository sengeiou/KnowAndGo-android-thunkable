package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.extractor.p012ts.PsExtractor;

final class zzor implements zzoo {
    private int zzamy;
    private final int zzand = this.zzbea.zzgg();
    private final zzst zzbea;
    private final int zzber = (this.zzbea.zzgg() & 255);
    private int zzbes;

    public zzor(zzol zzol) {
        this.zzbea = zzol.zzbea;
        this.zzbea.setPosition(12);
    }

    public final boolean zzio() {
        return false;
    }

    public final int zzim() {
        return this.zzand;
    }

    public final int zzin() {
        if (this.zzber == 8) {
            return this.zzbea.readUnsignedByte();
        }
        if (this.zzber == 16) {
            return this.zzbea.readUnsignedShort();
        }
        int i = this.zzamy;
        this.zzamy = i + 1;
        if (i % 2 != 0) {
            return this.zzbes & 15;
        }
        this.zzbes = this.zzbea.readUnsignedByte();
        return (this.zzbes & PsExtractor.VIDEO_STREAM_MASK) >> 4;
    }
}
