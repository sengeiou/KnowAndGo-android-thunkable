package com.google.android.play.core.appupdate;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.google.android.play.core.tasks.C2170i;

/* renamed from: com.google.android.play.core.appupdate.c */
final class C1818c extends ResultReceiver {

    /* renamed from: a */
    final /* synthetic */ C2170i f219a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C1818c(Handler handler, C2170i iVar) {
        super(handler);
        this.f219a = iVar;
    }

    public final void onReceiveResult(int i, Bundle bundle) {
        C2170i iVar;
        int i2;
        switch (i) {
            case 1:
                iVar = this.f219a;
                i2 = -1;
                break;
            case 2:
                iVar = this.f219a;
                i2 = 0;
                break;
            default:
                iVar = this.f219a;
                i2 = 1;
                break;
        }
        iVar.mo33809b(Integer.valueOf(i2));
    }
}
