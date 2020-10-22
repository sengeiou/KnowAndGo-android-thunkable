package com.facebook.react.viewmanagers;

import android.view.View;
import androidx.annotation.Nullable;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.BaseViewManagerInterface;
import com.facebook.react.viewmanagers.InputAccessoryViewManagerInterface;

public class InputAccessoryViewManagerDelegate<T extends View, U extends BaseViewManagerInterface<T> & InputAccessoryViewManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    public InputAccessoryViewManagerDelegate(U u) {
        super(u);
    }

    public void setProperty(T t, String str, @Nullable Object obj) {
        if (((str.hashCode() == 1287124693 && str.equals("backgroundColor")) ? (char) 0 : 65535) != 0) {
            super.setProperty(t, str, obj);
        } else {
            ((InputAccessoryViewManagerInterface) this.mViewManager).setBackgroundColor(t, obj == null ? null : Integer.valueOf(((Double) obj).intValue()));
        }
    }
}
