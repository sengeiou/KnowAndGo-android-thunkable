package com.uxcam.internals;

import com.facebook.common.util.UriUtil;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.UByte;
import kotlin.text.Typography;
import org.apache.commons.p032io.IOUtils;
import org.apache.logging.log4j.message.ParameterizedMessage;

/* renamed from: com.uxcam.internals.bw */
public final class C3002bw {

    /* renamed from: e */
    private static final char[] f1608e = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: a */
    public final String f1609a;

    /* renamed from: b */
    public final String f1610b;

    /* renamed from: c */
    public final int f1611c;

    /* renamed from: d */
    public final List f1612d;

    /* renamed from: f */
    private final String f1613f;

    /* renamed from: g */
    private final String f1614g;

    /* renamed from: h */
    private final List f1615h;

    /* renamed from: i */
    private final String f1616i;

    /* renamed from: j */
    private final String f1617j;

    /* renamed from: com.uxcam.internals.bw$aa */
    public static final class C3003aa {

        /* renamed from: a */
        String f1618a;

        /* renamed from: b */
        String f1619b = "";

        /* renamed from: c */
        String f1620c = "";

        /* renamed from: d */
        String f1621d;

        /* renamed from: e */
        int f1622e = -1;

        /* renamed from: f */
        final List f1623f = new ArrayList();

        /* renamed from: g */
        List f1624g;

        /* renamed from: h */
        String f1625h;

        /* renamed from: com.uxcam.internals.bw$aa$aa */
        enum C3004aa {
            ;
            

            /* renamed from: a */
            public static final int f1626a = 1;

            /* renamed from: b */
            public static final int f1627b = 2;

            /* renamed from: c */
            public static final int f1628c = 3;

            /* renamed from: d */
            public static final int f1629d = 4;

            /* renamed from: e */
            public static final int f1630e = 5;

            static {
                f1631f = new int[]{f1626a, f1627b, f1628c, f1629d, f1630e};
            }
        }

        public C3003aa() {
            this.f1623f.add("");
        }

        /* renamed from: a */
        static String m1314a(String str, int i, int i2) {
            String a = C3002bw.m1296a(str, i, i2, false);
            if (!a.contains(ParameterizedMessage.ERROR_MSG_SEPARATOR)) {
                return C3030cl.m1421a(a);
            }
            InetAddress f = (!a.startsWith("[") || !a.endsWith("]")) ? m1320f(a, 0, a.length()) : m1320f(a, 1, a.length() - 1);
            if (f == null) {
                return null;
            }
            byte[] address = f.getAddress();
            if (address.length == 16) {
                return m1315a(address);
            }
            throw new AssertionError();
        }

