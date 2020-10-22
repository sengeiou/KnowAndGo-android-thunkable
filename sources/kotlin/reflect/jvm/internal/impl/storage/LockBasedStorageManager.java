package kotlin.reflect.jvm.internal.impl.storage;

import com.polidea.rxandroidble.ClientComponent;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.utils.ExceptionUtilsKt;
import kotlin.reflect.jvm.internal.impl.utils.WrappedValues;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class LockBasedStorageManager implements StorageManager {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final StorageManager NO_LOCKS = new LockBasedStorageManager("NO_LOCKS", ExceptionHandlingStrategy.THROW, NoLock.INSTANCE) {
        private static /* synthetic */ void $$$reportNull$$$0(int i) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$1", "recursionDetectedDefault"}));
        }

        /* access modifiers changed from: protected */
        @NotNull
        public <T> RecursionDetectedResult<T> recursionDetectedDefault() {
            RecursionDetectedResult<T> fallThrough = RecursionDetectedResult.fallThrough();
            if (fallThrough == null) {
                $$$reportNull$$$0(0);
            }
            return fallThrough;
        }
    };
    private static final String PACKAGE_NAME = StringsKt.substringBeforeLast(LockBasedStorageManager.class.getCanonicalName(), ".", "");
    private final String debugText;
    /* access modifiers changed from: private */
    public final ExceptionHandlingStrategy exceptionHandlingStrategy;
    protected final Lock lock;

    public interface ExceptionHandlingStrategy {
        public static final ExceptionHandlingStrategy THROW = new ExceptionHandlingStrategy() {
            private static /* synthetic */ void $$$reportNull$$$0(int i) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"throwable", "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$ExceptionHandlingStrategy$1", "handleException"}));
            }

            @NotNull
            public RuntimeException handleException(@NotNull Throwable th) {
                if (th == null) {
                    $$$reportNull$$$0(0);
                }
                throw ExceptionUtilsKt.rethrow(th);
            }
        };

        @NotNull
        RuntimeException handleException(@NotNull Throwable th);
    }

    private enum NotValue {
        NOT_COMPUTED,
        COMPUTING,
        RECURSION_WAS_DETECTED
    }

    private static /* synthetic */ void $$$reportNull$$$0(int i) {
        String str = (i == 6 || i == 10 || i == 24) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[((i == 6 || i == 10 || i == 24) ? 2 : 3)];
        if (i != 1) {
            switch (i) {
                case 3:
                    break;
                case 4:
                    objArr[0] = "lock";
                    break;
                case 5:
                case 7:
                case 9:
                case 11:
                    objArr[0] = "compute";
                    break;
                case 6:
                case 10:
                case 24:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager";
                    break;
                case 8:
                case 12:
                    objArr[0] = "map";
                    break;
                case 13:
                case 14:
                case 16:
                case 18:
                case 19:
                case 20:
                case 22:
                    objArr[0] = "computable";
                    break;
                case 15:
                    objArr[0] = "onRecursiveCall";
                    break;
                case 17:
                case 21:
                    objArr[0] = "postCompute";
                    break;
                case 23:
                    objArr[0] = "throwable";
                    break;
                default:
                    objArr[0] = "debugText";
                    break;
            }
        }
        objArr[0] = "exceptionHandlingStrategy";
        if (i == 6) {
            objArr[1] = "createMemoizedFunction";
        } else if (i == 10) {
            objArr[1] = "createMemoizedFunctionWithNullableValues";
        } else if (i != 24) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager";
        } else {
            objArr[1] = "sanitizeStackTrace";
        }
        switch (i) {
            case 2:
            case 3:
            case 4:
                objArr[2] = "<init>";
                break;
            case 5:
            case 7:
            case 8:
                objArr[2] = "createMemoizedFunction";
                break;
            case 6:
            case 10:
            case 24:
                break;
            case 9:
            case 11:
            case 12:
                objArr[2] = "createMemoizedFunctionWithNullableValues";
                break;
            case 13:
                objArr[2] = "createLazyValue";
                break;
            case 14:
            case 15:
                objArr[2] = "createRecursionTolerantLazyValue";
                break;
            case 16:
            case 17:
                objArr[2] = "createLazyValueWithPostCompute";
                break;
            case 18:
                objArr[2] = "createNullableLazyValue";
                break;
            case 19:
                objArr[2] = "createRecursionTolerantNullableLazyValue";
                break;
            case 20:
            case 21:
                objArr[2] = "createNullableLazyValueWithPostCompute";
                break;
            case 22:
                objArr[2] = "compute";
                break;
            case 23:
                objArr[2] = "sanitizeStackTrace";
                break;
            default:
                objArr[2] = "createWithExceptionHandling";
                break;
        }
        String format = String.format(str, objArr);
        throw ((i == 6 || i == 10 || i == 24) ? new IllegalStateException(format) : new IllegalArgumentException(format));
    }

    private LockBasedStorageManager(@NotNull String str, @NotNull ExceptionHandlingStrategy exceptionHandlingStrategy2, @NotNull Lock lock2) {
        if (str == null) {
            $$$reportNull$$$0(2);
        }
        if (exceptionHandlingStrategy2 == null) {
            $$$reportNull$$$0(3);
        }
        if (lock2 == null) {
            $$$reportNull$$$0(4);
        }
        this.lock = lock2;
        this.exceptionHandlingStrategy = exceptionHandlingStrategy2;
        this.debugText = str;
    }

    public LockBasedStorageManager(String str) {
        this(str, ExceptionHandlingStrategy.THROW, new ReentrantLock());
    }

    public String toString() {
        return getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()) + " (" + this.debugText + ")";
    }

    @NotNull
    public <K, V> MemoizedFunctionToNotNull<K, V> createMemoizedFunction(@NotNull Function1<? super K, ? extends V> function1) {
        if (function1 == null) {
            $$$reportNull$$$0(5);
        }
        MemoizedFunctionToNotNull<K, V> createMemoizedFunction = createMemoizedFunction(function1, createConcurrentHashMap());
        if (createMemoizedFunction == null) {
            $$$reportNull$$$0(6);
        }
        return createMemoizedFunction;
    }

    @NotNull
    public <K, V> MemoizedFunctionToNotNull<K, V> createMemoizedFunction(@NotNull Function1<? super K, ? extends V> function1, @NotNull ConcurrentMap<K, Object> concurrentMap) {
        if (function1 == null) {
            $$$reportNull$$$0(7);
        }
        if (concurrentMap == null) {
            $$$reportNull$$$0(8);
        }
        return new MapBasedMemoizedFunctionToNotNull(this, concurrentMap, function1);
    }

    @NotNull
    public <K, V> MemoizedFunctionToNullable<K, V> createMemoizedFunctionWithNullableValues(@NotNull Function1<? super K, ? extends V> function1) {
        if (function1 == null) {
            $$$reportNull$$$0(9);
        }
        MemoizedFunctionToNullable<K, V> createMemoizedFunctionWithNullableValues = createMemoizedFunctionWithNullableValues(function1, createConcurrentHashMap());
        if (createMemoizedFunctionWithNullableValues == null) {
            $$$reportNull$$$0(10);
        }
        return createMemoizedFunctionWithNullableValues;
    }

    @NotNull
    public <K, V> MemoizedFunctionToNullable<K, V> createMemoizedFunctionWithNullableValues(@NotNull Function1<? super K, ? extends V> function1, @NotNull ConcurrentMap<K, Object> concurrentMap) {
        if (function1 == null) {
            $$$reportNull$$$0(11);
        }
        if (concurrentMap == null) {
            $$$reportNull$$$0(12);
        }
        return new MapBasedMemoizedFunction(this, concurrentMap, function1);
    }

    @NotNull
    public <T> NotNullLazyValue<T> createLazyValue(@NotNull Function0<? extends T> function0) {
        if (function0 == null) {
            $$$reportNull$$$0(13);
        }
        return new LockBasedNotNullLazyValue(this, function0);
    }

    @NotNull
    public <T> NotNullLazyValue<T> createRecursionTolerantLazyValue(@NotNull Function0<? extends T> function0, @NotNull final T t) {
        if (function0 == null) {
            $$$reportNull$$$0(14);
        }
        if (t == null) {
            $$$reportNull$$$0(15);
        }
        return new LockBasedNotNullLazyValue<T>(this, function0) {
            private static /* synthetic */ void $$$reportNull$$$0(int i) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$2", "recursionDetected"}));
            }

            /* access modifiers changed from: protected */
            @NotNull
            public RecursionDetectedResult<T> recursionDetected(boolean z) {
                RecursionDetectedResult<T> value = RecursionDetectedResult.value(t);
                if (value == null) {
                    $$$reportNull$$$0(0);
                }
                return value;
            }
        };
    }

    @NotNull
    public <T> NotNullLazyValue<T> createLazyValueWithPostCompute(@NotNull Function0<? extends T> function0, Function1<? super Boolean, ? extends T> function1, @NotNull Function1<? super T, Unit> function12) {
        if (function0 == null) {
            $$$reportNull$$$0(16);
        }
        if (function12 == null) {
            $$$reportNull$$$0(17);
        }
        final Function1<? super Boolean, ? extends T> function13 = function1;
        final Function1<? super T, Unit> function14 = function12;
        return new LockBasedNotNullLazyValue<T>(this, function0) {
            private static /* synthetic */ void $$$reportNull$$$0(int i) {
                String str = i != 2 ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                Object[] objArr = new Object[(i != 2 ? 2 : 3)];
                if (i != 2) {
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$3";
                } else {
                    objArr[0] = "value";
                }
                if (i != 2) {
                    objArr[1] = "recursionDetected";
                } else {
                    objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$3";
                }
                if (i == 2) {
                    objArr[2] = "postCompute";
                }
                String format = String.format(str, objArr);
                throw (i != 2 ? new IllegalStateException(format) : new IllegalArgumentException(format));
            }

            /* access modifiers changed from: protected */
            @NotNull
            public RecursionDetectedResult<T> recursionDetected(boolean z) {
                if (function13 == null) {
                    RecursionDetectedResult<T> recursionDetected = super.recursionDetected(z);
                    if (recursionDetected == null) {
                        $$$reportNull$$$0(0);
                    }
                    return recursionDetected;
                }
                RecursionDetectedResult<T> value = RecursionDetectedResult.value(function13.invoke(Boolean.valueOf(z)));
                if (value == null) {
                    $$$reportNull$$$0(1);
                }
                return value;
            }

            /* access modifiers changed from: protected */
            public void postCompute(@NotNull T t) {
                if (t == null) {
                    $$$reportNull$$$0(2);
                }
                function14.invoke(t);
            }
        };
    }

    @NotNull
    public <T> NullableLazyValue<T> createNullableLazyValue(@NotNull Function0<? extends T> function0) {
        if (function0 == null) {
            $$$reportNull$$$0(18);
        }
        return new LockBasedLazyValue(this, function0);
    }

    public <T> T compute(@NotNull Function0<? extends T> function0) {
        if (function0 == null) {
            $$$reportNull$$$0(22);
        }
        this.lock.lock();
        try {
            T invoke = function0.invoke();
            this.lock.unlock();
            return invoke;
        } catch (Throwable th) {
            this.lock.unlock();
            throw th;
        }
    }

    @NotNull
    private static <K> ConcurrentMap<K, Object> createConcurrentHashMap() {
        return new ConcurrentHashMap(3, 1.0f, 2);
    }

    /* access modifiers changed from: protected */
    @NotNull
    public <T> RecursionDetectedResult<T> recursionDetectedDefault() {
        throw ((IllegalStateException) sanitizeStackTrace(new IllegalStateException("Recursive call in a lazy value under " + this)));
    }

    private static class RecursionDetectedResult<T> {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final boolean fallThrough;
        private final T value;

        static {
            Class<LockBasedStorageManager> cls = LockBasedStorageManager.class;
        }

        @NotNull
        public static <T> RecursionDetectedResult<T> value(T t) {
            return new RecursionDetectedResult<>(t, false);
        }

        @NotNull
        public static <T> RecursionDetectedResult<T> fallThrough() {
            return new RecursionDetectedResult<>((Object) null, true);
        }

        private RecursionDetectedResult(T t, boolean z) {
            this.value = t;
            this.fallThrough = z;
        }

        public T getValue() {
            return this.value;
        }

        public boolean isFallThrough() {
            return this.fallThrough;
        }

        public String toString() {
            return isFallThrough() ? "FALL_THROUGH" : String.valueOf(this.value);
        }
    }

    private static class LockBasedLazyValue<T> implements NullableLazyValue<T> {
        private final Function0<? extends T> computable;
        private final LockBasedStorageManager storageManager;
        @Nullable
        private volatile Object value;

        private static /* synthetic */ void $$$reportNull$$$0(int i) {
            String str;
            int i2;
            Throwable th;
            switch (i) {
                case 2:
                case 3:
                    str = "@NotNull method %s.%s must not return null";
                    break;
                default:
                    str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                    break;
            }
            switch (i) {
                case 2:
                case 3:
                    i2 = 2;
                    break;
                default:
                    i2 = 3;
                    break;
            }
            Object[] objArr = new Object[i2];
            switch (i) {
                case 1:
                    objArr[0] = "computable";
                    break;
                case 2:
                case 3:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedLazyValue";
                    break;
                default:
                    objArr[0] = "storageManager";
                    break;
            }
            switch (i) {
                case 2:
                    objArr[1] = "recursionDetected";
                    break;
                case 3:
                    objArr[1] = "renderDebugInformation";
                    break;
                default:
                    objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedLazyValue";
                    break;
            }
            switch (i) {
                case 2:
                case 3:
                    break;
                default:
                    objArr[2] = "<init>";
                    break;
            }
            String format = String.format(str, objArr);
            switch (i) {
                case 2:
                case 3:
                    th = new IllegalStateException(format);
                    break;
                default:
                    th = new IllegalArgumentException(format);
                    break;
            }
            throw th;
        }

        /* access modifiers changed from: protected */
        public void postCompute(T t) {
        }

        public LockBasedLazyValue(@NotNull LockBasedStorageManager lockBasedStorageManager, @NotNull Function0<? extends T> function0) {
            if (lockBasedStorageManager == null) {
                $$$reportNull$$$0(0);
            }
            if (function0 == null) {
                $$$reportNull$$$0(1);
            }
            this.value = NotValue.NOT_COMPUTED;
            this.storageManager = lockBasedStorageManager;
            this.computable = function0;
        }

        public boolean isComputed() {
            return (this.value == NotValue.NOT_COMPUTED || this.value == NotValue.COMPUTING) ? false : true;
        }

        public T invoke() {
            T invoke;
            Object obj = this.value;
            if (!(obj instanceof NotValue)) {
                return WrappedValues.unescapeThrowable(obj);
            }
            this.storageManager.lock.lock();
            try {
                Object obj2 = this.value;
                if (!(obj2 instanceof NotValue)) {
                    invoke = WrappedValues.unescapeThrowable(obj2);
                } else {
                    if (obj2 == NotValue.COMPUTING) {
                        this.value = NotValue.RECURSION_WAS_DETECTED;
                        RecursionDetectedResult recursionDetected = recursionDetected(true);
                        if (!recursionDetected.isFallThrough()) {
                            invoke = recursionDetected.getValue();
                        }
                    }
                    if (obj2 == NotValue.RECURSION_WAS_DETECTED) {
                        RecursionDetectedResult recursionDetected2 = recursionDetected(false);
                        if (!recursionDetected2.isFallThrough()) {
                            invoke = recursionDetected2.getValue();
                        }
                    }
                    this.value = NotValue.COMPUTING;
                    invoke = this.computable.invoke();
                    this.value = invoke;
                    postCompute(invoke);
                }
                this.storageManager.lock.unlock();
                return invoke;
            } catch (Throwable th) {
                this.storageManager.lock.unlock();
                throw th;
            }
        }

        /* access modifiers changed from: protected */
        @NotNull
        public RecursionDetectedResult<T> recursionDetected(boolean z) {
            RecursionDetectedResult<T> recursionDetectedDefault = this.storageManager.recursionDetectedDefault();
            if (recursionDetectedDefault == null) {
                $$$reportNull$$$0(2);
            }
            return recursionDetectedDefault;
        }
    }

    private static class LockBasedNotNullLazyValue<T> extends LockBasedLazyValue<T> implements NotNullLazyValue<T> {
        static final /* synthetic */ boolean $assertionsDisabled = false;

        private static /* synthetic */ void $$$reportNull$$$0(int i) {
            String str = i != 2 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
            Object[] objArr = new Object[(i != 2 ? 3 : 2)];
            switch (i) {
                case 1:
                    objArr[0] = "computable";
                    break;
                case 2:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedNotNullLazyValue";
                    break;
                default:
                    objArr[0] = "storageManager";
                    break;
            }
            if (i != 2) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedNotNullLazyValue";
            } else {
                objArr[1] = "invoke";
            }
            if (i != 2) {
                objArr[2] = "<init>";
            }
            String format = String.format(str, objArr);
            throw (i != 2 ? new IllegalArgumentException(format) : new IllegalStateException(format));
        }

        static {
            Class<LockBasedStorageManager> cls = LockBasedStorageManager.class;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public LockBasedNotNullLazyValue(@NotNull LockBasedStorageManager lockBasedStorageManager, @NotNull Function0<? extends T> function0) {
            super(lockBasedStorageManager, function0);
            if (lockBasedStorageManager == null) {
                $$$reportNull$$$0(0);
            }
            if (function0 == null) {
                $$$reportNull$$$0(1);
            }
        }

        @NotNull
        public T invoke() {
            T invoke = super.invoke();
            if (invoke == null) {
                $$$reportNull$$$0(2);
            }
            return invoke;
        }
    }

    private static class MapBasedMemoizedFunction<K, V> implements MemoizedFunctionToNullable<K, V> {
        private final ConcurrentMap<K, Object> cache;
        private final Function1<? super K, ? extends V> compute;
        private final LockBasedStorageManager storageManager;

        private static /* synthetic */ void $$$reportNull$$$0(int i) {
            String str;
            int i2;
            Throwable th;
            switch (i) {
                case 3:
                case 4:
                    str = "@NotNull method %s.%s must not return null";
                    break;
                default:
                    str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                    break;
            }
            switch (i) {
                case 3:
                case 4:
                    i2 = 2;
                    break;
                default:
                    i2 = 3;
                    break;
            }
            Object[] objArr = new Object[i2];
            switch (i) {
                case 1:
                    objArr[0] = "map";
                    break;
                case 2:
                    objArr[0] = "compute";
                    break;
                case 3:
                case 4:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$MapBasedMemoizedFunction";
                    break;
                default:
                    objArr[0] = "storageManager";
                    break;
            }
            switch (i) {
                case 3:
                    objArr[1] = "recursionDetected";
                    break;
                case 4:
                    objArr[1] = "raceCondition";
                    break;
                default:
                    objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$MapBasedMemoizedFunction";
                    break;
            }
            switch (i) {
                case 3:
                case 4:
                    break;
                default:
                    objArr[2] = "<init>";
                    break;
            }
            String format = String.format(str, objArr);
            switch (i) {
                case 3:
                case 4:
                    th = new IllegalStateException(format);
                    break;
                default:
                    th = new IllegalArgumentException(format);
                    break;
            }
            throw th;
        }

        public MapBasedMemoizedFunction(@NotNull LockBasedStorageManager lockBasedStorageManager, @NotNull ConcurrentMap<K, Object> concurrentMap, @NotNull Function1<? super K, ? extends V> function1) {
            if (lockBasedStorageManager == null) {
                $$$reportNull$$$0(0);
            }
            if (concurrentMap == null) {
                $$$reportNull$$$0(1);
            }
            if (function1 == null) {
                $$$reportNull$$$0(2);
            }
            this.storageManager = lockBasedStorageManager;
            this.cache = concurrentMap;
            this.compute = function1;
        }

        @Nullable
        public V invoke(K k) {
            Object obj = this.cache.get(k);
            if (obj != null && obj != NotValue.COMPUTING) {
                return WrappedValues.unescapeExceptionOrNull(obj);
            }
            this.storageManager.lock.lock();
            try {
                Object obj2 = this.cache.get(k);
                if (obj2 == NotValue.COMPUTING) {
                    throw recursionDetected(k);
                } else if (obj2 != null) {
                    return WrappedValues.unescapeExceptionOrNull(obj2);
                } else {
                    AssertionError assertionError = null;
                    try {
                        this.cache.put(k, NotValue.COMPUTING);
                        V invoke = this.compute.invoke(k);
                        Object put = this.cache.put(k, WrappedValues.escapeNull(invoke));
                        if (put == NotValue.COMPUTING) {
                            this.storageManager.lock.unlock();
                            return invoke;
                        }
                        AssertionError raceCondition = raceCondition(k, put);
                        try {
                            throw raceCondition;
                        } catch (Throwable th) {
                            AssertionError assertionError2 = raceCondition;
                            th = th;
                            assertionError = assertionError2;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (ExceptionUtilsKt.isProcessCanceledException(th)) {
                            this.cache.remove(k);
                            throw ((RuntimeException) th);
                        } else if (th != assertionError) {
                            Object put2 = this.cache.put(k, WrappedValues.escapeThrowable(th));
                            if (put2 != NotValue.COMPUTING) {
                                throw raceCondition(k, put2);
                            }
                            throw this.storageManager.exceptionHandlingStrategy.handleException(th);
                        } else {
                            throw this.storageManager.exceptionHandlingStrategy.handleException(th);
                        }
                    }
                }
            } finally {
                this.storageManager.lock.unlock();
            }
        }

        @NotNull
        private AssertionError recursionDetected(K k) {
            AssertionError assertionError = (AssertionError) LockBasedStorageManager.sanitizeStackTrace(new AssertionError("Recursion detected on input: " + k + " under " + this.storageManager));
            if (assertionError == null) {
                $$$reportNull$$$0(3);
            }
            return assertionError;
        }

        @NotNull
        private AssertionError raceCondition(K k, Object obj) {
            AssertionError assertionError = (AssertionError) LockBasedStorageManager.sanitizeStackTrace(new AssertionError("Race condition detected on input " + k + ". Old value is " + obj + " under " + this.storageManager));
            if (assertionError == null) {
                $$$reportNull$$$0(4);
            }
            return assertionError;
        }

        /* access modifiers changed from: protected */
        public LockBasedStorageManager getStorageManager() {
            return this.storageManager;
        }
    }

    private static class MapBasedMemoizedFunctionToNotNull<K, V> extends MapBasedMemoizedFunction<K, V> implements MemoizedFunctionToNotNull<K, V> {
        static final /* synthetic */ boolean $assertionsDisabled = false;

        private static /* synthetic */ void $$$reportNull$$$0(int i) {
            String str = i != 3 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
            Object[] objArr = new Object[(i != 3 ? 3 : 2)];
            switch (i) {
                case 1:
                    objArr[0] = "map";
                    break;
                case 2:
                    objArr[0] = "compute";
                    break;
                case 3:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$MapBasedMemoizedFunctionToNotNull";
                    break;
                default:
                    objArr[0] = "storageManager";
                    break;
            }
            if (i != 3) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$MapBasedMemoizedFunctionToNotNull";
            } else {
                objArr[1] = "invoke";
            }
            if (i != 3) {
                objArr[2] = "<init>";
            }
            String format = String.format(str, objArr);
            throw (i != 3 ? new IllegalArgumentException(format) : new IllegalStateException(format));
        }

        static {
            Class<LockBasedStorageManager> cls = LockBasedStorageManager.class;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public MapBasedMemoizedFunctionToNotNull(@NotNull LockBasedStorageManager lockBasedStorageManager, @NotNull ConcurrentMap<K, Object> concurrentMap, @NotNull Function1<? super K, ? extends V> function1) {
            super(lockBasedStorageManager, concurrentMap, function1);
            if (lockBasedStorageManager == null) {
                $$$reportNull$$$0(0);
            }
            if (concurrentMap == null) {
                $$$reportNull$$$0(1);
            }
            if (function1 == null) {
                $$$reportNull$$$0(2);
            }
        }

        @NotNull
        public V invoke(K k) {
            V invoke = super.invoke(k);
            if (invoke == null) {
                $$$reportNull$$$0(3);
            }
            return invoke;
        }
    }

    /* access modifiers changed from: private */
    @NotNull
    public static <T extends Throwable> T sanitizeStackTrace(@NotNull T t) {
        if (t == null) {
            $$$reportNull$$$0(23);
        }
        StackTraceElement[] stackTrace = t.getStackTrace();
        int length = stackTrace.length;
        int i = -1;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                break;
            } else if (!stackTrace[i2].getClassName().startsWith(PACKAGE_NAME)) {
                i = i2;
                break;
            } else {
                i2++;
            }
        }
        List subList = Arrays.asList(stackTrace).subList(i, length);
        t.setStackTrace((StackTraceElement[]) subList.toArray(new StackTraceElement[subList.size()]));
        if (t == null) {
            $$$reportNull$$$0(24);
        }
        return t;
    }

    private static class CacheWithNullableValuesBasedOnMemoizedFunction<K, V> extends MapBasedMemoizedFunction<KeyWithComputation<K, V>, V> {
        private static /* synthetic */ void $$$reportNull$$$0(int i) {
            Object[] objArr = new Object[3];
            switch (i) {
                case 1:
                    objArr[0] = "map";
                    break;
                case 2:
                    objArr[0] = ClientComponent.NamedSchedulers.COMPUTATION;
                    break;
                default:
                    objArr[0] = "storageManager";
                    break;
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$CacheWithNullableValuesBasedOnMemoizedFunction";
            if (i != 2) {
                objArr[2] = "<init>";
            } else {
                objArr[2] = "computeIfAbsent";
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        private CacheWithNullableValuesBasedOnMemoizedFunction(@NotNull LockBasedStorageManager lockBasedStorageManager, @NotNull ConcurrentMap<KeyWithComputation<K, V>, Object> concurrentMap) {
            super(lockBasedStorageManager, concurrentMap, new Function1<KeyWithComputation<K, V>, V>() {
                public V invoke(KeyWithComputation<K, V> keyWithComputation) {
                    return keyWithComputation.computation.invoke();
                }
            });
            if (lockBasedStorageManager == null) {
                $$$reportNull$$$0(0);
            }
            if (concurrentMap == null) {
                $$$reportNull$$$0(1);
            }
        }

        @Nullable
        public V computeIfAbsent(K k, @NotNull Function0<? extends V> function0) {
            if (function0 == null) {
                $$$reportNull$$$0(2);
            }
            return invoke(new KeyWithComputation(k, function0));
        }
    }

    @NotNull
    public <K, V> CacheWithNotNullValues<K, V> createCacheWithNotNullValues() {
        return new CacheWithNotNullValuesBasedOnMemoizedFunction(createConcurrentHashMap());
    }

    private static class CacheWithNotNullValuesBasedOnMemoizedFunction<K, V> extends CacheWithNullableValuesBasedOnMemoizedFunction<K, V> implements CacheWithNotNullValues<K, V> {
        static final /* synthetic */ boolean $assertionsDisabled = false;

        private static /* synthetic */ void $$$reportNull$$$0(int i) {
            String str = i != 3 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
            Object[] objArr = new Object[(i != 3 ? 3 : 2)];
            switch (i) {
                case 1:
                    objArr[0] = "map";
                    break;
                case 2:
                    objArr[0] = ClientComponent.NamedSchedulers.COMPUTATION;
                    break;
                case 3:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$CacheWithNotNullValuesBasedOnMemoizedFunction";
                    break;
                default:
                    objArr[0] = "storageManager";
                    break;
            }
            if (i != 3) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$CacheWithNotNullValuesBasedOnMemoizedFunction";
            } else {
                objArr[1] = "computeIfAbsent";
            }
            switch (i) {
                case 2:
                    objArr[2] = "computeIfAbsent";
                    break;
                case 3:
                    break;
                default:
                    objArr[2] = "<init>";
                    break;
            }
            String format = String.format(str, objArr);
            throw (i != 3 ? new IllegalArgumentException(format) : new IllegalStateException(format));
        }

        static {
            Class<LockBasedStorageManager> cls = LockBasedStorageManager.class;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        private CacheWithNotNullValuesBasedOnMemoizedFunction(@NotNull LockBasedStorageManager lockBasedStorageManager, @NotNull ConcurrentMap<KeyWithComputation<K, V>, Object> concurrentMap) {
            super(concurrentMap);
            if (lockBasedStorageManager == null) {
                $$$reportNull$$$0(0);
            }
            if (concurrentMap == null) {
                $$$reportNull$$$0(1);
            }
        }

        @NotNull
        public V computeIfAbsent(K k, @NotNull Function0<? extends V> function0) {
            if (function0 == null) {
                $$$reportNull$$$0(2);
            }
            V computeIfAbsent = super.computeIfAbsent(k, function0);
            if (computeIfAbsent == null) {
                $$$reportNull$$$0(3);
            }
            return computeIfAbsent;
        }
    }

    private static class KeyWithComputation<K, V> {
        /* access modifiers changed from: private */
        public final Function0<? extends V> computation;
        private final K key;

        public KeyWithComputation(K k, Function0<? extends V> function0) {
            this.key = k;
            this.computation = function0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.key.equals(((KeyWithComputation) obj).key);
        }

        public int hashCode() {
            return this.key.hashCode();
        }
    }
}
