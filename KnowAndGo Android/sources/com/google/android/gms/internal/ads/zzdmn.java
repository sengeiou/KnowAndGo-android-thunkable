package com.google.android.gms.internal.ads;

import java.io.IOException;
import kotlin.UByte;
import kotlin.jvm.internal.ByteCompanionObject;

final class zzdmn {
    static int zza(byte[] bArr, int i, zzdmo zzdmo) {
        int i2 = i + 1;
        byte b = bArr[i];
        if (b < 0) {
            return zza((int) b, bArr, i2, zzdmo);
        }
        zzdmo.zzhcl = b;
        return i2;
    }

    static int zza(int i, byte[] bArr, int i2, zzdmo zzdmo) {
        int i3 = i & 127;
        int i4 = i2 + 1;
        byte b = bArr[i2];
        if (b >= 0) {
            zzdmo.zzhcl = i3 | (b << 7);
            return i4;
        }
        int i5 = i3 | ((b & ByteCompanionObject.MAX_VALUE) << 7);
        int i6 = i4 + 1;
        byte b2 = bArr[i4];
        if (b2 >= 0) {
            zzdmo.zzhcl = i5 | (b2 << 14);
            return i6;
        }
        int i7 = i5 | ((b2 & ByteCompanionObject.MAX_VALUE) << 14);
        int i8 = i6 + 1;
        byte b3 = bArr[i6];
        if (b3 >= 0) {
            zzdmo.zzhcl = i7 | (b3 << 21);
            return i8;
        }
        int i9 = i7 | ((b3 & ByteCompanionObject.MAX_VALUE) << 21);
        int i10 = i8 + 1;
        byte b4 = bArr[i8];
        if (b4 >= 0) {
            zzdmo.zzhcl = i9 | (b4 << 28);
            return i10;
        }
        int i11 = i9 | ((b4 & ByteCompanionObject.MAX_VALUE) << 28);
        while (true) {
            int i12 = i10 + 1;
            if (bArr[i10] >= 0) {
                zzdmo.zzhcl = i11;
                return i12;
            }
            i10 = i12;
        }
    }

    static int zzb(byte[] bArr, int i, zzdmo zzdmo) {
        int i2 = i + 1;
        long j = (long) bArr[i];
        if (j >= 0) {
            zzdmo.zzhcm = j;
            return i2;
        }
        int i3 = i2 + 1;
        byte b = bArr[i2];
        long j2 = (j & 127) | (((long) (b & ByteCompanionObject.MAX_VALUE)) << 7);
        int i4 = 7;
        while (b < 0) {
            int i5 = i3 + 1;
            byte b2 = bArr[i3];
            i4 += 7;
            j2 |= ((long) (b2 & ByteCompanionObject.MAX_VALUE)) << i4;
            int i6 = i5;
            b = b2;
            i3 = i6;
        }
        zzdmo.zzhcm = j2;
        return i3;
    }

    static int zzf(byte[] bArr, int i) {
        return ((bArr[i + 3] & UByte.MAX_VALUE) << 24) | (bArr[i] & UByte.MAX_VALUE) | ((bArr[i + 1] & UByte.MAX_VALUE) << 8) | ((bArr[i + 2] & UByte.MAX_VALUE) << 16);
    }

    static long zzg(byte[] bArr, int i) {
        return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
    }

    static double zzh(byte[] bArr, int i) {
        return Double.longBitsToDouble(zzg(bArr, i));
    }

    static float zzi(byte[] bArr, int i) {
        return Float.intBitsToFloat(zzf(bArr, i));
    }

    static int zzc(byte[] bArr, int i, zzdmo zzdmo) throws zzdok {
        int zza = zza(bArr, i, zzdmo);
        int i2 = zzdmo.zzhcl;
        if (i2 < 0) {
            throw zzdok.zzaye();
        } else if (i2 == 0) {
            zzdmo.zzhcn = "";
            return zza;
        } else {
            zzdmo.zzhcn = new String(bArr, zza, i2, zzdod.UTF_8);
            return zza + i2;
        }
    }

