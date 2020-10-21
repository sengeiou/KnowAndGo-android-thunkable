package androidx.fragment.app;

import android.app.Activity;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.util.SparseArray;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.C0270R;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ViewModelStoreOwner;

class FragmentStateManager {
    private static final String TAG = "FragmentManager";
    private static final String TARGET_REQUEST_CODE_STATE_TAG = "android:target_req_state";
    private static final String TARGET_STATE_TAG = "android:target_state";
    private static final String USER_VISIBLE_HINT_TAG = "android:user_visible_hint";
    private static final String VIEW_STATE_TAG = "android:view_state";
    private final FragmentLifecycleCallbacksDispatcher mDispatcher;
    @NonNull
    private final Fragment mFragment;
    private int mFragmentManagerState = -1;

    FragmentStateManager(@NonNull FragmentLifecycleCallbacksDispatcher fragmentLifecycleCallbacksDispatcher, @NonNull Fragment fragment) {
        this.mDispatcher = fragmentLifecycleCallbacksDispatcher;
        this.mFragment = fragment;
    }

    FragmentStateManager(@NonNull FragmentLifecycleCallbacksDispatcher fragmentLifecycleCallbacksDispatcher, @NonNull ClassLoader classLoader, @NonNull FragmentFactory fragmentFactory, @NonNull FragmentState fragmentState) {
        this.mDispatcher = fragmentLifecycleCallbacksDispatcher;
        this.mFragment = fragmentFactory.instantiate(classLoader, fragmentState.mClassName);
        if (fragmentState.mArguments != null) {
            fragmentState.mArguments.setClassLoader(classLoader);
        }
        this.mFragment.setArguments(fragmentState.mArguments);
        this.mFragment.mWho = fragmentState.mWho;
        this.mFragment.mFromLayout = fragmentState.mFromLayout;
        this.mFragment.mRestored = true;
        this.mFragment.mFragmentId = fragmentState.mFragmentId;
        this.mFragment.mContainerId = fragmentState.mContainerId;
        this.mFragment.mTag = fragmentState.mTag;
        this.mFragment.mRetainInstance = fragmentState.mRetainInstance;
        this.mFragment.mRemoving = fragmentState.mRemoving;
        this.mFragment.mDetached = fragmentState.mDetached;
        this.mFragment.mHidden = fragmentState.mHidden;
        this.mFragment.mMaxState = Lifecycle.State.values()[fragmentState.mMaxLifecycleState];
        if (fragmentState.mSavedFragmentState != null) {
            this.mFragment.mSavedFragmentState = fragmentState.mSavedFragmentState;
        } else {
            this.mFragment.mSavedFragmentState = new Bundle();
        }
        if (FragmentManager.isLoggingEnabled(2)) {
            Log.v(TAG, "Instantiated fragment " + this.mFragment);
        }
    }

