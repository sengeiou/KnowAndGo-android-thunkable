package com.polidea.rxandroidble.internal.connection;

import com.polidea.rxandroidble.RxBleConnection;
import p033rx.Observable;
import p033rx.functions.Func1;

public class NoRetryStrategy implements RxBleConnection.WriteOperationRetryStrategy {
    public Observable<RxBleConnection.WriteOperationRetryStrategy.LongWriteFailure> call(Observable<RxBleConnection.WriteOperationRetryStrategy.LongWriteFailure> observable) {
        return observable.flatMap(new Func1<RxBleConnection.WriteOperationRetryStrategy.LongWriteFailure, Observable<RxBleConnection.WriteOperationRetryStrategy.LongWriteFailure>>() {
            public Observable<RxBleConnection.WriteOperationRetryStrategy.LongWriteFailure> call(RxBleConnection.WriteOperationRetryStrategy.LongWriteFailure longWriteFailure) {
                return Observable.error(longWriteFailure.getCause());
            }
        });
    }
}
