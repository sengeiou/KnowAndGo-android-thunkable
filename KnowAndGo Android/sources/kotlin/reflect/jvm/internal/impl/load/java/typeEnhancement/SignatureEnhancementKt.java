package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: signatureEnhancement.kt */
public final class SignatureEnhancementKt {
    @NotNull
    public static final JavaTypeQualifiers createJavaTypeQualifiers(@Nullable NullabilityQualifier nullabilityQualifier, @Nullable MutabilityQualifier mutabilityQualifier, boolean z, boolean z2) {
        if (!z2 || nullabilityQualifier != NullabilityQualifier.NOT_NULL) {
            return new JavaTypeQualifiers(nullabilityQualifier, mutabilityQualifier, false, z);
        }
        return new JavaTypeQualifiers(nullabilityQualifier, mutabilityQualifier, true, z);
    }

    @Nullable
    public static final <T> T select(@NotNull Set<? extends T> set, @NotNull T t, @NotNull T t2, @Nullable T t3, boolean z) {
        Set<? extends T> set2;
        Intrinsics.checkParameterIsNotNull(set, "$this$select");
        Intrinsics.checkParameterIsNotNull(t, "low");
        Intrinsics.checkParameterIsNotNull(t2, "high");
        if (z) {
            T t4 = set.contains(t) ? t : set.contains(t2) ? t2 : null;
            if (!Intrinsics.areEqual((Object) t4, (Object) t) || !Intrinsics.areEqual((Object) t3, (Object) t2)) {
                return t3 != null ? t3 : t4;
            }
            return null;
        }
        if (!(t3 == null || (set2 = CollectionsKt.toSet(SetsKt.plus(set, t3))) == null)) {
            set = set2;
        }
        return CollectionsKt.singleOrNull(set);
    }

    @Nullable
    public static final NullabilityQualifier select(@NotNull Set<? extends NullabilityQualifier> set, @Nullable NullabilityQualifier nullabilityQualifier, boolean z) {
        Intrinsics.checkParameterIsNotNull(set, "$this$select");
        if (nullabilityQualifier == NullabilityQualifier.FORCE_FLEXIBILITY) {
            return NullabilityQualifier.FORCE_FLEXIBILITY;
        }
        return (NullabilityQualifier) select(set, NullabilityQualifier.NOT_NULL, NullabilityQualifier.NULLABLE, nullabilityQualifier, z);
    }
}
