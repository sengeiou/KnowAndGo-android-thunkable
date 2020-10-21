package com.google.android.gms.internal.ads;

import java.util.Random;

@zzard
public final class zzyu extends zzzz {
    private final Object lock = new Object();
    private final Random zzcil = new Random();
    private long zzcin;

    public zzyu() {
        zzpi();
    }

    public final void zzpi() {
        synchronized (this.lock) {
            int i = 3;
            long j = 0;
            while (true) {
                i--;
                if (i <= 0) {
                    break;
                }
                try {
                    j = ((long) this.zzcil.nextInt()) + 2147483648L;
                    if (j != this.zzcin && j != 0) {
                        break;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            this.zzcin = j;
        }
    }

    public final long getValue() {
        return this.zzcin;
    }
}
