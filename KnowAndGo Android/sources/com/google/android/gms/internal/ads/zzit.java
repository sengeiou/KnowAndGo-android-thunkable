package com.google.android.gms.internal.ads;

import android.util.Pair;
import com.google.android.exoplayer2.util.MimeTypes;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

final class zzit {
    public static zzix zza(zzir zzir, zzis zzis) {
        boolean z;
        boolean z2;
        long j;
        long j2;
        int i;
        int i2;
        int i3;
        String str;
        List list;
        boolean z3;
        zzir zzir2 = zzir;
        zzir zzw = zzir2.zzw(zziq.zzakr);
        zzkm zzkm = zzw.zzv(zziq.zzala).zzamc;
        zzkm.setPosition(16);
        int readInt = zzkm.readInt();
        if (readInt != 1936684398 && readInt != 1986618469 && readInt != 1952807028 && readInt != 1953325924) {
            return null;
        }
        zzkm zzkm2 = zzir2.zzv(zziq.zzaky).zzamc;
        int i4 = 8;
        zzkm2.setPosition(8);
        int zzt = zziq.zzt(zzkm2.readInt());
        zzkm2.zzac(zzt == 0 ? 8 : 16);
        int readInt2 = zzkm2.readInt();
        zzkm2.zzac(4);
        int position = zzkm2.getPosition();
        int i5 = zzt == 0 ? 4 : 8;
        int i6 = 0;
        while (true) {
            z = true;
            if (i6 >= i5) {
                z2 = true;
                break;
            } else if (zzkm2.data[position + i6] != -1) {
                z2 = false;
                break;
            } else {
                i6++;
            }
        }
        if (z2) {
            zzkm2.zzac(i5);
            j = -1;
        } else {
            j = zzt == 0 ? zzkm2.zzge() : zzkm2.zzgh();
        }
        Pair create = Pair.create(Integer.valueOf(readInt2), Long.valueOf(j));
        int intValue = ((Integer) create.first).intValue();
        long longValue = ((Long) create.second).longValue();
        zzkm zzkm3 = zzis.zzamc;
        zzkm3.setPosition(8);
        zzkm3.zzac(zziq.zzt(zzkm3.readInt()) == 0 ? 8 : 16);
        long zzge = zzkm3.zzge();
        if (longValue == -1) {
            j2 = -1;
        } else {
            j2 = zzkq.zza(longValue, 1000000, zzge);
        }
        zzir zzw2 = zzw.zzw(zziq.zzaks).zzw(zziq.zzakt);
        zzkm zzkm4 = zzw.zzv(zziq.zzakz).zzamc;
        zzkm4.setPosition(8);
        if (zziq.zzt(zzkm4.readInt()) != 0) {
            i4 = 16;
        }
        zzkm4.zzac(i4);
        long zzge2 = zzkm4.zzge();
        zzkm zzkm5 = zzw2.zzv(zziq.zzalb).zzamc;
        zzkm5.setPosition(12);
        int readInt3 = zzkm5.readInt();
        zziu zziu = new zziu(readInt3);
        int i7 = 0;
        while (i7 < readInt3) {
            int position2 = zzkm5.getPosition();
            int readInt4 = zzkm5.readInt();
            zzkh.checkArgument(readInt4 > 0, "childAtomSize should be positive");
            int readInt5 = zzkm5.readInt();
            if (readInt5 == zziq.zzaka || readInt5 == zziq.zzakb || readInt5 == zziq.zzalh) {
                i2 = readInt3;
                i = readInt;
                i3 = readInt4;
                zzkm5.setPosition(position2 + 8);
                zzkm5.zzac(24);
                int readUnsignedShort = zzkm5.readUnsignedShort();
                int readUnsignedShort2 = zzkm5.readUnsignedShort();
                zzkm5.zzac(50);
                int position3 = zzkm5.getPosition();
                float f = 1.0f;
                List list2 = null;
                while (position3 - position2 < i3) {
                    zzkm5.setPosition(position3);
                    int position4 = zzkm5.getPosition();
                    int readInt6 = zzkm5.readInt();
                    if (readInt6 == 0 && zzkm5.getPosition() - position2 == i3) {
                        break;
                    }
                    zzkh.checkArgument(readInt6 > 0, "childAtomSize should be positive");
                    int readInt7 = zzkm5.readInt();
                    if (readInt7 == zziq.zzaku) {
                        zzkm5.setPosition(position4 + 8 + 4);
                        int readUnsignedByte = (zzkm5.readUnsignedByte() & 3) + 1;
                        if (readUnsignedByte != 3) {
                            ArrayList arrayList = new ArrayList();
                            int readUnsignedByte2 = zzkm5.readUnsignedByte() & 31;
                            for (int i8 = 0; i8 < readUnsignedByte2; i8++) {
                                arrayList.add(zzkj.zzc(zzkm5));
                            }
                            int readUnsignedByte3 = zzkm5.readUnsignedByte();
                            for (int i9 = 0; i9 < readUnsignedByte3; i9++) {
                                arrayList.add(zzkj.zzc(zzkm5));
                            }
                            Pair create2 = Pair.create(arrayList, Integer.valueOf(readUnsignedByte));
                            zziu.zzamf = ((Integer) create2.second).intValue();
                            list2 = (List) create2.first;
                        } else {
                            throw new IllegalStateException();
                        }
                    } else if (readInt7 == zziq.zzald) {
                        zziu.zzamd[i7] = zza(zzkm5, position4, readInt6);
                    } else if (readInt7 == zziq.zzaln) {
                        zzkm5.setPosition(position4 + 8);
                        f = ((float) zzkm5.zzgg()) / ((float) zzkm5.zzgg());
                    }
                    position3 += readInt6;
                }
                zziu.zzame = zzhj.zza(MimeTypes.VIDEO_H264, -1, j2, readUnsignedShort, readUnsignedShort2, f, list2);
            } else if (readInt5 == zziq.zzake || readInt5 == zziq.zzali || readInt5 == zziq.zzakf) {
                i3 = readInt4;
                zzkm5.setPosition(position2 + 8);
                zzkm5.zzac(16);
                int readUnsignedShort3 = zzkm5.readUnsignedShort();
                int readUnsignedShort4 = zzkm5.readUnsignedShort();
                zzkm5.zzac(4);
                int zzgf = zzkm5.zzgf();
                int position5 = zzkm5.getPosition();
                int i10 = readUnsignedShort3;
                int i11 = zzgf;
                byte[] bArr = null;
                while (true) {
                    if (position5 - position2 < i3) {
                        zzkm5.setPosition(position5);
                        int position6 = zzkm5.getPosition();
                        int readInt8 = zzkm5.readInt();
                        if (readInt8 > 0) {
                            i2 = readInt3;
                            i = readInt;
                            z3 = true;
                        } else {
                            i2 = readInt3;
                            i = readInt;
                            z3 = false;
                        }
                        zzkh.checkArgument(z3, "childAtomSize should be positive");
                        int readInt9 = zzkm5.readInt();
                        if (readInt5 != zziq.zzake && readInt5 != zziq.zzali) {
                            if (readInt5 != zziq.zzakf || readInt9 != zziq.zzakg) {
                                if (readInt5 == zziq.zzakh && readInt9 == zziq.zzaki) {
                                    zzkm5.setPosition(position6 + 8);
                                    zziu.zzame = zzkg.zzb(zzkm5);
                                    break;
                                }
                            } else {
                                zzkm5.setPosition(position6 + 8);
                                zziu.zzame = zzkg.zza(zzkm5);
                                break;
                            }
                        } else if (readInt9 == zziq.zzakc) {
                            byte[] zzc = zzc(zzkm5, position6);
                            Pair<Integer, Integer> zzd = zzki.zzd(zzc);
                            i11 = ((Integer) zzd.first).intValue();
                            i10 = ((Integer) zzd.second).intValue();
                            bArr = zzc;
                        } else if (readInt9 == zziq.zzald) {
                            zziu.zzamd[i7] = zza(zzkm5, position6, readInt8);
                        }
                        position5 += readInt8;
                        readInt3 = i2;
                        readInt = i;
                    } else {
                        i2 = readInt3;
                        i = readInt;
                        if (readInt5 == zziq.zzakf) {
                            str = MimeTypes.AUDIO_AC3;
                        } else {
                            str = readInt5 == zziq.zzakh ? MimeTypes.AUDIO_E_AC3 : MimeTypes.AUDIO_AAC;
                        }
                        String str2 = str;
                        if (bArr == null) {
                            list = null;
                        } else {
                            list = Collections.singletonList(bArr);
                        }
                        zziu.zzame = zzhj.zzb(str2, readUnsignedShort4, j2, i10, i11, list);
                    }
                }
            } else if (readInt5 == zziq.zzalo) {
                zziu.zzame = zzhj.zzem();
                i2 = readInt3;
                i = readInt;
                i3 = readInt4;
            } else {
                if (readInt5 == zziq.zzalr) {
                    zzkm5.setPosition(position2 + 8);
                    zzkm5.zzac(24);
                    int readUnsignedShort5 = zzkm5.readUnsignedShort();
                    int readUnsignedShort6 = zzkm5.readUnsignedShort();
                    zzkm5.zzac(50);
                    ArrayList arrayList2 = new ArrayList(z ? 1 : 0);
                    int position7 = zzkm5.getPosition();
                    while (position7 - position2 < readInt4) {
                        zzkm5.setPosition(position7);
                        int position8 = zzkm5.getPosition();
                        int readInt10 = zzkm5.readInt();
                        if (readInt10 <= 0) {
                            z = false;
                        }
                        zzkh.checkArgument(z, "childAtomSize should be positive");
                        if (zzkm5.readInt() == zziq.zzakc) {
                            arrayList2.add(zzc(zzkm5, position8));
                        }
                        position7 += readInt10;
                        z = true;
                    }
                    i3 = readInt4;
                    zziu.zzame = zzhj.zza(MimeTypes.VIDEO_MP4V, -1, j2, readUnsignedShort5, readUnsignedShort6, arrayList2);
                } else {
                    i3 = readInt4;
                }
                i2 = readInt3;
                i = readInt;
            }
            zzkm5.setPosition(position2 + i3);
            i7++;
            readInt3 = i2;
            readInt = i;
            z = true;
        }
        int i12 = readInt;
        return new zzix(intValue, readInt, zzge2, j2, zziu.zzame, zziu.zzamd, zziu.zzamf);
    }

