package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Stack;
import kotlin.UByte;

final class zzja implements zzjd {
    private final byte[] zzanf = new byte[8];
    private final Stack<zzjc> zzang = new Stack<>();
    private final zzjf zzanh = new zzjf();
    private zzje zzani;
    private int zzanj;
    private int zzank;
    private long zzanl;

    zzja() {
    }

    public final void zza(zzje zzje) {
        this.zzani = zzje;
    }

    public final void reset() {
        this.zzanj = 0;
        this.zzang.clear();
        this.zzanh.reset();
    }

    public final boolean zza(zzie zzie) throws IOException, InterruptedException {
        double d;
        zzkh.checkState(this.zzani != null);
        while (true) {
            if (this.zzang.isEmpty() || zzie.getPosition() < this.zzang.peek().zzanm) {
                if (this.zzanj == 0) {
                    long zza = this.zzanh.zza(zzie, true, false);
                    if (zza == -1) {
                        return false;
                    }
                    this.zzank = (int) zza;
                    this.zzanj = 1;
                }
                if (this.zzanj == 1) {
                    this.zzanl = this.zzanh.zza(zzie, false, true);
                    this.zzanj = 2;
                }
                int zzx = this.zzani.zzx(this.zzank);
                switch (zzx) {
                    case 0:
                        zzie.zzr((int) this.zzanl);
                        this.zzanj = 0;
                    case 1:
                        long position = zzie.getPosition();
                        this.zzang.add(new zzjc(this.zzank, this.zzanl + position));
                        this.zzani.zzb(this.zzank, position, this.zzanl);
                        this.zzanj = 0;
                        return true;
                    case 2:
                        if (this.zzanl <= 8) {
                            this.zzani.zzc(this.zzank, zzc(zzie, (int) this.zzanl));
                            this.zzanj = 0;
                            return true;
                        }
                        long j = this.zzanl;
                        StringBuilder sb = new StringBuilder(42);
                        sb.append("Invalid integer size: ");
                        sb.append(j);
                        throw new IllegalStateException(sb.toString());
                    case 3:
                        if (this.zzanl <= 2147483647L) {
                            zzje zzje = this.zzani;
                            int i = this.zzank;
                            int i2 = (int) this.zzanl;
                            byte[] bArr = new byte[i2];
                            zzie.readFully(bArr, 0, i2);
                            zzje.zza(i, new String(bArr, Charset.forName("UTF-8")));
                            this.zzanj = 0;
                            return true;
                        }
                        long j2 = this.zzanl;
                        StringBuilder sb2 = new StringBuilder(41);
                        sb2.append("String element size: ");
                        sb2.append(j2);
                        throw new IllegalStateException(sb2.toString());
                    case 4:
                        this.zzani.zza(this.zzank, (int) this.zzanl, zzie);
                        this.zzanj = 0;
                        return true;
                    case 5:
                        if (this.zzanl == 4 || this.zzanl == 8) {
                            zzje zzje2 = this.zzani;
                            int i3 = this.zzank;
                            int i4 = (int) this.zzanl;
                            long zzc = zzc(zzie, i4);
                            if (i4 == 4) {
                                d = (double) Float.intBitsToFloat((int) zzc);
                            } else {
                                d = Double.longBitsToDouble(zzc);
                            }
                            zzje2.zza(i3, d);
                            this.zzanj = 0;
                            return true;
                        }
                        long j3 = this.zzanl;
                        StringBuilder sb3 = new StringBuilder(40);
                        sb3.append("Invalid float size: ");
                        sb3.append(j3);
                        throw new IllegalStateException(sb3.toString());
                    default:
                        StringBuilder sb4 = new StringBuilder(32);
                        sb4.append("Invalid element type ");
                        sb4.append(zzx);
                        throw new IllegalStateException(sb4.toString());
                }
            } else {
                this.zzani.zzy(this.zzang.pop().zzank);
                return true;
            }
        }
    }

    private final long zzc(zzie zzie, int i) throws IOException, InterruptedException {
        zzie.readFully(this.zzanf, 0, i);
        long j = 0;
        for (int i2 = 0; i2 < i; i2++) {
            j = (j << 8) | ((long) (this.zzanf[i2] & UByte.MAX_VALUE));
        }
        return j;
    }
}
