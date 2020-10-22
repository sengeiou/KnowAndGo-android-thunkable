package com.google.android.gms.internal.ads;

public abstract class zzamt extends zzfn implements zzams {
    public zzamt() {
        super("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
    }

    /* JADX WARNING: type inference failed for: r10v5, types: [android.os.IInterface] */
    /* JADX WARNING: type inference failed for: r10v7, types: [android.os.IInterface] */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean dispatchTransaction(int r9, android.os.Parcel r10, android.os.Parcel r11, int r12) throws android.os.RemoteException {
        /*
            r8 = this;
            r12 = 0
            switch(r9) {
                case 1: goto L_0x02a5;
                case 2: goto L_0x029a;
                case 3: goto L_0x0266;
                case 4: goto L_0x025e;
                case 5: goto L_0x0256;
                case 6: goto L_0x020f;
                case 7: goto L_0x01d1;
                case 8: goto L_0x01c9;
                case 9: goto L_0x01c1;
                case 10: goto L_0x0197;
                case 11: goto L_0x0183;
                case 12: goto L_0x017b;
                case 13: goto L_0x016f;
                case 14: goto L_0x0125;
                case 15: goto L_0x0119;
                case 16: goto L_0x010d;
                case 17: goto L_0x0101;
                case 18: goto L_0x00f5;
                case 19: goto L_0x00e9;
                case 20: goto L_0x00d1;
                case 21: goto L_0x00c1;
                case 22: goto L_0x00b5;
                case 23: goto L_0x0099;
                case 24: goto L_0x008d;
                case 25: goto L_0x0081;
                case 26: goto L_0x0075;
                case 27: goto L_0x0069;
                case 28: goto L_0x0034;
                case 29: goto L_0x0004;
                case 30: goto L_0x0024;
                case 31: goto L_0x0006;
                default: goto L_0x0004;
            }
        L_0x0004:
            r9 = 0
            return r9
        L_0x0006:
            android.os.IBinder r9 = r10.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r9 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r9)
            android.os.IBinder r12 = r10.readStrongBinder()
            com.google.android.gms.internal.ads.zzaiq r12 = com.google.android.gms.internal.ads.zzair.zzv(r12)
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzaiw> r0 = com.google.android.gms.internal.ads.zzaiw.CREATOR
            java.util.ArrayList r10 = r10.createTypedArrayList(r0)
            r8.zza((com.google.android.gms.dynamic.IObjectWrapper) r9, (com.google.android.gms.internal.ads.zzaiq) r12, (java.util.List<com.google.android.gms.internal.ads.zzaiw>) r10)
            r11.writeNoException()
            goto L_0x02e6
        L_0x0024:
            android.os.IBinder r9 = r10.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r9 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r9)
            r8.zzs(r9)
            r11.writeNoException()
            goto L_0x02e6
        L_0x0034:
            android.os.IBinder r9 = r10.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r9 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r9)
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzxz> r0 = com.google.android.gms.internal.ads.zzxz.CREATOR
            android.os.Parcelable r0 = com.google.android.gms.internal.ads.zzfo.zza((android.os.Parcel) r10, r0)
            com.google.android.gms.internal.ads.zzxz r0 = (com.google.android.gms.internal.ads.zzxz) r0
            java.lang.String r1 = r10.readString()
            android.os.IBinder r10 = r10.readStrongBinder()
            if (r10 != 0) goto L_0x004f
            goto L_0x0061
        L_0x004f:
            java.lang.String r12 = "com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener"
            android.os.IInterface r12 = r10.queryLocalInterface(r12)
            boolean r2 = r12 instanceof com.google.android.gms.internal.ads.zzamv
            if (r2 == 0) goto L_0x005c
            com.google.android.gms.internal.ads.zzamv r12 = (com.google.android.gms.internal.ads.zzamv) r12
            goto L_0x0061
        L_0x005c:
            com.google.android.gms.internal.ads.zzamx r12 = new com.google.android.gms.internal.ads.zzamx
            r12.<init>(r10)
        L_0x0061:
            r8.zzb(r9, r0, r1, r12)
            r11.writeNoException()
            goto L_0x02e6
        L_0x0069:
            com.google.android.gms.internal.ads.zzang r9 = r8.zzsl()
            r11.writeNoException()
            com.google.android.gms.internal.ads.zzfo.zza((android.os.Parcel) r11, (android.os.IInterface) r9)
            goto L_0x02e6
        L_0x0075:
            com.google.android.gms.internal.ads.zzaar r9 = r8.getVideoController()
            r11.writeNoException()
            com.google.android.gms.internal.ads.zzfo.zza((android.os.Parcel) r11, (android.os.IInterface) r9)
            goto L_0x02e6
        L_0x0081:
            boolean r9 = com.google.android.gms.internal.ads.zzfo.zza(r10)
            r8.setImmersiveMode(r9)
            r11.writeNoException()
            goto L_0x02e6
        L_0x008d:
            com.google.android.gms.internal.ads.zzafe r9 = r8.zzsk()
            r11.writeNoException()
            com.google.android.gms.internal.ads.zzfo.zza((android.os.Parcel) r11, (android.os.IInterface) r9)
            goto L_0x02e6
        L_0x0099:
            android.os.IBinder r9 = r10.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r9 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r9)
            android.os.IBinder r12 = r10.readStrongBinder()
            com.google.android.gms.internal.ads.zzatk r12 = com.google.android.gms.internal.ads.zzatl.zzai(r12)
            java.util.ArrayList r10 = r10.createStringArrayList()
            r8.zza((com.google.android.gms.dynamic.IObjectWrapper) r9, (com.google.android.gms.internal.ads.zzatk) r12, (java.util.List<java.lang.String>) r10)
            r11.writeNoException()
            goto L_0x02e6
        L_0x00b5:
            boolean r9 = r8.zzsj()
            r11.writeNoException()
            com.google.android.gms.internal.ads.zzfo.writeBoolean(r11, r9)
            goto L_0x02e6
        L_0x00c1:
            android.os.IBinder r9 = r10.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r9 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r9)
            r8.zzr(r9)
            r11.writeNoException()
            goto L_0x02e6
        L_0x00d1:
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzxz> r9 = com.google.android.gms.internal.ads.zzxz.CREATOR
            android.os.Parcelable r9 = com.google.android.gms.internal.ads.zzfo.zza((android.os.Parcel) r10, r9)
            com.google.android.gms.internal.ads.zzxz r9 = (com.google.android.gms.internal.ads.zzxz) r9
            java.lang.String r12 = r10.readString()
            java.lang.String r10 = r10.readString()
            r8.zza((com.google.android.gms.internal.ads.zzxz) r9, (java.lang.String) r12, (java.lang.String) r10)
            r11.writeNoException()
            goto L_0x02e6
        L_0x00e9:
            android.os.Bundle r9 = r8.zzsi()
            r11.writeNoException()
            com.google.android.gms.internal.ads.zzfo.zzb(r11, r9)
            goto L_0x02e6
        L_0x00f5:
            android.os.Bundle r9 = r8.getInterstitialAdapterInfo()
            r11.writeNoException()
            com.google.android.gms.internal.ads.zzfo.zzb(r11, r9)
            goto L_0x02e6
        L_0x0101:
            android.os.Bundle r9 = r8.zzsh()
            r11.writeNoException()
            com.google.android.gms.internal.ads.zzfo.zzb(r11, r9)
            goto L_0x02e6
        L_0x010d:
            com.google.android.gms.internal.ads.zzand r9 = r8.zzsg()
            r11.writeNoException()
            com.google.android.gms.internal.ads.zzfo.zza((android.os.Parcel) r11, (android.os.IInterface) r9)
            goto L_0x02e6
        L_0x0119:
            com.google.android.gms.internal.ads.zzana r9 = r8.zzsf()
            r11.writeNoException()
            com.google.android.gms.internal.ads.zzfo.zza((android.os.Parcel) r11, (android.os.IInterface) r9)
            goto L_0x02e6
        L_0x0125:
            android.os.IBinder r9 = r10.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r1 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r9)
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzxz> r9 = com.google.android.gms.internal.ads.zzxz.CREATOR
            android.os.Parcelable r9 = com.google.android.gms.internal.ads.zzfo.zza((android.os.Parcel) r10, r9)
            r2 = r9
            com.google.android.gms.internal.ads.zzxz r2 = (com.google.android.gms.internal.ads.zzxz) r2
            java.lang.String r3 = r10.readString()
            java.lang.String r4 = r10.readString()
            android.os.IBinder r9 = r10.readStrongBinder()
            if (r9 != 0) goto L_0x0146
        L_0x0144:
            r5 = r12
            goto L_0x0159
        L_0x0146:
            java.lang.String r12 = "com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener"
            android.os.IInterface r12 = r9.queryLocalInterface(r12)
            boolean r0 = r12 instanceof com.google.android.gms.internal.ads.zzamv
            if (r0 == 0) goto L_0x0153
            com.google.android.gms.internal.ads.zzamv r12 = (com.google.android.gms.internal.ads.zzamv) r12
            goto L_0x0144
        L_0x0153:
            com.google.android.gms.internal.ads.zzamx r12 = new com.google.android.gms.internal.ads.zzamx
            r12.<init>(r9)
            goto L_0x0144
        L_0x0159:
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzady> r9 = com.google.android.gms.internal.ads.zzady.CREATOR
            android.os.Parcelable r9 = com.google.android.gms.internal.ads.zzfo.zza((android.os.Parcel) r10, r9)
            r6 = r9
            com.google.android.gms.internal.ads.zzady r6 = (com.google.android.gms.internal.ads.zzady) r6
            java.util.ArrayList r7 = r10.createStringArrayList()
            r0 = r8
            r0.zza(r1, r2, r3, r4, r5, r6, r7)
            r11.writeNoException()
            goto L_0x02e6
        L_0x016f:
            boolean r9 = r8.isInitialized()
            r11.writeNoException()
            com.google.android.gms.internal.ads.zzfo.writeBoolean(r11, r9)
            goto L_0x02e6
        L_0x017b:
            r8.showVideo()
            r11.writeNoException()
            goto L_0x02e6
        L_0x0183:
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzxz> r9 = com.google.android.gms.internal.ads.zzxz.CREATOR
            android.os.Parcelable r9 = com.google.android.gms.internal.ads.zzfo.zza((android.os.Parcel) r10, r9)
            com.google.android.gms.internal.ads.zzxz r9 = (com.google.android.gms.internal.ads.zzxz) r9
            java.lang.String r10 = r10.readString()
            r8.zza(r9, r10)
            r11.writeNoException()
            goto L_0x02e6
        L_0x0197:
            android.os.IBinder r9 = r10.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r1 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r9)
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzxz> r9 = com.google.android.gms.internal.ads.zzxz.CREATOR
            android.os.Parcelable r9 = com.google.android.gms.internal.ads.zzfo.zza((android.os.Parcel) r10, r9)
            r2 = r9
            com.google.android.gms.internal.ads.zzxz r2 = (com.google.android.gms.internal.ads.zzxz) r2
            java.lang.String r3 = r10.readString()
            android.os.IBinder r9 = r10.readStrongBinder()
            com.google.android.gms.internal.ads.zzatk r4 = com.google.android.gms.internal.ads.zzatl.zzai(r9)
            java.lang.String r5 = r10.readString()
            r0 = r8
            r0.zza((com.google.android.gms.dynamic.IObjectWrapper) r1, (com.google.android.gms.internal.ads.zzxz) r2, (java.lang.String) r3, (com.google.android.gms.internal.ads.zzatk) r4, (java.lang.String) r5)
            r11.writeNoException()
            goto L_0x02e6
        L_0x01c1:
            r8.resume()
            r11.writeNoException()
            goto L_0x02e6
        L_0x01c9:
            r8.pause()
            r11.writeNoException()
            goto L_0x02e6
        L_0x01d1:
            android.os.IBinder r9 = r10.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r1 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r9)
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzxz> r9 = com.google.android.gms.internal.ads.zzxz.CREATOR
            android.os.Parcelable r9 = com.google.android.gms.internal.ads.zzfo.zza((android.os.Parcel) r10, r9)
            r2 = r9
            com.google.android.gms.internal.ads.zzxz r2 = (com.google.android.gms.internal.ads.zzxz) r2
            java.lang.String r3 = r10.readString()
            java.lang.String r4 = r10.readString()
            android.os.IBinder r9 = r10.readStrongBinder()
            if (r9 != 0) goto L_0x01f2
        L_0x01f0:
            r5 = r12
            goto L_0x0206
        L_0x01f2:
            java.lang.String r10 = "com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener"
            android.os.IInterface r10 = r9.queryLocalInterface(r10)
            boolean r12 = r10 instanceof com.google.android.gms.internal.ads.zzamv
            if (r12 == 0) goto L_0x0200
            r12 = r10
            com.google.android.gms.internal.ads.zzamv r12 = (com.google.android.gms.internal.ads.zzamv) r12
            goto L_0x01f0
        L_0x0200:
            com.google.android.gms.internal.ads.zzamx r12 = new com.google.android.gms.internal.ads.zzamx
            r12.<init>(r9)
            goto L_0x01f0
        L_0x0206:
            r0 = r8
            r0.zza((com.google.android.gms.dynamic.IObjectWrapper) r1, (com.google.android.gms.internal.ads.zzxz) r2, (java.lang.String) r3, (java.lang.String) r4, (com.google.android.gms.internal.ads.zzamv) r5)
            r11.writeNoException()
            goto L_0x02e6
        L_0x020f:
            android.os.IBinder r9 = r10.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r1 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r9)
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzyd> r9 = com.google.android.gms.internal.ads.zzyd.CREATOR
            android.os.Parcelable r9 = com.google.android.gms.internal.ads.zzfo.zza((android.os.Parcel) r10, r9)
            r2 = r9
            com.google.android.gms.internal.ads.zzyd r2 = (com.google.android.gms.internal.ads.zzyd) r2
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzxz> r9 = com.google.android.gms.internal.ads.zzxz.CREATOR
            android.os.Parcelable r9 = com.google.android.gms.internal.ads.zzfo.zza((android.os.Parcel) r10, r9)
            r3 = r9
            com.google.android.gms.internal.ads.zzxz r3 = (com.google.android.gms.internal.ads.zzxz) r3
            java.lang.String r4 = r10.readString()
            java.lang.String r5 = r10.readString()
            android.os.IBinder r9 = r10.readStrongBinder()
            if (r9 != 0) goto L_0x0239
        L_0x0237:
            r6 = r12
            goto L_0x024d
        L_0x0239:
            java.lang.String r10 = "com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener"
            android.os.IInterface r10 = r9.queryLocalInterface(r10)
            boolean r12 = r10 instanceof com.google.android.gms.internal.ads.zzamv
            if (r12 == 0) goto L_0x0247
            r12 = r10
            com.google.android.gms.internal.ads.zzamv r12 = (com.google.android.gms.internal.ads.zzamv) r12
            goto L_0x0237
        L_0x0247:
            com.google.android.gms.internal.ads.zzamx r12 = new com.google.android.gms.internal.ads.zzamx
            r12.<init>(r9)
            goto L_0x0237
        L_0x024d:
            r0 = r8
            r0.zza(r1, r2, r3, r4, r5, r6)
            r11.writeNoException()
            goto L_0x02e6
        L_0x0256:
            r8.destroy()
            r11.writeNoException()
            goto L_0x02e6
        L_0x025e:
            r8.showInterstitial()
            r11.writeNoException()
            goto L_0x02e6
        L_0x0266:
            android.os.IBinder r9 = r10.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r9 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r9)
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzxz> r0 = com.google.android.gms.internal.ads.zzxz.CREATOR
            android.os.Parcelable r0 = com.google.android.gms.internal.ads.zzfo.zza((android.os.Parcel) r10, r0)
            com.google.android.gms.internal.ads.zzxz r0 = (com.google.android.gms.internal.ads.zzxz) r0
            java.lang.String r1 = r10.readString()
            android.os.IBinder r10 = r10.readStrongBinder()
            if (r10 != 0) goto L_0x0281
            goto L_0x0293
        L_0x0281:
            java.lang.String r12 = "com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener"
            android.os.IInterface r12 = r10.queryLocalInterface(r12)
            boolean r2 = r12 instanceof com.google.android.gms.internal.ads.zzamv
            if (r2 == 0) goto L_0x028e
            com.google.android.gms.internal.ads.zzamv r12 = (com.google.android.gms.internal.ads.zzamv) r12
            goto L_0x0293
        L_0x028e:
            com.google.android.gms.internal.ads.zzamx r12 = new com.google.android.gms.internal.ads.zzamx
            r12.<init>(r10)
        L_0x0293:
            r8.zza(r9, r0, r1, r12)
            r11.writeNoException()
            goto L_0x02e6
        L_0x029a:
            com.google.android.gms.dynamic.IObjectWrapper r9 = r8.zzse()
            r11.writeNoException()
            com.google.android.gms.internal.ads.zzfo.zza((android.os.Parcel) r11, (android.os.IInterface) r9)
            goto L_0x02e6
        L_0x02a5:
            android.os.IBinder r9 = r10.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r1 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r9)
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzyd> r9 = com.google.android.gms.internal.ads.zzyd.CREATOR
            android.os.Parcelable r9 = com.google.android.gms.internal.ads.zzfo.zza((android.os.Parcel) r10, r9)
            r2 = r9
            com.google.android.gms.internal.ads.zzyd r2 = (com.google.android.gms.internal.ads.zzyd) r2
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzxz> r9 = com.google.android.gms.internal.ads.zzxz.CREATOR
            android.os.Parcelable r9 = com.google.android.gms.internal.ads.zzfo.zza((android.os.Parcel) r10, r9)
            r3 = r9
            com.google.android.gms.internal.ads.zzxz r3 = (com.google.android.gms.internal.ads.zzxz) r3
            java.lang.String r4 = r10.readString()
            android.os.IBinder r9 = r10.readStrongBinder()
            if (r9 != 0) goto L_0x02cb
        L_0x02c9:
            r5 = r12
            goto L_0x02df
        L_0x02cb:
            java.lang.String r10 = "com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener"
            android.os.IInterface r10 = r9.queryLocalInterface(r10)
            boolean r12 = r10 instanceof com.google.android.gms.internal.ads.zzamv
            if (r12 == 0) goto L_0x02d9
            r12 = r10
            com.google.android.gms.internal.ads.zzamv r12 = (com.google.android.gms.internal.ads.zzamv) r12
            goto L_0x02c9
        L_0x02d9:
            com.google.android.gms.internal.ads.zzamx r12 = new com.google.android.gms.internal.ads.zzamx
            r12.<init>(r9)
            goto L_0x02c9
        L_0x02df:
            r0 = r8
            r0.zza((com.google.android.gms.dynamic.IObjectWrapper) r1, (com.google.android.gms.internal.ads.zzyd) r2, (com.google.android.gms.internal.ads.zzxz) r3, (java.lang.String) r4, (com.google.android.gms.internal.ads.zzamv) r5)
            r11.writeNoException()
        L_0x02e6:
            r9 = 1
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzamt.dispatchTransaction(int, android.os.Parcel, android.os.Parcel, int):boolean");
    }
}
