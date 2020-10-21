package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaAnnotations;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.TypeParameterResolver;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaArrayType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifier;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPrimitiveType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameter;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaWildcardType;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: JavaTypeResolver.kt */
public final class JavaTypeResolver {

    /* renamed from: c */
    private final LazyJavaResolverContext f2991c;
    private final TypeParameterResolver typeParameterResolver;

    public JavaTypeResolver(@NotNull LazyJavaResolverContext lazyJavaResolverContext, @NotNull TypeParameterResolver typeParameterResolver2) {
        Intrinsics.checkParameterIsNotNull(lazyJavaResolverContext, "c");
        Intrinsics.checkParameterIsNotNull(typeParameterResolver2, "typeParameterResolver");
        this.f2991c = lazyJavaResolverContext;
        this.typeParameterResolver = typeParameterResolver2;
    }

    @NotNull
    public final KotlinType transformJavaType(@Nullable JavaType javaType, @NotNull JavaTypeAttributes javaTypeAttributes) {
        KotlinType transformJavaType;
        SimpleType simpleType;
        Intrinsics.checkParameterIsNotNull(javaTypeAttributes, "attr");
        if (javaType instanceof JavaPrimitiveType) {
            PrimitiveType type = ((JavaPrimitiveType) javaType).getType();
            if (type != null) {
                simpleType = this.f2991c.getModule().getBuiltIns().getPrimitiveKotlinType(type);
            } else {
                simpleType = this.f2991c.getModule().getBuiltIns().getUnitType();
            }
            Intrinsics.checkExpressionValueIsNotNull(simpleType, "if (primitiveType != nul….module.builtIns.unitType");
            return simpleType;
        } else if (javaType instanceof JavaClassifierType) {
            return transformJavaClassifierType((JavaClassifierType) javaType, javaTypeAttributes);
        } else {
            if (javaType instanceof JavaArrayType) {
                return transformArrayType$default(this, (JavaArrayType) javaType, javaTypeAttributes, false, 4, (Object) null);
            } else if (javaType instanceof JavaWildcardType) {
                JavaType bound = ((JavaWildcardType) javaType).getBound();
                if (bound != null && (transformJavaType = transformJavaType(bound, javaTypeAttributes)) != null) {
                    return transformJavaType;
                }
                SimpleType defaultBound = this.f2991c.getModule().getBuiltIns().getDefaultBound();
                Intrinsics.checkExpressionValueIsNotNull(defaultBound, "c.module.builtIns.defaultBound");
                return defaultBound;
            } else if (javaType == null) {
                SimpleType defaultBound2 = this.f2991c.getModule().getBuiltIns().getDefaultBound();
                Intrinsics.checkExpressionValueIsNotNull(defaultBound2, "c.module.builtIns.defaultBound");
                return defaultBound2;
            } else {
                throw new UnsupportedOperationException("Unsupported type: " + javaType);
            }
        }
    }

    public static /* synthetic */ KotlinType transformArrayType$default(JavaTypeResolver javaTypeResolver, JavaArrayType javaArrayType, JavaTypeAttributes javaTypeAttributes, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return javaTypeResolver.transformArrayType(javaArrayType, javaTypeAttributes, z);
    }

