package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.resolve.constants.IntegerLiteralTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.AbstractTypeCheckerContext;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructorSubstitution;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext;
import kotlin.reflect.jvm.internal.impl.types.model.CaptureStatus;
import kotlin.reflect.jvm.internal.impl.types.model.CapturedTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.DefinitelyNotNullTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.DynamicTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.FlexibleTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentListMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeParameterMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeVariance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ClassicTypeCheckerContext.kt */
public class ClassicTypeCheckerContext extends AbstractTypeCheckerContext implements ClassicTypeSystemContext {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final boolean allowedTypeVariable;
    private final boolean errorTypeEqualsToAnything;

    public ClassicTypeCheckerContext(boolean z, boolean z2) {
        this.errorTypeEqualsToAnything = z;
        this.allowedTypeVariable = z2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ClassicTypeCheckerContext(boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, (i & 2) != 0 ? true : z2);
    }

    public int argumentsCount(@NotNull KotlinTypeMarker kotlinTypeMarker) {
        Intrinsics.checkParameterIsNotNull(kotlinTypeMarker, "$this$argumentsCount");
        return ClassicTypeSystemContext.DefaultImpls.argumentsCount(this, kotlinTypeMarker);
    }

    @NotNull
    public TypeArgumentListMarker asArgumentList(@NotNull SimpleTypeMarker simpleTypeMarker) {
        Intrinsics.checkParameterIsNotNull(simpleTypeMarker, "$this$asArgumentList");
        return ClassicTypeSystemContext.DefaultImpls.asArgumentList(this, simpleTypeMarker);
    }

    @Nullable
    public CapturedTypeMarker asCapturedType(@NotNull SimpleTypeMarker simpleTypeMarker) {
        Intrinsics.checkParameterIsNotNull(simpleTypeMarker, "$this$asCapturedType");
        return ClassicTypeSystemContext.DefaultImpls.asCapturedType(this, simpleTypeMarker);
    }

    @Nullable
    public DefinitelyNotNullTypeMarker asDefinitelyNotNullType(@NotNull SimpleTypeMarker simpleTypeMarker) {
        Intrinsics.checkParameterIsNotNull(simpleTypeMarker, "$this$asDefinitelyNotNullType");
        return ClassicTypeSystemContext.DefaultImpls.asDefinitelyNotNullType(this, simpleTypeMarker);
    }

    @Nullable
    public DynamicTypeMarker asDynamicType(@NotNull FlexibleTypeMarker flexibleTypeMarker) {
        Intrinsics.checkParameterIsNotNull(flexibleTypeMarker, "$this$asDynamicType");
        return ClassicTypeSystemContext.DefaultImpls.asDynamicType(this, flexibleTypeMarker);
    }

    @Nullable
    public FlexibleTypeMarker asFlexibleType(@NotNull KotlinTypeMarker kotlinTypeMarker) {
        Intrinsics.checkParameterIsNotNull(kotlinTypeMarker, "$this$asFlexibleType");
        return ClassicTypeSystemContext.DefaultImpls.asFlexibleType(this, kotlinTypeMarker);
    }

    @Nullable
    public SimpleTypeMarker asSimpleType(@NotNull KotlinTypeMarker kotlinTypeMarker) {
        Intrinsics.checkParameterIsNotNull(kotlinTypeMarker, "$this$asSimpleType");
        return ClassicTypeSystemContext.DefaultImpls.asSimpleType(this, kotlinTypeMarker);
    }

    @NotNull
    public TypeArgumentMarker asTypeArgument(@NotNull KotlinTypeMarker kotlinTypeMarker) {
        Intrinsics.checkParameterIsNotNull(kotlinTypeMarker, "$this$asTypeArgument");
        return ClassicTypeSystemContext.DefaultImpls.asTypeArgument(this, kotlinTypeMarker);
    }

