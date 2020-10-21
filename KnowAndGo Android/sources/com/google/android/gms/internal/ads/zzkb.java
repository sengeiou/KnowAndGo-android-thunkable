package com.google.android.gms.internal.ads;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import java.io.IOException;

@SuppressLint({"HandlerLeak"})
final class zzkb extends Handler implements Runnable {
    private final zzkc zzaqk;
    private final zzka zzaql;
    private final int zzaqm = 0;
    private volatile Thread zzaqn;
    private final /* synthetic */ zzjz zzaqo;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzkb(zzjz zzjz, Looper looper, zzkc zzkc, zzka zzka, int i) {
        super(looper);
        this.zzaqo = zzjz;
        this.zzaqk = zzkc;
        this.zzaql = zzka;
    }

    public final void quit() {
        this.zzaqk.zzfp();
        if (this.zzaqn != null) {
            this.zzaqn.interrupt();
        }
    }

    public final void run() {
        try {
            this.zzaqn = Thread.currentThread();
            if (this.zzaqm > 0) {
                Thread.sleep((long) this.zzaqm);
            }
            if (!this.zzaqk.zzfq()) {
                this.zzaqk.zzfr();
            }
            sendEmptyMessage(0);
        } catch (IOException e) {
            obtainMessage(1, e).sendToTarget();
        } catch (InterruptedException unused) {
            zzkh.checkState(this.zzaqk.zzfq());
            sendEmptyMessage(0);
        } catch (Exception e2) {
            Log.e("LoadTask", "Unexpected exception loading stream", e2);
            obtainMessage(1, new zzkd(e2)).sendToTarget();
        } catch (Error e3) {
            Log.e("LoadTask", "Unexpected error loading stream", e3);
            obtainMessage(2, e3).sendToTarget();
            throw e3;
        }
    }

    public final void handleMessage(Message message) {
        if (message.what != 2) {
            boolean unused = this.zzaqo.zzaqj = false;
            zzkb unused2 = this.zzaqo.zzaqi = null;
            if (this.zzaqk.zzfq()) {
                this.zzaql.zzb(this.zzaqk);
                return;
            }
            switch (message.what) {
                case 0:
                    this.zzaql.zza(this.zzaqk);
                    return;
                case 1:
                    this.zzaql.zza(this.zzaqk, (IOException) message.obj);
                    return;
                default:
                    return;
            }
        } else {
            throw ((Error) message.obj);
        }
    }
}