    @NotNull
    public final KotlinType transformArrayType(@NotNull JavaArrayType javaArrayType, @NotNull JavaTypeAttributes javaTypeAttributes, boolean z) {
        Intrinsics.checkParameterIsNotNull(javaArrayType, "arrayType");
        Intrinsics.checkParameterIsNotNull(javaTypeAttributes, "attr");
        JavaType componentType = javaArrayType.getComponentType();
        JavaPrimitiveType javaPrimitiveType = (JavaPrimitiveType) (!(componentType instanceof JavaPrimitiveType) ? null : componentType);
        PrimitiveType type = javaPrimitiveType != null ? javaPrimitiveType.getType() : null;
        if (type != null) {
            SimpleType primitiveArrayKotlinType = this.f2991c.getModule().getBuiltIns().getPrimitiveArrayKotlinType(type);
            Intrinsics.checkExpressionValueIsNotNull(primitiveArrayKotlinType, "c.module.builtIns.getPri…KotlinType(primitiveType)");
            if (javaTypeAttributes.isForAnnotationParameter()) {
                return primitiveArrayKotlinType;
            }
            return KotlinTypeFactory.flexibleType(primitiveArrayKotlinType, primitiveArrayKotlinType.makeNullableAsSpecified(true));
        }
        KotlinType transformJavaType = transformJavaType(componentType, JavaTypeResolverKt.toAttributes$default(TypeUsage.COMMON, javaTypeAttributes.isForAnnotationParameter(), (TypeParameterDescriptor) null, 2, (Object) null));
        if (javaTypeAttributes.isForAnnotationParameter()) {
            SimpleType arrayType = this.f2991c.getModule().getBuiltIns().getArrayType(z ? Variance.OUT_VARIANCE : Variance.INVARIANT, transformJavaType);
            Intrinsics.checkExpressionValueIsNotNull(arrayType, "c.module.builtIns.getArr…ctionKind, componentType)");
            return arrayType;
        }
        SimpleType arrayType2 = this.f2991c.getModule().getBuiltIns().getArrayType(Variance.INVARIANT, transformJavaType);
        Intrinsics.checkExpressionValueIsNotNull(arrayType2, "c.module.builtIns.getArr…INVARIANT, componentType)");
        return KotlinTypeFactory.flexibleType(arrayType2, this.f2991c.getModule().getBuiltIns().getArrayType(Variance.OUT_VARIANCE, transformJavaType).makeNullableAsSpecified(true));
    }

    private final KotlinType transformJavaClassifierType(JavaClassifierType javaClassifierType, JavaTypeAttributes javaTypeAttributes) {
        JavaTypeResolver$transformJavaClassifierType$1 javaTypeResolver$transformJavaClassifierType$1 = new JavaTypeResolver$transformJavaClassifierType$1(javaClassifierType);
        boolean z = !javaTypeAttributes.isForAnnotationParameter() && javaTypeAttributes.getHowThisTypeIsUsed() != TypeUsage.SUPERTYPE;
        boolean isRaw = javaClassifierType.isRaw();
        if (isRaw || z) {
            SimpleType computeSimpleJavaClassifierType = computeSimpleJavaClassifierType(javaClassifierType, javaTypeAttributes.withFlexibility(JavaTypeFlexibility.FLEXIBLE_LOWER_BOUND), (SimpleType) null);
            if (computeSimpleJavaClassifierType == null) {
                return javaTypeResolver$transformJavaClassifierType$1.invoke();
            }
            SimpleType computeSimpleJavaClassifierType2 = computeSimpleJavaClassifierType(javaClassifierType, javaTypeAttributes.withFlexibility(JavaTypeFlexibility.FLEXIBLE_UPPER_BOUND), computeSimpleJavaClassifierType);
            if (computeSimpleJavaClassifierType2 == null) {
                return javaTypeResolver$transformJavaClassifierType$1.invoke();
            }
            if (isRaw) {
                return new RawTypeImpl(computeSimpleJavaClassifierType, computeSimpleJavaClassifierType2);
            }
            return KotlinTypeFactory.flexibleType(computeSimpleJavaClassifierType, computeSimpleJavaClassifierType2);
        }
        SimpleType computeSimpleJavaClassifierType3 = computeSimpleJavaClassifierType(javaClassifierType, javaTypeAttributes, (SimpleType) null);
        if (computeSimpleJavaClassifierType3 == null) {
            computeSimpleJavaClassifierType3 = javaTypeResolver$transformJavaClassifierType$1.invoke();
        }
        return computeSimpleJavaClassifierType3;
    }

