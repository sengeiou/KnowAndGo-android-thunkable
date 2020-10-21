package kotlin.reflect.jvm.internal.pcollections;

import java.io.Serializable;

final class MapEntry<K, V> implements Serializable {
    public final K key;
    public final V value;

    public MapEntry(K k, V v) {
        this.key = k;
        this.value = v;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x002e A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r4) {
        /*
            r3 = this;
            boolean r0 = r4 instanceof kotlin.reflect.jvm.internal.pcollections.MapEntry
            r1 = 0
            if (r0 != 0) goto L_0x0006
            return r1
        L_0x0006:
            kotlin.reflect.jvm.internal.pcollections.MapEntry r4 = (kotlin.reflect.jvm.internal.pcollections.MapEntry) r4
            K r0 = r3.key
            if (r0 != 0) goto L_0x0011
            K r0 = r4.key
            if (r0 != 0) goto L_0x002f
            goto L_0x001b
        L_0x0011:
            K r0 = r3.key
            K r2 = r4.key
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x002f
        L_0x001b:
            V r0 = r3.value
            if (r0 != 0) goto L_0x0024
            V r4 = r4.value
            if (r4 != 0) goto L_0x002f
            goto L_0x002e
        L_0x0024:
            V r0 = r3.value
            V r4 = r4.value
            boolean r4 = r0.equals(r4)
            if (r4 == 0) goto L_0x002f
        L_0x002e:
            r1 = 1
        L_0x002f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.pcollections.MapEntry.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        int i = 0;
        int hashCode = this.key == null ? 0 : this.key.hashCode();
        if (this.value != null) {
            i = this.value.hashCode();
        }
        return hashCode ^ i;
    }

    public String toString() {
        return this.key + "=" + this.value;
    }
}
