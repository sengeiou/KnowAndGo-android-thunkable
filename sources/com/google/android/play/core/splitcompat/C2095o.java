package com.google.android.play.core.splitcompat;

import android.util.Log;
import java.util.Set;

/* renamed from: com.google.android.play.core.splitcompat.o */
final class C2095o implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Set f848a;

    /* renamed from: b */
    final /* synthetic */ SplitCompat f849b;

    C2095o(SplitCompat splitCompat, Set set) {
        this.f849b = splitCompat;
        this.f848a = set;
    }

    public final void run() {
        try {
            for (String f : this.f848a) {
                this.f849b.f822b.mo33695f(f);
            }
        } catch (Exception e) {
            Log.e("SplitCompat", "Failed to remove from splitcompat storage split that is already installed", e);
        }
    }
}
