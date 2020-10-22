package com.uxcam.internals;

import javax.security.auth.x500.X500Principal;

/* renamed from: com.uxcam.internals.ei */
final class C3120ei {

    /* renamed from: a */
    final String f2133a;

    /* renamed from: b */
    final int f2134b = this.f2133a.length();

    /* renamed from: c */
    int f2135c;

    /* renamed from: d */
    int f2136d;

    /* renamed from: e */
    int f2137e;

    /* renamed from: f */
    int f2138f;

    /* renamed from: g */
    char[] f2139g;

    public C3120ei(X500Principal x500Principal) {
        this.f2133a = x500Principal.getName("RFC2253");
    }

    /* renamed from: a */
    private int m1715a(int i) {
        int i2;
        int i3;
        int i4 = i + 1;
        if (i4 < this.f2134b) {
            char c = this.f2139g[i];
            if (c >= '0' && c <= '9') {
                i2 = c - '0';
            } else if (c >= 'a' && c <= 'f') {
                i2 = c - 'W';
            } else if (c < 'A' || c > 'F') {
                throw new IllegalStateException("Malformed DN: " + this.f2133a);
            } else {
                i2 = c - '7';
            }
            char c2 = this.f2139g[i4];
            if (c2 >= '0' && c2 <= '9') {
                i3 = c2 - '0';
            } else if (c2 >= 'a' && c2 <= 'f') {
                i3 = c2 - 'W';
            } else if (c2 < 'A' || c2 > 'F') {
                throw new IllegalStateException("Malformed DN: " + this.f2133a);
            } else {
                i3 = c2 - '7';
            }
            return (i2 << 4) + i3;
        }
        throw new IllegalStateException("Malformed DN: " + this.f2133a);
    }

