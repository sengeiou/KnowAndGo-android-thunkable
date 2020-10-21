package p024io.expo.appearance;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.common.ReactConstants;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import java.util.HashMap;
import java.util.Map;

/* renamed from: io.expo.appearance.RNCAppearanceModule */
public class RNCAppearanceModule extends ReactContextBaseJavaModule implements LifecycleEventListener {
    public static final String REACT_CLASS = "RNCAppearance";
    private BroadcastReceiver mBroadcastReceiver = null;

    @NonNull
    public String getName() {
        return REACT_CLASS;
    }

    public void onHostDestroy() {
    }

    public RNCAppearanceModule(@NonNull final ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        if (Build.VERSION.SDK_INT > 28) {
            this.mBroadcastReceiver = new BroadcastReceiver() {
                public void onReceive(Context context, Intent intent) {
                    Configuration configuration = (Configuration) intent.getParcelableExtra("newConfig");
                    RNCAppearanceModule.this.sendEvent(reactApplicationContext, "appearanceChanged", RNCAppearanceModule.this.getPreferences());
                }
            };
            reactApplicationContext.addLifecycleEventListener(this);
        }
    }

    /* access modifiers changed from: protected */
    public String getColorScheme(Configuration configuration) {
        if (Build.VERSION.SDK_INT <= 28) {
            return "no-preference";
        }
        int i = configuration.uiMode & 48;
        if (i == 0 || i == 16) {
            return "light";
        }
        if (i != 32) {
            return "no-preference";
        }
        return "dark";
    }

    /* access modifiers changed from: private */
    public WritableMap getPreferences() {
        WritableMap createMap = Arguments.createMap();
        createMap.putString("colorScheme", getColorScheme(getReactApplicationContext().getResources().getConfiguration()));
        return createMap;
    }

    @Nullable
    public Map<String, Object> getConstants() {
        HashMap hashMap = new HashMap();
        hashMap.put("initialPreferences", getPreferences());
        return hashMap;
    }

    /* access modifiers changed from: private */
    public void sendEvent(ReactContext reactContext, String str, @Nullable WritableMap writableMap) {
        if (reactContext.hasActiveCatalystInstance()) {
            FLog.m74i("sendEvent", str + ": " + writableMap.toString());
            ((DeviceEventManagerModule.RCTDeviceEventEmitter) reactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit(str, writableMap);
        }
    }

    private void sendEvent(String str, @Nullable WritableMap writableMap) {
        if (getReactApplicationContext().hasActiveCatalystInstance()) {
            FLog.m74i("sendEvent", str + ": " + writableMap.toString());
            ((DeviceEventManagerModule.RCTDeviceEventEmitter) getReactApplicationContext().getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit(str, writableMap);
        }
    }

    private void updateAndSendAppearancePreferences() {
        sendEvent("appearanceChanged", getPreferences());
    }

    public void onHostResume() {
        Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            FLog.m62e(ReactConstants.TAG, "no activity to register receiver");
            return;
        }
        currentActivity.registerReceiver(this.mBroadcastReceiver, new IntentFilter("onConfigurationChanged"));
        updateAndSendAppearancePreferences();
    }

    public void onHostPause() {
        Activity currentActivity = getCurrentActivity();
        if (currentActivity != null) {
            try {
                currentActivity.unregisterReceiver(this.mBroadcastReceiver);
            } catch (IllegalArgumentException e) {
                FLog.m63e(ReactConstants.TAG, "mBroadcastReceiver already unregistered", (Throwable) e);
            }
        }
    }
}
