package kotlin.jvm.internal;

import java.util.Iterator;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(mo39784bv = {1, 0, 3}, mo39785d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\u001a%\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, mo39786d2 = {"iterator", "", "T", "array", "", "([Ljava/lang/Object;)Ljava/util/Iterator;", "kotlin-stdlib"}, mo39787k = 2, mo39788mv = {1, 1, 15})
/* compiled from: ArrayIterator.kt */
public final class ArrayIteratorKt {
    @NotNull
    public static final <T> Iterator<T> iterator(@NotNull T[] tArr) {
        Intrinsics.checkParameterIsNotNull(tArr, "array");
        return new ArrayIterator<>(tArr);
    }
}
