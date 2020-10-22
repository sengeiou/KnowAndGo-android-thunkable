package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import java.util.Map;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class AnnotationDescriptorImpl implements AnnotationDescriptor {
    private final KotlinType annotationType;
    private final SourceElement source;
    private final Map<Name, ConstantValue<?>> valueArguments;

    private static /* synthetic */ void $$$reportNull$$$0(int i) {
        String str;
        int i2;
        Throwable th;
        switch (i) {
            case 3:
            case 4:
            case 5:
                str = "@NotNull method %s.%s must not return null";
                break;
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i) {
            case 3:
            case 4:
            case 5:
                i2 = 2;
                break;
            default:
                i2 = 3;
                break;
        }
        Object[] objArr = new Object[i2];
        switch (i) {
            case 1:
                objArr[0] = "valueArguments";
                break;
            case 2:
                objArr[0] = "source";
                break;
            case 3:
            case 4:
            case 5:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/annotations/AnnotationDescriptorImpl";
                break;
            default:
                objArr[0] = "annotationType";
                break;
        }
        switch (i) {
            case 3:
                objArr[1] = "getType";
                break;
            case 4:
                objArr[1] = "getAllValueArguments";
                break;
            case 5:
                objArr[1] = "getSource";
                break;
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/annotations/AnnotationDescriptorImpl";
                break;
        }
        switch (i) {
            case 3:
            case 4:
            case 5:
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        switch (i) {
            case 3:
            case 4:
            case 5:
                th = new IllegalStateException(format);
                break;
            default:
                th = new IllegalArgumentException(format);
                break;
        }
        throw th;
    }

    public AnnotationDescriptorImpl(@NotNull KotlinType kotlinType, @NotNull Map<Name, ConstantValue<?>> map, @NotNull SourceElement sourceElement) {
        if (kotlinType == null) {
            $$$reportNull$$$0(0);
        }
        if (map == null) {
            $$$reportNull$$$0(1);
        }
        if (sourceElement == null) {
            $$$reportNull$$$0(2);
        }
        this.annotationType = kotlinType;
        this.valueArguments = map;
        this.source = sourceElement;
    }

    @NotNull
    public KotlinType getType() {
        KotlinType kotlinType = this.annotationType;
        if (kotlinType == null) {
            $$$reportNull$$$0(3);
        }
        return kotlinType;
    }

    @Nullable
    public FqName getFqName() {
        return AnnotationDescriptor.DefaultImpls.getFqName(this);
    }

    @NotNull
    public Map<Name, ConstantValue<?>> getAllValueArguments() {
        Map<Name, ConstantValue<?>> map = this.valueArguments;
        if (map == null) {
            $$$reportNull$$$0(4);
        }
        return map;
    }

    @NotNull
    public SourceElement getSource() {
        SourceElement sourceElement = this.source;
        if (sourceElement == null) {
            $$$reportNull$$$0(5);
        }
        return sourceElement;
    }

    public String toString() {
        return DescriptorRenderer.FQ_NAMES_IN_TYPES.renderAnnotation(this, (AnnotationUseSiteTarget) null);
    }
}
