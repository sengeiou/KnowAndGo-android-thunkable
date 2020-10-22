package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: JvmMemberSignature.kt */
public abstract class JvmMemberSignature {
    @NotNull
    public abstract String asString();

    @NotNull
    public abstract String getDesc();

    @NotNull
    public abstract String getName();

    private JvmMemberSignature() {
    }

    public /* synthetic */ JvmMemberSignature(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* compiled from: JvmMemberSignature.kt */
    public static final class Method extends JvmMemberSignature {
        @NotNull
        private final String desc;
        @NotNull
        private final String name;

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Method)) {
                return false;
            }
            Method method = (Method) obj;
            return Intrinsics.areEqual((Object) getName(), (Object) method.getName()) && Intrinsics.areEqual((Object) getDesc(), (Object) method.getDesc());
        }

        public int hashCode() {
            String name2 = getName();
            int i = 0;
            int hashCode = (name2 != null ? name2.hashCode() : 0) * 31;
            String desc2 = getDesc();
            if (desc2 != null) {
                i = desc2.hashCode();
            }
            return hashCode + i;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Method(@NotNull String str, @NotNull String str2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkParameterIsNotNull(str, "name");
            Intrinsics.checkParameterIsNotNull(str2, "desc");
            this.name = str;
            this.desc = str2;
        }

        @NotNull
        public String getDesc() {
            return this.desc;
        }

        @NotNull
        public String getName() {
            return this.name;
        }

        @NotNull
        public String asString() {
            return getName() + getDesc();
        }
    }

    /* compiled from: JvmMemberSignature.kt */
    public static final class Field extends JvmMemberSignature {
        @NotNull
        private final String desc;
        @NotNull
        private final String name;

        @NotNull
        public final String component1() {
            return getName();
        }

        @NotNull
        public final String component2() {
            return getDesc();
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Field)) {
                return false;
            }
            Field field = (Field) obj;
            return Intrinsics.areEqual((Object) getName(), (Object) field.getName()) && Intrinsics.areEqual((Object) getDesc(), (Object) field.getDesc());
        }

        public int hashCode() {
            String name2 = getName();
            int i = 0;
            int hashCode = (name2 != null ? name2.hashCode() : 0) * 31;
            String desc2 = getDesc();
            if (desc2 != null) {
                i = desc2.hashCode();
            }
            return hashCode + i;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Field(@NotNull String str, @NotNull String str2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkParameterIsNotNull(str, "name");
            Intrinsics.checkParameterIsNotNull(str2, "desc");
            this.name = str;
            this.desc = str2;
        }

        @NotNull
        public String getDesc() {
            return this.desc;
        }

        @NotNull
        public String getName() {
            return this.name;
        }

        @NotNull
        public String asString() {
            return getName() + ':' + getDesc();
        }
    }

    @NotNull
    public final String toString() {
        return asString();
    }
}
