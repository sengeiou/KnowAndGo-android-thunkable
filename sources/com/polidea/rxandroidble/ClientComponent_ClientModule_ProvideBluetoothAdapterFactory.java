package com.polidea.rxandroidble;

import android.bluetooth.BluetoothAdapter;
import androidx.annotation.Nullable;
import bleshadow.dagger.internal.Factory;
import com.polidea.rxandroidble.ClientComponent;

public final class ClientComponent_ClientModule_ProvideBluetoothAdapterFactory implements Factory<BluetoothAdapter> {
    private static final ClientComponent_ClientModule_ProvideBluetoothAdapterFactory INSTANCE = new ClientComponent_ClientModule_ProvideBluetoothAdapterFactory();

    @Nullable
    public BluetoothAdapter get() {
        return ClientComponent.ClientModule.provideBluetoothAdapter();
    }

    public static ClientComponent_ClientModule_ProvideBluetoothAdapterFactory create() {
        return INSTANCE;
    }

    @Nullable
    public static BluetoothAdapter proxyProvideBluetoothAdapter() {
        return ClientComponent.ClientModule.provideBluetoothAdapter();
    }
}