    @Nullable
    public SimpleTypeMarker captureFromArguments(@NotNull SimpleTypeMarker simpleTypeMarker, @NotNull CaptureStatus captureStatus) {
        Intrinsics.checkParameterIsNotNull(simpleTypeMarker, "type");
        Intrinsics.checkParameterIsNotNull(captureStatus, "status");
        return ClassicTypeSystemContext.DefaultImpls.captureFromArguments(this, simpleTypeMarker, captureStatus);
    }

    @Nullable
    public List<SimpleTypeMarker> fastCorrespondingSupertypes(@NotNull SimpleTypeMarker simpleTypeMarker, @NotNull TypeConstructorMarker typeConstructorMarker) {
        Intrinsics.checkParameterIsNotNull(simpleTypeMarker, "$this$fastCorrespondingSupertypes");
        Intrinsics.checkParameterIsNotNull(typeConstructorMarker, "constructor");
        return ClassicTypeSystemContext.DefaultImpls.fastCorrespondingSupertypes(this, simpleTypeMarker, typeConstructorMarker);
    }

    @NotNull
    public TypeArgumentMarker get(@NotNull TypeArgumentListMarker typeArgumentListMarker, int i) {
        Intrinsics.checkParameterIsNotNull(typeArgumentListMarker, "$this$get");
        return ClassicTypeSystemContext.DefaultImpls.get(this, typeArgumentListMarker, i);
    }

    @NotNull
    public TypeArgumentMarker getArgument(@NotNull KotlinTypeMarker kotlinTypeMarker, int i) {
        Intrinsics.checkParameterIsNotNull(kotlinTypeMarker, "$this$getArgument");
        return ClassicTypeSystemContext.DefaultImpls.getArgument(this, kotlinTypeMarker, i);
    }

    @Nullable
    public TypeArgumentMarker getArgumentOrNull(@NotNull SimpleTypeMarker simpleTypeMarker, int i) {
        Intrinsics.checkParameterIsNotNull(simpleTypeMarker, "$this$getArgumentOrNull");
        return ClassicTypeSystemContext.DefaultImpls.getArgumentOrNull(this, simpleTypeMarker, i);
    }

    @NotNull
    public TypeParameterMarker getParameter(@NotNull TypeConstructorMarker typeConstructorMarker, int i) {
        Intrinsics.checkParameterIsNotNull(typeConstructorMarker, "$this$getParameter");
        return ClassicTypeSystemContext.DefaultImpls.getParameter(this, typeConstructorMarker, i);
    }

    @NotNull
    public KotlinTypeMarker getType(@NotNull TypeArgumentMarker typeArgumentMarker) {
        Intrinsics.checkParameterIsNotNull(typeArgumentMarker, "$this$getType");
        return ClassicTypeSystemContext.DefaultImpls.getType(this, typeArgumentMarker);
    }

    @NotNull
    public TypeVariance getVariance(@NotNull TypeArgumentMarker typeArgumentMarker) {
        Intrinsics.checkParameterIsNotNull(typeArgumentMarker, "$this$getVariance");
        return ClassicTypeSystemContext.DefaultImpls.getVariance((ClassicTypeSystemContext) this, typeArgumentMarker);
    }

    @NotNull
    public TypeVariance getVariance(@NotNull TypeParameterMarker typeParameterMarker) {
        Intrinsics.checkParameterIsNotNull(typeParameterMarker, "$this$getVariance");
        return ClassicTypeSystemContext.DefaultImpls.getVariance((ClassicTypeSystemContext) this, typeParameterMarker);
    }

    public boolean hasFlexibleNullability(@NotNull KotlinTypeMarker kotlinTypeMarker) {
        Intrinsics.checkParameterIsNotNull(kotlinTypeMarker, "$this$hasFlexibleNullability");
        return ClassicTypeSystemContext.DefaultImpls.hasFlexibleNullability(this, kotlinTypeMarker);
    }

