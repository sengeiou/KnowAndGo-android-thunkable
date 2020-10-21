package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import org.jetbrains.annotations.NotNull;

/* compiled from: KotlinTypeFactory.kt */
final class AnnotatedSimpleType extends DelegatingSimpleTypeImpl {
    @NotNull
    private final Annotations annotations;

    @NotNull
    public Annotations getAnnotations() {
        return this.annotations;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AnnotatedSimpleType(@NotNull SimpleType simpleType, @NotNull Annotations annotations2) {
        super(simpleType);
        Intrinsics.checkParameterIsNotNull(simpleType, "delegate");
        Intrinsics.checkParameterIsNotNull(annotations2, "annotations");
        this.annotations = annotations2;
    }
}
