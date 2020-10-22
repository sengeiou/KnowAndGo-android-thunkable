package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Choreographer;

final class zztm implements Handler.Callback, Choreographer.FrameCallback {
    private static final zztm zzbpp = new zztm();
    private final Handler handler;
    public volatile long zzbpo;
    private final HandlerThread zzbpq = new HandlerThread("ChoreographerOwner:Handler");
    private Choreographer zzbpr;
    private int zzbps;

    public static zztm zzkn() {
        return zzbpp;
    }

    private zztm() {
        this.zzbpq.start();
        this.handler = new Handler(this.zzbpq.getLooper(), this);
        this.handler.sendEmptyMessage(0);
    }

    public final void zzko() {
        this.handler.sendEmptyMessage(1);
    }

    public final void zzkp() {
        this.handler.sendEmptyMessage(2);
    }

    public final void doFrame(long j) {
        this.zzbpo = j;
        this.zzbpr.postFrameCallbackDelayed(this, 500);
    }

    public final boolean handleMessage(Message message) {
        switch (message.what) {
            case 0:
                this.zzbpr = Choreographer.getInstance();
                return true;
            case 1:
                this.zzbps++;
                if (this.zzbps == 1) {
                    this.zzbpr.postFrameCallback(this);
                }
                return true;
            case 2:
                this.zzbps--;
                if (this.zzbps == 0) {
                    this.zzbpr.removeFrameCallback(this);
                    this.zzbpo = 0;
                }
                return true;
            default:
                return false;
        }
    }
}
