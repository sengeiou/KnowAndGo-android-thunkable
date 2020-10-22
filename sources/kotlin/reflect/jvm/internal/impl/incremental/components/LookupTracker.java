package kotlin.reflect.jvm.internal.impl.incremental.components;

import com.facebook.react.uimanager.ViewProps;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: LookupTracker.kt */
public interface LookupTracker {
    boolean getRequiresPosition();

    void record(@NotNull String str, @NotNull Position position, @NotNull String str2, @NotNull ScopeKind scopeKind, @NotNull String str3);

    /* compiled from: LookupTracker.kt */
    public static final class DO_NOTHING implements LookupTracker {
        public static final DO_NOTHING INSTANCE = new DO_NOTHING();

        public boolean getRequiresPosition() {
            return false;
        }

        public void record(@NotNull String str, @NotNull Position position, @NotNull String str2, @NotNull ScopeKind scopeKind, @NotNull String str3) {
            Intrinsics.checkParameterIsNotNull(str, "filePath");
            Intrinsics.checkParameterIsNotNull(position, ViewProps.POSITION);
            Intrinsics.checkParameterIsNotNull(str2, "scopeFqName");
            Intrinsics.checkParameterIsNotNull(scopeKind, "scopeKind");
            Intrinsics.checkParameterIsNotNull(str3, "name");
        }

        private DO_NOTHING() {
        }
    }
}
