package p033rx;

import p033rx.internal.util.SubscriptionList;

/* renamed from: rx.SingleSubscriber */
public abstract class SingleSubscriber<T> implements Subscription {

    /* renamed from: cs */
    private final SubscriptionList f3049cs = new SubscriptionList();

    public abstract void onError(Throwable th);

    public abstract void onSuccess(T t);

    public final void add(Subscription subscription) {
        this.f3049cs.add(subscription);
    }

    public final void unsubscribe() {
        this.f3049cs.unsubscribe();
    }

    public final boolean isUnsubscribed() {
        return this.f3049cs.isUnsubscribed();
    }
}
