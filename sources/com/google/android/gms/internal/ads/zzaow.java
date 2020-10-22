package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;

public abstract class zzaow extends zzfn implements zzaov {
    public zzaow() {
        super("com.google.android.gms.ads.internal.mediation.client.rtb.IRtbAdapter");
    }

    public static zzaov zzab(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.IRtbAdapter");
        if (queryLocalInterface instanceof zzaov) {
            return (zzaov) queryLocalInterface;
        }
        return new zzaox(iBinder);
    }

    /* JADX WARNING: type inference failed for: r1v4, types: [com.google.android.gms.internal.ads.zzaoy] */
    /* JADX WARNING: type inference failed for: r1v10, types: [com.google.android.gms.internal.ads.zzaol] */
    /* JADX WARNING: type inference failed for: r1v11, types: [com.google.android.gms.internal.ads.zzaoj] */
    /* JADX WARNING: type inference failed for: r5v6, types: [com.google.android.gms.internal.ads.zzaoj] */
    /* JADX WARNING: type inference failed for: r1v18, types: [com.google.android.gms.internal.ads.zzaoo] */
    /* JADX WARNING: type inference failed for: r1v19, types: [com.google.android.gms.internal.ads.zzaom] */
    /* JADX WARNING: type inference failed for: r5v9, types: [com.google.android.gms.internal.ads.zzaom] */
    /* JADX WARNING: type inference failed for: r1v24, types: [com.google.android.gms.internal.ads.zzaou] */
    /* JADX WARNING: type inference failed for: r1v25, types: [com.google.android.gms.internal.ads.zzaos] */
    /* JADX WARNING: type inference failed for: r5v12, types: [com.google.android.gms.internal.ads.zzaos] */
    /* JADX WARNING: type inference failed for: r1v30, types: [com.google.android.gms.internal.ads.zzaor] */
    /* JADX WARNING: type inference failed for: r1v31, types: [com.google.android.gms.internal.ads.zzaop] */
    /* JADX WARNING: type inference failed for: r5v15, types: [com.google.android.gms.internal.ads.zzaop] */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean dispatchTransaction(int r10, android.os.Parcel r11, android.os.Parcel r12, int r13) throws android.os.RemoteException {
        /*
            r9 = this;
            r1 = 0
            switch(r10) {
                case 1: goto L_0x01a6;
                case 2: goto L_0x019b;
                case 3: goto L_0x0190;
                case 4: goto L_0x0004;
                case 5: goto L_0x0184;
                case 6: goto L_0x0004;
                case 7: goto L_0x0004;
                case 8: goto L_0x0004;
                case 9: goto L_0x0004;
                case 10: goto L_0x0174;
                case 11: goto L_0x0160;
                case 12: goto L_0x0004;
                case 13: goto L_0x010c;
                case 14: goto L_0x00c2;
                case 15: goto L_0x00ae;
                case 16: goto L_0x0064;
                case 17: goto L_0x0050;
                case 18: goto L_0x0006;
                default: goto L_0x0004;
            }
        L_0x0004:
            r0 = 0
            return r0
        L_0x0006:
            java.lang.String r2 = r11.readString()
            java.lang.String r3 = r11.readString()
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzxz> r4 = com.google.android.gms.internal.ads.zzxz.CREATOR
            android.os.Parcelable r4 = com.google.android.gms.internal.ads.zzfo.zza((android.os.Parcel) r11, r4)
            com.google.android.gms.internal.ads.zzxz r4 = (com.google.android.gms.internal.ads.zzxz) r4
            android.os.IBinder r5 = r11.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r5 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r5)
            android.os.IBinder r6 = r11.readStrongBinder()
            if (r6 != 0) goto L_0x0026
        L_0x0024:
            r6 = r1
            goto L_0x0039
        L_0x0026:
            java.lang.String r1 = "com.google.android.gms.ads.internal.mediation.client.rtb.INativeCallback"
            android.os.IInterface r1 = r6.queryLocalInterface(r1)
            boolean r7 = r1 instanceof com.google.android.gms.internal.ads.zzaop
            if (r7 == 0) goto L_0x0033
            com.google.android.gms.internal.ads.zzaop r1 = (com.google.android.gms.internal.ads.zzaop) r1
            goto L_0x0024
        L_0x0033:
            com.google.android.gms.internal.ads.zzaor r1 = new com.google.android.gms.internal.ads.zzaor
            r1.<init>(r6)
            goto L_0x0024
        L_0x0039:
            android.os.IBinder r0 = r11.readStrongBinder()
            com.google.android.gms.internal.ads.zzamv r7 = com.google.android.gms.internal.ads.zzamw.zzz(r0)
            r0 = r9
            r1 = r2
            r2 = r3
            r3 = r4
            r4 = r5
            r5 = r6
            r6 = r7
            r0.zza((java.lang.String) r1, (java.lang.String) r2, (com.google.android.gms.internal.ads.zzxz) r3, (com.google.android.gms.dynamic.IObjectWrapper) r4, (com.google.android.gms.internal.ads.zzaop) r5, (com.google.android.gms.internal.ads.zzamv) r6)
            r12.writeNoException()
            goto L_0x01f2
        L_0x0050:
            android.os.IBinder r0 = r11.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r0 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r0)
            boolean r0 = r9.zzz(r0)
            r12.writeNoException()
            com.google.android.gms.internal.ads.zzfo.writeBoolean(r12, r0)
            goto L_0x01f2
        L_0x0064:
            java.lang.String r2 = r11.readString()
            java.lang.String r3 = r11.readString()
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzxz> r4 = com.google.android.gms.internal.ads.zzxz.CREATOR
            android.os.Parcelable r4 = com.google.android.gms.internal.ads.zzfo.zza((android.os.Parcel) r11, r4)
            com.google.android.gms.internal.ads.zzxz r4 = (com.google.android.gms.internal.ads.zzxz) r4
            android.os.IBinder r5 = r11.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r5 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r5)
            android.os.IBinder r6 = r11.readStrongBinder()
            if (r6 != 0) goto L_0x0084
        L_0x0082:
            r6 = r1
            goto L_0x0097
        L_0x0084:
            java.lang.String r1 = "com.google.android.gms.ads.internal.mediation.client.rtb.IRewardedCallback"
            android.os.IInterface r1 = r6.queryLocalInterface(r1)
            boolean r7 = r1 instanceof com.google.android.gms.internal.ads.zzaos
            if (r7 == 0) goto L_0x0091
            com.google.android.gms.internal.ads.zzaos r1 = (com.google.android.gms.internal.ads.zzaos) r1
            goto L_0x0082
        L_0x0091:
            com.google.android.gms.internal.ads.zzaou r1 = new com.google.android.gms.internal.ads.zzaou
            r1.<init>(r6)
            goto L_0x0082
        L_0x0097:
            android.os.IBinder r0 = r11.readStrongBinder()
            com.google.android.gms.internal.ads.zzamv r7 = com.google.android.gms.internal.ads.zzamw.zzz(r0)
            r0 = r9
            r1 = r2
            r2 = r3
            r3 = r4
            r4 = r5
            r5 = r6
            r6 = r7
            r0.zza((java.lang.String) r1, (java.lang.String) r2, (com.google.android.gms.internal.ads.zzxz) r3, (com.google.android.gms.dynamic.IObjectWrapper) r4, (com.google.android.gms.internal.ads.zzaos) r5, (com.google.android.gms.internal.ads.zzamv) r6)
            r12.writeNoException()
            goto L_0x01f2
        L_0x00ae:
            android.os.IBinder r0 = r11.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r0 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r0)
            boolean r0 = r9.zzy(r0)
            r12.writeNoException()
            com.google.android.gms.internal.ads.zzfo.writeBoolean(r12, r0)
            goto L_0x01f2
        L_0x00c2:
            java.lang.String r2 = r11.readString()
            java.lang.String r3 = r11.readString()
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzxz> r4 = com.google.android.gms.internal.ads.zzxz.CREATOR
            android.os.Parcelable r4 = com.google.android.gms.internal.ads.zzfo.zza((android.os.Parcel) r11, r4)
            com.google.android.gms.internal.ads.zzxz r4 = (com.google.android.gms.internal.ads.zzxz) r4
            android.os.IBinder r5 = r11.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r5 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r5)
            android.os.IBinder r6 = r11.readStrongBinder()
            if (r6 != 0) goto L_0x00e2
        L_0x00e0:
            r6 = r1
            goto L_0x00f5
        L_0x00e2:
            java.lang.String r1 = "com.google.android.gms.ads.internal.mediation.client.rtb.IInterstitialCallback"
            android.os.IInterface r1 = r6.queryLocalInterface(r1)
            boolean r7 = r1 instanceof com.google.android.gms.internal.ads.zzaom
            if (r7 == 0) goto L_0x00ef
            com.google.android.gms.internal.ads.zzaom r1 = (com.google.android.gms.internal.ads.zzaom) r1
            goto L_0x00e0
        L_0x00ef:
            com.google.android.gms.internal.ads.zzaoo r1 = new com.google.android.gms.internal.ads.zzaoo
            r1.<init>(r6)
            goto L_0x00e0
        L_0x00f5:
            android.os.IBinder r0 = r11.readStrongBinder()
            com.google.android.gms.internal.ads.zzamv r7 = com.google.android.gms.internal.ads.zzamw.zzz(r0)
            r0 = r9
            r1 = r2
            r2 = r3
            r3 = r4
            r4 = r5
            r5 = r6
            r6 = r7
            r0.zza((java.lang.String) r1, (java.lang.String) r2, (com.google.android.gms.internal.ads.zzxz) r3, (com.google.android.gms.dynamic.IObjectWrapper) r4, (com.google.android.gms.internal.ads.zzaom) r5, (com.google.android.gms.internal.ads.zzamv) r6)
            r12.writeNoException()
            goto L_0x01f2
        L_0x010c:
            java.lang.String r2 = r11.readString()
            java.lang.String r3 = r11.readString()
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzxz> r4 = com.google.android.gms.internal.ads.zzxz.CREATOR
            android.os.Parcelable r4 = com.google.android.gms.internal.ads.zzfo.zza((android.os.Parcel) r11, r4)
            com.google.android.gms.internal.ads.zzxz r4 = (com.google.android.gms.internal.ads.zzxz) r4
            android.os.IBinder r5 = r11.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r5 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r5)
            android.os.IBinder r6 = r11.readStrongBinder()
            if (r6 != 0) goto L_0x012c
        L_0x012a:
            r6 = r1
            goto L_0x013f
        L_0x012c:
            java.lang.String r1 = "com.google.android.gms.ads.internal.mediation.client.rtb.IBannerCallback"
            android.os.IInterface r1 = r6.queryLocalInterface(r1)
            boolean r7 = r1 instanceof com.google.android.gms.internal.ads.zzaoj
            if (r7 == 0) goto L_0x0139
            com.google.android.gms.internal.ads.zzaoj r1 = (com.google.android.gms.internal.ads.zzaoj) r1
            goto L_0x012a
        L_0x0139:
            com.google.android.gms.internal.ads.zzaol r1 = new com.google.android.gms.internal.ads.zzaol
            r1.<init>(r6)
            goto L_0x012a
        L_0x013f:
            android.os.IBinder r1 = r11.readStrongBinder()
            com.google.android.gms.internal.ads.zzamv r7 = com.google.android.gms.internal.ads.zzamw.zzz(r1)
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzyd> r1 = com.google.android.gms.internal.ads.zzyd.CREATOR
            android.os.Parcelable r0 = com.google.android.gms.internal.ads.zzfo.zza((android.os.Parcel) r11, r1)
            r8 = r0
            com.google.android.gms.internal.ads.zzyd r8 = (com.google.android.gms.internal.ads.zzyd) r8
            r0 = r9
            r1 = r2
            r2 = r3
            r3 = r4
            r4 = r5
            r5 = r6
            r6 = r7
            r7 = r8
            r0.zza(r1, r2, r3, r4, r5, r6, r7)
            r12.writeNoException()
            goto L_0x01f2
        L_0x0160:
            java.lang.String[] r1 = r11.createStringArray()
            android.os.Parcelable$Creator r2 = android.os.Bundle.CREATOR
            java.lang.Object[] r0 = r11.createTypedArray(r2)
            android.os.Bundle[] r0 = (android.os.Bundle[]) r0
            r9.zza(r1, r0)
            r12.writeNoException()
            goto L_0x01f2
        L_0x0174:
            android.os.IBinder r0 = r11.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r0 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r0)
            r9.zzx(r0)
            r12.writeNoException()
            goto L_0x01f2
        L_0x0184:
            com.google.android.gms.internal.ads.zzaar r0 = r9.getVideoController()
            r12.writeNoException()
            com.google.android.gms.internal.ads.zzfo.zza((android.os.Parcel) r12, (android.os.IInterface) r0)
            goto L_0x01f2
        L_0x0190:
            com.google.android.gms.internal.ads.zzapj r0 = r9.zzsy()
            r12.writeNoException()
            com.google.android.gms.internal.ads.zzfo.zzb(r12, r0)
            goto L_0x01f2
        L_0x019b:
            com.google.android.gms.internal.ads.zzapj r0 = r9.zzsx()
            r12.writeNoException()
            com.google.android.gms.internal.ads.zzfo.zzb(r12, r0)
            goto L_0x01f2
        L_0x01a6:
            android.os.IBinder r2 = r11.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r2 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r2)
            java.lang.String r3 = r11.readString()
            android.os.Parcelable$Creator r4 = android.os.Bundle.CREATOR
            android.os.Parcelable r4 = com.google.android.gms.internal.ads.zzfo.zza((android.os.Parcel) r11, r4)
            android.os.Bundle r4 = (android.os.Bundle) r4
            android.os.Parcelable$Creator r5 = android.os.Bundle.CREATOR
            android.os.Parcelable r5 = com.google.android.gms.internal.ads.zzfo.zza((android.os.Parcel) r11, r5)
            android.os.Bundle r5 = (android.os.Bundle) r5
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzyd> r6 = com.google.android.gms.internal.ads.zzyd.CREATOR
            android.os.Parcelable r6 = com.google.android.gms.internal.ads.zzfo.zza((android.os.Parcel) r11, r6)
            com.google.android.gms.internal.ads.zzyd r6 = (com.google.android.gms.internal.ads.zzyd) r6
            android.os.IBinder r0 = r11.readStrongBinder()
            if (r0 != 0) goto L_0x01d2
        L_0x01d0:
            r7 = r1
            goto L_0x01e5
        L_0x01d2:
            java.lang.String r1 = "com.google.android.gms.ads.internal.mediation.client.rtb.ISignalsCallback"
            android.os.IInterface r1 = r0.queryLocalInterface(r1)
            boolean r7 = r1 instanceof com.google.android.gms.internal.ads.zzaoy
            if (r7 == 0) goto L_0x01df
            com.google.android.gms.internal.ads.zzaoy r1 = (com.google.android.gms.internal.ads.zzaoy) r1
            goto L_0x01d0
        L_0x01df:
            com.google.android.gms.internal.ads.zzapa r1 = new com.google.android.gms.internal.ads.zzapa
            r1.<init>(r0)
            goto L_0x01d0
        L_0x01e5:
            r0 = r9
            r1 = r2
            r2 = r3
            r3 = r4
            r4 = r5
            r5 = r6
            r6 = r7
            r0.zza((com.google.android.gms.dynamic.IObjectWrapper) r1, (java.lang.String) r2, (android.os.Bundle) r3, (android.os.Bundle) r4, (com.google.android.gms.internal.ads.zzyd) r5, (com.google.android.gms.internal.ads.zzaoy) r6)
            r12.writeNoException()
        L_0x01f2:
            r0 = 1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaow.dispatchTransaction(int, android.os.Parcel, android.os.Parcel, int):boolean");
    }
}
