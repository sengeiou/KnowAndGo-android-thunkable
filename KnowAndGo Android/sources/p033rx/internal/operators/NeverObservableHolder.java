package p033rx.internal.operators;

import p033rx.Observable;
import p033rx.Subscriber;

/* renamed from: rx.internal.operators.NeverObservableHolder */
public enum NeverObservableHolder implements Observable.OnSubscribe<Object> {
    INSTANCE;
    
    static final Observable<Object> NEVER = null;

    public void call(Subscriber<? super Object> subscriber) {
    }

    static {
        NEVER = Observable.unsafeCreate(INSTANCE);
    }

    public static <T> Observable<T> instance() {
        return NEVER;
    }
}
