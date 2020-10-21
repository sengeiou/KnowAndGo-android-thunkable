package kotlin.reflect.jvm.internal.structure;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaLiteralAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo39784bv = {1, 0, 3}, mo39785d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007R\u0014\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, mo39786d2 = {"Lkotlin/reflect/jvm/internal/structure/ReflectJavaLiteralAnnotationArgument;", "Lkotlin/reflect/jvm/internal/structure/ReflectJavaAnnotationArgument;", "Lkotlin/reflect/jvm/internal/impl/load/java/structure/JavaLiteralAnnotationArgument;", "name", "Lkotlin/reflect/jvm/internal/impl/name/Name;", "value", "", "(Lorg/jetbrains/kotlin/name/Name;Ljava/lang/Object;)V", "getValue", "()Ljava/lang/Object;", "descriptors.runtime"}, mo39787k = 1, mo39788mv = {1, 1, 15})
/* compiled from: ReflectJavaAnnotationArguments.kt */
public final class ReflectJavaLiteralAnnotationArgument extends ReflectJavaAnnotationArgument implements JavaLiteralAnnotationArgument {
    @NotNull
    private final Object value;

    @NotNull
    public Object getValue() {
        return this.value;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ReflectJavaLiteralAnnotationArgument(@Nullable Name name, @NotNull Object obj) {
        super(name);
        Intrinsics.checkParameterIsNotNull(obj, "value");
        this.value = obj;
    }
}
