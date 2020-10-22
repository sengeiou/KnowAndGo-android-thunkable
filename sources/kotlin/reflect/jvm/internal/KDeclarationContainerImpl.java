package kotlin.reflect.jvm.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.ClassBasedDeclarationContainer;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.ReflectProperties;
import kotlin.reflect.jvm.internal.components.RuntimeModuleData;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.structure.ReflectClassUtilKt;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.apache.commons.p032io.IOUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo39784bv = {1, 0, 3}, mo39785d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\b\b \u0018\u0000 =2\u00020\u0001:\u0003=>?B\u0005¢\u0006\u0002\u0010\u0002J*\u0010\f\u001a\u00020\r2\u0010\u0010\u000e\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0014\u0010\u0014\u001a\u0006\u0012\u0002\b\u00030\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0014\u0010\u0018\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00192\u0006\u0010\u0010\u001a\u00020\u0011J\u0014\u0010\u001a\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00192\u0006\u0010\u0010\u001a\u00020\u0011J \u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u0013J\u0016\u0010\u001f\u001a\u00020 2\u0006\u0010\u001d\u001a\u00020\u00112\u0006\u0010!\u001a\u00020\u0011J\u0018\u0010\"\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0011J\u0016\u0010#\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u00112\u0006\u0010!\u001a\u00020\u0011J\u0016\u0010$\u001a\b\u0012\u0004\u0012\u00020 0\u00042\u0006\u0010\u001d\u001a\u00020%H&J\u0012\u0010&\u001a\u0004\u0018\u00010\u00172\u0006\u0010'\u001a\u00020(H&J\"\u0010)\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030*0\u00042\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.H\u0004J\u0016\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00170\u00042\u0006\u0010\u001d\u001a\u00020%H&J\u001a\u00100\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t012\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0014\u00102\u001a\u0006\u0012\u0002\b\u00030\t2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J$\u00103\u001a\u0006\u0012\u0002\b\u00030\t2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u00104\u001a\u00020(2\u0006\u00105\u001a\u00020(H\u0002J=\u00106\u001a\u0004\u0018\u00010\u001c*\u0006\u0012\u0002\b\u00030\t2\u0006\u0010\u001d\u001a\u00020\u00112\u0010\u00107\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t082\n\u00109\u001a\u0006\u0012\u0002\b\u00030\tH\u0002¢\u0006\u0002\u0010:J8\u00106\u001a\u0004\u0018\u00010\u001c*\u0006\u0012\u0002\b\u00030\t2\u0006\u0010\u001d\u001a\u00020\u00112\u0010\u00107\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t012\n\u00109\u001a\u0006\u0012\u0002\b\u00030\tH\u0002J(\u0010;\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0019*\u0006\u0012\u0002\b\u00030\t2\u0010\u00107\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t01H\u0002J=\u0010<\u001a\u0004\u0018\u00010\u001c*\u0006\u0012\u0002\b\u00030\t2\u0006\u0010\u001d\u001a\u00020\u00112\u0010\u00107\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t082\n\u00109\u001a\u0006\u0012\u0002\b\u00030\tH\u0002¢\u0006\u0002\u0010:R\u0018\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\u0006\u0012\u0002\b\u00030\t8TX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006@"}, mo39786d2 = {"Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "Lkotlin/jvm/internal/ClassBasedDeclarationContainer;", "()V", "constructorDescriptors", "", "Lkotlin/reflect/jvm/internal/impl/descriptors/ConstructorDescriptor;", "getConstructorDescriptors", "()Ljava/util/Collection;", "methodOwner", "Ljava/lang/Class;", "getMethodOwner", "()Ljava/lang/Class;", "addParametersAndMasks", "", "result", "", "desc", "", "isConstructor", "", "createProperty", "Lkotlin/reflect/jvm/internal/KPropertyImpl;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "findConstructorBySignature", "Ljava/lang/reflect/Constructor;", "findDefaultConstructor", "findDefaultMethod", "Ljava/lang/reflect/Method;", "name", "isMember", "findFunctionDescriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "signature", "findMethodBySignature", "findPropertyDescriptor", "getFunctions", "Lkotlin/reflect/jvm/internal/impl/name/Name;", "getLocalProperty", "index", "", "getMembers", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "scope", "Lkotlin/reflect/jvm/internal/impl/resolve/scopes/MemberScope;", "belonginess", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$MemberBelonginess;", "getProperties", "loadParameterTypes", "", "loadReturnType", "parseType", "begin", "end", "lookupMethod", "parameterTypes", "", "returnType", "(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;Ljava/lang/Class;)Ljava/lang/reflect/Method;", "tryGetConstructor", "tryGetMethod", "Companion", "Data", "MemberBelonginess", "kotlin-reflection"}, mo39787k = 1, mo39788mv = {1, 1, 15})
/* compiled from: KDeclarationContainerImpl.kt */
public abstract class KDeclarationContainerImpl implements ClassBasedDeclarationContainer {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final Class<?> DEFAULT_CONSTRUCTOR_MARKER = Class.forName("kotlin.jvm.internal.DefaultConstructorMarker");
    /* access modifiers changed from: private */
    @NotNull
    public static final Regex LOCAL_PROPERTY_SIGNATURE = new Regex("<v#(\\d+)>");

