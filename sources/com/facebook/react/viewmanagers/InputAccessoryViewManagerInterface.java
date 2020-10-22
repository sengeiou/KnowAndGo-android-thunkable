package com.facebook.react.viewmanagers;

import android.view.View;
import androidx.annotation.Nullable;

public interface InputAccessoryViewManagerInterface<T extends View> {
    void setBackgroundColor(T t, @Nullable Integer num);
}
