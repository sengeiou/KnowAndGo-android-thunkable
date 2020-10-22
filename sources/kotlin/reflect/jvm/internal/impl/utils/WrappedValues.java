package kotlin.reflect.jvm.internal.impl.utils;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class WrappedValues {
    private static final Object NULL_VALUE = new Object() {
        public String toString() {
            return "NULL_VALUE";
        }
    };
    public static volatile boolean throwWrappedProcessCanceledException = false;

    private static /* synthetic */ void $$$reportNull$$$0(int i) {
        String str;
        int i2;
        Throwable th;
        switch (i) {
            case 1:
            case 2:
                str = "@NotNull method %s.%s must not return null";
                break;
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i) {
            case 1:
            case 2:
                i2 = 2;
                break;
            default:
                i2 = 3;
                break;
        }
        Object[] objArr = new Object[i2];
        switch (i) {
            case 1:
            case 2:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/utils/WrappedValues";
                break;
            case 3:
                objArr[0] = "throwable";
                break;
            default:
                objArr[0] = "value";
                break;
        }
        switch (i) {
            case 1:
            case 2:
                objArr[1] = "escapeNull";
                break;
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/utils/WrappedValues";
                break;
        }
        switch (i) {
            case 1:
            case 2:
                break;
            case 3:
                objArr[2] = "escapeThrowable";
                break;
            case 4:
                objArr[2] = "unescapeExceptionOrNull";
                break;
            default:
                objArr[2] = "unescapeNull";
                break;
        }
        String format = String.format(str, objArr);
        switch (i) {
            case 1:
            case 2:
                th = new IllegalStateException(format);
                break;
            default:
                th = new IllegalArgumentException(format);
                break;
        }
        throw th;
    }

    private static final class ThrowableWrapper {
        private final Throwable throwable;

        private static /* synthetic */ void $$$reportNull$$$0(int i) {
            String str = i != 1 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
            Object[] objArr = new Object[(i != 1 ? 3 : 2)];
            if (i != 1) {
                objArr[0] = "throwable";
            } else {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/utils/WrappedValues$ThrowableWrapper";
            }
            if (i != 1) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/utils/WrappedValues$ThrowableWrapper";
            } else {
                objArr[1] = "getThrowable";
            }
            if (i != 1) {
                objArr[2] = "<init>";
            }
            String format = String.format(str, objArr);
            throw (i != 1 ? new IllegalArgumentException(format) : new IllegalStateException(format));
        }

        private ThrowableWrapper(@NotNull Throwable th) {
            if (th == null) {
                $$$reportNull$$$0(0);
            }
            this.throwable = th;
        }

        @NotNull
        public Throwable getThrowable() {
            Throwable th = this.throwable;
            if (th == null) {
                $$$reportNull$$$0(1);
            }
            return th;
        }

        public String toString() {
            return this.throwable.toString();
        }
    }

    @Nullable
    public static <V> V unescapeNull(@NotNull Object obj) {
        if (obj == null) {
            $$$reportNull$$$0(0);
        }
        if (obj == NULL_VALUE) {
            return null;
        }
        return obj;
    }

    @NotNull
    public static <V> Object escapeNull(@Nullable V v) {
        if (v == null) {
            Object obj = NULL_VALUE;
            if (obj == null) {
                $$$reportNull$$$0(1);
            }
            return obj;
        }
        if (v == null) {
            $$$reportNull$$$0(2);
        }
        return v;
    }

    @NotNull
    public static Object escapeThrowable(@NotNull Throwable th) {
        if (th == null) {
            $$$reportNull$$$0(3);
        }
        return new ThrowableWrapper(th);
    }

    @Nullable
    public static <V> V unescapeExceptionOrNull(@NotNull Object obj) {
        if (obj == null) {
            $$$reportNull$$$0(4);
        }
        return unescapeNull(unescapeThrowable(obj));
    }

    @Nullable
    public static <V> V unescapeThrowable(@Nullable Object obj) {
        if (!(obj instanceof ThrowableWrapper)) {
            return obj;
        }
        Throwable throwable = ((ThrowableWrapper) obj).getThrowable();
        if (!throwWrappedProcessCanceledException || !ExceptionUtilsKt.isProcessCanceledException(throwable)) {
            throw ExceptionUtilsKt.rethrow(throwable);
        }
        throw new WrappedProcessCanceledException(throwable);
    }

    public static class WrappedProcessCanceledException extends RuntimeException {
        public WrappedProcessCanceledException(Throwable th) {
            super("Rethrow stored exception", th);
        }
    }
}