    /* renamed from: e */
    private char m1716e() {
        int i;
        int i2;
        int a = m1715a(this.f2135c);
        this.f2135c++;
        if (a < 128) {
            return (char) a;
        }
        if (a < 192 || a > 247) {
            return '?';
        }
        if (a <= 223) {
            i2 = a & 31;
            i = 1;
        } else if (a <= 239) {
            i = 2;
            i2 = a & 15;
        } else {
            i = 3;
            i2 = a & 7;
        }
        for (int i3 = 0; i3 < i; i3++) {
            this.f2135c++;
            if (this.f2135c == this.f2134b || this.f2139g[this.f2135c] != '\\') {
                return '?';
            }
            this.f2135c++;
            int a2 = m1715a(this.f2135c);
            this.f2135c++;
            if ((a2 & 192) != 128) {
                return '?';
            }
            i2 = (i2 << 6) + (a2 & 63);
        }
        return (char) i2;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final String mo38333a() {
        while (this.f2135c < this.f2134b && this.f2139g[this.f2135c] == ' ') {
            this.f2135c++;
        }
        if (this.f2135c == this.f2134b) {
            return null;
        }
        this.f2136d = this.f2135c;
        do {
            this.f2135c++;
            if (this.f2135c >= this.f2134b || this.f2139g[this.f2135c] == '=' || this.f2139g[this.f2135c] == ' ') {
            }
            this.f2135c++;
            break;
        } while (this.f2139g[this.f2135c] == ' ');
        if (this.f2135c < this.f2134b) {
            this.f2137e = this.f2135c;
            if (this.f2139g[this.f2135c] == ' ') {
                while (this.f2135c < this.f2134b && this.f2139g[this.f2135c] != '=' && this.f2139g[this.f2135c] == ' ') {
                    this.f2135c++;
                }
                if (this.f2139g[this.f2135c] != '=' || this.f2135c == this.f2134b) {
                    throw new IllegalStateException("Unexpected end of DN: " + this.f2133a);
                }
            }
            do {
                this.f2135c++;
                if (this.f2135c >= this.f2134b || this.f2139g[this.f2135c] != ' ') {
                }
                this.f2135c++;
                break;
            } while (this.f2139g[this.f2135c] != ' ');
            if (this.f2137e - this.f2136d > 4 && this.f2139g[this.f2136d + 3] == '.' && ((this.f2139g[this.f2136d] == 'O' || this.f2139g[this.f2136d] == 'o') && ((this.f2139g[this.f2136d + 1] == 'I' || this.f2139g[this.f2136d + 1] == 'i') && (this.f2139g[this.f2136d + 2] == 'D' || this.f2139g[this.f2136d + 2] == 'd')))) {
                this.f2136d += 4;
            }
            return new String(this.f2139g, this.f2136d, this.f2137e - this.f2136d);
        }
        throw new IllegalStateException("Unexpected end of DN: " + this.f2133a);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final String mo38334b() {
        if (this.f2135c + 4 < this.f2134b) {
            this.f2136d = this.f2135c;
            int i = this.f2135c;
            while (true) {
                this.f2135c = i + 1;
                if (this.f2135c == this.f2134b || this.f2139g[this.f2135c] == '+' || this.f2139g[this.f2135c] == ',' || this.f2139g[this.f2135c] == ';') {
                    this.f2137e = this.f2135c;
                } else if (this.f2139g[this.f2135c] == ' ') {
                    this.f2137e = this.f2135c;
                    do {
                        this.f2135c++;
                        if (this.f2135c >= this.f2134b) {
                            break;
                        }
                    } while (this.f2139g[this.f2135c] != ' ');
                } else {
                    if (this.f2139g[this.f2135c] >= 'A' && this.f2139g[this.f2135c] <= 'F') {
                        char[] cArr = this.f2139g;
                        int i2 = this.f2135c;
                        cArr[i2] = (char) (cArr[i2] + ' ');
                    }
                    i = this.f2135c;
                }
            }
            int i3 = this.f2137e - this.f2136d;
            if (i3 < 5 || (i3 & 1) == 0) {
                throw new IllegalStateException("Unexpected end of DN: " + this.f2133a);
            }
            byte[] bArr = new byte[(i3 / 2)];
            int i4 = this.f2136d + 1;
            for (int i5 = 0; i5 < bArr.length; i5++) {
                bArr[i5] = (byte) m1715a(i4);
                i4 += 2;
            }
            return new String(this.f2139g, this.f2136d, i3);
        }
        throw new IllegalStateException("Unexpected end of DN: " + this.f2133a);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final String mo38335c() {
        this.f2136d = this.f2135c;
        this.f2137e = this.f2135c;
        while (this.f2135c < this.f2134b) {
            char c = this.f2139g[this.f2135c];
            if (c != ' ') {
                if (c != ';') {
                    if (c != '\\') {
                        switch (c) {
                            case '+':
                            case ',':
                                break;
                            default:
                                char[] cArr = this.f2139g;
                                int i = this.f2137e;
                                this.f2137e = i + 1;
                                cArr[i] = this.f2139g[this.f2135c];
                                break;
                        }
                    } else {
                        char[] cArr2 = this.f2139g;
                        int i2 = this.f2137e;
                        this.f2137e = i2 + 1;
                        cArr2[i2] = mo38336d();
                    }
                    this.f2135c++;
                }
                return new String(this.f2139g, this.f2136d, this.f2137e - this.f2136d);
            }
            this.f2138f = this.f2137e;
            this.f2135c++;
            char[] cArr3 = this.f2139g;
            int i3 = this.f2137e;
            this.f2137e = i3 + 1;
            cArr3[i3] = ' ';
            while (this.f2135c < this.f2134b && this.f2139g[this.f2135c] == ' ') {
                char[] cArr4 = this.f2139g;
                int i4 = this.f2137e;
                this.f2137e = i4 + 1;
                cArr4[i4] = ' ';
                this.f2135c++;
            }
            if (this.f2135c == this.f2134b || this.f2139g[this.f2135c] == ',' || this.f2139g[this.f2135c] == '+' || this.f2139g[this.f2135c] == ';') {
                return new String(this.f2139g, this.f2136d, this.f2138f - this.f2136d);
            }
        }
        return new String(this.f2139g, this.f2136d, this.f2137e - this.f2136d);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public final char mo38336d() {
        this.f2135c++;
        if (this.f2135c != this.f2134b) {
            char c = this.f2139g[this.f2135c];
            if (!(c == ' ' || c == '%' || c == '\\' || c == '_')) {
                switch (c) {
                    case '\"':
                    case '#':
                        break;
                    default:
                        switch (c) {
                            case '*':
                            case '+':
                            case ',':
                                break;
                            default:
                                switch (c) {
                                    case ';':
                                    case '<':
                                    case '=':
                                    case '>':
                                        break;
                                    default:
                                        return m1716e();
                                }
                        }
                }
            }
            return this.f2139g[this.f2135c];
        }
        throw new IllegalStateException("Unexpected end of DN: " + this.f2133a);
    }
}
