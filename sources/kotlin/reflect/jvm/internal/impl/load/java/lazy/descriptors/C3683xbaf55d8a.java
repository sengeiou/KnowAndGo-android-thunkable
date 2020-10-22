package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterUtilsKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor;
import org.jetbrains.annotations.NotNull;

/* renamed from: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor$LazyJavaClassTypeConstructor$parameters$1 */
/* compiled from: LazyJavaClassDescriptor.kt */
final class C3683xbaf55d8a extends Lambda implements Function0<List<? extends TypeParameterDescriptor>> {
    final /* synthetic */ LazyJavaClassDescriptor.LazyJavaClassTypeConstructor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C3683xbaf55d8a(LazyJavaClassDescriptor.LazyJavaClassTypeConstructor lazyJavaClassTypeConstructor) {
        super(0);
        this.this$0 = lazyJavaClassTypeConstructor;
    }

    @NotNull
    public final List<TypeParameterDescriptor> invoke() {
        return TypeParameterUtilsKt.computeConstructorTypeParameters(LazyJavaClassDescriptor.this);
    }
}
