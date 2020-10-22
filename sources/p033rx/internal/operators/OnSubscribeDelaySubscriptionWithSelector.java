package p033rx.internal.operators;

import p033rx.Observable;
import p033rx.Observer;
import p033rx.Subscriber;
import p033rx.exceptions.Exceptions;
import p033rx.functions.Func0;
import p033rx.observers.Subscribers;

/* renamed from: rx.internal.operators.OnSubscribeDelaySubscriptionWithSelector */
public final class OnSubscribeDelaySubscriptionWithSelector<T, U> implements Observable.OnSubscribe<T> {
    final Observable<? extends T> source;
    final Func0<? extends Observable<U>> subscriptionDelay;

    public OnSubscribeDelaySubscriptionWithSelector(Observable<? extends T> observable, Func0<? extends Observable<U>> func0) {
        this.source = observable;
        this.subscriptionDelay = func0;
    }

    public void call(final Subscriber<? super T> subscriber) {
        try {
            ((Observable) this.subscriptionDelay.call()).take(1).unsafeSubscribe(new Subscriber<U>() {
                public void onNext(U u) {
                }

                public void onCompleted() {
                    OnSubscribeDelaySubscriptionWithSelector.this.source.unsafeSubscribe(Subscribers.wrap(subscriber));
                }

                public void onError(Throwable th) {
                    subscriber.onError(th);
                }
            });
        } catch (Throwable th) {
            Exceptions.throwOrReport(th, (Observer<?>) subscriber);
        }
    }
}