    private final SimpleType computeSimpleJavaClassifierType(JavaClassifierType javaClassifierType, JavaTypeAttributes javaTypeAttributes, SimpleType simpleType) {
        Annotations annotations;
        if (simpleType == null || (annotations = simpleType.getAnnotations()) == null) {
            annotations = new LazyJavaAnnotations(this.f2991c, javaClassifierType);
        }
        TypeConstructor computeTypeConstructor = computeTypeConstructor(javaClassifierType, javaTypeAttributes);
        TypeConstructor typeConstructor = null;
        if (computeTypeConstructor == null) {
            return null;
        }
        boolean isNullable = isNullable(javaTypeAttributes);
        if (simpleType != null) {
            typeConstructor = simpleType.getConstructor();
        }
        if (!Intrinsics.areEqual((Object) typeConstructor, (Object) computeTypeConstructor) || javaClassifierType.isRaw() || !isNullable) {
            return KotlinTypeFactory.simpleType(annotations, computeTypeConstructor, computeArguments(javaClassifierType, javaTypeAttributes, computeTypeConstructor), isNullable);
        }
        return simpleType.makeNullableAsSpecified(true);
    }

    private final TypeConstructor computeTypeConstructor(JavaClassifierType javaClassifierType, JavaTypeAttributes javaTypeAttributes) {
        TypeConstructor typeConstructor;
        JavaClassifier classifier = javaClassifierType.getClassifier();
        if (classifier == null) {
            return createNotFoundClass(javaClassifierType);
        }
        if (classifier instanceof JavaClass) {
            JavaClass javaClass = (JavaClass) classifier;
            FqName fqName = javaClass.getFqName();
            if (fqName != null) {
                ClassDescriptor mapKotlinClass = mapKotlinClass(javaClassifierType, javaTypeAttributes, fqName);
                if (mapKotlinClass == null) {
                    mapKotlinClass = this.f2991c.getComponents().getModuleClassResolver().resolveClass(javaClass);
                }
                if (mapKotlinClass == null || (typeConstructor = mapKotlinClass.getTypeConstructor()) == null) {
                    return createNotFoundClass(javaClassifierType);
                }
                return typeConstructor;
            }
            throw new AssertionError("Class type should have a FQ name: " + classifier);
        } else if (classifier instanceof JavaTypeParameter) {
            TypeParameterDescriptor resolveTypeParameter = this.typeParameterResolver.resolveTypeParameter((JavaTypeParameter) classifier);
            if (resolveTypeParameter != null) {
                return resolveTypeParameter.getTypeConstructor();
            }
            return null;
        } else {
            throw new IllegalStateException("Unknown classifier kind: " + classifier);
        }
    }

    private final TypeConstructor createNotFoundClass(JavaClassifierType javaClassifierType) {
        ClassId classId = ClassId.topLevel(new FqName(javaClassifierType.getClassifierQualifiedName()));
        Intrinsics.checkExpressionValueIsNotNull(classId, "ClassId.topLevel(FqName(…classifierQualifiedName))");
        TypeConstructor typeConstructor = this.f2991c.getComponents().getDeserializedDescriptorResolver().getComponents().getNotFoundClasses().getClass(classId, CollectionsKt.listOf(0)).getTypeConstructor();
        Intrinsics.checkExpressionValueIsNotNull(typeConstructor, "c.components.deserialize…istOf(0)).typeConstructor");
        return typeConstructor;
    }

