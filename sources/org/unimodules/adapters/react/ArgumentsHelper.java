package org.unimodules.adapters.react;

import com.facebook.react.bridge.Dynamic;
import org.unimodules.core.arguments.MapArguments;
import org.unimodules.core.arguments.ReadableArguments;

public class ArgumentsHelper {
    public static Object getNativeArgumentForExpectedClass(Dynamic dynamic, Class<?> cls) {
        switch (dynamic.getType()) {
            case String:
                return dynamic.asString();
            case Map:
                if (cls.isAssignableFrom(ReadableArguments.class)) {
                    return new MapArguments(dynamic.asMap().toHashMap());
                }
                return dynamic.asMap().toHashMap();
            case Array:
                return dynamic.asArray().toArrayList();
            case Number:
                Double valueOf = Double.valueOf(dynamic.asDouble());
                if (cls == Byte.TYPE || cls == Byte.class) {
                    return Byte.valueOf(valueOf.byteValue());
                }
                if (cls == Short.TYPE || cls == Short.class) {
                    return Short.valueOf(valueOf.shortValue());
                }
                if (cls == Integer.TYPE || cls == Integer.class) {
                    return Integer.valueOf(valueOf.intValue());
                }
                if (cls == Float.TYPE || cls == Float.class) {
                    return Float.valueOf(valueOf.floatValue());
                }
                if (cls == Long.TYPE || cls == Long.class) {
                    return Long.valueOf(valueOf.longValue());
                }
                return valueOf;
            case Boolean:
                return Boolean.valueOf(dynamic.asBoolean());
            case Null:
                return null;
            default:
                throw new RuntimeException("Don't know how to convert React Native argument of type " + dynamic.getType() + " to native.");
        }
    }
}
