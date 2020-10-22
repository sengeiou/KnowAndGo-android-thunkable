package com.polidea.rxandroidble.internal.scan;

import androidx.annotation.RestrictTo;
import bleshadow.javax.inject.Inject;
import com.polidea.rxandroidble.internal.RxBleDeviceProvider;
import com.polidea.rxandroidble.scan.ScanResult;
import p033rx.functions.Func1;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class InternalToExternalScanResultConverter implements Func1<RxBleInternalScanResult, ScanResult> {
    private final RxBleDeviceProvider deviceProvider;

    @Inject
    public InternalToExternalScanResultConverter(RxBleDeviceProvider rxBleDeviceProvider) {
        this.deviceProvider = rxBleDeviceProvider;
    }

    public ScanResult call(RxBleInternalScanResult rxBleInternalScanResult) {
        return new ScanResult(this.deviceProvider.getBleDevice(rxBleInternalScanResult.getBluetoothDevice().getAddress()), rxBleInternalScanResult.getRssi(), rxBleInternalScanResult.getTimestampNanos(), rxBleInternalScanResult.getScanCallbackType(), rxBleInternalScanResult.getScanRecord());
    }
}
