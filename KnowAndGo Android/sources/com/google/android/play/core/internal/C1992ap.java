package com.google.android.play.core.internal;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.play.core.tasks.C2170i;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.android.play.core.internal.ap */
public final class C1992ap<T extends IInterface> {

    /* renamed from: a */
    private static final Map<String, Handler> f738a = new HashMap();
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final Context f739b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final C1982af f740c;

    /* renamed from: d */
    private final String f741d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final List<C1983ag> f742e = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: f */
    public boolean f743f;

    /* renamed from: g */
    private final Intent f744g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public final C1988al<T> f745h;

    /* renamed from: i */
    private final WeakReference<C1987ak> f746i;

    /* renamed from: j */
    private final IBinder.DeathRecipient f747j = new C1984ah(this);
    /* access modifiers changed from: private */
    @Nullable

    /* renamed from: k */
    public ServiceConnection f748k;
    /* access modifiers changed from: private */
    @Nullable

    /* renamed from: l */
    public T f749l;

    public C1992ap(Context context, C1982af afVar, String str, Intent intent, C1988al<T> alVar) {
        this.f739b = context;
        this.f740c = afVar;
        this.f741d = str;
        this.f744g = intent;
        this.f745h = alVar;
        this.f746i = new WeakReference<>((Object) null);
    }

    /* renamed from: a */
    static /* synthetic */ void m602a(C1992ap apVar, C1983ag agVar) {
        if (apVar.f749l == null && !apVar.f743f) {
            apVar.f740c.mo33553c("Initiate binding to the service.", new Object[0]);
            apVar.f742e.add(agVar);
            apVar.f748k = new C1991ao(apVar);
            apVar.f743f = true;
            if (!apVar.f739b.bindService(apVar.f744g, apVar.f748k, 1)) {
                apVar.f740c.mo33553c("Failed to bind to the service.", new Object[0]);
                apVar.f743f = false;
                List<C1983ag> list = apVar.f742e;
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    C2170i<?> b = list.get(i).mo33555b();
                    if (b != null) {
                        b.mo33808b((Exception) new C1993aq());
                    }
                }
                apVar.f742e.clear();
            }
        } else if (apVar.f743f) {
            apVar.f740c.mo33553c("Waiting to bind to the service.", new Object[0]);
            apVar.f742e.add(agVar);
        } else {
            agVar.run();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public final void m604b(C1983ag agVar) {
        Handler handler;
        synchronized (f738a) {
            if (!f738a.containsKey(this.f741d)) {
                HandlerThread handlerThread = new HandlerThread(this.f741d, 10);
                handlerThread.start();
                f738a.put(this.f741d, new Handler(handlerThread.getLooper()));
            }
            handler = f738a.get(this.f741d);
        }
        handler.post(agVar);
    }

    /* renamed from: f */
    static /* synthetic */ void m609f(C1992ap apVar) {
        apVar.f740c.mo33553c("linkToDeath", new Object[0]);
        try {
            apVar.f749l.asBinder().linkToDeath(apVar.f747j, 0);
        } catch (RemoteException e) {
            apVar.f740c.mo33551a((Throwable) e, "linkToDeath failed", new Object[0]);
        }
    }

    /* renamed from: h */
    static /* synthetic */ void m611h(C1992ap apVar) {
        apVar.f740c.mo33553c("unlinkToDeath", new Object[0]);
        apVar.f749l.asBinder().unlinkToDeath(apVar.f747j, 0);
    }

    /* renamed from: a */
    public final void mo33561a() {
        m604b((C1983ag) new C1986aj(this));
    }

    /* renamed from: a */
    public final void mo33562a(C1983ag agVar) {
        m604b((C1983ag) new C1985ai(this, agVar.mo33555b(), agVar));
    }

    @Nullable
    /* renamed from: b */
    public final T mo33563b() {
        return this.f749l;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final /* bridge */ /* synthetic */ void mo33564c() {
        this.f740c.mo33553c("reportBinderDeath", new Object[0]);
        C1987ak akVar = (C1987ak) this.f746i.get();
        if (akVar == null) {
            this.f740c.mo33553c("%s : Binder has died.", this.f741d);
            List<C1983ag> list = this.f742e;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                C2170i<?> b = list.get(i).mo33555b();
                if (b != null) {
                    b.mo33808b((Exception) Build.VERSION.SDK_INT < 15 ? new RemoteException() : new RemoteException(String.valueOf(this.f741d).concat(" : Binder has died.")));
                }
            }
            this.f742e.clear();
            return;
        }
        this.f740c.mo33553c("calling onBinderDied", new Object[0]);
        akVar.mo33558a();
    }
}
