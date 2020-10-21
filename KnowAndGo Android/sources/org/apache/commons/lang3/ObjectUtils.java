package org.apache.commons.lang3;

import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeSet;
import org.apache.commons.lang3.exception.CloneFailedException;
import org.apache.commons.lang3.mutable.MutableInt;
import org.apache.commons.lang3.text.StrBuilder;

public class ObjectUtils {
    private static final char AT_SIGN = '@';
    public static final Null NULL = new Null();

    public static byte CONST(byte b) {
        return b;
    }

    public static char CONST(char c) {
        return c;
    }

    public static double CONST(double d) {
        return d;
    }

    public static float CONST(float f) {
        return f;
    }

    public static int CONST(int i) {
        return i;
    }

    public static long CONST(long j) {
        return j;
    }

    public static <T> T CONST(T t) {
        return t;
    }

    public static short CONST(short s) {
        return s;
    }

    public static boolean CONST(boolean z) {
        return z;
    }

    public static <T> T defaultIfNull(T t, T t2) {
        return t != null ? t : t2;
    }

    public static boolean isEmpty(Object obj) {
        if (obj == null) {
            return true;
        }
        if (obj instanceof CharSequence) {
            if (((CharSequence) obj).length() == 0) {
                return true;
            }
            return false;
        } else if (obj.getClass().isArray()) {
            if (Array.getLength(obj) == 0) {
                return true;
            }
            return false;
        } else if (obj instanceof Collection) {
            return ((Collection) obj).isEmpty();
        } else {
            if (obj instanceof Map) {
                return ((Map) obj).isEmpty();
            }
            return false;
        }
    }

    public static boolean isNotEmpty(Object obj) {
        return !isEmpty(obj);
    }

    @SafeVarargs
    public static <T> T firstNonNull(T... tArr) {
        if (tArr == null) {
            return null;
        }
        for (T t : tArr) {
            if (t != null) {
                return t;
            }
        }
        return null;
    }

    public static boolean anyNotNull(Object... objArr) {
        return firstNonNull(objArr) != null;
    }

    public static boolean allNotNull(Object... objArr) {
        if (objArr == null) {
            return false;
        }
        for (Object obj : objArr) {
            if (obj == null) {
                return false;
            }
        }
        return true;
    }

    @Deprecated
    public static boolean equals(Object obj, Object obj2) {
        if (obj == obj2) {
            return true;
        }
        if (obj == null || obj2 == null) {
            return false;
        }
        return obj.equals(obj2);
    }

    public static boolean notEqual(Object obj, Object obj2) {
        return !equals(obj, obj2);
    }

