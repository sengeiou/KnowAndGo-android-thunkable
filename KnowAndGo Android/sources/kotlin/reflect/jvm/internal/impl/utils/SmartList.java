package kotlin.reflect.jvm.internal.impl.utils;

import java.lang.reflect.Array;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import org.jetbrains.annotations.NotNull;

public class SmartList<E> extends AbstractList<E> implements RandomAccess {
    /* access modifiers changed from: private */
    public Object myElem;
    private int mySize;

    private static /* synthetic */ void $$$reportNull$$$0(int i) {
        String str;
        int i2;
        Throwable th;
        switch (i) {
            case 2:
            case 3:
            case 5:
            case 6:
            case 7:
                str = "@NotNull method %s.%s must not return null";
                break;
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i) {
            case 2:
            case 3:
            case 5:
            case 6:
            case 7:
                i2 = 2;
                break;
            default:
                i2 = 3;
                break;
        }
        Object[] objArr = new Object[i2];
        switch (i) {
            case 2:
            case 3:
            case 5:
            case 6:
            case 7:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/utils/SmartList";
                break;
            case 4:
                objArr[0] = NotificationBundleProcessor.PUSH_ADDITIONAL_DATA_KEY;
                break;
            default:
                objArr[0] = "elements";
                break;
        }
        switch (i) {
            case 2:
            case 3:
                objArr[1] = "iterator";
                break;
            case 5:
            case 6:
            case 7:
                objArr[1] = "toArray";
                break;
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/utils/SmartList";
                break;
        }
        switch (i) {
            case 2:
            case 3:
            case 5:
            case 6:
            case 7:
                break;
            case 4:
                objArr[2] = "toArray";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        switch (i) {
            case 2:
            case 3:
            case 5:
            case 6:
            case 7:
                th = new IllegalStateException(format);
                break;
            default:
                th = new IllegalArgumentException(format);
                break;
        }
        throw th;
    }

    public E get(int i) {
        if (i < 0 || i >= this.mySize) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size: " + this.mySize);
        } else if (this.mySize == 1) {
            return this.myElem;
        } else {
            return ((Object[]) this.myElem)[i];
        }
    }

    public boolean add(E e) {
        if (this.mySize == 0) {
            this.myElem = e;
        } else if (this.mySize == 1) {
            this.myElem = new Object[]{this.myElem, e};
        } else {
            Object[] objArr = (Object[]) this.myElem;
            int length = objArr.length;
            if (this.mySize >= length) {
                int i = ((length * 3) / 2) + 1;
                int i2 = this.mySize + 1;
                if (i >= i2) {
                    i2 = i;
                }
                Object[] objArr2 = new Object[i2];
                this.myElem = objArr2;
                System.arraycopy(objArr, 0, objArr2, 0, length);
                objArr = objArr2;
            }
            objArr[this.mySize] = e;
        }
        this.mySize++;
        this.modCount++;
        return true;
    }