        /* renamed from: a */
        private static String m1315a(byte[] bArr) {
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            int i4 = -1;
            while (i2 < bArr.length) {
                int i5 = i2;
                while (i5 < 16 && bArr[i5] == 0 && bArr[i5 + 1] == 0) {
                    i5 += 2;
                }
                int i6 = i5 - i2;
                if (i6 > i3) {
                    i4 = i2;
                    i3 = i6;
                }
                i2 = i5 + 2;
            }
            C3130en enVar = new C3130en();
            while (i < bArr.length) {
                if (i == i4) {
                    enVar.mo38387h(58);
                    i += i3;
                    if (i == 16) {
                        enVar.mo38387h(58);
                    }
                } else {
                    if (i > 0) {
                        enVar.mo38387h(58);
                    }
                    enVar.mo38391i((long) (((bArr[i] & UByte.MAX_VALUE) << 8) | (bArr[i + 1] & UByte.MAX_VALUE)));
                    i += 2;
                }
            }
            return enVar.mo38395l();
        }

        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
            	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
            */
        /* JADX WARNING: Removed duplicated region for block: B:11:0x0031  */
        /* JADX WARNING: Removed duplicated region for block: B:46:0x00e4 A[SYNTHETIC] */
        /* renamed from: b */
        private void m1316b(java.lang.String r12, int r13, int r14) {
            /*
                r11 = this;
                if (r13 != r14) goto L_0x0003
                return
            L_0x0003:
                char r0 = r12.charAt(r13)
                r1 = 47
                r2 = 1
                if (r0 == r1) goto L_0x0020
                r1 = 92
                if (r0 != r1) goto L_0x0011
                goto L_0x0020
            L_0x0011:
                java.util.List r0 = r11.f1623f
                java.util.List r1 = r11.f1623f
                int r1 = r1.size()
                int r1 = r1 - r2
                java.lang.String r3 = ""
                r0.set(r1, r3)
                goto L_0x002e
            L_0x0020:
                java.util.List r0 = r11.f1623f
                r0.clear()
                java.util.List r0 = r11.f1623f
                java.lang.String r1 = ""
                r0.add(r1)
            L_0x002c:
                int r13 = r13 + 1
            L_0x002e:
                r4 = r13
                if (r4 >= r14) goto L_0x00e4
                java.lang.String r13 = "/\\"
                int r13 = com.uxcam.internals.C3030cl.m1418a((java.lang.String) r12, (int) r4, (int) r14, (java.lang.String) r13)
                r0 = 0
                if (r13 >= r14) goto L_0x003c
                r1 = 1
                goto L_0x003d
            L_0x003c:
                r1 = 0
            L_0x003d:
                java.lang.String r6 = " \"<>^`{}|/\\?#"
                r7 = 1
                r8 = 0
                r9 = 0
                r10 = 1
                r3 = r12
                r5 = r13
                java.lang.String r3 = com.uxcam.internals.C3002bw.m1295a(r3, r4, r5, r6, r7, r8, r9, r10)
                java.lang.String r4 = "."
                boolean r4 = r3.equals(r4)
                if (r4 != 0) goto L_0x005c
                java.lang.String r4 = "%2e"
                boolean r4 = r3.equalsIgnoreCase(r4)
                if (r4 == 0) goto L_0x005a
                goto L_0x005c
            L_0x005a:
                r4 = 0
                goto L_0x005d
            L_0x005c:
                r4 = 1
            L_0x005d:
                if (r4 != 0) goto L_0x00e0
                java.lang.String r4 = ".."
                boolean r4 = r3.equals(r4)
                if (r4 != 0) goto L_0x007f
                java.lang.String r4 = "%2e."
                boolean r4 = r3.equalsIgnoreCase(r4)
                if (r4 != 0) goto L_0x007f
                java.lang.String r4 = ".%2e"
                boolean r4 = r3.equalsIgnoreCase(r4)
                if (r4 != 0) goto L_0x007f
                java.lang.String r4 = "%2e%2e"
                boolean r4 = r3.equalsIgnoreCase(r4)
                if (r4 == 0) goto L_0x0080
            L_0x007f:
                r0 = 1
            L_0x0080:
                if (r0 == 0) goto L_0x00b6
                java.util.List r0 = r11.f1623f
                java.util.List r3 = r11.f1623f
                int r3 = r3.size()
                int r3 = r3 - r2
                java.lang.Object r0 = r0.remove(r3)
                java.lang.String r0 = (java.lang.String) r0
                boolean r0 = r0.isEmpty()
                if (r0 == 0) goto L_0x00ae
                java.util.List r0 = r11.f1623f
                boolean r0 = r0.isEmpty()
                if (r0 != 0) goto L_0x00ae
                java.util.List r0 = r11.f1623f
                java.util.List r3 = r11.f1623f
                int r3 = r3.size()
                int r3 = r3 - r2
                java.lang.String r4 = ""
                r0.set(r3, r4)
                goto L_0x00e0
            L_0x00ae:
                java.util.List r0 = r11.f1623f
                java.lang.String r3 = ""
                r0.add(r3)
                goto L_0x00e0
            L_0x00b6:
                java.util.List r0 = r11.f1623f
                java.util.List r4 = r11.f1623f
                int r4 = r4.size()
                int r4 = r4 - r2
                java.lang.Object r0 = r0.get(r4)
                java.lang.String r0 = (java.lang.String) r0
                boolean r0 = r0.isEmpty()
                if (r0 == 0) goto L_0x00d8
                java.util.List r0 = r11.f1623f
                java.util.List r4 = r11.f1623f
                int r4 = r4.size()
                int r4 = r4 - r2
                r0.set(r4, r3)
                goto L_0x00dd
            L_0x00d8:
                java.util.List r0 = r11.f1623f
                r0.add(r3)
            L_0x00dd:
                if (r1 == 0) goto L_0x00e0
                goto L_0x00ae
            L_0x00e0:
                if (r1 == 0) goto L_0x002e
                goto L_0x002c
            L_0x00e4:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uxcam.internals.C3002bw.C3003aa.m1316b(java.lang.String, int, int):void");
        }

        /* renamed from: c */
        private static int m1317c(String str, int i, int i2) {
            if (i2 - i < 2) {
                return -1;
            }
            char charAt = str.charAt(i);
            if ((charAt >= 'a' && charAt <= 'z') || (charAt >= 'A' && charAt <= 'Z')) {
                while (true) {
                    i++;
                    if (i >= i2) {
                        break;
                    }
                    char charAt2 = str.charAt(i);
                    if ((charAt2 < 'a' || charAt2 > 'z') && ((charAt2 < 'A' || charAt2 > 'Z') && !((charAt2 >= '0' && charAt2 <= '9') || charAt2 == '+' || charAt2 == '-' || charAt2 == '.'))) {
                        if (charAt2 == ':') {
                            return i;
                        }
                    }
                }
            }
            return -1;
        }

        /* renamed from: d */
        private static int m1318d(String str, int i, int i2) {
            int i3 = 0;
            while (i < i2) {
                char charAt = str.charAt(i);
                if (charAt != '\\' && charAt != '/') {
                    break;
                }
                i3++;
                i++;
            }
            return i3;
        }

        /* renamed from: e */
        private static int m1319e(String str, int i, int i2) {
            while (i < i2) {
                char charAt = str.charAt(i);
                if (charAt == ':') {
                    return i;
                }
                if (charAt == '[') {
                    do {
                        i++;
                        if (i >= i2) {
                            break;
                        }
                    } while (str.charAt(i) == ']');
                }
                i++;
            }
            return i2;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:44:0x0097, code lost:
            r5 = 0;
         */
        /* renamed from: f */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private static java.net.InetAddress m1320f(java.lang.String r16, int r17, int r18) {
            /*
                r0 = r16
                r1 = r18
                r2 = 16
                byte[] r3 = new byte[r2]
                r4 = -1
                r5 = 0
                r6 = r17
                r7 = 0
                r8 = -1
                r9 = -1
            L_0x000f:
                r10 = 0
                if (r6 >= r1) goto L_0x00d4
                if (r7 != r2) goto L_0x0015
                return r10
            L_0x0015:
                int r11 = r6 + 2
                r12 = 255(0xff, float:3.57E-43)
                r13 = 4
                if (r11 > r1) goto L_0x0033
                java.lang.String r14 = "::"
                r15 = 2
                boolean r14 = r0.regionMatches(r6, r14, r5, r15)
                if (r14 == 0) goto L_0x0033
                if (r8 == r4) goto L_0x0028
                return r10
            L_0x0028:
                int r7 = r7 + 2
                if (r11 != r1) goto L_0x002f
                r8 = r7
                goto L_0x00d4
            L_0x002f:
                r8 = r7
                r9 = r11
                goto L_0x00a2
            L_0x0033:
                if (r7 == 0) goto L_0x00a1
                java.lang.String r11 = ":"
                r14 = 1
                boolean r11 = r0.regionMatches(r6, r11, r5, r14)
                if (r11 == 0) goto L_0x0042
                int r6 = r6 + 1
                goto L_0x00a1
            L_0x0042:
                java.lang.String r11 = "."
                boolean r6 = r0.regionMatches(r6, r11, r5, r14)
                if (r6 == 0) goto L_0x00a0
                int r6 = r7 + -2
                r11 = r6
            L_0x004d:
                if (r9 >= r1) goto L_0x0094
                if (r11 != r2) goto L_0x0052
                goto L_0x009a
            L_0x0052:
                if (r11 == r6) goto L_0x005f
                char r15 = r0.charAt(r9)
                r14 = 46
                if (r15 == r14) goto L_0x005d
                goto L_0x009a
            L_0x005d:
                int r9 = r9 + 1
            L_0x005f:
                r14 = r9
                r15 = 0
            L_0x0061:
                if (r14 >= r1) goto L_0x0082
                char r5 = r0.charAt(r14)
                r2 = 48
                if (r5 < r2) goto L_0x0082
                r4 = 57
                if (r5 > r4) goto L_0x0082
                if (r15 != 0) goto L_0x0074
                if (r9 == r14) goto L_0x0074
                goto L_0x0097
            L_0x0074:
                int r15 = r15 * 10
                int r15 = r15 + r5
                int r15 = r15 - r2
                if (r15 <= r12) goto L_0x007b
                goto L_0x0097
            L_0x007b:
                int r14 = r14 + 1
                r2 = 16
                r4 = -1
                r5 = 0
                goto L_0x0061
            L_0x0082:
                int r2 = r14 - r9
                if (r2 != 0) goto L_0x0087
                goto L_0x0097
            L_0x0087:
                int r2 = r11 + 1
                byte r4 = (byte) r15
                r3[r11] = r4
                r11 = r2
                r9 = r14
                r2 = 16
                r4 = -1
                r5 = 0
                r14 = 1
                goto L_0x004d
            L_0x0094:
                int r6 = r6 + r13
                if (r11 == r6) goto L_0x0099
            L_0x0097:
                r5 = 0
                goto L_0x009a
            L_0x0099:
                r5 = 1
            L_0x009a:
                if (r5 != 0) goto L_0x009d
                return r10
            L_0x009d:
                int r7 = r7 + 2
                goto L_0x00d4
            L_0x00a0:
                return r10
            L_0x00a1:
                r9 = r6
            L_0x00a2:
                r6 = r9
                r2 = 0
            L_0x00a4:
                if (r6 >= r1) goto L_0x00b7
                char r4 = r0.charAt(r6)
                int r4 = com.uxcam.internals.C3002bw.m1293a((char) r4)
                r5 = -1
                if (r4 == r5) goto L_0x00b7
                int r2 = r2 << 4
                int r2 = r2 + r4
                int r6 = r6 + 1
                goto L_0x00a4
            L_0x00b7:
                int r4 = r6 - r9
                if (r4 == 0) goto L_0x00d3
                if (r4 <= r13) goto L_0x00be
                goto L_0x00d3
            L_0x00be:
                int r4 = r7 + 1
                int r5 = r2 >>> 8
                r5 = r5 & r12
                byte r5 = (byte) r5
                r3[r7] = r5
                int r7 = r4 + 1
                r2 = r2 & 255(0xff, float:3.57E-43)
                byte r2 = (byte) r2
                r3[r4] = r2
                r2 = 16
                r4 = -1
                r5 = 0
                goto L_0x000f
            L_0x00d3:
                return r10
            L_0x00d4:
                r0 = 16
                if (r7 == r0) goto L_0x00ea
                r1 = -1
                if (r8 != r1) goto L_0x00dc
                return r10
            L_0x00dc:
                int r1 = r7 - r8
                int r2 = 16 - r1
                java.lang.System.arraycopy(r3, r8, r3, r2, r1)
                int r2 = 16 - r7
                int r2 = r2 + r8
                r0 = 0
                java.util.Arrays.fill(r3, r8, r2, r0)
            L_0x00ea:
                java.net.InetAddress r0 = java.net.InetAddress.getByAddress(r3)     // Catch:{ UnknownHostException -> 0x00ef }
                return r0
            L_0x00ef:
                java.lang.AssertionError r0 = new java.lang.AssertionError
                r0.<init>()
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uxcam.internals.C3002bw.C3003aa.m1320f(java.lang.String, int, int):java.net.InetAddress");
        }

        /* renamed from: g */
        private static int m1321g(String str, int i, int i2) {
            try {
                int parseInt = Integer.parseInt(C3002bw.m1295a(str, i, i2, "", false, false, false, true));
                if (parseInt <= 0 || parseInt > 65535) {
                    return -1;
                }
                return parseInt;
            } catch (NumberFormatException unused) {
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public final int mo38132a() {
            return this.f1622e != -1 ? this.f1622e : C3002bw.m1294a(this.f1618a);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public final int mo38133a(C3002bw bwVar, String str) {
            int i;
            int a;
            int i2;
            C3002bw bwVar2 = bwVar;
            String str2 = str;
            int a2 = C3030cl.m1416a(str2, 0, str.length());
            int b = C3030cl.m1436b(str2, a2, str.length());
            if (m1317c(str2, a2, b) != -1) {
                if (str.regionMatches(true, a2, "https:", 0, 6)) {
                    this.f1618a = UriUtil.HTTPS_SCHEME;
                    a2 += 6;
                } else if (!str.regionMatches(true, a2, "http:", 0, 5)) {
                    return C3004aa.f1628c;
                } else {
                    this.f1618a = UriUtil.HTTP_SCHEME;
                    a2 += 5;
                }
            } else if (bwVar2 == null) {
                return C3004aa.f1627b;
            } else {
                this.f1618a = bwVar2.f1609a;
            }
            int d = m1318d(str2, a2, b);
            char c = '#';
            if (d >= 2 || bwVar2 == null || !bwVar2.f1609a.equals(this.f1618a)) {
                int i3 = a2 + d;
                boolean z = false;
                boolean z2 = false;
                while (true) {
                    a = C3030cl.m1418a(str2, i3, b, "@/\\?#");
                    char charAt = a != b ? str2.charAt(a) : 65535;
                    if (!(charAt == 65535 || charAt == c || charAt == '/' || charAt == '\\')) {
                        switch (charAt) {
                            case '?':
                                break;
                            case '@':
                                if (!z) {
                                    int a3 = C3030cl.m1417a(str2, i3, a, ':');
                                    int i4 = a3;
                                    i2 = a;
                                    String a4 = C3002bw.m1295a(str, i3, a3, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
                                    if (z2) {
                                        a4 = this.f1619b + "%40" + a4;
                                    }
                                    this.f1619b = a4;
                                    if (i4 != i2) {
                                        this.f1620c = C3002bw.m1295a(str, i4 + 1, i2, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
                                        z = true;
                                    }
                                    z2 = true;
                                } else {
                                    i2 = a;
                                    this.f1620c += "%40" + C3002bw.m1295a(str, i3, i2, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
                                }
                                i3 = i2 + 1;
                                c = '#';
                                continue;
                        }
                    }
                }
                i = a;
                int e = m1319e(str2, i3, i);
                int i5 = e + 1;
                if (i5 < i) {
                    this.f1621d = m1314a(str2, i3, e);
                    this.f1622e = m1321g(str2, i5, i);
                    if (this.f1622e == -1) {
                        return C3004aa.f1629d;
                    }
                } else {
                    this.f1621d = m1314a(str2, i3, e);
                    this.f1622e = C3002bw.m1294a(this.f1618a);
                }
                if (this.f1621d == null) {
                    return C3004aa.f1630e;
                }
            } else {
                this.f1619b = bwVar.mo38124c();
                this.f1620c = bwVar.mo38125d();
                this.f1621d = bwVar2.f1610b;
                this.f1622e = bwVar2.f1611c;
                this.f1623f.clear();
                this.f1623f.addAll(bwVar.mo38128f());
                if (a2 == b || str2.charAt(a2) == '#') {
                    mo38134a(bwVar.mo38129g());
                }
                i = a2;
            }
            int a5 = C3030cl.m1418a(str2, i, b, "?#");
            m1316b(str2, i, a5);
            if (a5 < b && str2.charAt(a5) == '?') {
                int a6 = C3030cl.m1417a(str2, a5, b, '#');
                this.f1624g = C3002bw.m1303b(C3002bw.m1295a(str, a5 + 1, a6, " \"'<>#", true, false, true, true));
                a5 = a6;
            }
            if (a5 < b && str2.charAt(a5) == '#') {
                this.f1625h = C3002bw.m1295a(str, 1 + a5, b, "", true, false, false, false);
            }
            return C3004aa.f1626a;
        }

        /* renamed from: a */
        public final C3003aa mo38134a(String str) {
            this.f1624g = str != null ? C3002bw.m1303b(C3002bw.m1297a(str, " \"'<>#", true, false, true, true)) : null;
            return this;
        }

        /* renamed from: b */
        public final C3002bw mo38135b() {
            if (this.f1618a == null) {
                throw new IllegalStateException("scheme == null");
            } else if (this.f1621d != null) {
                return new C3002bw(this);
            } else {
                throw new IllegalStateException("host == null");
            }
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f1618a);
            sb.append("://");
            if (!this.f1619b.isEmpty() || !this.f1620c.isEmpty()) {
                sb.append(this.f1619b);
                if (!this.f1620c.isEmpty()) {
                    sb.append(':');
                    sb.append(this.f1620c);
                }
                sb.append('@');
            }
            if (this.f1621d.indexOf(58) != -1) {
                sb.append('[');
                sb.append(this.f1621d);
                sb.append(']');
            } else {
                sb.append(this.f1621d);
            }
            int a = mo38132a();
            if (a != C3002bw.m1294a(this.f1618a)) {
                sb.append(':');
                sb.append(a);
            }
            C3002bw.m1301a(sb, this.f1623f);
            if (this.f1624g != null) {
                sb.append('?');
                C3002bw.m1304b(sb, this.f1624g);
            }
            if (this.f1625h != null) {
                sb.append('#');
                sb.append(this.f1625h);
            }
            return sb.toString();
        }
    }

    C3002bw(C3003aa aaVar) {
        this.f1609a = aaVar.f1618a;
        this.f1613f = m1298a(aaVar.f1619b, false);
        this.f1614g = m1298a(aaVar.f1620c, false);
        this.f1610b = aaVar.f1621d;
        this.f1611c = aaVar.mo38132a();
        this.f1615h = m1299a(aaVar.f1623f, false);
        String str = null;
        this.f1612d = aaVar.f1624g != null ? m1299a(aaVar.f1624g, true) : null;
        this.f1616i = aaVar.f1625h != null ? m1298a(aaVar.f1625h, false) : str;
        this.f1617j = aaVar.toString();
    }

    /* renamed from: a */
    static int m1293a(char c) {
        if (c >= '0' && c <= '9') {
            return c - '0';
        }
        char c2 = 'a';
        if (c < 'a' || c > 'f') {
            c2 = 'A';
            if (c < 'A' || c > 'F') {
                return -1;
            }
        }
        return (c - c2) + 10;
    }

    /* renamed from: a */
    public static int m1294a(String str) {
        if (str.equals(UriUtil.HTTP_SCHEME)) {
            return 80;
        }
        return str.equals(UriUtil.HTTPS_SCHEME) ? 443 : -1;
    }

    /* renamed from: a */
    static String m1295a(String str, int i, int i2, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        String str3 = str;
        int i3 = i2;
        String str4 = str2;
        int i4 = i;
        while (i4 < i3) {
            int codePointAt = str.codePointAt(i4);
            int i5 = 43;
            if (codePointAt < 32 || codePointAt == 127 || ((codePointAt >= 128 && z4) || str4.indexOf(codePointAt) != -1 || ((codePointAt == 37 && (!z || (z2 && !m1302a(str, i4, i3)))) || (codePointAt == 43 && z3)))) {
                C3130en enVar = new C3130en();
                int i6 = i;
                enVar.mo38356a(str, i, i4);
                C3130en enVar2 = null;
                while (i4 < i3) {
                    int codePointAt2 = str.codePointAt(i4);
                    if (!z || !(codePointAt2 == 9 || codePointAt2 == 10 || codePointAt2 == 12 || codePointAt2 == 13)) {
                        if (codePointAt2 != i5 || !z3) {
                            if (codePointAt2 >= 32 && codePointAt2 != 127 && (codePointAt2 < 128 || !z4)) {
                                if (str4.indexOf(codePointAt2) == -1 && (codePointAt2 != 37 || (z && (!z2 || m1302a(str, i4, i3))))) {
                                    enVar.mo38352a(codePointAt2);
                                    i4 += Character.charCount(codePointAt2);
                                    i5 = 43;
                                }
                            }
                            if (enVar2 == null) {
                                enVar2 = new C3130en();
                            }
                            enVar2.mo38352a(codePointAt2);
                            while (!enVar2.mo38371c()) {
                                byte e = enVar2.mo38376e() & UByte.MAX_VALUE;
                                enVar.mo38387h(37);
                                enVar.mo38387h((int) f1608e[(e >> 4) & 15]);
                                enVar.mo38387h((int) f1608e[e & 15]);
                            }
                            i4 += Character.charCount(codePointAt2);
                            i5 = 43;
                        } else {
                            enVar.mo38364b(z ? "+" : "%2B");
                        }
                    }
                    i4 += Character.charCount(codePointAt2);
                    i5 = 43;
                }
                return enVar.mo38395l();
            }
            i4 += Character.charCount(codePointAt);
        }
        int i7 = i;
        return str.substring(i, i2);
    }

    /* renamed from: a */
    static String m1296a(String str, int i, int i2, boolean z) {
        for (int i3 = i; i3 < i2; i3++) {
            char charAt = str.charAt(i3);
            if (charAt == '%' || (charAt == '+' && z)) {
                C3130en enVar = new C3130en();
                enVar.mo38356a(str, i, i3);
                m1300a(enVar, str, i3, i2, z);
                return enVar.mo38395l();
            }
        }
        return str.substring(i, i2);
    }

    /* renamed from: a */
    static String m1297a(String str, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        return m1295a(str, 0, str.length(), str2, z, z2, z3, z4);
    }

    /* renamed from: a */
    private static String m1298a(String str, boolean z) {
        return m1296a(str, 0, str.length(), z);
    }

    /* renamed from: a */
    private static List m1299a(List list, boolean z) {
        int size = list.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            String str = (String) list.get(i);
            arrayList.add(str != null ? m1298a(str, z) : null);
        }
        return Collections.unmodifiableList(arrayList);
    }

    /* renamed from: a */
    private static void m1300a(C3130en enVar, String str, int i, int i2, boolean z) {
        int i3;
        while (i < i2) {
            int codePointAt = str.codePointAt(i);
            if (codePointAt == 37 && (i3 = i + 2) < i2) {
                int a = m1293a(str.charAt(i + 1));
                int a2 = m1293a(str.charAt(i3));
                if (!(a == -1 || a2 == -1)) {
                    enVar.mo38387h((a << 4) + a2);
                    i = i3;
                    i += Character.charCount(codePointAt);
                }
            } else if (codePointAt == 43 && z) {
                enVar.mo38387h(32);
                i += Character.charCount(codePointAt);
            }
            enVar.mo38352a(codePointAt);
            i += Character.charCount(codePointAt);
        }
    }

    /* renamed from: a */
    static void m1301a(StringBuilder sb, List list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            sb.append(IOUtils.DIR_SEPARATOR_UNIX);
            sb.append((String) list.get(i));
        }
    }

    /* renamed from: a */
    private static boolean m1302a(String str, int i, int i2) {
        int i3 = i + 2;
        return i3 < i2 && str.charAt(i) == '%' && m1293a(str.charAt(i + 1)) != -1 && m1293a(str.charAt(i3)) != -1;
    }

    /* renamed from: b */
    static List m1303b(String str) {
        String str2;
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i <= str.length()) {
            int indexOf = str.indexOf(38, i);
            if (indexOf == -1) {
                indexOf = str.length();
            }
            int indexOf2 = str.indexOf(61, i);
            if (indexOf2 == -1 || indexOf2 > indexOf) {
                arrayList.add(str.substring(i, indexOf));
                str2 = null;
            } else {
                arrayList.add(str.substring(i, indexOf2));
                str2 = str.substring(indexOf2 + 1, indexOf);
            }
            arrayList.add(str2);
            i = indexOf + 1;
        }
        return arrayList;
    }

    /* renamed from: b */
    public static void m1304b(StringBuilder sb, List list) {
        int size = list.size();
        for (int i = 0; i < size; i += 2) {
            String str = (String) list.get(i);
            String str2 = (String) list.get(i + 1);
            if (i > 0) {
                sb.append(Typography.amp);
            }
            sb.append(str);
            if (str2 != null) {
                sb.append('=');
                sb.append(str2);
            }
        }
    }

    /* renamed from: d */
    public static C3002bw m1305d(String str) {
        C3003aa aaVar = new C3003aa();
        if (aaVar.mo38133a((C3002bw) null, str) == C3003aa.C3004aa.f1626a) {
            return aaVar.mo38135b();
        }
        return null;
    }

    /* renamed from: a */
    public final URI mo38121a() {
        C3003aa aaVar = new C3003aa();
        aaVar.f1618a = this.f1609a;
        aaVar.f1619b = mo38124c();
        aaVar.f1620c = mo38125d();
        aaVar.f1621d = this.f1610b;
        aaVar.f1622e = this.f1611c != m1294a(this.f1609a) ? this.f1611c : -1;
        aaVar.f1623f.clear();
        aaVar.f1623f.addAll(mo38128f());
        aaVar.mo38134a(mo38129g());
        aaVar.f1625h = this.f1616i == null ? null : this.f1617j.substring(this.f1617j.indexOf(35) + 1);
        int size = aaVar.f1623f.size();
        for (int i = 0; i < size; i++) {
            aaVar.f1623f.set(i, m1297a((String) aaVar.f1623f.get(i), "[]", true, true, false, true));
        }
        if (aaVar.f1624g != null) {
            int size2 = aaVar.f1624g.size();
            for (int i2 = 0; i2 < size2; i2++) {
                String str = (String) aaVar.f1624g.get(i2);
                if (str != null) {
                    aaVar.f1624g.set(i2, m1297a(str, "\\^`{|}", true, true, true, true));
                }
            }
        }
        if (aaVar.f1625h != null) {
            aaVar.f1625h = m1297a(aaVar.f1625h, " \"#<>\\^`{|}", true, true, false, false);
        }
        String aaVar2 = aaVar.toString();
        try {
            return new URI(aaVar2);
        } catch (URISyntaxException e) {
            try {
                return URI.create(aaVar2.replaceAll("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]", ""));
            } catch (Exception unused) {
                throw new RuntimeException(e);
            }
        }
    }

    /* renamed from: b */
    public final boolean mo38122b() {
        return this.f1609a.equals(UriUtil.HTTPS_SCHEME);
    }

    /* renamed from: c */
    public final C3003aa mo38123c(String str) {
        C3003aa aaVar = new C3003aa();
        if (aaVar.mo38133a(this, str) == C3003aa.C3004aa.f1626a) {
            return aaVar;
        }
        return null;
    }

    /* renamed from: c */
    public final String mo38124c() {
        if (this.f1613f.isEmpty()) {
            return "";
        }
        int length = this.f1609a.length() + 3;
        String str = this.f1617j;
        return this.f1617j.substring(length, C3030cl.m1418a(str, length, str.length(), ":@"));
    }

    /* renamed from: d */
    public final String mo38125d() {
        if (this.f1614g.isEmpty()) {
            return "";
        }
        int indexOf = this.f1617j.indexOf(64);
        return this.f1617j.substring(this.f1617j.indexOf(58, this.f1609a.length() + 3) + 1, indexOf);
    }

    /* renamed from: e */
    public final String mo38126e() {
        int indexOf = this.f1617j.indexOf(47, this.f1609a.length() + 3);
        String str = this.f1617j;
        return this.f1617j.substring(indexOf, C3030cl.m1418a(str, indexOf, str.length(), "?#"));
    }

    public final boolean equals(Object obj) {
        return (obj instanceof C3002bw) && ((C3002bw) obj).f1617j.equals(this.f1617j);
    }

    /* renamed from: f */
    public final List mo38128f() {
        int indexOf = this.f1617j.indexOf(47, this.f1609a.length() + 3);
        String str = this.f1617j;
        int a = C3030cl.m1418a(str, indexOf, str.length(), "?#");
        ArrayList arrayList = new ArrayList();
        while (indexOf < a) {
            int i = indexOf + 1;
            int a2 = C3030cl.m1417a(this.f1617j, i, a, (char) IOUtils.DIR_SEPARATOR_UNIX);
            arrayList.add(this.f1617j.substring(i, a2));
            indexOf = a2;
        }
        return arrayList;
    }

    /* renamed from: g */
    public final String mo38129g() {
        if (this.f1612d == null) {
            return null;
        }
        int indexOf = this.f1617j.indexOf(63) + 1;
        return this.f1617j.substring(indexOf, C3030cl.m1417a(this.f1617j, indexOf + 1, this.f1617j.length(), '#'));
    }

    public final int hashCode() {
        return this.f1617j.hashCode();
    }

    public final String toString() {
        return this.f1617j;
    }
}
