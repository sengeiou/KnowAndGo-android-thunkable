package com.uxcam.internals;

import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import kotlin.UByte;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;
import org.apache.commons.lang3.StringUtils;

/* renamed from: com.uxcam.internals.eq */
public class C3133eq implements Serializable, Comparable {

    /* renamed from: a */
    static final char[] f2159a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* renamed from: b */
    public static final C3133eq f2160b = m1829a(new byte[0]);

    /* renamed from: c */
    final byte[] f2161c;

    /* renamed from: d */
    transient int f2162d;

    /* renamed from: e */
    transient String f2163e;

    C3133eq(byte[] bArr) {
        this.f2161c = bArr;
    }

    /* renamed from: a */
    private static int m1827a(char c) {
        if (c >= '0' && c <= '9') {
            return c - '0';
        }
        char c2 = 'a';
        if (c < 'a' || c > 'f') {
            c2 = 'A';
            if (c < 'A' || c > 'F') {
                throw new IllegalArgumentException("Unexpected hex digit: ".concat(String.valueOf(c)));
            }
        }
        return (c - c2) + 10;
    }

    /* renamed from: a */
    public static C3133eq m1828a(String str) {
        if (str != null) {
            C3133eq eqVar = new C3133eq(str.getBytes(C3151fe.f2202a));
            eqVar.f2163e = str;
            return eqVar;
        }
        throw new IllegalArgumentException("s == null");
    }

    /* renamed from: a */
    public static C3133eq m1829a(byte... bArr) {
        if (bArr != null) {
            return new C3133eq((byte[]) bArr.clone());
        }
        throw new IllegalArgumentException("data == null");
    }

    /* renamed from: b */
    public static C3133eq m1830b(String str) {
        if (str.length() % 2 == 0) {
            byte[] bArr = new byte[(str.length() / 2)];
            for (int i = 0; i < bArr.length; i++) {
                int i2 = i * 2;
                bArr[i] = (byte) ((m1827a(str.charAt(i2)) << 4) + m1827a(str.charAt(i2 + 1)));
            }
            return m1829a(bArr);
        }
        throw new IllegalArgumentException("Unexpected hex string: ".concat(String.valueOf(str)));
    }

    /* renamed from: c */
    private C3133eq m1831c(String str) {
        try {
            return m1829a(MessageDigest.getInstance(str).digest(this.f2161c));
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError(e);
        }
    }

    /* renamed from: a */
    public byte mo38402a(int i) {
        return this.f2161c[i];
    }