    public void add(int i, E e) {
        if (i < 0 || i > this.mySize) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size: " + this.mySize);
        }
        if (this.mySize == 0) {
            this.myElem = e;
        } else if (this.mySize == 1 && i == 0) {
            this.myElem = new Object[]{e, this.myElem};
        } else {
            Object[] objArr = new Object[(this.mySize + 1)];
            if (this.mySize == 1) {
                objArr[0] = this.myElem;
            } else {
                Object[] objArr2 = (Object[]) this.myElem;
                System.arraycopy(objArr2, 0, objArr, 0, i);
                System.arraycopy(objArr2, i, objArr, i + 1, this.mySize - i);
            }
            objArr[i] = e;
            this.myElem = objArr;
        }
        this.mySize++;
        this.modCount++;
    }

    public int size() {
        return this.mySize;
    }

    public void clear() {
        this.myElem = null;
        this.mySize = 0;
        this.modCount++;
    }

    public E set(int i, E e) {
        if (i < 0 || i >= this.mySize) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size: " + this.mySize);
        } else if (this.mySize == 1) {
            E e2 = this.myElem;
            this.myElem = e;
            return e2;
        } else {
            E[] eArr = (Object[]) this.myElem;
            E e3 = eArr[i];
            eArr[i] = e;
            return e3;
        }
    }

    public E remove(int i) {
        E e;
        if (i < 0 || i >= this.mySize) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size: " + this.mySize);
        }
        if (this.mySize == 1) {
            e = this.myElem;
            this.myElem = null;
        } else {
            E[] eArr = (Object[]) this.myElem;
            E e2 = eArr[i];
            if (this.mySize == 2) {
                this.myElem = eArr[1 - i];
            } else {
                int i2 = (this.mySize - i) - 1;
                if (i2 > 0) {
                    System.arraycopy(eArr, i + 1, eArr, i, i2);
                }
                eArr[this.mySize - 1] = null;
            }
            e = e2;
        }
        this.mySize--;
        this.modCount++;
        return e;
    }

    private static class EmptyIterator<T> implements Iterator<T> {
        private static final EmptyIterator INSTANCE = new EmptyIterator();

        public boolean hasNext() {
            return false;
        }

        private EmptyIterator() {
        }

        public static <T> EmptyIterator<T> getInstance() {
            return INSTANCE;
        }

        public T next() {
            throw new NoSuchElementException();
        }

        public void remove() {
            throw new IllegalStateException();
        }
    }

    @NotNull
    public Iterator<E> iterator() {
        if (this.mySize == 0) {
            EmptyIterator instance = EmptyIterator.getInstance();
            if (instance == null) {
                $$$reportNull$$$0(2);
            }
            return instance;
        } else if (this.mySize == 1) {
            return new SingletonIterator();
        } else {
            Iterator<E> it = super.iterator();
            if (it == null) {
                $$$reportNull$$$0(3);
            }
            return it;
        }
    }

    private static abstract class SingletonIteratorBase<T> implements Iterator<T> {
        private boolean myVisited;

        /* access modifiers changed from: protected */
        public abstract void checkCoModification();

        /* access modifiers changed from: protected */
        public abstract T getElement();

        private SingletonIteratorBase() {
        }

        public final boolean hasNext() {
            return !this.myVisited;
        }

        public final T next() {
            if (!this.myVisited) {
                this.myVisited = true;
                checkCoModification();
                return getElement();
            }
            throw new NoSuchElementException();
        }
    }

    private class SingletonIterator extends SingletonIteratorBase<E> {
        private final int myInitialModCount;

        public SingletonIterator() {
            super();
            this.myInitialModCount = SmartList.this.modCount;
        }

        /* access modifiers changed from: protected */
        public E getElement() {
            return SmartList.this.myElem;
        }

        /* access modifiers changed from: protected */
        public void checkCoModification() {
            if (SmartList.this.modCount != this.myInitialModCount) {
                throw new ConcurrentModificationException("ModCount: " + SmartList.this.modCount + "; expected: " + this.myInitialModCount);
            }
        }

        public void remove() {
            checkCoModification();
            SmartList.this.clear();
        }
    }

    @NotNull
    public <T> T[] toArray(@NotNull T[] tArr) {
        if (tArr == null) {
            $$$reportNull$$$0(4);
        }
        int length = tArr.length;
        if (this.mySize == 1) {
            if (length != 0) {
                tArr[0] = this.myElem;
            } else {
                T[] tArr2 = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), 1);
                tArr2[0] = this.myElem;
                if (tArr2 == null) {
                    $$$reportNull$$$0(5);
                }
                return tArr2;
            }
        } else if (length < this.mySize) {
            T[] copyOf = Arrays.copyOf((Object[]) this.myElem, this.mySize, tArr.getClass());
            if (copyOf == null) {
                $$$reportNull$$$0(6);
            }
            return copyOf;
        } else if (this.mySize != 0) {
            System.arraycopy(this.myElem, 0, tArr, 0, this.mySize);
        }
        if (length > this.mySize) {
            tArr[this.mySize] = null;
        }
        if (tArr == null) {
            $$$reportNull$$$0(7);
        }
        return tArr;
    }
}
