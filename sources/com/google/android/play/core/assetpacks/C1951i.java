package com.google.android.play.core.assetpacks;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.google.android.play.core.tasks.C2170i;

/* renamed from: com.google.android.play.core.assetpacks.i */
final class C1951i extends ResultReceiver {

    /* renamed from: a */
    final /* synthetic */ C2170i f673a;

    /* renamed from: b */
    final /* synthetic */ C1952j f674b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C1951i(C1952j jVar, Handler handler, C2170i iVar) {
        super(handler);
        this.f674b = jVar;
        this.f673a = iVar;
    }

    public final void onReceiveResult(int i, Bundle bundle) {
        switch (i) {
            case 1:
                this.f673a.mo33809b(-1);
                this.f674b.f682h.mo33426a((PendingIntent) null);
                return;
            case 2:
                this.f673a.mo33809b(0);
                return;
            default:
                this.f673a.mo33808b((Exception) new AssetPackException(-100));
                return;
        }
    }
}
