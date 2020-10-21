package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import org.jetbrains.annotations.NotNull;

/* compiled from: TypeIntersectionScope.kt */
final class TypeIntersectionScope$getContributedDescriptors$2 extends Lambda implements Function1<CallableDescriptor, CallableDescriptor> {
    public static final TypeIntersectionScope$getContributedDescriptors$2 INSTANCE = new TypeIntersectionScope$getContributedDescriptors$2();

    TypeIntersectionScope$getContributedDescriptors$2() {
        super(1);
    }

    @NotNull
    public final CallableDescriptor invoke(@NotNull CallableDescriptor callableDescriptor) {
        Intrinsics.checkParameterIsNotNull(callableDescriptor, "$receiver");
        return callableDescriptor;
    }
}