package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.C1470C;

public final class zzqz extends zzlr {
    private static final Object zzbkr = new Object();
    private final boolean zzaus;
    private final boolean zzaut;
    private final long zzbks;
    private final long zzbkt;
    private final long zzbku;
    private final long zzbkv;

    public zzqz(long j, boolean z) {
        this(j, j, 0, 0, z, false);
    }

    public final int zzhf() {
        return 1;
    }

    public final int zzhg() {
        return 1;
    }

    private zzqz(long j, long j2, long j3, long j4, boolean z, boolean z2) {
        this.zzbks = j;
        this.zzbkt = j2;
        this.zzbku = 0;
        this.zzbkv = 0;
        this.zzaus = z;
        this.zzaut = false;
    }

    public final zzlu zza(int i, zzlu zzlu, boolean z, long j) {
        zzsk.zzc(i, 0, 1);
        boolean z2 = this.zzaus;
        long j2 = this.zzbkt;
        zzlu.zzaun = null;
        zzlu.zzauq = C1470C.TIME_UNSET;
        zzlu.zzaur = C1470C.TIME_UNSET;
        zzlu.zzaus = z2;
        zzlu.zzaut = false;
        zzlu.zzauw = 0;
        zzlu.zzack = j2;
        zzlu.zzauu = 0;
        zzlu.zzauv = 0;
        zzlu.zzaux = 0;
        return zzlu;
    }

    public final zzlt zza(int i, zzlt zzlt, boolean z) {
        zzsk.zzc(i, 0, 1);
        Object obj = z ? zzbkr : null;
        return zzlt.zza(obj, obj, 0, this.zzbks, 0, false);
    }

    public final int zzc(Object obj) {
        return zzbkr.equals(obj) ? 0 : -1;
    }
}
