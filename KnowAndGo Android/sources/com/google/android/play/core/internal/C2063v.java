package com.google.android.play.core.internal;

/* renamed from: com.google.android.play.core.internal.v */
public abstract class C2063v extends C2051j implements C2064w {
    public C2063v() {
        super("com.google.android.play.core.assetpacks.protocol.IAssetPackExtractionService");
    }

    /* JADX WARNING: type inference failed for: r4v3, types: [android.os.IInterface] */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean mo33545a(int r3, android.os.Parcel r4) throws android.os.RemoteException {
        /*
            r2 = this;
            r0 = 0
            switch(r3) {
                case 2: goto L_0x002c;
                case 3: goto L_0x0006;
                default: goto L_0x0004;
            }
        L_0x0004:
            r3 = 0
            return r3
        L_0x0006:
            android.os.Parcelable$Creator r3 = android.os.Bundle.CREATOR
            android.os.Parcelable r3 = com.google.android.play.core.internal.C2052k.m776a((android.os.Parcel) r4, r3)
            android.os.Bundle r3 = (android.os.Bundle) r3
            android.os.IBinder r3 = r4.readStrongBinder()
            if (r3 != 0) goto L_0x0015
            goto L_0x0028
        L_0x0015:
            java.lang.String r4 = "com.google.android.play.core.assetpacks.protocol.IAssetPackExtractionServiceCallback"
            android.os.IInterface r4 = r3.queryLocalInterface(r4)
            boolean r0 = r4 instanceof com.google.android.play.core.internal.C2066y
            if (r0 == 0) goto L_0x0023
            r0 = r4
            com.google.android.play.core.internal.y r0 = (com.google.android.play.core.internal.C2066y) r0
            goto L_0x0028
        L_0x0023:
            com.google.android.play.core.internal.x r0 = new com.google.android.play.core.internal.x
            r0.<init>(r3)
        L_0x0028:
            r2.mo33371a(r0)
            goto L_0x0050
        L_0x002c:
            android.os.Parcelable$Creator r3 = android.os.Bundle.CREATOR
            android.os.Parcelable r3 = com.google.android.play.core.internal.C2052k.m776a((android.os.Parcel) r4, r3)
            android.os.Bundle r3 = (android.os.Bundle) r3
            android.os.IBinder r4 = r4.readStrongBinder()
            if (r4 != 0) goto L_0x003b
            goto L_0x004d
        L_0x003b:
            java.lang.String r0 = "com.google.android.play.core.assetpacks.protocol.IAssetPackExtractionServiceCallback"
            android.os.IInterface r0 = r4.queryLocalInterface(r0)
            boolean r1 = r0 instanceof com.google.android.play.core.internal.C2066y
            if (r1 == 0) goto L_0x0048
            com.google.android.play.core.internal.y r0 = (com.google.android.play.core.internal.C2066y) r0
            goto L_0x004d
        L_0x0048:
            com.google.android.play.core.internal.x r0 = new com.google.android.play.core.internal.x
            r0.<init>(r4)
        L_0x004d:
            r2.mo33370a(r3, r0)
        L_0x0050:
            r3 = 1
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.play.core.internal.C2063v.mo33545a(int, android.os.Parcel):boolean");
    }
}
