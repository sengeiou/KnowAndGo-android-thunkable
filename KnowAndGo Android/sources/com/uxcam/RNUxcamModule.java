package com.uxcam;

import android.view.View;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.facebook.react.uimanager.NativeViewHierarchyManager;
import com.facebook.react.uimanager.UIBlock;
import com.facebook.react.uimanager.UIManagerModule;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class RNUxcamModule extends ReactContextBaseJavaModule {
    private static final String PARAM_ERROR_MESSAGE_KEY = "error";
    private static final String PARAM_SUCCESS_KEY = "success";
    private static final String UXCAM_PLUGIN_TYPE = "react-native";
    private static final String UXCAM_REACT_PLUGIN_VERSION = "5.2.0";
    private static final String UXCAM_VERIFICATION_EVENT_KEY = "UXCam_Verification_Event";
    /* access modifiers changed from: private */
    public final ReactApplicationContext reactContext;

    public String getName() {
        return "RNUxcam";
    }

    public RNUxcamModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.reactContext = reactApplicationContext;
        UXCam.addVerificationListener(new OnVerificationListener() {
            public void onVerificationSuccess() {
                WritableMap createMap = Arguments.createMap();
                createMap.putBoolean(RNUxcamModule.PARAM_SUCCESS_KEY, true);
                RNUxcamModule.this.sendEvent(RNUxcamModule.this.reactContext, RNUxcamModule.UXCAM_VERIFICATION_EVENT_KEY, createMap);
            }

            public void onVerificationFailed(String str) {
                WritableMap createMap = Arguments.createMap();
                createMap.putBoolean(RNUxcamModule.PARAM_SUCCESS_KEY, false);
                createMap.putString(RNUxcamModule.PARAM_ERROR_MESSAGE_KEY, str);
                RNUxcamModule.this.sendEvent(RNUxcamModule.this.reactContext, RNUxcamModule.UXCAM_VERIFICATION_EVENT_KEY, createMap);
            }
        });
    }

    /* access modifiers changed from: private */
    public void sendEvent(ReactContext reactContext2, String str, WritableMap writableMap) {
        ((DeviceEventManagerModule.RCTDeviceEventEmitter) reactContext2.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit(str, writableMap);
    }

    @ReactMethod
    public void startWithKey(String str) {
        UXCam.pluginType(UXCAM_PLUGIN_TYPE, UXCAM_REACT_PLUGIN_VERSION);
        UXCam.startApplicationWithKeyForCordova(getCurrentActivity(), str);
    }

    @ReactMethod
    public void startNewSession() {
        UXCam.startNewSession();
    }

    @ReactMethod
    public void stopSessionAndUploadData() {
        UXCam.stopSessionAndUploadData();
    }

    @ReactMethod
    public void occludeSensitiveScreen(boolean z) {
        UXCam.occludeSensitiveScreen(z, false);
    }

    @ReactMethod
    public void occludeSensitiveScreen(boolean z, boolean z2) {
        UXCam.occludeSensitiveScreen(z, z2);
    }

    @ReactMethod
    public void occludeAllTextFields(boolean z) {
        UXCam.occludeAllTextFields(z);
    }

    @ReactMethod
    public void tagScreenName(String str) {
        UXCam.tagScreenName(str);
    }

    @ReactMethod
    public void setAutomaticScreenNameTagging(boolean z) {
        UXCam.setAutomaticScreenNameTagging(z);
    }

    @ReactMethod
    public void addScreenNameToIgnore(String str) {
        UXCam.addScreenNameToIgnore(str);
    }

    @ReactMethod
    public void addScreenNamesToIgnore(ReadableArray readableArray) {
        Iterator<Object> it = readableArray.toArrayList().iterator();
        while (it.hasNext()) {
            UXCam.addScreenNameToIgnore(it.next().toString());
        }
    }

    @ReactMethod
    public void removeScreenNameToIgnore(String str) {
        UXCam.removeScreenNameToIgnore(str);
    }

    @ReactMethod
    public void removeScreenNamesToIgnore(ReadableArray readableArray) {
        Iterator<Object> it = readableArray.toArrayList().iterator();
        while (it.hasNext()) {
            UXCam.removeScreenNameToIgnore(it.next().toString());
        }
    }

    @ReactMethod
    public void removeAllScreenNamesToIgnore() {
        UXCam.removeAllScreenNamesToIgnore();
    }

    @ReactMethod
    public void screenNamesBeingIgnored(Promise promise) {
        List<String> screenNamesBeingIgnored = UXCam.screenNamesBeingIgnored();
        WritableArray createArray = Arguments.createArray();
        for (String pushString : screenNamesBeingIgnored) {
            createArray.pushString(pushString);
        }
        promise.resolve(createArray);
    }

    @ReactMethod
    public void setUserIdentity(String str) {
        UXCam.setUserIdentity(str);
    }

    @ReactMethod
    public void setUserProperty(String str, String str2) {
        UXCam.setUserProperty(str, str2);
    }

    @ReactMethod
    public void setSessionProperty(String str, String str2) {
        UXCam.setSessionProperty(str, str2);
    }

    @ReactMethod
    public void logEvent(String str) {
        UXCam.logEvent(str);
    }

    @ReactMethod
    public void logEvent(String str, ReadableMap readableMap) {
        if (readableMap != null) {
            HashMap hashMap = new HashMap();
            ReadableMapKeySetIterator keySetIterator = readableMap.keySetIterator();
            while (keySetIterator.hasNextKey()) {
                String nextKey = keySetIterator.nextKey();
                ReadableType type = readableMap.getType(nextKey);
                if (type == ReadableType.Boolean) {
                    hashMap.put(nextKey, Boolean.valueOf(readableMap.getBoolean(nextKey)));
                } else if (type == ReadableType.Number) {
                    hashMap.put(nextKey, Double.valueOf(readableMap.getDouble(nextKey)));
                } else {
                    hashMap.put(nextKey, readableMap.getString(nextKey));
                }
            }
            UXCam.logEvent(str, (Map) hashMap);
            return;
        }
        UXCam.logEvent(str);
    }

    @ReactMethod
    public void addVerificationListener(final Promise promise) {
        UXCam.addVerificationListener(new OnVerificationListener() {
            public void onVerificationSuccess() {
                promise.resolve(RNUxcamModule.PARAM_SUCCESS_KEY);
            }

            public void onVerificationFailed(String str) {
                promise.reject("failed", str, new Throwable(str));
            }
        });
    }

    @ReactMethod
    public void urlForCurrentSession(Promise promise) {
        promise.resolve(UXCam.urlForCurrentSession());
    }

    @ReactMethod
    public void urlForCurrentUser(Promise promise) {
        promise.resolve(UXCam.urlForCurrentUser());
    }

    @ReactMethod
    public void isRecording(Promise promise) {
        promise.resolve(Boolean.valueOf(UXCam.isRecording()));
    }

    @ReactMethod
    public void pauseScreenRecording() {
        UXCam.pauseScreenRecording();
    }

    @ReactMethod
    public void resumeScreenRecording() {
        UXCam.resumeScreenRecording();
    }

    @ReactMethod
    public void optInOverall() {
        UXCam.optIn();
    }

    @ReactMethod
    public void optOutOverall() {
        UXCam.optOut();
    }

    @ReactMethod
    public void optInOverallStatus(Promise promise) {
        promise.resolve(Boolean.valueOf(UXCam.optStatus()));
    }

    @ReactMethod
    public void optIntoVideoRecording() {
        UXCam.optIntoVideoRecording();
    }

    @ReactMethod
    public void optOutOfVideoRecording() {
        UXCam.optOutOfVideoRecording();
    }

    @ReactMethod
    public void optInVideoRecordingStatus(Promise promise) {
        promise.resolve(Boolean.valueOf(UXCam.optInVideoRecordingStatus()));
    }

    @ReactMethod
    public void cancelCurrentSession() {
        UXCam.cancelCurrentSession();
    }

    @ReactMethod
    public void allowShortBreakForAnotherApp(boolean z) {
        UXCam.allowShortBreakForAnotherApp(z);
    }

    @ReactMethod
    public void allowShortBreakForAnotherAppInMillis(int i) {
        UXCam.allowShortBreakForAnotherApp(i);
    }

    @ReactMethod
    public void getMultiSessionRecord(Promise promise) {
        promise.resolve(Boolean.valueOf(UXCam.getMultiSessionRecord()));
    }

    @ReactMethod
    public void setMultiSessionRecord(boolean z) {
        UXCam.setMultiSessionRecord(z);
    }

    @ReactMethod
    public void deletePendingUploads() {
        UXCam.deletePendingUploads();
    }

    @ReactMethod
    public void pendingSessionCount(Promise promise) {
        promise.resolve(Integer.valueOf(UXCam.pendingSessionCount()));
    }

    @ReactMethod
    public void occludeSensitiveView(final int i) {
        ((UIManagerModule) getReactApplicationContext().getNativeModule(UIManagerModule.class)).addUIBlock(new UIBlock() {
            public void execute(NativeViewHierarchyManager nativeViewHierarchyManager) {
                try {
                    View resolveView = nativeViewHierarchyManager.resolveView(i);
                    if (resolveView != null) {
                        UXCam.occludeSensitiveView(resolveView);
                    }
                } catch (Exception unused) {
                }
            }
        });
    }

    @ReactMethod
    public void unOccludeSensitiveView(final int i) {
        ((UIManagerModule) getReactApplicationContext().getNativeModule(UIManagerModule.class)).addUIBlock(new UIBlock() {
            public void execute(NativeViewHierarchyManager nativeViewHierarchyManager) {
                try {
                    View resolveView = nativeViewHierarchyManager.resolveView(i);
                    if (resolveView != null) {
                        UXCam.unOccludeSensitiveView(resolveView);
                    }
                } catch (Exception unused) {
                }
            }
        });
    }

    @ReactMethod
    public void occludeSensitiveViewWithoutGesture(final int i) {
        ((UIManagerModule) getReactApplicationContext().getNativeModule(UIManagerModule.class)).addUIBlock(new UIBlock() {
            public void execute(NativeViewHierarchyManager nativeViewHierarchyManager) {
                try {
                    View resolveView = nativeViewHierarchyManager.resolveView(i);
                    if (resolveView != null) {
                        UXCam.occludeSensitiveViewWithoutGesture(resolveView);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
