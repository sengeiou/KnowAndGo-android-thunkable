package com.google.android.play.core.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: com.google.android.play.core.internal.ac */
public abstract class C1979ac extends C2051j implements C1980ad {
    public C1979ac() {
        super("com.google.android.play.core.inappreview.protocol.IInAppReviewServiceCallback");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final boolean mo33545a(int i, Parcel parcel) throws RemoteException {
        if (i != 2) {
            return false;
        }
        mo33546a((Bundle) C2052k.m776a(parcel, Bundle.CREATOR));
        return true;
    }
}
