package com.google.android.gms.internal.ads;

import java.io.IOException;

public abstract class zzdnd {
    int zzhcz;
    int zzhda;
    private int zzhdb;
    zzdng zzhdc;
    private boolean zzhdd;

    static zzdnd zzc(byte[] bArr, int i, int i2, boolean z) {
        zzdnf zzdnf = new zzdnf(bArr, i, i2, z);
        try {
            zzdnf.zzfr(i2);
            return zzdnf;
        } catch (zzdok e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static long zzfi(long j) {
        return (-(j & 1)) ^ (j >>> 1);
    }

    public static int zzft(int i) {
        return (-(i & 1)) ^ (i >>> 1);
    }

    public abstract double readDouble() throws IOException;

    public abstract float readFloat() throws IOException;

    public abstract String readString() throws IOException;

    public abstract int zzavu() throws IOException;

    public abstract long zzavv() throws IOException;

    public abstract long zzavw() throws IOException;

    public abstract int zzavx() throws IOException;

    public abstract long zzavy() throws IOException;

    public abstract int zzavz() throws IOException;

    public abstract boolean zzawa() throws IOException;

    public abstract String zzawb() throws IOException;

    public abstract zzdmr zzawc() throws IOException;

    public abstract int zzawd() throws IOException;

    public abstract int zzawe() throws IOException;

    public abstract int zzawf() throws IOException;

    public abstract long zzawg() throws IOException;

    public abstract int zzawh() throws IOException;

    public abstract long zzawi() throws IOException;

    /* access modifiers changed from: package-private */
    public abstract long zzawj() throws IOException;

    public abstract boolean zzawk() throws IOException;

    public abstract int zzawl();

    public abstract void zzfp(int i) throws zzdok;

    public abstract boolean zzfq(int i) throws IOException;

    public abstract int zzfr(int i) throws zzdok;

    public abstract void zzfs(int i);

    private zzdnd() {
        this.zzhda = 100;
        this.zzhdb = Integer.MAX_VALUE;
        this.zzhdd = false;
    }
}
