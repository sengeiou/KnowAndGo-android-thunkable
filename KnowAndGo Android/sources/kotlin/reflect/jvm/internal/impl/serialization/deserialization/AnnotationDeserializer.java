package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.constants.AnnotationValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ArrayValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.BooleanValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ByteValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.CharValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValueFactory;
import kotlin.reflect.jvm.internal.impl.resolve.constants.DoubleValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.EnumValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ErrorValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.FloatValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.IntValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.KClassValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.LongValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ShortValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.StringValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.UByteValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.UIntValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ULongValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.UShortValue;
import kotlin.reflect.jvm.internal.impl.types.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import org.jetbrains.annotations.NotNull;

/* compiled from: AnnotationDeserializer.kt */
public final class AnnotationDeserializer {
    private final ModuleDescriptor module;
    private final NotFoundClasses notFoundClasses;

    public AnnotationDeserializer(@NotNull ModuleDescriptor moduleDescriptor, @NotNull NotFoundClasses notFoundClasses2) {
        Intrinsics.checkParameterIsNotNull(moduleDescriptor, "module");
        Intrinsics.checkParameterIsNotNull(notFoundClasses2, "notFoundClasses");
        this.module = moduleDescriptor;
        this.notFoundClasses = notFoundClasses2;
    }

    private final KotlinBuiltIns getBuiltIns() {
        return this.module.getBuiltIns();
    }

