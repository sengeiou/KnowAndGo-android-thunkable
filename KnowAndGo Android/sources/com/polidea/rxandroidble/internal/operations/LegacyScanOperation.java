package com.polidea.rxandroidble.internal.operations;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import com.polidea.rxandroidble.internal.scan.RxBleInternalScanResultLegacy;
import com.polidea.rxandroidble.internal.util.RxBleAdapterWrapper;
import com.polidea.rxandroidble.internal.util.UUIDUtil;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import p033rx.Emitter;

public class LegacyScanOperation extends ScanOperation<RxBleInternalScanResultLegacy, BluetoothAdapter.LeScanCallback> {
    /* access modifiers changed from: private */
    public final Set<UUID> filterUuids;
    /* access modifiers changed from: private */
    public final boolean isFilterDefined;
    /* access modifiers changed from: private */
    public final UUIDUtil uuidUtil;

    public LegacyScanOperation(UUID[] uuidArr, RxBleAdapterWrapper rxBleAdapterWrapper, UUIDUtil uUIDUtil) {
        super(rxBleAdapterWrapper);
        this.isFilterDefined = uuidArr != null && uuidArr.length > 0;
        this.uuidUtil = uUIDUtil;
        if (this.isFilterDefined) {
            this.filterUuids = new HashSet(uuidArr.length);
            Collections.addAll(this.filterUuids, uuidArr);
            return;
        }
        this.filterUuids = null;
    }

    /* access modifiers changed from: package-private */
    public BluetoothAdapter.LeScanCallback createScanCallback(final Emitter<RxBleInternalScanResultLegacy> emitter) {
        return new BluetoothAdapter.LeScanCallback() {
            public void onLeScan(BluetoothDevice bluetoothDevice, int i, byte[] bArr) {
                if (!LegacyScanOperation.this.isFilterDefined || LegacyScanOperation.this.uuidUtil.extractUUIDs(bArr).containsAll(LegacyScanOperation.this.filterUuids)) {
                    emitter.onNext(new RxBleInternalScanResultLegacy(bluetoothDevice, i, bArr));
                }
            }
        };
    }

    /* access modifiers changed from: package-private */
    public boolean startScan(RxBleAdapterWrapper rxBleAdapterWrapper, BluetoothAdapter.LeScanCallback leScanCallback) {
        return rxBleAdapterWrapper.startLegacyLeScan(leScanCallback);
    }

    /* access modifiers changed from: package-private */
    public void stopScan(RxBleAdapterWrapper rxBleAdapterWrapper, BluetoothAdapter.LeScanCallback leScanCallback) {
        rxBleAdapterWrapper.stopLegacyLeScan(leScanCallback);
    }
}
