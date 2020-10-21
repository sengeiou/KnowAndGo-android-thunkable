package kotlin.reflect.jvm.internal.impl.metadata.deserialization;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: protoTypeTableUtil.kt */
public final class ProtoTypeTableUtilKt {
    @NotNull
    public static final List<ProtoBuf.Type> supertypes(@NotNull ProtoBuf.Class classR, @NotNull TypeTable typeTable) {
        Intrinsics.checkParameterIsNotNull(classR, "$this$supertypes");
        Intrinsics.checkParameterIsNotNull(typeTable, "typeTable");
        List<ProtoBuf.Type> supertypeList = classR.getSupertypeList();
        if (!(!supertypeList.isEmpty())) {
            supertypeList = null;
        }
        if (supertypeList != null) {
            return supertypeList;
        }
        List<Integer> supertypeIdList = classR.getSupertypeIdList();
        Intrinsics.checkExpressionValueIsNotNull(supertypeIdList, "supertypeIdList");
        Iterable<Integer> iterable = supertypeIdList;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (Integer num : iterable) {
            Intrinsics.checkExpressionValueIsNotNull(num, "it");
            arrayList.add(typeTable.get(num.intValue()));
        }
        return (List) arrayList;
    }

    @Nullable
    public static final ProtoBuf.Type type(@NotNull ProtoBuf.Type.Argument argument, @NotNull TypeTable typeTable) {
        Intrinsics.checkParameterIsNotNull(argument, "$this$type");
        Intrinsics.checkParameterIsNotNull(typeTable, "typeTable");
        if (argument.hasType()) {
            return argument.getType();
        }
        if (argument.hasTypeId()) {
            return typeTable.get(argument.getTypeId());
        }
        return null;
    }

    @Nullable
    public static final ProtoBuf.Type flexibleUpperBound(@NotNull ProtoBuf.Type type, @NotNull TypeTable typeTable) {
        Intrinsics.checkParameterIsNotNull(type, "$this$flexibleUpperBound");
        Intrinsics.checkParameterIsNotNull(typeTable, "typeTable");
        if (type.hasFlexibleUpperBound()) {
            return type.getFlexibleUpperBound();
        }
        if (type.hasFlexibleUpperBoundId()) {
            return typeTable.get(type.getFlexibleUpperBoundId());
        }
        return null;
    }

    @NotNull
    public static final List<ProtoBuf.Type> upperBounds(@NotNull ProtoBuf.TypeParameter typeParameter, @NotNull TypeTable typeTable) {
        Intrinsics.checkParameterIsNotNull(typeParameter, "$this$upperBounds");
        Intrinsics.checkParameterIsNotNull(typeTable, "typeTable");
        List<ProtoBuf.Type> upperBoundList = typeParameter.getUpperBoundList();
        if (!(!upperBoundList.isEmpty())) {
            upperBoundList = null;
        }
        if (upperBoundList != null) {
            return upperBoundList;
        }
        List<Integer> upperBoundIdList = typeParameter.getUpperBoundIdList();
        Intrinsics.checkExpressionValueIsNotNull(upperBoundIdList, "upperBoundIdList");
        Iterable<Integer> iterable = upperBoundIdList;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (Integer num : iterable) {
            Intrinsics.checkExpressionValueIsNotNull(num, "it");
            arrayList.add(typeTable.get(num.intValue()));
        }
        return (List) arrayList;
    }

    @NotNull
    public static final ProtoBuf.Type returnType(@NotNull ProtoBuf.Function function, @NotNull TypeTable typeTable) {
        Intrinsics.checkParameterIsNotNull(function, "$this$returnType");
        Intrinsics.checkParameterIsNotNull(typeTable, "typeTable");
        if (function.hasReturnType()) {
            ProtoBuf.Type returnType = function.getReturnType();
            Intrinsics.checkExpressionValueIsNotNull(returnType, "returnType");
            return returnType;
        } else if (function.hasReturnTypeId()) {
            return typeTable.get(function.getReturnTypeId());
        } else {
            throw new IllegalStateException("No returnType in ProtoBuf.Function".toString());
        }
    }

    public static final boolean hasReceiver(@NotNull ProtoBuf.Function function) {
        Intrinsics.checkParameterIsNotNull(function, "$this$hasReceiver");
        return function.hasReceiverType() || function.hasReceiverTypeId();
    }

    @Nullable
    public static final ProtoBuf.Type receiverType(@NotNull ProtoBuf.Function function, @NotNull TypeTable typeTable) {
        Intrinsics.checkParameterIsNotNull(function, "$this$receiverType");
        Intrinsics.checkParameterIsNotNull(typeTable, "typeTable");
        if (function.hasReceiverType()) {
            return function.getReceiverType();
        }
        if (function.hasReceiverTypeId()) {
            return typeTable.get(function.getReceiverTypeId());
        }
        return null;
    }

