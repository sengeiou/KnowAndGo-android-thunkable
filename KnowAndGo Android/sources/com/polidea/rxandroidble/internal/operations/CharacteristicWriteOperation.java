package com.polidea.rxandroidble.internal.operations;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import bleshadow.javax.inject.Named;
import com.polidea.rxandroidble.exceptions.BleGattOperationType;
import com.polidea.rxandroidble.internal.SingleResponseOperation;
import com.polidea.rxandroidble.internal.connection.RxBleGattCallback;
import com.polidea.rxandroidble.internal.util.ByteAssociation;
import java.util.UUID;
import p033rx.Observable;
import p033rx.functions.Func1;

public class CharacteristicWriteOperation extends SingleResponseOperation<byte[]> {
    /* access modifiers changed from: private */
    public final BluetoothGattCharacteristic bluetoothGattCharacteristic;
    private final byte[] data;

    CharacteristicWriteOperation(RxBleGattCallback rxBleGattCallback, BluetoothGatt bluetoothGatt, @Named("operation-timeout") TimeoutConfiguration timeoutConfiguration, BluetoothGattCharacteristic bluetoothGattCharacteristic2, byte[] bArr) {
        super(bluetoothGatt, rxBleGattCallback, BleGattOperationType.CHARACTERISTIC_WRITE, timeoutConfiguration);
        this.bluetoothGattCharacteristic = bluetoothGattCharacteristic2;
        this.data = bArr;
    }

    /* access modifiers changed from: protected */
    public Observable<byte[]> getCallback(RxBleGattCallback rxBleGattCallback) {
        return rxBleGattCallback.getOnCharacteristicWrite().filter(new Func1<ByteAssociation<UUID>, Boolean>() {
            public Boolean call(ByteAssociation<UUID> byteAssociation) {
                return Boolean.valueOf(((UUID) byteAssociation.first).equals(CharacteristicWriteOperation.this.bluetoothGattCharacteristic.getUuid()));
            }
        }).map(new Func1<ByteAssociation<UUID>, byte[]>() {
            public byte[] call(ByteAssociation<UUID> byteAssociation) {
                return byteAssociation.second;
            }
        });
    }

    /* access modifiers changed from: protected */
    public boolean startOperation(BluetoothGatt bluetoothGatt) {
        this.bluetoothGattCharacteristic.setValue(this.data);
        return bluetoothGatt.writeCharacteristic(this.bluetoothGattCharacteristic);
    }
}