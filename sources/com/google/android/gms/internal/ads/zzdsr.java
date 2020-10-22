package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.ByteBuffer;

public abstract class zzdsr implements zzbd {
    private static zzdtc zzcp = zzdtc.zzm(zzdsr.class);
    private String type;
    private long zzajx;
    private zzbe zzhth;
    boolean zzhti;
    private boolean zzhtj;
    private ByteBuffer zzhtk;
    private long zzhtl;
    private long zzhtm = -1;
    private zzdsw zzhtn;
    private ByteBuffer zzhto = null;

    private final synchronized void zzbbb() {
        if (!this.zzhtj) {
            try {
                zzdtc zzdtc = zzcp;
                String valueOf = String.valueOf(this.type);
                zzdtc.zzhc(valueOf.length() != 0 ? "mem mapping ".concat(valueOf) : new String("mem mapping "));
                this.zzhtk = this.zzhtn.zzi(this.zzhtl, this.zzhtm);
                this.zzhtj = true;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /* access modifiers changed from: protected */
    public abstract void zzg(ByteBuffer byteBuffer);

    protected zzdsr(String str) {
        this.type = str;
        this.zzhtj = true;
        this.zzhti = true;
    }

    public final void zza(zzdsw zzdsw, ByteBuffer byteBuffer, long j, zzba zzba) throws IOException {
        this.zzhtl = zzdsw.position();
        this.zzajx = this.zzhtl - ((long) byteBuffer.remaining());
        this.zzhtm = j;
        this.zzhtn = zzdsw;
        zzdsw.zzff(zzdsw.position() + j);
        this.zzhtj = false;
        this.zzhti = false;
        zzbbc();
    }

    public final synchronized void zzbbc() {
        zzbbb();
        zzdtc zzdtc = zzcp;
        String valueOf = String.valueOf(this.type);
        zzdtc.zzhc(valueOf.length() != 0 ? "parsing details of ".concat(valueOf) : new String("parsing details of "));
        if (this.zzhtk != null) {
            ByteBuffer byteBuffer = this.zzhtk;
            this.zzhti = true;
            byteBuffer.rewind();
            zzg(byteBuffer);
            if (byteBuffer.remaining() > 0) {
                this.zzhto = byteBuffer.slice();
            }
            this.zzhtk = null;
        }
    }

    public final String getType() {
        return this.type;
    }

    public final void zza(zzbe zzbe) {
        this.zzhth = zzbe;
    }
}
