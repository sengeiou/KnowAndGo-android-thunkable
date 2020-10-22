package com.uxcam.internals;

import android.support.p002v4.media.session.PlaybackStateCompat;

/* renamed from: com.uxcam.internals.ez */
final class C3145ez {

    /* renamed from: a */
    static C3144ey f2194a;

    /* renamed from: b */
    static long f2195b;

    private C3145ez() {
    }

    /* renamed from: a */
    static C3144ey m1913a() {
        synchronized (C3145ez.class) {
            if (f2194a == null) {
                return new C3144ey();
            }
            C3144ey eyVar = f2194a;
            f2194a = eyVar.f2192f;
            eyVar.f2192f = null;
            f2195b -= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
            return eyVar;
        }
    }

    /* renamed from: a */
    static void m1914a(C3144ey eyVar) {
        if (eyVar.f2192f != null || eyVar.f2193g != null) {
            throw new IllegalArgumentException();
        } else if (!eyVar.f2190d) {
            synchronized (C3145ez.class) {
                if (f2195b + PlaybackStateCompat.ACTION_PLAY_FROM_URI <= PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) {
                    f2195b += PlaybackStateCompat.ACTION_PLAY_FROM_URI;
                    eyVar.f2192f = f2194a;
                    eyVar.f2189c = 0;
                    eyVar.f2188b = 0;
                    f2194a = eyVar;
                }
            }
        }
    }
}
