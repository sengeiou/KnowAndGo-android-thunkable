package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import org.jetbrains.annotations.NotNull;

/* renamed from: kotlin.reflect.jvm.internal.impl.load.java.BuiltinMethodsWithSpecialGenericSignature$getSpecialSignatureInfo$builtinSignature$1 */
/* compiled from: specialBuiltinMembers.kt */
final class C3673xdb572182 extends Lambda implements Function1<CallableMemberDescriptor, Boolean> {
    public static final C3673xdb572182 INSTANCE = new C3673xdb572182();

    C3673xdb572182() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return Boolean.valueOf(invoke((CallableMemberDescriptor) obj));
    }

    public final boolean invoke(@NotNull CallableMemberDescriptor callableMemberDescriptor) {
        Intrinsics.checkParameterIsNotNull(callableMemberDescriptor, "it");
        return (callableMemberDescriptor instanceof FunctionDescriptor) && BuiltinMethodsWithSpecialGenericSignature.access$getHasErasedValueParametersInJava$p(BuiltinMethodsWithSpecialGenericSignature.INSTANCE, callableMemberDescriptor);
    }
}
