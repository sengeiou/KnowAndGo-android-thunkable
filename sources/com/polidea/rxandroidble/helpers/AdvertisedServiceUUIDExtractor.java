package com.polidea.rxandroidble.helpers;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class AdvertisedServiceUUIDExtractor {
    private static final String UUID_BASE = "%08x-0000-1000-8000-00805f9b34fb";

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x000f, code lost:
        continue;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<java.util.UUID> extractUUIDs(byte[] r9) {
        /*
            r8 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.nio.ByteBuffer r9 = java.nio.ByteBuffer.wrap(r9)
            java.nio.ByteOrder r1 = java.nio.ByteOrder.LITTLE_ENDIAN
            java.nio.ByteBuffer r9 = r9.order(r1)
        L_0x000f:
            int r1 = r9.remaining()
            r2 = 2
            if (r1 <= r2) goto L_0x0087
            byte r1 = r9.get()
            if (r1 != 0) goto L_0x001d
            goto L_0x0087
        L_0x001d:
            byte r3 = r9.get()
            r4 = 0
            r5 = 1
            switch(r3) {
                case 2: goto L_0x0068;
                case 3: goto L_0x0068;
                case 4: goto L_0x0030;
                case 5: goto L_0x0030;
                case 6: goto L_0x0050;
                case 7: goto L_0x0050;
                default: goto L_0x0026;
            }
        L_0x0026:
            int r2 = r9.position()
            int r2 = r2 + r1
            int r2 = r2 - r5
            r9.position(r2)
            goto L_0x000f
        L_0x0030:
            r2 = 4
            if (r1 < r2) goto L_0x0050
            java.lang.String r2 = "%08x-0000-1000-8000-00805f9b34fb"
            java.lang.Object[] r3 = new java.lang.Object[r5]
            int r6 = r9.getInt()
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            r3[r4] = r6
            java.lang.String r2 = java.lang.String.format(r2, r3)
            java.util.UUID r2 = java.util.UUID.fromString(r2)
            r0.add(r2)
            int r1 = r1 + -4
            byte r1 = (byte) r1
            goto L_0x0030
        L_0x0050:
            r2 = 16
            if (r1 < r2) goto L_0x000f
            long r2 = r9.getLong()
            long r4 = r9.getLong()
            java.util.UUID r6 = new java.util.UUID
            r6.<init>(r4, r2)
            r0.add(r6)
            int r1 = r1 + -16
            byte r1 = (byte) r1
            goto L_0x0050
        L_0x0068:
            if (r1 < r2) goto L_0x000f
            java.lang.String r3 = "%08x-0000-1000-8000-00805f9b34fb"
            java.lang.Object[] r6 = new java.lang.Object[r5]
            short r7 = r9.getShort()
            java.lang.Short r7 = java.lang.Short.valueOf(r7)
            r6[r4] = r7
            java.lang.String r3 = java.lang.String.format(r3, r6)
            java.util.UUID r3 = java.util.UUID.fromString(r3)
            r0.add(r3)
            int r1 = r1 + -2
            byte r1 = (byte) r1
            goto L_0x0068
        L_0x0087:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.polidea.rxandroidble.helpers.AdvertisedServiceUUIDExtractor.extractUUIDs(byte[]):java.util.List");
    }

    @NonNull
    public Set<UUID> toDistinctSet(@Nullable UUID[] uuidArr) {
        if (uuidArr == null) {
            uuidArr = new UUID[0];
        }
        return new HashSet(Arrays.asList(uuidArr));
    }
}
