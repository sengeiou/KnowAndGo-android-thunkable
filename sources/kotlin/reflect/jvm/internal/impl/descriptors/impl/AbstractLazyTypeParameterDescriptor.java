package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;

public abstract class AbstractLazyTypeParameterDescriptor extends AbstractTypeParameterDescriptor {
    private static /* synthetic */ void $$$reportNull$$$0(int i) {
        Object[] objArr = new Object[3];
        switch (i) {
            case 1:
                objArr[0] = "containingDeclaration";
                break;
            case 2:
                objArr[0] = "name";
                break;
            case 3:
                objArr[0] = "variance";
                break;
            case 4:
                objArr[0] = "source";
                break;
            case 5:
                objArr[0] = "supertypeLoopChecker";
                break;
            default:
                objArr[0] = "storageManager";
                break;
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractLazyTypeParameterDescriptor";
        objArr[2] = "<init>";
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AbstractLazyTypeParameterDescriptor(@NotNull StorageManager storageManager, @NotNull DeclarationDescriptor declarationDescriptor, @NotNull Name name, @NotNull Variance variance, boolean z, int i, @NotNull SourceElement sourceElement, @NotNull SupertypeLoopChecker supertypeLoopChecker) {
        super(storageManager, declarationDescriptor, Annotations.Companion.getEMPTY(), name, variance, z, i, sourceElement, supertypeLoopChecker);
        if (storageManager == null) {
            $$$reportNull$$$0(0);
        }
        if (declarationDescriptor == null) {
            $$$reportNull$$$0(1);
        }
        if (name == null) {
            $$$reportNull$$$0(2);
        }
        if (variance == null) {
            $$$reportNull$$$0(3);
        }
        if (sourceElement == null) {
            $$$reportNull$$$0(4);
        }
        if (supertypeLoopChecker == null) {
            $$$reportNull$$$0(5);
        }
    }

    public String toString() {
        String str;
        Object[] objArr = new Object[3];
        objArr[0] = isReified() ? "reified " : "";
        if (getVariance() == Variance.INVARIANT) {
            str = "";
        } else {
            str = getVariance() + StringUtils.SPACE;
        }
        objArr[1] = str;
        objArr[2] = getName();
        return String.format("%s%s%s", objArr);
    }
}