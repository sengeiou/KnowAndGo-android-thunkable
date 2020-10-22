package kotlin.reflect.jvm.internal.impl.types;

import kotlin._Assertions;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: TypeSubstitution.kt */
public final class IndexedParametersSubstitution extends TypeSubstitution {
    private final boolean approximateCapturedTypes;
    @NotNull
    private final TypeProjection[] arguments;
    @NotNull
    private final TypeParameterDescriptor[] parameters;

    @NotNull
    public final TypeParameterDescriptor[] getParameters() {
        return this.parameters;
    }

    @NotNull
    public final TypeProjection[] getArguments() {
        return this.arguments;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ IndexedParametersSubstitution(TypeParameterDescriptor[] typeParameterDescriptorArr, TypeProjection[] typeProjectionArr, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(typeParameterDescriptorArr, typeProjectionArr, (i & 4) != 0 ? false : z);
    }

    public IndexedParametersSubstitution(@NotNull TypeParameterDescriptor[] typeParameterDescriptorArr, @NotNull TypeProjection[] typeProjectionArr, boolean z) {
        Intrinsics.checkParameterIsNotNull(typeParameterDescriptorArr, "parameters");
        Intrinsics.checkParameterIsNotNull(typeProjectionArr, "arguments");
        this.parameters = typeParameterDescriptorArr;
        this.arguments = typeProjectionArr;
        this.approximateCapturedTypes = z;
        boolean z2 = this.parameters.length <= this.arguments.length;
        if (_Assertions.ENABLED && !z2) {
            throw new AssertionError("Number of arguments should not be less then number of parameters, but: parameters=" + this.parameters.length + ", args=" + this.arguments.length);
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public IndexedParametersSubstitution(@org.jetbrains.annotations.NotNull java.util.List<? extends kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor> r8, @org.jetbrains.annotations.NotNull java.util.List<? extends kotlin.reflect.jvm.internal.impl.types.TypeProjection> r9) {
        /*
            r7 = this;
            java.lang.String r0 = "parameters"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r8, r0)
            java.lang.String r0 = "argumentsList"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r9, r0)
            java.util.Collection r8 = (java.util.Collection) r8
            r0 = 0
            kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor[] r1 = new kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor[r0]
            java.lang.Object[] r8 = r8.toArray(r1)
            if (r8 == 0) goto L_0x0035
            r2 = r8
            kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor[] r2 = (kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor[]) r2
            java.util.Collection r9 = (java.util.Collection) r9
            kotlin.reflect.jvm.internal.impl.types.TypeProjection[] r8 = new kotlin.reflect.jvm.internal.impl.types.TypeProjection[r0]
            java.lang.Object[] r8 = r9.toArray(r8)
            if (r8 == 0) goto L_0x002d
            r3 = r8
            kotlin.reflect.jvm.internal.impl.types.TypeProjection[] r3 = (kotlin.reflect.jvm.internal.impl.types.TypeProjection[]) r3
            r4 = 0
            r5 = 4
            r6 = 0
            r1 = r7
            r1.<init>(r2, r3, r4, r5, r6)
            return
        L_0x002d:
            kotlin.TypeCastException r8 = new kotlin.TypeCastException
            java.lang.String r9 = "null cannot be cast to non-null type kotlin.Array<T>"
            r8.<init>(r9)
            throw r8
        L_0x0035:
            kotlin.TypeCastException r8 = new kotlin.TypeCastException
            java.lang.String r9 = "null cannot be cast to non-null type kotlin.Array<T>"
            r8.<init>(r9)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.types.IndexedParametersSubstitution.<init>(java.util.List, java.util.List):void");
    }

    public boolean isEmpty() {
        return this.arguments.length == 0;
    }

    public boolean approximateContravariantCapturedTypes() {
        return this.approximateCapturedTypes;
    }

    @Nullable
    public TypeProjection get(@NotNull KotlinType kotlinType) {
        int index;
        Intrinsics.checkParameterIsNotNull(kotlinType, "key");
        ClassifierDescriptor declarationDescriptor = kotlinType.getConstructor().getDeclarationDescriptor();
        if (!(declarationDescriptor instanceof TypeParameterDescriptor)) {
            declarationDescriptor = null;
        }
        TypeParameterDescriptor typeParameterDescriptor = (TypeParameterDescriptor) declarationDescriptor;
        if (typeParameterDescriptor == null || (index = typeParameterDescriptor.getIndex()) >= this.parameters.length || !Intrinsics.areEqual((Object) this.parameters[index].getTypeConstructor(), (Object) typeParameterDescriptor.getTypeConstructor())) {
            return null;
        }
        return this.arguments[index];
    }
}
