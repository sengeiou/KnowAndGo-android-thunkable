package kotlin.reflect.jvm.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.KClassImpl;
import kotlin.reflect.jvm.internal.components.RuntimeModuleData;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import org.jetbrains.annotations.NotNull;

@Metadata(mo39784bv = {1, 0, 3}, mo39785d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo39786d2 = {"<anonymous>", "Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;", "T", "", "invoke"}, mo39787k = 3, mo39788mv = {1, 1, 15})
/* compiled from: KClassImpl.kt */
final class KClassImpl$Data$descriptor$2 extends Lambda implements Function0<ClassDescriptor> {
    final /* synthetic */ KClassImpl.Data this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    KClassImpl$Data$descriptor$2(KClassImpl.Data data) {
        super(0);
        this.this$0 = data;
    }

    @NotNull
    public final ClassDescriptor invoke() {
        ClassDescriptor classDescriptor;
        ClassId access$getClassId$p = KClassImpl.this.getClassId();
        RuntimeModuleData moduleData = KClassImpl.this.getData().invoke().getModuleData();
        if (access$getClassId$p.isLocal()) {
            classDescriptor = moduleData.getDeserialization().deserializeClass(access$getClassId$p);
        } else {
            classDescriptor = FindClassInModuleKt.findClassAcrossModuleDependencies(moduleData.getModule(), access$getClassId$p);
        }
        if (classDescriptor != null) {
            return classDescriptor;
        }
        Void unused = KClassImpl.this.reportUnresolvedClass();
        throw null;
    }
}
