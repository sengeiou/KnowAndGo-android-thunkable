package kotlin.reflect.jvm;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KFunction;
import kotlin.reflect.KMutableProperty;
import kotlin.reflect.KProperty;
import kotlin.reflect.KType;
import kotlin.reflect.jvm.internal.KPropertyImpl;
import kotlin.reflect.jvm.internal.KTypeImpl;
import kotlin.reflect.jvm.internal.UtilKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo39784bv = {1, 0, 3}, mo39785d1 = {"\u0000J\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010%\u001a\u0004\u0018\u00010&*\u00020'H\u0002\"/\u0010\u0000\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00038F¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u001b\u0010\b\u001a\u0004\u0018\u00010\t*\u0006\u0012\u0002\b\u00030\n8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f\"\u001b\u0010\r\u001a\u0004\u0018\u00010\u000e*\u0006\u0012\u0002\b\u00030\n8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010\"\u001b\u0010\u0011\u001a\u0004\u0018\u00010\u000e*\u0006\u0012\u0002\b\u00030\u00038F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013\"\u001b\u0010\u0014\u001a\u0004\u0018\u00010\u000e*\u0006\u0012\u0002\b\u00030\u00158F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017\"\u0015\u0010\u0018\u001a\u00020\u0019*\u00020\u001a8F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c\"-\u0010\u001d\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0003\"\b\b\u0000\u0010\u0002*\u00020\u001e*\b\u0012\u0004\u0012\u0002H\u00020\u00018F¢\u0006\u0006\u001a\u0004\b\u001f\u0010 \"\u001b\u0010\u001d\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0003*\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b\u001f\u0010!\"\u001b\u0010\"\u001a\b\u0012\u0002\b\u0003\u0018\u00010\n*\u00020\t8F¢\u0006\u0006\u001a\u0004\b#\u0010$¨\u0006("}, mo39786d2 = {"javaConstructor", "Ljava/lang/reflect/Constructor;", "T", "Lkotlin/reflect/KFunction;", "javaConstructor$annotations", "(Lkotlin/reflect/KFunction;)V", "getJavaConstructor", "(Lkotlin/reflect/KFunction;)Ljava/lang/reflect/Constructor;", "javaField", "Ljava/lang/reflect/Field;", "Lkotlin/reflect/KProperty;", "getJavaField", "(Lkotlin/reflect/KProperty;)Ljava/lang/reflect/Field;", "javaGetter", "Ljava/lang/reflect/Method;", "getJavaGetter", "(Lkotlin/reflect/KProperty;)Ljava/lang/reflect/Method;", "javaMethod", "getJavaMethod", "(Lkotlin/reflect/KFunction;)Ljava/lang/reflect/Method;", "javaSetter", "Lkotlin/reflect/KMutableProperty;", "getJavaSetter", "(Lkotlin/reflect/KMutableProperty;)Ljava/lang/reflect/Method;", "javaType", "Ljava/lang/reflect/Type;", "Lkotlin/reflect/KType;", "getJavaType", "(Lkotlin/reflect/KType;)Ljava/lang/reflect/Type;", "kotlinFunction", "", "getKotlinFunction", "(Ljava/lang/reflect/Constructor;)Lkotlin/reflect/KFunction;", "(Ljava/lang/reflect/Method;)Lkotlin/reflect/KFunction;", "kotlinProperty", "getKotlinProperty", "(Ljava/lang/reflect/Field;)Lkotlin/reflect/KProperty;", "getKPackage", "Lkotlin/reflect/KDeclarationContainer;", "Ljava/lang/reflect/Member;", "kotlin-reflection"}, mo39787k = 2, mo39788mv = {1, 1, 15})
@JvmName(name = "ReflectJvmMapping")
/* compiled from: ReflectJvmMapping.kt */
public final class ReflectJvmMapping {
    public static /* synthetic */ void javaConstructor$annotations(KFunction kFunction) {
    }

    @Nullable
    public static final Field getJavaField(@NotNull KProperty<?> kProperty) {
        Intrinsics.checkParameterIsNotNull(kProperty, "$this$javaField");
        KPropertyImpl<?> asKPropertyImpl = UtilKt.asKPropertyImpl(kProperty);
        if (asKPropertyImpl != null) {
            return asKPropertyImpl.getJavaField();
        }
        return null;
    }

    @Nullable
    public static final Method getJavaGetter(@NotNull KProperty<?> kProperty) {
        Intrinsics.checkParameterIsNotNull(kProperty, "$this$javaGetter");
        return getJavaMethod(kProperty.getGetter());
    }

