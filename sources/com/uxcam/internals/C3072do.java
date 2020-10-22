package com.uxcam.internals;

import com.facebook.common.util.UriUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.UByte;
import kotlin.jvm.internal.ByteCompanionObject;
import org.unimodules.interfaces.permissions.PermissionsResponse;
import p024io.nlopez.smartlocation.geofencing.providers.GeofencingGooglePlayServicesProvider;

/* renamed from: com.uxcam.internals.do */
final class C3072do {

    /* renamed from: a */
    static final C3071dn[] f1946a = {new C3071dn(C3071dn.f1942f, ""), new C3071dn(C3071dn.f1939c, "GET"), new C3071dn(C3071dn.f1939c, "POST"), new C3071dn(C3071dn.f1940d, "/"), new C3071dn(C3071dn.f1940d, "/index.html"), new C3071dn(C3071dn.f1941e, (String) UriUtil.HTTP_SCHEME), new C3071dn(C3071dn.f1941e, (String) UriUtil.HTTPS_SCHEME), new C3071dn(C3071dn.f1938b, "200"), new C3071dn(C3071dn.f1938b, "204"), new C3071dn(C3071dn.f1938b, "206"), new C3071dn(C3071dn.f1938b, "304"), new C3071dn(C3071dn.f1938b, "400"), new C3071dn(C3071dn.f1938b, "404"), new C3071dn(C3071dn.f1938b, "500"), new C3071dn("accept-charset", ""), new C3071dn("accept-encoding", "gzip, deflate"), new C3071dn("accept-language", ""), new C3071dn("accept-ranges", ""), new C3071dn("accept", ""), new C3071dn("access-control-allow-origin", ""), new C3071dn("age", ""), new C3071dn("allow", ""), new C3071dn("authorization", ""), new C3071dn("cache-control", ""), new C3071dn("content-disposition", ""), new C3071dn("content-encoding", ""), new C3071dn("content-language", ""), new C3071dn("content-length", ""), new C3071dn("content-location", ""), new C3071dn("content-range", ""), new C3071dn("content-type", ""), new C3071dn("cookie", ""), new C3071dn("date", ""), new C3071dn("etag", ""), new C3071dn("expect", ""), new C3071dn((String) PermissionsResponse.EXPIRES_KEY, ""), new C3071dn("from", ""), new C3071dn("host", ""), new C3071dn("if-match", ""), new C3071dn("if-modified-since", ""), new C3071dn("if-none-match", ""), new C3071dn("if-range", ""), new C3071dn("if-unmodified-since", ""), new C3071dn("last-modified", ""), new C3071dn("link", ""), new C3071dn((String) GeofencingGooglePlayServicesProvider.LOCATION_EXTRA_ID, ""), new C3071dn("max-forwards", ""), new C3071dn("proxy-authenticate", ""), new C3071dn("proxy-authorization", ""), new C3071dn("range", ""), new C3071dn("referer", ""), new C3071dn("refresh", ""), new C3071dn("retry-after", ""), new C3071dn("server", ""), new C3071dn("set-cookie", ""), new C3071dn("strict-transport-security", ""), new C3071dn("transfer-encoding", ""), new C3071dn("user-agent", ""), new C3071dn("vary", ""), new C3071dn("via", ""), new C3071dn("www-authenticate", "")};

    /* renamed from: b */
    static final Map f1947b;

    /* renamed from: com.uxcam.internals.do$aa */
    static final class C3073aa {

        /* renamed from: a */
        C3071dn[] f1948a;

        /* renamed from: b */
        int f1949b;

        /* renamed from: c */
        int f1950c;

        /* renamed from: d */
        int f1951d;

        /* renamed from: e */
        private final List f1952e;

        /* renamed from: f */
        private final C3132ep f1953f;

        /* renamed from: g */
        private final int f1954g;

        /* renamed from: h */
        private int f1955h;

        C3073aa(C3148fc fcVar) {
            this(fcVar, (byte) 0);
        }

        private C3073aa(C3148fc fcVar, byte b) {
            this.f1952e = new ArrayList();
            this.f1948a = new C3071dn[8];
            this.f1949b = this.f1948a.length - 1;
            this.f1950c = 0;
            this.f1951d = 0;
            this.f1954g = 4096;
            this.f1955h = 4096;
            this.f1953f = C3138ev.m1863a(fcVar);
        }

