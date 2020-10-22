package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: PackagePartProvider.kt */
public interface PackagePartProvider {
    @NotNull
    List<String> findPackageParts(@NotNull String str);

    /* compiled from: PackagePartProvider.kt */
    public static final class Empty implements PackagePartProvider {
        public static final Empty INSTANCE = new Empty();

        private Empty() {
        }

        @NotNull
        public List<String> findPackageParts(@NotNull String str) {
            Intrinsics.checkParameterIsNotNull(str, "packageFqName");
            return CollectionsKt.emptyList();
        }
    }
}
