package kotlin.reflect.jvm.internal.impl.resolve.jvm;

import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.InlineClassesUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: inlineClassManglingRules.kt */
public final class InlineClassManglingRulesKt {
    public static final boolean shouldHideConstructorDueToInlineClassTypeValueParameters(@NotNull CallableMemberDescriptor callableMemberDescriptor) {
        Intrinsics.checkParameterIsNotNull(callableMemberDescriptor, "descriptor");
        if (!(callableMemberDescriptor instanceof ClassConstructorDescriptor)) {
            callableMemberDescriptor = null;
        }
        ClassConstructorDescriptor classConstructorDescriptor = (ClassConstructorDescriptor) callableMemberDescriptor;
        if (classConstructorDescriptor == null || Visibilities.isPrivate(classConstructorDescriptor.getVisibility())) {
            return false;
        }
        ClassDescriptor constructedClass = classConstructorDescriptor.getConstructedClass();
        Intrinsics.checkExpressionValueIsNotNull(constructedClass, "constructorDescriptor.constructedClass");
        if (constructedClass.isInline() || DescriptorUtils.isSealedClass(classConstructorDescriptor.getConstructedClass())) {
            return false;
        }
        List<ValueParameterDescriptor> valueParameters = classConstructorDescriptor.getValueParameters();
        Intrinsics.checkExpressionValueIsNotNull(valueParameters, "constructorDescriptor.valueParameters");
        Iterable<ValueParameterDescriptor> iterable = valueParameters;
        if ((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) {
            return false;
        }
        for (ValueParameterDescriptor valueParameterDescriptor : iterable) {
            Intrinsics.checkExpressionValueIsNotNull(valueParameterDescriptor, "it");
            KotlinType type = valueParameterDescriptor.getType();
            Intrinsics.checkExpressionValueIsNotNull(type, "it.type");
            if (requiresFunctionNameMangling(type)) {
                return true;
            }
        }
        return false;
    }

    public static final boolean isInlineClassThatRequiresMangling(@NotNull DeclarationDescriptor declarationDescriptor) {
        Intrinsics.checkParameterIsNotNull(declarationDescriptor, "$this$isInlineClassThatRequiresMangling");
        return InlineClassesUtilsKt.isInlineClass(declarationDescriptor) && !isDontMangleClass((ClassDescriptor) declarationDescriptor);
    }

    public static final boolean isInlineClassThatRequiresMangling(@NotNull KotlinType kotlinType) {
        Intrinsics.checkParameterIsNotNull(kotlinType, "$this$isInlineClassThatRequiresMangling");
        ClassifierDescriptor declarationDescriptor = kotlinType.getConstructor().getDeclarationDescriptor();
        return declarationDescriptor != null && isInlineClassThatRequiresMangling((DeclarationDescriptor) declarationDescriptor);
    }

    private static final boolean requiresFunctionNameMangling(@NotNull KotlinType kotlinType) {
        return isInlineClassThatRequiresMangling(kotlinType) || isTypeParameterWithUpperBoundThatRequiresMangling(kotlinType);
    }

    private static final boolean isDontMangleClass(ClassDescriptor classDescriptor) {
        return Intrinsics.areEqual((Object) DescriptorUtilsKt.getFqNameSafe(classDescriptor), (Object) DescriptorUtils.RESULT_FQ_NAME);
    }

    private static final boolean isTypeParameterWithUpperBoundThatRequiresMangling(@NotNull KotlinType kotlinType) {
        ClassifierDescriptor declarationDescriptor = kotlinType.getConstructor().getDeclarationDescriptor();
        if (!(declarationDescriptor instanceof TypeParameterDescriptor)) {
            declarationDescriptor = null;
        }
        TypeParameterDescriptor typeParameterDescriptor = (TypeParameterDescriptor) declarationDescriptor;
        if (typeParameterDescriptor != null) {
            return requiresFunctionNameMangling(TypeUtilsKt.getRepresentativeUpperBound(typeParameterDescriptor));
        }
        return false;
    }
}
