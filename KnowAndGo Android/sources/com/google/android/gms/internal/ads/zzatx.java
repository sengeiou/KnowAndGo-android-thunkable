package com.google.android.gms.internal.ads;

public abstract class zzatx extends zzfn implements zzatw {
    public zzatx() {
        super("com.google.android.gms.ads.internal.rewarded.client.IRewardedAdCallback");
    }

    /* JADX WARNING: type inference failed for: r2v2, types: [android.os.IInterface] */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean dispatchTransaction(int r1, android.os.Parcel r2, android.os.Parcel r3, int r4) throws android.os.RemoteException {
        /*
            r0 = this;
            switch(r1) {
                case 1: goto L_0x0031;
                case 2: goto L_0x002d;
                case 3: goto L_0x000d;
                case 4: goto L_0x0005;
                default: goto L_0x0003;
            }
        L_0x0003:
            r1 = 0
            return r1
        L_0x0005:
            int r1 = r2.readInt()
            r0.onRewardedAdFailedToShow(r1)
            goto L_0x0034
        L_0x000d:
            android.os.IBinder r1 = r2.readStrongBinder()
            if (r1 != 0) goto L_0x0015
            r1 = 0
            goto L_0x0029
        L_0x0015:
            java.lang.String r2 = "com.google.android.gms.ads.internal.rewarded.client.IRewardItem"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r4 = r2 instanceof com.google.android.gms.internal.ads.zzatq
            if (r4 == 0) goto L_0x0023
            r1 = r2
            com.google.android.gms.internal.ads.zzatq r1 = (com.google.android.gms.internal.ads.zzatq) r1
            goto L_0x0029
        L_0x0023:
            com.google.android.gms.internal.ads.zzats r2 = new com.google.android.gms.internal.ads.zzats
            r2.<init>(r1)
            r1 = r2
        L_0x0029:
            r0.zza(r1)
            goto L_0x0034
        L_0x002d:
            r0.onRewardedAdClosed()
            goto L_0x0034
        L_0x0031:
            r0.onRewardedAdOpened()
        L_0x0034:
            r3.writeNoException()
            r1 = 1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzatx.dispatchTransaction(int, android.os.Parcel, android.os.Parcel, int):boolean");
    }
}
