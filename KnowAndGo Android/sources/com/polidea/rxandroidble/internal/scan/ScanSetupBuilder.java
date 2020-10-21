package com.polidea.rxandroidble.internal.scan;

import androidx.annotation.RestrictTo;
import com.polidea.rxandroidble.scan.ScanFilter;
import com.polidea.rxandroidble.scan.ScanSettings;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public interface ScanSetupBuilder {
    ScanSetup build(ScanSettings scanSettings, ScanFilter... scanFilterArr);
}
