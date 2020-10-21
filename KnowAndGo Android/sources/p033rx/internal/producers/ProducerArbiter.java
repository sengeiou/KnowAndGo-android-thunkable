package p033rx.internal.producers;

import p033rx.Producer;

/* renamed from: rx.internal.producers.ProducerArbiter */
public final class ProducerArbiter implements Producer {
    static final Producer NULL_PRODUCER = new Producer() {
        public void request(long j) {
        }
    };
    Producer currentProducer;
    boolean emitting;
    long missedProduced;
    Producer missedProducer;
    long missedRequested;
    long requested;

    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        r2 = r5.requested + r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0020, code lost:
        if (r2 >= 0) goto L_0x0027;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0022, code lost:
        r2 = Long.MAX_VALUE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0027, code lost:
        r5.requested = r2;
        r0 = r5.currentProducer;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x002b, code lost:
        if (r0 == null) goto L_0x0030;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x002d, code lost:
        r0.request(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0030, code lost:
        emitLoop();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0033, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0034, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0035, code lost:
        monitor-enter(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
        r5.emitting = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x003a, code lost:
        throw r6;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void request(long r6) {
        /*
            r5 = this;
            r0 = 0
            int r2 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            if (r2 < 0) goto L_0x0041
            if (r2 != 0) goto L_0x0009
            return
        L_0x0009:
            monitor-enter(r5)
            boolean r2 = r5.emitting     // Catch:{ all -> 0x003e }
            if (r2 == 0) goto L_0x0016
            long r0 = r5.missedRequested     // Catch:{ all -> 0x003e }
            r2 = 0
            long r0 = r0 + r6
            r5.missedRequested = r0     // Catch:{ all -> 0x003e }
            monitor-exit(r5)     // Catch:{ all -> 0x003e }
            return
        L_0x0016:
            r2 = 1
            r5.emitting = r2     // Catch:{ all -> 0x003e }
            monitor-exit(r5)     // Catch:{ all -> 0x003e }
            long r2 = r5.requested     // Catch:{ all -> 0x0034 }
            r4 = 0
            long r2 = r2 + r6
            int r0 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r0 >= 0) goto L_0x0027
            r2 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
        L_0x0027:
            r5.requested = r2     // Catch:{ all -> 0x0034 }
            rx.Producer r0 = r5.currentProducer     // Catch:{ all -> 0x0034 }
            if (r0 == 0) goto L_0x0030
            r0.request(r6)     // Catch:{ all -> 0x0034 }
        L_0x0030:
            r5.emitLoop()     // Catch:{ all -> 0x0034 }
            return
        L_0x0034:
            r6 = move-exception
            monitor-enter(r5)
            r7 = 0
            r5.emitting = r7     // Catch:{ all -> 0x003b }
            monitor-exit(r5)     // Catch:{ all -> 0x003b }
            throw r6
        L_0x003b:
            r6 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x003b }
            throw r6
        L_0x003e:
            r6 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x003e }
            throw r6
        L_0x0041:
            java.lang.IllegalArgumentException r6 = new java.lang.IllegalArgumentException
            java.lang.String r7 = "n >= 0 required"
            r6.<init>(r7)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: p033rx.internal.producers.ProducerArbiter.request(long):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
        r2 = r6.requested;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0020, code lost:
        if (r2 == Long.MAX_VALUE) goto L_0x0032;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0022, code lost:
        r2 = r2 - r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0025, code lost:
        if (r2 < 0) goto L_0x002a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0027, code lost:
        r6.requested = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0031, code lost:
        throw new java.lang.IllegalStateException("more items arrived than were requested");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0032, code lost:
        emitLoop();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0035, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0036, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0037, code lost:
        monitor-enter(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        r6.emitting = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x003c, code lost:
        throw r7;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void produced(long r7) {
        /*
            r6 = this;
            r0 = 0
            int r2 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
            if (r2 <= 0) goto L_0x0043
            monitor-enter(r6)
            boolean r2 = r6.emitting     // Catch:{ all -> 0x0040 }
            if (r2 == 0) goto L_0x0013
            long r0 = r6.missedProduced     // Catch:{ all -> 0x0040 }
            r2 = 0
            long r0 = r0 + r7
            r6.missedProduced = r0     // Catch:{ all -> 0x0040 }
            monitor-exit(r6)     // Catch:{ all -> 0x0040 }
            return
        L_0x0013:
            r2 = 1
            r6.emitting = r2     // Catch:{ all -> 0x0040 }
            monitor-exit(r6)     // Catch:{ all -> 0x0040 }
            long r2 = r6.requested     // Catch:{ all -> 0x0036 }
            r4 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            int r4 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r4 == 0) goto L_0x0032
            long r2 = r2 - r7
            int r7 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r7 < 0) goto L_0x002a
            r6.requested = r2     // Catch:{ all -> 0x0036 }
            goto L_0x0032
        L_0x002a:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0036 }
            java.lang.String r8 = "more items arrived than were requested"
            r7.<init>(r8)     // Catch:{ all -> 0x0036 }
            throw r7     // Catch:{ all -> 0x0036 }
        L_0x0032:
            r6.emitLoop()     // Catch:{ all -> 0x0036 }
            return
        L_0x0036:
            r7 = move-exception
            monitor-enter(r6)
            r8 = 0
            r6.emitting = r8     // Catch:{ all -> 0x003d }
            monitor-exit(r6)     // Catch:{ all -> 0x003d }
            throw r7
        L_0x003d:
            r7 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x003d }
            throw r7
        L_0x0040:
            r7 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x0040 }
            throw r7
        L_0x0043:
            java.lang.IllegalArgumentException r7 = new java.lang.IllegalArgumentException
            java.lang.String r8 = "n > 0 required"
            r7.<init>(r8)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: p033rx.internal.producers.ProducerArbiter.produced(long):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
        r2.currentProducer = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0013, code lost:
        if (r3 == null) goto L_0x001a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0015, code lost:
        r3.request(r2.requested);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x001a, code lost:
        emitLoop();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x001d, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x001e, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x001f, code lost:
        monitor-enter(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        r2.emitting = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0024, code lost:
        throw r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setProducer(p033rx.Producer r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r0 = r2.emitting     // Catch:{ all -> 0x0028 }
            if (r0 == 0) goto L_0x000d
            if (r3 != 0) goto L_0x0009
            rx.Producer r3 = NULL_PRODUCER     // Catch:{ all -> 0x0028 }
        L_0x0009:
            r2.missedProducer = r3     // Catch:{ all -> 0x0028 }
            monitor-exit(r2)     // Catch:{ all -> 0x0028 }
            return
        L_0x000d:
            r0 = 1
            r2.emitting = r0     // Catch:{ all -> 0x0028 }
            monitor-exit(r2)     // Catch:{ all -> 0x0028 }
            r2.currentProducer = r3     // Catch:{ all -> 0x001e }
            if (r3 == 0) goto L_0x001a
            long r0 = r2.requested     // Catch:{ all -> 0x001e }
            r3.request(r0)     // Catch:{ all -> 0x001e }
        L_0x001a:
            r2.emitLoop()     // Catch:{ all -> 0x001e }
            return
        L_0x001e:
            r3 = move-exception
            monitor-enter(r2)
            r0 = 0
            r2.emitting = r0     // Catch:{ all -> 0x0025 }
            monitor-exit(r2)     // Catch:{ all -> 0x0025 }
            throw r3
        L_0x0025:
            r3 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0025 }
            throw r3
        L_0x0028:
            r3 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0028 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: p033rx.internal.producers.ProducerArbiter.setProducer(rx.Producer):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0020, code lost:
        r9 = r14.requested;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0029, code lost:
        if (r9 == Long.MAX_VALUE) goto L_0x0049;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002b, code lost:
        r9 = r9 + r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002e, code lost:
        if (r9 < 0) goto L_0x0046;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0032, code lost:
        if (r9 != Long.MAX_VALUE) goto L_0x0035;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0035, code lost:
        r9 = r9 - r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0039, code lost:
        if (r9 < 0) goto L_0x003e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x003b, code lost:
        r14.requested = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0045, code lost:
        throw new java.lang.IllegalStateException("more produced than requested");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0046, code lost:
        r14.requested = Long.MAX_VALUE;
        r9 = Long.MAX_VALUE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0049, code lost:
        if (r4 == null) goto L_0x0058;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x004d, code lost:
        if (r4 != NULL_PRODUCER) goto L_0x0052;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x004f, code lost:
        r14.currentProducer = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0052, code lost:
        r14.currentProducer = r4;
        r4.request(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0058, code lost:
        r2 = r14.currentProducer;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x005a, code lost:
        if (r2 == null) goto L_0x0000;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x005c, code lost:
        if (r7 == 0) goto L_0x0000;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x005e, code lost:
        r2.request(r0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void emitLoop() {
        /*
            r14 = this;
        L_0x0000:
            monitor-enter(r14)
            long r0 = r14.missedRequested     // Catch:{ all -> 0x0062 }
            long r2 = r14.missedProduced     // Catch:{ all -> 0x0062 }
            rx.Producer r4 = r14.missedProducer     // Catch:{ all -> 0x0062 }
            r5 = 0
            int r7 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r7 != 0) goto L_0x0018
            int r8 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r8 != 0) goto L_0x0018
            if (r4 != 0) goto L_0x0018
            r0 = 0
            r14.emitting = r0     // Catch:{ all -> 0x0062 }
            monitor-exit(r14)     // Catch:{ all -> 0x0062 }
            return
        L_0x0018:
            r14.missedRequested = r5     // Catch:{ all -> 0x0062 }
            r14.missedProduced = r5     // Catch:{ all -> 0x0062 }
            r8 = 0
            r14.missedProducer = r8     // Catch:{ all -> 0x0062 }
            monitor-exit(r14)     // Catch:{ all -> 0x0062 }
            long r9 = r14.requested
            r11 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            int r13 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r13 == 0) goto L_0x0049
            long r9 = r9 + r0
            int r13 = (r9 > r5 ? 1 : (r9 == r5 ? 0 : -1))
            if (r13 < 0) goto L_0x0046
            int r13 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r13 != 0) goto L_0x0035
            goto L_0x0046
        L_0x0035:
            r11 = 0
            long r9 = r9 - r2
            int r2 = (r9 > r5 ? 1 : (r9 == r5 ? 0 : -1))
            if (r2 < 0) goto L_0x003e
            r14.requested = r9
            goto L_0x0049
        L_0x003e:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "more produced than requested"
            r0.<init>(r1)
            throw r0
        L_0x0046:
            r14.requested = r11
            r9 = r11
        L_0x0049:
            if (r4 == 0) goto L_0x0058
            rx.Producer r0 = NULL_PRODUCER
            if (r4 != r0) goto L_0x0052
            r14.currentProducer = r8
            goto L_0x0000
        L_0x0052:
            r14.currentProducer = r4
            r4.request(r9)
            goto L_0x0000
        L_0x0058:
            rx.Producer r2 = r14.currentProducer
            if (r2 == 0) goto L_0x0000
            if (r7 == 0) goto L_0x0000
            r2.request(r0)
            goto L_0x0000
        L_0x0062:
            r0 = move-exception
            monitor-exit(r14)     // Catch:{ all -> 0x0062 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p033rx.internal.producers.ProducerArbiter.emitLoop():void");
    }
}
