package kotlin.reflect.full;

import java.lang.annotation.Annotation;
import java.util.Iterator;
import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KAnnotatedElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo39784bv = {1, 0, 3}, mo39785d1 = {"\u0000\u0016\n\u0002\b\u0002\n\u0002\u0010\u001b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u001a \u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002*\u00020\u0003H\b¢\u0006\u0002\u0010\u0004\u001a\u0019\u0010\u0005\u001a\u00020\u0006\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002*\u00020\u0003H\b¨\u0006\u0007"}, mo39786d2 = {"findAnnotation", "T", "", "Lkotlin/reflect/KAnnotatedElement;", "(Lkotlin/reflect/KAnnotatedElement;)Ljava/lang/annotation/Annotation;", "hasAnnotation", "", "kotlin-reflection"}, mo39787k = 2, mo39788mv = {1, 1, 15})
@JvmName(name = "KAnnotatedElements")
/* compiled from: KAnnotatedElements.kt */
public final class KAnnotatedElements {
    @SinceKotlin(version = "1.1")
    @Nullable
    public static final /* synthetic */ <T extends Annotation> T findAnnotation(@NotNull KAnnotatedElement kAnnotatedElement) {
        T t;
        Intrinsics.checkParameterIsNotNull(kAnnotatedElement, "$this$findAnnotation");
        Iterator it = kAnnotatedElement.getAnnotations().iterator();
        while (true) {
            if (!it.hasNext()) {
                t = null;
                break;
            }
            t = it.next();
            Intrinsics.reifiedOperationMarker(3, "T");
            if (((Annotation) t) instanceof Annotation) {
                break;
            }
        }
        Intrinsics.reifiedOperationMarker(1, "T?");
        return (Annotation) t;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    public static final /* synthetic */ <T extends Annotation> boolean hasAnnotation(@NotNull KAnnotatedElement kAnnotatedElement) {
        Object obj;
        Intrinsics.checkParameterIsNotNull(kAnnotatedElement, "$this$hasAnnotation");
        Iterator it = kAnnotatedElement.getAnnotations().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            Intrinsics.reifiedOperationMarker(3, "T");
            if (((Annotation) obj) instanceof Annotation) {
                break;
            }
        }
        Intrinsics.reifiedOperationMarker(1, "T?");
        if (((Annotation) obj) != null) {
            return true;
        }
        return false;
    }
}
