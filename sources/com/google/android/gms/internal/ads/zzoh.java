package com.google.android.gms.internal.ads;

import java.io.IOException;
import kotlin.UByte;

final class zzoh {
    private final zzst zzbac = new zzst(8);
    private int zzbch;

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0074, code lost:
        r0 = zzc(r14);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zza(com.google.android.gms.internal.ads.zzno r14) throws java.io.IOException, java.lang.InterruptedException {
        /*
            r13 = this;
            long r0 = r14.getLength()
            r2 = 1024(0x400, double:5.06E-321)
            r4 = -1
            int r4 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r4 == 0) goto L_0x0012
            int r5 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r5 <= 0) goto L_0x0011
            goto L_0x0012
        L_0x0011:
            r2 = r0
        L_0x0012:
            int r2 = (int) r2
            com.google.android.gms.internal.ads.zzst r3 = r13.zzbac
            byte[] r3 = r3.data
            r5 = 4
            r6 = 0
            r14.zzc(r3, r6, r5)
            com.google.android.gms.internal.ads.zzst r3 = r13.zzbac
            long r7 = r3.zzge()
            r13.zzbch = r5
        L_0x0024:
            r9 = 440786851(0x1a45dfa3, double:2.1777764E-315)
            r3 = 1
            int r5 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r5 == 0) goto L_0x004c
            int r5 = r13.zzbch
            int r5 = r5 + r3
            r13.zzbch = r5
            if (r5 != r2) goto L_0x0034
            return r6
        L_0x0034:
            com.google.android.gms.internal.ads.zzst r5 = r13.zzbac
            byte[] r5 = r5.data
            r14.zzc(r5, r6, r3)
            r3 = 8
            long r7 = r7 << r3
            r9 = -256(0xffffffffffffff00, double:NaN)
            long r7 = r7 & r9
            com.google.android.gms.internal.ads.zzst r3 = r13.zzbac
            byte[] r3 = r3.data
            byte r3 = r3[r6]
            r3 = r3 & 255(0xff, float:3.57E-43)
            long r9 = (long) r3
            long r7 = r7 | r9
            goto L_0x0024
        L_0x004c:
            long r7 = r13.zzc(r14)
            int r2 = r13.zzbch
            long r9 = (long) r2
            r11 = -9223372036854775808
            int r2 = (r7 > r11 ? 1 : (r7 == r11 ? 0 : -1))
            if (r2 == 0) goto L_0x009e
            if (r4 == 0) goto L_0x0062
            long r4 = r9 + r7
            int r0 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r0 < 0) goto L_0x0062
            goto L_0x009e
        L_0x0062:
            int r0 = r13.zzbch
            long r0 = (long) r0
            long r4 = r9 + r7
            int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r0 >= 0) goto L_0x0095
            long r0 = r13.zzc(r14)
            int r0 = (r0 > r11 ? 1 : (r0 == r11 ? 0 : -1))
            if (r0 != 0) goto L_0x0074
            return r6
        L_0x0074:
            long r0 = r13.zzc(r14)
            r4 = 0
            int r2 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r2 < 0) goto L_0x0094
            r4 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r4 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r4 <= 0) goto L_0x0086
            goto L_0x0094
        L_0x0086:
            if (r2 == 0) goto L_0x0062
            int r2 = (int) r0
            r14.zzar(r2)
            int r2 = r13.zzbch
            long r4 = (long) r2
            long r4 = r4 + r0
            int r0 = (int) r4
            r13.zzbch = r0
            goto L_0x0062
        L_0x0094:
            return r6
        L_0x0095:
            int r14 = r13.zzbch
            long r0 = (long) r14
            int r14 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r14 != 0) goto L_0x009d
            return r3
        L_0x009d:
            return r6
        L_0x009e:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzoh.zza(com.google.android.gms.internal.ads.zzno):boolean");
    }

    private final long zzc(zzno zzno) throws IOException, InterruptedException {
        int i = 0;
        zzno.zzc(this.zzbac.data, 0, 1);
        byte b = this.zzbac.data[0] & UByte.MAX_VALUE;
        if (b == 0) {
            return Long.MIN_VALUE;
        }
        int i2 = 128;
        int i3 = 0;
        while ((b & i2) == 0) {
            i2 >>= 1;
            i3++;
        }
        int i4 = b & (~i2);
        zzno.zzc(this.zzbac.data, 1, i3);
        while (i < i3) {
            i++;
            i4 = (this.zzbac.data[i] & UByte.MAX_VALUE) + (i4 << 8);
        }
        this.zzbch += i3 + 1;
        return (long) i4;
    }
}
