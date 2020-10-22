package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Stack;
import kotlin.UByte;

final class zzny implements zzob {
    private final byte[] zzanf = new byte[8];
    private final Stack<zzoa> zzang = new Stack<>();
    private int zzanj;
    private int zzank;
    private long zzanl;
    private final zzoi zzazr = new zzoi();
    private zzoc zzazs;

    zzny() {
    }

    public final void zza(zzoc zzoc) {
        this.zzazs = zzoc;
    }

    public final void reset() {
        this.zzanj = 0;
        this.zzang.clear();
        this.zzazr.reset();
    }

    public final boolean zzb(zzno zzno) throws IOException, InterruptedException {
        String str;
        double d;
        zzsk.checkState(this.zzazs != null);
        while (true) {
            if (this.zzang.isEmpty() || zzno.getPosition() < this.zzang.peek().zzanm) {
                if (this.zzanj == 0) {
                    long zza = this.zzazr.zza(zzno, true, false, 4);
                    if (zza == -2) {
                        zzno.zzig();
                        while (true) {
                            zzno.zzc(this.zzanf, 0, 4);
                            int zzaw = zzoi.zzaw(this.zzanf[0]);
                            if (zzaw != -1 && zzaw <= 4) {
                                int zza2 = (int) zzoi.zza(this.zzanf, zzaw, false);
                                if (this.zzazs.zzav(zza2)) {
                                    zzno.zzr(zzaw);
                                    zza = (long) zza2;
                                }
                            }
                            zzno.zzr(1);
                        }
                    }
                    if (zza == -1) {
                        return false;
                    }
                    this.zzank = (int) zza;
                    this.zzanj = 1;
                }
                if (this.zzanj == 1) {
                    this.zzanl = this.zzazr.zza(zzno, false, true, 8);
                    this.zzanj = 2;
                }
                int zzx = this.zzazs.zzx(this.zzank);
                switch (zzx) {
                    case 0:
                        zzno.zzr((int) this.zzanl);
                        this.zzanj = 0;
                    case 1:
                        long position = zzno.getPosition();
                        this.zzang.add(new zzoa(this.zzank, this.zzanl + position));
                        this.zzazs.zzb(this.zzank, position, this.zzanl);
                        this.zzanj = 0;
                        return true;
                    case 2:
                        if (this.zzanl <= 8) {
                            this.zzazs.zzc(this.zzank, zza(zzno, (int) this.zzanl));
                            this.zzanj = 0;
                            return true;
                        }
                        long j = this.zzanl;
                        StringBuilder sb = new StringBuilder(42);
                        sb.append("Invalid integer size: ");
                        sb.append(j);
                        throw new zzlm(sb.toString());
                    case 3:
                        if (this.zzanl <= 2147483647L) {
                            zzoc zzoc = this.zzazs;
                            int i = this.zzank;
                            int i2 = (int) this.zzanl;
                            if (i2 == 0) {
                                str = "";
                            } else {
                                byte[] bArr = new byte[i2];
                                zzno.readFully(bArr, 0, i2);
                                str = new String(bArr);
                            }
                            zzoc.zza(i, str);
                            this.zzanj = 0;
                            return true;
                        }
                        long j2 = this.zzanl;
                        StringBuilder sb2 = new StringBuilder(41);
                        sb2.append("String element size: ");
                        sb2.append(j2);
                        throw new zzlm(sb2.toString());
                    case 4:
                        this.zzazs.zza(this.zzank, (int) this.zzanl, zzno);
                        this.zzanj = 0;
                        return true;
                    case 5:
                        if (this.zzanl == 4 || this.zzanl == 8) {
                            zzoc zzoc2 = this.zzazs;
                            int i3 = this.zzank;
                            int i4 = (int) this.zzanl;
                            long zza3 = zza(zzno, i4);
                            if (i4 == 4) {
                                d = (double) Float.intBitsToFloat((int) zza3);
                            } else {
                                d = Double.longBitsToDouble(zza3);
                            }
                            zzoc2.zza(i3, d);
                            this.zzanj = 0;
                            return true;
                        }
                        long j3 = this.zzanl;
                        StringBuilder sb3 = new StringBuilder(40);
                        sb3.append("Invalid float size: ");
                        sb3.append(j3);
                        throw new zzlm(sb3.toString());
                    default:
                        StringBuilder sb4 = new StringBuilder(32);
                        sb4.append("Invalid element type ");
                        sb4.append(zzx);
                        throw new zzlm(sb4.toString());
                }
            } else {
                this.zzazs.zzy(this.zzang.pop().zzank);
                return true;
            }
        }
    }

    private final long zza(zzno zzno, int i) throws IOException, InterruptedException {
        zzno.readFully(this.zzanf, 0, i);
        long j = 0;
        for (int i2 = 0; i2 < i; i2++) {
            j = (j << 8) | ((long) (this.zzanf[i2] & UByte.MAX_VALUE));
        }
        return j;
    }
}
