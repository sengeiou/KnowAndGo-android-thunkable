package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;

/* renamed from: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement$enhanceSignature$valueParameterEnhancements$1$enhancementResult$1 */
/* compiled from: signatureEnhancement.kt */
final class C3720xdf7d8d68 extends Lambda implements Function1<CallableMemberDescriptor, KotlinType> {

    /* renamed from: $p */
    final /* synthetic */ ValueParameterDescriptor f2992$p;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C3720xdf7d8d68(ValueParameterDescriptor valueParameterDescriptor) {
        super(1);
        this.f2992$p = valueParameterDescriptor;
    }

    @NotNull
    public final KotlinType invoke(@NotNull CallableMemberDescriptor callableMemberDescriptor) {
        Intrinsics.checkParameterIsNotNull(callableMemberDescriptor, "it");
        ValueParameterDescriptor valueParameterDescriptor = callableMemberDescriptor.getValueParameters().get(this.f2992$p.getIndex());
        Intrinsics.checkExpressionValueIsNotNull(valueParameterDescriptor, "it.valueParameters[p.index]");
        KotlinType type = valueParameterDescriptor.getType();
        Intrinsics.checkExpressionValueIsNotNull(type, "it.valueParameters[p.index].type");
        return type;
    }
}
