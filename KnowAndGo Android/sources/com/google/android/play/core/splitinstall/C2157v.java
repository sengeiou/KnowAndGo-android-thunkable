package com.google.android.play.core.splitinstall;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import com.google.android.play.core.common.IntentSenderForResultStarter;

/* renamed from: com.google.android.play.core.splitinstall.v */
final class C2157v implements IntentSenderForResultStarter {

    /* renamed from: a */
    final /* synthetic */ Activity f1000a;

    C2157v(Activity activity) {
        this.f1000a = activity;
    }

    public final void startIntentSenderForResult(IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) throws IntentSender.SendIntentException {
        this.f1000a.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4);
    }
}
