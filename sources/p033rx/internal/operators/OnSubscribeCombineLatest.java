package p033rx.internal.operators;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import p033rx.Observable;
import p033rx.Producer;
import p033rx.Subscriber;
import p033rx.Subscription;
import p033rx.exceptions.CompositeException;
import p033rx.functions.FuncN;
import p033rx.internal.util.RxRingBuffer;
import p033rx.internal.util.atomic.SpscLinkedArrayQueue;
import p033rx.plugins.RxJavaHooks;

/* renamed from: rx.internal.operators.OnSubscribeCombineLatest */
public final class OnSubscribeCombineLatest<T, R> implements Observable.OnSubscribe<R> {
    final int bufferSize;
    final FuncN<? extends R> combiner;
    final boolean delayError;
    final Observable<? extends T>[] sources;
    final Iterable<? extends Observable<? extends T>> sourcesIterable;

    public OnSubscribeCombineLatest(Iterable<? extends Observable<? extends T>> iterable, FuncN<? extends R> funcN) {
        this((Observable<? extends T>[]) null, iterable, funcN, RxRingBuffer.SIZE, false);
    }

    public OnSubscribeCombineLatest(Observable<? extends T>[] observableArr, Iterable<? extends Observable<? extends T>> iterable, FuncN<? extends R> funcN, int i, boolean z) {
        this.sources = observableArr;
        this.sourcesIterable = iterable;
        this.combiner = funcN;
        this.bufferSize = i;
        this.delayError = z;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0052  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void call(p033rx.Subscriber<? super R> r9) {
        /*
            r8 = this;
            rx.Observable<? extends T>[] r0 = r8.sources
            if (r0 != 0) goto L_0x004a
            java.lang.Iterable<? extends rx.Observable<? extends T>> r0 = r8.sourcesIterable
            boolean r0 = r0 instanceof java.util.List
            if (r0 == 0) goto L_0x001c
            java.lang.Iterable<? extends rx.Observable<? extends T>> r0 = r8.sourcesIterable
            java.util.List r0 = (java.util.List) r0
            int r1 = r0.size()
            rx.Observable[] r1 = new p033rx.Observable[r1]
            java.lang.Object[] r0 = r0.toArray(r1)
            rx.Observable[] r0 = (p033rx.Observable[]) r0
            int r1 = r0.length
            goto L_0x004b
        L_0x001c:
            r0 = 8
            rx.Observable[] r0 = new p033rx.Observable[r0]
            java.lang.Iterable<? extends rx.Observable<? extends T>> r1 = r8.sourcesIterable
            java.util.Iterator r1 = r1.iterator()
            r2 = 0
            r3 = r0
            r0 = 0
        L_0x0029:
            boolean r4 = r1.hasNext()
            if (r4 == 0) goto L_0x0047
            java.lang.Object r4 = r1.next()
            rx.Observable r4 = (p033rx.Observable) r4
            int r5 = r3.length
            if (r0 != r5) goto L_0x0041
            int r5 = r0 >> 2
            int r5 = r5 + r0
            rx.Observable[] r5 = new p033rx.Observable[r5]
            java.lang.System.arraycopy(r3, r2, r5, r2, r0)
            r3 = r5
        L_0x0041:
            int r5 = r0 + 1
            r3[r0] = r4
            r0 = r5
            goto L_0x0029
        L_0x0047:
            r5 = r0
            r0 = r3
            goto L_0x004c
        L_0x004a:
            int r1 = r0.length
        L_0x004b:
            r5 = r1
        L_0x004c:
            if (r5 != 0) goto L_0x0052
            r9.onCompleted()
            return
        L_0x0052:
            rx.internal.operators.OnSubscribeCombineLatest$LatestCoordinator r1 = new rx.internal.operators.OnSubscribeCombineLatest$LatestCoordinator
            rx.functions.FuncN<? extends R> r4 = r8.combiner
            int r6 = r8.bufferSize
            boolean r7 = r8.delayError
            r2 = r1
            r3 = r9
            r2.<init>(r3, r4, r5, r6, r7)
            r1.subscribe(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p033rx.internal.operators.OnSubscribeCombineLatest.call(rx.Subscriber):void");
    }

    /* renamed from: rx.internal.operators.OnSubscribeCombineLatest$LatestCoordinator */
    static final class LatestCoordinator<T, R> extends AtomicInteger implements Producer, Subscription {
        static final Object MISSING = new Object();
        private static final long serialVersionUID = 8567835998786448817L;
        int active;
        final Subscriber<? super R> actual;
        final int bufferSize;
        volatile boolean cancelled;
        final FuncN<? extends R> combiner;
        int complete;
        final boolean delayError;
        volatile boolean done;
        final AtomicReference<Throwable> error = new AtomicReference<>();
        final Object[] latest;
        final SpscLinkedArrayQueue<Object> queue;
        final AtomicLong requested = new AtomicLong();
        final CombinerSubscriber<T, R>[] subscribers;

        public LatestCoordinator(Subscriber<? super R> subscriber, FuncN<? extends R> funcN, int i, int i2, boolean z) {
            this.actual = subscriber;
            this.combiner = funcN;
            this.bufferSize = i2;
            this.delayError = z;
            this.latest = new Object[i];
            Arrays.fill(this.latest, MISSING);
            this.subscribers = new CombinerSubscriber[i];
            this.queue = new SpscLinkedArrayQueue<>(i2);
        }

        public void subscribe(Observable<? extends T>[] observableArr) {
            CombinerSubscriber<T, R>[] combinerSubscriberArr = this.subscribers;
            int length = combinerSubscriberArr.length;
            for (int i = 0; i < length; i++) {
                combinerSubscriberArr[i] = new CombinerSubscriber<>(this, i);
            }
            lazySet(0);
            this.actual.add(this);
            this.actual.setProducer(this);
            for (int i2 = 0; i2 < length && !this.cancelled; i2++) {
                observableArr[i2].subscribe(combinerSubscriberArr[i2]);
            }
        }

        public void request(long j) {
            int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
            if (i < 0) {
                throw new IllegalArgumentException("n >= required but it was " + j);
            } else if (i != 0) {
                BackpressureUtils.getAndAddRequest(this.requested, j);
                drain();
            }
        }

        public void unsubscribe() {
            if (!this.cancelled) {
                this.cancelled = true;
                if (getAndIncrement() == 0) {
                    cancel(this.queue);
                }
            }
        }

        public boolean isUnsubscribed() {
            return this.cancelled;
        }

        /* access modifiers changed from: package-private */
        public void cancel(Queue<?> queue2) {
            queue2.clear();
            for (CombinerSubscriber<T, R> unsubscribe : this.subscribers) {
                unsubscribe.unsubscribe();
            }
        }

        /* access modifiers changed from: package-private */
        public void combine(Object obj, int i) {
            boolean z;
            CombinerSubscriber<T, R> combinerSubscriber = this.subscribers[i];
            synchronized (this) {
                int length = this.latest.length;
                Object obj2 = this.latest[i];
                int i2 = this.active;
                if (obj2 == MISSING) {
                    i2++;
                    this.active = i2;
                }
                int i3 = this.complete;
                if (obj == null) {
                    i3++;
                    this.complete = i3;
                } else {
                    this.latest[i] = NotificationLite.getValue(obj);
                }
                boolean z2 = false;
                z = i2 == length;
                if (i3 == length || (obj == null && obj2 == MISSING)) {
                    z2 = true;
                }
                if (z2) {
                    this.done = true;
                } else if (obj != null && z) {
                    this.queue.offer(combinerSubscriber, this.latest.clone());
                } else if (obj == null && this.error.get() != null && (obj2 == MISSING || !this.delayError)) {
                    this.done = true;
                }
            }
            if (z || obj == null) {
                drain();
            } else {
                combinerSubscriber.requestMore(1);
            }
        }

        /* access modifiers changed from: package-private */
        public void drain() {
            long j;
            if (getAndIncrement() == 0) {
                SpscLinkedArrayQueue<Object> spscLinkedArrayQueue = this.queue;
                Subscriber<? super R> subscriber = this.actual;
                boolean z = this.delayError;
                AtomicLong atomicLong = this.requested;
                int i = 1;
                do {
                    if (!checkTerminated(this.done, spscLinkedArrayQueue.isEmpty(), subscriber, spscLinkedArrayQueue, z)) {
                        long j2 = atomicLong.get();
                        long j3 = 0;
                        while (true) {
                            if (j3 == j2) {
                                j = j3;
                                break;
                            }
                            boolean z2 = this.done;
                            CombinerSubscriber combinerSubscriber = (CombinerSubscriber) spscLinkedArrayQueue.peek();
                            boolean z3 = combinerSubscriber == null;
                            CombinerSubscriber combinerSubscriber2 = combinerSubscriber;
                            long j4 = j3;
                            if (!checkTerminated(z2, z3, subscriber, spscLinkedArrayQueue, z)) {
                                if (z3) {
                                    j = j4;
                                    break;
                                }
                                spscLinkedArrayQueue.poll();
                                Object[] objArr = (Object[]) spscLinkedArrayQueue.poll();
                                if (objArr == null) {
                                    this.cancelled = true;
                                    cancel(spscLinkedArrayQueue);
                                    subscriber.onError(new IllegalStateException("Broken queue?! Sender received but not the array."));
                                    return;
                                }
                                try {
                                    subscriber.onNext(this.combiner.call(objArr));
                                    combinerSubscriber2.requestMore(1);
                                    j3 = j4 + 1;
                                } catch (Throwable th) {
                                    this.cancelled = true;
                                    cancel(spscLinkedArrayQueue);
                                    subscriber.onError(th);
                                    return;
                                }
                            } else {
                                return;
                            }
                        }
                        if (!(j == 0 || j2 == Long.MAX_VALUE)) {
                            BackpressureUtils.produced(atomicLong, j);
                        }
                        i = addAndGet(-i);
                    } else {
                        return;
                    }
                } while (i != 0);
            }
        }

        /* access modifiers changed from: package-private */
        public boolean checkTerminated(boolean z, boolean z2, Subscriber<?> subscriber, Queue<?> queue2, boolean z3) {
            if (this.cancelled) {
                cancel(queue2);
                return true;
            } else if (!z) {
                return false;
            } else {
                if (!z3) {
                    Throwable th = this.error.get();
                    if (th != null) {
                        cancel(queue2);
                        subscriber.onError(th);
                        return true;
                    } else if (!z2) {
                        return false;
                    } else {
                        subscriber.onCompleted();
                        return true;
                    }
                } else if (!z2) {
                    return false;
                } else {
                    Throwable th2 = this.error.get();
                    if (th2 != null) {
                        subscriber.onError(th2);
                    } else {
                        subscriber.onCompleted();
                    }
                    return true;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void onError(Throwable th) {
            Throwable th2;
            Throwable th3;
            AtomicReference<Throwable> atomicReference = this.error;
            do {
                th2 = atomicReference.get();
                if (th2 == null) {
                    th3 = th;
                } else if (th2 instanceof CompositeException) {
                    ArrayList arrayList = new ArrayList(((CompositeException) th2).getExceptions());
                    arrayList.add(th);
                    th3 = new CompositeException((Collection<? extends Throwable>) arrayList);
                } else {
                    th3 = new CompositeException((Collection<? extends Throwable>) Arrays.asList(new Throwable[]{th2, th}));
                }
            } while (!atomicReference.compareAndSet(th2, th3));
        }
    }

    /* renamed from: rx.internal.operators.OnSubscribeCombineLatest$CombinerSubscriber */
    static final class CombinerSubscriber<T, R> extends Subscriber<T> {
        boolean done;
        final int index;
        final LatestCoordinator<T, R> parent;

        public CombinerSubscriber(LatestCoordinator<T, R> latestCoordinator, int i) {
            this.parent = latestCoordinator;
            this.index = i;
            request((long) latestCoordinator.bufferSize);
        }

        public void onNext(T t) {
            if (!this.done) {
                this.parent.combine(NotificationLite.next(t), this.index);
            }
        }

        public void onError(Throwable th) {
            if (this.done) {
                RxJavaHooks.onError(th);
                return;
            }
            this.parent.onError(th);
            this.done = true;
            this.parent.combine((Object) null, this.index);
        }

        public void onCompleted() {
            if (!this.done) {
                this.done = true;
                this.parent.combine((Object) null, this.index);
            }
        }

        public void requestMore(long j) {
            request(j);
        }
    }
}
