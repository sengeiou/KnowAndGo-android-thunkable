package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.EnumEntrySyntheticClassDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* renamed from: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor$EnumEntryClassDescriptors$enumEntryByName$1 */
/* compiled from: DeserializedClassDescriptor.kt */
final class C3816xaf8327b7 extends Lambda implements Function1<Name, EnumEntrySyntheticClassDescriptor> {
    final /* synthetic */ DeserializedClassDescriptor.EnumEntryClassDescriptors this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C3816xaf8327b7(DeserializedClassDescriptor.EnumEntryClassDescriptors enumEntryClassDescriptors) {
        super(1);
        this.this$0 = enumEntryClassDescriptors;
    }

    @Nullable
    public final EnumEntrySyntheticClassDescriptor invoke(@NotNull Name name) {
        Intrinsics.checkParameterIsNotNull(name, "name");
        ProtoBuf.EnumEntry enumEntry = (ProtoBuf.EnumEntry) this.this$0.enumEntryProtos.get(name);
        if (enumEntry == null) {
            return null;
        }
        return EnumEntrySyntheticClassDescriptor.create(DeserializedClassDescriptor.this.getC().getStorageManager(), DeserializedClassDescriptor.this, name, this.this$0.enumMemberNames, new DeserializedAnnotations(DeserializedClassDescriptor.this.getC().getStorageManager(), new C3811x7c5aab78(enumEntry, this, name)), SourceElement.NO_SOURCE);
    }
}
