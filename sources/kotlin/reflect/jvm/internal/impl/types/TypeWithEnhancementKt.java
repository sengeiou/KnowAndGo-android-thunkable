package kotlin.reflect.jvm.internal.impl.types;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: TypeWithEnhancement.kt */
public final class TypeWithEnhancementKt {
    @Nullable
    public static final KotlinType getEnhancement(@NotNull KotlinType kotlinType) {
        Intrinsics.checkParameterIsNotNull(kotlinType, "$this$getEnhancement");
        if (kotlinType instanceof TypeWithEnhancement) {
            return ((TypeWithEnhancement) kotlinType).getEnhancement();
        }
        return null;
    }

    @NotNull
    public static final KotlinType unwrapEnhancement(@NotNull KotlinType kotlinType) {
        Intrinsics.checkParameterIsNotNull(kotlinType, "$this$unwrapEnhancement");
        KotlinType enhancement = getEnhancement(kotlinType);
        return enhancement != null ? enhancement : kotlinType;
    }

    @NotNull
    public static final UnwrappedType inheritEnhancement(@NotNull UnwrappedType unwrappedType, @NotNull KotlinType kotlinType) {
        Intrinsics.checkParameterIsNotNull(unwrappedType, "$this$inheritEnhancement");
        Intrinsics.checkParameterIsNotNull(kotlinType, "origin");
        return wrapEnhancement(unwrappedType, getEnhancement(kotlinType));
    }

    @NotNull
    public static final UnwrappedType wrapEnhancement(@NotNull UnwrappedType unwrappedType, @Nullable KotlinType kotlinType) {
        Intrinsics.checkParameterIsNotNull(unwrappedType, "$this$wrapEnhancement");
        if (kotlinType == null) {
            return unwrappedType;
        }
        if (unwrappedType instanceof SimpleType) {
            return new SimpleTypeWithEnhancement((SimpleType) unwrappedType, kotlinType);
        }
        if (unwrappedType instanceof FlexibleType) {
            return new FlexibleTypeWithEnhancement((FlexibleType) unwrappedType, kotlinType);
        }
        throw new NoWhenBranchMatchedException();
    }
}
