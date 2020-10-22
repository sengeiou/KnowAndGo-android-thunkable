package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.ByteBuffer;

public class zzdss extends zzdsu implements zzbd {
    private String type;
    private long zzajx;
    private zzbe zzhth;
    private boolean zzhtp;

    public zzdss(String str) {
        this.type = str;
    }

    public final void zza(zzbe zzbe) {
        this.zzhth = zzbe;
    }

    public final String getType() {
        return this.type;
    }

    public final void zza(zzdsw zzdsw, ByteBuffer byteBuffer, long j, zzba zzba) throws IOException {
        this.zzajx = zzdsw.position() - ((long) byteBuffer.remaining());
        this.zzhtp = byteBuffer.remaining() == 16;
        zza(zzdsw, j, zzba);
    }

    public final void zza(zzdsw zzdsw, long j, zzba zzba) throws IOException {
        this.zzhtn = zzdsw;
        this.zzhtt = zzdsw.position();
        this.zzbkn = this.zzhtt - ((long) ((this.zzhtp || 8 + j >= 4294967296L) ? 16 : 8));
        zzdsw.zzff(zzdsw.position() + j);
        this.zzbdz = zzdsw.position();
        this.zzhtr = zzba;
    }
}
