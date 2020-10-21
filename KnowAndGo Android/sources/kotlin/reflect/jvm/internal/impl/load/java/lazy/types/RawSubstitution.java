package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeKt;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitution;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.jetbrains.annotations.NotNull;

/* compiled from: RawType.kt */
public final class RawSubstitution extends TypeSubstitution {
    public static final RawSubstitution INSTANCE = new RawSubstitution();
    private static final JavaTypeAttributes lowerTypeAttr = JavaTypeResolverKt.toAttributes$default(TypeUsage.COMMON, false, (TypeParameterDescriptor) null, 3, (Object) null).withFlexibility(JavaTypeFlexibility.FLEXIBLE_LOWER_BOUND);
    private static final JavaTypeAttributes upperTypeAttr = JavaTypeResolverKt.toAttributes$default(TypeUsage.COMMON, false, (TypeParameterDescriptor) null, 3, (Object) null).withFlexibility(JavaTypeFlexibility.FLEXIBLE_UPPER_BOUND);

    public boolean isEmpty() {
        return false;
    }

    private RawSubstitution() {
    }

    @NotNull
    public TypeProjectionImpl get(@NotNull KotlinType kotlinType) {
        Intrinsics.checkParameterIsNotNull(kotlinType, "key");
        return new TypeProjectionImpl(eraseType(kotlinType));
    }

    private final KotlinType eraseType(KotlinType kotlinType) {
        UnwrappedType unwrappedType;
        ClassifierDescriptor declarationDescriptor = kotlinType.getConstructor().getDeclarationDescriptor();
        if (declarationDescriptor instanceof TypeParameterDescriptor) {
            return eraseType(JavaTypeResolverKt.getErasedUpperBound$default((TypeParameterDescriptor) declarationDescriptor, (TypeParameterDescriptor) null, (Function0) null, 3, (Object) null));
        }
        if (declarationDescriptor instanceof ClassDescriptor) {
            ClassDescriptor classDescriptor = (ClassDescriptor) declarationDescriptor;
            Pair<SimpleType, Boolean> eraseInflexibleBasedOnClassDescriptor = eraseInflexibleBasedOnClassDescriptor(FlexibleTypesKt.lowerIfFlexible(kotlinType), classDescriptor, lowerTypeAttr);
            SimpleType component1 = eraseInflexibleBasedOnClassDescriptor.component1();
            boolean booleanValue = eraseInflexibleBasedOnClassDescriptor.component2().booleanValue();
            Pair<SimpleType, Boolean> eraseInflexibleBasedOnClassDescriptor2 = eraseInflexibleBasedOnClassDescriptor(FlexibleTypesKt.upperIfFlexible(kotlinType), classDescriptor, upperTypeAttr);
            SimpleType component12 = eraseInflexibleBasedOnClassDescriptor2.component1();
            boolean booleanValue2 = eraseInflexibleBasedOnClassDescriptor2.component2().booleanValue();
            if (booleanValue || booleanValue2) {
                unwrappedType = new RawTypeImpl(component1, component12);
            } else {
                unwrappedType = KotlinTypeFactory.flexibleType(component1, component12);
            }
            return unwrappedType;
        }
        throw new IllegalStateException(("Unexpected declaration kind: " + declarationDescriptor).toString());
    }