    private final ClassDescriptor mapKotlinClass(JavaClassifierType javaClassifierType, JavaTypeAttributes javaTypeAttributes, FqName fqName) {
        if (javaTypeAttributes.isForAnnotationParameter() && Intrinsics.areEqual((Object) fqName, (Object) JavaTypeResolverKt.JAVA_LANG_CLASS_FQ_NAME)) {
            return this.f2991c.getComponents().getReflectionTypes().getKClass();
        }
        JavaToKotlinClassMap javaToKotlinClassMap = JavaToKotlinClassMap.INSTANCE;
        ClassDescriptor mapJavaToKotlin$default = JavaToKotlinClassMap.mapJavaToKotlin$default(javaToKotlinClassMap, fqName, this.f2991c.getModule().getBuiltIns(), (Integer) null, 4, (Object) null);
        if (mapJavaToKotlin$default != null) {
            return (!javaToKotlinClassMap.isReadOnly(mapJavaToKotlin$default) || !(javaTypeAttributes.getFlexibility() == JavaTypeFlexibility.FLEXIBLE_LOWER_BOUND || javaTypeAttributes.getHowThisTypeIsUsed() == TypeUsage.SUPERTYPE || argumentsMakeSenseOnlyForMutableContainer(javaClassifierType, mapJavaToKotlin$default))) ? mapJavaToKotlin$default : javaToKotlinClassMap.convertReadOnlyToMutable(mapJavaToKotlin$default);
        }
        return null;
    }

