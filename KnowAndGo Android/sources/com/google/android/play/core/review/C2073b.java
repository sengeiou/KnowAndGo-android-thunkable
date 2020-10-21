package com.google.android.play.core.review;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.google.android.play.core.tasks.C2170i;

/* renamed from: com.google.android.play.core.review.b */
final class C2073b extends ResultReceiver {

    /* renamed from: a */
    final /* synthetic */ C2170i f807a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C2073b(Handler handler, C2170i iVar) {
        super(handler);
        this.f807a = iVar;
    }

    public final void onReceiveResult(int i, Bundle bundle) {
        this.f807a.mo33809b(null);
    }
}
