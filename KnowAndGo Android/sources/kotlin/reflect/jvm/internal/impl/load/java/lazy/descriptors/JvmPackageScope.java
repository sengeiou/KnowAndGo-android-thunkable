package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.UtilsKt;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPackage;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageKt;
import kotlin.reflect.jvm.internal.impl.util.collectionUtils.ScopeUtilsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p024io.nlopez.smartlocation.geofencing.providers.GeofencingGooglePlayServicesProvider;

/* compiled from: JvmPackageScope.kt */
public final class JvmPackageScope implements MemberScope {
    static final /* synthetic */ KProperty[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(JvmPackageScope.class), "kotlinScopes", "getKotlinScopes()Ljava/util/List;"))};
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final LazyJavaResolverContext f2981c;
    @NotNull
    private final LazyJavaPackageScope javaScope;
    private final NotNullLazyValue kotlinScopes$delegate = this.f2981c.getStorageManager().createLazyValue(new JvmPackageScope$kotlinScopes$2(this));
    /* access modifiers changed from: private */
    public final LazyJavaPackageFragment packageFragment;

    private final List<MemberScope> getKotlinScopes() {
        return (List) StorageKt.getValue(this.kotlinScopes$delegate, (Object) this, (KProperty<?>) $$delegatedProperties[0]);
    }

    public JvmPackageScope(@NotNull LazyJavaResolverContext lazyJavaResolverContext, @NotNull JavaPackage javaPackage, @NotNull LazyJavaPackageFragment lazyJavaPackageFragment) {
        Intrinsics.checkParameterIsNotNull(lazyJavaResolverContext, "c");
        Intrinsics.checkParameterIsNotNull(javaPackage, "jPackage");
        Intrinsics.checkParameterIsNotNull(lazyJavaPackageFragment, "packageFragment");
        this.f2981c = lazyJavaResolverContext;
        this.packageFragment = lazyJavaPackageFragment;
        this.javaScope = new LazyJavaPackageScope(this.f2981c, javaPackage, this.packageFragment);
    }

    @NotNull
    public final LazyJavaPackageScope getJavaScope$descriptors_jvm() {
        return this.javaScope;
    }

    @Nullable
    public ClassifierDescriptor getContributedClassifier(@NotNull Name name, @NotNull LookupLocation lookupLocation) {
        Intrinsics.checkParameterIsNotNull(name, "name");
        Intrinsics.checkParameterIsNotNull(lookupLocation, GeofencingGooglePlayServicesProvider.LOCATION_EXTRA_ID);
        recordLookup(name, lookupLocation);
        ClassDescriptor contributedClassifier = this.javaScope.getContributedClassifier(name, lookupLocation);
        if (contributedClassifier != null) {
            return contributedClassifier;
        }
        ClassifierDescriptor classifierDescriptor = null;
        for (MemberScope contributedClassifier2 : getKotlinScopes()) {
            ClassifierDescriptor contributedClassifier3 = contributedClassifier2.getContributedClassifier(name, lookupLocation);
            if (contributedClassifier3 != null) {
                if (!(contributedClassifier3 instanceof ClassifierDescriptorWithTypeParameters) || !((ClassifierDescriptorWithTypeParameters) contributedClassifier3).isExpect()) {
                    return contributedClassifier3;
                }
                if (classifierDescriptor == null) {
                    classifierDescriptor = contributedClassifier3;
                }
            }
        }
        return classifierDescriptor;
    }

    @NotNull
    public Collection<PropertyDescriptor> getContributedVariables(@NotNull Name name, @NotNull LookupLocation lookupLocation) {
        Intrinsics.checkParameterIsNotNull(name, "name");
        Intrinsics.checkParameterIsNotNull(lookupLocation, GeofencingGooglePlayServicesProvider.LOCATION_EXTRA_ID);
        recordLookup(name, lookupLocation);
        LazyJavaPackageScope lazyJavaPackageScope = this.javaScope;
        List<MemberScope> kotlinScopes = getKotlinScopes();
        Collection contributedVariables = lazyJavaPackageScope.getContributedVariables(name, lookupLocation);
        for (MemberScope contributedVariables2 : kotlinScopes) {
            contributedVariables = ScopeUtilsKt.concat(contributedVariables, contributedVariables2.getContributedVariables(name, lookupLocation));
        }
        return contributedVariables != null ? contributedVariables : SetsKt.emptySet();
    }

    @NotNull
    public Collection<SimpleFunctionDescriptor> getContributedFunctions(@NotNull Name name, @NotNull LookupLocation lookupLocation) {
        Intrinsics.checkParameterIsNotNull(name, "name");
        Intrinsics.checkParameterIsNotNull(lookupLocation, GeofencingGooglePlayServicesProvider.LOCATION_EXTRA_ID);
        recordLookup(name, lookupLocation);
        LazyJavaPackageScope lazyJavaPackageScope = this.javaScope;
        List<MemberScope> kotlinScopes = getKotlinScopes();
        Collection contributedFunctions = lazyJavaPackageScope.getContributedFunctions(name, lookupLocation);
        for (MemberScope contributedFunctions2 : kotlinScopes) {
            contributedFunctions = ScopeUtilsKt.concat(contributedFunctions, contributedFunctions2.getContributedFunctions(name, lookupLocation));
        }
        return contributedFunctions != null ? contributedFunctions : SetsKt.emptySet();
    }

    /* JADX WARNING: type inference failed for: r5v0, types: [java.lang.Object, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1<? super kotlin.reflect.jvm.internal.impl.name.Name, java.lang.Boolean>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor> getContributedDescriptors(@org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter r4, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super kotlin.reflect.jvm.internal.impl.name.Name, java.lang.Boolean> r5) {
        /*
            r3 = this;
            java.lang.String r0 = "kindFilter"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r4, r0)
            java.lang.String r0 = "nameFilter"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r5, r0)
            kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageScope r0 = r3.javaScope
            java.util.List r1 = r3.getKotlinScopes()
            kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope r0 = (kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope) r0
            java.util.Collection r0 = r0.getContributedDescriptors(r4, r5)
            java.util.Iterator r1 = r1.iterator()
        L_0x001a:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x002f
            java.lang.Object r2 = r1.next()
            kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope r2 = (kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope) r2
            java.util.Collection r2 = r2.getContributedDescriptors(r4, r5)
            java.util.Collection r0 = kotlin.reflect.jvm.internal.impl.util.collectionUtils.ScopeUtilsKt.concat(r0, r2)
            goto L_0x001a
        L_0x002f:
            if (r0 == 0) goto L_0x0032
            goto L_0x0039
        L_0x0032:
            java.util.Set r4 = kotlin.collections.SetsKt.emptySet()
            r0 = r4
            java.util.Collection r0 = (java.util.Collection) r0
        L_0x0039:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.JvmPackageScope.getContributedDescriptors(kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter, kotlin.jvm.functions.Function1):java.util.Collection");
    }

    @NotNull
    public Set<Name> getFunctionNames() {
        Collection linkedHashSet = new LinkedHashSet();
        for (MemberScope functionNames : getKotlinScopes()) {
            CollectionsKt.addAll(linkedHashSet, functionNames.getFunctionNames());
        }
        Set<Name> set = (Set) linkedHashSet;
        set.addAll(this.javaScope.getFunctionNames());
        return set;
    }

    @NotNull
    public Set<Name> getVariableNames() {
        Collection linkedHashSet = new LinkedHashSet();
        for (MemberScope variableNames : getKotlinScopes()) {
            CollectionsKt.addAll(linkedHashSet, variableNames.getVariableNames());
        }
        Set<Name> set = (Set) linkedHashSet;
        set.addAll(this.javaScope.getVariableNames());
        return set;
    }

    public void recordLookup(@NotNull Name name, @NotNull LookupLocation lookupLocation) {
        Intrinsics.checkParameterIsNotNull(name, "name");
        Intrinsics.checkParameterIsNotNull(lookupLocation, GeofencingGooglePlayServicesProvider.LOCATION_EXTRA_ID);
        UtilsKt.record(this.f2981c.getComponents().getLookupTracker(), lookupLocation, (PackageFragmentDescriptor) this.packageFragment, name);
    }
}
