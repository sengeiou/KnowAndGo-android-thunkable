package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

public final class zzaox extends zzfm implements zzaov {
    zzaox(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.rtb.IRtbAdapter");
    }

    public final void zza(IObjectWrapper iObjectWrapper, String str, Bundle bundle, Bundle bundle2, zzyd zzyd, zzaoy zzaoy) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzfo.zza(obtainAndWriteInterfaceToken, (IInterface) iObjectWrapper);
        obtainAndWriteInterfaceToken.writeString(str);
        zzfo.zza(obtainAndWriteInterfaceToken, (Parcelable) bundle);
        zzfo.zza(obtainAndWriteInterfaceToken, (Parcelable) bundle2);
        zzfo.zza(obtainAndWriteInterfaceToken, (Parcelable) zzyd);
        zzfo.zza(obtainAndWriteInterfaceToken, (IInterface) zzaoy);
        zza(1, obtainAndWriteInterfaceToken);
    }

    public final zzapj zzsx() throws RemoteException {
        Parcel transactAndReadException = transactAndReadException(2, obtainAndWriteInterfaceToken());
        zzapj zzapj = (zzapj) zzfo.zza(transactAndReadException, zzapj.CREATOR);
        transactAndReadException.recycle();
        return zzapj;
    }

    public final zzapj zzsy() throws RemoteException {
        Parcel transactAndReadException = transactAndReadException(3, obtainAndWriteInterfaceToken());
        zzapj zzapj = (zzapj) zzfo.zza(transactAndReadException, zzapj.CREATOR);
        transactAndReadException.recycle();
        return zzapj;
    }

    public final zzaar getVideoController() throws RemoteException {
        Parcel transactAndReadException = transactAndReadException(5, obtainAndWriteInterfaceToken());
        zzaar zzh = zzaas.zzh(transactAndReadException.readStrongBinder());
        transactAndReadException.recycle();
        return zzh;
    }

    public final void zzx(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzfo.zza(obtainAndWriteInterfaceToken, (IInterface) iObjectWrapper);
        zza(10, obtainAndWriteInterfaceToken);
    }

    public final void zza(String[] strArr, Bundle[] bundleArr) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        obtainAndWriteInterfaceToken.writeStringArray(strArr);
        obtainAndWriteInterfaceToken.writeTypedArray(bundleArr, 0);
        zza(11, obtainAndWriteInterfaceToken);
    }

    public final void zza(String str, String str2, zzxz zzxz, IObjectWrapper iObjectWrapper, zzaoj zzaoj, zzamv zzamv, zzyd zzyd) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        obtainAndWriteInterfaceToken.writeString(str);
        obtainAndWriteInterfaceToken.writeString(str2);
        zzfo.zza(obtainAndWriteInterfaceToken, (Parcelable) zzxz);
        zzfo.zza(obtainAndWriteInterfaceToken, (IInterface) iObjectWrapper);
        zzfo.zza(obtainAndWriteInterfaceToken, (IInterface) zzaoj);
        zzfo.zza(obtainAndWriteInterfaceToken, (IInterface) zzamv);
        zzfo.zza(obtainAndWriteInterfaceToken, (Parcelable) zzyd);
        zza(13, obtainAndWriteInterfaceToken);
    }

    public final void zza(String str, String str2, zzxz zzxz, IObjectWrapper iObjectWrapper, zzaom zzaom, zzamv zzamv) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        obtainAndWriteInterfaceToken.writeString(str);
        obtainAndWriteInterfaceToken.writeString(str2);
        zzfo.zza(obtainAndWriteInterfaceToken, (Parcelable) zzxz);
        zzfo.zza(obtainAndWriteInterfaceToken, (IInterface) iObjectWrapper);
        zzfo.zza(obtainAndWriteInterfaceToken, (IInterface) zzaom);
        zzfo.zza(obtainAndWriteInterfaceToken, (IInterface) zzamv);
        zza(14, obtainAndWriteInterfaceToken);
    }

    public final boolean zzy(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzfo.zza(obtainAndWriteInterfaceToken, (IInterface) iObjectWrapper);
        Parcel transactAndReadException = transactAndReadException(15, obtainAndWriteInterfaceToken);
        boolean zza = zzfo.zza(transactAndReadException);
        transactAndReadException.recycle();
        return zza;
    }

    public final void zza(String str, String str2, zzxz zzxz, IObjectWrapper iObjectWrapper, zzaos zzaos, zzamv zzamv) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        obtainAndWriteInterfaceToken.writeString(str);
        obtainAndWriteInterfaceToken.writeString(str2);
        zzfo.zza(obtainAndWriteInterfaceToken, (Parcelable) zzxz);
        zzfo.zza(obtainAndWriteInterfaceToken, (IInterface) iObjectWrapper);
        zzfo.zza(obtainAndWriteInterfaceToken, (IInterface) zzaos);
        zzfo.zza(obtainAndWriteInterfaceToken, (IInterface) zzamv);
        zza(16, obtainAndWriteInterfaceToken);
    }

    public final boolean zzz(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzfo.zza(obtainAndWriteInterfaceToken, (IInterface) iObjectWrapper);
        Parcel transactAndReadException = transactAndReadException(17, obtainAndWriteInterfaceToken);
        boolean zza = zzfo.zza(transactAndReadException);
        transactAndReadException.recycle();
        return zza;
    }

    public final void zza(String str, String str2, zzxz zzxz, IObjectWrapper iObjectWrapper, zzaop zzaop, zzamv zzamv) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        obtainAndWriteInterfaceToken.writeString(str);
        obtainAndWriteInterfaceToken.writeString(str2);
        zzfo.zza(obtainAndWriteInterfaceToken, (Parcelable) zzxz);
        zzfo.zza(obtainAndWriteInterfaceToken, (IInterface) iObjectWrapper);
        zzfo.zza(obtainAndWriteInterfaceToken, (IInterface) zzaop);
        zzfo.zza(obtainAndWriteInterfaceToken, (IInterface) zzamv);
        zza(18, obtainAndWriteInterfaceToken);
    }
}
