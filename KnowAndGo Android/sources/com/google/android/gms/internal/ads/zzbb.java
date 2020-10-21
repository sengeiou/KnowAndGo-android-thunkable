package com.google.android.gms.internal.ads;

import java.io.Closeable;
import java.io.IOException;

public class zzbb extends zzdsu implements Closeable {
    private static zzdtc zzcp = zzdtc.zzm(zzbb.class);

    public zzbb(zzdsw zzdsw, zzba zzba) throws IOException {
        zza(zzdsw, zzdsw.size(), zzba);
    }

    public void close() throws IOException {
        this.zzhtn.close();
    }

    public String toString() {
        String obj = this.zzhtn.toString();
        StringBuilder sb = new StringBuilder(String.valueOf(obj).length() + 7);
        sb.append("model(");
        sb.append(obj);
        sb.append(")");
        return sb.toString();
    }
}
