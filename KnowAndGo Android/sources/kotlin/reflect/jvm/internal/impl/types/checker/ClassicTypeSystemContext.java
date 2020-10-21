package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.Collection;
import java.util.List;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModalityKt;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedType;
import kotlin.reflect.jvm.internal.impl.resolve.constants.IntegerLiteralTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.AbstractTypeCheckerContext;
import kotlin.reflect.jvm.internal.impl.types.DefinitelyNotNullType;
import kotlin.reflect.jvm.internal.impl.types.DynamicType;
import kotlin.reflect.jvm.internal.impl.types.FlexibleType;
import kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeKt;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.StubType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.Variance;
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
import kotlin.reflect.jvm.internal.impl.types.model.TypeSystemInferenceExtensionContext;
import kotlin.reflect.jvm.internal.impl.types.model.TypeVariance;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ClassicTypeSystemContext.kt */
public interface ClassicTypeSystemContext extends TypeSystemInferenceExtensionContext {
    @Nullable
    SimpleTypeMarker asSimpleType(@NotNull KotlinTypeMarker kotlinTypeMarker);

    @NotNull
    TypeConstructorMarker typeConstructor(@NotNull SimpleTypeMarker simpleTypeMarker);

    /* compiled from: ClassicTypeSystemContext.kt */
    public static final class DefaultImpls {
        @Nullable
        public static List<SimpleTypeMarker> fastCorrespondingSupertypes(ClassicTypeSystemContext classicTypeSystemContext, @NotNull SimpleTypeMarker simpleTypeMarker, @NotNull TypeConstructorMarker typeConstructorMarker) {
            Intrinsics.checkParameterIsNotNull(simpleTypeMarker, "$this$fastCorrespondingSupertypes");
            Intrinsics.checkParameterIsNotNull(typeConstructorMarker, "constructor");
            return TypeSystemInferenceExtensionContext.DefaultImpls.fastCorrespondingSupertypes(classicTypeSystemContext, simpleTypeMarker, typeConstructorMarker);
        }

        @NotNull
        public static TypeArgumentMarker get(ClassicTypeSystemContext classicTypeSystemContext, @NotNull TypeArgumentListMarker typeArgumentListMarker, int i) {
            Intrinsics.checkParameterIsNotNull(typeArgumentListMarker, "$this$get");
            return TypeSystemInferenceExtensionContext.DefaultImpls.get(classicTypeSystemContext, typeArgumentListMarker, i);
        }

        @Nullable
        public static TypeArgumentMarker getArgumentOrNull(ClassicTypeSystemContext classicTypeSystemContext, @NotNull SimpleTypeMarker simpleTypeMarker, int i) {
            Intrinsics.checkParameterIsNotNull(simpleTypeMarker, "$this$getArgumentOrNull");
            return TypeSystemInferenceExtensionContext.DefaultImpls.getArgumentOrNull(classicTypeSystemContext, simpleTypeMarker, i);
        }

        public static boolean hasFlexibleNullability(ClassicTypeSystemContext classicTypeSystemContext, @NotNull KotlinTypeMarker kotlinTypeMarker) {
            Intrinsics.checkParameterIsNotNull(kotlinTypeMarker, "$this$hasFlexibleNullability");
            return TypeSystemInferenceExtensionContext.DefaultImpls.hasFlexibleNullability(classicTypeSystemContext, kotlinTypeMarker);
        }

        public static boolean isClassType(ClassicTypeSystemContext classicTypeSystemContext, @NotNull SimpleTypeMarker simpleTypeMarker) {
            Intrinsics.checkParameterIsNotNull(simpleTypeMarker, "$this$isClassType");
            return TypeSystemInferenceExtensionContext.DefaultImpls.isClassType(classicTypeSystemContext, simpleTypeMarker);
        }

        public static boolean isDefinitelyNotNullType(ClassicTypeSystemContext classicTypeSystemContext, @NotNull KotlinTypeMarker kotlinTypeMarker) {
            Intrinsics.checkParameterIsNotNull(kotlinTypeMarker, "$this$isDefinitelyNotNullType");
            return TypeSystemInferenceExtensionContext.DefaultImpls.isDefinitelyNotNullType(classicTypeSystemContext, kotlinTypeMarker);
        }

