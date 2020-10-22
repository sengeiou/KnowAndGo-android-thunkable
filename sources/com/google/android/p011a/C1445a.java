package com.google.android.p011a;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: com.google.android.a.a */
/* compiled from: BaseProxy */
public class C1445a implements IInterface {

    /* renamed from: a */
    private final IBinder f127a;

    /* renamed from: b */
    private final String f128b;

    protected C1445a(IBinder iBinder, String str) {
        this.f127a = iBinder;
        this.f128b = str;
    }

    public final IBinder asBinder() {
        return this.f127a;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final Parcel mo17828a() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.f128b);
        return obtain;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final Parcel mo17829a(Parcel parcel) throws RemoteException {
        parcel = Parcel.obtain();
        try {
            this.f127a.transact(1, parcel, parcel, 0);
            parcel.readException();
            return parcel;
        } catch (RuntimeException e) {
            throw e;
        } finally {
            parcel.recycle();
        }
    }
}
