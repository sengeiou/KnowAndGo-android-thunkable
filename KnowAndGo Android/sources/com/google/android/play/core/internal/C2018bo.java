package com.google.android.play.core.internal;

/* renamed from: com.google.android.play.core.internal.bo */
public final class C2018bo extends RuntimeException {
    public C2018bo(String str) {
        super(str);
    }

    public C2018bo(Throwable th) {
        super("Failed to initialize FileStorage", th);
    }
}
