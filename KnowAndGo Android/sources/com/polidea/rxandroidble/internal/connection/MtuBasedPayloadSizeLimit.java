package com.polidea.rxandroidble.internal.connection;

import androidx.annotation.RestrictTo;
import bleshadow.javax.inject.Inject;
import bleshadow.javax.inject.Named;
import com.polidea.rxandroidble.RxBleConnection;

@ConnectionScope
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
class MtuBasedPayloadSizeLimit implements PayloadSizeLimitProvider {
    private final int gattWriteMtuOverhead;
    private final RxBleConnection rxBleConnection;

    @Inject
    MtuBasedPayloadSizeLimit(RxBleConnection rxBleConnection2, @Named("GATT_WRITE_MTU_OVERHEAD") int i) {
        this.rxBleConnection = rxBleConnection2;
        this.gattWriteMtuOverhead = i;
    }

    public int getPayloadSizeLimit() {
        return this.rxBleConnection.getMtu() - this.gattWriteMtuOverhead;
    }
}
