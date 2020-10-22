package com.uxcam.internals;

import android.os.Debug;
import android.os.Handler;
import android.os.Looper;
import android.util.Pair;

/* renamed from: com.uxcam.internals.ah */
public final class C2943ah extends Thread {

    /* renamed from: a */
    public static Pair f1260a = null;

    /* renamed from: d */
    private static final C2946aa f1261d = new C2946aa() {
        /* renamed from: a */
        public final void mo37984a(Pair pair, long j) {
        }
    };

    /* renamed from: b */
    public C2946aa f1262b = f1261d;

    /* renamed from: c */
    public boolean f1263c = true;

    /* renamed from: e */
    private final Handler f1264e = new Handler(Looper.getMainLooper());

    /* renamed from: f */
    private final int f1265f;

    /* renamed from: g */
    private final int f1266g;

    /* renamed from: h */
    private boolean f1267h = false;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public volatile long f1268i = 0;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public volatile boolean f1269j = false;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public long f1270k = 0;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public long f1271l = 0;

    /* renamed from: m */
    private final Runnable f1272m = new Runnable() {
        public final void run() {
            long unused = C2943ah.this.f1268i = 0;
            boolean unused2 = C2943ah.this.f1269j = false;
            long unused3 = C2943ah.this.f1271l = System.currentTimeMillis() - C2943ah.this.f1270k;
        }
    };

    /* renamed from: com.uxcam.internals.ah$aa */
    public interface C2946aa {
        /* renamed from: a */
        void mo37984a(Pair pair, long j);
    }

    public C2943ah(int i, int i2) {
        this.f1265f = i;
        this.f1266g = i2;
    }

    public final void run() {
        setName("|ANR-Ticker|");
        long j = (long) this.f1265f;
        while (!isInterrupted() && this.f1263c) {
            boolean z = this.f1268i == 0;
            this.f1268i += j;
            if (z) {
                this.f1270k = System.currentTimeMillis();
                this.f1264e.post(this.f1272m);
            }
            try {
                Thread.sleep(j);
                if (this.f1268i != 0 && !this.f1269j) {
                    this.f1269j = true;
                    f1260a = C2947ai.m1175a("main", true);
                    new StringBuilder("error found:: ").append(f1260a);
                }
                StringBuilder sb = new StringBuilder("tickerTimeDiffInMillis ");
                sb.append(this.f1271l);
                sb.append(" minANRTime ");
                sb.append(this.f1266g);
                if (((long) this.f1266g) < this.f1271l) {
                    if (this.f1267h || (!Debug.isDebuggerConnected() && !Debug.waitingForDebugger())) {
                        this.f1262b.mo37984a(f1260a, this.f1271l);
                        j = (long) this.f1265f;
                        this.f1269j = true;
                        this.f1271l = 0;
                    } else {
                        this.f1269j = true;
                    }
                }
            } catch (InterruptedException unused) {
                return;
            }
        }
    }
}
