package com.facebook.react;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.facebook.common.logging.FLog;
import com.facebook.infer.annotation.Assertions;
import com.facebook.infer.annotation.ThreadConfined;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.CatalystInstance;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactMarker;
import com.facebook.react.bridge.ReactMarkerConstants;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.common.ReactConstants;
import com.facebook.react.common.annotations.VisibleForTesting;
import com.facebook.react.modules.appregistry.AppRegistry;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.facebook.react.modules.deviceinfo.DeviceInfoModule;
import com.facebook.react.uimanager.DisplayMetricsHolder;
import com.facebook.react.uimanager.IllegalViewOperationException;
import com.facebook.react.uimanager.JSTouchDispatcher;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.ReactRoot;
import com.facebook.react.uimanager.RootView;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.systrace.Systrace;

public class ReactRootView extends FrameLayout implements RootView, ReactRoot {
    private final ReactAndroidHWInputDeviceHelper mAndroidHWInputDeviceHelper;
    @Nullable
    private Bundle mAppProperties;
    @Nullable
    private CustomGlobalLayoutListener mCustomGlobalLayoutListener;
    private int mHeightMeasureSpec;
    @Nullable
    private String mInitialUITemplate;
    /* access modifiers changed from: private */
    public boolean mIsAttachedToInstance;
    @Nullable
    private String mJSModuleName;
    @Nullable
    private JSTouchDispatcher mJSTouchDispatcher;
    private int mLastHeight;
    private int mLastWidth;
    /* access modifiers changed from: private */
    @Nullable
    public ReactInstanceManager mReactInstanceManager;
    @Nullable
    private ReactRootViewEventListener mRootViewEventListener;
    private int mRootViewTag;
    private boolean mShouldLogContentAppeared;
    private int mUIManagerType;
    private final boolean mUseSurface;
    private boolean mWasMeasured;
    private int mWidthMeasureSpec;

    public interface ReactRootViewEventListener {
        void onAttachedToReactInstance(ReactRootView reactRootView);
    }

    public ViewGroup getRootViewGroup() {
        return this;
    }

    public ReactRootView(Context context) {
        super(context);
        this.mAndroidHWInputDeviceHelper = new ReactAndroidHWInputDeviceHelper(this);
        this.mWasMeasured = false;
        this.mWidthMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.mHeightMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.mLastWidth = 0;
        this.mLastHeight = 0;
        this.mUIManagerType = 1;
        this.mUseSurface = false;
        init();
    }

    public ReactRootView(Context context, boolean z) {
        super(context);
        this.mAndroidHWInputDeviceHelper = new ReactAndroidHWInputDeviceHelper(this);
        this.mWasMeasured = false;
        this.mWidthMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.mHeightMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.mLastWidth = 0;
        this.mLastHeight = 0;
        this.mUIManagerType = 1;
        this.mUseSurface = z;
        init();
    }

