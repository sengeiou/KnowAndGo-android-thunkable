package com.google.android.play.core.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

/* renamed from: com.google.android.play.core.internal.x */
public final class C2065x extends C2050i implements C2066y {
    C2065x(IBinder iBinder) {
        super(iBinder, "com.google.android.play.core.assetpacks.protocol.IAssetPackExtractionServiceCallback");
    }

    /* renamed from: a */
    public final void mo33650a(Bundle bundle) throws RemoteException {
        Parcel a = mo33633a();
        C2052k.m778a(a, (Parcelable) bundle);
        mo33634a(3, a);
    }

    /* renamed from: a */
    public final void mo33651a(Bundle bundle, Bundle bundle2) throws RemoteException {
        Parcel a = mo33633a();
        C2052k.m778a(a, (Parcelable) bundle);
        C2052k.m778a(a, (Parcelable) bundle2);
        mo33634a(2, a);
    }

    /* renamed from: b */
    public final void mo33652b(Bundle bundle) throws RemoteException {
        Parcel a = mo33633a();
        C2052k.m778a(a, (Parcelable) bundle);
        mo33634a(4, a);
    }
}
