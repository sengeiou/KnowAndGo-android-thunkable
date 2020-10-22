package com.polidea.rxandroidble;

import android.bluetooth.BluetoothGatt;
import androidx.annotation.NonNull;
import com.polidea.rxandroidble.internal.connection.RxBleGattCallback;
import p033rx.Observable;
import p033rx.Scheduler;

public interface RxBleCustomOperation<T> {
    @NonNull
    Observable<T> asObservable(BluetoothGatt bluetoothGatt, RxBleGattCallback rxBleGattCallback, Scheduler scheduler) throws Throwable;
}
