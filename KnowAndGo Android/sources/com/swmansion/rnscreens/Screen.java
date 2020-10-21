package com.swmansion.rnscreens;

import android.graphics.Paint;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.facebook.react.bridge.GuardedRunnable;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.UIManagerModule;

public class Screen extends ViewGroup {
    /* access modifiers changed from: private */
    public static View.OnAttachStateChangeListener sShowSoftKeyboardOnAttach = new View.OnAttachStateChangeListener() {
        public void onViewDetachedFromWindow(View view) {
        }

        public void onViewAttachedToWindow(View view) {
            ((InputMethodManager) view.getContext().getSystemService("input_method")).showSoftInput(view, 0);
            view.removeOnAttachStateChangeListener(Screen.sShowSoftKeyboardOnAttach);
        }
    };
    private boolean mActive;
    @Nullable
    private ScreenContainer mContainer;
    @Nullable
    private ScreenFragment mFragment;
    private boolean mGestureEnabled = true;
    private StackAnimation mStackAnimation = StackAnimation.DEFAULT;
    private StackPresentation mStackPresentation = StackPresentation.PUSH;
    private boolean mTransitioning;

    public enum StackAnimation {
        DEFAULT,
        NONE,
        FADE
    }

    public enum StackPresentation {
        PUSH,
        MODAL,
        TRANSPARENT_MODAL
    }

    /* access modifiers changed from: protected */
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
    }

    /* access modifiers changed from: protected */
    public void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
    }

    public void setLayerType(int i, @Nullable Paint paint) {
    }

    /* access modifiers changed from: protected */
    public void onAnimationEnd() {
        super.onAnimationEnd();
        if (this.mFragment != null) {
            this.mFragment.onViewAnimationEnd();
        }
    }

    public Screen(ReactContext reactContext) {
        super(reactContext);
        setLayoutParams(new WindowManager.LayoutParams(2));
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (z) {
            final int i5 = i3 - i;
            final int i6 = i4 - i2;
            ReactContext reactContext = (ReactContext) getContext();
            final ReactContext reactContext2 = reactContext;
            reactContext.runOnNativeModulesQueueThread(new GuardedRunnable(reactContext) {
                public void runGuarded() {
                    ((UIManagerModule) reactContext2.getNativeModule(UIManagerModule.class)).updateNodeSize(Screen.this.getId(), i5, i6);
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        View focusedChild = getFocusedChild();
        if (focusedChild != null) {
            while (focusedChild instanceof ViewGroup) {
                focusedChild = ((ViewGroup) focusedChild).getFocusedChild();
            }
            if (focusedChild instanceof TextView) {
                TextView textView = (TextView) focusedChild;
                if (textView.getShowSoftInputOnFocus()) {
                    textView.addOnAttachStateChangeListener(sShowSoftKeyboardOnAttach);
                }
            }
        }
    }

    public void setTransitioning(boolean z) {
        if (this.mTransitioning != z) {
            this.mTransitioning = z;
            super.setLayerType(z ? 2 : 0, (Paint) null);
        }
    }

    public void setStackPresentation(StackPresentation stackPresentation) {
        this.mStackPresentation = stackPresentation;
    }

    public void setStackAnimation(StackAnimation stackAnimation) {
        this.mStackAnimation = stackAnimation;
    }

    public void setGestureEnabled(boolean z) {
        this.mGestureEnabled = z;
    }

    public StackAnimation getStackAnimation() {
        return this.mStackAnimation;
    }

    public StackPresentation getStackPresentation() {
        return this.mStackPresentation;
    }

    /* access modifiers changed from: protected */
    public void setContainer(@Nullable ScreenContainer screenContainer) {
        this.mContainer = screenContainer;
    }

    /* access modifiers changed from: protected */
    public void setFragment(ScreenFragment screenFragment) {
        this.mFragment = screenFragment;
    }

    /* access modifiers changed from: protected */
    @Nullable
    public ScreenFragment getFragment() {
        return this.mFragment;
    }

    /* access modifiers changed from: protected */
    @Nullable
    public ScreenContainer getContainer() {
        return this.mContainer;
    }

    public void setActive(boolean z) {
        if (z != this.mActive) {
            this.mActive = z;
            if (this.mContainer != null) {
                this.mContainer.notifyChildUpdate();
            }
        }
    }

    public boolean isActive() {
        return this.mActive;
    }

    public boolean isGestureEnabled() {
        return this.mGestureEnabled;
    }
}
