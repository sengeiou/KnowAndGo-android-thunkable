package com.polidea.rxandroidble.exceptions;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.polidea.rxandroidble.utils.GattStatusParser;

public class BleDisconnectedException extends BleException {
    public static final int UNKNOWN_STATUS = -1;
    @NonNull
    public final String bluetoothDeviceAddress;
    public final int state;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static BleDisconnectedException adapterDisabled(String str) {
        return new BleDisconnectedException(new BleAdapterDisabledException(), str, -1);
    }

    @Deprecated
    public BleDisconnectedException() {
        this("", -1);
    }

    @Deprecated
    public BleDisconnectedException(Throwable th, @NonNull String str) {
        this(th, str, -1);
    }

    @Deprecated
    public BleDisconnectedException(@NonNull String str) {
        this(str, -1);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public BleDisconnectedException(Throwable th, @NonNull String str, int i) {
        super(createMessage(str, i), th);
        this.bluetoothDeviceAddress = str;
        this.state = i;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public BleDisconnectedException(@NonNull String str, int i) {
        super(createMessage(str, i));
        this.bluetoothDeviceAddress = str;
        this.state = i;
    }

    private static String createMessage(@Nullable String str, int i) {
        String gattCallbackStatusDescription = GattStatusParser.getGattCallbackStatusDescription(i);
        return "Disconnected from " + str + " with status " + i + " (" + gattCallbackStatusDescription + ")";
    }
}
