package com.google.android.play.core.internal;

import androidx.annotation.Nullable;
import com.google.android.play.core.tasks.C2170i;

/* renamed from: com.google.android.play.core.internal.ag */
public abstract class C1983ag implements Runnable {
    @Nullable

    /* renamed from: a */
    private final C2170i<?> f729a;

    C1983ag() {
        this.f729a = null;
    }

    public C1983ag(@Nullable C2170i<?> iVar) {
        this.f729a = iVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo33272a();

    /* access modifiers changed from: package-private */
    @Nullable
    /* renamed from: b */
    public final C2170i<?> mo33555b() {
        return this.f729a;
    }

    public final void run() {
        try {
            mo33272a();
        } catch (Exception e) {
            C2170i<?> iVar = this.f729a;
            if (iVar != null) {
                iVar.mo33808b(e);
            }
        }
    }
}
