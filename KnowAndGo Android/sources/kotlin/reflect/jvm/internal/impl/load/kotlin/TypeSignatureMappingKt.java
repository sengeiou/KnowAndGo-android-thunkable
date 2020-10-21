package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyGetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeEnhancementKt;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.name.SpecialNames;
import kotlin.reflect.jvm.internal.impl.resolve.InlineClassesUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmClassName;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeKt;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlin.reflect.jvm.internal.impl.utils.FunctionsKt;
import kotlin.text.StringsKt;
import org.apache.commons.p032io.IOUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: typeSignatureMapping.kt */
public final class TypeSignatureMappingKt {
    private static final <T> T boxTypeIfNeeded(@NotNull JvmTypeFactory<T> jvmTypeFactory, T t, boolean z) {
        return z ? jvmTypeFactory.boxType(t) : t;
    }

    public static /* synthetic */ Object mapType$default(KotlinType kotlinType, JvmTypeFactory jvmTypeFactory, TypeMappingMode typeMappingMode, TypeMappingConfiguration typeMappingConfiguration, JvmDescriptorTypeWriter jvmDescriptorTypeWriter, Function3<Object, Object, Object, Unit> function3, boolean z, int i, Object obj) {
        if ((i & 32) != 0) {
            function3 = FunctionsKt.getDO_NOTHING_3();
        }
        return mapType(kotlinType, jvmTypeFactory, typeMappingMode, typeMappingConfiguration, jvmDescriptorTypeWriter, function3, z);
    }

