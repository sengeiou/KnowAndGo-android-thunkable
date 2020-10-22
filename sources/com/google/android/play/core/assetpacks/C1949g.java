package com.google.android.play.core.assetpacks;

import com.google.android.play.core.tasks.OnSuccessListener;
import java.util.List;

/* renamed from: com.google.android.play.core.assetpacks.g */
final /* synthetic */ class C1949g implements OnSuccessListener {

    /* renamed from: a */
    private final C1870bb f671a;

    private C1949g(C1870bb bbVar) {
        this.f671a = bbVar;
    }

    /* renamed from: a */
    static OnSuccessListener m527a(C1870bb bbVar) {
        return new C1949g(bbVar);
    }

    public final void onSuccess(Object obj) {
        this.f671a.mo33378a((List<String>) (List) obj);
    }
}
