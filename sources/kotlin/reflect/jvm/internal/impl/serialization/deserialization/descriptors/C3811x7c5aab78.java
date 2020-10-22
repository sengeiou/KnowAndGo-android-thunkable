package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.NotNull;

/* renamed from: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor$EnumEntryClassDescriptors$enumEntryByName$1$$special$$inlined$let$lambda$1 */
/* compiled from: DeserializedClassDescriptor.kt */
final class C3811x7c5aab78 extends Lambda implements Function0<List<? extends AnnotationDescriptor>> {
    final /* synthetic */ Name $name$inlined;
    final /* synthetic */ ProtoBuf.EnumEntry $proto;
    final /* synthetic */ C3816xaf8327b7 this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C3811x7c5aab78(ProtoBuf.EnumEntry enumEntry, C3816xaf8327b7 deserializedClassDescriptor$EnumEntryClassDescriptors$enumEntryByName$1, Name name) {
        super(0);
        this.$proto = enumEntry;
        this.this$0 = deserializedClassDescriptor$EnumEntryClassDescriptors$enumEntryByName$1;
        this.$name$inlined = name;
    }

    @NotNull
    public final List<AnnotationDescriptor> invoke() {
        return CollectionsKt.toList(DeserializedClassDescriptor.this.getC().getComponents().getAnnotationAndConstantLoader().loadEnumEntryAnnotations(DeserializedClassDescriptor.this.getThisAsProtoContainer$deserialization(), this.$proto));
    }
}
