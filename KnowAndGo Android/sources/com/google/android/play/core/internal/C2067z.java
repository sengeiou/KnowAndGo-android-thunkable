package com.google.android.play.core.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

/* renamed from: com.google.android.play.core.internal.z */
public final class C2067z extends C2050i implements C1978ab {
    C2067z(IBinder iBinder) {
        super(iBinder, "com.google.android.play.core.inappreview.protocol.IInAppReviewService");
    }

    /* renamed from: a */
    public final void mo33544a(String str, Bundle bundle, C1980ad adVar) throws RemoteException {
        Parcel a = mo33633a();
        a.writeString(str);
        C2052k.m778a(a, (Parcelable) bundle);
        C2052k.m777a(a, (IInterface) adVar);
        mo33634a(2, a);
    }
}
