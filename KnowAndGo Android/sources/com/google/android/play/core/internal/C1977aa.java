package com.google.android.play.core.internal;

import android.os.IBinder;
import android.os.IInterface;

/* renamed from: com.google.android.play.core.internal.aa */
public abstract class C1977aa extends C2051j implements C1978ab {
    /* renamed from: a */
    public static C1978ab m578a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.play.core.inappreview.protocol.IInAppReviewService");
        return queryLocalInterface instanceof C1978ab ? (C1978ab) queryLocalInterface : new C2067z(iBinder);
    }
}
