package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

import androidx.exifinterface.media.ExifInterface;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: ClassMapperLite.kt */
public final class ClassMapperLite {
    public static final ClassMapperLite INSTANCE = new ClassMapperLite();
    private static final Map<String, String> map;

    static {
        Map<String, String> linkedHashMap = new LinkedHashMap<>();
        List listOf = CollectionsKt.listOf("Boolean", "Z", "Char", "C", "Byte", "B", "Short", ExifInterface.LATITUDE_SOUTH, "Int", "I", "Float", "F", "Long", "J", "Double", "D");
        IntProgression step = RangesKt.step((IntProgression) CollectionsKt.getIndices(listOf), 2);
        int first = step.getFirst();
        int last = step.getLast();
        int step2 = step.getStep();
        if (step2 < 0 ? first >= last : first <= last) {
            while (true) {
                int i = first + 1;
                linkedHashMap.put("kotlin/" + ((String) listOf.get(first)), listOf.get(i));
                linkedHashMap.put("kotlin/" + ((String) listOf.get(first)) + "Array", '[' + ((String) listOf.get(i)));
                if (first == last) {
                    break;
                }
                first += step2;
            }
        }
        linkedHashMap.put("kotlin/Unit", ExifInterface.GPS_MEASUREMENT_INTERRUPTED);
        ClassMapperLite$map$1$1 classMapperLite$map$1$1 = new ClassMapperLite$map$1$1(linkedHashMap);
        classMapperLite$map$1$1.invoke("Any", "java/lang/Object");
        classMapperLite$map$1$1.invoke("Nothing", "java/lang/Void");
        classMapperLite$map$1$1.invoke("Annotation", "java/lang/annotation/Annotation");
        for (String str : CollectionsKt.listOf("String", "CharSequence", "Throwable", "Cloneable", "Number", "Comparable", "Enum")) {
            classMapperLite$map$1$1.invoke(str, "java/lang/" + str);
        }
        for (String str2 : CollectionsKt.listOf("Iterator", "Collection", "List", "Set", "Map", "ListIterator")) {
            classMapperLite$map$1$1.invoke("collections/" + str2, "java/util/" + str2);
            classMapperLite$map$1$1.invoke("collections/Mutable" + str2, "java/util/" + str2);
        }
        classMapperLite$map$1$1.invoke("collections/Iterable", "java/lang/Iterable");
        classMapperLite$map$1$1.invoke("collections/MutableIterable", "java/lang/Iterable");
        classMapperLite$map$1$1.invoke("collections/Map.Entry", "java/util/Map$Entry");
        classMapperLite$map$1$1.invoke("collections/MutableMap.MutableEntry", "java/util/Map$Entry");
        for (int i2 = 0; i2 <= 22; i2++) {
            classMapperLite$map$1$1.invoke("Function" + i2, "kotlin/jvm/functions/Function" + i2);
            classMapperLite$map$1$1.invoke("reflect/KFunction" + i2, "kotlin/reflect/KFunction");
        }
        for (String str3 : CollectionsKt.listOf("Char", "Byte", "Short", "Int", "Float", "Long", "Double", "String", "Enum")) {
            classMapperLite$map$1$1.invoke(str3 + ".Companion", "kotlin/jvm/internal/" + str3 + "CompanionObject");
        }
        map = linkedHashMap;
    }

    private ClassMapperLite() {
    }

    @JvmStatic
    @NotNull
    public static final String mapClass(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "classId");
        String str2 = map.get(str);
        if (str2 != null) {
            return str2;
        }
        return 'L' + StringsKt.replace$default(str, '.', '$', false, 4, (Object) null) + ';';
    }
}