    @NotNull
    public abstract Collection<ConstructorDescriptor> getConstructorDescriptors();

    @NotNull
    public abstract Collection<FunctionDescriptor> getFunctions(@NotNull Name name);

    @Nullable
    public abstract PropertyDescriptor getLocalProperty(int i);

    @NotNull
    public abstract Collection<PropertyDescriptor> getProperties(@NotNull Name name);

    @Metadata(mo39784bv = {1, 0, 3}, mo39785d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b¦\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001b\u0010\u0003\u001a\u00020\u00048FX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, mo39786d2 = {"Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$Data;", "", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;)V", "moduleData", "Lkotlin/reflect/jvm/internal/components/RuntimeModuleData;", "getModuleData", "()Lkotlin/reflect/jvm/internal/components/RuntimeModuleData;", "moduleData$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "kotlin-reflection"}, mo39787k = 1, mo39788mv = {1, 1, 15})
    /* compiled from: KDeclarationContainerImpl.kt */
    public abstract class Data {
        static final /* synthetic */ KProperty[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Data.class), "moduleData", "getModuleData()Lkotlin/reflect/jvm/internal/components/RuntimeModuleData;"))};
        @NotNull
        private final ReflectProperties.LazySoftVal moduleData$delegate = ReflectProperties.lazySoft(new KDeclarationContainerImpl$Data$moduleData$2(this));

        @NotNull
        public final RuntimeModuleData getModuleData() {
            return (RuntimeModuleData) this.moduleData$delegate.getValue(this, $$delegatedProperties[0]);
        }

        public Data() {
        }
    }

    /* access modifiers changed from: protected */
    @NotNull
    public Class<?> getMethodOwner() {
        Class<?> wrapperByPrimitive = ReflectClassUtilKt.getWrapperByPrimitive(getJClass());
        return wrapperByPrimitive != null ? wrapperByPrimitive : getJClass();
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0022 A[SYNTHETIC] */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.Collection<kotlin.reflect.jvm.internal.KCallableImpl<?>> getMembers(@org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope r8, @org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.KDeclarationContainerImpl.MemberBelonginess r9) {
        /*
            r7 = this;
            java.lang.String r0 = "scope"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r8, r0)
            java.lang.String r0 = "belonginess"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r9, r0)
            kotlin.reflect.jvm.internal.KDeclarationContainerImpl$getMembers$visitor$1 r0 = new kotlin.reflect.jvm.internal.KDeclarationContainerImpl$getMembers$visitor$1
            r0.<init>(r7)
            r1 = 0
            r2 = 3
            java.util.Collection r8 = kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope.DefaultImpls.getContributedDescriptors$default(r8, r1, r1, r2, r1)
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.Collection r2 = (java.util.Collection) r2
            java.util.Iterator r8 = r8.iterator()
        L_0x0022:
            boolean r3 = r8.hasNext()
            if (r3 == 0) goto L_0x005c
            java.lang.Object r3 = r8.next()
            kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r3 = (kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor) r3
            boolean r4 = r3 instanceof kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
            if (r4 == 0) goto L_0x0055
            r4 = r3
            kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor r4 = (kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor) r4
            kotlin.reflect.jvm.internal.impl.descriptors.Visibility r5 = r4.getVisibility()
            kotlin.reflect.jvm.internal.impl.descriptors.Visibility r6 = kotlin.reflect.jvm.internal.impl.descriptors.Visibilities.INVISIBLE_FAKE
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r6)
            r5 = r5 ^ 1
            if (r5 == 0) goto L_0x0055
            boolean r4 = r9.accept(r4)
            if (r4 == 0) goto L_0x0055
            r4 = r0
            kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor r4 = (kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor) r4
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            java.lang.Object r3 = r3.accept(r4, r5)
            kotlin.reflect.jvm.internal.KCallableImpl r3 = (kotlin.reflect.jvm.internal.KCallableImpl) r3
            goto L_0x0056
        L_0x0055:
            r3 = r1
        L_0x0056:
            if (r3 == 0) goto L_0x0022
            r2.add(r3)
            goto L_0x0022
        L_0x005c:
            java.util.List r2 = (java.util.List) r2
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.List r8 = kotlin.collections.CollectionsKt.toList(r2)
            java.util.Collection r8 = (java.util.Collection) r8
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.KDeclarationContainerImpl.getMembers(kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, kotlin.reflect.jvm.internal.KDeclarationContainerImpl$MemberBelonginess):java.util.Collection");
    }

    @Metadata(mo39784bv = {1, 0, 3}, mo39785d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, mo39786d2 = {"Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$MemberBelonginess;", "", "(Ljava/lang/String;I)V", "accept", "", "member", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;", "DECLARED", "INHERITED", "kotlin-reflection"}, mo39787k = 1, mo39788mv = {1, 1, 15})
    /* compiled from: KDeclarationContainerImpl.kt */
    protected enum MemberBelonginess {
        DECLARED,
        INHERITED;

        public final boolean accept(@NotNull CallableMemberDescriptor callableMemberDescriptor) {
            Intrinsics.checkParameterIsNotNull(callableMemberDescriptor, "member");
            CallableMemberDescriptor.Kind kind = callableMemberDescriptor.getKind();
            Intrinsics.checkExpressionValueIsNotNull(kind, "member.kind");
            return kind.isReal() == (this == DECLARED);
        }
    }

    /* access modifiers changed from: private */
    public final KPropertyImpl<?> createProperty(PropertyDescriptor propertyDescriptor) {
        int i = 0;
        int i2 = propertyDescriptor.getDispatchReceiverParameter() != null ? 1 : 0;
        if (propertyDescriptor.getExtensionReceiverParameter() != null) {
            i = 1;
        }
        int i3 = i2 + i;
        if (propertyDescriptor.isVar()) {
            switch (i3) {
                case 0:
                    return new KMutableProperty0Impl<>(this, propertyDescriptor);
                case 1:
                    return new KMutableProperty1Impl<>(this, propertyDescriptor);
                case 2:
                    return new KMutableProperty2Impl<>(this, propertyDescriptor);
            }
        } else {
            switch (i3) {
                case 0:
                    return new KProperty0Impl<>(this, propertyDescriptor);
                case 1:
                    return new KProperty1Impl<>(this, propertyDescriptor);
                case 2:
                    return new KProperty2Impl<>(this, propertyDescriptor);
            }
        }
        throw new KotlinReflectionInternalError("Unsupported property: " + propertyDescriptor);
    }

    @NotNull
    public final PropertyDescriptor findPropertyDescriptor(@NotNull String str, @NotNull String str2) {
        String str3;
        Intrinsics.checkParameterIsNotNull(str, "name");
        Intrinsics.checkParameterIsNotNull(str2, "signature");
        MatchResult matchEntire = LOCAL_PROPERTY_SIGNATURE.matchEntire(str2);
        boolean z = true;
        if (matchEntire != null) {
            String str4 = matchEntire.getDestructured().getMatch().getGroupValues().get(1);
            PropertyDescriptor localProperty = getLocalProperty(Integer.parseInt(str4));
            if (localProperty != null) {
                return localProperty;
            }
            throw new KotlinReflectionInternalError("Local property #" + str4 + " not found in " + getJClass());
        }
        Name identifier = Name.identifier(str);
        Intrinsics.checkExpressionValueIsNotNull(identifier, "Name.identifier(name)");
        Collection arrayList = new ArrayList();
        for (Object next : getProperties(identifier)) {
            if (Intrinsics.areEqual((Object) RuntimeTypeMapper.INSTANCE.mapPropertySignature((PropertyDescriptor) next).asString(), (Object) str2)) {
                arrayList.add(next);
            }
        }
        List list = (List) arrayList;
        if (list.isEmpty()) {
            throw new KotlinReflectionInternalError("Property '" + str + "' (JVM signature: " + str2 + ") not resolved in " + this);
        } else if (list.size() == 1) {
            return (PropertyDescriptor) CollectionsKt.single(list);
        } else {
            Map linkedHashMap = new LinkedHashMap();
            for (Object next2 : list) {
                Visibility visibility = ((PropertyDescriptor) next2).getVisibility();
                Object obj = linkedHashMap.get(visibility);
                if (obj == null) {
                    obj = new ArrayList();
                    linkedHashMap.put(visibility, obj);
                }
                ((List) obj).add(next2);
            }
            Collection values = MapsKt.toSortedMap(linkedHashMap, C3622x62283bb.INSTANCE).values();
            Intrinsics.checkExpressionValueIsNotNull(values, "properties\n             …                }).values");
            List list2 = (List) CollectionsKt.last(values);
            if (list2.size() == 1) {
                Intrinsics.checkExpressionValueIsNotNull(list2, "mostVisibleProperties");
                return (PropertyDescriptor) CollectionsKt.first(list2);
            }
            Name identifier2 = Name.identifier(str);
            Intrinsics.checkExpressionValueIsNotNull(identifier2, "Name.identifier(name)");
            String joinToString$default = CollectionsKt.joinToString$default(getProperties(identifier2), "\n", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, KDeclarationContainerImpl$findPropertyDescriptor$allMembers$1.INSTANCE, 30, (Object) null);
            StringBuilder sb = new StringBuilder();
            sb.append("Property '");
            sb.append(str);
            sb.append("' (JVM signature: ");
            sb.append(str2);
            sb.append(") not resolved in ");
            sb.append(this);
            sb.append(':');
            if (joinToString$default.length() != 0) {
                z = false;
            }
            if (z) {
                str3 = " no members found";
            } else {
                str3 = 10 + joinToString$default;
            }
            sb.append(str3);
            throw new KotlinReflectionInternalError(sb.toString());
        }
    }

    @NotNull
    public final FunctionDescriptor findFunctionDescriptor(@NotNull String str, @NotNull String str2) {
        Collection<FunctionDescriptor> collection;
        String str3;
        Intrinsics.checkParameterIsNotNull(str, "name");
        Intrinsics.checkParameterIsNotNull(str2, "signature");
        if (Intrinsics.areEqual((Object) str, (Object) "<init>")) {
            collection = CollectionsKt.toList(getConstructorDescriptors());
        } else {
            Name identifier = Name.identifier(str);
            Intrinsics.checkExpressionValueIsNotNull(identifier, "Name.identifier(name)");
            collection = getFunctions(identifier);
        }
        Iterable iterable = collection;
        Collection arrayList = new ArrayList();
        for (Object next : iterable) {
            if (Intrinsics.areEqual((Object) RuntimeTypeMapper.INSTANCE.mapSignature((FunctionDescriptor) next).asString(), (Object) str2)) {
                arrayList.add(next);
            }
        }
        List list = (List) arrayList;
        boolean z = true;
        if (list.size() == 1) {
            return (FunctionDescriptor) CollectionsKt.single(list);
        }
        String joinToString$default = CollectionsKt.joinToString$default(iterable, "\n", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, KDeclarationContainerImpl$findFunctionDescriptor$allMembers$1.INSTANCE, 30, (Object) null);
        StringBuilder sb = new StringBuilder();
        sb.append("Function '");
        sb.append(str);
        sb.append("' (JVM signature: ");
        sb.append(str2);
        sb.append(") not resolved in ");
        sb.append(this);
        sb.append(':');
        if (joinToString$default.length() != 0) {
            z = false;
        }
        if (z) {
            str3 = " no members found";
        } else {
            str3 = 10 + joinToString$default;
        }
        sb.append(str3);
        throw new KotlinReflectionInternalError(sb.toString());
    }

    private final Method lookupMethod(@NotNull Class<?> cls, String str, List<? extends Class<?>> list, Class<?> cls2) {
        Collection collection = list;
        Object[] array = collection.toArray(new Class[0]);
        if (array != null) {
            Method lookupMethod = lookupMethod(cls, str, (Class<?>[]) (Class[]) array, cls2);
            if (lookupMethod != null) {
                return lookupMethod;
            }
            if (!cls.isInterface()) {
                return null;
            }
            Class<Object> cls3 = Object.class;
            Object[] array2 = collection.toArray(new Class[0]);
            if (array2 != null) {
                Method lookupMethod2 = lookupMethod((Class<?>) cls3, str, (Class<?>[]) (Class[]) array2, cls2);
                if (lookupMethod2 != null) {
                    return lookupMethod2;
                }
                return null;
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    private final Method lookupMethod(@NotNull Class<?> cls, String str, Class<?>[] clsArr, Class<?> cls2) {
        Method lookupMethod;
        Method tryGetMethod = tryGetMethod(cls, str, clsArr, cls2);
        if (tryGetMethod != null) {
            return tryGetMethod;
        }
        Class<? super Object> superclass = cls.getSuperclass();
        if (superclass != null && (lookupMethod = lookupMethod((Class<?>) superclass, str, clsArr, cls2)) != null) {
            return lookupMethod;
        }
        for (Class cls3 : cls.getInterfaces()) {
            Intrinsics.checkExpressionValueIsNotNull(cls3, "superInterface");
            Method lookupMethod2 = lookupMethod((Class<?>) cls3, str, clsArr, cls2);
            if (lookupMethod2 != null) {
                return lookupMethod2;
            }
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x005c A[LOOP:0: B:6:0x0029->B:20:0x005c, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x005a A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.reflect.Method tryGetMethod(@org.jetbrains.annotations.NotNull java.lang.Class<?> r7, java.lang.String r8, java.lang.Class<?>[] r9, java.lang.Class<?> r10) {
        /*
            r6 = this;
            r0 = 0
            int r1 = r9.length     // Catch:{ NoSuchMethodException -> 0x005f }
            java.lang.Object[] r1 = java.util.Arrays.copyOf(r9, r1)     // Catch:{ NoSuchMethodException -> 0x005f }
            java.lang.Class[] r1 = (java.lang.Class[]) r1     // Catch:{ NoSuchMethodException -> 0x005f }
            java.lang.reflect.Method r1 = r7.getDeclaredMethod(r8, r1)     // Catch:{ NoSuchMethodException -> 0x005f }
            java.lang.String r2 = "result"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r2)     // Catch:{ NoSuchMethodException -> 0x005f }
            java.lang.Class r2 = r1.getReturnType()     // Catch:{ NoSuchMethodException -> 0x005f }
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r10)     // Catch:{ NoSuchMethodException -> 0x005f }
            if (r2 == 0) goto L_0x001d
            r0 = r1
            goto L_0x005f
        L_0x001d:
            java.lang.reflect.Method[] r7 = r7.getDeclaredMethods()     // Catch:{ NoSuchMethodException -> 0x005f }
            java.lang.String r1 = "declaredMethods"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r7, r1)     // Catch:{ NoSuchMethodException -> 0x005f }
            int r1 = r7.length     // Catch:{ NoSuchMethodException -> 0x005f }
            r2 = 0
            r3 = 0
        L_0x0029:
            if (r3 >= r1) goto L_0x005f
            r4 = r7[r3]     // Catch:{ NoSuchMethodException -> 0x005f }
            java.lang.String r5 = "method"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r4, r5)     // Catch:{ NoSuchMethodException -> 0x005f }
            java.lang.String r5 = r4.getName()     // Catch:{ NoSuchMethodException -> 0x005f }
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r8)     // Catch:{ NoSuchMethodException -> 0x005f }
            if (r5 == 0) goto L_0x0057
            java.lang.Class r5 = r4.getReturnType()     // Catch:{ NoSuchMethodException -> 0x005f }
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r10)     // Catch:{ NoSuchMethodException -> 0x005f }
            if (r5 == 0) goto L_0x0057
            java.lang.Class[] r5 = r4.getParameterTypes()     // Catch:{ NoSuchMethodException -> 0x005f }
            if (r5 != 0) goto L_0x004f
            kotlin.jvm.internal.Intrinsics.throwNpe()     // Catch:{ NoSuchMethodException -> 0x005f }
        L_0x004f:
            boolean r5 = java.util.Arrays.equals(r5, r9)     // Catch:{ NoSuchMethodException -> 0x005f }
            if (r5 == 0) goto L_0x0057
            r5 = 1
            goto L_0x0058
        L_0x0057:
            r5 = 0
        L_0x0058:
            if (r5 == 0) goto L_0x005c
            r0 = r4
            goto L_0x005f
        L_0x005c:
            int r3 = r3 + 1
            goto L_0x0029
        L_0x005f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.KDeclarationContainerImpl.tryGetMethod(java.lang.Class, java.lang.String, java.lang.Class[], java.lang.Class):java.lang.reflect.Method");
    }

    private final Constructor<?> tryGetConstructor(@NotNull Class<?> cls, List<? extends Class<?>> list) {
        try {
            Object[] array = list.toArray(new Class[0]);
            if (array != null) {
                Class[] clsArr = (Class[]) array;
                return cls.getDeclaredConstructor((Class[]) Arrays.copyOf(clsArr, clsArr.length));
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    @Nullable
    public final Method findMethodBySignature(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkParameterIsNotNull(str, "name");
        Intrinsics.checkParameterIsNotNull(str2, "desc");
        if (Intrinsics.areEqual((Object) str, (Object) "<init>")) {
            return null;
        }
        return lookupMethod(getMethodOwner(), str, (List<? extends Class<?>>) loadParameterTypes(str2), loadReturnType(str2));
    }

    @Nullable
    public final Method findDefaultMethod(@NotNull String str, @NotNull String str2, boolean z) {
        Intrinsics.checkParameterIsNotNull(str, "name");
        Intrinsics.checkParameterIsNotNull(str2, "desc");
        if (Intrinsics.areEqual((Object) str, (Object) "<init>")) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (z) {
            arrayList.add(getJClass());
        }
        List list = arrayList;
        addParametersAndMasks(list, str2, false);
        Class<?> methodOwner = getMethodOwner();
        return lookupMethod(methodOwner, str + "$default", (List<? extends Class<?>>) list, loadReturnType(str2));
    }

    @Nullable
    public final Constructor<?> findConstructorBySignature(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "desc");
        return tryGetConstructor(getJClass(), loadParameterTypes(str));
    }

    @Nullable
    public final Constructor<?> findDefaultConstructor(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "desc");
        Class<?> jClass = getJClass();
        List arrayList = new ArrayList();
        addParametersAndMasks(arrayList, str, true);
        return tryGetConstructor(jClass, arrayList);
    }

    private final void addParametersAndMasks(List<Class<?>> list, String str, boolean z) {
        List<Class<?>> loadParameterTypes = loadParameterTypes(str);
        list.addAll(loadParameterTypes);
        int size = ((loadParameterTypes.size() + 32) - 1) / 32;
        for (int i = 0; i < size; i++) {
            Class cls = Integer.TYPE;
            Intrinsics.checkExpressionValueIsNotNull(cls, "Integer.TYPE");
            list.add(cls);
        }
        Class cls2 = z ? DEFAULT_CONSTRUCTOR_MARKER : Object.class;
        Intrinsics.checkExpressionValueIsNotNull(cls2, "if (isConstructor) DEFAU…RKER else Any::class.java");
        list.add(cls2);
    }

    private final List<Class<?>> loadParameterTypes(String str) {
        int i;
        ArrayList arrayList = new ArrayList();
        int i2 = 1;
        while (str.charAt(i2) != ')') {
            int i3 = i2;
            while (str.charAt(i3) == '[') {
                i3++;
            }
            char charAt = str.charAt(i3);
            if (StringsKt.contains$default((CharSequence) "VZCBSIFJD", charAt, false, 2, (Object) null)) {
                i = i3 + 1;
            } else if (charAt == 'L') {
                i = StringsKt.indexOf$default((CharSequence) str, ';', i2, false, 4, (Object) null) + 1;
            } else {
                throw new KotlinReflectionInternalError("Unknown type prefix in the method signature: " + str);
            }
            arrayList.add(parseType(str, i2, i));
            i2 = i;
        }
        return arrayList;
    }

    private final Class<?> parseType(String str, int i, int i2) {
        switch (str.charAt(i)) {
            case 'B':
                return Byte.TYPE;
            case 'C':
                return Character.TYPE;
            case 'D':
                return Double.TYPE;
            case 'F':
                return Float.TYPE;
            case 'I':
                return Integer.TYPE;
            case 'J':
                return Long.TYPE;
            case 'L':
                ClassLoader safeClassLoader = ReflectClassUtilKt.getSafeClassLoader(getJClass());
                int i3 = i + 1;
                int i4 = i2 - 1;
                if (str != null) {
                    String substring = str.substring(i3, i4);
                    Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    Class<?> loadClass = safeClassLoader.loadClass(StringsKt.replace$default(substring, (char) IOUtils.DIR_SEPARATOR_UNIX, '.', false, 4, (Object) null));
                    Intrinsics.checkExpressionValueIsNotNull(loadClass, "jClass.safeClassLoader.l…d - 1).replace('/', '.'))");
                    return loadClass;
                }
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            case 'S':
                return Short.TYPE;
            case 'V':
                Class<?> cls = Void.TYPE;
                Intrinsics.checkExpressionValueIsNotNull(cls, "Void.TYPE");
                return cls;
            case 'Z':
                return Boolean.TYPE;
            case '[':
                return ReflectClassUtilKt.createArrayType(parseType(str, i + 1, i2));
            default:
                throw new KotlinReflectionInternalError("Unknown type prefix in the method signature: " + str);
        }
    }

    private final Class<?> loadReturnType(String str) {
        return parseType(str, StringsKt.indexOf$default((CharSequence) str, ')', 0, false, 6, (Object) null) + 1, str.length());
    }

    @Metadata(mo39784bv = {1, 0, 3}, mo39785d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u0012\u0012\u0002\b\u0003 \u0005*\b\u0012\u0002\b\u0003\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, mo39786d2 = {"Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$Companion;", "", "()V", "DEFAULT_CONSTRUCTOR_MARKER", "Ljava/lang/Class;", "kotlin.jvm.PlatformType", "LOCAL_PROPERTY_SIGNATURE", "Lkotlin/text/Regex;", "getLOCAL_PROPERTY_SIGNATURE$kotlin_reflection", "()Lkotlin/text/Regex;", "kotlin-reflection"}, mo39787k = 1, mo39788mv = {1, 1, 15})
    /* compiled from: KDeclarationContainerImpl.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final Regex getLOCAL_PROPERTY_SIGNATURE$kotlin_reflection() {
            return KDeclarationContainerImpl.LOCAL_PROPERTY_SIGNATURE;
        }
    }
}