        /* renamed from: a */
        private int m1543a(int i) {
            int i2 = 0;
            if (i > 0) {
                int length = this.f1948a.length;
                while (true) {
                    length--;
                    if (length < this.f1949b || i <= 0) {
                        System.arraycopy(this.f1948a, this.f1949b + 1, this.f1948a, this.f1949b + 1 + i2, this.f1950c);
                        this.f1949b += i2;
                    } else {
                        i -= this.f1948a[length].f1945i;
                        this.f1951d -= this.f1948a[length].f1945i;
                        this.f1950c--;
                        i2++;
                    }
                }
                System.arraycopy(this.f1948a, this.f1949b + 1, this.f1948a, this.f1949b + 1 + i2, this.f1950c);
                this.f1949b += i2;
            }
            return i2;
        }

        /* renamed from: a */
        private int m1544a(int i, int i2) {
            int i3 = i & i2;
            if (i3 < i2) {
                return i3;
            }
            int i4 = 0;
            while (true) {
                int e = m1551e();
                if ((e & 128) == 0) {
                    return i2 + (e << i4);
                }
                i2 += (e & 127) << i4;
                i4 += 7;
            }
        }

        /* renamed from: a */
        private void m1545a(C3071dn dnVar) {
            this.f1952e.add(dnVar);
            int i = dnVar.f1945i;
            if (i > this.f1955h) {
                m1549d();
                return;
            }
            m1543a((this.f1951d + i) - this.f1955h);
            if (this.f1950c + 1 > this.f1948a.length) {
                C3071dn[] dnVarArr = new C3071dn[(this.f1948a.length * 2)];
                System.arraycopy(this.f1948a, 0, dnVarArr, this.f1948a.length, this.f1948a.length);
                this.f1949b = this.f1948a.length - 1;
                this.f1948a = dnVarArr;
            }
            int i2 = this.f1949b;
            this.f1949b = i2 - 1;
            this.f1948a[i2] = dnVar;
            this.f1950c++;
            this.f1951d += i;
        }

        /* renamed from: b */
        private int m1546b(int i) {
            return this.f1949b + 1 + i;
        }

        /* renamed from: c */
        private C3133eq m1547c(int i) {
            return (m1550d(i) ? C3072do.f1946a[i] : this.f1948a[m1546b(i - C3072do.f1946a.length)]).f1943g;
        }

        /* renamed from: c */
        private void m1548c() {
            if (this.f1955h >= this.f1951d) {
                return;
            }
            if (this.f1955h == 0) {
                m1549d();
            } else {
                m1543a(this.f1951d - this.f1955h);
            }
        }

        /* renamed from: d */
        private void m1549d() {
            Arrays.fill(this.f1948a, (Object) null);
            this.f1949b = this.f1948a.length - 1;
            this.f1950c = 0;
            this.f1951d = 0;
        }

        /* renamed from: d */
        private static boolean m1550d(int i) {
            return i >= 0 && i <= C3072do.f1946a.length - 1;
        }

        /* renamed from: e */
        private int m1551e() {
            return this.f1953f.mo38376e() & UByte.MAX_VALUE;
        }

        /* renamed from: f */
        private C3133eq m1552f() {
            int e = m1551e();
            boolean z = (e & 128) == 128;
            int a = m1544a(e, 127);
            return z ? C3133eq.m1829a(C3101dv.m1661a().mo38305a(this.f1953f.mo38378e((long) a))) : this.f1953f.mo38370c((long) a);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public final void mo38248a() {
            C3071dn dnVar;
            List list;
            C3071dn dnVar2;
            while (!this.f1953f.mo38371c()) {
                byte e = this.f1953f.mo38376e() & UByte.MAX_VALUE;
                if (e == 128) {
                    throw new IOException("index == 0");
                } else if ((e & ByteCompanionObject.MIN_VALUE) == 128) {
                    int a = m1544a(e, 127) - 1;
                    if (m1550d(a)) {
                        this.f1952e.add(C3072do.f1946a[a]);
                    } else {
                        int b = m1546b(a - C3072do.f1946a.length);
                        if (b < 0 || b > this.f1948a.length - 1) {
                            throw new IOException("Header index too large " + (a + 1));
                        }
                        this.f1952e.add(this.f1948a[b]);
                    }
                } else {
                    if (e == 64) {
                        dnVar2 = new C3071dn(C3072do.m1542a(m1552f()), m1552f());
                    } else if ((e & 64) == 64) {
                        dnVar2 = new C3071dn(m1547c(m1544a(e, 63) - 1), m1552f());
                    } else if ((e & 32) == 32) {
                        this.f1955h = m1544a(e, 31);
                        if (this.f1955h < 0 || this.f1955h > this.f1954g) {
                            throw new IOException("Invalid dynamic table size update " + this.f1955h);
                        }
                        m1548c();
                    } else {
                        if (e == 16 || e == 0) {
                            C3133eq a2 = C3072do.m1542a(m1552f());
                            C3133eq f = m1552f();
                            list = this.f1952e;
                            dnVar = new C3071dn(a2, f);
                        } else {
                            C3133eq c = m1547c(m1544a(e, 15) - 1);
                            C3133eq f2 = m1552f();
                            list = this.f1952e;
                            dnVar = new C3071dn(c, f2);
                        }
                        list.add(dnVar);
                    }
                    m1545a(dnVar2);
                }
            }
        }

        /* renamed from: b */
        public final List mo38249b() {
            ArrayList arrayList = new ArrayList(this.f1952e);
            this.f1952e.clear();
            return arrayList;
        }
    }

