package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.BinaryVersion;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: IncompatibleVersionErrorData.kt */
public final class IncompatibleVersionErrorData<T extends BinaryVersion> {
    @NotNull
    private final T actualVersion;
    @NotNull
    private final ClassId classId;
    @NotNull
    private final T expectedVersion;
    @NotNull
    private final String filePath;

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof IncompatibleVersionErrorData)) {
            return false;
        }
        IncompatibleVersionErrorData incompatibleVersionErrorData = (IncompatibleVersionErrorData) obj;
        return Intrinsics.areEqual((Object) this.actualVersion, (Object) incompatibleVersionErrorData.actualVersion) && Intrinsics.areEqual((Object) this.expectedVersion, (Object) incompatibleVersionErrorData.expectedVersion) && Intrinsics.areEqual((Object) this.filePath, (Object) incompatibleVersionErrorData.filePath) && Intrinsics.areEqual((Object) this.classId, (Object) incompatibleVersionErrorData.classId);
    }

    public int hashCode() {
        T t = this.actualVersion;
        int i = 0;
        int hashCode = (t != null ? t.hashCode() : 0) * 31;
        T t2 = this.expectedVersion;
        int hashCode2 = (hashCode + (t2 != null ? t2.hashCode() : 0)) * 31;
        String str = this.filePath;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 31;
        ClassId classId2 = this.classId;
        if (classId2 != null) {
            i = classId2.hashCode();
        }
        return hashCode3 + i;
    }

    @NotNull
    public String toString() {
        return "IncompatibleVersionErrorData(actualVersion=" + this.actualVersion + ", expectedVersion=" + this.expectedVersion + ", filePath=" + this.filePath + ", classId=" + this.classId + ")";
    }

    public IncompatibleVersionErrorData(@NotNull T t, @NotNull T t2, @NotNull String str, @NotNull ClassId classId2) {
        Intrinsics.checkParameterIsNotNull(t, "actualVersion");
        Intrinsics.checkParameterIsNotNull(t2, "expectedVersion");
        Intrinsics.checkParameterIsNotNull(str, "filePath");
        Intrinsics.checkParameterIsNotNull(classId2, "classId");
        this.actualVersion = t;
        this.expectedVersion = t2;
        this.filePath = str;
        this.classId = classId2;
    }
}
