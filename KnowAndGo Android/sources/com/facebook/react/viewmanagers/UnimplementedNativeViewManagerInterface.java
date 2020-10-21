package com.facebook.react.viewmanagers;

import android.view.View;
import androidx.annotation.Nullable;

public interface UnimplementedNativeViewManagerInterface<T extends View> {
    void setName(T t, @Nullable String str);
}
