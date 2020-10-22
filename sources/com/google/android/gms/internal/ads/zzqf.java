package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.io.EOFException;
import java.io.IOException;

final class zzqf {
    private final zznp zzbbf;
    private final zznn[] zzbix;
    private zznn zzbiy;

    public zzqf(zznn[] zznnArr, zznp zznp) {
        this.zzbix = zznnArr;
        this.zzbbf = zznp;
    }

    public final zznn zza(zzno zzno, Uri uri) throws IOException, InterruptedException {
        if (this.zzbiy != null) {
            return this.zzbiy;
        }
        zznn[] zznnArr = this.zzbix;
        int length = zznnArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            zznn zznn = zznnArr[i];
            try {
                if (zznn.zza(zzno)) {
                    this.zzbiy = zznn;
                    zzno.zzig();
                    break;
                }
                i++;
            } catch (EOFException unused) {
            } finally {
                zzno.zzig();
            }
        }
        if (this.zzbiy != null) {
            this.zzbiy.zza(this.zzbbf);
            return this.zzbiy;
        }
        String zza = zzsy.zza((Object[]) this.zzbix);
        StringBuilder sb = new StringBuilder(String.valueOf(zza).length() + 58);
        sb.append("None of the available extractors (");
        sb.append(zza);
        sb.append(") could read the stream.");
        throw new zzrc(sb.toString(), uri);
    }

    public final void release() {
        if (this.zzbiy != null) {
            this.zzbiy.release();
            this.zzbiy = null;
        }
    }
}
