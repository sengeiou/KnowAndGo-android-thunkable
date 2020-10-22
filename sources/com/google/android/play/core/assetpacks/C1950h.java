package com.google.android.play.core.assetpacks;

import com.google.android.play.core.tasks.OnFailureListener;

/* renamed from: com.google.android.play.core.assetpacks.h */
final /* synthetic */ class C1950h implements OnFailureListener {

    /* renamed from: a */
    static final OnFailureListener f672a = new C1950h();

    private C1950h() {
    }

    public final void onFailure(Exception exc) {
        C1952j.f675a.mo33554d(String.format("Could not sync active asset packs. %s", new Object[]{exc}), new Object[0]);
    }
}
