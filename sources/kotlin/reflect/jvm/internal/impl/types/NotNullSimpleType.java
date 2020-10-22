package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: KotlinTypeFactory.kt */
final class NotNullSimpleType extends DelegatingSimpleTypeImpl {
    public boolean isMarkedNullable() {
        return false;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NotNullSimpleType(@NotNull SimpleType simpleType) {
        super(simpleType);
        Intrinsics.checkParameterIsNotNull(simpleType, "delegate");
    }
}