    public boolean identicalArguments(@NotNull SimpleTypeMarker simpleTypeMarker, @NotNull SimpleTypeMarker simpleTypeMarker2) {
        Intrinsics.checkParameterIsNotNull(simpleTypeMarker, NotificationBundleProcessor.PUSH_ADDITIONAL_DATA_KEY);
        Intrinsics.checkParameterIsNotNull(simpleTypeMarker2, "b");
        return ClassicTypeSystemContext.DefaultImpls.identicalArguments(this, simpleTypeMarker, simpleTypeMarker2);
    }

    @NotNull
    public KotlinTypeMarker intersectTypes(@NotNull List<? extends KotlinTypeMarker> list) {
        Intrinsics.checkParameterIsNotNull(list, "types");
        return ClassicTypeSystemContext.DefaultImpls.intersectTypes(this, list);
    }

    public boolean isAnyConstructor(@NotNull TypeConstructorMarker typeConstructorMarker) {
        Intrinsics.checkParameterIsNotNull(typeConstructorMarker, "$this$isAnyConstructor");
        return ClassicTypeSystemContext.DefaultImpls.isAnyConstructor(this, typeConstructorMarker);
    }

    public boolean isClassType(@NotNull SimpleTypeMarker simpleTypeMarker) {
        Intrinsics.checkParameterIsNotNull(simpleTypeMarker, "$this$isClassType");
        return ClassicTypeSystemContext.DefaultImpls.isClassType(this, simpleTypeMarker);
    }

    public boolean isClassTypeConstructor(@NotNull TypeConstructorMarker typeConstructorMarker) {
        Intrinsics.checkParameterIsNotNull(typeConstructorMarker, "$this$isClassTypeConstructor");
        return ClassicTypeSystemContext.DefaultImpls.isClassTypeConstructor(this, typeConstructorMarker);
    }

    public boolean isCommonFinalClassConstructor(@NotNull TypeConstructorMarker typeConstructorMarker) {
        Intrinsics.checkParameterIsNotNull(typeConstructorMarker, "$this$isCommonFinalClassConstructor");
        return ClassicTypeSystemContext.DefaultImpls.isCommonFinalClassConstructor(this, typeConstructorMarker);
    }

    public boolean isDefinitelyNotNullType(@NotNull KotlinTypeMarker kotlinTypeMarker) {
        Intrinsics.checkParameterIsNotNull(kotlinTypeMarker, "$this$isDefinitelyNotNullType");
        return ClassicTypeSystemContext.DefaultImpls.isDefinitelyNotNullType(this, kotlinTypeMarker);
    }

    public boolean isDenotable(@NotNull TypeConstructorMarker typeConstructorMarker) {
        Intrinsics.checkParameterIsNotNull(typeConstructorMarker, "$this$isDenotable");
        return ClassicTypeSystemContext.DefaultImpls.isDenotable(this, typeConstructorMarker);
    }

    public boolean isDynamic(@NotNull KotlinTypeMarker kotlinTypeMarker) {
        Intrinsics.checkParameterIsNotNull(kotlinTypeMarker, "$this$isDynamic");
        return ClassicTypeSystemContext.DefaultImpls.isDynamic(this, kotlinTypeMarker);
    }

    public boolean isEqualTypeConstructors(@NotNull TypeConstructorMarker typeConstructorMarker, @NotNull TypeConstructorMarker typeConstructorMarker2) {
        Intrinsics.checkParameterIsNotNull(typeConstructorMarker, "c1");
        Intrinsics.checkParameterIsNotNull(typeConstructorMarker2, "c2");
        return ClassicTypeSystemContext.DefaultImpls.isEqualTypeConstructors(this, typeConstructorMarker, typeConstructorMarker2);
    }

    public boolean isError(@NotNull KotlinTypeMarker kotlinTypeMarker) {
        Intrinsics.checkParameterIsNotNull(kotlinTypeMarker, "$this$isError");
        return ClassicTypeSystemContext.DefaultImpls.isError(this, kotlinTypeMarker);
    }

