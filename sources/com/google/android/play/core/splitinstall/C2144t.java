package com.google.android.play.core.splitinstall;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Nullable;
import com.google.android.play.core.internal.C1982af;
import com.google.android.play.core.listener.C2069b;

/* renamed from: com.google.android.play.core.splitinstall.t */
public final class C2144t extends C2069b<SplitInstallSessionState> {
    @Nullable

    /* renamed from: c */
    private static C2144t f945c;

    /* renamed from: d */
    private final Handler f946d = new Handler(Looper.getMainLooper());

    /* renamed from: e */
    private final C2128e f947e;

    public C2144t(Context context, C2128e eVar) {
        super(new C1982af("SplitInstallListenerRegistry"), new IntentFilter("com.google.android.play.core.splitinstall.receiver.SplitInstallUpdateIntentService"), context);
        this.f947e = eVar;
    }

    /* renamed from: a */
    public static synchronized C2144t m1011a(Context context) {
        C2144t tVar;
        synchronized (C2144t.class) {
            if (f945c == null) {
                f945c = new C2144t(context, C2135l.f928a);
            }
            tVar = f945c;
        }
        return tVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo33265a(Context context, Intent intent) {
        Bundle bundleExtra = intent.getBundleExtra("session_state");
        if (bundleExtra != null) {
            SplitInstallSessionState a = SplitInstallSessionState.m914a(bundleExtra);
            this.f791a.mo33550a("ListenerRegistryBroadcastReceiver.onReceive: %s", a);
            C2129f a2 = this.f947e.mo33762a();
            if (a.status() != 3 || a2 == null) {
                mo33656a(a);
            } else {
                a2.mo33566a(a.mo33732c(), new C2142r(this, a, intent, context));
            }
        }
    }
}
