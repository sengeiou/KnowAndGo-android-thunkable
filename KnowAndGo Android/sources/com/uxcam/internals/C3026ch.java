package com.uxcam.internals;

import java.net.InetSocketAddress;
import java.net.Proxy;

/* renamed from: com.uxcam.internals.ch */
public final class C3026ch {

    /* renamed from: a */
    public final C2974be f1768a;

    /* renamed from: b */
    public final Proxy f1769b;

    /* renamed from: c */
    public final InetSocketAddress f1770c;

    public C3026ch(C2974be beVar, Proxy proxy, InetSocketAddress inetSocketAddress) {
        if (beVar == null) {
            throw new NullPointerException("address == null");
        } else if (proxy == null) {
            throw new NullPointerException("proxy == null");
        } else if (inetSocketAddress != null) {
            this.f1768a = beVar;
            this.f1769b = proxy;
            this.f1770c = inetSocketAddress;
        } else {
            throw new NullPointerException("inetSocketAddress == null");
        }
    }

    public final boolean equals(Object obj) {
        if (obj instanceof C3026ch) {
            C3026ch chVar = (C3026ch) obj;
            return this.f1768a.equals(chVar.f1768a) && this.f1769b.equals(chVar.f1769b) && this.f1770c.equals(chVar.f1770c);
        }
    }

    public final int hashCode() {
        return ((((this.f1768a.hashCode() + 527) * 31) + this.f1769b.hashCode()) * 31) + this.f1770c.hashCode();
    }
}
