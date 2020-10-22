package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.MessageDigest;
import org.apache.commons.lang3.StringUtils;

@zzard
public final class zzvf extends zzva {
    private MessageDigest zzbwc;

    public final byte[] zzbl(String str) {
        byte[] bArr;
        String[] split = str.split(StringUtils.SPACE);
        int i = 4;
        if (split.length == 1) {
            int zzbn = zzve.zzbn(split[0]);
            ByteBuffer allocate = ByteBuffer.allocate(4);
            allocate.order(ByteOrder.LITTLE_ENDIAN);
            allocate.putInt(zzbn);
            bArr = allocate.array();
        } else if (split.length < 5) {
            bArr = new byte[(split.length << 1)];
            for (int i2 = 0; i2 < split.length; i2++) {
                int zzbn2 = zzve.zzbn(split[i2]);
                int i3 = (zzbn2 >> 16) ^ (65535 & zzbn2);
                byte[] bArr2 = {(byte) i3, (byte) (i3 >> 8)};
                int i4 = i2 << 1;
                bArr[i4] = bArr2[0];
                bArr[i4 + 1] = bArr2[1];
            }
        } else {
            bArr = new byte[split.length];
            for (int i5 = 0; i5 < split.length; i5++) {
                int zzbn3 = zzve.zzbn(split[i5]);
                bArr[i5] = (byte) ((zzbn3 >> 24) ^ (((zzbn3 & 255) ^ ((zzbn3 >> 8) & 255)) ^ ((zzbn3 >> 16) & 255)));
            }
        }
        this.zzbwc = zznf();
        synchronized (this.mLock) {
            if (this.zzbwc == null) {
                byte[] bArr3 = new byte[0];
                return bArr3;
            }
            this.zzbwc.reset();
            this.zzbwc.update(bArr);
            byte[] digest = this.zzbwc.digest();
            if (digest.length <= 4) {
                i = digest.length;
            }
            byte[] bArr4 = new byte[i];
            System.arraycopy(digest, 0, bArr4, 0, bArr4.length);
            return bArr4;
        }
    }
}
