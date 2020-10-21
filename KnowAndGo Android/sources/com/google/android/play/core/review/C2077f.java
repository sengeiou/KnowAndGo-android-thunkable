package com.google.android.play.core.review;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.play.core.internal.C1979ac;
import com.google.android.play.core.internal.C1982af;
import com.google.android.play.core.tasks.C2170i;

/* renamed from: com.google.android.play.core.review.f */
class C2077f<T> extends C1979ac {

    /* renamed from: a */
    final C1982af f813a;

    /* renamed from: b */
    final C2170i<T> f814b;

    /* renamed from: c */
    final /* synthetic */ C2079h f815c;

    C2077f(C2079h hVar, C1982af afVar, C2170i<T> iVar) {
        this.f815c = hVar;
        this.f813a = afVar;
        this.f814b = iVar;
    }

    /* renamed from: a */
    public void mo33546a(Bundle bundle) throws RemoteException {
        this.f815c.f817a.mo33561a();
        this.f813a.mo33553c("onGetLaunchReviewFlowInfo", new Object[0]);
    }
}
