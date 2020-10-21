package p033rx.schedulers;

/* renamed from: rx.schedulers.Timestamped */
public final class Timestamped<T> {
    private final long timestampMillis;
    private final T value;

    public Timestamped(long j, T t) {
        this.value = t;
        this.timestampMillis = j;
    }

    public long getTimestampMillis() {
        return this.timestampMillis;
    }

    public T getValue() {
        return this.value;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof Timestamped)) {
            return false;
        }
        Timestamped timestamped = (Timestamped) obj;
        if (this.timestampMillis == timestamped.timestampMillis) {
            if (this.value == timestamped.value) {
                return true;
            }
            if (this.value == null || !this.value.equals(timestamped.value)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((((int) (this.timestampMillis ^ (this.timestampMillis >>> 32))) + 31) * 31) + (this.value == null ? 0 : this.value.hashCode());
    }

    public String toString() {
        return String.format("Timestamped(timestampMillis = %d, value = %s)", new Object[]{Long.valueOf(this.timestampMillis), this.value.toString()});
    }
}
