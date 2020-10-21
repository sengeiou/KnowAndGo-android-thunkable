package com.google.android.play.core.assetpacks;

import com.google.android.play.core.internal.C2020bq;
import com.google.android.play.core.internal.C2044cn;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* renamed from: com.google.android.play.core.assetpacks.v */
public final class C1965v implements C2044cn<Executor> {
    /* renamed from: b */
    public static Executor m551b() {
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor(C1955m.f695a);
        C2020bq.m692b(newSingleThreadExecutor);
        return newSingleThreadExecutor;
    }

    /* renamed from: a */
    public final /* bridge */ /* synthetic */ Object mo33266a() {
        return m551b();
    }
}
