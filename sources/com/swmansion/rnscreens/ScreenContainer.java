package com.swmansion.rnscreens;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.facebook.react.modules.core.ChoreographerCompat;
import com.facebook.react.modules.core.ReactChoreographer;
import com.swmansion.rnscreens.ScreenFragment;
import java.util.ArrayList;
import java.util.HashSet;

public class ScreenContainer<T extends ScreenFragment> extends ViewGroup {
    @Nullable
    private FragmentTransaction mCurrentTransaction;
    @Nullable
    protected FragmentManager mFragmentManager;
    private final ChoreographerCompat.FrameCallback mFrameCallback = new ChoreographerCompat.FrameCallback() {
        public void doFrame(long j) {
            ScreenContainer.this.updateIfNeeded();
        }
    };
    private boolean mIsAttached;
    private final ChoreographerCompat.FrameCallback mLayoutCallback = new ChoreographerCompat.FrameCallback() {
        public void doFrame(long j) {
            boolean unused = ScreenContainer.this.mLayoutEnqueued = false;
            ScreenContainer.this.measure(View.MeasureSpec.makeMeasureSpec(ScreenContainer.this.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(ScreenContainer.this.getHeight(), 1073741824));
            ScreenContainer.this.layout(ScreenContainer.this.getLeft(), ScreenContainer.this.getTop(), ScreenContainer.this.getRight(), ScreenContainer.this.getBottom());
        }
    };
    /* access modifiers changed from: private */
    public boolean mLayoutEnqueued = false;
    private boolean mNeedUpdate;
    /* access modifiers changed from: private */
    @Nullable
    public FragmentTransaction mProcessingTransaction;
    protected final ArrayList<T> mScreenFragments = new ArrayList<>();

    public ScreenContainer(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            getChildAt(i5).layout(0, 0, getWidth(), getHeight());
        }
    }

    public void requestLayout() {
        super.requestLayout();
        if (!this.mLayoutEnqueued && this.mLayoutCallback != null) {
            this.mLayoutEnqueued = true;
            ReactChoreographer.getInstance().postFrameCallback(ReactChoreographer.CallbackType.NATIVE_ANIMATED_MODULE, this.mLayoutCallback);
        }
    }

    /* access modifiers changed from: protected */
    public void markUpdated() {
        if (!this.mNeedUpdate) {
            this.mNeedUpdate = true;
            ReactChoreographer.getInstance().postFrameCallback(ReactChoreographer.CallbackType.NATIVE_ANIMATED_MODULE, this.mFrameCallback);
        }
    }

    /* access modifiers changed from: protected */
    public void notifyChildUpdate() {
        markUpdated();
    }

    /* access modifiers changed from: protected */
    public T adapt(Screen screen) {
        return new ScreenFragment(screen);
    }

    /* access modifiers changed from: protected */
    public void addScreen(Screen screen, int i) {
        ScreenFragment adapt = adapt(screen);
        screen.setFragment(adapt);
        this.mScreenFragments.add(i, adapt);
        screen.setContainer(this);
        markUpdated();
    }

    /* access modifiers changed from: protected */
    public void removeScreenAt(int i) {
        ((ScreenFragment) this.mScreenFragments.get(i)).getScreen().setContainer((ScreenContainer) null);
        this.mScreenFragments.remove(i);
        markUpdated();
    }

    /* access modifiers changed from: protected */
    public void removeAllScreens() {
        int size = this.mScreenFragments.size();
        for (int i = 0; i < size; i++) {
            ((ScreenFragment) this.mScreenFragments.get(i)).getScreen().setContainer((ScreenContainer) null);
        }
        this.mScreenFragments.clear();
        markUpdated();
    }

    /* access modifiers changed from: protected */
    public int getScreenCount() {
        return this.mScreenFragments.size();
    }

    /* access modifiers changed from: protected */
    public Screen getScreenAt(int i) {
        return ((ScreenFragment) this.mScreenFragments.get(i)).getScreen();
    }

