package com.polidea.rxandroidble;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.polidea.rxandroidble.RxBleConnection;
import p033rx.Observable;

public interface RxBleDevice {
    @Deprecated
    Observable<RxBleConnection> establishConnection(Context context, boolean z);

    Observable<RxBleConnection> establishConnection(boolean z);

    Observable<RxBleConnection> establishConnection(boolean z, @NonNull Timeout timeout);

    BluetoothDevice getBluetoothDevice();

    RxBleConnection.RxBleConnectionState getConnectionState();

    String getMacAddress();

    @Nullable
    String getName();

    Observable<RxBleConnection.RxBleConnectionState> observeConnectionStateChanges();
}
