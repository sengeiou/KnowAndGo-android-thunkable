package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* renamed from: kotlin.reflect.jvm.internal.impl.types.checker.TypeIntersector$intersectTypesWithoutIntersectionType$errorMessage$1 */
/* compiled from: IntersectionType.kt */
final class C3833x7a6103fb extends Lambda implements Function0<String> {
    final /* synthetic */ Set $inputTypes;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C3833x7a6103fb(Set set) {
        super(0);
        this.$inputTypes = set;
    }

    @NotNull
    public final String invoke() {
        return "This collections cannot be empty! input types: " + CollectionsKt.joinToString$default(this.$inputTypes, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 63, (Object) null);
    }
}