    @NotNull
    public final AnnotationDescriptor deserializeAnnotation(@NotNull ProtoBuf.Annotation annotation, @NotNull NameResolver nameResolver) {
        Intrinsics.checkParameterIsNotNull(annotation, "proto");
        Intrinsics.checkParameterIsNotNull(nameResolver, "nameResolver");
        ClassDescriptor resolveClass = resolveClass(NameResolverUtilKt.getClassId(nameResolver, annotation.getId()));
        Map emptyMap = MapsKt.emptyMap();
        if (annotation.getArgumentCount() != 0) {
            DeclarationDescriptor declarationDescriptor = resolveClass;
            if (!ErrorUtils.isError(declarationDescriptor) && DescriptorUtils.isAnnotationClass(declarationDescriptor)) {
                Collection<ClassConstructorDescriptor> constructors = resolveClass.getConstructors();
                Intrinsics.checkExpressionValueIsNotNull(constructors, "annotationClass.constructors");
                ClassConstructorDescriptor classConstructorDescriptor = (ClassConstructorDescriptor) CollectionsKt.singleOrNull(constructors);
                if (classConstructorDescriptor != null) {
                    List<ValueParameterDescriptor> valueParameters = classConstructorDescriptor.getValueParameters();
                    Intrinsics.checkExpressionValueIsNotNull(valueParameters, "constructor.valueParameters");
                    Iterable iterable = valueParameters;
                    Map linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(iterable, 10)), 16));
                    for (Object next : iterable) {
                        ValueParameterDescriptor valueParameterDescriptor = (ValueParameterDescriptor) next;
                        Intrinsics.checkExpressionValueIsNotNull(valueParameterDescriptor, "it");
                        linkedHashMap.put(valueParameterDescriptor.getName(), next);
                    }
                    List<ProtoBuf.Annotation.Argument> argumentList = annotation.getArgumentList();
                    Intrinsics.checkExpressionValueIsNotNull(argumentList, "proto.argumentList");
                    Collection arrayList = new ArrayList();
                    for (ProtoBuf.Annotation.Argument argument : argumentList) {
                        Intrinsics.checkExpressionValueIsNotNull(argument, "it");
                        Pair<Name, ConstantValue<?>> resolveArgument = resolveArgument(argument, linkedHashMap, nameResolver);
                        if (resolveArgument != null) {
                            arrayList.add(resolveArgument);
                        }
                    }
                    emptyMap = MapsKt.toMap((List) arrayList);
                }
            }
        }
        return new AnnotationDescriptorImpl(resolveClass.getDefaultType(), emptyMap, SourceElement.NO_SOURCE);
    }

    private final Pair<Name, ConstantValue<?>> resolveArgument(ProtoBuf.Annotation.Argument argument, Map<Name, ? extends ValueParameterDescriptor> map, NameResolver nameResolver) {
        ValueParameterDescriptor valueParameterDescriptor = (ValueParameterDescriptor) map.get(NameResolverUtilKt.getName(nameResolver, argument.getNameId()));
        if (valueParameterDescriptor == null) {
            return null;
        }
        Name name = NameResolverUtilKt.getName(nameResolver, argument.getNameId());
        KotlinType type = valueParameterDescriptor.getType();
        Intrinsics.checkExpressionValueIsNotNull(type, "parameter.type");
        ProtoBuf.Annotation.Argument.Value value = argument.getValue();
        Intrinsics.checkExpressionValueIsNotNull(value, "proto.value");
        return new Pair<>(name, resolveValueAndCheckExpectedType(type, value, nameResolver));
    }

    private final ConstantValue<?> resolveValueAndCheckExpectedType(KotlinType kotlinType, ProtoBuf.Annotation.Argument.Value value, NameResolver nameResolver) {
        ConstantValue<?> resolveValue = resolveValue(kotlinType, value, nameResolver);
        if (!doesValueConformToExpectedType(resolveValue, kotlinType, value)) {
            resolveValue = null;
        }
        if (resolveValue != null) {
            return resolveValue;
        }
        ErrorValue.Companion companion = ErrorValue.Companion;
        return companion.create("Unexpected argument value: actual type " + value.getType() + " != expected type " + kotlinType);
    }

    @NotNull
    public final ConstantValue<?> resolveValue(@NotNull KotlinType kotlinType, @NotNull ProtoBuf.Annotation.Argument.Value value, @NotNull NameResolver nameResolver) {
        ConstantValue<?> constantValue;
        Intrinsics.checkParameterIsNotNull(kotlinType, "expectedType");
        Intrinsics.checkParameterIsNotNull(value, "value");
        Intrinsics.checkParameterIsNotNull(nameResolver, "nameResolver");
        Boolean bool = Flags.IS_UNSIGNED.get(value.getFlags());
        Intrinsics.checkExpressionValueIsNotNull(bool, "Flags.IS_UNSIGNED.get(value.flags)");
        boolean booleanValue = bool.booleanValue();
        ProtoBuf.Annotation.Argument.Value.Type type = value.getType();
        if (type != null) {
            switch (type) {
                case BYTE:
                    byte intValue = (byte) ((int) value.getIntValue());
                    if (booleanValue) {
                        constantValue = new UByteValue(intValue);
                    } else {
                        constantValue = new ByteValue(intValue);
                    }
                    return constantValue;
                case CHAR:
                    return new CharValue((char) ((int) value.getIntValue()));
                case SHORT:
                    short intValue2 = (short) ((int) value.getIntValue());
                    return booleanValue ? new UShortValue(intValue2) : new ShortValue(intValue2);
                case INT:
                    int intValue3 = (int) value.getIntValue();
                    return booleanValue ? new UIntValue(intValue3) : new IntValue(intValue3);
                case LONG:
                    long intValue4 = value.getIntValue();
                    return booleanValue ? new ULongValue(intValue4) : new LongValue(intValue4);
                case FLOAT:
                    return new FloatValue(value.getFloatValue());
                case DOUBLE:
                    return new DoubleValue(value.getDoubleValue());
                case BOOLEAN:
                    return new BooleanValue(value.getIntValue() != 0);
                case STRING:
                    return new StringValue(nameResolver.getString(value.getStringValue()));
                case CLASS:
                    return new KClassValue(NameResolverUtilKt.getClassId(nameResolver, value.getClassId()), value.getArrayDimensionCount());
                case ENUM:
                    return new EnumValue(NameResolverUtilKt.getClassId(nameResolver, value.getClassId()), NameResolverUtilKt.getName(nameResolver, value.getEnumValueId()));
                case ANNOTATION:
                    ProtoBuf.Annotation annotation = value.getAnnotation();
                    Intrinsics.checkExpressionValueIsNotNull(annotation, "value.annotation");
                    return new AnnotationValue(deserializeAnnotation(annotation, nameResolver));
                case ARRAY:
                    ConstantValueFactory constantValueFactory = ConstantValueFactory.INSTANCE;
                    List<ProtoBuf.Annotation.Argument.Value> arrayElementList = value.getArrayElementList();
                    Intrinsics.checkExpressionValueIsNotNull(arrayElementList, "value.arrayElementList");
                    Iterable<ProtoBuf.Annotation.Argument.Value> iterable = arrayElementList;
                    Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
                    for (ProtoBuf.Annotation.Argument.Value value2 : iterable) {
                        SimpleType anyType = getBuiltIns().getAnyType();
                        Intrinsics.checkExpressionValueIsNotNull(anyType, "builtIns.anyType");
                        Intrinsics.checkExpressionValueIsNotNull(value2, "it");
                        arrayList.add(resolveValue(anyType, value2, nameResolver));
                    }
                    return constantValueFactory.createArrayValue((List<? extends ConstantValue<?>>) (List) arrayList, kotlinType);
            }
        }
        throw new IllegalStateException(("Unsupported annotation argument type: " + value.getType() + " (expected " + kotlinType + ')').toString());
    }

    private final boolean doesValueConformToExpectedType(ConstantValue<?> constantValue, KotlinType kotlinType, ProtoBuf.Annotation.Argument.Value value) {
        ProtoBuf.Annotation.Argument.Value.Type type = value.getType();
        if (type != null) {
            switch (type) {
                case CLASS:
                    ClassifierDescriptor declarationDescriptor = kotlinType.getConstructor().getDeclarationDescriptor();
                    if (!(declarationDescriptor instanceof ClassDescriptor)) {
                        declarationDescriptor = null;
                    }
                    ClassDescriptor classDescriptor = (ClassDescriptor) declarationDescriptor;
                    if (classDescriptor == null || KotlinBuiltIns.isKClass(classDescriptor)) {
                        return true;
                    }
                    return false;
                case ARRAY:
                    if ((constantValue instanceof ArrayValue) && ((List) ((ArrayValue) constantValue).getValue()).size() == value.getArrayElementList().size()) {
                        KotlinType arrayElementType = getBuiltIns().getArrayElementType(kotlinType);
                        Intrinsics.checkExpressionValueIsNotNull(arrayElementType, "builtIns.getArrayElementType(expectedType)");
                        ArrayValue arrayValue = (ArrayValue) constantValue;
                        Iterable indices = CollectionsKt.getIndices((Collection) arrayValue.getValue());
                        if (!(indices instanceof Collection) || !((Collection) indices).isEmpty()) {
                            Iterator it = indices.iterator();
                            while (it.hasNext()) {
                                int nextInt = ((IntIterator) it).nextInt();
                                ProtoBuf.Annotation.Argument.Value arrayElement = value.getArrayElement(nextInt);
                                Intrinsics.checkExpressionValueIsNotNull(arrayElement, "value.getArrayElement(i)");
                                if (!doesValueConformToExpectedType((ConstantValue) ((List) arrayValue.getValue()).get(nextInt), arrayElementType, arrayElement)) {
                                    return false;
                                }
                            }
                            break;
                        }
                    } else {
                        throw new IllegalStateException(("Deserialized ArrayValue should have the same number of elements as the original array value: " + constantValue).toString());
                    }
                    break;
            }
        }
        return Intrinsics.areEqual((Object) constantValue.getType(this.module), (Object) kotlinType);
    }

    private final ClassDescriptor resolveClass(ClassId classId) {
        return FindClassInModuleKt.findNonGenericClassAcrossDependencies(this.module, classId, this.notFoundClasses);
    }
}
