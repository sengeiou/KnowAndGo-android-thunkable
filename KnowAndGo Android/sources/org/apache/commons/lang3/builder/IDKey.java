package org.apache.commons.lang3.builder;

final class IDKey {

    /* renamed from: id */
    private final int f3033id;
    private final Object value;

    IDKey(Object obj) {
        this.f3033id = System.identityHashCode(obj);
        this.value = obj;
    }

    public int hashCode() {
        return this.f3033id;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof IDKey)) {
            return false;
        }
        IDKey iDKey = (IDKey) obj;
        if (this.f3033id == iDKey.f3033id && this.value == iDKey.value) {
            return true;
        }
        return false;
    }
}
