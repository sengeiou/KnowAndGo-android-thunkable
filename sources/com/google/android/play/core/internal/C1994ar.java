package com.google.android.play.core.internal;

import android.content.Intent;
import android.util.Log;
import com.google.android.play.core.splitinstall.C2127d;
import java.util.List;

/* renamed from: com.google.android.play.core.internal.ar */
final class C1994ar implements Runnable {

    /* renamed from: a */
    final /* synthetic */ List f750a;

    /* renamed from: b */
    final /* synthetic */ C2127d f751b;

    /* renamed from: c */
    final /* synthetic */ C1995as f752c;

    C1994ar(C1995as asVar, List list, C2127d dVar) {
        this.f752c = asVar;
        this.f750a = list;
        this.f751b = dVar;
    }

    public final void run() {
        try {
            if (this.f752c.f755c.mo33568a((List<Intent>) this.f750a)) {
                C1995as.m620a(this.f752c, this.f751b);
            } else {
                C1995as.m621a(this.f752c, this.f750a, this.f751b);
            }
        } catch (Exception e) {
            Log.e("SplitCompat", "Error checking verified files.", e);
            this.f751b.mo33760a(-11);
        }
    }
}
