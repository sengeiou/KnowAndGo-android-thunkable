package com.google.android.play.core.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: com.google.android.play.core.internal.i */
public class C2050i implements IInterface {

    /* renamed from: a */
    private final IBinder f788a;

    /* renamed from: b */
    private final String f789b;

    protected C2050i(IBinder iBinder, String str) {
        this.f788a = iBinder;
        this.f789b = str;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final Parcel mo33633a() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.f789b);
        return obtain;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo33634a(int i, Parcel parcel) throws RemoteException {
        try {
            this.f788a.transact(i, parcel, (Parcel) null, 1);
        } finally {
            parcel.recycle();
        }
    }

    public final IBinder asBinder() {
        return this.f788a;
    }
}
