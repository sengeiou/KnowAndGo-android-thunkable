package kotlin.reflect.jvm.internal.impl.renderer;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: DescriptorRendererImpl.kt */
final class DescriptorRendererImpl$functionTypeParameterTypesRenderer$2 extends Lambda implements Function0<DescriptorRenderer> {
    final /* synthetic */ DescriptorRendererImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DescriptorRendererImpl$functionTypeParameterTypesRenderer$2(DescriptorRendererImpl descriptorRendererImpl) {
        super(0);
        this.this$0 = descriptorRendererImpl;
    }

    @NotNull
    public final DescriptorRenderer invoke() {
        return this.this$0.withOptions(C37941.INSTANCE);
    }
}
