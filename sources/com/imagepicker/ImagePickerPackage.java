package com.imagepicker;

import androidx.annotation.StyleRes;
import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.JavaScriptModule;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ImagePickerPackage implements ReactPackage {
    @StyleRes
    private final int dialogThemeId;

    public ImagePickerPackage() {
        this.dialogThemeId = ImagePickerModule.DEFAULT_EXPLAINING_PERMISSION_DIALIOG_THEME;
    }

    public ImagePickerPackage(@StyleRes int i) {
        this.dialogThemeId = i;
    }

    public List<NativeModule> createNativeModules(ReactApplicationContext reactApplicationContext) {
        return Arrays.asList(new NativeModule[]{new ImagePickerModule(reactApplicationContext, this.dialogThemeId)});
    }

    public List<Class<? extends JavaScriptModule>> createJSModules() {
        return Collections.emptyList();
    }

    public List<ViewManager> createViewManagers(ReactApplicationContext reactApplicationContext) {
        return Collections.emptyList();
    }
}
