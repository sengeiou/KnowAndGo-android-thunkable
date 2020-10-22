package com.uxcam.internals;

import java.net.UnknownServiceException;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;

/* renamed from: com.uxcam.internals.cs */
public final class C3042cs {

    /* renamed from: a */
    boolean f1842a;

    /* renamed from: b */
    boolean f1843b;

    /* renamed from: c */
    private final List f1844c;

    /* renamed from: d */
    private int f1845d = 0;

    public C3042cs(List list) {
        this.f1844c = list;
    }

    /* renamed from: b */
    private boolean m1457b(SSLSocket sSLSocket) {
        for (int i = this.f1845d; i < this.f1844c.size(); i++) {
            if (((C2989bo) this.f1844c.get(i)).mo38088a(sSLSocket)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public final C2989bo mo38205a(SSLSocket sSLSocket) {
        C2989bo boVar;
        int i = this.f1845d;
        int size = this.f1844c.size();
        while (true) {
            if (i >= size) {
                boVar = null;
                break;
            }
            boVar = (C2989bo) this.f1844c.get(i);
            if (boVar.mo38088a(sSLSocket)) {
                this.f1845d = i + 1;
                break;
            }
            i++;
        }
        if (boVar != null) {
            this.f1842a = m1457b(sSLSocket);
            C3028cj.f1778a.mo38149a(boVar, sSLSocket, this.f1843b);
            return boVar;
        }
        throw new UnknownServiceException("Unable to find acceptable protocols. isFallback=" + this.f1843b + ", modes=" + this.f1844c + ", supported protocols=" + Arrays.toString(sSLSocket.getEnabledProtocols()));
    }
}
