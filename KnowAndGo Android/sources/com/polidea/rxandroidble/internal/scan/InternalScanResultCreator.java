package com.polidea.rxandroidble.internal.scan;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.le.ScanResult;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import bleshadow.javax.inject.Inject;
import com.polidea.rxandroidble.ClientScope;
import com.polidea.rxandroidble.internal.RxBleLog;
import com.polidea.rxandroidble.internal.util.UUIDUtil;
import com.polidea.rxandroidble.scan.ScanCallbackType;

@ClientScope
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class InternalScanResultCreator {
    private final UUIDUtil uuidUtil;

    @Inject
    public InternalScanResultCreator(UUIDUtil uUIDUtil) {
        this.uuidUtil = uUIDUtil;
    }

    public RxBleInternalScanResult create(BluetoothDevice bluetoothDevice, int i, byte[] bArr) {
        return new RxBleInternalScanResult(bluetoothDevice, i, System.nanoTime(), this.uuidUtil.parseFromBytes(bArr), ScanCallbackType.CALLBACK_TYPE_UNSPECIFIED);
    }

    @RequiresApi(api = 21)
    public RxBleInternalScanResult create(ScanResult scanResult) {
        return new RxBleInternalScanResult(scanResult.getDevice(), scanResult.getRssi(), scanResult.getTimestampNanos(), new ScanRecordImplNativeWrapper(scanResult.getScanRecord()), ScanCallbackType.CALLBACK_TYPE_BATCH);
    }

    @RequiresApi(api = 21)
    public RxBleInternalScanResult create(int i, ScanResult scanResult) {
        return new RxBleInternalScanResult(scanResult.getDevice(), scanResult.getRssi(), scanResult.getTimestampNanos(), new ScanRecordImplNativeWrapper(scanResult.getScanRecord()), toScanCallbackType(i));
    }

    @RequiresApi(21)
    private static ScanCallbackType toScanCallbackType(int i) {
        if (i == 4) {
            return ScanCallbackType.CALLBACK_TYPE_MATCH_LOST;
        }
        switch (i) {
            case 1:
                return ScanCallbackType.CALLBACK_TYPE_ALL_MATCHES;
            case 2:
                return ScanCallbackType.CALLBACK_TYPE_FIRST_MATCH;
            default:
                RxBleLog.m1092w("Unknown callback type %d -> check android.bluetooth.le.ScanSettings", new Object[0]);
                return ScanCallbackType.CALLBACK_TYPE_UNKNOWN;
        }
    }
}
