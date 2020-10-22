package com.google.android.play.core.assetpacks;

import com.google.android.play.core.internal.C2020bq;
import com.google.android.play.core.internal.C2044cn;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* renamed from: com.google.android.play.core.assetpacks.p */
public final class C1959p implements C2044cn<Executor> {
    /* renamed from: b */
    public static Executor m542b() {
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor(C1954l.f694a);
        C2020bq.m692b(newSingleThreadExecutor);
        return newSingleThreadExecutor;
    }

    /* renamed from: a */
    public final /* bridge */ /* synthetic */ Object mo33266a() {
        return m542b();
    }
}
