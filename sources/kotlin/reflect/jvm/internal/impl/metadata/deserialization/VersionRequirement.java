package kotlin.reflect.jvm.internal.impl.metadata.deserialization;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.DeprecationLevel;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: VersionRequirement.kt */
public final class VersionRequirement {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Nullable
    private final Integer errorCode;
    @NotNull
    private final ProtoBuf.VersionRequirement.VersionKind kind;
    @NotNull
    private final DeprecationLevel level;
    @Nullable
    private final String message;
    @NotNull
    private final Version version;

    public VersionRequirement(@NotNull Version version2, @NotNull ProtoBuf.VersionRequirement.VersionKind versionKind, @NotNull DeprecationLevel deprecationLevel, @Nullable Integer num, @Nullable String str) {
        Intrinsics.checkParameterIsNotNull(version2, "version");
        Intrinsics.checkParameterIsNotNull(versionKind, "kind");
        Intrinsics.checkParameterIsNotNull(deprecationLevel, "level");
        this.version = version2;
        this.kind = versionKind;
        this.level = deprecationLevel;
        this.errorCode = num;
        this.message = str;
    }

    @NotNull
    public final Version getVersion() {
        return this.version;
    }

    @NotNull
    public final ProtoBuf.VersionRequirement.VersionKind getKind() {
        return this.kind;
    }

    /* compiled from: VersionRequirement.kt */
    public static final class Version {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        @NotNull
        @JvmField
        public static final Version INFINITY = new Version(256, 256, 256);
        private final int major;
        private final int minor;
        private final int patch;

        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                if (obj instanceof Version) {
                    Version version = (Version) obj;
                    if (this.major == version.major) {
                        if (this.minor == version.minor) {
                            if (this.patch == version.patch) {
                                return true;
                            }
                        }
                    }
                }
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (((this.major * 31) + this.minor) * 31) + this.patch;
        }

        public Version(int i, int i2, int i3) {
            this.major = i;
            this.minor = i2;
            this.patch = i3;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Version(int i, int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, i2, (i4 & 4) != 0 ? 0 : i3);
        }

        @NotNull
        public final String asString() {
            StringBuilder sb;
            int i;
            if (this.patch == 0) {
                sb = new StringBuilder();
                sb.append(this.major);
                sb.append('.');
                i = this.minor;
            } else {
                sb = new StringBuilder();
                sb.append(this.major);
                sb.append('.');
                sb.append(this.minor);
                sb.append('.');
                i = this.patch;
            }
            sb.append(i);
            return sb.toString();
        }

        @NotNull
        public String toString() {
            return asString();
        }

        /* compiled from: VersionRequirement.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @NotNull
            public final Version decode(@Nullable Integer num, @Nullable Integer num2) {
                if (num2 != null) {
                    return new Version(num2.intValue() & 255, (num2.intValue() >> 8) & 255, (num2.intValue() >> 16) & 255);
                }
                if (num != null) {
                    return new Version(num.intValue() & 7, (num.intValue() >> 3) & 15, (num.intValue() >> 7) & 127);
                }
                return Version.INFINITY;
            }
        }
    }

    @NotNull
    public String toString() {
        String str;
        String str2;
        StringBuilder sb = new StringBuilder();
        sb.append("since ");
        sb.append(this.version);
        sb.append(' ');
        sb.append(this.level);
        if (this.errorCode != null) {
            str = " error " + this.errorCode;
        } else {
            str = "";
        }
        sb.append(str);
        if (this.message != null) {
            str2 = ": " + this.message;
        } else {
            str2 = "";
        }
        sb.append(str2);
        return sb.toString();
    }

    /* compiled from: VersionRequirement.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final List<VersionRequirement> create(@NotNull MessageLite messageLite, @NotNull NameResolver nameResolver, @NotNull VersionRequirementTable versionRequirementTable) {
            List<Integer> list;
            Intrinsics.checkParameterIsNotNull(messageLite, "proto");
            Intrinsics.checkParameterIsNotNull(nameResolver, "nameResolver");
            Intrinsics.checkParameterIsNotNull(versionRequirementTable, "table");
            if (messageLite instanceof ProtoBuf.Class) {
                list = ((ProtoBuf.Class) messageLite).getVersionRequirementList();
            } else if (messageLite instanceof ProtoBuf.Constructor) {
                list = ((ProtoBuf.Constructor) messageLite).getVersionRequirementList();
            } else if (messageLite instanceof ProtoBuf.Function) {
                list = ((ProtoBuf.Function) messageLite).getVersionRequirementList();
            } else if (messageLite instanceof ProtoBuf.Property) {
                list = ((ProtoBuf.Property) messageLite).getVersionRequirementList();
            } else if (messageLite instanceof ProtoBuf.TypeAlias) {
                list = ((ProtoBuf.TypeAlias) messageLite).getVersionRequirementList();
            } else {
                throw new IllegalStateException("Unexpected declaration: " + messageLite.getClass());
            }
            Intrinsics.checkExpressionValueIsNotNull(list, "ids");
            Collection arrayList = new ArrayList();
            for (Integer num : list) {
                Companion companion = VersionRequirement.Companion;
                Intrinsics.checkExpressionValueIsNotNull(num, "id");
                VersionRequirement create = companion.create(num.intValue(), nameResolver, versionRequirementTable);
                if (create != null) {
                    arrayList.add(create);
                }
            }
            return (List) arrayList;
        }

        @Nullable
        public final VersionRequirement create(int i, @NotNull NameResolver nameResolver, @NotNull VersionRequirementTable versionRequirementTable) {
            DeprecationLevel deprecationLevel;
            Intrinsics.checkParameterIsNotNull(nameResolver, "nameResolver");
            Intrinsics.checkParameterIsNotNull(versionRequirementTable, "table");
            ProtoBuf.VersionRequirement versionRequirement = versionRequirementTable.get(i);
            String str = null;
            if (versionRequirement == null) {
                return null;
            }
            Version decode = Version.Companion.decode(versionRequirement.hasVersion() ? Integer.valueOf(versionRequirement.getVersion()) : null, versionRequirement.hasVersionFull() ? Integer.valueOf(versionRequirement.getVersionFull()) : null);
            ProtoBuf.VersionRequirement.Level level = versionRequirement.getLevel();
            if (level == null) {
                Intrinsics.throwNpe();
            }
            switch (level) {
                case WARNING:
                    deprecationLevel = DeprecationLevel.WARNING;
                    break;
                case ERROR:
                    deprecationLevel = DeprecationLevel.ERROR;
                    break;
                case HIDDEN:
                    deprecationLevel = DeprecationLevel.HIDDEN;
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
            DeprecationLevel deprecationLevel2 = deprecationLevel;
            Integer valueOf = versionRequirement.hasErrorCode() ? Integer.valueOf(versionRequirement.getErrorCode()) : null;
            if (versionRequirement.hasMessage()) {
                str = nameResolver.getString(versionRequirement.getMessage());
            }
            ProtoBuf.VersionRequirement.VersionKind versionKind = versionRequirement.getVersionKind();
            Intrinsics.checkExpressionValueIsNotNull(versionKind, "info.versionKind");
            return new VersionRequirement(decode, versionKind, deprecationLevel2, valueOf, str);
        }
    }
}
