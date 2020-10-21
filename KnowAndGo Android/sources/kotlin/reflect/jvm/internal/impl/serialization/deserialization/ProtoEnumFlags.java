package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ProtoEnumFlags.kt */
public final class ProtoEnumFlags {
    public static final ProtoEnumFlags INSTANCE = new ProtoEnumFlags();

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$1 = new int[CallableMemberDescriptor.Kind.values().length];
        public static final /* synthetic */ int[] $EnumSwitchMapping$3 = new int[Modality.values().length];
        public static final /* synthetic */ int[] $EnumSwitchMapping$6 = new int[ClassKind.values().length];

        static {
            $EnumSwitchMapping$0 = new int[ProtoBuf.MemberKind.values().length];
            $EnumSwitchMapping$0[ProtoBuf.MemberKind.DECLARATION.ordinal()] = 1;
            $EnumSwitchMapping$0[ProtoBuf.MemberKind.FAKE_OVERRIDE.ordinal()] = 2;
            $EnumSwitchMapping$0[ProtoBuf.MemberKind.DELEGATION.ordinal()] = 3;
            $EnumSwitchMapping$0[ProtoBuf.MemberKind.SYNTHESIZED.ordinal()] = 4;
            $EnumSwitchMapping$1[CallableMemberDescriptor.Kind.DECLARATION.ordinal()] = 1;
            $EnumSwitchMapping$1[CallableMemberDescriptor.Kind.FAKE_OVERRIDE.ordinal()] = 2;
            $EnumSwitchMapping$1[CallableMemberDescriptor.Kind.DELEGATION.ordinal()] = 3;
            $EnumSwitchMapping$1[CallableMemberDescriptor.Kind.SYNTHESIZED.ordinal()] = 4;
            $EnumSwitchMapping$2 = new int[ProtoBuf.Modality.values().length];
            $EnumSwitchMapping$2[ProtoBuf.Modality.FINAL.ordinal()] = 1;
            $EnumSwitchMapping$2[ProtoBuf.Modality.OPEN.ordinal()] = 2;
            $EnumSwitchMapping$2[ProtoBuf.Modality.ABSTRACT.ordinal()] = 3;
            $EnumSwitchMapping$2[ProtoBuf.Modality.SEALED.ordinal()] = 4;
            $EnumSwitchMapping$3[Modality.FINAL.ordinal()] = 1;
            $EnumSwitchMapping$3[Modality.OPEN.ordinal()] = 2;
            $EnumSwitchMapping$3[Modality.ABSTRACT.ordinal()] = 3;
            $EnumSwitchMapping$3[Modality.SEALED.ordinal()] = 4;
            $EnumSwitchMapping$4 = new int[ProtoBuf.Visibility.values().length];
            $EnumSwitchMapping$4[ProtoBuf.Visibility.INTERNAL.ordinal()] = 1;
            $EnumSwitchMapping$4[ProtoBuf.Visibility.PRIVATE.ordinal()] = 2;
            $EnumSwitchMapping$4[ProtoBuf.Visibility.PRIVATE_TO_THIS.ordinal()] = 3;
            $EnumSwitchMapping$4[ProtoBuf.Visibility.PROTECTED.ordinal()] = 4;
            $EnumSwitchMapping$4[ProtoBuf.Visibility.PUBLIC.ordinal()] = 5;
            $EnumSwitchMapping$4[ProtoBuf.Visibility.LOCAL.ordinal()] = 6;
            $EnumSwitchMapping$5 = new int[ProtoBuf.Class.Kind.values().length];
            $EnumSwitchMapping$5[ProtoBuf.Class.Kind.CLASS.ordinal()] = 1;
            $EnumSwitchMapping$5[ProtoBuf.Class.Kind.INTERFACE.ordinal()] = 2;
            $EnumSwitchMapping$5[ProtoBuf.Class.Kind.ENUM_CLASS.ordinal()] = 3;
            $EnumSwitchMapping$5[ProtoBuf.Class.Kind.ENUM_ENTRY.ordinal()] = 4;
            $EnumSwitchMapping$5[ProtoBuf.Class.Kind.ANNOTATION_CLASS.ordinal()] = 5;
            $EnumSwitchMapping$5[ProtoBuf.Class.Kind.OBJECT.ordinal()] = 6;
            $EnumSwitchMapping$5[ProtoBuf.Class.Kind.COMPANION_OBJECT.ordinal()] = 7;
            $EnumSwitchMapping$6[ClassKind.CLASS.ordinal()] = 1;
            $EnumSwitchMapping$6[ClassKind.INTERFACE.ordinal()] = 2;
            $EnumSwitchMapping$6[ClassKind.ENUM_CLASS.ordinal()] = 3;
            $EnumSwitchMapping$6[ClassKind.ENUM_ENTRY.ordinal()] = 4;
            $EnumSwitchMapping$6[ClassKind.ANNOTATION_CLASS.ordinal()] = 5;
            $EnumSwitchMapping$6[ClassKind.OBJECT.ordinal()] = 6;
            $EnumSwitchMapping$7 = new int[ProtoBuf.TypeParameter.Variance.values().length];
            $EnumSwitchMapping$7[ProtoBuf.TypeParameter.Variance.IN.ordinal()] = 1;
            $EnumSwitchMapping$7[ProtoBuf.TypeParameter.Variance.OUT.ordinal()] = 2;
            $EnumSwitchMapping$7[ProtoBuf.TypeParameter.Variance.INV.ordinal()] = 3;
            $EnumSwitchMapping$8 = new int[ProtoBuf.Type.Argument.Projection.values().length];
            $EnumSwitchMapping$8[ProtoBuf.Type.Argument.Projection.IN.ordinal()] = 1;
            $EnumSwitchMapping$8[ProtoBuf.Type.Argument.Projection.OUT.ordinal()] = 2;
            $EnumSwitchMapping$8[ProtoBuf.Type.Argument.Projection.INV.ordinal()] = 3;
            $EnumSwitchMapping$8[ProtoBuf.Type.Argument.Projection.STAR.ordinal()] = 4;
        }
    }

    private ProtoEnumFlags() {
    }

    @NotNull
    public final CallableMemberDescriptor.Kind memberKind(@Nullable ProtoBuf.MemberKind memberKind) {
        if (memberKind != null) {
            switch (memberKind) {
                case DECLARATION:
                    return CallableMemberDescriptor.Kind.DECLARATION;
                case FAKE_OVERRIDE:
                    return CallableMemberDescriptor.Kind.FAKE_OVERRIDE;
                case DELEGATION:
                    return CallableMemberDescriptor.Kind.DELEGATION;
                case SYNTHESIZED:
                    return CallableMemberDescriptor.Kind.SYNTHESIZED;
            }
        }
        return CallableMemberDescriptor.Kind.DECLARATION;
    }

    @NotNull
    public final Modality modality(@Nullable ProtoBuf.Modality modality) {
        if (modality != null) {
            switch (modality) {
                case FINAL:
                    return Modality.FINAL;
                case OPEN:
                    return Modality.OPEN;
                case ABSTRACT:
                    return Modality.ABSTRACT;
                case SEALED:
                    return Modality.SEALED;
            }
        }
        return Modality.FINAL;
    }

    @NotNull
    public final Visibility visibility(@Nullable ProtoBuf.Visibility visibility) {
        Visibility visibility2;
        if (visibility != null) {
            switch (visibility) {
                case INTERNAL:
                    visibility2 = Visibilities.INTERNAL;
                    break;
                case PRIVATE:
                    visibility2 = Visibilities.PRIVATE;
                    break;
                case PRIVATE_TO_THIS:
                    visibility2 = Visibilities.PRIVATE_TO_THIS;
                    break;
                case PROTECTED:
                    visibility2 = Visibilities.PROTECTED;
                    break;
                case PUBLIC:
                    visibility2 = Visibilities.PUBLIC;
                    break;
                case LOCAL:
                    visibility2 = Visibilities.LOCAL;
                    break;
            }
        }
        visibility2 = Visibilities.PRIVATE;
        Intrinsics.checkExpressionValueIsNotNull(visibility2, "when (visibility) {\n    …isibilities.PRIVATE\n    }");
        return visibility2;
    }

    @NotNull
    public final ClassKind classKind(@Nullable ProtoBuf.Class.Kind kind) {
        if (kind != null) {
            switch (kind) {
                case CLASS:
                    return ClassKind.CLASS;
                case INTERFACE:
                    return ClassKind.INTERFACE;
                case ENUM_CLASS:
                    return ClassKind.ENUM_CLASS;
                case ENUM_ENTRY:
                    return ClassKind.ENUM_ENTRY;
                case ANNOTATION_CLASS:
                    return ClassKind.ANNOTATION_CLASS;
                case OBJECT:
                case COMPANION_OBJECT:
                    return ClassKind.OBJECT;
            }
        }
        return ClassKind.CLASS;
    }

    @NotNull
    public final Variance variance(@NotNull ProtoBuf.TypeParameter.Variance variance) {
        Intrinsics.checkParameterIsNotNull(variance, "variance");
        switch (variance) {
            case IN:
                return Variance.IN_VARIANCE;
            case OUT:
                return Variance.OUT_VARIANCE;
            case INV:
                return Variance.INVARIANT;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    @NotNull
    public final Variance variance(@NotNull ProtoBuf.Type.Argument.Projection projection) {
        Intrinsics.checkParameterIsNotNull(projection, "projection");
        switch (projection) {
            case IN:
                return Variance.IN_VARIANCE;
            case OUT:
                return Variance.OUT_VARIANCE;
            case INV:
                return Variance.INVARIANT;
            case STAR:
                throw new IllegalArgumentException("Only IN, OUT and INV are supported. Actual argument: " + projection);
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
