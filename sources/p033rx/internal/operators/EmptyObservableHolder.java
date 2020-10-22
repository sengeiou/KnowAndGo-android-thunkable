package p033rx.internal.operators;

import p033rx.Observable;
import p033rx.Subscriber;

/* renamed from: rx.internal.operators.EmptyObservableHolder */
public enum EmptyObservableHolder implements Observable.OnSubscribe<Object> {
    INSTANCE;
    
    static final Observable<Object> EMPTY = null;

    static {
        EMPTY = Observable.unsafeCreate(INSTANCE);
    }

    public static <T> Observable<T> instance() {
        return EMPTY;
    }

    public void call(Subscriber<? super Object> subscriber) {
        subscriber.onCompleted();
    }
}
