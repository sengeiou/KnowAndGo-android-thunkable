package com.facebook.react.fabric;

import androidx.annotation.NonNull;
import com.facebook.react.bridge.NativeModuleCallExceptionHandler;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.modules.core.ChoreographerCompat;

public abstract class GuardedFrameCallback extends ChoreographerCompat.FrameCallback {
    @NonNull
    private final NativeModuleCallExceptionHandler mExceptionHandler;

    /* access modifiers changed from: protected */
    public abstract void doFrameGuarded(long j);

    @Deprecated
    protected GuardedFrameCallback(@NonNull ReactContext reactContext) {
        this(reactContext.getExceptionHandler());
    }

    protected GuardedFrameCallback(@NonNull NativeModuleCallExceptionHandler nativeModuleCallExceptionHandler) {
        this.mExceptionHandler = nativeModuleCallExceptionHandler;
    }

    public final void doFrame(long j) {
        try {
            doFrameGuarded(j);
        } catch (RuntimeException e) {
            this.mExceptionHandler.handleException(e);
        }
    }
}
