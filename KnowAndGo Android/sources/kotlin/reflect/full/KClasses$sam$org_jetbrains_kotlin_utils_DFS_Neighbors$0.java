package kotlin.reflect.full;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.utils.DFS;
import org.jetbrains.annotations.NotNull;

@Metadata(mo39784bv = {1, 0, 3}, mo39787k = 3, mo39788mv = {1, 1, 15})
/* compiled from: KClasses.kt */
final class KClasses$sam$org_jetbrains_kotlin_utils_DFS_Neighbors$0 implements DFS.Neighbors {
    private final /* synthetic */ Function1 function;

    KClasses$sam$org_jetbrains_kotlin_utils_DFS_Neighbors$0(Function1 function1) {
        this.function = function1;
    }

    @NotNull
    public final /* synthetic */ Iterable getNeighbors(Object obj) {
        return (Iterable) this.function.invoke(obj);
    }
}
