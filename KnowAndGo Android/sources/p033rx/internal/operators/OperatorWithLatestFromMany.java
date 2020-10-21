package p033rx.internal.operators;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceArray;
import p033rx.Observable;
import p033rx.Producer;
import p033rx.Subscriber;
import p033rx.exceptions.Exceptions;
import p033rx.functions.FuncN;
import p033rx.observers.SerializedSubscriber;
import p033rx.plugins.RxJavaHooks;

/* renamed from: rx.internal.operators.OperatorWithLatestFromMany */
public final class OperatorWithLatestFromMany<T, R> implements Observable.OnSubscribe<R> {
    final FuncN<R> combiner;
    final Observable<T> main;
    final Observable<?>[] others;
    final Iterable<Observable<?>> othersIterable;

    public OperatorWithLatestFromMany(Observable<T> observable, Observable<?>[] observableArr, Iterable<Observable<?>> iterable, FuncN<R> funcN) {
        this.main = observable;
        this.others = observableArr;
        this.othersIterable = iterable;
        this.combiner = funcN;
    }

    public void call(Subscriber<? super R> subscriber) {
        Observable<?>[] observableArr;
        int i;
        SerializedSubscriber serializedSubscriber = new SerializedSubscriber(subscriber);
        int i2 = 0;
        if (this.others != null) {
            Observable<?>[] observableArr2 = this.others;
            observableArr = observableArr2;
            i = observableArr2.length;
        } else {
            observableArr = new Observable[8];
            i = 0;
            for (Observable<?> next : this.othersIterable) {
                if (i == observableArr.length) {
                    observableArr = (Observable[]) Arrays.copyOf(observableArr, (i >> 2) + i);
                }
                observableArr[i] = next;
                i++;
            }
        }
        WithLatestMainSubscriber withLatestMainSubscriber = new WithLatestMainSubscriber(subscriber, this.combiner, i);
        serializedSubscriber.add(withLatestMainSubscriber);
        while (i2 < i) {
            if (!serializedSubscriber.isUnsubscribed()) {
                int i3 = i2 + 1;
                WithLatestOtherSubscriber withLatestOtherSubscriber = new WithLatestOtherSubscriber(withLatestMainSubscriber, i3);
                withLatestMainSubscriber.add(withLatestOtherSubscriber);
                observableArr[i2].unsafeSubscribe(withLatestOtherSubscriber);
                i2 = i3;
            } else {
                return;
            }
        }
        this.main.unsafeSubscribe(withLatestMainSubscriber);
    }

    /* renamed from: rx.internal.operators.OperatorWithLatestFromMany$WithLatestMainSubscriber */
    static final class WithLatestMainSubscriber<T, R> extends Subscriber<T> {
        static final Object EMPTY = new Object();
        final Subscriber<? super R> actual;
        final FuncN<R> combiner;
        final AtomicReferenceArray<Object> current;
        boolean done;
        final AtomicInteger ready;

        public WithLatestMainSubscriber(Subscriber<? super R> subscriber, FuncN<R> funcN, int i) {
            this.actual = subscriber;
            this.combiner = funcN;
            AtomicReferenceArray<Object> atomicReferenceArray = new AtomicReferenceArray<>(i + 1);
            for (int i2 = 0; i2 <= i; i2++) {
                atomicReferenceArray.lazySet(i2, EMPTY);
            }
            this.current = atomicReferenceArray;
            this.ready = new AtomicInteger(i);
            request(0);
        }

        public void onNext(T t) {
            if (!this.done) {
                if (this.ready.get() == 0) {
                    AtomicReferenceArray<Object> atomicReferenceArray = this.current;
                    int length = atomicReferenceArray.length();
                    atomicReferenceArray.lazySet(0, t);
                    Object[] objArr = new Object[atomicReferenceArray.length()];
                    for (int i = 0; i < length; i++) {
                        objArr[i] = atomicReferenceArray.get(i);
                    }
                    try {
                        this.actual.onNext(this.combiner.call(objArr));
                    } catch (Throwable th) {
                        Exceptions.throwIfFatal(th);
                        onError(th);
                    }
                } else {
                    request(1);
                }
            }
        }

        public void onError(Throwable th) {
            if (this.done) {
                RxJavaHooks.onError(th);
                return;
            }
            this.done = true;
            unsubscribe();
            this.actual.onError(th);
        }

        public void onCompleted() {
            if (!this.done) {
                this.done = true;
                unsubscribe();
                this.actual.onCompleted();
            }
        }

        public void setProducer(Producer producer) {
            super.setProducer(producer);
            this.actual.setProducer(producer);
        }

        /* access modifiers changed from: package-private */
        public void innerNext(int i, Object obj) {
            if (this.current.getAndSet(i, obj) == EMPTY) {
                this.ready.decrementAndGet();
            }
        }

        /* access modifiers changed from: package-private */
        public void innerError(int i, Throwable th) {
            onError(th);
        }

        /* access modifiers changed from: package-private */
        public void innerComplete(int i) {
            if (this.current.get(i) == EMPTY) {
                onCompleted();
            }
        }
    }

    /* renamed from: rx.internal.operators.OperatorWithLatestFromMany$WithLatestOtherSubscriber */
    static final class WithLatestOtherSubscriber extends Subscriber<Object> {
        final int index;
        final WithLatestMainSubscriber<?, ?> parent;

        public WithLatestOtherSubscriber(WithLatestMainSubscriber<?, ?> withLatestMainSubscriber, int i) {
            this.parent = withLatestMainSubscriber;
            this.index = i;
        }

        public void onNext(Object obj) {
            this.parent.innerNext(this.index, obj);
        }

        public void onError(Throwable th) {
            this.parent.innerError(this.index, th);
        }

        public void onCompleted() {
            this.parent.innerComplete(this.index);
        }
    }
}
