package com.google.android.gms.internal.measurement;

public enum zzux {
    VOID(Void.class, Void.class, (Class<?>) null),
    INT(Integer.TYPE, Integer.class, 0),
    LONG(Long.TYPE, Long.class, 0L),
    FLOAT(Float.TYPE, Float.class, Float.valueOf(0.0f)),
    DOUBLE(Double.TYPE, Double.class, Double.valueOf(0.0d)),
    BOOLEAN(Boolean.TYPE, Boolean.class, false),
    STRING(String.class, String.class, ""),
    BYTE_STRING(zzte.class, zzte.class, zzte.zzbts),
    ENUM(Integer.TYPE, Integer.class, (Class<?>) null),
    MESSAGE(Object.class, Object.class, (Class<?>) null);
    
    private final Class<?> zzbzq;
    private final Class<?> zzbzr;
    private final Object zzbzs;

    private zzux(Class<?> cls, Class<?> cls2, Object obj) {
        this.zzbzq = cls;
        this.zzbzr = cls2;
        this.zzbzs = obj;
    }

    public final Class<?> zzwy() {
        return this.zzbzr;
    }
}
