package com.uxcam.internals;

import com.uxcam.internals.C3005bx;
import com.uxcam.internals.C3017cd;
import com.uxcam.internals.C3022cf;
import java.util.List;

/* renamed from: com.uxcam.internals.cy */
public final class C3049cy implements C3005bx {

    /* renamed from: a */
    private final C2992bq f1883a;

    public C3049cy(C2992bq bqVar) {
        this.f1883a = bqVar;
    }

    /* renamed from: a */
    public final C3022cf mo38068a(C3005bx.C3006aa aaVar) {
        boolean z;
        String str;
        C3017cd a = aaVar.mo38137a();
        C3017cd.C3018aa a2 = a.mo38165a();
        C3019ce ceVar = a.f1726d;
        if (ceVar != null) {
            C3007by a3 = ceVar.mo38104a();
            if (a3 != null) {
                a2.mo38172a("Content-Type", a3.toString());
            }
            long b = ceVar.mo38106b();
            if (b != -1) {
                a2.mo38172a("Content-Length", Long.toString(b));
                str = "Transfer-Encoding";
            } else {
                a2.mo38172a("Transfer-Encoding", "chunked");
                str = "Content-Length";
            }
            a2.mo38174b(str);
        }
        if (a.mo38166a("Host") == null) {
            a2.mo38172a("Host", C3030cl.m1420a(a.f1723a, false));
        }
        if (a.mo38166a("Connection") == null) {
            a2.mo38172a("Connection", "Keep-Alive");
        }
        if (a.mo38166a("Accept-Encoding") == null) {
            a2.mo38172a("Accept-Encoding", "gzip");
            z = true;
        } else {
            z = false;
        }
        List a4 = this.f1883a.mo38100a();
        if (!a4.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            int size = a4.size();
            for (int i = 0; i < size; i++) {
                if (i > 0) {
                    sb.append("; ");
                }
                C2991bp bpVar = (C2991bp) a4.get(i);
                sb.append(bpVar.f1579a);
                sb.append('=');
                sb.append(bpVar.f1580b);
            }
            a2.mo38172a("Cookie", sb.toString());
        }
        if (a.mo38166a("User-Agent") == null) {
            a2.mo38172a("User-Agent", "okhttp/3.5.0");
        }
        C3022cf a5 = aaVar.mo38138a(a2.mo38173a());
        C3054dc.m1503a(this.f1883a, a.f1723a, a5.f1745f);
        C3022cf.C3023aa b2 = a5.mo38177b();
        b2.f1753a = a;
        if (z && "gzip".equalsIgnoreCase(a5.mo38175a("Content-Encoding")) && C3054dc.m1505b(a5)) {
            C3136et etVar = new C3136et(a5.f1746g.mo38189c());
            C3000bv a6 = a5.f1745f.mo38111a().mo38118a("Content-Encoding").mo38118a("Content-Length").mo38120a();
            b2.mo38182a(a6);
            b2.f1759g = new C3057df(a6, C3138ev.m1863a((C3148fc) etVar));
        }
        return b2.mo38185a();
    }
}
