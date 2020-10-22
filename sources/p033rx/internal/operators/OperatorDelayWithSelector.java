package p033rx.internal.operators;

import p033rx.Observable;
import p033rx.Observer;
import p033rx.Subscriber;
import p033rx.exceptions.Exceptions;
import p033rx.functions.Func1;
import p033rx.observers.SerializedSubscriber;
import p033rx.observers.Subscribers;
import p033rx.subjects.PublishSubject;

/* renamed from: rx.internal.operators.OperatorDelayWithSelector */
public final class OperatorDelayWithSelector<T, V> implements Observable.Operator<T, T> {
    final Func1<? super T, ? extends Observable<V>> itemDelay;
    final Observable<? extends T> source;

    public OperatorDelayWithSelector(Observable<? extends T> observable, Func1<? super T, ? extends Observable<V>> func1) {
        this.source = observable;
        this.itemDelay = func1;
    }

    public Subscriber<? super T> call(Subscriber<? super T> subscriber) {
        final SerializedSubscriber serializedSubscriber = new SerializedSubscriber(subscriber);
        final PublishSubject create = PublishSubject.create();
        subscriber.add(Observable.merge(create).unsafeSubscribe(Subscribers.from(serializedSubscriber)));
        return new Subscriber<T>(subscriber) {
            public void onCompleted() {
                create.onCompleted();
            }

            public void onError(Throwable th) {
                serializedSubscriber.onError(th);
            }

            public void onNext(final T t) {
                try {
                    create.onNext(((Observable) OperatorDelayWithSelector.this.itemDelay.call(t)).take(1).defaultIfEmpty(null).map(new Func1<V, T>() {
                        public T call(V v) {
                            return t;
                        }
                    }));
                } catch (Throwable th) {
                    Exceptions.throwOrReport(th, (Observer<?>) this);
                }
            }
        };
    }
}
