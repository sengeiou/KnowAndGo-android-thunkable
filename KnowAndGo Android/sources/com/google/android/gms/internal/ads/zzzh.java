package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;

public final class zzzh extends zzfm implements zzzf {
    zzzh(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
    }

    /* JADX WARNING: type inference failed for: r2v1, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzzc zzpk() throws android.os.RemoteException {
        /*
            r4 = this;
            android.os.Parcel r0 = r4.obtainAndWriteInterfaceToken()
            r1 = 1
            android.os.Parcel r0 = r4.transactAndReadException(r1, r0)
            android.os.IBinder r1 = r0.readStrongBinder()
            if (r1 != 0) goto L_0x0011
            r1 = 0
            goto L_0x0025
        L_0x0011:
            java.lang.String r2 = "com.google.android.gms.ads.internal.client.IAdLoader"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.internal.ads.zzzc
            if (r3 == 0) goto L_0x001f
            r1 = r2
            com.google.android.gms.internal.ads.zzzc r1 = (com.google.android.gms.internal.ads.zzzc) r1
            goto L_0x0025
        L_0x001f:
            com.google.android.gms.internal.ads.zzze r2 = new com.google.android.gms.internal.ads.zzze
            r2.<init>(r1)
            r1 = r2
        L_0x0025:
            r0.recycle()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzzh.zzpk():com.google.android.gms.internal.ads.zzzc");
    }

    public final void zza(zzyz zzyz) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzfo.zza(obtainAndWriteInterfaceToken, (IInterface) zzyz);
        zza(2, obtainAndWriteInterfaceToken);
    }

    public final void zza(zzafi zzafi) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzfo.zza(obtainAndWriteInterfaceToken, (IInterface) zzafi);
        zza(3, obtainAndWriteInterfaceToken);
    }

    public final void zza(zzafl zzafl) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzfo.zza(obtainAndWriteInterfaceToken, (IInterface) zzafl);
        zza(4, obtainAndWriteInterfaceToken);
    }

    public final void zza(String str, zzafr zzafr, zzafo zzafo) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        obtainAndWriteInterfaceToken.writeString(str);
        zzfo.zza(obtainAndWriteInterfaceToken, (IInterface) zzafr);
        zzfo.zza(obtainAndWriteInterfaceToken, (IInterface) zzafo);
        zza(5, obtainAndWriteInterfaceToken);
    }

    public final void zza(zzady zzady) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzfo.zza(obtainAndWriteInterfaceToken, (Parcelable) zzady);
        zza(6, obtainAndWriteInterfaceToken);
    }

    public final void zza(zzzy zzzy) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzfo.zza(obtainAndWriteInterfaceToken, (IInterface) zzzy);
        zza(7, obtainAndWriteInterfaceToken);
    }

    public final void zza(zzafu zzafu, zzyd zzyd) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzfo.zza(obtainAndWriteInterfaceToken, (IInterface) zzafu);
        zzfo.zza(obtainAndWriteInterfaceToken, (Parcelable) zzyd);
        zza(8, obtainAndWriteInterfaceToken);
    }

    public final void zza(PublisherAdViewOptions publisherAdViewOptions) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzfo.zza(obtainAndWriteInterfaceToken, (Parcelable) publisherAdViewOptions);
        zza(9, obtainAndWriteInterfaceToken);
    }

    public final void zza(zzafx zzafx) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzfo.zza(obtainAndWriteInterfaceToken, (IInterface) zzafx);
        zza(10, obtainAndWriteInterfaceToken);
    }

    public final void zza(zzaiy zzaiy) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzfo.zza(obtainAndWriteInterfaceToken, (Parcelable) zzaiy);
        zza(13, obtainAndWriteInterfaceToken);
    }

    public final void zza(zzaje zzaje) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzfo.zza(obtainAndWriteInterfaceToken, (IInterface) zzaje);
        zza(14, obtainAndWriteInterfaceToken);
    }
}
