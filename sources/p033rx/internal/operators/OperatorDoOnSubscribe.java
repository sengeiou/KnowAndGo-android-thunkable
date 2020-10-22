package p033rx.internal.operators;

import p033rx.Observable;
import p033rx.Subscriber;
import p033rx.functions.Action0;
import p033rx.observers.Subscribers;

/* renamed from: rx.internal.operators.OperatorDoOnSubscribe */
public class OperatorDoOnSubscribe<T> implements Observable.Operator<T, T> {
    private final Action0 subscribe;

    public OperatorDoOnSubscribe(Action0 action0) {
        this.subscribe = action0;
    }

    public Subscriber<? super T> call(Subscriber<? super T> subscriber) {
        this.subscribe.call();
        return Subscribers.wrap(subscriber);
    }
}
