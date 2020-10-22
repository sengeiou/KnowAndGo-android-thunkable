package com.google.android.gms.internal.ads;

import android.os.HandlerThread;
import android.os.Process;

public final class zzko extends HandlerThread {
    private final int priority = -16;

    public zzko(String str, int i) {
        super(str);
    }

    public final void run() {
        Process.setThreadPriority(this.priority);
        super.run();
    }
}
