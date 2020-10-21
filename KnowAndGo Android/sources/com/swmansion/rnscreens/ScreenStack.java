package com.swmansion.rnscreens;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.UIManagerModule;
import com.swmansion.rnscreens.Screen;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ScreenStack extends ScreenContainer<ScreenStackFragment> {
    private static final String BACK_STACK_TAG = "RN_SCREEN_LAST";
    private final FragmentManager.OnBackStackChangedListener mBackStackListener = new FragmentManager.OnBackStackChangedListener() {
        public void onBackStackChanged() {
            if (ScreenStack.this.mFragmentManager.getBackStackEntryCount() == 0) {
                ScreenStack.this.dismiss(ScreenStack.this.mTopScreen);
            }
        }
    };
    private final Set<ScreenStackFragment> mDismissed = new HashSet();
    private final FragmentManager.FragmentLifecycleCallbacks mLifecycleCallbacks = new FragmentManager.FragmentLifecycleCallbacks() {
        public void onFragmentResumed(FragmentManager fragmentManager, Fragment fragment) {
            if (ScreenStack.this.mTopScreen == fragment) {
                ScreenStack.this.setupBackHandlerIfNeeded(ScreenStack.this.mTopScreen);
            }
        }
    };
    private boolean mRemovalTransitionStarted = false;
    private final ArrayList<ScreenStackFragment> mStack = new ArrayList<>();
    /* access modifiers changed from: private */
    public ScreenStackFragment mTopScreen = null;

    public ScreenStack(Context context) {
        super(context);
    }

    public void dismiss(ScreenStackFragment screenStackFragment) {
        this.mDismissed.add(screenStackFragment);
        markUpdated();
    }

    public Screen getTopScreen() {
        if (this.mTopScreen != null) {
            return this.mTopScreen.getScreen();
        }
        return null;
    }

    public Screen getRootScreen() {
        int screenCount = getScreenCount();
        for (int i = 0; i < screenCount; i++) {
            Screen screenAt = getScreenAt(i);
            if (!this.mDismissed.contains(screenAt.getFragment())) {
                return screenAt;
            }
        }
        throw new IllegalStateException("Stack has no root screen set");
    }

    /* access modifiers changed from: protected */
    public ScreenStackFragment adapt(Screen screen) {
        return new ScreenStackFragment(screen);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        if (this.mFragmentManager != null) {
            this.mFragmentManager.removeOnBackStackChangedListener(this.mBackStackListener);
            this.mFragmentManager.unregisterFragmentLifecycleCallbacks(this.mLifecycleCallbacks);
            if (!this.mFragmentManager.isStateSaved()) {
                this.mFragmentManager.popBackStack(BACK_STACK_TAG, 1);
            }
        }
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mFragmentManager.registerFragmentLifecycleCallbacks(this.mLifecycleCallbacks, false);
    }

    public void startViewTransition(View view) {
        super.startViewTransition(view);
        this.mRemovalTransitionStarted = true;
    }

    public void endViewTransition(View view) {
        super.endViewTransition(view);
        if (this.mRemovalTransitionStarted) {
            this.mRemovalTransitionStarted = false;
            dispatchOnFinishTransitioning();
        }
    }

    public void onViewAppearTransitionEnd() {
        if (!this.mRemovalTransitionStarted) {
            dispatchOnFinishTransitioning();
        }
    }

    private void dispatchOnFinishTransitioning() {
        ((UIManagerModule) ((ReactContext) getContext()).getNativeModule(UIManagerModule.class)).getEventDispatcher().dispatchEvent(new StackFinishTransitioningEvent(getId()));
    }

    /* access modifiers changed from: protected */
    public void removeScreenAt(int i) {
        this.mDismissed.remove(getScreenAt(i).getFragment());
        super.removeScreenAt(i);
    }

    /* access modifiers changed from: protected */
    public void removeAllScreens() {
        this.mDismissed.clear();
        super.removeAllScreens();
    }

    /* access modifiers changed from: protected */
    public boolean hasScreen(ScreenFragment screenFragment) {
        return super.hasScreen(screenFragment) && !this.mDismissed.contains(screenFragment);
    }

    /* access modifiers changed from: protected */
    public void performUpdate() {
        Iterator<ScreenStackFragment> it = this.mStack.iterator();
        while (it.hasNext()) {
            ScreenStackFragment next = it.next();
            if (!this.mScreenFragments.contains(next) || this.mDismissed.contains(next)) {
                getOrCreateTransaction().remove(next);
            }
        }
        int size = this.mScreenFragments.size() - 1;
        ScreenStackFragment screenStackFragment = null;
        final ScreenStackFragment screenStackFragment2 = null;
        while (true) {
            if (size < 0) {
                break;
            }
            ScreenStackFragment screenStackFragment3 = (ScreenStackFragment) this.mScreenFragments.get(size);
            if (!this.mDismissed.contains(screenStackFragment3)) {
                if (screenStackFragment2 != null) {
                    screenStackFragment = screenStackFragment3;
                    break;
                } else if (screenStackFragment3.getScreen().getStackPresentation() != Screen.StackPresentation.TRANSPARENT_MODAL) {
                    screenStackFragment2 = screenStackFragment3;
                    break;
                } else {
                    screenStackFragment2 = screenStackFragment3;
                }
            }
            size--;
        }
        Iterator it2 = this.mScreenFragments.iterator();
        while (it2.hasNext()) {
            ScreenStackFragment screenStackFragment4 = (ScreenStackFragment) it2.next();
            if (!(screenStackFragment4 == screenStackFragment2 || screenStackFragment4 == screenStackFragment || this.mDismissed.contains(screenStackFragment4))) {
                getOrCreateTransaction().remove(screenStackFragment4);
            }
        }
        if (screenStackFragment != null && !screenStackFragment.isAdded()) {
            getOrCreateTransaction().add(getId(), (Fragment) screenStackFragment).runOnCommit(new Runnable() {
                public void run() {
                    screenStackFragment2.getScreen().bringToFront();
                }
            });
        }
        if (screenStackFragment2 != null && !screenStackFragment2.isAdded()) {
            getOrCreateTransaction().add(getId(), (Fragment) screenStackFragment2);
        }
        if (!this.mStack.contains(screenStackFragment2)) {
            if (!(this.mTopScreen == null || screenStackFragment2 == null)) {
                int i = FragmentTransaction.TRANSIT_FRAGMENT_OPEN;
                switch (screenStackFragment2.getScreen().getStackAnimation()) {
                    case NONE:
                        i = 0;
                        break;
                    case FADE:
                        i = FragmentTransaction.TRANSIT_FRAGMENT_FADE;
                        break;
                }
                getOrCreateTransaction().setTransition(i);
            }
        } else if (this.mTopScreen != null && !this.mTopScreen.equals(screenStackFragment2)) {
            int i2 = 8194;
            switch (this.mTopScreen.getScreen().getStackAnimation()) {
                case NONE:
                    i2 = 0;
                    break;
                case FADE:
                    i2 = FragmentTransaction.TRANSIT_FRAGMENT_FADE;
                    break;
            }
            getOrCreateTransaction().setTransition(i2);
        }
        this.mTopScreen = screenStackFragment2;
        this.mStack.clear();
        this.mStack.addAll(this.mScreenFragments);
        tryCommitTransaction();
        if (this.mTopScreen != null) {
            setupBackHandlerIfNeeded(this.mTopScreen);
        }
        Iterator<ScreenStackFragment> it3 = this.mStack.iterator();
        while (it3.hasNext()) {
            it3.next().onStackUpdate();
        }
    }

    /* access modifiers changed from: private */
    public void setupBackHandlerIfNeeded(ScreenStackFragment screenStackFragment) {
        if (this.mTopScreen.isResumed()) {
            this.mFragmentManager.removeOnBackStackChangedListener(this.mBackStackListener);
            this.mFragmentManager.popBackStack(BACK_STACK_TAG, 1);
            ScreenStackFragment screenStackFragment2 = null;
            int i = 0;
            int size = this.mStack.size();
            while (true) {
                if (i >= size) {
                    break;
                }
                ScreenStackFragment screenStackFragment3 = this.mStack.get(i);
                if (!this.mDismissed.contains(screenStackFragment3)) {
                    screenStackFragment2 = screenStackFragment3;
                    break;
                }
                i++;
            }
            if (screenStackFragment != screenStackFragment2 && screenStackFragment.isDismissable()) {
                this.mFragmentManager.beginTransaction().show(screenStackFragment).addToBackStack(BACK_STACK_TAG).setPrimaryNavigationFragment(screenStackFragment).commitAllowingStateLoss();
                this.mFragmentManager.addOnBackStackChangedListener(this.mBackStackListener);
            }
        }
    }
}