package kotlin.reflect.jvm.internal;

import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.structure.ReflectClassUtilKt;
import org.jetbrains.annotations.NotNull;

@Metadata(mo39784bv = {1, 0, 3}, mo39785d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028BX\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, mo39786d2 = {"signature", "", "Ljava/lang/reflect/Method;", "getSignature", "(Ljava/lang/reflect/Method;)Ljava/lang/String;", "kotlin-reflection"}, mo39787k = 2, mo39788mv = {1, 1, 15})
/* compiled from: RuntimeTypeMapper.kt */
public final class RuntimeTypeMapperKt {
    /* access modifiers changed from: private */
    public static final String getSignature(@NotNull Method method) {
        StringBuilder sb = new StringBuilder();
        sb.append(method.getName());
        Class[] parameterTypes = method.getParameterTypes();
        Intrinsics.checkExpressionValueIsNotNull(parameterTypes, "parameterTypes");
        sb.append(ArraysKt.joinToString$default((Object[]) parameterTypes, (CharSequence) "", (CharSequence) "(", (CharSequence) ")", 0, (CharSequence) null, (Function1) RuntimeTypeMapperKt$signature$1.INSTANCE, 24, (Object) null));
        Class<?> returnType = method.getReturnType();
        Intrinsics.checkExpressionValueIsNotNull(returnType, "returnType");
        sb.append(ReflectClassUtilKt.getDesc(returnType));
        return sb.toString();
    }
}
