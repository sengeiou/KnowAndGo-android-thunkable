package p033rx.internal.operators;

import p033rx.Subscriber;
import p033rx.plugins.RxJavaHooks;

/* renamed from: rx.internal.operators.DeferredScalarSubscriberSafe */
public abstract class DeferredScalarSubscriberSafe<T, R> extends DeferredScalarSubscriber<T, R> {
    protected boolean done;

    public DeferredScalarSubscriberSafe(Subscriber<? super R> subscriber) {
        super(subscriber);
    }

    public void onError(Throwable th) {
        if (!this.done) {
            this.done = true;
            super.onError(th);
            return;
        }
        RxJavaHooks.onError(th);
    }

    public void onCompleted() {
        if (!this.done) {
            this.done = true;
            super.onCompleted();
        }
    }
}
