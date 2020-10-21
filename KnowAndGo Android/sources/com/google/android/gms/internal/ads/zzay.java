package com.google.android.gms.internal.ads;

import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class zzay implements zzba {
    private static Logger zzcn = Logger.getLogger(zzay.class.getName());
    private ThreadLocal<ByteBuffer> zzco = new zzaz(this);

    public abstract zzbd zza(String str, byte[] bArr, String str2);

    public final zzbd zza(zzdsw zzdsw, zzbe zzbe) throws IOException {
        int read;
        long j;
        zzdsw zzdsw2 = zzdsw;
        zzbe zzbe2 = zzbe;
        long position = zzdsw.position();
        this.zzco.get().rewind().limit(8);
        do {
            read = zzdsw2.read(this.zzco.get());
            if (read == 8) {
                this.zzco.get().rewind();
                long zza = zzbc.zza(this.zzco.get());
                byte[] bArr = null;
                if (zza >= 8 || zza <= 1) {
                    String zzf = zzbc.zzf(this.zzco.get());
                    if (zza == 1) {
                        this.zzco.get().limit(16);
                        zzdsw2.read(this.zzco.get());
                        this.zzco.get().position(8);
                        j = zzbc.zzc(this.zzco.get()) - 16;
                    } else {
                        j = zza == 0 ? zzdsw.size() - zzdsw.position() : zza - 8;
                    }
                    if ("uuid".equals(zzf)) {
                        this.zzco.get().limit(this.zzco.get().limit() + 16);
                        zzdsw2.read(this.zzco.get());
                        bArr = new byte[16];
                        for (int position2 = this.zzco.get().position() - 16; position2 < this.zzco.get().position(); position2++) {
                            bArr[position2 - (this.zzco.get().position() - 16)] = this.zzco.get().get(position2);
                        }
                        j -= 16;
                    }
                    long j2 = j;
                    zzbd zza2 = zza(zzf, bArr, zzbe2 instanceof zzbd ? ((zzbd) zzbe2).getType() : "");
                    zza2.zza(zzbe2);
                    this.zzco.get().rewind();
                    zza2.zza(zzdsw, this.zzco.get(), j2, this);
                    return zza2;
                }
                Logger logger = zzcn;
                Level level = Level.SEVERE;
                StringBuilder sb = new StringBuilder(80);
                sb.append("Plausibility check failed: size < 8 (size = ");
                sb.append(zza);
                sb.append("). Stop parsing!");
                logger.logp(level, "com.coremedia.iso.AbstractBoxParser", "parseBox", sb.toString());
                return null;
            }
        } while (read >= 0);
        zzdsw2.zzff(position);
        throw new EOFException();
    }
}
