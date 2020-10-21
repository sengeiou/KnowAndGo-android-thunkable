package com.bugsnag.android;

import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Build;
import androidx.core.p005os.EnvironmentCompat;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo39784bv = {1, 0, 3}, mo39785d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B8\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012)\u0010\u0004\u001a%\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u000b¢\u0006\u0002\u0010\fJ\b\u0010\u0010\u001a\u00020\u0006H\u0016J\b\u0010\u0011\u001a\u00020\nH\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\nH\u0016R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, mo39786d2 = {"Lcom/bugsnag/android/ConnectivityCompat;", "Lcom/bugsnag/android/Connectivity;", "context", "Landroid/content/Context;", "callback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "connected", "", "Lcom/bugsnag/android/NetworkChangeCallback;", "(Landroid/content/Context;Lkotlin/jvm/functions/Function1;)V", "cm", "Landroid/net/ConnectivityManager;", "connectivity", "hasNetworkConnection", "registerForNetworkChanges", "retrieveNetworkAccessState", "", "unregisterForNetworkChanges", "bugsnag-android-core_release"}, mo39787k = 1, mo39788mv = {1, 1, 16})
/* compiled from: ConnectivityCompat.kt */
public final class ConnectivityCompat implements Connectivity {

    /* renamed from: cm */
    private final ConnectivityManager f61cm;
    private final Connectivity connectivity;

    public ConnectivityCompat(@NotNull Context context, @Nullable Function1<? super Boolean, Unit> function1) {
        Connectivity connectivity2;
        Intrinsics.checkParameterIsNotNull(context, "context");
        Object systemService = context.getSystemService("connectivity");
        if (systemService != null) {
            this.f61cm = (ConnectivityManager) systemService;
            if (Build.VERSION.SDK_INT >= 24) {
                connectivity2 = new ConnectivityApi24(this.f61cm, function1);
            } else {
                connectivity2 = new ConnectivityLegacy(context, this.f61cm, function1);
            }
            this.connectivity = connectivity2;
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.net.ConnectivityManager");
    }

    public void registerForNetworkChanges() {
        try {
            Result.Companion companion = Result.Companion;
            this.connectivity.registerForNetworkChanges();
            Result.m2517constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.m2517constructorimpl(ResultKt.createFailure(th));
        }
    }

    public boolean hasNetworkConnection() {
        boolean z;
        try {
            Result.Companion companion = Result.Companion;
            z = Result.m2517constructorimpl(Boolean.valueOf(this.connectivity.hasNetworkConnection()));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            z = Result.m2517constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m2520exceptionOrNullimpl(z) != null) {
            z = true;
        }
        return ((Boolean) z).booleanValue();
    }

    public void unregisterForNetworkChanges() {
        try {
            Result.Companion companion = Result.Companion;
            this.connectivity.unregisterForNetworkChanges();
            Result.m2517constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.m2517constructorimpl(ResultKt.createFailure(th));
        }
    }

    @NotNull
    public String retrieveNetworkAccessState() {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.m2517constructorimpl(this.connectivity.retrieveNetworkAccessState());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m2517constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m2520exceptionOrNullimpl(obj) != null) {
            obj = EnvironmentCompat.MEDIA_UNKNOWN;
        }
        return (String) obj;
    }
}
