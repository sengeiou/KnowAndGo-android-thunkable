package com.google.android.play.core.internal;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.Collection;

/* renamed from: com.google.android.play.core.internal.bp */
public final class C2019bp<T> {

    /* renamed from: a */
    private final Object f761a;

    /* renamed from: b */
    private final Field f762b;

    /* renamed from: c */
    private final Class<T> f763c;

    C2019bp(Object obj, Field field, Class<T> cls) {
        this.f761a = obj;
        this.f762b = field;
        this.f763c = cls;
    }

    C2019bp(Object obj, Field field, Class cls, byte[] bArr) {
        this(obj, field, Array.newInstance(cls, 0).getClass());
    }

    /* renamed from: c */
    private Class m671c() {
        return mo33577b().getType().getComponentType();
    }

    /* renamed from: a */
    public final T mo33574a() {
        try {
            return this.f763c.cast(this.f762b.get(this.f761a));
        } catch (Exception e) {
            throw new C2021br(String.format("Failed to get value of field %s of type %s on object of type %s", new Object[]{this.f762b.getName(), this.f761a.getClass().getName(), this.f763c.getName()}), e);
        }
    }

    /* renamed from: a */
    public final void mo33575a(T t) {
        try {
            this.f762b.set(this.f761a, t);
        } catch (Exception e) {
            throw new C2021br(String.format("Failed to set value of field %s of type %s on object of type %s", new Object[]{this.f762b.getName(), this.f761a.getClass().getName(), this.f763c.getName()}), e);
        }
    }

    /* renamed from: a */
    public void mo33576a(Collection collection) {
        Object[] objArr = (Object[]) mo33574a();
        int length = objArr == null ? 0 : objArr.length;
        Object[] objArr2 = (Object[]) Array.newInstance(m671c(), collection.size() + length);
        if (objArr != null) {
            System.arraycopy(objArr, 0, objArr2, 0, objArr.length);
        }
        for (Object obj : collection) {
            objArr2[length] = obj;
            length++;
        }
        mo33575a(objArr2);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public final Field mo33577b() {
        return this.f762b;
    }

    /* renamed from: b */
    public void mo33578b(Collection collection) {
        Object[] objArr = (Object[]) mo33574a();
        int i = 0;
        Object[] objArr2 = (Object[]) Array.newInstance(m671c(), (objArr == null ? 0 : objArr.length) + collection.size());
        if (objArr != null) {
            System.arraycopy(objArr, 0, objArr2, collection.size(), objArr.length);
        }
        for (Object obj : collection) {
            objArr2[i] = obj;
            i++;
        }
        mo33575a(objArr2);
    }
}
