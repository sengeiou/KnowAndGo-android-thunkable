package com.polidea.rxandroidble.internal.connection;

import android.bluetooth.BluetoothGattCharacteristic;
import androidx.annotation.NonNull;
import bleshadow.javax.inject.Inject;
import com.polidea.rxandroidble.RxBleConnection;
import com.polidea.rxandroidble.internal.operations.OperationsProvider;
import com.polidea.rxandroidble.internal.serialization.ConnectionOperationQueue;
import java.util.UUID;
import p033rx.Observable;
import p033rx.functions.Func1;

public final class LongWriteOperationBuilderImpl implements RxBleConnection.LongWriteOperationBuilder {
    /* access modifiers changed from: private */
    public byte[] bytes;
    /* access modifiers changed from: private */
    public PayloadSizeLimitProvider maxBatchSizeProvider;
    /* access modifiers changed from: private */
    public final ConnectionOperationQueue operationQueue;
    /* access modifiers changed from: private */
    public final OperationsProvider operationsProvider;
    private final RxBleConnection rxBleConnection;
    /* access modifiers changed from: private */
    public RxBleConnection.WriteOperationAckStrategy writeOperationAckStrategy = new ImmediateSerializedBatchAckStrategy();
    /* access modifiers changed from: private */
    public RxBleConnection.WriteOperationRetryStrategy writeOperationRetryStrategy = new NoRetryStrategy();
    private Observable<BluetoothGattCharacteristic> writtenCharacteristicObservable;

    @Inject
    LongWriteOperationBuilderImpl(ConnectionOperationQueue connectionOperationQueue, MtuBasedPayloadSizeLimit mtuBasedPayloadSizeLimit, RxBleConnection rxBleConnection2, OperationsProvider operationsProvider2) {
        this.operationQueue = connectionOperationQueue;
        this.maxBatchSizeProvider = mtuBasedPayloadSizeLimit;
        this.rxBleConnection = rxBleConnection2;
        this.operationsProvider = operationsProvider2;
    }

    public RxBleConnection.LongWriteOperationBuilder setBytes(@NonNull byte[] bArr) {
        this.bytes = bArr;
        return this;
    }

    public RxBleConnection.LongWriteOperationBuilder setCharacteristicUuid(@NonNull UUID uuid) {
        this.writtenCharacteristicObservable = this.rxBleConnection.getCharacteristic(uuid);
        return this;
    }

    public RxBleConnection.LongWriteOperationBuilder setCharacteristic(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        this.writtenCharacteristicObservable = Observable.just(bluetoothGattCharacteristic);
        return this;
    }

    public RxBleConnection.LongWriteOperationBuilder setMaxBatchSize(int i) {
        this.maxBatchSizeProvider = new ConstantPayloadSizeLimit(i);
        return this;
    }

    public RxBleConnection.LongWriteOperationBuilder setWriteOperationRetryStrategy(@NonNull RxBleConnection.WriteOperationRetryStrategy writeOperationRetryStrategy2) {
        this.writeOperationRetryStrategy = writeOperationRetryStrategy2;
        return this;
    }

    public RxBleConnection.LongWriteOperationBuilder setWriteOperationAckStrategy(@NonNull RxBleConnection.WriteOperationAckStrategy writeOperationAckStrategy2) {
        this.writeOperationAckStrategy = writeOperationAckStrategy2;
        return this;
    }

    public Observable<byte[]> build() {
        if (this.writtenCharacteristicObservable == null) {
            throw new IllegalArgumentException("setCharacteristicUuid() or setCharacteristic() needs to be called before build()");
        } else if (this.bytes != null) {
            return this.writtenCharacteristicObservable.flatMap(new Func1<BluetoothGattCharacteristic, Observable<byte[]>>() {
                public Observable<byte[]> call(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
                    return LongWriteOperationBuilderImpl.this.operationQueue.queue(LongWriteOperationBuilderImpl.this.operationsProvider.provideLongWriteOperation(bluetoothGattCharacteristic, LongWriteOperationBuilderImpl.this.writeOperationAckStrategy, LongWriteOperationBuilderImpl.this.writeOperationRetryStrategy, LongWriteOperationBuilderImpl.this.maxBatchSizeProvider, LongWriteOperationBuilderImpl.this.bytes));
                }
            });
        } else {
            throw new IllegalArgumentException("setBytes() needs to be called before build()");
        }
    }
}
