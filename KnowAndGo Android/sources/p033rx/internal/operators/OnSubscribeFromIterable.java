package p033rx.internal.operators;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
import p033rx.Observable;
import p033rx.Observer;
import p033rx.Producer;
import p033rx.Subscriber;
import p033rx.exceptions.Exceptions;

/* renamed from: rx.internal.operators.OnSubscribeFromIterable */
public final class OnSubscribeFromIterable<T> implements Observable.OnSubscribe<T> {

    /* renamed from: is */
    final Iterable<? extends T> f3056is;

    public OnSubscribeFromIterable(Iterable<? extends T> iterable) {
        if (iterable != null) {
            this.f3056is = iterable;
            return;
        }
        throw new NullPointerException("iterable must not be null");
    }

    public void call(Subscriber<? super T> subscriber) {
        try {
            Iterator<? extends T> it = this.f3056is.iterator();
            boolean hasNext = it.hasNext();
            if (subscriber.isUnsubscribed()) {
                return;
            }
            if (!hasNext) {
                subscriber.onCompleted();
            } else {
                subscriber.setProducer(new IterableProducer(subscriber, it));
            }
        } catch (Throwable th) {
            Exceptions.throwOrReport(th, (Observer<?>) subscriber);
        }
    }

    /* renamed from: rx.internal.operators.OnSubscribeFromIterable$IterableProducer */
    static final class IterableProducer<T> extends AtomicLong implements Producer {
        private static final long serialVersionUID = -8730475647105475802L;

        /* renamed from: it */
        private final Iterator<? extends T> f3057it;

        /* renamed from: o */
        private final Subscriber<? super T> f3058o;

        IterableProducer(Subscriber<? super T> subscriber, Iterator<? extends T> it) {
            this.f3058o = subscriber;
            this.f3057it = it;
        }

        public void request(long j) {
            if (get() != Long.MAX_VALUE) {
                if (j == Long.MAX_VALUE && compareAndSet(0, Long.MAX_VALUE)) {
                    fastPath();
                } else if (j > 0 && BackpressureUtils.getAndAddRequest(this, j) == 0) {
                    slowPath(j);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void slowPath(long j) {
            Subscriber<? super T> subscriber = this.f3058o;
            Iterator<? extends T> it = this.f3057it;
            long j2 = j;
            do {
                long j3 = 0;
                while (true) {
                    if (j3 == j2) {
                        j2 = get();
                        if (j3 == j2) {
                            j2 = BackpressureUtils.produced(this, j3);
                        }
                    } else if (!subscriber.isUnsubscribed()) {
                        try {
                            subscriber.onNext(it.next());
                            if (!subscriber.isUnsubscribed()) {
                                try {
                                    if (it.hasNext()) {
                                        j3++;
                                    } else if (!subscriber.isUnsubscribed()) {
                                        subscriber.onCompleted();
                                        return;
                                    } else {
                                        return;
                                    }
                                } catch (Throwable th) {
                                    Exceptions.throwOrReport(th, (Observer<?>) subscriber);
                                    return;
                                }
                            } else {
                                return;
                            }
                        } catch (Throwable th2) {
                            Exceptions.throwOrReport(th2, (Observer<?>) subscriber);
                            return;
                        }
                    } else {
                        return;
                    }
                }
            } while (j2 != 0);
        }

        /* access modifiers changed from: package-private */
        public void fastPath() {
            Subscriber<? super T> subscriber = this.f3058o;
            Iterator<? extends T> it = this.f3057it;
            while (!subscriber.isUnsubscribed()) {
                try {
                    subscriber.onNext(it.next());
                    if (!subscriber.isUnsubscribed()) {
                        try {
                            if (!it.hasNext()) {
                                if (!subscriber.isUnsubscribed()) {
                                    subscriber.onCompleted();
                                    return;
                                }
                                return;
                            }
                        } catch (Throwable th) {
                            Exceptions.throwOrReport(th, (Observer<?>) subscriber);
                            return;
                        }
                    } else {
                        return;
                    }
                } catch (Throwable th2) {
                    Exceptions.throwOrReport(th2, (Observer<?>) subscriber);
                    return;
                }
            }
        }
    }
}
