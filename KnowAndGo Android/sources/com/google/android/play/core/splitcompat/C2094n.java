package com.google.android.play.core.splitcompat;

import android.util.Log;

/* renamed from: com.google.android.play.core.splitcompat.n */
final class C2094n implements Runnable {

    /* renamed from: a */
    final /* synthetic */ SplitCompat f847a;

    C2094n(SplitCompat splitCompat) {
        this.f847a = splitCompat;
    }

    public final void run() {
        try {
            this.f847a.f822b.mo33685a();
        } catch (Exception e) {
            Log.e("SplitCompat", "Failed to cleanup splitcompat storage", e);
        }
    }
}
