package androidx.fragment.app;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;

public class DialogFragment extends Fragment implements DialogInterface.OnCancelListener, DialogInterface.OnDismissListener {
    private static final String SAVED_BACK_STACK_ID = "android:backStackId";
    private static final String SAVED_CANCELABLE = "android:cancelable";
    private static final String SAVED_DIALOG_STATE_TAG = "android:savedDialogState";
    private static final String SAVED_SHOWS_DIALOG = "android:showsDialog";
    private static final String SAVED_STYLE = "android:style";
    private static final String SAVED_THEME = "android:theme";
    public static final int STYLE_NORMAL = 0;
    public static final int STYLE_NO_FRAME = 2;
    public static final int STYLE_NO_INPUT = 3;
    public static final int STYLE_NO_TITLE = 1;
    int mBackStackId = -1;
    boolean mCancelable = true;
    @Nullable
    Dialog mDialog;
    private Runnable mDismissRunnable = new Runnable() {
        public void run() {
            DialogFragment.this.mOnDismissListener.onDismiss(DialogFragment.this.mDialog);
        }
    };
    boolean mDismissed;
    private Handler mHandler;
    DialogInterface.OnCancelListener mOnCancelListener = new DialogInterface.OnCancelListener() {
        public void onCancel(@Nullable DialogInterface dialogInterface) {
            if (DialogFragment.this.mDialog != null) {
                DialogFragment.this.onCancel(DialogFragment.this.mDialog);
            }
        }
    };
    DialogInterface.OnDismissListener mOnDismissListener = new DialogInterface.OnDismissListener() {
        public void onDismiss(@Nullable DialogInterface dialogInterface) {
            if (DialogFragment.this.mDialog != null) {
                DialogFragment.this.onDismiss(DialogFragment.this.mDialog);
            }
        }
    };
    boolean mShownByMe;
    boolean mShowsDialog = true;
    int mStyle = 0;
    int mTheme = 0;
    boolean mViewDestroyed;

    public void onCancel(@NonNull DialogInterface dialogInterface) {
    }

    public void setStyle(int i, @StyleRes int i2) {
        this.mStyle = i;
        if (this.mStyle == 2 || this.mStyle == 3) {
            this.mTheme = 16973913;
        }
        if (i2 != 0) {
            this.mTheme = i2;
        }
    }

    public void show(@NonNull FragmentManager fragmentManager, @Nullable String str) {
        this.mDismissed = false;
        this.mShownByMe = true;
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        beginTransaction.add((Fragment) this, str);
        beginTransaction.commit();
    }

    public int show(@NonNull FragmentTransaction fragmentTransaction, @Nullable String str) {
        this.mDismissed = false;
        this.mShownByMe = true;
        fragmentTransaction.add((Fragment) this, str);
        this.mViewDestroyed = false;
        this.mBackStackId = fragmentTransaction.commit();
        return this.mBackStackId;
    }

    public void showNow(@NonNull FragmentManager fragmentManager, @Nullable String str) {
        this.mDismissed = false;
        this.mShownByMe = true;
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        beginTransaction.add((Fragment) this, str);
        beginTransaction.commitNow();
    }

    public void dismiss() {
        dismissInternal(false, false);
    }

    public void dismissAllowingStateLoss() {
        dismissInternal(true, false);
    }

    /* access modifiers changed from: package-private */
    public void dismissInternal(boolean z, boolean z2) {
        if (!this.mDismissed) {
            this.mDismissed = true;
            this.mShownByMe = false;
            if (this.mDialog != null) {
                this.mDialog.setOnDismissListener((DialogInterface.OnDismissListener) null);
                this.mDialog.dismiss();
                if (!z2) {
                    if (Looper.myLooper() == this.mHandler.getLooper()) {
                        onDismiss(this.mDialog);
                    } else {
                        this.mHandler.post(this.mDismissRunnable);
                    }
                }
            }
            this.mViewDestroyed = true;
            if (this.mBackStackId >= 0) {
                getParentFragmentManager().popBackStack(this.mBackStackId, 1);
                this.mBackStackId = -1;
                return;
            }
            FragmentTransaction beginTransaction = getParentFragmentManager().beginTransaction();
            beginTransaction.remove(this);
            if (z) {
                beginTransaction.commitAllowingStateLoss();
            } else {
                beginTransaction.commit();
            }
        }
    }

    @Nullable
    public Dialog getDialog() {
        return this.mDialog;
    }

    @NonNull
    public final Dialog requireDialog() {
        Dialog dialog = getDialog();
        if (dialog != null) {
            return dialog;
        }
        throw new IllegalStateException("DialogFragment " + this + " does not have a Dialog.");
    }

    @StyleRes
    public int getTheme() {
        return this.mTheme;
    }

    public void setCancelable(boolean z) {
        this.mCancelable = z;
        if (this.mDialog != null) {
            this.mDialog.setCancelable(z);
        }
    }

