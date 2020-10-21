package com.google.android.finsky.externalreferrer;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.p011a.C1445a;
import com.google.android.p011a.C1446b;
import com.google.android.p011a.C1447c;

public interface IGetInstallReferrerService extends IInterface {

    public static abstract class Stub extends C1446b implements IGetInstallReferrerService {

        public static class Proxy extends C1445a implements IGetInstallReferrerService {
            Proxy(IBinder iBinder) {
                super(iBinder, "com.google.android.finsky.externalreferrer.IGetInstallReferrerService");
            }

            /* renamed from: a */
            public final Bundle mo20689a(Bundle bundle) throws RemoteException {
                Parcel a = mo17828a();
                C1447c.m148a(a, (Parcelable) bundle);
                Parcel a2 = mo17829a(a);
                Bundle bundle2 = (Bundle) C1447c.m147a(a2, Bundle.CREATOR);
                a2.recycle();
                return bundle2;
            }
        }

        public Stub() {
            super("com.google.android.finsky.externalreferrer.IGetInstallReferrerService");
        }

        /* renamed from: a */
        public static IGetInstallReferrerService m160a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.finsky.externalreferrer.IGetInstallReferrerService");
            if (queryLocalInterface instanceof IGetInstallReferrerService) {
                return (IGetInstallReferrerService) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }
    }

    /* renamed from: a */
    Bundle mo20689a(Bundle bundle) throws RemoteException;
}
