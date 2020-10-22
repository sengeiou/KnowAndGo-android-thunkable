package com.google.android.play.core.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

/* renamed from: com.google.android.play.core.internal.l */
public final class C2053l extends C2050i implements C2055n {
    C2053l(IBinder iBinder) {
        super(iBinder, "com.google.android.play.core.appupdate.protocol.IAppUpdateService");
    }

    /* renamed from: a */
    public final void mo33638a(String str, Bundle bundle, C2057p pVar) throws RemoteException {
        Parcel a = mo33633a();
        a.writeString(str);
        C2052k.m778a(a, (Parcelable) bundle);
        C2052k.m777a(a, (IInterface) pVar);
        mo33634a(2, a);
    }

    /* renamed from: b */
    public final void mo33639b(String str, Bundle bundle, C2057p pVar) throws RemoteException {
        Parcel a = mo33633a();
        a.writeString(str);
        C2052k.m778a(a, (Parcelable) bundle);
        C2052k.m777a(a, (IInterface) pVar);
        mo33634a(3, a);
    }
}
