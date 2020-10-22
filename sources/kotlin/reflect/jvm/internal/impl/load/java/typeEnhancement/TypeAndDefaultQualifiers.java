package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: signatureEnhancement.kt */
final class TypeAndDefaultQualifiers {
    @Nullable
    private final JavaTypeQualifiers defaultQualifiers;
    @NotNull
    private final KotlinType type;

    @NotNull
    public final KotlinType component1() {
        return this.type;
    }

    @Nullable
    public final JavaTypeQualifiers component2() {
        return this.defaultQualifiers;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TypeAndDefaultQualifiers)) {
            return false;
        }
        TypeAndDefaultQualifiers typeAndDefaultQualifiers = (TypeAndDefaultQualifiers) obj;
        return Intrinsics.areEqual((Object) this.type, (Object) typeAndDefaultQualifiers.type) && Intrinsics.areEqual((Object) this.defaultQualifiers, (Object) typeAndDefaultQualifiers.defaultQualifiers);
    }

    public int hashCode() {
        KotlinType kotlinType = this.type;
        int i = 0;
        int hashCode = (kotlinType != null ? kotlinType.hashCode() : 0) * 31;
        JavaTypeQualifiers javaTypeQualifiers = this.defaultQualifiers;
        if (javaTypeQualifiers != null) {
            i = javaTypeQualifiers.hashCode();
        }
        return hashCode + i;
    }

    @NotNull
    public String toString() {
        return "TypeAndDefaultQualifiers(type=" + this.type + ", defaultQualifiers=" + this.defaultQualifiers + ")";
    }

    public TypeAndDefaultQualifiers(@NotNull KotlinType kotlinType, @Nullable JavaTypeQualifiers javaTypeQualifiers) {
        Intrinsics.checkParameterIsNotNull(kotlinType, "type");
        this.type = kotlinType;
        this.defaultQualifiers = javaTypeQualifiers;
    }

    @NotNull
    public final KotlinType getType() {
        return this.type;
    }
}
