package p033rx.internal.schedulers;

import java.util.concurrent.TimeUnit;
import p033rx.Scheduler;
import p033rx.Subscription;
import p033rx.functions.Action0;
import p033rx.internal.subscriptions.SequentialSubscription;

/* renamed from: rx.internal.schedulers.SchedulePeriodicHelper */
public final class SchedulePeriodicHelper {
    public static final long CLOCK_DRIFT_TOLERANCE_NANOS = TimeUnit.MINUTES.toNanos(Long.getLong("rx.scheduler.drift-tolerance", 15).longValue());

    /* renamed from: rx.internal.schedulers.SchedulePeriodicHelper$NowNanoSupplier */
    public interface NowNanoSupplier {
        long nowNanos();
    }

    private SchedulePeriodicHelper() {
        throw new IllegalStateException("No instances!");
    }

    public static Subscription schedulePeriodically(Scheduler.Worker worker, Action0 action0, long j, long j2, TimeUnit timeUnit, NowNanoSupplier nowNanoSupplier) {
        long j3 = j;
        TimeUnit timeUnit2 = timeUnit;
        final long nanos = timeUnit2.toNanos(j2);
        final long nowNanos = nowNanoSupplier != null ? nowNanoSupplier.nowNanos() : TimeUnit.MILLISECONDS.toNanos(worker.now());
        final long nanos2 = timeUnit2.toNanos(j3) + nowNanos;
        SequentialSubscription sequentialSubscription = new SequentialSubscription();
        SequentialSubscription sequentialSubscription2 = new SequentialSubscription(sequentialSubscription);
        final Action0 action02 = action0;
        final SequentialSubscription sequentialSubscription3 = sequentialSubscription2;
        final NowNanoSupplier nowNanoSupplier2 = nowNanoSupplier;
        SequentialSubscription sequentialSubscription4 = sequentialSubscription2;
        C42921 r15 = r3;
        final Scheduler.Worker worker2 = worker;
        C42921 r3 = new Action0() {
            long count;
            long lastNowNanos = nowNanos;
            long startInNanos = nanos2;

            public void call() {
                long j;
                action02.call();
                if (!sequentialSubscription3.isUnsubscribed()) {
                    long nowNanos = nowNanoSupplier2 != null ? nowNanoSupplier2.nowNanos() : TimeUnit.MILLISECONDS.toNanos(worker2.now());
                    if (SchedulePeriodicHelper.CLOCK_DRIFT_TOLERANCE_NANOS + nowNanos < this.lastNowNanos || nowNanos >= this.lastNowNanos + nanos + SchedulePeriodicHelper.CLOCK_DRIFT_TOLERANCE_NANOS) {
                        j = nanos + nowNanos;
                        long j2 = nanos;
                        long j3 = this.count + 1;
                        this.count = j3;
                        this.startInNanos = j - (j2 * j3);
                    } else {
                        long j4 = this.startInNanos;
                        long j5 = this.count + 1;
                        this.count = j5;
                        j = j4 + (j5 * nanos);
                    }
                    this.lastNowNanos = nowNanos;
                    sequentialSubscription3.replace(worker2.schedule(this, j - nowNanos, TimeUnit.NANOSECONDS));
                }
            }
        };
        sequentialSubscription.replace(worker.schedule(r15, j3, timeUnit2));
        return sequentialSubscription4;
    }
}