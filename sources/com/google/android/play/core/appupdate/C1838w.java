package com.google.android.play.core.appupdate;

import android.content.Context;
import com.google.android.play.core.splitcompat.C2096p;

/* renamed from: com.google.android.play.core.appupdate.w */
public final /* synthetic */ class C1838w {

    /* renamed from: a */
    private static C1840y f285a;

    /* renamed from: a */
    static synchronized C1840y m250a(Context context) {
        C1840y yVar;
        synchronized (C1838w.class) {
            if (f285a == null) {
                C1839x xVar = new C1839x((byte[]) null);
                xVar.mo33304a(new C1822g(C2096p.m907a(context)));
                f285a = xVar.mo33303a();
            }
            yVar = f285a;
        }
        return yVar;
    }
}
