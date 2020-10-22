package kotlin.reflect.jvm.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import org.jetbrains.annotations.NotNull;

@Metadata(mo39784bv = {1, 0, 3}, mo39785d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo39786d2 = {"<anonymous>", "", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "invoke"}, mo39787k = 3, mo39788mv = {1, 1, 15})
/* compiled from: KDeclarationContainerImpl.kt */
final class KDeclarationContainerImpl$findFunctionDescriptor$allMembers$1 extends Lambda implements Function1<FunctionDescriptor, String> {
    public static final KDeclarationContainerImpl$findFunctionDescriptor$allMembers$1 INSTANCE = new KDeclarationContainerImpl$findFunctionDescriptor$allMembers$1();

    KDeclarationContainerImpl$findFunctionDescriptor$allMembers$1() {
        super(1);
    }

    @NotNull
    public final String invoke(@NotNull FunctionDescriptor functionDescriptor) {
        Intrinsics.checkParameterIsNotNull(functionDescriptor, "descriptor");
        return DescriptorRenderer.DEBUG_TEXT.render(functionDescriptor) + " | " + RuntimeTypeMapper.INSTANCE.mapSignature(functionDescriptor);
    }
}
