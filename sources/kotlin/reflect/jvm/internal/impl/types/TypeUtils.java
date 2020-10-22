package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.checker.NewTypeVariableConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class TypeUtils {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final SimpleType CANT_INFER_FUNCTION_PARAM_TYPE = ErrorUtils.createErrorType("Cannot be inferred");
    public static final SimpleType DONT_CARE = ErrorUtils.createErrorTypeWithCustomDebugName("DONT_CARE");
    @NotNull
    public static final SimpleType NO_EXPECTED_TYPE = new SpecialType("NO_EXPECTED_TYPE");
    public static final SimpleType UNIT_EXPECTED_TYPE = new SpecialType("UNIT_EXPECTED_TYPE");

    private static /* synthetic */ void $$$reportNull$$$0(int i) {
        String str;
        int i2;
        Throwable th;
        switch (i) {
            case 4:
            case 6:
            case 7:
            case 9:
            case 11:
            case 12:
            case 14:
            case 16:
            case 23:
            case 32:
            case 44:
            case 49:
            case 52:
            case 53:
            case 54:
            case 55:
                str = "@NotNull method %s.%s must not return null";
                break;
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i) {
            case 4:
            case 6:
            case 7:
            case 9:
            case 11:
            case 12:
            case 14:
            case 16:
            case 23:
            case 32:
            case 44:
            case 49:
            case 52:
            case 53:
            case 54:
            case 55:
                i2 = 2;
                break;
            default:
                i2 = 3;
                break;
        }
        Object[] objArr = new Object[i2];
        switch (i) {
            case 4:
            case 6:
            case 7:
            case 9:
            case 11:
            case 12:
            case 14:
            case 16:
            case 23:
            case 32:
            case 44:
            case 49:
            case 52:
            case 53:
            case 54:
            case 55:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/types/TypeUtils";
                break;
            case 13:
                objArr[0] = "parameters";
                break;
            case 17:
                objArr[0] = "subType";
                break;
            case 18:
                objArr[0] = "superType";
                break;
            case 19:
                objArr[0] = "substitutor";
                break;
            case 21:
                objArr[0] = "result";
                break;
            case 28:
            case 30:
                objArr[0] = "clazz";
                break;
            case 29:
                objArr[0] = "typeArguments";
                break;
            case 31:
                objArr[0] = "projections";
                break;
            case 33:
                objArr[0] = NotificationBundleProcessor.PUSH_ADDITIONAL_DATA_KEY;
                break;
            case 34:
                objArr[0] = "b";
                break;
            case 36:
                objArr[0] = "typeParameters";
                break;
            case 38:
                objArr[0] = "typeParameterConstructors";
                break;
            case 39:
                objArr[0] = "specialType";
                break;
            case 40:
            case 41:
                objArr[0] = "isSpecialType";
                break;
            case 42:
                objArr[0] = "parameterDescriptor";
                break;
            case 43:
            case 47:
                objArr[0] = "numberValueTypeConstructor";
                break;
            case 45:
            case 46:
                objArr[0] = "supertypes";
                break;
            case 48:
            case 51:
                objArr[0] = "expectedType";
                break;
            case 50:
                objArr[0] = "literalTypeConstructor";
                break;
            default:
                objArr[0] = "type";
                break;
        }
        switch (i) {
            case 4:
                objArr[1] = "makeNullableAsSpecified";
                break;
            case 6:
            case 7:
            case 9:
                objArr[1] = "makeNullableIfNeeded";
                break;
            case 11:
            case 12:
                objArr[1] = "makeUnsubstitutedType";
                break;
            case 14:
                objArr[1] = "getDefaultTypeProjections";
                break;
            case 16:
                objArr[1] = "getImmediateSupertypes";
                break;
            case 23:
                objArr[1] = "getAllSupertypes";
                break;
            case 32:
                objArr[1] = "substituteProjectionsForParameters";
                break;
            case 44:
                objArr[1] = "getDefaultPrimitiveNumberType";
                break;
            case 49:
            case 52:
            case 53:
            case 54:
            case 55:
                objArr[1] = "getPrimitiveNumberType";
                break;
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/types/TypeUtils";
                break;
        }
        switch (i) {
            case 1:
                objArr[2] = "makeNullable";
                break;
            case 2:
                objArr[2] = "makeNotNullable";
                break;
            case 3:
                objArr[2] = "makeNullableAsSpecified";
                break;
            case 4:
            case 6:
            case 7:
            case 9:
            case 11:
            case 12:
            case 14:
            case 16:
            case 23:
            case 32:
            case 44:
            case 49:
            case 52:
            case 53:
            case 54:
            case 55:
                break;
            case 5:
            case 8:
                objArr[2] = "makeNullableIfNeeded";
                break;
            case 10:
                objArr[2] = "canHaveSubtypes";
                break;
            case 13:
                objArr[2] = "getDefaultTypeProjections";
                break;
            case 15:
                objArr[2] = "getImmediateSupertypes";
                break;
            case 17:
            case 18:
            case 19:
                objArr[2] = "createSubstitutedSupertype";
                break;
            case 20:
            case 21:
                objArr[2] = "collectAllSupertypes";
                break;
            case 22:
                objArr[2] = "getAllSupertypes";
                break;
            case 24:
                objArr[2] = "isNullableType";
                break;
            case 25:
                objArr[2] = "acceptsNullable";
                break;
            case 26:
                objArr[2] = "hasNullableSuperType";
                break;
            case 27:
                objArr[2] = "getClassDescriptor";
                break;
            case 28:
            case 29:
                objArr[2] = "substituteParameters";
                break;
            case 30:
            case 31:
                objArr[2] = "substituteProjectionsForParameters";
                break;
            case 33:
            case 34:
                objArr[2] = "equalTypes";
                break;
            case 35:
            case 36:
                objArr[2] = "dependsOnTypeParameters";
                break;
            case 37:
            case 38:
                objArr[2] = "dependsOnTypeConstructors";
                break;
            case 39:
            case 40:
            case 41:
                objArr[2] = "contains";
                break;
            case 42:
                objArr[2] = "makeStarProjection";
                break;
            case 43:
            case 45:
                objArr[2] = "getDefaultPrimitiveNumberType";
                break;
            case 46:
                objArr[2] = "findByFqName";
                break;
            case 47:
            case 48:
            case 50:
            case 51:
                objArr[2] = "getPrimitiveNumberType";
                break;
            case 56:
                objArr[2] = "isTypeParameter";
                break;
            case 57:
                objArr[2] = "isReifiedTypeParameter";
                break;
            case 58:
                objArr[2] = "isNonReifiedTypeParameter";
                break;
            case 59:
                objArr[2] = "getTypeParameterDescriptorOrNull";
                break;
            default:
                objArr[2] = "noExpectedType";
                break;
        }
        String format = String.format(str, objArr);
        switch (i) {
            case 4:
            case 6:
            case 7:
            case 9:
            case 11:
            case 12:
            case 14:
            case 16:
            case 23:
            case 32:
            case 44:
            case 49:
            case 52:
            case 53:
            case 54:
            case 55:
                th = new IllegalStateException(format);
                break;
            default:
                th = new IllegalArgumentException(format);
                break;
        }
        throw th;
    }

    public static class SpecialType extends DelegatingSimpleType {
        private final String name;

        private static /* synthetic */ void $$$reportNull$$$0(int i) {
            String str = i != 1 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
            Object[] objArr = new Object[(i != 1 ? 3 : 2)];
            if (i != 1) {
                objArr[0] = "newAnnotations";
            } else {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/types/TypeUtils$SpecialType";
            }
            if (i != 1) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/types/TypeUtils$SpecialType";
            } else {
                objArr[1] = "toString";
            }
            if (i != 1) {
                objArr[2] = "replaceAnnotations";
            }
            String format = String.format(str, objArr);
            throw (i != 1 ? new IllegalArgumentException(format) : new IllegalStateException(format));
        }

        public SpecialType(String str) {
            this.name = str;
        }

        /* access modifiers changed from: protected */
        @NotNull
        public SimpleType getDelegate() {
            throw new IllegalStateException(this.name);
        }

        @NotNull
        public SimpleType replaceAnnotations(@NotNull Annotations annotations) {
            if (annotations == null) {
                $$$reportNull$$$0(0);
            }
            throw new IllegalStateException(this.name);
        }

        @NotNull
        public SimpleType makeNullableAsSpecified(boolean z) {
            throw new IllegalStateException(this.name);
        }

        @NotNull
        public String toString() {
            String str = this.name;
            if (str == null) {
                $$$reportNull$$$0(1);
            }
            return str;
        }
    }

    public static boolean noExpectedType(@NotNull KotlinType kotlinType) {
        if (kotlinType == null) {
            $$$reportNull$$$0(0);
        }
        return kotlinType == NO_EXPECTED_TYPE || kotlinType == UNIT_EXPECTED_TYPE;
    }

    public static boolean isDontCarePlaceholder(@Nullable KotlinType kotlinType) {
        return kotlinType != null && kotlinType.getConstructor() == DONT_CARE.getConstructor();
    }

    @NotNull
    public static KotlinType makeNullable(@NotNull KotlinType kotlinType) {
        if (kotlinType == null) {
            $$$reportNull$$$0(1);
        }
        return makeNullableAsSpecified(kotlinType, true);
    }

    @NotNull
    public static KotlinType makeNotNullable(@NotNull KotlinType kotlinType) {
        if (kotlinType == null) {
            $$$reportNull$$$0(2);
        }
        return makeNullableAsSpecified(kotlinType, false);
    }

    @NotNull
    public static KotlinType makeNullableAsSpecified(@NotNull KotlinType kotlinType, boolean z) {
        if (kotlinType == null) {
            $$$reportNull$$$0(3);
        }
        UnwrappedType makeNullableAsSpecified = kotlinType.unwrap().makeNullableAsSpecified(z);
        if (makeNullableAsSpecified == null) {
            $$$reportNull$$$0(4);
        }
        return makeNullableAsSpecified;
    }

    @NotNull
    public static KotlinType makeNullableIfNeeded(@NotNull KotlinType kotlinType, boolean z) {
        if (kotlinType == null) {
            $$$reportNull$$$0(8);
        }
        if (z) {
            return makeNullable(kotlinType);
        }
        if (kotlinType == null) {
            $$$reportNull$$$0(9);
        }
        return kotlinType;
    }

    @NotNull
    public static SimpleType makeUnsubstitutedType(ClassifierDescriptor classifierDescriptor, MemberScope memberScope) {
        if (ErrorUtils.isError(classifierDescriptor)) {
            SimpleType createErrorType = ErrorUtils.createErrorType("Unsubstituted type for " + classifierDescriptor);
            if (createErrorType == null) {
                $$$reportNull$$$0(11);
            }
            return createErrorType;
        }
        TypeConstructor typeConstructor = classifierDescriptor.getTypeConstructor();
        SimpleType simpleTypeWithNonTrivialMemberScope = KotlinTypeFactory.simpleTypeWithNonTrivialMemberScope(Annotations.Companion.getEMPTY(), typeConstructor, getDefaultTypeProjections(typeConstructor.getParameters()), false, memberScope);
        if (simpleTypeWithNonTrivialMemberScope == null) {
            $$$reportNull$$$0(12);
        }
        return simpleTypeWithNonTrivialMemberScope;
    }

    @NotNull
    public static List<TypeProjection> getDefaultTypeProjections(@NotNull List<TypeParameterDescriptor> list) {
        if (list == null) {
            $$$reportNull$$$0(13);
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (TypeParameterDescriptor defaultType : list) {
            arrayList.add(new TypeProjectionImpl(defaultType.getDefaultType()));
        }
        List<TypeProjection> list2 = CollectionsKt.toList(arrayList);
        if (list2 == null) {
            $$$reportNull$$$0(14);
        }
        return list2;
    }

    @NotNull
    public static List<KotlinType> getImmediateSupertypes(@NotNull KotlinType kotlinType) {
        if (kotlinType == null) {
            $$$reportNull$$$0(15);
        }
        TypeSubstitutor create = TypeSubstitutor.create(kotlinType);
        Collection<KotlinType> supertypes = kotlinType.getConstructor().getSupertypes();
        ArrayList arrayList = new ArrayList(supertypes.size());
        for (KotlinType createSubstitutedSupertype : supertypes) {
            KotlinType createSubstitutedSupertype2 = createSubstitutedSupertype(kotlinType, createSubstitutedSupertype, create);
            if (createSubstitutedSupertype2 != null) {
                arrayList.add(createSubstitutedSupertype2);
            }
        }
        return arrayList;
    }

    @Nullable
    public static KotlinType createSubstitutedSupertype(@NotNull KotlinType kotlinType, @NotNull KotlinType kotlinType2, @NotNull TypeSubstitutor typeSubstitutor) {
        if (kotlinType == null) {
            $$$reportNull$$$0(17);
        }
        if (kotlinType2 == null) {
            $$$reportNull$$$0(18);
        }
        if (typeSubstitutor == null) {
            $$$reportNull$$$0(19);
        }
        KotlinType substitute = typeSubstitutor.substitute(kotlinType2, Variance.INVARIANT);
        if (substitute != null) {
            return makeNullableIfNeeded(substitute, kotlinType.isMarkedNullable());
        }
        return null;
    }

    public static boolean isNullableType(@NotNull KotlinType kotlinType) {
        if (kotlinType == null) {
            $$$reportNull$$$0(24);
        }
        if (kotlinType.isMarkedNullable()) {
            return true;
        }
        if (FlexibleTypesKt.isFlexible(kotlinType) && isNullableType(FlexibleTypesKt.asFlexibleType(kotlinType).getUpperBound())) {
            return true;
        }
        if (isTypeParameter(kotlinType)) {
            return hasNullableSuperType(kotlinType);
        }
        TypeConstructor constructor = kotlinType.getConstructor();
        if (!(constructor instanceof IntersectionTypeConstructor)) {
            return false;
        }
        for (KotlinType isNullableType : constructor.getSupertypes()) {
            if (isNullableType(isNullableType)) {
                return true;
            }
        }
        return false;
    }

    public static boolean acceptsNullable(@NotNull KotlinType kotlinType) {
        if (kotlinType == null) {
            $$$reportNull$$$0(25);
        }
        if (kotlinType.isMarkedNullable()) {
            return true;
        }
        if (!FlexibleTypesKt.isFlexible(kotlinType) || !acceptsNullable(FlexibleTypesKt.asFlexibleType(kotlinType).getUpperBound())) {
            return false;
        }
        return true;
    }

    public static boolean hasNullableSuperType(@NotNull KotlinType kotlinType) {
        if (kotlinType == null) {
            $$$reportNull$$$0(26);
        }
        if (kotlinType.getConstructor().getDeclarationDescriptor() instanceof ClassDescriptor) {
            return false;
        }
        for (KotlinType isNullableType : getImmediateSupertypes(kotlinType)) {
            if (isNullableType(isNullableType)) {
                return true;
            }
        }
        return false;
    }

    @Nullable
    public static ClassDescriptor getClassDescriptor(@NotNull KotlinType kotlinType) {
        if (kotlinType == null) {
            $$$reportNull$$$0(27);
        }
        ClassifierDescriptor declarationDescriptor = kotlinType.getConstructor().getDeclarationDescriptor();
        if (declarationDescriptor instanceof ClassDescriptor) {
            return (ClassDescriptor) declarationDescriptor;
        }
        return null;
    }

    public static boolean contains(@Nullable KotlinType kotlinType, @NotNull Function1<UnwrappedType, Boolean> function1) {
        if (function1 == null) {
            $$$reportNull$$$0(40);
        }
        return contains(kotlinType, function1, new HashSet());
    }

    private static boolean contains(@Nullable KotlinType kotlinType, @NotNull Function1<UnwrappedType, Boolean> function1, HashSet<KotlinType> hashSet) {
        if (function1 == null) {
            $$$reportNull$$$0(41);
        }
        if (kotlinType == null || hashSet.contains(kotlinType)) {
            return false;
        }
        hashSet.add(kotlinType);
        UnwrappedType unwrap = kotlinType.unwrap();
        if (function1.invoke(unwrap).booleanValue()) {
            return true;
        }
        FlexibleType flexibleType = unwrap instanceof FlexibleType ? (FlexibleType) unwrap : null;
        if (flexibleType != null && (contains(flexibleType.getLowerBound(), function1, hashSet) || contains(flexibleType.getUpperBound(), function1, hashSet))) {
            return true;
        }
        if ((unwrap instanceof DefinitelyNotNullType) && contains(((DefinitelyNotNullType) unwrap).getOriginal(), function1, hashSet)) {
            return true;
        }
        TypeConstructor constructor = kotlinType.getConstructor();
        if (constructor instanceof IntersectionTypeConstructor) {
            for (KotlinType contains : ((IntersectionTypeConstructor) constructor).getSupertypes()) {
                if (contains(contains, function1, hashSet)) {
                    return true;
                }
            }
            return false;
        }
        for (TypeProjection next : kotlinType.getArguments()) {
            if (!next.isStarProjection()) {
                if (contains(next.getType(), function1, hashSet)) {
                    return true;
                }
            }
        }
        return false;
    }

    @NotNull
    public static TypeProjection makeStarProjection(@NotNull TypeParameterDescriptor typeParameterDescriptor) {
        if (typeParameterDescriptor == null) {
            $$$reportNull$$$0(42);
        }
        return new StarProjectionImpl(typeParameterDescriptor);
    }

    public static boolean isTypeParameter(@NotNull KotlinType kotlinType) {
        if (kotlinType == null) {
            $$$reportNull$$$0(56);
        }
        return getTypeParameterDescriptorOrNull(kotlinType) != null || (kotlinType.getConstructor() instanceof NewTypeVariableConstructor);
    }

    @Nullable
    public static TypeParameterDescriptor getTypeParameterDescriptorOrNull(@NotNull KotlinType kotlinType) {
        if (kotlinType == null) {
            $$$reportNull$$$0(59);
        }
        if (kotlinType.getConstructor().getDeclarationDescriptor() instanceof TypeParameterDescriptor) {
            return (TypeParameterDescriptor) kotlinType.getConstructor().getDeclarationDescriptor();
        }
        return null;
    }
}
