package p033rx.internal.operators;

import java.util.concurrent.TimeUnit;
import p033rx.Observable;
import p033rx.Scheduler;
import p033rx.Subscriber;

/* renamed from: rx.internal.operators.OperatorThrottleFirst */
public final class OperatorThrottleFirst<T> implements Observable.Operator<T, T> {
    final Scheduler scheduler;
    final long timeInMilliseconds;

    public OperatorThrottleFirst(long j, TimeUnit timeUnit, Scheduler scheduler2) {
        this.timeInMilliseconds = timeUnit.toMillis(j);
        this.scheduler = scheduler2;
    }

    public Subscriber<? super T> call(final Subscriber<? super T> subscriber) {
        return new Subscriber<T>(subscriber) {
            private long lastOnNext = -1;

            public void onStart() {
                request(Long.MAX_VALUE);
            }

            public void onNext(T t) {
                long now = OperatorThrottleFirst.this.scheduler.now();
                if (this.lastOnNext == -1 || now < this.lastOnNext || now - this.lastOnNext >= OperatorThrottleFirst.this.timeInMilliseconds) {
                    this.lastOnNext = now;
                    subscriber.onNext(t);
                }
            }

            public void onCompleted() {
                subscriber.onCompleted();
            }

            public void onError(Throwable th) {
                subscriber.onError(th);
            }
        };
    }
}
