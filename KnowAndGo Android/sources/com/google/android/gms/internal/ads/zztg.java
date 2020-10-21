package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.List;

public final class zztg {
    public final List<byte[]> zzafw;
    public final int zzamf;

    public static zztg zzh(zzst zzst) throws zzlm {
        List list;
        try {
            zzst.zzac(21);
            int readUnsignedByte = zzst.readUnsignedByte() & 3;
            int readUnsignedByte2 = zzst.readUnsignedByte();
            int position = zzst.getPosition();
            int i = 0;
            int i2 = 0;
            while (i < readUnsignedByte2) {
                zzst.zzac(1);
                int readUnsignedShort = zzst.readUnsignedShort();
                int i3 = i2;
                for (int i4 = 0; i4 < readUnsignedShort; i4++) {
                    int readUnsignedShort2 = zzst.readUnsignedShort();
                    i3 += readUnsignedShort2 + 4;
                    zzst.zzac(readUnsignedShort2);
                }
                i++;
                i2 = i3;
            }
            zzst.setPosition(position);
            byte[] bArr = new byte[i2];
            int i5 = 0;
            int i6 = 0;
            while (i5 < readUnsignedByte2) {
                zzst.zzac(1);
                int readUnsignedShort3 = zzst.readUnsignedShort();
                int i7 = i6;
                for (int i8 = 0; i8 < readUnsignedShort3; i8++) {
                    int readUnsignedShort4 = zzst.readUnsignedShort();
                    System.arraycopy(zzsq.zzaqt, 0, bArr, i7, zzsq.zzaqt.length);
                    int length = i7 + zzsq.zzaqt.length;
                    System.arraycopy(zzst.data, zzst.getPosition(), bArr, length, readUnsignedShort4);
                    i7 = length + readUnsignedShort4;
                    zzst.zzac(readUnsignedShort4);
                }
                i5++;
                i6 = i7;
            }
            if (i2 == 0) {
                list = null;
            } else {
                list = Collections.singletonList(bArr);
            }
            return new zztg(list, readUnsignedByte + 1);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new zzlm("Error parsing HEVC config", e);
        }
    }

    private zztg(List<byte[]> list, int i) {
        this.zzafw = list;
        this.zzamf = i;
    }
}
