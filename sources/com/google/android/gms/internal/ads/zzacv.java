package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Callable;

final class zzacv implements Callable<Void> {
    private final /* synthetic */ Context val$context;

    zzacv(Context context) {
        this.val$context = context;
    }

    public final /* synthetic */ Object call() throws Exception {
        zzyt.zzpe().initialize(this.val$context);
        return null;
    }
}
