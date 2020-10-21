package com.uxcam.internals;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* renamed from: com.uxcam.internals.hp */
public final class C3246hp {

    /* renamed from: a */
    static Set f2554a;

    static {
        HashSet hashSet = new HashSet();
        f2554a = hashSet;
        hashSet.add(String.class);
        f2554a.add(Byte.class);
        f2554a.add(Short.class);
        f2554a.add(Integer.class);
        f2554a.add(Long.class);
        f2554a.add(Float.class);
        f2554a.add(Double.class);
        f2554a.add(Character.class);
    }

    /* renamed from: a */
    public static void m2232a(Object obj, StringBuilder sb, String... strArr) {
        sb.append("{\n");
        HashSet hashSet = new HashSet(Arrays.asList(strArr));
        for (Method method : obj.getClass().getMethods()) {
            if (method.getName().startsWith("get") && method.getParameterTypes().length == 0 && !Void.TYPE.equals(method.getReturnType())) {
                try {
                    String substring = method.getName().substring(3);
                    String str = substring.substring(0, 1).toLowerCase() + substring.substring(1);
                    if (strArr.length <= 0 || hashSet.contains(str)) {
                        Object invoke = method.invoke(obj, new Object[0]);
                        if (invoke.getClass().isPrimitive() || f2554a.contains(invoke.getClass()) || (invoke instanceof Iterable)) {
                            sb.append(str + ": ");
                            m2233a(sb, invoke);
                            sb.append(",\n");
                        }
                    }
                } catch (Exception unused) {
                }
            }
        }
        sb.append("}");
    }

    /* renamed from: a */
    private static void m2233a(StringBuilder sb, Object obj) {
        String valueOf;
        if (obj == null) {
            valueOf = "null";
        } else if (obj == String.class) {
            sb.append("'");
            sb.append((String) obj);
            valueOf = "'";
        } else if (obj instanceof Iterable) {
            Iterator it = ((Iterable) obj).iterator();
            String str = "[";
            loop0:
            while (true) {
                sb.append(str);
                while (it.hasNext()) {
                    m2232a(it.next(), sb, new String[0]);
                    if (it.hasNext()) {
                        str = ",";
                    }
                }
                break loop0;
            }
            valueOf = "]";
        } else {
            valueOf = String.valueOf(obj);
        }
        sb.append(valueOf);
    }
}
