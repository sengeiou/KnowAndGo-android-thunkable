package kotlin.reflect.jvm.internal.impl.types.checker;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.AbstractNullabilityChecker;
import kotlin.reflect.jvm.internal.impl.types.AbstractTypeCheckerContext;
import kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import org.jetbrains.annotations.NotNull;

/* compiled from: NewKotlinTypeChecker.kt */
public final class NullabilityChecker {
    public static final NullabilityChecker INSTANCE = new NullabilityChecker();

    private NullabilityChecker() {
    }

    public final boolean isSubtypeOfAny(@NotNull UnwrappedType unwrappedType) {
        Intrinsics.checkParameterIsNotNull(unwrappedType, "type");
        return AbstractNullabilityChecker.INSTANCE.hasNotNullSupertype(SimpleClassicTypeSystemContext.INSTANCE.newBaseTypeCheckerContext(false), FlexibleTypesKt.lowerIfFlexible(unwrappedType), AbstractTypeCheckerContext.SupertypesPolicy.LowerIfFlexible.INSTANCE);
    }
}
