package com.polidea.multiplatformbleadapter.utils;

import androidx.annotation.Nullable;
import com.polidea.multiplatformbleadapter.OnErrorCallback;
import com.polidea.multiplatformbleadapter.OnSuccessCallback;
import com.polidea.multiplatformbleadapter.errors.BleError;
import java.util.concurrent.atomic.AtomicBoolean;

public class SafeExecutor<T> {
    private OnErrorCallback errorCallback;
    private OnSuccessCallback<T> successCallback;
    private AtomicBoolean wasExecuted = new AtomicBoolean(false);

    public SafeExecutor(@Nullable OnSuccessCallback<T> onSuccessCallback, @Nullable OnErrorCallback onErrorCallback) {
        this.successCallback = onSuccessCallback;
        this.errorCallback = onErrorCallback;
    }

    public void success(T t) {
        if (this.wasExecuted.compareAndSet(false, true)) {
            this.successCallback.onSuccess(t);
        }
    }

    public void error(BleError bleError) {
        if (this.wasExecuted.compareAndSet(false, true)) {
            this.errorCallback.onError(bleError);
        }
    }
}
