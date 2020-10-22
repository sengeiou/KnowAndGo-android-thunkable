package com.google.android.play.core.assetpacks;

import android.os.Bundle;

/* renamed from: com.google.android.play.core.assetpacks.au */
final /* synthetic */ class C1862au implements Runnable {

    /* renamed from: a */
    private final C1864aw f365a;

    /* renamed from: b */
    private final Bundle f366b;

    /* renamed from: c */
    private final AssetPackState f367c;

    C1862au(C1864aw awVar, Bundle bundle, AssetPackState assetPackState) {
        this.f365a = awVar;
        this.f366b = bundle;
        this.f367c = assetPackState;
    }

    public final void run() {
        this.f365a.mo33367a(this.f366b, this.f367c);
    }
}
