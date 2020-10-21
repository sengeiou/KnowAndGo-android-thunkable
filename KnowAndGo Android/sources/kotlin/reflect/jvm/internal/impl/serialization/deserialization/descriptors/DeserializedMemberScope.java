package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.Parser;
import kotlin.reflect.jvm.internal.impl.resolve.MemberComparator;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.NameResolverUtilKt;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNotNull;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageKt;
import kotlin.sequences.SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p024io.nlopez.smartlocation.geofencing.providers.GeofencingGooglePlayServicesProvider;

/* compiled from: DeserializedMemberScope.kt */
public abstract class DeserializedMemberScope extends MemberScopeImpl {
    static final /* synthetic */ KProperty[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(DeserializedMemberScope.class), "functionNamesLazy", "getFunctionNamesLazy()Ljava/util/Set;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(DeserializedMemberScope.class), "variableNamesLazy", "getVariableNamesLazy()Ljava/util/Set;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(DeserializedMemberScope.class), "classNames", "getClassNames$deserialization()Ljava/util/Set;"))};
    /* access modifiers changed from: private */
    @NotNull

    /* renamed from: c */
    public final DeserializationContext f3004c;
    @NotNull
    private final NotNullLazyValue classNames$delegate;
    private final NotNullLazyValue functionNamesLazy$delegate;
    /* access modifiers changed from: private */
    public final Map<Name, byte[]> functionProtosBytes;
    private final MemoizedFunctionToNotNull<Name, Collection<SimpleFunctionDescriptor>> functions;
    private final MemoizedFunctionToNotNull<Name, Collection<PropertyDescriptor>> properties;
    /* access modifiers changed from: private */
    public final Map<Name, byte[]> propertyProtosBytes;
    private final MemoizedFunctionToNullable<Name, TypeAliasDescriptor> typeAliasByName;
    private final Map<Name, byte[]> typeAliasBytes;
    private final NotNullLazyValue variableNamesLazy$delegate;

    private final Set<Name> getFunctionNamesLazy() {
        return (Set) StorageKt.getValue(this.functionNamesLazy$delegate, (Object) this, (KProperty<?>) $$delegatedProperties[0]);
    }

    private final Set<Name> getVariableNamesLazy() {
        return (Set) StorageKt.getValue(this.variableNamesLazy$delegate, (Object) this, (KProperty<?>) $$delegatedProperties[1]);
    }

    /* access modifiers changed from: protected */
    public abstract void addEnumEntryDescriptors(@NotNull Collection<DeclarationDescriptor> collection, @NotNull Function1<? super Name, Boolean> function1);

    /* access modifiers changed from: protected */
    public void computeNonDeclaredFunctions(@NotNull Name name, @NotNull Collection<SimpleFunctionDescriptor> collection) {
        Intrinsics.checkParameterIsNotNull(name, "name");
        Intrinsics.checkParameterIsNotNull(collection, "functions");
    }

    /* access modifiers changed from: protected */
    public void computeNonDeclaredProperties(@NotNull Name name, @NotNull Collection<PropertyDescriptor> collection) {
        Intrinsics.checkParameterIsNotNull(name, "name");
        Intrinsics.checkParameterIsNotNull(collection, "descriptors");
    }

    /* access modifiers changed from: protected */
    @NotNull
    public abstract ClassId createClassId(@NotNull Name name);

    @NotNull
    public final Set<Name> getClassNames$deserialization() {
        return (Set) StorageKt.getValue(this.classNames$delegate, (Object) this, (KProperty<?>) $$delegatedProperties[2]);
    }

    /* access modifiers changed from: protected */
    @NotNull
    public abstract Set<Name> getNonDeclaredFunctionNames();

    /* access modifiers changed from: protected */
    @NotNull
    public abstract Set<Name> getNonDeclaredVariableNames();

    /* access modifiers changed from: protected */
    @NotNull
    public final DeserializationContext getC() {
        return this.f3004c;
    }

    protected DeserializedMemberScope(@NotNull DeserializationContext deserializationContext, @NotNull Collection<ProtoBuf.Function> collection, @NotNull Collection<ProtoBuf.Property> collection2, @NotNull Collection<ProtoBuf.TypeAlias> collection3, @NotNull Function0<? extends Collection<Name>> function0) {
        Map<Name, byte[]> map;
        Intrinsics.checkParameterIsNotNull(deserializationContext, "c");
        Intrinsics.checkParameterIsNotNull(collection, "functionList");
        Intrinsics.checkParameterIsNotNull(collection2, "propertyList");
        Intrinsics.checkParameterIsNotNull(collection3, "typeAliasList");
        Intrinsics.checkParameterIsNotNull(function0, "classNames");
        this.f3004c = deserializationContext;
        Map linkedHashMap = new LinkedHashMap();
        for (Object next : collection) {
            Name name = NameResolverUtilKt.getName(this.f3004c.getNameResolver(), ((ProtoBuf.Function) ((MessageLite) next)).getName());
            Object obj = linkedHashMap.get(name);
            if (obj == null) {
                obj = new ArrayList();
                linkedHashMap.put(name, obj);
            }
            ((List) obj).add(next);
        }
        this.functionProtosBytes = packToByteArray(linkedHashMap);
        Map linkedHashMap2 = new LinkedHashMap();
        for (Object next2 : collection2) {
            Name name2 = NameResolverUtilKt.getName(this.f3004c.getNameResolver(), ((ProtoBuf.Property) ((MessageLite) next2)).getName());
            Object obj2 = linkedHashMap2.get(name2);
            if (obj2 == null) {
                obj2 = new ArrayList();
                linkedHashMap2.put(name2, obj2);
            }
            ((List) obj2).add(next2);
        }
        this.propertyProtosBytes = packToByteArray(linkedHashMap2);
        if (this.f3004c.getComponents().getConfiguration().getTypeAliasesAllowed()) {
            Map linkedHashMap3 = new LinkedHashMap();
            for (Object next3 : collection3) {
                Name name3 = NameResolverUtilKt.getName(this.f3004c.getNameResolver(), ((ProtoBuf.TypeAlias) ((MessageLite) next3)).getName());
                Object obj3 = linkedHashMap3.get(name3);
                if (obj3 == null) {
                    obj3 = new ArrayList();
                    linkedHashMap3.put(name3, obj3);
                }
                ((List) obj3).add(next3);
            }
            map = packToByteArray(linkedHashMap3);
        } else {
            map = MapsKt.emptyMap();
        }
        this.typeAliasBytes = map;
        this.functions = this.f3004c.getStorageManager().createMemoizedFunction(new DeserializedMemberScope$functions$1(this));
        this.properties = this.f3004c.getStorageManager().createMemoizedFunction(new DeserializedMemberScope$properties$1(this));
        this.typeAliasByName = this.f3004c.getStorageManager().createMemoizedFunctionWithNullableValues(new DeserializedMemberScope$typeAliasByName$1(this));
        this.functionNamesLazy$delegate = this.f3004c.getStorageManager().createLazyValue(new DeserializedMemberScope$functionNamesLazy$2(this));
        this.variableNamesLazy$delegate = this.f3004c.getStorageManager().createLazyValue(new DeserializedMemberScope$variableNamesLazy$2(this));
        this.classNames$delegate = this.f3004c.getStorageManager().createLazyValue(new DeserializedMemberScope$classNames$2(function0));
    }

    private final Set<Name> getTypeAliasNames() {
        return this.typeAliasBytes.keySet();
    }

    @NotNull
    public Set<Name> getFunctionNames() {
        return getFunctionNamesLazy();
    }

    @NotNull
    public Set<Name> getVariableNames() {
        return getVariableNamesLazy();
    }

    /* access modifiers changed from: private */
    public final Collection<SimpleFunctionDescriptor> computeFunctions(Name name) {
        Collection<ProtoBuf.Function> collection;
        List list;
        Map<Name, byte[]> map = this.functionProtosBytes;
        Parser<ProtoBuf.Function> parser = ProtoBuf.Function.PARSER;
        Intrinsics.checkExpressionValueIsNotNull(parser, "ProtoBuf.Function.PARSER");
        byte[] bArr = map.get(name);
        if (bArr == null || (list = SequencesKt.toList(SequencesKt.generateSequence(new DeserializedMemberScope$computeDescriptors$$inlined$let$lambda$1(new ByteArrayInputStream(bArr), this, parser)))) == null) {
            collection = CollectionsKt.emptyList();
        } else {
            collection = list;
        }
        Collection arrayList = new ArrayList();
        for (ProtoBuf.Function function : collection) {
            MemberDeserializer memberDeserializer = this.f3004c.getMemberDeserializer();
            Intrinsics.checkExpressionValueIsNotNull(function, "it");
            arrayList.add(memberDeserializer.loadFunction(function));
        }
        ArrayList arrayList2 = (ArrayList) arrayList;
        computeNonDeclaredFunctions(name, arrayList2);
        return kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.compact(arrayList2);
    }

    @NotNull
    public Collection<SimpleFunctionDescriptor> getContributedFunctions(@NotNull Name name, @NotNull LookupLocation lookupLocation) {
        Intrinsics.checkParameterIsNotNull(name, "name");
        Intrinsics.checkParameterIsNotNull(lookupLocation, GeofencingGooglePlayServicesProvider.LOCATION_EXTRA_ID);
        if (!getFunctionNames().contains(name)) {
            return CollectionsKt.emptyList();
        }
        return this.functions.invoke(name);
    }

    /* access modifiers changed from: private */
    public final Collection<PropertyDescriptor> computeProperties(Name name) {
        Collection<ProtoBuf.Property> collection;
        List list;
        Map<Name, byte[]> map = this.propertyProtosBytes;
        Parser<ProtoBuf.Property> parser = ProtoBuf.Property.PARSER;
        Intrinsics.checkExpressionValueIsNotNull(parser, "ProtoBuf.Property.PARSER");
        byte[] bArr = map.get(name);
        if (bArr == null || (list = SequencesKt.toList(SequencesKt.generateSequence(new DeserializedMemberScope$computeDescriptors$$inlined$let$lambda$3(new ByteArrayInputStream(bArr), this, parser)))) == null) {
            collection = CollectionsKt.emptyList();
        } else {
            collection = list;
        }
        Collection arrayList = new ArrayList();
        for (ProtoBuf.Property property : collection) {
            MemberDeserializer memberDeserializer = this.f3004c.getMemberDeserializer();
            Intrinsics.checkExpressionValueIsNotNull(property, "it");
            arrayList.add(memberDeserializer.loadProperty(property));
        }
        ArrayList arrayList2 = (ArrayList) arrayList;
        computeNonDeclaredProperties(name, arrayList2);
        return kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.compact(arrayList2);
    }

    /* access modifiers changed from: private */
    public final TypeAliasDescriptor createTypeAlias(Name name) {
        ProtoBuf.TypeAlias parseDelimitedFrom;
        byte[] bArr = this.typeAliasBytes.get(name);
        if (bArr == null || (parseDelimitedFrom = ProtoBuf.TypeAlias.parseDelimitedFrom(new ByteArrayInputStream(bArr), this.f3004c.getComponents().getExtensionRegistryLite())) == null) {
            return null;
        }
        return this.f3004c.getMemberDeserializer().loadTypeAlias(parseDelimitedFrom);
    }

    @NotNull
    public Collection<PropertyDescriptor> getContributedVariables(@NotNull Name name, @NotNull LookupLocation lookupLocation) {
        Intrinsics.checkParameterIsNotNull(name, "name");
        Intrinsics.checkParameterIsNotNull(lookupLocation, GeofencingGooglePlayServicesProvider.LOCATION_EXTRA_ID);
        if (!getVariableNames().contains(name)) {
            return CollectionsKt.emptyList();
        }
        return this.properties.invoke(name);
    }

    /* access modifiers changed from: protected */
    @NotNull
    public final Collection<DeclarationDescriptor> computeDescriptors(@NotNull DescriptorKindFilter descriptorKindFilter, @NotNull Function1<? super Name, Boolean> function1, @NotNull LookupLocation lookupLocation) {
        Intrinsics.checkParameterIsNotNull(descriptorKindFilter, "kindFilter");
        Intrinsics.checkParameterIsNotNull(function1, "nameFilter");
        Intrinsics.checkParameterIsNotNull(lookupLocation, GeofencingGooglePlayServicesProvider.LOCATION_EXTRA_ID);
        ArrayList arrayList = new ArrayList(0);
        if (descriptorKindFilter.acceptsKinds(DescriptorKindFilter.Companion.getSINGLETON_CLASSIFIERS_MASK())) {
            addEnumEntryDescriptors(arrayList, function1);
        }
        Collection collection = arrayList;
        addFunctionsAndProperties(collection, descriptorKindFilter, function1, lookupLocation);
        if (descriptorKindFilter.acceptsKinds(DescriptorKindFilter.Companion.getCLASSIFIERS_MASK())) {
            for (Name next : getClassNames$deserialization()) {
                if (function1.invoke(next).booleanValue()) {
                    kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.addIfNotNull(collection, deserializeClass(next));
                }
            }
        }
        if (descriptorKindFilter.acceptsKinds(DescriptorKindFilter.Companion.getTYPE_ALIASES_MASK())) {
            for (Name next2 : getTypeAliasNames()) {
                if (function1.invoke(next2).booleanValue()) {
                    kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.addIfNotNull(collection, this.typeAliasByName.invoke(next2));
                }
            }
        }
        return kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.compact(arrayList);
    }

    private final void addFunctionsAndProperties(Collection<DeclarationDescriptor> collection, DescriptorKindFilter descriptorKindFilter, Function1<? super Name, Boolean> function1, LookupLocation lookupLocation) {
        if (descriptorKindFilter.acceptsKinds(DescriptorKindFilter.Companion.getVARIABLES_MASK())) {
            ArrayList arrayList = new ArrayList();
            for (Name name : getVariableNames()) {
                if (function1.invoke(name).booleanValue()) {
                    arrayList.addAll(getContributedVariables(name, lookupLocation));
                }
            }
            MemberComparator.NameAndTypeMemberComparator nameAndTypeMemberComparator = MemberComparator.NameAndTypeMemberComparator.INSTANCE;
            Intrinsics.checkExpressionValueIsNotNull(nameAndTypeMemberComparator, "MemberComparator.NameAnd…MemberComparator.INSTANCE");
            CollectionsKt.sortWith(arrayList, nameAndTypeMemberComparator);
            collection.addAll(arrayList);
        }
        if (descriptorKindFilter.acceptsKinds(DescriptorKindFilter.Companion.getFUNCTIONS_MASK())) {
            ArrayList arrayList2 = new ArrayList();
            for (Name name2 : getFunctionNames()) {
                if (function1.invoke(name2).booleanValue()) {
                    arrayList2.addAll(getContributedFunctions(name2, lookupLocation));
                }
            }
            MemberComparator.NameAndTypeMemberComparator nameAndTypeMemberComparator2 = MemberComparator.NameAndTypeMemberComparator.INSTANCE;
            Intrinsics.checkExpressionValueIsNotNull(nameAndTypeMemberComparator2, "MemberComparator.NameAnd…MemberComparator.INSTANCE");
            CollectionsKt.sortWith(arrayList2, nameAndTypeMemberComparator2);
            collection.addAll(arrayList2);
        }
    }

    @Nullable
    public ClassifierDescriptor getContributedClassifier(@NotNull Name name, @NotNull LookupLocation lookupLocation) {
        Intrinsics.checkParameterIsNotNull(name, "name");
        Intrinsics.checkParameterIsNotNull(lookupLocation, GeofencingGooglePlayServicesProvider.LOCATION_EXTRA_ID);
        if (hasClass(name)) {
            return deserializeClass(name);
        }
        if (getTypeAliasNames().contains(name)) {
            return this.typeAliasByName.invoke(name);
        }
        return null;
    }

    private final ClassDescriptor deserializeClass(Name name) {
        return this.f3004c.getComponents().deserializeClass(createClassId(name));
    }

    /* access modifiers changed from: protected */
    public boolean hasClass(@NotNull Name name) {
        Intrinsics.checkParameterIsNotNull(name, "name");
        return getClassNames$deserialization().contains(name);
    }

    private final Map<Name, byte[]> packToByteArray(@NotNull Map<Name, ? extends Collection<? extends AbstractMessageLite>> map) {
        Map<Name, byte[]> linkedHashMap = new LinkedHashMap<>(MapsKt.mapCapacity(map.size()));
        for (Map.Entry entry : map.entrySet()) {
            Object key = entry.getKey();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            Iterable<AbstractMessageLite> iterable = (Iterable) entry.getValue();
            Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
            for (AbstractMessageLite writeDelimitedTo : iterable) {
                writeDelimitedTo.writeDelimitedTo(byteArrayOutputStream);
                arrayList.add(Unit.INSTANCE);
            }
            List list = (List) arrayList;
            linkedHashMap.put(key, byteArrayOutputStream.toByteArray());
        }
        return linkedHashMap;
    }
}
