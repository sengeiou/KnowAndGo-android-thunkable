package com.google.android.play.core.internal;

import android.os.IBinder;
import android.os.IInterface;

/* renamed from: com.google.android.play.core.internal.bt */
public abstract class C2023bt extends C2051j implements C2024bu {
    /* renamed from: a */
    public static C2024bu m701a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.play.core.splitinstall.protocol.ISplitInstallService");
        return queryLocalInterface instanceof C2024bu ? (C2024bu) queryLocalInterface : new C2022bs(iBinder);
    }
}