    private final boolean argumentsMakeSenseOnlyForMutableContainer(@NotNull JavaClassifierType javaClassifierType, ClassDescriptor classDescriptor) {
        Variance variance;
        if (!JavaTypeResolver$argumentsMakeSenseOnlyForMutableContainer$1.INSTANCE.invoke((JavaType) CollectionsKt.lastOrNull(javaClassifierType.getTypeArguments()))) {
            return false;
        }
        TypeConstructor typeConstructor = JavaToKotlinClassMap.INSTANCE.convertReadOnlyToMutable(classDescriptor).getTypeConstructor();
        Intrinsics.checkExpressionValueIsNotNull(typeConstructor, "JavaToKotlinClassMap.con…         .typeConstructor");
        List<TypeParameterDescriptor> parameters = typeConstructor.getParameters();
        Intrinsics.checkExpressionValueIsNotNull(parameters, "JavaToKotlinClassMap.con…ypeConstructor.parameters");
        TypeParameterDescriptor typeParameterDescriptor = (TypeParameterDescriptor) CollectionsKt.lastOrNull(parameters);
        if (typeParameterDescriptor == null || (variance = typeParameterDescriptor.getVariance()) == null) {
            return false;
        }
        Intrinsics.checkExpressionValueIsNotNull(variance, "JavaToKotlinClassMap.con….variance ?: return false");
        if (variance != Variance.OUT_VARIANCE) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0022, code lost:
        if ((!r2.isEmpty()) != false) goto L_0x0027;
     */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x008f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.util.List<kotlin.reflect.jvm.internal.impl.types.TypeProjection> computeArguments(kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType r13, kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeAttributes r14, kotlin.reflect.jvm.internal.impl.types.TypeConstructor r15) {
        /*
            r12 = this;
            boolean r6 = r13.isRaw()
            r0 = 0
            r1 = 1
            if (r6 != 0) goto L_0x0027
            java.util.List r2 = r13.getTypeArguments()
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L_0x0025
            java.util.List r2 = r15.getParameters()
            java.lang.String r3 = "constructor.parameters"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r2, r3)
            java.util.Collection r2 = (java.util.Collection) r2
            boolean r2 = r2.isEmpty()
            r2 = r2 ^ r1
            if (r2 == 0) goto L_0x0025
            goto L_0x0027
        L_0x0025:
            r2 = 0
            goto L_0x0028
        L_0x0027:
            r2 = 1
        L_0x0028:
            java.util.List r3 = r15.getParameters()
            java.lang.String r4 = "constructor.parameters"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r3, r4)
            r4 = 10
            if (r2 == 0) goto L_0x008f
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            java.util.ArrayList r13 = new java.util.ArrayList
            int r0 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r3, r4)
            r13.<init>(r0)
            java.util.Collection r13 = (java.util.Collection) r13
            java.util.Iterator r7 = r3.iterator()
        L_0x0046:
            boolean r0 = r7.hasNext()
            if (r0 == 0) goto L_0x0086
            java.lang.Object r0 = r7.next()
            r8 = r0
            kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor r8 = (kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor) r8
            kotlin.reflect.jvm.internal.impl.types.LazyWrappedType r9 = new kotlin.reflect.jvm.internal.impl.types.LazyWrappedType
            kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext r0 = r12.f2991c
            kotlin.reflect.jvm.internal.impl.storage.StorageManager r10 = r0.getStorageManager()
            kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeResolver$computeArguments$$inlined$map$lambda$1 r11 = new kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeResolver$computeArguments$$inlined$map$lambda$1
            r0 = r11
            r1 = r8
            r2 = r12
            r3 = r14
            r4 = r15
            r5 = r6
            r0.<init>(r1, r2, r3, r4, r5)
            kotlin.jvm.functions.Function0 r11 = (kotlin.jvm.functions.Function0) r11
            r9.<init>(r10, r11)
            kotlin.reflect.jvm.internal.impl.load.java.lazy.types.RawSubstitution r0 = kotlin.reflect.jvm.internal.impl.load.java.lazy.types.RawSubstitution.INSTANCE
            java.lang.String r1 = "parameter"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r8, r1)
            if (r6 == 0) goto L_0x0076
            r1 = r14
            goto L_0x007c
        L_0x0076:
            kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeFlexibility r1 = kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeFlexibility.INFLEXIBLE
            kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeAttributes r1 = r14.withFlexibility(r1)
        L_0x007c:
            kotlin.reflect.jvm.internal.impl.types.KotlinType r9 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r9
            kotlin.reflect.jvm.internal.impl.types.TypeProjection r0 = r0.computeProjection(r8, r1, r9)
            r13.add(r0)
            goto L_0x0046
        L_0x0086:
            java.util.List r13 = (java.util.List) r13
            java.lang.Iterable r13 = (java.lang.Iterable) r13
            java.util.List r13 = kotlin.collections.CollectionsKt.toList(r13)
            return r13
        L_0x008f:
            int r14 = r3.size()
            java.util.List r15 = r13.getTypeArguments()
            int r15 = r15.size()
            if (r14 == r15) goto L_0x00df
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            java.util.ArrayList r13 = new java.util.ArrayList
            int r14 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r3, r4)
            r13.<init>(r14)
            java.util.Collection r13 = (java.util.Collection) r13
            java.util.Iterator r14 = r3.iterator()
        L_0x00ae:
            boolean r15 = r14.hasNext()
            if (r15 == 0) goto L_0x00d6
            java.lang.Object r15 = r14.next()
            kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor r15 = (kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor) r15
            kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl r0 = new kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl
            java.lang.String r1 = "p"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r15, r1)
            kotlin.reflect.jvm.internal.impl.name.Name r15 = r15.getName()
            java.lang.String r15 = r15.asString()
            kotlin.reflect.jvm.internal.impl.types.SimpleType r15 = kotlin.reflect.jvm.internal.impl.types.ErrorUtils.createErrorType(r15)
            kotlin.reflect.jvm.internal.impl.types.KotlinType r15 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r15
            r0.<init>(r15)
            r13.add(r0)
            goto L_0x00ae
        L_0x00d6:
            java.util.List r13 = (java.util.List) r13
            java.lang.Iterable r13 = (java.lang.Iterable) r13
            java.util.List r13 = kotlin.collections.CollectionsKt.toList(r13)
            return r13
        L_0x00df:
            java.util.List r13 = r13.getTypeArguments()
            java.lang.Iterable r13 = (java.lang.Iterable) r13
            java.lang.Iterable r13 = kotlin.collections.CollectionsKt.withIndex(r13)
            java.util.ArrayList r14 = new java.util.ArrayList
            int r15 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r13, r4)
            r14.<init>(r15)
            java.util.Collection r14 = (java.util.Collection) r14
            java.util.Iterator r13 = r13.iterator()
        L_0x00f8:
            boolean r15 = r13.hasNext()
            if (r15 == 0) goto L_0x015e
            java.lang.Object r15 = r13.next()
            kotlin.collections.IndexedValue r15 = (kotlin.collections.IndexedValue) r15
            int r2 = r15.component1()
            java.lang.Object r15 = r15.component2()
            kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType r15 = (kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType) r15
            int r4 = r3.size()
            if (r2 >= r4) goto L_0x0116
            r4 = 1
            goto L_0x0117
        L_0x0116:
            r4 = 0
        L_0x0117:
            boolean r5 = kotlin._Assertions.ENABLED
            if (r5 == 0) goto L_0x0143
            if (r4 == 0) goto L_0x011e
            goto L_0x0143
        L_0x011e:
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            java.lang.String r14 = "Argument index should be less then type parameters count, but "
            r13.append(r14)
            r13.append(r2)
            java.lang.String r14 = " > "
            r13.append(r14)
            int r14 = r3.size()
            r13.append(r14)
            java.lang.String r13 = r13.toString()
            java.lang.AssertionError r14 = new java.lang.AssertionError
            r14.<init>(r13)
            java.lang.Throwable r14 = (java.lang.Throwable) r14
            throw r14
        L_0x0143:
            java.lang.Object r2 = r3.get(r2)
            kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor r2 = (kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor) r2
            kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage r4 = kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage.COMMON
            r5 = 3
            r6 = 0
            kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeAttributes r4 = kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeResolverKt.toAttributes$default(r4, r0, r6, r5, r6)
            java.lang.String r5 = "parameter"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r2, r5)
            kotlin.reflect.jvm.internal.impl.types.TypeProjection r15 = r12.transformToTypeProjection(r15, r4, r2)
            r14.add(r15)
            goto L_0x00f8
        L_0x015e:
            java.util.List r14 = (java.util.List) r14
            java.lang.Iterable r14 = (java.lang.Iterable) r14
            java.util.List r13 = kotlin.collections.CollectionsKt.toList(r14)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeResolver.computeArguments(kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType, kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeAttributes, kotlin.reflect.jvm.internal.impl.types.TypeConstructor):java.util.List");
    }

    private final TypeProjection transformToTypeProjection(JavaType javaType, JavaTypeAttributes javaTypeAttributes, TypeParameterDescriptor typeParameterDescriptor) {
        if (!(javaType instanceof JavaWildcardType)) {
            return new TypeProjectionImpl(Variance.INVARIANT, transformJavaType(javaType, javaTypeAttributes));
        }
        JavaWildcardType javaWildcardType = (JavaWildcardType) javaType;
        JavaType bound = javaWildcardType.getBound();
        Variance variance = javaWildcardType.isExtends() ? Variance.OUT_VARIANCE : Variance.IN_VARIANCE;
        if (bound == null || isConflictingArgumentFor(variance, typeParameterDescriptor)) {
            return JavaTypeResolverKt.makeStarProjection(typeParameterDescriptor, javaTypeAttributes);
        }
        return TypeUtilsKt.createProjection(transformJavaType(bound, JavaTypeResolverKt.toAttributes$default(TypeUsage.COMMON, false, (TypeParameterDescriptor) null, 3, (Object) null)), variance, typeParameterDescriptor);
    }

    private final boolean isConflictingArgumentFor(@NotNull Variance variance, TypeParameterDescriptor typeParameterDescriptor) {
        if (typeParameterDescriptor.getVariance() == Variance.INVARIANT || variance == typeParameterDescriptor.getVariance()) {
            return false;
        }
        return true;
    }

    private final boolean isNullable(@NotNull JavaTypeAttributes javaTypeAttributes) {
        if (javaTypeAttributes.getFlexibility() == JavaTypeFlexibility.FLEXIBLE_LOWER_BOUND || javaTypeAttributes.isForAnnotationParameter() || javaTypeAttributes.getHowThisTypeIsUsed() == TypeUsage.SUPERTYPE) {
            return false;
        }
        return true;
    }
}
