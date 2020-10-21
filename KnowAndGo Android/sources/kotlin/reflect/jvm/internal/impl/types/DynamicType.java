package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions;
import kotlin.reflect.jvm.internal.impl.types.model.DynamicTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: dynamicTypes.kt */
public final class DynamicType extends FlexibleType implements DynamicTypeMarker {
    @NotNull
    private final Annotations annotations;

    public boolean isMarkedNullable() {
        return false;
    }

    @NotNull
    public DynamicType makeNullableAsSpecified(boolean z) {
        return this;
    }

    @NotNull
    public String render(@NotNull DescriptorRenderer descriptorRenderer, @NotNull DescriptorRendererOptions descriptorRendererOptions) {
        Intrinsics.checkParameterIsNotNull(descriptorRenderer, "renderer");
        Intrinsics.checkParameterIsNotNull(descriptorRendererOptions, "options");
        return "dynamic";
    }

    @NotNull
    public Annotations getAnnotations() {
        return this.annotations;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public DynamicType(@org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns r3, @org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations r4) {
        /*
            r2 = this;
            java.lang.String r0 = "builtIns"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r3, r0)
            java.lang.String r0 = "annotations"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r4, r0)
            kotlin.reflect.jvm.internal.impl.types.SimpleType r0 = r3.getNothingType()
            java.lang.String r1 = "builtIns.nothingType"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)
            kotlin.reflect.jvm.internal.impl.types.SimpleType r3 = r3.getNullableAnyType()
            java.lang.String r1 = "builtIns.nullableAnyType"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r3, r1)
            r2.<init>(r0, r3)
            r2.annotations = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.types.DynamicType.<init>(kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns, kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations):void");
    }

    @NotNull
    public SimpleType getDelegate() {
        return getUpperBound();
    }

    @NotNull
    public DynamicType replaceAnnotations(@NotNull Annotations annotations2) {
        Intrinsics.checkParameterIsNotNull(annotations2, "newAnnotations");
        return new DynamicType(TypeUtilsKt.getBuiltIns(getDelegate()), annotations2);
    }
}
