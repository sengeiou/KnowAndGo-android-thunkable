package com.google.android.play.core.internal;

import android.os.IBinder;
import android.os.IInterface;

/* renamed from: com.google.android.play.core.internal.r */
public abstract class C2059r extends C2051j implements C2060s {
    /* renamed from: a */
    public static C2060s m797a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.play.core.assetpacks.protocol.IAssetModuleService");
        return queryLocalInterface instanceof C2060s ? (C2060s) queryLocalInterface : new C2058q(iBinder);
    }
}
