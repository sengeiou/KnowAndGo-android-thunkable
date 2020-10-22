package com.swmansion.gesturehandler.react;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.annotation.Nullable;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactRootView;

public class RNGestureHandlerEnabledRootView extends ReactRootView {
    @Nullable
    private RNGestureHandlerRootHelper mGestureRootHelper;
    @Nullable
    private ReactInstanceManager mReactInstanceManager;

    public RNGestureHandlerEnabledRootView(Context context) {
        super(context);
    }

    public RNGestureHandlerEnabledRootView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (this.mGestureRootHelper != null) {
            this.mGestureRootHelper.requestDisallowInterceptTouchEvent(z);
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.mGestureRootHelper == null || !this.mGestureRootHelper.dispatchTouchEvent(motionEvent)) {
            return super.dispatchTouchEvent(motionEvent);
        }
        return true;
    }

    public void initialize() {
        if (this.mGestureRootHelper == null) {
            this.mGestureRootHelper = new RNGestureHandlerRootHelper(this.mReactInstanceManager.getCurrentReactContext(), this);
            return;
        }
        throw new IllegalStateException("GestureHandler already initialized for root view " + this);
    }

    public void tearDown() {
        if (this.mGestureRootHelper != null) {
            this.mGestureRootHelper.tearDown();
            this.mGestureRootHelper = null;
        }
    }

    public void startReactApplication(ReactInstanceManager reactInstanceManager, String str, @Nullable Bundle bundle) {
        super.startReactApplication(reactInstanceManager, str, bundle);
        this.mReactInstanceManager = reactInstanceManager;
    }
}