        public static boolean isDynamic(ClassicTypeSystemContext classicTypeSystemContext, @NotNull KotlinTypeMarker kotlinTypeMarker) {
            Intrinsics.checkParameterIsNotNull(kotlinTypeMarker, "$this$isDynamic");
            return TypeSystemInferenceExtensionContext.DefaultImpls.isDynamic(classicTypeSystemContext, kotlinTypeMarker);
        }

        public static boolean isIntegerLiteralType(ClassicTypeSystemContext classicTypeSystemContext, @NotNull SimpleTypeMarker simpleTypeMarker) {
            Intrinsics.checkParameterIsNotNull(simpleTypeMarker, "$this$isIntegerLiteralType");
            return TypeSystemInferenceExtensionContext.DefaultImpls.isIntegerLiteralType(classicTypeSystemContext, simpleTypeMarker);
        }

        public static boolean isNothing(ClassicTypeSystemContext classicTypeSystemContext, @NotNull KotlinTypeMarker kotlinTypeMarker) {
            Intrinsics.checkParameterIsNotNull(kotlinTypeMarker, "$this$isNothing");
            return TypeSystemInferenceExtensionContext.DefaultImpls.isNothing(classicTypeSystemContext, kotlinTypeMarker);
        }

        @NotNull
        public static SimpleTypeMarker lowerBoundIfFlexible(ClassicTypeSystemContext classicTypeSystemContext, @NotNull KotlinTypeMarker kotlinTypeMarker) {
            Intrinsics.checkParameterIsNotNull(kotlinTypeMarker, "$this$lowerBoundIfFlexible");
            return TypeSystemInferenceExtensionContext.DefaultImpls.lowerBoundIfFlexible(classicTypeSystemContext, kotlinTypeMarker);
        }

        public static int size(ClassicTypeSystemContext classicTypeSystemContext, @NotNull TypeArgumentListMarker typeArgumentListMarker) {
            Intrinsics.checkParameterIsNotNull(typeArgumentListMarker, "$this$size");
            return TypeSystemInferenceExtensionContext.DefaultImpls.size(classicTypeSystemContext, typeArgumentListMarker);
        }

        @NotNull
        public static TypeConstructorMarker typeConstructor(ClassicTypeSystemContext classicTypeSystemContext, @NotNull KotlinTypeMarker kotlinTypeMarker) {
            Intrinsics.checkParameterIsNotNull(kotlinTypeMarker, "$this$typeConstructor");
            return TypeSystemInferenceExtensionContext.DefaultImpls.typeConstructor(classicTypeSystemContext, kotlinTypeMarker);
        }

        @NotNull
        public static SimpleTypeMarker upperBoundIfFlexible(ClassicTypeSystemContext classicTypeSystemContext, @NotNull KotlinTypeMarker kotlinTypeMarker) {
            Intrinsics.checkParameterIsNotNull(kotlinTypeMarker, "$this$upperBoundIfFlexible");
            return TypeSystemInferenceExtensionContext.DefaultImpls.upperBoundIfFlexible(classicTypeSystemContext, kotlinTypeMarker);
        }

        public static boolean isDenotable(ClassicTypeSystemContext classicTypeSystemContext, @NotNull TypeConstructorMarker typeConstructorMarker) {
            Intrinsics.checkParameterIsNotNull(typeConstructorMarker, "$this$isDenotable");
            if (typeConstructorMarker instanceof TypeConstructor) {
                return ((TypeConstructor) typeConstructorMarker).isDenotable();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + typeConstructorMarker + ", " + Reflection.getOrCreateKotlinClass(typeConstructorMarker.getClass())).toString());
        }

