package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: KotlinTypeFactory.kt */
final class NullableSimpleType extends DelegatingSimpleTypeImpl {
    public boolean isMarkedNullable() {
        return true;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NullableSimpleType(@NotNull SimpleType simpleType) {
        super(simpleType);
        Intrinsics.checkParameterIsNotNull(simpleType, "delegate");
    }
}
