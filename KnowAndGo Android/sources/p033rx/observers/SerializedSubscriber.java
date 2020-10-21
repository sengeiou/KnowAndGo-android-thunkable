package p033rx.observers;

import p033rx.Observer;
import p033rx.Subscriber;

/* renamed from: rx.observers.SerializedSubscriber */
public class SerializedSubscriber<T> extends Subscriber<T> {

    /* renamed from: s */
    private final Observer<T> f3089s;

    public SerializedSubscriber(Subscriber<? super T> subscriber) {
        this(subscriber, true);
    }

    public SerializedSubscriber(Subscriber<? super T> subscriber, boolean z) {
        super(subscriber, z);
        this.f3089s = new SerializedObserver(subscriber);
    }

    public void onCompleted() {
        this.f3089s.onCompleted();
    }

    public void onError(Throwable th) {
        this.f3089s.onError(th);
    }

    public void onNext(T t) {
        this.f3089s.onNext(t);
    }
}
