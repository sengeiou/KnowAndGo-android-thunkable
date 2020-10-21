package com.google.android.gms.internal.ads;

public final class zzcji {
    private int responseCode = 0;
    private long zzfyl = 0;
    private long zzfym = 0;
    private long zzfyn = 0;
    private final Object zzfyo = new Object();
    private final Object zzfyp = new Object();
    private final Object zzfyq = new Object();
    private final Object zzfyr = new Object();

    public final void zzdo(int i) {
        synchronized (this.zzfyo) {
            this.responseCode = i;
        }
    }

    public final int getResponseCode() {
        int i;
        synchronized (this.zzfyo) {
            i = this.responseCode;
        }
        return i;
    }

    public final void zzeu(long j) {
        synchronized (this.zzfyp) {
            this.zzfyl = j;
        }
    }

    public final long zzakl() {
        long j;
        synchronized (this.zzfyp) {
            j = this.zzfyl;
        }
        return j;
    }

    public final synchronized void zzfh(long j) {
        synchronized (this.zzfyq) {
            this.zzfym = j;
        }
    }

    public final synchronized long zzakm() {
        long j;
        synchronized (this.zzfyq) {
            j = this.zzfym;
        }
        return j;
    }

    public final synchronized void zzev(long j) {
        synchronized (this.zzfyr) {
            this.zzfyn = j;
        }
    }

    public final synchronized long zzakn() {
        long j;
        synchronized (this.zzfyr) {
            j = this.zzfyn;
        }
        return j;
    }
}
