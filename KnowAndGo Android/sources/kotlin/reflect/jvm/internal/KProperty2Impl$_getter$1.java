package kotlin.reflect.jvm.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.KProperty2Impl;
import org.jetbrains.annotations.NotNull;

@Metadata(mo39784bv = {1, 0, 3}, mo39785d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0000\u001a\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u00040\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0006\b\u0002\u0010\u0004 \u0001H\n¢\u0006\u0002\b\u0005"}, mo39786d2 = {"<anonymous>", "Lkotlin/reflect/jvm/internal/KProperty2Impl$Getter;", "D", "E", "R", "invoke"}, mo39787k = 3, mo39788mv = {1, 1, 15})
/* compiled from: KProperty2Impl.kt */
final class KProperty2Impl$_getter$1 extends Lambda implements Function0<KProperty2Impl.Getter<D, E, ? extends R>> {
    final /* synthetic */ KProperty2Impl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    KProperty2Impl$_getter$1(KProperty2Impl kProperty2Impl) {
        super(0);
        this.this$0 = kProperty2Impl;
    }

    @NotNull
    public final KProperty2Impl.Getter<D, E, R> invoke() {
        return new KProperty2Impl.Getter<>(this.this$0);
    }
}
