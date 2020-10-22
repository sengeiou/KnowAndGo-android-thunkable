package com.facebook.react.uimanager;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;

public abstract class BaseViewManagerAdapter<T extends View> implements BaseViewManagerInterface<T> {
    public void setAccessibilityActions(@NonNull T t, ReadableArray readableArray) {
    }

    public void setAccessibilityHint(@NonNull T t, String str) {
    }

    public void setAccessibilityLabel(@NonNull T t, String str) {
    }

    public void setAccessibilityLiveRegion(@NonNull T t, @Nullable String str) {
    }

    public void setAccessibilityRole(@NonNull T t, @Nullable String str) {
    }

    public void setBackgroundColor(@NonNull T t, int i) {
    }

    public void setBorderBottomLeftRadius(@NonNull T t, float f) {
    }

    public void setBorderBottomRightRadius(@NonNull T t, float f) {
    }

    public void setBorderRadius(@NonNull T t, float f) {
    }

    public void setBorderTopLeftRadius(@NonNull T t, float f) {
    }

    public void setBorderTopRightRadius(@NonNull T t, float f) {
    }

    public void setElevation(@NonNull T t, float f) {
    }

    public void setImportantForAccessibility(@NonNull T t, @Nullable String str) {
    }

    public void setNativeId(@NonNull T t, String str) {
    }

    public void setOpacity(@NonNull T t, float f) {
    }

    public void setRenderToHardwareTexture(@NonNull T t, boolean z) {
    }

    public void setRotation(@NonNull T t, float f) {
    }

    public void setScaleX(@NonNull T t, float f) {
    }

    public void setScaleY(@NonNull T t, float f) {
    }

    public void setTestId(@NonNull T t, String str) {
    }

    public void setTransform(@NonNull T t, @Nullable ReadableArray readableArray) {
    }

    public void setTranslateX(@NonNull T t, float f) {
    }

    public void setTranslateY(@NonNull T t, float f) {
    }

    public void setViewState(@NonNull T t, @Nullable ReadableMap readableMap) {
    }

    public void setZIndex(@NonNull T t, float f) {
    }
}
