package kotlin.reflect.jvm.internal.structure;

import java.lang.annotation.Annotation;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationAsAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo39784bv = {1, 0, 3}, mo39785d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, mo39786d2 = {"Lkotlin/reflect/jvm/internal/structure/ReflectJavaAnnotationAsAnnotationArgument;", "Lkotlin/reflect/jvm/internal/structure/ReflectJavaAnnotationArgument;", "Lkotlin/reflect/jvm/internal/impl/load/java/structure/JavaAnnotationAsAnnotationArgument;", "name", "Lkotlin/reflect/jvm/internal/impl/name/Name;", "annotation", "", "(Lorg/jetbrains/kotlin/name/Name;Ljava/lang/annotation/Annotation;)V", "getAnnotation", "Lkotlin/reflect/jvm/internal/impl/load/java/structure/JavaAnnotation;", "descriptors.runtime"}, mo39787k = 1, mo39788mv = {1, 1, 15})
/* compiled from: ReflectJavaAnnotationArguments.kt */
public final class ReflectJavaAnnotationAsAnnotationArgument extends ReflectJavaAnnotationArgument implements JavaAnnotationAsAnnotationArgument {
    private final Annotation annotation;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ReflectJavaAnnotationAsAnnotationArgument(@Nullable Name name, @NotNull Annotation annotation2) {
        super(name);
        Intrinsics.checkParameterIsNotNull(annotation2, "annotation");
        this.annotation = annotation2;
    }

    @NotNull
    public JavaAnnotation getAnnotation() {
        return new ReflectJavaAnnotation(this.annotation);
    }
}
