package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import org.jetbrains.annotations.NotNull;

/* compiled from: MemberDeserializer.kt */
final class MemberDeserializer$getReceiverParameterAnnotations$1 extends Lambda implements Function0<List<? extends AnnotationDescriptor>> {
    final /* synthetic */ AnnotatedCallableKind $kind;
    final /* synthetic */ MessageLite $proto;
    final /* synthetic */ MemberDeserializer this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MemberDeserializer$getReceiverParameterAnnotations$1(MemberDeserializer memberDeserializer, MessageLite messageLite, AnnotatedCallableKind annotatedCallableKind) {
        super(0);
        this.this$0 = memberDeserializer;
        this.$proto = messageLite;
        this.$kind = annotatedCallableKind;
    }

    @NotNull
    public final List<AnnotationDescriptor> invoke() {
        ProtoContainer access$asProtoContainer = this.this$0.asProtoContainer(this.this$0.f3000c.getContainingDeclaration());
        List<AnnotationDescriptor> loadExtensionReceiverParameterAnnotations = access$asProtoContainer != null ? this.this$0.f3000c.getComponents().getAnnotationAndConstantLoader().loadExtensionReceiverParameterAnnotations(access$asProtoContainer, this.$proto, this.$kind) : null;
        return loadExtensionReceiverParameterAnnotations != null ? loadExtensionReceiverParameterAnnotations : CollectionsKt.emptyList();
    }
}
