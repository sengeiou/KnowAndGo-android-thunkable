package com.facebook.react.uimanager;

import androidx.annotation.Nullable;
import com.facebook.react.bridge.CatalystInstance;
import com.facebook.react.bridge.JSIModuleType;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactSoftException;
import com.facebook.react.bridge.UIManager;
import com.facebook.react.uimanager.common.ViewUtil;

public class UIManagerHelper {
    @Nullable
    public static UIManager getUIManagerForReactTag(ReactContext reactContext, int i) {
        return getUIManager(reactContext, ViewUtil.getUIManagerType(i));
    }

    @Nullable
    public static UIManager getUIManager(ReactContext reactContext, int i) {
        if (!reactContext.hasActiveCatalystInstance()) {
            ReactSoftException.logSoftException("UIManagerHelper", new RuntimeException("Cannot get UIManager: no active Catalyst instance"));
            return null;
        }
        CatalystInstance catalystInstance = reactContext.getCatalystInstance();
        if (i == 2) {
            return (UIManager) catalystInstance.getJSIModule(JSIModuleType.UIManager);
        }
        return (UIManager) catalystInstance.getNativeModule(UIManagerModule.class);
    }
}
