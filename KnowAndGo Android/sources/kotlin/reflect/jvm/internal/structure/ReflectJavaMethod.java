package kotlin.reflect.jvm.internal.structure;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaValueParameter;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.structure.ReflectJavaType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo39784bv = {1, 0, 3}, mo39785d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00078VX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\r8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118VX\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u00118VX\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0014¨\u0006\u0018"}, mo39786d2 = {"Lkotlin/reflect/jvm/internal/structure/ReflectJavaMethod;", "Lkotlin/reflect/jvm/internal/structure/ReflectJavaMember;", "Lkotlin/reflect/jvm/internal/impl/load/java/structure/JavaMethod;", "member", "Ljava/lang/reflect/Method;", "(Ljava/lang/reflect/Method;)V", "annotationParameterDefaultValue", "Lkotlin/reflect/jvm/internal/impl/load/java/structure/JavaAnnotationArgument;", "getAnnotationParameterDefaultValue", "()Lorg/jetbrains/kotlin/load/java/structure/JavaAnnotationArgument;", "getMember", "()Ljava/lang/reflect/Method;", "returnType", "Lkotlin/reflect/jvm/internal/structure/ReflectJavaType;", "getReturnType", "()Lkotlin/reflect/jvm/internal/structure/ReflectJavaType;", "typeParameters", "", "Lkotlin/reflect/jvm/internal/structure/ReflectJavaTypeParameter;", "getTypeParameters", "()Ljava/util/List;", "valueParameters", "Lkotlin/reflect/jvm/internal/impl/load/java/structure/JavaValueParameter;", "getValueParameters", "descriptors.runtime"}, mo39787k = 1, mo39788mv = {1, 1, 15})
/* compiled from: ReflectJavaMethod.kt */
public final class ReflectJavaMethod extends ReflectJavaMember implements JavaMethod {
    @NotNull
    private final Method member;

    public ReflectJavaMethod(@NotNull Method method) {
        Intrinsics.checkParameterIsNotNull(method, "member");
        this.member = method;
    }

    public boolean getHasAnnotationParameterDefaultValue() {
        return JavaMethod.DefaultImpls.getHasAnnotationParameterDefaultValue(this);
    }

    @NotNull
    public Method getMember() {
        return this.member;
    }

    @NotNull
    public List<JavaValueParameter> getValueParameters() {
        Type[] genericParameterTypes = getMember().getGenericParameterTypes();
        Intrinsics.checkExpressionValueIsNotNull(genericParameterTypes, "member.genericParameterTypes");
        Annotation[][] parameterAnnotations = getMember().getParameterAnnotations();
        Intrinsics.checkExpressionValueIsNotNull(parameterAnnotations, "member.parameterAnnotations");
        return getValueParameters(genericParameterTypes, parameterAnnotations, getMember().isVarArgs());
    }

    @NotNull
    public ReflectJavaType getReturnType() {
        ReflectJavaType.Factory factory = ReflectJavaType.Factory;
        Type genericReturnType = getMember().getGenericReturnType();
        Intrinsics.checkExpressionValueIsNotNull(genericReturnType, "member.genericReturnType");
        return factory.create(genericReturnType);
    }

    @Nullable
    public JavaAnnotationArgument getAnnotationParameterDefaultValue() {
        Object defaultValue = getMember().getDefaultValue();
        ReflectJavaAnnotationArgument reflectJavaAnnotationArgument = null;
        if (defaultValue != null) {
            reflectJavaAnnotationArgument = ReflectJavaAnnotationArgument.Factory.create(defaultValue, (Name) null);
        }
        return reflectJavaAnnotationArgument;
    }

    @NotNull
    public List<ReflectJavaTypeParameter> getTypeParameters() {
        TypeVariable[] typeParameters = getMember().getTypeParameters();
        Intrinsics.checkExpressionValueIsNotNull(typeParameters, "member.typeParameters");
        Collection arrayList = new ArrayList(typeParameters.length);
        for (TypeVariable reflectJavaTypeParameter : typeParameters) {
            arrayList.add(new ReflectJavaTypeParameter(reflectJavaTypeParameter));
        }
        return (List) arrayList;
    }
}
