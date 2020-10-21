package p033rx.subscriptions;

import java.util.concurrent.atomic.AtomicReference;
import p033rx.Subscription;
import p033rx.functions.Action0;

/* renamed from: rx.subscriptions.BooleanSubscription */
public final class BooleanSubscription implements Subscription {
    static final Action0 EMPTY_ACTION = new Action0() {
        public void call() {
        }
    };
    final AtomicReference<Action0> actionRef;

    public BooleanSubscription() {
        this.actionRef = new AtomicReference<>();
    }

    private BooleanSubscription(Action0 action0) {
        this.actionRef = new AtomicReference<>(action0);
    }

    public static BooleanSubscription create() {
        return new BooleanSubscription();
    }

    public static BooleanSubscription create(Action0 action0) {
        return new BooleanSubscription(action0);
    }

    public boolean isUnsubscribed() {
        return this.actionRef.get() == EMPTY_ACTION;
    }

    public void unsubscribe() {
        Action0 andSet;
        if (this.actionRef.get() != EMPTY_ACTION && (andSet = this.actionRef.getAndSet(EMPTY_ACTION)) != null && andSet != EMPTY_ACTION) {
            andSet.call();
        }
    }
}
