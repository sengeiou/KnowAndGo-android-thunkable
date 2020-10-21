package com.polidea.rxandroidble.internal.serialization;

import androidx.annotation.RestrictTo;
import bleshadow.javax.inject.Inject;
import bleshadow.javax.inject.Named;
import com.polidea.rxandroidble.internal.RxBleLog;
import com.polidea.rxandroidble.internal.operations.Operation;
import com.polidea.rxandroidble.internal.util.OperationLogger;
import p033rx.Emitter;
import p033rx.Observable;
import p033rx.Scheduler;
import p033rx.functions.Action1;
import p033rx.functions.Cancellable;

public class ClientOperationQueueImpl implements ClientOperationQueue {
    /* access modifiers changed from: private */
    public OperationPriorityFifoBlockingQueue queue = new OperationPriorityFifoBlockingQueue();

    @Inject
    public ClientOperationQueueImpl(@Named("bluetooth_interaction") final Scheduler scheduler) {
        new Thread(new Runnable() {
            public void run() {
                while (true) {
                    try {
                        FIFORunnableEntry<?> take = ClientOperationQueueImpl.this.queue.take();
                        Operation<T> operation = take.operation;
                        long currentTimeMillis = System.currentTimeMillis();
                        OperationLogger.logOperationStarted(operation);
                        QueueSemaphore queueSemaphore = new QueueSemaphore();
                        take.emitter.setSubscription(take.run(queueSemaphore, scheduler));
                        queueSemaphore.awaitRelease();
                        OperationLogger.logOperationFinished(operation, currentTimeMillis, System.currentTimeMillis());
                    } catch (InterruptedException e) {
                        RxBleLog.m1087e(e, "Error while processing client operation queue", new Object[0]);
                    }
                }
            }
        }).start();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public <T> Observable<T> queue(final Operation<T> operation) {
        return Observable.create(new Action1<Emitter<T>>() {
            public void call(Emitter<T> emitter) {
                final FIFORunnableEntry fIFORunnableEntry = new FIFORunnableEntry(operation, emitter);
                emitter.setCancellation(new Cancellable() {
                    public void cancel() throws Exception {
                        if (ClientOperationQueueImpl.this.queue.remove(fIFORunnableEntry)) {
                            OperationLogger.logOperationRemoved(operation);
                        }
                    }
                });
                OperationLogger.logOperationQueued(operation);
                ClientOperationQueueImpl.this.queue.add(fIFORunnableEntry);
            }
        }, Emitter.BackpressureMode.NONE);
    }
}
