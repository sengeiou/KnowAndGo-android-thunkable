package com.google.android.play.core.splitinstall;

import android.content.Context;
import com.google.android.play.core.splitcompat.C2096p;

/* renamed from: com.google.android.play.core.splitinstall.k */
public final class C2134k {

    /* renamed from: a */
    private static C2136m f927a;

    private C2134k() {
    }

    /* renamed from: a */
    public static synchronized C2136m m989a(Context context) {
        C2136m mVar;
        synchronized (C2134k.class) {
            if (f927a == null) {
                C2125b bVar = new C2125b((byte[]) null);
                bVar.mo33756a(new C2160y(C2096p.m907a(context)));
                f927a = bVar.mo33755a();
            }
            mVar = f927a;
        }
        return mVar;
    }
}
