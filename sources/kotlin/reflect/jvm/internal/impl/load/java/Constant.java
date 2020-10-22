package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: utils.kt */
public final class Constant extends JavaDefaultValue {
    @NotNull
    private final Object value;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Constant(@NotNull Object obj) {
        super((DefaultConstructorMarker) null);
        Intrinsics.checkParameterIsNotNull(obj, "value");
        this.value = obj;
    }
}
