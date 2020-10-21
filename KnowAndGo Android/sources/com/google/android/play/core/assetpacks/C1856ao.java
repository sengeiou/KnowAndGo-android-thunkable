package com.google.android.play.core.assetpacks;

import android.os.Bundle;
import com.google.android.play.core.tasks.C2170i;

/* renamed from: com.google.android.play.core.assetpacks.ao */
final class C1856ao extends C1852ak<Void> {

    /* renamed from: c */
    final int f346c;

    /* renamed from: d */
    final String f347d;

    /* renamed from: e */
    final int f348e;

    /* renamed from: f */
    final /* synthetic */ C1859ar f349f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C1856ao(C1859ar arVar, C2170i<Void> iVar, int i, String str, int i2) {
        super(arVar, iVar);
        this.f349f = arVar;
        this.f346c = i;
        this.f347d = str;
        this.f348e = i2;
    }

    /* renamed from: a */
    public final void mo33343a(Bundle bundle) {
        this.f349f.f358e.mo33561a();
        int i = bundle.getInt("error_code");
        C1859ar.f354a.mo33552b("onError(%d), retrying notifyModuleCompleted...", Integer.valueOf(i));
        int i2 = this.f348e;
        if (i2 > 0) {
            this.f349f.m301a(this.f346c, this.f347d, i2 - 1);
        }
    }
}
