package com.google.android.play.core.assetpacks;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.google.android.play.core.common.C1971a;
import com.google.android.play.core.internal.C1982af;
import com.google.android.play.core.internal.C2040cj;
import com.google.android.play.core.listener.C2069b;
import java.util.ArrayList;
import java.util.concurrent.Executor;

/* renamed from: com.google.android.play.core.assetpacks.aw */
final class C1864aw extends C2069b<AssetPackState> {

    /* renamed from: c */
    private final C1911cp f370c;

    /* renamed from: d */
    private final C1891bw f371d;

    /* renamed from: e */
    private final C2040cj<C1966w> f372e;

    /* renamed from: f */
    private final C1882bn f373f;

    /* renamed from: g */
    private final C1894bz f374g;

    /* renamed from: h */
    private final C1971a f375h;

    /* renamed from: i */
    private final C2040cj<Executor> f376i;

    /* renamed from: j */
    private final C2040cj<Executor> f377j;

    /* renamed from: k */
    private final Handler f378k = new Handler(Looper.getMainLooper());

    C1864aw(Context context, C1911cp cpVar, C1891bw bwVar, C2040cj<C1966w> cjVar, C1894bz bzVar, C1882bn bnVar, C1971a aVar, C2040cj<Executor> cjVar2, C2040cj<Executor> cjVar3) {
        super(new C1982af("AssetPackServiceListenerRegistry"), new IntentFilter("com.google.android.play.core.assetpacks.receiver.ACTION_SESSION_UPDATE"), context);
        this.f370c = cpVar;
        this.f371d = bwVar;
        this.f372e = cjVar;
        this.f374g = bzVar;
        this.f373f = bnVar;
        this.f375h = aVar;
        this.f376i = cjVar2;
        this.f377j = cjVar3;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo33265a(Context context, Intent intent) {
        Bundle bundleExtra = intent.getBundleExtra("com.google.android.play.core.assetpacks.receiver.EXTRA_SESSION_STATE");
        if (bundleExtra != null) {
            ArrayList<String> stringArrayList = bundleExtra.getStringArrayList("pack_names");
            if (stringArrayList == null || stringArrayList.size() != 1) {
                this.f791a.mo33552b("Corrupt bundle received from broadcast.", new Object[0]);
                return;
            }
            Bundle bundleExtra2 = intent.getBundleExtra("com.google.android.play.core.FLAGS");
            if (bundleExtra2 != null) {
                this.f375h.mo33531a(bundleExtra2);
            }
            AssetPackState a = AssetPackState.m260a(bundleExtra, stringArrayList.get(0), this.f374g, C1866ay.f388a);
            this.f791a.mo33550a("ListenerRegistryBroadcastReceiver.onReceive: %s", a);
            PendingIntent pendingIntent = (PendingIntent) bundleExtra.getParcelable("confirmation_intent");
            if (pendingIntent != null) {
                this.f373f.mo33426a(pendingIntent);
            }
            this.f377j.mo33606a().execute(new C1862au(this, bundleExtra, a));
            this.f376i.mo33606a().execute(new C1863av(this, bundleExtra));
            return;
        }
        this.f791a.mo33552b("Empty bundle received from broadcast.", new Object[0]);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final /* synthetic */ void mo33366a(Bundle bundle) {
        if (this.f370c.mo33444a(bundle)) {
            this.f371d.mo33431a();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final /* synthetic */ void mo33367a(Bundle bundle, AssetPackState assetPackState) {
        if (this.f370c.mo33449b(bundle)) {
            mo33368a(assetPackState);
            this.f372e.mo33606a().mo33356a();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo33368a(AssetPackState assetPackState) {
        this.f378k.post(new C1861at(this, assetPackState));
    }
}
