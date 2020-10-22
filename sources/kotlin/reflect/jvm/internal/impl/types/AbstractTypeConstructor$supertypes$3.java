package kotlin.reflect.jvm.internal.impl.types;

import java.util.Collection;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor;
import org.jetbrains.annotations.NotNull;

/* compiled from: AbstractTypeConstructor.kt */
final class AbstractTypeConstructor$supertypes$3 extends Lambda implements Function1<AbstractTypeConstructor.Supertypes, Unit> {
    final /* synthetic */ AbstractTypeConstructor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AbstractTypeConstructor$supertypes$3(AbstractTypeConstructor abstractTypeConstructor) {
        super(1);
        this.this$0 = abstractTypeConstructor;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((AbstractTypeConstructor.Supertypes) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull AbstractTypeConstructor.Supertypes supertypes) {
        Intrinsics.checkParameterIsNotNull(supertypes, "supertypes");
        Collection<KotlinType> findLoopsInSupertypesAndDisconnect = this.this$0.getSupertypeLoopChecker().findLoopsInSupertypesAndDisconnect(this.this$0, supertypes.getAllSupertypes(), new AbstractTypeConstructor$supertypes$3$resultWithoutCycles$1(this), new AbstractTypeConstructor$supertypes$3$resultWithoutCycles$2(this));
        List list = null;
        if (findLoopsInSupertypesAndDisconnect.isEmpty()) {
            KotlinType defaultSupertypeIfEmpty = this.this$0.defaultSupertypeIfEmpty();
            List listOf = defaultSupertypeIfEmpty != null ? CollectionsKt.listOf(defaultSupertypeIfEmpty) : null;
            if (listOf == null) {
                listOf = CollectionsKt.emptyList();
            }
            findLoopsInSupertypesAndDisconnect = listOf;
        }
        this.this$0.getSupertypeLoopChecker().findLoopsInSupertypesAndDisconnect(this.this$0, findLoopsInSupertypesAndDisconnect, new Function1<TypeConstructor, Collection<? extends KotlinType>>(this) {
            final /* synthetic */ AbstractTypeConstructor$supertypes$3 this$0;

            {
                this.this$0 = r1;
            }

            @NotNull
            public final Collection<KotlinType> invoke(@NotNull TypeConstructor typeConstructor) {
                Intrinsics.checkParameterIsNotNull(typeConstructor, "it");
                return this.this$0.this$0.computeNeighbours(typeConstructor, true);
            }
        }, new Function1<KotlinType, Unit>(this) {
            final /* synthetic */ AbstractTypeConstructor$supertypes$3 this$0;

            {
                this.this$0 = r1;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((KotlinType) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull KotlinType kotlinType) {
                Intrinsics.checkParameterIsNotNull(kotlinType, "it");
                this.this$0.this$0.reportScopesLoopError(kotlinType);
            }
        });
        if (findLoopsInSupertypesAndDisconnect instanceof List) {
            list = findLoopsInSupertypesAndDisconnect;
        }
        List list2 = list;
        if (list2 == null) {
            list2 = CollectionsKt.toList(findLoopsInSupertypesAndDisconnect);
        }
        supertypes.setSupertypesWithoutCycles(list2);
    }
}
