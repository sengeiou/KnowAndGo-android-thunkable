package kotlin.reflect.jvm.internal.impl.types;

import kotlin.NoWhenBranchMatchedException;
import kotlin._Assertions;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: flexibleTypes.kt */
public final class FlexibleTypeImpl extends FlexibleType implements CustomTypeVariable {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @JvmField
    public static boolean RUN_SLOW_ASSERTIONS;
    private boolean assertionsDone;

    /* compiled from: flexibleTypes.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FlexibleTypeImpl(@NotNull SimpleType simpleType, @NotNull SimpleType simpleType2) {
        super(simpleType, simpleType2);
        Intrinsics.checkParameterIsNotNull(simpleType, "lowerBound");
        Intrinsics.checkParameterIsNotNull(simpleType2, "upperBound");
    }

    private final void runAssertions() {
        if (RUN_SLOW_ASSERTIONS && !this.assertionsDone) {
            this.assertionsDone = true;
            boolean z = !FlexibleTypesKt.isFlexible(getLowerBound());
            if (!_Assertions.ENABLED || z) {
                boolean z2 = !FlexibleTypesKt.isFlexible(getUpperBound());
                if (!_Assertions.ENABLED || z2) {
                    boolean areEqual = true ^ Intrinsics.areEqual((Object) getLowerBound(), (Object) getUpperBound());
                    if (!_Assertions.ENABLED || areEqual) {
                        boolean isSubtypeOf = KotlinTypeChecker.DEFAULT.isSubtypeOf(getLowerBound(), getUpperBound());
                        if (_Assertions.ENABLED && !isSubtypeOf) {
                            throw new AssertionError("Lower bound " + getLowerBound() + " of a flexible type must be a subtype of the upper bound " + getUpperBound());
                        }
                        return;
                    }
                    throw new AssertionError("Lower and upper bounds are equal: " + getLowerBound() + " == " + getUpperBound());
                }
                throw new AssertionError("Upper bound of a flexible type can not be flexible: " + getUpperBound());
            }
            throw new AssertionError("Lower bound of a flexible type can not be flexible: " + getLowerBound());
        }
    }

    @NotNull
    public SimpleType getDelegate() {
        runAssertions();
        return getLowerBound();
    }

    public boolean isTypeVariable() {
        return (getLowerBound().getConstructor().getDeclarationDescriptor() instanceof TypeParameterDescriptor) && Intrinsics.areEqual((Object) getLowerBound().getConstructor(), (Object) getUpperBound().getConstructor());
    }

    @NotNull
    public KotlinType substitutionResult(@NotNull KotlinType kotlinType) {
        UnwrappedType unwrappedType;
        Intrinsics.checkParameterIsNotNull(kotlinType, "replacement");
        UnwrappedType unwrap = kotlinType.unwrap();
        if (unwrap instanceof FlexibleType) {
            unwrappedType = unwrap;
        } else if (unwrap instanceof SimpleType) {
            SimpleType simpleType = (SimpleType) unwrap;
            unwrappedType = KotlinTypeFactory.flexibleType(simpleType, simpleType.makeNullableAsSpecified(true));
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return TypeWithEnhancementKt.inheritEnhancement(unwrappedType, unwrap);
    }

    @NotNull
    public UnwrappedType replaceAnnotations(@NotNull Annotations annotations) {
        Intrinsics.checkParameterIsNotNull(annotations, "newAnnotations");
        return KotlinTypeFactory.flexibleType(getLowerBound().replaceAnnotations(annotations), getUpperBound().replaceAnnotations(annotations));
    }

    @NotNull
    public String render(@NotNull DescriptorRenderer descriptorRenderer, @NotNull DescriptorRendererOptions descriptorRendererOptions) {
        Intrinsics.checkParameterIsNotNull(descriptorRenderer, "renderer");
        Intrinsics.checkParameterIsNotNull(descriptorRendererOptions, "options");
        if (!descriptorRendererOptions.getDebugMode()) {
            return descriptorRenderer.renderFlexibleType(descriptorRenderer.renderType(getLowerBound()), descriptorRenderer.renderType(getUpperBound()), TypeUtilsKt.getBuiltIns(this));
        }
        return '(' + descriptorRenderer.renderType(getLowerBound()) + ".." + descriptorRenderer.renderType(getUpperBound()) + ')';
    }

    @NotNull
    public UnwrappedType makeNullableAsSpecified(boolean z) {
        return KotlinTypeFactory.flexibleType(getLowerBound().makeNullableAsSpecified(z), getUpperBound().makeNullableAsSpecified(z));
    }
}
