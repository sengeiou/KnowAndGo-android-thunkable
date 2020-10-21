package com.facebook.react.devsupport;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.common.ReactConstants;
import com.facebook.react.devsupport.interfaces.DevSupportManager;
import com.facebook.react.module.annotations.ReactModule;

@ReactModule(name = "LogBox")
public class LogBoxModule extends ReactContextBaseJavaModule {
    public static final String NAME = "LogBox";
    /* access modifiers changed from: private */
    public final DevSupportManager mDevSupportManager;
    /* access modifiers changed from: private */
    @Nullable
    public LogBoxDialog mLogBoxDialog;
    /* access modifiers changed from: private */
    @Nullable
    public View mReactRootView;

    public String getName() {
        return NAME;
    }

    public LogBoxModule(ReactApplicationContext reactApplicationContext, DevSupportManager devSupportManager) {
        super(reactApplicationContext);
        this.mDevSupportManager = devSupportManager;
        UiThreadUtil.runOnUiThread(new Runnable() {
            public void run() {
                if (LogBoxModule.this.mReactRootView == null) {
                    View unused = LogBoxModule.this.mReactRootView = LogBoxModule.this.mDevSupportManager.createRootView(LogBoxModule.NAME);
                    if (LogBoxModule.this.mReactRootView == null) {
                        FLog.m62e(ReactConstants.TAG, "Unable to launch logbox because react was unable to create the root view");
                    }
                }
            }
        });
    }

    @ReactMethod
    public void show() {
        UiThreadUtil.runOnUiThread(new Runnable() {
            public void run() {
                if (LogBoxModule.this.mLogBoxDialog == null) {
                    Activity access$300 = LogBoxModule.this.getCurrentActivity();
                    if (access$300 == null || access$300.isFinishing()) {
                        FLog.m62e(ReactConstants.TAG, "Unable to launch logbox because react activity is not available, here is the error that logbox would've displayed: ");
                        return;
                    }
                    LogBoxDialog unused = LogBoxModule.this.mLogBoxDialog = new LogBoxDialog(access$300, LogBoxModule.this.mReactRootView);
                    LogBoxModule.this.mLogBoxDialog.setCancelable(false);
                    LogBoxModule.this.mLogBoxDialog.show();
                }
            }
        });
    }

    @ReactMethod
    public void hide() {
        UiThreadUtil.runOnUiThread(new Runnable() {
            public void run() {
                if (LogBoxModule.this.mLogBoxDialog != null) {
                    if (LogBoxModule.this.mReactRootView.getParent() != null) {
                        ((ViewGroup) LogBoxModule.this.mReactRootView.getParent()).removeView(LogBoxModule.this.mReactRootView);
                    }
                    LogBoxModule.this.mLogBoxDialog.dismiss();
                    LogBoxDialog unused = LogBoxModule.this.mLogBoxDialog = null;
                }
            }
        });
    }

    public void onCatalystInstanceDestroy() {
        UiThreadUtil.runOnUiThread(new Runnable() {
            public void run() {
                if (LogBoxModule.this.mReactRootView != null) {
                    LogBoxModule.this.mDevSupportManager.destroyRootView(LogBoxModule.this.mReactRootView);
                    View unused = LogBoxModule.this.mReactRootView = null;
                }
            }
        });
    }
}
