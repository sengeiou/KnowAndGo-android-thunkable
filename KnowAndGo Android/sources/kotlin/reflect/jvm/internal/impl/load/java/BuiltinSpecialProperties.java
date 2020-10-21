package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin._Assertions;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: specialBuiltinMembers.kt */
public final class BuiltinSpecialProperties {
    private static final Map<Name, List<Name>> GETTER_JVM_NAME_TO_PROPERTIES_SHORT_NAME_MAP;
    public static final BuiltinSpecialProperties INSTANCE = new BuiltinSpecialProperties();
    @NotNull
    private static final Map<FqName, Name> PROPERTY_FQ_NAME_TO_JVM_GETTER_NAME_MAP;
    private static final Set<FqName> SPECIAL_FQ_NAMES = PROPERTY_FQ_NAME_TO_JVM_GETTER_NAME_MAP.keySet();
    @NotNull
    private static final Set<Name> SPECIAL_SHORT_NAMES;

    static {
        FqNameUnsafe fqNameUnsafe = KotlinBuiltIns.FQ_NAMES._enum;
        Intrinsics.checkExpressionValueIsNotNull(fqNameUnsafe, "BUILTIN_NAMES._enum");
        FqNameUnsafe fqNameUnsafe2 = KotlinBuiltIns.FQ_NAMES._enum;
        Intrinsics.checkExpressionValueIsNotNull(fqNameUnsafe2, "BUILTIN_NAMES._enum");
        FqName fqName = KotlinBuiltIns.FQ_NAMES.collection;
        Intrinsics.checkExpressionValueIsNotNull(fqName, "BUILTIN_NAMES.collection");
        FqName fqName2 = KotlinBuiltIns.FQ_NAMES.map;
        Intrinsics.checkExpressionValueIsNotNull(fqName2, "BUILTIN_NAMES.map");
        FqNameUnsafe fqNameUnsafe3 = KotlinBuiltIns.FQ_NAMES.charSequence;
        Intrinsics.checkExpressionValueIsNotNull(fqNameUnsafe3, "BUILTIN_NAMES.charSequence");
        FqName fqName3 = KotlinBuiltIns.FQ_NAMES.map;
        Intrinsics.checkExpressionValueIsNotNull(fqName3, "BUILTIN_NAMES.map");
        FqName fqName4 = KotlinBuiltIns.FQ_NAMES.map;
        Intrinsics.checkExpressionValueIsNotNull(fqName4, "BUILTIN_NAMES.map");
        FqName fqName5 = KotlinBuiltIns.FQ_NAMES.map;
        Intrinsics.checkExpressionValueIsNotNull(fqName5, "BUILTIN_NAMES.map");
        PROPERTY_FQ_NAME_TO_JVM_GETTER_NAME_MAP = MapsKt.mapOf(TuplesKt.m2473to(SpecialBuiltinMembers.childSafe(fqNameUnsafe, "name"), Name.identifier("name")), TuplesKt.m2473to(SpecialBuiltinMembers.childSafe(fqNameUnsafe2, "ordinal"), Name.identifier("ordinal")), TuplesKt.m2473to(SpecialBuiltinMembers.child(fqName, "size"), Name.identifier("size")), TuplesKt.m2473to(SpecialBuiltinMembers.child(fqName2, "size"), Name.identifier("size")), TuplesKt.m2473to(SpecialBuiltinMembers.childSafe(fqNameUnsafe3, "length"), Name.identifier("length")), TuplesKt.m2473to(SpecialBuiltinMembers.child(fqName3, "keys"), Name.identifier("keySet")), TuplesKt.m2473to(SpecialBuiltinMembers.child(fqName4, "values"), Name.identifier("values")), TuplesKt.m2473to(SpecialBuiltinMembers.child(fqName5, "entries"), Name.identifier("entrySet")));
        Iterable<Map.Entry> entrySet = PROPERTY_FQ_NAME_TO_JVM_GETTER_NAME_MAP.entrySet();
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(entrySet, 10));
        for (Map.Entry entry : entrySet) {
            arrayList.add(new Pair(((FqName) entry.getKey()).shortName(), entry.getValue()));
        }
        Map<Name, List<Name>> linkedHashMap = new LinkedHashMap<>();
        for (Pair pair : (List) arrayList) {
            Name name = (Name) pair.getSecond();
            List<Name> list = linkedHashMap.get(name);
            if (list == null) {
                list = new ArrayList<>();
                linkedHashMap.put(name, list);
            }
            list.add((Name) pair.getFirst());
        }
        GETTER_JVM_NAME_TO_PROPERTIES_SHORT_NAME_MAP = linkedHashMap;
        Iterable<FqName> iterable = SPECIAL_FQ_NAMES;
        Collection arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (FqName shortName : iterable) {
            arrayList2.add(shortName.shortName());
        }
        SPECIAL_SHORT_NAMES = CollectionsKt.toSet((List) arrayList2);
    }

    private BuiltinSpecialProperties() {
    }

    @NotNull
    public final Set<Name> getSPECIAL_SHORT_NAMES$descriptors_jvm() {
        return SPECIAL_SHORT_NAMES;
    }

    public final boolean hasBuiltinSpecialPropertyFqName(@NotNull CallableMemberDescriptor callableMemberDescriptor) {
        Intrinsics.checkParameterIsNotNull(callableMemberDescriptor, "callableMemberDescriptor");
        if (!SPECIAL_SHORT_NAMES.contains(callableMemberDescriptor.getName())) {
            return false;
        }
        return hasBuiltinSpecialPropertyFqNameImpl(callableMemberDescriptor);
    }

    private final boolean hasBuiltinSpecialPropertyFqNameImpl(@NotNull CallableMemberDescriptor callableMemberDescriptor) {
        DeclarationDescriptor declarationDescriptor = callableMemberDescriptor;
        if (CollectionsKt.contains(SPECIAL_FQ_NAMES, DescriptorUtilsKt.fqNameOrNull(declarationDescriptor)) && callableMemberDescriptor.getValueParameters().isEmpty()) {
            return true;
        }
        if (!KotlinBuiltIns.isBuiltIn(declarationDescriptor)) {
            return false;
        }
        Collection<? extends CallableMemberDescriptor> overriddenDescriptors = callableMemberDescriptor.getOverriddenDescriptors();
        Intrinsics.checkExpressionValueIsNotNull(overriddenDescriptors, "overriddenDescriptors");
        Iterable<CallableMemberDescriptor> iterable = overriddenDescriptors;
        if ((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) {
            return false;
        }
        for (CallableMemberDescriptor callableMemberDescriptor2 : iterable) {
            BuiltinSpecialProperties builtinSpecialProperties = INSTANCE;
            Intrinsics.checkExpressionValueIsNotNull(callableMemberDescriptor2, "it");
            if (builtinSpecialProperties.hasBuiltinSpecialPropertyFqName(callableMemberDescriptor2)) {
                return true;
            }
        }
        return false;
    }

    @NotNull
    public final List<Name> getPropertyNameCandidatesBySpecialGetterName(@NotNull Name name) {
        Intrinsics.checkParameterIsNotNull(name, "name1");
        List<Name> list = GETTER_JVM_NAME_TO_PROPERTIES_SHORT_NAME_MAP.get(name);
        return list != null ? list : CollectionsKt.emptyList();
    }

    @Nullable
    public final String getBuiltinSpecialPropertyGetterName(@NotNull CallableMemberDescriptor callableMemberDescriptor) {
        Name name;
        Intrinsics.checkParameterIsNotNull(callableMemberDescriptor, "$this$getBuiltinSpecialPropertyGetterName");
        boolean isBuiltIn = KotlinBuiltIns.isBuiltIn(callableMemberDescriptor);
        if (!_Assertions.ENABLED || isBuiltIn) {
            CallableMemberDescriptor firstOverridden$default = DescriptorUtilsKt.firstOverridden$default(DescriptorUtilsKt.getPropertyIfAccessor(callableMemberDescriptor), false, C3674xbe16cae4.INSTANCE, 1, (Object) null);
            if (firstOverridden$default == null || (name = PROPERTY_FQ_NAME_TO_JVM_GETTER_NAME_MAP.get(DescriptorUtilsKt.getFqNameSafe(firstOverridden$default))) == null) {
                return null;
            }
            return name.asString();
        }
        throw new AssertionError("This method is defined only for builtin members, but " + callableMemberDescriptor + " found");
    }
}