    /* renamed from: com.uxcam.internals.do$ab */
    static final class C3074ab {

        /* renamed from: a */
        int f1956a;

        /* renamed from: b */
        int f1957b;

        /* renamed from: c */
        C3071dn[] f1958c;

        /* renamed from: d */
        int f1959d;

        /* renamed from: e */
        int f1960e;

        /* renamed from: f */
        int f1961f;

        /* renamed from: g */
        private final C3130en f1962g;

        /* renamed from: h */
        private final boolean f1963h;

        /* renamed from: i */
        private int f1964i;

        /* renamed from: j */
        private boolean f1965j;

        C3074ab(C3130en enVar) {
            this(enVar, (byte) 0);
        }

        private C3074ab(C3130en enVar, byte b) {
            this.f1964i = Integer.MAX_VALUE;
            this.f1958c = new C3071dn[8];
            this.f1959d = this.f1958c.length - 1;
            this.f1960e = 0;
            this.f1961f = 0;
            this.f1956a = 4096;
            this.f1957b = 4096;
            this.f1963h = true;
            this.f1962g = enVar;
        }

        /* renamed from: a */
        private void m1555a() {
            Arrays.fill(this.f1958c, (Object) null);
            this.f1959d = this.f1958c.length - 1;
            this.f1960e = 0;
            this.f1961f = 0;
        }

        /* renamed from: a */
        private void m1556a(int i, int i2, int i3) {
            int i4;
            C3130en enVar;
            if (i < i2) {
                enVar = this.f1962g;
                i4 = i | i3;
            } else {
                this.f1962g.mo38387h(i3 | i2);
                i4 = i - i2;
                while (i4 >= 128) {
                    this.f1962g.mo38387h(128 | (i4 & 127));
                    i4 >>>= 7;
                }
                enVar = this.f1962g;
            }
            enVar.mo38387h(i4);
        }

        /* renamed from: a */
        private void m1557a(C3071dn dnVar) {
            int i = dnVar.f1945i;
            if (i > this.f1957b) {
                m1555a();
                return;
            }
            m1559b((this.f1961f + i) - this.f1957b);
            if (this.f1960e + 1 > this.f1958c.length) {
                C3071dn[] dnVarArr = new C3071dn[(this.f1958c.length * 2)];
                System.arraycopy(this.f1958c, 0, dnVarArr, this.f1958c.length, this.f1958c.length);
                this.f1959d = this.f1958c.length - 1;
                this.f1958c = dnVarArr;
            }
            int i2 = this.f1959d;
            this.f1959d = i2 - 1;
            this.f1958c[i2] = dnVar;
            this.f1960e++;
            this.f1961f += i;
        }

        /* renamed from: a */
        private void m1558a(C3133eq eqVar) {
            int g;
            int i;
            if (this.f1963h) {
                C3101dv.m1661a();
                if (C3101dv.m1660a(eqVar) < eqVar.mo38415g()) {
                    C3130en enVar = new C3130en();
                    C3101dv.m1661a();
                    C3101dv.m1662a(eqVar, enVar);
                    eqVar = enVar.mo38394k();
                    g = eqVar.mo38415g();
                    i = 128;
                    m1556a(g, 127, i);
                    this.f1962g.mo38369c(eqVar);
                }
            }
            g = eqVar.mo38415g();
            i = 0;
            m1556a(g, 127, i);
            this.f1962g.mo38369c(eqVar);
        }

