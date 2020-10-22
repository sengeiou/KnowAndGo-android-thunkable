package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin._Assertions;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.sequences.SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: typeParameterUtils.kt */
public final class TypeParameterUtilsKt {
    @NotNull
    public static final List<TypeParameterDescriptor> computeConstructorTypeParameters(@NotNull ClassifierDescriptorWithTypeParameters classifierDescriptorWithTypeParameters) {
        List<TypeParameterDescriptor> list;
        DeclarationDescriptor declarationDescriptor;
        TypeConstructor typeConstructor;
        Intrinsics.checkParameterIsNotNull(classifierDescriptorWithTypeParameters, "$this$computeConstructorTypeParameters");
        List<TypeParameterDescriptor> declaredTypeParameters = classifierDescriptorWithTypeParameters.getDeclaredTypeParameters();
        Intrinsics.checkExpressionValueIsNotNull(declaredTypeParameters, "declaredTypeParameters");
        if (!classifierDescriptorWithTypeParameters.isInner() && !(classifierDescriptorWithTypeParameters.getContainingDeclaration() instanceof CallableDescriptor)) {
            return declaredTypeParameters;
        }
        DeclarationDescriptor declarationDescriptor2 = classifierDescriptorWithTypeParameters;
        List<R> list2 = SequencesKt.toList(SequencesKt.flatMap(SequencesKt.takeWhile(DescriptorUtilsKt.getParents(declarationDescriptor2), C3642x246a49e2.INSTANCE), C3643x246a49e3.INSTANCE));
        Iterator<DeclarationDescriptor> it = DescriptorUtilsKt.getParents(declarationDescriptor2).iterator();
        while (true) {
            list = null;
            if (!it.hasNext()) {
                declarationDescriptor = null;
                break;
            }
            declarationDescriptor = it.next();
            if (declarationDescriptor instanceof ClassDescriptor) {
                break;
            }
        }
        ClassDescriptor classDescriptor = (ClassDescriptor) declarationDescriptor;
        if (!(classDescriptor == null || (typeConstructor = classDescriptor.getTypeConstructor()) == null)) {
            list = typeConstructor.getParameters();
        }
        if (list == null) {
            list = CollectionsKt.emptyList();
        }
        if (!list2.isEmpty() || !list.isEmpty()) {
            Iterable<TypeParameterDescriptor> plus = CollectionsKt.plus(list2, list);
            Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(plus, 10));
            for (TypeParameterDescriptor typeParameterDescriptor : plus) {
                Intrinsics.checkExpressionValueIsNotNull(typeParameterDescriptor, "it");
                arrayList.add(capturedCopyForInnerDeclaration(typeParameterDescriptor, declarationDescriptor2, declaredTypeParameters.size()));
            }
            return CollectionsKt.plus(declaredTypeParameters, (List) arrayList);
        }
        List<TypeParameterDescriptor> declaredTypeParameters2 = classifierDescriptorWithTypeParameters.getDeclaredTypeParameters();
        Intrinsics.checkExpressionValueIsNotNull(declaredTypeParameters2, "declaredTypeParameters");
        return declaredTypeParameters2;
    }

    private static final CapturedTypeParameterDescriptor capturedCopyForInnerDeclaration(@NotNull TypeParameterDescriptor typeParameterDescriptor, DeclarationDescriptor declarationDescriptor, int i) {
        return new CapturedTypeParameterDescriptor(typeParameterDescriptor, declarationDescriptor, i);
    }

    @Nullable
    public static final PossiblyInnerType buildPossiblyInnerType(@NotNull KotlinType kotlinType) {
        Intrinsics.checkParameterIsNotNull(kotlinType, "$this$buildPossiblyInnerType");
        ClassifierDescriptor declarationDescriptor = kotlinType.getConstructor().getDeclarationDescriptor();
        if (!(declarationDescriptor instanceof ClassifierDescriptorWithTypeParameters)) {
            declarationDescriptor = null;
        }
        return buildPossiblyInnerType(kotlinType, (ClassifierDescriptorWithTypeParameters) declarationDescriptor, 0);
    }

    private static final PossiblyInnerType buildPossiblyInnerType(@NotNull KotlinType kotlinType, ClassifierDescriptorWithTypeParameters classifierDescriptorWithTypeParameters, int i) {
        ClassifierDescriptorWithTypeParameters classifierDescriptorWithTypeParameters2 = null;
        if (classifierDescriptorWithTypeParameters != null) {
            DeclarationDescriptor declarationDescriptor = classifierDescriptorWithTypeParameters;
            if (!ErrorUtils.isError(declarationDescriptor)) {
                int size = classifierDescriptorWithTypeParameters.getDeclaredTypeParameters().size() + i;
                if (!classifierDescriptorWithTypeParameters.isInner()) {
                    boolean z = size == kotlinType.getArguments().size() || DescriptorUtils.isLocal(declarationDescriptor);
                    if (!_Assertions.ENABLED || z) {
                        return new PossiblyInnerType(classifierDescriptorWithTypeParameters, kotlinType.getArguments().subList(i, kotlinType.getArguments().size()), (PossiblyInnerType) null);
                    }
                    throw new AssertionError((kotlinType.getArguments().size() - size) + " trailing arguments were found in " + kotlinType + " type");
                }
                List<TypeProjection> subList = kotlinType.getArguments().subList(i, size);
                DeclarationDescriptor containingDeclaration = classifierDescriptorWithTypeParameters.getContainingDeclaration();
                if (containingDeclaration instanceof ClassifierDescriptorWithTypeParameters) {
                    classifierDescriptorWithTypeParameters2 = containingDeclaration;
                }
                return new PossiblyInnerType(classifierDescriptorWithTypeParameters, subList, buildPossiblyInnerType(kotlinType, classifierDescriptorWithTypeParameters2, size));
            }
        }
        return null;
    }
}
