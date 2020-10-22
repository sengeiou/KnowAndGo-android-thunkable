package com.uxcam.internals;

import io.flutter.embedding.engine.renderer.FlutterRenderer;
import java.lang.reflect.Field;

/* renamed from: com.uxcam.internals.ft */
public final class C3176ft {
    /* renamed from: a */
    public static Object m2021a(String str, Object obj) {
        try {
            Field a = m2022a(str, (Class) obj.getClass());
            a.setAccessible(true);
            return a.get(obj);
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: a */
    public static Field m2022a(String str, Class cls) {
        for (Class cls2 = cls; cls2 != Object.class; cls2 = cls2.getSuperclass()) {
            for (Field field : cls2.getDeclaredFields()) {
                if (str.equals(field.getName())) {
                    return field;
                }
                if (C2952an.f1316S && str.equals("flutterRenderer") && field.getType().getName().equalsIgnoreCase(FlutterRenderer.class.getName())) {
                    return field;
                }
            }
        }
        throw new NoSuchFieldException("Field " + str + " not found for class " + cls);
    }
}
