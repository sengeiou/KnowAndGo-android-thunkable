package com.uxcam.internals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* renamed from: com.uxcam.internals.bv */
public final class C3000bv {

    /* renamed from: a */
    public final String[] f1606a;

    /* renamed from: com.uxcam.internals.bv$aa */
    public static final class C3001aa {

        /* renamed from: a */
        final List f1607a = new ArrayList(20);

        /* renamed from: b */
        static void m1289b(String str, String str2) {
            if (str == null) {
                throw new NullPointerException("name == null");
            } else if (!str.isEmpty()) {
                int length = str.length();
                for (int i = 0; i < length; i++) {
                    char charAt = str.charAt(i);
                    if (charAt <= 31 || charAt >= 127) {
                        throw new IllegalArgumentException(C3030cl.m1422a("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(charAt), Integer.valueOf(i), str));
                    }
                }
                if (str2 != null) {
                    int length2 = str2.length();
                    int i2 = 0;
                    while (i2 < length2) {
                        char charAt2 = str2.charAt(i2);
                        if ((charAt2 > 31 || charAt2 == 9) && charAt2 < 127) {
                            i2++;
                        } else {
                            throw new IllegalArgumentException(C3030cl.m1422a("Unexpected char %#04x at %d in %s value: %s", Integer.valueOf(charAt2), Integer.valueOf(i2), str, str2));
                        }
                    }
                    return;
                }
                throw new NullPointerException("value == null");
            } else {
                throw new IllegalArgumentException("name is empty");
            }
        }

        /* renamed from: a */
        public final C3001aa mo38118a(String str) {
            int i = 0;
            while (i < this.f1607a.size()) {
                if (str.equalsIgnoreCase((String) this.f1607a.get(i))) {
                    this.f1607a.remove(i);
                    this.f1607a.remove(i);
                    i -= 2;
                }
                i += 2;
            }
            return this;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public final C3001aa mo38119a(String str, String str2) {
            this.f1607a.add(str);
            this.f1607a.add(str2.trim());
            return this;
        }

        /* renamed from: a */
        public final C3000bv mo38120a() {
            return new C3000bv(this);
        }
    }

    C3000bv(C3001aa aaVar) {
        this.f1606a = (String[]) aaVar.f1607a.toArray(new String[aaVar.f1607a.size()]);
    }

    private C3000bv(String[] strArr) {
        this.f1606a = strArr;
    }

    /* renamed from: a */
    public static C3000bv m1284a(String... strArr) {
        String[] strArr2 = (String[]) strArr.clone();
        int i = 0;
        while (i < strArr2.length) {
            if (strArr2[i] != null) {
                strArr2[i] = strArr2[i].trim();
                i++;
            } else {
                throw new IllegalArgumentException("Headers cannot be null");
            }
        }
        int i2 = 0;
        while (i2 < strArr2.length) {
            String str = strArr2[i2];
            String str2 = strArr2[i2 + 1];
            if (str.length() != 0 && str.indexOf(0) == -1 && str2.indexOf(0) == -1) {
                i2 += 2;
            } else {
                throw new IllegalArgumentException("Unexpected header: " + str + ": " + str2);
            }
        }
        return new C3000bv(strArr2);
    }

    /* renamed from: a */
    public final C3001aa mo38111a() {
        C3001aa aaVar = new C3001aa();
        Collections.addAll(aaVar.f1607a, this.f1606a);
        return aaVar;
    }

    /* renamed from: a */
    public final String mo38112a(int i) {
        return this.f1606a[i * 2];
    }

    /* renamed from: a */
    public final String mo38113a(String str) {
        String[] strArr = this.f1606a;
        for (int length = strArr.length - 2; length >= 0; length -= 2) {
            if (str.equalsIgnoreCase(strArr[length])) {
                return strArr[length + 1];
            }
        }
        return null;
    }

    /* renamed from: b */
    public final String mo38114b(int i) {
        return this.f1606a[(i * 2) + 1];
    }

    public final boolean equals(Object obj) {
        return (obj instanceof C3000bv) && Arrays.equals(((C3000bv) obj).f1606a, this.f1606a);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f1606a);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        int length = this.f1606a.length / 2;
        for (int i = 0; i < length; i++) {
            sb.append(mo38112a(i));
            sb.append(": ");
            sb.append(mo38114b(i));
            sb.append("\n");
        }
        return sb.toString();
    }
}
