package kotlin.reflect.jvm.internal.impl.resolve.calls.inference;

import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import org.jetbrains.annotations.NotNull;

/* compiled from: CapturedTypeConstructor.kt */
public interface CapturedTypeConstructor extends TypeConstructor {
    @NotNull
    TypeProjection getProjection();
}
