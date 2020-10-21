package com.uxcam.internals;

import android.support.p002v4.media.session.PlaybackStateCompat;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.reflect.Array;
import java.net.IDN;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import org.apache.commons.lang3.time.TimeZones;
import org.apache.logging.log4j.message.ParameterizedMessage;

/* renamed from: com.uxcam.internals.cl */
public final class C3030cl {

    /* renamed from: a */
    public static final byte[] f1780a = new byte[0];

    /* renamed from: b */
    public static final String[] f1781b = new String[0];

    /* renamed from: c */
    public static final C3024cg f1782c = C3024cg.m1399a(f1780a);

    /* renamed from: d */
    public static final C3019ce f1783d;

    /* renamed from: e */
    public static final Charset f1784e = Charset.forName("UTF-8");

    /* renamed from: f */
    public static final TimeZone f1785f = TimeZone.getTimeZone(TimeZones.GMT_ID);

    /* renamed from: g */
    private static final C3133eq f1786g = C3133eq.m1830b("efbbbf");

    /* renamed from: h */
    private static final C3133eq f1787h = C3133eq.m1830b("feff");

    /* renamed from: i */
    private static final C3133eq f1788i = C3133eq.m1830b("fffe");

    /* renamed from: j */
    private static final C3133eq f1789j = C3133eq.m1830b("0000ffff");

    /* renamed from: k */
    private static final C3133eq f1790k = C3133eq.m1830b("ffff0000");

    /* renamed from: l */
    private static final Charset f1791l = Charset.forName("UTF-16BE");

    /* renamed from: m */
    private static final Charset f1792m = Charset.forName("UTF-16LE");

    /* renamed from: n */
    private static final Charset f1793n = Charset.forName("UTF-32BE");

    /* renamed from: o */
    private static final Charset f1794o = Charset.forName("UTF-32LE");

    /* renamed from: p */
    private static final Pattern f1795p = Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");

    static {
        byte[] bArr = f1780a;
        f1783d = C3019ce.m1376a(bArr, bArr.length);
    }

    /* renamed from: a */
    public static int m1416a(String str, int i, int i2) {
        while (i < i2) {
            switch (str.charAt(i)) {
                case 9:
                case 10:
                case 12:
                case 13:
                case ' ':
                    i++;
                default:
                    return i;
            }
        }
        return i2;
    }

    /* renamed from: a */
    public static int m1417a(String str, int i, int i2, char c) {
        while (i < i2) {
            if (str.charAt(i) == c) {
                return i;
            }
            i++;
        }
        return i2;
    }

    /* renamed from: a */
    public static int m1418a(String str, int i, int i2, String str2) {
        while (i < i2) {
            if (str2.indexOf(str.charAt(i)) != -1) {
                return i;
            }
            i++;
        }
        return i2;
    }

    /* renamed from: a */
    public static int m1419a(Object[] objArr, Object obj) {
        int length = objArr.length;
        for (int i = 0; i < length; i++) {
            if (m1433a(objArr[i], obj)) {
                return i;
            }
        }
        return -1;
    }

    /* renamed from: a */
    public static String m1420a(C3002bw bwVar, boolean z) {
        String str;
        if (bwVar.f1610b.contains(ParameterizedMessage.ERROR_MSG_SEPARATOR)) {
            str = "[" + bwVar.f1610b + "]";
        } else {
            str = bwVar.f1610b;
        }
        if (!z && bwVar.f1611c == C3002bw.m1294a(bwVar.f1609a)) {
            return str;
        }
        return str + ParameterizedMessage.ERROR_MSG_SEPARATOR + bwVar.f1611c;
    }

