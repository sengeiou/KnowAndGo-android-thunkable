package kotlin.reflect.jvm.internal.impl.types.checker;

import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.AbstractTypeCheckerContext;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;
import org.jetbrains.annotations.NotNull;

/* renamed from: kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeCheckerContext$Companion$classicSubstitutionSupertypePolicy$2 */
/* compiled from: ClassicTypeCheckerContext.kt */
public final class C3830x9ae7c99c extends AbstractTypeCheckerContext.SupertypesPolicy.DoCustomTransform {
    final /* synthetic */ TypeSubstitutor $substitutor;
    final /* synthetic */ ClassicTypeSystemContext $this_classicSubstitutionSupertypePolicy;

    C3830x9ae7c99c(ClassicTypeSystemContext classicTypeSystemContext, TypeSubstitutor typeSubstitutor) {
        this.$this_classicSubstitutionSupertypePolicy = classicTypeSystemContext;
        this.$substitutor = typeSubstitutor;
    }

    @NotNull
    public SimpleTypeMarker transformType(@NotNull AbstractTypeCheckerContext abstractTypeCheckerContext, @NotNull KotlinTypeMarker kotlinTypeMarker) {
        Intrinsics.checkParameterIsNotNull(abstractTypeCheckerContext, "context");
        Intrinsics.checkParameterIsNotNull(kotlinTypeMarker, "type");
        ClassicTypeSystemContext classicTypeSystemContext = this.$this_classicSubstitutionSupertypePolicy;
        TypeSubstitutor typeSubstitutor = this.$substitutor;
        SimpleTypeMarker lowerBoundIfFlexible = this.$this_classicSubstitutionSupertypePolicy.lowerBoundIfFlexible(kotlinTypeMarker);
        if (lowerBoundIfFlexible != null) {
            KotlinType safeSubstitute = typeSubstitutor.safeSubstitute((KotlinType) lowerBoundIfFlexible, Variance.INVARIANT);
            Intrinsics.checkExpressionValueIsNotNull(safeSubstitute, "substitutor.safeSubstitu…ANT\n                    )");
            SimpleTypeMarker asSimpleType = classicTypeSystemContext.asSimpleType(safeSubstitute);
            if (asSimpleType == null) {
                Intrinsics.throwNpe();
            }
            return asSimpleType;
        }
        throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.types.KotlinType");
    }
}