        /* renamed from: b */
        private int m1559b(int i) {
            int i2 = 0;
            if (i > 0) {
                int length = this.f1958c.length;
                while (true) {
                    length--;
                    if (length < this.f1959d || i <= 0) {
                        System.arraycopy(this.f1958c, this.f1959d + 1, this.f1958c, this.f1959d + 1 + i2, this.f1960e);
                        Arrays.fill(this.f1958c, this.f1959d + 1, this.f1959d + 1 + i2, (Object) null);
                        this.f1959d += i2;
                    } else {
                        i -= this.f1958c[length].f1945i;
                        this.f1961f -= this.f1958c[length].f1945i;
                        this.f1960e--;
                        i2++;
                    }
                }
                System.arraycopy(this.f1958c, this.f1959d + 1, this.f1958c, this.f1959d + 1 + i2, this.f1960e);
                Arrays.fill(this.f1958c, this.f1959d + 1, this.f1959d + 1 + i2, (Object) null);
                this.f1959d += i2;
            }
            return i2;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public final void mo38250a(int i) {
            this.f1956a = i;
            int min = Math.min(i, 16384);
            if (this.f1957b != min) {
                if (min < this.f1957b) {
                    this.f1964i = Math.min(this.f1964i, min);
                }
                this.f1965j = true;
                this.f1957b = min;
                if (this.f1957b >= this.f1961f) {
                    return;
                }
                if (this.f1957b == 0) {
                    m1555a();
                } else {
                    m1559b(this.f1961f - this.f1957b);
                }
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public final void mo38251a(List list) {
            int i;
            int i2;
            if (this.f1965j) {
                if (this.f1964i < this.f1957b) {
                    m1556a(this.f1964i, 31, 32);
                }
                this.f1965j = false;
                this.f1964i = Integer.MAX_VALUE;
                m1556a(this.f1957b, 31, 32);
            }
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                C3071dn dnVar = (C3071dn) list.get(i3);
                C3133eq f = dnVar.f1943g.mo38414f();
                C3133eq eqVar = dnVar.f1944h;
                Integer num = (Integer) C3072do.f1947b.get(f);
                if (num != null) {
                    i2 = num.intValue() + 1;
                    if (i2 > 1 && i2 < 8) {
                        if (C3030cl.m1433a((Object) C3072do.f1946a[i2 - 1].f1944h, (Object) eqVar)) {
                            i = i2;
                        } else if (C3030cl.m1433a((Object) C3072do.f1946a[i2].f1944h, (Object) eqVar)) {
                            i = i2;
                            i2++;
                        }
                    }
                    i = i2;
                    i2 = -1;
                } else {
                    i2 = -1;
                    i = -1;
                }
                if (i2 == -1) {
                    int i4 = this.f1959d + 1;
                    int length = this.f1958c.length;
                    while (true) {
                        if (i4 >= length) {
                            break;
                        }
                        if (C3030cl.m1433a((Object) this.f1958c[i4].f1943g, (Object) f)) {
                            if (C3030cl.m1433a((Object) this.f1958c[i4].f1944h, (Object) eqVar)) {
                                i2 = C3072do.f1946a.length + (i4 - this.f1959d);
                                break;
                            } else if (i == -1) {
                                i = (i4 - this.f1959d) + C3072do.f1946a.length;
                            }
                        }
                        i4++;
                    }
                }
                if (i2 != -1) {
                    m1556a(i2, 127, 128);
                } else {
                    if (i == -1) {
                        this.f1962g.mo38387h(64);
                        m1558a(f);
                    } else {
                        C3133eq eqVar2 = C3071dn.f1937a;
                        if (!f.mo38406a(0, eqVar2, 0, eqVar2.mo38415g()) || C3071dn.f1942f.equals(f)) {
                            m1556a(i, 63, 64);
                        } else {
                            m1556a(i, 15, 0);
                            m1558a(eqVar);
                        }
                    }
                    m1558a(eqVar);
                    m1557a(dnVar);
                }
            }
        }
    }

    static {
        LinkedHashMap linkedHashMap = new LinkedHashMap(f1946a.length);
        for (int i = 0; i < f1946a.length; i++) {
            if (!linkedHashMap.containsKey(f1946a[i].f1943g)) {
                linkedHashMap.put(f1946a[i].f1943g, Integer.valueOf(i));
            }
        }
        f1947b = Collections.unmodifiableMap(linkedHashMap);
    }

    /* renamed from: a */
    static C3133eq m1542a(C3133eq eqVar) {
        int g = eqVar.mo38415g();
        int i = 0;
        while (i < g) {
            byte a = eqVar.mo38402a(i);
            if (a < 65 || a > 90) {
                i++;
            } else {
                throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: " + eqVar.mo38404a());
            }
        }
        return eqVar;
    }
}
