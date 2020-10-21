package com.google.android.play.core.internal;

import android.os.IBinder;

/* renamed from: com.google.android.play.core.internal.ah */
final /* synthetic */ class C1984ah implements IBinder.DeathRecipient {

    /* renamed from: a */
    private final C1992ap f730a;

    C1984ah(C1992ap apVar) {
        this.f730a = apVar;
    }

    public final void binderDied() {
        this.f730a.mo33564c();
    }
}
