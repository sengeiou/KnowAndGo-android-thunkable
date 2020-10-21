package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractLazyTypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaAnnotations;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeResolverKt;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameter;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.jetbrains.annotations.NotNull;

/* compiled from: LazyJavaTypeParameterDescriptor.kt */
public final class LazyJavaTypeParameterDescriptor extends AbstractLazyTypeParameterDescriptor {
    @NotNull
    private final LazyJavaAnnotations annotations = new LazyJavaAnnotations(this.f2990c, this.javaTypeParameter);

    /* renamed from: c */
    private final LazyJavaResolverContext f2990c;
    @NotNull
    private final JavaTypeParameter javaTypeParameter;

    /* access modifiers changed from: protected */
    public void reportSupertypeLoopError(@NotNull KotlinType kotlinType) {
        Intrinsics.checkParameterIsNotNull(kotlinType, "type");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LazyJavaTypeParameterDescriptor(@NotNull LazyJavaResolverContext lazyJavaResolverContext, @NotNull JavaTypeParameter javaTypeParameter2, int i, @NotNull DeclarationDescriptor declarationDescriptor) {
        super(lazyJavaResolverContext.getStorageManager(), declarationDescriptor, javaTypeParameter2.getName(), Variance.INVARIANT, false, i, SourceElement.NO_SOURCE, lazyJavaResolverContext.getComponents().getSupertypeLoopChecker());
        Intrinsics.checkParameterIsNotNull(lazyJavaResolverContext, "c");
        Intrinsics.checkParameterIsNotNull(javaTypeParameter2, "javaTypeParameter");
        Intrinsics.checkParameterIsNotNull(declarationDescriptor, "containingDeclaration");
        this.f2990c = lazyJavaResolverContext;
        this.javaTypeParameter = javaTypeParameter2;
    }

    @NotNull
    public LazyJavaAnnotations getAnnotations() {
        return this.annotations;
    }

    /* access modifiers changed from: protected */
    @NotNull
    public List<KotlinType> resolveUpperBounds() {
        Collection<JavaClassifierType> upperBounds = this.javaTypeParameter.getUpperBounds();
        if (upperBounds.isEmpty()) {
            SimpleType anyType = this.f2990c.getModule().getBuiltIns().getAnyType();
            Intrinsics.checkExpressionValueIsNotNull(anyType, "c.module.builtIns.anyType");
            SimpleType nullableAnyType = this.f2990c.getModule().getBuiltIns().getNullableAnyType();
            Intrinsics.checkExpressionValueIsNotNull(nullableAnyType, "c.module.builtIns.nullableAnyType");
            return CollectionsKt.listOf(KotlinTypeFactory.flexibleType(anyType, nullableAnyType));
        }
        Iterable<JavaClassifierType> iterable = upperBounds;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (JavaClassifierType transformJavaType : iterable) {
            arrayList.add(this.f2990c.getTypeResolver().transformJavaType(transformJavaType, JavaTypeResolverKt.toAttributes$default(TypeUsage.COMMON, false, this, 1, (Object) null)));
        }
        return (List) arrayList;
    }
}