    @Deprecated
    public static int hashCode(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    @Deprecated
    public static int hashCodeMulti(Object... objArr) {
        int i = 1;
        if (objArr != null) {
            for (Object hashCode : objArr) {
                i = (i * 31) + hashCode(hashCode);
            }
        }
        return i;
    }

    public static String identityToString(Object obj) {
        if (obj == null) {
            return null;
        }
        String name = obj.getClass().getName();
        String hexString = Integer.toHexString(System.identityHashCode(obj));
        StringBuilder sb = new StringBuilder(name.length() + 1 + hexString.length());
        sb.append(name);
        sb.append(AT_SIGN);
        sb.append(hexString);
        return sb.toString();
    }

    public static void identityToString(Appendable appendable, Object obj) throws IOException {
        Validate.notNull(obj, "Cannot get the toString of a null object", new Object[0]);
        appendable.append(obj.getClass().getName()).append(AT_SIGN).append(Integer.toHexString(System.identityHashCode(obj)));
    }

    @Deprecated
    public static void identityToString(StrBuilder strBuilder, Object obj) {
        Validate.notNull(obj, "Cannot get the toString of a null object", new Object[0]);
        String name = obj.getClass().getName();
        String hexString = Integer.toHexString(System.identityHashCode(obj));
        strBuilder.ensureCapacity(strBuilder.length() + name.length() + 1 + hexString.length());
        strBuilder.append(name).append((char) AT_SIGN).append(hexString);
    }

    public static void identityToString(StringBuffer stringBuffer, Object obj) {
        Validate.notNull(obj, "Cannot get the toString of a null object", new Object[0]);
        String name = obj.getClass().getName();
        String hexString = Integer.toHexString(System.identityHashCode(obj));
        stringBuffer.ensureCapacity(stringBuffer.length() + name.length() + 1 + hexString.length());
        stringBuffer.append(name);
        stringBuffer.append(AT_SIGN);
        stringBuffer.append(hexString);
    }

    public static void identityToString(StringBuilder sb, Object obj) {
        Validate.notNull(obj, "Cannot get the toString of a null object", new Object[0]);
        String name = obj.getClass().getName();
        String hexString = Integer.toHexString(System.identityHashCode(obj));
        sb.ensureCapacity(sb.length() + name.length() + 1 + hexString.length());
        sb.append(name);
        sb.append(AT_SIGN);
        sb.append(hexString);
    }

    @Deprecated
    public static String toString(Object obj) {
        return obj == null ? "" : obj.toString();
    }

    @Deprecated
    public static String toString(Object obj, String str) {
        return obj == null ? str : obj.toString();
    }

    @SafeVarargs
    public static <T extends Comparable<? super T>> T min(T... tArr) {
        T t = null;
        if (tArr != null) {
            for (T t2 : tArr) {
                if (compare(t2, t, true) < 0) {
                    t = t2;
                }
            }
        }
        return t;
    }

    @SafeVarargs
    public static <T extends Comparable<? super T>> T max(T... tArr) {
        if (tArr == null) {
            return null;
        }
        T t = null;
        for (T t2 : tArr) {
            if (compare(t2, t, false) > 0) {
                t = t2;
            }
        }
        return t;
    }

    public static <T extends Comparable<? super T>> int compare(T t, T t2) {
        return compare(t, t2, false);
    }

    public static <T extends Comparable<? super T>> int compare(T t, T t2, boolean z) {
        if (t == t2) {
            return 0;
        }
        if (t == null) {
            return z ? 1 : -1;
        }
        if (t2 == null) {
            return z ? -1 : 1;
        }
        return t.compareTo(t2);
    }

    @SafeVarargs
    public static <T extends Comparable<? super T>> T median(T... tArr) {
        Validate.notEmpty(tArr);
        Validate.noNullElements(tArr);
        TreeSet treeSet = new TreeSet();
        Collections.addAll(treeSet, tArr);
        return (Comparable) treeSet.toArray()[(treeSet.size() - 1) / 2];
    }

    @SafeVarargs
    public static <T> T median(Comparator<T> comparator, T... tArr) {
        Validate.notEmpty(tArr, "null/empty items", new Object[0]);
        Validate.noNullElements(tArr);
        Validate.notNull(comparator, "null comparator", new Object[0]);
        TreeSet treeSet = new TreeSet(comparator);
        Collections.addAll(treeSet, tArr);
        return treeSet.toArray()[(treeSet.size() - 1) / 2];
    }

    @SafeVarargs
    public static <T> T mode(T... tArr) {
        if (!ArrayUtils.isNotEmpty(tArr)) {
            return null;
        }
        HashMap hashMap = new HashMap(tArr.length);
        int i = 0;
        for (T t : tArr) {
            MutableInt mutableInt = (MutableInt) hashMap.get(t);
            if (mutableInt == null) {
                hashMap.put(t, new MutableInt(1));
            } else {
                mutableInt.increment();
            }
        }
        Iterator it = hashMap.entrySet().iterator();
        while (true) {
            T t2 = null;
            while (true) {
                if (!it.hasNext()) {
                    return t2;
                }
                Map.Entry entry = (Map.Entry) it.next();
                int intValue = ((MutableInt) entry.getValue()).intValue();
                if (intValue != i) {
                    if (intValue > i) {
                        t2 = entry.getKey();
                        i = intValue;
                    }
                }
            }
        }
    }

    public static <T> T clone(T t) {
        if (!(t instanceof Cloneable)) {
            return null;
        }
        if (t.getClass().isArray()) {
            Class<?> componentType = t.getClass().getComponentType();
            if (!componentType.isPrimitive()) {
                return ((Object[]) t).clone();
            }
            int length = Array.getLength(t);
            T newInstance = Array.newInstance(componentType, length);
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return newInstance;
                }
                Array.set(newInstance, i, Array.get(t, i));
                length = i;
            }
        } else {
            try {
                return t.getClass().getMethod("clone", new Class[0]).invoke(t, new Object[0]);
            } catch (NoSuchMethodException e) {
                throw new CloneFailedException("Cloneable type " + t.getClass().getName() + " has no clone method", e);
            } catch (IllegalAccessException e2) {
                throw new CloneFailedException("Cannot clone Cloneable type " + t.getClass().getName(), e2);
            } catch (InvocationTargetException e3) {
                throw new CloneFailedException("Exception cloning Cloneable type " + t.getClass().getName(), e3.getCause());
            }
        }
    }

    public static <T> T cloneIfPossible(T t) {
        T clone = clone(t);
        return clone == null ? t : clone;
    }

    public static class Null implements Serializable {
        private static final long serialVersionUID = 7092611880189329093L;

        Null() {
        }

        private Object readResolve() {
            return ObjectUtils.NULL;
        }
    }

    public static byte CONST_BYTE(int i) {
        if (i >= -128 && i <= 127) {
            return (byte) i;
        }
        throw new IllegalArgumentException("Supplied value must be a valid byte literal between -128 and 127: [" + i + "]");
    }

    public static short CONST_SHORT(int i) {
        if (i >= -32768 && i <= 32767) {
            return (short) i;
        }
        throw new IllegalArgumentException("Supplied value must be a valid byte literal between -32768 and 32767: [" + i + "]");
    }
}