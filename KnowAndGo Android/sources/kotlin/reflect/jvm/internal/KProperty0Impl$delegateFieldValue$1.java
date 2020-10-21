package kotlin.reflect.jvm.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(mo39784bv = {1, 0, 3}, mo39785d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0006\b\u0000\u0010\u0002 \u0001H\n¢\u0006\u0002\b\u0003"}, mo39786d2 = {"<anonymous>", "", "R", "invoke"}, mo39787k = 3, mo39788mv = {1, 1, 15})
/* compiled from: KProperty0Impl.kt */
final class KProperty0Impl$delegateFieldValue$1 extends Lambda implements Function0<Object> {
    final /* synthetic */ KProperty0Impl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    KProperty0Impl$delegateFieldValue$1(KProperty0Impl kProperty0Impl) {
        super(0);
        this.this$0 = kProperty0Impl;
    }

    @Nullable
    public final Object invoke() {
        return this.this$0.getDelegate(this.this$0.computeDelegateField(), this.this$0.getBoundReceiver());
    }
}
