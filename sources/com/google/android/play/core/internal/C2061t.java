package com.google.android.play.core.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

/* renamed from: com.google.android.play.core.internal.t */
public abstract class C2061t extends C2051j implements C2062u {
    public C2061t() {
        super("com.google.android.play.core.assetpacks.protocol.IAssetModuleServiceCallback");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final boolean mo33545a(int i, Parcel parcel) throws RemoteException {
        switch (i) {
            case 2:
                mo33342a(parcel.readInt(), (Bundle) C2052k.m776a(parcel, Bundle.CREATOR));
                return true;
            case 3:
                int readInt = parcel.readInt();
                Bundle bundle = (Bundle) C2052k.m776a(parcel, Bundle.CREATOR);
                mo33341a(readInt);
                return true;
            case 4:
                int readInt2 = parcel.readInt();
                Bundle bundle2 = (Bundle) C2052k.m776a(parcel, Bundle.CREATOR);
                mo33347b(readInt2);
                return true;
            case 5:
                mo33345a((List<Bundle>) parcel.createTypedArrayList(Bundle.CREATOR));
                return true;
            case 6:
                Bundle bundle3 = (Bundle) C2052k.m776a(parcel, Bundle.CREATOR);
                mo33348b((Bundle) C2052k.m776a(parcel, Bundle.CREATOR));
                return true;
            case 7:
                mo33343a((Bundle) C2052k.m776a(parcel, Bundle.CREATOR));
                return true;
            case 8:
                Bundle bundle4 = (Bundle) C2052k.m776a(parcel, Bundle.CREATOR);
                mo33350c((Bundle) C2052k.m776a(parcel, Bundle.CREATOR));
                return true;
            case 10:
                Bundle bundle5 = (Bundle) C2052k.m776a(parcel, Bundle.CREATOR);
                mo33352d((Bundle) C2052k.m776a(parcel, Bundle.CREATOR));
                return true;
            case 11:
                mo33344a((Bundle) C2052k.m776a(parcel, Bundle.CREATOR), (Bundle) C2052k.m776a(parcel, Bundle.CREATOR));
                return true;
            case 12:
                mo33349b((Bundle) C2052k.m776a(parcel, Bundle.CREATOR), (Bundle) C2052k.m776a(parcel, Bundle.CREATOR));
                return true;
            case 13:
                mo33351c((Bundle) C2052k.m776a(parcel, Bundle.CREATOR), (Bundle) C2052k.m776a(parcel, Bundle.CREATOR));
                return true;
            case 14:
                Bundle bundle6 = (Bundle) C2052k.m776a(parcel, Bundle.CREATOR);
                Bundle bundle7 = (Bundle) C2052k.m776a(parcel, Bundle.CREATOR);
                mo33346b();
                return true;
            case 15:
                Bundle bundle8 = (Bundle) C2052k.m776a(parcel, Bundle.CREATOR);
                mo33340a();
                return true;
            default:
                return false;
        }
    }
}
