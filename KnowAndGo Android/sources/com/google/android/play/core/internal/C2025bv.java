package com.google.android.play.core.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

/* renamed from: com.google.android.play.core.internal.bv */
public abstract class C2025bv extends C2051j implements C2026bw {
    public C2025bv() {
        super("com.google.android.play.core.splitinstall.protocol.ISplitInstallServiceCallback");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final boolean mo33545a(int i, Parcel parcel) throws RemoteException {
        switch (i) {
            case 2:
                mo33595c(parcel.readInt(), (Bundle) C2052k.m776a(parcel, Bundle.CREATOR));
                return true;
            case 3:
                int readInt = parcel.readInt();
                Bundle bundle = (Bundle) C2052k.m776a(parcel, Bundle.CREATOR);
                mo33588a(readInt);
                return true;
            case 4:
                mo33589a(parcel.readInt(), (Bundle) C2052k.m776a(parcel, Bundle.CREATOR));
                return true;
            case 5:
                mo33593b(parcel.readInt(), (Bundle) C2052k.m776a(parcel, Bundle.CREATOR));
                return true;
            case 6:
                mo33598e((Bundle) C2052k.m776a(parcel, Bundle.CREATOR));
                return true;
            case 7:
                mo33591a((List<Bundle>) parcel.createTypedArrayList(Bundle.CREATOR));
                return true;
            case 8:
                mo33597d((Bundle) C2052k.m776a(parcel, Bundle.CREATOR));
                return true;
            case 9:
                mo33590a((Bundle) C2052k.m776a(parcel, Bundle.CREATOR));
                return true;
            case 10:
                Bundle bundle2 = (Bundle) C2052k.m776a(parcel, Bundle.CREATOR);
                mo33592b();
                return true;
            case 11:
                Bundle bundle3 = (Bundle) C2052k.m776a(parcel, Bundle.CREATOR);
                mo33587a();
                return true;
            case 12:
                mo33594b((Bundle) C2052k.m776a(parcel, Bundle.CREATOR));
                return true;
            case 13:
                mo33596c((Bundle) C2052k.m776a(parcel, Bundle.CREATOR));
                return true;
            default:
                return false;
        }
    }
}
