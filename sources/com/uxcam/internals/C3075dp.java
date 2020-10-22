package com.uxcam.internals;

import java.io.IOException;

/* renamed from: com.uxcam.internals.dp */
public final class C3075dp {

    /* renamed from: a */
    static final C3133eq f1966a = C3133eq.m1828a("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");

    /* renamed from: b */
    static final String[] f1967b = new String[64];

    /* renamed from: c */
    static final String[] f1968c = new String[256];

    /* renamed from: d */
    private static final String[] f1969d = {"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};

    static {
        for (int i = 0; i < f1968c.length; i++) {
            f1968c[i] = C3030cl.m1422a("%8s", Integer.toBinaryString(i)).replace(' ', '0');
        }
        f1967b[0] = "";
        f1967b[1] = "END_STREAM";
        int[] iArr = {1};
        f1967b[8] = "PADDED";
        for (int i2 = 0; i2 <= 0; i2++) {
            int i3 = iArr[i2];
            f1967b[i3 | 8] = f1967b[i3] + "|PADDED";
        }
        f1967b[4] = "END_HEADERS";
        f1967b[32] = "PRIORITY";
        f1967b[36] = "END_HEADERS|PRIORITY";
        int[] iArr2 = {4, 32, 36};
        for (int i4 = 0; i4 < 3; i4++) {
            int i5 = iArr2[i4];
            for (int i6 = 0; i6 <= 0; i6++) {
                int i7 = iArr[i6];
                String[] strArr = f1967b;
                int i8 = i7 | i5;
                strArr[i8] = f1967b[i7] + '|' + f1967b[i5];
                f1967b[i8 | 8] = f1967b[i7] + '|' + f1967b[i5] + "|PADDED";
            }
        }
        for (int i9 = 0; i9 < f1967b.length; i9++) {
            if (f1967b[i9] == null) {
                f1967b[i9] = f1968c[i9];
            }
        }
    }

    private C3075dp() {
    }

    /* renamed from: a */
    static IllegalArgumentException m1562a(String str, Object... objArr) {
        throw new IllegalArgumentException(C3030cl.m1422a(str, objArr));
    }

    /* renamed from: a */
    static String m1563a(boolean z, int i, int i2, byte b, byte b2) {
        String str;
        String str2;
        String str3;
        String a = b < f1969d.length ? f1969d[b] : C3030cl.m1422a("0x%02x", Byte.valueOf(b));
        if (b2 != 0) {
            switch (b) {
                case 2:
                case 3:
                case 7:
                case 8:
                    str = f1968c[b2];
                    break;
                case 4:
                case 6:
                    if (b2 != 1) {
                        str = f1968c[b2];
                        break;
                    } else {
                        str = "ACK";
                        break;
                    }
                default:
                    String str4 = b2 < f1967b.length ? f1967b[b2] : f1968c[b2];
                    if (b == 5 && (b2 & 4) != 0) {
                        str2 = "HEADERS";
                        str3 = "PUSH_PROMISE";
                    } else if (b != 0 || (b2 & 32) == 0) {
                        str = str4;
                        break;
                    } else {
                        str2 = "PRIORITY";
                        str3 = "COMPRESSED";
                    }
                    str = str4.replace(str2, str3);
                    break;
            }
        } else {
            str = "";
        }
        Object[] objArr = new Object[5];
        objArr[0] = z ? "<<" : ">>";
        objArr[1] = Integer.valueOf(i);
        objArr[2] = Integer.valueOf(i2);
        objArr[3] = a;
        objArr[4] = str;
        return C3030cl.m1422a("%s 0x%08x %5d %-13s %s", objArr);
    }

    /* renamed from: b */
    static IOException m1564b(String str, Object... objArr) {
        throw new IOException(C3030cl.m1422a(str, objArr));
    }
}
