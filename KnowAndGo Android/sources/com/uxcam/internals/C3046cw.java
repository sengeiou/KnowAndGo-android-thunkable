package com.uxcam.internals;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketAddress;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import org.apache.logging.log4j.message.ParameterizedMessage;

/* renamed from: com.uxcam.internals.cw */
public final class C3046cw {

    /* renamed from: a */
    final C2974be f1862a;

    /* renamed from: b */
    final C3044cu f1863b;

    /* renamed from: c */
    private Proxy f1864c;

    /* renamed from: d */
    private InetSocketAddress f1865d;

    /* renamed from: e */
    private List f1866e = Collections.emptyList();

    /* renamed from: f */
    private int f1867f;

    /* renamed from: g */
    private List f1868g = Collections.emptyList();

    /* renamed from: h */
    private int f1869h;

    /* renamed from: i */
    private final List f1870i = new ArrayList();

    public C3046cw(C2974be beVar, C3044cu cuVar) {
        List list;
        this.f1862a = beVar;
        this.f1863b = cuVar;
        C3002bw bwVar = beVar.f1397a;
        Proxy proxy = beVar.f1404h;
        if (proxy != null) {
            list = Collections.singletonList(proxy);
        } else {
            List<Proxy> select = this.f1862a.f1403g.select(bwVar.mo38121a());
            if (select == null || select.isEmpty()) {
                list = C3030cl.m1425a((Object[]) new Proxy[]{Proxy.NO_PROXY});
            } else {
                list = C3030cl.m1424a((List) select);
            }
        }
        this.f1866e = list;
        this.f1867f = 0;
    }

    /* renamed from: a */
    private void m1471a(Proxy proxy) {
        String str;
        int i;
        this.f1868g = new ArrayList();
        if (proxy.type() == Proxy.Type.DIRECT || proxy.type() == Proxy.Type.SOCKS) {
            str = this.f1862a.f1397a.f1610b;
            i = this.f1862a.f1397a.f1611c;
        } else {
            SocketAddress address = proxy.address();
            if (address instanceof InetSocketAddress) {
                InetSocketAddress inetSocketAddress = (InetSocketAddress) address;
                InetAddress address2 = inetSocketAddress.getAddress();
                str = address2 == null ? inetSocketAddress.getHostName() : address2.getHostAddress();
                i = inetSocketAddress.getPort();
            } else {
                throw new IllegalArgumentException("Proxy.address() is not an InetSocketAddress: " + address.getClass());
            }
        }
        if (i <= 0 || i > 65535) {
            throw new SocketException("No route to " + str + ParameterizedMessage.ERROR_MSG_SEPARATOR + i + "; port is out of range");
        }
        if (proxy.type() == Proxy.Type.SOCKS) {
            this.f1868g.add(InetSocketAddress.createUnresolved(str, i));
        } else {
            List a = this.f1862a.f1398b.mo38103a(str);
            int size = a.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.f1868g.add(new InetSocketAddress((InetAddress) a.get(i2), i));
            }
        }
        this.f1869h = 0;
    }

    /* renamed from: a */
    public final C3026ch mo38214a() {
        while (true) {
            if (!mo38216c()) {
                if (!mo38215b()) {
                    if (mo38217d()) {
                        return (C3026ch) this.f1870i.remove(0);
                    }
                    throw new NoSuchElementException();
                } else if (mo38215b()) {
                    List list = this.f1866e;
                    int i = this.f1867f;
                    this.f1867f = i + 1;
                    Proxy proxy = (Proxy) list.get(i);
                    m1471a(proxy);
                    this.f1864c = proxy;
                } else {
                    throw new SocketException("No route to " + this.f1862a.f1397a.f1610b + "; exhausted proxy configurations: " + this.f1866e);
                }
            }
            if (mo38216c()) {
                List list2 = this.f1868g;
                int i2 = this.f1869h;
                this.f1869h = i2 + 1;
                this.f1865d = (InetSocketAddress) list2.get(i2);
                C3026ch chVar = new C3026ch(this.f1862a, this.f1864c, this.f1865d);
                if (!this.f1863b.mo38213c(chVar)) {
                    return chVar;
                }
                this.f1870i.add(chVar);
            } else {
                throw new SocketException("No route to " + this.f1862a.f1397a.f1610b + "; exhausted inet socket addresses: " + this.f1868g);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final boolean mo38215b() {
        return this.f1867f < this.f1866e.size();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final boolean mo38216c() {
        return this.f1869h < this.f1868g.size();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public final boolean mo38217d() {
        return !this.f1870i.isEmpty();
    }
}