        public static boolean isIntegerLiteralTypeConstructor(ClassicTypeSystemContext classicTypeSystemContext, @NotNull TypeConstructorMarker typeConstructorMarker) {
            Intrinsics.checkParameterIsNotNull(typeConstructorMarker, "$this$isIntegerLiteralTypeConstructor");
            if (typeConstructorMarker instanceof TypeConstructor) {
                return typeConstructorMarker instanceof IntegerLiteralTypeConstructor;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + typeConstructorMarker + ", " + Reflection.getOrCreateKotlinClass(typeConstructorMarker.getClass())).toString());
        }

        @NotNull
        public static Collection<KotlinTypeMarker> possibleIntegerTypes(ClassicTypeSystemContext classicTypeSystemContext, @NotNull SimpleTypeMarker simpleTypeMarker) {
            Intrinsics.checkParameterIsNotNull(simpleTypeMarker, "$this$possibleIntegerTypes");
            TypeConstructorMarker typeConstructor = classicTypeSystemContext.typeConstructor(simpleTypeMarker);
            if (typeConstructor instanceof IntegerLiteralTypeConstructor) {
                return ((IntegerLiteralTypeConstructor) typeConstructor).getPossibleTypes();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + simpleTypeMarker + ", " + Reflection.getOrCreateKotlinClass(simpleTypeMarker.getClass())).toString());
        }

        @NotNull
        public static SimpleTypeMarker withNullability(ClassicTypeSystemContext classicTypeSystemContext, @NotNull SimpleTypeMarker simpleTypeMarker, boolean z) {
            Intrinsics.checkParameterIsNotNull(simpleTypeMarker, "$this$withNullability");
            if (simpleTypeMarker instanceof SimpleType) {
                return ((SimpleType) simpleTypeMarker).makeNullableAsSpecified(z);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + simpleTypeMarker + ", " + Reflection.getOrCreateKotlinClass(simpleTypeMarker.getClass())).toString());
        }

        public static boolean isError(ClassicTypeSystemContext classicTypeSystemContext, @NotNull KotlinTypeMarker kotlinTypeMarker) {
            Intrinsics.checkParameterIsNotNull(kotlinTypeMarker, "$this$isError");
            if (kotlinTypeMarker instanceof KotlinType) {
                return KotlinTypeKt.isError((KotlinType) kotlinTypeMarker);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + kotlinTypeMarker + ", " + Reflection.getOrCreateKotlinClass(kotlinTypeMarker.getClass())).toString());
        }

        public static boolean isStubType(ClassicTypeSystemContext classicTypeSystemContext, @NotNull SimpleTypeMarker simpleTypeMarker) {
            Intrinsics.checkParameterIsNotNull(simpleTypeMarker, "$this$isStubType");
            if (simpleTypeMarker instanceof SimpleType) {
                return simpleTypeMarker instanceof StubType;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + simpleTypeMarker + ", " + Reflection.getOrCreateKotlinClass(simpleTypeMarker.getClass())).toString());
        }

        @Nullable
        public static KotlinTypeMarker lowerType(ClassicTypeSystemContext classicTypeSystemContext, @NotNull CapturedTypeMarker capturedTypeMarker) {
            Intrinsics.checkParameterIsNotNull(capturedTypeMarker, "$this$lowerType");
            if (capturedTypeMarker instanceof NewCapturedType) {
                return ((NewCapturedType) capturedTypeMarker).getLowerType();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + capturedTypeMarker + ", " + Reflection.getOrCreateKotlinClass(capturedTypeMarker.getClass())).toString());
        }

        public static boolean isIntersection(ClassicTypeSystemContext classicTypeSystemContext, @NotNull TypeConstructorMarker typeConstructorMarker) {
            Intrinsics.checkParameterIsNotNull(typeConstructorMarker, "$this$isIntersection");
            if (typeConstructorMarker instanceof TypeConstructor) {
                return typeConstructorMarker instanceof IntersectionTypeConstructor;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + typeConstructorMarker + ", " + Reflection.getOrCreateKotlinClass(typeConstructorMarker.getClass())).toString());
        }

        public static boolean identicalArguments(ClassicTypeSystemContext classicTypeSystemContext, @NotNull SimpleTypeMarker simpleTypeMarker, @NotNull SimpleTypeMarker simpleTypeMarker2) {
            Intrinsics.checkParameterIsNotNull(simpleTypeMarker, NotificationBundleProcessor.PUSH_ADDITIONAL_DATA_KEY);
            Intrinsics.checkParameterIsNotNull(simpleTypeMarker2, "b");
            if (!(simpleTypeMarker instanceof SimpleType)) {
                throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + simpleTypeMarker + ", " + Reflection.getOrCreateKotlinClass(simpleTypeMarker.getClass())).toString());
            } else if (simpleTypeMarker2 instanceof SimpleType) {
                return ((SimpleType) simpleTypeMarker).getArguments() == ((SimpleType) simpleTypeMarker2).getArguments();
            } else {
                throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + simpleTypeMarker2 + ", " + Reflection.getOrCreateKotlinClass(simpleTypeMarker2.getClass())).toString());
            }
        }

        @Nullable
        public static SimpleTypeMarker asSimpleType(ClassicTypeSystemContext classicTypeSystemContext, @NotNull KotlinTypeMarker kotlinTypeMarker) {
            Intrinsics.checkParameterIsNotNull(kotlinTypeMarker, "$this$asSimpleType");
            if (kotlinTypeMarker instanceof KotlinType) {
                UnwrappedType unwrap = ((KotlinType) kotlinTypeMarker).unwrap();
                if (!(unwrap instanceof SimpleType)) {
                    unwrap = null;
                }
                return (SimpleType) unwrap;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + kotlinTypeMarker + ", " + Reflection.getOrCreateKotlinClass(kotlinTypeMarker.getClass())).toString());
        }

        @Nullable
        public static FlexibleTypeMarker asFlexibleType(ClassicTypeSystemContext classicTypeSystemContext, @NotNull KotlinTypeMarker kotlinTypeMarker) {
            Intrinsics.checkParameterIsNotNull(kotlinTypeMarker, "$this$asFlexibleType");
            if (kotlinTypeMarker instanceof KotlinType) {
                UnwrappedType unwrap = ((KotlinType) kotlinTypeMarker).unwrap();
                if (!(unwrap instanceof FlexibleType)) {
                    unwrap = null;
                }
                return (FlexibleType) unwrap;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + kotlinTypeMarker + ", " + Reflection.getOrCreateKotlinClass(kotlinTypeMarker.getClass())).toString());
        }

        @Nullable
        public static DynamicTypeMarker asDynamicType(ClassicTypeSystemContext classicTypeSystemContext, @NotNull FlexibleTypeMarker flexibleTypeMarker) {
            Intrinsics.checkParameterIsNotNull(flexibleTypeMarker, "$this$asDynamicType");
            if (flexibleTypeMarker instanceof FlexibleType) {
                if (!(flexibleTypeMarker instanceof DynamicType)) {
                    flexibleTypeMarker = null;
                }
                return (DynamicType) flexibleTypeMarker;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + flexibleTypeMarker + ", " + Reflection.getOrCreateKotlinClass(flexibleTypeMarker.getClass())).toString());
        }

        @NotNull
        public static SimpleTypeMarker upperBound(ClassicTypeSystemContext classicTypeSystemContext, @NotNull FlexibleTypeMarker flexibleTypeMarker) {
            Intrinsics.checkParameterIsNotNull(flexibleTypeMarker, "$this$upperBound");
            if (flexibleTypeMarker instanceof FlexibleType) {
                return ((FlexibleType) flexibleTypeMarker).getUpperBound();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + flexibleTypeMarker + ", " + Reflection.getOrCreateKotlinClass(flexibleTypeMarker.getClass())).toString());
        }

        @NotNull
        public static SimpleTypeMarker lowerBound(ClassicTypeSystemContext classicTypeSystemContext, @NotNull FlexibleTypeMarker flexibleTypeMarker) {
            Intrinsics.checkParameterIsNotNull(flexibleTypeMarker, "$this$lowerBound");
            if (flexibleTypeMarker instanceof FlexibleType) {
                return ((FlexibleType) flexibleTypeMarker).getLowerBound();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + flexibleTypeMarker + ", " + Reflection.getOrCreateKotlinClass(flexibleTypeMarker.getClass())).toString());
        }

        @Nullable
        public static CapturedTypeMarker asCapturedType(ClassicTypeSystemContext classicTypeSystemContext, @NotNull SimpleTypeMarker simpleTypeMarker) {
            Intrinsics.checkParameterIsNotNull(simpleTypeMarker, "$this$asCapturedType");
            if (simpleTypeMarker instanceof SimpleType) {
                if (!(simpleTypeMarker instanceof NewCapturedType)) {
                    simpleTypeMarker = null;
                }
                return (NewCapturedType) simpleTypeMarker;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + simpleTypeMarker + ", " + Reflection.getOrCreateKotlinClass(simpleTypeMarker.getClass())).toString());
        }

        @Nullable
        public static DefinitelyNotNullTypeMarker asDefinitelyNotNullType(ClassicTypeSystemContext classicTypeSystemContext, @NotNull SimpleTypeMarker simpleTypeMarker) {
            Intrinsics.checkParameterIsNotNull(simpleTypeMarker, "$this$asDefinitelyNotNullType");
            if (simpleTypeMarker instanceof SimpleType) {
                if (!(simpleTypeMarker instanceof DefinitelyNotNullType)) {
                    simpleTypeMarker = null;
                }
                return (DefinitelyNotNullType) simpleTypeMarker;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + simpleTypeMarker + ", " + Reflection.getOrCreateKotlinClass(simpleTypeMarker.getClass())).toString());
        }

        public static boolean isMarkedNullable(ClassicTypeSystemContext classicTypeSystemContext, @NotNull SimpleTypeMarker simpleTypeMarker) {
            Intrinsics.checkParameterIsNotNull(simpleTypeMarker, "$this$isMarkedNullable");
            if (simpleTypeMarker instanceof SimpleType) {
                return ((SimpleType) simpleTypeMarker).isMarkedNullable();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + simpleTypeMarker + ", " + Reflection.getOrCreateKotlinClass(simpleTypeMarker.getClass())).toString());
        }

        @NotNull
        public static TypeConstructorMarker typeConstructor(ClassicTypeSystemContext classicTypeSystemContext, @NotNull SimpleTypeMarker simpleTypeMarker) {
            Intrinsics.checkParameterIsNotNull(simpleTypeMarker, "$this$typeConstructor");
            if (simpleTypeMarker instanceof SimpleType) {
                return ((SimpleType) simpleTypeMarker).getConstructor();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + simpleTypeMarker + ", " + Reflection.getOrCreateKotlinClass(simpleTypeMarker.getClass())).toString());
        }

        public static int argumentsCount(ClassicTypeSystemContext classicTypeSystemContext, @NotNull KotlinTypeMarker kotlinTypeMarker) {
            Intrinsics.checkParameterIsNotNull(kotlinTypeMarker, "$this$argumentsCount");
            if (kotlinTypeMarker instanceof KotlinType) {
                return ((KotlinType) kotlinTypeMarker).getArguments().size();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + kotlinTypeMarker + ", " + Reflection.getOrCreateKotlinClass(kotlinTypeMarker.getClass())).toString());
        }

        @NotNull
        public static TypeArgumentMarker getArgument(ClassicTypeSystemContext classicTypeSystemContext, @NotNull KotlinTypeMarker kotlinTypeMarker, int i) {
            Intrinsics.checkParameterIsNotNull(kotlinTypeMarker, "$this$getArgument");
            if (kotlinTypeMarker instanceof KotlinType) {
                return ((KotlinType) kotlinTypeMarker).getArguments().get(i);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + kotlinTypeMarker + ", " + Reflection.getOrCreateKotlinClass(kotlinTypeMarker.getClass())).toString());
        }

        public static boolean isStarProjection(ClassicTypeSystemContext classicTypeSystemContext, @NotNull TypeArgumentMarker typeArgumentMarker) {
            Intrinsics.checkParameterIsNotNull(typeArgumentMarker, "$this$isStarProjection");
            if (typeArgumentMarker instanceof TypeProjection) {
                return ((TypeProjection) typeArgumentMarker).isStarProjection();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + typeArgumentMarker + ", " + Reflection.getOrCreateKotlinClass(typeArgumentMarker.getClass())).toString());
        }

        @NotNull
        public static TypeVariance getVariance(ClassicTypeSystemContext classicTypeSystemContext, @NotNull TypeArgumentMarker typeArgumentMarker) {
            Intrinsics.checkParameterIsNotNull(typeArgumentMarker, "$this$getVariance");
            if (typeArgumentMarker instanceof TypeProjection) {
                Variance projectionKind = ((TypeProjection) typeArgumentMarker).getProjectionKind();
                Intrinsics.checkExpressionValueIsNotNull(projectionKind, "this.projectionKind");
                return ClassicTypeSystemContextKt.convertVariance(projectionKind);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + typeArgumentMarker + ", " + Reflection.getOrCreateKotlinClass(typeArgumentMarker.getClass())).toString());
        }

        @NotNull
        public static KotlinTypeMarker getType(ClassicTypeSystemContext classicTypeSystemContext, @NotNull TypeArgumentMarker typeArgumentMarker) {
            Intrinsics.checkParameterIsNotNull(typeArgumentMarker, "$this$getType");
            if (typeArgumentMarker instanceof TypeProjection) {
                return ((TypeProjection) typeArgumentMarker).getType().unwrap();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + typeArgumentMarker + ", " + Reflection.getOrCreateKotlinClass(typeArgumentMarker.getClass())).toString());
        }

        public static int parametersCount(ClassicTypeSystemContext classicTypeSystemContext, @NotNull TypeConstructorMarker typeConstructorMarker) {
            Intrinsics.checkParameterIsNotNull(typeConstructorMarker, "$this$parametersCount");
            if (typeConstructorMarker instanceof TypeConstructor) {
                return ((TypeConstructor) typeConstructorMarker).getParameters().size();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + typeConstructorMarker + ", " + Reflection.getOrCreateKotlinClass(typeConstructorMarker.getClass())).toString());
        }

        @NotNull
        public static TypeParameterMarker getParameter(ClassicTypeSystemContext classicTypeSystemContext, @NotNull TypeConstructorMarker typeConstructorMarker, int i) {
            Intrinsics.checkParameterIsNotNull(typeConstructorMarker, "$this$getParameter");
            if (typeConstructorMarker instanceof TypeConstructor) {
                TypeParameterDescriptor typeParameterDescriptor = ((TypeConstructor) typeConstructorMarker).getParameters().get(i);
                Intrinsics.checkExpressionValueIsNotNull(typeParameterDescriptor, "this.parameters[index]");
                return typeParameterDescriptor;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + typeConstructorMarker + ", " + Reflection.getOrCreateKotlinClass(typeConstructorMarker.getClass())).toString());
        }

        @NotNull
        public static Collection<KotlinTypeMarker> supertypes(ClassicTypeSystemContext classicTypeSystemContext, @NotNull TypeConstructorMarker typeConstructorMarker) {
            Intrinsics.checkParameterIsNotNull(typeConstructorMarker, "$this$supertypes");
            if (typeConstructorMarker instanceof TypeConstructor) {
                Collection<KotlinType> supertypes = ((TypeConstructor) typeConstructorMarker).getSupertypes();
                Intrinsics.checkExpressionValueIsNotNull(supertypes, "this.supertypes");
                return supertypes;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + typeConstructorMarker + ", " + Reflection.getOrCreateKotlinClass(typeConstructorMarker.getClass())).toString());
        }

        @NotNull
        public static TypeVariance getVariance(ClassicTypeSystemContext classicTypeSystemContext, @NotNull TypeParameterMarker typeParameterMarker) {
            Intrinsics.checkParameterIsNotNull(typeParameterMarker, "$this$getVariance");
            if (typeParameterMarker instanceof TypeParameterDescriptor) {
                Variance variance = ((TypeParameterDescriptor) typeParameterMarker).getVariance();
                Intrinsics.checkExpressionValueIsNotNull(variance, "this.variance");
                return ClassicTypeSystemContextKt.convertVariance(variance);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + typeParameterMarker + ", " + Reflection.getOrCreateKotlinClass(typeParameterMarker.getClass())).toString());
        }

        public static boolean isEqualTypeConstructors(ClassicTypeSystemContext classicTypeSystemContext, @NotNull TypeConstructorMarker typeConstructorMarker, @NotNull TypeConstructorMarker typeConstructorMarker2) {
            Intrinsics.checkParameterIsNotNull(typeConstructorMarker, "c1");
            Intrinsics.checkParameterIsNotNull(typeConstructorMarker2, "c2");
            if (!(typeConstructorMarker instanceof TypeConstructor)) {
                throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + typeConstructorMarker + ", " + Reflection.getOrCreateKotlinClass(typeConstructorMarker.getClass())).toString());
            } else if (typeConstructorMarker2 instanceof TypeConstructor) {
                return Intrinsics.areEqual((Object) typeConstructorMarker, (Object) typeConstructorMarker2);
            } else {
                throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + typeConstructorMarker2 + ", " + Reflection.getOrCreateKotlinClass(typeConstructorMarker2.getClass())).toString());
            }
        }

        public static boolean isClassTypeConstructor(ClassicTypeSystemContext classicTypeSystemContext, @NotNull TypeConstructorMarker typeConstructorMarker) {
            Intrinsics.checkParameterIsNotNull(typeConstructorMarker, "$this$isClassTypeConstructor");
            if (typeConstructorMarker instanceof TypeConstructor) {
                return ((TypeConstructor) typeConstructorMarker).getDeclarationDescriptor() instanceof ClassDescriptor;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + typeConstructorMarker + ", " + Reflection.getOrCreateKotlinClass(typeConstructorMarker.getClass())).toString());
        }

        public static boolean isCommonFinalClassConstructor(ClassicTypeSystemContext classicTypeSystemContext, @NotNull TypeConstructorMarker typeConstructorMarker) {
            Intrinsics.checkParameterIsNotNull(typeConstructorMarker, "$this$isCommonFinalClassConstructor");
            if (typeConstructorMarker instanceof TypeConstructor) {
                ClassifierDescriptor declarationDescriptor = ((TypeConstructor) typeConstructorMarker).getDeclarationDescriptor();
                if (!(declarationDescriptor instanceof ClassDescriptor)) {
                    declarationDescriptor = null;
                }
                ClassDescriptor classDescriptor = (ClassDescriptor) declarationDescriptor;
                if (classDescriptor == null || !ModalityKt.isFinalClass(classDescriptor) || classDescriptor.getKind() == ClassKind.ENUM_ENTRY || classDescriptor.getKind() == ClassKind.ANNOTATION_CLASS) {
                    return false;
                }
                return true;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + typeConstructorMarker + ", " + Reflection.getOrCreateKotlinClass(typeConstructorMarker.getClass())).toString());
        }

        @NotNull
        public static TypeArgumentListMarker asArgumentList(ClassicTypeSystemContext classicTypeSystemContext, @NotNull SimpleTypeMarker simpleTypeMarker) {
            Intrinsics.checkParameterIsNotNull(simpleTypeMarker, "$this$asArgumentList");
            if (simpleTypeMarker instanceof SimpleType) {
                return (TypeArgumentListMarker) simpleTypeMarker;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + simpleTypeMarker + ", " + Reflection.getOrCreateKotlinClass(simpleTypeMarker.getClass())).toString());
        }

        @Nullable
        public static SimpleTypeMarker captureFromArguments(ClassicTypeSystemContext classicTypeSystemContext, @NotNull SimpleTypeMarker simpleTypeMarker, @NotNull CaptureStatus captureStatus) {
            Intrinsics.checkParameterIsNotNull(simpleTypeMarker, "type");
            Intrinsics.checkParameterIsNotNull(captureStatus, "status");
            if (simpleTypeMarker instanceof SimpleType) {
                return NewCapturedTypeKt.captureFromArguments$default((SimpleType) simpleTypeMarker, captureStatus, (Function2) null, 4, (Object) null);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + simpleTypeMarker + ", " + Reflection.getOrCreateKotlinClass(simpleTypeMarker.getClass())).toString());
        }

        public static boolean isAnyConstructor(ClassicTypeSystemContext classicTypeSystemContext, @NotNull TypeConstructorMarker typeConstructorMarker) {
            Intrinsics.checkParameterIsNotNull(typeConstructorMarker, "$this$isAnyConstructor");
            if (typeConstructorMarker instanceof TypeConstructor) {
                return KotlinBuiltIns.isTypeConstructorForGivenClass((TypeConstructor) typeConstructorMarker, KotlinBuiltIns.FQ_NAMES.any);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + typeConstructorMarker + ", " + Reflection.getOrCreateKotlinClass(typeConstructorMarker.getClass())).toString());
        }

        public static boolean isNothingConstructor(ClassicTypeSystemContext classicTypeSystemContext, @NotNull TypeConstructorMarker typeConstructorMarker) {
            Intrinsics.checkParameterIsNotNull(typeConstructorMarker, "$this$isNothingConstructor");
            if (typeConstructorMarker instanceof TypeConstructor) {
                return KotlinBuiltIns.isTypeConstructorForGivenClass((TypeConstructor) typeConstructorMarker, KotlinBuiltIns.FQ_NAMES.nothing);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + typeConstructorMarker + ", " + Reflection.getOrCreateKotlinClass(typeConstructorMarker.getClass())).toString());
        }

        @NotNull
        public static TypeArgumentMarker asTypeArgument(ClassicTypeSystemContext classicTypeSystemContext, @NotNull KotlinTypeMarker kotlinTypeMarker) {
            Intrinsics.checkParameterIsNotNull(kotlinTypeMarker, "$this$asTypeArgument");
            if (kotlinTypeMarker instanceof KotlinType) {
                return TypeUtilsKt.asTypeProjection((KotlinType) kotlinTypeMarker);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + kotlinTypeMarker + ", " + Reflection.getOrCreateKotlinClass(kotlinTypeMarker.getClass())).toString());
        }

        public static boolean isSingleClassifierType(ClassicTypeSystemContext classicTypeSystemContext, @NotNull SimpleTypeMarker simpleTypeMarker) {
            Intrinsics.checkParameterIsNotNull(simpleTypeMarker, "$this$isSingleClassifierType");
            if (simpleTypeMarker instanceof SimpleType) {
                if (!KotlinTypeKt.isError((KotlinType) simpleTypeMarker)) {
                    SimpleType simpleType = (SimpleType) simpleTypeMarker;
                    return !(simpleType.getConstructor().getDeclarationDescriptor() instanceof TypeAliasDescriptor) && (simpleType.getConstructor().getDeclarationDescriptor() != null || (simpleTypeMarker instanceof CapturedType) || (simpleTypeMarker instanceof NewCapturedType) || (simpleTypeMarker instanceof DefinitelyNotNullType) || (simpleType.getConstructor() instanceof IntegerLiteralTypeConstructor));
                }
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + simpleTypeMarker + ", " + Reflection.getOrCreateKotlinClass(simpleTypeMarker.getClass())).toString());
        }

        @NotNull
        public static KotlinTypeMarker intersectTypes(ClassicTypeSystemContext classicTypeSystemContext, @NotNull List<? extends KotlinTypeMarker> list) {
            Intrinsics.checkParameterIsNotNull(list, "types");
            return IntersectionTypeKt.intersectTypes(list);
        }

        @NotNull
        public static AbstractTypeCheckerContext newBaseTypeCheckerContext(ClassicTypeSystemContext classicTypeSystemContext, boolean z) {
            return new ClassicTypeCheckerContext(z, false, 2, (DefaultConstructorMarker) null);
        }

        public static boolean isNullableType(ClassicTypeSystemContext classicTypeSystemContext, @NotNull KotlinTypeMarker kotlinTypeMarker) {
            Intrinsics.checkParameterIsNotNull(kotlinTypeMarker, "$this$isNullableType");
            if (kotlinTypeMarker instanceof KotlinType) {
                return TypeUtils.isNullableType((KotlinType) kotlinTypeMarker);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + kotlinTypeMarker + ", " + Reflection.getOrCreateKotlinClass(kotlinTypeMarker.getClass())).toString());
        }
    }
}
