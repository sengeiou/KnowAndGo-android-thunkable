package com.google.android.play.core.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

/* renamed from: com.google.android.play.core.internal.ao */
final class C1991ao implements ServiceConnection {

    /* renamed from: a */
    final /* synthetic */ C1992ap f737a;

    /* synthetic */ C1991ao(C1992ap apVar) {
        this.f737a = apVar;
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.f737a.f740c.mo33553c("ServiceConnectionImpl.onServiceConnected(%s)", componentName);
        this.f737a.m604b((C1983ag) new C1989am(this, iBinder));
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        this.f737a.f740c.mo33553c("ServiceConnectionImpl.onServiceDisconnected(%s)", componentName);
        this.f737a.m604b((C1983ag) new C1990an(this));
    }
}
