package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterUtilsKt;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractTypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.TypeAliasConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirement;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirementTable;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeKt;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutionKt;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: DeserializedMemberDescriptor.kt */
public final class DeserializedTypeAliasDescriptor extends AbstractTypeAliasDescriptor implements DeserializedMemberDescriptor {
    @NotNull
    private Collection<? extends TypeAliasConstructorDescriptor> constructors;
    @Nullable
    private final DeserializedContainerSource containerSource;
    @NotNull
    private DeserializedMemberDescriptor.CoroutinesCompatibilityMode coroutinesExperimentalCompatibilityMode = DeserializedMemberDescriptor.CoroutinesCompatibilityMode.COMPATIBLE;
    private SimpleType defaultTypeImpl;
    @NotNull
    private SimpleType expandedType;
    @NotNull
    private final NameResolver nameResolver;
    @NotNull
    private final ProtoBuf.TypeAlias proto;
    @NotNull
    private final StorageManager storageManager;
    private List<? extends TypeParameterDescriptor> typeConstructorParameters;
    @NotNull
    private final TypeTable typeTable;
    @NotNull
    private SimpleType underlyingType;
    @NotNull
    private final VersionRequirementTable versionRequirementTable;

    @NotNull
    public List<VersionRequirement> getVersionRequirements() {
        return DeserializedMemberDescriptor.DefaultImpls.getVersionRequirements(this);
    }

    /* access modifiers changed from: protected */
    @NotNull
    public StorageManager getStorageManager() {
        return this.storageManager;
    }

    @NotNull
    public ProtoBuf.TypeAlias getProto() {
        return this.proto;
    }

    @NotNull
    public NameResolver getNameResolver() {
        return this.nameResolver;
    }

    @NotNull
    public TypeTable getTypeTable() {
        return this.typeTable;
    }

    @NotNull
    public VersionRequirementTable getVersionRequirementTable() {
        return this.versionRequirementTable;
    }

