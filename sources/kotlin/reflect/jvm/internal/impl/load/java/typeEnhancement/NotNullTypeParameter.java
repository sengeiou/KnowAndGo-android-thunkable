package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.types.DelegatingSimpleType;
import kotlin.reflect.jvm.internal.impl.types.FlexibleType;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.NotNullTypeVariable;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.TypeWithEnhancementKt;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: typeEnhancement.kt */
public final class NotNullTypeParameter extends DelegatingSimpleType implements NotNullTypeVariable {
    @NotNull
    private final SimpleType delegate;

    public boolean isMarkedNullable() {
        return false;
    }

    public boolean isTypeVariable() {
        return true;
    }

    public NotNullTypeParameter(@NotNull SimpleType simpleType) {
        Intrinsics.checkParameterIsNotNull(simpleType, "delegate");
        this.delegate = simpleType;
    }

    /* access modifiers changed from: protected */
    @NotNull
    public SimpleType getDelegate() {
        return this.delegate;
    }

    @NotNull
    public KotlinType substitutionResult(@NotNull KotlinType kotlinType) {
        Intrinsics.checkParameterIsNotNull(kotlinType, "replacement");
        UnwrappedType unwrap = kotlinType.unwrap();
        KotlinType kotlinType2 = unwrap;
        if (!TypeUtils.isNullableType(kotlinType2) && !TypeUtilsKt.isTypeParameter(kotlinType2)) {
            return kotlinType2;
        }
        if (unwrap instanceof SimpleType) {
            return prepareReplacement((SimpleType) unwrap);
        }
        if (unwrap instanceof FlexibleType) {
            FlexibleType flexibleType = (FlexibleType) unwrap;
            return TypeWithEnhancementKt.wrapEnhancement(KotlinTypeFactory.flexibleType(prepareReplacement(flexibleType.getLowerBound()), prepareReplacement(flexibleType.getUpperBound())), TypeWithEnhancementKt.getEnhancement(kotlinType2));
        }
        throw new IllegalStateException(("Incorrect type: " + unwrap).toString());
    }

    private final SimpleType prepareReplacement(@NotNull SimpleType simpleType) {
        SimpleType makeNullableAsSpecified = simpleType.makeNullableAsSpecified(false);
        if (!TypeUtilsKt.isTypeParameter(simpleType)) {
            return makeNullableAsSpecified;
        }
        return new NotNullTypeParameter(makeNullableAsSpecified);
    }

    @NotNull
    public NotNullTypeParameter replaceAnnotations(@NotNull Annotations annotations) {
        Intrinsics.checkParameterIsNotNull(annotations, "newAnnotations");
        return new NotNullTypeParameter(getDelegate().replaceAnnotations(annotations));
    }

    @NotNull
    public SimpleType makeNullableAsSpecified(boolean z) {
        return z ? getDelegate().makeNullableAsSpecified(true) : this;
    }
}
