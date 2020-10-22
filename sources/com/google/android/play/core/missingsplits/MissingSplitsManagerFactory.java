package com.google.android.play.core.missingsplits;

import android.content.Context;
import androidx.annotation.NonNull;
import java.util.concurrent.atomic.AtomicReference;

public class MissingSplitsManagerFactory {

    /* renamed from: a */
    private static final AtomicReference<Boolean> f797a = new AtomicReference<>((Object) null);

    @NonNull
    public static MissingSplitsManager create(@NonNull Context context) {
        return new C2071b(context, Runtime.getRuntime(), new C2070a(context, context.getPackageManager()), f797a);
    }
}
