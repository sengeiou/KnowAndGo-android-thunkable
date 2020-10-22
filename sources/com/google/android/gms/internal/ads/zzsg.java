package com.google.android.gms.internal.ads;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import com.google.android.gms.internal.ads.zzsh;
import java.io.IOException;

@SuppressLint({"HandlerLeak"})
final class zzsg<T extends zzsh> extends Handler implements Runnable {
    private volatile boolean zzacf;
    private volatile Thread zzaqn;
    private final T zzbmt;
    private final zzsf<T> zzbmu;
    public final int zzbmv;
    private final long zzbmw;
    private IOException zzbmx;
    private int zzbmy;
    private final /* synthetic */ zzse zzbmz;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzsg(zzse zzse, Looper looper, T t, zzsf<T> zzsf, int i, long j) {
        super(looper);
        this.zzbmz = zzse;
        this.zzbmt = t;
        this.zzbmu = zzsf;
        this.zzbmv = i;
        this.zzbmw = j;
    }

    public final void zzbm(int i) throws IOException {
        if (this.zzbmx != null && this.zzbmy > i) {
            throw this.zzbmx;
        }
    }

    public final void zzeq(long j) {
        zzsk.checkState(this.zzbmz.zzbmr == null);
        zzsg unused = this.zzbmz.zzbmr = this;
        if (j > 0) {
            sendEmptyMessageDelayed(0, j);
        } else {
            execute();
        }
    }

    public final void zzl(boolean z) {
        this.zzacf = z;
        this.zzbmx = null;
        if (hasMessages(0)) {
            removeMessages(0);
            if (!z) {
                sendEmptyMessage(1);
            }
        } else {
            this.zzbmt.zzfp();
            if (this.zzaqn != null) {
                this.zzaqn.interrupt();
            }
        }
        if (z) {
            finish();
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.zzbmu.zza(this.zzbmt, elapsedRealtime, elapsedRealtime - this.zzbmw, true);
        }
    }

    public final void run() {
        try {
            this.zzaqn = Thread.currentThread();
            if (!this.zzbmt.zzfq()) {
                String valueOf = String.valueOf(this.zzbmt.getClass().getSimpleName());
                zzsx.beginSection(valueOf.length() != 0 ? "load:".concat(valueOf) : new String("load:"));
                this.zzbmt.zzfr();
                zzsx.endSection();
            }
            if (!this.zzacf) {
                sendEmptyMessage(2);
            }
        } catch (IOException e) {
            if (!this.zzacf) {
                obtainMessage(3, e).sendToTarget();
            }
        } catch (InterruptedException unused) {
            zzsk.checkState(this.zzbmt.zzfq());
            if (!this.zzacf) {
                sendEmptyMessage(2);
            }
        } catch (Exception e2) {
            Log.e("LoadTask", "Unexpected exception loading stream", e2);
            if (!this.zzacf) {
                obtainMessage(3, new zzsi(e2)).sendToTarget();
            }
        } catch (OutOfMemoryError e3) {
            Log.e("LoadTask", "OutOfMemory error loading stream", e3);
            if (!this.zzacf) {
                obtainMessage(3, new zzsi(e3)).sendToTarget();
            }
        } catch (Error e4) {
            Log.e("LoadTask", "Unexpected error loading stream", e4);
            if (!this.zzacf) {
                obtainMessage(4, e4).sendToTarget();
            }
            throw e4;
        } catch (Throwable th) {
            zzsx.endSection();
            throw th;
        }
    }

    public final void handleMessage(Message message) {
        int i;
        if (!this.zzacf) {
            if (message.what == 0) {
                execute();
            } else if (message.what != 4) {
                finish();
                long elapsedRealtime = SystemClock.elapsedRealtime();
                long j = elapsedRealtime - this.zzbmw;
                if (this.zzbmt.zzfq()) {
                    this.zzbmu.zza(this.zzbmt, elapsedRealtime, j, false);
                    return;
                }
                switch (message.what) {
                    case 1:
                        this.zzbmu.zza(this.zzbmt, elapsedRealtime, j, false);
                        return;
                    case 2:
                        this.zzbmu.zza(this.zzbmt, elapsedRealtime, j);
                        return;
                    case 3:
                        this.zzbmx = (IOException) message.obj;
                        int zza = this.zzbmu.zza(this.zzbmt, elapsedRealtime, j, this.zzbmx);
                        if (zza == 3) {
                            IOException unused = this.zzbmz.zzbms = this.zzbmx;
                            return;
                        } else if (zza != 2) {
                            if (zza == 1) {
                                i = 1;
                            } else {
                                i = this.zzbmy + 1;
                            }
                            this.zzbmy = i;
                            zzeq((long) Math.min((this.zzbmy - 1) * 1000, 5000));
                            return;
                        } else {
                            return;
                        }
                    default:
                        return;
                }
            } else {
                throw ((Error) message.obj);
            }
        }
    }

    private final void execute() {
        this.zzbmx = null;
        this.zzbmz.zzaqh.execute(this.zzbmz.zzbmr);
    }

    private final void finish() {
        zzsg unused = this.zzbmz.zzbmr = null;
    }
}
