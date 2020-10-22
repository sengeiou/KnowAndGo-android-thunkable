package com.polidea.rxandroidble.internal.connection;

import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
class ConstantPayloadSizeLimit implements PayloadSizeLimitProvider {
    private final int limit;

    ConstantPayloadSizeLimit(int i) {
        this.limit = i;
    }

    public int getPayloadSizeLimit() {
        return this.limit;
    }
}
