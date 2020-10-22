package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: JvmNameResolver.kt */
public final class JvmNameResolver implements NameResolver {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final List<String> PREDEFINED_STRINGS = CollectionsKt.listOf("kotlin/Any", "kotlin/Nothing", "kotlin/Unit", "kotlin/Throwable", "kotlin/Number", "kotlin/Byte", "kotlin/Double", "kotlin/Float", "kotlin/Int", "kotlin/Long", "kotlin/Short", "kotlin/Boolean", "kotlin/Char", "kotlin/CharSequence", "kotlin/String", "kotlin/Comparable", "kotlin/Enum", "kotlin/Array", "kotlin/ByteArray", "kotlin/DoubleArray", "kotlin/FloatArray", "kotlin/IntArray", "kotlin/LongArray", "kotlin/ShortArray", "kotlin/BooleanArray", "kotlin/CharArray", "kotlin/Cloneable", "kotlin/Annotation", "kotlin/collections/Iterable", "kotlin/collections/MutableIterable", "kotlin/collections/Collection", "kotlin/collections/MutableCollection", "kotlin/collections/List", "kotlin/collections/MutableList", "kotlin/collections/Set", "kotlin/collections/MutableSet", "kotlin/collections/Map", "kotlin/collections/MutableMap", "kotlin/collections/Map.Entry", "kotlin/collections/MutableMap.MutableEntry", "kotlin/collections/Iterator", "kotlin/collections/MutableIterator", "kotlin/collections/ListIterator", "kotlin/collections/MutableListIterator");
    private static final Map<String, Integer> PREDEFINED_STRINGS_MAP;
    private final Set<Integer> localNameIndices;
    @NotNull
    private final List<JvmProtoBuf.StringTableTypes.Record> records;
    @NotNull
    private final String[] strings;
    @NotNull
    private final JvmProtoBuf.StringTableTypes types;

    public JvmNameResolver(@NotNull JvmProtoBuf.StringTableTypes stringTableTypes, @NotNull String[] strArr) {
        Intrinsics.checkParameterIsNotNull(stringTableTypes, "types");
        Intrinsics.checkParameterIsNotNull(strArr, "strings");
        this.types = stringTableTypes;
        this.strings = strArr;
        List<Integer> localNameList = this.types.getLocalNameList();
        this.localNameIndices = localNameList.isEmpty() ? SetsKt.emptySet() : CollectionsKt.toSet(localNameList);
        ArrayList arrayList = new ArrayList();
        List<JvmProtoBuf.StringTableTypes.Record> recordList = this.types.getRecordList();
        arrayList.ensureCapacity(recordList.size());
        for (JvmProtoBuf.StringTableTypes.Record next : recordList) {
            Intrinsics.checkExpressionValueIsNotNull(next, "record");
            int range = next.getRange();
            for (int i = 0; i < range; i++) {
                arrayList.add(next);
            }
        }
        arrayList.trimToSize();
        this.records = arrayList;
    }

    @NotNull
    public String getString(int i) {
        String str;
        JvmProtoBuf.StringTableTypes.Record record = this.records.get(i);
        if (record.hasString()) {
            str = record.getString();
        } else {
            if (record.hasPredefinedIndex()) {
                int size = PREDEFINED_STRINGS.size();
                int predefinedIndex = record.getPredefinedIndex();
                if (predefinedIndex >= 0 && size > predefinedIndex) {
                    str = PREDEFINED_STRINGS.get(record.getPredefinedIndex());
                }
            }
            str = this.strings[i];
        }
        if (record.getSubstringIndexCount() >= 2) {
            List<Integer> substringIndexList = record.getSubstringIndexList();
            Integer num = substringIndexList.get(0);
            Integer num2 = substringIndexList.get(1);
            Intrinsics.checkExpressionValueIsNotNull(num, "begin");
            if (Intrinsics.compare(0, num.intValue()) <= 0) {
                int intValue = num.intValue();
                Intrinsics.checkExpressionValueIsNotNull(num2, "end");
                if (Intrinsics.compare(intValue, num2.intValue()) <= 0 && Intrinsics.compare(num2.intValue(), str.length()) <= 0) {
                    Intrinsics.checkExpressionValueIsNotNull(str, "string");
                    int intValue2 = num.intValue();
                    int intValue3 = num2.intValue();
                    if (str != null) {
                        str = str.substring(intValue2, intValue3);
                        Intrinsics.checkExpressionValueIsNotNull(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    } else {
                        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                    }
                }
            }
        }
        String str2 = str;
        if (record.getReplaceCharCount() >= 2) {
            List<Integer> replaceCharList = record.getReplaceCharList();
            Intrinsics.checkExpressionValueIsNotNull(str2, "string");
            str2 = StringsKt.replace$default(str2, (char) replaceCharList.get(0).intValue(), (char) replaceCharList.get(1).intValue(), false, 4, (Object) null);
        }
        String str3 = str2;
        JvmProtoBuf.StringTableTypes.Record.Operation operation = record.getOperation();
        if (operation == null) {
            operation = JvmProtoBuf.StringTableTypes.Record.Operation.NONE;
        }
        switch (operation) {
            case INTERNAL_TO_CLASS_ID:
                Intrinsics.checkExpressionValueIsNotNull(str3, "string");
                str3 = StringsKt.replace$default(str3, '$', '.', false, 4, (Object) null);
                break;
            case DESC_TO_CLASS_ID:
                if (str3.length() >= 2) {
                    Intrinsics.checkExpressionValueIsNotNull(str3, "string");
                    int length = str3.length() - 1;
                    if (str3 != null) {
                        str3 = str3.substring(1, length);
                        Intrinsics.checkExpressionValueIsNotNull(str3, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    } else {
                        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                    }
                }
                String str4 = str3;
                Intrinsics.checkExpressionValueIsNotNull(str4, "string");
                str3 = StringsKt.replace$default(str4, '$', '.', false, 4, (Object) null);
                break;
        }
        Intrinsics.checkExpressionValueIsNotNull(str3, "string");
        return str3;
    }

    @NotNull
    public String getQualifiedClassName(int i) {
        return getString(i);
    }

    public boolean isLocalClassName(int i) {
        return this.localNameIndices.contains(Integer.valueOf(i));
    }

    /* compiled from: JvmNameResolver.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Iterable<IndexedValue> withIndex = CollectionsKt.withIndex(PREDEFINED_STRINGS);
        Map<String, Integer> linkedHashMap = new LinkedHashMap<>(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(withIndex, 10)), 16));
        for (IndexedValue indexedValue : withIndex) {
            linkedHashMap.put((String) indexedValue.getValue(), Integer.valueOf(indexedValue.getIndex()));
        }
        PREDEFINED_STRINGS_MAP = linkedHashMap;
    }
}
