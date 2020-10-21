package com.google.android.play.core.assetpacks;

import android.content.ComponentName;
import android.content.Context;
import com.google.android.play.core.common.PlayCoreDialogWrapperActivity;
import com.google.android.play.core.internal.C2020bq;
import com.google.android.play.core.internal.C2044cn;

/* renamed from: com.google.android.play.core.assetpacks.q */
public final class C1960q implements C2044cn<AssetPackManager> {

    /* renamed from: a */
    private final C2044cn<C1952j> f700a;

    /* renamed from: b */
    private final C2044cn<Context> f701b;

    public C1960q(C2044cn<C1952j> cnVar, C2044cn<Context> cnVar2) {
        this.f700a = cnVar;
        this.f701b = cnVar2;
    }

    /* renamed from: a */
    public final /* bridge */ /* synthetic */ Object mo33266a() {
        C1952j a = this.f700a.mo33266a();
        Context b = ((C1962s) this.f701b).mo33266a();
        C1952j jVar = a;
        C2020bq.m685a(b.getPackageManager(), new ComponentName(b.getPackageName(), "com.google.android.play.core.assetpacks.AssetPackExtractionService"), 4);
        PlayCoreDialogWrapperActivity.m565a(b);
        C2020bq.m692b(jVar);
        return jVar;
    }
}
