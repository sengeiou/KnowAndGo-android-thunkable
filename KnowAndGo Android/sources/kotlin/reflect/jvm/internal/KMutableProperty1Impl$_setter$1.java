package kotlin.reflect.jvm.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.KMutableProperty1Impl;
import org.jetbrains.annotations.NotNull;

@Metadata(mo39784bv = {1, 0, 3}, mo39785d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003H\n¢\u0006\u0002\b\u0004"}, mo39786d2 = {"<anonymous>", "Lkotlin/reflect/jvm/internal/KMutableProperty1Impl$Setter;", "T", "R", "invoke"}, mo39787k = 3, mo39788mv = {1, 1, 15})
/* compiled from: KProperty1Impl.kt */
final class KMutableProperty1Impl$_setter$1 extends Lambda implements Function0<KMutableProperty1Impl.Setter<T, R>> {
    final /* synthetic */ KMutableProperty1Impl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    KMutableProperty1Impl$_setter$1(KMutableProperty1Impl kMutableProperty1Impl) {
        super(0);
        this.this$0 = kMutableProperty1Impl;
    }

    @NotNull
    public final KMutableProperty1Impl.Setter<T, R> invoke() {
        return new KMutableProperty1Impl.Setter<>(this.this$0);
    }
}
