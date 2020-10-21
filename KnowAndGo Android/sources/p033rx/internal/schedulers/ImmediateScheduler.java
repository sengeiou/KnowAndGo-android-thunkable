package p033rx.internal.schedulers;

import java.util.concurrent.TimeUnit;
import p033rx.Scheduler;
import p033rx.Subscription;
import p033rx.functions.Action0;
import p033rx.subscriptions.BooleanSubscription;
import p033rx.subscriptions.Subscriptions;

/* renamed from: rx.internal.schedulers.ImmediateScheduler */
public final class ImmediateScheduler extends Scheduler {
    public static final ImmediateScheduler INSTANCE = new ImmediateScheduler();

    private ImmediateScheduler() {
    }

    public Scheduler.Worker createWorker() {
        return new InnerImmediateScheduler();
    }

    /* renamed from: rx.internal.schedulers.ImmediateScheduler$InnerImmediateScheduler */
    final class InnerImmediateScheduler extends Scheduler.Worker implements Subscription {
        final BooleanSubscription innerSubscription = new BooleanSubscription();

        InnerImmediateScheduler() {
        }

        public Subscription schedule(Action0 action0, long j, TimeUnit timeUnit) {
            return schedule(new SleepingAction(action0, this, ImmediateScheduler.this.now() + timeUnit.toMillis(j)));
        }

        public Subscription schedule(Action0 action0) {
            action0.call();
            return Subscriptions.unsubscribed();
        }

        public void unsubscribe() {
            this.innerSubscription.unsubscribe();
        }

        public boolean isUnsubscribed() {
            return this.innerSubscription.isUnsubscribed();
        }
    }
}
