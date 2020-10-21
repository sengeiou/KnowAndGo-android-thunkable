package p033rx;

import p033rx.exceptions.MissingBackpressureException;

/* renamed from: rx.BackpressureOverflow */
public final class BackpressureOverflow {
    public static final Strategy ON_OVERFLOW_DEFAULT = ON_OVERFLOW_ERROR;
    public static final Strategy ON_OVERFLOW_DROP_LATEST = DropLatest.INSTANCE;
    public static final Strategy ON_OVERFLOW_DROP_OLDEST = DropOldest.INSTANCE;
    public static final Strategy ON_OVERFLOW_ERROR = Error.INSTANCE;

    /* renamed from: rx.BackpressureOverflow$Strategy */
    public interface Strategy {
        boolean mayAttemptDrop() throws MissingBackpressureException;
    }

    private BackpressureOverflow() {
        throw new IllegalStateException("No instances!");
    }

    /* renamed from: rx.BackpressureOverflow$DropOldest */
    static final class DropOldest implements Strategy {
        static final DropOldest INSTANCE = new DropOldest();

        public boolean mayAttemptDrop() {
            return true;
        }

        private DropOldest() {
        }
    }

    /* renamed from: rx.BackpressureOverflow$DropLatest */
    static final class DropLatest implements Strategy {
        static final DropLatest INSTANCE = new DropLatest();

        public boolean mayAttemptDrop() {
            return false;
        }

        private DropLatest() {
        }
    }

    /* renamed from: rx.BackpressureOverflow$Error */
    static final class Error implements Strategy {
        static final Error INSTANCE = new Error();

        private Error() {
        }

        public boolean mayAttemptDrop() throws MissingBackpressureException {
            throw new MissingBackpressureException("Overflowed buffer");
        }
    }
}
