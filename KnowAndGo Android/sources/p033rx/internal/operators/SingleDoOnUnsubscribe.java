package p033rx.internal.operators;

import p033rx.Single;
import p033rx.SingleSubscriber;
import p033rx.functions.Action0;
import p033rx.subscriptions.Subscriptions;

/* renamed from: rx.internal.operators.SingleDoOnUnsubscribe */
public final class SingleDoOnUnsubscribe<T> implements Single.OnSubscribe<T> {
    final Action0 onUnsubscribe;
    final Single.OnSubscribe<T> source;

    public SingleDoOnUnsubscribe(Single.OnSubscribe<T> onSubscribe, Action0 action0) {
        this.source = onSubscribe;
        this.onUnsubscribe = action0;
    }

    public void call(SingleSubscriber<? super T> singleSubscriber) {
        singleSubscriber.add(Subscriptions.create(this.onUnsubscribe));
        this.source.call(singleSubscriber);
    }
}