    public ReactRootView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mAndroidHWInputDeviceHelper = new ReactAndroidHWInputDeviceHelper(this);
        this.mWasMeasured = false;
        this.mWidthMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.mHeightMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.mLastWidth = 0;
        this.mLastHeight = 0;
        this.mUIManagerType = 1;
        this.mUseSurface = false;
        init();
    }

    public ReactRootView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mAndroidHWInputDeviceHelper = new ReactAndroidHWInputDeviceHelper(this);
        this.mWasMeasured = false;
        this.mWidthMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.mHeightMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.mLastWidth = 0;
        this.mLastHeight = 0;
        this.mUIManagerType = 1;
        this.mUseSurface = false;
        init();
    }

    private void init() {
        setClipChildren(false);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x002f A[Catch:{ all -> 0x00be }] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x003f A[Catch:{ all -> 0x00be }, LOOP:0: B:19:0x0039->B:21:0x003f, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0064 A[Catch:{ all -> 0x00be }] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0073 A[Catch:{ all -> 0x00be }, LOOP:1: B:29:0x006d->B:31:0x0073, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x009e A[Catch:{ all -> 0x00be }] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00a2 A[ADDED_TO_REGION, Catch:{ all -> 0x00be }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r11, int r12) {
        /*
            r10 = this;
            r0 = 0
            r10.setAllowImmediateUIOperationExecution(r0)
            boolean r1 = r10.mUseSurface
            r2 = 1
            if (r1 == 0) goto L_0x0010
            super.onMeasure(r11, r12)
            r10.setAllowImmediateUIOperationExecution(r2)
            return
        L_0x0010:
            java.lang.String r1 = "ReactRootView.onMeasure"
            r3 = 0
            com.facebook.systrace.Systrace.beginSection(r3, r1)
            int r1 = r10.mWidthMeasureSpec     // Catch:{ all -> 0x00be }
            if (r11 != r1) goto L_0x0022
            int r1 = r10.mHeightMeasureSpec     // Catch:{ all -> 0x00be }
            if (r12 == r1) goto L_0x0020
            goto L_0x0022
        L_0x0020:
            r1 = 0
            goto L_0x0023
        L_0x0022:
            r1 = 1
        L_0x0023:
            r10.mWidthMeasureSpec = r11     // Catch:{ all -> 0x00be }
            r10.mHeightMeasureSpec = r12     // Catch:{ all -> 0x00be }
            int r5 = android.view.View.MeasureSpec.getMode(r11)     // Catch:{ all -> 0x00be }
            r6 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r5 == r6) goto L_0x0037
            if (r5 != 0) goto L_0x0032
            goto L_0x0037
        L_0x0032:
            int r11 = android.view.View.MeasureSpec.getSize(r11)     // Catch:{ all -> 0x00be }
            goto L_0x005e
        L_0x0037:
            r11 = 0
            r5 = 0
        L_0x0039:
            int r7 = r10.getChildCount()     // Catch:{ all -> 0x00be }
            if (r11 >= r7) goto L_0x005d
            android.view.View r7 = r10.getChildAt(r11)     // Catch:{ all -> 0x00be }
            int r8 = r7.getLeft()     // Catch:{ all -> 0x00be }
            int r9 = r7.getMeasuredWidth()     // Catch:{ all -> 0x00be }
            int r8 = r8 + r9
            int r9 = r7.getPaddingLeft()     // Catch:{ all -> 0x00be }
            int r8 = r8 + r9
            int r7 = r7.getPaddingRight()     // Catch:{ all -> 0x00be }
            int r8 = r8 + r7
            int r5 = java.lang.Math.max(r5, r8)     // Catch:{ all -> 0x00be }
            int r11 = r11 + 1
            goto L_0x0039
        L_0x005d:
            r11 = r5
        L_0x005e:
            int r5 = android.view.View.MeasureSpec.getMode(r12)     // Catch:{ all -> 0x00be }
            if (r5 == r6) goto L_0x006c
            if (r5 != 0) goto L_0x0067
            goto L_0x006c
        L_0x0067:
            int r12 = android.view.View.MeasureSpec.getSize(r12)     // Catch:{ all -> 0x00be }
            goto L_0x0091
        L_0x006c:
            r12 = 0
        L_0x006d:
            int r5 = r10.getChildCount()     // Catch:{ all -> 0x00be }
            if (r0 >= r5) goto L_0x0091
            android.view.View r5 = r10.getChildAt(r0)     // Catch:{ all -> 0x00be }
            int r6 = r5.getTop()     // Catch:{ all -> 0x00be }
            int r7 = r5.getMeasuredHeight()     // Catch:{ all -> 0x00be }
            int r6 = r6 + r7
            int r7 = r5.getPaddingTop()     // Catch:{ all -> 0x00be }
            int r6 = r6 + r7
            int r5 = r5.getPaddingBottom()     // Catch:{ all -> 0x00be }
            int r6 = r6 + r5
            int r12 = java.lang.Math.max(r12, r6)     // Catch:{ all -> 0x00be }
            int r0 = r0 + 1
            goto L_0x006d
        L_0x0091:
            r10.setMeasuredDimension(r11, r12)     // Catch:{ all -> 0x00be }
            r10.mWasMeasured = r2     // Catch:{ all -> 0x00be }
            com.facebook.react.ReactInstanceManager r0 = r10.mReactInstanceManager     // Catch:{ all -> 0x00be }
            if (r0 == 0) goto L_0x00a2
            boolean r0 = r10.mIsAttachedToInstance     // Catch:{ all -> 0x00be }
            if (r0 != 0) goto L_0x00a2
            r10.attachToReactInstanceManager()     // Catch:{ all -> 0x00be }
            goto L_0x00b3
        L_0x00a2:
            if (r1 != 0) goto L_0x00ac
            int r0 = r10.mLastWidth     // Catch:{ all -> 0x00be }
            if (r0 != r11) goto L_0x00ac
            int r0 = r10.mLastHeight     // Catch:{ all -> 0x00be }
            if (r0 == r12) goto L_0x00b3
        L_0x00ac:
            int r0 = r10.mWidthMeasureSpec     // Catch:{ all -> 0x00be }
            int r1 = r10.mHeightMeasureSpec     // Catch:{ all -> 0x00be }
            r10.updateRootLayoutSpecs(r0, r1)     // Catch:{ all -> 0x00be }
        L_0x00b3:
            r10.mLastWidth = r11     // Catch:{ all -> 0x00be }
            r10.mLastHeight = r12     // Catch:{ all -> 0x00be }
            r10.setAllowImmediateUIOperationExecution(r2)
            com.facebook.systrace.Systrace.endSection(r3)
            return
        L_0x00be:
            r11 = move-exception
            r10.setAllowImmediateUIOperationExecution(r2)
            com.facebook.systrace.Systrace.endSection(r3)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.ReactRootView.onMeasure(int, int):void");
    }

    public void onChildStartedNativeGesture(MotionEvent motionEvent) {
        if (this.mReactInstanceManager == null || !this.mIsAttachedToInstance || this.mReactInstanceManager.getCurrentReactContext() == null) {
            FLog.m102w(ReactConstants.TAG, "Unable to dispatch touch to JS as the catalyst instance has not been attached");
        } else if (this.mJSTouchDispatcher == null) {
            FLog.m102w(ReactConstants.TAG, "Unable to dispatch touch to JS before the dispatcher is available");
        } else {
            this.mJSTouchDispatcher.onChildStartedNativeGesture(motionEvent, ((UIManagerModule) this.mReactInstanceManager.getCurrentReactContext().getNativeModule(UIManagerModule.class)).getEventDispatcher());
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        dispatchJSTouchEvent(motionEvent);
        return super.onInterceptTouchEvent(motionEvent);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        dispatchJSTouchEvent(motionEvent);
        super.onTouchEvent(motionEvent);
        return true;
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        try {
            super.dispatchDraw(canvas);
        } catch (StackOverflowError e) {
            handleException(e);
        }
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (this.mReactInstanceManager == null || !this.mIsAttachedToInstance || this.mReactInstanceManager.getCurrentReactContext() == null) {
            FLog.m102w(ReactConstants.TAG, "Unable to handle key event as the catalyst instance has not been attached");
            return super.dispatchKeyEvent(keyEvent);
        }
        this.mAndroidHWInputDeviceHelper.handleKeyEvent(keyEvent);
        return super.dispatchKeyEvent(keyEvent);
    }

    /* access modifiers changed from: protected */
    public void onFocusChanged(boolean z, int i, Rect rect) {
        if (this.mReactInstanceManager == null || !this.mIsAttachedToInstance || this.mReactInstanceManager.getCurrentReactContext() == null) {
            FLog.m102w(ReactConstants.TAG, "Unable to handle focus changed event as the catalyst instance has not been attached");
            super.onFocusChanged(z, i, rect);
            return;
        }
        this.mAndroidHWInputDeviceHelper.clearFocus();
        super.onFocusChanged(z, i, rect);
    }

    public void requestChildFocus(View view, View view2) {
        if (this.mReactInstanceManager == null || !this.mIsAttachedToInstance || this.mReactInstanceManager.getCurrentReactContext() == null) {
            FLog.m102w(ReactConstants.TAG, "Unable to handle child focus changed event as the catalyst instance has not been attached");
            super.requestChildFocus(view, view2);
            return;
        }
        this.mAndroidHWInputDeviceHelper.onFocusChanged(view2);
        super.requestChildFocus(view, view2);
    }

    private void dispatchJSTouchEvent(MotionEvent motionEvent) {
        if (this.mReactInstanceManager == null || !this.mIsAttachedToInstance || this.mReactInstanceManager.getCurrentReactContext() == null) {
            FLog.m102w(ReactConstants.TAG, "Unable to dispatch touch to JS as the catalyst instance has not been attached");
        } else if (this.mJSTouchDispatcher == null) {
            FLog.m102w(ReactConstants.TAG, "Unable to dispatch touch to JS before the dispatcher is available");
        } else {
            this.mJSTouchDispatcher.handleTouchEvent(motionEvent, ((UIManagerModule) this.mReactInstanceManager.getCurrentReactContext().getNativeModule(UIManagerModule.class)).getEventDispatcher());
        }
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(z);
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.mUseSurface) {
            super.onLayout(z, i, i2, i3, i4);
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mIsAttachedToInstance) {
            removeOnGlobalLayoutListener();
            getViewTreeObserver().addOnGlobalLayoutListener(getCustomGlobalLayoutListener());
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.mIsAttachedToInstance) {
            removeOnGlobalLayoutListener();
        }
    }

    private void removeOnGlobalLayoutListener() {
        getViewTreeObserver().removeOnGlobalLayoutListener(getCustomGlobalLayoutListener());
    }

    public void onViewAdded(View view) {
        super.onViewAdded(view);
        if (this.mShouldLogContentAppeared) {
            this.mShouldLogContentAppeared = false;
            if (this.mJSModuleName != null) {
                ReactMarker.logMarker(ReactMarkerConstants.CONTENT_APPEARED, this.mJSModuleName, this.mRootViewTag);
            }
        }
    }

    public void startReactApplication(ReactInstanceManager reactInstanceManager, String str) {
        startReactApplication(reactInstanceManager, str, (Bundle) null);
    }

    public void startReactApplication(ReactInstanceManager reactInstanceManager, String str, @Nullable Bundle bundle) {
        startReactApplication(reactInstanceManager, str, bundle, (String) null);
    }

    @ThreadConfined("UI")
    public void startReactApplication(ReactInstanceManager reactInstanceManager, String str, @Nullable Bundle bundle, @Nullable String str2) {
        Systrace.beginSection(0, "startReactApplication");
        try {
            UiThreadUtil.assertOnUiThread();
            Assertions.assertCondition(this.mReactInstanceManager == null, "This root view has already been attached to a catalyst instance manager");
            this.mReactInstanceManager = reactInstanceManager;
            this.mJSModuleName = str;
            this.mAppProperties = bundle;
            this.mInitialUITemplate = str2;
            boolean z = this.mUseSurface;
            this.mReactInstanceManager.createReactContextInBackground();
            attachToReactInstanceManager();
        } finally {
            Systrace.endSection(0);
        }
    }

    public int getWidthMeasureSpec() {
        return this.mWidthMeasureSpec;
    }

    public int getHeightMeasureSpec() {
        return this.mHeightMeasureSpec;
    }

    public void setShouldLogContentAppeared(boolean z) {
        this.mShouldLogContentAppeared = z;
    }

    @Nullable
    public String getSurfaceID() {
        Bundle appProperties = getAppProperties();
        if (appProperties != null) {
            return appProperties.getString("surfaceID");
        }
        return null;
    }

    private void updateRootLayoutSpecs(int i, int i2) {
        if (this.mReactInstanceManager == null) {
            FLog.m102w(ReactConstants.TAG, "Unable to update root layout specs for uninitialized ReactInstanceManager");
            return;
        }
        ReactContext currentReactContext = this.mReactInstanceManager.getCurrentReactContext();
        if (currentReactContext != null) {
            UIManagerHelper.getUIManager(currentReactContext, getUIManagerType()).updateRootLayoutSpecs(getRootViewTag(), i, i2);
        }
    }

    private void setAllowImmediateUIOperationExecution(boolean z) {
        ReactContext currentReactContext;
        ReactInstanceManager reactInstanceManager = this.mReactInstanceManager;
        if (reactInstanceManager != null && (currentReactContext = reactInstanceManager.getCurrentReactContext()) != null) {
            UIManagerHelper.getUIManager(currentReactContext, getUIManagerType()).setAllowImmediateUIOperationExecution(z);
        }
    }

    @ThreadConfined("UI")
    public void unmountReactApplication() {
        UiThreadUtil.assertOnUiThread();
        if (this.mReactInstanceManager != null && this.mIsAttachedToInstance) {
            this.mReactInstanceManager.detachRootView(this);
            this.mIsAttachedToInstance = false;
        }
        this.mReactInstanceManager = null;
        this.mShouldLogContentAppeared = false;
    }

    public void onStage(int i) {
        if (i == 101) {
            onAttachedToReactInstance();
        }
    }

    public void onAttachedToReactInstance() {
        this.mJSTouchDispatcher = new JSTouchDispatcher(this);
        if (this.mRootViewEventListener != null) {
            this.mRootViewEventListener.onAttachedToReactInstance(this);
        }
    }

    public void setEventListener(ReactRootViewEventListener reactRootViewEventListener) {
        this.mRootViewEventListener = reactRootViewEventListener;
    }

    public String getJSModuleName() {
        return (String) Assertions.assertNotNull(this.mJSModuleName);
    }

    @Nullable
    public Bundle getAppProperties() {
        return this.mAppProperties;
    }

    @Nullable
    public String getInitialUITemplate() {
        return this.mInitialUITemplate;
    }

    @ThreadConfined("UI")
    public void setAppProperties(@Nullable Bundle bundle) {
        UiThreadUtil.assertOnUiThread();
        this.mAppProperties = bundle;
        if (getRootViewTag() != 0) {
            runApplication();
        }
    }

    public void runApplication() {
        Systrace.beginSection(0, "ReactRootView.runApplication");
        try {
            if (this.mReactInstanceManager != null) {
                if (this.mIsAttachedToInstance) {
                    ReactContext currentReactContext = this.mReactInstanceManager.getCurrentReactContext();
                    if (currentReactContext == null) {
                        Systrace.endSection(0);
                        return;
                    }
                    CatalystInstance catalystInstance = currentReactContext.getCatalystInstance();
                    String jSModuleName = getJSModuleName();
                    if (!this.mUseSurface) {
                        if (this.mWasMeasured) {
                            updateRootLayoutSpecs(this.mWidthMeasureSpec, this.mHeightMeasureSpec);
                        }
                        WritableNativeMap writableNativeMap = new WritableNativeMap();
                        writableNativeMap.putDouble("rootTag", (double) getRootViewTag());
                        Bundle appProperties = getAppProperties();
                        if (appProperties != null) {
                            writableNativeMap.putMap("initialProps", Arguments.fromBundle(appProperties));
                        }
                        this.mShouldLogContentAppeared = true;
                        ((AppRegistry) catalystInstance.getJSModule(AppRegistry.class)).runApplication(jSModuleName, writableNativeMap);
                    }
                    Systrace.endSection(0);
                }
            }
        } finally {
            Systrace.endSection(0);
        }
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public void simulateAttachForTesting() {
        this.mIsAttachedToInstance = true;
        this.mJSTouchDispatcher = new JSTouchDispatcher(this);
    }

    private CustomGlobalLayoutListener getCustomGlobalLayoutListener() {
        if (this.mCustomGlobalLayoutListener == null) {
            this.mCustomGlobalLayoutListener = new CustomGlobalLayoutListener();
        }
        return this.mCustomGlobalLayoutListener;
    }

    private void attachToReactInstanceManager() {
        Systrace.beginSection(0, "attachToReactInstanceManager");
        if (!this.mIsAttachedToInstance) {
            try {
                this.mIsAttachedToInstance = true;
                ((ReactInstanceManager) Assertions.assertNotNull(this.mReactInstanceManager)).attachRootView(this);
                getViewTreeObserver().addOnGlobalLayoutListener(getCustomGlobalLayoutListener());
            } finally {
                Systrace.endSection(0);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        super.finalize();
        Assertions.assertCondition(!this.mIsAttachedToInstance, "The application this ReactRootView was rendering was not unmounted before the ReactRootView was garbage collected. This usually means that your application is leaking large amounts of memory. To solve this, make sure to call ReactRootView#unmountReactApplication in the onDestroy() of your hosting Activity or in the onDestroyView() of your hosting Fragment.");
    }

    public int getRootViewTag() {
        return this.mRootViewTag;
    }

    public void setRootViewTag(int i) {
        this.mRootViewTag = i;
    }

    public void handleException(Throwable th) {
        if (this.mReactInstanceManager == null || this.mReactInstanceManager.getCurrentReactContext() == null) {
            throw new RuntimeException(th);
        }
        this.mReactInstanceManager.getCurrentReactContext().handleException(new IllegalViewOperationException(th.getMessage(), this, th));
    }

    public void setIsFabric(boolean z) {
        this.mUIManagerType = z ? 2 : 1;
    }

    public int getUIManagerType() {
        return this.mUIManagerType;
    }

    @Nullable
    public ReactInstanceManager getReactInstanceManager() {
        return this.mReactInstanceManager;
    }

    /* access modifiers changed from: package-private */
    public void sendEvent(String str, @Nullable WritableMap writableMap) {
        if (this.mReactInstanceManager != null) {
            ((DeviceEventManagerModule.RCTDeviceEventEmitter) this.mReactInstanceManager.getCurrentReactContext().getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit(str, writableMap);
        }
    }

    private class CustomGlobalLayoutListener implements ViewTreeObserver.OnGlobalLayoutListener {
        private int mDeviceRotation = 0;
        private int mKeyboardHeight = 0;
        private final int mMinKeyboardHeightDetected;
        private DisplayMetrics mScreenMetrics = new DisplayMetrics();
        private final Rect mVisibleViewArea;
        private DisplayMetrics mWindowMetrics = new DisplayMetrics();

        CustomGlobalLayoutListener() {
            DisplayMetricsHolder.initDisplayMetricsIfNotInitialized(ReactRootView.this.getContext().getApplicationContext());
            this.mVisibleViewArea = new Rect();
            this.mMinKeyboardHeightDetected = (int) PixelUtil.toPixelFromDIP(60.0f);
        }

        public void onGlobalLayout() {
            if (ReactRootView.this.mReactInstanceManager != null && ReactRootView.this.mIsAttachedToInstance && ReactRootView.this.mReactInstanceManager.getCurrentReactContext() != null) {
                checkForKeyboardEvents();
                checkForDeviceOrientationChanges();
                checkForDeviceDimensionsChanges();
            }
        }

        private void checkForKeyboardEvents() {
            ReactRootView.this.getRootView().getWindowVisibleDisplayFrame(this.mVisibleViewArea);
            int i = DisplayMetricsHolder.getWindowDisplayMetrics().heightPixels - this.mVisibleViewArea.bottom;
            boolean z = true;
            if (this.mKeyboardHeight != i && i > this.mMinKeyboardHeightDetected) {
                this.mKeyboardHeight = i;
                ReactRootView.this.sendEvent("keyboardDidShow", createKeyboardEventPayload((double) PixelUtil.toDIPFromPixel((float) this.mVisibleViewArea.bottom), (double) PixelUtil.toDIPFromPixel((float) this.mVisibleViewArea.left), (double) PixelUtil.toDIPFromPixel((float) this.mVisibleViewArea.width()), (double) PixelUtil.toDIPFromPixel((float) this.mKeyboardHeight)));
                return;
            }
            if (this.mKeyboardHeight == 0 || i > this.mMinKeyboardHeightDetected) {
                z = false;
            }
            if (z) {
                this.mKeyboardHeight = 0;
                ReactRootView.this.sendEvent("keyboardDidHide", createKeyboardEventPayload((double) PixelUtil.toDIPFromPixel((float) this.mVisibleViewArea.height()), 0.0d, (double) PixelUtil.toDIPFromPixel((float) this.mVisibleViewArea.width()), 0.0d));
            }
        }

        private void checkForDeviceOrientationChanges() {
            int rotation = ((WindowManager) ReactRootView.this.getContext().getSystemService("window")).getDefaultDisplay().getRotation();
            if (this.mDeviceRotation != rotation) {
                this.mDeviceRotation = rotation;
                emitOrientationChanged(rotation);
            }
        }

        private void checkForDeviceDimensionsChanges() {
            DisplayMetricsHolder.initDisplayMetrics(ReactRootView.this.getContext());
            if (!areMetricsEqual(this.mWindowMetrics, DisplayMetricsHolder.getWindowDisplayMetrics()) || !areMetricsEqual(this.mScreenMetrics, DisplayMetricsHolder.getScreenDisplayMetrics())) {
                this.mWindowMetrics.setTo(DisplayMetricsHolder.getWindowDisplayMetrics());
                this.mScreenMetrics.setTo(DisplayMetricsHolder.getScreenDisplayMetrics());
                emitUpdateDimensionsEvent();
            }
        }

        private boolean areMetricsEqual(DisplayMetrics displayMetrics, DisplayMetrics displayMetrics2) {
            if (Build.VERSION.SDK_INT >= 17) {
                return displayMetrics.equals(displayMetrics2);
            }
            return displayMetrics.widthPixels == displayMetrics2.widthPixels && displayMetrics.heightPixels == displayMetrics2.heightPixels && displayMetrics.density == displayMetrics2.density && displayMetrics.densityDpi == displayMetrics2.densityDpi && displayMetrics.scaledDensity == displayMetrics2.scaledDensity && displayMetrics.xdpi == displayMetrics2.xdpi && displayMetrics.ydpi == displayMetrics2.ydpi;
        }

        private void emitOrientationChanged(int i) {
            String str;
            double d;
            double d2;
            boolean z = true;
            switch (i) {
                case 0:
                    str = "portrait-primary";
                    d2 = 0.0d;
                    break;
                case 1:
                    str = "landscape-primary";
                    d = -90.0d;
                    break;
                case 2:
                    str = "portrait-secondary";
                    d2 = 180.0d;
                    break;
                case 3:
                    str = "landscape-secondary";
                    d = 90.0d;
                    break;
                default:
                    return;
            }
            d = d2;
            z = false;
            WritableMap createMap = Arguments.createMap();
            createMap.putString("name", str);
            createMap.putDouble("rotationDegrees", d);
            createMap.putBoolean("isLandscape", z);
            ReactRootView.this.sendEvent("namedOrientationDidChange", createMap);
        }

        private void emitUpdateDimensionsEvent() {
            ((DeviceInfoModule) ReactRootView.this.mReactInstanceManager.getCurrentReactContext().getNativeModule(DeviceInfoModule.class)).emitUpdateDimensionsEvent();
        }

        private WritableMap createKeyboardEventPayload(double d, double d2, double d3, double d4) {
            WritableMap createMap = Arguments.createMap();
            WritableMap createMap2 = Arguments.createMap();
            createMap2.putDouble("height", d4);
            createMap2.putDouble("screenX", d2);
            createMap2.putDouble("width", d3);
            createMap2.putDouble("screenY", d);
            createMap.putMap("endCoordinates", createMap2);
            createMap.putString("easing", "keyboard");
            createMap.putDouble("duration", 0.0d);
            return createMap;
        }
    }
}
