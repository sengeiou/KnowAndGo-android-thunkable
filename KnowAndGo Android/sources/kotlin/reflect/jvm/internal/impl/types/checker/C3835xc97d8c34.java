package kotlin.reflect.jvm.internal.impl.types.checker;

import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;

/* renamed from: kotlin.reflect.jvm.internal.impl.types.checker.TypeIntersector$intersectTypesWithoutIntersectionType$filteredSuperAndEqualTypes$1 */
/* compiled from: IntersectionType.kt */
final /* synthetic */ class C3835xc97d8c34 extends FunctionReference implements Function2<KotlinType, KotlinType, Boolean> {
    C3835xc97d8c34(NewKotlinTypeChecker newKotlinTypeChecker) {
        super(2, newKotlinTypeChecker);
    }

    public final String getName() {
        return "equalTypes";
    }

    public final KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(NewKotlinTypeChecker.class);
    }

    public final String getSignature() {
        return "equalTypes(Lorg/jetbrains/kotlin/types/KotlinType;Lorg/jetbrains/kotlin/types/KotlinType;)Z";
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return Boolean.valueOf(invoke((KotlinType) obj, (KotlinType) obj2));
    }

    public final boolean invoke(@NotNull KotlinType kotlinType, @NotNull KotlinType kotlinType2) {
        Intrinsics.checkParameterIsNotNull(kotlinType, "p1");
        Intrinsics.checkParameterIsNotNull(kotlinType2, "p2");
        return ((NewKotlinTypeChecker) this.receiver).equalTypes(kotlinType, kotlinType2);
    }
}
