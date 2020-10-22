package com.polidea.rxandroidble.internal;

import androidx.annotation.RestrictTo;
import java.util.UUID;

public class BleIllegalOperationException extends RuntimeException {
    public final UUID characteristicUUID;
    public final int neededProperties;
    public final int supportedProperties;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public BleIllegalOperationException(String str, UUID uuid, int i, int i2) {
        super(str);
        this.characteristicUUID = uuid;
        this.supportedProperties = i;
        this.neededProperties = i2;
    }
}
