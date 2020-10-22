package com.polidea.rxandroidble.internal.connection;

import android.bluetooth.BluetoothGatt;
import androidx.annotation.NonNull;
import bleshadow.javax.inject.Inject;
import java.util.concurrent.atomic.AtomicReference;

@ConnectionScope
public class BluetoothGattProvider {
    private final AtomicReference<BluetoothGatt> reference = new AtomicReference<>();

    @Inject
    BluetoothGattProvider() {
    }

    public BluetoothGatt getBluetoothGatt() {
        return this.reference.get();
    }

    public void updateBluetoothGatt(@NonNull BluetoothGatt bluetoothGatt) {
        this.reference.compareAndSet((Object) null, bluetoothGatt);
    }
}
