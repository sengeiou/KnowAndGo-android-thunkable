package kotlin.reflect.jvm.internal.impl.load.kotlin;

import androidx.exifinterface.media.ExifInterface;
import kotlin.NoWhenBranchMatchedException;
import kotlin._Assertions;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmClassName;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: methodSignatureMapping.kt */
final class JvmTypeFactoryImpl implements JvmTypeFactory<JvmType> {
    public static final JvmTypeFactoryImpl INSTANCE = new JvmTypeFactoryImpl();

    private JvmTypeFactoryImpl() {
    }

    @NotNull
    public JvmType boxType(@NotNull JvmType jvmType) {
        Intrinsics.checkParameterIsNotNull(jvmType, "possiblyPrimitiveType");
        if (!(jvmType instanceof JvmType.Primitive)) {
            return jvmType;
        }
        JvmType.Primitive primitive = (JvmType.Primitive) jvmType;
        if (primitive.getJvmPrimitiveType() == null) {
            return jvmType;
        }
        JvmClassName byFqNameWithoutInnerClasses = JvmClassName.byFqNameWithoutInnerClasses(primitive.getJvmPrimitiveType().getWrapperFqName());
        Intrinsics.checkExpressionValueIsNotNull(byFqNameWithoutInnerClasses, "JvmClassName.byFqNameWit…mitiveType.wrapperFqName)");
        String internalName = byFqNameWithoutInnerClasses.getInternalName();
        Intrinsics.checkExpressionValueIsNotNull(internalName, "JvmClassName.byFqNameWit…apperFqName).internalName");
        return createObjectType(internalName);
    }

    @NotNull
    public JvmType createFromString(@NotNull String str) {
        JvmPrimitiveType jvmPrimitiveType;
        Intrinsics.checkParameterIsNotNull(str, "representation");
        CharSequence charSequence = str;
        boolean z = false;
        boolean z2 = charSequence.length() > 0;
        if (!_Assertions.ENABLED || z2) {
            char charAt = str.charAt(0);
            JvmPrimitiveType[] values = JvmPrimitiveType.values();
            int length = values.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    jvmPrimitiveType = null;
                    break;
                }
                jvmPrimitiveType = values[i];
                if (jvmPrimitiveType.getDesc().charAt(0) == charAt) {
                    break;
                }
                i++;
            }
            if (jvmPrimitiveType != null) {
                return new JvmType.Primitive(jvmPrimitiveType);
            }
            if (charAt == 'V') {
                return new JvmType.Primitive((JvmPrimitiveType) null);
            }
            if (charAt != '[') {
                if (charAt == 'L' && StringsKt.endsWith$default(charSequence, ';', false, 2, (Object) null)) {
                    z = true;
                }
                if (!_Assertions.ENABLED || z) {
                    String substring = str.substring(1, str.length() - 1);
                    Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    return new JvmType.Object(substring);
                }
                throw new AssertionError("Type that is not primitive nor array should be Object, but '" + str + "' was found");
            }
            String substring2 = str.substring(1);
            Intrinsics.checkExpressionValueIsNotNull(substring2, "(this as java.lang.String).substring(startIndex)");
            return new JvmType.Array(createFromString(substring2));
        }
        throw new AssertionError("empty string as JvmType");
    }

    @NotNull
    public JvmType.Object createObjectType(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "internalName");
        return new JvmType.Object(str);
    }

    @NotNull
    public String toString(@NotNull JvmType jvmType) {
        String desc;
        Intrinsics.checkParameterIsNotNull(jvmType, "type");
        if (jvmType instanceof JvmType.Array) {
            return "[" + toString(((JvmType.Array) jvmType).getElementType());
        } else if (jvmType instanceof JvmType.Primitive) {
            JvmPrimitiveType jvmPrimitiveType = ((JvmType.Primitive) jvmType).getJvmPrimitiveType();
            if (jvmPrimitiveType == null || (desc = jvmPrimitiveType.getDesc()) == null) {
                return ExifInterface.GPS_MEASUREMENT_INTERRUPTED;
            }
            return desc;
        } else if (jvmType instanceof JvmType.Object) {
            return "L" + ((JvmType.Object) jvmType).getInternalName() + ";";
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    @NotNull
    public JvmType getJavaLangClassType() {
        return createObjectType("java/lang/Class");
    }
}