    private static zziy zza(zzkm zzkm, int i, int i2) {
        zziy zziy;
        int i3 = i + 8;
        zziy zziy2 = null;
        while (i3 - i < i2) {
            zzkm.setPosition(i3);
            int readInt = zzkm.readInt();
            int readInt2 = zzkm.readInt();
            if (readInt2 == zziq.zzalj) {
                zzkm.readInt();
            } else if (readInt2 == zziq.zzale) {
                zzkm.zzac(4);
                zzkm.readInt();
                zzkm.readInt();
            } else if (readInt2 == zziq.zzalf) {
                int i4 = i3 + 8;
                while (true) {
                    if (i4 - i3 >= readInt) {
                        zziy = null;
                        break;
                    }
                    zzkm.setPosition(i4);
                    int readInt3 = zzkm.readInt();
                    if (zzkm.readInt() == zziq.zzalg) {
                        zzkm.zzac(4);
                        int readInt4 = zzkm.readInt();
                        boolean z = true;
                        if ((readInt4 >> 8) != 1) {
                            z = false;
                        }
                        byte[] bArr = new byte[16];
                        zzkm.zzb(bArr, 0, 16);
                        zziy = new zziy(z, readInt4 & 255, bArr);
                    } else {
                        i4 += readInt3;
                    }
                }
                zziy2 = zziy;
            }
            i3 += readInt;
        }
        return zziy2;
    }

