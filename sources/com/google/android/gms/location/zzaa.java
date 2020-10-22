package com.google.android.gms.location;

import android.os.Parcelable;

public final class zzaa implements Parcelable.Creator<LocationAvailability> {
    /* JADX WARNING: type inference failed for: r1v3, types: [java.lang.Object[]] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ java.lang.Object createFromParcel(android.os.Parcel r14) {
        /*
            r13 = this;
            int r0 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.validateObjectHeader(r14)
            r1 = 1
            r2 = 1000(0x3e8, float:1.401E-42)
            r3 = 0
            r5 = 0
            r10 = r3
            r12 = r5
            r7 = 1000(0x3e8, float:1.401E-42)
            r8 = 1
            r9 = 1
        L_0x0010:
            int r1 = r14.dataPosition()
            if (r1 >= r0) goto L_0x0043
            int r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readHeader(r14)
            int r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.getFieldId(r1)
            switch(r2) {
                case 1: goto L_0x003e;
                case 2: goto L_0x0039;
                case 3: goto L_0x0034;
                case 4: goto L_0x002f;
                case 5: goto L_0x0025;
                default: goto L_0x0021;
            }
        L_0x0021:
            com.google.android.gms.common.internal.safeparcel.SafeParcelReader.skipUnknownField(r14, r1)
            goto L_0x0010
        L_0x0025:
            android.os.Parcelable$Creator<com.google.android.gms.location.zzaj> r2 = com.google.android.gms.location.zzaj.CREATOR
            java.lang.Object[] r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createTypedArray(r14, r1, r2)
            r12 = r1
            com.google.android.gms.location.zzaj[] r12 = (com.google.android.gms.location.zzaj[]) r12
            goto L_0x0010
        L_0x002f:
            int r7 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readInt(r14, r1)
            goto L_0x0010
        L_0x0034:
            long r10 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readLong(r14, r1)
            goto L_0x0010
        L_0x0039:
            int r9 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readInt(r14, r1)
            goto L_0x0010
        L_0x003e:
            int r8 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readInt(r14, r1)
            goto L_0x0010
        L_0x0043:
            com.google.android.gms.common.internal.safeparcel.SafeParcelReader.ensureAtEnd(r14, r0)
            com.google.android.gms.location.LocationAvailability r14 = new com.google.android.gms.location.LocationAvailability
            r6 = r14
            r6.<init>(r7, r8, r9, r10, r12)
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.location.zzaa.createFromParcel(android.os.Parcel):java.lang.Object");
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new LocationAvailability[i];
    }
}
