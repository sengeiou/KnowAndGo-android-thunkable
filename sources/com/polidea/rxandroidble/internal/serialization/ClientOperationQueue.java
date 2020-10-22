package com.polidea.rxandroidble.internal.serialization;

import com.polidea.rxandroidble.internal.operations.Operation;
import p033rx.Observable;

public interface ClientOperationQueue {
    <T> Observable<T> queue(Operation<T> operation);
}
