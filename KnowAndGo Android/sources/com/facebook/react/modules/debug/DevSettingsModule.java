package com.facebook.react.modules.debug;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.devsupport.interfaces.DevOptionHandler;
import com.facebook.react.devsupport.interfaces.DevSupportManager;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.onesignal.OneSignalDbContract;

@ReactModule(name = "DevSettings")
public class DevSettingsModule extends ReactContextBaseJavaModule {
    public static final String NAME = "DevSettings";
    /* access modifiers changed from: private */
    public final DevSupportManager mDevSupportManager;

    public String getName() {
        return NAME;
    }

    @ReactMethod
    public void onFastRefresh() {
    }

    public DevSettingsModule(ReactApplicationContext reactApplicationContext, DevSupportManager devSupportManager) {
        super(reactApplicationContext);
        this.mDevSupportManager = devSupportManager;
    }

    @ReactMethod
    public void reload() {
        if (this.mDevSupportManager.getDevSupportEnabled()) {
            UiThreadUtil.runOnUiThread(new Runnable() {
                public void run() {
                    DevSettingsModule.this.mDevSupportManager.handleReloadJS();
                }
            });
        }
    }

    @ReactMethod
    public void reloadWithReason(String str) {
        reload();
    }

    @ReactMethod
    public void setHotLoadingEnabled(boolean z) {
        this.mDevSupportManager.setHotModuleReplacementEnabled(z);
    }

    @ReactMethod
    public void setIsDebuggingRemotely(boolean z) {
        this.mDevSupportManager.setRemoteJSDebugEnabled(z);
    }

    @ReactMethod
    public void setProfilingEnabled(boolean z) {
        this.mDevSupportManager.setFpsDebugEnabled(z);
    }

    @ReactMethod
    public void toggleElementInspector() {
        this.mDevSupportManager.toggleElementInspector();
    }

    @ReactMethod
    public void addMenuItem(final String str) {
        this.mDevSupportManager.addCustomDevOption(str, new DevOptionHandler() {
            public void onOptionSelected() {
                WritableMap createMap = Arguments.createMap();
                createMap.putString(OneSignalDbContract.NotificationTable.COLUMN_NAME_TITLE, str);
                ReactApplicationContext access$100 = DevSettingsModule.this.getReactApplicationContextIfActiveOrWarn();
                if (access$100 != null) {
                    ((DeviceEventManagerModule.RCTDeviceEventEmitter) access$100.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("didPressMenuItem", createMap);
                }
            }
        });
    }
}
