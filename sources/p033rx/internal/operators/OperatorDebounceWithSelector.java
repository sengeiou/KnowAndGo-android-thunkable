package p033rx.internal.operators;

import p033rx.Observable;
import p033rx.Observer;
import p033rx.Subscriber;
import p033rx.exceptions.Exceptions;
import p033rx.functions.Func1;
import p033rx.internal.operators.OperatorDebounceWithTime;
import p033rx.observers.SerializedSubscriber;
import p033rx.subscriptions.SerialSubscription;

/* renamed from: rx.internal.operators.OperatorDebounceWithSelector */
public final class OperatorDebounceWithSelector<T, U> implements Observable.Operator<T, T> {
    final Func1<? super T, ? extends Observable<U>> selector;

    public OperatorDebounceWithSelector(Func1<? super T, ? extends Observable<U>> func1) {
        this.selector = func1;
    }

    public Subscriber<? super T> call(Subscriber<? super T> subscriber) {
        final SerializedSubscriber serializedSubscriber = new SerializedSubscriber(subscriber);
        final SerialSubscription serialSubscription = new SerialSubscription();
        subscriber.add(serialSubscription);
        return new Subscriber<T>(subscriber) {
            final Subscriber<?> self = this;
            final OperatorDebounceWithTime.DebounceState<T> state = new OperatorDebounceWithTime.DebounceState<>();

            public void onStart() {
                request(Long.MAX_VALUE);
            }

            public void onNext(T t) {
                try {
                    Observable observable = (Observable) OperatorDebounceWithSelector.this.selector.call(t);
                    final int next = this.state.next(t);
                    C41781 r1 = new Subscriber<U>() {
                        public void onNext(U u) {
                            onCompleted();
                        }

                        public void onError(Throwable th) {
                            C41771.this.self.onError(th);
                        }

                        public void onCompleted() {
                            C41771.this.state.emit(next, serializedSubscriber, C41771.this.self);
                            unsubscribe();
                        }
                    };
                    serialSubscription.set(r1);
                    observable.unsafeSubscribe(r1);
                } catch (Throwable th) {
                    Exceptions.throwOrReport(th, (Observer<?>) this);
                }
            }

            public void onError(Throwable th) {
                serializedSubscriber.onError(th);
                unsubscribe();
                this.state.clear();
            }

            public void onCompleted() {
                this.state.emitAndComplete(serializedSubscriber, this);
            }
        };
    }
}
