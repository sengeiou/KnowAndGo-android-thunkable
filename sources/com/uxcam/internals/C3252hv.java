package com.uxcam.internals;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* renamed from: com.uxcam.internals.hv */
public class C3252hv extends C3273in {
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static Set f2569c;

    /* renamed from: e */
    private String f2570e;

    /* renamed from: f */
    private short f2571f;

    /* renamed from: g */
    private short f2572g;

    /* renamed from: h */
    private short f2573h;

    /* renamed from: i */
    private String f2574i;

    /* renamed from: j */
    private int f2575j;

    /* renamed from: k */
    private short f2576k;

    /* renamed from: l */
    private short f2577l;

    /* renamed from: m */
    private int f2578m;

    /* renamed from: n */
    private String f2579n;

    /* renamed from: o */
    private int f2580o;

    /* renamed from: p */
    private int f2581p;

    /* renamed from: q */
    private String f2582q;

    /* renamed from: r */
    private String f2583r;

    /* renamed from: s */
    private short f2584s;

    /* renamed from: t */
    private short f2585t;

    /* renamed from: u */
    private int f2586u;

    /* renamed from: v */
    private short f2587v;

    /* renamed from: w */
    private List f2588w;

    /* renamed from: com.uxcam.internals.hv$aa */
    public static class C3253aa {

        /* renamed from: a */
        short f2589a;

        /* renamed from: b */
        int f2590b;

        /* renamed from: c */
        byte[] f2591c;

        public final String toString() {
            try {
                return new String(this.f2591c, 0, this.f2590b, C3252hv.f2569c.contains(Short.valueOf(this.f2589a)) ? "UTF-16" : "UTF-8");
            } catch (UnsupportedEncodingException unused) {
                return null;
            }
        }
    }

    static {
        HashSet hashSet = new HashSet();
        f2569c = hashSet;
        hashSet.add(14);
        f2569c.add(15);
    }

    public C3252hv() {
        super(new C3277ir("alis", 0));
    }

    /* renamed from: a */
    public static String m2236a() {
        return "alis";
    }

    /* renamed from: c */
    private C3253aa m2238c() {
        for (C3253aa aaVar : this.f2588w) {
            if (aaVar.f2589a == 18) {
                return aaVar;
            }
        }
        return null;
    }

    /* renamed from: a */
    public final void mo38539a(StringBuilder sb) {
        String str;
        String sb2;
        super.mo38539a(sb);
        sb.append(": ");
        boolean z = true;
        if ((this.f2649b & 1) == 0) {
            z = false;
        }
        if (z) {
            sb2 = "'self'";
        } else {
            StringBuilder sb3 = new StringBuilder("'");
            C3253aa c = m2238c();
            if (c == null) {
                str = null;
            } else {
                str = "/" + c.toString();
            }
            sb3.append(str);
            sb3.append("'");
            sb2 = sb3.toString();
        }
        sb.append(sb2);
    }

    /* renamed from: a */
    public final void mo38506a(ByteBuffer byteBuffer) {
        super.mo38506a(byteBuffer);
        if ((this.f2649b & 1) == 0) {
            byteBuffer.put(C3227gx.m2197a(this.f2570e), 0, 4);
            byteBuffer.putShort(this.f2571f);
            byteBuffer.putShort(this.f2572g);
            byteBuffer.putShort(this.f2573h);
            C3229gz.m2200a(byteBuffer, this.f2574i, 27);
            byteBuffer.putInt(this.f2575j);
            byteBuffer.putShort(this.f2576k);
            byteBuffer.putShort(this.f2577l);
            byteBuffer.putInt(this.f2578m);
            C3229gz.m2200a(byteBuffer, this.f2579n, 63);
            byteBuffer.putInt(this.f2580o);
            byteBuffer.putInt(this.f2581p);
            byteBuffer.put(C3227gx.m2197a(this.f2582q), 0, 4);
            byteBuffer.put(C3227gx.m2197a(this.f2583r), 0, 4);
            byteBuffer.putShort(this.f2584s);
            byteBuffer.putShort(this.f2585t);
            byteBuffer.putInt(this.f2586u);
            byteBuffer.putShort(this.f2587v);
            byteBuffer.put(new byte[10]);
            for (C3253aa aaVar : this.f2588w) {
                byteBuffer.putShort(aaVar.f2589a);
                byteBuffer.putShort((short) aaVar.f2590b);
                byteBuffer.put(aaVar.f2591c);
            }
            byteBuffer.putShort(-1);
            byteBuffer.putShort(0);
        }
    }
}
