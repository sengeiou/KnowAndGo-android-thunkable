package com.google.android.play.core.assetpacks;

import android.os.Bundle;
import com.google.android.play.core.tasks.C2170i;

/* renamed from: com.google.android.play.core.assetpacks.an */
final class C1855an extends C1852ak<Void> {

    /* renamed from: c */
    final /* synthetic */ C1859ar f345c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C1855an(C1859ar arVar, C2170i<Void> iVar) {
        super(arVar, iVar);
        this.f345c = arVar;
    }

    /* renamed from: a */
    public final void mo33344a(Bundle bundle, Bundle bundle2) {
        super.mo33344a(bundle, bundle2);
        if (!this.f345c.f360g.compareAndSet(true, false)) {
            C1859ar.f354a.mo33554d("Expected keepingAlive to be true, but was false.", new Object[0]);
        }
        if (bundle.getBoolean("keep_alive")) {
            this.f345c.mo33356a();
        }
    }
}