    FragmentStateManager(@NonNull FragmentLifecycleCallbacksDispatcher fragmentLifecycleCallbacksDispatcher, @NonNull Fragment fragment, @NonNull FragmentState fragmentState) {
        this.mDispatcher = fragmentLifecycleCallbacksDispatcher;
        this.mFragment = fragment;
        this.mFragment.mSavedViewState = null;
        this.mFragment.mBackStackNesting = 0;
        this.mFragment.mInLayout = false;
        this.mFragment.mAdded = false;
        this.mFragment.mTargetWho = this.mFragment.mTarget != null ? this.mFragment.mTarget.mWho : null;
        this.mFragment.mTarget = null;
        if (fragmentState.mSavedFragmentState != null) {
            this.mFragment.mSavedFragmentState = fragmentState.mSavedFragmentState;
        } else {
            this.mFragment.mSavedFragmentState = new Bundle();
        }
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public Fragment getFragment() {
        return this.mFragment;
    }

    /* access modifiers changed from: package-private */
    public void setFragmentManagerState(int i) {
        this.mFragmentManagerState = i;
    }

    /* access modifiers changed from: package-private */
    public int computeMaxState() {
        int i = this.mFragmentManagerState;
        if (this.mFragment.mFromLayout) {
            if (this.mFragment.mInLayout) {
                i = Math.max(this.mFragmentManagerState, 1);
            } else if (this.mFragmentManagerState < 2) {
                i = Math.min(i, this.mFragment.mState);
            } else {
                i = Math.min(i, 1);
            }
        }
        if (!this.mFragment.mAdded) {
            i = Math.min(i, 1);
        }
        if (this.mFragment.mRemoving) {
            if (this.mFragment.isInBackStack()) {
                i = Math.min(i, 1);
            } else {
                i = Math.min(i, -1);
            }
        }
        if (this.mFragment.mDeferStart && this.mFragment.mState < 3) {
            i = Math.min(i, 2);
        }
        switch (this.mFragment.mMaxState) {
            case RESUMED:
                return i;
            case STARTED:
                return Math.min(i, 3);
            case CREATED:
                return Math.min(i, 1);
            default:
                return Math.min(i, -1);
        }
    }

    /* access modifiers changed from: package-private */
    public void ensureInflatedView() {
        if (this.mFragment.mFromLayout && this.mFragment.mInLayout && !this.mFragment.mPerformedCreateView) {
            if (FragmentManager.isLoggingEnabled(3)) {
                Log.d(TAG, "moveto CREATE_VIEW: " + this.mFragment);
            }
            this.mFragment.performCreateView(this.mFragment.performGetLayoutInflater(this.mFragment.mSavedFragmentState), (ViewGroup) null, this.mFragment.mSavedFragmentState);
            if (this.mFragment.mView != null) {
                this.mFragment.mView.setSaveFromParentEnabled(false);
                this.mFragment.mView.setTag(C0270R.C0273id.fragment_container_view_tag, this.mFragment);
                if (this.mFragment.mHidden) {
                    this.mFragment.mView.setVisibility(8);
                }
                this.mFragment.onViewCreated(this.mFragment.mView, this.mFragment.mSavedFragmentState);
                this.mDispatcher.dispatchOnFragmentViewCreated(this.mFragment, this.mFragment.mView, this.mFragment.mSavedFragmentState, false);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void restoreState(@NonNull ClassLoader classLoader) {
        if (this.mFragment.mSavedFragmentState != null) {
            this.mFragment.mSavedFragmentState.setClassLoader(classLoader);
            this.mFragment.mSavedViewState = this.mFragment.mSavedFragmentState.getSparseParcelableArray(VIEW_STATE_TAG);
            this.mFragment.mTargetWho = this.mFragment.mSavedFragmentState.getString(TARGET_STATE_TAG);
            if (this.mFragment.mTargetWho != null) {
                this.mFragment.mTargetRequestCode = this.mFragment.mSavedFragmentState.getInt(TARGET_REQUEST_CODE_STATE_TAG, 0);
            }
            if (this.mFragment.mSavedUserVisibleHint != null) {
                this.mFragment.mUserVisibleHint = this.mFragment.mSavedUserVisibleHint.booleanValue();
                this.mFragment.mSavedUserVisibleHint = null;
            } else {
                this.mFragment.mUserVisibleHint = this.mFragment.mSavedFragmentState.getBoolean(USER_VISIBLE_HINT_TAG, true);
            }
            if (!this.mFragment.mUserVisibleHint) {
                this.mFragment.mDeferStart = true;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void attach(@NonNull FragmentHostCallback<?> fragmentHostCallback, @NonNull FragmentManager fragmentManager, @Nullable Fragment fragment) {
        this.mFragment.mHost = fragmentHostCallback;
        this.mFragment.mParentFragment = fragment;
        this.mFragment.mFragmentManager = fragmentManager;
        this.mDispatcher.dispatchOnFragmentPreAttached(this.mFragment, fragmentHostCallback.getContext(), false);
        this.mFragment.performAttach();
        if (this.mFragment.mParentFragment == null) {
            fragmentHostCallback.onAttachFragment(this.mFragment);
        } else {
            this.mFragment.mParentFragment.onAttachFragment(this.mFragment);
        }
        this.mDispatcher.dispatchOnFragmentAttached(this.mFragment, fragmentHostCallback.getContext(), false);
    }

    /* access modifiers changed from: package-private */
    public void create() {
        if (FragmentManager.isLoggingEnabled(3)) {
            Log.d(TAG, "moveto CREATED: " + this.mFragment);
        }
        if (!this.mFragment.mIsCreated) {
            this.mDispatcher.dispatchOnFragmentPreCreated(this.mFragment, this.mFragment.mSavedFragmentState, false);
            this.mFragment.performCreate(this.mFragment.mSavedFragmentState);
            this.mDispatcher.dispatchOnFragmentCreated(this.mFragment, this.mFragment.mSavedFragmentState, false);
            return;
        }
        this.mFragment.restoreChildFragmentState(this.mFragment.mSavedFragmentState);
        this.mFragment.mState = 1;
    }

    /* JADX WARNING: type inference failed for: r5v21, types: [android.view.View] */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void createView(@androidx.annotation.NonNull androidx.fragment.app.FragmentContainer r5) {
        /*
            r4 = this;
            androidx.fragment.app.Fragment r0 = r4.mFragment
            boolean r0 = r0.mFromLayout
            if (r0 == 0) goto L_0x0007
            return
        L_0x0007:
            r0 = 3
            boolean r0 = androidx.fragment.app.FragmentManager.isLoggingEnabled(r0)
            if (r0 == 0) goto L_0x0026
            java.lang.String r0 = "FragmentManager"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "moveto CREATE_VIEW: "
            r1.append(r2)
            androidx.fragment.app.Fragment r2 = r4.mFragment
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            android.util.Log.d(r0, r1)
        L_0x0026:
            r0 = 0
            androidx.fragment.app.Fragment r1 = r4.mFragment
            android.view.ViewGroup r1 = r1.mContainer
            if (r1 == 0) goto L_0x0033
            androidx.fragment.app.Fragment r5 = r4.mFragment
            android.view.ViewGroup r0 = r5.mContainer
            goto L_0x00b5
        L_0x0033:
            androidx.fragment.app.Fragment r1 = r4.mFragment
            int r1 = r1.mContainerId
            if (r1 == 0) goto L_0x00b5
            androidx.fragment.app.Fragment r0 = r4.mFragment
            int r0 = r0.mContainerId
            r1 = -1
            if (r0 == r1) goto L_0x0097
            androidx.fragment.app.Fragment r0 = r4.mFragment
            int r0 = r0.mContainerId
            android.view.View r5 = r5.onFindViewById(r0)
            r0 = r5
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            if (r0 != 0) goto L_0x00b5
            androidx.fragment.app.Fragment r5 = r4.mFragment
            boolean r5 = r5.mRestored
            if (r5 == 0) goto L_0x0054
            goto L_0x00b5
        L_0x0054:
            androidx.fragment.app.Fragment r5 = r4.mFragment     // Catch:{ NotFoundException -> 0x0063 }
            android.content.res.Resources r5 = r5.getResources()     // Catch:{ NotFoundException -> 0x0063 }
            androidx.fragment.app.Fragment r0 = r4.mFragment     // Catch:{ NotFoundException -> 0x0063 }
            int r0 = r0.mContainerId     // Catch:{ NotFoundException -> 0x0063 }
            java.lang.String r5 = r5.getResourceName(r0)     // Catch:{ NotFoundException -> 0x0063 }
            goto L_0x0066
        L_0x0063:
            java.lang.String r5 = "unknown"
        L_0x0066:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "No view found for id 0x"
            r1.append(r2)
            androidx.fragment.app.Fragment r2 = r4.mFragment
            int r2 = r2.mContainerId
            java.lang.String r2 = java.lang.Integer.toHexString(r2)
            r1.append(r2)
            java.lang.String r2 = " ("
            r1.append(r2)
            r1.append(r5)
            java.lang.String r5 = ") for fragment "
            r1.append(r5)
            androidx.fragment.app.Fragment r5 = r4.mFragment
            r1.append(r5)
            java.lang.String r5 = r1.toString()
            r0.<init>(r5)
            throw r0
        L_0x0097:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Cannot create fragment "
            r0.append(r1)
            androidx.fragment.app.Fragment r1 = r4.mFragment
            r0.append(r1)
            java.lang.String r1 = " for a container view with no id"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r5.<init>(r0)
            throw r5
        L_0x00b5:
            androidx.fragment.app.Fragment r5 = r4.mFragment
            r5.mContainer = r0
            androidx.fragment.app.Fragment r5 = r4.mFragment
            androidx.fragment.app.Fragment r1 = r4.mFragment
            androidx.fragment.app.Fragment r2 = r4.mFragment
            android.os.Bundle r2 = r2.mSavedFragmentState
            android.view.LayoutInflater r1 = r1.performGetLayoutInflater(r2)
            androidx.fragment.app.Fragment r2 = r4.mFragment
            android.os.Bundle r2 = r2.mSavedFragmentState
            r5.performCreateView(r1, r0, r2)
            androidx.fragment.app.Fragment r5 = r4.mFragment
            android.view.View r5 = r5.mView
            if (r5 == 0) goto L_0x0135
            androidx.fragment.app.Fragment r5 = r4.mFragment
            android.view.View r5 = r5.mView
            r1 = 0
            r5.setSaveFromParentEnabled(r1)
            androidx.fragment.app.Fragment r5 = r4.mFragment
            android.view.View r5 = r5.mView
            int r2 = androidx.fragment.C0270R.C0273id.fragment_container_view_tag
            androidx.fragment.app.Fragment r3 = r4.mFragment
            r5.setTag(r2, r3)
            if (r0 == 0) goto L_0x00ee
            androidx.fragment.app.Fragment r5 = r4.mFragment
            android.view.View r5 = r5.mView
            r0.addView(r5)
        L_0x00ee:
            androidx.fragment.app.Fragment r5 = r4.mFragment
            boolean r5 = r5.mHidden
            if (r5 == 0) goto L_0x00fd
            androidx.fragment.app.Fragment r5 = r4.mFragment
            android.view.View r5 = r5.mView
            r0 = 8
            r5.setVisibility(r0)
        L_0x00fd:
            androidx.fragment.app.Fragment r5 = r4.mFragment
            android.view.View r5 = r5.mView
            androidx.core.view.ViewCompat.requestApplyInsets(r5)
            androidx.fragment.app.Fragment r5 = r4.mFragment
            androidx.fragment.app.Fragment r0 = r4.mFragment
            android.view.View r0 = r0.mView
            androidx.fragment.app.Fragment r2 = r4.mFragment
            android.os.Bundle r2 = r2.mSavedFragmentState
            r5.onViewCreated(r0, r2)
            androidx.fragment.app.FragmentLifecycleCallbacksDispatcher r5 = r4.mDispatcher
            androidx.fragment.app.Fragment r0 = r4.mFragment
            androidx.fragment.app.Fragment r2 = r4.mFragment
            android.view.View r2 = r2.mView
            androidx.fragment.app.Fragment r3 = r4.mFragment
            android.os.Bundle r3 = r3.mSavedFragmentState
            r5.dispatchOnFragmentViewCreated(r0, r2, r3, r1)
            androidx.fragment.app.Fragment r5 = r4.mFragment
            androidx.fragment.app.Fragment r0 = r4.mFragment
            android.view.View r0 = r0.mView
            int r0 = r0.getVisibility()
            if (r0 != 0) goto L_0x0133
            androidx.fragment.app.Fragment r0 = r4.mFragment
            android.view.ViewGroup r0 = r0.mContainer
            if (r0 == 0) goto L_0x0133
            r1 = 1
        L_0x0133:
            r5.mIsNewlyAdded = r1
        L_0x0135:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.FragmentStateManager.createView(androidx.fragment.app.FragmentContainer):void");
    }

    /* access modifiers changed from: package-private */
    public void activityCreated() {
        if (FragmentManager.isLoggingEnabled(3)) {
            Log.d(TAG, "moveto ACTIVITY_CREATED: " + this.mFragment);
        }
        this.mFragment.performActivityCreated(this.mFragment.mSavedFragmentState);
        this.mDispatcher.dispatchOnFragmentActivityCreated(this.mFragment, this.mFragment.mSavedFragmentState, false);
    }

    /* access modifiers changed from: package-private */
    public void restoreViewState() {
        if (FragmentManager.isLoggingEnabled(3)) {
            Log.d(TAG, "moveto RESTORE_VIEW_STATE: " + this.mFragment);
        }
        if (this.mFragment.mView != null) {
            this.mFragment.restoreViewState(this.mFragment.mSavedFragmentState);
        }
        this.mFragment.mSavedFragmentState = null;
    }

    /* access modifiers changed from: package-private */
    public void start() {
        if (FragmentManager.isLoggingEnabled(3)) {
            Log.d(TAG, "moveto STARTED: " + this.mFragment);
        }
        this.mFragment.performStart();
        this.mDispatcher.dispatchOnFragmentStarted(this.mFragment, false);
    }

    /* access modifiers changed from: package-private */
    public void resume() {
        if (FragmentManager.isLoggingEnabled(3)) {
            Log.d(TAG, "moveto RESUMED: " + this.mFragment);
        }
        this.mFragment.performResume();
        this.mDispatcher.dispatchOnFragmentResumed(this.mFragment, false);
        this.mFragment.mSavedFragmentState = null;
        this.mFragment.mSavedViewState = null;
    }

    /* access modifiers changed from: package-private */
    public void pause() {
        if (FragmentManager.isLoggingEnabled(3)) {
            Log.d(TAG, "movefrom RESUMED: " + this.mFragment);
        }
        this.mFragment.performPause();
        this.mDispatcher.dispatchOnFragmentPaused(this.mFragment, false);
    }

    /* access modifiers changed from: package-private */
    public void stop() {
        if (FragmentManager.isLoggingEnabled(3)) {
            Log.d(TAG, "movefrom STARTED: " + this.mFragment);
        }
        this.mFragment.performStop();
        this.mDispatcher.dispatchOnFragmentStopped(this.mFragment, false);
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public FragmentState saveState() {
        FragmentState fragmentState = new FragmentState(this.mFragment);
        if (this.mFragment.mState <= -1 || fragmentState.mSavedFragmentState != null) {
            fragmentState.mSavedFragmentState = this.mFragment.mSavedFragmentState;
        } else {
            fragmentState.mSavedFragmentState = saveBasicState();
            if (this.mFragment.mTargetWho != null) {
                if (fragmentState.mSavedFragmentState == null) {
                    fragmentState.mSavedFragmentState = new Bundle();
                }
                fragmentState.mSavedFragmentState.putString(TARGET_STATE_TAG, this.mFragment.mTargetWho);
                if (this.mFragment.mTargetRequestCode != 0) {
                    fragmentState.mSavedFragmentState.putInt(TARGET_REQUEST_CODE_STATE_TAG, this.mFragment.mTargetRequestCode);
                }
            }
        }
        return fragmentState;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public Fragment.SavedState saveInstanceState() {
        Bundle saveBasicState;
        if (this.mFragment.mState <= -1 || (saveBasicState = saveBasicState()) == null) {
            return null;
        }
        return new Fragment.SavedState(saveBasicState);
    }

    private Bundle saveBasicState() {
        Bundle bundle = new Bundle();
        this.mFragment.performSaveInstanceState(bundle);
        this.mDispatcher.dispatchOnFragmentSaveInstanceState(this.mFragment, bundle, false);
        if (bundle.isEmpty()) {
            bundle = null;
        }
        if (this.mFragment.mView != null) {
            saveViewState();
        }
        if (this.mFragment.mSavedViewState != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putSparseParcelableArray(VIEW_STATE_TAG, this.mFragment.mSavedViewState);
        }
        if (!this.mFragment.mUserVisibleHint) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean(USER_VISIBLE_HINT_TAG, this.mFragment.mUserVisibleHint);
        }
        return bundle;
    }

    /* access modifiers changed from: package-private */
    public void saveViewState() {
        if (this.mFragment.mView != null) {
            SparseArray<Parcelable> sparseArray = new SparseArray<>();
            this.mFragment.mView.saveHierarchyState(sparseArray);
            if (sparseArray.size() > 0) {
                this.mFragment.mSavedViewState = sparseArray;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void destroy(@NonNull FragmentHostCallback<?> fragmentHostCallback, @NonNull FragmentManagerViewModel fragmentManagerViewModel) {
        if (FragmentManager.isLoggingEnabled(3)) {
            Log.d(TAG, "movefrom CREATED: " + this.mFragment);
        }
        boolean z = true;
        boolean z2 = this.mFragment.mRemoving && !this.mFragment.isInBackStack();
        if (z2 || fragmentManagerViewModel.shouldDestroy(this.mFragment)) {
            if (fragmentHostCallback instanceof ViewModelStoreOwner) {
                z = fragmentManagerViewModel.isCleared();
            } else if (fragmentHostCallback.getContext() instanceof Activity) {
                z = true ^ ((Activity) fragmentHostCallback.getContext()).isChangingConfigurations();
            }
            if (z2 || z) {
                fragmentManagerViewModel.clearNonConfigState(this.mFragment);
            }
            this.mFragment.performDestroy();
            this.mDispatcher.dispatchOnFragmentDestroyed(this.mFragment, false);
            return;
        }
        this.mFragment.mState = 0;
    }

    /* access modifiers changed from: package-private */
    public void detach(@NonNull FragmentManagerViewModel fragmentManagerViewModel) {
        if (FragmentManager.isLoggingEnabled(3)) {
            Log.d(TAG, "movefrom ATTACHED: " + this.mFragment);
        }
        this.mFragment.performDetach();
        boolean z = false;
        this.mDispatcher.dispatchOnFragmentDetached(this.mFragment, false);
        this.mFragment.mState = -1;
        this.mFragment.mHost = null;
        this.mFragment.mParentFragment = null;
        this.mFragment.mFragmentManager = null;
        if (this.mFragment.mRemoving && !this.mFragment.isInBackStack()) {
            z = true;
        }
        if (z || fragmentManagerViewModel.shouldDestroy(this.mFragment)) {
            if (FragmentManager.isLoggingEnabled(3)) {
                Log.d(TAG, "initState called for fragment: " + this.mFragment);
            }
            this.mFragment.initState();
        }
    }
}
