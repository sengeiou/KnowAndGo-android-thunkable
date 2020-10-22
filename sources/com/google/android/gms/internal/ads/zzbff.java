package com.google.android.gms.internal.ads;

final /* synthetic */ class zzbff implements zzrw {
    private final zzrw zzehj;
    private final byte[] zzehk;

    zzbff(zzrw zzrw, byte[] bArr) {
        this.zzehj = zzrw;
        this.zzehk = bArr;
    }

    public final zzrv zzju() {
        zzrw zzrw = this.zzehj;
        byte[] bArr = this.zzehk;
        return new zzbfj(new zzru(bArr), bArr.length, zzrw.zzju());
    }
}