    /* renamed from: a */
    public static String m1421a(String str) {
        boolean z;
        try {
            String lowerCase = IDN.toASCII(str).toLowerCase(Locale.US);
            if (lowerCase.isEmpty()) {
                return null;
            }
            int i = 0;
            while (true) {
                z = true;
                if (i >= lowerCase.length()) {
                    z = false;
                    break;
                }
                char charAt = lowerCase.charAt(i);
                if (charAt <= 31) {
                    break;
                } else if (charAt >= 127) {
                    break;
                } else if (" #%/:?@[\\]".indexOf(charAt) != -1) {
                    break;
                } else {
                    i++;
                }
            }
            if (z) {
                return null;
            }
            return lowerCase;
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    /* renamed from: a */
    public static String m1422a(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    /* renamed from: a */
    public static Charset m1423a(C3132ep epVar, Charset charset) {
        if (epVar.mo38367b(f1786g)) {
            epVar.mo38382f((long) f1786g.mo38415g());
            return f1784e;
        } else if (epVar.mo38367b(f1787h)) {
            epVar.mo38382f((long) f1787h.mo38415g());
            return f1791l;
        } else if (epVar.mo38367b(f1788i)) {
            epVar.mo38382f((long) f1788i.mo38415g());
            return f1792m;
        } else if (epVar.mo38367b(f1789j)) {
            epVar.mo38382f((long) f1789j.mo38415g());
            return f1793n;
        } else if (!epVar.mo38367b(f1790k)) {
            return charset;
        } else {
            epVar.mo38382f((long) f1790k.mo38415g());
            return f1794o;
        }
    }

    /* renamed from: a */
    public static List m1424a(List list) {
        return Collections.unmodifiableList(new ArrayList(list));
    }

    /* renamed from: a */
    public static List m1425a(Object... objArr) {
        return Collections.unmodifiableList(Arrays.asList((Object[]) objArr.clone()));
    }

    /* renamed from: a */
    public static ThreadFactory m1426a(final String str, final boolean z) {
        return new ThreadFactory() {
            public final Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable, str);
                thread.setDaemon(z);
                return thread;
            }
        };
    }

    /* renamed from: a */
    public static void m1427a(long j, long j2) {
        if ((j2 | 0) < 0 || 0 > j || j - 0 < j2) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    /* renamed from: a */
    public static void m1428a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: a */
    public static void m1429a(Socket socket) {
        if (socket != null) {
            try {
                socket.close();
            } catch (AssertionError e) {
                if (!m1432a(e)) {
                    throw e;
                }
            } catch (RuntimeException e2) {
                throw e2;
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: a */
    public static boolean m1430a(C3148fc fcVar, int i, TimeUnit timeUnit) {
        long nanoTime = System.nanoTime();
        long c = fcVar.mo38197a().mo38425d_() ? fcVar.mo38197a().mo38422c() - nanoTime : Long.MAX_VALUE;
        fcVar.mo38197a().mo38420a(Math.min(c, timeUnit.toNanos((long) i)) + nanoTime);
        try {
            C3130en enVar = new C3130en();
            while (fcVar.mo38196a(enVar, PlaybackStateCompat.ACTION_PLAY_FROM_URI) != -1) {
                enVar.mo38398o();
            }
            if (c == Long.MAX_VALUE) {
                fcVar.mo38197a().mo38426e_();
                return true;
            }
            fcVar.mo38197a().mo38420a(nanoTime + c);
            return true;
        } catch (InterruptedIOException unused) {
            if (c == Long.MAX_VALUE) {
                fcVar.mo38197a().mo38426e_();
                return false;
            }
            fcVar.mo38197a().mo38420a(nanoTime + c);
            return false;
        } catch (Throwable th) {
            if (c == Long.MAX_VALUE) {
                fcVar.mo38197a().mo38426e_();
            } else {
                fcVar.mo38197a().mo38420a(nanoTime + c);
            }
            throw th;
        }
    }

    /* renamed from: a */
    public static boolean m1431a(C3148fc fcVar, TimeUnit timeUnit) {
        try {
            return m1430a(fcVar, 100, timeUnit);
        } catch (IOException unused) {
            return false;
        }
    }

    /* renamed from: a */
    public static boolean m1432a(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }

    /* renamed from: a */
    public static boolean m1433a(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    /* renamed from: a */
    public static Object[] m1434a(Class cls, Object[] objArr, Object[] objArr2) {
        ArrayList arrayList = new ArrayList();
        for (Object obj : objArr) {
            int length = objArr2.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                Object obj2 = objArr2[i];
                if (obj.equals(obj2)) {
                    arrayList.add(obj2);
                    break;
                }
                i++;
            }
        }
        return arrayList.toArray((Object[]) Array.newInstance(cls, arrayList.size()));
    }

    /* renamed from: a */
    public static String[] m1435a(String[] strArr, String str) {
        String[] strArr2 = new String[(strArr.length + 1)];
        System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
        strArr2[strArr2.length - 1] = str;
        return strArr2;
    }

    /* renamed from: b */
    public static int m1436b(String str, int i, int i2) {
        int i3 = i2 - 1;
        while (i3 >= i) {
            switch (str.charAt(i3)) {
                case 9:
                case 10:
                case 12:
                case 13:
                case ' ':
                    i3--;
                default:
                    return i3 + 1;
            }
        }
        return i;
    }

    /* renamed from: b */
    public static boolean m1437b(String str) {
        return f1795p.matcher(str).matches();
    }

    /* renamed from: c */
    public static String m1438c(String str, int i, int i2) {
        int a = m1416a(str, i, i2);
        return str.substring(a, m1436b(str, a, i2));
    }
}
