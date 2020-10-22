package kotlin.reflect.jvm.internal.impl.types.checker;

import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeKt;
import kotlin.reflect.jvm.internal.impl.types.TypeCapabilitiesKt;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class TypeCheckingProcedure {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final TypeCheckingProcedureCallbacks constraints;

    private static /* synthetic */ void $$$reportNull$$$0(int i) {
        String str = (i == 7 || i == 10) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[((i == 7 || i == 10) ? 2 : 3)];
        switch (i) {
            case 1:
            case 3:
            case 16:
            case 18:
                objArr[0] = "supertype";
                break;
            case 4:
                objArr[0] = "typeCheckingProcedureCallbacks";
                break;
            case 5:
            case 8:
            case 21:
                objArr[0] = MediationRewardedVideoAdAdapter.CUSTOM_EVENT_SERVER_PARAMETER_FIELD;
                break;
            case 6:
            case 9:
                objArr[0] = "argument";
                break;
            case 7:
            case 10:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/types/checker/TypeCheckingProcedure";
                break;
            case 11:
                objArr[0] = "type1";
                break;
            case 12:
                objArr[0] = "type2";
                break;
            case 13:
                objArr[0] = "typeParameter";
                break;
            case 14:
                objArr[0] = "typeArgument";
                break;
            case 19:
                objArr[0] = "subtypeArgumentProjection";
                break;
            case 20:
                objArr[0] = "supertypeArgumentProjection";
                break;
            default:
                objArr[0] = "subtype";
                break;
        }
        if (i == 7) {
            objArr[1] = "getOutType";
        } else if (i != 10) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/types/checker/TypeCheckingProcedure";
        } else {
            objArr[1] = "getInType";
        }
        switch (i) {
            case 5:
            case 6:
                objArr[2] = "getOutType";
                break;
            case 7:
            case 10:
                break;
            case 8:
            case 9:
                objArr[2] = "getInType";
                break;
            case 11:
            case 12:
                objArr[2] = "equalTypes";
                break;
            case 13:
            case 14:
                objArr[2] = "getEffectiveProjectionKind";
                break;
            case 15:
            case 16:
                objArr[2] = "isSubtypeOf";
                break;
            case 17:
            case 18:
                objArr[2] = "checkSubtypeForTheSameConstructor";
                break;
            case 19:
            case 20:
            case 21:
                objArr[2] = "capture";
                break;
            default:
                objArr[2] = "findCorrespondingSupertype";
                break;
        }
        String format = String.format(str, objArr);
        throw ((i == 7 || i == 10) ? new IllegalStateException(format) : new IllegalArgumentException(format));
    }

    @Nullable
    public static KotlinType findCorrespondingSupertype(@NotNull KotlinType kotlinType, @NotNull KotlinType kotlinType2) {
        if (kotlinType == null) {
            $$$reportNull$$$0(0);
        }
        if (kotlinType2 == null) {
            $$$reportNull$$$0(1);
        }
        return findCorrespondingSupertype(kotlinType, kotlinType2, new TypeCheckerProcedureCallbacksImpl());
    }

    @Nullable
    public static KotlinType findCorrespondingSupertype(@NotNull KotlinType kotlinType, @NotNull KotlinType kotlinType2, @NotNull TypeCheckingProcedureCallbacks typeCheckingProcedureCallbacks) {
        if (kotlinType == null) {
            $$$reportNull$$$0(2);
        }
        if (kotlinType2 == null) {
            $$$reportNull$$$0(3);
        }
        if (typeCheckingProcedureCallbacks == null) {
            $$$reportNull$$$0(4);
        }
        return UtilsKt.findCorrespondingSupertype(kotlinType, kotlinType2, typeCheckingProcedureCallbacks);
    }

    @NotNull
    private static KotlinType getOutType(@NotNull TypeParameterDescriptor typeParameterDescriptor, @NotNull TypeProjection typeProjection) {
        if (typeParameterDescriptor == null) {
            $$$reportNull$$$0(5);
        }
        if (typeProjection == null) {
            $$$reportNull$$$0(6);
        }
        KotlinType nullableAnyType = typeProjection.getProjectionKind() == Variance.IN_VARIANCE || typeParameterDescriptor.getVariance() == Variance.IN_VARIANCE ? DescriptorUtilsKt.getBuiltIns(typeParameterDescriptor).getNullableAnyType() : typeProjection.getType();
        if (nullableAnyType == null) {
            $$$reportNull$$$0(7);
        }
        return nullableAnyType;
    }

    @NotNull
    private static KotlinType getInType(@NotNull TypeParameterDescriptor typeParameterDescriptor, @NotNull TypeProjection typeProjection) {
        if (typeParameterDescriptor == null) {
            $$$reportNull$$$0(8);
        }
        if (typeProjection == null) {
            $$$reportNull$$$0(9);
        }
        KotlinType nothingType = typeProjection.getProjectionKind() == Variance.OUT_VARIANCE || typeParameterDescriptor.getVariance() == Variance.OUT_VARIANCE ? DescriptorUtilsKt.getBuiltIns(typeParameterDescriptor).getNothingType() : typeProjection.getType();
        if (nothingType == null) {
            $$$reportNull$$$0(10);
        }
        return nothingType;
    }

    public TypeCheckingProcedure(TypeCheckingProcedureCallbacks typeCheckingProcedureCallbacks) {
        this.constraints = typeCheckingProcedureCallbacks;
    }

    public boolean equalTypes(@NotNull KotlinType kotlinType, @NotNull KotlinType kotlinType2) {
        if (kotlinType == null) {
            $$$reportNull$$$0(11);
        }
        if (kotlinType2 == null) {
            $$$reportNull$$$0(12);
        }
        if (kotlinType == kotlinType2) {
            return true;
        }
        if (FlexibleTypesKt.isFlexible(kotlinType)) {
            if (!FlexibleTypesKt.isFlexible(kotlinType2)) {
                return heterogeneousEquivalence(kotlinType2, kotlinType);
            }
            if (KotlinTypeKt.isError(kotlinType) || KotlinTypeKt.isError(kotlinType2) || !isSubtypeOf(kotlinType, kotlinType2) || !isSubtypeOf(kotlinType2, kotlinType)) {
                return false;
            }
            return true;
        } else if (FlexibleTypesKt.isFlexible(kotlinType2)) {
            return heterogeneousEquivalence(kotlinType, kotlinType2);
        } else {
            if (kotlinType.isMarkedNullable() != kotlinType2.isMarkedNullable()) {
                return false;
            }
            if (kotlinType.isMarkedNullable()) {
                return this.constraints.assertEqualTypes(TypeUtils.makeNotNullable(kotlinType), TypeUtils.makeNotNullable(kotlinType2), this);
            }
            TypeConstructor constructor = kotlinType.getConstructor();
            TypeConstructor constructor2 = kotlinType2.getConstructor();
            if (!this.constraints.assertEqualTypeConstructors(constructor, constructor2)) {
                return false;
            }
            List<TypeProjection> arguments = kotlinType.getArguments();
            List<TypeProjection> arguments2 = kotlinType2.getArguments();
            if (arguments.size() != arguments2.size()) {
                return false;
            }
            for (int i = 0; i < arguments.size(); i++) {
                TypeProjection typeProjection = arguments.get(i);
                TypeProjection typeProjection2 = arguments2.get(i);
                if (!typeProjection.isStarProjection() || !typeProjection2.isStarProjection()) {
                    TypeParameterDescriptor typeParameterDescriptor = constructor.getParameters().get(i);
                    TypeParameterDescriptor typeParameterDescriptor2 = constructor2.getParameters().get(i);
                    if (!capture(typeProjection, typeProjection2, typeParameterDescriptor) && (getEffectiveProjectionKind(typeParameterDescriptor, typeProjection) != getEffectiveProjectionKind(typeParameterDescriptor2, typeProjection2) || !this.constraints.assertEqualTypes(typeProjection.getType(), typeProjection2.getType(), this))) {
                        return false;
                    }
                }
            }
            return true;
        }
    }

    /* access modifiers changed from: protected */
    public boolean heterogeneousEquivalence(KotlinType kotlinType, KotlinType kotlinType2) {
        return isSubtypeOf(FlexibleTypesKt.asFlexibleType(kotlinType2).getLowerBound(), kotlinType) && isSubtypeOf(kotlinType, FlexibleTypesKt.asFlexibleType(kotlinType2).getUpperBound());
    }

    public enum EnrichedProjectionKind {
        IN,
        OUT,
        INV,
        STAR;

        @NotNull
        public static EnrichedProjectionKind fromVariance(@NotNull Variance variance) {
            if (variance == null) {
                $$$reportNull$$$0(0);
            }
            switch (variance) {
                case INVARIANT:
                    EnrichedProjectionKind enrichedProjectionKind = INV;
                    if (enrichedProjectionKind == null) {
                        $$$reportNull$$$0(1);
                    }
                    return enrichedProjectionKind;
                case IN_VARIANCE:
                    EnrichedProjectionKind enrichedProjectionKind2 = IN;
                    if (enrichedProjectionKind2 == null) {
                        $$$reportNull$$$0(2);
                    }
                    return enrichedProjectionKind2;
                case OUT_VARIANCE:
                    EnrichedProjectionKind enrichedProjectionKind3 = OUT;
                    if (enrichedProjectionKind3 == null) {
                        $$$reportNull$$$0(3);
                    }
                    return enrichedProjectionKind3;
                default:
                    throw new IllegalStateException("Unknown variance");
            }
        }
    }

    public static EnrichedProjectionKind getEffectiveProjectionKind(@NotNull TypeParameterDescriptor typeParameterDescriptor, @NotNull TypeProjection typeProjection) {
        if (typeParameterDescriptor == null) {
            $$$reportNull$$$0(13);
        }
        if (typeProjection == null) {
            $$$reportNull$$$0(14);
        }
        Variance variance = typeParameterDescriptor.getVariance();
        Variance projectionKind = typeProjection.getProjectionKind();
        if (projectionKind == Variance.INVARIANT) {
            Variance variance2 = projectionKind;
            projectionKind = variance;
            variance = variance2;
        }
        if (variance == Variance.IN_VARIANCE && projectionKind == Variance.OUT_VARIANCE) {
            return EnrichedProjectionKind.STAR;
        }
        if (variance == Variance.OUT_VARIANCE && projectionKind == Variance.IN_VARIANCE) {
            return EnrichedProjectionKind.STAR;
        }
        return EnrichedProjectionKind.fromVariance(projectionKind);
    }

    public boolean isSubtypeOf(@NotNull KotlinType kotlinType, @NotNull KotlinType kotlinType2) {
        if (kotlinType == null) {
            $$$reportNull$$$0(15);
        }
        if (kotlinType2 == null) {
            $$$reportNull$$$0(16);
        }
        if (TypeCapabilitiesKt.sameTypeConstructors(kotlinType, kotlinType2)) {
            return !kotlinType.isMarkedNullable() || kotlinType2.isMarkedNullable();
        }
        KotlinType subtypeRepresentative = TypeCapabilitiesKt.getSubtypeRepresentative(kotlinType);
        KotlinType supertypeRepresentative = TypeCapabilitiesKt.getSupertypeRepresentative(kotlinType2);
        if (subtypeRepresentative == kotlinType && supertypeRepresentative == kotlinType2) {
            return isSubtypeOfForRepresentatives(kotlinType, kotlinType2);
        }
        return isSubtypeOf(subtypeRepresentative, supertypeRepresentative);
    }

    private boolean isSubtypeOfForRepresentatives(KotlinType kotlinType, KotlinType kotlinType2) {
        if (KotlinTypeKt.isError(kotlinType) || KotlinTypeKt.isError(kotlinType2)) {
            return true;
        }
        if (!kotlinType2.isMarkedNullable() && kotlinType.isMarkedNullable()) {
            return false;
        }
        if (KotlinBuiltIns.isNothingOrNullableNothing(kotlinType)) {
            return true;
        }
        KotlinType findCorrespondingSupertype = findCorrespondingSupertype(kotlinType, kotlinType2, this.constraints);
        if (findCorrespondingSupertype == null) {
            return this.constraints.noCorrespondingSupertype(kotlinType, kotlinType2);
        }
        if (kotlinType2.isMarkedNullable() || !findCorrespondingSupertype.isMarkedNullable()) {
            return checkSubtypeForTheSameConstructor(findCorrespondingSupertype, kotlinType2);
        }
        return false;
    }

    private boolean checkSubtypeForTheSameConstructor(@NotNull KotlinType kotlinType, @NotNull KotlinType kotlinType2) {
        if (kotlinType == null) {
            $$$reportNull$$$0(17);
        }
        if (kotlinType2 == null) {
            $$$reportNull$$$0(18);
        }
        TypeConstructor constructor = kotlinType.getConstructor();
        List<TypeProjection> arguments = kotlinType.getArguments();
        List<TypeProjection> arguments2 = kotlinType2.getArguments();
        if (arguments.size() != arguments2.size()) {
            return false;
        }
        List<TypeParameterDescriptor> parameters = constructor.getParameters();
        int i = 0;
        while (true) {
            boolean z = true;
            if (i >= parameters.size()) {
                return true;
            }
            TypeParameterDescriptor typeParameterDescriptor = parameters.get(i);
            TypeProjection typeProjection = arguments2.get(i);
            TypeProjection typeProjection2 = arguments.get(i);
            if (!typeProjection.isStarProjection() && !capture(typeProjection2, typeProjection, typeParameterDescriptor)) {
                if (!KotlinTypeKt.isError(typeProjection2.getType()) && !KotlinTypeKt.isError(typeProjection.getType())) {
                    z = false;
                }
                if (z || typeParameterDescriptor.getVariance() != Variance.INVARIANT || typeProjection2.getProjectionKind() != Variance.INVARIANT || typeProjection.getProjectionKind() != Variance.INVARIANT) {
                    KotlinType outType = getOutType(typeParameterDescriptor, typeProjection);
                    if (!this.constraints.assertSubtype(getOutType(typeParameterDescriptor, typeProjection2), outType, this)) {
                        return false;
                    }
                    KotlinType inType = getInType(typeParameterDescriptor, typeProjection);
                    KotlinType inType2 = getInType(typeParameterDescriptor, typeProjection2);
                    if (typeProjection.getProjectionKind() != Variance.OUT_VARIANCE && !this.constraints.assertSubtype(inType, inType2, this)) {
                        return false;
                    }
                } else if (!this.constraints.assertEqualTypes(typeProjection2.getType(), typeProjection.getType(), this)) {
                    return false;
                }
            }
            i++;
        }
    }

    private boolean capture(@NotNull TypeProjection typeProjection, @NotNull TypeProjection typeProjection2, @NotNull TypeParameterDescriptor typeParameterDescriptor) {
        if (typeProjection == null) {
            $$$reportNull$$$0(19);
        }
        if (typeProjection2 == null) {
            $$$reportNull$$$0(20);
        }
        if (typeParameterDescriptor == null) {
            $$$reportNull$$$0(21);
        }
        if (typeParameterDescriptor.getVariance() == Variance.INVARIANT && typeProjection.getProjectionKind() != Variance.INVARIANT && typeProjection2.getProjectionKind() == Variance.INVARIANT) {
            return this.constraints.capture(typeProjection2.getType(), typeProjection);
        }
        return false;
    }
}