    public boolean isIntegerLiteralType(@NotNull SimpleTypeMarker simpleTypeMarker) {
        Intrinsics.checkParameterIsNotNull(simpleTypeMarker, "$this$isIntegerLiteralType");
        return ClassicTypeSystemContext.DefaultImpls.isIntegerLiteralType(this, simpleTypeMarker);
    }

    public boolean isIntegerLiteralTypeConstructor(@NotNull TypeConstructorMarker typeConstructorMarker) {
        Intrinsics.checkParameterIsNotNull(typeConstructorMarker, "$this$isIntegerLiteralTypeConstructor");
        return ClassicTypeSystemContext.DefaultImpls.isIntegerLiteralTypeConstructor(this, typeConstructorMarker);
    }

    public boolean isIntersection(@NotNull TypeConstructorMarker typeConstructorMarker) {
        Intrinsics.checkParameterIsNotNull(typeConstructorMarker, "$this$isIntersection");
        return ClassicTypeSystemContext.DefaultImpls.isIntersection(this, typeConstructorMarker);
    }

    public boolean isMarkedNullable(@NotNull SimpleTypeMarker simpleTypeMarker) {
        Intrinsics.checkParameterIsNotNull(simpleTypeMarker, "$this$isMarkedNullable");
        return ClassicTypeSystemContext.DefaultImpls.isMarkedNullable(this, simpleTypeMarker);
    }

    public boolean isNothing(@NotNull KotlinTypeMarker kotlinTypeMarker) {
        Intrinsics.checkParameterIsNotNull(kotlinTypeMarker, "$this$isNothing");
        return ClassicTypeSystemContext.DefaultImpls.isNothing(this, kotlinTypeMarker);
    }

    public boolean isNothingConstructor(@NotNull TypeConstructorMarker typeConstructorMarker) {
        Intrinsics.checkParameterIsNotNull(typeConstructorMarker, "$this$isNothingConstructor");
        return ClassicTypeSystemContext.DefaultImpls.isNothingConstructor(this, typeConstructorMarker);
    }

    public boolean isNullableType(@NotNull KotlinTypeMarker kotlinTypeMarker) {
        Intrinsics.checkParameterIsNotNull(kotlinTypeMarker, "$this$isNullableType");
        return ClassicTypeSystemContext.DefaultImpls.isNullableType(this, kotlinTypeMarker);
    }

    public boolean isSingleClassifierType(@NotNull SimpleTypeMarker simpleTypeMarker) {
        Intrinsics.checkParameterIsNotNull(simpleTypeMarker, "$this$isSingleClassifierType");
        return ClassicTypeSystemContext.DefaultImpls.isSingleClassifierType(this, simpleTypeMarker);
    }

    public boolean isStarProjection(@NotNull TypeArgumentMarker typeArgumentMarker) {
        Intrinsics.checkParameterIsNotNull(typeArgumentMarker, "$this$isStarProjection");
        return ClassicTypeSystemContext.DefaultImpls.isStarProjection(this, typeArgumentMarker);
    }

    public boolean isStubType(@NotNull SimpleTypeMarker simpleTypeMarker) {
        Intrinsics.checkParameterIsNotNull(simpleTypeMarker, "$this$isStubType");
        return ClassicTypeSystemContext.DefaultImpls.isStubType(this, simpleTypeMarker);
    }

    @NotNull
    public SimpleTypeMarker lowerBound(@NotNull FlexibleTypeMarker flexibleTypeMarker) {
        Intrinsics.checkParameterIsNotNull(flexibleTypeMarker, "$this$lowerBound");
        return ClassicTypeSystemContext.DefaultImpls.lowerBound(this, flexibleTypeMarker);
    }

