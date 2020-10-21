package kotlin.reflect.jvm.internal.impl.resolve.constants;

import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeKt;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: constantValues.kt */
public final class KClassValue extends ConstantValue<Value> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* compiled from: constantValues.kt */
    public static abstract class Value {

        /* compiled from: constantValues.kt */
        public static final class NormalClass extends Value {
            @NotNull
            private final ClassLiteralValue value;

            public boolean equals(@Nullable Object obj) {
                if (this != obj) {
                    return (obj instanceof NormalClass) && Intrinsics.areEqual((Object) this.value, (Object) ((NormalClass) obj).value);
                }
                return true;
            }

            public int hashCode() {
                ClassLiteralValue classLiteralValue = this.value;
                if (classLiteralValue != null) {
                    return classLiteralValue.hashCode();
                }
                return 0;
            }

            @NotNull
            public String toString() {
                return "NormalClass(value=" + this.value + ")";
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public NormalClass(@NotNull ClassLiteralValue classLiteralValue) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkParameterIsNotNull(classLiteralValue, "value");
                this.value = classLiteralValue;
            }

            @NotNull
            public final ClassLiteralValue getValue() {
                return this.value;
            }

            @NotNull
            public final ClassId getClassId() {
                return this.value.getClassId();
            }

            public final int getArrayDimensions() {
                return this.value.getArrayNestedness();
            }
        }

        private Value() {
        }

        public /* synthetic */ Value(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* compiled from: constantValues.kt */
        public static final class LocalClass extends Value {
            @NotNull
            private final KotlinType type;

            public boolean equals(@Nullable Object obj) {
                if (this != obj) {
                    return (obj instanceof LocalClass) && Intrinsics.areEqual((Object) this.type, (Object) ((LocalClass) obj).type);
                }
                return true;
            }

            public int hashCode() {
                KotlinType kotlinType = this.type;
                if (kotlinType != null) {
                    return kotlinType.hashCode();
                }
                return 0;
            }

            @NotNull
            public String toString() {
                return "LocalClass(type=" + this.type + ")";
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public LocalClass(@NotNull KotlinType kotlinType) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkParameterIsNotNull(kotlinType, "type");
                this.type = kotlinType;
            }

            @NotNull
            public final KotlinType getType() {
                return this.type;
            }
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public KClassValue(@NotNull Value value) {
        super(value);
        Intrinsics.checkParameterIsNotNull(value, "value");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public KClassValue(@NotNull ClassLiteralValue classLiteralValue) {
        this((Value) new Value.NormalClass(classLiteralValue));
        Intrinsics.checkParameterIsNotNull(classLiteralValue, "value");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public KClassValue(@NotNull ClassId classId, int i) {
        this(new ClassLiteralValue(classId, i));
        Intrinsics.checkParameterIsNotNull(classId, "classId");
    }

    @NotNull
    public KotlinType getType(@NotNull ModuleDescriptor moduleDescriptor) {
        Intrinsics.checkParameterIsNotNull(moduleDescriptor, "module");
        Annotations empty = Annotations.Companion.getEMPTY();
        ClassDescriptor kClass = moduleDescriptor.getBuiltIns().getKClass();
        Intrinsics.checkExpressionValueIsNotNull(kClass, "module.builtIns.kClass");
        return KotlinTypeFactory.simpleNotNullType(empty, kClass, CollectionsKt.listOf(new TypeProjectionImpl(getArgumentType(moduleDescriptor))));
    }

    @NotNull
    public final KotlinType getArgumentType(@NotNull ModuleDescriptor moduleDescriptor) {
        Intrinsics.checkParameterIsNotNull(moduleDescriptor, "module");
        Value value = (Value) getValue();
        if (value instanceof Value.LocalClass) {
            return ((Value.LocalClass) getValue()).getType();
        }
        if (value instanceof Value.NormalClass) {
            ClassLiteralValue value2 = ((Value.NormalClass) getValue()).getValue();
            ClassId component1 = value2.component1();
            int component2 = value2.component2();
            ClassDescriptor findClassAcrossModuleDependencies = FindClassInModuleKt.findClassAcrossModuleDependencies(moduleDescriptor, component1);
            if (findClassAcrossModuleDependencies != null) {
                SimpleType defaultType = findClassAcrossModuleDependencies.getDefaultType();
                Intrinsics.checkExpressionValueIsNotNull(defaultType, "descriptor.defaultType");
                KotlinType replaceArgumentsWithStarProjections = TypeUtilsKt.replaceArgumentsWithStarProjections(defaultType);
                for (int i = 0; i < component2; i++) {
                    SimpleType arrayType = moduleDescriptor.getBuiltIns().getArrayType(Variance.INVARIANT, replaceArgumentsWithStarProjections);
                    Intrinsics.checkExpressionValueIsNotNull(arrayType, "module.builtIns.getArray…Variance.INVARIANT, type)");
                    replaceArgumentsWithStarProjections = arrayType;
                }
                return replaceArgumentsWithStarProjections;
            }
            SimpleType createErrorType = ErrorUtils.createErrorType("Unresolved type: " + component1 + " (arrayDimensions=" + component2 + ')');
            Intrinsics.checkExpressionValueIsNotNull(createErrorType, "ErrorUtils.createErrorTy…sions=$arrayDimensions)\")");
            return createErrorType;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* compiled from: constantValues.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public final ConstantValue<?> create(@NotNull KotlinType kotlinType) {
            Intrinsics.checkParameterIsNotNull(kotlinType, "argumentType");
            if (KotlinTypeKt.isError(kotlinType)) {
                return null;
            }
            KotlinType kotlinType2 = kotlinType;
            int i = 0;
            while (KotlinBuiltIns.isArray(kotlinType2)) {
                kotlinType2 = ((TypeProjection) CollectionsKt.single(kotlinType2.getArguments())).getType();
                Intrinsics.checkExpressionValueIsNotNull(kotlinType2, "type.arguments.single().type");
                i++;
            }
            ClassifierDescriptor declarationDescriptor = kotlinType2.getConstructor().getDeclarationDescriptor();
            if (declarationDescriptor instanceof ClassDescriptor) {
                ClassId classId = DescriptorUtilsKt.getClassId(declarationDescriptor);
                if (classId != null) {
                    return new KClassValue(classId, i);
                }
                return new KClassValue((Value) new Value.LocalClass(kotlinType));
            } else if (!(declarationDescriptor instanceof TypeParameterDescriptor)) {
                return null;
            } else {
                ClassId classId2 = ClassId.topLevel(KotlinBuiltIns.FQ_NAMES.any.toSafe());
                Intrinsics.checkExpressionValueIsNotNull(classId2, "ClassId.topLevel(KotlinB…ns.FQ_NAMES.any.toSafe())");
                return new KClassValue(classId2, 0);
            }
        }
    }
}
