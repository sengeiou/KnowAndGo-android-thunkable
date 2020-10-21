package kotlin.reflect.jvm.internal.impl.metadata.deserialization;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: VersionRequirement.kt */
public final class VersionRequirementTable {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @NotNull
    public static final VersionRequirementTable EMPTY = new VersionRequirementTable(CollectionsKt.emptyList());
    private final List<ProtoBuf.VersionRequirement> infos;

    private VersionRequirementTable(List<ProtoBuf.VersionRequirement> list) {
        this.infos = list;
    }

    public /* synthetic */ VersionRequirementTable(List list, DefaultConstructorMarker defaultConstructorMarker) {
        this(list);
    }

    @Nullable
    public final ProtoBuf.VersionRequirement get(int i) {
        return (ProtoBuf.VersionRequirement) CollectionsKt.getOrNull(this.infos, i);
    }

    /* compiled from: VersionRequirement.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final VersionRequirementTable getEMPTY() {
            return VersionRequirementTable.EMPTY;
        }

        @NotNull
        public final VersionRequirementTable create(@NotNull ProtoBuf.VersionRequirementTable versionRequirementTable) {
            Intrinsics.checkParameterIsNotNull(versionRequirementTable, "table");
            if (versionRequirementTable.getRequirementCount() == 0) {
                return getEMPTY();
            }
            List<ProtoBuf.VersionRequirement> requirementList = versionRequirementTable.getRequirementList();
            Intrinsics.checkExpressionValueIsNotNull(requirementList, "table.requirementList");
            return new VersionRequirementTable(requirementList, (DefaultConstructorMarker) null);
        }
    }
}
