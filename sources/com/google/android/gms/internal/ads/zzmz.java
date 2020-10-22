package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.MediaCodec;

public final class zzmz {

    /* renamed from: iv */
    public byte[] f183iv;
    private byte[] key;
    private int mode;
    public int[] numBytesOfClearData;
    public int[] numBytesOfEncryptedData;
    private int numSubSamples;
    private final MediaCodec.CryptoInfo zzabn;
    private int zzayw;
    private int zzayx;
    private final zznb zzayy;

    public zzmz() {
        this.zzabn = zzsy.SDK_INT >= 16 ? new MediaCodec.CryptoInfo() : null;
        this.zzayy = zzsy.SDK_INT >= 24 ? new zznb(this.zzabn) : null;
    }

    public final void set(int i, int[] iArr, int[] iArr2, byte[] bArr, byte[] bArr2, int i2) {
        this.numSubSamples = i;
        this.numBytesOfClearData = iArr;
        this.numBytesOfEncryptedData = iArr2;
        this.key = bArr;
        this.f183iv = bArr2;
        this.mode = i2;
        this.zzayw = 0;
        this.zzayx = 0;
        if (zzsy.SDK_INT >= 16) {
            this.zzabn.numSubSamples = this.numSubSamples;
            this.zzabn.numBytesOfClearData = this.numBytesOfClearData;
            this.zzabn.numBytesOfEncryptedData = this.numBytesOfEncryptedData;
            this.zzabn.key = this.key;
            this.zzabn.iv = this.f183iv;
            this.zzabn.mode = this.mode;
            if (zzsy.SDK_INT >= 24) {
                this.zzayy.set(0, 0);
            }
        }
    }

    @TargetApi(16)
    public final MediaCodec.CryptoInfo zzdl() {
        return this.zzabn;
    }
}
