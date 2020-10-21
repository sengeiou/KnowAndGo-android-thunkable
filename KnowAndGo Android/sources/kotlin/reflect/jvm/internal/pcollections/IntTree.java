package kotlin.reflect.jvm.internal.pcollections;

final class IntTree<V> {
    static final IntTree<Object> EMPTYNODE = new IntTree<>();
    private final long key;
    private final IntTree<V> left;
    private final IntTree<V> right;
    private final int size;
    private final V value;

    private IntTree() {
        this.size = 0;
        this.key = 0;
        this.value = null;
        this.left = null;
        this.right = null;
    }

    private IntTree(long j, V v, IntTree<V> intTree, IntTree<V> intTree2) {
        this.key = j;
        this.value = v;
        this.left = intTree;
        this.right = intTree2;
        this.size = intTree.size + 1 + intTree2.size;
    }

    private IntTree<V> withKey(long j) {
        if (this.size == 0 || j == this.key) {
            return this;
        }
        return new IntTree(j, this.value, this.left, this.right);
    }

    /* access modifiers changed from: package-private */
    public V get(long j) {
        if (this.size == 0) {
            return null;
        }
        if (j < this.key) {
            return this.left.get(j - this.key);
        }
        if (j > this.key) {
            return this.right.get(j - this.key);
        }
        return this.value;
    }

    /* access modifiers changed from: package-private */
    public IntTree<V> plus(long j, V v) {
        if (this.size == 0) {
            return new IntTree(j, v, this, this);
        }
        if (j < this.key) {
            return rebalanced(this.left.plus(j - this.key, v), this.right);
        }
        if (j > this.key) {
            return rebalanced(this.left, this.right.plus(j - this.key, v));
        }
        if (v == this.value) {
            return this;
        }
        return new IntTree(j, v, this.left, this.right);
    }

    /* access modifiers changed from: package-private */
    public IntTree<V> minus(long j) {
        if (this.size == 0) {
            return this;
        }
        if (j < this.key) {
            return rebalanced(this.left.minus(j - this.key), this.right);
        }
        if (j > this.key) {
            return rebalanced(this.left, this.right.minus(j - this.key));
        }
        if (this.left.size == 0) {
            return this.right.withKey(this.right.key + this.key);
        }
        if (this.right.size == 0) {
            return this.left.withKey(this.left.key + this.key);
        }
        long minKey = this.right.minKey() + this.key;
        V v = this.right.get(minKey - this.key);
        IntTree<V> minus = this.right.minus(minKey - this.key);
        return rebalanced(minKey, v, this.left.withKey((this.left.key + this.key) - minKey), minus.withKey((minus.key + this.key) - minKey));
    }

    private long minKey() {
        if (this.left.size == 0) {
            return this.key;
        }
        return this.left.minKey() + this.key;
    }

    private IntTree<V> rebalanced(IntTree<V> intTree, IntTree<V> intTree2) {
        if (intTree == this.left && intTree2 == this.right) {
            return this;
        }
        return rebalanced(this.key, this.value, intTree, intTree2);
    }

    private static <V> IntTree<V> rebalanced(long j, V v, IntTree<V> intTree, IntTree<V> intTree2) {
        IntTree<V> intTree3 = intTree;
        IntTree<V> intTree4 = intTree2;
        if (intTree3.size + intTree4.size > 1) {
            if (intTree3.size >= intTree4.size * 5) {
                IntTree<V> intTree5 = intTree3.left;
                IntTree<V> intTree6 = intTree3.right;
                if (intTree6.size < intTree5.size * 2) {
                    return new IntTree(intTree3.key + j, intTree3.value, intTree5, new IntTree(-intTree3.key, v, intTree6.withKey(intTree6.key + intTree3.key), intTree2));
                }
                IntTree<V> intTree7 = intTree6.left;
                IntTree<V> intTree8 = intTree6.right;
                return new IntTree(intTree6.key + intTree3.key + j, intTree6.value, new IntTree(-intTree6.key, intTree3.value, intTree5, intTree7.withKey(intTree7.key + intTree6.key)), new IntTree((-intTree3.key) - intTree6.key, v, intTree8.withKey(intTree8.key + intTree6.key + intTree3.key), intTree2));
            } else if (intTree4.size >= intTree3.size * 5) {
                IntTree<V> intTree9 = intTree4.left;
                IntTree<V> intTree10 = intTree4.right;
                if (intTree9.size < intTree10.size * 2) {
                    return new IntTree(intTree4.key + j, intTree4.value, new IntTree(-intTree4.key, v, intTree, intTree9.withKey(intTree9.key + intTree4.key)), intTree10);
                }
                IntTree<V> intTree11 = intTree9.left;
                IntTree<V> intTree12 = intTree9.right;
                V v2 = intTree9.value;
                long j2 = (-intTree4.key) - intTree9.key;
                return new IntTree(intTree9.key + intTree4.key + j, v2, new IntTree(j2, v, intTree, intTree11.withKey(intTree11.key + intTree9.key + intTree4.key)), new IntTree(-intTree9.key, intTree4.value, intTree12.withKey(intTree12.key + intTree9.key), intTree10));
            }
        }
        return new IntTree(j, v, intTree, intTree2);
    }
}
