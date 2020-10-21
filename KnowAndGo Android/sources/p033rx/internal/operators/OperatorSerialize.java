package p033rx.internal.operators;

import p033rx.Observable;
import p033rx.Subscriber;
import p033rx.observers.SerializedSubscriber;

/* renamed from: rx.internal.operators.OperatorSerialize */
public final class OperatorSerialize<T> implements Observable.Operator<T, T> {

    /* renamed from: rx.internal.operators.OperatorSerialize$Holder */
    static final class Holder {
        static final OperatorSerialize<Object> INSTANCE = new OperatorSerialize<>();

        Holder() {
        }
    }

    public static <T> OperatorSerialize<T> instance() {
        return Holder.INSTANCE;
    }

    OperatorSerialize() {
    }

    public Subscriber<? super T> call(final Subscriber<? super T> subscriber) {
        return new SerializedSubscriber(new Subscriber<T>(subscriber) {
            public void onCompleted() {
                subscriber.onCompleted();
            }

            public void onError(Throwable th) {
                subscriber.onError(th);
            }

            public void onNext(T t) {
                subscriber.onNext(t);
            }
        });
    }
}