    private final Pair<SimpleType, Boolean> eraseInflexibleBasedOnClassDescriptor(SimpleType simpleType, ClassDescriptor classDescriptor, JavaTypeAttributes javaTypeAttributes) {
        if (simpleType.getConstructor().getParameters().isEmpty()) {
            return TuplesKt.m2473to(simpleType, false);
        }
        KotlinType kotlinType = simpleType;
        if (KotlinBuiltIns.isArray(kotlinType)) {
            TypeProjection typeProjection = simpleType.getArguments().get(0);
            Variance projectionKind = typeProjection.getProjectionKind();
            KotlinType type = typeProjection.getType();
            Intrinsics.checkExpressionValueIsNotNull(type, "componentTypeProjection.type");
            return TuplesKt.m2473to(KotlinTypeFactory.simpleType(simpleType.getAnnotations(), simpleType.getConstructor(), CollectionsKt.listOf(new TypeProjectionImpl(projectionKind, eraseType(type))), simpleType.isMarkedNullable()), false);
        } else if (KotlinTypeKt.isError(kotlinType)) {
            return TuplesKt.m2473to(ErrorUtils.createErrorType("Raw error type: " + simpleType.getConstructor()), false);
        } else {
            Annotations annotations = simpleType.getAnnotations();
            TypeConstructor constructor = simpleType.getConstructor();
            List<TypeParameterDescriptor> parameters = simpleType.getConstructor().getParameters();
            Intrinsics.checkExpressionValueIsNotNull(parameters, "type.constructor.parameters");
            Iterable<TypeParameterDescriptor> iterable = parameters;
            Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
            for (TypeParameterDescriptor typeParameterDescriptor : iterable) {
                RawSubstitution rawSubstitution = INSTANCE;
                Intrinsics.checkExpressionValueIsNotNull(typeParameterDescriptor, MediationRewardedVideoAdAdapter.CUSTOM_EVENT_SERVER_PARAMETER_FIELD);
                arrayList.add(computeProjection$default(rawSubstitution, typeParameterDescriptor, javaTypeAttributes, (KotlinType) null, 4, (Object) null));
            }
            boolean isMarkedNullable = simpleType.isMarkedNullable();
            MemberScope memberScope = classDescriptor.getMemberScope(INSTANCE);
            Intrinsics.checkExpressionValueIsNotNull(memberScope, "declaration.getMemberScope(RawSubstitution)");
            return TuplesKt.m2473to(KotlinTypeFactory.simpleTypeWithNonTrivialMemberScope(annotations, constructor, (List) arrayList, isMarkedNullable, memberScope), true);
        }
    }

    public static /* synthetic */ TypeProjection computeProjection$default(RawSubstitution rawSubstitution, TypeParameterDescriptor typeParameterDescriptor, JavaTypeAttributes javaTypeAttributes, KotlinType kotlinType, int i, Object obj) {
        if ((i & 4) != 0) {
            kotlinType = JavaTypeResolverKt.getErasedUpperBound$default(typeParameterDescriptor, (TypeParameterDescriptor) null, (Function0) null, 3, (Object) null);
        }
        return rawSubstitution.computeProjection(typeParameterDescriptor, javaTypeAttributes, kotlinType);
    }

    @NotNull
    public final TypeProjection computeProjection(@NotNull TypeParameterDescriptor typeParameterDescriptor, @NotNull JavaTypeAttributes javaTypeAttributes, @NotNull KotlinType kotlinType) {
        TypeProjection makeStarProjection;
        Intrinsics.checkParameterIsNotNull(typeParameterDescriptor, MediationRewardedVideoAdAdapter.CUSTOM_EVENT_SERVER_PARAMETER_FIELD);
        Intrinsics.checkParameterIsNotNull(javaTypeAttributes, "attr");
        Intrinsics.checkParameterIsNotNull(kotlinType, "erasedUpperBound");
        switch (javaTypeAttributes.getFlexibility()) {
            case FLEXIBLE_LOWER_BOUND:
                return new TypeProjectionImpl(Variance.INVARIANT, kotlinType);
            case FLEXIBLE_UPPER_BOUND:
            case INFLEXIBLE:
                if (!typeParameterDescriptor.getVariance().getAllowsOutPosition()) {
                    return new TypeProjectionImpl(Variance.INVARIANT, DescriptorUtilsKt.getBuiltIns(typeParameterDescriptor).getNothingType());
                }
                List<TypeParameterDescriptor> parameters = kotlinType.getConstructor().getParameters();
                Intrinsics.checkExpressionValueIsNotNull(parameters, "erasedUpperBound.constructor.parameters");
                if (!parameters.isEmpty()) {
                    makeStarProjection = new TypeProjectionImpl(Variance.OUT_VARIANCE, kotlinType);
                } else {
                    makeStarProjection = JavaTypeResolverKt.makeStarProjection(typeParameterDescriptor, javaTypeAttributes);
                }
                return makeStarProjection;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
