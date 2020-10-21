package com.polidea.rxandroidble.internal.scan;

import androidx.annotation.RestrictTo;
import com.polidea.rxandroidble.internal.operations.Operation;
import p033rx.Observable;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class ScanSetup {
    public final Operation<RxBleInternalScanResult> scanOperation;
    public final Observable.Transformer<RxBleInternalScanResult, RxBleInternalScanResult> scanOperationBehaviourEmulatorTransformer;

    public ScanSetup(Operation<RxBleInternalScanResult> operation, Observable.Transformer<RxBleInternalScanResult, RxBleInternalScanResult> transformer) {
        this.scanOperation = operation;
        this.scanOperationBehaviourEmulatorTransformer = transformer;
    }
}
