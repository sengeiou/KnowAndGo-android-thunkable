package com.uxcam.internals;

/* renamed from: com.uxcam.internals.av */
public final class C2961av implements C2962aw {

    /* renamed from: a */
    private String f1372a;

    public C2961av(String str) {
        this.f1372a = str;
    }

    /* renamed from: a */
    public final int mo38040a() {
        return 1;
    }

    /* renamed from: b */
    public final String mo38041b() {
        return this.f1372a;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof C2961av) || !((C2961av) obj).f1372a.equalsIgnoreCase(this.f1372a)) {
            return super.equals(obj);
        }
        return true;
    }

    public final int hashCode() {
        return this.f1372a.hashCode();
    }
}
