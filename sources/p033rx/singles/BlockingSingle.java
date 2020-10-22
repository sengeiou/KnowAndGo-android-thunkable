package p033rx.singles;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicReference;
import p033rx.Single;
import p033rx.SingleSubscriber;
import p033rx.exceptions.Exceptions;
import p033rx.internal.operators.BlockingOperatorToFuture;
import p033rx.internal.util.BlockingUtils;

/* renamed from: rx.singles.BlockingSingle */
public final class BlockingSingle<T> {
    private final Single<? extends T> single;

    private BlockingSingle(Single<? extends T> single2) {
        this.single = single2;
    }

    public static <T> BlockingSingle<T> from(Single<? extends T> single2) {
        return new BlockingSingle<>(single2);
    }

    public T value() {
        final AtomicReference atomicReference = new AtomicReference();
        final AtomicReference atomicReference2 = new AtomicReference();
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        BlockingUtils.awaitForComplete(countDownLatch, this.single.subscribe(new SingleSubscriber<T>() {
            public void onSuccess(T t) {
                atomicReference.set(t);
                countDownLatch.countDown();
            }

            public void onError(Throwable th) {
                atomicReference2.set(th);
                countDownLatch.countDown();
            }
        }));
        Throwable th = (Throwable) atomicReference2.get();
        if (th == null) {
            return atomicReference.get();
        }
        throw Exceptions.propagate(th);
    }

    public Future<T> toFuture() {
        return BlockingOperatorToFuture.toFuture(this.single.toObservable());
    }
}
