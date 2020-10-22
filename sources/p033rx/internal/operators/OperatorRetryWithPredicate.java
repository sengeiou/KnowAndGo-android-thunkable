package p033rx.internal.operators;

import java.util.concurrent.atomic.AtomicInteger;
import p033rx.Observable;
import p033rx.Producer;
import p033rx.Scheduler;
import p033rx.Subscriber;
import p033rx.functions.Action0;
import p033rx.functions.Func2;
import p033rx.internal.producers.ProducerArbiter;
import p033rx.schedulers.Schedulers;
import p033rx.subscriptions.SerialSubscription;

/* renamed from: rx.internal.operators.OperatorRetryWithPredicate */
public final class OperatorRetryWithPredicate<T> implements Observable.Operator<T, Observable<T>> {
    final Func2<Integer, Throwable, Boolean> predicate;

    public OperatorRetryWithPredicate(Func2<Integer, Throwable, Boolean> func2) {
        this.predicate = func2;
    }

    public Subscriber<? super Observable<T>> call(Subscriber<? super T> subscriber) {
        Scheduler.Worker createWorker = Schedulers.trampoline().createWorker();
        subscriber.add(createWorker);
        SerialSubscription serialSubscription = new SerialSubscription();
        subscriber.add(serialSubscription);
        ProducerArbiter producerArbiter = new ProducerArbiter();
        subscriber.setProducer(producerArbiter);
        return new SourceSubscriber(subscriber, this.predicate, createWorker, serialSubscription, producerArbiter);
    }

    /* renamed from: rx.internal.operators.OperatorRetryWithPredicate$SourceSubscriber */
    static final class SourceSubscriber<T> extends Subscriber<Observable<T>> {
        final AtomicInteger attempts = new AtomicInteger();
        final Subscriber<? super T> child;
        final Scheduler.Worker inner;

        /* renamed from: pa */
        final ProducerArbiter f3066pa;
        final Func2<Integer, Throwable, Boolean> predicate;
        final SerialSubscription serialSubscription;

        public void onCompleted() {
        }

        public SourceSubscriber(Subscriber<? super T> subscriber, Func2<Integer, Throwable, Boolean> func2, Scheduler.Worker worker, SerialSubscription serialSubscription2, ProducerArbiter producerArbiter) {
            this.child = subscriber;
            this.predicate = func2;
            this.inner = worker;
            this.serialSubscription = serialSubscription2;
            this.f3066pa = producerArbiter;
        }

        public void onError(Throwable th) {
            this.child.onError(th);
        }

        public void onNext(final Observable<T> observable) {
            this.inner.schedule(new Action0() {
                public void call() {
                    SourceSubscriber.this.attempts.incrementAndGet();
                    C42281 r0 = new Subscriber<T>() {
                        boolean done;

                        public void onCompleted() {
                            if (!this.done) {
                                this.done = true;
                                SourceSubscriber.this.child.onCompleted();
                            }
                        }

                        public void onError(Throwable th) {
                            if (!this.done) {
                                this.done = true;
                                if (!SourceSubscriber.this.predicate.call(Integer.valueOf(SourceSubscriber.this.attempts.get()), th).booleanValue() || SourceSubscriber.this.inner.isUnsubscribed()) {
                                    SourceSubscriber.this.child.onError(th);
                                } else {
                                    SourceSubscriber.this.inner.schedule(this);
                                }
                            }
                        }

                        public void onNext(T t) {
                            if (!this.done) {
                                SourceSubscriber.this.child.onNext(t);
                                SourceSubscriber.this.f3066pa.produced(1);
                            }
                        }

                        public void setProducer(Producer producer) {
                            SourceSubscriber.this.f3066pa.setProducer(producer);
                        }
                    };
                    SourceSubscriber.this.serialSubscription.set(r0);
                    observable.unsafeSubscribe(r0);
                }
            });
        }
    }
}
