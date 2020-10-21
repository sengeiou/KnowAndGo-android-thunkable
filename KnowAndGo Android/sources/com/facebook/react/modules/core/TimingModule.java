package com.facebook.react.modules.core;

import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.devsupport.interfaces.DevSupportManager;
import com.facebook.react.jstasks.HeadlessJsTaskContext;
import com.facebook.react.jstasks.HeadlessJsTaskEventListener;
import com.facebook.react.module.annotations.ReactModule;

@ReactModule(name = "Timing")
public final class TimingModule extends ReactContextBaseJavaModule implements LifecycleEventListener, HeadlessJsTaskEventListener {
    public static final String NAME = "Timing";
    private final JavaTimerManager mJavaTimerManager;

    public String getName() {
        return NAME;
    }

    public class BridgeTimerManager implements JavaScriptTimerManager {
        public BridgeTimerManager() {
        }

        public void callTimers(WritableArray writableArray) {
            ReactApplicationContext access$000 = TimingModule.this.getReactApplicationContextIfActiveOrWarn();
            if (access$000 != null) {
                ((JSTimers) access$000.getJSModule(JSTimers.class)).callTimers(writableArray);
            }
        }

        public void callIdleCallbacks(double d) {
            ReactApplicationContext access$100 = TimingModule.this.getReactApplicationContextIfActiveOrWarn();
            if (access$100 != null) {
                ((JSTimers) access$100.getJSModule(JSTimers.class)).callIdleCallbacks(d);
            }
        }

        public void emitTimeDriftWarning(String str) {
            ReactApplicationContext access$200 = TimingModule.this.getReactApplicationContextIfActiveOrWarn();
            if (access$200 != null) {
                ((JSTimers) access$200.getJSModule(JSTimers.class)).emitTimeDriftWarning(str);
            }
        }
    }

    public TimingModule(ReactApplicationContext reactApplicationContext, DevSupportManager devSupportManager) {
        super(reactApplicationContext);
        this.mJavaTimerManager = new JavaTimerManager(reactApplicationContext, new BridgeTimerManager(), ReactChoreographer.getInstance(), devSupportManager);
    }

    public void initialize() {
        getReactApplicationContext().addLifecycleEventListener(this);
        HeadlessJsTaskContext.getInstance(getReactApplicationContext()).addTaskEventListener(this);
    }

    @ReactMethod
    public void createTimer(int i, int i2, double d, boolean z) {
        this.mJavaTimerManager.createAndMaybeCallTimer(i, i2, d, z);
    }

    @ReactMethod
    public void deleteTimer(int i) {
        this.mJavaTimerManager.deleteTimer(i);
    }

    @ReactMethod
    public void setSendIdleEvents(boolean z) {
        this.mJavaTimerManager.setSendIdleEvents(z);
    }

    public void onHostResume() {
        this.mJavaTimerManager.onHostResume();
    }

    public void onHostPause() {
        this.mJavaTimerManager.onHostPause();
    }

    public void onHostDestroy() {
        this.mJavaTimerManager.onHostDestroy();
    }

    public void onHeadlessJsTaskStart(int i) {
        this.mJavaTimerManager.onHeadlessJsTaskStart(i);
    }

    public void onHeadlessJsTaskFinish(int i) {
        this.mJavaTimerManager.onHeadlessJsTaskFinish(i);
    }

    public void onCatalystInstanceDestroy() {
        HeadlessJsTaskContext.getInstance(getReactApplicationContext()).removeTaskEventListener(this);
        this.mJavaTimerManager.onInstanceDestroy();
    }
}
