package kotlin.reflect.jvm.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.KDeclarationContainerImpl;
import kotlin.reflect.jvm.internal.components.RuntimeModuleData;
import org.jetbrains.annotations.NotNull;

@Metadata(mo39784bv = {1, 0, 3}, mo39785d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo39786d2 = {"<anonymous>", "Lkotlin/reflect/jvm/internal/components/RuntimeModuleData;", "invoke"}, mo39787k = 3, mo39788mv = {1, 1, 15})
/* compiled from: KDeclarationContainerImpl.kt */
final class KDeclarationContainerImpl$Data$moduleData$2 extends Lambda implements Function0<RuntimeModuleData> {
    final /* synthetic */ KDeclarationContainerImpl.Data this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    KDeclarationContainerImpl$Data$moduleData$2(KDeclarationContainerImpl.Data data) {
        super(0);
        this.this$0 = data;
    }

    @NotNull
    public final RuntimeModuleData invoke() {
        return ModuleByClassLoaderKt.getOrCreateModule(KDeclarationContainerImpl.this.getJClass());
    }
}