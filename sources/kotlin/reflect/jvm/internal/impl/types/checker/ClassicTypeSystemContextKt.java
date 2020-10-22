package kotlin.reflect.jvm.internal.impl.types.checker;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.model.TypeVariance;
import org.jetbrains.annotations.NotNull;

/* compiled from: ClassicTypeSystemContext.kt */
public final class ClassicTypeSystemContextKt {
    @NotNull
    public static final TypeVariance convertVariance(@NotNull Variance variance) {
        Intrinsics.checkParameterIsNotNull(variance, "$this$convertVariance");
        switch (variance) {
            case INVARIANT:
                return TypeVariance.INV;
            case IN_VARIANCE:
                return TypeVariance.IN;
            case OUT_VARIANCE:
                return TypeVariance.OUT;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
