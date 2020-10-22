package com.polidea.rxandroidble.internal.scan;

import androidx.annotation.Nullable;
import com.polidea.rxandroidble.scan.ScanFilter;

public class EmulatedScanFilterMatcher {
    @Nullable
    private final ScanFilter[] scanFilters;

    public EmulatedScanFilterMatcher(@Nullable ScanFilter... scanFilterArr) {
        this.scanFilters = scanFilterArr;
    }

    public boolean matches(RxBleInternalScanResult rxBleInternalScanResult) {
        if (this.scanFilters == null || this.scanFilters.length == 0) {
            return true;
        }
        for (ScanFilter matches : this.scanFilters) {
            if (matches.matches(rxBleInternalScanResult)) {
                return true;
            }
        }
        return false;
    }
}