    public boolean isCancelable() {
        return this.mCancelable;
    }

    public void setShowsDialog(boolean z) {
        this.mShowsDialog = z;
    }

    public boolean getShowsDialog() {
        return this.mShowsDialog;
    }

    @MainThread
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (!this.mShownByMe) {
            this.mDismissed = false;
        }
    }

    @MainThread
    public void onDetach() {
        super.onDetach();
        if (!this.mShownByMe && !this.mDismissed) {
            this.mDismissed = true;
        }
    }

    @MainThread
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        this.mHandler = new Handler();
        this.mShowsDialog = this.mContainerId == 0;
        if (bundle != null) {
            this.mStyle = bundle.getInt(SAVED_STYLE, 0);
            this.mTheme = bundle.getInt(SAVED_THEME, 0);
            this.mCancelable = bundle.getBoolean(SAVED_CANCELABLE, true);
            this.mShowsDialog = bundle.getBoolean(SAVED_SHOWS_DIALOG, this.mShowsDialog);
            this.mBackStackId = bundle.getInt(SAVED_BACK_STACK_ID, -1);
        }
    }

    @NonNull
    public LayoutInflater onGetLayoutInflater(@Nullable Bundle bundle) {
        if (!this.mShowsDialog) {
            return super.onGetLayoutInflater(bundle);
        }
        this.mDialog = onCreateDialog(bundle);
        if (this.mDialog == null) {
            return (LayoutInflater) this.mHost.getContext().getSystemService("layout_inflater");
        }
        setupDialog(this.mDialog, this.mStyle);
        return (LayoutInflater) this.mDialog.getContext().getSystemService("layout_inflater");
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setupDialog(@NonNull Dialog dialog, int i) {
        switch (i) {
            case 1:
            case 2:
                break;
            case 3:
                dialog.getWindow().addFlags(24);
                break;
            default:
                return;
        }
        dialog.requestWindowFeature(1);
    }

    @MainThread
    @NonNull
    public Dialog onCreateDialog(@Nullable Bundle bundle) {
        return new Dialog(requireContext(), getTheme());
    }

    public void onDismiss(@NonNull DialogInterface dialogInterface) {
        if (!this.mViewDestroyed) {
            dismissInternal(true, true);
        }
    }

    @MainThread
    public void onActivityCreated(@Nullable Bundle bundle) {
        Bundle bundle2;
        super.onActivityCreated(bundle);
        if (this.mShowsDialog) {
            View view = getView();
            if (view != null) {
                if (view.getParent() == null) {
                    this.mDialog.setContentView(view);
                } else {
                    throw new IllegalStateException("DialogFragment can not be attached to a container view");
                }
            }
            FragmentActivity activity = getActivity();
            if (activity != null) {
                this.mDialog.setOwnerActivity(activity);
            }
            this.mDialog.setCancelable(this.mCancelable);
            this.mDialog.setOnCancelListener(this.mOnCancelListener);
            this.mDialog.setOnDismissListener(this.mOnDismissListener);
            if (bundle != null && (bundle2 = bundle.getBundle(SAVED_DIALOG_STATE_TAG)) != null) {
                this.mDialog.onRestoreInstanceState(bundle2);
            }
        }
    }

    @MainThread
    public void onStart() {
        super.onStart();
        if (this.mDialog != null) {
            this.mViewDestroyed = false;
            this.mDialog.show();
        }
    }

    @MainThread
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        Bundle onSaveInstanceState;
        super.onSaveInstanceState(bundle);
        if (!(this.mDialog == null || (onSaveInstanceState = this.mDialog.onSaveInstanceState()) == null)) {
            bundle.putBundle(SAVED_DIALOG_STATE_TAG, onSaveInstanceState);
        }
        if (this.mStyle != 0) {
            bundle.putInt(SAVED_STYLE, this.mStyle);
        }
        if (this.mTheme != 0) {
            bundle.putInt(SAVED_THEME, this.mTheme);
        }
        if (!this.mCancelable) {
            bundle.putBoolean(SAVED_CANCELABLE, this.mCancelable);
        }
        if (!this.mShowsDialog) {
            bundle.putBoolean(SAVED_SHOWS_DIALOG, this.mShowsDialog);
        }
        if (this.mBackStackId != -1) {
            bundle.putInt(SAVED_BACK_STACK_ID, this.mBackStackId);
        }
    }

    @MainThread
    public void onStop() {
        super.onStop();
        if (this.mDialog != null) {
            this.mDialog.hide();
        }
    }

    @MainThread
    public void onDestroyView() {
        super.onDestroyView();
        if (this.mDialog != null) {
            this.mViewDestroyed = true;
            this.mDialog.setOnDismissListener((DialogInterface.OnDismissListener) null);
            this.mDialog.dismiss();
            if (!this.mDismissed) {
                onDismiss(this.mDialog);
            }
            this.mDialog = null;
        }
    }
}