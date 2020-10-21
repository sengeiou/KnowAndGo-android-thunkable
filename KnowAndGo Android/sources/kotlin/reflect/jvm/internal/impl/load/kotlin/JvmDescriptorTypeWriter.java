package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: typeSignatureMapping.kt */
public class JvmDescriptorTypeWriter<T> {
    @Nullable
    private T jvmCurrentType;
    private int jvmCurrentTypeArrayLevel;
    private final JvmTypeFactory<T> jvmTypeFactory;

    public void writeArrayEnd() {
    }

    public void writeArrayType() {
        if (this.jvmCurrentType == null) {
            this.jvmCurrentTypeArrayLevel++;
            int i = this.jvmCurrentTypeArrayLevel;
        }
    }

    public void writeClass(@NotNull T t) {
        Intrinsics.checkParameterIsNotNull(t, "objectType");
        writeJvmTypeAsIs(t);
    }

    /* access modifiers changed from: protected */
    public final void writeJvmTypeAsIs(@NotNull T t) {
        Intrinsics.checkParameterIsNotNull(t, "type");
        if (this.jvmCurrentType == null) {
            if (this.jvmCurrentTypeArrayLevel > 0) {
                JvmTypeFactory<T> jvmTypeFactory2 = this.jvmTypeFactory;
                t = jvmTypeFactory2.createFromString(StringsKt.repeat("[", this.jvmCurrentTypeArrayLevel) + this.jvmTypeFactory.toString(t));
            }
            this.jvmCurrentType = t;
        }
    }

    public void writeTypeVariable(@NotNull Name name, @NotNull T t) {
        Intrinsics.checkParameterIsNotNull(name, "name");
        Intrinsics.checkParameterIsNotNull(t, "type");
        writeJvmTypeAsIs(t);
    }
}
