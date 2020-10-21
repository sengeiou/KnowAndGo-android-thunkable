package com.google.android.play.core.listener;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.annotation.Nullable;
import com.google.android.play.core.internal.C1982af;
import com.google.android.play.core.internal.C1998av;
import com.google.android.play.core.splitcompat.C2096p;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* renamed from: com.google.android.play.core.listener.b */
public abstract class C2069b<StateT> {

    /* renamed from: a */
    protected final C1982af f791a;

    /* renamed from: b */
    protected final Set<StateUpdatedListener<StateT>> f792b = new HashSet();

    /* renamed from: c */
    private final IntentFilter f793c;

    /* renamed from: d */
    private final Context f794d;
    @Nullable

    /* renamed from: e */
    private C2068a f795e = null;

    /* renamed from: f */
    private volatile boolean f796f = false;

    protected C2069b(C1982af afVar, IntentFilter intentFilter, Context context) {
        this.f791a = afVar;
        this.f793c = intentFilter;
        this.f794d = C2096p.m907a(context);
    }

    /* renamed from: c */
    private final void m832c() {
        C2068a aVar;
        if ((this.f796f || !this.f792b.isEmpty()) && this.f795e == null) {
            this.f795e = new C2068a(this);
            this.f794d.registerReceiver(this.f795e, this.f793c);
        }
        if (!this.f796f && this.f792b.isEmpty() && (aVar = this.f795e) != null) {
            this.f794d.unregisterReceiver(aVar);
            this.f795e = null;
        }
    }

    /* renamed from: a */
    public final synchronized void mo33654a() {
        this.f791a.mo33553c("clearListeners", new Object[0]);
        this.f792b.clear();
        m832c();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo33265a(Context context, Intent intent);

    /* renamed from: a */
    public final synchronized void mo33655a(StateUpdatedListener<StateT> stateUpdatedListener) {
        this.f791a.mo33553c("registerListener", new Object[0]);
        C1998av.m630a(stateUpdatedListener, (Object) "Registered Play Core listener should not be null.");
        this.f792b.add(stateUpdatedListener);
        m832c();
    }

    /* renamed from: a */
    public final synchronized void mo33656a(StateT statet) {
        Iterator it = new HashSet(this.f792b).iterator();
        while (it.hasNext()) {
            ((StateUpdatedListener) it.next()).onStateUpdate(statet);
        }
    }

    /* renamed from: a */
    public final synchronized void mo33657a(boolean z) {
        this.f796f = z;
        m832c();
    }

    /* renamed from: b */
    public final synchronized void mo33658b(StateUpdatedListener<StateT> stateUpdatedListener) {
        this.f791a.mo33553c("unregisterListener", new Object[0]);
        C1998av.m630a(stateUpdatedListener, (Object) "Unregistered Play Core listener should not be null.");
        this.f792b.remove(stateUpdatedListener);
        m832c();
    }

    /* renamed from: b */
    public final synchronized boolean mo33659b() {
        return this.f795e != null;
    }
}
