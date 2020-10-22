package p033rx.internal.operators;

import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import p033rx.Observable;
import p033rx.Observer;
import p033rx.Producer;
import p033rx.Subscriber;
import p033rx.exceptions.Exceptions;
import p033rx.exceptions.MissingBackpressureException;
import p033rx.functions.Func1;
import p033rx.internal.operators.OnSubscribeFromIterable;
import p033rx.internal.util.ExceptionsUtils;
import p033rx.internal.util.RxRingBuffer;
import p033rx.internal.util.ScalarSynchronousObservable;
import p033rx.internal.util.atomic.SpscAtomicArrayQueue;
import p033rx.internal.util.atomic.SpscLinkedArrayQueue;
import p033rx.internal.util.unsafe.SpscArrayQueue;
import p033rx.internal.util.unsafe.UnsafeAccess;
import p033rx.plugins.RxJavaHooks;

/* renamed from: rx.internal.operators.OnSubscribeFlattenIterable */
public final class OnSubscribeFlattenIterable<T, R> implements Observable.OnSubscribe<R> {
    final Func1<? super T, ? extends Iterable<? extends R>> mapper;
    final int prefetch;
    final Observable<? extends T> source;

    protected OnSubscribeFlattenIterable(Observable<? extends T> observable, Func1<? super T, ? extends Iterable<? extends R>> func1, int i) {
        this.source = observable;
        this.mapper = func1;
        this.prefetch = i;
    }

    public void call(Subscriber<? super R> subscriber) {
        final FlattenIterableSubscriber flattenIterableSubscriber = new FlattenIterableSubscriber(subscriber, this.mapper, this.prefetch);
        subscriber.add(flattenIterableSubscriber);
        subscriber.setProducer(new Producer() {
            public void request(long j) {
                flattenIterableSubscriber.requestMore(j);
            }
        });
        this.source.unsafeSubscribe(flattenIterableSubscriber);
    }

    public static <T, R> Observable<R> createFrom(Observable<? extends T> observable, Func1<? super T, ? extends Iterable<? extends R>> func1, int i) {
        if (observable instanceof ScalarSynchronousObservable) {
            return Observable.unsafeCreate(new OnSubscribeScalarFlattenIterable(((ScalarSynchronousObservable) observable).get(), func1));
        }
        return Observable.unsafeCreate(new OnSubscribeFlattenIterable(observable, func1, i));
    }

    /* renamed from: rx.internal.operators.OnSubscribeFlattenIterable$FlattenIterableSubscriber */
    static final class FlattenIterableSubscriber<T, R> extends Subscriber<T> {
        Iterator<? extends R> active;
        final Subscriber<? super R> actual;
        volatile boolean done;
        final AtomicReference<Throwable> error = new AtomicReference<>();
        final long limit;
        final Func1<? super T, ? extends Iterable<? extends R>> mapper;
        long produced;
        final Queue<Object> queue;
        final AtomicLong requested = new AtomicLong();
        final AtomicInteger wip = new AtomicInteger();

        public FlattenIterableSubscriber(Subscriber<? super R> subscriber, Func1<? super T, ? extends Iterable<? extends R>> func1, int i) {
            this.actual = subscriber;
            this.mapper = func1;
            if (i == Integer.MAX_VALUE) {
                this.limit = Long.MAX_VALUE;
                this.queue = new SpscLinkedArrayQueue(RxRingBuffer.SIZE);
            } else {
                this.limit = (long) (i - (i >> 2));
                if (UnsafeAccess.isUnsafeAvailable()) {
                    this.queue = new SpscArrayQueue(i);
                } else {
                    this.queue = new SpscAtomicArrayQueue(i);
                }
            }
            request((long) i);
        }

        public void onNext(T t) {
            if (!this.queue.offer(NotificationLite.next(t))) {
                unsubscribe();
                onError(new MissingBackpressureException());
                return;
            }
            drain();
        }

