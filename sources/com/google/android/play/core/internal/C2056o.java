package com.google.android.play.core.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: com.google.android.play.core.internal.o */
public abstract class C2056o extends C2051j implements C2057p {
    public C2056o() {
        super("com.google.android.play.core.appupdate.protocol.IAppUpdateServiceCallback");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final boolean mo33545a(int i, Parcel parcel) throws RemoteException {
        switch (i) {
            case 2:
                mo33273a((Bundle) C2052k.m776a(parcel, Bundle.CREATOR));
                return true;
            case 3:
                mo33274b((Bundle) C2052k.m776a(parcel, Bundle.CREATOR));
                return true;
            default:
                return false;
        }
    }
}
