package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterUtilsKt;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor;
import org.jetbrains.annotations.NotNull;

/* renamed from: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor$DeserializedClassTypeConstructor$parameters$1 */
/* compiled from: DeserializedClassDescriptor.kt */
final class C3815x32944d2c extends Lambda implements Function0<List<? extends TypeParameterDescriptor>> {
    final /* synthetic */ DeserializedClassDescriptor.DeserializedClassTypeConstructor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C3815x32944d2c(DeserializedClassDescriptor.DeserializedClassTypeConstructor deserializedClassTypeConstructor) {
        super(0);
        this.this$0 = deserializedClassTypeConstructor;
    }

    @NotNull
    public final List<TypeParameterDescriptor> invoke() {
        return TypeParameterUtilsKt.computeConstructorTypeParameters(DeserializedClassDescriptor.this);
    }
}
