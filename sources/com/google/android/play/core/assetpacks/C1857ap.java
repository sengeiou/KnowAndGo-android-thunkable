package com.google.android.play.core.assetpacks;

import android.os.Bundle;
import com.google.android.play.core.tasks.C2170i;

/* renamed from: com.google.android.play.core.assetpacks.ap */
final class C1857ap extends C1852ak<AssetPackStates> {

    /* renamed from: c */
    private final C1894bz f350c;

    /* renamed from: d */
    private final C1867az f351d;

    C1857ap(C1859ar arVar, C2170i<AssetPackStates> iVar, C1894bz bzVar, C1867az azVar) {
        super(arVar, iVar);
        this.f350c = bzVar;
        this.f351d = azVar;
    }

    /* renamed from: c */
    public final void mo33351c(Bundle bundle, Bundle bundle2) {
        super.mo33351c(bundle, bundle2);
        this.f342a.mo33809b(AssetPackStates.m264a(bundle, this.f350c, this.f351d));
    }
}
