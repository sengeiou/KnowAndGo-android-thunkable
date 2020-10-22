package com.google.android.play.core.assetpacks;

import android.os.Bundle;
import com.google.android.play.core.tasks.C2170i;
import java.util.List;

/* renamed from: com.google.android.play.core.assetpacks.aq */
final class C1858aq extends C1852ak<AssetPackStates> {

    /* renamed from: c */
    private final List<String> f352c;

    /* renamed from: d */
    private final C1894bz f353d;

    C1858aq(C1859ar arVar, C2170i<AssetPackStates> iVar, C1894bz bzVar, List<String> list) {
        super(arVar, iVar);
        this.f353d = bzVar;
        this.f352c = list;
    }

    /* renamed from: a */
    public final void mo33342a(int i, Bundle bundle) {
        super.mo33342a(i, bundle);
        this.f342a.mo33809b(AssetPackStates.m265a(bundle, this.f353d, this.f352c));
    }
}
