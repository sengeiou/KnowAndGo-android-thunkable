package androidx.fragment.app;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.LogWriter;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import java.io.PrintWriter;
import java.util.ArrayList;
import org.apache.commons.lang3.StringUtils;

final class BackStackRecord extends FragmentTransaction implements FragmentManager.BackStackEntry, FragmentManager.OpGenerator {
    private static final String TAG = "FragmentManager";
    boolean mCommitted;
    int mIndex;
    final FragmentManager mManager;

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("BackStackEntry{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.mIndex >= 0) {
            sb.append(" #");
            sb.append(this.mIndex);
        }
        if (this.mName != null) {
            sb.append(StringUtils.SPACE);
            sb.append(this.mName);
        }
        sb.append("}");
        return sb.toString();
    }

    public void dump(String str, PrintWriter printWriter) {
        dump(str, printWriter, true);
    }

    public void dump(String str, PrintWriter printWriter, boolean z) {
        String str2;
        if (z) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.mName);
            printWriter.print(" mIndex=");
            printWriter.print(this.mIndex);
            printWriter.print(" mCommitted=");
            printWriter.println(this.mCommitted);
            if (this.mTransition != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.mTransition));
            }
            if (!(this.mEnterAnim == 0 && this.mExitAnim == 0)) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.mEnterAnim));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.mExitAnim));
            }
            if (!(this.mPopEnterAnim == 0 && this.mPopExitAnim == 0)) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.mPopEnterAnim));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.mPopExitAnim));
            }
            if (!(this.mBreadCrumbTitleRes == 0 && this.mBreadCrumbTitleText == null)) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.mBreadCrumbTitleRes));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.mBreadCrumbTitleText);
            }
            if (!(this.mBreadCrumbShortTitleRes == 0 && this.mBreadCrumbShortTitleText == null)) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.mBreadCrumbShortTitleRes));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.mBreadCrumbShortTitleText);
            }
        }
        if (!this.mOps.isEmpty()) {
            printWriter.print(str);
            printWriter.println("Operations:");
            int size = this.mOps.size();
            for (int i = 0; i < size; i++) {
                FragmentTransaction.C0297Op op = (FragmentTransaction.C0297Op) this.mOps.get(i);
                switch (op.mCmd) {
                    case 0:
                        str2 = "NULL";
                        break;
                    case 1:
                        str2 = "ADD";
                        break;
                    case 2:
                        str2 = "REPLACE";
                        break;
                    case 3:
                        str2 = "REMOVE";
                        break;
                    case 4:
                        str2 = "HIDE";
                        break;
                    case 5:
                        str2 = "SHOW";
                        break;
                    case 6:
                        str2 = "DETACH";
                        break;
                    case 7:
                        str2 = "ATTACH";
                        break;
                    case 8:
                        str2 = "SET_PRIMARY_NAV";
                        break;
                    case 9:
                        str2 = "UNSET_PRIMARY_NAV";
                        break;
                    case 10:
                        str2 = "OP_SET_MAX_LIFECYCLE";
                        break;
                    default:
                        str2 = "cmd=" + op.mCmd;
                        break;
                }
                printWriter.print(str);
                printWriter.print("  Op #");
                printWriter.print(i);
                printWriter.print(": ");
                printWriter.print(str2);
                printWriter.print(StringUtils.SPACE);
                printWriter.println(op.mFragment);
                if (z) {
                    if (!(op.mEnterAnim == 0 && op.mExitAnim == 0)) {
                        printWriter.print(str);
                        printWriter.print("enterAnim=#");
                        printWriter.print(Integer.toHexString(op.mEnterAnim));
                        printWriter.print(" exitAnim=#");
                        printWriter.println(Integer.toHexString(op.mExitAnim));
                    }
                    if (op.mPopEnterAnim != 0 || op.mPopExitAnim != 0) {
                        printWriter.print(str);
                        printWriter.print("popEnterAnim=#");
                        printWriter.print(Integer.toHexString(op.mPopEnterAnim));
                        printWriter.print(" popExitAnim=#");
                        printWriter.println(Integer.toHexString(op.mPopExitAnim));
                    }
                }
            }
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BackStackRecord(@NonNull FragmentManager fragmentManager) {
        super(fragmentManager.getFragmentFactory(), fragmentManager.mHost != null ? fragmentManager.mHost.getContext().getClassLoader() : null);
        this.mIndex = -1;
        this.mManager = fragmentManager;
    }

    public int getId() {
        return this.mIndex;
    }

    public int getBreadCrumbTitleRes() {
        return this.mBreadCrumbTitleRes;
    }

    public int getBreadCrumbShortTitleRes() {
        return this.mBreadCrumbShortTitleRes;
    }

    @Nullable
    public CharSequence getBreadCrumbTitle() {
        if (this.mBreadCrumbTitleRes != 0) {
            return this.mManager.mHost.getContext().getText(this.mBreadCrumbTitleRes);
        }
        return this.mBreadCrumbTitleText;
    }

    @Nullable
    public CharSequence getBreadCrumbShortTitle() {
        if (this.mBreadCrumbShortTitleRes != 0) {
            return this.mManager.mHost.getContext().getText(this.mBreadCrumbShortTitleRes);
        }
        return this.mBreadCrumbShortTitleText;
    }

    /* access modifiers changed from: package-private */
    public void doAddOp(int i, Fragment fragment, @Nullable String str, int i2) {
        super.doAddOp(i, fragment, str, i2);
        fragment.mFragmentManager = this.mManager;
    }

    @NonNull
    public FragmentTransaction remove(@NonNull Fragment fragment) {
        if (fragment.mFragmentManager == null || fragment.mFragmentManager == this.mManager) {
            return super.remove(fragment);
        }
        throw new IllegalStateException("Cannot remove Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    @NonNull
    public FragmentTransaction hide(@NonNull Fragment fragment) {
        if (fragment.mFragmentManager == null || fragment.mFragmentManager == this.mManager) {
            return super.hide(fragment);
        }
        throw new IllegalStateException("Cannot hide Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    @NonNull
    public FragmentTransaction show(@NonNull Fragment fragment) {
        if (fragment.mFragmentManager == null || fragment.mFragmentManager == this.mManager) {
            return super.show(fragment);
        }
        throw new IllegalStateException("Cannot show Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    @NonNull
    public FragmentTransaction detach(@NonNull Fragment fragment) {
        if (fragment.mFragmentManager == null || fragment.mFragmentManager == this.mManager) {
            return super.detach(fragment);
        }
        throw new IllegalStateException("Cannot detach Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    @NonNull
    public FragmentTransaction setPrimaryNavigationFragment(@Nullable Fragment fragment) {
        if (fragment == null || fragment.mFragmentManager == null || fragment.mFragmentManager == this.mManager) {
            return super.setPrimaryNavigationFragment(fragment);
        }
        throw new IllegalStateException("Cannot setPrimaryNavigation for Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    @NonNull
    public FragmentTransaction setMaxLifecycle(@NonNull Fragment fragment, @NonNull Lifecycle.State state) {
        if (fragment.mFragmentManager != this.mManager) {
            throw new IllegalArgumentException("Cannot setMaxLifecycle for Fragment not attached to FragmentManager " + this.mManager);
        } else if (state.isAtLeast(Lifecycle.State.CREATED)) {
            return super.setMaxLifecycle(fragment, state);
        } else {
            throw new IllegalArgumentException("Cannot set maximum Lifecycle below " + Lifecycle.State.CREATED);
        }
    }

    /* access modifiers changed from: package-private */
    public void bumpBackStackNesting(int i) {
        if (this.mAddToBackStack) {
            if (FragmentManager.isLoggingEnabled(2)) {
                Log.v(TAG, "Bump nesting in " + this + " by " + i);
            }
            int size = this.mOps.size();
            for (int i2 = 0; i2 < size; i2++) {
                FragmentTransaction.C0297Op op = (FragmentTransaction.C0297Op) this.mOps.get(i2);
                if (op.mFragment != null) {
                    op.mFragment.mBackStackNesting += i;
                    if (FragmentManager.isLoggingEnabled(2)) {
                        Log.v(TAG, "Bump nesting of " + op.mFragment + " to " + op.mFragment.mBackStackNesting);
                    }
                }
            }
        }
    }

    public void runOnCommitRunnables() {
        if (this.mCommitRunnables != null) {
            for (int i = 0; i < this.mCommitRunnables.size(); i++) {
                ((Runnable) this.mCommitRunnables.get(i)).run();
            }
            this.mCommitRunnables = null;
        }
    }

    public int commit() {
        return commitInternal(false);
    }

    public int commitAllowingStateLoss() {
        return commitInternal(true);
    }

    public void commitNow() {
        disallowAddToBackStack();
        this.mManager.execSingleAction(this, false);
    }

    public void commitNowAllowingStateLoss() {
        disallowAddToBackStack();
        this.mManager.execSingleAction(this, true);
    }

    /* access modifiers changed from: package-private */
    public int commitInternal(boolean z) {
        if (!this.mCommitted) {
            if (FragmentManager.isLoggingEnabled(2)) {
                Log.v(TAG, "Commit: " + this);
                PrintWriter printWriter = new PrintWriter(new LogWriter(TAG));
                dump("  ", printWriter);
                printWriter.close();
            }
            this.mCommitted = true;
            if (this.mAddToBackStack) {
                this.mIndex = this.mManager.allocBackStackIndex();
            } else {
                this.mIndex = -1;
            }
            this.mManager.enqueueAction(this, z);
            return this.mIndex;
        }
        throw new IllegalStateException("commit already called");
    }

    public boolean generateOps(@NonNull ArrayList<BackStackRecord> arrayList, @NonNull ArrayList<Boolean> arrayList2) {
        if (FragmentManager.isLoggingEnabled(2)) {
            Log.v(TAG, "Run: " + this);
        }
        arrayList.add(this);
        arrayList2.add(false);
        if (!this.mAddToBackStack) {
            return true;
        }
        this.mManager.addBackStackState(this);
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean interactsWith(int i) {
        int size = this.mOps.size();
        for (int i2 = 0; i2 < size; i2++) {
            FragmentTransaction.C0297Op op = (FragmentTransaction.C0297Op) this.mOps.get(i2);
            int i3 = op.mFragment != null ? op.mFragment.mContainerId : 0;
            if (i3 != 0 && i3 == i) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean interactsWith(ArrayList<BackStackRecord> arrayList, int i, int i2) {
        if (i2 == i) {
            return false;
        }
        int size = this.mOps.size();
        int i3 = -1;
        for (int i4 = 0; i4 < size; i4++) {
            FragmentTransaction.C0297Op op = (FragmentTransaction.C0297Op) this.mOps.get(i4);
            int i5 = op.mFragment != null ? op.mFragment.mContainerId : 0;
            if (!(i5 == 0 || i5 == i3)) {
                for (int i6 = i; i6 < i2; i6++) {
                    BackStackRecord backStackRecord = arrayList.get(i6);
                    int size2 = backStackRecord.mOps.size();
                    for (int i7 = 0; i7 < size2; i7++) {
                        FragmentTransaction.C0297Op op2 = (FragmentTransaction.C0297Op) backStackRecord.mOps.get(i7);
                        if ((op2.mFragment != null ? op2.mFragment.mContainerId : 0) == i5) {
                            return true;
                        }
                    }
                }
                i3 = i5;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void executeOps() {
        int size = this.mOps.size();
        for (int i = 0; i < size; i++) {
            FragmentTransaction.C0297Op op = (FragmentTransaction.C0297Op) this.mOps.get(i);
            Fragment fragment = op.mFragment;
            if (fragment != null) {
                fragment.setNextTransition(this.mTransition);
            }
            int i2 = op.mCmd;
            if (i2 != 1) {
                switch (i2) {
                    case 3:
                        fragment.setNextAnim(op.mExitAnim);
                        this.mManager.removeFragment(fragment);
                        break;
                    case 4:
                        fragment.setNextAnim(op.mExitAnim);
                        this.mManager.hideFragment(fragment);
                        break;
                    case 5:
                        fragment.setNextAnim(op.mEnterAnim);
                        this.mManager.setExitAnimationOrder(fragment, false);
                        this.mManager.showFragment(fragment);
                        break;
                    case 6:
                        fragment.setNextAnim(op.mExitAnim);
                        this.mManager.detachFragment(fragment);
                        break;
                    case 7:
                        fragment.setNextAnim(op.mEnterAnim);
                        this.mManager.setExitAnimationOrder(fragment, false);
                        this.mManager.attachFragment(fragment);
                        break;
                    case 8:
                        this.mManager.setPrimaryNavigationFragment(fragment);
                        break;
                    case 9:
                        this.mManager.setPrimaryNavigationFragment((Fragment) null);
                        break;
                    case 10:
                        this.mManager.setMaxLifecycle(fragment, op.mCurrentMaxState);
                        break;
                    default:
                        throw new IllegalArgumentException("Unknown cmd: " + op.mCmd);
                }
            } else {
                fragment.setNextAnim(op.mEnterAnim);
                this.mManager.setExitAnimationOrder(fragment, false);
                this.mManager.addFragment(fragment);
            }
            if (!(this.mReorderingAllowed || op.mCmd == 1 || fragment == null)) {
                this.mManager.moveFragmentToExpectedState(fragment);
            }
        }
        if (!this.mReorderingAllowed) {
            this.mManager.moveToState(this.mManager.mCurState, true);
        }
    }

    /* access modifiers changed from: package-private */
    public void executePopOps(boolean z) {
        for (int size = this.mOps.size() - 1; size >= 0; size--) {
            FragmentTransaction.C0297Op op = (FragmentTransaction.C0297Op) this.mOps.get(size);
            Fragment fragment = op.mFragment;
            if (fragment != null) {
                fragment.setNextTransition(FragmentManager.reverseTransit(this.mTransition));
            }
            int i = op.mCmd;
            if (i != 1) {
                switch (i) {
                    case 3:
                        fragment.setNextAnim(op.mPopEnterAnim);
                        this.mManager.addFragment(fragment);
                        break;
                    case 4:
                        fragment.setNextAnim(op.mPopEnterAnim);
                        this.mManager.showFragment(fragment);
                        break;
                    case 5:
                        fragment.setNextAnim(op.mPopExitAnim);
                        this.mManager.setExitAnimationOrder(fragment, true);
                        this.mManager.hideFragment(fragment);
                        break;
                    case 6:
                        fragment.setNextAnim(op.mPopEnterAnim);
                        this.mManager.attachFragment(fragment);
                        break;
                    case 7:
                        fragment.setNextAnim(op.mPopExitAnim);
                        this.mManager.setExitAnimationOrder(fragment, true);
                        this.mManager.detachFragment(fragment);
                        break;
                    case 8:
                        this.mManager.setPrimaryNavigationFragment((Fragment) null);
                        break;
                    case 9:
                        this.mManager.setPrimaryNavigationFragment(fragment);
                        break;
                    case 10:
                        this.mManager.setMaxLifecycle(fragment, op.mOldMaxState);
                        break;
                    default:
                        throw new IllegalArgumentException("Unknown cmd: " + op.mCmd);
                }
            } else {
                fragment.setNextAnim(op.mPopExitAnim);
                this.mManager.setExitAnimationOrder(fragment, true);
                this.mManager.removeFragment(fragment);
            }
            if (!(this.mReorderingAllowed || op.mCmd == 3 || fragment == null)) {
                this.mManager.moveFragmentToExpectedState(fragment);
            }
        }
        if (!this.mReorderingAllowed && z) {
            this.mManager.moveToState(this.mManager.mCurState, true);
        }
    }

    /* access modifiers changed from: package-private */
    public Fragment expandOps(ArrayList<Fragment> arrayList, Fragment fragment) {
        Fragment fragment2 = fragment;
        int i = 0;
        while (i < this.mOps.size()) {
            FragmentTransaction.C0297Op op = (FragmentTransaction.C0297Op) this.mOps.get(i);
            switch (op.mCmd) {
                case 1:
                case 7:
                    arrayList.add(op.mFragment);
                    break;
                case 2:
                    Fragment fragment3 = op.mFragment;
                    int i2 = fragment3.mContainerId;
                    Fragment fragment4 = fragment2;
                    int i3 = i;
                    boolean z = false;
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        Fragment fragment5 = arrayList.get(size);
                        if (fragment5.mContainerId == i2) {
                            if (fragment5 == fragment3) {
                                z = true;
                            } else {
                                if (fragment5 == fragment4) {
                                    this.mOps.add(i3, new FragmentTransaction.C0297Op(9, fragment5));
                                    i3++;
                                    fragment4 = null;
                                }
                                FragmentTransaction.C0297Op op2 = new FragmentTransaction.C0297Op(3, fragment5);
                                op2.mEnterAnim = op.mEnterAnim;
                                op2.mPopEnterAnim = op.mPopEnterAnim;
                                op2.mExitAnim = op.mExitAnim;
                                op2.mPopExitAnim = op.mPopExitAnim;
                                this.mOps.add(i3, op2);
                                arrayList.remove(fragment5);
                                i3++;
                            }
                        }
                    }
                    if (z) {
                        this.mOps.remove(i3);
                        i3--;
                    } else {
                        op.mCmd = 1;
                        arrayList.add(fragment3);
                    }
                    i = i3;
                    fragment2 = fragment4;
                    break;
                case 3:
                case 6:
                    arrayList.remove(op.mFragment);
                    if (op.mFragment != fragment2) {
                        break;
                    } else {
                        this.mOps.add(i, new FragmentTransaction.C0297Op(9, op.mFragment));
                        i++;
                        fragment2 = null;
                        break;
                    }
                case 8:
                    this.mOps.add(i, new FragmentTransaction.C0297Op(9, fragment2));
                    i++;
                    fragment2 = op.mFragment;
                    break;
            }
            i++;
        }
        return fragment2;
    }

    /* access modifiers changed from: package-private */
    public Fragment trackAddedFragmentsInPop(ArrayList<Fragment> arrayList, Fragment fragment) {
        for (int size = this.mOps.size() - 1; size >= 0; size--) {
            FragmentTransaction.C0297Op op = (FragmentTransaction.C0297Op) this.mOps.get(size);
            int i = op.mCmd;
            if (i != 1) {
                if (i != 3) {
                    switch (i) {
                        case 6:
                            break;
                        case 7:
                            break;
                        case 8:
                            fragment = null;
                            break;
                        case 9:
                            fragment = op.mFragment;
                            break;
                        case 10:
                            op.mCurrentMaxState = op.mOldMaxState;
                            break;
                    }
                }
                arrayList.add(op.mFragment);
            }
            arrayList.remove(op.mFragment);
        }
        return fragment;
    }

    /* access modifiers changed from: package-private */
    public boolean isPostponed() {
        for (int i = 0; i < this.mOps.size(); i++) {
            if (isFragmentPostponed((FragmentTransaction.C0297Op) this.mOps.get(i))) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void setOnStartPostponedListener(Fragment.OnStartEnterTransitionListener onStartEnterTransitionListener) {
        for (int i = 0; i < this.mOps.size(); i++) {
            FragmentTransaction.C0297Op op = (FragmentTransaction.C0297Op) this.mOps.get(i);
            if (isFragmentPostponed(op)) {
                op.mFragment.setOnStartEnterTransitionListener(onStartEnterTransitionListener);
            }
        }
    }

    private static boolean isFragmentPostponed(FragmentTransaction.C0297Op op) {
        Fragment fragment = op.mFragment;
        return fragment != null && fragment.mAdded && fragment.mView != null && !fragment.mDetached && !fragment.mHidden && fragment.isPostponed();
    }

    @Nullable
    public String getName() {
        return this.mName;
    }

    public boolean isEmpty() {
        return this.mOps.isEmpty();
    }
}
