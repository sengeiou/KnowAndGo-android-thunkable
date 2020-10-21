package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;

public abstract class zzzl extends zzfn implements zzzk {
    public zzzl() {
        super("com.google.android.gms.ads.internal.client.IAdManager");
    }

    public static zzzk zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
        if (queryLocalInterface instanceof zzzk) {
            return (zzzk) queryLocalInterface;
        }
        return new zzzm(iBinder);
    }

    /* JADX WARNING: type inference failed for: r4v1 */
    /* JADX WARNING: type inference failed for: r4v2, types: [com.google.android.gms.internal.ads.zzyz] */
    /* JADX WARNING: type inference failed for: r4v7, types: [com.google.android.gms.internal.ads.zzzs] */
    /* JADX WARNING: type inference failed for: r4v12, types: [com.google.android.gms.internal.ads.zzyw] */
    /* JADX WARNING: type inference failed for: r4v17, types: [com.google.android.gms.internal.ads.zzzy] */
    /* JADX WARNING: type inference failed for: r4v22, types: [com.google.android.gms.internal.ads.zzzp] */
    /* JADX WARNING: type inference failed for: r4v27 */
    /* JADX WARNING: type inference failed for: r4v28 */
    /* JADX WARNING: type inference failed for: r4v29 */
    /* JADX WARNING: type inference failed for: r4v30 */
    /* JADX WARNING: type inference failed for: r4v31 */
    /* JADX WARNING: type inference failed for: r4v32 */
    /* JADX WARNING: type inference failed for: r4v33 */
    /* JADX WARNING: type inference failed for: r4v34 */
    /* JADX WARNING: type inference failed for: r4v35 */
    /* JADX WARNING: type inference failed for: r4v36 */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean dispatchTransaction(int r1, android.os.Parcel r2, android.os.Parcel r3, int r4) throws android.os.RemoteException {
        /*
            r0 = this;
            r4 = 0
            switch(r1) {
                case 1: goto L_0x0209;
                case 2: goto L_0x0202;
                case 3: goto L_0x01f7;
                case 4: goto L_0x01e4;
                case 5: goto L_0x01dd;
                case 6: goto L_0x01d6;
                case 7: goto L_0x01b5;
                case 8: goto L_0x0194;
                case 9: goto L_0x018c;
                case 10: goto L_0x0184;
                case 11: goto L_0x017c;
                case 12: goto L_0x0170;
                case 13: goto L_0x0160;
                case 14: goto L_0x0150;
                case 15: goto L_0x013c;
                case 16: goto L_0x0004;
                case 17: goto L_0x0004;
                case 18: goto L_0x0130;
                case 19: goto L_0x0120;
                case 20: goto L_0x00fe;
                case 21: goto L_0x00dc;
                case 22: goto L_0x00d0;
                case 23: goto L_0x00c4;
                case 24: goto L_0x00b4;
                case 25: goto L_0x00a8;
                case 26: goto L_0x009c;
                case 27: goto L_0x0004;
                case 28: goto L_0x0004;
                case 29: goto L_0x008c;
                case 30: goto L_0x007c;
                case 31: goto L_0x0070;
                case 32: goto L_0x0064;
                case 33: goto L_0x0058;
                case 34: goto L_0x004c;
                case 35: goto L_0x0040;
                case 36: goto L_0x001e;
                case 37: goto L_0x0012;
                case 38: goto L_0x0006;
                default: goto L_0x0004;
            }
        L_0x0004:
            r1 = 0
            return r1
        L_0x0006:
            java.lang.String r1 = r2.readString()
            r0.zzbt(r1)
            r3.writeNoException()
            goto L_0x0213
        L_0x0012:
            android.os.Bundle r1 = r0.getAdMetadata()
            r3.writeNoException()
            com.google.android.gms.internal.ads.zzfo.zzb(r3, r1)
            goto L_0x0213
        L_0x001e:
            android.os.IBinder r1 = r2.readStrongBinder()
            if (r1 != 0) goto L_0x0025
            goto L_0x0038
        L_0x0025:
            java.lang.String r2 = "com.google.android.gms.ads.internal.client.IAdMetadataListener"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r4 = r2 instanceof com.google.android.gms.internal.ads.zzzp
            if (r4 == 0) goto L_0x0033
            r4 = r2
            com.google.android.gms.internal.ads.zzzp r4 = (com.google.android.gms.internal.ads.zzzp) r4
            goto L_0x0038
        L_0x0033:
            com.google.android.gms.internal.ads.zzzr r4 = new com.google.android.gms.internal.ads.zzzr
            r4.<init>(r1)
        L_0x0038:
            r0.zza((com.google.android.gms.internal.ads.zzzp) r4)
            r3.writeNoException()
            goto L_0x0213
        L_0x0040:
            java.lang.String r1 = r0.zzpj()
            r3.writeNoException()
            r3.writeString(r1)
            goto L_0x0213
        L_0x004c:
            boolean r1 = com.google.android.gms.internal.ads.zzfo.zza(r2)
            r0.setImmersiveMode(r1)
            r3.writeNoException()
            goto L_0x0213
        L_0x0058:
            com.google.android.gms.internal.ads.zzyz r1 = r0.zzpp()
            r3.writeNoException()
            com.google.android.gms.internal.ads.zzfo.zza((android.os.Parcel) r3, (android.os.IInterface) r1)
            goto L_0x0213
        L_0x0064:
            com.google.android.gms.internal.ads.zzzs r1 = r0.zzpo()
            r3.writeNoException()
            com.google.android.gms.internal.ads.zzfo.zza((android.os.Parcel) r3, (android.os.IInterface) r1)
            goto L_0x0213
        L_0x0070:
            java.lang.String r1 = r0.getAdUnitId()
            r3.writeNoException()
            r3.writeString(r1)
            goto L_0x0213
        L_0x007c:
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzaax> r1 = com.google.android.gms.internal.ads.zzaax.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.internal.ads.zzfo.zza((android.os.Parcel) r2, r1)
            com.google.android.gms.internal.ads.zzaax r1 = (com.google.android.gms.internal.ads.zzaax) r1
            r0.zza((com.google.android.gms.internal.ads.zzaax) r1)
            r3.writeNoException()
            goto L_0x0213
        L_0x008c:
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzacd> r1 = com.google.android.gms.internal.ads.zzacd.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.internal.ads.zzfo.zza((android.os.Parcel) r2, r1)
            com.google.android.gms.internal.ads.zzacd r1 = (com.google.android.gms.internal.ads.zzacd) r1
            r0.zza((com.google.android.gms.internal.ads.zzacd) r1)
            r3.writeNoException()
            goto L_0x0213
        L_0x009c:
            com.google.android.gms.internal.ads.zzaar r1 = r0.getVideoController()
            r3.writeNoException()
            com.google.android.gms.internal.ads.zzfo.zza((android.os.Parcel) r3, (android.os.IInterface) r1)
            goto L_0x0213
        L_0x00a8:
            java.lang.String r1 = r2.readString()
            r0.setUserId(r1)
            r3.writeNoException()
            goto L_0x0213
        L_0x00b4:
            android.os.IBinder r1 = r2.readStrongBinder()
            com.google.android.gms.internal.ads.zzatb r1 = com.google.android.gms.internal.ads.zzatc.zzah(r1)
            r0.zza((com.google.android.gms.internal.ads.zzatb) r1)
            r3.writeNoException()
            goto L_0x0213
        L_0x00c4:
            boolean r1 = r0.isLoading()
            r3.writeNoException()
            com.google.android.gms.internal.ads.zzfo.writeBoolean(r3, r1)
            goto L_0x0213
        L_0x00d0:
            boolean r1 = com.google.android.gms.internal.ads.zzfo.zza(r2)
            r0.setManualImpressionsEnabled(r1)
            r3.writeNoException()
            goto L_0x0213
        L_0x00dc:
            android.os.IBinder r1 = r2.readStrongBinder()
            if (r1 != 0) goto L_0x00e3
            goto L_0x00f6
        L_0x00e3:
            java.lang.String r2 = "com.google.android.gms.ads.internal.client.ICorrelationIdProvider"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r4 = r2 instanceof com.google.android.gms.internal.ads.zzzy
            if (r4 == 0) goto L_0x00f1
            r4 = r2
            com.google.android.gms.internal.ads.zzzy r4 = (com.google.android.gms.internal.ads.zzzy) r4
            goto L_0x00f6
        L_0x00f1:
            com.google.android.gms.internal.ads.zzaaa r4 = new com.google.android.gms.internal.ads.zzaaa
            r4.<init>(r1)
        L_0x00f6:
            r0.zzb((com.google.android.gms.internal.ads.zzzy) r4)
            r3.writeNoException()
            goto L_0x0213
        L_0x00fe:
            android.os.IBinder r1 = r2.readStrongBinder()
            if (r1 != 0) goto L_0x0105
            goto L_0x0118
        L_0x0105:
            java.lang.String r2 = "com.google.android.gms.ads.internal.client.IAdClickListener"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r4 = r2 instanceof com.google.android.gms.internal.ads.zzyw
            if (r4 == 0) goto L_0x0113
            r4 = r2
            com.google.android.gms.internal.ads.zzyw r4 = (com.google.android.gms.internal.ads.zzyw) r4
            goto L_0x0118
        L_0x0113:
            com.google.android.gms.internal.ads.zzyy r4 = new com.google.android.gms.internal.ads.zzyy
            r4.<init>(r1)
        L_0x0118:
            r0.zza((com.google.android.gms.internal.ads.zzyw) r4)
            r3.writeNoException()
            goto L_0x0213
        L_0x0120:
            android.os.IBinder r1 = r2.readStrongBinder()
            com.google.android.gms.internal.ads.zzado r1 = com.google.android.gms.internal.ads.zzadp.zzi(r1)
            r0.zza((com.google.android.gms.internal.ads.zzado) r1)
            r3.writeNoException()
            goto L_0x0213
        L_0x0130:
            java.lang.String r1 = r0.getMediationAdapterClassName()
            r3.writeNoException()
            r3.writeString(r1)
            goto L_0x0213
        L_0x013c:
            android.os.IBinder r1 = r2.readStrongBinder()
            com.google.android.gms.internal.ads.zzaqt r1 = com.google.android.gms.internal.ads.zzaqu.zzaf(r1)
            java.lang.String r2 = r2.readString()
            r0.zza(r1, r2)
            r3.writeNoException()
            goto L_0x0213
        L_0x0150:
            android.os.IBinder r1 = r2.readStrongBinder()
            com.google.android.gms.internal.ads.zzaqn r1 = com.google.android.gms.internal.ads.zzaqo.zzad(r1)
            r0.zza((com.google.android.gms.internal.ads.zzaqn) r1)
            r3.writeNoException()
            goto L_0x0213
        L_0x0160:
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzyd> r1 = com.google.android.gms.internal.ads.zzyd.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.internal.ads.zzfo.zza((android.os.Parcel) r2, r1)
            com.google.android.gms.internal.ads.zzyd r1 = (com.google.android.gms.internal.ads.zzyd) r1
            r0.zza((com.google.android.gms.internal.ads.zzyd) r1)
            r3.writeNoException()
            goto L_0x0213
        L_0x0170:
            com.google.android.gms.internal.ads.zzyd r1 = r0.zzpn()
            r3.writeNoException()
            com.google.android.gms.internal.ads.zzfo.zzb(r3, r1)
            goto L_0x0213
        L_0x017c:
            r0.zzpm()
            r3.writeNoException()
            goto L_0x0213
        L_0x0184:
            r0.stopLoading()
            r3.writeNoException()
            goto L_0x0213
        L_0x018c:
            r0.showInterstitial()
            r3.writeNoException()
            goto L_0x0213
        L_0x0194:
            android.os.IBinder r1 = r2.readStrongBinder()
            if (r1 != 0) goto L_0x019b
            goto L_0x01ae
        L_0x019b:
            java.lang.String r2 = "com.google.android.gms.ads.internal.client.IAppEventListener"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r4 = r2 instanceof com.google.android.gms.internal.ads.zzzs
            if (r4 == 0) goto L_0x01a9
            r4 = r2
            com.google.android.gms.internal.ads.zzzs r4 = (com.google.android.gms.internal.ads.zzzs) r4
            goto L_0x01ae
        L_0x01a9:
            com.google.android.gms.internal.ads.zzzu r4 = new com.google.android.gms.internal.ads.zzzu
            r4.<init>(r1)
        L_0x01ae:
            r0.zza((com.google.android.gms.internal.ads.zzzs) r4)
            r3.writeNoException()
            goto L_0x0213
        L_0x01b5:
            android.os.IBinder r1 = r2.readStrongBinder()
            if (r1 != 0) goto L_0x01bc
            goto L_0x01cf
        L_0x01bc:
            java.lang.String r2 = "com.google.android.gms.ads.internal.client.IAdListener"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r4 = r2 instanceof com.google.android.gms.internal.ads.zzyz
            if (r4 == 0) goto L_0x01ca
            r4 = r2
            com.google.android.gms.internal.ads.zzyz r4 = (com.google.android.gms.internal.ads.zzyz) r4
            goto L_0x01cf
        L_0x01ca:
            com.google.android.gms.internal.ads.zzzb r4 = new com.google.android.gms.internal.ads.zzzb
            r4.<init>(r1)
        L_0x01cf:
            r0.zzb((com.google.android.gms.internal.ads.zzyz) r4)
            r3.writeNoException()
            goto L_0x0213
        L_0x01d6:
            r0.resume()
            r3.writeNoException()
            goto L_0x0213
        L_0x01dd:
            r0.pause()
            r3.writeNoException()
            goto L_0x0213
        L_0x01e4:
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzxz> r1 = com.google.android.gms.internal.ads.zzxz.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.internal.ads.zzfo.zza((android.os.Parcel) r2, r1)
            com.google.android.gms.internal.ads.zzxz r1 = (com.google.android.gms.internal.ads.zzxz) r1
            boolean r1 = r0.zzb((com.google.android.gms.internal.ads.zzxz) r1)
            r3.writeNoException()
            com.google.android.gms.internal.ads.zzfo.writeBoolean(r3, r1)
            goto L_0x0213
        L_0x01f7:
            boolean r1 = r0.isReady()
            r3.writeNoException()
            com.google.android.gms.internal.ads.zzfo.writeBoolean(r3, r1)
            goto L_0x0213
        L_0x0202:
            r0.destroy()
            r3.writeNoException()
            goto L_0x0213
        L_0x0209:
            com.google.android.gms.dynamic.IObjectWrapper r1 = r0.zzpl()
            r3.writeNoException()
            com.google.android.gms.internal.ads.zzfo.zza((android.os.Parcel) r3, (android.os.IInterface) r1)
        L_0x0213:
            r1 = 1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzzl.dispatchTransaction(int, android.os.Parcel, android.os.Parcel, int):boolean");
    }
}