    private void setFragmentManager(FragmentManager fragmentManager) {
        this.mFragmentManager = fragmentManager;
        updateIfNeeded();
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0049  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void setupFragmentManager() {
        /*
            r3 = this;
            r0 = r3
        L_0x0001:
            boolean r1 = r0 instanceof com.facebook.react.ReactRootView
            if (r1 != 0) goto L_0x0014
            boolean r2 = r0 instanceof com.swmansion.rnscreens.Screen
            if (r2 != 0) goto L_0x0014
            android.view.ViewParent r2 = r0.getParent()
            if (r2 == 0) goto L_0x0014
            android.view.ViewParent r0 = r0.getParent()
            goto L_0x0001
        L_0x0014:
            boolean r2 = r0 instanceof com.swmansion.rnscreens.Screen
            if (r2 == 0) goto L_0x0026
            com.swmansion.rnscreens.Screen r0 = (com.swmansion.rnscreens.Screen) r0
            com.swmansion.rnscreens.ScreenFragment r0 = r0.getFragment()
            androidx.fragment.app.FragmentManager r0 = r0.getChildFragmentManager()
            r3.setFragmentManager(r0)
            return
        L_0x0026:
            if (r1 == 0) goto L_0x0051
            com.facebook.react.ReactRootView r0 = (com.facebook.react.ReactRootView) r0
            android.content.Context r0 = r0.getContext()
        L_0x002e:
            boolean r1 = r0 instanceof androidx.fragment.app.FragmentActivity
            if (r1 != 0) goto L_0x003d
            boolean r2 = r0 instanceof android.content.ContextWrapper
            if (r2 == 0) goto L_0x003d
            android.content.ContextWrapper r0 = (android.content.ContextWrapper) r0
            android.content.Context r0 = r0.getBaseContext()
            goto L_0x002e
        L_0x003d:
            if (r1 == 0) goto L_0x0049
            androidx.fragment.app.FragmentActivity r0 = (androidx.fragment.app.FragmentActivity) r0
            androidx.fragment.app.FragmentManager r0 = r0.getSupportFragmentManager()
            r3.setFragmentManager(r0)
            return
        L_0x0049:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "In order to use RNScreens components your app's activity need to extend ReactFragmentActivity or ReactCompatActivity"
            r0.<init>(r1)
            throw r0
        L_0x0051:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "ScreenContainer is not attached under ReactRootView"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.swmansion.rnscreens.ScreenContainer.setupFragmentManager():void");
    }

    /* access modifiers changed from: protected */
    public FragmentTransaction getOrCreateTransaction() {
        if (this.mCurrentTransaction == null) {
            this.mCurrentTransaction = this.mFragmentManager.beginTransaction();
            this.mCurrentTransaction.setReorderingAllowed(true);
        }
        return this.mCurrentTransaction;
    }

    /* access modifiers changed from: protected */
    public void tryCommitTransaction() {
        if (this.mCurrentTransaction != null) {
            final FragmentTransaction fragmentTransaction = this.mCurrentTransaction;
            this.mProcessingTransaction = fragmentTransaction;
            this.mProcessingTransaction.runOnCommit(new Runnable() {
                public void run() {
                    if (ScreenContainer.this.mProcessingTransaction == fragmentTransaction) {
                        FragmentTransaction unused = ScreenContainer.this.mProcessingTransaction = null;
                    }
                }
            });
            this.mCurrentTransaction.commitAllowingStateLoss();
            this.mCurrentTransaction = null;
        }
    }

    private void attachScreen(ScreenFragment screenFragment) {
        getOrCreateTransaction().add(getId(), (Fragment) screenFragment);
    }

    private void moveToFront(ScreenFragment screenFragment) {
        FragmentTransaction orCreateTransaction = getOrCreateTransaction();
        orCreateTransaction.remove(screenFragment);
        orCreateTransaction.add(getId(), (Fragment) screenFragment);
    }

    private void detachScreen(ScreenFragment screenFragment) {
        getOrCreateTransaction().remove(screenFragment);
    }

    /* access modifiers changed from: protected */
    public boolean isScreenActive(ScreenFragment screenFragment) {
        return screenFragment.getScreen().isActive();
    }

    /* access modifiers changed from: protected */
    public boolean hasScreen(ScreenFragment screenFragment) {
        return this.mScreenFragments.contains(screenFragment);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mIsAttached = true;
        this.mNeedUpdate = true;
        setupFragmentManager();
    }

    private void removeMyFragments() {
        FragmentTransaction beginTransaction = this.mFragmentManager.beginTransaction();
        boolean z = false;
        for (Fragment next : this.mFragmentManager.getFragments()) {
            if ((next instanceof ScreenFragment) && ((ScreenFragment) next).mScreenView.getContainer() == this) {
                beginTransaction.remove(next);
                z = true;
            }
        }
        if (z) {
            beginTransaction.commitNowAllowingStateLoss();
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        if (this.mFragmentManager != null && !this.mFragmentManager.isDestroyed()) {
            removeMyFragments();
            this.mFragmentManager.executePendingTransactions();
        }
        super.onDetachedFromWindow();
        this.mIsAttached = false;
        removeAllViews();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            getChildAt(i3).measure(i, i2);
        }
    }

    /* access modifiers changed from: private */
    public void updateIfNeeded() {
        if (this.mNeedUpdate && this.mIsAttached && this.mFragmentManager != null) {
            this.mNeedUpdate = false;
            onUpdate();
        }
    }

    private final void onUpdate() {
        this.mFragmentManager.executePendingTransactions();
        performUpdate();
    }

    /* access modifiers changed from: protected */
    public void performUpdate() {
        HashSet hashSet = new HashSet(this.mFragmentManager.getFragments());
        int size = this.mScreenFragments.size();
        for (int i = 0; i < size; i++) {
            ScreenFragment screenFragment = (ScreenFragment) this.mScreenFragments.get(i);
            if (!isScreenActive(screenFragment) && screenFragment.isAdded()) {
                detachScreen(screenFragment);
            }
            hashSet.remove(screenFragment);
        }
        if (!hashSet.isEmpty()) {
            Object[] array = hashSet.toArray();
            for (int i2 = 0; i2 < array.length; i2++) {
                if ((array[i2] instanceof ScreenFragment) && ((ScreenFragment) array[i2]).getScreen().getContainer() == null) {
                    detachScreen((ScreenFragment) array[i2]);
                }
            }
        }
        int size2 = this.mScreenFragments.size();
        int i3 = 0;
        for (int i4 = 0; i4 < size2; i4++) {
            if (isScreenActive((ScreenFragment) this.mScreenFragments.get(i4))) {
                i3++;
            }
        }
        boolean z = i3 > 1;
        int size3 = this.mScreenFragments.size();
        boolean z2 = false;
        for (int i5 = 0; i5 < size3; i5++) {
            ScreenFragment screenFragment2 = (ScreenFragment) this.mScreenFragments.get(i5);
            boolean isScreenActive = isScreenActive(screenFragment2);
            if (isScreenActive && !screenFragment2.isAdded()) {
                attachScreen(screenFragment2);
                z2 = true;
            } else if (isScreenActive && z2) {
                moveToFront(screenFragment2);
            }
            screenFragment2.getScreen().setTransitioning(z);
        }
        tryCommitTransaction();
    }
}
