package com.google.android.play.core.review;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.play.core.internal.C1982af;
import com.google.android.play.core.tasks.C2170i;

/* renamed from: com.google.android.play.core.review.g */
final class C2078g extends C2077f<ReviewInfo> {
    C2078g(C2079h hVar, C2170i iVar) {
        super(hVar, new C1982af("OnRequestInstallCallback"), iVar);
    }

    /* renamed from: a */
    public final void mo33546a(Bundle bundle) throws RemoteException {
        super.mo33546a(bundle);
        this.f814b.mo33809b(ReviewInfo.m851a((PendingIntent) bundle.get("confirmation_intent")));
    }
}