        public void onError(Throwable th) {
            if (ExceptionsUtils.addThrowable(this.error, th)) {
                this.done = true;
                drain();
                return;
            }
            RxJavaHooks.onError(th);
        }

        public void onCompleted() {
            this.done = true;
            drain();
        }

        /* access modifiers changed from: package-private */
        public void requestMore(long j) {
            int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
            if (i > 0) {
                BackpressureUtils.getAndAddRequest(this.requested, j);
                drain();
            } else if (i < 0) {
                throw new IllegalStateException("n >= 0 required but it was " + j);
            }
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:59:0x00cc, code lost:
            if (r13 == null) goto L_0x00ce;
         */
        /* JADX WARNING: Removed duplicated region for block: B:26:0x0066  */
        /* JADX WARNING: Removed duplicated region for block: B:68:0x00db A[SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:71:0x0010 A[SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void drain() {
            /*
                r16 = this;
                r1 = r16
                java.util.concurrent.atomic.AtomicInteger r0 = r1.wip
                int r0 = r0.getAndIncrement()
                if (r0 == 0) goto L_0x000b
                return
            L_0x000b:
                rx.Subscriber<? super R> r2 = r1.actual
                java.util.Queue<java.lang.Object> r3 = r1.queue
                r5 = 1
            L_0x0010:
                java.util.Iterator<? extends R> r0 = r1.active
                r6 = 1
                r8 = 0
                r10 = 0
                if (r0 != 0) goto L_0x0063
                boolean r11 = r1.done
                java.lang.Object r12 = r3.poll()
                if (r12 != 0) goto L_0x0023
                r13 = 1
                goto L_0x0024
            L_0x0023:
                r13 = 0
            L_0x0024:
                boolean r11 = r1.checkTerminated(r11, r13, r2, r3)
                if (r11 == 0) goto L_0x002b
                return
            L_0x002b:
                if (r13 != 0) goto L_0x0063
                long r13 = r1.produced
                long r13 = r13 + r6
                r15 = r5
                long r4 = r1.limit
                int r0 = (r13 > r4 ? 1 : (r13 == r4 ? 0 : -1))
                if (r0 != 0) goto L_0x003d
                r1.produced = r8
                r1.request(r13)
                goto L_0x003f
            L_0x003d:
                r1.produced = r13
            L_0x003f:
                rx.functions.Func1<? super T, ? extends java.lang.Iterable<? extends R>> r0 = r1.mapper     // Catch:{ Throwable -> 0x005a }
                java.lang.Object r4 = p033rx.internal.operators.NotificationLite.getValue(r12)     // Catch:{ Throwable -> 0x005a }
                java.lang.Object r0 = r0.call(r4)     // Catch:{ Throwable -> 0x005a }
                java.lang.Iterable r0 = (java.lang.Iterable) r0     // Catch:{ Throwable -> 0x005a }
                java.util.Iterator r0 = r0.iterator()     // Catch:{ Throwable -> 0x005a }
                boolean r4 = r0.hasNext()     // Catch:{ Throwable -> 0x005a }
                if (r4 != 0) goto L_0x0057
                goto L_0x00ce
            L_0x0057:
                r1.active = r0
                goto L_0x0064
            L_0x005a:
                r0 = move-exception
                p033rx.exceptions.Exceptions.throwIfFatal(r0)
                r1.onError(r0)
                goto L_0x00ce
            L_0x0063:
                r15 = r5
            L_0x0064:
                if (r0 == 0) goto L_0x00d1
                java.util.concurrent.atomic.AtomicLong r4 = r1.requested
                long r4 = r4.get()
                r11 = r8
            L_0x006d:
                r13 = 0
                int r14 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1))
                if (r14 == 0) goto L_0x00ac
                boolean r14 = r1.done
                boolean r14 = r1.checkTerminated(r14, r10, r2, r3)
                if (r14 == 0) goto L_0x007b
                return
            L_0x007b:
                java.lang.Object r14 = r0.next()     // Catch:{ Throwable -> 0x00a1 }
                r2.onNext(r14)
                boolean r14 = r1.done
                boolean r14 = r1.checkTerminated(r14, r10, r2, r3)
                if (r14 == 0) goto L_0x008b
                return
            L_0x008b:
                r14 = 0
                long r11 = r11 + r6
                boolean r14 = r0.hasNext()     // Catch:{ Throwable -> 0x0096 }
                if (r14 != 0) goto L_0x006d
                r1.active = r13
                goto L_0x00ad
            L_0x0096:
                r0 = move-exception
                r6 = r0
                p033rx.exceptions.Exceptions.throwIfFatal(r6)
                r1.active = r13
                r1.onError(r6)
                goto L_0x00ad
            L_0x00a1:
                r0 = move-exception
                r6 = r0
                p033rx.exceptions.Exceptions.throwIfFatal(r6)
                r1.active = r13
                r1.onError(r6)
                goto L_0x00ad
            L_0x00ac:
                r13 = r0
            L_0x00ad:
                int r0 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1))
                if (r0 != 0) goto L_0x00c3
                boolean r0 = r1.done
                boolean r4 = r3.isEmpty()
                if (r4 == 0) goto L_0x00bc
                if (r13 != 0) goto L_0x00bc
                r10 = 1
            L_0x00bc:
                boolean r0 = r1.checkTerminated(r0, r10, r2, r3)
                if (r0 == 0) goto L_0x00c3
                return
            L_0x00c3:
                int r0 = (r11 > r8 ? 1 : (r11 == r8 ? 0 : -1))
                if (r0 == 0) goto L_0x00cc
                java.util.concurrent.atomic.AtomicLong r0 = r1.requested
                p033rx.internal.operators.BackpressureUtils.produced(r0, r11)
            L_0x00cc:
                if (r13 != 0) goto L_0x00d1
            L_0x00ce:
                r5 = r15
                goto L_0x0010
            L_0x00d1:
                java.util.concurrent.atomic.AtomicInteger r0 = r1.wip
                r4 = r15
                int r4 = -r4
                int r5 = r0.addAndGet(r4)
                if (r5 != 0) goto L_0x0010
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: p033rx.internal.operators.OnSubscribeFlattenIterable.FlattenIterableSubscriber.drain():void");
        }

        /* access modifiers changed from: package-private */
        public boolean checkTerminated(boolean z, boolean z2, Subscriber<?> subscriber, Queue<?> queue2) {
            if (subscriber.isUnsubscribed()) {
                queue2.clear();
                this.active = null;
                return true;
            } else if (!z) {
                return false;
            } else {
                if (this.error.get() != null) {
                    Throwable terminate = ExceptionsUtils.terminate(this.error);
                    unsubscribe();
                    queue2.clear();
                    this.active = null;
                    subscriber.onError(terminate);
                    return true;
                } else if (!z2) {
                    return false;
                } else {
                    subscriber.onCompleted();
                    return true;
                }
            }
        }
    }

    /* renamed from: rx.internal.operators.OnSubscribeFlattenIterable$OnSubscribeScalarFlattenIterable */
    static final class OnSubscribeScalarFlattenIterable<T, R> implements Observable.OnSubscribe<R> {
        final Func1<? super T, ? extends Iterable<? extends R>> mapper;
        final T value;

        public OnSubscribeScalarFlattenIterable(T t, Func1<? super T, ? extends Iterable<? extends R>> func1) {
            this.value = t;
            this.mapper = func1;
        }

        public void call(Subscriber<? super R> subscriber) {
            try {
                Iterator it = ((Iterable) this.mapper.call(this.value)).iterator();
                if (!it.hasNext()) {
                    subscriber.onCompleted();
                } else {
                    subscriber.setProducer(new OnSubscribeFromIterable.IterableProducer(subscriber, it));
                }
            } catch (Throwable th) {
                Exceptions.throwOrReport(th, (Observer<?>) subscriber, (Object) this.value);
            }
        }
    }
}