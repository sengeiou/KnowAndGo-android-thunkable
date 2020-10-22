package com.facebook.react.bridge;

import android.view.View;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import com.facebook.infer.annotation.ThreadConfined;

public interface UIManager extends JSIModule, PerformanceCounter {
    @UiThread
    @ThreadConfined("UI")
    <T extends View> int addRootView(T t, WritableMap writableMap, @Nullable String str);

    void dispatchCommand(int i, int i2, @Nullable ReadableArray readableArray);

    void dispatchCommand(int i, String str, @Nullable ReadableArray readableArray);

    void sendAccessibilityEvent(int i, int i2);

    @UiThread
    @ThreadConfined("UI")
    void setAllowImmediateUIOperationExecution(boolean z);

    @UiThread
    @ThreadConfined("UI")
    void synchronouslyUpdateViewOnUIThread(int i, ReadableMap readableMap);

    @UiThread
    @ThreadConfined("UI")
    void updateRootLayoutSpecs(int i, int i2, int i3);
}
