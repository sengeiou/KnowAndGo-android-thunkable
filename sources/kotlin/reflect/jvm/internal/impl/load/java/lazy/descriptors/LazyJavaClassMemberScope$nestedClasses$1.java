package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.Map;
import java.util.Set;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassDescriptorBase;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.EnumEntrySyntheticClassDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.JavaClassFinder;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaAnnotationsKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaField;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: LazyJavaClassMemberScope.kt */
final class LazyJavaClassMemberScope$nestedClasses$1 extends Lambda implements Function1<Name, ClassDescriptorBase> {

    /* renamed from: $c */
    final /* synthetic */ LazyJavaResolverContext f2985$c;
    final /* synthetic */ LazyJavaClassMemberScope this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazyJavaClassMemberScope$nestedClasses$1(LazyJavaClassMemberScope lazyJavaClassMemberScope, LazyJavaResolverContext lazyJavaResolverContext) {
        super(1);
        this.this$0 = lazyJavaClassMemberScope;
        this.f2985$c = lazyJavaResolverContext;
    }

    @Nullable
    public final ClassDescriptorBase invoke(@NotNull Name name) {
        LazyJavaClassDescriptor lazyJavaClassDescriptor;
        Name name2 = name;
        Intrinsics.checkParameterIsNotNull(name2, "name");
        EnumEntrySyntheticClassDescriptor enumEntrySyntheticClassDescriptor = null;
        if (!((Set) this.this$0.nestedClassIndex.invoke()).contains(name2)) {
            JavaField javaField = (JavaField) ((Map) this.this$0.enumEntryIndex.invoke()).get(name2);
            if (javaField != null) {
                enumEntrySyntheticClassDescriptor = EnumEntrySyntheticClassDescriptor.create(this.f2985$c.getStorageManager(), this.this$0.getOwnerDescriptor(), name, this.f2985$c.getStorageManager().createLazyValue(new LazyJavaClassMemberScope$nestedClasses$1$enumMemberNames$1(this)), LazyJavaAnnotationsKt.resolveAnnotations(this.f2985$c, javaField), this.f2985$c.getComponents().getSourceElementFactory().source(javaField));
            }
            return enumEntrySyntheticClassDescriptor;
        }
        JavaClassFinder finder = this.f2985$c.getComponents().getFinder();
        ClassId classId = DescriptorUtilsKt.getClassId(this.this$0.getOwnerDescriptor());
        if (classId == null) {
            Intrinsics.throwNpe();
        }
        ClassId createNestedClassId = classId.createNestedClassId(name2);
        Intrinsics.checkExpressionValueIsNotNull(createNestedClassId, "ownerDescriptor.classId!…createNestedClassId(name)");
        JavaClass findClass = finder.findClass(new JavaClassFinder.Request(createNestedClassId, (byte[]) null, this.this$0.jClass, 2, (DefaultConstructorMarker) null));
        if (findClass != null) {
            lazyJavaClassDescriptor = new LazyJavaClassDescriptor(this.f2985$c, this.this$0.getOwnerDescriptor(), findClass, (ClassDescriptor) null, 8, (DefaultConstructorMarker) null);
            this.f2985$c.getComponents().getJavaClassesTracker().reportClass(lazyJavaClassDescriptor);
        } else {
            lazyJavaClassDescriptor = null;
        }
        return lazyJavaClassDescriptor;
    }
}
