package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.CallSuper;

public class zzdbh extends Handler {
    private static volatile zzdbi zzgoy;

    public zzdbh() {
    }

    public zzdbh(Looper looper) {
        super(looper);
    }

    public final void dispatchMessage(Message message) {
        zzb(message);
    }

    /* access modifiers changed from: protected */
    @CallSuper
    public void zzb(Message message) {
        super.dispatchMessage(message);
    }
}