    /* renamed from: a */
    public C3133eq mo38403a(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException("beginIndex < 0");
        } else if (i2 <= this.f2161c.length) {
            int i3 = i2 - i;
            if (i3 < 0) {
                throw new IllegalArgumentException("endIndex < beginIndex");
            } else if (i == 0 && i2 == this.f2161c.length) {
                return this;
            } else {
                byte[] bArr = new byte[i3];
                System.arraycopy(this.f2161c, i, bArr, 0, i3);
                return new C3133eq(bArr);
            }
        } else {
            throw new IllegalArgumentException("endIndex > length(" + this.f2161c.length + ")");
        }
    }

    /* renamed from: a */
    public String mo38404a() {
        String str = this.f2163e;
        if (str != null) {
            return str;
        }
        String str2 = new String(this.f2161c, C3151fe.f2202a);
        this.f2163e = str2;
        return str2;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo38405a(C3130en enVar) {
        enVar.mo38366b(this.f2161c, 0, this.f2161c.length);
    }

    /* renamed from: a */
    public boolean mo38406a(int i, C3133eq eqVar, int i2, int i3) {
        return eqVar.mo38407a(0, this.f2161c, 0, i3);
    }

    /* renamed from: a */
    public boolean mo38407a(int i, byte[] bArr, int i2, int i3) {
        return i >= 0 && i <= this.f2161c.length - i3 && i2 >= 0 && i2 <= bArr.length - i3 && C3151fe.m1949a(this.f2161c, i, bArr, i2, i3);
    }

    /* renamed from: b */
    public String mo38408b() {
        return C3129em.m1743a(this.f2161c);
    }

    /* renamed from: c */
    public C3133eq mo38409c() {
        return m1831c(MessageDigestAlgorithms.SHA_1);
    }

    public /* synthetic */ int compareTo(Object obj) {
        C3133eq eqVar = (C3133eq) obj;
        int g = mo38415g();
        int g2 = eqVar.mo38415g();
        int min = Math.min(g, g2);
        for (int i = 0; i < min; i++) {
            byte a = mo38402a(i) & UByte.MAX_VALUE;
            byte a2 = eqVar.mo38402a(i) & UByte.MAX_VALUE;
            if (a != a2) {
                return a < a2 ? -1 : 1;
            }
        }
        if (g == g2) {
            return 0;
        }
        return g < g2 ? -1 : 1;
    }

    /* renamed from: d */
    public C3133eq mo38411d() {
        return m1831c(MessageDigestAlgorithms.SHA_256);
    }

    /* renamed from: e */
    public String mo38412e() {
        char[] cArr = new char[(this.f2161c.length * 2)];
        int i = 0;
        for (byte b : this.f2161c) {
            int i2 = i + 1;
            cArr[i] = f2159a[(b >> 4) & 15];
            i = i2 + 1;
            cArr[i2] = f2159a[b & 15];
        }
        return new String(cArr);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof C3133eq) {
            C3133eq eqVar = (C3133eq) obj;
            return eqVar.mo38415g() == this.f2161c.length && eqVar.mo38407a(0, this.f2161c, 0, this.f2161c.length);
        }
    }

    /* renamed from: f */
    public C3133eq mo38414f() {
        int i = 0;
        while (i < this.f2161c.length) {
            byte b = this.f2161c[i];
            if (b < 65 || b > 90) {
                i++;
            } else {
                byte[] bArr = (byte[]) this.f2161c.clone();
                bArr[i] = (byte) (b + 32);
                for (int i2 = i + 1; i2 < bArr.length; i2++) {
                    byte b2 = bArr[i2];
                    if (b2 >= 65 && b2 <= 90) {
                        bArr[i2] = (byte) (b2 + 32);
                    }
                }
                return new C3133eq(bArr);
            }
        }
        return this;
    }

    /* renamed from: g */
    public int mo38415g() {
        return this.f2161c.length;
    }

    /* renamed from: h */
    public byte[] mo38416h() {
        return (byte[]) this.f2161c.clone();
    }

    public int hashCode() {
        int i = this.f2162d;
        if (i != 0) {
            return i;
        }
        int hashCode = Arrays.hashCode(this.f2161c);
        this.f2162d = hashCode;
        return hashCode;
    }

    public String toString() {
        String replace;
        StringBuilder sb;
        StringBuilder sb2;
        String str;
        if (this.f2161c.length == 0) {
            return "[size=0]";
        }
        String a = mo38404a();
        int length = a.length();
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i >= length) {
                i = a.length();
                break;
            } else if (i2 == 64) {
                break;
            } else {
                int codePointAt = a.codePointAt(i);
                if ((!Character.isISOControl(codePointAt) || codePointAt == 10 || codePointAt == 13) && codePointAt != 65533) {
                    i2++;
                    i += Character.charCount(codePointAt);
                }
            }
        }
        i = -1;
        if (i != -1) {
            replace = a.substring(0, i).replace("\\", "\\\\").replace("\n", "\\n").replace(StringUtils.f3031CR, "\\r");
            if (i < a.length()) {
                sb2 = new StringBuilder("[size=");
                sb2.append(this.f2161c.length);
                sb2.append(" text=");
                sb2.append(replace);
                str = "…]";
                sb2.append(str);
                return sb2.toString();
            }
            sb = new StringBuilder("[text=");
        } else if (this.f2161c.length <= 64) {
            sb = new StringBuilder("[hex=");
            replace = mo38412e();
        } else {
            sb2 = new StringBuilder("[size=");
            sb2.append(this.f2161c.length);
            sb2.append(" hex=");
            replace = mo38403a(0, 64).mo38412e();
            sb2.append(replace);
            str = "…]";
            sb2.append(str);
            return sb2.toString();
        }
        sb2.append(replace);
        str = "]";
        sb2.append(str);
        return sb2.toString();
    }
}
