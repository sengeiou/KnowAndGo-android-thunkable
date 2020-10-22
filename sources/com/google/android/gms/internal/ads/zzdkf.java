package com.google.android.gms.internal.ads;

public final class zzdkf {
    private final zzdlj zzgyw;
    private final zzdlj zzgyx;

    public zzdkf(byte[] bArr, byte[] bArr2) {
        this.zzgyw = zzdlj.zzv(bArr);
        this.zzgyx = zzdlj.zzv(bArr2);
    }

    public final byte[] zzauw() {
        if (this.zzgyw == null) {
            return null;
        }
        return this.zzgyw.getBytes();
    }

    public final byte[] zzaux() {
        if (this.zzgyx == null) {
            return null;
        }
        return this.zzgyx.getBytes();
    }
}