    @NotNull
    public static final ProtoBuf.Type returnType(@NotNull ProtoBuf.Property property, @NotNull TypeTable typeTable) {
        Intrinsics.checkParameterIsNotNull(property, "$this$returnType");
        Intrinsics.checkParameterIsNotNull(typeTable, "typeTable");
        if (property.hasReturnType()) {
            ProtoBuf.Type returnType = property.getReturnType();
            Intrinsics.checkExpressionValueIsNotNull(returnType, "returnType");
            return returnType;
        } else if (property.hasReturnTypeId()) {
            return typeTable.get(property.getReturnTypeId());
        } else {
            throw new IllegalStateException("No returnType in ProtoBuf.Property".toString());
        }
    }

    public static final boolean hasReceiver(@NotNull ProtoBuf.Property property) {
        Intrinsics.checkParameterIsNotNull(property, "$this$hasReceiver");
        return property.hasReceiverType() || property.hasReceiverTypeId();
    }

    @Nullable
    public static final ProtoBuf.Type receiverType(@NotNull ProtoBuf.Property property, @NotNull TypeTable typeTable) {
        Intrinsics.checkParameterIsNotNull(property, "$this$receiverType");
        Intrinsics.checkParameterIsNotNull(typeTable, "typeTable");
        if (property.hasReceiverType()) {
            return property.getReceiverType();
        }
        if (property.hasReceiverTypeId()) {
            return typeTable.get(property.getReceiverTypeId());
        }
        return null;
    }

    @NotNull
    public static final ProtoBuf.Type type(@NotNull ProtoBuf.ValueParameter valueParameter, @NotNull TypeTable typeTable) {
        Intrinsics.checkParameterIsNotNull(valueParameter, "$this$type");
        Intrinsics.checkParameterIsNotNull(typeTable, "typeTable");
        if (valueParameter.hasType()) {
            ProtoBuf.Type type = valueParameter.getType();
            Intrinsics.checkExpressionValueIsNotNull(type, "type");
            return type;
        } else if (valueParameter.hasTypeId()) {
            return typeTable.get(valueParameter.getTypeId());
        } else {
            throw new IllegalStateException("No type in ProtoBuf.ValueParameter".toString());
        }
    }

    @Nullable
    public static final ProtoBuf.Type varargElementType(@NotNull ProtoBuf.ValueParameter valueParameter, @NotNull TypeTable typeTable) {
        Intrinsics.checkParameterIsNotNull(valueParameter, "$this$varargElementType");
        Intrinsics.checkParameterIsNotNull(typeTable, "typeTable");
        if (valueParameter.hasVarargElementType()) {
            return valueParameter.getVarargElementType();
        }
        if (valueParameter.hasVarargElementTypeId()) {
            return typeTable.get(valueParameter.getVarargElementTypeId());
        }
        return null;
    }

    @Nullable
    public static final ProtoBuf.Type outerType(@NotNull ProtoBuf.Type type, @NotNull TypeTable typeTable) {
        Intrinsics.checkParameterIsNotNull(type, "$this$outerType");
        Intrinsics.checkParameterIsNotNull(typeTable, "typeTable");
        if (type.hasOuterType()) {
            return type.getOuterType();
        }
        if (type.hasOuterTypeId()) {
            return typeTable.get(type.getOuterTypeId());
        }
        return null;
    }

    @Nullable
    public static final ProtoBuf.Type abbreviatedType(@NotNull ProtoBuf.Type type, @NotNull TypeTable typeTable) {
        Intrinsics.checkParameterIsNotNull(type, "$this$abbreviatedType");
        Intrinsics.checkParameterIsNotNull(typeTable, "typeTable");
        if (type.hasAbbreviatedType()) {
            return type.getAbbreviatedType();
        }
        if (type.hasAbbreviatedTypeId()) {
            return typeTable.get(type.getAbbreviatedTypeId());
        }
        return null;
    }

    @NotNull
    public static final ProtoBuf.Type underlyingType(@NotNull ProtoBuf.TypeAlias typeAlias, @NotNull TypeTable typeTable) {
        Intrinsics.checkParameterIsNotNull(typeAlias, "$this$underlyingType");
        Intrinsics.checkParameterIsNotNull(typeTable, "typeTable");
        if (typeAlias.hasUnderlyingType()) {
            ProtoBuf.Type underlyingType = typeAlias.getUnderlyingType();
            Intrinsics.checkExpressionValueIsNotNull(underlyingType, "underlyingType");
            return underlyingType;
        } else if (typeAlias.hasUnderlyingTypeId()) {
            return typeTable.get(typeAlias.getUnderlyingTypeId());
        } else {
            throw new IllegalStateException("No underlyingType in ProtoBuf.TypeAlias".toString());
        }
    }

    @NotNull
    public static final ProtoBuf.Type expandedType(@NotNull ProtoBuf.TypeAlias typeAlias, @NotNull TypeTable typeTable) {
        Intrinsics.checkParameterIsNotNull(typeAlias, "$this$expandedType");
        Intrinsics.checkParameterIsNotNull(typeTable, "typeTable");
        if (typeAlias.hasExpandedType()) {
            ProtoBuf.Type expandedType = typeAlias.getExpandedType();
            Intrinsics.checkExpressionValueIsNotNull(expandedType, "expandedType");
            return expandedType;
        } else if (typeAlias.hasExpandedTypeId()) {
            return typeTable.get(typeAlias.getExpandedTypeId());
        } else {
            throw new IllegalStateException("No expandedType in ProtoBuf.TypeAlias".toString());
        }
    }
}