package kotlin.reflect.jvm.internal.impl.types.checker;

import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker;
import org.jetbrains.annotations.NotNull;

public class KotlinTypeCheckerImpl implements KotlinTypeChecker {
    private final TypeCheckingProcedure procedure;

    private static /* synthetic */ void $$$reportNull$$$0(int i) {
        Object[] objArr = new Object[3];
        switch (i) {
            case 1:
                objArr[0] = "procedure";
                break;
            case 2:
                objArr[0] = "subtype";
                break;
            case 3:
                objArr[0] = "supertype";
                break;
            case 4:
                objArr[0] = NotificationBundleProcessor.PUSH_ADDITIONAL_DATA_KEY;
                break;
            case 5:
                objArr[0] = "b";
                break;
            default:
                objArr[0] = "equalityAxioms";
                break;
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/types/checker/KotlinTypeCheckerImpl";
        switch (i) {
            case 1:
                objArr[2] = "<init>";
                break;
            case 2:
            case 3:
                objArr[2] = "isSubtypeOf";
                break;
            case 4:
            case 5:
                objArr[2] = "equalTypes";
                break;
            default:
                objArr[2] = "withAxioms";
                break;
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    @NotNull
    public static KotlinTypeChecker withAxioms(@NotNull final KotlinTypeChecker.TypeConstructorEquality typeConstructorEquality) {
        if (typeConstructorEquality == null) {
            $$$reportNull$$$0(0);
        }
        return new KotlinTypeCheckerImpl(new TypeCheckingProcedure(new TypeCheckerProcedureCallbacksImpl() {
            private static /* synthetic */ void $$$reportNull$$$0(int i) {
                Object[] objArr = new Object[3];
                if (i != 1) {
                    objArr[0] = "constructor1";
                } else {
                    objArr[0] = "constructor2";
                }
                objArr[1] = "kotlin/reflect/jvm/internal/impl/types/checker/KotlinTypeCheckerImpl$1";
                objArr[2] = "assertEqualTypeConstructors";
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
            }

            public boolean assertEqualTypeConstructors(@NotNull TypeConstructor typeConstructor, @NotNull TypeConstructor typeConstructor2) {
                if (typeConstructor == null) {
                    $$$reportNull$$$0(0);
                }
                if (typeConstructor2 == null) {
                    $$$reportNull$$$0(1);
                }
                return typeConstructor.equals(typeConstructor2) || typeConstructorEquality.equals(typeConstructor, typeConstructor2);
            }
        }));
    }

    protected KotlinTypeCheckerImpl(@NotNull TypeCheckingProcedure typeCheckingProcedure) {
        if (typeCheckingProcedure == null) {
            $$$reportNull$$$0(1);
        }
        this.procedure = typeCheckingProcedure;
    }

    public boolean isSubtypeOf(@NotNull KotlinType kotlinType, @NotNull KotlinType kotlinType2) {
        if (kotlinType == null) {
            $$$reportNull$$$0(2);
        }
        if (kotlinType2 == null) {
            $$$reportNull$$$0(3);
        }
        return this.procedure.isSubtypeOf(kotlinType, kotlinType2);
    }

    public boolean equalTypes(@NotNull KotlinType kotlinType, @NotNull KotlinType kotlinType2) {
        if (kotlinType == null) {
            $$$reportNull$$$0(4);
        }
        if (kotlinType2 == null) {
            $$$reportNull$$$0(5);
        }
        return this.procedure.equalTypes(kotlinType, kotlinType2);
    }
}
