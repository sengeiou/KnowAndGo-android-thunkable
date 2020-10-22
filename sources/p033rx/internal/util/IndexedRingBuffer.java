package p033rx.internal.util;

import java.io.PrintStream;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;
import p033rx.Subscription;
import p033rx.functions.Func1;

/* renamed from: rx.internal.util.IndexedRingBuffer */
public final class IndexedRingBuffer<E> implements Subscription {
    static final int SIZE;
    private final ElementSection<E> elements = new ElementSection<>();
    final AtomicInteger index = new AtomicInteger();
    private final IndexSection removed = new IndexSection();
    final AtomicInteger removedIndex = new AtomicInteger();

    public boolean isUnsubscribed() {
        return false;
    }

    static {
        int i = PlatformDependent.isAndroid() ? 8 : 128;
        String property = System.getProperty("rx.indexed-ring-buffer.size");
        if (property != null) {
            try {
                i = Integer.parseInt(property);
            } catch (NumberFormatException e) {
                PrintStream printStream = System.err;
                printStream.println("Failed to set 'rx.indexed-ring-buffer.size' with value " + property + " => " + e.getMessage());
            }
        }
        SIZE = i;
    }

    public static <T> IndexedRingBuffer<T> getInstance() {
        return new IndexedRingBuffer<>();
    }

    public void releaseToPool() {
        int i = this.index.get();
        ElementSection<E> elementSection = this.elements;
        int i2 = 0;
        loop0:
        while (elementSection != null) {
            int i3 = i2;
            int i4 = 0;
            while (i4 < SIZE) {
                if (i3 >= i) {
                    break loop0;
                }
                elementSection.array.set(i4, (Object) null);
                i4++;
                i3++;
            }
            elementSection = elementSection.next.get();
            i2 = i3;
        }
        this.index.set(0);
        this.removedIndex.set(0);
    }

    public void unsubscribe() {
        releaseToPool();
    }

    IndexedRingBuffer() {
    }

    public int add(E e) {
        int indexForAdd = getIndexForAdd();
        if (indexForAdd < SIZE) {
            this.elements.array.set(indexForAdd, e);
            return indexForAdd;
        }
        getElementSection(indexForAdd).array.set(indexForAdd % SIZE, e);
        return indexForAdd;
    }

    public E remove(int i) {
        E e;
        if (i < SIZE) {
            e = this.elements.array.getAndSet(i, (Object) null);
        } else {
            e = getElementSection(i).array.getAndSet(i % SIZE, (Object) null);
        }
        pushRemovedIndex(i);
        return e;
    }

    private IndexSection getIndexSection(int i) {
        if (i < SIZE) {
            return this.removed;
        }
        int i2 = i / SIZE;
        IndexSection indexSection = this.removed;
        for (int i3 = 0; i3 < i2; i3++) {
            indexSection = indexSection.getNext();
        }
        return indexSection;
    }

    private ElementSection<E> getElementSection(int i) {
        if (i < SIZE) {
            return this.elements;
        }
        int i2 = i / SIZE;
        ElementSection<E> elementSection = this.elements;
        for (int i3 = 0; i3 < i2; i3++) {
            elementSection = elementSection.getNext();
        }
        return elementSection;
    }

    private synchronized int getIndexForAdd() {
        int i;
        int indexFromPreviouslyRemoved = getIndexFromPreviouslyRemoved();
        if (indexFromPreviouslyRemoved >= 0) {
            if (indexFromPreviouslyRemoved < SIZE) {
                i = this.removed.getAndSet(indexFromPreviouslyRemoved, -1);
            } else {
                i = getIndexSection(indexFromPreviouslyRemoved).getAndSet(indexFromPreviouslyRemoved % SIZE, -1);
            }
            if (i == this.index.get()) {
                this.index.getAndIncrement();
            }
        } else {
            i = this.index.getAndIncrement();
        }
        return i;
    }

    private synchronized int getIndexFromPreviouslyRemoved() {
        int i;
        int i2;
        do {
            i = this.removedIndex.get();
            if (i <= 0) {
                return -1;
            }
            i2 = i - 1;
        } while (!this.removedIndex.compareAndSet(i, i2));
        return i2;
    }

    private synchronized void pushRemovedIndex(int i) {
        int andIncrement = this.removedIndex.getAndIncrement();
        if (andIncrement < SIZE) {
            this.removed.set(andIncrement, i);
        } else {
            getIndexSection(andIncrement).set(andIncrement % SIZE, i);
        }
    }

    public int forEach(Func1<? super E, Boolean> func1) {
        return forEach(func1, 0);
    }

    public int forEach(Func1<? super E, Boolean> func1, int i) {
        int forEach = forEach(func1, i, this.index.get());
        if (i > 0 && forEach == this.index.get()) {
            return forEach(func1, 0, i);
        }
        if (forEach == this.index.get()) {
            return 0;
        }
        return forEach;
    }

    private int forEach(Func1<? super E, Boolean> func1, int i, int i2) {
        int i3;
        int i4 = this.index.get();
        ElementSection<E> elementSection = this.elements;
        if (i >= SIZE) {
            elementSection = getElementSection(i);
            i3 = i;
            i %= SIZE;
        } else {
            i3 = i;
        }
        loop0:
        while (elementSection != null) {
            while (i < SIZE) {
                if (i3 >= i4 || i3 >= i2) {
                    break loop0;
                }
                E e = elementSection.array.get(i);
                if (e != null && !func1.call(e).booleanValue()) {
                    return i3;
                }
                i++;
                i3++;
            }
            elementSection = elementSection.next.get();
            i = 0;
        }
        return i3;
    }

    /* renamed from: rx.internal.util.IndexedRingBuffer$ElementSection */
    static final class ElementSection<E> {
        final AtomicReferenceArray<E> array = new AtomicReferenceArray<>(IndexedRingBuffer.SIZE);
        final AtomicReference<ElementSection<E>> next = new AtomicReference<>();

        ElementSection() {
        }

        /* access modifiers changed from: package-private */
        public ElementSection<E> getNext() {
            if (this.next.get() != null) {
                return this.next.get();
            }
            ElementSection<E> elementSection = new ElementSection<>();
            if (this.next.compareAndSet((Object) null, elementSection)) {
                return elementSection;
            }
            return this.next.get();
        }
    }

    /* renamed from: rx.internal.util.IndexedRingBuffer$IndexSection */
    static class IndexSection {
        private final AtomicReference<IndexSection> _next = new AtomicReference<>();
        private final AtomicIntegerArray unsafeArray = new AtomicIntegerArray(IndexedRingBuffer.SIZE);

        IndexSection() {
        }

        public int getAndSet(int i, int i2) {
            return this.unsafeArray.getAndSet(i, i2);
        }

        public void set(int i, int i2) {
            this.unsafeArray.set(i, i2);
        }

        /* access modifiers changed from: package-private */
        public IndexSection getNext() {
            if (this._next.get() != null) {
                return this._next.get();
            }
            IndexSection indexSection = new IndexSection();
            if (this._next.compareAndSet((Object) null, indexSection)) {
                return indexSection;
            }
            return this._next.get();
        }
    }
}
