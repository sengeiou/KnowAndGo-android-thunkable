package com.google.android.play.core.internal;

import android.os.IBinder;
import android.os.IInterface;

/* renamed from: com.google.android.play.core.internal.m */
public abstract class C2054m extends C2051j implements C2055n {
    /* renamed from: a */
    public static C2055n m781a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.play.core.appupdate.protocol.IAppUpdateService");
        return queryLocalInterface instanceof C2055n ? (C2055n) queryLocalInterface : new C2053l(iBinder);
    }
}
