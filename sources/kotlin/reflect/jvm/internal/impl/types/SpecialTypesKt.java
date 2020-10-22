package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SpecialTypes.kt */
public final class SpecialTypesKt {
    @Nullable
    public static final AbbreviatedType getAbbreviatedType(@NotNull KotlinType kotlinType) {
        Intrinsics.checkParameterIsNotNull(kotlinType, "$this$getAbbreviatedType");
        UnwrappedType unwrap = kotlinType.unwrap();
        if (!(unwrap instanceof AbbreviatedType)) {
            unwrap = null;
        }
        return (AbbreviatedType) unwrap;
    }

    @Nullable
    public static final SimpleType getAbbreviation(@NotNull KotlinType kotlinType) {
        Intrinsics.checkParameterIsNotNull(kotlinType, "$this$getAbbreviation");
        AbbreviatedType abbreviatedType = getAbbreviatedType(kotlinType);
        if (abbreviatedType != null) {
            return abbreviatedType.getAbbreviation();
        }
        return null;
    }

    @NotNull
    public static final SimpleType withAbbreviation(@NotNull SimpleType simpleType, @NotNull SimpleType simpleType2) {
        Intrinsics.checkParameterIsNotNull(simpleType, "$this$withAbbreviation");
        Intrinsics.checkParameterIsNotNull(simpleType2, "abbreviatedType");
        if (KotlinTypeKt.isError(simpleType)) {
            return simpleType;
        }
        return new AbbreviatedType(simpleType, simpleType2);
    }

    public static final boolean isDefinitelyNotNullType(@NotNull KotlinType kotlinType) {
        Intrinsics.checkParameterIsNotNull(kotlinType, "$this$isDefinitelyNotNullType");
        return kotlinType.unwrap() instanceof DefinitelyNotNullType;
    }

    @NotNull
    public static final SimpleType makeSimpleTypeDefinitelyNotNullOrNotNull(@NotNull SimpleType simpleType) {
        SimpleType simpleType2;
        Intrinsics.checkParameterIsNotNull(simpleType, "$this$makeSimpleTypeDefinitelyNotNullOrNotNull");
        DefinitelyNotNullType makeDefinitelyNotNull$descriptors = DefinitelyNotNullType.Companion.makeDefinitelyNotNull$descriptors(simpleType);
        if (makeDefinitelyNotNull$descriptors != null) {
            simpleType2 = makeDefinitelyNotNull$descriptors;
        } else {
            simpleType2 = makeIntersectionTypeDefinitelyNotNullOrNotNull(simpleType);
        }
        return simpleType2 != null ? simpleType2 : simpleType.makeNullableAsSpecified(false);
    }

    @NotNull
    public static final UnwrappedType makeDefinitelyNotNullOrNotNull(@NotNull UnwrappedType unwrappedType) {
        UnwrappedType unwrappedType2;
        Intrinsics.checkParameterIsNotNull(unwrappedType, "$this$makeDefinitelyNotNullOrNotNull");
        DefinitelyNotNullType makeDefinitelyNotNull$descriptors = DefinitelyNotNullType.Companion.makeDefinitelyNotNull$descriptors(unwrappedType);
        if (makeDefinitelyNotNull$descriptors != null) {
            unwrappedType2 = makeDefinitelyNotNull$descriptors;
        } else {
            unwrappedType2 = makeIntersectionTypeDefinitelyNotNullOrNotNull(unwrappedType);
        }
        return unwrappedType2 != null ? unwrappedType2 : unwrappedType.makeNullableAsSpecified(false);
    }

    private static final SimpleType makeIntersectionTypeDefinitelyNotNullOrNotNull(@NotNull KotlinType kotlinType) {
        IntersectionTypeConstructor makeDefinitelyNotNullOrNotNull;
        TypeConstructor constructor = kotlinType.getConstructor();
        if (!(constructor instanceof IntersectionTypeConstructor)) {
            constructor = null;
        }
        IntersectionTypeConstructor intersectionTypeConstructor = (IntersectionTypeConstructor) constructor;
        if (intersectionTypeConstructor == null || (makeDefinitelyNotNullOrNotNull = makeDefinitelyNotNullOrNotNull(intersectionTypeConstructor)) == null) {
            return null;
        }
        return KotlinTypeFactory.simpleTypeWithNonTrivialMemberScope(kotlinType.getAnnotations(), makeDefinitelyNotNullOrNotNull, CollectionsKt.emptyList(), false, makeDefinitelyNotNullOrNotNull.createScopeForKotlinType());
    }

    private static final IntersectionTypeConstructor makeDefinitelyNotNullOrNotNull(@NotNull IntersectionTypeConstructor intersectionTypeConstructor) {
        Iterable<KotlinType> supertypes = intersectionTypeConstructor.getSupertypes();
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(supertypes, 10));
        boolean z = false;
        for (KotlinType kotlinType : supertypes) {
            if (TypeUtils.isNullableType(kotlinType)) {
                z = true;
                kotlinType = makeDefinitelyNotNullOrNotNull(kotlinType.unwrap());
            }
            arrayList.add(kotlinType);
        }
        List list = (List) arrayList;
        if (!z) {
            return null;
        }
        return new IntersectionTypeConstructor(list);
    }
}
