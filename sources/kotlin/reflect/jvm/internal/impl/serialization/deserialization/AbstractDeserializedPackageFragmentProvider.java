package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: AbstractDeserializedPackageFragmentProvider.kt */
public abstract class AbstractDeserializedPackageFragmentProvider implements PackageFragmentProvider {
    @NotNull
    protected DeserializationComponents components;
    @NotNull
    private final KotlinMetadataFinder finder;
    private final MemoizedFunctionToNullable<FqName, PackageFragmentDescriptor> fragments = this.storageManager.createMemoizedFunctionWithNullableValues(new AbstractDeserializedPackageFragmentProvider$fragments$1(this));
    @NotNull
    private final ModuleDescriptor moduleDescriptor;
    @NotNull
    private final StorageManager storageManager;

    /* access modifiers changed from: protected */
    @Nullable
    public abstract DeserializedPackageFragment findPackage(@NotNull FqName fqName);

    public AbstractDeserializedPackageFragmentProvider(@NotNull StorageManager storageManager2, @NotNull KotlinMetadataFinder kotlinMetadataFinder, @NotNull ModuleDescriptor moduleDescriptor2) {
        Intrinsics.checkParameterIsNotNull(storageManager2, "storageManager");
        Intrinsics.checkParameterIsNotNull(kotlinMetadataFinder, "finder");
        Intrinsics.checkParameterIsNotNull(moduleDescriptor2, "moduleDescriptor");
        this.storageManager = storageManager2;
        this.finder = kotlinMetadataFinder;
        this.moduleDescriptor = moduleDescriptor2;
    }

    /* access modifiers changed from: protected */
    @NotNull
    public final StorageManager getStorageManager() {
        return this.storageManager;
    }

    /* access modifiers changed from: protected */
    @NotNull
    public final KotlinMetadataFinder getFinder() {
        return this.finder;
    }

    /* access modifiers changed from: protected */
    @NotNull
    public final ModuleDescriptor getModuleDescriptor() {
        return this.moduleDescriptor;
    }

    /* access modifiers changed from: protected */
    @NotNull
    public final DeserializationComponents getComponents() {
        DeserializationComponents deserializationComponents = this.components;
        if (deserializationComponents == null) {
            Intrinsics.throwUninitializedPropertyAccessException("components");
        }
        return deserializationComponents;
    }

    /* access modifiers changed from: protected */
    public final void setComponents(@NotNull DeserializationComponents deserializationComponents) {
        Intrinsics.checkParameterIsNotNull(deserializationComponents, "<set-?>");
        this.components = deserializationComponents;
    }

    @NotNull
    public List<PackageFragmentDescriptor> getPackageFragments(@NotNull FqName fqName) {
        Intrinsics.checkParameterIsNotNull(fqName, "fqName");
        return CollectionsKt.listOfNotNull(this.fragments.invoke(fqName));
    }

    @NotNull
    public Collection<FqName> getSubPackagesOf(@NotNull FqName fqName, @NotNull Function1<? super Name, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(fqName, "fqName");
        Intrinsics.checkParameterIsNotNull(function1, "nameFilter");
        return SetsKt.emptySet();
    }
}