    @NotNull
    public SimpleTypeMarker lowerBoundIfFlexible(@NotNull KotlinTypeMarker kotlinTypeMarker) {
        Intrinsics.checkParameterIsNotNull(kotlinTypeMarker, "$this$lowerBoundIfFlexible");
        return ClassicTypeSystemContext.DefaultImpls.lowerBoundIfFlexible(this, kotlinTypeMarker);
    }

    @Nullable
    public KotlinTypeMarker lowerType(@NotNull CapturedTypeMarker capturedTypeMarker) {
        Intrinsics.checkParameterIsNotNull(capturedTypeMarker, "$this$lowerType");
        return ClassicTypeSystemContext.DefaultImpls.lowerType(this, capturedTypeMarker);
    }

    public int parametersCount(@NotNull TypeConstructorMarker typeConstructorMarker) {
        Intrinsics.checkParameterIsNotNull(typeConstructorMarker, "$this$parametersCount");
        return ClassicTypeSystemContext.DefaultImpls.parametersCount(this, typeConstructorMarker);
    }

    @NotNull
    public Collection<KotlinTypeMarker> possibleIntegerTypes(@NotNull SimpleTypeMarker simpleTypeMarker) {
        Intrinsics.checkParameterIsNotNull(simpleTypeMarker, "$this$possibleIntegerTypes");
        return ClassicTypeSystemContext.DefaultImpls.possibleIntegerTypes(this, simpleTypeMarker);
    }

    public int size(@NotNull TypeArgumentListMarker typeArgumentListMarker) {
        Intrinsics.checkParameterIsNotNull(typeArgumentListMarker, "$this$size");
        return ClassicTypeSystemContext.DefaultImpls.size(this, typeArgumentListMarker);
    }

    @NotNull
    public Collection<KotlinTypeMarker> supertypes(@NotNull TypeConstructorMarker typeConstructorMarker) {
        Intrinsics.checkParameterIsNotNull(typeConstructorMarker, "$this$supertypes");
        return ClassicTypeSystemContext.DefaultImpls.supertypes(this, typeConstructorMarker);
    }

    @NotNull
    public TypeConstructorMarker typeConstructor(@NotNull KotlinTypeMarker kotlinTypeMarker) {
        Intrinsics.checkParameterIsNotNull(kotlinTypeMarker, "$this$typeConstructor");
        return ClassicTypeSystemContext.DefaultImpls.typeConstructor((ClassicTypeSystemContext) this, kotlinTypeMarker);
    }

    @NotNull
    public TypeConstructorMarker typeConstructor(@NotNull SimpleTypeMarker simpleTypeMarker) {
        Intrinsics.checkParameterIsNotNull(simpleTypeMarker, "$this$typeConstructor");
        return ClassicTypeSystemContext.DefaultImpls.typeConstructor((ClassicTypeSystemContext) this, simpleTypeMarker);
    }

    @NotNull
    public SimpleTypeMarker upperBound(@NotNull FlexibleTypeMarker flexibleTypeMarker) {
        Intrinsics.checkParameterIsNotNull(flexibleTypeMarker, "$this$upperBound");
        return ClassicTypeSystemContext.DefaultImpls.upperBound(this, flexibleTypeMarker);
    }

    @NotNull
    public SimpleTypeMarker upperBoundIfFlexible(@NotNull KotlinTypeMarker kotlinTypeMarker) {
        Intrinsics.checkParameterIsNotNull(kotlinTypeMarker, "$this$upperBoundIfFlexible");
        return ClassicTypeSystemContext.DefaultImpls.upperBoundIfFlexible(this, kotlinTypeMarker);
    }

    @NotNull
    public SimpleTypeMarker withNullability(@NotNull SimpleTypeMarker simpleTypeMarker, boolean z) {
        Intrinsics.checkParameterIsNotNull(simpleTypeMarker, "$this$withNullability");
        return ClassicTypeSystemContext.DefaultImpls.withNullability(this, simpleTypeMarker, z);
    }

