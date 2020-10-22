package com.facebook.react.views.picker;

import android.content.Context;
import android.view.View;
import androidx.annotation.Nullable;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewManagerDelegate;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.viewmanagers.AndroidDialogPickerManagerDelegate;
import com.facebook.react.viewmanagers.AndroidDialogPickerManagerInterface;

@ReactModule(name = "AndroidDialogPicker")
public class ReactDialogPickerManager extends ReactPickerManager implements AndroidDialogPickerManagerInterface<ReactPicker> {
    public static final String REACT_CLASS = "AndroidDialogPicker";
    private final ViewManagerDelegate<ReactPicker> mDelegate = new AndroidDialogPickerManagerDelegate(this);

    public String getName() {
        return REACT_CLASS;
    }

    @ReactProp(customType = "Color", name = "color")
    public /* bridge */ /* synthetic */ void setColor(View view, @Nullable Integer num) {
        super.setColor((ReactPicker) view, num);
    }

    @ReactProp(defaultBoolean = true, name = "enabled")
    public /* bridge */ /* synthetic */ void setEnabled(View view, boolean z) {
        super.setEnabled((ReactPicker) view, z);
    }

    @ReactProp(name = "items")
    public /* bridge */ /* synthetic */ void setItems(View view, @Nullable ReadableArray readableArray) {
        super.setItems((ReactPicker) view, readableArray);
    }

    @ReactProp(name = "prompt")
    public /* bridge */ /* synthetic */ void setPrompt(View view, @Nullable String str) {
        super.setPrompt((ReactPicker) view, str);
    }

    @ReactProp(name = "selected")
    public /* bridge */ /* synthetic */ void setSelected(View view, int i) {
        super.setSelected((ReactPicker) view, i);
    }

    /* access modifiers changed from: protected */
    public ReactPicker createViewInstance(ThemedReactContext themedReactContext) {
        return new ReactPicker((Context) themedReactContext, 0);
    }

    /* access modifiers changed from: protected */
    public ViewManagerDelegate<ReactPicker> getDelegate() {
        return this.mDelegate;
    }
}