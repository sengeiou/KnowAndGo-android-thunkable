package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: LazyJavaStaticScope.kt */
public abstract class LazyJavaStaticScope extends LazyJavaScope {
    /* access modifiers changed from: protected */
    public void computeNonDeclaredProperties(@NotNull Name name, @NotNull Collection<PropertyDescriptor> collection) {
        Intrinsics.checkParameterIsNotNull(name, "name");
        Intrinsics.checkParameterIsNotNull(collection, "result");
    }

    /* access modifiers changed from: protected */
    @Nullable
    public ReceiverParameterDescriptor getDispatchReceiverParameter() {
        return null;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LazyJavaStaticScope(@NotNull LazyJavaResolverContext lazyJavaResolverContext) {
        super(lazyJavaResolverContext);
        Intrinsics.checkParameterIsNotNull(lazyJavaResolverContext, "c");
    }

    /* access modifiers changed from: protected */
    @NotNull
    public LazyJavaScope.MethodSignatureData resolveMethodSignature(@NotNull JavaMethod javaMethod, @NotNull List<? extends TypeParameterDescriptor> list, @NotNull KotlinType kotlinType, @NotNull List<? extends ValueParameterDescriptor> list2) {
        Intrinsics.checkParameterIsNotNull(javaMethod, "method");
        Intrinsics.checkParameterIsNotNull(list, "methodTypeParameters");
        Intrinsics.checkParameterIsNotNull(kotlinType, "returnType");
        Intrinsics.checkParameterIsNotNull(list2, "valueParameters");
        return new LazyJavaScope.MethodSignatureData(kotlinType, (KotlinType) null, list2, list, false, CollectionsKt.emptyList());
    }
}