    @Nullable
    public DeserializedContainerSource getContainerSource() {
        return this.containerSource;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public DeserializedTypeAliasDescriptor(@org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.storage.StorageManager r13, @org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r14, @org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations r15, @org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.name.Name r16, @org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.descriptors.Visibility r17, @org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeAlias r18, @org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver r19, @org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable r20, @org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirementTable r21, @org.jetbrains.annotations.Nullable kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerSource r22) {
        /*
            r12 = this;
            r6 = r12
            r7 = r13
            r8 = r18
            r9 = r19
            r10 = r20
            r11 = r21
            java.lang.String r0 = "storageManager"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r13, r0)
            java.lang.String r0 = "containingDeclaration"
            r1 = r14
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r14, r0)
            java.lang.String r0 = "annotations"
            r2 = r15
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r15, r0)
            java.lang.String r0 = "name"
            r3 = r16
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r3, r0)
            java.lang.String r0 = "visibility"
            r5 = r17
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r5, r0)
            java.lang.String r0 = "proto"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r8, r0)
            java.lang.String r0 = "nameResolver"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r9, r0)
            java.lang.String r0 = "typeTable"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r10, r0)
            java.lang.String r0 = "versionRequirementTable"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r11, r0)
            kotlin.reflect.jvm.internal.impl.descriptors.SourceElement r4 = kotlin.reflect.jvm.internal.impl.descriptors.SourceElement.NO_SOURCE
            java.lang.String r0 = "SourceElement.NO_SOURCE"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r4, r0)
            r0 = r12
            r0.<init>(r1, r2, r3, r4, r5)
            r6.storageManager = r7
            r6.proto = r8
            r6.nameResolver = r9
            r6.typeTable = r10
            r6.versionRequirementTable = r11
            r0 = r22
            r6.containerSource = r0
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor$CoroutinesCompatibilityMode r0 = kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor.CoroutinesCompatibilityMode.COMPATIBLE
            r6.coroutinesExperimentalCompatibilityMode = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedTypeAliasDescriptor.<init>(kotlin.reflect.jvm.internal.impl.storage.StorageManager, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations, kotlin.reflect.jvm.internal.impl.name.Name, kotlin.reflect.jvm.internal.impl.descriptors.Visibility, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeAlias, kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver, kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable, kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirementTable, kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerSource):void");
    }

    @NotNull
    public SimpleType getUnderlyingType() {
        SimpleType simpleType = this.underlyingType;
        if (simpleType == null) {
            Intrinsics.throwUninitializedPropertyAccessException("underlyingType");
        }
        return simpleType;
    }

    @NotNull
    public SimpleType getExpandedType() {
        SimpleType simpleType = this.expandedType;
        if (simpleType == null) {
            Intrinsics.throwUninitializedPropertyAccessException("expandedType");
        }
        return simpleType;
    }

    @NotNull
    public DeserializedMemberDescriptor.CoroutinesCompatibilityMode getCoroutinesExperimentalCompatibilityMode() {
        return this.coroutinesExperimentalCompatibilityMode;
    }

    public final void initialize(@NotNull List<? extends TypeParameterDescriptor> list, @NotNull SimpleType simpleType, @NotNull SimpleType simpleType2, @NotNull DeserializedMemberDescriptor.CoroutinesCompatibilityMode coroutinesCompatibilityMode) {
        Intrinsics.checkParameterIsNotNull(list, "declaredTypeParameters");
        Intrinsics.checkParameterIsNotNull(simpleType, "underlyingType");
        Intrinsics.checkParameterIsNotNull(simpleType2, "expandedType");
        Intrinsics.checkParameterIsNotNull(coroutinesCompatibilityMode, "isExperimentalCoroutineInReleaseEnvironment");
        initialize(list);
        this.underlyingType = simpleType;
        this.expandedType = simpleType2;
        this.typeConstructorParameters = TypeParameterUtilsKt.computeConstructorTypeParameters(this);
        this.defaultTypeImpl = computeDefaultType();
        this.constructors = getTypeAliasConstructors();
        this.coroutinesExperimentalCompatibilityMode = coroutinesCompatibilityMode;
    }

    @Nullable
    public ClassDescriptor getClassDescriptor() {
        if (KotlinTypeKt.isError(getExpandedType())) {
            return null;
        }
        ClassifierDescriptor declarationDescriptor = getExpandedType().getConstructor().getDeclarationDescriptor();
        if (!(declarationDescriptor instanceof ClassDescriptor)) {
            declarationDescriptor = null;
        }
        return (ClassDescriptor) declarationDescriptor;
    }

    @NotNull
    public SimpleType getDefaultType() {
        SimpleType simpleType = this.defaultTypeImpl;
        if (simpleType == null) {
            Intrinsics.throwUninitializedPropertyAccessException("defaultTypeImpl");
        }
        return simpleType;
    }

    @NotNull
    public TypeAliasDescriptor substitute(@NotNull TypeSubstitutor typeSubstitutor) {
        Intrinsics.checkParameterIsNotNull(typeSubstitutor, "substitutor");
        if (typeSubstitutor.isEmpty()) {
            return this;
        }
        StorageManager storageManager2 = getStorageManager();
        DeclarationDescriptor containingDeclaration = getContainingDeclaration();
        Intrinsics.checkExpressionValueIsNotNull(containingDeclaration, "containingDeclaration");
        Annotations annotations = getAnnotations();
        Intrinsics.checkExpressionValueIsNotNull(annotations, "annotations");
        Name name = getName();
        Intrinsics.checkExpressionValueIsNotNull(name, "name");
        DeserializedTypeAliasDescriptor deserializedTypeAliasDescriptor = new DeserializedTypeAliasDescriptor(storageManager2, containingDeclaration, annotations, name, getVisibility(), getProto(), getNameResolver(), getTypeTable(), getVersionRequirementTable(), getContainerSource());
        List<TypeParameterDescriptor> declaredTypeParameters = getDeclaredTypeParameters();
        KotlinType safeSubstitute = typeSubstitutor.safeSubstitute(getUnderlyingType(), Variance.INVARIANT);
        Intrinsics.checkExpressionValueIsNotNull(safeSubstitute, "substitutor.safeSubstitu…Type, Variance.INVARIANT)");
        SimpleType asSimpleType = TypeSubstitutionKt.asSimpleType(safeSubstitute);
        KotlinType safeSubstitute2 = typeSubstitutor.safeSubstitute(getExpandedType(), Variance.INVARIANT);
        Intrinsics.checkExpressionValueIsNotNull(safeSubstitute2, "substitutor.safeSubstitu…Type, Variance.INVARIANT)");
        deserializedTypeAliasDescriptor.initialize(declaredTypeParameters, asSimpleType, TypeSubstitutionKt.asSimpleType(safeSubstitute2), getCoroutinesExperimentalCompatibilityMode());
        return deserializedTypeAliasDescriptor;
    }

    /* access modifiers changed from: protected */
    @NotNull
    public List<TypeParameterDescriptor> getTypeConstructorTypeParameters() {
        List<? extends TypeParameterDescriptor> list = this.typeConstructorParameters;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("typeConstructorParameters");
        }
        return list;
    }
}