    @Nullable
    public static final Method getJavaSetter(@NotNull KMutableProperty<?> kMutableProperty) {
        Intrinsics.checkParameterIsNotNull(kMutableProperty, "$this$javaSetter");
        return getJavaMethod(kMutableProperty.getSetter());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000c, code lost:
        r2 = r2.getCaller();
     */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.reflect.Method getJavaMethod(@org.jetbrains.annotations.NotNull kotlin.reflect.KFunction<?> r2) {
        /*
            java.lang.String r0 = "$this$javaMethod"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r2, r0)
            kotlin.reflect.jvm.internal.KCallableImpl r2 = kotlin.reflect.jvm.internal.UtilKt.asKCallableImpl(r2)
            r0 = 0
            if (r2 == 0) goto L_0x0017
            kotlin.reflect.jvm.internal.calls.Caller r2 = r2.getCaller()
            if (r2 == 0) goto L_0x0017
            java.lang.reflect.Member r2 = r2.getMember()
            goto L_0x0018
        L_0x0017:
            r2 = r0
        L_0x0018:
            boolean r1 = r2 instanceof java.lang.reflect.Method
            if (r1 != 0) goto L_0x001d
            r2 = r0
        L_0x001d:
            java.lang.reflect.Method r2 = (java.lang.reflect.Method) r2
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.ReflectJvmMapping.getJavaMethod(kotlin.reflect.KFunction):java.lang.reflect.Method");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000c, code lost:
        r2 = r2.getCaller();
     */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> java.lang.reflect.Constructor<T> getJavaConstructor(@org.jetbrains.annotations.NotNull kotlin.reflect.KFunction<? extends T> r2) {
        /*
            java.lang.String r0 = "$this$javaConstructor"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r2, r0)
            kotlin.reflect.jvm.internal.KCallableImpl r2 = kotlin.reflect.jvm.internal.UtilKt.asKCallableImpl(r2)
            r0 = 0
            if (r2 == 0) goto L_0x0017
            kotlin.reflect.jvm.internal.calls.Caller r2 = r2.getCaller()
            if (r2 == 0) goto L_0x0017
            java.lang.reflect.Member r2 = r2.getMember()
            goto L_0x0018
        L_0x0017:
            r2 = r0
        L_0x0018:
            boolean r1 = r2 instanceof java.lang.reflect.Constructor
            if (r1 != 0) goto L_0x001d
            r2 = r0
        L_0x001d:
            java.lang.reflect.Constructor r2 = (java.lang.reflect.Constructor) r2
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.ReflectJvmMapping.getJavaConstructor(kotlin.reflect.KFunction):java.lang.reflect.Constructor");
    }

    @NotNull
    public static final Type getJavaType(@NotNull KType kType) {
        Intrinsics.checkParameterIsNotNull(kType, "$this$javaType");
        return ((KTypeImpl) kType).getJavaType$kotlin_reflection();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: kotlin.reflect.KProperty<?>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: kotlin.reflect.KProperty<?>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: kotlin.reflect.KProperty1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: kotlin.reflect.KProperty<?>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: kotlin.reflect.KProperty<?>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v8, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v6, resolved type: kotlin.reflect.KProperty} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: kotlin.reflect.KProperty<?>} */
    /* JADX WARNING: Multi-variable type inference failed */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final kotlin.reflect.KProperty<?> getKotlinProperty(@org.jetbrains.annotations.NotNull java.lang.reflect.Field r5) {
        /*
            java.lang.String r0 = "$this$kotlinProperty"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r5, r0)
            boolean r0 = r5.isSynthetic()
            r1 = 0
            if (r0 == 0) goto L_0x000d
            return r1
        L_0x000d:
            r0 = r5
            java.lang.reflect.Member r0 = (java.lang.reflect.Member) r0
            kotlin.reflect.KDeclarationContainer r0 = getKPackage(r0)
            if (r0 == 0) goto L_0x005c
            java.util.Collection r0 = r0.getMembers()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.Collection r2 = (java.util.Collection) r2
            java.util.Iterator r0 = r0.iterator()
        L_0x0027:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L_0x0039
            java.lang.Object r3 = r0.next()
            boolean r4 = r3 instanceof kotlin.reflect.KProperty
            if (r4 == 0) goto L_0x0027
            r2.add(r3)
            goto L_0x0027
        L_0x0039:
            java.util.List r2 = (java.util.List) r2
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.Iterator r0 = r2.iterator()
        L_0x0041:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x0059
            java.lang.Object r2 = r0.next()
            r3 = r2
            kotlin.reflect.KProperty r3 = (kotlin.reflect.KProperty) r3
            java.lang.reflect.Field r3 = getJavaField(r3)
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r5)
            if (r3 == 0) goto L_0x0041
            r1 = r2
        L_0x0059:
            kotlin.reflect.KProperty r1 = (kotlin.reflect.KProperty) r1
            return r1
        L_0x005c:
            java.lang.Class r0 = r5.getDeclaringClass()
            java.lang.String r2 = "declaringClass"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r2)
            kotlin.reflect.KClass r0 = kotlin.jvm.JvmClassMappingKt.getKotlinClass(r0)
            java.util.Collection r0 = kotlin.reflect.full.KClasses.getMemberProperties(r0)
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x0073:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x008d
            java.lang.Object r2 = r0.next()
            r3 = r2
            kotlin.reflect.KProperty1 r3 = (kotlin.reflect.KProperty1) r3
            kotlin.reflect.KProperty r3 = (kotlin.reflect.KProperty) r3
            java.lang.reflect.Field r3 = getJavaField(r3)
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r5)
            if (r3 == 0) goto L_0x0073
            r1 = r2
        L_0x008d:
            kotlin.reflect.KProperty r1 = (kotlin.reflect.KProperty) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.ReflectJvmMapping.getKotlinProperty(java.lang.reflect.Field):kotlin.reflect.KProperty");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0012, code lost:
        r0 = r0.getClassHeader();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final kotlin.reflect.KDeclarationContainer getKPackage(@org.jetbrains.annotations.NotNull java.lang.reflect.Member r3) {
        /*
            kotlin.reflect.jvm.internal.components.ReflectKotlinClass$Factory r0 = kotlin.reflect.jvm.internal.components.ReflectKotlinClass.Factory
            java.lang.Class r1 = r3.getDeclaringClass()
            java.lang.String r2 = "declaringClass"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r2)
            kotlin.reflect.jvm.internal.components.ReflectKotlinClass r0 = r0.create(r1)
            r1 = 0
            if (r0 == 0) goto L_0x001d
            kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader r0 = r0.getClassHeader()
            if (r0 == 0) goto L_0x001d
            kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader$Kind r0 = r0.getKind()
            goto L_0x001e
        L_0x001d:
            r0 = r1
        L_0x001e:
            if (r0 != 0) goto L_0x0021
            goto L_0x003f
        L_0x0021:
            int[] r2 = kotlin.reflect.jvm.ReflectJvmMapping.WhenMappings.$EnumSwitchMapping$0
            int r0 = r0.ordinal()
            r0 = r2[r0]
            switch(r0) {
                case 1: goto L_0x002d;
                case 2: goto L_0x002d;
                case 3: goto L_0x002d;
                default: goto L_0x002c;
            }
        L_0x002c:
            goto L_0x003f
        L_0x002d:
            kotlin.reflect.jvm.internal.KPackageImpl r0 = new kotlin.reflect.jvm.internal.KPackageImpl
            java.lang.Class r3 = r3.getDeclaringClass()
            java.lang.String r2 = "declaringClass"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r3, r2)
            r2 = 2
            r0.<init>(r3, r1, r2, r1)
            r1 = r0
            kotlin.reflect.KDeclarationContainer r1 = (kotlin.reflect.KDeclarationContainer) r1
        L_0x003f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.ReflectJvmMapping.getKPackage(java.lang.reflect.Member):kotlin.reflect.KDeclarationContainer");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: kotlin.reflect.KFunction<?>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: kotlin.reflect.KFunction<?>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: kotlin.reflect.KFunction} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: kotlin.reflect.KFunction<?>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: kotlin.reflect.KFunction<?>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v14, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v13, resolved type: kotlin.reflect.KFunction} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: kotlin.reflect.KFunction<?>} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00ca A[EDGE_INSN: B:56:0x00ca->B:38:0x00ca ?: BREAK  , SYNTHETIC] */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final kotlin.reflect.KFunction<?> getKotlinFunction(@org.jetbrains.annotations.NotNull java.lang.reflect.Method r7) {
        /*
            java.lang.String r0 = "$this$kotlinFunction"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r7, r0)
            int r0 = r7.getModifiers()
            boolean r0 = java.lang.reflect.Modifier.isStatic(r0)
            r1 = 0
            if (r0 == 0) goto L_0x00cf
            r0 = r7
            java.lang.reflect.Member r0 = (java.lang.reflect.Member) r0
            kotlin.reflect.KDeclarationContainer r0 = getKPackage(r0)
            if (r0 == 0) goto L_0x005f
            java.util.Collection r0 = r0.getMembers()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.Collection r2 = (java.util.Collection) r2
            java.util.Iterator r0 = r0.iterator()
        L_0x002a:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L_0x003c
            java.lang.Object r3 = r0.next()
            boolean r4 = r3 instanceof kotlin.reflect.KFunction
            if (r4 == 0) goto L_0x002a
            r2.add(r3)
            goto L_0x002a
        L_0x003c:
            java.util.List r2 = (java.util.List) r2
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.Iterator r0 = r2.iterator()
        L_0x0044:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x005c
            java.lang.Object r2 = r0.next()
            r3 = r2
            kotlin.reflect.KFunction r3 = (kotlin.reflect.KFunction) r3
            java.lang.reflect.Method r3 = getJavaMethod(r3)
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r7)
            if (r3 == 0) goto L_0x0044
            r1 = r2
        L_0x005c:
            kotlin.reflect.KFunction r1 = (kotlin.reflect.KFunction) r1
            return r1
        L_0x005f:
            java.lang.Class r0 = r7.getDeclaringClass()
            java.lang.String r2 = "declaringClass"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r2)
            kotlin.reflect.KClass r0 = kotlin.jvm.JvmClassMappingKt.getKotlinClass(r0)
            kotlin.reflect.KClass r0 = kotlin.reflect.full.KClasses.getCompanionObject(r0)
            if (r0 == 0) goto L_0x00cf
            java.util.Collection r0 = kotlin.reflect.full.KClasses.getFunctions(r0)
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x007c:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x00c9
            java.lang.Object r2 = r0.next()
            r3 = r2
            kotlin.reflect.KFunction r3 = (kotlin.reflect.KFunction) r3
            java.lang.reflect.Method r3 = getJavaMethod(r3)
            if (r3 == 0) goto L_0x00c5
            java.lang.String r4 = r3.getName()
            java.lang.String r5 = r7.getName()
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) r5)
            if (r4 == 0) goto L_0x00c5
            java.lang.Class[] r4 = r3.getParameterTypes()
            if (r4 != 0) goto L_0x00a6
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x00a6:
            java.lang.Class[] r5 = r7.getParameterTypes()
            java.lang.String r6 = "this.parameterTypes"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r5, r6)
            boolean r4 = java.util.Arrays.equals(r4, r5)
            if (r4 == 0) goto L_0x00c5
            java.lang.Class r3 = r3.getReturnType()
            java.lang.Class r4 = r7.getReturnType()
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r4)
            if (r3 == 0) goto L_0x00c5
            r3 = 1
            goto L_0x00c6
        L_0x00c5:
            r3 = 0
        L_0x00c6:
            if (r3 == 0) goto L_0x007c
            goto L_0x00ca
        L_0x00c9:
            r2 = r1
        L_0x00ca:
            kotlin.reflect.KFunction r2 = (kotlin.reflect.KFunction) r2
            if (r2 == 0) goto L_0x00cf
            return r2
        L_0x00cf:
            java.lang.Class r0 = r7.getDeclaringClass()
            java.lang.String r2 = "declaringClass"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r2)
            kotlin.reflect.KClass r0 = kotlin.jvm.JvmClassMappingKt.getKotlinClass(r0)
            java.util.Collection r0 = kotlin.reflect.full.KClasses.getFunctions(r0)
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x00e6:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x00fe
            java.lang.Object r2 = r0.next()
            r3 = r2
            kotlin.reflect.KFunction r3 = (kotlin.reflect.KFunction) r3
            java.lang.reflect.Method r3 = getJavaMethod(r3)
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r7)
            if (r3 == 0) goto L_0x00e6
            r1 = r2
        L_0x00fe:
            kotlin.reflect.KFunction r1 = (kotlin.reflect.KFunction) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.ReflectJvmMapping.getKotlinFunction(java.lang.reflect.Method):kotlin.reflect.KFunction");
    }

    @Nullable
    public static final <T> KFunction<T> getKotlinFunction(@NotNull Constructor<T> constructor) {
        Object obj;
        Intrinsics.checkParameterIsNotNull(constructor, "$this$kotlinFunction");
        Class<T> declaringClass = constructor.getDeclaringClass();
        Intrinsics.checkExpressionValueIsNotNull(declaringClass, "declaringClass");
        Iterator it = JvmClassMappingKt.getKotlinClass(declaringClass).getConstructors().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual((Object) getJavaConstructor((KFunction) obj), (Object) constructor)) {
                break;
            }
        }
        return (KFunction) obj;
    }
}
