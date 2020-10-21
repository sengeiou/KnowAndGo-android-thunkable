package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.List;

public final class zzta {
    private final int height;
    private final int width;
    public final List<byte[]> zzafw;
    public final int zzamf;
    public final float zzbne;

    public static zzta zzf(zzst zzst) throws zzlm {
        float f;
        int i;
        int i2;
        try {
            zzst.zzac(4);
            int readUnsignedByte = (zzst.readUnsignedByte() & 3) + 1;
            if (readUnsignedByte != 3) {
                ArrayList arrayList = new ArrayList();
                int readUnsignedByte2 = zzst.readUnsignedByte() & 31;
                for (int i3 = 0; i3 < readUnsignedByte2; i3++) {
                    arrayList.add(zzg(zzst));
                }
                int readUnsignedByte3 = zzst.readUnsignedByte();
                for (int i4 = 0; i4 < readUnsignedByte3; i4++) {
                    arrayList.add(zzg(zzst));
                }
                if (readUnsignedByte2 > 0) {
                    zzsr zze = zzsq.zze((byte[]) arrayList.get(0), readUnsignedByte, ((byte[]) arrayList.get(0)).length);
                    int i5 = zze.width;
                    int i6 = zze.height;
                    f = zze.zzbne;
                    i2 = i5;
                    i = i6;
                } else {
                    i2 = -1;
                    i = -1;
                    f = 1.0f;
                }
                return new zzta(arrayList, readUnsignedByte, i2, i, f);
            }
            throw new IllegalStateException();
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new zzlm("Error parsing AVC config", e);
        }
    }

    private zzta(List<byte[]> list, int i, int i2, int i3, float f) {
        this.zzafw = list;
        this.zzamf = i;
        this.width = i2;
        this.height = i3;
        this.zzbne = f;
    }

    private static byte[] zzg(zzst zzst) {
        int readUnsignedShort = zzst.readUnsignedShort();
        int position = zzst.getPosition();
        zzst.zzac(readUnsignedShort);
        return zzsl.zza(zzst.data, position, readUnsignedShort);
    }
}