    static int zzd(byte[] bArr, int i, zzdmo zzdmo) throws zzdok {
        int zza = zza(bArr, i, zzdmo);
        int i2 = zzdmo.zzhcl;
        if (i2 < 0) {
            throw zzdok.zzaye();
        } else if (i2 == 0) {
            zzdmo.zzhcn = "";
            return zza;
        } else {
            zzdmo.zzhcn = zzdrb.zzn(bArr, zza, i2);
            return zza + i2;
        }
    }

    static int zze(byte[] bArr, int i, zzdmo zzdmo) throws zzdok {
        int zza = zza(bArr, i, zzdmo);
        int i2 = zzdmo.zzhcl;
        if (i2 < 0) {
            throw zzdok.zzaye();
        } else if (i2 > bArr.length - zza) {
            throw zzdok.zzayd();
        } else if (i2 == 0) {
            zzdmo.zzhcn = zzdmr.zzhcr;
            return zza;
        } else {
            zzdmo.zzhcn = zzdmr.zzi(bArr, zza, i2);
            return zza + i2;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v6, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static int zza(com.google.android.gms.internal.ads.zzdqb r6, byte[] r7, int r8, int r9, com.google.android.gms.internal.ads.zzdmo r10) throws java.io.IOException {
        /*
            int r0 = r8 + 1
            byte r8 = r7[r8]
            if (r8 >= 0) goto L_0x000c
            int r0 = zza((int) r8, (byte[]) r7, (int) r0, (com.google.android.gms.internal.ads.zzdmo) r10)
            int r8 = r10.zzhcl
        L_0x000c:
            r3 = r0
            if (r8 < 0) goto L_0x0025
            int r9 = r9 - r3
            if (r8 > r9) goto L_0x0025
            java.lang.Object r9 = r6.newInstance()
            int r8 = r8 + r3
            r0 = r6
            r1 = r9
            r2 = r7
            r4 = r8
            r5 = r10
            r0.zza(r1, r2, r3, r4, r5)
            r6.zzaa(r9)
            r10.zzhcn = r9
            return r8
        L_0x0025:
            com.google.android.gms.internal.ads.zzdok r6 = com.google.android.gms.internal.ads.zzdok.zzayd()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdmn.zza(com.google.android.gms.internal.ads.zzdqb, byte[], int, int, com.google.android.gms.internal.ads.zzdmo):int");
    }

    static int zza(zzdqb zzdqb, byte[] bArr, int i, int i2, int i3, zzdmo zzdmo) throws IOException {
        zzdpo zzdpo = (zzdpo) zzdqb;
        Object newInstance = zzdpo.newInstance();
        int zza = zzdpo.zza(newInstance, bArr, i, i2, i3, zzdmo);
        zzdpo.zzaa(newInstance);
        zzdmo.zzhcn = newInstance;
        return zza;
    }

    static int zza(int i, byte[] bArr, int i2, int i3, zzdoj<?> zzdoj, zzdmo zzdmo) {
        zzdoc zzdoc = (zzdoc) zzdoj;
        int zza = zza(bArr, i2, zzdmo);
        zzdoc.zzgp(zzdmo.zzhcl);
        while (zza < i3) {
            int zza2 = zza(bArr, zza, zzdmo);
            if (i != zzdmo.zzhcl) {
                break;
            }
            zza = zza(bArr, zza2, zzdmo);
            zzdoc.zzgp(zzdmo.zzhcl);
        }
        return zza;
    }

    static int zza(byte[] bArr, int i, zzdoj<?> zzdoj, zzdmo zzdmo) throws IOException {
        zzdoc zzdoc = (zzdoc) zzdoj;
        int zza = zza(bArr, i, zzdmo);
        int i2 = zzdmo.zzhcl + zza;
        while (zza < i2) {
            zza = zza(bArr, zza, zzdmo);
            zzdoc.zzgp(zzdmo.zzhcl);
        }
        if (zza == i2) {
            return zza;
        }
        throw zzdok.zzayd();
    }

    static int zza(zzdqb<?> zzdqb, int i, byte[] bArr, int i2, int i3, zzdoj<?> zzdoj, zzdmo zzdmo) throws IOException {
        int zza = zza((zzdqb) zzdqb, bArr, i2, i3, zzdmo);
        zzdoj.add(zzdmo.zzhcn);
        while (zza < i3) {
            int zza2 = zza(bArr, zza, zzdmo);
            if (i != zzdmo.zzhcl) {
                break;
            }
            zza = zza((zzdqb) zzdqb, bArr, zza2, i3, zzdmo);
            zzdoj.add(zzdmo.zzhcn);
        }
        return zza;
    }

    static int zza(int i, byte[] bArr, int i2, int i3, zzdqu zzdqu, zzdmo zzdmo) throws zzdok {
        if ((i >>> 3) != 0) {
            int i4 = i & 7;
            if (i4 != 5) {
                switch (i4) {
                    case 0:
                        int zzb = zzb(bArr, i2, zzdmo);
                        zzdqu.zzc(i, Long.valueOf(zzdmo.zzhcm));
                        return zzb;
                    case 1:
                        zzdqu.zzc(i, Long.valueOf(zzg(bArr, i2)));
                        return i2 + 8;
                    case 2:
                        int zza = zza(bArr, i2, zzdmo);
                        int i5 = zzdmo.zzhcl;
                        if (i5 < 0) {
                            throw zzdok.zzaye();
                        } else if (i5 <= bArr.length - zza) {
                            if (i5 == 0) {
                                zzdqu.zzc(i, zzdmr.zzhcr);
                            } else {
                                zzdqu.zzc(i, zzdmr.zzi(bArr, zza, i5));
                            }
                            return zza + i5;
                        } else {
                            throw zzdok.zzayd();
                        }
                    case 3:
                        zzdqu zzbaa = zzdqu.zzbaa();
                        int i6 = (i & -8) | 4;
                        int i7 = 0;
                        while (true) {
                            if (i2 < i3) {
                                int zza2 = zza(bArr, i2, zzdmo);
                                int i8 = zzdmo.zzhcl;
                                if (i8 != i6) {
                                    i7 = i8;
                                    i2 = zza(i8, bArr, zza2, i3, zzbaa, zzdmo);
                                } else {
                                    i7 = i8;
                                    i2 = zza2;
                                }
                            }
                        }
                        if (i2 > i3 || i7 != i6) {
                            throw zzdok.zzayj();
                        }
                        zzdqu.zzc(i, zzbaa);
                        return i2;
                    default:
                        throw zzdok.zzayg();
                }
            } else {
                zzdqu.zzc(i, Integer.valueOf(zzf(bArr, i2)));
                return i2 + 4;
            }
        } else {
            throw zzdok.zzayg();
        }
    }

    static int zza(int i, byte[] bArr, int i2, int i3, zzdmo zzdmo) throws zzdok {
        if ((i >>> 3) != 0) {
            int i4 = i & 7;
            if (i4 == 5) {
                return i2 + 4;
            }
            switch (i4) {
                case 0:
                    return zzb(bArr, i2, zzdmo);
                case 1:
                    return i2 + 8;
                case 2:
                    return zza(bArr, i2, zzdmo) + zzdmo.zzhcl;
                case 3:
                    int i5 = (i & -8) | 4;
                    int i6 = 0;
                    while (i2 < i3) {
                        i2 = zza(bArr, i2, zzdmo);
                        i6 = zzdmo.zzhcl;
                        if (i6 != i5) {
                            i2 = zza(i6, bArr, i2, i3, zzdmo);
                        } else if (i2 > i3 && i6 == i5) {
                            return i2;
                        } else {
                            throw zzdok.zzayj();
                        }
                    }
                    if (i2 > i3) {
                    }
                    throw zzdok.zzayj();
                default:
                    throw zzdok.zzayg();
            }
        } else {
            throw zzdok.zzayg();
        }
    }
}