    private static byte[] zzc(zzkm zzkm, int i) {
        zzkm.setPosition(i + 8 + 4);
        zzkm.zzac(1);
        int readUnsignedByte = zzkm.readUnsignedByte();
        while (readUnsignedByte > 127) {
            readUnsignedByte = zzkm.readUnsignedByte();
        }
        zzkm.zzac(2);
        int readUnsignedByte2 = zzkm.readUnsignedByte();
        if ((readUnsignedByte2 & 128) != 0) {
            zzkm.zzac(2);
        }
        if ((readUnsignedByte2 & 64) != 0) {
            zzkm.zzac(zzkm.readUnsignedShort());
        }
        if ((readUnsignedByte2 & 32) != 0) {
            zzkm.zzac(2);
        }
        zzkm.zzac(1);
        int readUnsignedByte3 = zzkm.readUnsignedByte();
        while (readUnsignedByte3 > 127) {
            readUnsignedByte3 = zzkm.readUnsignedByte();
        }
        zzkm.zzac(13);
        zzkm.zzac(1);
        int readUnsignedByte4 = zzkm.readUnsignedByte();
        int i2 = readUnsignedByte4 & 127;
        while (readUnsignedByte4 > 127) {
            readUnsignedByte4 = zzkm.readUnsignedByte();
            i2 = (i2 << 8) | (readUnsignedByte4 & 127);
        }
        byte[] bArr = new byte[i2];
        zzkm.zzb(bArr, 0, i2);
        return bArr;
    }
}
