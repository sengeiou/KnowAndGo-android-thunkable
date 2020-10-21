package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: methodSignatureMapping.kt */
public abstract class JvmType {
    private JvmType() {
    }

    public /* synthetic */ JvmType(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* compiled from: methodSignatureMapping.kt */
    public static final class Primitive extends JvmType {
        @Nullable
        private final JvmPrimitiveType jvmPrimitiveType;

        public Primitive(@Nullable JvmPrimitiveType jvmPrimitiveType2) {
            super((DefaultConstructorMarker) null);
            this.jvmPrimitiveType = jvmPrimitiveType2;
        }

        @Nullable
        public final JvmPrimitiveType getJvmPrimitiveType() {
            return this.jvmPrimitiveType;
        }
    }

    /* compiled from: methodSignatureMapping.kt */
    public static final class Object extends JvmType {
        @NotNull
        private final String internalName;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Object(@NotNull String str) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkParameterIsNotNull(str, "internalName");
            this.internalName = str;
        }

        @NotNull
        public final String getInternalName() {
            return this.internalName;
        }
    }

    /* compiled from: methodSignatureMapping.kt */
    public static final class Array extends JvmType {
        @NotNull
        private final JvmType elementType;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Array(@NotNull JvmType jvmType) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkParameterIsNotNull(jvmType, "elementType");
            this.elementType = jvmType;
        }

        @NotNull
        public final JvmType getElementType() {
            return this.elementType;
        }
    }

    @NotNull
    public String toString() {
        return JvmTypeFactoryImpl.INSTANCE.toString(this);
    }
}
