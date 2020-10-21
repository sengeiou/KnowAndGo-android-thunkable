package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import org.jetbrains.annotations.NotNull;

/* compiled from: MemberDeserializer.kt */
final class MemberDeserializer$getPropertyFieldAnnotations$1 extends Lambda implements Function0<List<? extends AnnotationDescriptor>> {
    final /* synthetic */ boolean $isDelegate;
    final /* synthetic */ ProtoBuf.Property $proto;
    final /* synthetic */ MemberDeserializer this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MemberDeserializer$getPropertyFieldAnnotations$1(MemberDeserializer memberDeserializer, boolean z, ProtoBuf.Property property) {
        super(0);
        this.this$0 = memberDeserializer;
        this.$isDelegate = z;
        this.$proto = property;
    }

    @NotNull
    public final List<AnnotationDescriptor> invoke() {
        List<AnnotationDescriptor> list;
        ProtoContainer access$asProtoContainer = this.this$0.asProtoContainer(this.this$0.f3000c.getContainingDeclaration());
        if (access$asProtoContainer != null) {
            list = this.$isDelegate ? CollectionsKt.toList(this.this$0.f3000c.getComponents().getAnnotationAndConstantLoader().loadPropertyDelegateFieldAnnotations(access$asProtoContainer, this.$proto)) : CollectionsKt.toList(this.this$0.f3000c.getComponents().getAnnotationAndConstantLoader().loadPropertyBackingFieldAnnotations(access$asProtoContainer, this.$proto));
        } else {
            list = null;
        }
        return list != null ? list : CollectionsKt.emptyList();
    }
}
