package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: specialBuiltinMembers.kt */
final class NameAndSignature {
    @NotNull
    private final Name name;
    @NotNull
    private final String signature;

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NameAndSignature)) {
            return false;
        }
        NameAndSignature nameAndSignature = (NameAndSignature) obj;
        return Intrinsics.areEqual((Object) this.name, (Object) nameAndSignature.name) && Intrinsics.areEqual((Object) this.signature, (Object) nameAndSignature.signature);
    }

    public int hashCode() {
        Name name2 = this.name;
        int i = 0;
        int hashCode = (name2 != null ? name2.hashCode() : 0) * 31;
        String str = this.signature;
        if (str != null) {
            i = str.hashCode();
        }
        return hashCode + i;
    }

    @NotNull
    public String toString() {
        return "NameAndSignature(name=" + this.name + ", signature=" + this.signature + ")";
    }

    public NameAndSignature(@NotNull Name name2, @NotNull String str) {
        Intrinsics.checkParameterIsNotNull(name2, "name");
        Intrinsics.checkParameterIsNotNull(str, "signature");
        this.name = name2;
        this.signature = str;
    }

    @NotNull
    public final Name getName() {
        return this.name;
    }

    @NotNull
    public final String getSignature() {
        return this.signature;
    }
}
