package p033rx.internal.operators;

import java.util.concurrent.Callable;
import p033rx.Single;
import p033rx.SingleSubscriber;
import p033rx.exceptions.Exceptions;

/* renamed from: rx.internal.operators.SingleFromCallable */
public final class SingleFromCallable<T> implements Single.OnSubscribe<T> {
    final Callable<? extends T> callable;

    public SingleFromCallable(Callable<? extends T> callable2) {
        this.callable = callable2;
    }

    public void call(SingleSubscriber<? super T> singleSubscriber) {
        try {
            singleSubscriber.onSuccess(this.callable.call());
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            singleSubscriber.onError(th);
        }
    }
}
