package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.NotNull;

/* compiled from: LazyJavaClassMemberScope.kt */
final class LazyJavaClassMemberScope$nestedClasses$1$enumMemberNames$1 extends Lambda implements Function0<Set<? extends Name>> {
    final /* synthetic */ LazyJavaClassMemberScope$nestedClasses$1 this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazyJavaClassMemberScope$nestedClasses$1$enumMemberNames$1(LazyJavaClassMemberScope$nestedClasses$1 lazyJavaClassMemberScope$nestedClasses$1) {
        super(0);
        this.this$0 = lazyJavaClassMemberScope$nestedClasses$1;
    }

    @NotNull
    public final Set<Name> invoke() {
        return SetsKt.plus(this.this$0.this$0.getFunctionNames(), this.this$0.this$0.getVariableNames());
    }
}
