package com.polidea.rxandroidble.internal.operations;

import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanResult;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.polidea.rxandroidble.exceptions.BleScanException;
import com.polidea.rxandroidble.internal.RxBleLog;
import com.polidea.rxandroidble.internal.scan.AndroidScanObjectsConverter;
import com.polidea.rxandroidble.internal.scan.EmulatedScanFilterMatcher;
import com.polidea.rxandroidble.internal.scan.InternalScanResultCreator;
import com.polidea.rxandroidble.internal.scan.RxBleInternalScanResult;
import com.polidea.rxandroidble.internal.util.RxBleAdapterWrapper;
import com.polidea.rxandroidble.scan.ScanFilter;
import com.polidea.rxandroidble.scan.ScanSettings;
import java.util.List;
import p033rx.Emitter;

@RequiresApi(api = 21)
public class ScanOperationApi21 extends ScanOperation<RxBleInternalScanResult, ScanCallback> {
    @NonNull
    private final AndroidScanObjectsConverter androidScanObjectsConverter;
    /* access modifiers changed from: private */
    @NonNull
    public final EmulatedScanFilterMatcher emulatedScanFilterMatcher;
    /* access modifiers changed from: private */
    @NonNull
    public final InternalScanResultCreator internalScanResultCreator;
    @Nullable
    private final ScanFilter[] scanFilters;
    @NonNull
    private final ScanSettings scanSettings;

    public ScanOperationApi21(@NonNull RxBleAdapterWrapper rxBleAdapterWrapper, @NonNull InternalScanResultCreator internalScanResultCreator2, @NonNull AndroidScanObjectsConverter androidScanObjectsConverter2, @NonNull ScanSettings scanSettings2, @NonNull EmulatedScanFilterMatcher emulatedScanFilterMatcher2, @Nullable ScanFilter[] scanFilterArr) {
        super(rxBleAdapterWrapper);
        this.internalScanResultCreator = internalScanResultCreator2;
        this.scanSettings = scanSettings2;
        this.emulatedScanFilterMatcher = emulatedScanFilterMatcher2;
        this.scanFilters = scanFilterArr;
        this.androidScanObjectsConverter = androidScanObjectsConverter2;
    }

    /* access modifiers changed from: package-private */
    public ScanCallback createScanCallback(final Emitter<RxBleInternalScanResult> emitter) {
        return new ScanCallback() {
            public void onScanResult(int i, ScanResult scanResult) {
                RxBleInternalScanResult create = ScanOperationApi21.this.internalScanResultCreator.create(i, scanResult);
                if (ScanOperationApi21.this.emulatedScanFilterMatcher.matches(create)) {
                    emitter.onNext(create);
                }
            }

            public void onBatchScanResults(List<ScanResult> list) {
                for (ScanResult create : list) {
                    RxBleInternalScanResult create2 = ScanOperationApi21.this.internalScanResultCreator.create(create);
                    if (ScanOperationApi21.this.emulatedScanFilterMatcher.matches(create2)) {
                        emitter.onNext(create2);
                    }
                }
            }

            public void onScanFailed(int i) {
                emitter.onError(new BleScanException(ScanOperationApi21.errorCodeToBleErrorCode(i)));
            }
        };
    }

    /* access modifiers changed from: package-private */
    public boolean startScan(RxBleAdapterWrapper rxBleAdapterWrapper, ScanCallback scanCallback) {
        rxBleAdapterWrapper.startLeScan(this.androidScanObjectsConverter.toNativeFilters(this.scanFilters), this.androidScanObjectsConverter.toNativeSettings(this.scanSettings), scanCallback);
        return true;
    }

    /* access modifiers changed from: package-private */
    public void stopScan(RxBleAdapterWrapper rxBleAdapterWrapper, ScanCallback scanCallback) {
        rxBleAdapterWrapper.stopLeScan(scanCallback);
    }

    /* access modifiers changed from: private */
    public static int errorCodeToBleErrorCode(int i) {
        switch (i) {
            case 1:
                return 5;
            case 2:
                return 6;
            case 3:
                return 7;
            case 4:
                return 8;
            case 5:
                return 9;
            default:
                RxBleLog.m1092w("Encountered unknown scanning error code: %d -> check android.bluetooth.le.ScanCallback", new Object[0]);
                return Integer.MAX_VALUE;
        }
    }
}
