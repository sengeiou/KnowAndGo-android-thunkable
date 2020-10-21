package com.polidea.rxandroidble.internal.connection;

import android.bluetooth.BluetoothGattCharacteristic;
import androidx.annotation.Nullable;
import com.polidea.rxandroidble.internal.BleIllegalOperationException;

public abstract class IllegalOperationHandler {
    protected IllegalOperationMessageCreator messageCreator;

    @Nullable
    public abstract BleIllegalOperationException handleMismatchData(BluetoothGattCharacteristic bluetoothGattCharacteristic, int i);

    IllegalOperationHandler(IllegalOperationMessageCreator illegalOperationMessageCreator) {
        this.messageCreator = illegalOperationMessageCreator;
    }
}