    @NotNull
    public KotlinTypeMarker prepareType(@NotNull KotlinTypeMarker kotlinTypeMarker) {
        Intrinsics.checkParameterIsNotNull(kotlinTypeMarker, "type");
        return NewKotlinTypeChecker.INSTANCE.transformToNewType(((KotlinType) kotlinTypeMarker).unwrap());
    }

    public boolean isErrorTypeEqualsToAnything() {
        return this.errorTypeEqualsToAnything;
    }

    public boolean areEqualTypeConstructors(@NotNull TypeConstructorMarker typeConstructorMarker, @NotNull TypeConstructorMarker typeConstructorMarker2) {
        Intrinsics.checkParameterIsNotNull(typeConstructorMarker, NotificationBundleProcessor.PUSH_ADDITIONAL_DATA_KEY);
        Intrinsics.checkParameterIsNotNull(typeConstructorMarker2, "b");
        if (!(typeConstructorMarker instanceof TypeConstructor)) {
            throw new IllegalArgumentException(ClassicTypeCheckerContextKt.errorMessage(typeConstructorMarker).toString());
        } else if (typeConstructorMarker2 instanceof TypeConstructor) {
            return areEqualTypeConstructors((TypeConstructor) typeConstructorMarker, (TypeConstructor) typeConstructorMarker2);
        } else {
            throw new IllegalArgumentException(ClassicTypeCheckerContextKt.errorMessage(typeConstructorMarker2).toString());
        }
    }

    public boolean areEqualTypeConstructors(@NotNull TypeConstructor typeConstructor, @NotNull TypeConstructor typeConstructor2) {
        Intrinsics.checkParameterIsNotNull(typeConstructor, NotificationBundleProcessor.PUSH_ADDITIONAL_DATA_KEY);
        Intrinsics.checkParameterIsNotNull(typeConstructor2, "b");
        if (typeConstructor instanceof IntegerLiteralTypeConstructor) {
            return ((IntegerLiteralTypeConstructor) typeConstructor).checkConstructor(typeConstructor2);
        }
        if (typeConstructor2 instanceof IntegerLiteralTypeConstructor) {
            return ((IntegerLiteralTypeConstructor) typeConstructor2).checkConstructor(typeConstructor);
        }
        return Intrinsics.areEqual((Object) typeConstructor, (Object) typeConstructor2);
    }

    @NotNull
    public AbstractTypeCheckerContext.SupertypesPolicy.DoCustomTransform substitutionSupertypePolicy(@NotNull SimpleTypeMarker simpleTypeMarker) {
        Intrinsics.checkParameterIsNotNull(simpleTypeMarker, "type");
        return Companion.classicSubstitutionSupertypePolicy(this, simpleTypeMarker);
    }

    public boolean isAllowedTypeVariable(@NotNull KotlinTypeMarker kotlinTypeMarker) {
        Intrinsics.checkParameterIsNotNull(kotlinTypeMarker, "$this$isAllowedTypeVariable");
        return (kotlinTypeMarker instanceof UnwrappedType) && this.allowedTypeVariable && (((UnwrappedType) kotlinTypeMarker).getConstructor() instanceof NewTypeVariableConstructor);
    }

    /* compiled from: ClassicTypeCheckerContext.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final AbstractTypeCheckerContext.SupertypesPolicy.DoCustomTransform classicSubstitutionSupertypePolicy(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull SimpleTypeMarker simpleTypeMarker) {
            Intrinsics.checkParameterIsNotNull(classicTypeSystemContext, "$this$classicSubstitutionSupertypePolicy");
            Intrinsics.checkParameterIsNotNull(simpleTypeMarker, "type");
            if (simpleTypeMarker instanceof SimpleType) {
                return new C3830x9ae7c99c(classicTypeSystemContext, TypeConstructorSubstitution.Companion.create((KotlinType) simpleTypeMarker).buildSubstitutor());
            }
            throw new IllegalArgumentException(ClassicTypeCheckerContextKt.errorMessage(simpleTypeMarker).toString());
        }
    }
}
