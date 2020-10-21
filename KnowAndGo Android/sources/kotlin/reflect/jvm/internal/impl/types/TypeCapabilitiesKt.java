package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: TypeCapabilities.kt */
public final class TypeCapabilitiesKt {
    public static final boolean isCustomTypeVariable(@NotNull KotlinType kotlinType) {
        Intrinsics.checkParameterIsNotNull(kotlinType, "$this$isCustomTypeVariable");
        UnwrappedType unwrap = kotlinType.unwrap();
        if (!(unwrap instanceof CustomTypeVariable)) {
            unwrap = null;
        }
        CustomTypeVariable customTypeVariable = (CustomTypeVariable) unwrap;
        if (customTypeVariable != null) {
            return customTypeVariable.isTypeVariable();
        }
        return false;
    }

    @Nullable
    public static final CustomTypeVariable getCustomTypeVariable(@NotNull KotlinType kotlinType) {
        Intrinsics.checkParameterIsNotNull(kotlinType, "$this$getCustomTypeVariable");
        UnwrappedType unwrap = kotlinType.unwrap();
        if (!(unwrap instanceof CustomTypeVariable)) {
            unwrap = null;
        }
        CustomTypeVariable customTypeVariable = (CustomTypeVariable) unwrap;
        if (customTypeVariable == null || !customTypeVariable.isTypeVariable()) {
            return null;
        }
        return customTypeVariable;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0012, code lost:
        r0 = r0.getSubTypeRepresentative();
     */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final kotlin.reflect.jvm.internal.impl.types.KotlinType getSubtypeRepresentative(@org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.types.KotlinType r2) {
        /*
            java.lang.String r0 = "$this$getSubtypeRepresentative"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r2, r0)
            kotlin.reflect.jvm.internal.impl.types.UnwrappedType r0 = r2.unwrap()
            boolean r1 = r0 instanceof kotlin.reflect.jvm.internal.impl.types.SubtypingRepresentatives
            if (r1 != 0) goto L_0x000e
            r0 = 0
        L_0x000e:
            kotlin.reflect.jvm.internal.impl.types.SubtypingRepresentatives r0 = (kotlin.reflect.jvm.internal.impl.types.SubtypingRepresentatives) r0
            if (r0 == 0) goto L_0x0019
            kotlin.reflect.jvm.internal.impl.types.KotlinType r0 = r0.getSubTypeRepresentative()
            if (r0 == 0) goto L_0x0019
            r2 = r0
        L_0x0019:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.types.TypeCapabilitiesKt.getSubtypeRepresentative(kotlin.reflect.jvm.internal.impl.types.KotlinType):kotlin.reflect.jvm.internal.impl.types.KotlinType");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0012, code lost:
        r0 = r0.getSuperTypeRepresentative();
     */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final kotlin.reflect.jvm.internal.impl.types.KotlinType getSupertypeRepresentative(@org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.types.KotlinType r2) {
        /*
            java.lang.String r0 = "$this$getSupertypeRepresentative"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r2, r0)
            kotlin.reflect.jvm.internal.impl.types.UnwrappedType r0 = r2.unwrap()
            boolean r1 = r0 instanceof kotlin.reflect.jvm.internal.impl.types.SubtypingRepresentatives
            if (r1 != 0) goto L_0x000e
            r0 = 0
        L_0x000e:
            kotlin.reflect.jvm.internal.impl.types.SubtypingRepresentatives r0 = (kotlin.reflect.jvm.internal.impl.types.SubtypingRepresentatives) r0
            if (r0 == 0) goto L_0x0019
            kotlin.reflect.jvm.internal.impl.types.KotlinType r0 = r0.getSuperTypeRepresentative()
            if (r0 == 0) goto L_0x0019
            r2 = r0
        L_0x0019:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.types.TypeCapabilitiesKt.getSupertypeRepresentative(kotlin.reflect.jvm.internal.impl.types.KotlinType):kotlin.reflect.jvm.internal.impl.types.KotlinType");
    }

    public static final boolean sameTypeConstructors(@NotNull KotlinType kotlinType, @NotNull KotlinType kotlinType2) {
        Intrinsics.checkParameterIsNotNull(kotlinType, "first");
        Intrinsics.checkParameterIsNotNull(kotlinType2, "second");
        UnwrappedType unwrap = kotlinType.unwrap();
        if (!(unwrap instanceof SubtypingRepresentatives)) {
            unwrap = null;
        }
        SubtypingRepresentatives subtypingRepresentatives = (SubtypingRepresentatives) unwrap;
        if (!(subtypingRepresentatives != null ? subtypingRepresentatives.sameTypeConstructor(kotlinType2) : false)) {
            UnwrappedType unwrap2 = kotlinType2.unwrap();
            if (!(unwrap2 instanceof SubtypingRepresentatives)) {
                unwrap2 = null;
            }
            SubtypingRepresentatives subtypingRepresentatives2 = (SubtypingRepresentatives) unwrap2;
            if (subtypingRepresentatives2 != null ? subtypingRepresentatives2.sameTypeConstructor(kotlinType) : false) {
                return true;
            }
            return false;
        }
        return true;
    }
}
