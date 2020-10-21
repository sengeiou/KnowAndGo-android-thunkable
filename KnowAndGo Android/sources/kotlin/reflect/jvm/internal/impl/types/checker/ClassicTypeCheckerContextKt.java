package kotlin.reflect.jvm.internal.impl.types.checker;

import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;

/* compiled from: ClassicTypeCheckerContext.kt */
public final class ClassicTypeCheckerContextKt {
    /* access modifiers changed from: private */
    public static final String errorMessage(@NotNull Object obj) {
        return "ClassicTypeCheckerContext couldn't handle " + Reflection.getOrCreateKotlinClass(obj.getClass()) + ' ' + obj;
    }
}