    /* JADX WARNING: type inference failed for: r12v0, types: [kotlin.reflect.jvm.internal.impl.load.kotlin.TypeMappingConfiguration<? extends T>, java.lang.Object, kotlin.reflect.jvm.internal.impl.load.kotlin.TypeMappingConfiguration] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> T mapType(@org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.types.KotlinType r9, @org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.load.kotlin.JvmTypeFactory<T> r10, @org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.load.kotlin.TypeMappingMode r11, @org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.load.kotlin.TypeMappingConfiguration<? extends T> r12, @org.jetbrains.annotations.Nullable kotlin.reflect.jvm.internal.impl.load.kotlin.JvmDescriptorTypeWriter<T> r13, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function3<? super kotlin.reflect.jvm.internal.impl.types.KotlinType, ? super T, ? super kotlin.reflect.jvm.internal.impl.load.kotlin.TypeMappingMode, kotlin.Unit> r14, boolean r15) {
        /*
            java.lang.String r0 = "kotlinType"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r9, r0)
            java.lang.String r0 = "factory"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r10, r0)
            java.lang.String r0 = "mode"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r11, r0)
            java.lang.String r0 = "typeMappingConfiguration"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r12, r0)
            java.lang.String r0 = "writeGenericType"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r14, r0)
            kotlin.reflect.jvm.internal.impl.types.KotlinType r1 = r12.preprocessType(r9)
            if (r1 == 0) goto L_0x002a
            r2 = r10
            r3 = r11
            r4 = r12
            r5 = r13
            r6 = r14
            r7 = r15
            java.lang.Object r9 = mapType(r1, r2, r3, r4, r5, r6, r7)
            return r9
        L_0x002a:
            boolean r0 = kotlin.reflect.jvm.internal.impl.builtins.FunctionTypesKt.isSuspendFunctionType(r9)
            if (r0 == 0) goto L_0x0046
            boolean r0 = r12.releaseCoroutines()
            kotlin.reflect.jvm.internal.impl.types.SimpleType r9 = kotlin.reflect.jvm.internal.impl.builtins.SuspendFunctionTypesKt.transformSuspendFunctionToRuntimeFunctionType(r9, r0)
            r0 = r9
            kotlin.reflect.jvm.internal.impl.types.KotlinType r0 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r0
            r1 = r10
            r2 = r11
            r3 = r12
            r4 = r13
            r5 = r14
            r6 = r15
            java.lang.Object r9 = mapType(r0, r1, r2, r3, r4, r5, r6)
            return r9
        L_0x0046:
            java.lang.Object r0 = mapBuiltInType(r9, r10, r11)
            if (r0 == 0) goto L_0x0058
            boolean r12 = r11.getNeedPrimitiveBoxing()
            java.lang.Object r10 = boxTypeIfNeeded(r10, r0, r12)
            r14.invoke(r9, r10, r11)
            return r10
        L_0x0058:
            kotlin.reflect.jvm.internal.impl.types.TypeConstructor r0 = r9.getConstructor()
            boolean r1 = r0 instanceof kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor
            if (r1 == 0) goto L_0x0079
            kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor r0 = (kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor) r0
            java.util.Collection r9 = r0.getSupertypes()
            kotlin.reflect.jvm.internal.impl.types.KotlinType r9 = r12.commonSupertype(r9)
            kotlin.reflect.jvm.internal.impl.types.KotlinType r0 = kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.replaceArgumentsWithStarProjections(r9)
            r1 = r10
            r2 = r11
            r3 = r12
            r4 = r13
            r5 = r14
            r6 = r15
            java.lang.Object r9 = mapType(r0, r1, r2, r3, r4, r5, r6)
            return r9
        L_0x0079:
            kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor r0 = r0.getDeclarationDescriptor()
            if (r0 == 0) goto L_0x01e4
            java.lang.String r1 = "constructor.declarationD…structor of $kotlinType\")"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)
            r1 = r0
            kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r1 = (kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor) r1
            boolean r1 = kotlin.reflect.jvm.internal.impl.types.ErrorUtils.isError(r1)
            if (r1 == 0) goto L_0x00a8
            java.lang.String r11 = "error/NonExistentClass"
            java.lang.Object r10 = r10.createObjectType(r11)
            if (r0 == 0) goto L_0x00a0
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r0 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) r0
            r12.processErrorType(r9, r0)
            if (r13 == 0) goto L_0x009f
            r13.writeClass(r10)
        L_0x009f:
            return r10
        L_0x00a0:
            kotlin.TypeCastException r9 = new kotlin.TypeCastException
            java.lang.String r10 = "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor"
            r9.<init>(r10)
            throw r9
        L_0x00a8:
            boolean r1 = r0 instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
            if (r1 == 0) goto L_0x012f
            boolean r2 = kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.isArray(r9)
            if (r2 == 0) goto L_0x012f
            java.util.List r0 = r9.getArguments()
            int r0 = r0.size()
            r1 = 1
            if (r0 != r1) goto L_0x0125
            java.util.List r9 = r9.getArguments()
            r0 = 0
            java.lang.Object r9 = r9.get(r0)
            kotlin.reflect.jvm.internal.impl.types.TypeProjection r9 = (kotlin.reflect.jvm.internal.impl.types.TypeProjection) r9
            kotlin.reflect.jvm.internal.impl.types.KotlinType r0 = r9.getType()
            java.lang.String r1 = "memberProjection.type"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)
            kotlin.reflect.jvm.internal.impl.types.Variance r1 = r9.getProjectionKind()
            kotlin.reflect.jvm.internal.impl.types.Variance r2 = kotlin.reflect.jvm.internal.impl.types.Variance.IN_VARIANCE
            if (r1 != r2) goto L_0x00eb
            java.lang.String r9 = "java/lang/Object"
            java.lang.Object r9 = r10.createObjectType(r9)
            if (r13 == 0) goto L_0x010b
            r13.writeArrayType()
            r13.writeClass(r9)
            r13.writeArrayEnd()
            goto L_0x010b
        L_0x00eb:
            if (r13 == 0) goto L_0x00f0
            r13.writeArrayType()
        L_0x00f0:
            kotlin.reflect.jvm.internal.impl.types.Variance r9 = r9.getProjectionKind()
            java.lang.String r1 = "memberProjection.projectionKind"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r9, r1)
            kotlin.reflect.jvm.internal.impl.load.kotlin.TypeMappingMode r2 = r11.toGenericArgumentMode(r9)
            r1 = r10
            r3 = r12
            r4 = r13
            r5 = r14
            r6 = r15
            java.lang.Object r9 = mapType(r0, r1, r2, r3, r4, r5, r6)
            if (r13 == 0) goto L_0x010b
            r13.writeArrayEnd()
        L_0x010b:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r12 = "["
            r11.append(r12)
            java.lang.String r9 = r10.toString(r9)
            r11.append(r9)
            java.lang.String r9 = r11.toString()
            java.lang.Object r9 = r10.createFromString(r9)
            return r9
        L_0x0125:
            java.lang.UnsupportedOperationException r9 = new java.lang.UnsupportedOperationException
            java.lang.String r10 = "arrays must have one type argument"
            r9.<init>(r10)
            java.lang.Throwable r9 = (java.lang.Throwable) r9
            throw r9
        L_0x012f:
            if (r1 == 0) goto L_0x01a4
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r0 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) r0
            boolean r1 = r0.isInline()
            if (r1 == 0) goto L_0x0153
            boolean r1 = r11.getNeedInlineClassWrapping()
            if (r1 != 0) goto L_0x0153
            kotlin.reflect.jvm.internal.impl.types.KotlinType r2 = computeExpandedTypeForInlineClass(r9)
            if (r2 == 0) goto L_0x0153
            kotlin.reflect.jvm.internal.impl.load.kotlin.TypeMappingMode r4 = r11.wrapInlineClassesMode()
            r3 = r10
            r5 = r12
            r6 = r13
            r7 = r14
            r8 = r15
            java.lang.Object r9 = mapType(r2, r3, r4, r5, r6, r7, r8)
            return r9
        L_0x0153:
            boolean r13 = r11.isForAnnotationParameter()
            if (r13 == 0) goto L_0x0164
            boolean r13 = kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.isKClass(r0)
            if (r13 == 0) goto L_0x0164
            java.lang.Object r10 = r10.getJavaLangClassType()
            goto L_0x01a0
        L_0x0164:
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r13 = r0.getOriginal()
            java.lang.String r1 = "descriptor.original"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r13, r1)
            java.lang.Object r13 = r12.getPredefinedTypeForClass(r13)
            if (r13 == 0) goto L_0x0175
            r10 = r13
            goto L_0x01a0
        L_0x0175:
            kotlin.reflect.jvm.internal.impl.descriptors.ClassKind r13 = r0.getKind()
            kotlin.reflect.jvm.internal.impl.descriptors.ClassKind r1 = kotlin.reflect.jvm.internal.impl.descriptors.ClassKind.ENUM_ENTRY
            if (r13 != r1) goto L_0x018f
            kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r13 = r0.getContainingDeclaration()
            if (r13 == 0) goto L_0x0187
            r0 = r13
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r0 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) r0
            goto L_0x018f
        L_0x0187:
            kotlin.TypeCastException r9 = new kotlin.TypeCastException
            java.lang.String r10 = "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor"
            r9.<init>(r10)
            throw r9
        L_0x018f:
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r13 = r0.getOriginal()
            java.lang.String r0 = "enumClassIfEnumEntry.original"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r13, r0)
            java.lang.String r12 = computeInternalName(r13, r12, r15)
            java.lang.Object r10 = r10.createObjectType(r12)
        L_0x01a0:
            r14.invoke(r9, r10, r11)
            return r10
        L_0x01a4:
            boolean r14 = r0 instanceof kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor
            if (r14 == 0) goto L_0x01cb
            r9 = r0
            kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor r9 = (kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor) r9
            kotlin.reflect.jvm.internal.impl.types.KotlinType r1 = kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.getRepresentativeUpperBound(r9)
            kotlin.jvm.functions.Function3 r6 = kotlin.reflect.jvm.internal.impl.utils.FunctionsKt.getDO_NOTHING_3()
            r5 = 0
            r2 = r10
            r3 = r11
            r4 = r12
            r7 = r15
            java.lang.Object r9 = mapType(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ Throwable -> 0x01fd }
            if (r13 == 0) goto L_0x01ca
            kotlin.reflect.jvm.internal.impl.name.Name r10 = r0.getName()
            java.lang.String r11 = "descriptor.getName()"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r10, r11)
            r13.writeTypeVariable(r10, r9)
        L_0x01ca:
            return r9
        L_0x01cb:
            java.lang.UnsupportedOperationException r10 = new java.lang.UnsupportedOperationException
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r12 = "Unknown type "
            r11.append(r12)
            r11.append(r9)
            java.lang.String r9 = r11.toString()
            r10.<init>(r9)
            java.lang.Throwable r10 = (java.lang.Throwable) r10
            throw r10
        L_0x01e4:
            java.lang.UnsupportedOperationException r10 = new java.lang.UnsupportedOperationException
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r12 = "no descriptor for type constructor of "
            r11.append(r12)
            r11.append(r9)
            java.lang.String r9 = r11.toString()
            r10.<init>(r9)
            java.lang.Throwable r10 = (java.lang.Throwable) r10
            throw r10
        L_0x01fd:
            r9 = move-exception
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.kotlin.TypeSignatureMappingKt.mapType(kotlin.reflect.jvm.internal.impl.types.KotlinType, kotlin.reflect.jvm.internal.impl.load.kotlin.JvmTypeFactory, kotlin.reflect.jvm.internal.impl.load.kotlin.TypeMappingMode, kotlin.reflect.jvm.internal.impl.load.kotlin.TypeMappingConfiguration, kotlin.reflect.jvm.internal.impl.load.kotlin.JvmDescriptorTypeWriter, kotlin.jvm.functions.Function3, boolean):java.lang.Object");
    }

    public static final boolean hasVoidReturnType(@NotNull CallableDescriptor callableDescriptor) {
        Intrinsics.checkParameterIsNotNull(callableDescriptor, "descriptor");
        if (callableDescriptor instanceof ConstructorDescriptor) {
            return true;
        }
        KotlinType returnType = callableDescriptor.getReturnType();
        if (returnType == null) {
            Intrinsics.throwNpe();
        }
        if (KotlinBuiltIns.isUnit(returnType)) {
            KotlinType returnType2 = callableDescriptor.getReturnType();
            if (returnType2 == null) {
                Intrinsics.throwNpe();
            }
            if (TypeUtils.isNullableType(returnType2) || (callableDescriptor instanceof PropertyGetterDescriptor)) {
                return false;
            }
            return true;
        }
        return false;
    }

    private static final <T> T mapBuiltInType(KotlinType kotlinType, JvmTypeFactory<T> jvmTypeFactory, TypeMappingMode typeMappingMode) {
        ClassId mapKotlinToJava;
        ClassifierDescriptor declarationDescriptor = kotlinType.getConstructor().getDeclarationDescriptor();
        if (!(declarationDescriptor instanceof ClassDescriptor)) {
            declarationDescriptor = null;
        }
        ClassDescriptor classDescriptor = (ClassDescriptor) declarationDescriptor;
        if (classDescriptor == null) {
            return null;
        }
        DeclarationDescriptor declarationDescriptor2 = classDescriptor;
        PrimitiveType primitiveType = KotlinBuiltIns.getPrimitiveType(declarationDescriptor2);
        boolean z = true;
        boolean z2 = false;
        if (primitiveType != null) {
            JvmPrimitiveType jvmPrimitiveType = JvmPrimitiveType.get(primitiveType);
            Intrinsics.checkExpressionValueIsNotNull(jvmPrimitiveType, "JvmPrimitiveType.get(primitiveType)");
            String desc = jvmPrimitiveType.getDesc();
            Intrinsics.checkExpressionValueIsNotNull(desc, "JvmPrimitiveType.get(primitiveType).desc");
            T createFromString = jvmTypeFactory.createFromString(desc);
            if (!TypeUtils.isNullableType(kotlinType) && !TypeEnhancementKt.hasEnhancedNullability(kotlinType)) {
                z = false;
            }
            return boxTypeIfNeeded(jvmTypeFactory, createFromString, z);
        }
        PrimitiveType primitiveArrayType = KotlinBuiltIns.getPrimitiveArrayType(declarationDescriptor2);
        if (primitiveArrayType != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            JvmPrimitiveType jvmPrimitiveType2 = JvmPrimitiveType.get(primitiveArrayType);
            Intrinsics.checkExpressionValueIsNotNull(jvmPrimitiveType2, "JvmPrimitiveType.get(arrayElementType)");
            sb.append(jvmPrimitiveType2.getDesc());
            return jvmTypeFactory.createFromString(sb.toString());
        } else if (!KotlinBuiltIns.isUnderKotlinPackage(declarationDescriptor2) || (mapKotlinToJava = JavaToKotlinClassMap.INSTANCE.mapKotlinToJava(DescriptorUtilsKt.getFqNameUnsafe(declarationDescriptor2))) == null) {
            return null;
        } else {
            if (!typeMappingMode.getKotlinCollectionsToJavaCollections()) {
                Iterable mutabilityMappings = JavaToKotlinClassMap.INSTANCE.getMutabilityMappings();
                if (!(mutabilityMappings instanceof Collection) || !((Collection) mutabilityMappings).isEmpty()) {
                    Iterator it = mutabilityMappings.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (Intrinsics.areEqual((Object) ((JavaToKotlinClassMap.PlatformMutabilityMapping) it.next()).getJavaClass(), (Object) mapKotlinToJava)) {
                                z2 = true;
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                }
                if (z2) {
                    return null;
                }
            }
            JvmClassName byClassId = JvmClassName.byClassId(mapKotlinToJava);
            Intrinsics.checkExpressionValueIsNotNull(byClassId, "JvmClassName.byClassId(classId)");
            String internalName = byClassId.getInternalName();
            Intrinsics.checkExpressionValueIsNotNull(internalName, "JvmClassName.byClassId(classId).internalName");
            return jvmTypeFactory.createObjectType(internalName);
        }
    }

    @Nullable
    public static final KotlinType computeExpandedTypeForInlineClass(@NotNull KotlinType kotlinType) {
        Intrinsics.checkParameterIsNotNull(kotlinType, "inlineClassType");
        return computeExpandedTypeInner(kotlinType, new HashSet());
    }

    @Nullable
    public static final KotlinType computeExpandedTypeInner(@NotNull KotlinType kotlinType, @NotNull HashSet<ClassifierDescriptor> hashSet) {
        KotlinType kotlinType2;
        Intrinsics.checkParameterIsNotNull(kotlinType, "kotlinType");
        Intrinsics.checkParameterIsNotNull(hashSet, "visitedClassifiers");
        ClassifierDescriptor declarationDescriptor = kotlinType.getConstructor().getDeclarationDescriptor();
        if (declarationDescriptor != null) {
            Intrinsics.checkExpressionValueIsNotNull(declarationDescriptor, "kotlinType.constructor.d…n expected: $kotlinType\")");
            if (!hashSet.add(declarationDescriptor)) {
                return null;
            }
            if (declarationDescriptor instanceof TypeParameterDescriptor) {
                kotlinType2 = computeExpandedTypeInner(TypeUtilsKt.getRepresentativeUpperBound((TypeParameterDescriptor) declarationDescriptor), hashSet);
                if (kotlinType2 == null) {
                    return null;
                }
                if (!KotlinTypeKt.isNullable(kotlinType2) && kotlinType.isMarkedNullable()) {
                    return TypeUtilsKt.makeNullable(kotlinType2);
                }
            } else if (!(declarationDescriptor instanceof ClassDescriptor) || !((ClassDescriptor) declarationDescriptor).isInline()) {
                return kotlinType;
            } else {
                KotlinType substitutedUnderlyingType = InlineClassesUtilsKt.substitutedUnderlyingType(kotlinType);
                if (substitutedUnderlyingType == null || (kotlinType2 = computeExpandedTypeInner(substitutedUnderlyingType, hashSet)) == null) {
                    return null;
                }
                if (KotlinTypeKt.isNullable(kotlinType)) {
                    if (!KotlinTypeKt.isNullable(kotlinType2) && !KotlinBuiltIns.isPrimitiveType(kotlinType2)) {
                        return TypeUtilsKt.makeNullable(kotlinType2);
                    }
                    return kotlinType;
                }
            }
            return kotlinType2;
        }
        throw new AssertionError("Type with a declaration expected: " + kotlinType);
    }

    public static /* synthetic */ String computeInternalName$default(ClassDescriptor classDescriptor, TypeMappingConfiguration typeMappingConfiguration, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            typeMappingConfiguration = TypeMappingConfigurationImpl.INSTANCE;
        }
        return computeInternalName(classDescriptor, typeMappingConfiguration, z);
    }

    @NotNull
    public static final String computeInternalName(@NotNull ClassDescriptor classDescriptor, @NotNull TypeMappingConfiguration<?> typeMappingConfiguration, boolean z) {
        Intrinsics.checkParameterIsNotNull(classDescriptor, "klass");
        Intrinsics.checkParameterIsNotNull(typeMappingConfiguration, "typeMappingConfiguration");
        DeclarationDescriptor container = z ? getContainer(classDescriptor.getContainingDeclaration()) : classDescriptor.getContainingDeclaration();
        Name safeIdentifier = SpecialNames.safeIdentifier(classDescriptor.getName());
        Intrinsics.checkExpressionValueIsNotNull(safeIdentifier, "SpecialNames.safeIdentifier(klass.name)");
        String identifier = safeIdentifier.getIdentifier();
        Intrinsics.checkExpressionValueIsNotNull(identifier, "SpecialNames.safeIdentifier(klass.name).identifier");
        if (container instanceof PackageFragmentDescriptor) {
            FqName fqName = ((PackageFragmentDescriptor) container).getFqName();
            if (fqName.isRoot()) {
                return identifier;
            }
            StringBuilder sb = new StringBuilder();
            String asString = fqName.asString();
            Intrinsics.checkExpressionValueIsNotNull(asString, "fqName.asString()");
            sb.append(StringsKt.replace$default(asString, '.', (char) IOUtils.DIR_SEPARATOR_UNIX, false, 4, (Object) null));
            sb.append(IOUtils.DIR_SEPARATOR_UNIX);
            sb.append(identifier);
            return sb.toString();
        }
        ClassDescriptor classDescriptor2 = (ClassDescriptor) (!(container instanceof ClassDescriptor) ? null : container);
        if (classDescriptor2 != null) {
            String predefinedInternalNameForClass = typeMappingConfiguration.getPredefinedInternalNameForClass(classDescriptor2);
            if (predefinedInternalNameForClass == null) {
                predefinedInternalNameForClass = computeInternalName(classDescriptor2, typeMappingConfiguration, z);
            }
            return predefinedInternalNameForClass + '$' + identifier;
        }
        throw new IllegalArgumentException("Unexpected container: " + container + " for " + classDescriptor);
    }

    private static final DeclarationDescriptor getContainer(DeclarationDescriptor declarationDescriptor) {
        DeclarationDescriptor declarationDescriptor2 = (ClassDescriptor) (!(declarationDescriptor instanceof ClassDescriptor) ? null : declarationDescriptor);
        if (declarationDescriptor2 == null) {
            declarationDescriptor2 = (PackageFragmentDescriptor) (!(declarationDescriptor instanceof PackageFragmentDescriptor) ? null : declarationDescriptor);
        }
        DeclarationDescriptor declarationDescriptor3 = declarationDescriptor2;
        if (declarationDescriptor3 != null) {
            return declarationDescriptor3;
        }
        if (declarationDescriptor != null) {
            return getContainer(declarationDescriptor.getContainingDeclaration());
        }
        return null;
    }
}
